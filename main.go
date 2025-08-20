package main

import (
	"context"
	"crypto/hmac"
	"crypto/sha512"
	"encoding/hex"
	"fmt"
	"log"
	"net/http"
	"net/url"
	"sort"
	"strconv"
	"strings"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/google/uuid"
	"github.com/jackc/pgx/v5/pgxpool"
)

var (
	dbPool        *pgxpool.Pool
	vnpTmnCode    = "DGWQRL1A"
	vnpHashSecret = "AF76H8AKX85KUBM7GCB7TN1MZ64NNI4P"
	vnpURL        = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"
	vnpReturnURL  = "https://107e98e2ecd0.ngrok-free.app/vnpay/return"
	vnpIpnURL     = "https://107e98e2ecd0.ngrok-free.app/vnpay/ipn"
)

// type Food struct {
// 	ID    string `json:"id" binding:"omitempty,uuid"`
// 	Name  string `json:"name" binding:"required,min=6"`
// 	Price int64  `json:"price" binding:"required,gt=1"`
// }

// var Menu = []Food{
// 	{ID: uuid.New().String(), Name: "Banh mi", Price: 20},
// 	{ID: uuid.New().String(), Name: "Pho", Price: 30},
// 	{ID: uuid.New().String(), Name: "Chao", Price: 15},
// }

// // gin.Context func carries request details, validates and serializes JSON
// func getMenu(c *gin.Context) {
// 	c.IndentedJSON(http.StatusOK, Menu) //Serialize struct to JSON and add to response
// } //Passing the StatusOK const from net/http package to indicate status code 200

// // Write a handler to add a new item when client mnakes a POST request at /Menu
// func postFood(c *gin.Context) {
// 	var newFood Food
// 	//BindJSON read data from 'newFood', then parse the JSON type to Go struct. If JSON type is incorrect --> leave the error
// 	if err := c.BindJSON(&newFood); err != nil {
// 		//TODO: return error

// 		return
// 	}
// 	if newFood.ID == "" {
// 		newFood.ID = uuid.NewString()
// 	}
// 	Menu = append(Menu, newFood)
// 	c.IndentedJSON(http.StatusAccepted, newFood)
// }

// // Write a handler for client to get the food they want
// func getFoodID(c *gin.Context) {
// 	id := c.Param("ID")
// 	for _, a := range Menu {
// 		if a.ID == id {
// 			c.IndentedJSON(http.StatusOK, a)
// 			return
// 		}
// 	}
// 	c.IndentedJSON(http.StatusNotFound, gin.H{"message": "Food not found"})
// }

func main() {
	ctx := context.Background()
	connStr := "postgresql://neondb_owner:npg_ZDah7pgSBcF2@ep-frosty-mode-a173e84z-pooler.ap-southeast-1.aws.neon.tech/neondb?sslmode=require"
	var err error
	dbPool, err = pgxpool.New(ctx, connStr)

	if err != nil {
		log.Fatalf("Failed to create pool: %v", err)
	}
	defer dbPool.Close()

	if err := dbPool.Ping(ctx); err != nil {
		log.Fatalf("Failed to ping Neon Postgres: %v. Connection string used: %s", err, connStr)
	}
	log.Println("Successfully connected to Neon Postgres!")

	router := gin.Default() //initialize a gin with default
	router.Static("/static", "./static")
	router.StaticFile("/return.html", "./static/return.html")
	router.StaticFile("/", "./static/index.html")
	router.POST("/createorders", createOrders)
	router.GET("/vnpay/return", handleReturn)
	//router.GET("/return.html", handleReturn)
	router.POST("/vnpay/ipn", handleIPN)
	router.Run("localhost:8080") //use the run func to attach router to http server and start the server

}

// And finally, we can access to the link http://localhost:8080/Menu, the UI in the web in simply JSON structure
func createOrders(c *gin.Context) {
	var req struct {
		Amount     int64  `json:"amount"`
		Order_info string `json:"Order info"`
	}
	if err := c.BindJSON(&req); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": "Invalid request"})
		return
	}
	tnxRef := uuid.NewString()
	_, err := dbPool.Exec(context.Background(),
		"INSERT INTO orders (id, txn_ref, amount, order_info, status) VALUES ($1, $2, $3, $4, 'pending')",
		uuid.New(), tnxRef, req.Amount*100, req.Order_info)
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": "Cannot save orders"})
		return
	}
	//tao params cho VNpay
	params := map[string]string{
		"vnp_Version":    "2.1.0",
		"vnp_Command":    "pay",
		"vnp_TmnCode":    vnpTmnCode,
		"vnp_Locale":     "vn",
		"vnp_CurrCode":   "VND",
		"vnp_TxnRef":     tnxRef,
		"vnp_OrderInfo":  req.Order_info,
		"vnp_OrderType":  "other",
		"vnp_Amount":     strconv.FormatInt(req.Amount*100, 10),
		"vnp_ReturnUrl":  vnpReturnURL,
		"vnp_IpAddr":     getIpAdd(c.Request),
		"vnp_CreateDate": time.Now().Format("20060102150405"),
		"vnp_ExpireDate": time.Now().Add(15 * time.Minute).Format("20060102150405"),
	}
	secureHash := calculateChecksum(params)
	//add them Checksum vao trong map params
	query := url.Values{}
	for k, v := range params {
		query.Add(k, v)
	}
	query.Add("vnp_SecureHash", secureHash)
	paymentURL := vnpURL + "?" + query.Encode()
	c.JSON(http.StatusOK, gin.H{"payment url": paymentURL})
	fmt.Println("Final redirect URL:", paymentURL)
}

// Tao checksum
func calculateChecksum(params map[string]string) string {
	var key []string
	for k := range params { //Gán các keys của map params vào trong slice key[]
		key = append(key, k)
	}
	sort.Strings(key)

	var parts []string
	for _, k := range key {
		if strings.HasPrefix(k, "vnp_") && params[k] != "" { //check xem co dung key vnp_xxx khong
			parts = append(parts, k+"="+url.QueryEscape(params[k]))
		}
	}
	data := strings.Join(parts, "&")
	h := hmac.New(sha512.New, []byte(vnpHashSecret))
	h.Write([]byte(data))
	return hex.EncodeToString(h.Sum(nil))
}

func getIpAdd(r *http.Request) string {
	ip := r.Header.Get("X-Real-IP")
	if ip == "" {
		ip = r.Header.Get("X-Forwarded-For")
	}
	if ip == "" {
		ip = r.RemoteAddr
	}
	return ip
}

func handleIPN(c *gin.Context) {
	if err := c.Request.ParseForm(); err != nil {
		c.String(http.StatusBadRequest, "Lỗi parse form")
		return
	}
	params := c.Request.Form

	txnRef := params.Get("vnp_TxnRef")
	respCode := params.Get("vnp_ResponseCode")

	status := "failed"
	if respCode == "00" {
		status = "success"
	}

	// Update DB
	var err error
	_, err = dbPool.Exec(context.Background(), "UPDATE orders SET status = $1 WHERE txn_ref = $2", status, txnRef)
	if err != nil {
		c.String(http.StatusInternalServerError, "99|Update DB failed")
		return
	}
	c.String(http.StatusOK, "00|OK")
}

func handleReturn(c *gin.Context) {
	params := c.Request.URL.Query()
	txnRef := params.Get("vnp_TxnRef")
	respCode := params.Get("vnp_ResponseCode")

	status := "failed"
	if respCode == "00" {
		status = "success"
	}

	_, _ = dbPool.Exec(context.Background(), "UPDATE orders SET status = $1 WHERE txn_ref = $2", status, txnRef)

	c.String(http.StatusOK, "Thanh toán %s! Mã giao dịch: %s", status, txnRef)
	// c.HTML(http.StatusOK, "return.html", gin.H{
	// 	"TxnRef": txnRef,
	// 	"Status": status,
	// })
}
