package main

import (
	"log"
	"storage-main/config"
	"storage-main/controllers"

	"github.com/gin-gonic/gin"
)

func main() {
	// Init DB
	db := config.InitDB()
	defer db.Close()

	router := gin.Default()

	// Load templates from views folder
	router.LoadHTMLGlob("views/*")

	// Payment Routes
	router.GET("/", controllers.PaymentPage)
	router.POST("/createorders", controllers.CreateOrders(db))
	router.GET("/vnpay/return", controllers.ReturnPage(db))
	router.POST("/vnpay/ipn", controllers.HandleIPN(db))
	router.GET("/vnpay/query", controllers.QueryTransaction(db))

	// Refund Routes
	router.GET("/refund", controllers.RefundPage)
	router.POST("/refund", controllers.ProcessRefund(db))
	router.GET("/refund/result", controllers.GetRefundResult(db))

	log.Println("🚀 Server running on http://localhost:8080")
	router.Run("localhost:8080")
}
