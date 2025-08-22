package utils

import (
	"crypto/hmac"
	"crypto/sha512"
	"encoding/hex"
	"net/http"
	"net/url"
	"sort"
	"strings"
)

var (
	VnpTmnCode    = "DGWQRL1A"
	VnpHashSecret = "AF76H8AKX85KUBM7GCB7TN1MZ64NNI4P"
	VnpURL        = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"
	VnpReturnURL  = "https://ebdaa4fabb6f.ngrok-free.app/vnpay/return"
	VnpIpnURL     = "https://ebdaa4fabb6f.ngrok-free.app/vnpay/ipn"
)

// Calculate secure hash
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
	return hex.EncodeToString(h.Sum(nil))
}

func GetClientIP(r *http.Request) string {
	ip := r.Header.Get("X-Real-IP")
	if ip == "" {
		ip = r.Header.Get("X-Forwarded-For")
	}
	if ip == "" {
		ip = r.RemoteAddr
	}
	return ip
}
