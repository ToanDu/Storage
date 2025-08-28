package controllers

import (
	"bytes"
	"context"
	"crypto/hmac"
	"crypto/sha512"
	"encoding/hex"
	"encoding/json"
	"io"
	"log"
	"net/http"
	"net/url"
	"storage-main/models"
	"storage-main/utils"
	"strconv"
	"strings"
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
	return func(c *gin.Context) { // Lấy tham số từ query
		amountStr := "10000"
		orderInfo := "order_info"

		// Validate đầu vào
		if strings.TrimSpace(amountStr) == "" || strings.TrimSpace(orderInfo) == "" {
			c.JSON(http.StatusBadRequest, gin.H{
				"error": "amount and order_info are required (query params)",
			})
			return
		}

		amountVND, err := strconv.ParseInt(amountStr, 10, 64)
		if err != nil || amountVND <= 0 {
			c.JSON(http.StatusBadRequest, gin.H{"error": "amount must be a positive integer (VND)"})
			return
		}

		// Tạo order trên DB
		tnxRef := uuid.NewString()
		_, err = db.Exec(context.Background(),
			"INSERT INTO orders (id, txn_ref, amount, order_info, status) VALUES ($1, $2, $3, $4, 'pending')",
			uuid.New(), tnxRef, amountVND*100, orderInfo)
		if err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": "Cannot save orders"})
			return
		}

		params := map[string]string{
			"vnp_Version":    "2.1.0",
			"vnp_Command":    "pay",
			"vnp_TmnCode":    utils.VnpTmnCode,
			"vnp_Locale":     "vn",
			"vnp_CurrCode":   "VND",
			"vnp_TxnRef":     tnxRef,
			"vnp_OrderInfo":  orderInfo,
			"vnp_OrderType":  "other",
			"vnp_Amount":     strconv.FormatInt(amountVND*100, 10), // x100 theo chuẩn VNPay
			"vnp_ReturnUrl":  utils.VnpReturnURL,
			"vnp_IpAddr":     utils.GetClientIP(c.Request),
			"vnp_CreateDate": time.Now().Format("20060102150405"),
			"vnp_ExpireDate": time.Now().Add(15 * time.Minute).Format("20060102150405"),
		}

		// Ký HMAC-SHA512
		secureHash := utils.CalculateChecksum(params)
		// Ghép query để redirect
		q := url.Values{}
		for k, v := range params {
			q.Add(k, v)
		}
		q.Add("vnp_SecureHash", secureHash)

		paymentURL := utils.VnpURL + "?" + q.Encode()

		// c.JSON(http.StatusOK, gin.H{
		// 	"payment_url": paymentURL,
		// 	"txn_ref":     tnxRef,
		// })
		c.Redirect(http.StatusFound, paymentURL)
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
func Query_request(dbPool *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		var req struct {
			TransactionCode string `json:"transaction_code" binding:"required"`
			OrderInfo       string `json:"order_info"`
		}
		if err := c.BindJSON(&req); err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": "Invalid request"})
			log.Printf("Error invalid request: %v", err)
			return
		}

		// Lấy thời điểm tạo đơn (giả định chính là thời điểm vnp_CreateDate khi pay)
		// Khuyến nghị: lưu riêng "vnp_create_date" khi tạo thanh toán để đảm bảo trùng 100% với lệnh pay
		var createdTime time.Time
		if err := dbPool.QueryRow(context.Background(),
			"SELECT created_at FROM orders WHERE txn_ref = $1", req.TransactionCode).Scan(&createdTime); err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": "Transaction not found"})
			log.Printf("Error querying txn_ref: %v", err)
			return
		}

		// Chuẩn bị payload querydr
		requestID := uuid.NewString()[:12]                      // đủ tính duy nhất trong ngày, có thể thay đổi theo yêu cầu của bạn
		transactionDate := createdTime.Format("20060102150405") // phải là yyyyMMddHHmmss
		createDate := time.Now().Format("20060102150405")
		ip := utils.GetClientIP(c.Request)
		orderInfo := strings.TrimSpace(req.OrderInfo)
		if orderInfo == "" {
			orderInfo = "Query transaction result"
		}

		payload := map[string]string{
			"vnp_RequestId":       requestID,
			"vnp_Version":         "2.1.0",
			"vnp_Command":         "querydr",
			"vnp_TmnCode":         utils.VnpTmnCode,
			"vnp_TxnRef":          req.TransactionCode,
			"vnp_TransactionDate": transactionDate,
			"vnp_CreateDate":      createDate,
			"vnp_IpAddr":          ip,
			"vnp_OrderInfo":       orderInfo,
		}

		// Ký đúng quy tắc của querydr (KHÔNG sort key, KHÔNG URL-encode, dùng dấu "|")
		payload["vnp_SecureHash"] = signQueryDR(
			requestID, "2.1.0", "querydr", utils.VnpTmnCode, req.TransactionCode, transactionDate, createDate, ip, orderInfo,
		)

		// Gọi VNPay
		b, _ := json.Marshal(payload)
		resp, err := http.Post(utils.VnpApiURL, "application/json", bytes.NewBuffer(b))
		if err != nil {
			c.JSON(http.StatusBadGateway, gin.H{"error": "Failed to call VNPay API"})
			return
		}
		defer resp.Body.Close()

		body, err := io.ReadAll(resp.Body)
		if err != nil {
			c.JSON(http.StatusBadGateway, gin.H{"error": "Failed to read response"})
			return
		}

		var vnpResp map[string]any
		if err := json.Unmarshal(body, &vnpResp); err != nil {
			c.JSON(http.StatusBadGateway, gin.H{"error": "Failed to parse response"})
			return
		}

		// Đánh giá nhanh kết quả
		isAPISuccess := vnpResp["vnp_ResponseCode"] == "00"
		isTxnSuccess := vnpResp["vnp_TransactionStatus"] == "00"

		c.JSON(http.StatusOK, gin.H{
			"request":      payload,
			"vnp_response": vnpResp,
			"isSuccess":    isAPISuccess && isTxnSuccess,
			"http_status":  resp.StatusCode,
		})
	}
}

func signQueryDR(
	requestId, version, command, tmnCode, txnRef, transactionDate, createDate, ipAddr, orderInfo string,
) string {
	signData := strings.Join([]string{
		requestId,
		version,
		command,
		tmnCode,
		txnRef,
		transactionDate,
		createDate,
		ipAddr,
		orderInfo,
	}, "|")

	mac := hmac.New(sha512.New, []byte(utils.VnpHashSecret))
	mac.Write([]byte(signData))
	return strings.ToUpper(hex.EncodeToString(mac.Sum(nil)))
}
