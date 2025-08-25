package utils

import (
	"bytes"
	"crypto/hmac"
	"crypto/sha512"
	"encoding/hex"
	"encoding/json"
	"fmt"
	"net"
	"net/http"
	"net/url"
	"sort"
	"strconv"
	"strings"
	"time"

	"github.com/google/uuid"
)

var (
	VnpTmnCode    = "DGWQRL1A"
	VnpHashSecret = "AF76H8AKX85KUBM7GCB7TN1MZ64NNI4P"
	VnpURL        = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"
	VnpReturnURL  = "https://a8a3344578f0.ngrok-free.app/vnpay/return"
	VnpIpnURL     = "https://a8a3344578f0.ngrok-free.app/vnpay/ipn"

	// VNPay Merchant API (Query/Refund)
	VnpApiURL = "https://sandbox.vnpayment.vn/merchant_webapi/api/transaction"
)

// ---------- Common helpers ----------

// Calculate secure hash for key=value&... style (used in "pay" URL build)
func CalculateChecksum(params map[string]string) string {
	var keys []string
	for k := range params {
		keys = append(keys, k)
	}
	sort.Strings(keys)

	var parts []string
	for _, k := range keys {
		if strings.HasPrefix(k, "vnp_") && params[k] != "" {
			parts = append(parts, k+"="+url.QueryEscape(params[k]))
		}
	}

	data := strings.Join(parts, "&")
	h := hmac.New(sha512.New, []byte(VnpHashSecret))
	h.Write([]byte(data))
	// VNPay is tolerant here, but keep it upper to be consistent.
	return strings.ToUpper(hex.EncodeToString(h.Sum(nil)))
}

// ---- QueryDR-specific checksum (STRICT order, NO url-escape) ----
// Techspec 2.1.0, §2.5.4 (querydr):
// data = vnp_RequestId + "|" + vnp_Version + "|" + vnp_Command + "|" +
//
//	vnp_TmnCode + "|" + vnp_TxnRef + "|" + vnp_TransactionDate + "|" +
//	vnp_CreateDate + "|" + vnp_IpAddr + "|" + vnp_OrderInfo
func calculateQueryDRChecksum(req map[string]string) string {
	// Ensure all required keys exist (use empty string if not set to avoid nil map lookups)
	ordered := []string{
		req["vnp_RequestId"],
		req["vnp_Version"],
		req["vnp_Command"],
		req["vnp_TmnCode"],
		req["vnp_TxnRef"],
		req["vnp_TransactionDate"],
		req["vnp_CreateDate"],
		req["vnp_IpAddr"],
		req["vnp_OrderInfo"],
	}
	raw := strings.Join(ordered, "|")

	mac := hmac.New(sha512.New, []byte(VnpHashSecret))
	mac.Write([]byte(raw))
	sum := strings.ToUpper(hex.EncodeToString(mac.Sum(nil)))

	// Debug logs
	fmt.Println(">>> VNPay Checksum Input:", raw)
	fmt.Println(">>> VNPay Generated HMAC:", sum)

	return sum
}

func GetClientIP(r *http.Request) string {
	ip := r.Header.Get("X-Real-IP")
	if ip == "" {
		ip = r.Header.Get("X-Forwarded-For")
	}
	if ip == "" {
		ip, _, _ = net.SplitHostPort(r.RemoteAddr)
		if ip == "" {
			ip = r.RemoteAddr
		}
	}
	return ip
}

// Best-effort server IP (for vnp_IpAddr in server-to-server calls)
func GetServerIP() string {
	addrs, _ := net.InterfaceAddrs()
	for _, a := range addrs {
		if ipnet, ok := a.(*net.IPNet); ok && !ipnet.IP.IsLoopback() && ipnet.IP.To4() != nil {
			return ipnet.IP.String()
		}
	}
	return "127.0.0.1"
}

// ---------- QueryDR (Transaction Lookup) ----------

type QueryDRRequest struct {
	RequestId       string `json:"vnp_RequestId"`
	Version         string `json:"vnp_Version"`
	Command         string `json:"vnp_Command"`
	TmnCode         string `json:"vnp_TmnCode"`
	TxnRef          string `json:"vnp_TxnRef"`
	OrderInfo       string `json:"vnp_OrderInfo"`
	TransactionDate string `json:"vnp_TransactionDate"` // original vnp_CreateDate from pay
	CreateDate      string `json:"vnp_CreateDate"`      // time you send this query
	IpAddr          string `json:"vnp_IpAddr"`
	SecureHash      string `json:"vnp_SecureHash"`
}

type QueryDRResponse struct {
	ResponseId        string `json:"vnp_ResponseId"`
	Command           string `json:"vnp_Command"`
	ResponseCode      string `json:"vnp_ResponseCode"`
	Message           string `json:"vnp_Message"`
	TmnCode           string `json:"vnp_TmnCode"`
	TxnRef            string `json:"vnp_TxnRef"`
	Amount            string `json:"vnp_Amount"`
	BankCode          string `json:"vnp_BankCode"`
	PayDate           string `json:"vnp_PayDate"`
	TransactionNo     string `json:"vnp_TransactionNo"`
	TransactionType   string `json:"vnp_TransactionType"`
	TransactionStatus string `json:"vnp_TransactionStatus"`
	OrderInfo         string `json:"vnp_OrderInfo"`
	PromotionCode     string `json:"vnp_PromotionCode"`
	PromotionAmount   string `json:"vnp_PromotionAmount"`
	SecureHash        string `json:"vnp_SecureHash"`
}

// Build the minimal, spec-compliant body and sign it
func BuildQueryDRParams(txnRef string, txnDate string, orderInfo string, ip string) map[string]string {
	reqId := uuid.NewString()
	now := time.Now().Format("20060102150405")

	params := map[string]string{
		"vnp_RequestId":       reqId,
		"vnp_Version":         "2.1.0",
		"vnp_Command":         "querydr",
		"vnp_TmnCode":         VnpTmnCode,
		"vnp_TxnRef":          strings.TrimSpace(txnRef),
		"vnp_TransactionDate": strings.TrimSpace(txnDate),   // EXACT original vnp_CreateDate
		"vnp_CreateDate":      now,                          // when you send this query
		"vnp_IpAddr":          strings.TrimSpace(ip),        // the IP you’re sending from
		"vnp_OrderInfo":       strings.TrimSpace(orderInfo), // request description
	}

	// Sign with the strict querydr recipe
	params["vnp_SecureHash"] = calculateQueryDRChecksum(params)
	return params
}

func CallQueryDR(params map[string]string) (*QueryDRResponse, int, error) {
	body, _ := json.Marshal(params)

	// Log outgoing request payload
	fmt.Println(">>> Sending QueryDR payload:", string(body))

	req, err := http.NewRequest(http.MethodPost, VnpApiURL, bytes.NewReader(body))
	if err != nil {
		return nil, 0, err
	}
	req.Header.Set("Content-Type", "application/json")

	client := &http.Client{Timeout: 15 * time.Second}
	res, err := client.Do(req)
	if err != nil {
		return nil, 0, err
	}
	defer res.Body.Close()

	var out QueryDRResponse
	if err := json.NewDecoder(res.Body).Decode(&out); err != nil {
		return nil, res.StatusCode, fmt.Errorf("decode response: %w", err)
	}

	// Log incoming response
	fmt.Printf(">>> VNPay Response (HTTP %d): %+v\n", res.StatusCode, out)

	return &out, res.StatusCode, nil
}

// ---------- Refund Transaction ----------

// SignRefund creates the secure hash for refund requests using the pipe-separated format
func SignRefund(
	requestId, version, command, tmnCode, transactionType, txnRef,
	amount, transactionNo, transactionDate, createdby, createDate, ipAddr, orderInfo string) string {
	signData := strings.Join([]string{
		requestId,
		version,
		command,
		tmnCode,
		transactionType,
		txnRef,
		amount,
		transactionNo, // leave empty if not available, but keep the position
		transactionDate,
		createdby,
		createDate,
		ipAddr,
		orderInfo,
	}, "|")

	mac := hmac.New(sha512.New, []byte(VnpHashSecret))
	mac.Write([]byte(signData))
	return strings.ToUpper(hex.EncodeToString(mac.Sum(nil)))
}

// BuildRefundParams creates the refund request parameters
func BuildRefundParams(
	txnRef string,
	transactionType string,
	amount int64,
	transactionNo string,
	transactionDate string,
	orderInfo string,
	ip string) map[string]string {

	requestID := uuid.NewString()[:12]
	createDate := time.Now().Format("20060102150405")
	amountStr := strconv.FormatInt(amount, 10)

	payload := map[string]string{
		"vnp_RequestId":       requestID,
		"vnp_Version":         "2.1.0",
		"vnp_Command":         "refund",
		"vnp_TmnCode":         VnpTmnCode,
		"vnp_TransactionType": transactionType, // "02" full, "03" partial
		"vnp_TxnRef":          txnRef,
		"vnp_Amount":          amountStr, // amount * 100
		"vnp_OrderInfo":       orderInfo,
		"vnp_TransactionNo":   transactionNo,   // optional, can be ""
		"vnp_TransactionDate": transactionDate, // createDate of the original payment
		"vnp_CreateBy":        "admin",
		"vnp_CreateDate":      createDate, // time of refund request
		"vnp_IpAddr":          ip,
	}

	payload["vnp_SecureHash"] = SignRefund(
		requestID, "2.1.0", "refund", VnpTmnCode, transactionType, txnRef,
		amountStr, transactionNo, transactionDate, "admin", createDate, ip, orderInfo)

	return payload
}

// CallRefund sends the refund request to VNPay and returns the response
func CallRefund(params map[string]string) (map[string]interface{}, int, error) {
	body, _ := json.Marshal(params)

	// Log outgoing request payload
	fmt.Println(">>> Sending Refund payload:", string(body))

	req, err := http.NewRequest(http.MethodPost, VnpApiURL, bytes.NewReader(body))
	if err != nil {
		return nil, 0, err
	}
	req.Header.Set("Content-Type", "application/json")

	client := &http.Client{Timeout: 15 * time.Second}
	res, err := client.Do(req)
	if err != nil {
		return nil, 0, err
	}
	defer res.Body.Close()

	var out map[string]interface{}
	if err := json.NewDecoder(res.Body).Decode(&out); err != nil {
		return nil, res.StatusCode, fmt.Errorf("decode response: %w", err)
	}

	// Log incoming response
	fmt.Printf(">>> VNPay Refund Response (HTTP %d): %+v\n", res.StatusCode, out)

	return out, res.StatusCode, nil
}
