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
	router.GET("/", controllers.PaymentPage(db))
	router.GET("/createorders", controllers.CreateOrders(db))
	router.GET("/ReturnURL", controllers.ReturnPage(db))
	router.GET("/IPN", controllers.HandleIPN(db))
	router.POST("/query_transaction", controllers.Query_request(db))

	// Refund Routes
	router.GET("/refund", controllers.RefundPage)
	router.POST("/refund", controllers.ProcessRefund(db))
	router.GET("/refund/result", controllers.GetRefundResult(db))

	log.Println("🚀 Server running on http://localhost:8080")
	router.Run("localhost:8080")
}
