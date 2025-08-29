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
		amountStr := c.PostForm("amount")
		orderInfo := c.PostForm("txn_ref") // Now using txn_ref as orderInfo

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

		// Chuẩn bị payload querydr
		requestID := uuid.NewString()[:12]                      // đủ tính duy nhất trong ngày
		transactionDate := createdTime.Format("20060102150405") // phải là yyyyMMddHHmmss
		queryTime := time.Now()
		createDate := queryTime.Format("20060102150405")
		ip := utils.GetClientIP(c.Request)

		if strings.TrimSpace(req.OrderInfo) != "" {
			orderInfo = strings.TrimSpace(req.OrderInfo)
		} else if orderInfo == "" {
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

		// Ký đúng quy tắc của querydr
		payload["vnp_SecureHash"] = signQueryDR(
			requestID, "2.1.0", "querydr", utils.VnpTmnCode, req.TransactionCode,
			transactionDate, createDate, ip, orderInfo,
		)

		// Gọi VNPay
		b, _ := json.Marshal(payload)
		resp, err := http.Post(utils.VnpApiURL, "application/json", bytes.NewBuffer(b))
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
				"RequestId":         requestID,
			})
			return
		}
		defer resp.Body.Close()

		body, err := io.ReadAll(resp.Body)
		if err != nil {
			c.HTML(http.StatusBadGateway, "query_result.html", gin.H{
				"StatusClass":       "failed",
				"StatusMessage":     "❌ Lỗi đọc phản hồi từ VNPay",
				"TxnRef":            req.TransactionCode,
				"Amount":            orderAmount / 100,
				"TransactionTime":   createdTime.Format("02.01.2006 15:04:05"),
				"QueryTime":         queryTime.Format("02.01.2006 15:04:05"),
				"TransactionStatus": orderStatus,
				"OrderInfo":         orderInfo,
				"ResponseCode":      "99",
				"RequestId":         requestID,
			})
			return
		}

		var vnpResp map[string]any
		if err := json.Unmarshal(body, &vnpResp); err != nil {
			c.HTML(http.StatusBadGateway, "query_result.html", gin.H{
				"StatusClass":       "failed",
				"StatusMessage":     "❌ Lỗi phân tích phản hồi từ VNPay",
				"TxnRef":            req.TransactionCode,
				"Amount":            orderAmount / 100,
				"TransactionTime":   createdTime.Format("02.01.2006 15:04:05"),
				"QueryTime":         queryTime.Format("02.01.2006 15:04:05"),
				"TransactionStatus": orderStatus,
				"OrderInfo":         orderInfo,
				"ResponseCode":      "99",
				"RequestId":         requestID,
			})
			return
		}

		// Đánh giá kết quả
		responseCode, _ := vnpResp["vnp_ResponseCode"].(string)
		transactionStatus, _ := vnpResp["vnp_TransactionStatus"].(string)
		bankCode, _ := vnpResp["vnp_BankCode"].(string)
		amount, _ := vnpResp["vnp_Amount"].(string)

		var statusClass, statusMessage, displayTransactionStatus string
		var amountValue int64

		// Parse amount if available, otherwise use the one from the database
		if amount != "" {
			amountValue, err = strconv.ParseInt(amount, 10, 64)
			if err == nil {
				amountValue = amountValue / 100 // Convert from VNPay format
			} else {
				amountValue = orderAmount / 100
			}
		} else {
			amountValue = orderAmount / 100
		}

		// Luôn sử dụng createdTime từ database làm thời gian giao dịch
		transactionTime := createdTime.Format("02.01.2006 15:04:05")

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
			"RequestId":         requestID,
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
