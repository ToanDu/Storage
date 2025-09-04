package controllers

import (
	"context"
	"crypto/hmac"
	"crypto/sha512"
	"encoding/hex"
	"log"
	"net/http"
	"net/url"
	"sort"
	"storage-main/models"
	"storage-main/utils"
	"strconv"
	"strings"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/google/uuid"
	"github.com/jackc/pgx/v5/pgxpool"
) // GET /
func PaymentPage(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		// Fetch services from database
		rows, err := db.Query(context.Background(), "SELECT id, txn_ref, amount, description, duration FROM services ORDER BY amount")
		if err != nil {
			log.Printf("Error fetching services: %v", err)
			c.HTML(http.StatusOK, "index.html", gin.H{
				"Error": "Không thể tải danh sách dịch vụ",
			})
			return
		}
		defer rows.Close()

		var services []gin.H
		for rows.Next() {
			var id int
			var txnRef string
			var amount int64
			var description, duration string

			if err := rows.Scan(&id, &txnRef, &amount, &description, &duration); err != nil {
				log.Printf("Error scanning service row: %v", err)
				continue
			}

			services = append(services, gin.H{
				"ID":          id,
				"TxnRef":      txnRef,
				"Amount":      amount,
				"Description": description,
				"Duration":    duration,
				"AmountStr":   strconv.FormatInt(amount, 10),
			})
		}

		c.HTML(http.StatusOK, "index.html", gin.H{
			"Services": services,
		})
	}
}

// POST /createorders
func CreateOrders(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		// Get parameters from form post data
		amountStr := c.Query("amount")
		orderInfo := c.Query("txn_ref") // Now using txn_ref as orderInfo

		// Validate input
		if strings.TrimSpace(amountStr) == "" || strings.TrimSpace(orderInfo) == "" {
			c.JSON(http.StatusBadRequest, gin.H{
				"error": "amount and txn_ref are required",
			})
			return
		}

		amountVND, err := strconv.ParseInt(amountStr, 10, 64)
		if err != nil || amountVND <= 0 {
			c.JSON(http.StatusBadRequest, gin.H{"error": "amount must be a positive integer (VND)"})
			return
		}
		txnDate := time.Now().Format("20060102150405") // must be stored for later QueryDR

		// Tạo order trên DB
		tnxRef := uuid.NewString()
		models.CreateOrder(db, tnxRef, amountVND, orderInfo, txnDate)

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
		if v, err := strconv.ParseInt(amount, 10, 64); err == nil {
			amount = strconv.FormatInt(v/100, 10)
		}

		// Return chỉ để hiển thị — KHÔNG cập nhật DB. Trạng thái cuối lấy theo IPN.
		// Default fail
		status := "failed"
		statusText := "❌ Giao dịch thất bại"
		if respCode == "00" {
			status = "success"
			statusText = "🎉 Giao dịch thành công"
		}

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
// func HandleIPN(db *pgxpool.Pool) gin.HandlerFunc {
// 	return func(c *gin.Context) {

// 		txnRef := c.Query("vnp_TxnRef")
// 		respCode := c.Query("vnp_ResponseCode")

// 		status := "failed"
// 		if respCode == "00" {
// 			status = "success"
// 		}

//			if err := models.UpdateOrderStatus(db, txnRef, status); err != nil {
//				c.String(http.StatusInternalServerError, "99|Update DB failed")
//				return
//			}
//			c.String(http.StatusOK, "00|OK")
//		}
//	}

// GET /vnpay/ipn
func HandleIPN(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		q := c.Request.URL.Query()

		// 1) Verify signature
		secureHash := c.Query("vnp_SecureHash")
		if secureHash == "" {
			c.JSON(http.StatusOK, gin.H{"RspCode": "97", "Message": "Invalid signature"})
			return
		}
		// build rawData from all keys except vnp_SecureHash (sorted ASC, url-encoded)
		keys := make([]string, 0, len(q))
		for k := range q {
			if strings.EqualFold(k, "vnp_SecureHash") {
				continue
			}
			keys = append(keys, k)
		}
		sort.Strings(keys)
		var b strings.Builder
		for i, k := range keys {
			if i > 0 {
				b.WriteByte('&')
			}
			b.WriteString(url.QueryEscape(k))
			b.WriteByte('=')
			b.WriteString(url.QueryEscape(q.Get(k)))
		}
		raw := b.String()

		mac := hmac.New(sha512.New, []byte(utils.VnpHashSecret))
		mac.Write([]byte(raw))
		calculated := strings.ToUpper(hex.EncodeToString(mac.Sum(nil)))
		if !strings.EqualFold(calculated, secureHash) {
			c.JSON(http.StatusOK, gin.H{"RspCode": "97", "Message": "Invalid signature"})
			return
		}

		// 2) Lấy trường bắt buộc
		txnRef := c.Query("vnp_TxnRef")
		amountStr := c.Query("vnp_Amount") // *100 so với VND gốc
		respCode := c.Query("vnp_ResponseCode")
		txnStatus := c.Query("vnp_TransactionStatus") // có thể trống

		if txnRef == "" {
			c.JSON(http.StatusOK, gin.H{"RspCode": "01", "Message": "Order Not Found"})
			return
		}
		if amountStr == "" {
			c.JSON(http.StatusOK, gin.H{"RspCode": "04", "Message": "Invalid amount"})
			return
		}

		// 3) Tìm order
		order, err := models.GetOrderByTxnRef(db, txnRef)
		if err != nil {
			c.JSON(http.StatusOK, gin.H{"RspCode": "01", "Message": "Order Not Found"})
			return
		}

		// 4) Đối chiếu số tiền (DB lưu VND chuẩn; VNPay gửi *100)
		if amountStr != strconv.FormatInt(order.Amount*100, 10) {
			c.JSON(http.StatusOK, gin.H{"RspCode": "04", "Message": "Invalid amount"})
			return
		}

		// 5) Idempotent – đơn đã chốt thì không chốt lại
		if order.Status == "success" || order.Status == "failed" {
			c.JSON(http.StatusOK, gin.H{"RspCode": "02", "Message": "Order already confirmed"})
			return
		}

		// 6) Xác định trạng thái lưu DB
		paidOK := (respCode == "00") && (txnStatus == "" || txnStatus == "00")
		newStatus := "failed"
		if paidOK {
			newStatus = "success"
		}

		// 7) Cập nhật DB
		if err := models.UpdateOrderStatus(db, txnRef, newStatus); err != nil {
			// ví dụ update lỗi kết nối, deadlock, v.v.
			c.JSON(http.StatusOK, gin.H{"RspCode": "99", "Message": "DB error"})
			return
		}

		// 8) Phản hồi đúng đặc tả IPN (luôn 00 nếu đã xử lý xong)
		c.JSON(http.StatusOK, gin.H{"RspCode": "00", "Message": "Confirm Success"})
	}
}

// POST /query_transaction
func Query_request(dbPool *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		var req struct {
			TransactionCode string `form:"transaction_code" json:"transaction_code" binding:"required"`
			OrderInfo       string `form:"order_info" json:"order_info"`
		}

		// Try to bind from form data first, then from JSON if that fails
		if err := c.ShouldBind(&req); err != nil {
			if err2 := c.ShouldBindJSON(&req); err2 != nil {
				c.HTML(http.StatusBadRequest, "query_result.html", gin.H{
					"StatusClass":   "failed",
					"StatusMessage": "❌ Yêu cầu không hợp lệ",
					"TxnRef":        "",
					"ResponseCode":  "97",
				})
				log.Printf("Error invalid request: %v", err)
				return
			}
		}

		// Lấy thông tin giao dịch từ database
		var createdTime time.Time
		var orderAmount int64
		var orderStatus, orderInfo string

		err := dbPool.QueryRow(context.Background(),
			"SELECT created_at, amount, status, order_info FROM orders WHERE txn_ref = $1",
			req.TransactionCode).Scan(&createdTime, &orderAmount, &orderStatus, &orderInfo)

		if err != nil {
			c.HTML(http.StatusNotFound, "query_result.html", gin.H{
				"StatusClass":   "failed",
				"StatusMessage": "❌ Không tìm thấy giao dịch",
				"TxnRef":        req.TransactionCode,
				"ResponseCode":  "01",
				"QueryTime":     time.Now().Format("02.01.2006 15:04:05"),
			})
			log.Printf("Error querying txn_ref: %v", err)
			return
		}

		// Prepare fields for query
		transactionDate := createdTime.Format("20060102150405") // original payment date (vnp_CreateDate)
		queryTime := time.Now()
		ip := utils.GetClientIP(c.Request)

		if strings.TrimSpace(req.OrderInfo) != "" {
			orderInfo = strings.TrimSpace(req.OrderInfo)
		} else if orderInfo == "" {
			orderInfo = "Query transaction result"
		}

		// Build signed payload using shared helper (ensures proper RequestId and signature)
		payload := utils.BuildQueryDRParams(req.TransactionCode, transactionDate, orderInfo, ip)

		// Call VNPay via shared helper
		vnpResp, statusCode, err := utils.CallQueryDR(payload)
		if err != nil {
			c.HTML(http.StatusBadGateway, "query_result.html", gin.H{
				"StatusClass":       "failed",
				"StatusMessage":     "❌ Không thể kết nối đến VNPay",
				"TxnRef":            req.TransactionCode,
				"Amount":            orderAmount / 100, // Convert from VNPay format
				"TransactionTime":   createdTime.Format("02.01.2006 15:04:05"),
				"QueryTime":         queryTime.Format("02.01.2006 15:04:05"),
				"TransactionStatus": orderStatus,
				"OrderInfo":         orderInfo,
				"ResponseCode":      "99",
				"RequestId":         payload["vnp_RequestId"],
				"HttpStatus":        statusCode,
			})
			return
		}

		// Evaluate result from typed QueryDRResponse
		responseCode := vnpResp.ResponseCode
		transactionStatus := vnpResp.TransactionStatus
		bankCode := vnpResp.BankCode
		amountStr := vnpResp.Amount

		var statusClass, statusMessage, displayTransactionStatus string
		var amountValue int64
		var parseErr error

		// Parse amount if available, otherwise use DB amount
		if amountStr != "" {
			amountValue, parseErr = strconv.ParseInt(amountStr, 10, 64)
			if parseErr == nil {
				amountValue = amountValue / 100
			} else {
				amountValue = orderAmount / 100
			}
		} else {
			amountValue = orderAmount / 100
		}

		// Prefer VNPay PayDate when available (parse in VN timezone), otherwise fallback to DB created time.
		transactionTime := createdTime.Format("02.01.2006 15:04:05")
		if strings.TrimSpace(vnpResp.PayDate) != "" {
			loc, err := time.LoadLocation("Asia/Ho_Chi_Minh")
			if err != nil {
				log.Printf("Warning: cannot load Asia/Ho_Chi_Minh location: %v", err)
			} else {
				if payT, err := time.ParseInLocation("20060102150405", vnpResp.PayDate, loc); err == nil {
					transactionTime = payT.Format("02.01.2006 15:04:05")
				} else {
					log.Printf("Failed to parse VNPay PayDate %q: %v", vnpResp.PayDate, err)
				}
			}
		}

		// Determine status display
		if responseCode == "00" && transactionStatus == "00" {
			statusClass = "success"
			statusMessage = "✅ Giao dịch thành công"
			displayTransactionStatus = "Thành công"
		} else if responseCode == "00" && transactionStatus != "00" {
			statusClass = "failed"
			statusMessage = "❌ Giao dịch thất bại"
			displayTransactionStatus = "Thất bại"
		} else if responseCode == "91" {
			statusClass = "pending"
			statusMessage = "⏳ Giao dịch đang xử lý hoặc đã hết hạn truy vấn"
			displayTransactionStatus = "Đang xử lý"
		} else if responseCode == "94" {
			// Duplicate request detected by VNPay
			statusClass = "failed"
			statusMessage = "❌ Yêu cầu trùng lặp (duplicate request) – vui lòng thử lại sau một khoảng thời gian"
			displayTransactionStatus = "Không xác định"
		} else {
			statusClass = "failed"
			statusMessage = "❌ Truy vấn thất bại"
			displayTransactionStatus = "Không xác định"
		}

		// Render the result template
		c.HTML(http.StatusOK, "query_result.html", gin.H{
			"StatusClass":       statusClass,
			"StatusMessage":     statusMessage,
			"TxnRef":            req.TransactionCode,
			"Amount":            amountValue,
			"BankCode":          bankCode,
			"TransactionTime":   transactionTime,
			"QueryTime":         queryTime.Format("02.01.2006 15:04:05"),
			"TransactionStatus": displayTransactionStatus,
			"OrderInfo":         orderInfo,
			"ResponseCode":      responseCode,
			"RequestId":         payload["vnp_RequestId"],
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
