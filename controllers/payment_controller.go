package controllers

import (
	"log"
	"net/http"
	"net/url"
	"storage-main/models"
	"storage-main/utils"
	"strconv"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/google/uuid"
	"github.com/jackc/pgx/v5/pgxpool"
)

// GET /
func PaymentPage(c *gin.Context) {
	c.HTML(http.StatusOK, "index.html", nil)
}

// POST /createorders
func CreateOrders(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		amountStr := c.PostForm("amount")
		orderInfo := c.PostForm("info")

		amount, err := strconv.ParseInt(amountStr, 10, 64)
		if err != nil || amount <= 0 {
			c.HTML(http.StatusBadRequest, "index.html", gin.H{
				"Error": "Số tiền không hợp lệ",
			})
			return
		}

		txnRef := uuid.NewString()
		txnDate := time.Now().Format("20060102150405") // must be stored for later QueryDR

		if err := models.CreateOrder(db, txnRef, amount*100, orderInfo, txnDate); err != nil {
			c.HTML(http.StatusInternalServerError, "index.html", gin.H{
				"Error": "Không thể lưu đơn hàng",
			})
			return
		}

		// VNPAY params
		params := map[string]string{
			"vnp_Version":    "2.1.0",
			"vnp_Command":    "pay",
			"vnp_TmnCode":    utils.VnpTmnCode,
			"vnp_Locale":     "vn",
			"vnp_CurrCode":   "VND",
			"vnp_TxnRef":     txnRef,
			"vnp_OrderInfo":  orderInfo,
			"vnp_OrderType":  "other",
			"vnp_Amount":     strconv.FormatInt(amount*100, 10),
			"vnp_ReturnUrl":  utils.VnpReturnURL,
			"vnp_IpAddr":     utils.GetClientIP(c.Request),
			"vnp_CreateDate": txnDate,
			"vnp_ExpireDate": time.Now().Add(15 * time.Minute).Format("20060102150405"),
		}

		secureHash := utils.CalculateChecksum(params)
		query := url.Values{}
		for k, v := range params {
			query.Add(k, v)
		}
		query.Add("vnp_SecureHash", secureHash)

		paymentURL := utils.VnpURL + "?" + query.Encode()
		c.Redirect(http.StatusSeeOther, paymentURL)
	}
}

// GET /vnpay/return (after payment redirect)
func ReturnPage(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		txnRef := c.Query("vnp_TxnRef")
		respCode := c.Query("vnp_ResponseCode")
		bankCode := c.Query("vnp_BankCode")
		amount := c.Query("vnp_Amount")
		payDate := c.Query("vnp_PayDate")

		// Default fail
		status := "failed"
		statusText := "❌ Giao dịch thất bại"
		if respCode == "00" {
			status = "success"
			statusText = "🎉 Giao dịch thành công"
		}

		// Update DB
		_ = models.UpdateOrderStatus(db, txnRef, status)

		// Render return.html with clear fields
		c.HTML(http.StatusOK, "return.html", gin.H{
			"TxnRef":       txnRef,
			"ResponseCode": respCode,
			"Status":       status,     // success | failed
			"StatusText":   statusText, // pretty text
			"Amount":       amount,
			"BankCode":     bankCode,
			"PayDate":      payDate,
		})
	}
}

// POST /vnpay/ipn
func HandleIPN(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		if err := c.Request.ParseForm(); err != nil {
			c.String(http.StatusBadRequest, "Lỗi parse form")
			return
		}

		txnRef := c.Request.Form.Get("vnp_TxnRef")
		respCode := c.Request.Form.Get("vnp_ResponseCode")

		status := "failed"
		if respCode == "00" {
			status = "success"
		}

		if err := models.UpdateOrderStatus(db, txnRef, status); err != nil {
			c.String(http.StatusInternalServerError, "99|Update DB failed")
			return
		}
		c.String(http.StatusOK, "00|OK")
	}
}

// GET /vnpay/query?txnRef=xxxx
func QueryTransaction(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		txnRef := c.Query("txnRef")
		if txnRef == "" {
			c.HTML(http.StatusBadRequest, "return.html", gin.H{
				"Status":       "failed",
				"StatusText":   "❌ Thiếu mã giao dịch",
				"TxnRef":       "",
				"ResponseCode": "99",
			})
			return
		}

		// 🔎 lookup order in DB
		order, err := models.GetOrderByTxnRef(db, txnRef)
		if err != nil {
			c.HTML(http.StatusNotFound, "return.html", gin.H{
				"Status":       "failed",
				"StatusText":   "❌ Không tìm thấy đơn hàng",
				"TxnRef":       txnRef,
				"ResponseCode": "01",
			})
			return
		}

		ip := utils.GetServerIP()
		params := utils.BuildQueryDRParams(order.TxnRef, order.TxnDate, order.OrderInfo, ip)

		resp, _, err := utils.CallQueryDR(params)
		if err != nil {
			log.Printf("❌ QueryDR error: %v", err)
			// fallback to DB order status if VNPay query fails
			c.HTML(http.StatusOK, "return.html", gin.H{
				"TxnRef":       order.TxnRef,
				"ResponseCode": "99",
				"Status":       order.Status,
				"StatusText":   "⚠️ Không thể truy vấn VNPay, hiển thị trạng thái lưu trong hệ thống",
				"Amount":       strconv.FormatInt(order.Amount, 10),
				"BankCode":     "N/A",
				"PayDate":      order.TxnDate,
			})
			return
		}

		// ⚠️ If VNPay returns duplicate request code
		if resp.ResponseCode == "94" {
			log.Printf("⚠️ VNPay duplicate query, using cached DB result")
			c.HTML(http.StatusOK, "return.html", gin.H{
				"TxnRef":       order.TxnRef,
				"ResponseCode": "94",
				"Status":       order.Status,
				"StatusText":   "⚠️ Giao dịch đã được truy vấn gần đây (hiển thị trạng thái hệ thống)",
				"Amount":       strconv.FormatInt(order.Amount, 10),
				"BankCode":     "N/A",
				"PayDate":      order.TxnDate,
			})
			return
		}

		// ✅ Normal case: VNPay gave valid response
		status := "failed"
		statusText := "❌ Giao dịch thất bại"
		if resp.TransactionStatus == "00" && resp.ResponseCode == "00" {
			status = "success"
			statusText = "🎉 Giao dịch thành công"
		}

		c.HTML(http.StatusOK, "return.html", gin.H{
			"TxnRef":       resp.TxnRef,
			"ResponseCode": resp.ResponseCode,
			"Status":       status,
			"StatusText":   statusText,
			"Amount":       resp.Amount,
			"BankCode":     resp.BankCode,
			"PayDate":      resp.PayDate,
		})
	}
}
