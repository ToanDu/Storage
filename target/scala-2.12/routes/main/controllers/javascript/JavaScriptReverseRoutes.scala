
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/VHT_Projects/cmp-fe-dev-dev_multiLang/conf/routes
// @DATE:Mon Sep 22 16:32:39 ICT 2025

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:4
package controllers.javascript {

  // @LINE:451
  class ReverseMarketPlaceCommentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:452
    def getListCommentProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceCommentController.getListCommentProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListCommentProduct"})
        }
      """
    )
  
    // @LINE:451
    def commentWithProductId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceCommentController.commentWithProductId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "commentWithProductId"})
        }
      """
    )
  
  }

  // @LINE:376
  class ReverseWaterClockController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:377
    def getListClock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WaterClockController.getListClock",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListClock"})
        }
      """
    )
  
    // @LINE:376
    def waterClock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WaterClockController.waterClock",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "waterClock"})
        }
      """
    )
  
    // @LINE:378
    def getHistoryClock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WaterClockController.getHistoryClock",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryClock"})
        }
      """
    )
  
  }

  // @LINE:335
  class ReverseDevkitController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:335
    def devkit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DevkitController.devkit",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "devkit/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:554
  class ReverseTelcoUtilitiesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:567
    def prepayCharges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.prepayCharges",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prepayCharges" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("userId", userId0)])})
        }
      """
    )
  
    // @LINE:563
    def rechargeSubcriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.rechargeSubcriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rechargeSubcriber"})
        }
      """
    )
  
    // @LINE:566
    def validateSubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.validateSubs",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateSubs"})
        }
      """
    )
  
    // @LINE:569
    def getDataPrepaidInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getDataPrepaidInfo",
      """
        function(prom_code0,product_code1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataPrepaidInfo" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("prom_code", prom_code0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("product_code", product_code1)])})
        }
      """
    )
  
    // @LINE:557
    def utilitiesBuyPackage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.utilitiesBuyPackage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/utilitiesBuyPackage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:564
    def getListOrderIdByAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getListOrderIdByAction",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListOrderIdByAction"})
        }
      """
    )
  
    // @LINE:571
    def getHistoryPrepayCharges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getHistoryPrepayCharges",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryPrepayCharges"})
        }
      """
    )
  
    // @LINE:575
    def getHistoryPayPostBill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getHistoryPayPostBill",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryPayPostBill"})
        }
      """
    )
  
    // @LINE:555
    def utilitiesTopup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.utilitiesTopup",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/utilitiesTopup/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:556
    def utilitiesBlock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.utilitiesBlock",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/utilitiesBlock/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:554
    def utilitiesManage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.utilitiesManage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/utilitiesManage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:572
    def payPostpaidBill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.payPostpaidBill",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/payPostpaidBill/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:573
    def payDebit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.payDebit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "payDebit"})
        }
      """
    )
  
    // @LINE:574
    def payPostpaidBillDetail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.payPostpaidBillDetail",
      """
        function(userId0,orderId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/payPostpaidBill/detail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("orderId", orderId1))})
        }
      """
    )
  
    // @LINE:560
    def unregisterMiAddon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.unregisterMiAddon",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "unregisterMiAddon"})
        }
      """
    )
  
    // @LINE:558
    def getListPackMiAndAddOn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getListPackMiAndAddOn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListPackMiAndAddOn"})
        }
      """
    )
  
    // @LINE:562
    def getInfoOrderId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getInfoOrderId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoOrderId"})
        }
      """
    )
  
    // @LINE:570
    def rechargePrepaid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.rechargePrepaid",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rechargePrepaid"})
        }
      """
    )
  
    // @LINE:565
    def getHistoryBlockUnblock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.getHistoryBlockUnblock",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryBlockUnblock"})
        }
      """
    )
  
    // @LINE:561
    def unextendMiAddon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.unextendMiAddon",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "unextendMiAddon"})
        }
      """
    )
  
    // @LINE:568
    def prepayChargesBill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.prepayChargesBill",
      """
        function(userId0,isdn1,orderId2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prepayCharges/bill/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("isdn", isdn1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("orderId", orderId2))})
        }
      """
    )
  
    // @LINE:559
    def registerMiAddon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoUtilitiesController.registerMiAddon",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registerMiAddon"})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
        
          if (file1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("sitemap.xml") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sitemap.xml"})
          }
        
          if (file1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("sitemap_index.xml") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sitemap_index.xml"})
          }
        
          if (file1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("robots.txt") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "robots.txt"})
          }
        
          if (file1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("dieu-khoan.txt") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dieu-khoan.txt"})
          }
        
          if (file1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("health.html") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "healthCheck"})
          }
        
        }
      """
    )
  
    // @LINE:42
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:292
  class ReverseRuleChainController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:293
    def flowEngineWithId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RuleChainController.flowEngineWithId",
      """
        function(projectId0,idFlow1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "flowEngineWithId/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("projectId", projectId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("idFlow", idFlow1))})
        }
      """
    )
  
    // @LINE:292
    def ruleChain: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RuleChainController.ruleChain",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ruleEngine/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:203
  class ReverseLogDeviceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:203
    def logDeviceList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LogDeviceController.logDeviceList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logDeviceList"})
        }
      """
    )
  
    // @LINE:204
    def getAllLogMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LogDeviceController.getAllLogMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllLogMessage"})
        }
      """
    )
  
  }

  // @LINE:135
  class ReverseDashboardAppController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:141
    def sendMessageOnOffApp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.sendMessageOnOffApp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessageOnOffApp"})
        }
      """
    )
  
    // @LINE:138
    def getListDeviceWithWidgetMapApp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.getListDeviceWithWidgetMapApp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceWithWidgetMapApp"})
        }
      """
    )
  
    // @LINE:139
    def getDataAttributeByIdApp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.getDataAttributeByIdApp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataAttributeByIdApp"})
        }
      """
    )
  
    // @LINE:136
    def getDashboardWithId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.getDashboardWithId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDashboardWithIdApp"})
        }
      """
    )
  
    // @LINE:140
    def getLastValueAttributeApp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.getLastValueAttributeApp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLastValueAttributeApp"})
        }
      """
    )
  
    // @LINE:135
    def appDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.appDashboard",
      """
        function(id0,dashboardId1,token2,deviceId3,deviceToken4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "appDashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("dashboardId", dashboardId1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("token", token2)) + _qS([(deviceId3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("deviceId", deviceId3)), (deviceToken4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("deviceToken", deviceToken4))])})
        }
      """
    )
  
    // @LINE:137
    def getPositionDeviceByAttributeApp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardAppController.getPositionDeviceByAttributeApp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getPositionDeviceByAttributeApp"})
        }
      """
    )
  
  }

  // @LINE:617
  class ReverseTelcoHistoryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:624
    def historyPostPaidBill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.historyPostPaidBill",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyPostPaidBill/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:622
    def getHistoryPackMiAddon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.getHistoryPackMiAddon",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryPackMiAddon"})
        }
      """
    )
  
    // @LINE:619
    def historyPrepayCharges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.historyPrepayCharges",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyPrepayCharges/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:621
    def historyBlockUnblock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.historyBlockUnblock",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyBlockUnblock/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:618
    def historyDeposit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.historyDeposit",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyDeposit/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:617
    def historyPackMiAddon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.historyPackMiAddon",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyPackMiAddon/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:623
    def getHistoryApn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.getHistoryApn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryAPN"})
        }
      """
    )
  
    // @LINE:620
    def historyApn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoHistoryController.historyApn",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyAPN/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:56
  class ReverseDownloadPageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def download: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DownloadPageController.download",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "download"})
        }
      """
    )
  
  }

  // @LINE:340
  class ReverseAppDebugController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:343
    def appSdkPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AppDebugController.appSdkPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "appSdkPage"})
        }
      """
    )
  
    // @LINE:340
    def appDebug: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AppDebugController.appDebug",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "appDebug/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:344
    def solutionMaketPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AppDebugController.solutionMaketPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "solutionMaketPage"})
        }
      """
    )
  
    // @LINE:341
    def appDebugPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AppDebugController.appDebugPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "appDebugPage"})
        }
      """
    )
  
    // @LINE:342
    def appSdk: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AppDebugController.appSdk",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "appSdk/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:45
  class ReverseJsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:47
    def javascriptRoutes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.JsController.javascriptRoutes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascriptRoutes"})
        }
      """
    )
  
    // @LINE:45
    def jsMessages: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.JsController.jsMessages",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messages.js"})
        }
      """
    )
  
  }

  // @LINE:381
  class ReverseTemplateDeviceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:384
    def getTemplateDeviceById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TemplateDeviceController.getTemplateDeviceById",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getTemplateDeviceById"})
        }
      """
    )
  
    // @LINE:382
    def addTemplateDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TemplateDeviceController.addTemplateDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addTemplateDevice"})
        }
      """
    )
  
    // @LINE:385
    def editTemplateDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TemplateDeviceController.editTemplateDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editTemplateDevice"})
        }
      """
    )
  
    // @LINE:386
    def deleteTemplateDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TemplateDeviceController.deleteTemplateDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteTemplateDeviceById"})
        }
      """
    )
  
    // @LINE:383
    def getListTemplateDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TemplateDeviceController.getListTemplateDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListTemplateDevice"})
        }
      """
    )
  
    // @LINE:381
    def templateDeviceList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TemplateDeviceController.templateDeviceList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "templateDeviceList"})
        }
      """
    )
  
  }

  // @LINE:402
  class ReverseAdminSystemHealthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:402
    def systemHealth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminSystemHealthController.systemHealth",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "systemHealth"})
        }
      """
    )
  
  }

  // @LINE:276
  class ReverseEventController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:281
    def onclickEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.onclickEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "onclickEvent"})
        }
      """
    )
  
    // @LINE:288
    def activeEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.activeEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "activeEvent"})
        }
      """
    )
  
    // @LINE:278
    def addNewSchedule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.addNewSchedule",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewSchedule"})
        }
      """
    )
  
    // @LINE:279
    def editEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.editEvent",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editEvent/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:276
    def eventList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.eventList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eventList"})
        }
      """
    )
  
    // @LINE:277
    def addNewEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.addNewEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewEvent"})
        }
      """
    )
  
    // @LINE:283
    def deleteEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.deleteEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteEvent"})
        }
      """
    )
  
    // @LINE:289
    def deActiveEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.deActiveEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deActiveEvent"})
        }
      """
    )
  
    // @LINE:285
    def updateEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.updateEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "UpdateEvent"})
        }
      """
    )
  
    // @LINE:280
    def editSchedule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.editSchedule",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editSchedule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:282
    def getVarsByDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.getVarsByDevice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "variableList"})
        }
      """
    )
  
    // @LINE:287
    def removeEventOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.removeEventOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "removeEventOrg"})
        }
      """
    )
  
    // @LINE:286
    def changeEventOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.changeEventOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "changeEventOrg"})
        }
      """
    )
  
    // @LINE:284
    def getEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.getEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "eventDetail"})
        }
      """
    )
  
  }

  // @LINE:59
  class ReverseProjectController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:62
    def addProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.addProject",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addProject"})
        }
      """
    )
  
    // @LINE:66
    def sendPostJsonProjectTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.sendPostJsonProjectTemplate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendJsonProjectTemplate"})
        }
      """
    )
  
    // @LINE:61
    def createProjectForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.createProjectForm",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createProjectForm"})
        }
      """
    )
  
    // @LINE:63
    def editProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.editProject",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editProject"})
        }
      """
    )
  
    // @LINE:59
    def project: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.project",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "project"})
        }
      """
    )
  
    // @LINE:68
    def createDashboardTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.createDashboardTemplate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createDashboardTemplate"})
        }
      """
    )
  
    // @LINE:70
    def activePhone: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.activePhone",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "activePhone"})
        }
      """
    )
  
    // @LINE:64
    def delProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.delProject",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delProject"})
        }
      """
    )
  
    // @LINE:65
    def getNameProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.getNameProject",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getNameProject/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:69
    def getListTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.getListTag",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListTag"})
        }
      """
    )
  
    // @LINE:67
    def sendPutJsonProjectTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.sendPutJsonProjectTemplate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendPutJsonProjectTemplate"})
        }
      """
    )
  
    // @LINE:60
    def getProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.getProject",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getProject"})
        }
      """
    )
  
  }

  // @LINE:302
  class ReversePayCustomerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:302
    def getInfoVendor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.getInfoVendor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoVendor"})
        }
      """
    )
  
    // @LINE:314
    def getInfoCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.getInfoCustomer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoCustomer"})
        }
      """
    )
  
    // @LINE:313
    def postPricingOfCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.postPricingOfCustomer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "postPricingOfCustomer"})
        }
      """
    )
  
    // @LINE:316
    def updateInfoCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.updateInfoCustomer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateInfoCustomer"})
        }
      """
    )
  
    // @LINE:310
    def payment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.payment",
      """
        function(id0,userId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "payment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId1))})
        }
      """
    )
  
    // @LINE:307
    def cancelSubscription: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.cancelSubscription",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cancelSubscription"})
        }
      """
    )
  
    // @LINE:304
    def updateVendor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.updateVendor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateVendor"})
        }
      """
    )
  
    // @LINE:312
    def addPackdataNewForUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.addPackdataNewForUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addPackdataNewForUser"})
        }
      """
    )
  
    // @LINE:311
    def getListUserInOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.getListUserInOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListUserInOrg"})
        }
      """
    )
  
    // @LINE:306
    def createSubscription: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.createSubscription",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createSubscription"})
        }
      """
    )
  
    // @LINE:315
    def createInfoCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.createInfoCustomer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createInfoCustomer"})
        }
      """
    )
  
    // @LINE:305
    def getSubscription: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.getSubscription",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getSubscription"})
        }
      """
    )
  
    // @LINE:303
    def createVendor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.createVendor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createVendor"})
        }
      """
    )
  
    // @LINE:309
    def payCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayCustomerController.payCustomer",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "payCustomer/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:419
  class ReverseProductListController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:424
    def editProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.editProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editProduct"})
        }
      """
    )
  
    // @LINE:426
    def manageProductList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.manageProductList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "manageProductList"})
        }
      """
    )
  
    // @LINE:423
    def getProductById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.getProductById",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getProductById"})
        }
      """
    )
  
    // @LINE:419
    def productList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.productList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "productList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:427
    def manageProductFilterList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.manageProductFilterList",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "manageProductList"})
        }
      """
    )
  
    // @LINE:421
    def getProductByUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.getProductByUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getProductByUser"})
        }
      """
    )
  
    // @LINE:429
    def requestApproveProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.requestApproveProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "requestApproveProduct"})
        }
      """
    )
  
    // @LINE:422
    def deleteProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.deleteProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteProduct"})
        }
      """
    )
  
    // @LINE:428
    def changeStatusProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.changeStatusProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "changeStatusProduct"})
        }
      """
    )
  
    // @LINE:420
    def createProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductListController.createProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createProduct"})
        }
      """
    )
  
  }

  // @LINE:207
  class ReverseDeviceTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:211
    def getListTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTypeController.getListTypes",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListTypes"})
        }
      """
    )
  
    // @LINE:209
    def deleteDeviceType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTypeController.deleteDeviceType",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDeviceType"})
        }
      """
    )
  
    // @LINE:208
    def addNewDeviceType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTypeController.addNewDeviceType",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewDeviceType"})
        }
      """
    )
  
    // @LINE:210
    def editDeviceType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTypeController.editDeviceType",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editDeviceType"})
        }
      """
    )
  
    // @LINE:207
    def deviceTypeList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTypeController.deviceTypeList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deviceTypeList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:531
  class ReverseTelcoSubscriberController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:546
    def open2wSubcriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.open2wSubcriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "open2wSubcriber"})
        }
      """
    )
  
    // @LINE:532
    def getListSubscriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getListSubscriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSubscriber"})
        }
      """
    )
  
    // @LINE:540
    def getCtkm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getCtkm",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getCtkm"})
        }
      """
    )
  
    // @LINE:539
    def getHybridInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getHybridInfo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHybridInfo"})
        }
      """
    )
  
    // @LINE:536
    def getListProductOffering: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getListProductOffering",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListProductOffering"})
        }
      """
    )
  
    // @LINE:541
    def getBalanceInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getBalanceInfo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getBalanceInfo"})
        }
      """
    )
  
    // @LINE:535
    def subscriberDetail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.subscriberDetail",
      """
        function(id0,subs1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriberDetail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("subs", subs1))})
        }
      """
    )
  
    // @LINE:531
    def subscriberManage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.subscriberManage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/subscriberManage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:542
    def getDebitSubscriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getDebitSubscriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDebitSubscriber"})
        }
      """
    )
  
    // @LINE:545
    def openSubcriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.openSubcriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "openSubcriber"})
        }
      """
    )
  
    // @LINE:534
    def getDetailSubscriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getDetailSubscriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailSubscriber"})
        }
      """
    )
  
    // @LINE:533
    def getListSubsByBeVht: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getListSubsByBeVht",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSubsByBeVht"})
        }
      """
    )
  
    // @LINE:538
    def getTotalSubscriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getTotalSubscriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getTotalSubscriber"})
        }
      """
    )
  
    // @LINE:543
    def getKttkAndKtmi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getKttkAndKtmi",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getKttkAndKtmi"})
        }
      """
    )
  
    // @LINE:544
    def blockSubcriber: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.blockSubcriber",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "blockSubcriber"})
        }
      """
    )
  
    // @LINE:537
    def getInfoDataAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoSubscriberController.getInfoDataAccount",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoDataAccount"})
        }
      """
    )
  
  }

  // @LINE:640
  class ReverseTelcoFeedbackController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:642
    def logFeedback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoFeedbackController.logFeedback",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logFeedback"})
        }
      """
    )
  
    // @LINE:641
    def sendFeedback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoFeedbackController.sendFeedback",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendFeedback"})
        }
      """
    )
  
    // @LINE:640
    def feedback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoFeedbackController.feedback",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "feedback/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:643
    def getLogListFeedback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoFeedbackController.getLogListFeedback",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLogListFeedback"})
        }
      """
    )
  
  }

  // @LINE:93
  class ReverseApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:93
    def sendMail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.sendMail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMail"})
        }
      """
    )
  
    // @LINE:94
    def getJsonWidget: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getJsonWidget",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getJsonWidget/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:479
  class ReverseTelcoAPNController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:481
    def getAPNByPhone: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAPNController.getAPNByPhone",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "apn/getAPNByPhone"})
        }
      """
    )
  
    // @LINE:479
    def APNview: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAPNController.APNview",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apn/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:482
    def registerAPN: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAPNController.registerAPN",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "apn/registerAPN"})
        }
      """
    )
  
    // @LINE:483
    def unRegisterAPN: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAPNController.unRegisterAPN",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "apn/unRegisterAPN"})
        }
      """
    )
  
    // @LINE:480
    def getIpAllow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAPNController.getIpAllow",
      """
        function(isdn0,userId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apn/getIpAllow/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("isdn", isdn0)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("userId", userId1)])})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseOrderSearchController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:521
    def getSearchOrder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderSearchController.getSearchOrder",
      """
        function(orderId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getSearchOrder/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("orderId", orderId0))})
        }
      """
    )
  
    // @LINE:5
    def OrderSearchView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderSearchController.OrderSearchView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tra_cuu_don_hang"})
        }
      """
    )
  
  }

  // @LINE:404
  class ReverseAdminOverviewProjectController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:404
    def adminOverviewProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewProjectController.adminOverviewProject",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminOverviewProject/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:296
  class ReversePayPackDataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:301
    def deletePackdata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayPackDataController.deletePackdata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePackdata"})
        }
      """
    )
  
    // @LINE:299
    def getInfoPackdata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayPackDataController.getInfoPackdata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoPackdata"})
        }
      """
    )
  
    // @LINE:297
    def getListPackdata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayPackDataController.getListPackdata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListPackdata"})
        }
      """
    )
  
    // @LINE:300
    def editPackdata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayPackDataController.editPackdata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editPackdata"})
        }
      """
    )
  
    // @LINE:298
    def addNewPackdata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayPackDataController.addNewPackdata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewPackdata"})
        }
      """
    )
  
    // @LINE:296
    def packData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayPackDataController.packData",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "packData/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:107
  class ReverseDownloadFileController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:107
    def downloadFileFromApi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DownloadFileController.downloadFileFromApi",
      """
        function(param0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "downloadFile" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("param", param0)])})
        }
      """
    )
  
  }

  // @LINE:110
  class ReverseDashboardController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:110
    def dashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.dashboard",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboard"})
        }
      """
    )
  
    // @LINE:113
    def loadDeviceDataCurrent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.loadDeviceDataCurrent",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loadDeviceDataCurrent/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:111
    def getMarkersWithPaging: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.getMarkersWithPaging",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getMarkersWithPaging"})
        }
      """
    )
  
    // @LINE:112
    def getListDeviceWithPaging: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.getListDeviceWithPaging",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceWithPaging"})
        }
      """
    )
  
  }

  // @LINE:524
  class ReverseAdminTelcoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:529
    def getListEnterpriseSubmitOfAdminSpe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminTelcoController.getListEnterpriseSubmitOfAdminSpe",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListEnterpriseSubmitOfAdminSpe"})
        }
      """
    )
  
    // @LINE:526
    def processComfirmInfoAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminTelcoController.processComfirmInfoAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processComfirmInfoAccountCmp"})
        }
      """
    )
  
    // @LINE:528
    def getListEnterpriseByBrowser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminTelcoController.getListEnterpriseByBrowser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListEnterpriseByBrowser"})
        }
      """
    )
  
    // @LINE:525
    def getListInfoApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminTelcoController.getListInfoApproved",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListInfoApproved"})
        }
      """
    )
  
    // @LINE:524
    def approvedInfoCompanyTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminTelcoController.approvedInfoCompanyTelco",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "approvedInfoCompanyTelco"})
        }
      """
    )
  
    // @LINE:527
    def processComfirmInfoCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminTelcoController.processComfirmInfoCompany",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processComfirmInfoCompany"})
        }
      """
    )
  
  }

  // @LINE:548
  class ReverseTelcoContractController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:550
    def getDebitContract: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoContractController.getDebitContract",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDebitContract"})
        }
      """
    )
  
    // @LINE:551
    def getTotalAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoContractController.getTotalAccount",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getTotalAccount"})
        }
      """
    )
  
    // @LINE:549
    def getListAccountContract: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoContractController.getListAccountContract",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListAccountContract"})
        }
      """
    )
  
    // @LINE:548
    def contractManage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoContractController.contractManage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/contractManage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:552
    def getListContractByIdNo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoContractController.getListContractByIdNo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListContractByIdNo"})
        }
      """
    )
  
  }

  // @LINE:120
  class ReverseDashboardV3Controller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:124
    def deleteDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.deleteDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDashboard"})
        }
      """
    )
  
    // @LINE:128
    def moveDashboardToOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.moveDashboardToOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "moveDashboardToOrg"})
        }
      """
    )
  
    // @LINE:120
    def dashboardList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.dashboardList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboardList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:125
    def dashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.dashboard",
      """
        function(id0,dashboardId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("dashboardId", dashboardId1))})
        }
      """
    )
  
    // @LINE:123
    def editContentDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.editContentDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editContentDashboard"})
        }
      """
    )
  
    // @LINE:121
    def getListDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.getListDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDashboard"})
        }
      """
    )
  
    // @LINE:126
    def getDashboardWithId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.getDashboardWithId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDashboardWithId"})
        }
      """
    )
  
    // @LINE:122
    def addNewDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.addNewDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewDashboard"})
        }
      """
    )
  
    // @LINE:127
    def saveDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardV3Controller.saveDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveDashboard"})
        }
      """
    )
  
  }

  // @LINE:465
  class ReverseTelcoOrderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:467
    def checkValidateSerialSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.checkValidateSerialSim",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "checkValidateSerialSim"})
        }
      """
    )
  
    // @LINE:476
    def getListSaleService1: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getListSaleService1",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSaleService1"})
        }
      """
    )
  
    // @LINE:472
    def unlockIsdnVht: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.unlockIsdnVht",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "unlockIsdnVht"})
        }
      """
    )
  
    // @LINE:475
    def getListSaleService: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getListSaleService",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSaleService"})
        }
      """
    )
  
    // @LINE:477
    def processOrderBuySim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.processOrderBuySim",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processOrderBuySim"})
        }
      """
    )
  
    // @LINE:489
    def getCustomerType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getCustomerType",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getCustomerType"})
        }
      """
    )
  
    // @LINE:490
    def getListCt: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getListCt",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListCt"})
        }
      """
    )
  
    // @LINE:471
    def blockIsdnVht: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.blockIsdnVht",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "blockIsdnVht"})
        }
      """
    )
  
    // @LINE:486
    def manageOrder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.manageOrder",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/manageOrder/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:474
    def getListProductOffer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getListProductOffer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListProductOffer"})
        }
      """
    )
  
    // @LINE:487
    def getListOrderBuySim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getListOrderBuySim",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListOrderBuySim"})
        }
      """
    )
  
    // @LINE:473
    def connectSubscriberSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.connectSubscriberSim",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "connectSubscriberSim"})
        }
      """
    )
  
    // @LINE:488
    def upfilePycTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.upfilePycTelco",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "upfilePycTelco"})
        }
      """
    )
  
    // @LINE:470
    def searchSubscriberByStock: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.searchSubscriberByStock",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "searchSubscriberByStock"})
        }
      """
    )
  
    // @LINE:466
    def getDataTelcoByUrl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getDataTelcoByUrl",
      """
        function(url0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataTelcoByUrl/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("url", url0))})
        }
      """
    )
  
    // @LINE:468
    def getListReasonFull: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getListReasonFull",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListReasonFull"})
        }
      """
    )
  
    // @LINE:465
    def orderSubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.orderSubs",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/orderSubs/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:469
    def getConnectSubscriberRamdom: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.getConnectSubscriberRamdom",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getConnectSubscriberRamdom"})
        }
      """
    )
  
    // @LINE:485
    def buySim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoOrderController.buySim",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/buySim/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:269
  class ReverseRoleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:269
    def roleList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.roleList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "roleList"})
        }
      """
    )
  
    // @LINE:271
    def deleteRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.deleteRole",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteRole"})
        }
      """
    )
  
    // @LINE:270
    def addNewRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.addNewRole",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewRole"})
        }
      """
    )
  
    // @LINE:272
    def getRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.getRole",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "roleDetail"})
        }
      """
    )
  
    // @LINE:273
    def updateRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.updateRole",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRole"})
        }
      """
    )
  
  }

  // @LINE:225
  class ReverseOrginazationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:225
    def orginazationView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrginazationController.orginazationView",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orginazationView/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:97
  class ReverseSocketController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:97
    def wsSocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SocketController.wsSocket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wsSocket"})
        }
      """
    )
  
  }

  // @LINE:221
  class ReverseFlowEngineController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:221
    def getListFlow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FlowEngineController.getListFlow",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListFlow"})
        }
      """
    )
  
    // @LINE:222
    def addFlow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FlowEngineController.addFlow",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addFlow"})
        }
      """
    )
  
  }

  // @LINE:165
  class ReverseAttributeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:188
    def getValueAttributeWithTime: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.getValueAttributeWithTime",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getValueAttributeWithTime"})
        }
      """
    )
  
    // @LINE:187
    def getPositionDeviceByAttribute: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.getPositionDeviceByAttribute",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getPositionDeviceByAttribute"})
        }
      """
    )
  
    // @LINE:167
    def getAttributeHistory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.getAttributeHistory",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAttributeHistory"})
        }
      """
    )
  
    // @LINE:170
    def attributeEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.attributeEvent",
      """
        function(id0,eventId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "attributeEvent/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("eventId", eventId1))})
        }
      """
    )
  
    // @LINE:185
    def getDataAttributeById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.getDataAttributeById",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataAttributeById"})
        }
      """
    )
  
    // @LINE:172
    def attributeGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.attributeGroup",
      """
        function(id0,groupId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "attributeGroup/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("groupId", groupId1))})
        }
      """
    )
  
    // @LINE:183
    def deleteAttributeOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.deleteAttributeOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAttributeOrg"})
        }
      """
    )
  
    // @LINE:169
    def attributeUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.attributeUser",
      """
        function(id0,userId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "attributeUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId1))})
        }
      """
    )
  
    // @LINE:166
    def getAttributeList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.getAttributeList",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAttributeList"})
        }
      """
    )
  
    // @LINE:186
    def getLastValueAttribute: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.getLastValueAttribute",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLastValueAttribute"})
        }
      """
    )
  
    // @LINE:171
    def attributeTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.attributeTemplate",
      """
        function(id0,templateId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "attributeTemplate/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("templateId", templateId1))})
        }
      """
    )
  
    // @LINE:182
    def addAttribute: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.addAttribute",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addAttribute"})
        }
      """
    )
  
    // @LINE:165
    def attributeDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.attributeDevice",
      """
        function(id0,deviceId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "attributeDevice/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("deviceId", deviceId1))})
        }
      """
    )
  
    // @LINE:184
    def editAttributeOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AttributeController.editAttributeOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editAttributeOrg"})
        }
      """
    )
  
  }

  // @LINE:325
  class ReversePaySubsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:325
    def subsList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PaySubsController.subsList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subsList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:327
    def getInfoSub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PaySubsController.getInfoSub",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoSub"})
        }
      """
    )
  
    // @LINE:328
    def getLinkPaymentSub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PaySubsController.getLinkPaymentSub",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLinkPaymentSub"})
        }
      """
    )
  
    // @LINE:326
    def getAllSubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PaySubsController.getAllSubs",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllSubs"})
        }
      """
    )
  
  }

  // @LINE:495
  class ReverseTelcoDashboardController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:507
    def getDetailLowRemainingData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDetailLowRemainingData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailLowRemainingData"})
        }
      """
    )
  
    // @LINE:496
    def getDataDashboardTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDataDashboardTelco",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataDashboardTelco"})
        }
      """
    )
  
    // @LINE:508
    def getDetailPackageExpired: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDetailPackageExpired",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailPackageExpired"})
        }
      """
    )
  
    // @LINE:505
    def getDetailRedAlert: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDetailRedAlert",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailRedAlert"})
        }
      """
    )
  
    // @LINE:497
    def getDataDashboardWithMonth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDataDashboardWithMonth",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataDashboardWithMonth"})
        }
      """
    )
  
    // @LINE:495
    def telcoDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.telcoDashboard",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:506
    def getDetailPrepaidExpired: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDetailPrepaidExpired",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailPrepaidExpired"})
        }
      """
    )
  
    // @LINE:501
    def getSubscriberStatistics: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getSubscriberStatistics",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getSubscriberStatistics"})
        }
      """
    )
  
    // @LINE:502
    def getBalanceDashboardTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getBalanceDashboardTelco",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getBalanceDashboardTelco"})
        }
      """
    )
  
    // @LINE:504
    def getListSubsDashboardBlockDebit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getListSubsDashboardBlockDebit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSubsDashboardBlockDebit"})
        }
      """
    )
  
    // @LINE:499
    def getAlertDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getAlertDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAlertDashboard"})
        }
      """
    )
  
    // @LINE:503
    def getListSubsDashboardByKey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getListSubsDashboardByKey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSubsDashboardByKey"})
        }
      """
    )
  
    // @LINE:498
    def getTop5DataUsersOfMonth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getTop5DataUsersOfMonth",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getTop5DataUsersOfMonth"})
        }
      """
    )
  
    // @LINE:500
    def getDetailAlertDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDashboardController.getDetailAlertDashboard",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailAlertDashboard"})
        }
      """
    )
  
  }

  // @LINE:356
  class ReverseQrCodeCamController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:357
    def createQrCodeCam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeCamController.createQrCodeCam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createQrCodeCam"})
        }
      """
    )
  
    // @LINE:356
    def qrCodeCam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeCamController.qrCodeCam",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "qrCodeCam"})
        }
      """
    )
  
    // @LINE:358
    def deleteQrCodeCam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeCamController.deleteQrCodeCam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteQrCodeCam"})
        }
      """
    )
  
  }

  // @LINE:587
  class ReverseTelcoRoleAccountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:594
    def addEnterpriseBySAdmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.addEnterpriseBySAdmin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addEnterpriseBySAdmin"})
        }
      """
    )
  
    // @LINE:587
    def accountList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.accountList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/accountList"})
        }
      """
    )
  
    // @LINE:599
    def deleteAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.deleteAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAccountCmp"})
        }
      """
    )
  
    // @LINE:589
    def addAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.addAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addAccountCmp"})
        }
      """
    )
  
    // @LINE:593
    def generatePassAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.generatePassAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "generatePassAccountCmp"})
        }
      """
    )
  
    // @LINE:598
    def updateEnterprise: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.updateEnterprise",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateEnterprise"})
        }
      """
    )
  
    // @LINE:601
    def checkValidateGpkd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.checkValidateGpkd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateGpkdExist"})
        }
      """
    )
  
    // @LINE:595
    def addEnterpriseByAdminOrSEnterprise: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.addEnterpriseByAdminOrSEnterprise",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addEnterpriseByAdminOrSEnterprise"})
        }
      """
    )
  
    // @LINE:597
    def editEnterprise: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.editEnterprise",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editEnterprise"})
        }
      """
    )
  
    // @LINE:602
    def updatRoleAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.updatRoleAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updatRoleAccountCmp"})
        }
      """
    )
  
    // @LINE:596
    def deleteEnterprise: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.deleteEnterprise",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteEnterprise"})
        }
      """
    )
  
    // @LINE:592
    def getInfoAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.getInfoAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoAccountCmp"})
        }
      """
    )
  
    // @LINE:600
    def validateGpkd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.validateGpkd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateGpkd"})
        }
      """
    )
  
    // @LINE:591
    def infoAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.infoAccountCmp",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/infoAccountCmp/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:588
    def getListAccountCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.getListAccountCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListAccountCmp"})
        }
      """
    )
  
    // @LINE:590
    def addAccountCmpV2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoRoleAccountController.addAccountCmpV2",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addAccountCmpV2"})
        }
      """
    )
  
  }

  // @LINE:144
  class ReverseWidgetListController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:146
    def getWidgetCurrent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WidgetListController.getWidgetCurrent",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getWidgetCurrent"})
        }
      """
    )
  
    // @LINE:145
    def saveWidgetData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WidgetListController.saveWidgetData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveWidgetData"})
        }
      """
    )
  
    // @LINE:144
    def widgetPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WidgetListController.widgetPage",
      """
        function(id0,idDashboard1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "widgetPage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("idDashboard", idDashboard1))})
        }
      """
    )
  
  }

  // @LINE:446
  class ReverseMarketPlaceContactController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:446
    def productContactList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceContactController.productContactList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "productContactList"})
        }
      """
    )
  
    // @LINE:448
    def sendContactMarket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceContactController.sendContactMarket",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendContactMarket"})
        }
      """
    )
  
    // @LINE:447
    def productContactFilterList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceContactController.productContactFilterList",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "productContactList"})
        }
      """
    )
  
    // @LINE:449
    def editContactMarket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceContactController.editContactMarket",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editContactMarket"})
        }
      """
    )
  
  }

  // @LINE:672
  class ReverseTelcoStatisticalReportController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:675
    def getExpiratedPackages: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoStatisticalReportController.getExpiratedPackages",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/report/getExpiratedPackages"})
        }
      """
    )
  
    // @LINE:673
    def getRedBarings: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoStatisticalReportController.getRedBarings",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/report/getRedBarings"})
        }
      """
    )
  
    // @LINE:672
    def RedBaring: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoStatisticalReportController.RedBaring",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/report/subscriberBanned/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:674
    def ExpiratedPackage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoStatisticalReportController.ExpiratedPackage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/report/pakageTime/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:361
  class ReverseOAuthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:361
    def getLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuthController.getLogin",
      """
        function(login_challenge0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "oauth/login" + _qS([(login_challenge0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("login_challenge", login_challenge0))])})
        }
      """
    )
  
    // @LINE:365
    def callback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuthController.callback",
      """
        function(code0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "oauth/callback" + _qS([(code0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("code", code0))])})
        }
      """
    )
  
    // @LINE:364
    def postConsent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuthController.postConsent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "oauth/consent"})
        }
      """
    )
  
    // @LINE:363
    def getConsent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuthController.getConsent",
      """
        function(consent_challenge0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "oauth/consent" + _qS([(consent_challenge0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("consent_challenge", consent_challenge0))])})
        }
      """
    )
  
    // @LINE:362
    def postLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuthController.postLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "oauth/login"})
        }
      """
    )
  
  }

  // @LINE:455
  class ReverseUserTenantListController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:461
    def updateRoleUserPermission: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.updateRoleUserPermission",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRoleUserPermission"})
        }
      """
    )
  
    // @LINE:456
    def getListUserTenant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.getListUserTenant",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListUserTenant"})
        }
      """
    )
  
    // @LINE:457
    def createUserTenant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.createUserTenant",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createUserTenant"})
        }
      """
    )
  
    // @LINE:459
    def editUserTenant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.editUserTenant",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editUserTenant"})
        }
      """
    )
  
    // @LINE:458
    def delUserTenant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.delUserTenant",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delUserTenant"})
        }
      """
    )
  
    // @LINE:462
    def delRoleUserPermission: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.delRoleUserPermission",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delRoleUserPermission"})
        }
      """
    )
  
    // @LINE:455
    def userTenantList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.userTenantList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userTenantList"})
        }
      """
    )
  
    // @LINE:460
    def getListRoleOfOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTenantListController.getListRoleOfOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListRoleOfOrg"})
        }
      """
    )
  
  }

  // @LINE:330
  class ReverseManageSimController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:330
    def manageSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ManageSimController.manageSim",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "manageSim/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:331
    def getDataCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ManageSimController.getDataCustomer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataCustomer"})
        }
      """
    )
  
    // @LINE:332
    def detailSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ManageSimController.detailSim",
      """
        function(projectId0,simnb1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detailSim/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("projectId", projectId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("simnb", simnb1))})
        }
      """
    )
  
  }

  // @LINE:510
  class ReverseTelcoAccountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:517
    def getListArea: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.getListArea",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListArea"})
        }
      """
    )
  
    // @LINE:514
    def getInfoAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.getInfoAccount",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoAccount"})
        }
      """
    )
  
    // @LINE:518
    def getInfoGpkdApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.getInfoGpkdApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoGpkdApproved"})
        }
      """
    )
  
    // @LINE:520
    def updateCategoryBusinessAndDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.updateCategoryBusinessAndDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateCategoryBusinessAndDevice"})
        }
      """
    )
  
    // @LINE:519
    def getCategoryBusinessAndDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.getCategoryBusinessAndDevice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCategoryBusinessAndDevice"})
        }
      """
    )
  
    // @LINE:516
    def getInfoCompanyEnterpriseLv2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.getInfoCompanyEnterpriseLv2",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoCompanyEnterprise"})
        }
      """
    )
  
    // @LINE:511
    def updateDetailAccountTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.updateDetailAccountTelco",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateAccountInfo"})
        }
      """
    )
  
    // @LINE:510
    def accountInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.accountInfo",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/accountInfo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:515
    def getInfoCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.getInfoCompany",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoCompany"})
        }
      """
    )
  
    // @LINE:512
    def updateInfoCompanyTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.updateInfoCompanyTelco",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateInfoCompanyTelco"})
        }
      """
    )
  
    // @LINE:513
    def deleteInfoCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAccountController.deleteInfoCompany",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteInfoCompany"})
        }
      """
    )
  
  }

  // @LINE:81
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:83
    def getTokenSendPassUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getTokenSendPassUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getTokenSendPassUser"})
        }
      """
    )
  
    // @LINE:85
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.deleteUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser"})
        }
      """
    )
  
    // @LINE:87
    def updateUserOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUserOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateUserOrg"})
        }
      """
    )
  
    // @LINE:81
    def userList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.userList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userList"})
        }
      """
    )
  
    // @LINE:84
    def editUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.editUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editUser"})
        }
      """
    )
  
    // @LINE:86
    def addRoleForUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addRoleForUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUserRole"})
        }
      """
    )
  
    // @LINE:82
    def addNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addNewUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewUser"})
        }
      """
    )
  
  }

  // @LINE:227
  class ReverseGroupController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:241
    def getListOrganizations: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getListOrganizations",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListOrganizations/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:238
    def updateRoleToGroupUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.updateRoleToGroupUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRoleToGroupUser"})
        }
      """
    )
  
    // @LINE:239
    def updateUserToGroupDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.updateUserToGroupDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateUserToGroupDevice"})
        }
      """
    )
  
    // @LINE:242
    def processMoveUserToGroupOther: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.processMoveUserToGroupOther",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processMoveUserToGroupOther"})
        }
      """
    )
  
    // @LINE:243
    def processMoveDeviceToGroupOther: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.processMoveDeviceToGroupOther",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "processMoveDeviceToGroupOther"})
        }
      """
    )
  
    // @LINE:230
    def getGroupChildByGroupId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getGroupChildByGroupId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getChildByGroupId"})
        }
      """
    )
  
    // @LINE:236
    def updateGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.updateGroup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateOrg"})
        }
      """
    )
  
    // @LINE:229
    def getAttributeOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getAttributeOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAttributeOrg"})
        }
      """
    )
  
    // @LINE:244
    def createUserInOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.createUserInOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createUserInOrg"})
        }
      """
    )
  
    // @LINE:231
    def getListGroupOfOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getListGroupOfOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroupOfOrg"})
        }
      """
    )
  
    // @LINE:227
    def orgList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.orgList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orgList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:237
    def deleteGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.deleteGroup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteOrg"})
        }
      """
    )
  
    // @LINE:234
    def getListEventOfOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getListEventOfOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListEventOfOrg"})
        }
      """
    )
  
    // @LINE:245
    def updateRoleForUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.updateRoleForUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRoleForUser"})
        }
      """
    )
  
    // @LINE:233
    def getListDeviceOfOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getListDeviceOfOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceOfOrg"})
        }
      """
    )
  
    // @LINE:232
    def getListUserOfOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getListUserOfOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListUserOfOrg"})
        }
      """
    )
  
    // @LINE:228
    def getInfoOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getInfoOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoOrg"})
        }
      """
    )
  
    // @LINE:240
    def addGroupRoot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.addGroupRoot",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addGroupRoot"})
        }
      """
    )
  
    // @LINE:235
    def getListRoleOfOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getListRoleOfOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListRoleOfOrg"})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def pageSuccess: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.pageSuccess",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pageSuccess"})
        }
      """
    )
  
    // @LINE:51
    def cancel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.cancel",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cancel"})
        }
      """
    )
  
    // @LINE:261
    def pageTestApi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.pageTestApi",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pageTestApi"})
        }
      """
    )
  
    // @LINE:262
    def testPostFormUrlencoded: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.testPostFormUrlencoded",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "testPostFormUrlencoded"})
        }
      """
    )
  
    // @LINE:34
    def termsOfUse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.termsOfUse",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "termsOfUse"})
        }
      """
    )
  
    // @LINE:49
    def getImg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getImg",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getImg/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:50
    def success: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.success",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "success"})
        }
      """
    )
  
    // @LINE:263
    def testPostJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.testPostJson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "testPostJson"})
        }
      """
    )
  
    // @LINE:264
    def testGetByToken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.testGetByToken",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "testGetByToken"})
        }
      """
    )
  
    // @LINE:52
    def provision: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.provision",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "provision"})
        }
      """
    )
  
    // @LINE:266
    def getDashboardByProjectId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getDashboardByProjectId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDashboardByProjectId"})
        }
      """
    )
  
    // @LINE:265
    def getDashboardByIdOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getDashboardByIdOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDashboardByIdOrg"})
        }
      """
    )
  
  }

  // @LINE:577
  class ReverseTelcoInvoiceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:579
    def getLinkDownloadInvoice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoInvoiceController.getLinkDownloadInvoice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLinkDownloadInvoice"})
        }
      """
    )
  
    // @LINE:578
    def getListInvoiceOfContract: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoInvoiceController.getListInvoiceOfContract",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListInvoiceOfContract"})
        }
      """
    )
  
    // @LINE:577
    def invoiceOfContract: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoInvoiceController.invoiceOfContract",
      """
        function(userId0,invoice1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "invoiceOfContract/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("invoice", invoice1))})
        }
      """
    )
  
  }

  // @LINE:663
  class ReverseTelcoLocationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:663
    def telcoLocation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLocationController.telcoLocation",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telcoLocation/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:664
    def searchByIsdn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLocationController.searchByIsdn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "searchByIsdn"})
        }
      """
    )
  
  }

  // @LINE:73
  class ReverseOverviewController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:79
    def countDataSuccessRate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.countDataSuccessRate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "countDataSuccessRate"})
        }
      """
    )
  
    // @LINE:75
    def countDevice7Day: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.countDevice7Day",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "countDevice7Day/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:73
    def overview: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.overview",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "overview/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:78
    def countDataLatency: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.countDataLatency",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "countDataLatency"})
        }
      """
    )
  
    // @LINE:76
    def countUser7Day: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.countUser7Day",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "countUser7Day/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:74
    def countDeviceAndUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.countDeviceAndUser",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "countDeviceAndUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:77
    def countMess7Day: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OverviewController.countMess7Day",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "countMess7Day/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:318
  class ReversePayBillController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:320
    def getLinkPayment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayBillController.getLinkPayment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLinkPayment"})
        }
      """
    )
  
    // @LINE:321
    def getInfoBill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayBillController.getInfoBill",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoBill"})
        }
      """
    )
  
    // @LINE:322
    def billUserList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayBillController.billUserList",
      """
        function(id0,userId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "billUserList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId1))})
        }
      """
    )
  
    // @LINE:318
    def billList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayBillController.billList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "billList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:323
    def getBillOfUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayBillController.getBillOfUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getBillOfUser"})
        }
      """
    )
  
    // @LINE:319
    def getAllBill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PayBillController.getAllBill",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllBill"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def createAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.createAccount",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createAccount"})
        }
      """
    )
  
    // @LINE:29
    def ForgetPassword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ForgetPassword",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ForgetPassword"})
        }
      """
    )
  
    // @LINE:33
    def version: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.version",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "version"})
        }
      """
    )
  
    // @LINE:19
    def verifyPhone: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.verifyPhone",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "verifyPhone"})
        }
      """
    )
  
    // @LINE:13
    def authenticateDemo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.authenticateDemo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loginDemo"})
        }
      """
    )
  
    // @LINE:27
    def forgotPassPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.forgotPassPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "password"})
        }
      """
    )
  
    // @LINE:20
    def ChangePass: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ChangePass",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ChangePass"})
        }
      """
    )
  
    // @LINE:32
    def getOtpPhone: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getOtpPhone",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getOtpPhone"})
        }
      """
    )
  
    // @LINE:23
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:31
    def getOtpEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getOtpEmail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getOtpEmail"})
        }
      """
    )
  
    // @LINE:24
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.register",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:15
    def setLang: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.setLang",
      """
        function(lang0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lang/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("lang", lang0))})
        }
      """
    )
  
    // @LINE:18
    def checkIpLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.checkIpLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "checkIpLogin"})
        }
      """
    )
  
    // @LINE:22
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:26
    def newRegisterPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.newRegisterPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "newRegisterPost"})
        }
      """
    )
  
    // @LINE:36
    def sitemap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sitemap",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "innoway-sitemap.xml"})
        }
      """
    )
  
    // @LINE:12
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:28
  class ReverseFogotPassController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def userGetCodeChangePass: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FogotPassController.userGetCodeChangePass",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userGetCodeChangePass"})
        }
      """
    )
  
    // @LINE:30
    def ChangePassword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FogotPassController.ChangePassword",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ChangePassword"})
        }
      """
    )
  
  }

  // @LINE:388
  class ReverseAdminOverviewController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:389
    def getTotalOverview: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.getTotalOverview",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getTotalOverview"})
        }
      """
    )
  
    // @LINE:392
    def getInfoOVerviewVtag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.getInfoOVerviewVtag",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoOVerviewVtag"})
        }
      """
    )
  
    // @LINE:394
    def getInfoOVerviewMetter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.getInfoOVerviewMetter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoOVerviewMetter"})
        }
      """
    )
  
    // @LINE:390
    def postJsonTotalOverview: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.postJsonTotalOverview",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "postJsonTotalOverview"})
        }
      """
    )
  
    // @LINE:393
    def getInfoOVerviewFleet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.getInfoOVerviewFleet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoOVerviewFleet"})
        }
      """
    )
  
    // @LINE:391
    def getInfoOVerviewSmarthome: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.getInfoOVerviewSmarthome",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoOVerviewSmarthome"})
        }
      """
    )
  
    // @LINE:388
    def adminOverview: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.adminOverview",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminOverview"})
        }
      """
    )
  
    // @LINE:395
    def getListProjectWithPaging: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminOverviewController.getListProjectWithPaging",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListProjectWithPaging"})
        }
      """
    )
  
  }

  // @LINE:337
  class ReverseModuleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:337
    def module: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ModuleController.module",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "module/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:348
  class ReverseQrCodeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:352
    def deleteQrCode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.deleteQrCode",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteQrCode"})
        }
      """
    )
  
    // @LINE:351
    def getListQrCode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.getListQrCode",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListQrCode"})
        }
      """
    )
  
    // @LINE:349
    def createQrCode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.createQrCode",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createQrCode"})
        }
      """
    )
  
    // @LINE:354
    def editQrCode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.editQrCode",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editQrCode"})
        }
      """
    )
  
    // @LINE:348
    def qrCodeList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.qrCodeList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "qrCodeList"})
        }
      """
    )
  
    // @LINE:353
    def qrCodeHistoryList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.qrCodeHistoryList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "qrCodeHistoryList"})
        }
      """
    )
  
    // @LINE:350
    def qrCodeImg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QrCodeController.qrCodeImg",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "qrCodeImg/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:432
  class ReverseMarketPlaceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:436
    def getAllProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getAllProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllProduct"})
        }
      """
    )
  
    // @LINE:439
    def getAllGroupDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getAllGroupDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllGroupDevice"})
        }
      """
    )
  
    // @LINE:435
    def getProductMarket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getProductMarket",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getProductMarket"})
        }
      """
    )
  
    // @LINE:438
    def getAllGroupSolution: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getAllGroupSolution",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllGroupSolution"})
        }
      """
    )
  
    // @LINE:437
    def getAllGroupProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getAllGroupProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllGroupProduct"})
        }
      """
    )
  
    // @LINE:432
    def marketPlace: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.marketPlace",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "marketPlace"})
        }
      """
    )
  
    // @LINE:433
    def marketPlaceSolution: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.marketPlaceSolution",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "marketPlace/solution"})
        }
      """
    )
  
    // @LINE:441
    def getAllDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getAllDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllDevice"})
        }
      """
    )
  
    // @LINE:440
    def getAllSolution: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getAllSolution",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllSolution"})
        }
      """
    )
  
    // @LINE:443
    def getDetailProductWithId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getDetailProductWithId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDetailProductWithId"})
        }
      """
    )
  
    // @LINE:442
    def detailProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.detailProduct",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "marketPlace/product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:444
    def getSameProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.getSameProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getSameProduct"})
        }
      """
    )
  
    // @LINE:434
    def marketPlaceDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MarketPlaceController.marketPlaceDevice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "marketPlace/device"})
        }
      """
    )
  
  }

  // @LINE:191
  class ReverseMessagesDeviceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:197
    def sendMessageData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.sendMessageData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessageData"})
        }
      """
    )
  
    // @LINE:196
    def postCreateDeviceToken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.postCreateDeviceToken",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "postCreateDeviceToken"})
        }
      """
    )
  
    // @LINE:195
    def getMessageFormDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.getMessageFormDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getMessageFormDevice"})
        }
      """
    )
  
    // @LINE:199
    def sendMessageOnOffApp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.sendMessageOnOffApp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessageOnOffApp"})
        }
      """
    )
  
    // @LINE:192
    def getMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.getMetadata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getMetadata"})
        }
      """
    )
  
    // @LINE:193
    def sendMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.sendMetadata",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMetadata"})
        }
      """
    )
  
    // @LINE:198
    def sendMessageOnOff: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.sendMessageOnOff",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessageOnOff"})
        }
      """
    )
  
    // @LINE:194
    def sendMessageToDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.sendMessageToDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessageToDevice"})
        }
      """
    )
  
    // @LINE:191
    def messagesDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.messagesDevice",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messagesDevice/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:200
    def sendCommandRPC: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesDeviceController.sendCommandRPC",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendCommandRPC"})
        }
      """
    )
  
  }

  // @LINE:369
  class ReverseSolutionTrackingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:372
    def historyMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SolutionTrackingController.historyMap",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "historyMap/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:373
    def loadLocationHistory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SolutionTrackingController.loadLocationHistory",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "loadLocationHistory"})
        }
      """
    )
  
    // @LINE:369
    def monitorMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SolutionTrackingController.monitorMap",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "monitorMap/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:371
    def getInfoDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SolutionTrackingController.getInfoDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoDevice"})
        }
      """
    )
  
    // @LINE:370
    def getListGpsDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SolutionTrackingController.getListGpsDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGpsDevice"})
        }
      """
    )
  
  }

  // @LINE:149
  class ReverseDeviceIotController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:150
    def addNewDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.addNewDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewDevice"})
        }
      """
    )
  
    // @LINE:160
    def getListDeviceByOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getListDeviceByOrg",
      """
        function(id0,projectId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceByOrg/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("projectId", projectId1))})
        }
      """
    )
  
    // @LINE:155
    def configGpsDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.configGpsDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "configGpsDevice"})
        }
      """
    )
  
    // @LINE:152
    def deleteDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.deleteDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDevice"})
        }
      """
    )
  
    // @LINE:153
    def editNameDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.editNameDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editNameDevice"})
        }
      """
    )
  
    // @LINE:162
    def getListDeviceByDeviceType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getListDeviceByDeviceType",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceByDeviceType/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:159
    def getListDeviceVarsByDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getListDeviceVarsByDevice",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceVarByDevice/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:156
    def getConfigOfDeviceIot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getConfigOfDeviceIot",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getConfigOfDeviceIot/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:154
    def updateDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.updateDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateDevice"})
        }
      """
    )
  
    // @LINE:158
    def getListDeviceByGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getListDeviceByGroup",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceByGroup/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:151
    def createDeviceWithSerialSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.createDeviceWithSerialSim",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createDeviceWithSerialSim"})
        }
      """
    )
  
    // @LINE:149
    def deviceIotList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.deviceIotList",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deviceIotList/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:161
    def getListDeviceAndAttrByOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getListDeviceAndAttrByOrg",
      """
        function(id0,projectId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceAndAttrByOrg/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("projectId", projectId1))})
        }
      """
    )
  
    // @LINE:157
    def getListDeviceIot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceIotController.getListDeviceIot",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceIot"})
        }
      """
    )
  
  }

  // @LINE:627
  class ReverseTelcoChildUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:630
    def getRolesOfChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.getRolesOfChildUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getRolesOfChildUser"})
        }
      """
    )
  
    // @LINE:632
    def childUserDetail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.childUserDetail",
      """
        function(userId0,childUserId1,email2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "childUserDetail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("childUserId", childUserId1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email2))})
        }
      """
    )
  
    // @LINE:637
    def removeSubOfChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.removeSubOfChildUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "removeSubOfChildUser"})
        }
      """
    )
  
    // @LINE:627
    def listChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.listChildUser",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/listChildUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:636
    def validateSubToChildUser1: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.validateSubToChildUser1",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateSubToChildUser1"})
        }
      """
    )
  
    // @LINE:628
    def getListChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.getListChildUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListChildUser"})
        }
      """
    )
  
    // @LINE:635
    def addSubToChildUser1: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.addSubToChildUser1",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addSubToChildUser1"})
        }
      """
    )
  
    // @LINE:631
    def updateRolesOfChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.updateRolesOfChildUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRolesOfChildUser"})
        }
      """
    )
  
    // @LINE:633
    def getListSubsOfChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.getListSubsOfChildUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListSubsOfChildUser"})
        }
      """
    )
  
    // @LINE:629
    def addChildUserCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.addChildUserCmp",
      """
        function(userId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addChildUserCmp/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:634
    def addSubToChildUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoChildUserController.addSubToChildUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addSubToChildUser"})
        }
      """
    )
  
  }

  // @LINE:658
  class ReverseTelcoAepController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:660
    def requestDataAepGps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAepController.requestDataAepGps",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "requestDataAepGps"})
        }
      """
    )
  
    // @LINE:659
    def requestDataAepWeather: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAepController.requestDataAepWeather",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "requestDataAepWeather"})
        }
      """
    )
  
    // @LINE:658
    def aepUtilities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoAepController.aepUtilities",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "aepUtilities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:115
  class ReverseDashboardWidgetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:118
    def getHistoryRpc: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardWidgetController.getHistoryRpc",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getHistoryRpc"})
        }
      """
    )
  
    // @LINE:116
    def getListDeviceWithWidgetMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardWidgetController.getListDeviceWithWidgetMap",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceWithWidgetMap"})
        }
      """
    )
  
    // @LINE:117
    def getDeviceDataCurrent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardWidgetController.getDeviceDataCurrent",
      """
        function(deviceId0,latId1,longId2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getDeviceDataCurrent" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("deviceId", deviceId0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("latId", latId1), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("longId", longId2)])})
        }
      """
    )
  
    // @LINE:115
    def dashboardVer2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardWidgetController.dashboardVer2",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboardVer2/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:214
  class ReverseDeviceTemplateController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:214
    def deviceTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTemplateController.deviceTemplate",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deviceTemplate/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:218
    def createTemDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTemplateController.createTemDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createTemDevice"})
        }
      """
    )
  
    // @LINE:215
    def createDeviceTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTemplateController.createDeviceTemplate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createDeviceTemplate"})
        }
      """
    )
  
    // @LINE:217
    def deleteDeviceTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTemplateController.deleteDeviceTemplate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDeviceTemplate"})
        }
      """
    )
  
    // @LINE:216
    def getListDeviceTemplate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceTemplateController.getListDeviceTemplate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceTemplate"})
        }
      """
    )
  
  }

  // @LINE:397
  class ReverseAdminManageSimController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:399
    def getListDeviceWithProjectId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminManageSimController.getListDeviceWithProjectId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListDeviceWithProjectId"})
        }
      """
    )
  
    // @LINE:400
    def getAttrSimDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminManageSimController.getAttrSimDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAttrSimDevice"})
        }
      """
    )
  
    // @LINE:397
    def adminManageSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminManageSimController.adminManageSim",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminManageSim"})
        }
      """
    )
  
    // @LINE:398
    def getAllProjectWithPaging: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminManageSimController.getAllProjectWithPaging",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllProjectWithPaging"})
        }
      """
    )
  
  }

  // @LINE:248
  class ReverseGroupListController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:258
    def getListGroupOrganization: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.getListGroupOrganization",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroupOrganization"})
        }
      """
    )
  
    // @LINE:257
    def getListGroupEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.getListGroupEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroupEvent"})
        }
      """
    )
  
    // @LINE:254
    def getGroupWithEntityType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.getGroupWithEntityType",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getGroupWithEntityType"})
        }
      """
    )
  
    // @LINE:249
    def addNewGroups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.addNewGroups",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNewGroups"})
        }
      """
    )
  
    // @LINE:256
    def getListGroupDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.getListGroupDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroupDevice"})
        }
      """
    )
  
    // @LINE:252
    def updateOrgIdForGroups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.updateOrgIdForGroups",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateOrgIdForGroups"})
        }
      """
    )
  
    // @LINE:255
    def getListGroupUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.getListGroupUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroupUser"})
        }
      """
    )
  
    // @LINE:251
    def editNameGroups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.editNameGroups",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editNameGroups"})
        }
      """
    )
  
    // @LINE:248
    def groupsList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.groupsList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "groupsList"})
        }
      """
    )
  
    // @LINE:250
    def deleteGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.deleteGroup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteGroup"})
        }
      """
    )
  
    // @LINE:253
    def getListGroups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupListController.getListGroups",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroups"})
        }
      """
    )
  
  }

  // @LINE:582
  class ReverseTelcoApiKeyController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:583
    def getListApiKey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoApiKeyController.getListApiKey",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListApiKey"})
        }
      """
    )
  
    // @LINE:582
    def apiKeyManage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoApiKeyController.apiKeyManage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/apiKey/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:667
  class ReverseInvoiceManagerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:668
    def getInvoices: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InvoiceManagerController.getInvoices",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/getInvoices"})
        }
      """
    )
  
    // @LINE:667
    def invoiceManage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InvoiceManagerController.invoiceManage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/invoiceManage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:669
    def getInvoiceBase64: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InvoiceManagerController.getInvoiceBase64",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/getInvoiceBase64"})
        }
      """
    )
  
  }

  // @LINE:492
  class ReverseTelcoLogController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:652
    def deleteSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.deleteSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSurvey"})
        }
      """
    )
  
    // @LINE:647
    def getLogListCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.getLogListCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLogListCmp"})
        }
      """
    )
  
    // @LINE:655
    def saveFormCustomerSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.saveFormCustomerSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveFormCustomerSurvey"})
        }
      """
    )
  
    // @LINE:651
    def editSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.editSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editSurvey"})
        }
      """
    )
  
    // @LINE:492
    def logConnectSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.logConnectSim",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logConnectSim/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:650
    def getLogListCustomerSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.getLogListCustomerSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLogListCustomerSurvey"})
        }
      """
    )
  
    // @LINE:649
    def logCustomerSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.logCustomerSurvey",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logCustomerSurvey"})
        }
      """
    )
  
    // @LINE:493
    def getLogConnectSim: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.getLogConnectSim",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getLogConnectSim"})
        }
      """
    )
  
    // @LINE:646
    def logCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.logCmp",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logCmp"})
        }
      """
    )
  
    // @LINE:654
    def exportLogCustomerSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.exportLogCustomerSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "exportLogCustomerSurvey"})
        }
      """
    )
  
    // @LINE:648
    def updateFormCustomerSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.updateFormCustomerSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateFormCustomerSurvey"})
        }
      """
    )
  
    // @LINE:653
    def getInfoSurvey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoLogController.getInfoSurvey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoSurvey"})
        }
      """
    )
  
  }

  // @LINE:407
  class ReverseAdminRegisterDeveloperController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:409
    def exportRegisterDeveloperList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminRegisterDeveloperController.exportRegisterDeveloperList",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "exportRegisterDeveloperList"})
        }
      """
    )
  
    // @LINE:410
    def deleteRegisterDeveloper: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminRegisterDeveloperController.deleteRegisterDeveloper",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteRegisterDeveloper"})
        }
      """
    )
  
    // @LINE:407
    def registerDeveloperList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminRegisterDeveloperController.registerDeveloperList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registerDeveloperList"})
        }
      """
    )
  
    // @LINE:408
    def registerDeveloperFilterList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminRegisterDeveloperController.registerDeveloperFilterList",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registerDeveloperList"})
        }
      """
    )
  
  }

  // @LINE:100
  class ReverseSendApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:100
    def getDataWithParam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SendApiController.getDataWithParam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataWithParam"})
        }
      """
    )
  
    // @LINE:102
    def putDataWithParam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SendApiController.putDataWithParam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "putDataWithParam"})
        }
      """
    )
  
    // @LINE:104
    def deleteDataWithParam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SendApiController.deleteDataWithParam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDataWithParam"})
        }
      """
    )
  
    // @LINE:101
    def portDataWithParam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SendApiController.portDataWithParam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "portDataWithParam"})
        }
      """
    )
  
    // @LINE:103
    def upfileImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SendApiController.upfileImage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "upfileImage"})
        }
      """
    )
  
  }

  // @LINE:132
  class ReverseTelcoDeviceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:132
    def deviceManage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoDeviceController.deviceManage",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "telco/deviceManage/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:175
  class ReverseDeviceVariableController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:176
    def addVariable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceVariableController.addVariable",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addVariable"})
        }
      """
    )
  
    // @LINE:178
    def getDataVariableById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceVariableController.getDataVariableById",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getDataVariableById"})
        }
      """
    )
  
    // @LINE:179
    def getListVarByIdDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceVariableController.getListVarByIdDevice",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListVarByIdDevice/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:177
    def delVariable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceVariableController.delVariable",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delVariable"})
        }
      """
    )
  
    // @LINE:175
    def deviceVariable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DeviceVariableController.deviceVariable",
      """
        function(projectId0,id1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deviceVariable/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("projectId", projectId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id1))})
        }
      """
    )
  
  }

  // @LINE:413
  class ReverseAdminGroupProductController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:414
    def getListGroupProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminGroupProductController.getListGroupProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGroupProduct"})
        }
      """
    )
  
    // @LINE:415
    def addGroupProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminGroupProductController.addGroupProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addGroupProduct"})
        }
      """
    )
  
    // @LINE:416
    def deleteGroupProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminGroupProductController.deleteGroupProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteGroupProduct"})
        }
      """
    )
  
    // @LINE:417
    def editGroupProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminGroupProductController.editGroupProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editGroupProduct"})
        }
      """
    )
  
    // @LINE:413
    def groupProductList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminGroupProductController.groupProductList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "groupProductList"})
        }
      """
    )
  
  }

  // @LINE:4
  class ReverseLandingPageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getListProductOfferPack: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.getListProductOfferPack",
      """
        function(offerType0,payType1,category2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getListProductOfferPack" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("offerType", offerType0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("payType", payType1), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("category", category2)])})
        }
      """
    )
  
    // @LINE:7
    def submitFormContactTelco: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.submitFormContactTelco",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitFormContactTelco"})
        }
      """
    )
  
    // @LINE:9
    def submitFormContact: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.submitFormContact",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitFormContact"})
        }
      """
    )
  
    // @LINE:11
    def registerDeveloper: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.registerDeveloper",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registerDeveloper"})
        }
      """
    )
  
    // @LINE:6
    def landingPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.landingPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "landingPage"})
        }
      """
    )
  
    // @LINE:10
    def submitRegisterDeveloper: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.submitRegisterDeveloper",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitRegisterDeveloper"})
        }
      """
    )
  
    // @LINE:4
    def home: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LandingPageController.home",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:605
  class ReverseTelcoQrcodeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:605
    def qrcodeList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.qrcodeList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "qrcodeList"})
        }
      """
    )
  
    // @LINE:612
    def getInfoConnectSubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.getInfoConnectSubs",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getInfoConnectSubs"})
        }
      """
    )
  
    // @LINE:608
    def getListGpkd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.getListGpkd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListGpkd"})
        }
      """
    )
  
    // @LINE:607
    def checkValidateSerialAdm1: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.checkValidateSerialAdm1",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "checkValidateSerialAdm1"})
        }
      """
    )
  
    // @LINE:610
    def createQrcode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.createQrcode",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createQrcode"})
        }
      """
    )
  
    // @LINE:606
    def getListQrcodeCmp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.getListQrcodeCmp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getListQrcodeCmp"})
        }
      """
    )
  
    // @LINE:611
    def qrCodeConnect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.qrCodeConnect",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "provisioning/qr/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:613
    def paymentConnectSubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.paymentConnectSubs",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paymentConnectSubs"})
        }
      """
    )
  
    // @LINE:609
    def saveFileChungTu: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.saveFileChungTu",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveFileChungTu"})
        }
      """
    )
  
    // @LINE:614
    def delQrcodeById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TelcoQrcodeController.delQrcodeById",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delQrcodeById"})
        }
      """
    )
  
  }


}
