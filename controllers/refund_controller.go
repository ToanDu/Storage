package controllers

import (
	"context"
	"fmt"
	"net/http"
	"storage-main/models"
	"storage-main/utils"
	"strconv"
	"strings"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/jackc/pgx/v5/pgxpool"
)

// RefundPage renders the refund form page
func RefundPage(c *gin.Context) {
	txnRef := c.Query("txnRef")
	c.HTML(http.StatusOK, "refund.html", gin.H{
		"TxnRef": txnRef,
	})
}

// ProcessRefund handles the refund request
func ProcessRefund(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		var req struct {
			TransactionCode string `json:"transaction_code" binding:"required"`
			TransactionType string `json:"transaction_type" binding:"required"` // "02" full, "03" partial
			RefundAmount    int64  `json:"refund_amount"`                       // VND (not multiplied by 100)
			OrderInfo       string `json:"order_info"`
			TransactionNo   string `json:"transaction_no"` // optional
		}
		if err := c.BindJSON(&req); err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": "Invalid request"})
			return
		}

		tt := strings.TrimSpace(req.TransactionType)
		if tt != "02" && tt != "03" {
			c.JSON(http.StatusBadRequest, gin.H{"error": "transaction_type must be '02' (full) or '03' (partial)"})
			return
		}

		// Get order information to determine: transactionDate (original vnp_CreateDate) and original amount
		var createdTime time.Time
		var storedAmount100 int64 // already multiplied by 100 in createorders
		err := db.QueryRow(context.Background(),
			"SELECT created_at, amount FROM orders WHERE txn_ref = $1", req.TransactionCode).
			Scan(&createdTime, &storedAmount100)
		if err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": "Transaction not found"})
			return
		}

		// Determine refund amount (multiplied by 100 as per VNPay standard)
		var refundAmount100 int64
		if tt == "02" {
			// Full refund: use original amount (already *100 in DB)
			refundAmount100 = storedAmount100
		} else { // "03" partial
			if req.RefundAmount <= 0 {
				c.JSON(http.StatusBadRequest, gin.H{"error": "refund_amount must be > 0 for partial refund"})
				return
			}
			refundAmount100 = req.RefundAmount * 100
			// Check refund amount doesn't exceed original amount
			if refundAmount100 > storedAmount100 {
				c.JSON(http.StatusBadRequest, gin.H{"error": "refund_amount exceeds original payment amount"})
				return
			}
		}

		// Prepare refund payload
		transactionDate := createdTime.Format("20060102150405") // yyyyMMddHHmmss of original payment
		ip := utils.GetClientIP(c.Request)
		orderInfo := strings.TrimSpace(req.OrderInfo)
		if orderInfo == "" {
			if tt == "02" {
				orderInfo = "Refund full amount"
			} else {
				orderInfo = fmt.Sprintf("Refund partial amount %d VND", req.RefundAmount)
			}
		}
		transactionNo := strings.TrimSpace(req.TransactionNo) // can be empty

		payload := utils.BuildRefundParams(
			req.TransactionCode,
			tt,
			refundAmount100,
			transactionNo,
			transactionDate,
			orderInfo,
			ip)

		// Call VNPay API
		vnpResp, statusCode, err := utils.CallRefund(payload)
		if err != nil {
			c.JSON(http.StatusBadGateway, gin.H{"error": "Failed to call VNPay API"})
			return
		}

		// Quick assessment of API result
		apiOK := vnpResp["vnp_ResponseCode"] == "00"

		// Update order status (depending on system requirements)
		if apiOK {
			newStatus := "refund_pending"
			if tt == "02" {
				newStatus = "refunded"
			} else {
				newStatus = "partially_refunded"
			}
			_, _ = db.Exec(context.Background(),
				"UPDATE orders SET status = $1 WHERE txn_ref = $2", newStatus, req.TransactionCode)
		}

		c.JSON(http.StatusOK, gin.H{
			"request":      payload,
			"vnp_response": vnpResp,
			"api_success":  apiOK,
			"http_status":  statusCode,
		})
	}
}

// GetRefundResult renders a page to display refund results
func GetRefundResult(db *pgxpool.Pool) gin.HandlerFunc {
	return func(c *gin.Context) {
		txnRef := c.Query("txnRef")
		refundSuccess := c.Query("success")

		if txnRef == "" {
			c.HTML(http.StatusBadRequest, "return.html", gin.H{
				"Status":     "failed",
				"StatusText": "❌ Thiếu mã giao dịch",
			})
			return
		}

		// Get order information
		order, err := models.GetOrderByTxnRef(db, txnRef)
		if err != nil {
			c.HTML(http.StatusNotFound, "return.html", gin.H{
				"Status":     "failed",
				"StatusText": "❌ Không tìm thấy đơn hàng",
				"TxnRef":     txnRef,
			})
			return
		}

		status := order.Status
		statusText := "Giao dịch hoàn tiền đang xử lý"

		if status == "refunded" {
			statusText = "✅ Hoàn tiền toàn bộ thành công"
		} else if status == "partially_refunded" {
			statusText = "✅ Hoàn tiền một phần thành công"
		} else if refundSuccess == "false" {
			statusText = "❌ Yêu cầu hoàn tiền thất bại"
		}

		c.HTML(http.StatusOK, "return.html", gin.H{
			"TxnRef":     order.TxnRef,
			"Status":     status,
			"StatusText": statusText,
			"Amount":     strconv.FormatInt(order.Amount, 10),
			"OrderInfo":  order.OrderInfo,
			"IsRefund":   true,
		})
	}
}
