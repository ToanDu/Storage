
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/VHT_Projects/cmp-fe-dev-dev_multiLang/conf/routes
// @DATE:Mon Sep 22 16:32:39 ICT 2025

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:4
package controllers {

  // @LINE:451
  class ReverseMarketPlaceCommentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:452
    def getListCommentProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListCommentProduct")
    }
  
    // @LINE:451
    def commentWithProductId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "commentWithProductId")
    }
  
  }

  // @LINE:376
  class ReverseWaterClockController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:377
    def getListClock(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListClock")
    }
  
    // @LINE:376
    def waterClock(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "waterClock")
    }
  
    // @LINE:378
    def getHistoryClock(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryClock")
    }
  
  }

  // @LINE:335
  class ReverseDevkitController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:335
    def devkit(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "devkit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:554
  class ReverseTelcoUtilitiesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:567
    def prepayCharges(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "prepayCharges" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("userId", userId)))))
    }
  
    // @LINE:563
    def rechargeSubcriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "rechargeSubcriber")
    }
  
    // @LINE:566
    def validateSubs(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateSubs")
    }
  
    // @LINE:569
    def getDataPrepaidInfo(prom_code:String, product_code:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getDataPrepaidInfo" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("prom_code", prom_code)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("product_code", product_code)))))
    }
  
    // @LINE:557
    def utilitiesBuyPackage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/utilitiesBuyPackage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:564
    def getListOrderIdByAction(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListOrderIdByAction")
    }
  
    // @LINE:571
    def getHistoryPrepayCharges(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryPrepayCharges")
    }
  
    // @LINE:575
    def getHistoryPayPostBill(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryPayPostBill")
    }
  
    // @LINE:555
    def utilitiesTopup(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/utilitiesTopup/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:556
    def utilitiesBlock(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/utilitiesBlock/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:554
    def utilitiesManage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/utilitiesManage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:572
    def payPostpaidBill(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/payPostpaidBill/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:573
    def payDebit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "payDebit")
    }
  
    // @LINE:574
    def payPostpaidBillDetail(userId:String, orderId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/payPostpaidBill/detail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("orderId", orderId)))
    }
  
    // @LINE:560
    def unregisterMiAddon(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "unregisterMiAddon")
    }
  
    // @LINE:558
    def getListPackMiAndAddOn(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListPackMiAndAddOn")
    }
  
    // @LINE:562
    def getInfoOrderId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoOrderId")
    }
  
    // @LINE:570
    def rechargePrepaid(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "rechargePrepaid")
    }
  
    // @LINE:565
    def getHistoryBlockUnblock(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryBlockUnblock")
    }
  
    // @LINE:561
    def unextendMiAddon(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "unextendMiAddon")
    }
  
    // @LINE:568
    def prepayChargesBill(userId:String, isdn:String, orderId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "prepayCharges/bill/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("isdn", isdn)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("orderId", orderId)))
    }
  
    // @LINE:559
    def registerMiAddon(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "registerMiAddon")
    }
  
  }

  // @LINE:37
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:37
        case (file) if file == "sitemap.xml" =>
          implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"), ("file", "sitemap.xml")))
          Call("GET", _prefix + { _defaultPrefix } + "sitemap.xml")
      
        // @LINE:38
        case (file) if file == "sitemap_index.xml" =>
          implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"), ("file", "sitemap_index.xml")))
          Call("GET", _prefix + { _defaultPrefix } + "sitemap_index.xml")
      
        // @LINE:39
        case (file) if file == "robots.txt" =>
          implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"), ("file", "robots.txt")))
          Call("GET", _prefix + { _defaultPrefix } + "robots.txt")
      
        // @LINE:40
        case (file) if file == "dieu-khoan.txt" =>
          implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"), ("file", "dieu-khoan.txt")))
          Call("GET", _prefix + { _defaultPrefix } + "dieu-khoan.txt")
      
        // @LINE:90
        case (file) if file == "health.html" =>
          implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"), ("file", "health.html")))
          Call("GET", _prefix + { _defaultPrefix } + "healthCheck")
      
      }
    
    }
  
    // @LINE:42
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:292
  class ReverseRuleChainController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:293
    def flowEngineWithId(projectId:String, idFlow:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "flowEngineWithId/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("projectId", projectId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("idFlow", idFlow)))
    }
  
    // @LINE:292
    def ruleChain(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ruleEngine/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:203
  class ReverseLogDeviceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:203
    def logDeviceList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logDeviceList")
    }
  
    // @LINE:204
    def getAllLogMessage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllLogMessage")
    }
  
  }

  // @LINE:135
  class ReverseDashboardAppController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:141
    def sendMessageOnOffApp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessageOnOffApp")
    }
  
    // @LINE:138
    def getListDeviceWithWidgetMapApp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDeviceWithWidgetMapApp")
    }
  
    // @LINE:139
    def getDataAttributeByIdApp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataAttributeByIdApp")
    }
  
    // @LINE:136
    def getDashboardWithId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDashboardWithIdApp")
    }
  
    // @LINE:140
    def getLastValueAttributeApp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLastValueAttributeApp")
    }
  
    // @LINE:135
    def appDashboard(id:String, dashboardId:String, token:String, deviceId:String = null, deviceToken:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "appDashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("dashboardId", dashboardId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("token", token)) + play.core.routing.queryString(List(if(deviceId == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("deviceId", deviceId)), if(deviceToken == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("deviceToken", deviceToken)))))
    }
  
    // @LINE:137
    def getPositionDeviceByAttributeApp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getPositionDeviceByAttributeApp")
    }
  
  }

  // @LINE:617
  class ReverseTelcoHistoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:624
    def historyPostPaidBill(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyPostPaidBill/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:622
    def getHistoryPackMiAddon(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryPackMiAddon")
    }
  
    // @LINE:619
    def historyPrepayCharges(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyPrepayCharges/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:621
    def historyBlockUnblock(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyBlockUnblock/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:618
    def historyDeposit(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyDeposit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:617
    def historyPackMiAddon(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyPackMiAddon/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:623
    def getHistoryApn(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryAPN")
    }
  
    // @LINE:620
    def historyApn(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyAPN/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:56
  class ReverseDownloadPageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def download(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "download")
    }
  
  }

  // @LINE:340
  class ReverseAppDebugController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:343
    def appSdkPage(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "appSdkPage")
    }
  
    // @LINE:340
    def appDebug(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "appDebug/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:344
    def solutionMaketPage(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "solutionMaketPage")
    }
  
    // @LINE:341
    def appDebugPage(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "appDebugPage")
    }
  
    // @LINE:342
    def appSdk(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "appSdk/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:45
  class ReverseJsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:47
    def javascriptRoutes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "javascriptRoutes")
    }
  
    // @LINE:45
    def jsMessages(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messages.js")
    }
  
  }

  // @LINE:381
  class ReverseTemplateDeviceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:384
    def getTemplateDeviceById(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getTemplateDeviceById")
    }
  
    // @LINE:382
    def addTemplateDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addTemplateDevice")
    }
  
    // @LINE:385
    def editTemplateDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editTemplateDevice")
    }
  
    // @LINE:386
    def deleteTemplateDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteTemplateDeviceById")
    }
  
    // @LINE:383
    def getListTemplateDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListTemplateDevice")
    }
  
    // @LINE:381
    def templateDeviceList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "templateDeviceList")
    }
  
  }

  // @LINE:402
  class ReverseAdminSystemHealthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:402
    def systemHealth(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "systemHealth")
    }
  
  }

  // @LINE:276
  class ReverseEventController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:281
    def onclickEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "onclickEvent")
    }
  
    // @LINE:288
    def activeEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "activeEvent")
    }
  
    // @LINE:278
    def addNewSchedule(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewSchedule")
    }
  
    // @LINE:279
    def editEvent(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editEvent/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:276
    def eventList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "eventList")
    }
  
    // @LINE:277
    def addNewEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewEvent")
    }
  
    // @LINE:283
    def deleteEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteEvent")
    }
  
    // @LINE:289
    def deActiveEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deActiveEvent")
    }
  
    // @LINE:285
    def updateEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "UpdateEvent")
    }
  
    // @LINE:280
    def editSchedule(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editSchedule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:282
    def getVarsByDevice(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "variableList")
    }
  
    // @LINE:287
    def removeEventOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "removeEventOrg")
    }
  
    // @LINE:286
    def changeEventOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "changeEventOrg")
    }
  
    // @LINE:284
    def getEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "eventDetail")
    }
  
  }

  // @LINE:59
  class ReverseProjectController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:62
    def addProject(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addProject")
    }
  
    // @LINE:66
    def sendPostJsonProjectTemplate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendJsonProjectTemplate")
    }
  
    // @LINE:61
    def createProjectForm(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createProjectForm")
    }
  
    // @LINE:63
    def editProject(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editProject")
    }
  
    // @LINE:59
    def project(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "project")
    }
  
    // @LINE:68
    def createDashboardTemplate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createDashboardTemplate")
    }
  
    // @LINE:70
    def activePhone(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "activePhone")
    }
  
    // @LINE:64
    def delProject(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delProject")
    }
  
    // @LINE:65
    def getNameProject(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getNameProject/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:69
    def getListTag(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListTag")
    }
  
    // @LINE:67
    def sendPutJsonProjectTemplate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendPutJsonProjectTemplate")
    }
  
    // @LINE:60
    def getProject(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getProject")
    }
  
  }

  // @LINE:302
  class ReversePayCustomerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:302
    def getInfoVendor(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoVendor")
    }
  
    // @LINE:314
    def getInfoCustomer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoCustomer")
    }
  
    // @LINE:313
    def postPricingOfCustomer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "postPricingOfCustomer")
    }
  
    // @LINE:316
    def updateInfoCustomer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateInfoCustomer")
    }
  
    // @LINE:310
    def payment(id:String, userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:307
    def cancelSubscription(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "cancelSubscription")
    }
  
    // @LINE:304
    def updateVendor(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateVendor")
    }
  
    // @LINE:312
    def addPackdataNewForUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addPackdataNewForUser")
    }
  
    // @LINE:311
    def getListUserInOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListUserInOrg")
    }
  
    // @LINE:306
    def createSubscription(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createSubscription")
    }
  
    // @LINE:315
    def createInfoCustomer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createInfoCustomer")
    }
  
    // @LINE:305
    def getSubscription(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getSubscription")
    }
  
    // @LINE:303
    def createVendor(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createVendor")
    }
  
    // @LINE:309
    def payCustomer(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payCustomer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:419
  class ReverseProductListController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:424
    def editProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editProduct")
    }
  
    // @LINE:426
    def manageProductList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "manageProductList")
    }
  
    // @LINE:423
    def getProductById(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getProductById")
    }
  
    // @LINE:419
    def productList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "productList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:427
    def manageProductFilterList(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "manageProductList")
    }
  
    // @LINE:421
    def getProductByUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getProductByUser")
    }
  
    // @LINE:429
    def requestApproveProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "requestApproveProduct")
    }
  
    // @LINE:422
    def deleteProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteProduct")
    }
  
    // @LINE:428
    def changeStatusProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "changeStatusProduct")
    }
  
    // @LINE:420
    def createProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createProduct")
    }
  
  }

  // @LINE:207
  class ReverseDeviceTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:211
    def getListTypes(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListTypes")
    }
  
    // @LINE:209
    def deleteDeviceType(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteDeviceType")
    }
  
    // @LINE:208
    def addNewDeviceType(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewDeviceType")
    }
  
    // @LINE:210
    def editDeviceType(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editDeviceType")
    }
  
    // @LINE:207
    def deviceTypeList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deviceTypeList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:531
  class ReverseTelcoSubscriberController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:546
    def open2wSubcriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "open2wSubcriber")
    }
  
    // @LINE:532
    def getListSubscriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSubscriber")
    }
  
    // @LINE:540
    def getCtkm(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getCtkm")
    }
  
    // @LINE:539
    def getHybridInfo(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHybridInfo")
    }
  
    // @LINE:536
    def getListProductOffering(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListProductOffering")
    }
  
    // @LINE:541
    def getBalanceInfo(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getBalanceInfo")
    }
  
    // @LINE:535
    def subscriberDetail(id:String, subs:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subscriberDetail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("subs", subs)))
    }
  
    // @LINE:531
    def subscriberManage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/subscriberManage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:542
    def getDebitSubscriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDebitSubscriber")
    }
  
    // @LINE:545
    def openSubcriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "openSubcriber")
    }
  
    // @LINE:534
    def getDetailSubscriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailSubscriber")
    }
  
    // @LINE:533
    def getListSubsByBeVht(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSubsByBeVht")
    }
  
    // @LINE:538
    def getTotalSubscriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getTotalSubscriber")
    }
  
    // @LINE:543
    def getKttkAndKtmi(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getKttkAndKtmi")
    }
  
    // @LINE:544
    def blockSubcriber(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "blockSubcriber")
    }
  
    // @LINE:537
    def getInfoDataAccount(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoDataAccount")
    }
  
  }

  // @LINE:640
  class ReverseTelcoFeedbackController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:642
    def logFeedback(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logFeedback")
    }
  
    // @LINE:641
    def sendFeedback(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendFeedback")
    }
  
    // @LINE:640
    def feedback(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "feedback/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:643
    def getLogListFeedback(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLogListFeedback")
    }
  
  }

  // @LINE:93
  class ReverseApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:93
    def sendMail(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMail")
    }
  
    // @LINE:94
    def getJsonWidget(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getJsonWidget/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:479
  class ReverseTelcoAPNController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:481
    def getAPNByPhone(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "apn/getAPNByPhone")
    }
  
    // @LINE:479
    def APNview(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "apn/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:482
    def registerAPN(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "apn/registerAPN")
    }
  
    // @LINE:483
    def unRegisterAPN(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "apn/unRegisterAPN")
    }
  
    // @LINE:480
    def getIpAllow(isdn:String, userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "apn/getIpAllow/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("isdn", isdn)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("userId", userId)))))
    }
  
  }

  // @LINE:5
  class ReverseOrderSearchController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:521
    def getSearchOrder(orderId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getSearchOrder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("orderId", orderId)))
    }
  
    // @LINE:5
    def OrderSearchView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tra_cuu_don_hang")
    }
  
  }

  // @LINE:404
  class ReverseAdminOverviewProjectController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:404
    def adminOverviewProject(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminOverviewProject/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:296
  class ReversePayPackDataController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:301
    def deletePackdata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletePackdata")
    }
  
    // @LINE:299
    def getInfoPackdata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoPackdata")
    }
  
    // @LINE:297
    def getListPackdata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListPackdata")
    }
  
    // @LINE:300
    def editPackdata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editPackdata")
    }
  
    // @LINE:298
    def addNewPackdata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewPackdata")
    }
  
    // @LINE:296
    def packData(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "packData/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:107
  class ReverseDownloadFileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:107
    def downloadFileFromApi(param:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "downloadFile" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("param", param)))))
    }
  
  }

  // @LINE:110
  class ReverseDashboardController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:110
    def dashboard(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dashboard")
    }
  
    // @LINE:113
    def loadDeviceDataCurrent(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loadDeviceDataCurrent/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:111
    def getMarkersWithPaging(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getMarkersWithPaging")
    }
  
    // @LINE:112
    def getListDeviceWithPaging(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDeviceWithPaging")
    }
  
  }

  // @LINE:524
  class ReverseAdminTelcoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:529
    def getListEnterpriseSubmitOfAdminSpe(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListEnterpriseSubmitOfAdminSpe")
    }
  
    // @LINE:526
    def processComfirmInfoAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "processComfirmInfoAccountCmp")
    }
  
    // @LINE:528
    def getListEnterpriseByBrowser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListEnterpriseByBrowser")
    }
  
    // @LINE:525
    def getListInfoApproved(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListInfoApproved")
    }
  
    // @LINE:524
    def approvedInfoCompanyTelco(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "approvedInfoCompanyTelco")
    }
  
    // @LINE:527
    def processComfirmInfoCompany(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "processComfirmInfoCompany")
    }
  
  }

  // @LINE:548
  class ReverseTelcoContractController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:550
    def getDebitContract(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDebitContract")
    }
  
    // @LINE:551
    def getTotalAccount(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getTotalAccount")
    }
  
    // @LINE:549
    def getListAccountContract(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListAccountContract")
    }
  
    // @LINE:548
    def contractManage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/contractManage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:552
    def getListContractByIdNo(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListContractByIdNo")
    }
  
  }

  // @LINE:120
  class ReverseDashboardV3Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:124
    def deleteDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteDashboard")
    }
  
    // @LINE:128
    def moveDashboardToOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "moveDashboardToOrg")
    }
  
    // @LINE:120
    def dashboardList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dashboardList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:125
    def dashboard(id:String, dashboardId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("dashboardId", dashboardId)))
    }
  
    // @LINE:123
    def editContentDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editContentDashboard")
    }
  
    // @LINE:121
    def getListDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDashboard")
    }
  
    // @LINE:126
    def getDashboardWithId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDashboardWithId")
    }
  
    // @LINE:122
    def addNewDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewDashboard")
    }
  
    // @LINE:127
    def saveDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "saveDashboard")
    }
  
  }

  // @LINE:465
  class ReverseTelcoOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:467
    def checkValidateSerialSim(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "checkValidateSerialSim")
    }
  
    // @LINE:476
    def getListSaleService1(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSaleService1")
    }
  
    // @LINE:472
    def unlockIsdnVht(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "unlockIsdnVht")
    }
  
    // @LINE:475
    def getListSaleService(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSaleService")
    }
  
    // @LINE:477
    def processOrderBuySim(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "processOrderBuySim")
    }
  
    // @LINE:489
    def getCustomerType(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getCustomerType")
    }
  
    // @LINE:490
    def getListCt(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListCt")
    }
  
    // @LINE:471
    def blockIsdnVht(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "blockIsdnVht")
    }
  
    // @LINE:486
    def manageOrder(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/manageOrder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:474
    def getListProductOffer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListProductOffer")
    }
  
    // @LINE:487
    def getListOrderBuySim(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListOrderBuySim")
    }
  
    // @LINE:473
    def connectSubscriberSim(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "connectSubscriberSim")
    }
  
    // @LINE:488
    def upfilePycTelco(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "upfilePycTelco")
    }
  
    // @LINE:470
    def searchSubscriberByStock(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchSubscriberByStock")
    }
  
    // @LINE:466
    def getDataTelcoByUrl(url:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getDataTelcoByUrl/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("url", url)))
    }
  
    // @LINE:468
    def getListReasonFull(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListReasonFull")
    }
  
    // @LINE:465
    def orderSubs(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/orderSubs/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:469
    def getConnectSubscriberRamdom(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getConnectSubscriberRamdom")
    }
  
    // @LINE:485
    def buySim(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/buySim/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:269
  class ReverseRoleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:269
    def roleList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "roleList")
    }
  
    // @LINE:271
    def deleteRole(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteRole")
    }
  
    // @LINE:270
    def addNewRole(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewRole")
    }
  
    // @LINE:272
    def getRole(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "roleDetail")
    }
  
    // @LINE:273
    def updateRole(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateRole")
    }
  
  }

  // @LINE:225
  class ReverseOrginazationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:225
    def orginazationView(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orginazationView/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:97
  class ReverseSocketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:97
    def wsSocket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "wsSocket")
    }
  
  }

  // @LINE:221
  class ReverseFlowEngineController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:221
    def getListFlow(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListFlow")
    }
  
    // @LINE:222
    def addFlow(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addFlow")
    }
  
  }

  // @LINE:165
  class ReverseAttributeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:188
    def getValueAttributeWithTime(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getValueAttributeWithTime")
    }
  
    // @LINE:187
    def getPositionDeviceByAttribute(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getPositionDeviceByAttribute")
    }
  
    // @LINE:167
    def getAttributeHistory(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAttributeHistory")
    }
  
    // @LINE:170
    def attributeEvent(id:String, eventId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "attributeEvent/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("eventId", eventId)))
    }
  
    // @LINE:185
    def getDataAttributeById(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataAttributeById")
    }
  
    // @LINE:172
    def attributeGroup(id:String, groupId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "attributeGroup/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("groupId", groupId)))
    }
  
    // @LINE:183
    def deleteAttributeOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAttributeOrg")
    }
  
    // @LINE:169
    def attributeUser(id:String, userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "attributeUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:166
    def getAttributeList(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAttributeList")
    }
  
    // @LINE:186
    def getLastValueAttribute(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLastValueAttribute")
    }
  
    // @LINE:171
    def attributeTemplate(id:String, templateId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "attributeTemplate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("templateId", templateId)))
    }
  
    // @LINE:182
    def addAttribute(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addAttribute")
    }
  
    // @LINE:165
    def attributeDevice(id:String, deviceId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "attributeDevice/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("deviceId", deviceId)))
    }
  
    // @LINE:184
    def editAttributeOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editAttributeOrg")
    }
  
  }

  // @LINE:325
  class ReversePaySubsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:325
    def subsList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subsList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:327
    def getInfoSub(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoSub")
    }
  
    // @LINE:328
    def getLinkPaymentSub(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLinkPaymentSub")
    }
  
    // @LINE:326
    def getAllSubs(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllSubs")
    }
  
  }

  // @LINE:495
  class ReverseTelcoDashboardController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:507
    def getDetailLowRemainingData(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailLowRemainingData")
    }
  
    // @LINE:496
    def getDataDashboardTelco(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataDashboardTelco")
    }
  
    // @LINE:508
    def getDetailPackageExpired(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailPackageExpired")
    }
  
    // @LINE:505
    def getDetailRedAlert(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailRedAlert")
    }
  
    // @LINE:497
    def getDataDashboardWithMonth(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataDashboardWithMonth")
    }
  
    // @LINE:495
    def telcoDashboard(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:506
    def getDetailPrepaidExpired(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailPrepaidExpired")
    }
  
    // @LINE:501
    def getSubscriberStatistics(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getSubscriberStatistics")
    }
  
    // @LINE:502
    def getBalanceDashboardTelco(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getBalanceDashboardTelco")
    }
  
    // @LINE:504
    def getListSubsDashboardBlockDebit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSubsDashboardBlockDebit")
    }
  
    // @LINE:499
    def getAlertDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAlertDashboard")
    }
  
    // @LINE:503
    def getListSubsDashboardByKey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSubsDashboardByKey")
    }
  
    // @LINE:498
    def getTop5DataUsersOfMonth(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getTop5DataUsersOfMonth")
    }
  
    // @LINE:500
    def getDetailAlertDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailAlertDashboard")
    }
  
  }

  // @LINE:356
  class ReverseQrCodeCamController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:357
    def createQrCodeCam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createQrCodeCam")
    }
  
    // @LINE:356
    def qrCodeCam(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "qrCodeCam")
    }
  
    // @LINE:358
    def deleteQrCodeCam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteQrCodeCam")
    }
  
  }

  // @LINE:587
  class ReverseTelcoRoleAccountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:594
    def addEnterpriseBySAdmin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addEnterpriseBySAdmin")
    }
  
    // @LINE:587
    def accountList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/accountList")
    }
  
    // @LINE:599
    def deleteAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAccountCmp")
    }
  
    // @LINE:589
    def addAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addAccountCmp")
    }
  
    // @LINE:593
    def generatePassAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "generatePassAccountCmp")
    }
  
    // @LINE:598
    def updateEnterprise(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateEnterprise")
    }
  
    // @LINE:601
    def checkValidateGpkd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateGpkdExist")
    }
  
    // @LINE:595
    def addEnterpriseByAdminOrSEnterprise(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addEnterpriseByAdminOrSEnterprise")
    }
  
    // @LINE:597
    def editEnterprise(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editEnterprise")
    }
  
    // @LINE:602
    def updatRoleAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatRoleAccountCmp")
    }
  
    // @LINE:596
    def deleteEnterprise(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteEnterprise")
    }
  
    // @LINE:592
    def getInfoAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoAccountCmp")
    }
  
    // @LINE:600
    def validateGpkd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateGpkd")
    }
  
    // @LINE:591
    def infoAccountCmp(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/infoAccountCmp/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:588
    def getListAccountCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListAccountCmp")
    }
  
    // @LINE:590
    def addAccountCmpV2(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addAccountCmpV2")
    }
  
  }

  // @LINE:144
  class ReverseWidgetListController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:146
    def getWidgetCurrent(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getWidgetCurrent")
    }
  
    // @LINE:145
    def saveWidgetData(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "saveWidgetData")
    }
  
    // @LINE:144
    def widgetPage(id:String, idDashboard:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "widgetPage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("idDashboard", idDashboard)))
    }
  
  }

  // @LINE:446
  class ReverseMarketPlaceContactController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:446
    def productContactList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "productContactList")
    }
  
    // @LINE:448
    def sendContactMarket(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendContactMarket")
    }
  
    // @LINE:447
    def productContactFilterList(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "productContactList")
    }
  
    // @LINE:449
    def editContactMarket(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editContactMarket")
    }
  
  }

  // @LINE:672
  class ReverseTelcoStatisticalReportController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:675
    def getExpiratedPackages(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "telco/report/getExpiratedPackages")
    }
  
    // @LINE:673
    def getRedBarings(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "telco/report/getRedBarings")
    }
  
    // @LINE:672
    def RedBaring(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/report/subscriberBanned/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:674
    def ExpiratedPackage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/report/pakageTime/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:361
  class ReverseOAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:361
    def getLogin(login_challenge:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "oauth/login" + play.core.routing.queryString(List(if(login_challenge == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("login_challenge", login_challenge)))))
    }
  
    // @LINE:365
    def callback(code:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "oauth/callback" + play.core.routing.queryString(List(if(code == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("code", code)))))
    }
  
    // @LINE:364
    def postConsent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "oauth/consent")
    }
  
    // @LINE:363
    def getConsent(consent_challenge:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "oauth/consent" + play.core.routing.queryString(List(if(consent_challenge == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("consent_challenge", consent_challenge)))))
    }
  
    // @LINE:362
    def postLogin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "oauth/login")
    }
  
  }

  // @LINE:455
  class ReverseUserTenantListController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:461
    def updateRoleUserPermission(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateRoleUserPermission")
    }
  
    // @LINE:456
    def getListUserTenant(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListUserTenant")
    }
  
    // @LINE:457
    def createUserTenant(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUserTenant")
    }
  
    // @LINE:459
    def editUserTenant(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editUserTenant")
    }
  
    // @LINE:458
    def delUserTenant(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delUserTenant")
    }
  
    // @LINE:462
    def delRoleUserPermission(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delRoleUserPermission")
    }
  
    // @LINE:455
    def userTenantList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userTenantList")
    }
  
    // @LINE:460
    def getListRoleOfOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListRoleOfOrg")
    }
  
  }

  // @LINE:330
  class ReverseManageSimController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:330
    def manageSim(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "manageSim/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:331
    def getDataCustomer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataCustomer")
    }
  
    // @LINE:332
    def detailSim(projectId:String, simnb:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "detailSim/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("projectId", projectId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("simnb", simnb)))
    }
  
  }

  // @LINE:510
  class ReverseTelcoAccountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:517
    def getListArea(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListArea")
    }
  
    // @LINE:514
    def getInfoAccount(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoAccount")
    }
  
    // @LINE:518
    def getInfoGpkdApproved(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getInfoGpkdApproved")
    }
  
    // @LINE:520
    def updateCategoryBusinessAndDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateCategoryBusinessAndDevice")
    }
  
    // @LINE:519
    def getCategoryBusinessAndDevice(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCategoryBusinessAndDevice")
    }
  
    // @LINE:516
    def getInfoCompanyEnterpriseLv2(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoCompanyEnterprise")
    }
  
    // @LINE:511
    def updateDetailAccountTelco(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateAccountInfo")
    }
  
    // @LINE:510
    def accountInfo(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/accountInfo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:515
    def getInfoCompany(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoCompany")
    }
  
    // @LINE:512
    def updateInfoCompanyTelco(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateInfoCompanyTelco")
    }
  
    // @LINE:513
    def deleteInfoCompany(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteInfoCompany")
    }
  
  }

  // @LINE:81
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:83
    def getTokenSendPassUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getTokenSendPassUser")
    }
  
    // @LINE:85
    def deleteUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteUser")
    }
  
    // @LINE:87
    def updateUserOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateUserOrg")
    }
  
    // @LINE:81
    def userList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userList")
    }
  
    // @LINE:84
    def editUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editUser")
    }
  
    // @LINE:86
    def addRoleForUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addUserRole")
    }
  
    // @LINE:82
    def addNewUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewUser")
    }
  
  }

  // @LINE:227
  class ReverseGroupController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:241
    def getListOrganizations(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListOrganizations/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:238
    def updateRoleToGroupUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateRoleToGroupUser")
    }
  
    // @LINE:239
    def updateUserToGroupDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateUserToGroupDevice")
    }
  
    // @LINE:242
    def processMoveUserToGroupOther(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "processMoveUserToGroupOther")
    }
  
    // @LINE:243
    def processMoveDeviceToGroupOther(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "processMoveDeviceToGroupOther")
    }
  
    // @LINE:230
    def getGroupChildByGroupId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getChildByGroupId")
    }
  
    // @LINE:236
    def updateGroup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateOrg")
    }
  
    // @LINE:229
    def getAttributeOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAttributeOrg")
    }
  
    // @LINE:244
    def createUserInOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUserInOrg")
    }
  
    // @LINE:231
    def getListGroupOfOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroupOfOrg")
    }
  
    // @LINE:227
    def orgList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orgList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:237
    def deleteGroup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteOrg")
    }
  
    // @LINE:234
    def getListEventOfOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListEventOfOrg")
    }
  
    // @LINE:245
    def updateRoleForUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateRoleForUser")
    }
  
    // @LINE:233
    def getListDeviceOfOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDeviceOfOrg")
    }
  
    // @LINE:232
    def getListUserOfOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListUserOfOrg")
    }
  
    // @LINE:228
    def getInfoOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoOrg")
    }
  
    // @LINE:240
    def addGroupRoot(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addGroupRoot")
    }
  
    // @LINE:235
    def getListRoleOfOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListRoleOfOrg")
    }
  
  }

  // @LINE:34
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def pageSuccess(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pageSuccess")
    }
  
    // @LINE:51
    def cancel(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cancel")
    }
  
    // @LINE:261
    def pageTestApi(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pageTestApi")
    }
  
    // @LINE:262
    def testPostFormUrlencoded(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "testPostFormUrlencoded")
    }
  
    // @LINE:34
    def termsOfUse(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "termsOfUse")
    }
  
    // @LINE:49
    def getImg(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getImg/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:50
    def success(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "success")
    }
  
    // @LINE:263
    def testPostJson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "testPostJson")
    }
  
    // @LINE:264
    def testGetByToken(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "testGetByToken")
    }
  
    // @LINE:52
    def provision(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "provision")
    }
  
    // @LINE:266
    def getDashboardByProjectId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDashboardByProjectId")
    }
  
    // @LINE:265
    def getDashboardByIdOrg(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDashboardByIdOrg")
    }
  
  }

  // @LINE:577
  class ReverseTelcoInvoiceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:579
    def getLinkDownloadInvoice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLinkDownloadInvoice")
    }
  
    // @LINE:578
    def getListInvoiceOfContract(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListInvoiceOfContract")
    }
  
    // @LINE:577
    def invoiceOfContract(userId:String, invoice:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "invoiceOfContract/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("invoice", invoice)))
    }
  
  }

  // @LINE:663
  class ReverseTelcoLocationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:663
    def telcoLocation(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telcoLocation/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:664
    def searchByIsdn(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchByIsdn")
    }
  
  }

  // @LINE:73
  class ReverseOverviewController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:79
    def countDataSuccessRate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "countDataSuccessRate")
    }
  
    // @LINE:75
    def countDevice7Day(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "countDevice7Day/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:73
    def overview(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "overview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:78
    def countDataLatency(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "countDataLatency")
    }
  
    // @LINE:76
    def countUser7Day(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "countUser7Day/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:74
    def countDeviceAndUser(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "countDeviceAndUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:77
    def countMess7Day(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "countMess7Day/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:318
  class ReversePayBillController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:320
    def getLinkPayment(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLinkPayment")
    }
  
    // @LINE:321
    def getInfoBill(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoBill")
    }
  
    // @LINE:322
    def billUserList(id:String, userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "billUserList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:318
    def billList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "billList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:323
    def getBillOfUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getBillOfUser")
    }
  
    // @LINE:319
    def getAllBill(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllBill")
    }
  
  }

  // @LINE:12
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def createAccount(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "createAccount")
    }
  
    // @LINE:29
    def ForgetPassword(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ForgetPassword")
    }
  
    // @LINE:33
    def version(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "version")
    }
  
    // @LINE:19
    def verifyPhone(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "verifyPhone")
    }
  
    // @LINE:13
    def authenticateDemo(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loginDemo")
    }
  
    // @LINE:27
    def forgotPassPage(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "password")
    }
  
    // @LINE:20
    def ChangePass(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ChangePass")
    }
  
    // @LINE:32
    def getOtpPhone(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getOtpPhone")
    }
  
    // @LINE:23
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:31
    def getOtpEmail(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getOtpEmail")
    }
  
    // @LINE:24
    def register(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:15
    def setLang(lang:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lang/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("lang", lang)))
    }
  
    // @LINE:18
    def checkIpLogin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "checkIpLogin")
    }
  
    // @LINE:22
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:26
    def newRegisterPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "newRegisterPost")
    }
  
    // @LINE:36
    def sitemap(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "innoway-sitemap.xml")
    }
  
    // @LINE:12
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:28
  class ReverseFogotPassController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def userGetCodeChangePass(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "userGetCodeChangePass")
    }
  
    // @LINE:30
    def ChangePassword(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ChangePassword")
    }
  
  }

  // @LINE:388
  class ReverseAdminOverviewController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:389
    def getTotalOverview(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getTotalOverview")
    }
  
    // @LINE:392
    def getInfoOVerviewVtag(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoOVerviewVtag")
    }
  
    // @LINE:394
    def getInfoOVerviewMetter(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoOVerviewMetter")
    }
  
    // @LINE:390
    def postJsonTotalOverview(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "postJsonTotalOverview")
    }
  
    // @LINE:393
    def getInfoOVerviewFleet(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoOVerviewFleet")
    }
  
    // @LINE:391
    def getInfoOVerviewSmarthome(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoOVerviewSmarthome")
    }
  
    // @LINE:388
    def adminOverview(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminOverview")
    }
  
    // @LINE:395
    def getListProjectWithPaging(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListProjectWithPaging")
    }
  
  }

  // @LINE:337
  class ReverseModuleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:337
    def module(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "module/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:348
  class ReverseQrCodeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:352
    def deleteQrCode(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteQrCode")
    }
  
    // @LINE:351
    def getListQrCode(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListQrCode")
    }
  
    // @LINE:349
    def createQrCode(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createQrCode")
    }
  
    // @LINE:354
    def editQrCode(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editQrCode")
    }
  
    // @LINE:348
    def qrCodeList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "qrCodeList")
    }
  
    // @LINE:353
    def qrCodeHistoryList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "qrCodeHistoryList")
    }
  
    // @LINE:350
    def qrCodeImg(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "qrCodeImg/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:432
  class ReverseMarketPlaceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:436
    def getAllProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllProduct")
    }
  
    // @LINE:439
    def getAllGroupDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllGroupDevice")
    }
  
    // @LINE:435
    def getProductMarket(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getProductMarket")
    }
  
    // @LINE:438
    def getAllGroupSolution(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllGroupSolution")
    }
  
    // @LINE:437
    def getAllGroupProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllGroupProduct")
    }
  
    // @LINE:432
    def marketPlace(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "marketPlace")
    }
  
    // @LINE:433
    def marketPlaceSolution(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "marketPlace/solution")
    }
  
    // @LINE:441
    def getAllDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllDevice")
    }
  
    // @LINE:440
    def getAllSolution(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllSolution")
    }
  
    // @LINE:443
    def getDetailProductWithId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDetailProductWithId")
    }
  
    // @LINE:442
    def detailProduct(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "marketPlace/product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:444
    def getSameProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getSameProduct")
    }
  
    // @LINE:434
    def marketPlaceDevice(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "marketPlace/device")
    }
  
  }

  // @LINE:191
  class ReverseMessagesDeviceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:197
    def sendMessageData(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessageData")
    }
  
    // @LINE:196
    def postCreateDeviceToken(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "postCreateDeviceToken")
    }
  
    // @LINE:195
    def getMessageFormDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getMessageFormDevice")
    }
  
    // @LINE:199
    def sendMessageOnOffApp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessageOnOffApp")
    }
  
    // @LINE:192
    def getMetadata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getMetadata")
    }
  
    // @LINE:193
    def sendMetadata(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMetadata")
    }
  
    // @LINE:198
    def sendMessageOnOff(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessageOnOff")
    }
  
    // @LINE:194
    def sendMessageToDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessageToDevice")
    }
  
    // @LINE:191
    def messagesDevice(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messagesDevice/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:200
    def sendCommandRPC(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendCommandRPC")
    }
  
  }

  // @LINE:369
  class ReverseSolutionTrackingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:372
    def historyMap(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "historyMap/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:373
    def loadLocationHistory(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "loadLocationHistory")
    }
  
    // @LINE:369
    def monitorMap(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "monitorMap/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:371
    def getInfoDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoDevice")
    }
  
    // @LINE:370
    def getListGpsDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGpsDevice")
    }
  
  }

  // @LINE:149
  class ReverseDeviceIotController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:150
    def addNewDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewDevice")
    }
  
    // @LINE:160
    def getListDeviceByOrg(id:String, projectId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListDeviceByOrg/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("projectId", projectId)))
    }
  
    // @LINE:155
    def configGpsDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "configGpsDevice")
    }
  
    // @LINE:152
    def deleteDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteDevice")
    }
  
    // @LINE:153
    def editNameDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editNameDevice")
    }
  
    // @LINE:162
    def getListDeviceByDeviceType(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListDeviceByDeviceType/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:159
    def getListDeviceVarsByDevice(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListDeviceVarByDevice/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:156
    def getConfigOfDeviceIot(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getConfigOfDeviceIot/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:154
    def updateDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateDevice")
    }
  
    // @LINE:158
    def getListDeviceByGroup(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListDeviceByGroup/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:151
    def createDeviceWithSerialSim(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createDeviceWithSerialSim")
    }
  
    // @LINE:149
    def deviceIotList(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deviceIotList/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:161
    def getListDeviceAndAttrByOrg(id:String, projectId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListDeviceAndAttrByOrg/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("projectId", projectId)))
    }
  
    // @LINE:157
    def getListDeviceIot(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListDeviceIot")
    }
  
  }

  // @LINE:627
  class ReverseTelcoChildUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:630
    def getRolesOfChildUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getRolesOfChildUser")
    }
  
    // @LINE:632
    def childUserDetail(userId:String, childUserId:String, email:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "childUserDetail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("childUserId", childUserId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)))
    }
  
    // @LINE:637
    def removeSubOfChildUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "removeSubOfChildUser")
    }
  
    // @LINE:627
    def listChildUser(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/listChildUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:636
    def validateSubToChildUser1(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateSubToChildUser1")
    }
  
    // @LINE:628
    def getListChildUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListChildUser")
    }
  
    // @LINE:635
    def addSubToChildUser1(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addSubToChildUser1")
    }
  
    // @LINE:631
    def updateRolesOfChildUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateRolesOfChildUser")
    }
  
    // @LINE:633
    def getListSubsOfChildUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListSubsOfChildUser")
    }
  
    // @LINE:629
    def addChildUserCmp(userId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addChildUserCmp/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:634
    def addSubToChildUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addSubToChildUser")
    }
  
  }

  // @LINE:658
  class ReverseTelcoAepController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:660
    def requestDataAepGps(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "requestDataAepGps")
    }
  
    // @LINE:659
    def requestDataAepWeather(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "requestDataAepWeather")
    }
  
    // @LINE:658
    def aepUtilities(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "aepUtilities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:115
  class ReverseDashboardWidgetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:118
    def getHistoryRpc(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getHistoryRpc")
    }
  
    // @LINE:116
    def getListDeviceWithWidgetMap(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDeviceWithWidgetMap")
    }
  
    // @LINE:117
    def getDeviceDataCurrent(deviceId:String, latId:String, longId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getDeviceDataCurrent" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("deviceId", deviceId)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("latId", latId)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("longId", longId)))))
    }
  
    // @LINE:115
    def dashboardVer2(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dashboardVer2/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:214
  class ReverseDeviceTemplateController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:214
    def deviceTemplate(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deviceTemplate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:218
    def createTemDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createTemDevice")
    }
  
    // @LINE:215
    def createDeviceTemplate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createDeviceTemplate")
    }
  
    // @LINE:217
    def deleteDeviceTemplate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteDeviceTemplate")
    }
  
    // @LINE:216
    def getListDeviceTemplate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDeviceTemplate")
    }
  
  }

  // @LINE:397
  class ReverseAdminManageSimController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:399
    def getListDeviceWithProjectId(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListDeviceWithProjectId")
    }
  
    // @LINE:400
    def getAttrSimDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAttrSimDevice")
    }
  
    // @LINE:397
    def adminManageSim(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminManageSim")
    }
  
    // @LINE:398
    def getAllProjectWithPaging(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getAllProjectWithPaging")
    }
  
  }

  // @LINE:248
  class ReverseGroupListController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:258
    def getListGroupOrganization(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroupOrganization")
    }
  
    // @LINE:257
    def getListGroupEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroupEvent")
    }
  
    // @LINE:254
    def getGroupWithEntityType(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getGroupWithEntityType")
    }
  
    // @LINE:249
    def addNewGroups(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addNewGroups")
    }
  
    // @LINE:256
    def getListGroupDevice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroupDevice")
    }
  
    // @LINE:252
    def updateOrgIdForGroups(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateOrgIdForGroups")
    }
  
    // @LINE:255
    def getListGroupUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroupUser")
    }
  
    // @LINE:251
    def editNameGroups(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editNameGroups")
    }
  
    // @LINE:248
    def groupsList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "groupsList")
    }
  
    // @LINE:250
    def deleteGroup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteGroup")
    }
  
    // @LINE:253
    def getListGroups(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroups")
    }
  
  }

  // @LINE:582
  class ReverseTelcoApiKeyController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:583
    def getListApiKey(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListApiKey")
    }
  
    // @LINE:582
    def apiKeyManage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/apiKey/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:667
  class ReverseInvoiceManagerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:668
    def getInvoices(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "telco/getInvoices")
    }
  
    // @LINE:667
    def invoiceManage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/invoiceManage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:669
    def getInvoiceBase64(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "telco/getInvoiceBase64")
    }
  
  }

  // @LINE:492
  class ReverseTelcoLogController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:652
    def deleteSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteSurvey")
    }
  
    // @LINE:647
    def getLogListCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLogListCmp")
    }
  
    // @LINE:655
    def saveFormCustomerSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "saveFormCustomerSurvey")
    }
  
    // @LINE:651
    def editSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editSurvey")
    }
  
    // @LINE:492
    def logConnectSim(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logConnectSim/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:650
    def getLogListCustomerSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLogListCustomerSurvey")
    }
  
    // @LINE:649
    def logCustomerSurvey(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logCustomerSurvey")
    }
  
    // @LINE:493
    def getLogConnectSim(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getLogConnectSim")
    }
  
    // @LINE:646
    def logCmp(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logCmp")
    }
  
    // @LINE:654
    def exportLogCustomerSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "exportLogCustomerSurvey")
    }
  
    // @LINE:648
    def updateFormCustomerSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateFormCustomerSurvey")
    }
  
    // @LINE:653
    def getInfoSurvey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoSurvey")
    }
  
  }

  // @LINE:407
  class ReverseAdminRegisterDeveloperController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:409
    def exportRegisterDeveloperList(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "exportRegisterDeveloperList")
    }
  
    // @LINE:410
    def deleteRegisterDeveloper(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteRegisterDeveloper")
    }
  
    // @LINE:407
    def registerDeveloperList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "registerDeveloperList")
    }
  
    // @LINE:408
    def registerDeveloperFilterList(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "registerDeveloperList")
    }
  
  }

  // @LINE:100
  class ReverseSendApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:100
    def getDataWithParam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataWithParam")
    }
  
    // @LINE:102
    def putDataWithParam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "putDataWithParam")
    }
  
    // @LINE:104
    def deleteDataWithParam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteDataWithParam")
    }
  
    // @LINE:101
    def portDataWithParam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "portDataWithParam")
    }
  
    // @LINE:103
    def upfileImage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "upfileImage")
    }
  
  }

  // @LINE:132
  class ReverseTelcoDeviceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:132
    def deviceManage(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "telco/deviceManage/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
  }

  // @LINE:175
  class ReverseDeviceVariableController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:176
    def addVariable(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addVariable")
    }
  
    // @LINE:178
    def getDataVariableById(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDataVariableById")
    }
  
    // @LINE:179
    def getListVarByIdDevice(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListVarByIdDevice/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:177
    def delVariable(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delVariable")
    }
  
    // @LINE:175
    def deviceVariable(projectId:String, id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deviceVariable/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("projectId", projectId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:413
  class ReverseAdminGroupProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:414
    def getListGroupProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGroupProduct")
    }
  
    // @LINE:415
    def addGroupProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addGroupProduct")
    }
  
    // @LINE:416
    def deleteGroupProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteGroupProduct")
    }
  
    // @LINE:417
    def editGroupProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editGroupProduct")
    }
  
    // @LINE:413
    def groupProductList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "groupProductList")
    }
  
  }

  // @LINE:4
  class ReverseLandingPageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getListProductOfferPack(offerType:String, payType:String, category:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getListProductOfferPack" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("offerType", offerType)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("payType", payType)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("category", category)))))
    }
  
    // @LINE:7
    def submitFormContactTelco(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitFormContactTelco")
    }
  
    // @LINE:9
    def submitFormContact(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitFormContact")
    }
  
    // @LINE:11
    def registerDeveloper(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "registerDeveloper")
    }
  
    // @LINE:6
    def landingPage(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "landingPage")
    }
  
    // @LINE:10
    def submitRegisterDeveloper(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitRegisterDeveloper")
    }
  
    // @LINE:4
    def home(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:605
  class ReverseTelcoQrcodeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:605
    def qrcodeList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "qrcodeList")
    }
  
    // @LINE:612
    def getInfoConnectSubs(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getInfoConnectSubs")
    }
  
    // @LINE:608
    def getListGpkd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListGpkd")
    }
  
    // @LINE:607
    def checkValidateSerialAdm1(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "checkValidateSerialAdm1")
    }
  
    // @LINE:610
    def createQrcode(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createQrcode")
    }
  
    // @LINE:606
    def getListQrcodeCmp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getListQrcodeCmp")
    }
  
    // @LINE:611
    def qrCodeConnect(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "provisioning/qr/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:613
    def paymentConnectSubs(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "paymentConnectSubs")
    }
  
    // @LINE:609
    def saveFileChungTu(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "saveFileChungTu")
    }
  
    // @LINE:614
    def delQrcodeById(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delQrcodeById")
    }
  
  }


}
