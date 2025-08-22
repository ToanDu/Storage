package controllers

import (
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
		if err := models.CreateOrder(db, txnRef, amount*100, orderInfo); err != nil {
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
			"vnp_CreateDate": time.Now().Format("20060102150405"),
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

// GET /vnpay/return
func ReturnPage(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		txnRef := c.Query("vnp_TxnRef")
		respCode := c.Query("vnp_ResponseCode")

		status := "failed"
		if respCode == "00" {
			status = "success"
		}

		// Update DB
		_ = models.UpdateOrderStatus(db, txnRef, status)

		// Render return.html with dynamic values
		c.HTML(http.StatusOK, "return.html", gin.H{
			"TxnRef": txnRef,
			"Status": status,
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
