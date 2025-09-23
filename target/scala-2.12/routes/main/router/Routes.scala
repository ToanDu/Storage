
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/VHT_Projects/cmp-fe-dev-dev_multiLang/conf/routes
// @DATE:Mon Sep 22 16:32:39 ICT 2025

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  LandingPageController_67: controllers.LandingPageController,
  // @LINE:5
  OrderSearchController_57: controllers.OrderSearchController,
  // @LINE:12
  Application_71: controllers.Application,
  // @LINE:28
  FogotPassController_8: controllers.FogotPassController,
  // @LINE:34
  HomeController_10: controllers.HomeController,
  // @LINE:37
  Assets_63: controllers.Assets,
  // @LINE:45
  JsController_22: controllers.JsController,
  // @LINE:56
  DownloadPageController_6: controllers.DownloadPageController,
  // @LINE:59
  ProjectController_40: controllers.ProjectController,
  // @LINE:73
  OverviewController_27: controllers.OverviewController,
  // @LINE:81
  UserController_38: controllers.UserController,
  // @LINE:93
  ApiController_76: controllers.ApiController,
  // @LINE:97
  SocketController_32: controllers.SocketController,
  // @LINE:100
  SendApiController_48: controllers.SendApiController,
  // @LINE:107
  DownloadFileController_42: controllers.DownloadFileController,
  // @LINE:110
  DashboardController_14: controllers.DashboardController,
  // @LINE:115
  DashboardWidgetController_75: controllers.DashboardWidgetController,
  // @LINE:120
  DashboardV3Controller_4: controllers.DashboardV3Controller,
  // @LINE:132
  TelcoDeviceController_31: controllers.TelcoDeviceController,
  // @LINE:135
  DashboardAppController_24: controllers.DashboardAppController,
  // @LINE:144
  WidgetListController_78: controllers.WidgetListController,
  // @LINE:149
  DeviceIotController_49: controllers.DeviceIotController,
  // @LINE:165
  AttributeController_21: controllers.AttributeController,
  // @LINE:175
  DeviceVariableController_50: controllers.DeviceVariableController,
  // @LINE:191
  MessagesDeviceController_41: controllers.MessagesDeviceController,
  // @LINE:203
  LogDeviceController_43: controllers.LogDeviceController,
  // @LINE:207
  DeviceTypeController_64: controllers.DeviceTypeController,
  // @LINE:214
  DeviceTemplateController_51: controllers.DeviceTemplateController,
  // @LINE:221
  FlowEngineController_74: controllers.FlowEngineController,
  // @LINE:225
  OrginazationController_66: controllers.OrginazationController,
  // @LINE:227
  GroupController_77: controllers.GroupController,
  // @LINE:248
  GroupListController_68: controllers.GroupListController,
  // @LINE:269
  RoleController_25: controllers.RoleController,
  // @LINE:276
  EventController_65: controllers.EventController,
  // @LINE:292
  RuleChainController_16: controllers.RuleChainController,
  // @LINE:296
  PayPackDataController_45: controllers.PayPackDataController,
  // @LINE:302
  PayCustomerController_52: controllers.PayCustomerController,
  // @LINE:318
  PayBillController_61: controllers.PayBillController,
  // @LINE:325
  PaySubsController_33: controllers.PaySubsController,
  // @LINE:330
  ManageSimController_26: controllers.ManageSimController,
  // @LINE:335
  DevkitController_15: controllers.DevkitController,
  // @LINE:337
  ModuleController_72: controllers.ModuleController,
  // @LINE:340
  AppDebugController_23: controllers.AppDebugController,
  // @LINE:348
  QrCodeController_0: controllers.QrCodeController,
  // @LINE:356
  QrCodeCamController_54: controllers.QrCodeCamController,
  // @LINE:361
  OAuthController_9: controllers.OAuthController,
  // @LINE:369
  SolutionTrackingController_18: controllers.SolutionTrackingController,
  // @LINE:376
  WaterClockController_20: controllers.WaterClockController,
  // @LINE:381
  TemplateDeviceController_7: controllers.TemplateDeviceController,
  // @LINE:388
  AdminOverviewController_46: controllers.AdminOverviewController,
  // @LINE:397
  AdminManageSimController_39: controllers.AdminManageSimController,
  // @LINE:402
  AdminSystemHealthController_70: controllers.AdminSystemHealthController,
  // @LINE:404
  AdminOverviewProjectController_37: controllers.AdminOverviewProjectController,
  // @LINE:407
  AdminRegisterDeveloperController_36: controllers.AdminRegisterDeveloperController,
  // @LINE:413
  AdminGroupProductController_69: controllers.AdminGroupProductController,
  // @LINE:419
  ProductListController_60: controllers.ProductListController,
  // @LINE:432
  MarketPlaceController_28: controllers.MarketPlaceController,
  // @LINE:446
  MarketPlaceContactController_59: controllers.MarketPlaceContactController,
  // @LINE:451
  MarketPlaceCommentController_11: controllers.MarketPlaceCommentController,
  // @LINE:455
  UserTenantListController_53: controllers.UserTenantListController,
  // @LINE:465
  TelcoOrderController_44: controllers.TelcoOrderController,
  // @LINE:479
  TelcoAPNController_1: controllers.TelcoAPNController,
  // @LINE:492
  TelcoLogController_73: controllers.TelcoLogController,
  // @LINE:495
  TelcoDashboardController_55: controllers.TelcoDashboardController,
  // @LINE:510
  TelcoAccountController_3: controllers.TelcoAccountController,
  // @LINE:524
  AdminTelcoController_34: controllers.AdminTelcoController,
  // @LINE:531
  TelcoSubscriberController_12: controllers.TelcoSubscriberController,
  // @LINE:548
  TelcoContractController_17: controllers.TelcoContractController,
  // @LINE:554
  TelcoUtilitiesController_56: controllers.TelcoUtilitiesController,
  // @LINE:577
  TelcoInvoiceController_79: controllers.TelcoInvoiceController,
  // @LINE:582
  TelcoApiKeyController_47: controllers.TelcoApiKeyController,
  // @LINE:587
  TelcoRoleAccountController_5: controllers.TelcoRoleAccountController,
  // @LINE:605
  TelcoQrcodeController_62: controllers.TelcoQrcodeController,
  // @LINE:617
  TelcoHistoryController_35: controllers.TelcoHistoryController,
  // @LINE:627
  TelcoChildUserController_13: controllers.TelcoChildUserController,
  // @LINE:640
  TelcoFeedbackController_58: controllers.TelcoFeedbackController,
  // @LINE:658
  TelcoAepController_30: controllers.TelcoAepController,
  // @LINE:663
  TelcoLocationController_2: controllers.TelcoLocationController,
  // @LINE:667
  InvoiceManagerController_19: controllers.InvoiceManagerController,
  // @LINE:672
  TelcoStatisticalReportController_29: controllers.TelcoStatisticalReportController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    LandingPageController_67: controllers.LandingPageController,
    // @LINE:5
    OrderSearchController_57: controllers.OrderSearchController,
    // @LINE:12
    Application_71: controllers.Application,
    // @LINE:28
    FogotPassController_8: controllers.FogotPassController,
    // @LINE:34
    HomeController_10: controllers.HomeController,
    // @LINE:37
    Assets_63: controllers.Assets,
    // @LINE:45
    JsController_22: controllers.JsController,
    // @LINE:56
    DownloadPageController_6: controllers.DownloadPageController,
    // @LINE:59
    ProjectController_40: controllers.ProjectController,
    // @LINE:73
    OverviewController_27: controllers.OverviewController,
    // @LINE:81
    UserController_38: controllers.UserController,
    // @LINE:93
    ApiController_76: controllers.ApiController,
    // @LINE:97
    SocketController_32: controllers.SocketController,
    // @LINE:100
    SendApiController_48: controllers.SendApiController,
    // @LINE:107
    DownloadFileController_42: controllers.DownloadFileController,
    // @LINE:110
    DashboardController_14: controllers.DashboardController,
    // @LINE:115
    DashboardWidgetController_75: controllers.DashboardWidgetController,
    // @LINE:120
    DashboardV3Controller_4: controllers.DashboardV3Controller,
    // @LINE:132
    TelcoDeviceController_31: controllers.TelcoDeviceController,
    // @LINE:135
    DashboardAppController_24: controllers.DashboardAppController,
    // @LINE:144
    WidgetListController_78: controllers.WidgetListController,
    // @LINE:149
    DeviceIotController_49: controllers.DeviceIotController,
    // @LINE:165
    AttributeController_21: controllers.AttributeController,
    // @LINE:175
    DeviceVariableController_50: controllers.DeviceVariableController,
    // @LINE:191
    MessagesDeviceController_41: controllers.MessagesDeviceController,
    // @LINE:203
    LogDeviceController_43: controllers.LogDeviceController,
    // @LINE:207
    DeviceTypeController_64: controllers.DeviceTypeController,
    // @LINE:214
    DeviceTemplateController_51: controllers.DeviceTemplateController,
    // @LINE:221
    FlowEngineController_74: controllers.FlowEngineController,
    // @LINE:225
    OrginazationController_66: controllers.OrginazationController,
    // @LINE:227
    GroupController_77: controllers.GroupController,
    // @LINE:248
    GroupListController_68: controllers.GroupListController,
    // @LINE:269
    RoleController_25: controllers.RoleController,
    // @LINE:276
    EventController_65: controllers.EventController,
    // @LINE:292
    RuleChainController_16: controllers.RuleChainController,
    // @LINE:296
    PayPackDataController_45: controllers.PayPackDataController,
    // @LINE:302
    PayCustomerController_52: controllers.PayCustomerController,
    // @LINE:318
    PayBillController_61: controllers.PayBillController,
    // @LINE:325
    PaySubsController_33: controllers.PaySubsController,
    // @LINE:330
    ManageSimController_26: controllers.ManageSimController,
    // @LINE:335
    DevkitController_15: controllers.DevkitController,
    // @LINE:337
    ModuleController_72: controllers.ModuleController,
    // @LINE:340
    AppDebugController_23: controllers.AppDebugController,
    // @LINE:348
    QrCodeController_0: controllers.QrCodeController,
    // @LINE:356
    QrCodeCamController_54: controllers.QrCodeCamController,
    // @LINE:361
    OAuthController_9: controllers.OAuthController,
    // @LINE:369
    SolutionTrackingController_18: controllers.SolutionTrackingController,
    // @LINE:376
    WaterClockController_20: controllers.WaterClockController,
    // @LINE:381
    TemplateDeviceController_7: controllers.TemplateDeviceController,
    // @LINE:388
    AdminOverviewController_46: controllers.AdminOverviewController,
    // @LINE:397
    AdminManageSimController_39: controllers.AdminManageSimController,
    // @LINE:402
    AdminSystemHealthController_70: controllers.AdminSystemHealthController,
    // @LINE:404
    AdminOverviewProjectController_37: controllers.AdminOverviewProjectController,
    // @LINE:407
    AdminRegisterDeveloperController_36: controllers.AdminRegisterDeveloperController,
    // @LINE:413
    AdminGroupProductController_69: controllers.AdminGroupProductController,
    // @LINE:419
    ProductListController_60: controllers.ProductListController,
    // @LINE:432
    MarketPlaceController_28: controllers.MarketPlaceController,
    // @LINE:446
    MarketPlaceContactController_59: controllers.MarketPlaceContactController,
    // @LINE:451
    MarketPlaceCommentController_11: controllers.MarketPlaceCommentController,
    // @LINE:455
    UserTenantListController_53: controllers.UserTenantListController,
    // @LINE:465
    TelcoOrderController_44: controllers.TelcoOrderController,
    // @LINE:479
    TelcoAPNController_1: controllers.TelcoAPNController,
    // @LINE:492
    TelcoLogController_73: controllers.TelcoLogController,
    // @LINE:495
    TelcoDashboardController_55: controllers.TelcoDashboardController,
    // @LINE:510
    TelcoAccountController_3: controllers.TelcoAccountController,
    // @LINE:524
    AdminTelcoController_34: controllers.AdminTelcoController,
    // @LINE:531
    TelcoSubscriberController_12: controllers.TelcoSubscriberController,
    // @LINE:548
    TelcoContractController_17: controllers.TelcoContractController,
    // @LINE:554
    TelcoUtilitiesController_56: controllers.TelcoUtilitiesController,
    // @LINE:577
    TelcoInvoiceController_79: controllers.TelcoInvoiceController,
    // @LINE:582
    TelcoApiKeyController_47: controllers.TelcoApiKeyController,
    // @LINE:587
    TelcoRoleAccountController_5: controllers.TelcoRoleAccountController,
    // @LINE:605
    TelcoQrcodeController_62: controllers.TelcoQrcodeController,
    // @LINE:617
    TelcoHistoryController_35: controllers.TelcoHistoryController,
    // @LINE:627
    TelcoChildUserController_13: controllers.TelcoChildUserController,
    // @LINE:640
    TelcoFeedbackController_58: controllers.TelcoFeedbackController,
    // @LINE:658
    TelcoAepController_30: controllers.TelcoAepController,
    // @LINE:663
    TelcoLocationController_2: controllers.TelcoLocationController,
    // @LINE:667
    InvoiceManagerController_19: controllers.InvoiceManagerController,
    // @LINE:672
    TelcoStatisticalReportController_29: controllers.TelcoStatisticalReportController
  ) = this(errorHandler, LandingPageController_67, OrderSearchController_57, Application_71, FogotPassController_8, HomeController_10, Assets_63, JsController_22, DownloadPageController_6, ProjectController_40, OverviewController_27, UserController_38, ApiController_76, SocketController_32, SendApiController_48, DownloadFileController_42, DashboardController_14, DashboardWidgetController_75, DashboardV3Controller_4, TelcoDeviceController_31, DashboardAppController_24, WidgetListController_78, DeviceIotController_49, AttributeController_21, DeviceVariableController_50, MessagesDeviceController_41, LogDeviceController_43, DeviceTypeController_64, DeviceTemplateController_51, FlowEngineController_74, OrginazationController_66, GroupController_77, GroupListController_68, RoleController_25, EventController_65, RuleChainController_16, PayPackDataController_45, PayCustomerController_52, PayBillController_61, PaySubsController_33, ManageSimController_26, DevkitController_15, ModuleController_72, AppDebugController_23, QrCodeController_0, QrCodeCamController_54, OAuthController_9, SolutionTrackingController_18, WaterClockController_20, TemplateDeviceController_7, AdminOverviewController_46, AdminManageSimController_39, AdminSystemHealthController_70, AdminOverviewProjectController_37, AdminRegisterDeveloperController_36, AdminGroupProductController_69, ProductListController_60, MarketPlaceController_28, MarketPlaceContactController_59, MarketPlaceCommentController_11, UserTenantListController_53, TelcoOrderController_44, TelcoAPNController_1, TelcoLogController_73, TelcoDashboardController_55, TelcoAccountController_3, AdminTelcoController_34, TelcoSubscriberController_12, TelcoContractController_17, TelcoUtilitiesController_56, TelcoInvoiceController_79, TelcoApiKeyController_47, TelcoRoleAccountController_5, TelcoQrcodeController_62, TelcoHistoryController_35, TelcoChildUserController_13, TelcoFeedbackController_58, TelcoAepController_30, TelcoLocationController_2, InvoiceManagerController_19, TelcoStatisticalReportController_29, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LandingPageController_67, OrderSearchController_57, Application_71, FogotPassController_8, HomeController_10, Assets_63, JsController_22, DownloadPageController_6, ProjectController_40, OverviewController_27, UserController_38, ApiController_76, SocketController_32, SendApiController_48, DownloadFileController_42, DashboardController_14, DashboardWidgetController_75, DashboardV3Controller_4, TelcoDeviceController_31, DashboardAppController_24, WidgetListController_78, DeviceIotController_49, AttributeController_21, DeviceVariableController_50, MessagesDeviceController_41, LogDeviceController_43, DeviceTypeController_64, DeviceTemplateController_51, FlowEngineController_74, OrginazationController_66, GroupController_77, GroupListController_68, RoleController_25, EventController_65, RuleChainController_16, PayPackDataController_45, PayCustomerController_52, PayBillController_61, PaySubsController_33, ManageSimController_26, DevkitController_15, ModuleController_72, AppDebugController_23, QrCodeController_0, QrCodeCamController_54, OAuthController_9, SolutionTrackingController_18, WaterClockController_20, TemplateDeviceController_7, AdminOverviewController_46, AdminManageSimController_39, AdminSystemHealthController_70, AdminOverviewProjectController_37, AdminRegisterDeveloperController_36, AdminGroupProductController_69, ProductListController_60, MarketPlaceController_28, MarketPlaceContactController_59, MarketPlaceCommentController_11, UserTenantListController_53, TelcoOrderController_44, TelcoAPNController_1, TelcoLogController_73, TelcoDashboardController_55, TelcoAccountController_3, AdminTelcoController_34, TelcoSubscriberController_12, TelcoContractController_17, TelcoUtilitiesController_56, TelcoInvoiceController_79, TelcoApiKeyController_47, TelcoRoleAccountController_5, TelcoQrcodeController_62, TelcoHistoryController_35, TelcoChildUserController_13, TelcoFeedbackController_58, TelcoAepController_30, TelcoLocationController_2, InvoiceManagerController_19, TelcoStatisticalReportController_29, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.LandingPageController.home()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tra_cuu_don_hang""", """controllers.OrderSearchController.OrderSearchView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """landingPage""", """controllers.LandingPageController.landingPage()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitFormContactTelco""", """controllers.LandingPageController.submitFormContactTelco()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListProductOfferPack""", """controllers.LandingPageController.getListProductOfferPack(offerType:String, payType:String, category:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitFormContact""", """controllers.LandingPageController.submitFormContact()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitRegisterDeveloper""", """controllers.LandingPageController.submitRegisterDeveloper()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registerDeveloper""", """controllers.LandingPageController.registerDeveloper()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loginDemo""", """controllers.Application.authenticateDemo()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lang/""" + "$" + """lang<[^/]+>""", """controllers.Application.setLang(lang:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """checkIpLogin""", """controllers.Application.checkIpLogin()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """verifyPhone""", """controllers.Application.verifyPhone()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ChangePass""", """controllers.Application.ChangePass()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createAccount""", """controllers.Application.createAccount()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.authenticate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.Application.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.Application.register()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """newRegisterPost""", """controllers.Application.newRegisterPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password""", """controllers.Application.forgotPassPage()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userGetCodeChangePass""", """controllers.FogotPassController.userGetCodeChangePass()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ForgetPassword""", """controllers.Application.ForgetPassword()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ChangePassword""", """controllers.FogotPassController.ChangePassword()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getOtpEmail""", """controllers.Application.getOtpEmail()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getOtpPhone""", """controllers.Application.getOtpPhone()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """version""", """controllers.Application.version()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """termsOfUse""", """controllers.HomeController.termsOfUse()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """innoway-sitemap.xml""", """controllers.Application.sitemap()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sitemap.xml""", """controllers.Assets.at(path:String = "/public", file:String = "sitemap.xml")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sitemap_index.xml""", """controllers.Assets.at(path:String = "/public", file:String = "sitemap_index.xml")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """robots.txt""", """controllers.Assets.at(path:String = "/public", file:String = "robots.txt")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dieu-khoan.txt""", """controllers.Assets.at(path:String = "/public", file:String = "dieu-khoan.txt")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages.js""", """controllers.JsController.jsMessages()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """javascriptRoutes""", """controllers.JsController.javascriptRoutes()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getImg/""" + "$" + """id<[^/]+>""", """controllers.HomeController.getImg(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """success""", """controllers.HomeController.success()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cancel""", """controllers.HomeController.cancel()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """provision""", """controllers.HomeController.provision()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pageSuccess""", """controllers.HomeController.pageSuccess()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """download""", """controllers.DownloadPageController.download()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """project""", """controllers.ProjectController.project()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getProject""", """controllers.ProjectController.getProject()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createProjectForm""", """controllers.ProjectController.createProjectForm()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addProject""", """controllers.ProjectController.addProject()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editProject""", """controllers.ProjectController.editProject()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delProject""", """controllers.ProjectController.delProject()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getNameProject/""" + "$" + """id<[^/]+>""", """controllers.ProjectController.getNameProject(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendJsonProjectTemplate""", """controllers.ProjectController.sendPostJsonProjectTemplate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendPutJsonProjectTemplate""", """controllers.ProjectController.sendPutJsonProjectTemplate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createDashboardTemplate""", """controllers.ProjectController.createDashboardTemplate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListTag""", """controllers.ProjectController.getListTag()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activePhone""", """controllers.ProjectController.activePhone()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """overview/""" + "$" + """id<[^/]+>""", """controllers.OverviewController.overview(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countDeviceAndUser/""" + "$" + """id<[^/]+>""", """controllers.OverviewController.countDeviceAndUser(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countDevice7Day/""" + "$" + """id<[^/]+>""", """controllers.OverviewController.countDevice7Day(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countUser7Day/""" + "$" + """id<[^/]+>""", """controllers.OverviewController.countUser7Day(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countMess7Day/""" + "$" + """id<[^/]+>""", """controllers.OverviewController.countMess7Day(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countDataLatency""", """controllers.OverviewController.countDataLatency()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """countDataSuccessRate""", """controllers.OverviewController.countDataSuccessRate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userList""", """controllers.UserController.userList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewUser""", """controllers.UserController.addNewUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTokenSendPassUser""", """controllers.UserController.getTokenSendPassUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editUser""", """controllers.UserController.editUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteUser""", """controllers.UserController.deleteUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addUserRole""", """controllers.UserController.addRoleForUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateUserOrg""", """controllers.UserController.updateUserOrg()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """healthCheck""", """controllers.Assets.at(path:String = "/public", file:String = "health.html")"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMail""", """controllers.ApiController.sendMail()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getJsonWidget/""" + "$" + """id<[^/]+>""", """controllers.ApiController.getJsonWidget(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """wsSocket""", """controllers.SocketController.wsSocket()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataWithParam""", """controllers.SendApiController.getDataWithParam()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """portDataWithParam""", """controllers.SendApiController.portDataWithParam()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """putDataWithParam""", """controllers.SendApiController.putDataWithParam()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upfileImage""", """controllers.SendApiController.upfileImage()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDataWithParam""", """controllers.SendApiController.deleteDataWithParam()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """downloadFile""", """controllers.DownloadFileController.downloadFileFromApi(param:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dashboard""", """controllers.DashboardController.dashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getMarkersWithPaging""", """controllers.DashboardController.getMarkersWithPaging()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceWithPaging""", """controllers.DashboardController.getListDeviceWithPaging()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loadDeviceDataCurrent/""" + "$" + """id<[^/]+>""", """controllers.DashboardController.loadDeviceDataCurrent(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dashboardVer2/""" + "$" + """id<[^/]+>""", """controllers.DashboardWidgetController.dashboardVer2(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceWithWidgetMap""", """controllers.DashboardWidgetController.getListDeviceWithWidgetMap()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDeviceDataCurrent""", """controllers.DashboardWidgetController.getDeviceDataCurrent(deviceId:String, latId:String, longId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryRpc""", """controllers.DashboardWidgetController.getHistoryRpc()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dashboardList/""" + "$" + """id<[^/]+>""", """controllers.DashboardV3Controller.dashboardList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDashboard""", """controllers.DashboardV3Controller.getListDashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewDashboard""", """controllers.DashboardV3Controller.addNewDashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editContentDashboard""", """controllers.DashboardV3Controller.editContentDashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDashboard""", """controllers.DashboardV3Controller.deleteDashboard()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dashboard/""" + "$" + """id<[^/]+>/""" + "$" + """dashboardId<[^/]+>""", """controllers.DashboardV3Controller.dashboard(id:String, dashboardId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDashboardWithId""", """controllers.DashboardV3Controller.getDashboardWithId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveDashboard""", """controllers.DashboardV3Controller.saveDashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """moveDashboardToOrg""", """controllers.DashboardV3Controller.moveDashboardToOrg()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/deviceManage/""" + "$" + """userId<[^/]+>""", """controllers.TelcoDeviceController.deviceManage(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """appDashboard/""" + "$" + """id<[^/]+>/""" + "$" + """dashboardId<[^/]+>/""" + "$" + """token<[^/]+>""", """controllers.DashboardAppController.appDashboard(id:String, dashboardId:String, token:String, deviceId:String ?= null, deviceToken:String ?= null)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDashboardWithIdApp""", """controllers.DashboardAppController.getDashboardWithId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getPositionDeviceByAttributeApp""", """controllers.DashboardAppController.getPositionDeviceByAttributeApp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceWithWidgetMapApp""", """controllers.DashboardAppController.getListDeviceWithWidgetMapApp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataAttributeByIdApp""", """controllers.DashboardAppController.getDataAttributeByIdApp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLastValueAttributeApp""", """controllers.DashboardAppController.getLastValueAttributeApp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessageOnOffApp""", """controllers.DashboardAppController.sendMessageOnOffApp()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """widgetPage/""" + "$" + """id<[^/]+>/""" + "$" + """idDashboard<[^/]+>""", """controllers.WidgetListController.widgetPage(id:String, idDashboard:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveWidgetData""", """controllers.WidgetListController.saveWidgetData()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getWidgetCurrent""", """controllers.WidgetListController.getWidgetCurrent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deviceIotList/""" + "$" + """id<[^/]+>""", """controllers.DeviceIotController.deviceIotList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewDevice""", """controllers.DeviceIotController.addNewDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createDeviceWithSerialSim""", """controllers.DeviceIotController.createDeviceWithSerialSim()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDevice""", """controllers.DeviceIotController.deleteDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editNameDevice""", """controllers.DeviceIotController.editNameDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateDevice""", """controllers.DeviceIotController.updateDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """configGpsDevice""", """controllers.DeviceIotController.configGpsDevice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getConfigOfDeviceIot/""" + "$" + """id<[^/]+>""", """controllers.DeviceIotController.getConfigOfDeviceIot(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceIot""", """controllers.DeviceIotController.getListDeviceIot()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceByGroup/""" + "$" + """id<[^/]+>""", """controllers.DeviceIotController.getListDeviceByGroup(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceVarByDevice/""" + "$" + """id<[^/]+>""", """controllers.DeviceIotController.getListDeviceVarsByDevice(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceByOrg/""" + "$" + """id<[^/]+>/""" + "$" + """projectId<[^/]+>""", """controllers.DeviceIotController.getListDeviceByOrg(id:String, projectId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceAndAttrByOrg/""" + "$" + """id<[^/]+>/""" + "$" + """projectId<[^/]+>""", """controllers.DeviceIotController.getListDeviceAndAttrByOrg(id:String, projectId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceByDeviceType/""" + "$" + """id<[^/]+>""", """controllers.DeviceIotController.getListDeviceByDeviceType(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """attributeDevice/""" + "$" + """id<[^/]+>/""" + "$" + """deviceId<[^/]+>""", """controllers.AttributeController.attributeDevice(id:String, deviceId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttributeList""", """controllers.AttributeController.getAttributeList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttributeHistory""", """controllers.AttributeController.getAttributeHistory()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """attributeUser/""" + "$" + """id<[^/]+>/""" + "$" + """userId<[^/]+>""", """controllers.AttributeController.attributeUser(id:String, userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """attributeEvent/""" + "$" + """id<[^/]+>/""" + "$" + """eventId<[^/]+>""", """controllers.AttributeController.attributeEvent(id:String, eventId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """attributeTemplate/""" + "$" + """id<[^/]+>/""" + "$" + """templateId<[^/]+>""", """controllers.AttributeController.attributeTemplate(id:String, templateId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """attributeGroup/""" + "$" + """id<[^/]+>/""" + "$" + """groupId<[^/]+>""", """controllers.AttributeController.attributeGroup(id:String, groupId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deviceVariable/""" + "$" + """projectId<[^/]+>/""" + "$" + """id<[^/]+>""", """controllers.DeviceVariableController.deviceVariable(projectId:String, id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addVariable""", """controllers.DeviceVariableController.addVariable()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delVariable""", """controllers.DeviceVariableController.delVariable()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataVariableById""", """controllers.DeviceVariableController.getDataVariableById()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListVarByIdDevice/""" + "$" + """id<[^/]+>""", """controllers.DeviceVariableController.getListVarByIdDevice(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addAttribute""", """controllers.AttributeController.addAttribute()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAttributeOrg""", """controllers.AttributeController.deleteAttributeOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editAttributeOrg""", """controllers.AttributeController.editAttributeOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataAttributeById""", """controllers.AttributeController.getDataAttributeById()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLastValueAttribute""", """controllers.AttributeController.getLastValueAttribute()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getPositionDeviceByAttribute""", """controllers.AttributeController.getPositionDeviceByAttribute()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getValueAttributeWithTime""", """controllers.AttributeController.getValueAttributeWithTime()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messagesDevice/""" + "$" + """id<[^/]+>""", """controllers.MessagesDeviceController.messagesDevice(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getMetadata""", """controllers.MessagesDeviceController.getMetadata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMetadata""", """controllers.MessagesDeviceController.sendMetadata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessageToDevice""", """controllers.MessagesDeviceController.sendMessageToDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getMessageFormDevice""", """controllers.MessagesDeviceController.getMessageFormDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postCreateDeviceToken""", """controllers.MessagesDeviceController.postCreateDeviceToken()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessageData""", """controllers.MessagesDeviceController.sendMessageData()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessageOnOff""", """controllers.MessagesDeviceController.sendMessageOnOff()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessageOnOffApp""", """controllers.MessagesDeviceController.sendMessageOnOffApp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendCommandRPC""", """controllers.MessagesDeviceController.sendCommandRPC()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logDeviceList""", """controllers.LogDeviceController.logDeviceList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllLogMessage""", """controllers.LogDeviceController.getAllLogMessage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deviceTypeList/""" + "$" + """id<[^/]+>""", """controllers.DeviceTypeController.deviceTypeList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewDeviceType""", """controllers.DeviceTypeController.addNewDeviceType()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDeviceType""", """controllers.DeviceTypeController.deleteDeviceType()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editDeviceType""", """controllers.DeviceTypeController.editDeviceType()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListTypes""", """controllers.DeviceTypeController.getListTypes()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deviceTemplate/""" + "$" + """id<[^/]+>""", """controllers.DeviceTemplateController.deviceTemplate(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createDeviceTemplate""", """controllers.DeviceTemplateController.createDeviceTemplate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceTemplate""", """controllers.DeviceTemplateController.getListDeviceTemplate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDeviceTemplate""", """controllers.DeviceTemplateController.deleteDeviceTemplate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createTemDevice""", """controllers.DeviceTemplateController.createTemDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListFlow""", """controllers.FlowEngineController.getListFlow()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addFlow""", """controllers.FlowEngineController.addFlow()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orginazationView/""" + "$" + """id<[^/]+>""", """controllers.OrginazationController.orginazationView(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orgList/""" + "$" + """id<[^/]+>""", """controllers.GroupController.orgList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoOrg""", """controllers.GroupController.getInfoOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttributeOrg""", """controllers.GroupController.getAttributeOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getChildByGroupId""", """controllers.GroupController.getGroupChildByGroupId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroupOfOrg""", """controllers.GroupController.getListGroupOfOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListUserOfOrg""", """controllers.GroupController.getListUserOfOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceOfOrg""", """controllers.GroupController.getListDeviceOfOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListEventOfOrg""", """controllers.GroupController.getListEventOfOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListRoleOfOrg""", """controllers.GroupController.getListRoleOfOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateOrg""", """controllers.GroupController.updateGroup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteOrg""", """controllers.GroupController.deleteGroup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRoleToGroupUser""", """controllers.GroupController.updateRoleToGroupUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateUserToGroupDevice""", """controllers.GroupController.updateUserToGroupDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addGroupRoot""", """controllers.GroupController.addGroupRoot()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListOrganizations/""" + "$" + """id<[^/]+>""", """controllers.GroupController.getListOrganizations(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """processMoveUserToGroupOther""", """controllers.GroupController.processMoveUserToGroupOther()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """processMoveDeviceToGroupOther""", """controllers.GroupController.processMoveDeviceToGroupOther()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserInOrg""", """controllers.GroupController.createUserInOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRoleForUser""", """controllers.GroupController.updateRoleForUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groupsList""", """controllers.GroupListController.groupsList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewGroups""", """controllers.GroupListController.addNewGroups()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteGroup""", """controllers.GroupListController.deleteGroup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editNameGroups""", """controllers.GroupListController.editNameGroups()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateOrgIdForGroups""", """controllers.GroupListController.updateOrgIdForGroups()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroups""", """controllers.GroupListController.getListGroups()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getGroupWithEntityType""", """controllers.GroupListController.getGroupWithEntityType()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroupUser""", """controllers.GroupListController.getListGroupUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroupDevice""", """controllers.GroupListController.getListGroupDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroupEvent""", """controllers.GroupListController.getListGroupEvent()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroupOrganization""", """controllers.GroupListController.getListGroupOrganization()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pageTestApi""", """controllers.HomeController.pageTestApi()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """testPostFormUrlencoded""", """controllers.HomeController.testPostFormUrlencoded()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """testPostJson""", """controllers.HomeController.testPostJson()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """testGetByToken""", """controllers.HomeController.testGetByToken()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDashboardByIdOrg""", """controllers.HomeController.getDashboardByIdOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDashboardByProjectId""", """controllers.HomeController.getDashboardByProjectId()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """roleList""", """controllers.RoleController.roleList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewRole""", """controllers.RoleController.addNewRole()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteRole""", """controllers.RoleController.deleteRole()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """roleDetail""", """controllers.RoleController.getRole()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRole""", """controllers.RoleController.updateRole()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """eventList""", """controllers.EventController.eventList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewEvent""", """controllers.EventController.addNewEvent()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewSchedule""", """controllers.EventController.addNewSchedule()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editEvent/""" + "$" + """id<[^/]+>""", """controllers.EventController.editEvent(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editSchedule/""" + "$" + """id<[^/]+>""", """controllers.EventController.editSchedule(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """onclickEvent""", """controllers.EventController.onclickEvent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """variableList""", """controllers.EventController.getVarsByDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteEvent""", """controllers.EventController.deleteEvent()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """eventDetail""", """controllers.EventController.getEvent()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """UpdateEvent""", """controllers.EventController.updateEvent()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """changeEventOrg""", """controllers.EventController.changeEventOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """removeEventOrg""", """controllers.EventController.removeEventOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activeEvent""", """controllers.EventController.activeEvent()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deActiveEvent""", """controllers.EventController.deActiveEvent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ruleEngine/""" + "$" + """id<[^/]+>""", """controllers.RuleChainController.ruleChain(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """flowEngineWithId/""" + "$" + """projectId<[^/]+>/""" + "$" + """idFlow<[^/]+>""", """controllers.RuleChainController.flowEngineWithId(projectId:String, idFlow:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """packData/""" + "$" + """id<[^/]+>""", """controllers.PayPackDataController.packData(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListPackdata""", """controllers.PayPackDataController.getListPackdata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNewPackdata""", """controllers.PayPackDataController.addNewPackdata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoPackdata""", """controllers.PayPackDataController.getInfoPackdata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editPackdata""", """controllers.PayPackDataController.editPackdata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletePackdata""", """controllers.PayPackDataController.deletePackdata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoVendor""", """controllers.PayCustomerController.getInfoVendor()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createVendor""", """controllers.PayCustomerController.createVendor()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateVendor""", """controllers.PayCustomerController.updateVendor()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getSubscription""", """controllers.PayCustomerController.getSubscription()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createSubscription""", """controllers.PayCustomerController.createSubscription()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cancelSubscription""", """controllers.PayCustomerController.cancelSubscription()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payCustomer/""" + "$" + """id<[^/]+>""", """controllers.PayCustomerController.payCustomer(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment/""" + "$" + """id<[^/]+>/""" + "$" + """userId<[^/]+>""", """controllers.PayCustomerController.payment(id:String, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListUserInOrg""", """controllers.PayCustomerController.getListUserInOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addPackdataNewForUser""", """controllers.PayCustomerController.addPackdataNewForUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postPricingOfCustomer""", """controllers.PayCustomerController.postPricingOfCustomer()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoCustomer""", """controllers.PayCustomerController.getInfoCustomer()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createInfoCustomer""", """controllers.PayCustomerController.createInfoCustomer()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateInfoCustomer""", """controllers.PayCustomerController.updateInfoCustomer()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """billList/""" + "$" + """id<[^/]+>""", """controllers.PayBillController.billList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllBill""", """controllers.PayBillController.getAllBill()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLinkPayment""", """controllers.PayBillController.getLinkPayment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoBill""", """controllers.PayBillController.getInfoBill()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """billUserList/""" + "$" + """id<[^/]+>/""" + "$" + """userId<[^/]+>""", """controllers.PayBillController.billUserList(id:String, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBillOfUser""", """controllers.PayBillController.getBillOfUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subsList/""" + "$" + """id<[^/]+>""", """controllers.PaySubsController.subsList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllSubs""", """controllers.PaySubsController.getAllSubs()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoSub""", """controllers.PaySubsController.getInfoSub()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLinkPaymentSub""", """controllers.PaySubsController.getLinkPaymentSub()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """manageSim/""" + "$" + """id<[^/]+>""", """controllers.ManageSimController.manageSim(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataCustomer""", """controllers.ManageSimController.getDataCustomer()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detailSim/""" + "$" + """projectId<[^/]+>/""" + "$" + """simnb<[^/]+>""", """controllers.ManageSimController.detailSim(projectId:String, simnb:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """devkit/""" + "$" + """id<[^/]+>""", """controllers.DevkitController.devkit(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """module/""" + "$" + """id<[^/]+>""", """controllers.ModuleController.module(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """appDebug/""" + "$" + """id<[^/]+>""", """controllers.AppDebugController.appDebug(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """appDebugPage""", """controllers.AppDebugController.appDebugPage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """appSdk/""" + "$" + """id<[^/]+>""", """controllers.AppDebugController.appSdk(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """appSdkPage""", """controllers.AppDebugController.appSdkPage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """solutionMaketPage""", """controllers.AppDebugController.solutionMaketPage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qrCodeList""", """controllers.QrCodeController.qrCodeList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createQrCode""", """controllers.QrCodeController.createQrCode()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qrCodeImg/""" + "$" + """id<[^/]+>""", """controllers.QrCodeController.qrCodeImg(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListQrCode""", """controllers.QrCodeController.getListQrCode()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteQrCode""", """controllers.QrCodeController.deleteQrCode()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qrCodeHistoryList""", """controllers.QrCodeController.qrCodeHistoryList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editQrCode""", """controllers.QrCodeController.editQrCode()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qrCodeCam""", """controllers.QrCodeCamController.qrCodeCam()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createQrCodeCam""", """controllers.QrCodeCamController.createQrCodeCam()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteQrCodeCam""", """controllers.QrCodeCamController.deleteQrCodeCam()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """oauth/login""", """controllers.OAuthController.getLogin(login_challenge:String ?= null)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """oauth/login""", """controllers.OAuthController.postLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """oauth/consent""", """controllers.OAuthController.getConsent(consent_challenge:String ?= null)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """oauth/consent""", """controllers.OAuthController.postConsent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """oauth/callback""", """controllers.OAuthController.callback(code:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """monitorMap/""" + "$" + """id<[^/]+>""", """controllers.SolutionTrackingController.monitorMap(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGpsDevice""", """controllers.SolutionTrackingController.getListGpsDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoDevice""", """controllers.SolutionTrackingController.getInfoDevice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyMap/""" + "$" + """id<[^/]+>""", """controllers.SolutionTrackingController.historyMap(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loadLocationHistory""", """controllers.SolutionTrackingController.loadLocationHistory()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """waterClock""", """controllers.WaterClockController.waterClock()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListClock""", """controllers.WaterClockController.getListClock()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryClock""", """controllers.WaterClockController.getHistoryClock()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """templateDeviceList""", """controllers.TemplateDeviceController.templateDeviceList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addTemplateDevice""", """controllers.TemplateDeviceController.addTemplateDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListTemplateDevice""", """controllers.TemplateDeviceController.getListTemplateDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTemplateDeviceById""", """controllers.TemplateDeviceController.getTemplateDeviceById()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editTemplateDevice""", """controllers.TemplateDeviceController.editTemplateDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteTemplateDeviceById""", """controllers.TemplateDeviceController.deleteTemplateDevice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminOverview""", """controllers.AdminOverviewController.adminOverview()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTotalOverview""", """controllers.AdminOverviewController.getTotalOverview()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postJsonTotalOverview""", """controllers.AdminOverviewController.postJsonTotalOverview()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoOVerviewSmarthome""", """controllers.AdminOverviewController.getInfoOVerviewSmarthome()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoOVerviewVtag""", """controllers.AdminOverviewController.getInfoOVerviewVtag()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoOVerviewFleet""", """controllers.AdminOverviewController.getInfoOVerviewFleet()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoOVerviewMetter""", """controllers.AdminOverviewController.getInfoOVerviewMetter()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListProjectWithPaging""", """controllers.AdminOverviewController.getListProjectWithPaging()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminManageSim""", """controllers.AdminManageSimController.adminManageSim()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllProjectWithPaging""", """controllers.AdminManageSimController.getAllProjectWithPaging()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListDeviceWithProjectId""", """controllers.AdminManageSimController.getListDeviceWithProjectId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAttrSimDevice""", """controllers.AdminManageSimController.getAttrSimDevice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """systemHealth""", """controllers.AdminSystemHealthController.systemHealth()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminOverviewProject/""" + "$" + """id<[^/]+>""", """controllers.AdminOverviewProjectController.adminOverviewProject(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registerDeveloperList""", """controllers.AdminRegisterDeveloperController.registerDeveloperList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registerDeveloperList""", """controllers.AdminRegisterDeveloperController.registerDeveloperFilterList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """exportRegisterDeveloperList""", """controllers.AdminRegisterDeveloperController.exportRegisterDeveloperList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteRegisterDeveloper""", """controllers.AdminRegisterDeveloperController.deleteRegisterDeveloper()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groupProductList""", """controllers.AdminGroupProductController.groupProductList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGroupProduct""", """controllers.AdminGroupProductController.getListGroupProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addGroupProduct""", """controllers.AdminGroupProductController.addGroupProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteGroupProduct""", """controllers.AdminGroupProductController.deleteGroupProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editGroupProduct""", """controllers.AdminGroupProductController.editGroupProduct()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """productList/""" + "$" + """id<[^/]+>""", """controllers.ProductListController.productList(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createProduct""", """controllers.ProductListController.createProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getProductByUser""", """controllers.ProductListController.getProductByUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteProduct""", """controllers.ProductListController.deleteProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getProductById""", """controllers.ProductListController.getProductById()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editProduct""", """controllers.ProductListController.editProduct()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """manageProductList""", """controllers.ProductListController.manageProductList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """manageProductList""", """controllers.ProductListController.manageProductFilterList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """changeStatusProduct""", """controllers.ProductListController.changeStatusProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requestApproveProduct""", """controllers.ProductListController.requestApproveProduct()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """marketPlace""", """controllers.MarketPlaceController.marketPlace()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """marketPlace/solution""", """controllers.MarketPlaceController.marketPlaceSolution()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """marketPlace/device""", """controllers.MarketPlaceController.marketPlaceDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getProductMarket""", """controllers.MarketPlaceController.getProductMarket()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllProduct""", """controllers.MarketPlaceController.getAllProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllGroupProduct""", """controllers.MarketPlaceController.getAllGroupProduct()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllGroupSolution""", """controllers.MarketPlaceController.getAllGroupSolution()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllGroupDevice""", """controllers.MarketPlaceController.getAllGroupDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllSolution""", """controllers.MarketPlaceController.getAllSolution()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllDevice""", """controllers.MarketPlaceController.getAllDevice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """marketPlace/product/""" + "$" + """id<[^/]+>""", """controllers.MarketPlaceController.detailProduct(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailProductWithId""", """controllers.MarketPlaceController.getDetailProductWithId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getSameProduct""", """controllers.MarketPlaceController.getSameProduct()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """productContactList""", """controllers.MarketPlaceContactController.productContactList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """productContactList""", """controllers.MarketPlaceContactController.productContactFilterList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendContactMarket""", """controllers.MarketPlaceContactController.sendContactMarket()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editContactMarket""", """controllers.MarketPlaceContactController.editContactMarket()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """commentWithProductId""", """controllers.MarketPlaceCommentController.commentWithProductId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListCommentProduct""", """controllers.MarketPlaceCommentController.getListCommentProduct()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userTenantList""", """controllers.UserTenantListController.userTenantList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListUserTenant""", """controllers.UserTenantListController.getListUserTenant()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserTenant""", """controllers.UserTenantListController.createUserTenant()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delUserTenant""", """controllers.UserTenantListController.delUserTenant()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editUserTenant""", """controllers.UserTenantListController.editUserTenant()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListRoleOfOrg""", """controllers.UserTenantListController.getListRoleOfOrg()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRoleUserPermission""", """controllers.UserTenantListController.updateRoleUserPermission()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delRoleUserPermission""", """controllers.UserTenantListController.delRoleUserPermission()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/orderSubs/""" + "$" + """userId<[^/]+>""", """controllers.TelcoOrderController.orderSubs(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataTelcoByUrl/""" + "$" + """url<[^/]+>""", """controllers.TelcoOrderController.getDataTelcoByUrl(url:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """checkValidateSerialSim""", """controllers.TelcoOrderController.checkValidateSerialSim()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListReasonFull""", """controllers.TelcoOrderController.getListReasonFull()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getConnectSubscriberRamdom""", """controllers.TelcoOrderController.getConnectSubscriberRamdom()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchSubscriberByStock""", """controllers.TelcoOrderController.searchSubscriberByStock()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blockIsdnVht""", """controllers.TelcoOrderController.blockIsdnVht()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """unlockIsdnVht""", """controllers.TelcoOrderController.unlockIsdnVht()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """connectSubscriberSim""", """controllers.TelcoOrderController.connectSubscriberSim()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListProductOffer""", """controllers.TelcoOrderController.getListProductOffer()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSaleService""", """controllers.TelcoOrderController.getListSaleService()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSaleService1""", """controllers.TelcoOrderController.getListSaleService1()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """processOrderBuySim""", """controllers.TelcoOrderController.processOrderBuySim()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apn/""" + "$" + """userId<[^/]+>""", """controllers.TelcoAPNController.APNview(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apn/getIpAllow/""" + "$" + """isdn<[^/]+>""", """controllers.TelcoAPNController.getIpAllow(isdn:String, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apn/getAPNByPhone""", """controllers.TelcoAPNController.getAPNByPhone()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apn/registerAPN""", """controllers.TelcoAPNController.registerAPN()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apn/unRegisterAPN""", """controllers.TelcoAPNController.unRegisterAPN()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/buySim/""" + "$" + """userId<[^/]+>""", """controllers.TelcoOrderController.buySim(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/manageOrder/""" + "$" + """userId<[^/]+>""", """controllers.TelcoOrderController.manageOrder(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListOrderBuySim""", """controllers.TelcoOrderController.getListOrderBuySim()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upfilePycTelco""", """controllers.TelcoOrderController.upfilePycTelco()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCustomerType""", """controllers.TelcoOrderController.getCustomerType()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListCt""", """controllers.TelcoOrderController.getListCt()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logConnectSim/""" + "$" + """userId<[^/]+>""", """controllers.TelcoLogController.logConnectSim(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLogConnectSim""", """controllers.TelcoLogController.getLogConnectSim()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/dashboard/""" + "$" + """userId<[^/]+>""", """controllers.TelcoDashboardController.telcoDashboard(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataDashboardTelco""", """controllers.TelcoDashboardController.getDataDashboardTelco()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataDashboardWithMonth""", """controllers.TelcoDashboardController.getDataDashboardWithMonth()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTop5DataUsersOfMonth""", """controllers.TelcoDashboardController.getTop5DataUsersOfMonth()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAlertDashboard""", """controllers.TelcoDashboardController.getAlertDashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailAlertDashboard""", """controllers.TelcoDashboardController.getDetailAlertDashboard()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getSubscriberStatistics""", """controllers.TelcoDashboardController.getSubscriberStatistics()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBalanceDashboardTelco""", """controllers.TelcoDashboardController.getBalanceDashboardTelco()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSubsDashboardByKey""", """controllers.TelcoDashboardController.getListSubsDashboardByKey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSubsDashboardBlockDebit""", """controllers.TelcoDashboardController.getListSubsDashboardBlockDebit()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailRedAlert""", """controllers.TelcoDashboardController.getDetailRedAlert()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailPrepaidExpired""", """controllers.TelcoDashboardController.getDetailPrepaidExpired()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailLowRemainingData""", """controllers.TelcoDashboardController.getDetailLowRemainingData()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailPackageExpired""", """controllers.TelcoDashboardController.getDetailPackageExpired()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/accountInfo/""" + "$" + """userId<[^/]+>""", """controllers.TelcoAccountController.accountInfo(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateAccountInfo""", """controllers.TelcoAccountController.updateDetailAccountTelco()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateInfoCompanyTelco""", """controllers.TelcoAccountController.updateInfoCompanyTelco()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteInfoCompany""", """controllers.TelcoAccountController.deleteInfoCompany()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoAccount""", """controllers.TelcoAccountController.getInfoAccount()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoCompany""", """controllers.TelcoAccountController.getInfoCompany()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoCompanyEnterprise""", """controllers.TelcoAccountController.getInfoCompanyEnterpriseLv2()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListArea""", """controllers.TelcoAccountController.getListArea()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoGpkdApproved""", """controllers.TelcoAccountController.getInfoGpkdApproved()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCategoryBusinessAndDevice""", """controllers.TelcoAccountController.getCategoryBusinessAndDevice()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateCategoryBusinessAndDevice""", """controllers.TelcoAccountController.updateCategoryBusinessAndDevice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getSearchOrder/""" + "$" + """orderId<[^/]+>""", """controllers.OrderSearchController.getSearchOrder(orderId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """approvedInfoCompanyTelco""", """controllers.AdminTelcoController.approvedInfoCompanyTelco()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListInfoApproved""", """controllers.AdminTelcoController.getListInfoApproved()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """processComfirmInfoAccountCmp""", """controllers.AdminTelcoController.processComfirmInfoAccountCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """processComfirmInfoCompany""", """controllers.AdminTelcoController.processComfirmInfoCompany()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListEnterpriseByBrowser""", """controllers.AdminTelcoController.getListEnterpriseByBrowser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListEnterpriseSubmitOfAdminSpe""", """controllers.AdminTelcoController.getListEnterpriseSubmitOfAdminSpe()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/subscriberManage/""" + "$" + """userId<[^/]+>""", """controllers.TelcoSubscriberController.subscriberManage(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSubscriber""", """controllers.TelcoSubscriberController.getListSubscriber()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSubsByBeVht""", """controllers.TelcoSubscriberController.getListSubsByBeVht()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDetailSubscriber""", """controllers.TelcoSubscriberController.getDetailSubscriber()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscriberDetail/""" + "$" + """id<[^/]+>/""" + "$" + """subs<[^/]+>""", """controllers.TelcoSubscriberController.subscriberDetail(id:String, subs:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListProductOffering""", """controllers.TelcoSubscriberController.getListProductOffering()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoDataAccount""", """controllers.TelcoSubscriberController.getInfoDataAccount()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTotalSubscriber""", """controllers.TelcoSubscriberController.getTotalSubscriber()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHybridInfo""", """controllers.TelcoSubscriberController.getHybridInfo()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCtkm""", """controllers.TelcoSubscriberController.getCtkm()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBalanceInfo""", """controllers.TelcoSubscriberController.getBalanceInfo()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDebitSubscriber""", """controllers.TelcoSubscriberController.getDebitSubscriber()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getKttkAndKtmi""", """controllers.TelcoSubscriberController.getKttkAndKtmi()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blockSubcriber""", """controllers.TelcoSubscriberController.blockSubcriber()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """openSubcriber""", """controllers.TelcoSubscriberController.openSubcriber()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """open2wSubcriber""", """controllers.TelcoSubscriberController.open2wSubcriber()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/contractManage/""" + "$" + """userId<[^/]+>""", """controllers.TelcoContractController.contractManage(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListAccountContract""", """controllers.TelcoContractController.getListAccountContract()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDebitContract""", """controllers.TelcoContractController.getDebitContract()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTotalAccount""", """controllers.TelcoContractController.getTotalAccount()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListContractByIdNo""", """controllers.TelcoContractController.getListContractByIdNo()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/utilitiesManage/""" + "$" + """userId<[^/]+>""", """controllers.TelcoUtilitiesController.utilitiesManage(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/utilitiesTopup/""" + "$" + """userId<[^/]+>""", """controllers.TelcoUtilitiesController.utilitiesTopup(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/utilitiesBlock/""" + "$" + """userId<[^/]+>""", """controllers.TelcoUtilitiesController.utilitiesBlock(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/utilitiesBuyPackage/""" + "$" + """userId<[^/]+>""", """controllers.TelcoUtilitiesController.utilitiesBuyPackage(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListPackMiAndAddOn""", """controllers.TelcoUtilitiesController.getListPackMiAndAddOn()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registerMiAddon""", """controllers.TelcoUtilitiesController.registerMiAddon()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """unregisterMiAddon""", """controllers.TelcoUtilitiesController.unregisterMiAddon()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """unextendMiAddon""", """controllers.TelcoUtilitiesController.unextendMiAddon()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoOrderId""", """controllers.TelcoUtilitiesController.getInfoOrderId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rechargeSubcriber""", """controllers.TelcoUtilitiesController.rechargeSubcriber()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListOrderIdByAction""", """controllers.TelcoUtilitiesController.getListOrderIdByAction()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryBlockUnblock""", """controllers.TelcoUtilitiesController.getHistoryBlockUnblock()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateSubs""", """controllers.TelcoUtilitiesController.validateSubs()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """prepayCharges""", """controllers.TelcoUtilitiesController.prepayCharges(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """prepayCharges/bill/""" + "$" + """userId<[^/]+>/""" + "$" + """isdn<[^/]+>/""" + "$" + """orderId<[^/]+>""", """controllers.TelcoUtilitiesController.prepayChargesBill(userId:String, isdn:String, orderId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDataPrepaidInfo""", """controllers.TelcoUtilitiesController.getDataPrepaidInfo(prom_code:String, product_code:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rechargePrepaid""", """controllers.TelcoUtilitiesController.rechargePrepaid()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryPrepayCharges""", """controllers.TelcoUtilitiesController.getHistoryPrepayCharges()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/payPostpaidBill/""" + "$" + """userId<[^/]+>""", """controllers.TelcoUtilitiesController.payPostpaidBill(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payDebit""", """controllers.TelcoUtilitiesController.payDebit()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/payPostpaidBill/detail/""" + "$" + """userId<[^/]+>/""" + "$" + """orderId<[^/]+>""", """controllers.TelcoUtilitiesController.payPostpaidBillDetail(userId:String, orderId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryPayPostBill""", """controllers.TelcoUtilitiesController.getHistoryPayPostBill()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """invoiceOfContract/""" + "$" + """userId<[^/]+>/""" + "$" + """invoice<[^/]+>""", """controllers.TelcoInvoiceController.invoiceOfContract(userId:String, invoice:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListInvoiceOfContract""", """controllers.TelcoInvoiceController.getListInvoiceOfContract()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLinkDownloadInvoice""", """controllers.TelcoInvoiceController.getLinkDownloadInvoice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/apiKey/""" + "$" + """userId<[^/]+>""", """controllers.TelcoApiKeyController.apiKeyManage(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListApiKey""", """controllers.TelcoApiKeyController.getListApiKey()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/accountList""", """controllers.TelcoRoleAccountController.accountList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListAccountCmp""", """controllers.TelcoRoleAccountController.getListAccountCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addAccountCmp""", """controllers.TelcoRoleAccountController.addAccountCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addAccountCmpV2""", """controllers.TelcoRoleAccountController.addAccountCmpV2()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/infoAccountCmp/""" + "$" + """id<[^/]+>""", """controllers.TelcoRoleAccountController.infoAccountCmp(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoAccountCmp""", """controllers.TelcoRoleAccountController.getInfoAccountCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """generatePassAccountCmp""", """controllers.TelcoRoleAccountController.generatePassAccountCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addEnterpriseBySAdmin""", """controllers.TelcoRoleAccountController.addEnterpriseBySAdmin()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addEnterpriseByAdminOrSEnterprise""", """controllers.TelcoRoleAccountController.addEnterpriseByAdminOrSEnterprise()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteEnterprise""", """controllers.TelcoRoleAccountController.deleteEnterprise()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editEnterprise""", """controllers.TelcoRoleAccountController.editEnterprise()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateEnterprise""", """controllers.TelcoRoleAccountController.updateEnterprise()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAccountCmp""", """controllers.TelcoRoleAccountController.deleteAccountCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateGpkd""", """controllers.TelcoRoleAccountController.validateGpkd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateGpkdExist""", """controllers.TelcoRoleAccountController.checkValidateGpkd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatRoleAccountCmp""", """controllers.TelcoRoleAccountController.updatRoleAccountCmp()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qrcodeList""", """controllers.TelcoQrcodeController.qrcodeList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListQrcodeCmp""", """controllers.TelcoQrcodeController.getListQrcodeCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """checkValidateSerialAdm1""", """controllers.TelcoQrcodeController.checkValidateSerialAdm1()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListGpkd""", """controllers.TelcoQrcodeController.getListGpkd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveFileChungTu""", """controllers.TelcoQrcodeController.saveFileChungTu()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createQrcode""", """controllers.TelcoQrcodeController.createQrcode()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """provisioning/qr/""" + "$" + """id<[^/]+>""", """controllers.TelcoQrcodeController.qrCodeConnect(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoConnectSubs""", """controllers.TelcoQrcodeController.getInfoConnectSubs()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paymentConnectSubs""", """controllers.TelcoQrcodeController.paymentConnectSubs()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delQrcodeById""", """controllers.TelcoQrcodeController.delQrcodeById()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyPackMiAddon/""" + "$" + """userId<[^/]+>""", """controllers.TelcoHistoryController.historyPackMiAddon(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyDeposit/""" + "$" + """userId<[^/]+>""", """controllers.TelcoHistoryController.historyDeposit(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyPrepayCharges/""" + "$" + """userId<[^/]+>""", """controllers.TelcoHistoryController.historyPrepayCharges(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyAPN/""" + "$" + """userId<[^/]+>""", """controllers.TelcoHistoryController.historyApn(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyBlockUnblock/""" + "$" + """userId<[^/]+>""", """controllers.TelcoHistoryController.historyBlockUnblock(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryPackMiAddon""", """controllers.TelcoHistoryController.getHistoryPackMiAddon()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHistoryAPN""", """controllers.TelcoHistoryController.getHistoryApn()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """historyPostPaidBill/""" + "$" + """userId<[^/]+>""", """controllers.TelcoHistoryController.historyPostPaidBill(userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/listChildUser/""" + "$" + """userId<[^/]+>""", """controllers.TelcoChildUserController.listChildUser(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListChildUser""", """controllers.TelcoChildUserController.getListChildUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addChildUserCmp/""" + "$" + """userId<[^/]+>""", """controllers.TelcoChildUserController.addChildUserCmp(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getRolesOfChildUser""", """controllers.TelcoChildUserController.getRolesOfChildUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRolesOfChildUser""", """controllers.TelcoChildUserController.updateRolesOfChildUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """childUserDetail/""" + "$" + """userId<[^/]+>/""" + "$" + """childUserId<[^/]+>/""" + "$" + """email<[^/]+>""", """controllers.TelcoChildUserController.childUserDetail(userId:String, childUserId:String, email:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getListSubsOfChildUser""", """controllers.TelcoChildUserController.getListSubsOfChildUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addSubToChildUser""", """controllers.TelcoChildUserController.addSubToChildUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addSubToChildUser1""", """controllers.TelcoChildUserController.addSubToChildUser1()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateSubToChildUser1""", """controllers.TelcoChildUserController.validateSubToChildUser1()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """removeSubOfChildUser""", """controllers.TelcoChildUserController.removeSubOfChildUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """feedback/""" + "$" + """userId<[^/]+>""", """controllers.TelcoFeedbackController.feedback(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendFeedback""", """controllers.TelcoFeedbackController.sendFeedback()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logFeedback""", """controllers.TelcoFeedbackController.logFeedback()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLogListFeedback""", """controllers.TelcoFeedbackController.getLogListFeedback()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logCmp""", """controllers.TelcoLogController.logCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLogListCmp""", """controllers.TelcoLogController.getLogListCmp()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateFormCustomerSurvey""", """controllers.TelcoLogController.updateFormCustomerSurvey()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logCustomerSurvey""", """controllers.TelcoLogController.logCustomerSurvey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLogListCustomerSurvey""", """controllers.TelcoLogController.getLogListCustomerSurvey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editSurvey""", """controllers.TelcoLogController.editSurvey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteSurvey""", """controllers.TelcoLogController.deleteSurvey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getInfoSurvey""", """controllers.TelcoLogController.getInfoSurvey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """exportLogCustomerSurvey""", """controllers.TelcoLogController.exportLogCustomerSurvey()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveFormCustomerSurvey""", """controllers.TelcoLogController.saveFormCustomerSurvey()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """aepUtilities/""" + "$" + """userId<[^/]+>""", """controllers.TelcoAepController.aepUtilities(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requestDataAepWeather""", """controllers.TelcoAepController.requestDataAepWeather()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requestDataAepGps""", """controllers.TelcoAepController.requestDataAepGps()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telcoLocation/""" + "$" + """userId<[^/]+>""", """controllers.TelcoLocationController.telcoLocation(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchByIsdn""", """controllers.TelcoLocationController.searchByIsdn()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/invoiceManage/""" + "$" + """userId<[^/]+>""", """controllers.InvoiceManagerController.invoiceManage(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/getInvoices""", """controllers.InvoiceManagerController.getInvoices()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/getInvoiceBase64""", """controllers.InvoiceManagerController.getInvoiceBase64()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/report/subscriberBanned/""" + "$" + """userId<[^/]+>""", """controllers.TelcoStatisticalReportController.RedBaring(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/report/getRedBarings""", """controllers.TelcoStatisticalReportController.getRedBarings()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/report/pakageTime/""" + "$" + """userId<[^/]+>""", """controllers.TelcoStatisticalReportController.ExpiratedPackage(userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """telco/report/getExpiratedPackages""", """controllers.TelcoStatisticalReportController.getExpiratedPackages()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] lazy val controllers_LandingPageController_home0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_LandingPageController_home0_invoker = createInvoker(
    LandingPageController_67.home(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "home",
      Nil,
      "GET",
      this.prefix + """""",
      """ Routes
 This file defines all application routes (Higher priority routes first)
 ~~~~""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_OrderSearchController_OrderSearchView1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tra_cuu_don_hang")))
  )
  private[this] lazy val controllers_OrderSearchController_OrderSearchView1_invoker = createInvoker(
    OrderSearchController_57.OrderSearchView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderSearchController",
      "OrderSearchView",
      Nil,
      "GET",
      this.prefix + """tra_cuu_don_hang""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_LandingPageController_landingPage2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("landingPage")))
  )
  private[this] lazy val controllers_LandingPageController_landingPage2_invoker = createInvoker(
    LandingPageController_67.landingPage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "landingPage",
      Nil,
      "GET",
      this.prefix + """landingPage""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_LandingPageController_submitFormContactTelco3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitFormContactTelco")))
  )
  private[this] lazy val controllers_LandingPageController_submitFormContactTelco3_invoker = createInvoker(
    LandingPageController_67.submitFormContactTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "submitFormContactTelco",
      Nil,
      "POST",
      this.prefix + """submitFormContactTelco""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LandingPageController_getListProductOfferPack4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListProductOfferPack")))
  )
  private[this] lazy val controllers_LandingPageController_getListProductOfferPack4_invoker = createInvoker(
    LandingPageController_67.getListProductOfferPack(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "getListProductOfferPack",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """getListProductOfferPack""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_LandingPageController_submitFormContact5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitFormContact")))
  )
  private[this] lazy val controllers_LandingPageController_submitFormContact5_invoker = createInvoker(
    LandingPageController_67.submitFormContact(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "submitFormContact",
      Nil,
      "POST",
      this.prefix + """submitFormContact""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_LandingPageController_submitRegisterDeveloper6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitRegisterDeveloper")))
  )
  private[this] lazy val controllers_LandingPageController_submitRegisterDeveloper6_invoker = createInvoker(
    LandingPageController_67.submitRegisterDeveloper(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "submitRegisterDeveloper",
      Nil,
      "POST",
      this.prefix + """submitRegisterDeveloper""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_LandingPageController_registerDeveloper7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registerDeveloper")))
  )
  private[this] lazy val controllers_LandingPageController_registerDeveloper7_invoker = createInvoker(
    LandingPageController_67.registerDeveloper(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LandingPageController",
      "registerDeveloper",
      Nil,
      "GET",
      this.prefix + """registerDeveloper""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_login8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login8_invoker = createInvoker(
    Application_71.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_authenticateDemo9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loginDemo")))
  )
  private[this] lazy val controllers_Application_authenticateDemo9_invoker = createInvoker(
    Application_71.authenticateDemo(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "authenticateDemo",
      Nil,
      "GET",
      this.prefix + """loginDemo""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_setLang10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lang/"), DynamicPart("lang", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_setLang10_invoker = createInvoker(
    Application_71.setLang(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "setLang",
      Seq(classOf[String]),
      "GET",
      this.prefix + """lang/""" + "$" + """lang<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Application_checkIpLogin11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkIpLogin")))
  )
  private[this] lazy val controllers_Application_checkIpLogin11_invoker = createInvoker(
    Application_71.checkIpLogin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "checkIpLogin",
      Nil,
      "POST",
      this.prefix + """checkIpLogin""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Application_verifyPhone12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("verifyPhone")))
  )
  private[this] lazy val controllers_Application_verifyPhone12_invoker = createInvoker(
    Application_71.verifyPhone(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "verifyPhone",
      Nil,
      "POST",
      this.prefix + """verifyPhone""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Application_ChangePass13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ChangePass")))
  )
  private[this] lazy val controllers_Application_ChangePass13_invoker = createInvoker(
    Application_71.ChangePass(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "ChangePass",
      Nil,
      "GET",
      this.prefix + """ChangePass""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Application_createAccount14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createAccount")))
  )
  private[this] lazy val controllers_Application_createAccount14_invoker = createInvoker(
    Application_71.createAccount(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "createAccount",
      Nil,
      "GET",
      this.prefix + """createAccount""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Application_authenticate15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_authenticate15_invoker = createInvoker(
    Application_71.authenticate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "authenticate",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Application_logout16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_Application_logout16_invoker = createInvoker(
    Application_71.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_register17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_Application_register17_invoker = createInvoker(
    Application_71.register(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "register",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Application_newRegisterPost18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newRegisterPost")))
  )
  private[this] lazy val controllers_Application_newRegisterPost18_invoker = createInvoker(
    Application_71.newRegisterPost(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "newRegisterPost",
      Nil,
      "POST",
      this.prefix + """newRegisterPost""",
      """POST    /registerPost               controllers.Application.registerPost()""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Application_forgotPassPage19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password")))
  )
  private[this] lazy val controllers_Application_forgotPassPage19_invoker = createInvoker(
    Application_71.forgotPassPage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "forgotPassPage",
      Nil,
      "GET",
      this.prefix + """password""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_FogotPassController_userGetCodeChangePass20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userGetCodeChangePass")))
  )
  private[this] lazy val controllers_FogotPassController_userGetCodeChangePass20_invoker = createInvoker(
    FogotPassController_8.userGetCodeChangePass(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FogotPassController",
      "userGetCodeChangePass",
      Nil,
      "POST",
      this.prefix + """userGetCodeChangePass""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Application_ForgetPassword21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ForgetPassword")))
  )
  private[this] lazy val controllers_Application_ForgetPassword21_invoker = createInvoker(
    Application_71.ForgetPassword(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "ForgetPassword",
      Nil,
      "POST",
      this.prefix + """ForgetPassword""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_FogotPassController_ChangePassword22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ChangePassword")))
  )
  private[this] lazy val controllers_FogotPassController_ChangePassword22_invoker = createInvoker(
    FogotPassController_8.ChangePassword(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FogotPassController",
      "ChangePassword",
      Nil,
      "POST",
      this.prefix + """ChangePassword""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Application_getOtpEmail23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getOtpEmail")))
  )
  private[this] lazy val controllers_Application_getOtpEmail23_invoker = createInvoker(
    Application_71.getOtpEmail(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getOtpEmail",
      Nil,
      "POST",
      this.prefix + """getOtpEmail""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_Application_getOtpPhone24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getOtpPhone")))
  )
  private[this] lazy val controllers_Application_getOtpPhone24_invoker = createInvoker(
    Application_71.getOtpPhone(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getOtpPhone",
      Nil,
      "POST",
      this.prefix + """getOtpPhone""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_Application_version25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("version")))
  )
  private[this] lazy val controllers_Application_version25_invoker = createInvoker(
    Application_71.version(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "version",
      Nil,
      "GET",
      this.prefix + """version""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_HomeController_termsOfUse26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("termsOfUse")))
  )
  private[this] lazy val controllers_HomeController_termsOfUse26_invoker = createInvoker(
    HomeController_10.termsOfUse(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "termsOfUse",
      Nil,
      "GET",
      this.prefix + """termsOfUse""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_Application_sitemap27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("innoway-sitemap.xml")))
  )
  private[this] lazy val controllers_Application_sitemap27_invoker = createInvoker(
    Application_71.sitemap(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sitemap",
      Nil,
      "GET",
      this.prefix + """innoway-sitemap.xml""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_Assets_at28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sitemap.xml")))
  )
  private[this] lazy val controllers_Assets_at28_invoker = createInvoker(
    Assets_63.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """sitemap.xml""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_Assets_at29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sitemap_index.xml")))
  )
  private[this] lazy val controllers_Assets_at29_invoker = createInvoker(
    Assets_63.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """sitemap_index.xml""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_Assets_at30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("robots.txt")))
  )
  private[this] lazy val controllers_Assets_at30_invoker = createInvoker(
    Assets_63.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """robots.txt""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_Assets_at31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dieu-khoan.txt")))
  )
  private[this] lazy val controllers_Assets_at31_invoker = createInvoker(
    Assets_63.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """dieu-khoan.txt""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_Assets_versioned32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned32_invoker = createInvoker(
    Assets_63.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_JsController_jsMessages33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages.js")))
  )
  private[this] lazy val controllers_JsController_jsMessages33_invoker = createInvoker(
    JsController_22.jsMessages(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.JsController",
      "jsMessages",
      Nil,
      "GET",
      this.prefix + """messages.js""",
      """i18n""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_JsController_javascriptRoutes34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("javascriptRoutes")))
  )
  private[this] lazy val controllers_JsController_javascriptRoutes34_invoker = createInvoker(
    JsController_22.javascriptRoutes(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.JsController",
      "javascriptRoutes",
      Nil,
      "GET",
      this.prefix + """javascriptRoutes""",
      """Javascript Route""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_HomeController_getImg35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getImg/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getImg35_invoker = createInvoker(
    HomeController_10.getImg(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getImg",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getImg/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_HomeController_success36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("success")))
  )
  private[this] lazy val controllers_HomeController_success36_invoker = createInvoker(
    HomeController_10.success(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "success",
      Nil,
      "GET",
      this.prefix + """success""",
      """""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_HomeController_cancel37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cancel")))
  )
  private[this] lazy val controllers_HomeController_cancel37_invoker = createInvoker(
    HomeController_10.cancel(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "cancel",
      Nil,
      "GET",
      this.prefix + """cancel""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_HomeController_provision38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("provision")))
  )
  private[this] lazy val controllers_HomeController_provision38_invoker = createInvoker(
    HomeController_10.provision(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "provision",
      Nil,
      "GET",
      this.prefix + """provision""",
      """""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_HomeController_pageSuccess39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pageSuccess")))
  )
  private[this] lazy val controllers_HomeController_pageSuccess39_invoker = createInvoker(
    HomeController_10.pageSuccess(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "pageSuccess",
      Nil,
      "GET",
      this.prefix + """pageSuccess""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_DownloadPageController_download40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("download")))
  )
  private[this] lazy val controllers_DownloadPageController_download40_invoker = createInvoker(
    DownloadPageController_6.download(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DownloadPageController",
      "download",
      Nil,
      "GET",
      this.prefix + """download""",
      """download""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_ProjectController_project41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("project")))
  )
  private[this] lazy val controllers_ProjectController_project41_invoker = createInvoker(
    ProjectController_40.project(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "project",
      Nil,
      "GET",
      this.prefix + """project""",
      """project""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_ProjectController_getProject42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getProject")))
  )
  private[this] lazy val controllers_ProjectController_getProject42_invoker = createInvoker(
    ProjectController_40.getProject(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "getProject",
      Nil,
      "POST",
      this.prefix + """getProject""",
      """""",
      Seq()
    )
  )

  // @LINE:61
  private[this] lazy val controllers_ProjectController_createProjectForm43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createProjectForm")))
  )
  private[this] lazy val controllers_ProjectController_createProjectForm43_invoker = createInvoker(
    ProjectController_40.createProjectForm(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "createProjectForm",
      Nil,
      "POST",
      this.prefix + """createProjectForm""",
      """""",
      Seq()
    )
  )

  // @LINE:62
  private[this] lazy val controllers_ProjectController_addProject44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addProject")))
  )
  private[this] lazy val controllers_ProjectController_addProject44_invoker = createInvoker(
    ProjectController_40.addProject(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "addProject",
      Nil,
      "POST",
      this.prefix + """addProject""",
      """""",
      Seq()
    )
  )

  // @LINE:63
  private[this] lazy val controllers_ProjectController_editProject45_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editProject")))
  )
  private[this] lazy val controllers_ProjectController_editProject45_invoker = createInvoker(
    ProjectController_40.editProject(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "editProject",
      Nil,
      "POST",
      this.prefix + """editProject""",
      """""",
      Seq()
    )
  )

  // @LINE:64
  private[this] lazy val controllers_ProjectController_delProject46_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delProject")))
  )
  private[this] lazy val controllers_ProjectController_delProject46_invoker = createInvoker(
    ProjectController_40.delProject(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "delProject",
      Nil,
      "POST",
      this.prefix + """delProject""",
      """""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_ProjectController_getNameProject47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getNameProject/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProjectController_getNameProject47_invoker = createInvoker(
    ProjectController_40.getNameProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "getNameProject",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getNameProject/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:66
  private[this] lazy val controllers_ProjectController_sendPostJsonProjectTemplate48_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendJsonProjectTemplate")))
  )
  private[this] lazy val controllers_ProjectController_sendPostJsonProjectTemplate48_invoker = createInvoker(
    ProjectController_40.sendPostJsonProjectTemplate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "sendPostJsonProjectTemplate",
      Nil,
      "POST",
      this.prefix + """sendJsonProjectTemplate""",
      """""",
      Seq()
    )
  )

  // @LINE:67
  private[this] lazy val controllers_ProjectController_sendPutJsonProjectTemplate49_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendPutJsonProjectTemplate")))
  )
  private[this] lazy val controllers_ProjectController_sendPutJsonProjectTemplate49_invoker = createInvoker(
    ProjectController_40.sendPutJsonProjectTemplate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "sendPutJsonProjectTemplate",
      Nil,
      "POST",
      this.prefix + """sendPutJsonProjectTemplate""",
      """""",
      Seq()
    )
  )

  // @LINE:68
  private[this] lazy val controllers_ProjectController_createDashboardTemplate50_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createDashboardTemplate")))
  )
  private[this] lazy val controllers_ProjectController_createDashboardTemplate50_invoker = createInvoker(
    ProjectController_40.createDashboardTemplate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "createDashboardTemplate",
      Nil,
      "POST",
      this.prefix + """createDashboardTemplate""",
      """""",
      Seq()
    )
  )

  // @LINE:69
  private[this] lazy val controllers_ProjectController_getListTag51_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListTag")))
  )
  private[this] lazy val controllers_ProjectController_getListTag51_invoker = createInvoker(
    ProjectController_40.getListTag(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "getListTag",
      Nil,
      "GET",
      this.prefix + """getListTag""",
      """""",
      Seq()
    )
  )

  // @LINE:70
  private[this] lazy val controllers_ProjectController_activePhone52_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activePhone")))
  )
  private[this] lazy val controllers_ProjectController_activePhone52_invoker = createInvoker(
    ProjectController_40.activePhone(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "activePhone",
      Nil,
      "POST",
      this.prefix + """activePhone""",
      """""",
      Seq()
    )
  )

  // @LINE:73
  private[this] lazy val controllers_OverviewController_overview53_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("overview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OverviewController_overview53_invoker = createInvoker(
    OverviewController_27.overview(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "overview",
      Seq(classOf[String]),
      "GET",
      this.prefix + """overview/""" + "$" + """id<[^/]+>""",
      """overview""",
      Seq()
    )
  )

  // @LINE:74
  private[this] lazy val controllers_OverviewController_countDeviceAndUser54_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countDeviceAndUser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OverviewController_countDeviceAndUser54_invoker = createInvoker(
    OverviewController_27.countDeviceAndUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "countDeviceAndUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """countDeviceAndUser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:75
  private[this] lazy val controllers_OverviewController_countDevice7Day55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countDevice7Day/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OverviewController_countDevice7Day55_invoker = createInvoker(
    OverviewController_27.countDevice7Day(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "countDevice7Day",
      Seq(classOf[String]),
      "GET",
      this.prefix + """countDevice7Day/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:76
  private[this] lazy val controllers_OverviewController_countUser7Day56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countUser7Day/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OverviewController_countUser7Day56_invoker = createInvoker(
    OverviewController_27.countUser7Day(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "countUser7Day",
      Seq(classOf[String]),
      "GET",
      this.prefix + """countUser7Day/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:77
  private[this] lazy val controllers_OverviewController_countMess7Day57_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countMess7Day/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OverviewController_countMess7Day57_invoker = createInvoker(
    OverviewController_27.countMess7Day(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "countMess7Day",
      Seq(classOf[String]),
      "GET",
      this.prefix + """countMess7Day/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:78
  private[this] lazy val controllers_OverviewController_countDataLatency58_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countDataLatency")))
  )
  private[this] lazy val controllers_OverviewController_countDataLatency58_invoker = createInvoker(
    OverviewController_27.countDataLatency(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "countDataLatency",
      Nil,
      "POST",
      this.prefix + """countDataLatency""",
      """""",
      Seq()
    )
  )

  // @LINE:79
  private[this] lazy val controllers_OverviewController_countDataSuccessRate59_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("countDataSuccessRate")))
  )
  private[this] lazy val controllers_OverviewController_countDataSuccessRate59_invoker = createInvoker(
    OverviewController_27.countDataSuccessRate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OverviewController",
      "countDataSuccessRate",
      Nil,
      "POST",
      this.prefix + """countDataSuccessRate""",
      """""",
      Seq()
    )
  )

  // @LINE:81
  private[this] lazy val controllers_UserController_userList60_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userList")))
  )
  private[this] lazy val controllers_UserController_userList60_invoker = createInvoker(
    UserController_38.userList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "userList",
      Nil,
      "GET",
      this.prefix + """userList""",
      """""",
      Seq()
    )
  )

  // @LINE:82
  private[this] lazy val controllers_UserController_addNewUser61_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewUser")))
  )
  private[this] lazy val controllers_UserController_addNewUser61_invoker = createInvoker(
    UserController_38.addNewUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addNewUser",
      Nil,
      "POST",
      this.prefix + """addNewUser""",
      """""",
      Seq()
    )
  )

  // @LINE:83
  private[this] lazy val controllers_UserController_getTokenSendPassUser62_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTokenSendPassUser")))
  )
  private[this] lazy val controllers_UserController_getTokenSendPassUser62_invoker = createInvoker(
    UserController_38.getTokenSendPassUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getTokenSendPassUser",
      Nil,
      "POST",
      this.prefix + """getTokenSendPassUser""",
      """""",
      Seq()
    )
  )

  // @LINE:84
  private[this] lazy val controllers_UserController_editUser63_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editUser")))
  )
  private[this] lazy val controllers_UserController_editUser63_invoker = createInvoker(
    UserController_38.editUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "editUser",
      Nil,
      "POST",
      this.prefix + """editUser""",
      """""",
      Seq()
    )
  )

  // @LINE:85
  private[this] lazy val controllers_UserController_deleteUser64_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteUser")))
  )
  private[this] lazy val controllers_UserController_deleteUser64_invoker = createInvoker(
    UserController_38.deleteUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Nil,
      "POST",
      this.prefix + """deleteUser""",
      """""",
      Seq()
    )
  )

  // @LINE:86
  private[this] lazy val controllers_UserController_addRoleForUser65_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUserRole")))
  )
  private[this] lazy val controllers_UserController_addRoleForUser65_invoker = createInvoker(
    UserController_38.addRoleForUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addRoleForUser",
      Nil,
      "POST",
      this.prefix + """addUserRole""",
      """""",
      Seq()
    )
  )

  // @LINE:87
  private[this] lazy val controllers_UserController_updateUserOrg66_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateUserOrg")))
  )
  private[this] lazy val controllers_UserController_updateUserOrg66_invoker = createInvoker(
    UserController_38.updateUserOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUserOrg",
      Nil,
      "POST",
      this.prefix + """updateUserOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:90
  private[this] lazy val controllers_Assets_at67_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("healthCheck")))
  )
  private[this] lazy val controllers_Assets_at67_invoker = createInvoker(
    Assets_63.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """healthCheck""",
      """health check""",
      Seq()
    )
  )

  // @LINE:93
  private[this] lazy val controllers_ApiController_sendMail68_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMail")))
  )
  private[this] lazy val controllers_ApiController_sendMail68_invoker = createInvoker(
    ApiController_76.sendMail(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "sendMail",
      Nil,
      "POST",
      this.prefix + """sendMail""",
      """send mail api""",
      Seq()
    )
  )

  // @LINE:94
  private[this] lazy val controllers_ApiController_getJsonWidget69_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getJsonWidget/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApiController_getJsonWidget69_invoker = createInvoker(
    ApiController_76.getJsonWidget(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getJsonWidget",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getJsonWidget/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:97
  private[this] lazy val controllers_SocketController_wsSocket70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("wsSocket")))
  )
  private[this] lazy val controllers_SocketController_wsSocket70_invoker = createInvoker(
    SocketController_32.wsSocket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SocketController",
      "wsSocket",
      Nil,
      "GET",
      this.prefix + """wsSocket""",
      """socket""",
      Seq()
    )
  )

  // @LINE:100
  private[this] lazy val controllers_SendApiController_getDataWithParam71_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataWithParam")))
  )
  private[this] lazy val controllers_SendApiController_getDataWithParam71_invoker = createInvoker(
    SendApiController_48.getDataWithParam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SendApiController",
      "getDataWithParam",
      Nil,
      "POST",
      this.prefix + """getDataWithParam""",
      """send api""",
      Seq()
    )
  )

  // @LINE:101
  private[this] lazy val controllers_SendApiController_portDataWithParam72_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("portDataWithParam")))
  )
  private[this] lazy val controllers_SendApiController_portDataWithParam72_invoker = createInvoker(
    SendApiController_48.portDataWithParam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SendApiController",
      "portDataWithParam",
      Nil,
      "POST",
      this.prefix + """portDataWithParam""",
      """""",
      Seq()
    )
  )

  // @LINE:102
  private[this] lazy val controllers_SendApiController_putDataWithParam73_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("putDataWithParam")))
  )
  private[this] lazy val controllers_SendApiController_putDataWithParam73_invoker = createInvoker(
    SendApiController_48.putDataWithParam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SendApiController",
      "putDataWithParam",
      Nil,
      "POST",
      this.prefix + """putDataWithParam""",
      """""",
      Seq()
    )
  )

  // @LINE:103
  private[this] lazy val controllers_SendApiController_upfileImage74_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upfileImage")))
  )
  private[this] lazy val controllers_SendApiController_upfileImage74_invoker = createInvoker(
    SendApiController_48.upfileImage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SendApiController",
      "upfileImage",
      Nil,
      "POST",
      this.prefix + """upfileImage""",
      """""",
      Seq()
    )
  )

  // @LINE:104
  private[this] lazy val controllers_SendApiController_deleteDataWithParam75_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDataWithParam")))
  )
  private[this] lazy val controllers_SendApiController_deleteDataWithParam75_invoker = createInvoker(
    SendApiController_48.deleteDataWithParam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SendApiController",
      "deleteDataWithParam",
      Nil,
      "POST",
      this.prefix + """deleteDataWithParam""",
      """""",
      Seq()
    )
  )

  // @LINE:107
  private[this] lazy val controllers_DownloadFileController_downloadFileFromApi76_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("downloadFile")))
  )
  private[this] lazy val controllers_DownloadFileController_downloadFileFromApi76_invoker = createInvoker(
    DownloadFileController_42.downloadFileFromApi(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DownloadFileController",
      "downloadFileFromApi",
      Seq(classOf[String]),
      "GET",
      this.prefix + """downloadFile""",
      """downloadFile""",
      Seq()
    )
  )

  // @LINE:110
  private[this] lazy val controllers_DashboardController_dashboard77_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dashboard")))
  )
  private[this] lazy val controllers_DashboardController_dashboard77_invoker = createInvoker(
    DashboardController_14.dashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "dashboard",
      Nil,
      "GET",
      this.prefix + """dashboard""",
      """dashboard""",
      Seq()
    )
  )

  // @LINE:111
  private[this] lazy val controllers_DashboardController_getMarkersWithPaging78_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getMarkersWithPaging")))
  )
  private[this] lazy val controllers_DashboardController_getMarkersWithPaging78_invoker = createInvoker(
    DashboardController_14.getMarkersWithPaging(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "getMarkersWithPaging",
      Nil,
      "POST",
      this.prefix + """getMarkersWithPaging""",
      """""",
      Seq()
    )
  )

  // @LINE:112
  private[this] lazy val controllers_DashboardController_getListDeviceWithPaging79_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceWithPaging")))
  )
  private[this] lazy val controllers_DashboardController_getListDeviceWithPaging79_invoker = createInvoker(
    DashboardController_14.getListDeviceWithPaging(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "getListDeviceWithPaging",
      Nil,
      "POST",
      this.prefix + """getListDeviceWithPaging""",
      """""",
      Seq()
    )
  )

  // @LINE:113
  private[this] lazy val controllers_DashboardController_loadDeviceDataCurrent80_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loadDeviceDataCurrent/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DashboardController_loadDeviceDataCurrent80_invoker = createInvoker(
    DashboardController_14.loadDeviceDataCurrent(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "loadDeviceDataCurrent",
      Seq(classOf[String]),
      "GET",
      this.prefix + """loadDeviceDataCurrent/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:115
  private[this] lazy val controllers_DashboardWidgetController_dashboardVer281_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dashboardVer2/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DashboardWidgetController_dashboardVer281_invoker = createInvoker(
    DashboardWidgetController_75.dashboardVer2(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardWidgetController",
      "dashboardVer2",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dashboardVer2/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:116
  private[this] lazy val controllers_DashboardWidgetController_getListDeviceWithWidgetMap82_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceWithWidgetMap")))
  )
  private[this] lazy val controllers_DashboardWidgetController_getListDeviceWithWidgetMap82_invoker = createInvoker(
    DashboardWidgetController_75.getListDeviceWithWidgetMap(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardWidgetController",
      "getListDeviceWithWidgetMap",
      Nil,
      "POST",
      this.prefix + """getListDeviceWithWidgetMap""",
      """""",
      Seq()
    )
  )

  // @LINE:117
  private[this] lazy val controllers_DashboardWidgetController_getDeviceDataCurrent83_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDeviceDataCurrent")))
  )
  private[this] lazy val controllers_DashboardWidgetController_getDeviceDataCurrent83_invoker = createInvoker(
    DashboardWidgetController_75.getDeviceDataCurrent(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardWidgetController",
      "getDeviceDataCurrent",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """getDeviceDataCurrent""",
      """""",
      Seq()
    )
  )

  // @LINE:118
  private[this] lazy val controllers_DashboardWidgetController_getHistoryRpc84_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryRpc")))
  )
  private[this] lazy val controllers_DashboardWidgetController_getHistoryRpc84_invoker = createInvoker(
    DashboardWidgetController_75.getHistoryRpc(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardWidgetController",
      "getHistoryRpc",
      Nil,
      "POST",
      this.prefix + """getHistoryRpc""",
      """""",
      Seq()
    )
  )

  // @LINE:120
  private[this] lazy val controllers_DashboardV3Controller_dashboardList85_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dashboardList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DashboardV3Controller_dashboardList85_invoker = createInvoker(
    DashboardV3Controller_4.dashboardList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "dashboardList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dashboardList/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:121
  private[this] lazy val controllers_DashboardV3Controller_getListDashboard86_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDashboard")))
  )
  private[this] lazy val controllers_DashboardV3Controller_getListDashboard86_invoker = createInvoker(
    DashboardV3Controller_4.getListDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "getListDashboard",
      Nil,
      "POST",
      this.prefix + """getListDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:122
  private[this] lazy val controllers_DashboardV3Controller_addNewDashboard87_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewDashboard")))
  )
  private[this] lazy val controllers_DashboardV3Controller_addNewDashboard87_invoker = createInvoker(
    DashboardV3Controller_4.addNewDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "addNewDashboard",
      Nil,
      "POST",
      this.prefix + """addNewDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:123
  private[this] lazy val controllers_DashboardV3Controller_editContentDashboard88_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editContentDashboard")))
  )
  private[this] lazy val controllers_DashboardV3Controller_editContentDashboard88_invoker = createInvoker(
    DashboardV3Controller_4.editContentDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "editContentDashboard",
      Nil,
      "POST",
      this.prefix + """editContentDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:124
  private[this] lazy val controllers_DashboardV3Controller_deleteDashboard89_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDashboard")))
  )
  private[this] lazy val controllers_DashboardV3Controller_deleteDashboard89_invoker = createInvoker(
    DashboardV3Controller_4.deleteDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "deleteDashboard",
      Nil,
      "POST",
      this.prefix + """deleteDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:125
  private[this] lazy val controllers_DashboardV3Controller_dashboard90_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dashboard/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("dashboardId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DashboardV3Controller_dashboard90_invoker = createInvoker(
    DashboardV3Controller_4.dashboard(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "dashboard",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """dashboard/""" + "$" + """id<[^/]+>/""" + "$" + """dashboardId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:126
  private[this] lazy val controllers_DashboardV3Controller_getDashboardWithId91_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDashboardWithId")))
  )
  private[this] lazy val controllers_DashboardV3Controller_getDashboardWithId91_invoker = createInvoker(
    DashboardV3Controller_4.getDashboardWithId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "getDashboardWithId",
      Nil,
      "POST",
      this.prefix + """getDashboardWithId""",
      """""",
      Seq()
    )
  )

  // @LINE:127
  private[this] lazy val controllers_DashboardV3Controller_saveDashboard92_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveDashboard")))
  )
  private[this] lazy val controllers_DashboardV3Controller_saveDashboard92_invoker = createInvoker(
    DashboardV3Controller_4.saveDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "saveDashboard",
      Nil,
      "POST",
      this.prefix + """saveDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:128
  private[this] lazy val controllers_DashboardV3Controller_moveDashboardToOrg93_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("moveDashboardToOrg")))
  )
  private[this] lazy val controllers_DashboardV3Controller_moveDashboardToOrg93_invoker = createInvoker(
    DashboardV3Controller_4.moveDashboardToOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardV3Controller",
      "moveDashboardToOrg",
      Nil,
      "POST",
      this.prefix + """moveDashboardToOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:132
  private[this] lazy val controllers_TelcoDeviceController_deviceManage94_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/deviceManage/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoDeviceController_deviceManage94_invoker = createInvoker(
    TelcoDeviceController_31.deviceManage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDeviceController",
      "deviceManage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/deviceManage/""" + "$" + """userId<[^/]+>""",
      """deviesManage""",
      Seq()
    )
  )

  // @LINE:135
  private[this] lazy val controllers_DashboardAppController_appDashboard95_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("appDashboard/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("dashboardId", """[^/]+""",true), StaticPart("/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DashboardAppController_appDashboard95_invoker = createInvoker(
    DashboardAppController_24.appDashboard(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "appDashboard",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """appDashboard/""" + "$" + """id<[^/]+>/""" + "$" + """dashboardId<[^/]+>/""" + "$" + """token<[^/]+>""",
      """dashboard for app""",
      Seq()
    )
  )

  // @LINE:136
  private[this] lazy val controllers_DashboardAppController_getDashboardWithId96_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDashboardWithIdApp")))
  )
  private[this] lazy val controllers_DashboardAppController_getDashboardWithId96_invoker = createInvoker(
    DashboardAppController_24.getDashboardWithId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "getDashboardWithId",
      Nil,
      "POST",
      this.prefix + """getDashboardWithIdApp""",
      """""",
      Seq()
    )
  )

  // @LINE:137
  private[this] lazy val controllers_DashboardAppController_getPositionDeviceByAttributeApp97_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPositionDeviceByAttributeApp")))
  )
  private[this] lazy val controllers_DashboardAppController_getPositionDeviceByAttributeApp97_invoker = createInvoker(
    DashboardAppController_24.getPositionDeviceByAttributeApp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "getPositionDeviceByAttributeApp",
      Nil,
      "POST",
      this.prefix + """getPositionDeviceByAttributeApp""",
      """""",
      Seq()
    )
  )

  // @LINE:138
  private[this] lazy val controllers_DashboardAppController_getListDeviceWithWidgetMapApp98_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceWithWidgetMapApp")))
  )
  private[this] lazy val controllers_DashboardAppController_getListDeviceWithWidgetMapApp98_invoker = createInvoker(
    DashboardAppController_24.getListDeviceWithWidgetMapApp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "getListDeviceWithWidgetMapApp",
      Nil,
      "POST",
      this.prefix + """getListDeviceWithWidgetMapApp""",
      """""",
      Seq()
    )
  )

  // @LINE:139
  private[this] lazy val controllers_DashboardAppController_getDataAttributeByIdApp99_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataAttributeByIdApp")))
  )
  private[this] lazy val controllers_DashboardAppController_getDataAttributeByIdApp99_invoker = createInvoker(
    DashboardAppController_24.getDataAttributeByIdApp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "getDataAttributeByIdApp",
      Nil,
      "POST",
      this.prefix + """getDataAttributeByIdApp""",
      """""",
      Seq()
    )
  )

  // @LINE:140
  private[this] lazy val controllers_DashboardAppController_getLastValueAttributeApp100_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLastValueAttributeApp")))
  )
  private[this] lazy val controllers_DashboardAppController_getLastValueAttributeApp100_invoker = createInvoker(
    DashboardAppController_24.getLastValueAttributeApp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "getLastValueAttributeApp",
      Nil,
      "POST",
      this.prefix + """getLastValueAttributeApp""",
      """""",
      Seq()
    )
  )

  // @LINE:141
  private[this] lazy val controllers_DashboardAppController_sendMessageOnOffApp101_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessageOnOffApp")))
  )
  private[this] lazy val controllers_DashboardAppController_sendMessageOnOffApp101_invoker = createInvoker(
    DashboardAppController_24.sendMessageOnOffApp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardAppController",
      "sendMessageOnOffApp",
      Nil,
      "POST",
      this.prefix + """sendMessageOnOffApp""",
      """""",
      Seq()
    )
  )

  // @LINE:144
  private[this] lazy val controllers_WidgetListController_widgetPage102_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("widgetPage/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("idDashboard", """[^/]+""",true)))
  )
  private[this] lazy val controllers_WidgetListController_widgetPage102_invoker = createInvoker(
    WidgetListController_78.widgetPage(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WidgetListController",
      "widgetPage",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """widgetPage/""" + "$" + """id<[^/]+>/""" + "$" + """idDashboard<[^/]+>""",
      """widgetPage""",
      Seq()
    )
  )

  // @LINE:145
  private[this] lazy val controllers_WidgetListController_saveWidgetData103_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveWidgetData")))
  )
  private[this] lazy val controllers_WidgetListController_saveWidgetData103_invoker = createInvoker(
    WidgetListController_78.saveWidgetData(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WidgetListController",
      "saveWidgetData",
      Nil,
      "POST",
      this.prefix + """saveWidgetData""",
      """""",
      Seq()
    )
  )

  // @LINE:146
  private[this] lazy val controllers_WidgetListController_getWidgetCurrent104_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getWidgetCurrent")))
  )
  private[this] lazy val controllers_WidgetListController_getWidgetCurrent104_invoker = createInvoker(
    WidgetListController_78.getWidgetCurrent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WidgetListController",
      "getWidgetCurrent",
      Nil,
      "GET",
      this.prefix + """getWidgetCurrent""",
      """""",
      Seq()
    )
  )

  // @LINE:149
  private[this] lazy val controllers_DeviceIotController_deviceIotList105_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deviceIotList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_deviceIotList105_invoker = createInvoker(
    DeviceIotController_49.deviceIotList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "deviceIotList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """deviceIotList/""" + "$" + """id<[^/]+>""",
      """device""",
      Seq()
    )
  )

  // @LINE:150
  private[this] lazy val controllers_DeviceIotController_addNewDevice106_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewDevice")))
  )
  private[this] lazy val controllers_DeviceIotController_addNewDevice106_invoker = createInvoker(
    DeviceIotController_49.addNewDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "addNewDevice",
      Nil,
      "POST",
      this.prefix + """addNewDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:151
  private[this] lazy val controllers_DeviceIotController_createDeviceWithSerialSim107_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createDeviceWithSerialSim")))
  )
  private[this] lazy val controllers_DeviceIotController_createDeviceWithSerialSim107_invoker = createInvoker(
    DeviceIotController_49.createDeviceWithSerialSim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "createDeviceWithSerialSim",
      Nil,
      "POST",
      this.prefix + """createDeviceWithSerialSim""",
      """""",
      Seq()
    )
  )

  // @LINE:152
  private[this] lazy val controllers_DeviceIotController_deleteDevice108_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDevice")))
  )
  private[this] lazy val controllers_DeviceIotController_deleteDevice108_invoker = createInvoker(
    DeviceIotController_49.deleteDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "deleteDevice",
      Nil,
      "POST",
      this.prefix + """deleteDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:153
  private[this] lazy val controllers_DeviceIotController_editNameDevice109_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editNameDevice")))
  )
  private[this] lazy val controllers_DeviceIotController_editNameDevice109_invoker = createInvoker(
    DeviceIotController_49.editNameDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "editNameDevice",
      Nil,
      "POST",
      this.prefix + """editNameDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:154
  private[this] lazy val controllers_DeviceIotController_updateDevice110_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateDevice")))
  )
  private[this] lazy val controllers_DeviceIotController_updateDevice110_invoker = createInvoker(
    DeviceIotController_49.updateDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "updateDevice",
      Nil,
      "POST",
      this.prefix + """updateDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:155
  private[this] lazy val controllers_DeviceIotController_configGpsDevice111_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("configGpsDevice")))
  )
  private[this] lazy val controllers_DeviceIotController_configGpsDevice111_invoker = createInvoker(
    DeviceIotController_49.configGpsDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "configGpsDevice",
      Nil,
      "POST",
      this.prefix + """configGpsDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:156
  private[this] lazy val controllers_DeviceIotController_getConfigOfDeviceIot112_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getConfigOfDeviceIot/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_getConfigOfDeviceIot112_invoker = createInvoker(
    DeviceIotController_49.getConfigOfDeviceIot(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getConfigOfDeviceIot",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getConfigOfDeviceIot/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:157
  private[this] lazy val controllers_DeviceIotController_getListDeviceIot113_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceIot")))
  )
  private[this] lazy val controllers_DeviceIotController_getListDeviceIot113_invoker = createInvoker(
    DeviceIotController_49.getListDeviceIot(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getListDeviceIot",
      Nil,
      "GET",
      this.prefix + """getListDeviceIot""",
      """""",
      Seq()
    )
  )

  // @LINE:158
  private[this] lazy val controllers_DeviceIotController_getListDeviceByGroup114_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceByGroup/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_getListDeviceByGroup114_invoker = createInvoker(
    DeviceIotController_49.getListDeviceByGroup(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getListDeviceByGroup",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getListDeviceByGroup/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:159
  private[this] lazy val controllers_DeviceIotController_getListDeviceVarsByDevice115_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceVarByDevice/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_getListDeviceVarsByDevice115_invoker = createInvoker(
    DeviceIotController_49.getListDeviceVarsByDevice(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getListDeviceVarsByDevice",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getListDeviceVarByDevice/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:160
  private[this] lazy val controllers_DeviceIotController_getListDeviceByOrg116_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceByOrg/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("projectId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_getListDeviceByOrg116_invoker = createInvoker(
    DeviceIotController_49.getListDeviceByOrg(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getListDeviceByOrg",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """getListDeviceByOrg/""" + "$" + """id<[^/]+>/""" + "$" + """projectId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:161
  private[this] lazy val controllers_DeviceIotController_getListDeviceAndAttrByOrg117_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceAndAttrByOrg/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("projectId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_getListDeviceAndAttrByOrg117_invoker = createInvoker(
    DeviceIotController_49.getListDeviceAndAttrByOrg(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getListDeviceAndAttrByOrg",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """getListDeviceAndAttrByOrg/""" + "$" + """id<[^/]+>/""" + "$" + """projectId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:162
  private[this] lazy val controllers_DeviceIotController_getListDeviceByDeviceType118_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceByDeviceType/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceIotController_getListDeviceByDeviceType118_invoker = createInvoker(
    DeviceIotController_49.getListDeviceByDeviceType(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceIotController",
      "getListDeviceByDeviceType",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getListDeviceByDeviceType/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:165
  private[this] lazy val controllers_AttributeController_attributeDevice119_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("attributeDevice/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("deviceId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AttributeController_attributeDevice119_invoker = createInvoker(
    AttributeController_21.attributeDevice(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "attributeDevice",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """attributeDevice/""" + "$" + """id<[^/]+>/""" + "$" + """deviceId<[^/]+>""",
      """attribute""",
      Seq()
    )
  )

  // @LINE:166
  private[this] lazy val controllers_AttributeController_getAttributeList120_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttributeList")))
  )
  private[this] lazy val controllers_AttributeController_getAttributeList120_invoker = createInvoker(
    AttributeController_21.getAttributeList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "getAttributeList",
      Nil,
      "POST",
      this.prefix + """getAttributeList""",
      """""",
      Seq()
    )
  )

  // @LINE:167
  private[this] lazy val controllers_AttributeController_getAttributeHistory121_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttributeHistory")))
  )
  private[this] lazy val controllers_AttributeController_getAttributeHistory121_invoker = createInvoker(
    AttributeController_21.getAttributeHistory(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "getAttributeHistory",
      Nil,
      "POST",
      this.prefix + """getAttributeHistory""",
      """""",
      Seq()
    )
  )

  // @LINE:169
  private[this] lazy val controllers_AttributeController_attributeUser122_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("attributeUser/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AttributeController_attributeUser122_invoker = createInvoker(
    AttributeController_21.attributeUser(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "attributeUser",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """attributeUser/""" + "$" + """id<[^/]+>/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:170
  private[this] lazy val controllers_AttributeController_attributeEvent123_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("attributeEvent/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("eventId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AttributeController_attributeEvent123_invoker = createInvoker(
    AttributeController_21.attributeEvent(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "attributeEvent",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """attributeEvent/""" + "$" + """id<[^/]+>/""" + "$" + """eventId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:171
  private[this] lazy val controllers_AttributeController_attributeTemplate124_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("attributeTemplate/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("templateId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AttributeController_attributeTemplate124_invoker = createInvoker(
    AttributeController_21.attributeTemplate(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "attributeTemplate",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """attributeTemplate/""" + "$" + """id<[^/]+>/""" + "$" + """templateId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:172
  private[this] lazy val controllers_AttributeController_attributeGroup125_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("attributeGroup/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("groupId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AttributeController_attributeGroup125_invoker = createInvoker(
    AttributeController_21.attributeGroup(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "attributeGroup",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """attributeGroup/""" + "$" + """id<[^/]+>/""" + "$" + """groupId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:175
  private[this] lazy val controllers_DeviceVariableController_deviceVariable126_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deviceVariable/"), DynamicPart("projectId", """[^/]+""",true), StaticPart("/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceVariableController_deviceVariable126_invoker = createInvoker(
    DeviceVariableController_50.deviceVariable(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceVariableController",
      "deviceVariable",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """deviceVariable/""" + "$" + """projectId<[^/]+>/""" + "$" + """id<[^/]+>""",
      """variable of device""",
      Seq()
    )
  )

  // @LINE:176
  private[this] lazy val controllers_DeviceVariableController_addVariable127_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addVariable")))
  )
  private[this] lazy val controllers_DeviceVariableController_addVariable127_invoker = createInvoker(
    DeviceVariableController_50.addVariable(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceVariableController",
      "addVariable",
      Nil,
      "POST",
      this.prefix + """addVariable""",
      """""",
      Seq()
    )
  )

  // @LINE:177
  private[this] lazy val controllers_DeviceVariableController_delVariable128_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delVariable")))
  )
  private[this] lazy val controllers_DeviceVariableController_delVariable128_invoker = createInvoker(
    DeviceVariableController_50.delVariable(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceVariableController",
      "delVariable",
      Nil,
      "POST",
      this.prefix + """delVariable""",
      """""",
      Seq()
    )
  )

  // @LINE:178
  private[this] lazy val controllers_DeviceVariableController_getDataVariableById129_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataVariableById")))
  )
  private[this] lazy val controllers_DeviceVariableController_getDataVariableById129_invoker = createInvoker(
    DeviceVariableController_50.getDataVariableById(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceVariableController",
      "getDataVariableById",
      Nil,
      "POST",
      this.prefix + """getDataVariableById""",
      """""",
      Seq()
    )
  )

  // @LINE:179
  private[this] lazy val controllers_DeviceVariableController_getListVarByIdDevice130_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListVarByIdDevice/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceVariableController_getListVarByIdDevice130_invoker = createInvoker(
    DeviceVariableController_50.getListVarByIdDevice(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceVariableController",
      "getListVarByIdDevice",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getListVarByIdDevice/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:182
  private[this] lazy val controllers_AttributeController_addAttribute131_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addAttribute")))
  )
  private[this] lazy val controllers_AttributeController_addAttribute131_invoker = createInvoker(
    AttributeController_21.addAttribute(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "addAttribute",
      Nil,
      "POST",
      this.prefix + """addAttribute""",
      """Attribute""",
      Seq()
    )
  )

  // @LINE:183
  private[this] lazy val controllers_AttributeController_deleteAttributeOrg132_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAttributeOrg")))
  )
  private[this] lazy val controllers_AttributeController_deleteAttributeOrg132_invoker = createInvoker(
    AttributeController_21.deleteAttributeOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "deleteAttributeOrg",
      Nil,
      "POST",
      this.prefix + """deleteAttributeOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:184
  private[this] lazy val controllers_AttributeController_editAttributeOrg133_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editAttributeOrg")))
  )
  private[this] lazy val controllers_AttributeController_editAttributeOrg133_invoker = createInvoker(
    AttributeController_21.editAttributeOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "editAttributeOrg",
      Nil,
      "POST",
      this.prefix + """editAttributeOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:185
  private[this] lazy val controllers_AttributeController_getDataAttributeById134_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataAttributeById")))
  )
  private[this] lazy val controllers_AttributeController_getDataAttributeById134_invoker = createInvoker(
    AttributeController_21.getDataAttributeById(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "getDataAttributeById",
      Nil,
      "POST",
      this.prefix + """getDataAttributeById""",
      """""",
      Seq()
    )
  )

  // @LINE:186
  private[this] lazy val controllers_AttributeController_getLastValueAttribute135_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLastValueAttribute")))
  )
  private[this] lazy val controllers_AttributeController_getLastValueAttribute135_invoker = createInvoker(
    AttributeController_21.getLastValueAttribute(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "getLastValueAttribute",
      Nil,
      "POST",
      this.prefix + """getLastValueAttribute""",
      """""",
      Seq()
    )
  )

  // @LINE:187
  private[this] lazy val controllers_AttributeController_getPositionDeviceByAttribute136_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPositionDeviceByAttribute")))
  )
  private[this] lazy val controllers_AttributeController_getPositionDeviceByAttribute136_invoker = createInvoker(
    AttributeController_21.getPositionDeviceByAttribute(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "getPositionDeviceByAttribute",
      Nil,
      "POST",
      this.prefix + """getPositionDeviceByAttribute""",
      """""",
      Seq()
    )
  )

  // @LINE:188
  private[this] lazy val controllers_AttributeController_getValueAttributeWithTime137_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getValueAttributeWithTime")))
  )
  private[this] lazy val controllers_AttributeController_getValueAttributeWithTime137_invoker = createInvoker(
    AttributeController_21.getValueAttributeWithTime(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AttributeController",
      "getValueAttributeWithTime",
      Nil,
      "POST",
      this.prefix + """getValueAttributeWithTime""",
      """""",
      Seq()
    )
  )

  // @LINE:191
  private[this] lazy val controllers_MessagesDeviceController_messagesDevice138_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messagesDevice/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MessagesDeviceController_messagesDevice138_invoker = createInvoker(
    MessagesDeviceController_41.messagesDevice(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "messagesDevice",
      Seq(classOf[String]),
      "GET",
      this.prefix + """messagesDevice/""" + "$" + """id<[^/]+>""",
      """message""",
      Seq()
    )
  )

  // @LINE:192
  private[this] lazy val controllers_MessagesDeviceController_getMetadata139_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getMetadata")))
  )
  private[this] lazy val controllers_MessagesDeviceController_getMetadata139_invoker = createInvoker(
    MessagesDeviceController_41.getMetadata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "getMetadata",
      Nil,
      "POST",
      this.prefix + """getMetadata""",
      """""",
      Seq()
    )
  )

  // @LINE:193
  private[this] lazy val controllers_MessagesDeviceController_sendMetadata140_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMetadata")))
  )
  private[this] lazy val controllers_MessagesDeviceController_sendMetadata140_invoker = createInvoker(
    MessagesDeviceController_41.sendMetadata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "sendMetadata",
      Nil,
      "POST",
      this.prefix + """sendMetadata""",
      """""",
      Seq()
    )
  )

  // @LINE:194
  private[this] lazy val controllers_MessagesDeviceController_sendMessageToDevice141_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessageToDevice")))
  )
  private[this] lazy val controllers_MessagesDeviceController_sendMessageToDevice141_invoker = createInvoker(
    MessagesDeviceController_41.sendMessageToDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "sendMessageToDevice",
      Nil,
      "POST",
      this.prefix + """sendMessageToDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:195
  private[this] lazy val controllers_MessagesDeviceController_getMessageFormDevice142_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getMessageFormDevice")))
  )
  private[this] lazy val controllers_MessagesDeviceController_getMessageFormDevice142_invoker = createInvoker(
    MessagesDeviceController_41.getMessageFormDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "getMessageFormDevice",
      Nil,
      "POST",
      this.prefix + """getMessageFormDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:196
  private[this] lazy val controllers_MessagesDeviceController_postCreateDeviceToken143_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postCreateDeviceToken")))
  )
  private[this] lazy val controllers_MessagesDeviceController_postCreateDeviceToken143_invoker = createInvoker(
    MessagesDeviceController_41.postCreateDeviceToken(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "postCreateDeviceToken",
      Nil,
      "POST",
      this.prefix + """postCreateDeviceToken""",
      """""",
      Seq()
    )
  )

  // @LINE:197
  private[this] lazy val controllers_MessagesDeviceController_sendMessageData144_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessageData")))
  )
  private[this] lazy val controllers_MessagesDeviceController_sendMessageData144_invoker = createInvoker(
    MessagesDeviceController_41.sendMessageData(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "sendMessageData",
      Nil,
      "POST",
      this.prefix + """sendMessageData""",
      """""",
      Seq()
    )
  )

  // @LINE:198
  private[this] lazy val controllers_MessagesDeviceController_sendMessageOnOff145_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessageOnOff")))
  )
  private[this] lazy val controllers_MessagesDeviceController_sendMessageOnOff145_invoker = createInvoker(
    MessagesDeviceController_41.sendMessageOnOff(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "sendMessageOnOff",
      Nil,
      "POST",
      this.prefix + """sendMessageOnOff""",
      """""",
      Seq()
    )
  )

  // @LINE:199
  private[this] lazy val controllers_MessagesDeviceController_sendMessageOnOffApp146_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessageOnOffApp")))
  )
  private[this] lazy val controllers_MessagesDeviceController_sendMessageOnOffApp146_invoker = createInvoker(
    MessagesDeviceController_41.sendMessageOnOffApp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "sendMessageOnOffApp",
      Nil,
      "POST",
      this.prefix + """sendMessageOnOffApp""",
      """""",
      Seq()
    )
  )

  // @LINE:200
  private[this] lazy val controllers_MessagesDeviceController_sendCommandRPC147_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendCommandRPC")))
  )
  private[this] lazy val controllers_MessagesDeviceController_sendCommandRPC147_invoker = createInvoker(
    MessagesDeviceController_41.sendCommandRPC(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesDeviceController",
      "sendCommandRPC",
      Nil,
      "POST",
      this.prefix + """sendCommandRPC""",
      """""",
      Seq()
    )
  )

  // @LINE:203
  private[this] lazy val controllers_LogDeviceController_logDeviceList148_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logDeviceList")))
  )
  private[this] lazy val controllers_LogDeviceController_logDeviceList148_invoker = createInvoker(
    LogDeviceController_43.logDeviceList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LogDeviceController",
      "logDeviceList",
      Nil,
      "GET",
      this.prefix + """logDeviceList""",
      """log""",
      Seq()
    )
  )

  // @LINE:204
  private[this] lazy val controllers_LogDeviceController_getAllLogMessage149_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllLogMessage")))
  )
  private[this] lazy val controllers_LogDeviceController_getAllLogMessage149_invoker = createInvoker(
    LogDeviceController_43.getAllLogMessage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LogDeviceController",
      "getAllLogMessage",
      Nil,
      "POST",
      this.prefix + """getAllLogMessage""",
      """""",
      Seq()
    )
  )

  // @LINE:207
  private[this] lazy val controllers_DeviceTypeController_deviceTypeList150_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deviceTypeList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceTypeController_deviceTypeList150_invoker = createInvoker(
    DeviceTypeController_64.deviceTypeList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTypeController",
      "deviceTypeList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """deviceTypeList/""" + "$" + """id<[^/]+>""",
      """type""",
      Seq()
    )
  )

  // @LINE:208
  private[this] lazy val controllers_DeviceTypeController_addNewDeviceType151_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewDeviceType")))
  )
  private[this] lazy val controllers_DeviceTypeController_addNewDeviceType151_invoker = createInvoker(
    DeviceTypeController_64.addNewDeviceType(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTypeController",
      "addNewDeviceType",
      Nil,
      "POST",
      this.prefix + """addNewDeviceType""",
      """""",
      Seq()
    )
  )

  // @LINE:209
  private[this] lazy val controllers_DeviceTypeController_deleteDeviceType152_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDeviceType")))
  )
  private[this] lazy val controllers_DeviceTypeController_deleteDeviceType152_invoker = createInvoker(
    DeviceTypeController_64.deleteDeviceType(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTypeController",
      "deleteDeviceType",
      Nil,
      "POST",
      this.prefix + """deleteDeviceType""",
      """""",
      Seq()
    )
  )

  // @LINE:210
  private[this] lazy val controllers_DeviceTypeController_editDeviceType153_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editDeviceType")))
  )
  private[this] lazy val controllers_DeviceTypeController_editDeviceType153_invoker = createInvoker(
    DeviceTypeController_64.editDeviceType(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTypeController",
      "editDeviceType",
      Nil,
      "POST",
      this.prefix + """editDeviceType""",
      """""",
      Seq()
    )
  )

  // @LINE:211
  private[this] lazy val controllers_DeviceTypeController_getListTypes154_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListTypes")))
  )
  private[this] lazy val controllers_DeviceTypeController_getListTypes154_invoker = createInvoker(
    DeviceTypeController_64.getListTypes(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTypeController",
      "getListTypes",
      Nil,
      "POST",
      this.prefix + """getListTypes""",
      """""",
      Seq()
    )
  )

  // @LINE:214
  private[this] lazy val controllers_DeviceTemplateController_deviceTemplate155_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deviceTemplate/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeviceTemplateController_deviceTemplate155_invoker = createInvoker(
    DeviceTemplateController_51.deviceTemplate(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTemplateController",
      "deviceTemplate",
      Seq(classOf[String]),
      "GET",
      this.prefix + """deviceTemplate/""" + "$" + """id<[^/]+>""",
      """deviceTemplate""",
      Seq()
    )
  )

  // @LINE:215
  private[this] lazy val controllers_DeviceTemplateController_createDeviceTemplate156_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createDeviceTemplate")))
  )
  private[this] lazy val controllers_DeviceTemplateController_createDeviceTemplate156_invoker = createInvoker(
    DeviceTemplateController_51.createDeviceTemplate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTemplateController",
      "createDeviceTemplate",
      Nil,
      "POST",
      this.prefix + """createDeviceTemplate""",
      """""",
      Seq()
    )
  )

  // @LINE:216
  private[this] lazy val controllers_DeviceTemplateController_getListDeviceTemplate157_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceTemplate")))
  )
  private[this] lazy val controllers_DeviceTemplateController_getListDeviceTemplate157_invoker = createInvoker(
    DeviceTemplateController_51.getListDeviceTemplate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTemplateController",
      "getListDeviceTemplate",
      Nil,
      "POST",
      this.prefix + """getListDeviceTemplate""",
      """""",
      Seq()
    )
  )

  // @LINE:217
  private[this] lazy val controllers_DeviceTemplateController_deleteDeviceTemplate158_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDeviceTemplate")))
  )
  private[this] lazy val controllers_DeviceTemplateController_deleteDeviceTemplate158_invoker = createInvoker(
    DeviceTemplateController_51.deleteDeviceTemplate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTemplateController",
      "deleteDeviceTemplate",
      Nil,
      "POST",
      this.prefix + """deleteDeviceTemplate""",
      """""",
      Seq()
    )
  )

  // @LINE:218
  private[this] lazy val controllers_DeviceTemplateController_createTemDevice159_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createTemDevice")))
  )
  private[this] lazy val controllers_DeviceTemplateController_createTemDevice159_invoker = createInvoker(
    DeviceTemplateController_51.createTemDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeviceTemplateController",
      "createTemDevice",
      Nil,
      "POST",
      this.prefix + """createTemDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:221
  private[this] lazy val controllers_FlowEngineController_getListFlow160_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListFlow")))
  )
  private[this] lazy val controllers_FlowEngineController_getListFlow160_invoker = createInvoker(
    FlowEngineController_74.getListFlow(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FlowEngineController",
      "getListFlow",
      Nil,
      "POST",
      this.prefix + """getListFlow""",
      """flow""",
      Seq()
    )
  )

  // @LINE:222
  private[this] lazy val controllers_FlowEngineController_addFlow161_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addFlow")))
  )
  private[this] lazy val controllers_FlowEngineController_addFlow161_invoker = createInvoker(
    FlowEngineController_74.addFlow(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FlowEngineController",
      "addFlow",
      Nil,
      "POST",
      this.prefix + """addFlow""",
      """""",
      Seq()
    )
  )

  // @LINE:225
  private[this] lazy val controllers_OrginazationController_orginazationView162_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orginazationView/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrginazationController_orginazationView162_invoker = createInvoker(
    OrginazationController_66.orginazationView(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrginazationController",
      "orginazationView",
      Seq(classOf[String]),
      "GET",
      this.prefix + """orginazationView/""" + "$" + """id<[^/]+>""",
      """org list""",
      Seq()
    )
  )

  // @LINE:227
  private[this] lazy val controllers_GroupController_orgList163_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orgList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GroupController_orgList163_invoker = createInvoker(
    GroupController_77.orgList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "orgList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """orgList/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:228
  private[this] lazy val controllers_GroupController_getInfoOrg164_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoOrg")))
  )
  private[this] lazy val controllers_GroupController_getInfoOrg164_invoker = createInvoker(
    GroupController_77.getInfoOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getInfoOrg",
      Nil,
      "POST",
      this.prefix + """getInfoOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:229
  private[this] lazy val controllers_GroupController_getAttributeOrg165_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttributeOrg")))
  )
  private[this] lazy val controllers_GroupController_getAttributeOrg165_invoker = createInvoker(
    GroupController_77.getAttributeOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getAttributeOrg",
      Nil,
      "POST",
      this.prefix + """getAttributeOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:230
  private[this] lazy val controllers_GroupController_getGroupChildByGroupId166_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getChildByGroupId")))
  )
  private[this] lazy val controllers_GroupController_getGroupChildByGroupId166_invoker = createInvoker(
    GroupController_77.getGroupChildByGroupId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getGroupChildByGroupId",
      Nil,
      "POST",
      this.prefix + """getChildByGroupId""",
      """""",
      Seq()
    )
  )

  // @LINE:231
  private[this] lazy val controllers_GroupController_getListGroupOfOrg167_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroupOfOrg")))
  )
  private[this] lazy val controllers_GroupController_getListGroupOfOrg167_invoker = createInvoker(
    GroupController_77.getListGroupOfOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getListGroupOfOrg",
      Nil,
      "POST",
      this.prefix + """getListGroupOfOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:232
  private[this] lazy val controllers_GroupController_getListUserOfOrg168_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListUserOfOrg")))
  )
  private[this] lazy val controllers_GroupController_getListUserOfOrg168_invoker = createInvoker(
    GroupController_77.getListUserOfOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getListUserOfOrg",
      Nil,
      "POST",
      this.prefix + """getListUserOfOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:233
  private[this] lazy val controllers_GroupController_getListDeviceOfOrg169_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceOfOrg")))
  )
  private[this] lazy val controllers_GroupController_getListDeviceOfOrg169_invoker = createInvoker(
    GroupController_77.getListDeviceOfOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getListDeviceOfOrg",
      Nil,
      "POST",
      this.prefix + """getListDeviceOfOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:234
  private[this] lazy val controllers_GroupController_getListEventOfOrg170_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListEventOfOrg")))
  )
  private[this] lazy val controllers_GroupController_getListEventOfOrg170_invoker = createInvoker(
    GroupController_77.getListEventOfOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getListEventOfOrg",
      Nil,
      "POST",
      this.prefix + """getListEventOfOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:235
  private[this] lazy val controllers_GroupController_getListRoleOfOrg171_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListRoleOfOrg")))
  )
  private[this] lazy val controllers_GroupController_getListRoleOfOrg171_invoker = createInvoker(
    GroupController_77.getListRoleOfOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getListRoleOfOrg",
      Nil,
      "POST",
      this.prefix + """getListRoleOfOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:236
  private[this] lazy val controllers_GroupController_updateGroup172_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateOrg")))
  )
  private[this] lazy val controllers_GroupController_updateGroup172_invoker = createInvoker(
    GroupController_77.updateGroup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "updateGroup",
      Nil,
      "POST",
      this.prefix + """updateOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:237
  private[this] lazy val controllers_GroupController_deleteGroup173_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteOrg")))
  )
  private[this] lazy val controllers_GroupController_deleteGroup173_invoker = createInvoker(
    GroupController_77.deleteGroup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "deleteGroup",
      Nil,
      "POST",
      this.prefix + """deleteOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:238
  private[this] lazy val controllers_GroupController_updateRoleToGroupUser174_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateRoleToGroupUser")))
  )
  private[this] lazy val controllers_GroupController_updateRoleToGroupUser174_invoker = createInvoker(
    GroupController_77.updateRoleToGroupUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "updateRoleToGroupUser",
      Nil,
      "POST",
      this.prefix + """updateRoleToGroupUser""",
      """""",
      Seq()
    )
  )

  // @LINE:239
  private[this] lazy val controllers_GroupController_updateUserToGroupDevice175_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateUserToGroupDevice")))
  )
  private[this] lazy val controllers_GroupController_updateUserToGroupDevice175_invoker = createInvoker(
    GroupController_77.updateUserToGroupDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "updateUserToGroupDevice",
      Nil,
      "POST",
      this.prefix + """updateUserToGroupDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:240
  private[this] lazy val controllers_GroupController_addGroupRoot176_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addGroupRoot")))
  )
  private[this] lazy val controllers_GroupController_addGroupRoot176_invoker = createInvoker(
    GroupController_77.addGroupRoot(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "addGroupRoot",
      Nil,
      "POST",
      this.prefix + """addGroupRoot""",
      """""",
      Seq()
    )
  )

  // @LINE:241
  private[this] lazy val controllers_GroupController_getListOrganizations177_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListOrganizations/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GroupController_getListOrganizations177_invoker = createInvoker(
    GroupController_77.getListOrganizations(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getListOrganizations",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getListOrganizations/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:242
  private[this] lazy val controllers_GroupController_processMoveUserToGroupOther178_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("processMoveUserToGroupOther")))
  )
  private[this] lazy val controllers_GroupController_processMoveUserToGroupOther178_invoker = createInvoker(
    GroupController_77.processMoveUserToGroupOther(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "processMoveUserToGroupOther",
      Nil,
      "POST",
      this.prefix + """processMoveUserToGroupOther""",
      """""",
      Seq()
    )
  )

  // @LINE:243
  private[this] lazy val controllers_GroupController_processMoveDeviceToGroupOther179_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("processMoveDeviceToGroupOther")))
  )
  private[this] lazy val controllers_GroupController_processMoveDeviceToGroupOther179_invoker = createInvoker(
    GroupController_77.processMoveDeviceToGroupOther(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "processMoveDeviceToGroupOther",
      Nil,
      "POST",
      this.prefix + """processMoveDeviceToGroupOther""",
      """""",
      Seq()
    )
  )

  // @LINE:244
  private[this] lazy val controllers_GroupController_createUserInOrg180_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserInOrg")))
  )
  private[this] lazy val controllers_GroupController_createUserInOrg180_invoker = createInvoker(
    GroupController_77.createUserInOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "createUserInOrg",
      Nil,
      "POST",
      this.prefix + """createUserInOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:245
  private[this] lazy val controllers_GroupController_updateRoleForUser181_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateRoleForUser")))
  )
  private[this] lazy val controllers_GroupController_updateRoleForUser181_invoker = createInvoker(
    GroupController_77.updateRoleForUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "updateRoleForUser",
      Nil,
      "POST",
      this.prefix + """updateRoleForUser""",
      """""",
      Seq()
    )
  )

  // @LINE:248
  private[this] lazy val controllers_GroupListController_groupsList182_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groupsList")))
  )
  private[this] lazy val controllers_GroupListController_groupsList182_invoker = createInvoker(
    GroupListController_68.groupsList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "groupsList",
      Nil,
      "GET",
      this.prefix + """groupsList""",
      """group""",
      Seq()
    )
  )

  // @LINE:249
  private[this] lazy val controllers_GroupListController_addNewGroups183_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewGroups")))
  )
  private[this] lazy val controllers_GroupListController_addNewGroups183_invoker = createInvoker(
    GroupListController_68.addNewGroups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "addNewGroups",
      Nil,
      "POST",
      this.prefix + """addNewGroups""",
      """""",
      Seq()
    )
  )

  // @LINE:250
  private[this] lazy val controllers_GroupListController_deleteGroup184_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteGroup")))
  )
  private[this] lazy val controllers_GroupListController_deleteGroup184_invoker = createInvoker(
    GroupListController_68.deleteGroup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "deleteGroup",
      Nil,
      "POST",
      this.prefix + """deleteGroup""",
      """""",
      Seq()
    )
  )

  // @LINE:251
  private[this] lazy val controllers_GroupListController_editNameGroups185_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editNameGroups")))
  )
  private[this] lazy val controllers_GroupListController_editNameGroups185_invoker = createInvoker(
    GroupListController_68.editNameGroups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "editNameGroups",
      Nil,
      "POST",
      this.prefix + """editNameGroups""",
      """""",
      Seq()
    )
  )

  // @LINE:252
  private[this] lazy val controllers_GroupListController_updateOrgIdForGroups186_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateOrgIdForGroups")))
  )
  private[this] lazy val controllers_GroupListController_updateOrgIdForGroups186_invoker = createInvoker(
    GroupListController_68.updateOrgIdForGroups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "updateOrgIdForGroups",
      Nil,
      "POST",
      this.prefix + """updateOrgIdForGroups""",
      """""",
      Seq()
    )
  )

  // @LINE:253
  private[this] lazy val controllers_GroupListController_getListGroups187_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroups")))
  )
  private[this] lazy val controllers_GroupListController_getListGroups187_invoker = createInvoker(
    GroupListController_68.getListGroups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "getListGroups",
      Nil,
      "POST",
      this.prefix + """getListGroups""",
      """""",
      Seq()
    )
  )

  // @LINE:254
  private[this] lazy val controllers_GroupListController_getGroupWithEntityType188_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getGroupWithEntityType")))
  )
  private[this] lazy val controllers_GroupListController_getGroupWithEntityType188_invoker = createInvoker(
    GroupListController_68.getGroupWithEntityType(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "getGroupWithEntityType",
      Nil,
      "POST",
      this.prefix + """getGroupWithEntityType""",
      """""",
      Seq()
    )
  )

  // @LINE:255
  private[this] lazy val controllers_GroupListController_getListGroupUser189_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroupUser")))
  )
  private[this] lazy val controllers_GroupListController_getListGroupUser189_invoker = createInvoker(
    GroupListController_68.getListGroupUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "getListGroupUser",
      Nil,
      "POST",
      this.prefix + """getListGroupUser""",
      """""",
      Seq()
    )
  )

  // @LINE:256
  private[this] lazy val controllers_GroupListController_getListGroupDevice190_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroupDevice")))
  )
  private[this] lazy val controllers_GroupListController_getListGroupDevice190_invoker = createInvoker(
    GroupListController_68.getListGroupDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "getListGroupDevice",
      Nil,
      "POST",
      this.prefix + """getListGroupDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:257
  private[this] lazy val controllers_GroupListController_getListGroupEvent191_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroupEvent")))
  )
  private[this] lazy val controllers_GroupListController_getListGroupEvent191_invoker = createInvoker(
    GroupListController_68.getListGroupEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "getListGroupEvent",
      Nil,
      "POST",
      this.prefix + """getListGroupEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:258
  private[this] lazy val controllers_GroupListController_getListGroupOrganization192_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroupOrganization")))
  )
  private[this] lazy val controllers_GroupListController_getListGroupOrganization192_invoker = createInvoker(
    GroupListController_68.getListGroupOrganization(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupListController",
      "getListGroupOrganization",
      Nil,
      "POST",
      this.prefix + """getListGroupOrganization""",
      """""",
      Seq()
    )
  )

  // @LINE:261
  private[this] lazy val controllers_HomeController_pageTestApi193_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pageTestApi")))
  )
  private[this] lazy val controllers_HomeController_pageTestApi193_invoker = createInvoker(
    HomeController_10.pageTestApi(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "pageTestApi",
      Nil,
      "GET",
      this.prefix + """pageTestApi""",
      """test api""",
      Seq()
    )
  )

  // @LINE:262
  private[this] lazy val controllers_HomeController_testPostFormUrlencoded194_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("testPostFormUrlencoded")))
  )
  private[this] lazy val controllers_HomeController_testPostFormUrlencoded194_invoker = createInvoker(
    HomeController_10.testPostFormUrlencoded(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "testPostFormUrlencoded",
      Nil,
      "POST",
      this.prefix + """testPostFormUrlencoded""",
      """""",
      Seq()
    )
  )

  // @LINE:263
  private[this] lazy val controllers_HomeController_testPostJson195_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("testPostJson")))
  )
  private[this] lazy val controllers_HomeController_testPostJson195_invoker = createInvoker(
    HomeController_10.testPostJson(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "testPostJson",
      Nil,
      "POST",
      this.prefix + """testPostJson""",
      """""",
      Seq()
    )
  )

  // @LINE:264
  private[this] lazy val controllers_HomeController_testGetByToken196_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("testGetByToken")))
  )
  private[this] lazy val controllers_HomeController_testGetByToken196_invoker = createInvoker(
    HomeController_10.testGetByToken(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "testGetByToken",
      Nil,
      "POST",
      this.prefix + """testGetByToken""",
      """""",
      Seq()
    )
  )

  // @LINE:265
  private[this] lazy val controllers_HomeController_getDashboardByIdOrg197_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDashboardByIdOrg")))
  )
  private[this] lazy val controllers_HomeController_getDashboardByIdOrg197_invoker = createInvoker(
    HomeController_10.getDashboardByIdOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getDashboardByIdOrg",
      Nil,
      "POST",
      this.prefix + """getDashboardByIdOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:266
  private[this] lazy val controllers_HomeController_getDashboardByProjectId198_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDashboardByProjectId")))
  )
  private[this] lazy val controllers_HomeController_getDashboardByProjectId198_invoker = createInvoker(
    HomeController_10.getDashboardByProjectId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getDashboardByProjectId",
      Nil,
      "POST",
      this.prefix + """getDashboardByProjectId""",
      """""",
      Seq()
    )
  )

  // @LINE:269
  private[this] lazy val controllers_RoleController_roleList199_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("roleList")))
  )
  private[this] lazy val controllers_RoleController_roleList199_invoker = createInvoker(
    RoleController_25.roleList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "roleList",
      Nil,
      "GET",
      this.prefix + """roleList""",
      """role""",
      Seq()
    )
  )

  // @LINE:270
  private[this] lazy val controllers_RoleController_addNewRole200_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewRole")))
  )
  private[this] lazy val controllers_RoleController_addNewRole200_invoker = createInvoker(
    RoleController_25.addNewRole(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "addNewRole",
      Nil,
      "POST",
      this.prefix + """addNewRole""",
      """""",
      Seq()
    )
  )

  // @LINE:271
  private[this] lazy val controllers_RoleController_deleteRole201_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteRole")))
  )
  private[this] lazy val controllers_RoleController_deleteRole201_invoker = createInvoker(
    RoleController_25.deleteRole(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "deleteRole",
      Nil,
      "POST",
      this.prefix + """deleteRole""",
      """""",
      Seq()
    )
  )

  // @LINE:272
  private[this] lazy val controllers_RoleController_getRole202_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("roleDetail")))
  )
  private[this] lazy val controllers_RoleController_getRole202_invoker = createInvoker(
    RoleController_25.getRole(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "getRole",
      Nil,
      "GET",
      this.prefix + """roleDetail""",
      """""",
      Seq()
    )
  )

  // @LINE:273
  private[this] lazy val controllers_RoleController_updateRole203_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateRole")))
  )
  private[this] lazy val controllers_RoleController_updateRole203_invoker = createInvoker(
    RoleController_25.updateRole(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "updateRole",
      Nil,
      "POST",
      this.prefix + """updateRole""",
      """""",
      Seq()
    )
  )

  // @LINE:276
  private[this] lazy val controllers_EventController_eventList204_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("eventList")))
  )
  private[this] lazy val controllers_EventController_eventList204_invoker = createInvoker(
    EventController_65.eventList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "eventList",
      Nil,
      "GET",
      this.prefix + """eventList""",
      """event""",
      Seq()
    )
  )

  // @LINE:277
  private[this] lazy val controllers_EventController_addNewEvent205_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewEvent")))
  )
  private[this] lazy val controllers_EventController_addNewEvent205_invoker = createInvoker(
    EventController_65.addNewEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "addNewEvent",
      Nil,
      "POST",
      this.prefix + """addNewEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:278
  private[this] lazy val controllers_EventController_addNewSchedule206_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewSchedule")))
  )
  private[this] lazy val controllers_EventController_addNewSchedule206_invoker = createInvoker(
    EventController_65.addNewSchedule(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "addNewSchedule",
      Nil,
      "POST",
      this.prefix + """addNewSchedule""",
      """""",
      Seq()
    )
  )

  // @LINE:279
  private[this] lazy val controllers_EventController_editEvent207_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editEvent/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EventController_editEvent207_invoker = createInvoker(
    EventController_65.editEvent(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "editEvent",
      Seq(classOf[String]),
      "POST",
      this.prefix + """editEvent/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:280
  private[this] lazy val controllers_EventController_editSchedule208_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editSchedule/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EventController_editSchedule208_invoker = createInvoker(
    EventController_65.editSchedule(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "editSchedule",
      Seq(classOf[String]),
      "POST",
      this.prefix + """editSchedule/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:281
  private[this] lazy val controllers_EventController_onclickEvent209_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("onclickEvent")))
  )
  private[this] lazy val controllers_EventController_onclickEvent209_invoker = createInvoker(
    EventController_65.onclickEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "onclickEvent",
      Nil,
      "POST",
      this.prefix + """onclickEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:282
  private[this] lazy val controllers_EventController_getVarsByDevice210_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("variableList")))
  )
  private[this] lazy val controllers_EventController_getVarsByDevice210_invoker = createInvoker(
    EventController_65.getVarsByDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "getVarsByDevice",
      Nil,
      "GET",
      this.prefix + """variableList""",
      """""",
      Seq()
    )
  )

  // @LINE:283
  private[this] lazy val controllers_EventController_deleteEvent211_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteEvent")))
  )
  private[this] lazy val controllers_EventController_deleteEvent211_invoker = createInvoker(
    EventController_65.deleteEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "deleteEvent",
      Nil,
      "POST",
      this.prefix + """deleteEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:284
  private[this] lazy val controllers_EventController_getEvent212_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("eventDetail")))
  )
  private[this] lazy val controllers_EventController_getEvent212_invoker = createInvoker(
    EventController_65.getEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "getEvent",
      Nil,
      "POST",
      this.prefix + """eventDetail""",
      """""",
      Seq()
    )
  )

  // @LINE:285
  private[this] lazy val controllers_EventController_updateEvent213_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("UpdateEvent")))
  )
  private[this] lazy val controllers_EventController_updateEvent213_invoker = createInvoker(
    EventController_65.updateEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "updateEvent",
      Nil,
      "POST",
      this.prefix + """UpdateEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:286
  private[this] lazy val controllers_EventController_changeEventOrg214_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("changeEventOrg")))
  )
  private[this] lazy val controllers_EventController_changeEventOrg214_invoker = createInvoker(
    EventController_65.changeEventOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "changeEventOrg",
      Nil,
      "POST",
      this.prefix + """changeEventOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:287
  private[this] lazy val controllers_EventController_removeEventOrg215_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeEventOrg")))
  )
  private[this] lazy val controllers_EventController_removeEventOrg215_invoker = createInvoker(
    EventController_65.removeEventOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "removeEventOrg",
      Nil,
      "POST",
      this.prefix + """removeEventOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:288
  private[this] lazy val controllers_EventController_activeEvent216_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activeEvent")))
  )
  private[this] lazy val controllers_EventController_activeEvent216_invoker = createInvoker(
    EventController_65.activeEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "activeEvent",
      Nil,
      "POST",
      this.prefix + """activeEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:289
  private[this] lazy val controllers_EventController_deActiveEvent217_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deActiveEvent")))
  )
  private[this] lazy val controllers_EventController_deActiveEvent217_invoker = createInvoker(
    EventController_65.deActiveEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "deActiveEvent",
      Nil,
      "POST",
      this.prefix + """deActiveEvent""",
      """""",
      Seq()
    )
  )

  // @LINE:292
  private[this] lazy val controllers_RuleChainController_ruleChain218_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ruleEngine/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RuleChainController_ruleChain218_invoker = createInvoker(
    RuleChainController_16.ruleChain(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RuleChainController",
      "ruleChain",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ruleEngine/""" + "$" + """id<[^/]+>""",
      """rule engine""",
      Seq()
    )
  )

  // @LINE:293
  private[this] lazy val controllers_RuleChainController_flowEngineWithId219_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("flowEngineWithId/"), DynamicPart("projectId", """[^/]+""",true), StaticPart("/"), DynamicPart("idFlow", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RuleChainController_flowEngineWithId219_invoker = createInvoker(
    RuleChainController_16.flowEngineWithId(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RuleChainController",
      "flowEngineWithId",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """flowEngineWithId/""" + "$" + """projectId<[^/]+>/""" + "$" + """idFlow<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:296
  private[this] lazy val controllers_PayPackDataController_packData220_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("packData/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PayPackDataController_packData220_invoker = createInvoker(
    PayPackDataController_45.packData(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayPackDataController",
      "packData",
      Seq(classOf[String]),
      "GET",
      this.prefix + """packData/""" + "$" + """id<[^/]+>""",
      """pay""",
      Seq()
    )
  )

  // @LINE:297
  private[this] lazy val controllers_PayPackDataController_getListPackdata221_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListPackdata")))
  )
  private[this] lazy val controllers_PayPackDataController_getListPackdata221_invoker = createInvoker(
    PayPackDataController_45.getListPackdata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayPackDataController",
      "getListPackdata",
      Nil,
      "POST",
      this.prefix + """getListPackdata""",
      """""",
      Seq()
    )
  )

  // @LINE:298
  private[this] lazy val controllers_PayPackDataController_addNewPackdata222_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNewPackdata")))
  )
  private[this] lazy val controllers_PayPackDataController_addNewPackdata222_invoker = createInvoker(
    PayPackDataController_45.addNewPackdata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayPackDataController",
      "addNewPackdata",
      Nil,
      "POST",
      this.prefix + """addNewPackdata""",
      """""",
      Seq()
    )
  )

  // @LINE:299
  private[this] lazy val controllers_PayPackDataController_getInfoPackdata223_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoPackdata")))
  )
  private[this] lazy val controllers_PayPackDataController_getInfoPackdata223_invoker = createInvoker(
    PayPackDataController_45.getInfoPackdata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayPackDataController",
      "getInfoPackdata",
      Nil,
      "POST",
      this.prefix + """getInfoPackdata""",
      """""",
      Seq()
    )
  )

  // @LINE:300
  private[this] lazy val controllers_PayPackDataController_editPackdata224_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editPackdata")))
  )
  private[this] lazy val controllers_PayPackDataController_editPackdata224_invoker = createInvoker(
    PayPackDataController_45.editPackdata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayPackDataController",
      "editPackdata",
      Nil,
      "POST",
      this.prefix + """editPackdata""",
      """""",
      Seq()
    )
  )

  // @LINE:301
  private[this] lazy val controllers_PayPackDataController_deletePackdata225_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletePackdata")))
  )
  private[this] lazy val controllers_PayPackDataController_deletePackdata225_invoker = createInvoker(
    PayPackDataController_45.deletePackdata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayPackDataController",
      "deletePackdata",
      Nil,
      "POST",
      this.prefix + """deletePackdata""",
      """""",
      Seq()
    )
  )

  // @LINE:302
  private[this] lazy val controllers_PayCustomerController_getInfoVendor226_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoVendor")))
  )
  private[this] lazy val controllers_PayCustomerController_getInfoVendor226_invoker = createInvoker(
    PayCustomerController_52.getInfoVendor(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "getInfoVendor",
      Nil,
      "POST",
      this.prefix + """getInfoVendor""",
      """""",
      Seq()
    )
  )

  // @LINE:303
  private[this] lazy val controllers_PayCustomerController_createVendor227_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createVendor")))
  )
  private[this] lazy val controllers_PayCustomerController_createVendor227_invoker = createInvoker(
    PayCustomerController_52.createVendor(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "createVendor",
      Nil,
      "POST",
      this.prefix + """createVendor""",
      """""",
      Seq()
    )
  )

  // @LINE:304
  private[this] lazy val controllers_PayCustomerController_updateVendor228_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateVendor")))
  )
  private[this] lazy val controllers_PayCustomerController_updateVendor228_invoker = createInvoker(
    PayCustomerController_52.updateVendor(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "updateVendor",
      Nil,
      "POST",
      this.prefix + """updateVendor""",
      """""",
      Seq()
    )
  )

  // @LINE:305
  private[this] lazy val controllers_PayCustomerController_getSubscription229_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getSubscription")))
  )
  private[this] lazy val controllers_PayCustomerController_getSubscription229_invoker = createInvoker(
    PayCustomerController_52.getSubscription(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "getSubscription",
      Nil,
      "POST",
      this.prefix + """getSubscription""",
      """""",
      Seq()
    )
  )

  // @LINE:306
  private[this] lazy val controllers_PayCustomerController_createSubscription230_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createSubscription")))
  )
  private[this] lazy val controllers_PayCustomerController_createSubscription230_invoker = createInvoker(
    PayCustomerController_52.createSubscription(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "createSubscription",
      Nil,
      "POST",
      this.prefix + """createSubscription""",
      """""",
      Seq()
    )
  )

  // @LINE:307
  private[this] lazy val controllers_PayCustomerController_cancelSubscription231_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cancelSubscription")))
  )
  private[this] lazy val controllers_PayCustomerController_cancelSubscription231_invoker = createInvoker(
    PayCustomerController_52.cancelSubscription(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "cancelSubscription",
      Nil,
      "POST",
      this.prefix + """cancelSubscription""",
      """""",
      Seq()
    )
  )

  // @LINE:309
  private[this] lazy val controllers_PayCustomerController_payCustomer232_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payCustomer/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PayCustomerController_payCustomer232_invoker = createInvoker(
    PayCustomerController_52.payCustomer(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "payCustomer",
      Seq(classOf[String]),
      "GET",
      this.prefix + """payCustomer/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:310
  private[this] lazy val controllers_PayCustomerController_payment233_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PayCustomerController_payment233_invoker = createInvoker(
    PayCustomerController_52.payment(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "payment",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """payment/""" + "$" + """id<[^/]+>/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:311
  private[this] lazy val controllers_PayCustomerController_getListUserInOrg234_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListUserInOrg")))
  )
  private[this] lazy val controllers_PayCustomerController_getListUserInOrg234_invoker = createInvoker(
    PayCustomerController_52.getListUserInOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "getListUserInOrg",
      Nil,
      "POST",
      this.prefix + """getListUserInOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:312
  private[this] lazy val controllers_PayCustomerController_addPackdataNewForUser235_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addPackdataNewForUser")))
  )
  private[this] lazy val controllers_PayCustomerController_addPackdataNewForUser235_invoker = createInvoker(
    PayCustomerController_52.addPackdataNewForUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "addPackdataNewForUser",
      Nil,
      "POST",
      this.prefix + """addPackdataNewForUser""",
      """""",
      Seq()
    )
  )

  // @LINE:313
  private[this] lazy val controllers_PayCustomerController_postPricingOfCustomer236_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postPricingOfCustomer")))
  )
  private[this] lazy val controllers_PayCustomerController_postPricingOfCustomer236_invoker = createInvoker(
    PayCustomerController_52.postPricingOfCustomer(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "postPricingOfCustomer",
      Nil,
      "POST",
      this.prefix + """postPricingOfCustomer""",
      """""",
      Seq()
    )
  )

  // @LINE:314
  private[this] lazy val controllers_PayCustomerController_getInfoCustomer237_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoCustomer")))
  )
  private[this] lazy val controllers_PayCustomerController_getInfoCustomer237_invoker = createInvoker(
    PayCustomerController_52.getInfoCustomer(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "getInfoCustomer",
      Nil,
      "POST",
      this.prefix + """getInfoCustomer""",
      """""",
      Seq()
    )
  )

  // @LINE:315
  private[this] lazy val controllers_PayCustomerController_createInfoCustomer238_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createInfoCustomer")))
  )
  private[this] lazy val controllers_PayCustomerController_createInfoCustomer238_invoker = createInvoker(
    PayCustomerController_52.createInfoCustomer(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "createInfoCustomer",
      Nil,
      "POST",
      this.prefix + """createInfoCustomer""",
      """""",
      Seq()
    )
  )

  // @LINE:316
  private[this] lazy val controllers_PayCustomerController_updateInfoCustomer239_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateInfoCustomer")))
  )
  private[this] lazy val controllers_PayCustomerController_updateInfoCustomer239_invoker = createInvoker(
    PayCustomerController_52.updateInfoCustomer(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayCustomerController",
      "updateInfoCustomer",
      Nil,
      "POST",
      this.prefix + """updateInfoCustomer""",
      """""",
      Seq()
    )
  )

  // @LINE:318
  private[this] lazy val controllers_PayBillController_billList240_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("billList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PayBillController_billList240_invoker = createInvoker(
    PayBillController_61.billList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayBillController",
      "billList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """billList/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:319
  private[this] lazy val controllers_PayBillController_getAllBill241_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllBill")))
  )
  private[this] lazy val controllers_PayBillController_getAllBill241_invoker = createInvoker(
    PayBillController_61.getAllBill(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayBillController",
      "getAllBill",
      Nil,
      "POST",
      this.prefix + """getAllBill""",
      """""",
      Seq()
    )
  )

  // @LINE:320
  private[this] lazy val controllers_PayBillController_getLinkPayment242_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLinkPayment")))
  )
  private[this] lazy val controllers_PayBillController_getLinkPayment242_invoker = createInvoker(
    PayBillController_61.getLinkPayment(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayBillController",
      "getLinkPayment",
      Nil,
      "POST",
      this.prefix + """getLinkPayment""",
      """""",
      Seq()
    )
  )

  // @LINE:321
  private[this] lazy val controllers_PayBillController_getInfoBill243_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoBill")))
  )
  private[this] lazy val controllers_PayBillController_getInfoBill243_invoker = createInvoker(
    PayBillController_61.getInfoBill(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayBillController",
      "getInfoBill",
      Nil,
      "POST",
      this.prefix + """getInfoBill""",
      """""",
      Seq()
    )
  )

  // @LINE:322
  private[this] lazy val controllers_PayBillController_billUserList244_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("billUserList/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PayBillController_billUserList244_invoker = createInvoker(
    PayBillController_61.billUserList(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayBillController",
      "billUserList",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """billUserList/""" + "$" + """id<[^/]+>/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:323
  private[this] lazy val controllers_PayBillController_getBillOfUser245_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBillOfUser")))
  )
  private[this] lazy val controllers_PayBillController_getBillOfUser245_invoker = createInvoker(
    PayBillController_61.getBillOfUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PayBillController",
      "getBillOfUser",
      Nil,
      "POST",
      this.prefix + """getBillOfUser""",
      """""",
      Seq()
    )
  )

  // @LINE:325
  private[this] lazy val controllers_PaySubsController_subsList246_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subsList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaySubsController_subsList246_invoker = createInvoker(
    PaySubsController_33.subsList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaySubsController",
      "subsList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """subsList/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:326
  private[this] lazy val controllers_PaySubsController_getAllSubs247_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllSubs")))
  )
  private[this] lazy val controllers_PaySubsController_getAllSubs247_invoker = createInvoker(
    PaySubsController_33.getAllSubs(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaySubsController",
      "getAllSubs",
      Nil,
      "POST",
      this.prefix + """getAllSubs""",
      """""",
      Seq()
    )
  )

  // @LINE:327
  private[this] lazy val controllers_PaySubsController_getInfoSub248_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoSub")))
  )
  private[this] lazy val controllers_PaySubsController_getInfoSub248_invoker = createInvoker(
    PaySubsController_33.getInfoSub(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaySubsController",
      "getInfoSub",
      Nil,
      "POST",
      this.prefix + """getInfoSub""",
      """""",
      Seq()
    )
  )

  // @LINE:328
  private[this] lazy val controllers_PaySubsController_getLinkPaymentSub249_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLinkPaymentSub")))
  )
  private[this] lazy val controllers_PaySubsController_getLinkPaymentSub249_invoker = createInvoker(
    PaySubsController_33.getLinkPaymentSub(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaySubsController",
      "getLinkPaymentSub",
      Nil,
      "POST",
      this.prefix + """getLinkPaymentSub""",
      """""",
      Seq()
    )
  )

  // @LINE:330
  private[this] lazy val controllers_ManageSimController_manageSim250_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("manageSim/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ManageSimController_manageSim250_invoker = createInvoker(
    ManageSimController_26.manageSim(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ManageSimController",
      "manageSim",
      Seq(classOf[String]),
      "GET",
      this.prefix + """manageSim/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:331
  private[this] lazy val controllers_ManageSimController_getDataCustomer251_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataCustomer")))
  )
  private[this] lazy val controllers_ManageSimController_getDataCustomer251_invoker = createInvoker(
    ManageSimController_26.getDataCustomer(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ManageSimController",
      "getDataCustomer",
      Nil,
      "POST",
      this.prefix + """getDataCustomer""",
      """""",
      Seq()
    )
  )

  // @LINE:332
  private[this] lazy val controllers_ManageSimController_detailSim252_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detailSim/"), DynamicPart("projectId", """[^/]+""",true), StaticPart("/"), DynamicPart("simnb", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ManageSimController_detailSim252_invoker = createInvoker(
    ManageSimController_26.detailSim(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ManageSimController",
      "detailSim",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """detailSim/""" + "$" + """projectId<[^/]+>/""" + "$" + """simnb<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:335
  private[this] lazy val controllers_DevkitController_devkit253_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("devkit/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DevkitController_devkit253_invoker = createInvoker(
    DevkitController_15.devkit(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DevkitController",
      "devkit",
      Seq(classOf[String]),
      "GET",
      this.prefix + """devkit/""" + "$" + """id<[^/]+>""",
      """devkit""",
      Seq()
    )
  )

  // @LINE:337
  private[this] lazy val controllers_ModuleController_module254_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("module/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ModuleController_module254_invoker = createInvoker(
    ModuleController_72.module(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ModuleController",
      "module",
      Seq(classOf[String]),
      "GET",
      this.prefix + """module/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:340
  private[this] lazy val controllers_AppDebugController_appDebug255_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("appDebug/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AppDebugController_appDebug255_invoker = createInvoker(
    AppDebugController_23.appDebug(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppDebugController",
      "appDebug",
      Seq(classOf[String]),
      "GET",
      this.prefix + """appDebug/""" + "$" + """id<[^/]+>""",
      """app""",
      Seq()
    )
  )

  // @LINE:341
  private[this] lazy val controllers_AppDebugController_appDebugPage256_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("appDebugPage")))
  )
  private[this] lazy val controllers_AppDebugController_appDebugPage256_invoker = createInvoker(
    AppDebugController_23.appDebugPage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppDebugController",
      "appDebugPage",
      Nil,
      "GET",
      this.prefix + """appDebugPage""",
      """""",
      Seq()
    )
  )

  // @LINE:342
  private[this] lazy val controllers_AppDebugController_appSdk257_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("appSdk/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AppDebugController_appSdk257_invoker = createInvoker(
    AppDebugController_23.appSdk(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppDebugController",
      "appSdk",
      Seq(classOf[String]),
      "GET",
      this.prefix + """appSdk/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:343
  private[this] lazy val controllers_AppDebugController_appSdkPage258_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("appSdkPage")))
  )
  private[this] lazy val controllers_AppDebugController_appSdkPage258_invoker = createInvoker(
    AppDebugController_23.appSdkPage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppDebugController",
      "appSdkPage",
      Nil,
      "GET",
      this.prefix + """appSdkPage""",
      """""",
      Seq()
    )
  )

  // @LINE:344
  private[this] lazy val controllers_AppDebugController_solutionMaketPage259_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("solutionMaketPage")))
  )
  private[this] lazy val controllers_AppDebugController_solutionMaketPage259_invoker = createInvoker(
    AppDebugController_23.solutionMaketPage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppDebugController",
      "solutionMaketPage",
      Nil,
      "GET",
      this.prefix + """solutionMaketPage""",
      """""",
      Seq()
    )
  )

  // @LINE:348
  private[this] lazy val controllers_QrCodeController_qrCodeList260_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qrCodeList")))
  )
  private[this] lazy val controllers_QrCodeController_qrCodeList260_invoker = createInvoker(
    QrCodeController_0.qrCodeList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "qrCodeList",
      Nil,
      "GET",
      this.prefix + """qrCodeList""",
      """page qr code
GET        /qrCode                                 controllers.QrCodeController.qrCode()""",
      Seq()
    )
  )

  // @LINE:349
  private[this] lazy val controllers_QrCodeController_createQrCode261_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createQrCode")))
  )
  private[this] lazy val controllers_QrCodeController_createQrCode261_invoker = createInvoker(
    QrCodeController_0.createQrCode(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "createQrCode",
      Nil,
      "POST",
      this.prefix + """createQrCode""",
      """""",
      Seq()
    )
  )

  // @LINE:350
  private[this] lazy val controllers_QrCodeController_qrCodeImg262_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qrCodeImg/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QrCodeController_qrCodeImg262_invoker = createInvoker(
    QrCodeController_0.qrCodeImg(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "qrCodeImg",
      Seq(classOf[String]),
      "GET",
      this.prefix + """qrCodeImg/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:351
  private[this] lazy val controllers_QrCodeController_getListQrCode263_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListQrCode")))
  )
  private[this] lazy val controllers_QrCodeController_getListQrCode263_invoker = createInvoker(
    QrCodeController_0.getListQrCode(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "getListQrCode",
      Nil,
      "GET",
      this.prefix + """getListQrCode""",
      """""",
      Seq()
    )
  )

  // @LINE:352
  private[this] lazy val controllers_QrCodeController_deleteQrCode264_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteQrCode")))
  )
  private[this] lazy val controllers_QrCodeController_deleteQrCode264_invoker = createInvoker(
    QrCodeController_0.deleteQrCode(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "deleteQrCode",
      Nil,
      "POST",
      this.prefix + """deleteQrCode""",
      """""",
      Seq()
    )
  )

  // @LINE:353
  private[this] lazy val controllers_QrCodeController_qrCodeHistoryList265_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qrCodeHistoryList")))
  )
  private[this] lazy val controllers_QrCodeController_qrCodeHistoryList265_invoker = createInvoker(
    QrCodeController_0.qrCodeHistoryList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "qrCodeHistoryList",
      Nil,
      "GET",
      this.prefix + """qrCodeHistoryList""",
      """""",
      Seq()
    )
  )

  // @LINE:354
  private[this] lazy val controllers_QrCodeController_editQrCode266_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editQrCode")))
  )
  private[this] lazy val controllers_QrCodeController_editQrCode266_invoker = createInvoker(
    QrCodeController_0.editQrCode(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeController",
      "editQrCode",
      Nil,
      "POST",
      this.prefix + """editQrCode""",
      """""",
      Seq()
    )
  )

  // @LINE:356
  private[this] lazy val controllers_QrCodeCamController_qrCodeCam267_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qrCodeCam")))
  )
  private[this] lazy val controllers_QrCodeCamController_qrCodeCam267_invoker = createInvoker(
    QrCodeCamController_54.qrCodeCam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeCamController",
      "qrCodeCam",
      Nil,
      "GET",
      this.prefix + """qrCodeCam""",
      """""",
      Seq()
    )
  )

  // @LINE:357
  private[this] lazy val controllers_QrCodeCamController_createQrCodeCam268_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createQrCodeCam")))
  )
  private[this] lazy val controllers_QrCodeCamController_createQrCodeCam268_invoker = createInvoker(
    QrCodeCamController_54.createQrCodeCam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeCamController",
      "createQrCodeCam",
      Nil,
      "POST",
      this.prefix + """createQrCodeCam""",
      """""",
      Seq()
    )
  )

  // @LINE:358
  private[this] lazy val controllers_QrCodeCamController_deleteQrCodeCam269_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteQrCodeCam")))
  )
  private[this] lazy val controllers_QrCodeCamController_deleteQrCodeCam269_invoker = createInvoker(
    QrCodeCamController_54.deleteQrCodeCam(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QrCodeCamController",
      "deleteQrCodeCam",
      Nil,
      "POST",
      this.prefix + """deleteQrCodeCam""",
      """""",
      Seq()
    )
  )

  // @LINE:361
  private[this] lazy val controllers_OAuthController_getLogin270_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("oauth/login")))
  )
  private[this] lazy val controllers_OAuthController_getLogin270_invoker = createInvoker(
    OAuthController_9.getLogin(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuthController",
      "getLogin",
      Seq(classOf[String]),
      "GET",
      this.prefix + """oauth/login""",
      """oauth""",
      Seq()
    )
  )

  // @LINE:362
  private[this] lazy val controllers_OAuthController_postLogin271_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("oauth/login")))
  )
  private[this] lazy val controllers_OAuthController_postLogin271_invoker = createInvoker(
    OAuthController_9.postLogin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuthController",
      "postLogin",
      Nil,
      "POST",
      this.prefix + """oauth/login""",
      """""",
      Seq()
    )
  )

  // @LINE:363
  private[this] lazy val controllers_OAuthController_getConsent272_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("oauth/consent")))
  )
  private[this] lazy val controllers_OAuthController_getConsent272_invoker = createInvoker(
    OAuthController_9.getConsent(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuthController",
      "getConsent",
      Seq(classOf[String]),
      "GET",
      this.prefix + """oauth/consent""",
      """""",
      Seq()
    )
  )

  // @LINE:364
  private[this] lazy val controllers_OAuthController_postConsent273_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("oauth/consent")))
  )
  private[this] lazy val controllers_OAuthController_postConsent273_invoker = createInvoker(
    OAuthController_9.postConsent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuthController",
      "postConsent",
      Nil,
      "POST",
      this.prefix + """oauth/consent""",
      """""",
      Seq()
    )
  )

  // @LINE:365
  private[this] lazy val controllers_OAuthController_callback274_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("oauth/callback")))
  )
  private[this] lazy val controllers_OAuthController_callback274_invoker = createInvoker(
    OAuthController_9.callback(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuthController",
      "callback",
      Seq(classOf[String]),
      "GET",
      this.prefix + """oauth/callback""",
      """""",
      Seq()
    )
  )

  // @LINE:369
  private[this] lazy val controllers_SolutionTrackingController_monitorMap275_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("monitorMap/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SolutionTrackingController_monitorMap275_invoker = createInvoker(
    SolutionTrackingController_18.monitorMap(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SolutionTrackingController",
      "monitorMap",
      Seq(classOf[String]),
      "GET",
      this.prefix + """monitorMap/""" + "$" + """id<[^/]+>""",
      """solution
tracking""",
      Seq()
    )
  )

  // @LINE:370
  private[this] lazy val controllers_SolutionTrackingController_getListGpsDevice276_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGpsDevice")))
  )
  private[this] lazy val controllers_SolutionTrackingController_getListGpsDevice276_invoker = createInvoker(
    SolutionTrackingController_18.getListGpsDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SolutionTrackingController",
      "getListGpsDevice",
      Nil,
      "POST",
      this.prefix + """getListGpsDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:371
  private[this] lazy val controllers_SolutionTrackingController_getInfoDevice277_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoDevice")))
  )
  private[this] lazy val controllers_SolutionTrackingController_getInfoDevice277_invoker = createInvoker(
    SolutionTrackingController_18.getInfoDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SolutionTrackingController",
      "getInfoDevice",
      Nil,
      "POST",
      this.prefix + """getInfoDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:372
  private[this] lazy val controllers_SolutionTrackingController_historyMap278_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyMap/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SolutionTrackingController_historyMap278_invoker = createInvoker(
    SolutionTrackingController_18.historyMap(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SolutionTrackingController",
      "historyMap",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyMap/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:373
  private[this] lazy val controllers_SolutionTrackingController_loadLocationHistory279_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loadLocationHistory")))
  )
  private[this] lazy val controllers_SolutionTrackingController_loadLocationHistory279_invoker = createInvoker(
    SolutionTrackingController_18.loadLocationHistory(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SolutionTrackingController",
      "loadLocationHistory",
      Nil,
      "POST",
      this.prefix + """loadLocationHistory""",
      """""",
      Seq()
    )
  )

  // @LINE:376
  private[this] lazy val controllers_WaterClockController_waterClock280_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("waterClock")))
  )
  private[this] lazy val controllers_WaterClockController_waterClock280_invoker = createInvoker(
    WaterClockController_20.waterClock(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WaterClockController",
      "waterClock",
      Nil,
      "GET",
      this.prefix + """waterClock""",
      """waterClock""",
      Seq()
    )
  )

  // @LINE:377
  private[this] lazy val controllers_WaterClockController_getListClock281_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListClock")))
  )
  private[this] lazy val controllers_WaterClockController_getListClock281_invoker = createInvoker(
    WaterClockController_20.getListClock(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WaterClockController",
      "getListClock",
      Nil,
      "POST",
      this.prefix + """getListClock""",
      """""",
      Seq()
    )
  )

  // @LINE:378
  private[this] lazy val controllers_WaterClockController_getHistoryClock282_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryClock")))
  )
  private[this] lazy val controllers_WaterClockController_getHistoryClock282_invoker = createInvoker(
    WaterClockController_20.getHistoryClock(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WaterClockController",
      "getHistoryClock",
      Nil,
      "POST",
      this.prefix + """getHistoryClock""",
      """""",
      Seq()
    )
  )

  // @LINE:381
  private[this] lazy val controllers_TemplateDeviceController_templateDeviceList283_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("templateDeviceList")))
  )
  private[this] lazy val controllers_TemplateDeviceController_templateDeviceList283_invoker = createInvoker(
    TemplateDeviceController_7.templateDeviceList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TemplateDeviceController",
      "templateDeviceList",
      Nil,
      "GET",
      this.prefix + """templateDeviceList""",
      """TODO: ADMIN""",
      Seq()
    )
  )

  // @LINE:382
  private[this] lazy val controllers_TemplateDeviceController_addTemplateDevice284_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addTemplateDevice")))
  )
  private[this] lazy val controllers_TemplateDeviceController_addTemplateDevice284_invoker = createInvoker(
    TemplateDeviceController_7.addTemplateDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TemplateDeviceController",
      "addTemplateDevice",
      Nil,
      "POST",
      this.prefix + """addTemplateDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:383
  private[this] lazy val controllers_TemplateDeviceController_getListTemplateDevice285_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListTemplateDevice")))
  )
  private[this] lazy val controllers_TemplateDeviceController_getListTemplateDevice285_invoker = createInvoker(
    TemplateDeviceController_7.getListTemplateDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TemplateDeviceController",
      "getListTemplateDevice",
      Nil,
      "POST",
      this.prefix + """getListTemplateDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:384
  private[this] lazy val controllers_TemplateDeviceController_getTemplateDeviceById286_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTemplateDeviceById")))
  )
  private[this] lazy val controllers_TemplateDeviceController_getTemplateDeviceById286_invoker = createInvoker(
    TemplateDeviceController_7.getTemplateDeviceById(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TemplateDeviceController",
      "getTemplateDeviceById",
      Nil,
      "POST",
      this.prefix + """getTemplateDeviceById""",
      """""",
      Seq()
    )
  )

  // @LINE:385
  private[this] lazy val controllers_TemplateDeviceController_editTemplateDevice287_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editTemplateDevice")))
  )
  private[this] lazy val controllers_TemplateDeviceController_editTemplateDevice287_invoker = createInvoker(
    TemplateDeviceController_7.editTemplateDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TemplateDeviceController",
      "editTemplateDevice",
      Nil,
      "POST",
      this.prefix + """editTemplateDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:386
  private[this] lazy val controllers_TemplateDeviceController_deleteTemplateDevice288_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteTemplateDeviceById")))
  )
  private[this] lazy val controllers_TemplateDeviceController_deleteTemplateDevice288_invoker = createInvoker(
    TemplateDeviceController_7.deleteTemplateDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TemplateDeviceController",
      "deleteTemplateDevice",
      Nil,
      "POST",
      this.prefix + """deleteTemplateDeviceById""",
      """""",
      Seq()
    )
  )

  // @LINE:388
  private[this] lazy val controllers_AdminOverviewController_adminOverview289_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminOverview")))
  )
  private[this] lazy val controllers_AdminOverviewController_adminOverview289_invoker = createInvoker(
    AdminOverviewController_46.adminOverview(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "adminOverview",
      Nil,
      "GET",
      this.prefix + """adminOverview""",
      """""",
      Seq()
    )
  )

  // @LINE:389
  private[this] lazy val controllers_AdminOverviewController_getTotalOverview290_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTotalOverview")))
  )
  private[this] lazy val controllers_AdminOverviewController_getTotalOverview290_invoker = createInvoker(
    AdminOverviewController_46.getTotalOverview(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "getTotalOverview",
      Nil,
      "POST",
      this.prefix + """getTotalOverview""",
      """""",
      Seq()
    )
  )

  // @LINE:390
  private[this] lazy val controllers_AdminOverviewController_postJsonTotalOverview291_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postJsonTotalOverview")))
  )
  private[this] lazy val controllers_AdminOverviewController_postJsonTotalOverview291_invoker = createInvoker(
    AdminOverviewController_46.postJsonTotalOverview(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "postJsonTotalOverview",
      Nil,
      "POST",
      this.prefix + """postJsonTotalOverview""",
      """""",
      Seq()
    )
  )

  // @LINE:391
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewSmarthome292_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoOVerviewSmarthome")))
  )
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewSmarthome292_invoker = createInvoker(
    AdminOverviewController_46.getInfoOVerviewSmarthome(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "getInfoOVerviewSmarthome",
      Nil,
      "POST",
      this.prefix + """getInfoOVerviewSmarthome""",
      """""",
      Seq()
    )
  )

  // @LINE:392
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewVtag293_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoOVerviewVtag")))
  )
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewVtag293_invoker = createInvoker(
    AdminOverviewController_46.getInfoOVerviewVtag(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "getInfoOVerviewVtag",
      Nil,
      "POST",
      this.prefix + """getInfoOVerviewVtag""",
      """""",
      Seq()
    )
  )

  // @LINE:393
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewFleet294_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoOVerviewFleet")))
  )
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewFleet294_invoker = createInvoker(
    AdminOverviewController_46.getInfoOVerviewFleet(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "getInfoOVerviewFleet",
      Nil,
      "POST",
      this.prefix + """getInfoOVerviewFleet""",
      """""",
      Seq()
    )
  )

  // @LINE:394
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewMetter295_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoOVerviewMetter")))
  )
  private[this] lazy val controllers_AdminOverviewController_getInfoOVerviewMetter295_invoker = createInvoker(
    AdminOverviewController_46.getInfoOVerviewMetter(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "getInfoOVerviewMetter",
      Nil,
      "POST",
      this.prefix + """getInfoOVerviewMetter""",
      """""",
      Seq()
    )
  )

  // @LINE:395
  private[this] lazy val controllers_AdminOverviewController_getListProjectWithPaging296_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListProjectWithPaging")))
  )
  private[this] lazy val controllers_AdminOverviewController_getListProjectWithPaging296_invoker = createInvoker(
    AdminOverviewController_46.getListProjectWithPaging(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewController",
      "getListProjectWithPaging",
      Nil,
      "POST",
      this.prefix + """getListProjectWithPaging""",
      """""",
      Seq()
    )
  )

  // @LINE:397
  private[this] lazy val controllers_AdminManageSimController_adminManageSim297_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminManageSim")))
  )
  private[this] lazy val controllers_AdminManageSimController_adminManageSim297_invoker = createInvoker(
    AdminManageSimController_39.adminManageSim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminManageSimController",
      "adminManageSim",
      Nil,
      "GET",
      this.prefix + """adminManageSim""",
      """""",
      Seq()
    )
  )

  // @LINE:398
  private[this] lazy val controllers_AdminManageSimController_getAllProjectWithPaging298_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllProjectWithPaging")))
  )
  private[this] lazy val controllers_AdminManageSimController_getAllProjectWithPaging298_invoker = createInvoker(
    AdminManageSimController_39.getAllProjectWithPaging(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminManageSimController",
      "getAllProjectWithPaging",
      Nil,
      "POST",
      this.prefix + """getAllProjectWithPaging""",
      """""",
      Seq()
    )
  )

  // @LINE:399
  private[this] lazy val controllers_AdminManageSimController_getListDeviceWithProjectId299_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListDeviceWithProjectId")))
  )
  private[this] lazy val controllers_AdminManageSimController_getListDeviceWithProjectId299_invoker = createInvoker(
    AdminManageSimController_39.getListDeviceWithProjectId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminManageSimController",
      "getListDeviceWithProjectId",
      Nil,
      "POST",
      this.prefix + """getListDeviceWithProjectId""",
      """""",
      Seq()
    )
  )

  // @LINE:400
  private[this] lazy val controllers_AdminManageSimController_getAttrSimDevice300_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAttrSimDevice")))
  )
  private[this] lazy val controllers_AdminManageSimController_getAttrSimDevice300_invoker = createInvoker(
    AdminManageSimController_39.getAttrSimDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminManageSimController",
      "getAttrSimDevice",
      Nil,
      "POST",
      this.prefix + """getAttrSimDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:402
  private[this] lazy val controllers_AdminSystemHealthController_systemHealth301_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("systemHealth")))
  )
  private[this] lazy val controllers_AdminSystemHealthController_systemHealth301_invoker = createInvoker(
    AdminSystemHealthController_70.systemHealth(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminSystemHealthController",
      "systemHealth",
      Nil,
      "GET",
      this.prefix + """systemHealth""",
      """""",
      Seq()
    )
  )

  // @LINE:404
  private[this] lazy val controllers_AdminOverviewProjectController_adminOverviewProject302_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminOverviewProject/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminOverviewProjectController_adminOverviewProject302_invoker = createInvoker(
    AdminOverviewProjectController_37.adminOverviewProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminOverviewProjectController",
      "adminOverviewProject",
      Seq(classOf[String]),
      "GET",
      this.prefix + """adminOverviewProject/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:407
  private[this] lazy val controllers_AdminRegisterDeveloperController_registerDeveloperList303_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registerDeveloperList")))
  )
  private[this] lazy val controllers_AdminRegisterDeveloperController_registerDeveloperList303_invoker = createInvoker(
    AdminRegisterDeveloperController_36.registerDeveloperList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminRegisterDeveloperController",
      "registerDeveloperList",
      Nil,
      "GET",
      this.prefix + """registerDeveloperList""",
      """""",
      Seq()
    )
  )

  // @LINE:408
  private[this] lazy val controllers_AdminRegisterDeveloperController_registerDeveloperFilterList304_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registerDeveloperList")))
  )
  private[this] lazy val controllers_AdminRegisterDeveloperController_registerDeveloperFilterList304_invoker = createInvoker(
    AdminRegisterDeveloperController_36.registerDeveloperFilterList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminRegisterDeveloperController",
      "registerDeveloperFilterList",
      Nil,
      "POST",
      this.prefix + """registerDeveloperList""",
      """""",
      Seq()
    )
  )

  // @LINE:409
  private[this] lazy val controllers_AdminRegisterDeveloperController_exportRegisterDeveloperList305_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("exportRegisterDeveloperList")))
  )
  private[this] lazy val controllers_AdminRegisterDeveloperController_exportRegisterDeveloperList305_invoker = createInvoker(
    AdminRegisterDeveloperController_36.exportRegisterDeveloperList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminRegisterDeveloperController",
      "exportRegisterDeveloperList",
      Nil,
      "POST",
      this.prefix + """exportRegisterDeveloperList""",
      """""",
      Seq()
    )
  )

  // @LINE:410
  private[this] lazy val controllers_AdminRegisterDeveloperController_deleteRegisterDeveloper306_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteRegisterDeveloper")))
  )
  private[this] lazy val controllers_AdminRegisterDeveloperController_deleteRegisterDeveloper306_invoker = createInvoker(
    AdminRegisterDeveloperController_36.deleteRegisterDeveloper(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminRegisterDeveloperController",
      "deleteRegisterDeveloper",
      Nil,
      "POST",
      this.prefix + """deleteRegisterDeveloper""",
      """""",
      Seq()
    )
  )

  // @LINE:413
  private[this] lazy val controllers_AdminGroupProductController_groupProductList307_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groupProductList")))
  )
  private[this] lazy val controllers_AdminGroupProductController_groupProductList307_invoker = createInvoker(
    AdminGroupProductController_69.groupProductList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminGroupProductController",
      "groupProductList",
      Nil,
      "GET",
      this.prefix + """groupProductList""",
      """TODO: market place""",
      Seq()
    )
  )

  // @LINE:414
  private[this] lazy val controllers_AdminGroupProductController_getListGroupProduct308_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGroupProduct")))
  )
  private[this] lazy val controllers_AdminGroupProductController_getListGroupProduct308_invoker = createInvoker(
    AdminGroupProductController_69.getListGroupProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminGroupProductController",
      "getListGroupProduct",
      Nil,
      "POST",
      this.prefix + """getListGroupProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:415
  private[this] lazy val controllers_AdminGroupProductController_addGroupProduct309_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addGroupProduct")))
  )
  private[this] lazy val controllers_AdminGroupProductController_addGroupProduct309_invoker = createInvoker(
    AdminGroupProductController_69.addGroupProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminGroupProductController",
      "addGroupProduct",
      Nil,
      "POST",
      this.prefix + """addGroupProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:416
  private[this] lazy val controllers_AdminGroupProductController_deleteGroupProduct310_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteGroupProduct")))
  )
  private[this] lazy val controllers_AdminGroupProductController_deleteGroupProduct310_invoker = createInvoker(
    AdminGroupProductController_69.deleteGroupProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminGroupProductController",
      "deleteGroupProduct",
      Nil,
      "POST",
      this.prefix + """deleteGroupProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:417
  private[this] lazy val controllers_AdminGroupProductController_editGroupProduct311_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editGroupProduct")))
  )
  private[this] lazy val controllers_AdminGroupProductController_editGroupProduct311_invoker = createInvoker(
    AdminGroupProductController_69.editGroupProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminGroupProductController",
      "editGroupProduct",
      Nil,
      "POST",
      this.prefix + """editGroupProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:419
  private[this] lazy val controllers_ProductListController_productList312_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("productList/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductListController_productList312_invoker = createInvoker(
    ProductListController_60.productList(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "productList",
      Seq(classOf[String]),
      "GET",
      this.prefix + """productList/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:420
  private[this] lazy val controllers_ProductListController_createProduct313_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createProduct")))
  )
  private[this] lazy val controllers_ProductListController_createProduct313_invoker = createInvoker(
    ProductListController_60.createProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "createProduct",
      Nil,
      "POST",
      this.prefix + """createProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:421
  private[this] lazy val controllers_ProductListController_getProductByUser314_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getProductByUser")))
  )
  private[this] lazy val controllers_ProductListController_getProductByUser314_invoker = createInvoker(
    ProductListController_60.getProductByUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "getProductByUser",
      Nil,
      "POST",
      this.prefix + """getProductByUser""",
      """""",
      Seq()
    )
  )

  // @LINE:422
  private[this] lazy val controllers_ProductListController_deleteProduct315_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteProduct")))
  )
  private[this] lazy val controllers_ProductListController_deleteProduct315_invoker = createInvoker(
    ProductListController_60.deleteProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "deleteProduct",
      Nil,
      "POST",
      this.prefix + """deleteProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:423
  private[this] lazy val controllers_ProductListController_getProductById316_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getProductById")))
  )
  private[this] lazy val controllers_ProductListController_getProductById316_invoker = createInvoker(
    ProductListController_60.getProductById(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "getProductById",
      Nil,
      "POST",
      this.prefix + """getProductById""",
      """""",
      Seq()
    )
  )

  // @LINE:424
  private[this] lazy val controllers_ProductListController_editProduct317_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editProduct")))
  )
  private[this] lazy val controllers_ProductListController_editProduct317_invoker = createInvoker(
    ProductListController_60.editProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "editProduct",
      Nil,
      "POST",
      this.prefix + """editProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:426
  private[this] lazy val controllers_ProductListController_manageProductList318_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("manageProductList")))
  )
  private[this] lazy val controllers_ProductListController_manageProductList318_invoker = createInvoker(
    ProductListController_60.manageProductList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "manageProductList",
      Nil,
      "GET",
      this.prefix + """manageProductList""",
      """""",
      Seq()
    )
  )

  // @LINE:427
  private[this] lazy val controllers_ProductListController_manageProductFilterList319_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("manageProductList")))
  )
  private[this] lazy val controllers_ProductListController_manageProductFilterList319_invoker = createInvoker(
    ProductListController_60.manageProductFilterList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "manageProductFilterList",
      Nil,
      "POST",
      this.prefix + """manageProductList""",
      """""",
      Seq()
    )
  )

  // @LINE:428
  private[this] lazy val controllers_ProductListController_changeStatusProduct320_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("changeStatusProduct")))
  )
  private[this] lazy val controllers_ProductListController_changeStatusProduct320_invoker = createInvoker(
    ProductListController_60.changeStatusProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "changeStatusProduct",
      Nil,
      "POST",
      this.prefix + """changeStatusProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:429
  private[this] lazy val controllers_ProductListController_requestApproveProduct321_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("requestApproveProduct")))
  )
  private[this] lazy val controllers_ProductListController_requestApproveProduct321_invoker = createInvoker(
    ProductListController_60.requestApproveProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductListController",
      "requestApproveProduct",
      Nil,
      "POST",
      this.prefix + """requestApproveProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:432
  private[this] lazy val controllers_MarketPlaceController_marketPlace322_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("marketPlace")))
  )
  private[this] lazy val controllers_MarketPlaceController_marketPlace322_invoker = createInvoker(
    MarketPlaceController_28.marketPlace(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "marketPlace",
      Nil,
      "GET",
      this.prefix + """marketPlace""",
      """marketPlace""",
      Seq()
    )
  )

  // @LINE:433
  private[this] lazy val controllers_MarketPlaceController_marketPlaceSolution323_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("marketPlace/solution")))
  )
  private[this] lazy val controllers_MarketPlaceController_marketPlaceSolution323_invoker = createInvoker(
    MarketPlaceController_28.marketPlaceSolution(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "marketPlaceSolution",
      Nil,
      "GET",
      this.prefix + """marketPlace/solution""",
      """""",
      Seq()
    )
  )

  // @LINE:434
  private[this] lazy val controllers_MarketPlaceController_marketPlaceDevice324_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("marketPlace/device")))
  )
  private[this] lazy val controllers_MarketPlaceController_marketPlaceDevice324_invoker = createInvoker(
    MarketPlaceController_28.marketPlaceDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "marketPlaceDevice",
      Nil,
      "GET",
      this.prefix + """marketPlace/device""",
      """""",
      Seq()
    )
  )

  // @LINE:435
  private[this] lazy val controllers_MarketPlaceController_getProductMarket325_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getProductMarket")))
  )
  private[this] lazy val controllers_MarketPlaceController_getProductMarket325_invoker = createInvoker(
    MarketPlaceController_28.getProductMarket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getProductMarket",
      Nil,
      "POST",
      this.prefix + """getProductMarket""",
      """""",
      Seq()
    )
  )

  // @LINE:436
  private[this] lazy val controllers_MarketPlaceController_getAllProduct326_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllProduct")))
  )
  private[this] lazy val controllers_MarketPlaceController_getAllProduct326_invoker = createInvoker(
    MarketPlaceController_28.getAllProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getAllProduct",
      Nil,
      "POST",
      this.prefix + """getAllProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:437
  private[this] lazy val controllers_MarketPlaceController_getAllGroupProduct327_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllGroupProduct")))
  )
  private[this] lazy val controllers_MarketPlaceController_getAllGroupProduct327_invoker = createInvoker(
    MarketPlaceController_28.getAllGroupProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getAllGroupProduct",
      Nil,
      "POST",
      this.prefix + """getAllGroupProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:438
  private[this] lazy val controllers_MarketPlaceController_getAllGroupSolution328_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllGroupSolution")))
  )
  private[this] lazy val controllers_MarketPlaceController_getAllGroupSolution328_invoker = createInvoker(
    MarketPlaceController_28.getAllGroupSolution(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getAllGroupSolution",
      Nil,
      "POST",
      this.prefix + """getAllGroupSolution""",
      """""",
      Seq()
    )
  )

  // @LINE:439
  private[this] lazy val controllers_MarketPlaceController_getAllGroupDevice329_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllGroupDevice")))
  )
  private[this] lazy val controllers_MarketPlaceController_getAllGroupDevice329_invoker = createInvoker(
    MarketPlaceController_28.getAllGroupDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getAllGroupDevice",
      Nil,
      "POST",
      this.prefix + """getAllGroupDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:440
  private[this] lazy val controllers_MarketPlaceController_getAllSolution330_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllSolution")))
  )
  private[this] lazy val controllers_MarketPlaceController_getAllSolution330_invoker = createInvoker(
    MarketPlaceController_28.getAllSolution(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getAllSolution",
      Nil,
      "POST",
      this.prefix + """getAllSolution""",
      """""",
      Seq()
    )
  )

  // @LINE:441
  private[this] lazy val controllers_MarketPlaceController_getAllDevice331_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllDevice")))
  )
  private[this] lazy val controllers_MarketPlaceController_getAllDevice331_invoker = createInvoker(
    MarketPlaceController_28.getAllDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getAllDevice",
      Nil,
      "POST",
      this.prefix + """getAllDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:442
  private[this] lazy val controllers_MarketPlaceController_detailProduct332_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("marketPlace/product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MarketPlaceController_detailProduct332_invoker = createInvoker(
    MarketPlaceController_28.detailProduct(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "detailProduct",
      Seq(classOf[String]),
      "GET",
      this.prefix + """marketPlace/product/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:443
  private[this] lazy val controllers_MarketPlaceController_getDetailProductWithId333_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailProductWithId")))
  )
  private[this] lazy val controllers_MarketPlaceController_getDetailProductWithId333_invoker = createInvoker(
    MarketPlaceController_28.getDetailProductWithId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getDetailProductWithId",
      Nil,
      "POST",
      this.prefix + """getDetailProductWithId""",
      """""",
      Seq()
    )
  )

  // @LINE:444
  private[this] lazy val controllers_MarketPlaceController_getSameProduct334_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getSameProduct")))
  )
  private[this] lazy val controllers_MarketPlaceController_getSameProduct334_invoker = createInvoker(
    MarketPlaceController_28.getSameProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceController",
      "getSameProduct",
      Nil,
      "POST",
      this.prefix + """getSameProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:446
  private[this] lazy val controllers_MarketPlaceContactController_productContactList335_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("productContactList")))
  )
  private[this] lazy val controllers_MarketPlaceContactController_productContactList335_invoker = createInvoker(
    MarketPlaceContactController_59.productContactList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceContactController",
      "productContactList",
      Nil,
      "GET",
      this.prefix + """productContactList""",
      """""",
      Seq()
    )
  )

  // @LINE:447
  private[this] lazy val controllers_MarketPlaceContactController_productContactFilterList336_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("productContactList")))
  )
  private[this] lazy val controllers_MarketPlaceContactController_productContactFilterList336_invoker = createInvoker(
    MarketPlaceContactController_59.productContactFilterList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceContactController",
      "productContactFilterList",
      Nil,
      "POST",
      this.prefix + """productContactList""",
      """""",
      Seq()
    )
  )

  // @LINE:448
  private[this] lazy val controllers_MarketPlaceContactController_sendContactMarket337_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendContactMarket")))
  )
  private[this] lazy val controllers_MarketPlaceContactController_sendContactMarket337_invoker = createInvoker(
    MarketPlaceContactController_59.sendContactMarket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceContactController",
      "sendContactMarket",
      Nil,
      "POST",
      this.prefix + """sendContactMarket""",
      """""",
      Seq()
    )
  )

  // @LINE:449
  private[this] lazy val controllers_MarketPlaceContactController_editContactMarket338_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editContactMarket")))
  )
  private[this] lazy val controllers_MarketPlaceContactController_editContactMarket338_invoker = createInvoker(
    MarketPlaceContactController_59.editContactMarket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceContactController",
      "editContactMarket",
      Nil,
      "POST",
      this.prefix + """editContactMarket""",
      """""",
      Seq()
    )
  )

  // @LINE:451
  private[this] lazy val controllers_MarketPlaceCommentController_commentWithProductId339_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("commentWithProductId")))
  )
  private[this] lazy val controllers_MarketPlaceCommentController_commentWithProductId339_invoker = createInvoker(
    MarketPlaceCommentController_11.commentWithProductId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceCommentController",
      "commentWithProductId",
      Nil,
      "POST",
      this.prefix + """commentWithProductId""",
      """""",
      Seq()
    )
  )

  // @LINE:452
  private[this] lazy val controllers_MarketPlaceCommentController_getListCommentProduct340_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListCommentProduct")))
  )
  private[this] lazy val controllers_MarketPlaceCommentController_getListCommentProduct340_invoker = createInvoker(
    MarketPlaceCommentController_11.getListCommentProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MarketPlaceCommentController",
      "getListCommentProduct",
      Nil,
      "POST",
      this.prefix + """getListCommentProduct""",
      """""",
      Seq()
    )
  )

  // @LINE:455
  private[this] lazy val controllers_UserTenantListController_userTenantList341_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userTenantList")))
  )
  private[this] lazy val controllers_UserTenantListController_userTenantList341_invoker = createInvoker(
    UserTenantListController_53.userTenantList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "userTenantList",
      Nil,
      "GET",
      this.prefix + """userTenantList""",
      """user tenant""",
      Seq()
    )
  )

  // @LINE:456
  private[this] lazy val controllers_UserTenantListController_getListUserTenant342_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListUserTenant")))
  )
  private[this] lazy val controllers_UserTenantListController_getListUserTenant342_invoker = createInvoker(
    UserTenantListController_53.getListUserTenant(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "getListUserTenant",
      Nil,
      "POST",
      this.prefix + """getListUserTenant""",
      """""",
      Seq()
    )
  )

  // @LINE:457
  private[this] lazy val controllers_UserTenantListController_createUserTenant343_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserTenant")))
  )
  private[this] lazy val controllers_UserTenantListController_createUserTenant343_invoker = createInvoker(
    UserTenantListController_53.createUserTenant(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "createUserTenant",
      Nil,
      "POST",
      this.prefix + """createUserTenant""",
      """""",
      Seq()
    )
  )

  // @LINE:458
  private[this] lazy val controllers_UserTenantListController_delUserTenant344_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delUserTenant")))
  )
  private[this] lazy val controllers_UserTenantListController_delUserTenant344_invoker = createInvoker(
    UserTenantListController_53.delUserTenant(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "delUserTenant",
      Nil,
      "POST",
      this.prefix + """delUserTenant""",
      """""",
      Seq()
    )
  )

  // @LINE:459
  private[this] lazy val controllers_UserTenantListController_editUserTenant345_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editUserTenant")))
  )
  private[this] lazy val controllers_UserTenantListController_editUserTenant345_invoker = createInvoker(
    UserTenantListController_53.editUserTenant(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "editUserTenant",
      Nil,
      "POST",
      this.prefix + """editUserTenant""",
      """""",
      Seq()
    )
  )

  // @LINE:460
  private[this] lazy val controllers_UserTenantListController_getListRoleOfOrg346_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListRoleOfOrg")))
  )
  private[this] lazy val controllers_UserTenantListController_getListRoleOfOrg346_invoker = createInvoker(
    UserTenantListController_53.getListRoleOfOrg(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "getListRoleOfOrg",
      Nil,
      "POST",
      this.prefix + """getListRoleOfOrg""",
      """""",
      Seq()
    )
  )

  // @LINE:461
  private[this] lazy val controllers_UserTenantListController_updateRoleUserPermission347_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateRoleUserPermission")))
  )
  private[this] lazy val controllers_UserTenantListController_updateRoleUserPermission347_invoker = createInvoker(
    UserTenantListController_53.updateRoleUserPermission(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "updateRoleUserPermission",
      Nil,
      "POST",
      this.prefix + """updateRoleUserPermission""",
      """""",
      Seq()
    )
  )

  // @LINE:462
  private[this] lazy val controllers_UserTenantListController_delRoleUserPermission348_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delRoleUserPermission")))
  )
  private[this] lazy val controllers_UserTenantListController_delRoleUserPermission348_invoker = createInvoker(
    UserTenantListController_53.delRoleUserPermission(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTenantListController",
      "delRoleUserPermission",
      Nil,
      "POST",
      this.prefix + """delRoleUserPermission""",
      """""",
      Seq()
    )
  )

  // @LINE:465
  private[this] lazy val controllers_TelcoOrderController_orderSubs349_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/orderSubs/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoOrderController_orderSubs349_invoker = createInvoker(
    TelcoOrderController_44.orderSubs(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "orderSubs",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/orderSubs/""" + "$" + """userId<[^/]+>""",
      """TELCO""",
      Seq()
    )
  )

  // @LINE:466
  private[this] lazy val controllers_TelcoOrderController_getDataTelcoByUrl350_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataTelcoByUrl/"), DynamicPart("url", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoOrderController_getDataTelcoByUrl350_invoker = createInvoker(
    TelcoOrderController_44.getDataTelcoByUrl(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getDataTelcoByUrl",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getDataTelcoByUrl/""" + "$" + """url<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:467
  private[this] lazy val controllers_TelcoOrderController_checkValidateSerialSim351_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkValidateSerialSim")))
  )
  private[this] lazy val controllers_TelcoOrderController_checkValidateSerialSim351_invoker = createInvoker(
    TelcoOrderController_44.checkValidateSerialSim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "checkValidateSerialSim",
      Nil,
      "POST",
      this.prefix + """checkValidateSerialSim""",
      """""",
      Seq()
    )
  )

  // @LINE:468
  private[this] lazy val controllers_TelcoOrderController_getListReasonFull352_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListReasonFull")))
  )
  private[this] lazy val controllers_TelcoOrderController_getListReasonFull352_invoker = createInvoker(
    TelcoOrderController_44.getListReasonFull(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getListReasonFull",
      Nil,
      "POST",
      this.prefix + """getListReasonFull""",
      """""",
      Seq()
    )
  )

  // @LINE:469
  private[this] lazy val controllers_TelcoOrderController_getConnectSubscriberRamdom353_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getConnectSubscriberRamdom")))
  )
  private[this] lazy val controllers_TelcoOrderController_getConnectSubscriberRamdom353_invoker = createInvoker(
    TelcoOrderController_44.getConnectSubscriberRamdom(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getConnectSubscriberRamdom",
      Nil,
      "POST",
      this.prefix + """getConnectSubscriberRamdom""",
      """""",
      Seq()
    )
  )

  // @LINE:470
  private[this] lazy val controllers_TelcoOrderController_searchSubscriberByStock354_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchSubscriberByStock")))
  )
  private[this] lazy val controllers_TelcoOrderController_searchSubscriberByStock354_invoker = createInvoker(
    TelcoOrderController_44.searchSubscriberByStock(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "searchSubscriberByStock",
      Nil,
      "POST",
      this.prefix + """searchSubscriberByStock""",
      """""",
      Seq()
    )
  )

  // @LINE:471
  private[this] lazy val controllers_TelcoOrderController_blockIsdnVht355_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blockIsdnVht")))
  )
  private[this] lazy val controllers_TelcoOrderController_blockIsdnVht355_invoker = createInvoker(
    TelcoOrderController_44.blockIsdnVht(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "blockIsdnVht",
      Nil,
      "POST",
      this.prefix + """blockIsdnVht""",
      """""",
      Seq()
    )
  )

  // @LINE:472
  private[this] lazy val controllers_TelcoOrderController_unlockIsdnVht356_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("unlockIsdnVht")))
  )
  private[this] lazy val controllers_TelcoOrderController_unlockIsdnVht356_invoker = createInvoker(
    TelcoOrderController_44.unlockIsdnVht(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "unlockIsdnVht",
      Nil,
      "POST",
      this.prefix + """unlockIsdnVht""",
      """""",
      Seq()
    )
  )

  // @LINE:473
  private[this] lazy val controllers_TelcoOrderController_connectSubscriberSim357_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("connectSubscriberSim")))
  )
  private[this] lazy val controllers_TelcoOrderController_connectSubscriberSim357_invoker = createInvoker(
    TelcoOrderController_44.connectSubscriberSim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "connectSubscriberSim",
      Nil,
      "POST",
      this.prefix + """connectSubscriberSim""",
      """""",
      Seq()
    )
  )

  // @LINE:474
  private[this] lazy val controllers_TelcoOrderController_getListProductOffer358_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListProductOffer")))
  )
  private[this] lazy val controllers_TelcoOrderController_getListProductOffer358_invoker = createInvoker(
    TelcoOrderController_44.getListProductOffer(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getListProductOffer",
      Nil,
      "POST",
      this.prefix + """getListProductOffer""",
      """""",
      Seq()
    )
  )

  // @LINE:475
  private[this] lazy val controllers_TelcoOrderController_getListSaleService359_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSaleService")))
  )
  private[this] lazy val controllers_TelcoOrderController_getListSaleService359_invoker = createInvoker(
    TelcoOrderController_44.getListSaleService(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getListSaleService",
      Nil,
      "POST",
      this.prefix + """getListSaleService""",
      """""",
      Seq()
    )
  )

  // @LINE:476
  private[this] lazy val controllers_TelcoOrderController_getListSaleService1360_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSaleService1")))
  )
  private[this] lazy val controllers_TelcoOrderController_getListSaleService1360_invoker = createInvoker(
    TelcoOrderController_44.getListSaleService1(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getListSaleService1",
      Nil,
      "POST",
      this.prefix + """getListSaleService1""",
      """""",
      Seq()
    )
  )

  // @LINE:477
  private[this] lazy val controllers_TelcoOrderController_processOrderBuySim361_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("processOrderBuySim")))
  )
  private[this] lazy val controllers_TelcoOrderController_processOrderBuySim361_invoker = createInvoker(
    TelcoOrderController_44.processOrderBuySim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "processOrderBuySim",
      Nil,
      "POST",
      this.prefix + """processOrderBuySim""",
      """""",
      Seq()
    )
  )

  // @LINE:479
  private[this] lazy val controllers_TelcoAPNController_APNview362_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apn/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoAPNController_APNview362_invoker = createInvoker(
    TelcoAPNController_1.APNview(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAPNController",
      "APNview",
      Seq(classOf[String]),
      "GET",
      this.prefix + """apn/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:480
  private[this] lazy val controllers_TelcoAPNController_getIpAllow363_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apn/getIpAllow/"), DynamicPart("isdn", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoAPNController_getIpAllow363_invoker = createInvoker(
    TelcoAPNController_1.getIpAllow(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAPNController",
      "getIpAllow",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """apn/getIpAllow/""" + "$" + """isdn<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:481
  private[this] lazy val controllers_TelcoAPNController_getAPNByPhone364_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apn/getAPNByPhone")))
  )
  private[this] lazy val controllers_TelcoAPNController_getAPNByPhone364_invoker = createInvoker(
    TelcoAPNController_1.getAPNByPhone(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAPNController",
      "getAPNByPhone",
      Nil,
      "POST",
      this.prefix + """apn/getAPNByPhone""",
      """""",
      Seq()
    )
  )

  // @LINE:482
  private[this] lazy val controllers_TelcoAPNController_registerAPN365_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apn/registerAPN")))
  )
  private[this] lazy val controllers_TelcoAPNController_registerAPN365_invoker = createInvoker(
    TelcoAPNController_1.registerAPN(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAPNController",
      "registerAPN",
      Nil,
      "POST",
      this.prefix + """apn/registerAPN""",
      """""",
      Seq()
    )
  )

  // @LINE:483
  private[this] lazy val controllers_TelcoAPNController_unRegisterAPN366_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apn/unRegisterAPN")))
  )
  private[this] lazy val controllers_TelcoAPNController_unRegisterAPN366_invoker = createInvoker(
    TelcoAPNController_1.unRegisterAPN(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAPNController",
      "unRegisterAPN",
      Nil,
      "POST",
      this.prefix + """apn/unRegisterAPN""",
      """""",
      Seq()
    )
  )

  // @LINE:485
  private[this] lazy val controllers_TelcoOrderController_buySim367_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/buySim/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoOrderController_buySim367_invoker = createInvoker(
    TelcoOrderController_44.buySim(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "buySim",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/buySim/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:486
  private[this] lazy val controllers_TelcoOrderController_manageOrder368_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/manageOrder/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoOrderController_manageOrder368_invoker = createInvoker(
    TelcoOrderController_44.manageOrder(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "manageOrder",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/manageOrder/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:487
  private[this] lazy val controllers_TelcoOrderController_getListOrderBuySim369_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListOrderBuySim")))
  )
  private[this] lazy val controllers_TelcoOrderController_getListOrderBuySim369_invoker = createInvoker(
    TelcoOrderController_44.getListOrderBuySim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getListOrderBuySim",
      Nil,
      "POST",
      this.prefix + """getListOrderBuySim""",
      """""",
      Seq()
    )
  )

  // @LINE:488
  private[this] lazy val controllers_TelcoOrderController_upfilePycTelco370_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upfilePycTelco")))
  )
  private[this] lazy val controllers_TelcoOrderController_upfilePycTelco370_invoker = createInvoker(
    TelcoOrderController_44.upfilePycTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "upfilePycTelco",
      Nil,
      "POST",
      this.prefix + """upfilePycTelco""",
      """""",
      Seq()
    )
  )

  // @LINE:489
  private[this] lazy val controllers_TelcoOrderController_getCustomerType371_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCustomerType")))
  )
  private[this] lazy val controllers_TelcoOrderController_getCustomerType371_invoker = createInvoker(
    TelcoOrderController_44.getCustomerType(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getCustomerType",
      Nil,
      "POST",
      this.prefix + """getCustomerType""",
      """""",
      Seq()
    )
  )

  // @LINE:490
  private[this] lazy val controllers_TelcoOrderController_getListCt372_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListCt")))
  )
  private[this] lazy val controllers_TelcoOrderController_getListCt372_invoker = createInvoker(
    TelcoOrderController_44.getListCt(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoOrderController",
      "getListCt",
      Nil,
      "POST",
      this.prefix + """getListCt""",
      """""",
      Seq()
    )
  )

  // @LINE:492
  private[this] lazy val controllers_TelcoLogController_logConnectSim373_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logConnectSim/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoLogController_logConnectSim373_invoker = createInvoker(
    TelcoLogController_73.logConnectSim(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "logConnectSim",
      Seq(classOf[String]),
      "GET",
      this.prefix + """logConnectSim/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:493
  private[this] lazy val controllers_TelcoLogController_getLogConnectSim374_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLogConnectSim")))
  )
  private[this] lazy val controllers_TelcoLogController_getLogConnectSim374_invoker = createInvoker(
    TelcoLogController_73.getLogConnectSim(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "getLogConnectSim",
      Nil,
      "POST",
      this.prefix + """getLogConnectSim""",
      """""",
      Seq()
    )
  )

  // @LINE:495
  private[this] lazy val controllers_TelcoDashboardController_telcoDashboard375_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/dashboard/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoDashboardController_telcoDashboard375_invoker = createInvoker(
    TelcoDashboardController_55.telcoDashboard(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "telcoDashboard",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/dashboard/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:496
  private[this] lazy val controllers_TelcoDashboardController_getDataDashboardTelco376_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataDashboardTelco")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDataDashboardTelco376_invoker = createInvoker(
    TelcoDashboardController_55.getDataDashboardTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDataDashboardTelco",
      Nil,
      "POST",
      this.prefix + """getDataDashboardTelco""",
      """""",
      Seq()
    )
  )

  // @LINE:497
  private[this] lazy val controllers_TelcoDashboardController_getDataDashboardWithMonth377_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataDashboardWithMonth")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDataDashboardWithMonth377_invoker = createInvoker(
    TelcoDashboardController_55.getDataDashboardWithMonth(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDataDashboardWithMonth",
      Nil,
      "POST",
      this.prefix + """getDataDashboardWithMonth""",
      """""",
      Seq()
    )
  )

  // @LINE:498
  private[this] lazy val controllers_TelcoDashboardController_getTop5DataUsersOfMonth378_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTop5DataUsersOfMonth")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getTop5DataUsersOfMonth378_invoker = createInvoker(
    TelcoDashboardController_55.getTop5DataUsersOfMonth(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getTop5DataUsersOfMonth",
      Nil,
      "POST",
      this.prefix + """getTop5DataUsersOfMonth""",
      """""",
      Seq()
    )
  )

  // @LINE:499
  private[this] lazy val controllers_TelcoDashboardController_getAlertDashboard379_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAlertDashboard")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getAlertDashboard379_invoker = createInvoker(
    TelcoDashboardController_55.getAlertDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getAlertDashboard",
      Nil,
      "POST",
      this.prefix + """getAlertDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:500
  private[this] lazy val controllers_TelcoDashboardController_getDetailAlertDashboard380_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailAlertDashboard")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDetailAlertDashboard380_invoker = createInvoker(
    TelcoDashboardController_55.getDetailAlertDashboard(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDetailAlertDashboard",
      Nil,
      "POST",
      this.prefix + """getDetailAlertDashboard""",
      """""",
      Seq()
    )
  )

  // @LINE:501
  private[this] lazy val controllers_TelcoDashboardController_getSubscriberStatistics381_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getSubscriberStatistics")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getSubscriberStatistics381_invoker = createInvoker(
    TelcoDashboardController_55.getSubscriberStatistics(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getSubscriberStatistics",
      Nil,
      "POST",
      this.prefix + """getSubscriberStatistics""",
      """""",
      Seq()
    )
  )

  // @LINE:502
  private[this] lazy val controllers_TelcoDashboardController_getBalanceDashboardTelco382_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBalanceDashboardTelco")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getBalanceDashboardTelco382_invoker = createInvoker(
    TelcoDashboardController_55.getBalanceDashboardTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getBalanceDashboardTelco",
      Nil,
      "POST",
      this.prefix + """getBalanceDashboardTelco""",
      """""",
      Seq()
    )
  )

  // @LINE:503
  private[this] lazy val controllers_TelcoDashboardController_getListSubsDashboardByKey383_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSubsDashboardByKey")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getListSubsDashboardByKey383_invoker = createInvoker(
    TelcoDashboardController_55.getListSubsDashboardByKey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getListSubsDashboardByKey",
      Nil,
      "POST",
      this.prefix + """getListSubsDashboardByKey""",
      """""",
      Seq()
    )
  )

  // @LINE:504
  private[this] lazy val controllers_TelcoDashboardController_getListSubsDashboardBlockDebit384_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSubsDashboardBlockDebit")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getListSubsDashboardBlockDebit384_invoker = createInvoker(
    TelcoDashboardController_55.getListSubsDashboardBlockDebit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getListSubsDashboardBlockDebit",
      Nil,
      "POST",
      this.prefix + """getListSubsDashboardBlockDebit""",
      """""",
      Seq()
    )
  )

  // @LINE:505
  private[this] lazy val controllers_TelcoDashboardController_getDetailRedAlert385_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailRedAlert")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDetailRedAlert385_invoker = createInvoker(
    TelcoDashboardController_55.getDetailRedAlert(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDetailRedAlert",
      Nil,
      "POST",
      this.prefix + """getDetailRedAlert""",
      """""",
      Seq()
    )
  )

  // @LINE:506
  private[this] lazy val controllers_TelcoDashboardController_getDetailPrepaidExpired386_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailPrepaidExpired")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDetailPrepaidExpired386_invoker = createInvoker(
    TelcoDashboardController_55.getDetailPrepaidExpired(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDetailPrepaidExpired",
      Nil,
      "POST",
      this.prefix + """getDetailPrepaidExpired""",
      """""",
      Seq()
    )
  )

  // @LINE:507
  private[this] lazy val controllers_TelcoDashboardController_getDetailLowRemainingData387_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailLowRemainingData")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDetailLowRemainingData387_invoker = createInvoker(
    TelcoDashboardController_55.getDetailLowRemainingData(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDetailLowRemainingData",
      Nil,
      "POST",
      this.prefix + """getDetailLowRemainingData""",
      """""",
      Seq()
    )
  )

  // @LINE:508
  private[this] lazy val controllers_TelcoDashboardController_getDetailPackageExpired388_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailPackageExpired")))
  )
  private[this] lazy val controllers_TelcoDashboardController_getDetailPackageExpired388_invoker = createInvoker(
    TelcoDashboardController_55.getDetailPackageExpired(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoDashboardController",
      "getDetailPackageExpired",
      Nil,
      "POST",
      this.prefix + """getDetailPackageExpired""",
      """""",
      Seq()
    )
  )

  // @LINE:510
  private[this] lazy val controllers_TelcoAccountController_accountInfo389_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/accountInfo/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoAccountController_accountInfo389_invoker = createInvoker(
    TelcoAccountController_3.accountInfo(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "accountInfo",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/accountInfo/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:511
  private[this] lazy val controllers_TelcoAccountController_updateDetailAccountTelco390_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateAccountInfo")))
  )
  private[this] lazy val controllers_TelcoAccountController_updateDetailAccountTelco390_invoker = createInvoker(
    TelcoAccountController_3.updateDetailAccountTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "updateDetailAccountTelco",
      Nil,
      "POST",
      this.prefix + """updateAccountInfo""",
      """""",
      Seq()
    )
  )

  // @LINE:512
  private[this] lazy val controllers_TelcoAccountController_updateInfoCompanyTelco391_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateInfoCompanyTelco")))
  )
  private[this] lazy val controllers_TelcoAccountController_updateInfoCompanyTelco391_invoker = createInvoker(
    TelcoAccountController_3.updateInfoCompanyTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "updateInfoCompanyTelco",
      Nil,
      "POST",
      this.prefix + """updateInfoCompanyTelco""",
      """""",
      Seq()
    )
  )

  // @LINE:513
  private[this] lazy val controllers_TelcoAccountController_deleteInfoCompany392_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteInfoCompany")))
  )
  private[this] lazy val controllers_TelcoAccountController_deleteInfoCompany392_invoker = createInvoker(
    TelcoAccountController_3.deleteInfoCompany(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "deleteInfoCompany",
      Nil,
      "POST",
      this.prefix + """deleteInfoCompany""",
      """""",
      Seq()
    )
  )

  // @LINE:514
  private[this] lazy val controllers_TelcoAccountController_getInfoAccount393_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoAccount")))
  )
  private[this] lazy val controllers_TelcoAccountController_getInfoAccount393_invoker = createInvoker(
    TelcoAccountController_3.getInfoAccount(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "getInfoAccount",
      Nil,
      "POST",
      this.prefix + """getInfoAccount""",
      """""",
      Seq()
    )
  )

  // @LINE:515
  private[this] lazy val controllers_TelcoAccountController_getInfoCompany394_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoCompany")))
  )
  private[this] lazy val controllers_TelcoAccountController_getInfoCompany394_invoker = createInvoker(
    TelcoAccountController_3.getInfoCompany(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "getInfoCompany",
      Nil,
      "POST",
      this.prefix + """getInfoCompany""",
      """""",
      Seq()
    )
  )

  // @LINE:516
  private[this] lazy val controllers_TelcoAccountController_getInfoCompanyEnterpriseLv2395_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoCompanyEnterprise")))
  )
  private[this] lazy val controllers_TelcoAccountController_getInfoCompanyEnterpriseLv2395_invoker = createInvoker(
    TelcoAccountController_3.getInfoCompanyEnterpriseLv2(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "getInfoCompanyEnterpriseLv2",
      Nil,
      "POST",
      this.prefix + """getInfoCompanyEnterprise""",
      """""",
      Seq()
    )
  )

  // @LINE:517
  private[this] lazy val controllers_TelcoAccountController_getListArea396_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListArea")))
  )
  private[this] lazy val controllers_TelcoAccountController_getListArea396_invoker = createInvoker(
    TelcoAccountController_3.getListArea(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "getListArea",
      Nil,
      "POST",
      this.prefix + """getListArea""",
      """""",
      Seq()
    )
  )

  // @LINE:518
  private[this] lazy val controllers_TelcoAccountController_getInfoGpkdApproved397_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoGpkdApproved")))
  )
  private[this] lazy val controllers_TelcoAccountController_getInfoGpkdApproved397_invoker = createInvoker(
    TelcoAccountController_3.getInfoGpkdApproved(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "getInfoGpkdApproved",
      Nil,
      "GET",
      this.prefix + """getInfoGpkdApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:519
  private[this] lazy val controllers_TelcoAccountController_getCategoryBusinessAndDevice398_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCategoryBusinessAndDevice")))
  )
  private[this] lazy val controllers_TelcoAccountController_getCategoryBusinessAndDevice398_invoker = createInvoker(
    TelcoAccountController_3.getCategoryBusinessAndDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "getCategoryBusinessAndDevice",
      Nil,
      "GET",
      this.prefix + """getCategoryBusinessAndDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:520
  private[this] lazy val controllers_TelcoAccountController_updateCategoryBusinessAndDevice399_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateCategoryBusinessAndDevice")))
  )
  private[this] lazy val controllers_TelcoAccountController_updateCategoryBusinessAndDevice399_invoker = createInvoker(
    TelcoAccountController_3.updateCategoryBusinessAndDevice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAccountController",
      "updateCategoryBusinessAndDevice",
      Nil,
      "POST",
      this.prefix + """updateCategoryBusinessAndDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:521
  private[this] lazy val controllers_OrderSearchController_getSearchOrder400_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getSearchOrder/"), DynamicPart("orderId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderSearchController_getSearchOrder400_invoker = createInvoker(
    OrderSearchController_57.getSearchOrder(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderSearchController",
      "getSearchOrder",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getSearchOrder/""" + "$" + """orderId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:524
  private[this] lazy val controllers_AdminTelcoController_approvedInfoCompanyTelco401_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("approvedInfoCompanyTelco")))
  )
  private[this] lazy val controllers_AdminTelcoController_approvedInfoCompanyTelco401_invoker = createInvoker(
    AdminTelcoController_34.approvedInfoCompanyTelco(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminTelcoController",
      "approvedInfoCompanyTelco",
      Nil,
      "GET",
      this.prefix + """approvedInfoCompanyTelco""",
      """admin telco""",
      Seq()
    )
  )

  // @LINE:525
  private[this] lazy val controllers_AdminTelcoController_getListInfoApproved402_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListInfoApproved")))
  )
  private[this] lazy val controllers_AdminTelcoController_getListInfoApproved402_invoker = createInvoker(
    AdminTelcoController_34.getListInfoApproved(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminTelcoController",
      "getListInfoApproved",
      Nil,
      "POST",
      this.prefix + """getListInfoApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:526
  private[this] lazy val controllers_AdminTelcoController_processComfirmInfoAccountCmp403_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("processComfirmInfoAccountCmp")))
  )
  private[this] lazy val controllers_AdminTelcoController_processComfirmInfoAccountCmp403_invoker = createInvoker(
    AdminTelcoController_34.processComfirmInfoAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminTelcoController",
      "processComfirmInfoAccountCmp",
      Nil,
      "POST",
      this.prefix + """processComfirmInfoAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:527
  private[this] lazy val controllers_AdminTelcoController_processComfirmInfoCompany404_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("processComfirmInfoCompany")))
  )
  private[this] lazy val controllers_AdminTelcoController_processComfirmInfoCompany404_invoker = createInvoker(
    AdminTelcoController_34.processComfirmInfoCompany(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminTelcoController",
      "processComfirmInfoCompany",
      Nil,
      "POST",
      this.prefix + """processComfirmInfoCompany""",
      """""",
      Seq()
    )
  )

  // @LINE:528
  private[this] lazy val controllers_AdminTelcoController_getListEnterpriseByBrowser405_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListEnterpriseByBrowser")))
  )
  private[this] lazy val controllers_AdminTelcoController_getListEnterpriseByBrowser405_invoker = createInvoker(
    AdminTelcoController_34.getListEnterpriseByBrowser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminTelcoController",
      "getListEnterpriseByBrowser",
      Nil,
      "POST",
      this.prefix + """getListEnterpriseByBrowser""",
      """""",
      Seq()
    )
  )

  // @LINE:529
  private[this] lazy val controllers_AdminTelcoController_getListEnterpriseSubmitOfAdminSpe406_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListEnterpriseSubmitOfAdminSpe")))
  )
  private[this] lazy val controllers_AdminTelcoController_getListEnterpriseSubmitOfAdminSpe406_invoker = createInvoker(
    AdminTelcoController_34.getListEnterpriseSubmitOfAdminSpe(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminTelcoController",
      "getListEnterpriseSubmitOfAdminSpe",
      Nil,
      "POST",
      this.prefix + """getListEnterpriseSubmitOfAdminSpe""",
      """""",
      Seq()
    )
  )

  // @LINE:531
  private[this] lazy val controllers_TelcoSubscriberController_subscriberManage407_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/subscriberManage/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoSubscriberController_subscriberManage407_invoker = createInvoker(
    TelcoSubscriberController_12.subscriberManage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "subscriberManage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/subscriberManage/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:532
  private[this] lazy val controllers_TelcoSubscriberController_getListSubscriber408_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSubscriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getListSubscriber408_invoker = createInvoker(
    TelcoSubscriberController_12.getListSubscriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getListSubscriber",
      Nil,
      "POST",
      this.prefix + """getListSubscriber""",
      """""",
      Seq()
    )
  )

  // @LINE:533
  private[this] lazy val controllers_TelcoSubscriberController_getListSubsByBeVht409_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSubsByBeVht")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getListSubsByBeVht409_invoker = createInvoker(
    TelcoSubscriberController_12.getListSubsByBeVht(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getListSubsByBeVht",
      Nil,
      "POST",
      this.prefix + """getListSubsByBeVht""",
      """""",
      Seq()
    )
  )

  // @LINE:534
  private[this] lazy val controllers_TelcoSubscriberController_getDetailSubscriber410_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDetailSubscriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getDetailSubscriber410_invoker = createInvoker(
    TelcoSubscriberController_12.getDetailSubscriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getDetailSubscriber",
      Nil,
      "POST",
      this.prefix + """getDetailSubscriber""",
      """""",
      Seq()
    )
  )

  // @LINE:535
  private[this] lazy val controllers_TelcoSubscriberController_subscriberDetail411_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriberDetail/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("subs", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoSubscriberController_subscriberDetail411_invoker = createInvoker(
    TelcoSubscriberController_12.subscriberDetail(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "subscriberDetail",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """subscriberDetail/""" + "$" + """id<[^/]+>/""" + "$" + """subs<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:536
  private[this] lazy val controllers_TelcoSubscriberController_getListProductOffering412_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListProductOffering")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getListProductOffering412_invoker = createInvoker(
    TelcoSubscriberController_12.getListProductOffering(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getListProductOffering",
      Nil,
      "POST",
      this.prefix + """getListProductOffering""",
      """""",
      Seq()
    )
  )

  // @LINE:537
  private[this] lazy val controllers_TelcoSubscriberController_getInfoDataAccount413_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoDataAccount")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getInfoDataAccount413_invoker = createInvoker(
    TelcoSubscriberController_12.getInfoDataAccount(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getInfoDataAccount",
      Nil,
      "POST",
      this.prefix + """getInfoDataAccount""",
      """""",
      Seq()
    )
  )

  // @LINE:538
  private[this] lazy val controllers_TelcoSubscriberController_getTotalSubscriber414_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTotalSubscriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getTotalSubscriber414_invoker = createInvoker(
    TelcoSubscriberController_12.getTotalSubscriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getTotalSubscriber",
      Nil,
      "POST",
      this.prefix + """getTotalSubscriber""",
      """""",
      Seq()
    )
  )

  // @LINE:539
  private[this] lazy val controllers_TelcoSubscriberController_getHybridInfo415_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHybridInfo")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getHybridInfo415_invoker = createInvoker(
    TelcoSubscriberController_12.getHybridInfo(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getHybridInfo",
      Nil,
      "POST",
      this.prefix + """getHybridInfo""",
      """""",
      Seq()
    )
  )

  // @LINE:540
  private[this] lazy val controllers_TelcoSubscriberController_getCtkm416_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCtkm")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getCtkm416_invoker = createInvoker(
    TelcoSubscriberController_12.getCtkm(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getCtkm",
      Nil,
      "POST",
      this.prefix + """getCtkm""",
      """""",
      Seq()
    )
  )

  // @LINE:541
  private[this] lazy val controllers_TelcoSubscriberController_getBalanceInfo417_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBalanceInfo")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getBalanceInfo417_invoker = createInvoker(
    TelcoSubscriberController_12.getBalanceInfo(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getBalanceInfo",
      Nil,
      "POST",
      this.prefix + """getBalanceInfo""",
      """""",
      Seq()
    )
  )

  // @LINE:542
  private[this] lazy val controllers_TelcoSubscriberController_getDebitSubscriber418_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDebitSubscriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getDebitSubscriber418_invoker = createInvoker(
    TelcoSubscriberController_12.getDebitSubscriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getDebitSubscriber",
      Nil,
      "POST",
      this.prefix + """getDebitSubscriber""",
      """""",
      Seq()
    )
  )

  // @LINE:543
  private[this] lazy val controllers_TelcoSubscriberController_getKttkAndKtmi419_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getKttkAndKtmi")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_getKttkAndKtmi419_invoker = createInvoker(
    TelcoSubscriberController_12.getKttkAndKtmi(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "getKttkAndKtmi",
      Nil,
      "POST",
      this.prefix + """getKttkAndKtmi""",
      """""",
      Seq()
    )
  )

  // @LINE:544
  private[this] lazy val controllers_TelcoSubscriberController_blockSubcriber420_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blockSubcriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_blockSubcriber420_invoker = createInvoker(
    TelcoSubscriberController_12.blockSubcriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "blockSubcriber",
      Nil,
      "POST",
      this.prefix + """blockSubcriber""",
      """""",
      Seq()
    )
  )

  // @LINE:545
  private[this] lazy val controllers_TelcoSubscriberController_openSubcriber421_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("openSubcriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_openSubcriber421_invoker = createInvoker(
    TelcoSubscriberController_12.openSubcriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "openSubcriber",
      Nil,
      "POST",
      this.prefix + """openSubcriber""",
      """""",
      Seq()
    )
  )

  // @LINE:546
  private[this] lazy val controllers_TelcoSubscriberController_open2wSubcriber422_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("open2wSubcriber")))
  )
  private[this] lazy val controllers_TelcoSubscriberController_open2wSubcriber422_invoker = createInvoker(
    TelcoSubscriberController_12.open2wSubcriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoSubscriberController",
      "open2wSubcriber",
      Nil,
      "POST",
      this.prefix + """open2wSubcriber""",
      """""",
      Seq()
    )
  )

  // @LINE:548
  private[this] lazy val controllers_TelcoContractController_contractManage423_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/contractManage/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoContractController_contractManage423_invoker = createInvoker(
    TelcoContractController_17.contractManage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoContractController",
      "contractManage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/contractManage/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:549
  private[this] lazy val controllers_TelcoContractController_getListAccountContract424_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListAccountContract")))
  )
  private[this] lazy val controllers_TelcoContractController_getListAccountContract424_invoker = createInvoker(
    TelcoContractController_17.getListAccountContract(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoContractController",
      "getListAccountContract",
      Nil,
      "POST",
      this.prefix + """getListAccountContract""",
      """""",
      Seq()
    )
  )

  // @LINE:550
  private[this] lazy val controllers_TelcoContractController_getDebitContract425_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDebitContract")))
  )
  private[this] lazy val controllers_TelcoContractController_getDebitContract425_invoker = createInvoker(
    TelcoContractController_17.getDebitContract(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoContractController",
      "getDebitContract",
      Nil,
      "POST",
      this.prefix + """getDebitContract""",
      """""",
      Seq()
    )
  )

  // @LINE:551
  private[this] lazy val controllers_TelcoContractController_getTotalAccount426_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTotalAccount")))
  )
  private[this] lazy val controllers_TelcoContractController_getTotalAccount426_invoker = createInvoker(
    TelcoContractController_17.getTotalAccount(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoContractController",
      "getTotalAccount",
      Nil,
      "POST",
      this.prefix + """getTotalAccount""",
      """""",
      Seq()
    )
  )

  // @LINE:552
  private[this] lazy val controllers_TelcoContractController_getListContractByIdNo427_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListContractByIdNo")))
  )
  private[this] lazy val controllers_TelcoContractController_getListContractByIdNo427_invoker = createInvoker(
    TelcoContractController_17.getListContractByIdNo(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoContractController",
      "getListContractByIdNo",
      Nil,
      "POST",
      this.prefix + """getListContractByIdNo""",
      """""",
      Seq()
    )
  )

  // @LINE:554
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesManage428_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/utilitiesManage/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesManage428_invoker = createInvoker(
    TelcoUtilitiesController_56.utilitiesManage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "utilitiesManage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/utilitiesManage/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:555
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesTopup429_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/utilitiesTopup/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesTopup429_invoker = createInvoker(
    TelcoUtilitiesController_56.utilitiesTopup(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "utilitiesTopup",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/utilitiesTopup/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:556
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesBlock430_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/utilitiesBlock/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesBlock430_invoker = createInvoker(
    TelcoUtilitiesController_56.utilitiesBlock(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "utilitiesBlock",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/utilitiesBlock/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:557
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesBuyPackage431_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/utilitiesBuyPackage/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_utilitiesBuyPackage431_invoker = createInvoker(
    TelcoUtilitiesController_56.utilitiesBuyPackage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "utilitiesBuyPackage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/utilitiesBuyPackage/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:558
  private[this] lazy val controllers_TelcoUtilitiesController_getListPackMiAndAddOn432_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListPackMiAndAddOn")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getListPackMiAndAddOn432_invoker = createInvoker(
    TelcoUtilitiesController_56.getListPackMiAndAddOn(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getListPackMiAndAddOn",
      Nil,
      "POST",
      this.prefix + """getListPackMiAndAddOn""",
      """""",
      Seq()
    )
  )

  // @LINE:559
  private[this] lazy val controllers_TelcoUtilitiesController_registerMiAddon433_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registerMiAddon")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_registerMiAddon433_invoker = createInvoker(
    TelcoUtilitiesController_56.registerMiAddon(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "registerMiAddon",
      Nil,
      "POST",
      this.prefix + """registerMiAddon""",
      """""",
      Seq()
    )
  )

  // @LINE:560
  private[this] lazy val controllers_TelcoUtilitiesController_unregisterMiAddon434_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("unregisterMiAddon")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_unregisterMiAddon434_invoker = createInvoker(
    TelcoUtilitiesController_56.unregisterMiAddon(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "unregisterMiAddon",
      Nil,
      "POST",
      this.prefix + """unregisterMiAddon""",
      """""",
      Seq()
    )
  )

  // @LINE:561
  private[this] lazy val controllers_TelcoUtilitiesController_unextendMiAddon435_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("unextendMiAddon")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_unextendMiAddon435_invoker = createInvoker(
    TelcoUtilitiesController_56.unextendMiAddon(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "unextendMiAddon",
      Nil,
      "POST",
      this.prefix + """unextendMiAddon""",
      """""",
      Seq()
    )
  )

  // @LINE:562
  private[this] lazy val controllers_TelcoUtilitiesController_getInfoOrderId436_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoOrderId")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getInfoOrderId436_invoker = createInvoker(
    TelcoUtilitiesController_56.getInfoOrderId(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getInfoOrderId",
      Nil,
      "POST",
      this.prefix + """getInfoOrderId""",
      """""",
      Seq()
    )
  )

  // @LINE:563
  private[this] lazy val controllers_TelcoUtilitiesController_rechargeSubcriber437_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rechargeSubcriber")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_rechargeSubcriber437_invoker = createInvoker(
    TelcoUtilitiesController_56.rechargeSubcriber(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "rechargeSubcriber",
      Nil,
      "POST",
      this.prefix + """rechargeSubcriber""",
      """""",
      Seq()
    )
  )

  // @LINE:564
  private[this] lazy val controllers_TelcoUtilitiesController_getListOrderIdByAction438_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListOrderIdByAction")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getListOrderIdByAction438_invoker = createInvoker(
    TelcoUtilitiesController_56.getListOrderIdByAction(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getListOrderIdByAction",
      Nil,
      "POST",
      this.prefix + """getListOrderIdByAction""",
      """""",
      Seq()
    )
  )

  // @LINE:565
  private[this] lazy val controllers_TelcoUtilitiesController_getHistoryBlockUnblock439_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryBlockUnblock")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getHistoryBlockUnblock439_invoker = createInvoker(
    TelcoUtilitiesController_56.getHistoryBlockUnblock(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getHistoryBlockUnblock",
      Nil,
      "POST",
      this.prefix + """getHistoryBlockUnblock""",
      """""",
      Seq()
    )
  )

  // @LINE:566
  private[this] lazy val controllers_TelcoUtilitiesController_validateSubs440_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateSubs")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_validateSubs440_invoker = createInvoker(
    TelcoUtilitiesController_56.validateSubs(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "validateSubs",
      Nil,
      "POST",
      this.prefix + """validateSubs""",
      """""",
      Seq()
    )
  )

  // @LINE:567
  private[this] lazy val controllers_TelcoUtilitiesController_prepayCharges441_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("prepayCharges")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_prepayCharges441_invoker = createInvoker(
    TelcoUtilitiesController_56.prepayCharges(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "prepayCharges",
      Seq(classOf[String]),
      "GET",
      this.prefix + """prepayCharges""",
      """""",
      Seq()
    )
  )

  // @LINE:568
  private[this] lazy val controllers_TelcoUtilitiesController_prepayChargesBill442_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("prepayCharges/bill/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/"), DynamicPart("isdn", """[^/]+""",true), StaticPart("/"), DynamicPart("orderId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_prepayChargesBill442_invoker = createInvoker(
    TelcoUtilitiesController_56.prepayChargesBill(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "prepayChargesBill",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """prepayCharges/bill/""" + "$" + """userId<[^/]+>/""" + "$" + """isdn<[^/]+>/""" + "$" + """orderId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:569
  private[this] lazy val controllers_TelcoUtilitiesController_getDataPrepaidInfo443_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDataPrepaidInfo")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getDataPrepaidInfo443_invoker = createInvoker(
    TelcoUtilitiesController_56.getDataPrepaidInfo(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getDataPrepaidInfo",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """getDataPrepaidInfo""",
      """""",
      Seq()
    )
  )

  // @LINE:570
  private[this] lazy val controllers_TelcoUtilitiesController_rechargePrepaid444_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rechargePrepaid")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_rechargePrepaid444_invoker = createInvoker(
    TelcoUtilitiesController_56.rechargePrepaid(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "rechargePrepaid",
      Nil,
      "POST",
      this.prefix + """rechargePrepaid""",
      """""",
      Seq()
    )
  )

  // @LINE:571
  private[this] lazy val controllers_TelcoUtilitiesController_getHistoryPrepayCharges445_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryPrepayCharges")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getHistoryPrepayCharges445_invoker = createInvoker(
    TelcoUtilitiesController_56.getHistoryPrepayCharges(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getHistoryPrepayCharges",
      Nil,
      "POST",
      this.prefix + """getHistoryPrepayCharges""",
      """""",
      Seq()
    )
  )

  // @LINE:572
  private[this] lazy val controllers_TelcoUtilitiesController_payPostpaidBill446_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/payPostpaidBill/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_payPostpaidBill446_invoker = createInvoker(
    TelcoUtilitiesController_56.payPostpaidBill(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "payPostpaidBill",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/payPostpaidBill/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:573
  private[this] lazy val controllers_TelcoUtilitiesController_payDebit447_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payDebit")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_payDebit447_invoker = createInvoker(
    TelcoUtilitiesController_56.payDebit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "payDebit",
      Nil,
      "POST",
      this.prefix + """payDebit""",
      """""",
      Seq()
    )
  )

  // @LINE:574
  private[this] lazy val controllers_TelcoUtilitiesController_payPostpaidBillDetail448_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/payPostpaidBill/detail/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/"), DynamicPart("orderId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_payPostpaidBillDetail448_invoker = createInvoker(
    TelcoUtilitiesController_56.payPostpaidBillDetail(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "payPostpaidBillDetail",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """telco/payPostpaidBill/detail/""" + "$" + """userId<[^/]+>/""" + "$" + """orderId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:575
  private[this] lazy val controllers_TelcoUtilitiesController_getHistoryPayPostBill449_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryPayPostBill")))
  )
  private[this] lazy val controllers_TelcoUtilitiesController_getHistoryPayPostBill449_invoker = createInvoker(
    TelcoUtilitiesController_56.getHistoryPayPostBill(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoUtilitiesController",
      "getHistoryPayPostBill",
      Nil,
      "POST",
      this.prefix + """getHistoryPayPostBill""",
      """""",
      Seq()
    )
  )

  // @LINE:577
  private[this] lazy val controllers_TelcoInvoiceController_invoiceOfContract450_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("invoiceOfContract/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/"), DynamicPart("invoice", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoInvoiceController_invoiceOfContract450_invoker = createInvoker(
    TelcoInvoiceController_79.invoiceOfContract(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoInvoiceController",
      "invoiceOfContract",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """invoiceOfContract/""" + "$" + """userId<[^/]+>/""" + "$" + """invoice<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:578
  private[this] lazy val controllers_TelcoInvoiceController_getListInvoiceOfContract451_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListInvoiceOfContract")))
  )
  private[this] lazy val controllers_TelcoInvoiceController_getListInvoiceOfContract451_invoker = createInvoker(
    TelcoInvoiceController_79.getListInvoiceOfContract(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoInvoiceController",
      "getListInvoiceOfContract",
      Nil,
      "POST",
      this.prefix + """getListInvoiceOfContract""",
      """""",
      Seq()
    )
  )

  // @LINE:579
  private[this] lazy val controllers_TelcoInvoiceController_getLinkDownloadInvoice452_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLinkDownloadInvoice")))
  )
  private[this] lazy val controllers_TelcoInvoiceController_getLinkDownloadInvoice452_invoker = createInvoker(
    TelcoInvoiceController_79.getLinkDownloadInvoice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoInvoiceController",
      "getLinkDownloadInvoice",
      Nil,
      "POST",
      this.prefix + """getLinkDownloadInvoice""",
      """""",
      Seq()
    )
  )

  // @LINE:582
  private[this] lazy val controllers_TelcoApiKeyController_apiKeyManage453_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/apiKey/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoApiKeyController_apiKeyManage453_invoker = createInvoker(
    TelcoApiKeyController_47.apiKeyManage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoApiKeyController",
      "apiKeyManage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/apiKey/""" + "$" + """userId<[^/]+>""",
      """Telco api key""",
      Seq()
    )
  )

  // @LINE:583
  private[this] lazy val controllers_TelcoApiKeyController_getListApiKey454_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListApiKey")))
  )
  private[this] lazy val controllers_TelcoApiKeyController_getListApiKey454_invoker = createInvoker(
    TelcoApiKeyController_47.getListApiKey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoApiKeyController",
      "getListApiKey",
      Nil,
      "GET",
      this.prefix + """getListApiKey""",
      """""",
      Seq()
    )
  )

  // @LINE:587
  private[this] lazy val controllers_TelcoRoleAccountController_accountList455_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/accountList")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_accountList455_invoker = createInvoker(
    TelcoRoleAccountController_5.accountList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "accountList",
      Nil,
      "GET",
      this.prefix + """telco/accountList""",
      """role CMP""",
      Seq()
    )
  )

  // @LINE:588
  private[this] lazy val controllers_TelcoRoleAccountController_getListAccountCmp456_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListAccountCmp")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_getListAccountCmp456_invoker = createInvoker(
    TelcoRoleAccountController_5.getListAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "getListAccountCmp",
      Nil,
      "POST",
      this.prefix + """getListAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:589
  private[this] lazy val controllers_TelcoRoleAccountController_addAccountCmp457_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addAccountCmp")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_addAccountCmp457_invoker = createInvoker(
    TelcoRoleAccountController_5.addAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "addAccountCmp",
      Nil,
      "POST",
      this.prefix + """addAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:590
  private[this] lazy val controllers_TelcoRoleAccountController_addAccountCmpV2458_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addAccountCmpV2")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_addAccountCmpV2458_invoker = createInvoker(
    TelcoRoleAccountController_5.addAccountCmpV2(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "addAccountCmpV2",
      Nil,
      "POST",
      this.prefix + """addAccountCmpV2""",
      """""",
      Seq()
    )
  )

  // @LINE:591
  private[this] lazy val controllers_TelcoRoleAccountController_infoAccountCmp459_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/infoAccountCmp/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_infoAccountCmp459_invoker = createInvoker(
    TelcoRoleAccountController_5.infoAccountCmp(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "infoAccountCmp",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/infoAccountCmp/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:592
  private[this] lazy val controllers_TelcoRoleAccountController_getInfoAccountCmp460_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoAccountCmp")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_getInfoAccountCmp460_invoker = createInvoker(
    TelcoRoleAccountController_5.getInfoAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "getInfoAccountCmp",
      Nil,
      "POST",
      this.prefix + """getInfoAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:593
  private[this] lazy val controllers_TelcoRoleAccountController_generatePassAccountCmp461_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("generatePassAccountCmp")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_generatePassAccountCmp461_invoker = createInvoker(
    TelcoRoleAccountController_5.generatePassAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "generatePassAccountCmp",
      Nil,
      "POST",
      this.prefix + """generatePassAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:594
  private[this] lazy val controllers_TelcoRoleAccountController_addEnterpriseBySAdmin462_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addEnterpriseBySAdmin")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_addEnterpriseBySAdmin462_invoker = createInvoker(
    TelcoRoleAccountController_5.addEnterpriseBySAdmin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "addEnterpriseBySAdmin",
      Nil,
      "POST",
      this.prefix + """addEnterpriseBySAdmin""",
      """""",
      Seq()
    )
  )

  // @LINE:595
  private[this] lazy val controllers_TelcoRoleAccountController_addEnterpriseByAdminOrSEnterprise463_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addEnterpriseByAdminOrSEnterprise")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_addEnterpriseByAdminOrSEnterprise463_invoker = createInvoker(
    TelcoRoleAccountController_5.addEnterpriseByAdminOrSEnterprise(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "addEnterpriseByAdminOrSEnterprise",
      Nil,
      "POST",
      this.prefix + """addEnterpriseByAdminOrSEnterprise""",
      """""",
      Seq()
    )
  )

  // @LINE:596
  private[this] lazy val controllers_TelcoRoleAccountController_deleteEnterprise464_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteEnterprise")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_deleteEnterprise464_invoker = createInvoker(
    TelcoRoleAccountController_5.deleteEnterprise(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "deleteEnterprise",
      Nil,
      "POST",
      this.prefix + """deleteEnterprise""",
      """""",
      Seq()
    )
  )

  // @LINE:597
  private[this] lazy val controllers_TelcoRoleAccountController_editEnterprise465_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editEnterprise")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_editEnterprise465_invoker = createInvoker(
    TelcoRoleAccountController_5.editEnterprise(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "editEnterprise",
      Nil,
      "POST",
      this.prefix + """editEnterprise""",
      """""",
      Seq()
    )
  )

  // @LINE:598
  private[this] lazy val controllers_TelcoRoleAccountController_updateEnterprise466_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateEnterprise")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_updateEnterprise466_invoker = createInvoker(
    TelcoRoleAccountController_5.updateEnterprise(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "updateEnterprise",
      Nil,
      "POST",
      this.prefix + """updateEnterprise""",
      """""",
      Seq()
    )
  )

  // @LINE:599
  private[this] lazy val controllers_TelcoRoleAccountController_deleteAccountCmp467_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAccountCmp")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_deleteAccountCmp467_invoker = createInvoker(
    TelcoRoleAccountController_5.deleteAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "deleteAccountCmp",
      Nil,
      "POST",
      this.prefix + """deleteAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:600
  private[this] lazy val controllers_TelcoRoleAccountController_validateGpkd468_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateGpkd")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_validateGpkd468_invoker = createInvoker(
    TelcoRoleAccountController_5.validateGpkd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "validateGpkd",
      Nil,
      "POST",
      this.prefix + """validateGpkd""",
      """""",
      Seq()
    )
  )

  // @LINE:601
  private[this] lazy val controllers_TelcoRoleAccountController_checkValidateGpkd469_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateGpkdExist")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_checkValidateGpkd469_invoker = createInvoker(
    TelcoRoleAccountController_5.checkValidateGpkd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "checkValidateGpkd",
      Nil,
      "POST",
      this.prefix + """validateGpkdExist""",
      """""",
      Seq()
    )
  )

  // @LINE:602
  private[this] lazy val controllers_TelcoRoleAccountController_updatRoleAccountCmp470_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatRoleAccountCmp")))
  )
  private[this] lazy val controllers_TelcoRoleAccountController_updatRoleAccountCmp470_invoker = createInvoker(
    TelcoRoleAccountController_5.updatRoleAccountCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoRoleAccountController",
      "updatRoleAccountCmp",
      Nil,
      "POST",
      this.prefix + """updatRoleAccountCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:605
  private[this] lazy val controllers_TelcoQrcodeController_qrcodeList471_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qrcodeList")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_qrcodeList471_invoker = createInvoker(
    TelcoQrcodeController_62.qrcodeList(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "qrcodeList",
      Nil,
      "GET",
      this.prefix + """qrcodeList""",
      """qrcode""",
      Seq()
    )
  )

  // @LINE:606
  private[this] lazy val controllers_TelcoQrcodeController_getListQrcodeCmp472_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListQrcodeCmp")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_getListQrcodeCmp472_invoker = createInvoker(
    TelcoQrcodeController_62.getListQrcodeCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "getListQrcodeCmp",
      Nil,
      "POST",
      this.prefix + """getListQrcodeCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:607
  private[this] lazy val controllers_TelcoQrcodeController_checkValidateSerialAdm1473_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkValidateSerialAdm1")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_checkValidateSerialAdm1473_invoker = createInvoker(
    TelcoQrcodeController_62.checkValidateSerialAdm1(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "checkValidateSerialAdm1",
      Nil,
      "POST",
      this.prefix + """checkValidateSerialAdm1""",
      """""",
      Seq()
    )
  )

  // @LINE:608
  private[this] lazy val controllers_TelcoQrcodeController_getListGpkd474_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListGpkd")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_getListGpkd474_invoker = createInvoker(
    TelcoQrcodeController_62.getListGpkd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "getListGpkd",
      Nil,
      "POST",
      this.prefix + """getListGpkd""",
      """""",
      Seq()
    )
  )

  // @LINE:609
  private[this] lazy val controllers_TelcoQrcodeController_saveFileChungTu475_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveFileChungTu")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_saveFileChungTu475_invoker = createInvoker(
    TelcoQrcodeController_62.saveFileChungTu(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "saveFileChungTu",
      Nil,
      "POST",
      this.prefix + """saveFileChungTu""",
      """""",
      Seq()
    )
  )

  // @LINE:610
  private[this] lazy val controllers_TelcoQrcodeController_createQrcode476_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createQrcode")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_createQrcode476_invoker = createInvoker(
    TelcoQrcodeController_62.createQrcode(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "createQrcode",
      Nil,
      "POST",
      this.prefix + """createQrcode""",
      """""",
      Seq()
    )
  )

  // @LINE:611
  private[this] lazy val controllers_TelcoQrcodeController_qrCodeConnect477_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("provisioning/qr/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoQrcodeController_qrCodeConnect477_invoker = createInvoker(
    TelcoQrcodeController_62.qrCodeConnect(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "qrCodeConnect",
      Seq(classOf[String]),
      "GET",
      this.prefix + """provisioning/qr/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:612
  private[this] lazy val controllers_TelcoQrcodeController_getInfoConnectSubs478_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoConnectSubs")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_getInfoConnectSubs478_invoker = createInvoker(
    TelcoQrcodeController_62.getInfoConnectSubs(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "getInfoConnectSubs",
      Nil,
      "POST",
      this.prefix + """getInfoConnectSubs""",
      """""",
      Seq()
    )
  )

  // @LINE:613
  private[this] lazy val controllers_TelcoQrcodeController_paymentConnectSubs479_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paymentConnectSubs")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_paymentConnectSubs479_invoker = createInvoker(
    TelcoQrcodeController_62.paymentConnectSubs(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "paymentConnectSubs",
      Nil,
      "POST",
      this.prefix + """paymentConnectSubs""",
      """""",
      Seq()
    )
  )

  // @LINE:614
  private[this] lazy val controllers_TelcoQrcodeController_delQrcodeById480_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delQrcodeById")))
  )
  private[this] lazy val controllers_TelcoQrcodeController_delQrcodeById480_invoker = createInvoker(
    TelcoQrcodeController_62.delQrcodeById(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoQrcodeController",
      "delQrcodeById",
      Nil,
      "POST",
      this.prefix + """delQrcodeById""",
      """""",
      Seq()
    )
  )

  // @LINE:617
  private[this] lazy val controllers_TelcoHistoryController_historyPackMiAddon481_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyPackMiAddon/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoHistoryController_historyPackMiAddon481_invoker = createInvoker(
    TelcoHistoryController_35.historyPackMiAddon(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "historyPackMiAddon",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyPackMiAddon/""" + "$" + """userId<[^/]+>""",
      """history""",
      Seq()
    )
  )

  // @LINE:618
  private[this] lazy val controllers_TelcoHistoryController_historyDeposit482_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyDeposit/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoHistoryController_historyDeposit482_invoker = createInvoker(
    TelcoHistoryController_35.historyDeposit(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "historyDeposit",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyDeposit/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:619
  private[this] lazy val controllers_TelcoHistoryController_historyPrepayCharges483_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyPrepayCharges/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoHistoryController_historyPrepayCharges483_invoker = createInvoker(
    TelcoHistoryController_35.historyPrepayCharges(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "historyPrepayCharges",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyPrepayCharges/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:620
  private[this] lazy val controllers_TelcoHistoryController_historyApn484_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyAPN/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoHistoryController_historyApn484_invoker = createInvoker(
    TelcoHistoryController_35.historyApn(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "historyApn",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyAPN/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:621
  private[this] lazy val controllers_TelcoHistoryController_historyBlockUnblock485_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyBlockUnblock/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoHistoryController_historyBlockUnblock485_invoker = createInvoker(
    TelcoHistoryController_35.historyBlockUnblock(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "historyBlockUnblock",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyBlockUnblock/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:622
  private[this] lazy val controllers_TelcoHistoryController_getHistoryPackMiAddon486_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryPackMiAddon")))
  )
  private[this] lazy val controllers_TelcoHistoryController_getHistoryPackMiAddon486_invoker = createInvoker(
    TelcoHistoryController_35.getHistoryPackMiAddon(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "getHistoryPackMiAddon",
      Nil,
      "POST",
      this.prefix + """getHistoryPackMiAddon""",
      """""",
      Seq()
    )
  )

  // @LINE:623
  private[this] lazy val controllers_TelcoHistoryController_getHistoryApn487_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHistoryAPN")))
  )
  private[this] lazy val controllers_TelcoHistoryController_getHistoryApn487_invoker = createInvoker(
    TelcoHistoryController_35.getHistoryApn(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "getHistoryApn",
      Nil,
      "POST",
      this.prefix + """getHistoryAPN""",
      """""",
      Seq()
    )
  )

  // @LINE:624
  private[this] lazy val controllers_TelcoHistoryController_historyPostPaidBill488_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("historyPostPaidBill/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoHistoryController_historyPostPaidBill488_invoker = createInvoker(
    TelcoHistoryController_35.historyPostPaidBill(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoHistoryController",
      "historyPostPaidBill",
      Seq(classOf[String]),
      "GET",
      this.prefix + """historyPostPaidBill/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:627
  private[this] lazy val controllers_TelcoChildUserController_listChildUser489_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/listChildUser/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoChildUserController_listChildUser489_invoker = createInvoker(
    TelcoChildUserController_13.listChildUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "listChildUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/listChildUser/""" + "$" + """userId<[^/]+>""",
      """listChildUser""",
      Seq()
    )
  )

  // @LINE:628
  private[this] lazy val controllers_TelcoChildUserController_getListChildUser490_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListChildUser")))
  )
  private[this] lazy val controllers_TelcoChildUserController_getListChildUser490_invoker = createInvoker(
    TelcoChildUserController_13.getListChildUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "getListChildUser",
      Nil,
      "POST",
      this.prefix + """getListChildUser""",
      """""",
      Seq()
    )
  )

  // @LINE:629
  private[this] lazy val controllers_TelcoChildUserController_addChildUserCmp491_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addChildUserCmp/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoChildUserController_addChildUserCmp491_invoker = createInvoker(
    TelcoChildUserController_13.addChildUserCmp(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "addChildUserCmp",
      Seq(classOf[String]),
      "POST",
      this.prefix + """addChildUserCmp/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:630
  private[this] lazy val controllers_TelcoChildUserController_getRolesOfChildUser492_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getRolesOfChildUser")))
  )
  private[this] lazy val controllers_TelcoChildUserController_getRolesOfChildUser492_invoker = createInvoker(
    TelcoChildUserController_13.getRolesOfChildUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "getRolesOfChildUser",
      Nil,
      "POST",
      this.prefix + """getRolesOfChildUser""",
      """""",
      Seq()
    )
  )

  // @LINE:631
  private[this] lazy val controllers_TelcoChildUserController_updateRolesOfChildUser493_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateRolesOfChildUser")))
  )
  private[this] lazy val controllers_TelcoChildUserController_updateRolesOfChildUser493_invoker = createInvoker(
    TelcoChildUserController_13.updateRolesOfChildUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "updateRolesOfChildUser",
      Nil,
      "POST",
      this.prefix + """updateRolesOfChildUser""",
      """""",
      Seq()
    )
  )

  // @LINE:632
  private[this] lazy val controllers_TelcoChildUserController_childUserDetail494_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("childUserDetail/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/"), DynamicPart("childUserId", """[^/]+""",true), StaticPart("/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoChildUserController_childUserDetail494_invoker = createInvoker(
    TelcoChildUserController_13.childUserDetail(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "childUserDetail",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """childUserDetail/""" + "$" + """userId<[^/]+>/""" + "$" + """childUserId<[^/]+>/""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:633
  private[this] lazy val controllers_TelcoChildUserController_getListSubsOfChildUser495_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getListSubsOfChildUser")))
  )
  private[this] lazy val controllers_TelcoChildUserController_getListSubsOfChildUser495_invoker = createInvoker(
    TelcoChildUserController_13.getListSubsOfChildUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "getListSubsOfChildUser",
      Nil,
      "POST",
      this.prefix + """getListSubsOfChildUser""",
      """""",
      Seq()
    )
  )

  // @LINE:634
  private[this] lazy val controllers_TelcoChildUserController_addSubToChildUser496_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addSubToChildUser")))
  )
  private[this] lazy val controllers_TelcoChildUserController_addSubToChildUser496_invoker = createInvoker(
    TelcoChildUserController_13.addSubToChildUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "addSubToChildUser",
      Nil,
      "POST",
      this.prefix + """addSubToChildUser""",
      """""",
      Seq()
    )
  )

  // @LINE:635
  private[this] lazy val controllers_TelcoChildUserController_addSubToChildUser1497_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addSubToChildUser1")))
  )
  private[this] lazy val controllers_TelcoChildUserController_addSubToChildUser1497_invoker = createInvoker(
    TelcoChildUserController_13.addSubToChildUser1(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "addSubToChildUser1",
      Nil,
      "POST",
      this.prefix + """addSubToChildUser1""",
      """""",
      Seq()
    )
  )

  // @LINE:636
  private[this] lazy val controllers_TelcoChildUserController_validateSubToChildUser1498_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateSubToChildUser1")))
  )
  private[this] lazy val controllers_TelcoChildUserController_validateSubToChildUser1498_invoker = createInvoker(
    TelcoChildUserController_13.validateSubToChildUser1(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "validateSubToChildUser1",
      Nil,
      "POST",
      this.prefix + """validateSubToChildUser1""",
      """""",
      Seq()
    )
  )

  // @LINE:637
  private[this] lazy val controllers_TelcoChildUserController_removeSubOfChildUser499_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeSubOfChildUser")))
  )
  private[this] lazy val controllers_TelcoChildUserController_removeSubOfChildUser499_invoker = createInvoker(
    TelcoChildUserController_13.removeSubOfChildUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoChildUserController",
      "removeSubOfChildUser",
      Nil,
      "POST",
      this.prefix + """removeSubOfChildUser""",
      """""",
      Seq()
    )
  )

  // @LINE:640
  private[this] lazy val controllers_TelcoFeedbackController_feedback500_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("feedback/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoFeedbackController_feedback500_invoker = createInvoker(
    TelcoFeedbackController_58.feedback(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoFeedbackController",
      "feedback",
      Seq(classOf[String]),
      "GET",
      this.prefix + """feedback/""" + "$" + """userId<[^/]+>""",
      """feedback""",
      Seq()
    )
  )

  // @LINE:641
  private[this] lazy val controllers_TelcoFeedbackController_sendFeedback501_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendFeedback")))
  )
  private[this] lazy val controllers_TelcoFeedbackController_sendFeedback501_invoker = createInvoker(
    TelcoFeedbackController_58.sendFeedback(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoFeedbackController",
      "sendFeedback",
      Nil,
      "POST",
      this.prefix + """sendFeedback""",
      """""",
      Seq()
    )
  )

  // @LINE:642
  private[this] lazy val controllers_TelcoFeedbackController_logFeedback502_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logFeedback")))
  )
  private[this] lazy val controllers_TelcoFeedbackController_logFeedback502_invoker = createInvoker(
    TelcoFeedbackController_58.logFeedback(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoFeedbackController",
      "logFeedback",
      Nil,
      "GET",
      this.prefix + """logFeedback""",
      """""",
      Seq()
    )
  )

  // @LINE:643
  private[this] lazy val controllers_TelcoFeedbackController_getLogListFeedback503_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLogListFeedback")))
  )
  private[this] lazy val controllers_TelcoFeedbackController_getLogListFeedback503_invoker = createInvoker(
    TelcoFeedbackController_58.getLogListFeedback(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoFeedbackController",
      "getLogListFeedback",
      Nil,
      "POST",
      this.prefix + """getLogListFeedback""",
      """""",
      Seq()
    )
  )

  // @LINE:646
  private[this] lazy val controllers_TelcoLogController_logCmp504_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logCmp")))
  )
  private[this] lazy val controllers_TelcoLogController_logCmp504_invoker = createInvoker(
    TelcoLogController_73.logCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "logCmp",
      Nil,
      "GET",
      this.prefix + """logCmp""",
      """log cmp""",
      Seq()
    )
  )

  // @LINE:647
  private[this] lazy val controllers_TelcoLogController_getLogListCmp505_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLogListCmp")))
  )
  private[this] lazy val controllers_TelcoLogController_getLogListCmp505_invoker = createInvoker(
    TelcoLogController_73.getLogListCmp(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "getLogListCmp",
      Nil,
      "POST",
      this.prefix + """getLogListCmp""",
      """""",
      Seq()
    )
  )

  // @LINE:648
  private[this] lazy val controllers_TelcoLogController_updateFormCustomerSurvey506_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateFormCustomerSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_updateFormCustomerSurvey506_invoker = createInvoker(
    TelcoLogController_73.updateFormCustomerSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "updateFormCustomerSurvey",
      Nil,
      "POST",
      this.prefix + """updateFormCustomerSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:649
  private[this] lazy val controllers_TelcoLogController_logCustomerSurvey507_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logCustomerSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_logCustomerSurvey507_invoker = createInvoker(
    TelcoLogController_73.logCustomerSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "logCustomerSurvey",
      Nil,
      "GET",
      this.prefix + """logCustomerSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:650
  private[this] lazy val controllers_TelcoLogController_getLogListCustomerSurvey508_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLogListCustomerSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_getLogListCustomerSurvey508_invoker = createInvoker(
    TelcoLogController_73.getLogListCustomerSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "getLogListCustomerSurvey",
      Nil,
      "POST",
      this.prefix + """getLogListCustomerSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:651
  private[this] lazy val controllers_TelcoLogController_editSurvey509_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_editSurvey509_invoker = createInvoker(
    TelcoLogController_73.editSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "editSurvey",
      Nil,
      "POST",
      this.prefix + """editSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:652
  private[this] lazy val controllers_TelcoLogController_deleteSurvey510_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_deleteSurvey510_invoker = createInvoker(
    TelcoLogController_73.deleteSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "deleteSurvey",
      Nil,
      "POST",
      this.prefix + """deleteSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:653
  private[this] lazy val controllers_TelcoLogController_getInfoSurvey511_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getInfoSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_getInfoSurvey511_invoker = createInvoker(
    TelcoLogController_73.getInfoSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "getInfoSurvey",
      Nil,
      "POST",
      this.prefix + """getInfoSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:654
  private[this] lazy val controllers_TelcoLogController_exportLogCustomerSurvey512_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("exportLogCustomerSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_exportLogCustomerSurvey512_invoker = createInvoker(
    TelcoLogController_73.exportLogCustomerSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "exportLogCustomerSurvey",
      Nil,
      "POST",
      this.prefix + """exportLogCustomerSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:655
  private[this] lazy val controllers_TelcoLogController_saveFormCustomerSurvey513_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveFormCustomerSurvey")))
  )
  private[this] lazy val controllers_TelcoLogController_saveFormCustomerSurvey513_invoker = createInvoker(
    TelcoLogController_73.saveFormCustomerSurvey(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLogController",
      "saveFormCustomerSurvey",
      Nil,
      "POST",
      this.prefix + """saveFormCustomerSurvey""",
      """""",
      Seq()
    )
  )

  // @LINE:658
  private[this] lazy val controllers_TelcoAepController_aepUtilities514_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("aepUtilities/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoAepController_aepUtilities514_invoker = createInvoker(
    TelcoAepController_30.aepUtilities(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAepController",
      "aepUtilities",
      Seq(classOf[String]),
      "GET",
      this.prefix + """aepUtilities/""" + "$" + """userId<[^/]+>""",
      """AEP vs CMP""",
      Seq()
    )
  )

  // @LINE:659
  private[this] lazy val controllers_TelcoAepController_requestDataAepWeather515_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("requestDataAepWeather")))
  )
  private[this] lazy val controllers_TelcoAepController_requestDataAepWeather515_invoker = createInvoker(
    TelcoAepController_30.requestDataAepWeather(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAepController",
      "requestDataAepWeather",
      Nil,
      "POST",
      this.prefix + """requestDataAepWeather""",
      """""",
      Seq()
    )
  )

  // @LINE:660
  private[this] lazy val controllers_TelcoAepController_requestDataAepGps516_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("requestDataAepGps")))
  )
  private[this] lazy val controllers_TelcoAepController_requestDataAepGps516_invoker = createInvoker(
    TelcoAepController_30.requestDataAepGps(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoAepController",
      "requestDataAepGps",
      Nil,
      "POST",
      this.prefix + """requestDataAepGps""",
      """""",
      Seq()
    )
  )

  // @LINE:663
  private[this] lazy val controllers_TelcoLocationController_telcoLocation517_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telcoLocation/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoLocationController_telcoLocation517_invoker = createInvoker(
    TelcoLocationController_2.telcoLocation(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLocationController",
      "telcoLocation",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telcoLocation/""" + "$" + """userId<[^/]+>""",
      """location isdn""",
      Seq()
    )
  )

  // @LINE:664
  private[this] lazy val controllers_TelcoLocationController_searchByIsdn518_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchByIsdn")))
  )
  private[this] lazy val controllers_TelcoLocationController_searchByIsdn518_invoker = createInvoker(
    TelcoLocationController_2.searchByIsdn(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoLocationController",
      "searchByIsdn",
      Nil,
      "POST",
      this.prefix + """searchByIsdn""",
      """""",
      Seq()
    )
  )

  // @LINE:667
  private[this] lazy val controllers_InvoiceManagerController_invoiceManage519_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/invoiceManage/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_InvoiceManagerController_invoiceManage519_invoker = createInvoker(
    InvoiceManagerController_19.invoiceManage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InvoiceManagerController",
      "invoiceManage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/invoiceManage/""" + "$" + """userId<[^/]+>""",
      """Invoice Manager""",
      Seq()
    )
  )

  // @LINE:668
  private[this] lazy val controllers_InvoiceManagerController_getInvoices520_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/getInvoices")))
  )
  private[this] lazy val controllers_InvoiceManagerController_getInvoices520_invoker = createInvoker(
    InvoiceManagerController_19.getInvoices(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InvoiceManagerController",
      "getInvoices",
      Nil,
      "POST",
      this.prefix + """telco/getInvoices""",
      """""",
      Seq()
    )
  )

  // @LINE:669
  private[this] lazy val controllers_InvoiceManagerController_getInvoiceBase64521_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/getInvoiceBase64")))
  )
  private[this] lazy val controllers_InvoiceManagerController_getInvoiceBase64521_invoker = createInvoker(
    InvoiceManagerController_19.getInvoiceBase64(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InvoiceManagerController",
      "getInvoiceBase64",
      Nil,
      "POST",
      this.prefix + """telco/getInvoiceBase64""",
      """""",
      Seq()
    )
  )

  // @LINE:672
  private[this] lazy val controllers_TelcoStatisticalReportController_RedBaring522_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/report/subscriberBanned/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoStatisticalReportController_RedBaring522_invoker = createInvoker(
    TelcoStatisticalReportController_29.RedBaring(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoStatisticalReportController",
      "RedBaring",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/report/subscriberBanned/""" + "$" + """userId<[^/]+>""",
      """Statistic Report""",
      Seq()
    )
  )

  // @LINE:673
  private[this] lazy val controllers_TelcoStatisticalReportController_getRedBarings523_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/report/getRedBarings")))
  )
  private[this] lazy val controllers_TelcoStatisticalReportController_getRedBarings523_invoker = createInvoker(
    TelcoStatisticalReportController_29.getRedBarings(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoStatisticalReportController",
      "getRedBarings",
      Nil,
      "POST",
      this.prefix + """telco/report/getRedBarings""",
      """""",
      Seq()
    )
  )

  // @LINE:674
  private[this] lazy val controllers_TelcoStatisticalReportController_ExpiratedPackage524_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/report/pakageTime/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TelcoStatisticalReportController_ExpiratedPackage524_invoker = createInvoker(
    TelcoStatisticalReportController_29.ExpiratedPackage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoStatisticalReportController",
      "ExpiratedPackage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """telco/report/pakageTime/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:675
  private[this] lazy val controllers_TelcoStatisticalReportController_getExpiratedPackages525_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("telco/report/getExpiratedPackages")))
  )
  private[this] lazy val controllers_TelcoStatisticalReportController_getExpiratedPackages525_invoker = createInvoker(
    TelcoStatisticalReportController_29.getExpiratedPackages(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TelcoStatisticalReportController",
      "getExpiratedPackages",
      Nil,
      "POST",
      this.prefix + """telco/report/getExpiratedPackages""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case controllers_LandingPageController_home0_route(params) =>
      call { 
        controllers_LandingPageController_home0_invoker.call(LandingPageController_67.home())
      }
  
    // @LINE:5
    case controllers_OrderSearchController_OrderSearchView1_route(params) =>
      call { 
        controllers_OrderSearchController_OrderSearchView1_invoker.call(OrderSearchController_57.OrderSearchView())
      }
  
    // @LINE:6
    case controllers_LandingPageController_landingPage2_route(params) =>
      call { 
        controllers_LandingPageController_landingPage2_invoker.call(LandingPageController_67.landingPage())
      }
  
    // @LINE:7
    case controllers_LandingPageController_submitFormContactTelco3_route(params) =>
      call { 
        controllers_LandingPageController_submitFormContactTelco3_invoker.call(LandingPageController_67.submitFormContactTelco())
      }
  
    // @LINE:8
    case controllers_LandingPageController_getListProductOfferPack4_route(params) =>
      call(params.fromQuery[String]("offerType", None), params.fromQuery[String]("payType", None), params.fromQuery[String]("category", None)) { (offerType, payType, category) =>
        controllers_LandingPageController_getListProductOfferPack4_invoker.call(LandingPageController_67.getListProductOfferPack(offerType, payType, category))
      }
  
    // @LINE:9
    case controllers_LandingPageController_submitFormContact5_route(params) =>
      call { 
        controllers_LandingPageController_submitFormContact5_invoker.call(LandingPageController_67.submitFormContact())
      }
  
    // @LINE:10
    case controllers_LandingPageController_submitRegisterDeveloper6_route(params) =>
      call { 
        controllers_LandingPageController_submitRegisterDeveloper6_invoker.call(LandingPageController_67.submitRegisterDeveloper())
      }
  
    // @LINE:11
    case controllers_LandingPageController_registerDeveloper7_route(params) =>
      call { 
        controllers_LandingPageController_registerDeveloper7_invoker.call(LandingPageController_67.registerDeveloper())
      }
  
    // @LINE:12
    case controllers_Application_login8_route(params) =>
      call { 
        controllers_Application_login8_invoker.call(Application_71.login())
      }
  
    // @LINE:13
    case controllers_Application_authenticateDemo9_route(params) =>
      call { 
        controllers_Application_authenticateDemo9_invoker.call(Application_71.authenticateDemo())
      }
  
    // @LINE:15
    case controllers_Application_setLang10_route(params) =>
      call(params.fromPath[String]("lang", None)) { (lang) =>
        controllers_Application_setLang10_invoker.call(Application_71.setLang(lang))
      }
  
    // @LINE:18
    case controllers_Application_checkIpLogin11_route(params) =>
      call { 
        controllers_Application_checkIpLogin11_invoker.call(Application_71.checkIpLogin())
      }
  
    // @LINE:19
    case controllers_Application_verifyPhone12_route(params) =>
      call { 
        controllers_Application_verifyPhone12_invoker.call(Application_71.verifyPhone())
      }
  
    // @LINE:20
    case controllers_Application_ChangePass13_route(params) =>
      call { 
        controllers_Application_ChangePass13_invoker.call(Application_71.ChangePass())
      }
  
    // @LINE:21
    case controllers_Application_createAccount14_route(params) =>
      call { 
        controllers_Application_createAccount14_invoker.call(Application_71.createAccount())
      }
  
    // @LINE:22
    case controllers_Application_authenticate15_route(params) =>
      call { 
        controllers_Application_authenticate15_invoker.call(Application_71.authenticate())
      }
  
    // @LINE:23
    case controllers_Application_logout16_route(params) =>
      call { 
        controllers_Application_logout16_invoker.call(Application_71.logout())
      }
  
    // @LINE:24
    case controllers_Application_register17_route(params) =>
      call { 
        controllers_Application_register17_invoker.call(Application_71.register())
      }
  
    // @LINE:26
    case controllers_Application_newRegisterPost18_route(params) =>
      call { 
        controllers_Application_newRegisterPost18_invoker.call(Application_71.newRegisterPost())
      }
  
    // @LINE:27
    case controllers_Application_forgotPassPage19_route(params) =>
      call { 
        controllers_Application_forgotPassPage19_invoker.call(Application_71.forgotPassPage())
      }
  
    // @LINE:28
    case controllers_FogotPassController_userGetCodeChangePass20_route(params) =>
      call { 
        controllers_FogotPassController_userGetCodeChangePass20_invoker.call(FogotPassController_8.userGetCodeChangePass())
      }
  
    // @LINE:29
    case controllers_Application_ForgetPassword21_route(params) =>
      call { 
        controllers_Application_ForgetPassword21_invoker.call(Application_71.ForgetPassword())
      }
  
    // @LINE:30
    case controllers_FogotPassController_ChangePassword22_route(params) =>
      call { 
        controllers_FogotPassController_ChangePassword22_invoker.call(FogotPassController_8.ChangePassword())
      }
  
    // @LINE:31
    case controllers_Application_getOtpEmail23_route(params) =>
      call { 
        controllers_Application_getOtpEmail23_invoker.call(Application_71.getOtpEmail())
      }
  
    // @LINE:32
    case controllers_Application_getOtpPhone24_route(params) =>
      call { 
        controllers_Application_getOtpPhone24_invoker.call(Application_71.getOtpPhone())
      }
  
    // @LINE:33
    case controllers_Application_version25_route(params) =>
      call { 
        controllers_Application_version25_invoker.call(Application_71.version())
      }
  
    // @LINE:34
    case controllers_HomeController_termsOfUse26_route(params) =>
      call { 
        controllers_HomeController_termsOfUse26_invoker.call(HomeController_10.termsOfUse())
      }
  
    // @LINE:36
    case controllers_Application_sitemap27_route(params) =>
      call { 
        controllers_Application_sitemap27_invoker.call(Application_71.sitemap())
      }
  
    // @LINE:37
    case controllers_Assets_at28_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("sitemap.xml"))) { (path, file) =>
        controllers_Assets_at28_invoker.call(Assets_63.at(path, file))
      }
  
    // @LINE:38
    case controllers_Assets_at29_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("sitemap_index.xml"))) { (path, file) =>
        controllers_Assets_at29_invoker.call(Assets_63.at(path, file))
      }
  
    // @LINE:39
    case controllers_Assets_at30_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("robots.txt"))) { (path, file) =>
        controllers_Assets_at30_invoker.call(Assets_63.at(path, file))
      }
  
    // @LINE:40
    case controllers_Assets_at31_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("dieu-khoan.txt"))) { (path, file) =>
        controllers_Assets_at31_invoker.call(Assets_63.at(path, file))
      }
  
    // @LINE:42
    case controllers_Assets_versioned32_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned32_invoker.call(Assets_63.versioned(path, file))
      }
  
    // @LINE:45
    case controllers_JsController_jsMessages33_route(params) =>
      call { 
        controllers_JsController_jsMessages33_invoker.call(JsController_22.jsMessages())
      }
  
    // @LINE:47
    case controllers_JsController_javascriptRoutes34_route(params) =>
      call { 
        controllers_JsController_javascriptRoutes34_invoker.call(JsController_22.javascriptRoutes())
      }
  
    // @LINE:49
    case controllers_HomeController_getImg35_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_HomeController_getImg35_invoker.call(HomeController_10.getImg(id))
      }
  
    // @LINE:50
    case controllers_HomeController_success36_route(params) =>
      call { 
        controllers_HomeController_success36_invoker.call(HomeController_10.success())
      }
  
    // @LINE:51
    case controllers_HomeController_cancel37_route(params) =>
      call { 
        controllers_HomeController_cancel37_invoker.call(HomeController_10.cancel())
      }
  
    // @LINE:52
    case controllers_HomeController_provision38_route(params) =>
      call { 
        controllers_HomeController_provision38_invoker.call(HomeController_10.provision())
      }
  
    // @LINE:53
    case controllers_HomeController_pageSuccess39_route(params) =>
      call { 
        controllers_HomeController_pageSuccess39_invoker.call(HomeController_10.pageSuccess())
      }
  
    // @LINE:56
    case controllers_DownloadPageController_download40_route(params) =>
      call { 
        controllers_DownloadPageController_download40_invoker.call(DownloadPageController_6.download())
      }
  
    // @LINE:59
    case controllers_ProjectController_project41_route(params) =>
      call { 
        controllers_ProjectController_project41_invoker.call(ProjectController_40.project())
      }
  
    // @LINE:60
    case controllers_ProjectController_getProject42_route(params) =>
      call { 
        controllers_ProjectController_getProject42_invoker.call(ProjectController_40.getProject())
      }
  
    // @LINE:61
    case controllers_ProjectController_createProjectForm43_route(params) =>
      call { 
        controllers_ProjectController_createProjectForm43_invoker.call(ProjectController_40.createProjectForm())
      }
  
    // @LINE:62
    case controllers_ProjectController_addProject44_route(params) =>
      call { 
        controllers_ProjectController_addProject44_invoker.call(ProjectController_40.addProject())
      }
  
    // @LINE:63
    case controllers_ProjectController_editProject45_route(params) =>
      call { 
        controllers_ProjectController_editProject45_invoker.call(ProjectController_40.editProject())
      }
  
    // @LINE:64
    case controllers_ProjectController_delProject46_route(params) =>
      call { 
        controllers_ProjectController_delProject46_invoker.call(ProjectController_40.delProject())
      }
  
    // @LINE:65
    case controllers_ProjectController_getNameProject47_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProjectController_getNameProject47_invoker.call(ProjectController_40.getNameProject(id))
      }
  
    // @LINE:66
    case controllers_ProjectController_sendPostJsonProjectTemplate48_route(params) =>
      call { 
        controllers_ProjectController_sendPostJsonProjectTemplate48_invoker.call(ProjectController_40.sendPostJsonProjectTemplate())
      }
  
    // @LINE:67
    case controllers_ProjectController_sendPutJsonProjectTemplate49_route(params) =>
      call { 
        controllers_ProjectController_sendPutJsonProjectTemplate49_invoker.call(ProjectController_40.sendPutJsonProjectTemplate())
      }
  
    // @LINE:68
    case controllers_ProjectController_createDashboardTemplate50_route(params) =>
      call { 
        controllers_ProjectController_createDashboardTemplate50_invoker.call(ProjectController_40.createDashboardTemplate())
      }
  
    // @LINE:69
    case controllers_ProjectController_getListTag51_route(params) =>
      call { 
        controllers_ProjectController_getListTag51_invoker.call(ProjectController_40.getListTag())
      }
  
    // @LINE:70
    case controllers_ProjectController_activePhone52_route(params) =>
      call { 
        controllers_ProjectController_activePhone52_invoker.call(ProjectController_40.activePhone())
      }
  
    // @LINE:73
    case controllers_OverviewController_overview53_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OverviewController_overview53_invoker.call(OverviewController_27.overview(id))
      }
  
    // @LINE:74
    case controllers_OverviewController_countDeviceAndUser54_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OverviewController_countDeviceAndUser54_invoker.call(OverviewController_27.countDeviceAndUser(id))
      }
  
    // @LINE:75
    case controllers_OverviewController_countDevice7Day55_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OverviewController_countDevice7Day55_invoker.call(OverviewController_27.countDevice7Day(id))
      }
  
    // @LINE:76
    case controllers_OverviewController_countUser7Day56_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OverviewController_countUser7Day56_invoker.call(OverviewController_27.countUser7Day(id))
      }
  
    // @LINE:77
    case controllers_OverviewController_countMess7Day57_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OverviewController_countMess7Day57_invoker.call(OverviewController_27.countMess7Day(id))
      }
  
    // @LINE:78
    case controllers_OverviewController_countDataLatency58_route(params) =>
      call { 
        controllers_OverviewController_countDataLatency58_invoker.call(OverviewController_27.countDataLatency())
      }
  
    // @LINE:79
    case controllers_OverviewController_countDataSuccessRate59_route(params) =>
      call { 
        controllers_OverviewController_countDataSuccessRate59_invoker.call(OverviewController_27.countDataSuccessRate())
      }
  
    // @LINE:81
    case controllers_UserController_userList60_route(params) =>
      call { 
        controllers_UserController_userList60_invoker.call(UserController_38.userList())
      }
  
    // @LINE:82
    case controllers_UserController_addNewUser61_route(params) =>
      call { 
        controllers_UserController_addNewUser61_invoker.call(UserController_38.addNewUser())
      }
  
    // @LINE:83
    case controllers_UserController_getTokenSendPassUser62_route(params) =>
      call { 
        controllers_UserController_getTokenSendPassUser62_invoker.call(UserController_38.getTokenSendPassUser())
      }
  
    // @LINE:84
    case controllers_UserController_editUser63_route(params) =>
      call { 
        controllers_UserController_editUser63_invoker.call(UserController_38.editUser())
      }
  
    // @LINE:85
    case controllers_UserController_deleteUser64_route(params) =>
      call { 
        controllers_UserController_deleteUser64_invoker.call(UserController_38.deleteUser())
      }
  
    // @LINE:86
    case controllers_UserController_addRoleForUser65_route(params) =>
      call { 
        controllers_UserController_addRoleForUser65_invoker.call(UserController_38.addRoleForUser())
      }
  
    // @LINE:87
    case controllers_UserController_updateUserOrg66_route(params) =>
      call { 
        controllers_UserController_updateUserOrg66_invoker.call(UserController_38.updateUserOrg())
      }
  
    // @LINE:90
    case controllers_Assets_at67_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("health.html"))) { (path, file) =>
        controllers_Assets_at67_invoker.call(Assets_63.at(path, file))
      }
  
    // @LINE:93
    case controllers_ApiController_sendMail68_route(params) =>
      call { 
        controllers_ApiController_sendMail68_invoker.call(ApiController_76.sendMail())
      }
  
    // @LINE:94
    case controllers_ApiController_getJsonWidget69_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ApiController_getJsonWidget69_invoker.call(ApiController_76.getJsonWidget(id))
      }
  
    // @LINE:97
    case controllers_SocketController_wsSocket70_route(params) =>
      call { 
        controllers_SocketController_wsSocket70_invoker.call(SocketController_32.wsSocket())
      }
  
    // @LINE:100
    case controllers_SendApiController_getDataWithParam71_route(params) =>
      call { 
        controllers_SendApiController_getDataWithParam71_invoker.call(SendApiController_48.getDataWithParam())
      }
  
    // @LINE:101
    case controllers_SendApiController_portDataWithParam72_route(params) =>
      call { 
        controllers_SendApiController_portDataWithParam72_invoker.call(SendApiController_48.portDataWithParam())
      }
  
    // @LINE:102
    case controllers_SendApiController_putDataWithParam73_route(params) =>
      call { 
        controllers_SendApiController_putDataWithParam73_invoker.call(SendApiController_48.putDataWithParam())
      }
  
    // @LINE:103
    case controllers_SendApiController_upfileImage74_route(params) =>
      call { 
        controllers_SendApiController_upfileImage74_invoker.call(SendApiController_48.upfileImage())
      }
  
    // @LINE:104
    case controllers_SendApiController_deleteDataWithParam75_route(params) =>
      call { 
        controllers_SendApiController_deleteDataWithParam75_invoker.call(SendApiController_48.deleteDataWithParam())
      }
  
    // @LINE:107
    case controllers_DownloadFileController_downloadFileFromApi76_route(params) =>
      call(params.fromQuery[String]("param", None)) { (param) =>
        controllers_DownloadFileController_downloadFileFromApi76_invoker.call(DownloadFileController_42.downloadFileFromApi(param))
      }
  
    // @LINE:110
    case controllers_DashboardController_dashboard77_route(params) =>
      call { 
        controllers_DashboardController_dashboard77_invoker.call(DashboardController_14.dashboard())
      }
  
    // @LINE:111
    case controllers_DashboardController_getMarkersWithPaging78_route(params) =>
      call { 
        controllers_DashboardController_getMarkersWithPaging78_invoker.call(DashboardController_14.getMarkersWithPaging())
      }
  
    // @LINE:112
    case controllers_DashboardController_getListDeviceWithPaging79_route(params) =>
      call { 
        controllers_DashboardController_getListDeviceWithPaging79_invoker.call(DashboardController_14.getListDeviceWithPaging())
      }
  
    // @LINE:113
    case controllers_DashboardController_loadDeviceDataCurrent80_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DashboardController_loadDeviceDataCurrent80_invoker.call(DashboardController_14.loadDeviceDataCurrent(id))
      }
  
    // @LINE:115
    case controllers_DashboardWidgetController_dashboardVer281_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DashboardWidgetController_dashboardVer281_invoker.call(DashboardWidgetController_75.dashboardVer2(id))
      }
  
    // @LINE:116
    case controllers_DashboardWidgetController_getListDeviceWithWidgetMap82_route(params) =>
      call { 
        controllers_DashboardWidgetController_getListDeviceWithWidgetMap82_invoker.call(DashboardWidgetController_75.getListDeviceWithWidgetMap())
      }
  
    // @LINE:117
    case controllers_DashboardWidgetController_getDeviceDataCurrent83_route(params) =>
      call(params.fromQuery[String]("deviceId", None), params.fromQuery[String]("latId", None), params.fromQuery[String]("longId", None)) { (deviceId, latId, longId) =>
        controllers_DashboardWidgetController_getDeviceDataCurrent83_invoker.call(DashboardWidgetController_75.getDeviceDataCurrent(deviceId, latId, longId))
      }
  
    // @LINE:118
    case controllers_DashboardWidgetController_getHistoryRpc84_route(params) =>
      call { 
        controllers_DashboardWidgetController_getHistoryRpc84_invoker.call(DashboardWidgetController_75.getHistoryRpc())
      }
  
    // @LINE:120
    case controllers_DashboardV3Controller_dashboardList85_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DashboardV3Controller_dashboardList85_invoker.call(DashboardV3Controller_4.dashboardList(id))
      }
  
    // @LINE:121
    case controllers_DashboardV3Controller_getListDashboard86_route(params) =>
      call { 
        controllers_DashboardV3Controller_getListDashboard86_invoker.call(DashboardV3Controller_4.getListDashboard())
      }
  
    // @LINE:122
    case controllers_DashboardV3Controller_addNewDashboard87_route(params) =>
      call { 
        controllers_DashboardV3Controller_addNewDashboard87_invoker.call(DashboardV3Controller_4.addNewDashboard())
      }
  
    // @LINE:123
    case controllers_DashboardV3Controller_editContentDashboard88_route(params) =>
      call { 
        controllers_DashboardV3Controller_editContentDashboard88_invoker.call(DashboardV3Controller_4.editContentDashboard())
      }
  
    // @LINE:124
    case controllers_DashboardV3Controller_deleteDashboard89_route(params) =>
      call { 
        controllers_DashboardV3Controller_deleteDashboard89_invoker.call(DashboardV3Controller_4.deleteDashboard())
      }
  
    // @LINE:125
    case controllers_DashboardV3Controller_dashboard90_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("dashboardId", None)) { (id, dashboardId) =>
        controllers_DashboardV3Controller_dashboard90_invoker.call(DashboardV3Controller_4.dashboard(id, dashboardId))
      }
  
    // @LINE:126
    case controllers_DashboardV3Controller_getDashboardWithId91_route(params) =>
      call { 
        controllers_DashboardV3Controller_getDashboardWithId91_invoker.call(DashboardV3Controller_4.getDashboardWithId())
      }
  
    // @LINE:127
    case controllers_DashboardV3Controller_saveDashboard92_route(params) =>
      call { 
        controllers_DashboardV3Controller_saveDashboard92_invoker.call(DashboardV3Controller_4.saveDashboard())
      }
  
    // @LINE:128
    case controllers_DashboardV3Controller_moveDashboardToOrg93_route(params) =>
      call { 
        controllers_DashboardV3Controller_moveDashboardToOrg93_invoker.call(DashboardV3Controller_4.moveDashboardToOrg())
      }
  
    // @LINE:132
    case controllers_TelcoDeviceController_deviceManage94_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoDeviceController_deviceManage94_invoker.call(TelcoDeviceController_31.deviceManage(userId))
      }
  
    // @LINE:135
    case controllers_DashboardAppController_appDashboard95_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("dashboardId", None), params.fromPath[String]("token", None), params.fromQuery[String]("deviceId", Some(null)), params.fromQuery[String]("deviceToken", Some(null))) { (id, dashboardId, token, deviceId, deviceToken) =>
        controllers_DashboardAppController_appDashboard95_invoker.call(DashboardAppController_24.appDashboard(id, dashboardId, token, deviceId, deviceToken))
      }
  
    // @LINE:136
    case controllers_DashboardAppController_getDashboardWithId96_route(params) =>
      call { 
        controllers_DashboardAppController_getDashboardWithId96_invoker.call(DashboardAppController_24.getDashboardWithId())
      }
  
    // @LINE:137
    case controllers_DashboardAppController_getPositionDeviceByAttributeApp97_route(params) =>
      call { 
        controllers_DashboardAppController_getPositionDeviceByAttributeApp97_invoker.call(DashboardAppController_24.getPositionDeviceByAttributeApp())
      }
  
    // @LINE:138
    case controllers_DashboardAppController_getListDeviceWithWidgetMapApp98_route(params) =>
      call { 
        controllers_DashboardAppController_getListDeviceWithWidgetMapApp98_invoker.call(DashboardAppController_24.getListDeviceWithWidgetMapApp())
      }
  
    // @LINE:139
    case controllers_DashboardAppController_getDataAttributeByIdApp99_route(params) =>
      call { 
        controllers_DashboardAppController_getDataAttributeByIdApp99_invoker.call(DashboardAppController_24.getDataAttributeByIdApp())
      }
  
    // @LINE:140
    case controllers_DashboardAppController_getLastValueAttributeApp100_route(params) =>
      call { 
        controllers_DashboardAppController_getLastValueAttributeApp100_invoker.call(DashboardAppController_24.getLastValueAttributeApp())
      }
  
    // @LINE:141
    case controllers_DashboardAppController_sendMessageOnOffApp101_route(params) =>
      call { 
        controllers_DashboardAppController_sendMessageOnOffApp101_invoker.call(DashboardAppController_24.sendMessageOnOffApp())
      }
  
    // @LINE:144
    case controllers_WidgetListController_widgetPage102_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("idDashboard", None)) { (id, idDashboard) =>
        controllers_WidgetListController_widgetPage102_invoker.call(WidgetListController_78.widgetPage(id, idDashboard))
      }
  
    // @LINE:145
    case controllers_WidgetListController_saveWidgetData103_route(params) =>
      call { 
        controllers_WidgetListController_saveWidgetData103_invoker.call(WidgetListController_78.saveWidgetData())
      }
  
    // @LINE:146
    case controllers_WidgetListController_getWidgetCurrent104_route(params) =>
      call { 
        controllers_WidgetListController_getWidgetCurrent104_invoker.call(WidgetListController_78.getWidgetCurrent())
      }
  
    // @LINE:149
    case controllers_DeviceIotController_deviceIotList105_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceIotController_deviceIotList105_invoker.call(DeviceIotController_49.deviceIotList(id))
      }
  
    // @LINE:150
    case controllers_DeviceIotController_addNewDevice106_route(params) =>
      call { 
        controllers_DeviceIotController_addNewDevice106_invoker.call(DeviceIotController_49.addNewDevice())
      }
  
    // @LINE:151
    case controllers_DeviceIotController_createDeviceWithSerialSim107_route(params) =>
      call { 
        controllers_DeviceIotController_createDeviceWithSerialSim107_invoker.call(DeviceIotController_49.createDeviceWithSerialSim())
      }
  
    // @LINE:152
    case controllers_DeviceIotController_deleteDevice108_route(params) =>
      call { 
        controllers_DeviceIotController_deleteDevice108_invoker.call(DeviceIotController_49.deleteDevice())
      }
  
    // @LINE:153
    case controllers_DeviceIotController_editNameDevice109_route(params) =>
      call { 
        controllers_DeviceIotController_editNameDevice109_invoker.call(DeviceIotController_49.editNameDevice())
      }
  
    // @LINE:154
    case controllers_DeviceIotController_updateDevice110_route(params) =>
      call { 
        controllers_DeviceIotController_updateDevice110_invoker.call(DeviceIotController_49.updateDevice())
      }
  
    // @LINE:155
    case controllers_DeviceIotController_configGpsDevice111_route(params) =>
      call { 
        controllers_DeviceIotController_configGpsDevice111_invoker.call(DeviceIotController_49.configGpsDevice())
      }
  
    // @LINE:156
    case controllers_DeviceIotController_getConfigOfDeviceIot112_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceIotController_getConfigOfDeviceIot112_invoker.call(DeviceIotController_49.getConfigOfDeviceIot(id))
      }
  
    // @LINE:157
    case controllers_DeviceIotController_getListDeviceIot113_route(params) =>
      call { 
        controllers_DeviceIotController_getListDeviceIot113_invoker.call(DeviceIotController_49.getListDeviceIot())
      }
  
    // @LINE:158
    case controllers_DeviceIotController_getListDeviceByGroup114_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceIotController_getListDeviceByGroup114_invoker.call(DeviceIotController_49.getListDeviceByGroup(id))
      }
  
    // @LINE:159
    case controllers_DeviceIotController_getListDeviceVarsByDevice115_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceIotController_getListDeviceVarsByDevice115_invoker.call(DeviceIotController_49.getListDeviceVarsByDevice(id))
      }
  
    // @LINE:160
    case controllers_DeviceIotController_getListDeviceByOrg116_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("projectId", None)) { (id, projectId) =>
        controllers_DeviceIotController_getListDeviceByOrg116_invoker.call(DeviceIotController_49.getListDeviceByOrg(id, projectId))
      }
  
    // @LINE:161
    case controllers_DeviceIotController_getListDeviceAndAttrByOrg117_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("projectId", None)) { (id, projectId) =>
        controllers_DeviceIotController_getListDeviceAndAttrByOrg117_invoker.call(DeviceIotController_49.getListDeviceAndAttrByOrg(id, projectId))
      }
  
    // @LINE:162
    case controllers_DeviceIotController_getListDeviceByDeviceType118_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceIotController_getListDeviceByDeviceType118_invoker.call(DeviceIotController_49.getListDeviceByDeviceType(id))
      }
  
    // @LINE:165
    case controllers_AttributeController_attributeDevice119_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("deviceId", None)) { (id, deviceId) =>
        controllers_AttributeController_attributeDevice119_invoker.call(AttributeController_21.attributeDevice(id, deviceId))
      }
  
    // @LINE:166
    case controllers_AttributeController_getAttributeList120_route(params) =>
      call { 
        controllers_AttributeController_getAttributeList120_invoker.call(AttributeController_21.getAttributeList())
      }
  
    // @LINE:167
    case controllers_AttributeController_getAttributeHistory121_route(params) =>
      call { 
        controllers_AttributeController_getAttributeHistory121_invoker.call(AttributeController_21.getAttributeHistory())
      }
  
    // @LINE:169
    case controllers_AttributeController_attributeUser122_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("userId", None)) { (id, userId) =>
        controllers_AttributeController_attributeUser122_invoker.call(AttributeController_21.attributeUser(id, userId))
      }
  
    // @LINE:170
    case controllers_AttributeController_attributeEvent123_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("eventId", None)) { (id, eventId) =>
        controllers_AttributeController_attributeEvent123_invoker.call(AttributeController_21.attributeEvent(id, eventId))
      }
  
    // @LINE:171
    case controllers_AttributeController_attributeTemplate124_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("templateId", None)) { (id, templateId) =>
        controllers_AttributeController_attributeTemplate124_invoker.call(AttributeController_21.attributeTemplate(id, templateId))
      }
  
    // @LINE:172
    case controllers_AttributeController_attributeGroup125_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("groupId", None)) { (id, groupId) =>
        controllers_AttributeController_attributeGroup125_invoker.call(AttributeController_21.attributeGroup(id, groupId))
      }
  
    // @LINE:175
    case controllers_DeviceVariableController_deviceVariable126_route(params) =>
      call(params.fromPath[String]("projectId", None), params.fromPath[String]("id", None)) { (projectId, id) =>
        controllers_DeviceVariableController_deviceVariable126_invoker.call(DeviceVariableController_50.deviceVariable(projectId, id))
      }
  
    // @LINE:176
    case controllers_DeviceVariableController_addVariable127_route(params) =>
      call { 
        controllers_DeviceVariableController_addVariable127_invoker.call(DeviceVariableController_50.addVariable())
      }
  
    // @LINE:177
    case controllers_DeviceVariableController_delVariable128_route(params) =>
      call { 
        controllers_DeviceVariableController_delVariable128_invoker.call(DeviceVariableController_50.delVariable())
      }
  
    // @LINE:178
    case controllers_DeviceVariableController_getDataVariableById129_route(params) =>
      call { 
        controllers_DeviceVariableController_getDataVariableById129_invoker.call(DeviceVariableController_50.getDataVariableById())
      }
  
    // @LINE:179
    case controllers_DeviceVariableController_getListVarByIdDevice130_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceVariableController_getListVarByIdDevice130_invoker.call(DeviceVariableController_50.getListVarByIdDevice(id))
      }
  
    // @LINE:182
    case controllers_AttributeController_addAttribute131_route(params) =>
      call { 
        controllers_AttributeController_addAttribute131_invoker.call(AttributeController_21.addAttribute())
      }
  
    // @LINE:183
    case controllers_AttributeController_deleteAttributeOrg132_route(params) =>
      call { 
        controllers_AttributeController_deleteAttributeOrg132_invoker.call(AttributeController_21.deleteAttributeOrg())
      }
  
    // @LINE:184
    case controllers_AttributeController_editAttributeOrg133_route(params) =>
      call { 
        controllers_AttributeController_editAttributeOrg133_invoker.call(AttributeController_21.editAttributeOrg())
      }
  
    // @LINE:185
    case controllers_AttributeController_getDataAttributeById134_route(params) =>
      call { 
        controllers_AttributeController_getDataAttributeById134_invoker.call(AttributeController_21.getDataAttributeById())
      }
  
    // @LINE:186
    case controllers_AttributeController_getLastValueAttribute135_route(params) =>
      call { 
        controllers_AttributeController_getLastValueAttribute135_invoker.call(AttributeController_21.getLastValueAttribute())
      }
  
    // @LINE:187
    case controllers_AttributeController_getPositionDeviceByAttribute136_route(params) =>
      call { 
        controllers_AttributeController_getPositionDeviceByAttribute136_invoker.call(AttributeController_21.getPositionDeviceByAttribute())
      }
  
    // @LINE:188
    case controllers_AttributeController_getValueAttributeWithTime137_route(params) =>
      call { 
        controllers_AttributeController_getValueAttributeWithTime137_invoker.call(AttributeController_21.getValueAttributeWithTime())
      }
  
    // @LINE:191
    case controllers_MessagesDeviceController_messagesDevice138_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MessagesDeviceController_messagesDevice138_invoker.call(MessagesDeviceController_41.messagesDevice(id))
      }
  
    // @LINE:192
    case controllers_MessagesDeviceController_getMetadata139_route(params) =>
      call { 
        controllers_MessagesDeviceController_getMetadata139_invoker.call(MessagesDeviceController_41.getMetadata())
      }
  
    // @LINE:193
    case controllers_MessagesDeviceController_sendMetadata140_route(params) =>
      call { 
        controllers_MessagesDeviceController_sendMetadata140_invoker.call(MessagesDeviceController_41.sendMetadata())
      }
  
    // @LINE:194
    case controllers_MessagesDeviceController_sendMessageToDevice141_route(params) =>
      call { 
        controllers_MessagesDeviceController_sendMessageToDevice141_invoker.call(MessagesDeviceController_41.sendMessageToDevice())
      }
  
    // @LINE:195
    case controllers_MessagesDeviceController_getMessageFormDevice142_route(params) =>
      call { 
        controllers_MessagesDeviceController_getMessageFormDevice142_invoker.call(MessagesDeviceController_41.getMessageFormDevice())
      }
  
    // @LINE:196
    case controllers_MessagesDeviceController_postCreateDeviceToken143_route(params) =>
      call { 
        controllers_MessagesDeviceController_postCreateDeviceToken143_invoker.call(MessagesDeviceController_41.postCreateDeviceToken())
      }
  
    // @LINE:197
    case controllers_MessagesDeviceController_sendMessageData144_route(params) =>
      call { 
        controllers_MessagesDeviceController_sendMessageData144_invoker.call(MessagesDeviceController_41.sendMessageData())
      }
  
    // @LINE:198
    case controllers_MessagesDeviceController_sendMessageOnOff145_route(params) =>
      call { 
        controllers_MessagesDeviceController_sendMessageOnOff145_invoker.call(MessagesDeviceController_41.sendMessageOnOff())
      }
  
    // @LINE:199
    case controllers_MessagesDeviceController_sendMessageOnOffApp146_route(params) =>
      call { 
        controllers_MessagesDeviceController_sendMessageOnOffApp146_invoker.call(MessagesDeviceController_41.sendMessageOnOffApp())
      }
  
    // @LINE:200
    case controllers_MessagesDeviceController_sendCommandRPC147_route(params) =>
      call { 
        controllers_MessagesDeviceController_sendCommandRPC147_invoker.call(MessagesDeviceController_41.sendCommandRPC())
      }
  
    // @LINE:203
    case controllers_LogDeviceController_logDeviceList148_route(params) =>
      call { 
        controllers_LogDeviceController_logDeviceList148_invoker.call(LogDeviceController_43.logDeviceList())
      }
  
    // @LINE:204
    case controllers_LogDeviceController_getAllLogMessage149_route(params) =>
      call { 
        controllers_LogDeviceController_getAllLogMessage149_invoker.call(LogDeviceController_43.getAllLogMessage())
      }
  
    // @LINE:207
    case controllers_DeviceTypeController_deviceTypeList150_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceTypeController_deviceTypeList150_invoker.call(DeviceTypeController_64.deviceTypeList(id))
      }
  
    // @LINE:208
    case controllers_DeviceTypeController_addNewDeviceType151_route(params) =>
      call { 
        controllers_DeviceTypeController_addNewDeviceType151_invoker.call(DeviceTypeController_64.addNewDeviceType())
      }
  
    // @LINE:209
    case controllers_DeviceTypeController_deleteDeviceType152_route(params) =>
      call { 
        controllers_DeviceTypeController_deleteDeviceType152_invoker.call(DeviceTypeController_64.deleteDeviceType())
      }
  
    // @LINE:210
    case controllers_DeviceTypeController_editDeviceType153_route(params) =>
      call { 
        controllers_DeviceTypeController_editDeviceType153_invoker.call(DeviceTypeController_64.editDeviceType())
      }
  
    // @LINE:211
    case controllers_DeviceTypeController_getListTypes154_route(params) =>
      call { 
        controllers_DeviceTypeController_getListTypes154_invoker.call(DeviceTypeController_64.getListTypes())
      }
  
    // @LINE:214
    case controllers_DeviceTemplateController_deviceTemplate155_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DeviceTemplateController_deviceTemplate155_invoker.call(DeviceTemplateController_51.deviceTemplate(id))
      }
  
    // @LINE:215
    case controllers_DeviceTemplateController_createDeviceTemplate156_route(params) =>
      call { 
        controllers_DeviceTemplateController_createDeviceTemplate156_invoker.call(DeviceTemplateController_51.createDeviceTemplate())
      }
  
    // @LINE:216
    case controllers_DeviceTemplateController_getListDeviceTemplate157_route(params) =>
      call { 
        controllers_DeviceTemplateController_getListDeviceTemplate157_invoker.call(DeviceTemplateController_51.getListDeviceTemplate())
      }
  
    // @LINE:217
    case controllers_DeviceTemplateController_deleteDeviceTemplate158_route(params) =>
      call { 
        controllers_DeviceTemplateController_deleteDeviceTemplate158_invoker.call(DeviceTemplateController_51.deleteDeviceTemplate())
      }
  
    // @LINE:218
    case controllers_DeviceTemplateController_createTemDevice159_route(params) =>
      call { 
        controllers_DeviceTemplateController_createTemDevice159_invoker.call(DeviceTemplateController_51.createTemDevice())
      }
  
    // @LINE:221
    case controllers_FlowEngineController_getListFlow160_route(params) =>
      call { 
        controllers_FlowEngineController_getListFlow160_invoker.call(FlowEngineController_74.getListFlow())
      }
  
    // @LINE:222
    case controllers_FlowEngineController_addFlow161_route(params) =>
      call { 
        controllers_FlowEngineController_addFlow161_invoker.call(FlowEngineController_74.addFlow())
      }
  
    // @LINE:225
    case controllers_OrginazationController_orginazationView162_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OrginazationController_orginazationView162_invoker.call(OrginazationController_66.orginazationView(id))
      }
  
    // @LINE:227
    case controllers_GroupController_orgList163_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_GroupController_orgList163_invoker.call(GroupController_77.orgList(id))
      }
  
    // @LINE:228
    case controllers_GroupController_getInfoOrg164_route(params) =>
      call { 
        controllers_GroupController_getInfoOrg164_invoker.call(GroupController_77.getInfoOrg())
      }
  
    // @LINE:229
    case controllers_GroupController_getAttributeOrg165_route(params) =>
      call { 
        controllers_GroupController_getAttributeOrg165_invoker.call(GroupController_77.getAttributeOrg())
      }
  
    // @LINE:230
    case controllers_GroupController_getGroupChildByGroupId166_route(params) =>
      call { 
        controllers_GroupController_getGroupChildByGroupId166_invoker.call(GroupController_77.getGroupChildByGroupId())
      }
  
    // @LINE:231
    case controllers_GroupController_getListGroupOfOrg167_route(params) =>
      call { 
        controllers_GroupController_getListGroupOfOrg167_invoker.call(GroupController_77.getListGroupOfOrg())
      }
  
    // @LINE:232
    case controllers_GroupController_getListUserOfOrg168_route(params) =>
      call { 
        controllers_GroupController_getListUserOfOrg168_invoker.call(GroupController_77.getListUserOfOrg())
      }
  
    // @LINE:233
    case controllers_GroupController_getListDeviceOfOrg169_route(params) =>
      call { 
        controllers_GroupController_getListDeviceOfOrg169_invoker.call(GroupController_77.getListDeviceOfOrg())
      }
  
    // @LINE:234
    case controllers_GroupController_getListEventOfOrg170_route(params) =>
      call { 
        controllers_GroupController_getListEventOfOrg170_invoker.call(GroupController_77.getListEventOfOrg())
      }
  
    // @LINE:235
    case controllers_GroupController_getListRoleOfOrg171_route(params) =>
      call { 
        controllers_GroupController_getListRoleOfOrg171_invoker.call(GroupController_77.getListRoleOfOrg())
      }
  
    // @LINE:236
    case controllers_GroupController_updateGroup172_route(params) =>
      call { 
        controllers_GroupController_updateGroup172_invoker.call(GroupController_77.updateGroup())
      }
  
    // @LINE:237
    case controllers_GroupController_deleteGroup173_route(params) =>
      call { 
        controllers_GroupController_deleteGroup173_invoker.call(GroupController_77.deleteGroup())
      }
  
    // @LINE:238
    case controllers_GroupController_updateRoleToGroupUser174_route(params) =>
      call { 
        controllers_GroupController_updateRoleToGroupUser174_invoker.call(GroupController_77.updateRoleToGroupUser())
      }
  
    // @LINE:239
    case controllers_GroupController_updateUserToGroupDevice175_route(params) =>
      call { 
        controllers_GroupController_updateUserToGroupDevice175_invoker.call(GroupController_77.updateUserToGroupDevice())
      }
  
    // @LINE:240
    case controllers_GroupController_addGroupRoot176_route(params) =>
      call { 
        controllers_GroupController_addGroupRoot176_invoker.call(GroupController_77.addGroupRoot())
      }
  
    // @LINE:241
    case controllers_GroupController_getListOrganizations177_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_GroupController_getListOrganizations177_invoker.call(GroupController_77.getListOrganizations(id))
      }
  
    // @LINE:242
    case controllers_GroupController_processMoveUserToGroupOther178_route(params) =>
      call { 
        controllers_GroupController_processMoveUserToGroupOther178_invoker.call(GroupController_77.processMoveUserToGroupOther())
      }
  
    // @LINE:243
    case controllers_GroupController_processMoveDeviceToGroupOther179_route(params) =>
      call { 
        controllers_GroupController_processMoveDeviceToGroupOther179_invoker.call(GroupController_77.processMoveDeviceToGroupOther())
      }
  
    // @LINE:244
    case controllers_GroupController_createUserInOrg180_route(params) =>
      call { 
        controllers_GroupController_createUserInOrg180_invoker.call(GroupController_77.createUserInOrg())
      }
  
    // @LINE:245
    case controllers_GroupController_updateRoleForUser181_route(params) =>
      call { 
        controllers_GroupController_updateRoleForUser181_invoker.call(GroupController_77.updateRoleForUser())
      }
  
    // @LINE:248
    case controllers_GroupListController_groupsList182_route(params) =>
      call { 
        controllers_GroupListController_groupsList182_invoker.call(GroupListController_68.groupsList())
      }
  
    // @LINE:249
    case controllers_GroupListController_addNewGroups183_route(params) =>
      call { 
        controllers_GroupListController_addNewGroups183_invoker.call(GroupListController_68.addNewGroups())
      }
  
    // @LINE:250
    case controllers_GroupListController_deleteGroup184_route(params) =>
      call { 
        controllers_GroupListController_deleteGroup184_invoker.call(GroupListController_68.deleteGroup())
      }
  
    // @LINE:251
    case controllers_GroupListController_editNameGroups185_route(params) =>
      call { 
        controllers_GroupListController_editNameGroups185_invoker.call(GroupListController_68.editNameGroups())
      }
  
    // @LINE:252
    case controllers_GroupListController_updateOrgIdForGroups186_route(params) =>
      call { 
        controllers_GroupListController_updateOrgIdForGroups186_invoker.call(GroupListController_68.updateOrgIdForGroups())
      }
  
    // @LINE:253
    case controllers_GroupListController_getListGroups187_route(params) =>
      call { 
        controllers_GroupListController_getListGroups187_invoker.call(GroupListController_68.getListGroups())
      }
  
    // @LINE:254
    case controllers_GroupListController_getGroupWithEntityType188_route(params) =>
      call { 
        controllers_GroupListController_getGroupWithEntityType188_invoker.call(GroupListController_68.getGroupWithEntityType())
      }
  
    // @LINE:255
    case controllers_GroupListController_getListGroupUser189_route(params) =>
      call { 
        controllers_GroupListController_getListGroupUser189_invoker.call(GroupListController_68.getListGroupUser())
      }
  
    // @LINE:256
    case controllers_GroupListController_getListGroupDevice190_route(params) =>
      call { 
        controllers_GroupListController_getListGroupDevice190_invoker.call(GroupListController_68.getListGroupDevice())
      }
  
    // @LINE:257
    case controllers_GroupListController_getListGroupEvent191_route(params) =>
      call { 
        controllers_GroupListController_getListGroupEvent191_invoker.call(GroupListController_68.getListGroupEvent())
      }
  
    // @LINE:258
    case controllers_GroupListController_getListGroupOrganization192_route(params) =>
      call { 
        controllers_GroupListController_getListGroupOrganization192_invoker.call(GroupListController_68.getListGroupOrganization())
      }
  
    // @LINE:261
    case controllers_HomeController_pageTestApi193_route(params) =>
      call { 
        controllers_HomeController_pageTestApi193_invoker.call(HomeController_10.pageTestApi())
      }
  
    // @LINE:262
    case controllers_HomeController_testPostFormUrlencoded194_route(params) =>
      call { 
        controllers_HomeController_testPostFormUrlencoded194_invoker.call(HomeController_10.testPostFormUrlencoded())
      }
  
    // @LINE:263
    case controllers_HomeController_testPostJson195_route(params) =>
      call { 
        controllers_HomeController_testPostJson195_invoker.call(HomeController_10.testPostJson())
      }
  
    // @LINE:264
    case controllers_HomeController_testGetByToken196_route(params) =>
      call { 
        controllers_HomeController_testGetByToken196_invoker.call(HomeController_10.testGetByToken())
      }
  
    // @LINE:265
    case controllers_HomeController_getDashboardByIdOrg197_route(params) =>
      call { 
        controllers_HomeController_getDashboardByIdOrg197_invoker.call(HomeController_10.getDashboardByIdOrg())
      }
  
    // @LINE:266
    case controllers_HomeController_getDashboardByProjectId198_route(params) =>
      call { 
        controllers_HomeController_getDashboardByProjectId198_invoker.call(HomeController_10.getDashboardByProjectId())
      }
  
    // @LINE:269
    case controllers_RoleController_roleList199_route(params) =>
      call { 
        controllers_RoleController_roleList199_invoker.call(RoleController_25.roleList())
      }
  
    // @LINE:270
    case controllers_RoleController_addNewRole200_route(params) =>
      call { 
        controllers_RoleController_addNewRole200_invoker.call(RoleController_25.addNewRole())
      }
  
    // @LINE:271
    case controllers_RoleController_deleteRole201_route(params) =>
      call { 
        controllers_RoleController_deleteRole201_invoker.call(RoleController_25.deleteRole())
      }
  
    // @LINE:272
    case controllers_RoleController_getRole202_route(params) =>
      call { 
        controllers_RoleController_getRole202_invoker.call(RoleController_25.getRole())
      }
  
    // @LINE:273
    case controllers_RoleController_updateRole203_route(params) =>
      call { 
        controllers_RoleController_updateRole203_invoker.call(RoleController_25.updateRole())
      }
  
    // @LINE:276
    case controllers_EventController_eventList204_route(params) =>
      call { 
        controllers_EventController_eventList204_invoker.call(EventController_65.eventList())
      }
  
    // @LINE:277
    case controllers_EventController_addNewEvent205_route(params) =>
      call { 
        controllers_EventController_addNewEvent205_invoker.call(EventController_65.addNewEvent())
      }
  
    // @LINE:278
    case controllers_EventController_addNewSchedule206_route(params) =>
      call { 
        controllers_EventController_addNewSchedule206_invoker.call(EventController_65.addNewSchedule())
      }
  
    // @LINE:279
    case controllers_EventController_editEvent207_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_EventController_editEvent207_invoker.call(EventController_65.editEvent(id))
      }
  
    // @LINE:280
    case controllers_EventController_editSchedule208_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_EventController_editSchedule208_invoker.call(EventController_65.editSchedule(id))
      }
  
    // @LINE:281
    case controllers_EventController_onclickEvent209_route(params) =>
      call { 
        controllers_EventController_onclickEvent209_invoker.call(EventController_65.onclickEvent())
      }
  
    // @LINE:282
    case controllers_EventController_getVarsByDevice210_route(params) =>
      call { 
        controllers_EventController_getVarsByDevice210_invoker.call(EventController_65.getVarsByDevice())
      }
  
    // @LINE:283
    case controllers_EventController_deleteEvent211_route(params) =>
      call { 
        controllers_EventController_deleteEvent211_invoker.call(EventController_65.deleteEvent())
      }
  
    // @LINE:284
    case controllers_EventController_getEvent212_route(params) =>
      call { 
        controllers_EventController_getEvent212_invoker.call(EventController_65.getEvent())
      }
  
    // @LINE:285
    case controllers_EventController_updateEvent213_route(params) =>
      call { 
        controllers_EventController_updateEvent213_invoker.call(EventController_65.updateEvent())
      }
  
    // @LINE:286
    case controllers_EventController_changeEventOrg214_route(params) =>
      call { 
        controllers_EventController_changeEventOrg214_invoker.call(EventController_65.changeEventOrg())
      }
  
    // @LINE:287
    case controllers_EventController_removeEventOrg215_route(params) =>
      call { 
        controllers_EventController_removeEventOrg215_invoker.call(EventController_65.removeEventOrg())
      }
  
    // @LINE:288
    case controllers_EventController_activeEvent216_route(params) =>
      call { 
        controllers_EventController_activeEvent216_invoker.call(EventController_65.activeEvent())
      }
  
    // @LINE:289
    case controllers_EventController_deActiveEvent217_route(params) =>
      call { 
        controllers_EventController_deActiveEvent217_invoker.call(EventController_65.deActiveEvent())
      }
  
    // @LINE:292
    case controllers_RuleChainController_ruleChain218_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_RuleChainController_ruleChain218_invoker.call(RuleChainController_16.ruleChain(id))
      }
  
    // @LINE:293
    case controllers_RuleChainController_flowEngineWithId219_route(params) =>
      call(params.fromPath[String]("projectId", None), params.fromPath[String]("idFlow", None)) { (projectId, idFlow) =>
        controllers_RuleChainController_flowEngineWithId219_invoker.call(RuleChainController_16.flowEngineWithId(projectId, idFlow))
      }
  
    // @LINE:296
    case controllers_PayPackDataController_packData220_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PayPackDataController_packData220_invoker.call(PayPackDataController_45.packData(id))
      }
  
    // @LINE:297
    case controllers_PayPackDataController_getListPackdata221_route(params) =>
      call { 
        controllers_PayPackDataController_getListPackdata221_invoker.call(PayPackDataController_45.getListPackdata())
      }
  
    // @LINE:298
    case controllers_PayPackDataController_addNewPackdata222_route(params) =>
      call { 
        controllers_PayPackDataController_addNewPackdata222_invoker.call(PayPackDataController_45.addNewPackdata())
      }
  
    // @LINE:299
    case controllers_PayPackDataController_getInfoPackdata223_route(params) =>
      call { 
        controllers_PayPackDataController_getInfoPackdata223_invoker.call(PayPackDataController_45.getInfoPackdata())
      }
  
    // @LINE:300
    case controllers_PayPackDataController_editPackdata224_route(params) =>
      call { 
        controllers_PayPackDataController_editPackdata224_invoker.call(PayPackDataController_45.editPackdata())
      }
  
    // @LINE:301
    case controllers_PayPackDataController_deletePackdata225_route(params) =>
      call { 
        controllers_PayPackDataController_deletePackdata225_invoker.call(PayPackDataController_45.deletePackdata())
      }
  
    // @LINE:302
    case controllers_PayCustomerController_getInfoVendor226_route(params) =>
      call { 
        controllers_PayCustomerController_getInfoVendor226_invoker.call(PayCustomerController_52.getInfoVendor())
      }
  
    // @LINE:303
    case controllers_PayCustomerController_createVendor227_route(params) =>
      call { 
        controllers_PayCustomerController_createVendor227_invoker.call(PayCustomerController_52.createVendor())
      }
  
    // @LINE:304
    case controllers_PayCustomerController_updateVendor228_route(params) =>
      call { 
        controllers_PayCustomerController_updateVendor228_invoker.call(PayCustomerController_52.updateVendor())
      }
  
    // @LINE:305
    case controllers_PayCustomerController_getSubscription229_route(params) =>
      call { 
        controllers_PayCustomerController_getSubscription229_invoker.call(PayCustomerController_52.getSubscription())
      }
  
    // @LINE:306
    case controllers_PayCustomerController_createSubscription230_route(params) =>
      call { 
        controllers_PayCustomerController_createSubscription230_invoker.call(PayCustomerController_52.createSubscription())
      }
  
    // @LINE:307
    case controllers_PayCustomerController_cancelSubscription231_route(params) =>
      call { 
        controllers_PayCustomerController_cancelSubscription231_invoker.call(PayCustomerController_52.cancelSubscription())
      }
  
    // @LINE:309
    case controllers_PayCustomerController_payCustomer232_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PayCustomerController_payCustomer232_invoker.call(PayCustomerController_52.payCustomer(id))
      }
  
    // @LINE:310
    case controllers_PayCustomerController_payment233_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("userId", None)) { (id, userId) =>
        controllers_PayCustomerController_payment233_invoker.call(PayCustomerController_52.payment(id, userId))
      }
  
    // @LINE:311
    case controllers_PayCustomerController_getListUserInOrg234_route(params) =>
      call { 
        controllers_PayCustomerController_getListUserInOrg234_invoker.call(PayCustomerController_52.getListUserInOrg())
      }
  
    // @LINE:312
    case controllers_PayCustomerController_addPackdataNewForUser235_route(params) =>
      call { 
        controllers_PayCustomerController_addPackdataNewForUser235_invoker.call(PayCustomerController_52.addPackdataNewForUser())
      }
  
    // @LINE:313
    case controllers_PayCustomerController_postPricingOfCustomer236_route(params) =>
      call { 
        controllers_PayCustomerController_postPricingOfCustomer236_invoker.call(PayCustomerController_52.postPricingOfCustomer())
      }
  
    // @LINE:314
    case controllers_PayCustomerController_getInfoCustomer237_route(params) =>
      call { 
        controllers_PayCustomerController_getInfoCustomer237_invoker.call(PayCustomerController_52.getInfoCustomer())
      }
  
    // @LINE:315
    case controllers_PayCustomerController_createInfoCustomer238_route(params) =>
      call { 
        controllers_PayCustomerController_createInfoCustomer238_invoker.call(PayCustomerController_52.createInfoCustomer())
      }
  
    // @LINE:316
    case controllers_PayCustomerController_updateInfoCustomer239_route(params) =>
      call { 
        controllers_PayCustomerController_updateInfoCustomer239_invoker.call(PayCustomerController_52.updateInfoCustomer())
      }
  
    // @LINE:318
    case controllers_PayBillController_billList240_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PayBillController_billList240_invoker.call(PayBillController_61.billList(id))
      }
  
    // @LINE:319
    case controllers_PayBillController_getAllBill241_route(params) =>
      call { 
        controllers_PayBillController_getAllBill241_invoker.call(PayBillController_61.getAllBill())
      }
  
    // @LINE:320
    case controllers_PayBillController_getLinkPayment242_route(params) =>
      call { 
        controllers_PayBillController_getLinkPayment242_invoker.call(PayBillController_61.getLinkPayment())
      }
  
    // @LINE:321
    case controllers_PayBillController_getInfoBill243_route(params) =>
      call { 
        controllers_PayBillController_getInfoBill243_invoker.call(PayBillController_61.getInfoBill())
      }
  
    // @LINE:322
    case controllers_PayBillController_billUserList244_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("userId", None)) { (id, userId) =>
        controllers_PayBillController_billUserList244_invoker.call(PayBillController_61.billUserList(id, userId))
      }
  
    // @LINE:323
    case controllers_PayBillController_getBillOfUser245_route(params) =>
      call { 
        controllers_PayBillController_getBillOfUser245_invoker.call(PayBillController_61.getBillOfUser())
      }
  
    // @LINE:325
    case controllers_PaySubsController_subsList246_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PaySubsController_subsList246_invoker.call(PaySubsController_33.subsList(id))
      }
  
    // @LINE:326
    case controllers_PaySubsController_getAllSubs247_route(params) =>
      call { 
        controllers_PaySubsController_getAllSubs247_invoker.call(PaySubsController_33.getAllSubs())
      }
  
    // @LINE:327
    case controllers_PaySubsController_getInfoSub248_route(params) =>
      call { 
        controllers_PaySubsController_getInfoSub248_invoker.call(PaySubsController_33.getInfoSub())
      }
  
    // @LINE:328
    case controllers_PaySubsController_getLinkPaymentSub249_route(params) =>
      call { 
        controllers_PaySubsController_getLinkPaymentSub249_invoker.call(PaySubsController_33.getLinkPaymentSub())
      }
  
    // @LINE:330
    case controllers_ManageSimController_manageSim250_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ManageSimController_manageSim250_invoker.call(ManageSimController_26.manageSim(id))
      }
  
    // @LINE:331
    case controllers_ManageSimController_getDataCustomer251_route(params) =>
      call { 
        controllers_ManageSimController_getDataCustomer251_invoker.call(ManageSimController_26.getDataCustomer())
      }
  
    // @LINE:332
    case controllers_ManageSimController_detailSim252_route(params) =>
      call(params.fromPath[String]("projectId", None), params.fromPath[String]("simnb", None)) { (projectId, simnb) =>
        controllers_ManageSimController_detailSim252_invoker.call(ManageSimController_26.detailSim(projectId, simnb))
      }
  
    // @LINE:335
    case controllers_DevkitController_devkit253_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_DevkitController_devkit253_invoker.call(DevkitController_15.devkit(id))
      }
  
    // @LINE:337
    case controllers_ModuleController_module254_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ModuleController_module254_invoker.call(ModuleController_72.module(id))
      }
  
    // @LINE:340
    case controllers_AppDebugController_appDebug255_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AppDebugController_appDebug255_invoker.call(AppDebugController_23.appDebug(id))
      }
  
    // @LINE:341
    case controllers_AppDebugController_appDebugPage256_route(params) =>
      call { 
        controllers_AppDebugController_appDebugPage256_invoker.call(AppDebugController_23.appDebugPage())
      }
  
    // @LINE:342
    case controllers_AppDebugController_appSdk257_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AppDebugController_appSdk257_invoker.call(AppDebugController_23.appSdk(id))
      }
  
    // @LINE:343
    case controllers_AppDebugController_appSdkPage258_route(params) =>
      call { 
        controllers_AppDebugController_appSdkPage258_invoker.call(AppDebugController_23.appSdkPage())
      }
  
    // @LINE:344
    case controllers_AppDebugController_solutionMaketPage259_route(params) =>
      call { 
        controllers_AppDebugController_solutionMaketPage259_invoker.call(AppDebugController_23.solutionMaketPage())
      }
  
    // @LINE:348
    case controllers_QrCodeController_qrCodeList260_route(params) =>
      call { 
        controllers_QrCodeController_qrCodeList260_invoker.call(QrCodeController_0.qrCodeList())
      }
  
    // @LINE:349
    case controllers_QrCodeController_createQrCode261_route(params) =>
      call { 
        controllers_QrCodeController_createQrCode261_invoker.call(QrCodeController_0.createQrCode())
      }
  
    // @LINE:350
    case controllers_QrCodeController_qrCodeImg262_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_QrCodeController_qrCodeImg262_invoker.call(QrCodeController_0.qrCodeImg(id))
      }
  
    // @LINE:351
    case controllers_QrCodeController_getListQrCode263_route(params) =>
      call { 
        controllers_QrCodeController_getListQrCode263_invoker.call(QrCodeController_0.getListQrCode())
      }
  
    // @LINE:352
    case controllers_QrCodeController_deleteQrCode264_route(params) =>
      call { 
        controllers_QrCodeController_deleteQrCode264_invoker.call(QrCodeController_0.deleteQrCode())
      }
  
    // @LINE:353
    case controllers_QrCodeController_qrCodeHistoryList265_route(params) =>
      call { 
        controllers_QrCodeController_qrCodeHistoryList265_invoker.call(QrCodeController_0.qrCodeHistoryList())
      }
  
    // @LINE:354
    case controllers_QrCodeController_editQrCode266_route(params) =>
      call { 
        controllers_QrCodeController_editQrCode266_invoker.call(QrCodeController_0.editQrCode())
      }
  
    // @LINE:356
    case controllers_QrCodeCamController_qrCodeCam267_route(params) =>
      call { 
        controllers_QrCodeCamController_qrCodeCam267_invoker.call(QrCodeCamController_54.qrCodeCam())
      }
  
    // @LINE:357
    case controllers_QrCodeCamController_createQrCodeCam268_route(params) =>
      call { 
        controllers_QrCodeCamController_createQrCodeCam268_invoker.call(QrCodeCamController_54.createQrCodeCam())
      }
  
    // @LINE:358
    case controllers_QrCodeCamController_deleteQrCodeCam269_route(params) =>
      call { 
        controllers_QrCodeCamController_deleteQrCodeCam269_invoker.call(QrCodeCamController_54.deleteQrCodeCam())
      }
  
    // @LINE:361
    case controllers_OAuthController_getLogin270_route(params) =>
      call(params.fromQuery[String]("login_challenge", Some(null))) { (login_challenge) =>
        controllers_OAuthController_getLogin270_invoker.call(OAuthController_9.getLogin(login_challenge))
      }
  
    // @LINE:362
    case controllers_OAuthController_postLogin271_route(params) =>
      call { 
        controllers_OAuthController_postLogin271_invoker.call(OAuthController_9.postLogin())
      }
  
    // @LINE:363
    case controllers_OAuthController_getConsent272_route(params) =>
      call(params.fromQuery[String]("consent_challenge", Some(null))) { (consent_challenge) =>
        controllers_OAuthController_getConsent272_invoker.call(OAuthController_9.getConsent(consent_challenge))
      }
  
    // @LINE:364
    case controllers_OAuthController_postConsent273_route(params) =>
      call { 
        controllers_OAuthController_postConsent273_invoker.call(OAuthController_9.postConsent())
      }
  
    // @LINE:365
    case controllers_OAuthController_callback274_route(params) =>
      call(params.fromQuery[String]("code", Some(null))) { (code) =>
        controllers_OAuthController_callback274_invoker.call(OAuthController_9.callback(code))
      }
  
    // @LINE:369
    case controllers_SolutionTrackingController_monitorMap275_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SolutionTrackingController_monitorMap275_invoker.call(SolutionTrackingController_18.monitorMap(id))
      }
  
    // @LINE:370
    case controllers_SolutionTrackingController_getListGpsDevice276_route(params) =>
      call { 
        controllers_SolutionTrackingController_getListGpsDevice276_invoker.call(SolutionTrackingController_18.getListGpsDevice())
      }
  
    // @LINE:371
    case controllers_SolutionTrackingController_getInfoDevice277_route(params) =>
      call { 
        controllers_SolutionTrackingController_getInfoDevice277_invoker.call(SolutionTrackingController_18.getInfoDevice())
      }
  
    // @LINE:372
    case controllers_SolutionTrackingController_historyMap278_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SolutionTrackingController_historyMap278_invoker.call(SolutionTrackingController_18.historyMap(id))
      }
  
    // @LINE:373
    case controllers_SolutionTrackingController_loadLocationHistory279_route(params) =>
      call { 
        controllers_SolutionTrackingController_loadLocationHistory279_invoker.call(SolutionTrackingController_18.loadLocationHistory())
      }
  
    // @LINE:376
    case controllers_WaterClockController_waterClock280_route(params) =>
      call { 
        controllers_WaterClockController_waterClock280_invoker.call(WaterClockController_20.waterClock())
      }
  
    // @LINE:377
    case controllers_WaterClockController_getListClock281_route(params) =>
      call { 
        controllers_WaterClockController_getListClock281_invoker.call(WaterClockController_20.getListClock())
      }
  
    // @LINE:378
    case controllers_WaterClockController_getHistoryClock282_route(params) =>
      call { 
        controllers_WaterClockController_getHistoryClock282_invoker.call(WaterClockController_20.getHistoryClock())
      }
  
    // @LINE:381
    case controllers_TemplateDeviceController_templateDeviceList283_route(params) =>
      call { 
        controllers_TemplateDeviceController_templateDeviceList283_invoker.call(TemplateDeviceController_7.templateDeviceList())
      }
  
    // @LINE:382
    case controllers_TemplateDeviceController_addTemplateDevice284_route(params) =>
      call { 
        controllers_TemplateDeviceController_addTemplateDevice284_invoker.call(TemplateDeviceController_7.addTemplateDevice())
      }
  
    // @LINE:383
    case controllers_TemplateDeviceController_getListTemplateDevice285_route(params) =>
      call { 
        controllers_TemplateDeviceController_getListTemplateDevice285_invoker.call(TemplateDeviceController_7.getListTemplateDevice())
      }
  
    // @LINE:384
    case controllers_TemplateDeviceController_getTemplateDeviceById286_route(params) =>
      call { 
        controllers_TemplateDeviceController_getTemplateDeviceById286_invoker.call(TemplateDeviceController_7.getTemplateDeviceById())
      }
  
    // @LINE:385
    case controllers_TemplateDeviceController_editTemplateDevice287_route(params) =>
      call { 
        controllers_TemplateDeviceController_editTemplateDevice287_invoker.call(TemplateDeviceController_7.editTemplateDevice())
      }
  
    // @LINE:386
    case controllers_TemplateDeviceController_deleteTemplateDevice288_route(params) =>
      call { 
        controllers_TemplateDeviceController_deleteTemplateDevice288_invoker.call(TemplateDeviceController_7.deleteTemplateDevice())
      }
  
    // @LINE:388
    case controllers_AdminOverviewController_adminOverview289_route(params) =>
      call { 
        controllers_AdminOverviewController_adminOverview289_invoker.call(AdminOverviewController_46.adminOverview())
      }
  
    // @LINE:389
    case controllers_AdminOverviewController_getTotalOverview290_route(params) =>
      call { 
        controllers_AdminOverviewController_getTotalOverview290_invoker.call(AdminOverviewController_46.getTotalOverview())
      }
  
    // @LINE:390
    case controllers_AdminOverviewController_postJsonTotalOverview291_route(params) =>
      call { 
        controllers_AdminOverviewController_postJsonTotalOverview291_invoker.call(AdminOverviewController_46.postJsonTotalOverview())
      }
  
    // @LINE:391
    case controllers_AdminOverviewController_getInfoOVerviewSmarthome292_route(params) =>
      call { 
        controllers_AdminOverviewController_getInfoOVerviewSmarthome292_invoker.call(AdminOverviewController_46.getInfoOVerviewSmarthome())
      }
  
    // @LINE:392
    case controllers_AdminOverviewController_getInfoOVerviewVtag293_route(params) =>
      call { 
        controllers_AdminOverviewController_getInfoOVerviewVtag293_invoker.call(AdminOverviewController_46.getInfoOVerviewVtag())
      }
  
    // @LINE:393
    case controllers_AdminOverviewController_getInfoOVerviewFleet294_route(params) =>
      call { 
        controllers_AdminOverviewController_getInfoOVerviewFleet294_invoker.call(AdminOverviewController_46.getInfoOVerviewFleet())
      }
  
    // @LINE:394
    case controllers_AdminOverviewController_getInfoOVerviewMetter295_route(params) =>
      call { 
        controllers_AdminOverviewController_getInfoOVerviewMetter295_invoker.call(AdminOverviewController_46.getInfoOVerviewMetter())
      }
  
    // @LINE:395
    case controllers_AdminOverviewController_getListProjectWithPaging296_route(params) =>
      call { 
        controllers_AdminOverviewController_getListProjectWithPaging296_invoker.call(AdminOverviewController_46.getListProjectWithPaging())
      }
  
    // @LINE:397
    case controllers_AdminManageSimController_adminManageSim297_route(params) =>
      call { 
        controllers_AdminManageSimController_adminManageSim297_invoker.call(AdminManageSimController_39.adminManageSim())
      }
  
    // @LINE:398
    case controllers_AdminManageSimController_getAllProjectWithPaging298_route(params) =>
      call { 
        controllers_AdminManageSimController_getAllProjectWithPaging298_invoker.call(AdminManageSimController_39.getAllProjectWithPaging())
      }
  
    // @LINE:399
    case controllers_AdminManageSimController_getListDeviceWithProjectId299_route(params) =>
      call { 
        controllers_AdminManageSimController_getListDeviceWithProjectId299_invoker.call(AdminManageSimController_39.getListDeviceWithProjectId())
      }
  
    // @LINE:400
    case controllers_AdminManageSimController_getAttrSimDevice300_route(params) =>
      call { 
        controllers_AdminManageSimController_getAttrSimDevice300_invoker.call(AdminManageSimController_39.getAttrSimDevice())
      }
  
    // @LINE:402
    case controllers_AdminSystemHealthController_systemHealth301_route(params) =>
      call { 
        controllers_AdminSystemHealthController_systemHealth301_invoker.call(AdminSystemHealthController_70.systemHealth())
      }
  
    // @LINE:404
    case controllers_AdminOverviewProjectController_adminOverviewProject302_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdminOverviewProjectController_adminOverviewProject302_invoker.call(AdminOverviewProjectController_37.adminOverviewProject(id))
      }
  
    // @LINE:407
    case controllers_AdminRegisterDeveloperController_registerDeveloperList303_route(params) =>
      call { 
        controllers_AdminRegisterDeveloperController_registerDeveloperList303_invoker.call(AdminRegisterDeveloperController_36.registerDeveloperList())
      }
  
    // @LINE:408
    case controllers_AdminRegisterDeveloperController_registerDeveloperFilterList304_route(params) =>
      call { 
        controllers_AdminRegisterDeveloperController_registerDeveloperFilterList304_invoker.call(AdminRegisterDeveloperController_36.registerDeveloperFilterList())
      }
  
    // @LINE:409
    case controllers_AdminRegisterDeveloperController_exportRegisterDeveloperList305_route(params) =>
      call { 
        controllers_AdminRegisterDeveloperController_exportRegisterDeveloperList305_invoker.call(AdminRegisterDeveloperController_36.exportRegisterDeveloperList())
      }
  
    // @LINE:410
    case controllers_AdminRegisterDeveloperController_deleteRegisterDeveloper306_route(params) =>
      call { 
        controllers_AdminRegisterDeveloperController_deleteRegisterDeveloper306_invoker.call(AdminRegisterDeveloperController_36.deleteRegisterDeveloper())
      }
  
    // @LINE:413
    case controllers_AdminGroupProductController_groupProductList307_route(params) =>
      call { 
        controllers_AdminGroupProductController_groupProductList307_invoker.call(AdminGroupProductController_69.groupProductList())
      }
  
    // @LINE:414
    case controllers_AdminGroupProductController_getListGroupProduct308_route(params) =>
      call { 
        controllers_AdminGroupProductController_getListGroupProduct308_invoker.call(AdminGroupProductController_69.getListGroupProduct())
      }
  
    // @LINE:415
    case controllers_AdminGroupProductController_addGroupProduct309_route(params) =>
      call { 
        controllers_AdminGroupProductController_addGroupProduct309_invoker.call(AdminGroupProductController_69.addGroupProduct())
      }
  
    // @LINE:416
    case controllers_AdminGroupProductController_deleteGroupProduct310_route(params) =>
      call { 
        controllers_AdminGroupProductController_deleteGroupProduct310_invoker.call(AdminGroupProductController_69.deleteGroupProduct())
      }
  
    // @LINE:417
    case controllers_AdminGroupProductController_editGroupProduct311_route(params) =>
      call { 
        controllers_AdminGroupProductController_editGroupProduct311_invoker.call(AdminGroupProductController_69.editGroupProduct())
      }
  
    // @LINE:419
    case controllers_ProductListController_productList312_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProductListController_productList312_invoker.call(ProductListController_60.productList(id))
      }
  
    // @LINE:420
    case controllers_ProductListController_createProduct313_route(params) =>
      call { 
        controllers_ProductListController_createProduct313_invoker.call(ProductListController_60.createProduct())
      }
  
    // @LINE:421
    case controllers_ProductListController_getProductByUser314_route(params) =>
      call { 
        controllers_ProductListController_getProductByUser314_invoker.call(ProductListController_60.getProductByUser())
      }
  
    // @LINE:422
    case controllers_ProductListController_deleteProduct315_route(params) =>
      call { 
        controllers_ProductListController_deleteProduct315_invoker.call(ProductListController_60.deleteProduct())
      }
  
    // @LINE:423
    case controllers_ProductListController_getProductById316_route(params) =>
      call { 
        controllers_ProductListController_getProductById316_invoker.call(ProductListController_60.getProductById())
      }
  
    // @LINE:424
    case controllers_ProductListController_editProduct317_route(params) =>
      call { 
        controllers_ProductListController_editProduct317_invoker.call(ProductListController_60.editProduct())
      }
  
    // @LINE:426
    case controllers_ProductListController_manageProductList318_route(params) =>
      call { 
        controllers_ProductListController_manageProductList318_invoker.call(ProductListController_60.manageProductList())
      }
  
    // @LINE:427
    case controllers_ProductListController_manageProductFilterList319_route(params) =>
      call { 
        controllers_ProductListController_manageProductFilterList319_invoker.call(ProductListController_60.manageProductFilterList())
      }
  
    // @LINE:428
    case controllers_ProductListController_changeStatusProduct320_route(params) =>
      call { 
        controllers_ProductListController_changeStatusProduct320_invoker.call(ProductListController_60.changeStatusProduct())
      }
  
    // @LINE:429
    case controllers_ProductListController_requestApproveProduct321_route(params) =>
      call { 
        controllers_ProductListController_requestApproveProduct321_invoker.call(ProductListController_60.requestApproveProduct())
      }
  
    // @LINE:432
    case controllers_MarketPlaceController_marketPlace322_route(params) =>
      call { 
        controllers_MarketPlaceController_marketPlace322_invoker.call(MarketPlaceController_28.marketPlace())
      }
  
    // @LINE:433
    case controllers_MarketPlaceController_marketPlaceSolution323_route(params) =>
      call { 
        controllers_MarketPlaceController_marketPlaceSolution323_invoker.call(MarketPlaceController_28.marketPlaceSolution())
      }
  
    // @LINE:434
    case controllers_MarketPlaceController_marketPlaceDevice324_route(params) =>
      call { 
        controllers_MarketPlaceController_marketPlaceDevice324_invoker.call(MarketPlaceController_28.marketPlaceDevice())
      }
  
    // @LINE:435
    case controllers_MarketPlaceController_getProductMarket325_route(params) =>
      call { 
        controllers_MarketPlaceController_getProductMarket325_invoker.call(MarketPlaceController_28.getProductMarket())
      }
  
    // @LINE:436
    case controllers_MarketPlaceController_getAllProduct326_route(params) =>
      call { 
        controllers_MarketPlaceController_getAllProduct326_invoker.call(MarketPlaceController_28.getAllProduct())
      }
  
    // @LINE:437
    case controllers_MarketPlaceController_getAllGroupProduct327_route(params) =>
      call { 
        controllers_MarketPlaceController_getAllGroupProduct327_invoker.call(MarketPlaceController_28.getAllGroupProduct())
      }
  
    // @LINE:438
    case controllers_MarketPlaceController_getAllGroupSolution328_route(params) =>
      call { 
        controllers_MarketPlaceController_getAllGroupSolution328_invoker.call(MarketPlaceController_28.getAllGroupSolution())
      }
  
    // @LINE:439
    case controllers_MarketPlaceController_getAllGroupDevice329_route(params) =>
      call { 
        controllers_MarketPlaceController_getAllGroupDevice329_invoker.call(MarketPlaceController_28.getAllGroupDevice())
      }
  
    // @LINE:440
    case controllers_MarketPlaceController_getAllSolution330_route(params) =>
      call { 
        controllers_MarketPlaceController_getAllSolution330_invoker.call(MarketPlaceController_28.getAllSolution())
      }
  
    // @LINE:441
    case controllers_MarketPlaceController_getAllDevice331_route(params) =>
      call { 
        controllers_MarketPlaceController_getAllDevice331_invoker.call(MarketPlaceController_28.getAllDevice())
      }
  
    // @LINE:442
    case controllers_MarketPlaceController_detailProduct332_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MarketPlaceController_detailProduct332_invoker.call(MarketPlaceController_28.detailProduct(id))
      }
  
    // @LINE:443
    case controllers_MarketPlaceController_getDetailProductWithId333_route(params) =>
      call { 
        controllers_MarketPlaceController_getDetailProductWithId333_invoker.call(MarketPlaceController_28.getDetailProductWithId())
      }
  
    // @LINE:444
    case controllers_MarketPlaceController_getSameProduct334_route(params) =>
      call { 
        controllers_MarketPlaceController_getSameProduct334_invoker.call(MarketPlaceController_28.getSameProduct())
      }
  
    // @LINE:446
    case controllers_MarketPlaceContactController_productContactList335_route(params) =>
      call { 
        controllers_MarketPlaceContactController_productContactList335_invoker.call(MarketPlaceContactController_59.productContactList())
      }
  
    // @LINE:447
    case controllers_MarketPlaceContactController_productContactFilterList336_route(params) =>
      call { 
        controllers_MarketPlaceContactController_productContactFilterList336_invoker.call(MarketPlaceContactController_59.productContactFilterList())
      }
  
    // @LINE:448
    case controllers_MarketPlaceContactController_sendContactMarket337_route(params) =>
      call { 
        controllers_MarketPlaceContactController_sendContactMarket337_invoker.call(MarketPlaceContactController_59.sendContactMarket())
      }
  
    // @LINE:449
    case controllers_MarketPlaceContactController_editContactMarket338_route(params) =>
      call { 
        controllers_MarketPlaceContactController_editContactMarket338_invoker.call(MarketPlaceContactController_59.editContactMarket())
      }
  
    // @LINE:451
    case controllers_MarketPlaceCommentController_commentWithProductId339_route(params) =>
      call { 
        controllers_MarketPlaceCommentController_commentWithProductId339_invoker.call(MarketPlaceCommentController_11.commentWithProductId())
      }
  
    // @LINE:452
    case controllers_MarketPlaceCommentController_getListCommentProduct340_route(params) =>
      call { 
        controllers_MarketPlaceCommentController_getListCommentProduct340_invoker.call(MarketPlaceCommentController_11.getListCommentProduct())
      }
  
    // @LINE:455
    case controllers_UserTenantListController_userTenantList341_route(params) =>
      call { 
        controllers_UserTenantListController_userTenantList341_invoker.call(UserTenantListController_53.userTenantList())
      }
  
    // @LINE:456
    case controllers_UserTenantListController_getListUserTenant342_route(params) =>
      call { 
        controllers_UserTenantListController_getListUserTenant342_invoker.call(UserTenantListController_53.getListUserTenant())
      }
  
    // @LINE:457
    case controllers_UserTenantListController_createUserTenant343_route(params) =>
      call { 
        controllers_UserTenantListController_createUserTenant343_invoker.call(UserTenantListController_53.createUserTenant())
      }
  
    // @LINE:458
    case controllers_UserTenantListController_delUserTenant344_route(params) =>
      call { 
        controllers_UserTenantListController_delUserTenant344_invoker.call(UserTenantListController_53.delUserTenant())
      }
  
    // @LINE:459
    case controllers_UserTenantListController_editUserTenant345_route(params) =>
      call { 
        controllers_UserTenantListController_editUserTenant345_invoker.call(UserTenantListController_53.editUserTenant())
      }
  
    // @LINE:460
    case controllers_UserTenantListController_getListRoleOfOrg346_route(params) =>
      call { 
        controllers_UserTenantListController_getListRoleOfOrg346_invoker.call(UserTenantListController_53.getListRoleOfOrg())
      }
  
    // @LINE:461
    case controllers_UserTenantListController_updateRoleUserPermission347_route(params) =>
      call { 
        controllers_UserTenantListController_updateRoleUserPermission347_invoker.call(UserTenantListController_53.updateRoleUserPermission())
      }
  
    // @LINE:462
    case controllers_UserTenantListController_delRoleUserPermission348_route(params) =>
      call { 
        controllers_UserTenantListController_delRoleUserPermission348_invoker.call(UserTenantListController_53.delRoleUserPermission())
      }
  
    // @LINE:465
    case controllers_TelcoOrderController_orderSubs349_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoOrderController_orderSubs349_invoker.call(TelcoOrderController_44.orderSubs(userId))
      }
  
    // @LINE:466
    case controllers_TelcoOrderController_getDataTelcoByUrl350_route(params) =>
      call(params.fromPath[String]("url", None)) { (url) =>
        controllers_TelcoOrderController_getDataTelcoByUrl350_invoker.call(TelcoOrderController_44.getDataTelcoByUrl(url))
      }
  
    // @LINE:467
    case controllers_TelcoOrderController_checkValidateSerialSim351_route(params) =>
      call { 
        controllers_TelcoOrderController_checkValidateSerialSim351_invoker.call(TelcoOrderController_44.checkValidateSerialSim())
      }
  
    // @LINE:468
    case controllers_TelcoOrderController_getListReasonFull352_route(params) =>
      call { 
        controllers_TelcoOrderController_getListReasonFull352_invoker.call(TelcoOrderController_44.getListReasonFull())
      }
  
    // @LINE:469
    case controllers_TelcoOrderController_getConnectSubscriberRamdom353_route(params) =>
      call { 
        controllers_TelcoOrderController_getConnectSubscriberRamdom353_invoker.call(TelcoOrderController_44.getConnectSubscriberRamdom())
      }
  
    // @LINE:470
    case controllers_TelcoOrderController_searchSubscriberByStock354_route(params) =>
      call { 
        controllers_TelcoOrderController_searchSubscriberByStock354_invoker.call(TelcoOrderController_44.searchSubscriberByStock())
      }
  
    // @LINE:471
    case controllers_TelcoOrderController_blockIsdnVht355_route(params) =>
      call { 
        controllers_TelcoOrderController_blockIsdnVht355_invoker.call(TelcoOrderController_44.blockIsdnVht())
      }
  
    // @LINE:472
    case controllers_TelcoOrderController_unlockIsdnVht356_route(params) =>
      call { 
        controllers_TelcoOrderController_unlockIsdnVht356_invoker.call(TelcoOrderController_44.unlockIsdnVht())
      }
  
    // @LINE:473
    case controllers_TelcoOrderController_connectSubscriberSim357_route(params) =>
      call { 
        controllers_TelcoOrderController_connectSubscriberSim357_invoker.call(TelcoOrderController_44.connectSubscriberSim())
      }
  
    // @LINE:474
    case controllers_TelcoOrderController_getListProductOffer358_route(params) =>
      call { 
        controllers_TelcoOrderController_getListProductOffer358_invoker.call(TelcoOrderController_44.getListProductOffer())
      }
  
    // @LINE:475
    case controllers_TelcoOrderController_getListSaleService359_route(params) =>
      call { 
        controllers_TelcoOrderController_getListSaleService359_invoker.call(TelcoOrderController_44.getListSaleService())
      }
  
    // @LINE:476
    case controllers_TelcoOrderController_getListSaleService1360_route(params) =>
      call { 
        controllers_TelcoOrderController_getListSaleService1360_invoker.call(TelcoOrderController_44.getListSaleService1())
      }
  
    // @LINE:477
    case controllers_TelcoOrderController_processOrderBuySim361_route(params) =>
      call { 
        controllers_TelcoOrderController_processOrderBuySim361_invoker.call(TelcoOrderController_44.processOrderBuySim())
      }
  
    // @LINE:479
    case controllers_TelcoAPNController_APNview362_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoAPNController_APNview362_invoker.call(TelcoAPNController_1.APNview(userId))
      }
  
    // @LINE:480
    case controllers_TelcoAPNController_getIpAllow363_route(params) =>
      call(params.fromPath[String]("isdn", None), params.fromQuery[String]("userId", None)) { (isdn, userId) =>
        controllers_TelcoAPNController_getIpAllow363_invoker.call(TelcoAPNController_1.getIpAllow(isdn, userId))
      }
  
    // @LINE:481
    case controllers_TelcoAPNController_getAPNByPhone364_route(params) =>
      call { 
        controllers_TelcoAPNController_getAPNByPhone364_invoker.call(TelcoAPNController_1.getAPNByPhone())
      }
  
    // @LINE:482
    case controllers_TelcoAPNController_registerAPN365_route(params) =>
      call { 
        controllers_TelcoAPNController_registerAPN365_invoker.call(TelcoAPNController_1.registerAPN())
      }
  
    // @LINE:483
    case controllers_TelcoAPNController_unRegisterAPN366_route(params) =>
      call { 
        controllers_TelcoAPNController_unRegisterAPN366_invoker.call(TelcoAPNController_1.unRegisterAPN())
      }
  
    // @LINE:485
    case controllers_TelcoOrderController_buySim367_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoOrderController_buySim367_invoker.call(TelcoOrderController_44.buySim(userId))
      }
  
    // @LINE:486
    case controllers_TelcoOrderController_manageOrder368_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoOrderController_manageOrder368_invoker.call(TelcoOrderController_44.manageOrder(userId))
      }
  
    // @LINE:487
    case controllers_TelcoOrderController_getListOrderBuySim369_route(params) =>
      call { 
        controllers_TelcoOrderController_getListOrderBuySim369_invoker.call(TelcoOrderController_44.getListOrderBuySim())
      }
  
    // @LINE:488
    case controllers_TelcoOrderController_upfilePycTelco370_route(params) =>
      call { 
        controllers_TelcoOrderController_upfilePycTelco370_invoker.call(TelcoOrderController_44.upfilePycTelco())
      }
  
    // @LINE:489
    case controllers_TelcoOrderController_getCustomerType371_route(params) =>
      call { 
        controllers_TelcoOrderController_getCustomerType371_invoker.call(TelcoOrderController_44.getCustomerType())
      }
  
    // @LINE:490
    case controllers_TelcoOrderController_getListCt372_route(params) =>
      call { 
        controllers_TelcoOrderController_getListCt372_invoker.call(TelcoOrderController_44.getListCt())
      }
  
    // @LINE:492
    case controllers_TelcoLogController_logConnectSim373_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoLogController_logConnectSim373_invoker.call(TelcoLogController_73.logConnectSim(userId))
      }
  
    // @LINE:493
    case controllers_TelcoLogController_getLogConnectSim374_route(params) =>
      call { 
        controllers_TelcoLogController_getLogConnectSim374_invoker.call(TelcoLogController_73.getLogConnectSim())
      }
  
    // @LINE:495
    case controllers_TelcoDashboardController_telcoDashboard375_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoDashboardController_telcoDashboard375_invoker.call(TelcoDashboardController_55.telcoDashboard(userId))
      }
  
    // @LINE:496
    case controllers_TelcoDashboardController_getDataDashboardTelco376_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDataDashboardTelco376_invoker.call(TelcoDashboardController_55.getDataDashboardTelco())
      }
  
    // @LINE:497
    case controllers_TelcoDashboardController_getDataDashboardWithMonth377_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDataDashboardWithMonth377_invoker.call(TelcoDashboardController_55.getDataDashboardWithMonth())
      }
  
    // @LINE:498
    case controllers_TelcoDashboardController_getTop5DataUsersOfMonth378_route(params) =>
      call { 
        controllers_TelcoDashboardController_getTop5DataUsersOfMonth378_invoker.call(TelcoDashboardController_55.getTop5DataUsersOfMonth())
      }
  
    // @LINE:499
    case controllers_TelcoDashboardController_getAlertDashboard379_route(params) =>
      call { 
        controllers_TelcoDashboardController_getAlertDashboard379_invoker.call(TelcoDashboardController_55.getAlertDashboard())
      }
  
    // @LINE:500
    case controllers_TelcoDashboardController_getDetailAlertDashboard380_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDetailAlertDashboard380_invoker.call(TelcoDashboardController_55.getDetailAlertDashboard())
      }
  
    // @LINE:501
    case controllers_TelcoDashboardController_getSubscriberStatistics381_route(params) =>
      call { 
        controllers_TelcoDashboardController_getSubscriberStatistics381_invoker.call(TelcoDashboardController_55.getSubscriberStatistics())
      }
  
    // @LINE:502
    case controllers_TelcoDashboardController_getBalanceDashboardTelco382_route(params) =>
      call { 
        controllers_TelcoDashboardController_getBalanceDashboardTelco382_invoker.call(TelcoDashboardController_55.getBalanceDashboardTelco())
      }
  
    // @LINE:503
    case controllers_TelcoDashboardController_getListSubsDashboardByKey383_route(params) =>
      call { 
        controllers_TelcoDashboardController_getListSubsDashboardByKey383_invoker.call(TelcoDashboardController_55.getListSubsDashboardByKey())
      }
  
    // @LINE:504
    case controllers_TelcoDashboardController_getListSubsDashboardBlockDebit384_route(params) =>
      call { 
        controllers_TelcoDashboardController_getListSubsDashboardBlockDebit384_invoker.call(TelcoDashboardController_55.getListSubsDashboardBlockDebit())
      }
  
    // @LINE:505
    case controllers_TelcoDashboardController_getDetailRedAlert385_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDetailRedAlert385_invoker.call(TelcoDashboardController_55.getDetailRedAlert())
      }
  
    // @LINE:506
    case controllers_TelcoDashboardController_getDetailPrepaidExpired386_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDetailPrepaidExpired386_invoker.call(TelcoDashboardController_55.getDetailPrepaidExpired())
      }
  
    // @LINE:507
    case controllers_TelcoDashboardController_getDetailLowRemainingData387_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDetailLowRemainingData387_invoker.call(TelcoDashboardController_55.getDetailLowRemainingData())
      }
  
    // @LINE:508
    case controllers_TelcoDashboardController_getDetailPackageExpired388_route(params) =>
      call { 
        controllers_TelcoDashboardController_getDetailPackageExpired388_invoker.call(TelcoDashboardController_55.getDetailPackageExpired())
      }
  
    // @LINE:510
    case controllers_TelcoAccountController_accountInfo389_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoAccountController_accountInfo389_invoker.call(TelcoAccountController_3.accountInfo(userId))
      }
  
    // @LINE:511
    case controllers_TelcoAccountController_updateDetailAccountTelco390_route(params) =>
      call { 
        controllers_TelcoAccountController_updateDetailAccountTelco390_invoker.call(TelcoAccountController_3.updateDetailAccountTelco())
      }
  
    // @LINE:512
    case controllers_TelcoAccountController_updateInfoCompanyTelco391_route(params) =>
      call { 
        controllers_TelcoAccountController_updateInfoCompanyTelco391_invoker.call(TelcoAccountController_3.updateInfoCompanyTelco())
      }
  
    // @LINE:513
    case controllers_TelcoAccountController_deleteInfoCompany392_route(params) =>
      call { 
        controllers_TelcoAccountController_deleteInfoCompany392_invoker.call(TelcoAccountController_3.deleteInfoCompany())
      }
  
    // @LINE:514
    case controllers_TelcoAccountController_getInfoAccount393_route(params) =>
      call { 
        controllers_TelcoAccountController_getInfoAccount393_invoker.call(TelcoAccountController_3.getInfoAccount())
      }
  
    // @LINE:515
    case controllers_TelcoAccountController_getInfoCompany394_route(params) =>
      call { 
        controllers_TelcoAccountController_getInfoCompany394_invoker.call(TelcoAccountController_3.getInfoCompany())
      }
  
    // @LINE:516
    case controllers_TelcoAccountController_getInfoCompanyEnterpriseLv2395_route(params) =>
      call { 
        controllers_TelcoAccountController_getInfoCompanyEnterpriseLv2395_invoker.call(TelcoAccountController_3.getInfoCompanyEnterpriseLv2())
      }
  
    // @LINE:517
    case controllers_TelcoAccountController_getListArea396_route(params) =>
      call { 
        controllers_TelcoAccountController_getListArea396_invoker.call(TelcoAccountController_3.getListArea())
      }
  
    // @LINE:518
    case controllers_TelcoAccountController_getInfoGpkdApproved397_route(params) =>
      call { 
        controllers_TelcoAccountController_getInfoGpkdApproved397_invoker.call(TelcoAccountController_3.getInfoGpkdApproved())
      }
  
    // @LINE:519
    case controllers_TelcoAccountController_getCategoryBusinessAndDevice398_route(params) =>
      call { 
        controllers_TelcoAccountController_getCategoryBusinessAndDevice398_invoker.call(TelcoAccountController_3.getCategoryBusinessAndDevice())
      }
  
    // @LINE:520
    case controllers_TelcoAccountController_updateCategoryBusinessAndDevice399_route(params) =>
      call { 
        controllers_TelcoAccountController_updateCategoryBusinessAndDevice399_invoker.call(TelcoAccountController_3.updateCategoryBusinessAndDevice())
      }
  
    // @LINE:521
    case controllers_OrderSearchController_getSearchOrder400_route(params) =>
      call(params.fromPath[String]("orderId", None)) { (orderId) =>
        controllers_OrderSearchController_getSearchOrder400_invoker.call(OrderSearchController_57.getSearchOrder(orderId))
      }
  
    // @LINE:524
    case controllers_AdminTelcoController_approvedInfoCompanyTelco401_route(params) =>
      call { 
        controllers_AdminTelcoController_approvedInfoCompanyTelco401_invoker.call(AdminTelcoController_34.approvedInfoCompanyTelco())
      }
  
    // @LINE:525
    case controllers_AdminTelcoController_getListInfoApproved402_route(params) =>
      call { 
        controllers_AdminTelcoController_getListInfoApproved402_invoker.call(AdminTelcoController_34.getListInfoApproved())
      }
  
    // @LINE:526
    case controllers_AdminTelcoController_processComfirmInfoAccountCmp403_route(params) =>
      call { 
        controllers_AdminTelcoController_processComfirmInfoAccountCmp403_invoker.call(AdminTelcoController_34.processComfirmInfoAccountCmp())
      }
  
    // @LINE:527
    case controllers_AdminTelcoController_processComfirmInfoCompany404_route(params) =>
      call { 
        controllers_AdminTelcoController_processComfirmInfoCompany404_invoker.call(AdminTelcoController_34.processComfirmInfoCompany())
      }
  
    // @LINE:528
    case controllers_AdminTelcoController_getListEnterpriseByBrowser405_route(params) =>
      call { 
        controllers_AdminTelcoController_getListEnterpriseByBrowser405_invoker.call(AdminTelcoController_34.getListEnterpriseByBrowser())
      }
  
    // @LINE:529
    case controllers_AdminTelcoController_getListEnterpriseSubmitOfAdminSpe406_route(params) =>
      call { 
        controllers_AdminTelcoController_getListEnterpriseSubmitOfAdminSpe406_invoker.call(AdminTelcoController_34.getListEnterpriseSubmitOfAdminSpe())
      }
  
    // @LINE:531
    case controllers_TelcoSubscriberController_subscriberManage407_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoSubscriberController_subscriberManage407_invoker.call(TelcoSubscriberController_12.subscriberManage(userId))
      }
  
    // @LINE:532
    case controllers_TelcoSubscriberController_getListSubscriber408_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getListSubscriber408_invoker.call(TelcoSubscriberController_12.getListSubscriber())
      }
  
    // @LINE:533
    case controllers_TelcoSubscriberController_getListSubsByBeVht409_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getListSubsByBeVht409_invoker.call(TelcoSubscriberController_12.getListSubsByBeVht())
      }
  
    // @LINE:534
    case controllers_TelcoSubscriberController_getDetailSubscriber410_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getDetailSubscriber410_invoker.call(TelcoSubscriberController_12.getDetailSubscriber())
      }
  
    // @LINE:535
    case controllers_TelcoSubscriberController_subscriberDetail411_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("subs", None)) { (id, subs) =>
        controllers_TelcoSubscriberController_subscriberDetail411_invoker.call(TelcoSubscriberController_12.subscriberDetail(id, subs))
      }
  
    // @LINE:536
    case controllers_TelcoSubscriberController_getListProductOffering412_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getListProductOffering412_invoker.call(TelcoSubscriberController_12.getListProductOffering())
      }
  
    // @LINE:537
    case controllers_TelcoSubscriberController_getInfoDataAccount413_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getInfoDataAccount413_invoker.call(TelcoSubscriberController_12.getInfoDataAccount())
      }
  
    // @LINE:538
    case controllers_TelcoSubscriberController_getTotalSubscriber414_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getTotalSubscriber414_invoker.call(TelcoSubscriberController_12.getTotalSubscriber())
      }
  
    // @LINE:539
    case controllers_TelcoSubscriberController_getHybridInfo415_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getHybridInfo415_invoker.call(TelcoSubscriberController_12.getHybridInfo())
      }
  
    // @LINE:540
    case controllers_TelcoSubscriberController_getCtkm416_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getCtkm416_invoker.call(TelcoSubscriberController_12.getCtkm())
      }
  
    // @LINE:541
    case controllers_TelcoSubscriberController_getBalanceInfo417_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getBalanceInfo417_invoker.call(TelcoSubscriberController_12.getBalanceInfo())
      }
  
    // @LINE:542
    case controllers_TelcoSubscriberController_getDebitSubscriber418_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getDebitSubscriber418_invoker.call(TelcoSubscriberController_12.getDebitSubscriber())
      }
  
    // @LINE:543
    case controllers_TelcoSubscriberController_getKttkAndKtmi419_route(params) =>
      call { 
        controllers_TelcoSubscriberController_getKttkAndKtmi419_invoker.call(TelcoSubscriberController_12.getKttkAndKtmi())
      }
  
    // @LINE:544
    case controllers_TelcoSubscriberController_blockSubcriber420_route(params) =>
      call { 
        controllers_TelcoSubscriberController_blockSubcriber420_invoker.call(TelcoSubscriberController_12.blockSubcriber())
      }
  
    // @LINE:545
    case controllers_TelcoSubscriberController_openSubcriber421_route(params) =>
      call { 
        controllers_TelcoSubscriberController_openSubcriber421_invoker.call(TelcoSubscriberController_12.openSubcriber())
      }
  
    // @LINE:546
    case controllers_TelcoSubscriberController_open2wSubcriber422_route(params) =>
      call { 
        controllers_TelcoSubscriberController_open2wSubcriber422_invoker.call(TelcoSubscriberController_12.open2wSubcriber())
      }
  
    // @LINE:548
    case controllers_TelcoContractController_contractManage423_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoContractController_contractManage423_invoker.call(TelcoContractController_17.contractManage(userId))
      }
  
    // @LINE:549
    case controllers_TelcoContractController_getListAccountContract424_route(params) =>
      call { 
        controllers_TelcoContractController_getListAccountContract424_invoker.call(TelcoContractController_17.getListAccountContract())
      }
  
    // @LINE:550
    case controllers_TelcoContractController_getDebitContract425_route(params) =>
      call { 
        controllers_TelcoContractController_getDebitContract425_invoker.call(TelcoContractController_17.getDebitContract())
      }
  
    // @LINE:551
    case controllers_TelcoContractController_getTotalAccount426_route(params) =>
      call { 
        controllers_TelcoContractController_getTotalAccount426_invoker.call(TelcoContractController_17.getTotalAccount())
      }
  
    // @LINE:552
    case controllers_TelcoContractController_getListContractByIdNo427_route(params) =>
      call { 
        controllers_TelcoContractController_getListContractByIdNo427_invoker.call(TelcoContractController_17.getListContractByIdNo())
      }
  
    // @LINE:554
    case controllers_TelcoUtilitiesController_utilitiesManage428_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoUtilitiesController_utilitiesManage428_invoker.call(TelcoUtilitiesController_56.utilitiesManage(userId))
      }
  
    // @LINE:555
    case controllers_TelcoUtilitiesController_utilitiesTopup429_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoUtilitiesController_utilitiesTopup429_invoker.call(TelcoUtilitiesController_56.utilitiesTopup(userId))
      }
  
    // @LINE:556
    case controllers_TelcoUtilitiesController_utilitiesBlock430_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoUtilitiesController_utilitiesBlock430_invoker.call(TelcoUtilitiesController_56.utilitiesBlock(userId))
      }
  
    // @LINE:557
    case controllers_TelcoUtilitiesController_utilitiesBuyPackage431_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoUtilitiesController_utilitiesBuyPackage431_invoker.call(TelcoUtilitiesController_56.utilitiesBuyPackage(userId))
      }
  
    // @LINE:558
    case controllers_TelcoUtilitiesController_getListPackMiAndAddOn432_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_getListPackMiAndAddOn432_invoker.call(TelcoUtilitiesController_56.getListPackMiAndAddOn())
      }
  
    // @LINE:559
    case controllers_TelcoUtilitiesController_registerMiAddon433_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_registerMiAddon433_invoker.call(TelcoUtilitiesController_56.registerMiAddon())
      }
  
    // @LINE:560
    case controllers_TelcoUtilitiesController_unregisterMiAddon434_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_unregisterMiAddon434_invoker.call(TelcoUtilitiesController_56.unregisterMiAddon())
      }
  
    // @LINE:561
    case controllers_TelcoUtilitiesController_unextendMiAddon435_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_unextendMiAddon435_invoker.call(TelcoUtilitiesController_56.unextendMiAddon())
      }
  
    // @LINE:562
    case controllers_TelcoUtilitiesController_getInfoOrderId436_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_getInfoOrderId436_invoker.call(TelcoUtilitiesController_56.getInfoOrderId())
      }
  
    // @LINE:563
    case controllers_TelcoUtilitiesController_rechargeSubcriber437_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_rechargeSubcriber437_invoker.call(TelcoUtilitiesController_56.rechargeSubcriber())
      }
  
    // @LINE:564
    case controllers_TelcoUtilitiesController_getListOrderIdByAction438_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_getListOrderIdByAction438_invoker.call(TelcoUtilitiesController_56.getListOrderIdByAction())
      }
  
    // @LINE:565
    case controllers_TelcoUtilitiesController_getHistoryBlockUnblock439_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_getHistoryBlockUnblock439_invoker.call(TelcoUtilitiesController_56.getHistoryBlockUnblock())
      }
  
    // @LINE:566
    case controllers_TelcoUtilitiesController_validateSubs440_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_validateSubs440_invoker.call(TelcoUtilitiesController_56.validateSubs())
      }
  
    // @LINE:567
    case controllers_TelcoUtilitiesController_prepayCharges441_route(params) =>
      call(params.fromQuery[String]("userId", None)) { (userId) =>
        controllers_TelcoUtilitiesController_prepayCharges441_invoker.call(TelcoUtilitiesController_56.prepayCharges(userId))
      }
  
    // @LINE:568
    case controllers_TelcoUtilitiesController_prepayChargesBill442_route(params) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("isdn", None), params.fromPath[String]("orderId", None)) { (userId, isdn, orderId) =>
        controllers_TelcoUtilitiesController_prepayChargesBill442_invoker.call(TelcoUtilitiesController_56.prepayChargesBill(userId, isdn, orderId))
      }
  
    // @LINE:569
    case controllers_TelcoUtilitiesController_getDataPrepaidInfo443_route(params) =>
      call(params.fromQuery[String]("prom_code", None), params.fromQuery[String]("product_code", None)) { (prom_code, product_code) =>
        controllers_TelcoUtilitiesController_getDataPrepaidInfo443_invoker.call(TelcoUtilitiesController_56.getDataPrepaidInfo(prom_code, product_code))
      }
  
    // @LINE:570
    case controllers_TelcoUtilitiesController_rechargePrepaid444_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_rechargePrepaid444_invoker.call(TelcoUtilitiesController_56.rechargePrepaid())
      }
  
    // @LINE:571
    case controllers_TelcoUtilitiesController_getHistoryPrepayCharges445_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_getHistoryPrepayCharges445_invoker.call(TelcoUtilitiesController_56.getHistoryPrepayCharges())
      }
  
    // @LINE:572
    case controllers_TelcoUtilitiesController_payPostpaidBill446_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoUtilitiesController_payPostpaidBill446_invoker.call(TelcoUtilitiesController_56.payPostpaidBill(userId))
      }
  
    // @LINE:573
    case controllers_TelcoUtilitiesController_payDebit447_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_payDebit447_invoker.call(TelcoUtilitiesController_56.payDebit())
      }
  
    // @LINE:574
    case controllers_TelcoUtilitiesController_payPostpaidBillDetail448_route(params) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("orderId", None)) { (userId, orderId) =>
        controllers_TelcoUtilitiesController_payPostpaidBillDetail448_invoker.call(TelcoUtilitiesController_56.payPostpaidBillDetail(userId, orderId))
      }
  
    // @LINE:575
    case controllers_TelcoUtilitiesController_getHistoryPayPostBill449_route(params) =>
      call { 
        controllers_TelcoUtilitiesController_getHistoryPayPostBill449_invoker.call(TelcoUtilitiesController_56.getHistoryPayPostBill())
      }
  
    // @LINE:577
    case controllers_TelcoInvoiceController_invoiceOfContract450_route(params) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("invoice", None)) { (userId, invoice) =>
        controllers_TelcoInvoiceController_invoiceOfContract450_invoker.call(TelcoInvoiceController_79.invoiceOfContract(userId, invoice))
      }
  
    // @LINE:578
    case controllers_TelcoInvoiceController_getListInvoiceOfContract451_route(params) =>
      call { 
        controllers_TelcoInvoiceController_getListInvoiceOfContract451_invoker.call(TelcoInvoiceController_79.getListInvoiceOfContract())
      }
  
    // @LINE:579
    case controllers_TelcoInvoiceController_getLinkDownloadInvoice452_route(params) =>
      call { 
        controllers_TelcoInvoiceController_getLinkDownloadInvoice452_invoker.call(TelcoInvoiceController_79.getLinkDownloadInvoice())
      }
  
    // @LINE:582
    case controllers_TelcoApiKeyController_apiKeyManage453_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoApiKeyController_apiKeyManage453_invoker.call(TelcoApiKeyController_47.apiKeyManage(userId))
      }
  
    // @LINE:583
    case controllers_TelcoApiKeyController_getListApiKey454_route(params) =>
      call { 
        controllers_TelcoApiKeyController_getListApiKey454_invoker.call(TelcoApiKeyController_47.getListApiKey())
      }
  
    // @LINE:587
    case controllers_TelcoRoleAccountController_accountList455_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_accountList455_invoker.call(TelcoRoleAccountController_5.accountList())
      }
  
    // @LINE:588
    case controllers_TelcoRoleAccountController_getListAccountCmp456_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_getListAccountCmp456_invoker.call(TelcoRoleAccountController_5.getListAccountCmp())
      }
  
    // @LINE:589
    case controllers_TelcoRoleAccountController_addAccountCmp457_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_addAccountCmp457_invoker.call(TelcoRoleAccountController_5.addAccountCmp())
      }
  
    // @LINE:590
    case controllers_TelcoRoleAccountController_addAccountCmpV2458_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_addAccountCmpV2458_invoker.call(TelcoRoleAccountController_5.addAccountCmpV2())
      }
  
    // @LINE:591
    case controllers_TelcoRoleAccountController_infoAccountCmp459_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TelcoRoleAccountController_infoAccountCmp459_invoker.call(TelcoRoleAccountController_5.infoAccountCmp(id))
      }
  
    // @LINE:592
    case controllers_TelcoRoleAccountController_getInfoAccountCmp460_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_getInfoAccountCmp460_invoker.call(TelcoRoleAccountController_5.getInfoAccountCmp())
      }
  
    // @LINE:593
    case controllers_TelcoRoleAccountController_generatePassAccountCmp461_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_generatePassAccountCmp461_invoker.call(TelcoRoleAccountController_5.generatePassAccountCmp())
      }
  
    // @LINE:594
    case controllers_TelcoRoleAccountController_addEnterpriseBySAdmin462_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_addEnterpriseBySAdmin462_invoker.call(TelcoRoleAccountController_5.addEnterpriseBySAdmin())
      }
  
    // @LINE:595
    case controllers_TelcoRoleAccountController_addEnterpriseByAdminOrSEnterprise463_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_addEnterpriseByAdminOrSEnterprise463_invoker.call(TelcoRoleAccountController_5.addEnterpriseByAdminOrSEnterprise())
      }
  
    // @LINE:596
    case controllers_TelcoRoleAccountController_deleteEnterprise464_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_deleteEnterprise464_invoker.call(TelcoRoleAccountController_5.deleteEnterprise())
      }
  
    // @LINE:597
    case controllers_TelcoRoleAccountController_editEnterprise465_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_editEnterprise465_invoker.call(TelcoRoleAccountController_5.editEnterprise())
      }
  
    // @LINE:598
    case controllers_TelcoRoleAccountController_updateEnterprise466_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_updateEnterprise466_invoker.call(TelcoRoleAccountController_5.updateEnterprise())
      }
  
    // @LINE:599
    case controllers_TelcoRoleAccountController_deleteAccountCmp467_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_deleteAccountCmp467_invoker.call(TelcoRoleAccountController_5.deleteAccountCmp())
      }
  
    // @LINE:600
    case controllers_TelcoRoleAccountController_validateGpkd468_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_validateGpkd468_invoker.call(TelcoRoleAccountController_5.validateGpkd())
      }
  
    // @LINE:601
    case controllers_TelcoRoleAccountController_checkValidateGpkd469_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_checkValidateGpkd469_invoker.call(TelcoRoleAccountController_5.checkValidateGpkd())
      }
  
    // @LINE:602
    case controllers_TelcoRoleAccountController_updatRoleAccountCmp470_route(params) =>
      call { 
        controllers_TelcoRoleAccountController_updatRoleAccountCmp470_invoker.call(TelcoRoleAccountController_5.updatRoleAccountCmp())
      }
  
    // @LINE:605
    case controllers_TelcoQrcodeController_qrcodeList471_route(params) =>
      call { 
        controllers_TelcoQrcodeController_qrcodeList471_invoker.call(TelcoQrcodeController_62.qrcodeList())
      }
  
    // @LINE:606
    case controllers_TelcoQrcodeController_getListQrcodeCmp472_route(params) =>
      call { 
        controllers_TelcoQrcodeController_getListQrcodeCmp472_invoker.call(TelcoQrcodeController_62.getListQrcodeCmp())
      }
  
    // @LINE:607
    case controllers_TelcoQrcodeController_checkValidateSerialAdm1473_route(params) =>
      call { 
        controllers_TelcoQrcodeController_checkValidateSerialAdm1473_invoker.call(TelcoQrcodeController_62.checkValidateSerialAdm1())
      }
  
    // @LINE:608
    case controllers_TelcoQrcodeController_getListGpkd474_route(params) =>
      call { 
        controllers_TelcoQrcodeController_getListGpkd474_invoker.call(TelcoQrcodeController_62.getListGpkd())
      }
  
    // @LINE:609
    case controllers_TelcoQrcodeController_saveFileChungTu475_route(params) =>
      call { 
        controllers_TelcoQrcodeController_saveFileChungTu475_invoker.call(TelcoQrcodeController_62.saveFileChungTu())
      }
  
    // @LINE:610
    case controllers_TelcoQrcodeController_createQrcode476_route(params) =>
      call { 
        controllers_TelcoQrcodeController_createQrcode476_invoker.call(TelcoQrcodeController_62.createQrcode())
      }
  
    // @LINE:611
    case controllers_TelcoQrcodeController_qrCodeConnect477_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TelcoQrcodeController_qrCodeConnect477_invoker.call(TelcoQrcodeController_62.qrCodeConnect(id))
      }
  
    // @LINE:612
    case controllers_TelcoQrcodeController_getInfoConnectSubs478_route(params) =>
      call { 
        controllers_TelcoQrcodeController_getInfoConnectSubs478_invoker.call(TelcoQrcodeController_62.getInfoConnectSubs())
      }
  
    // @LINE:613
    case controllers_TelcoQrcodeController_paymentConnectSubs479_route(params) =>
      call { 
        controllers_TelcoQrcodeController_paymentConnectSubs479_invoker.call(TelcoQrcodeController_62.paymentConnectSubs())
      }
  
    // @LINE:614
    case controllers_TelcoQrcodeController_delQrcodeById480_route(params) =>
      call { 
        controllers_TelcoQrcodeController_delQrcodeById480_invoker.call(TelcoQrcodeController_62.delQrcodeById())
      }
  
    // @LINE:617
    case controllers_TelcoHistoryController_historyPackMiAddon481_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoHistoryController_historyPackMiAddon481_invoker.call(TelcoHistoryController_35.historyPackMiAddon(userId))
      }
  
    // @LINE:618
    case controllers_TelcoHistoryController_historyDeposit482_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoHistoryController_historyDeposit482_invoker.call(TelcoHistoryController_35.historyDeposit(userId))
      }
  
    // @LINE:619
    case controllers_TelcoHistoryController_historyPrepayCharges483_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoHistoryController_historyPrepayCharges483_invoker.call(TelcoHistoryController_35.historyPrepayCharges(userId))
      }
  
    // @LINE:620
    case controllers_TelcoHistoryController_historyApn484_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoHistoryController_historyApn484_invoker.call(TelcoHistoryController_35.historyApn(userId))
      }
  
    // @LINE:621
    case controllers_TelcoHistoryController_historyBlockUnblock485_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoHistoryController_historyBlockUnblock485_invoker.call(TelcoHistoryController_35.historyBlockUnblock(userId))
      }
  
    // @LINE:622
    case controllers_TelcoHistoryController_getHistoryPackMiAddon486_route(params) =>
      call { 
        controllers_TelcoHistoryController_getHistoryPackMiAddon486_invoker.call(TelcoHistoryController_35.getHistoryPackMiAddon())
      }
  
    // @LINE:623
    case controllers_TelcoHistoryController_getHistoryApn487_route(params) =>
      call { 
        controllers_TelcoHistoryController_getHistoryApn487_invoker.call(TelcoHistoryController_35.getHistoryApn())
      }
  
    // @LINE:624
    case controllers_TelcoHistoryController_historyPostPaidBill488_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoHistoryController_historyPostPaidBill488_invoker.call(TelcoHistoryController_35.historyPostPaidBill(userId))
      }
  
    // @LINE:627
    case controllers_TelcoChildUserController_listChildUser489_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoChildUserController_listChildUser489_invoker.call(TelcoChildUserController_13.listChildUser(userId))
      }
  
    // @LINE:628
    case controllers_TelcoChildUserController_getListChildUser490_route(params) =>
      call { 
        controllers_TelcoChildUserController_getListChildUser490_invoker.call(TelcoChildUserController_13.getListChildUser())
      }
  
    // @LINE:629
    case controllers_TelcoChildUserController_addChildUserCmp491_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoChildUserController_addChildUserCmp491_invoker.call(TelcoChildUserController_13.addChildUserCmp(userId))
      }
  
    // @LINE:630
    case controllers_TelcoChildUserController_getRolesOfChildUser492_route(params) =>
      call { 
        controllers_TelcoChildUserController_getRolesOfChildUser492_invoker.call(TelcoChildUserController_13.getRolesOfChildUser())
      }
  
    // @LINE:631
    case controllers_TelcoChildUserController_updateRolesOfChildUser493_route(params) =>
      call { 
        controllers_TelcoChildUserController_updateRolesOfChildUser493_invoker.call(TelcoChildUserController_13.updateRolesOfChildUser())
      }
  
    // @LINE:632
    case controllers_TelcoChildUserController_childUserDetail494_route(params) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("childUserId", None), params.fromPath[String]("email", None)) { (userId, childUserId, email) =>
        controllers_TelcoChildUserController_childUserDetail494_invoker.call(TelcoChildUserController_13.childUserDetail(userId, childUserId, email))
      }
  
    // @LINE:633
    case controllers_TelcoChildUserController_getListSubsOfChildUser495_route(params) =>
      call { 
        controllers_TelcoChildUserController_getListSubsOfChildUser495_invoker.call(TelcoChildUserController_13.getListSubsOfChildUser())
      }
  
    // @LINE:634
    case controllers_TelcoChildUserController_addSubToChildUser496_route(params) =>
      call { 
        controllers_TelcoChildUserController_addSubToChildUser496_invoker.call(TelcoChildUserController_13.addSubToChildUser())
      }
  
    // @LINE:635
    case controllers_TelcoChildUserController_addSubToChildUser1497_route(params) =>
      call { 
        controllers_TelcoChildUserController_addSubToChildUser1497_invoker.call(TelcoChildUserController_13.addSubToChildUser1())
      }
  
    // @LINE:636
    case controllers_TelcoChildUserController_validateSubToChildUser1498_route(params) =>
      call { 
        controllers_TelcoChildUserController_validateSubToChildUser1498_invoker.call(TelcoChildUserController_13.validateSubToChildUser1())
      }
  
    // @LINE:637
    case controllers_TelcoChildUserController_removeSubOfChildUser499_route(params) =>
      call { 
        controllers_TelcoChildUserController_removeSubOfChildUser499_invoker.call(TelcoChildUserController_13.removeSubOfChildUser())
      }
  
    // @LINE:640
    case controllers_TelcoFeedbackController_feedback500_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoFeedbackController_feedback500_invoker.call(TelcoFeedbackController_58.feedback(userId))
      }
  
    // @LINE:641
    case controllers_TelcoFeedbackController_sendFeedback501_route(params) =>
      call { 
        controllers_TelcoFeedbackController_sendFeedback501_invoker.call(TelcoFeedbackController_58.sendFeedback())
      }
  
    // @LINE:642
    case controllers_TelcoFeedbackController_logFeedback502_route(params) =>
      call { 
        controllers_TelcoFeedbackController_logFeedback502_invoker.call(TelcoFeedbackController_58.logFeedback())
      }
  
    // @LINE:643
    case controllers_TelcoFeedbackController_getLogListFeedback503_route(params) =>
      call { 
        controllers_TelcoFeedbackController_getLogListFeedback503_invoker.call(TelcoFeedbackController_58.getLogListFeedback())
      }
  
    // @LINE:646
    case controllers_TelcoLogController_logCmp504_route(params) =>
      call { 
        controllers_TelcoLogController_logCmp504_invoker.call(TelcoLogController_73.logCmp())
      }
  
    // @LINE:647
    case controllers_TelcoLogController_getLogListCmp505_route(params) =>
      call { 
        controllers_TelcoLogController_getLogListCmp505_invoker.call(TelcoLogController_73.getLogListCmp())
      }
  
    // @LINE:648
    case controllers_TelcoLogController_updateFormCustomerSurvey506_route(params) =>
      call { 
        controllers_TelcoLogController_updateFormCustomerSurvey506_invoker.call(TelcoLogController_73.updateFormCustomerSurvey())
      }
  
    // @LINE:649
    case controllers_TelcoLogController_logCustomerSurvey507_route(params) =>
      call { 
        controllers_TelcoLogController_logCustomerSurvey507_invoker.call(TelcoLogController_73.logCustomerSurvey())
      }
  
    // @LINE:650
    case controllers_TelcoLogController_getLogListCustomerSurvey508_route(params) =>
      call { 
        controllers_TelcoLogController_getLogListCustomerSurvey508_invoker.call(TelcoLogController_73.getLogListCustomerSurvey())
      }
  
    // @LINE:651
    case controllers_TelcoLogController_editSurvey509_route(params) =>
      call { 
        controllers_TelcoLogController_editSurvey509_invoker.call(TelcoLogController_73.editSurvey())
      }
  
    // @LINE:652
    case controllers_TelcoLogController_deleteSurvey510_route(params) =>
      call { 
        controllers_TelcoLogController_deleteSurvey510_invoker.call(TelcoLogController_73.deleteSurvey())
      }
  
    // @LINE:653
    case controllers_TelcoLogController_getInfoSurvey511_route(params) =>
      call { 
        controllers_TelcoLogController_getInfoSurvey511_invoker.call(TelcoLogController_73.getInfoSurvey())
      }
  
    // @LINE:654
    case controllers_TelcoLogController_exportLogCustomerSurvey512_route(params) =>
      call { 
        controllers_TelcoLogController_exportLogCustomerSurvey512_invoker.call(TelcoLogController_73.exportLogCustomerSurvey())
      }
  
    // @LINE:655
    case controllers_TelcoLogController_saveFormCustomerSurvey513_route(params) =>
      call { 
        controllers_TelcoLogController_saveFormCustomerSurvey513_invoker.call(TelcoLogController_73.saveFormCustomerSurvey())
      }
  
    // @LINE:658
    case controllers_TelcoAepController_aepUtilities514_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoAepController_aepUtilities514_invoker.call(TelcoAepController_30.aepUtilities(userId))
      }
  
    // @LINE:659
    case controllers_TelcoAepController_requestDataAepWeather515_route(params) =>
      call { 
        controllers_TelcoAepController_requestDataAepWeather515_invoker.call(TelcoAepController_30.requestDataAepWeather())
      }
  
    // @LINE:660
    case controllers_TelcoAepController_requestDataAepGps516_route(params) =>
      call { 
        controllers_TelcoAepController_requestDataAepGps516_invoker.call(TelcoAepController_30.requestDataAepGps())
      }
  
    // @LINE:663
    case controllers_TelcoLocationController_telcoLocation517_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoLocationController_telcoLocation517_invoker.call(TelcoLocationController_2.telcoLocation(userId))
      }
  
    // @LINE:664
    case controllers_TelcoLocationController_searchByIsdn518_route(params) =>
      call { 
        controllers_TelcoLocationController_searchByIsdn518_invoker.call(TelcoLocationController_2.searchByIsdn())
      }
  
    // @LINE:667
    case controllers_InvoiceManagerController_invoiceManage519_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_InvoiceManagerController_invoiceManage519_invoker.call(InvoiceManagerController_19.invoiceManage(userId))
      }
  
    // @LINE:668
    case controllers_InvoiceManagerController_getInvoices520_route(params) =>
      call { 
        controllers_InvoiceManagerController_getInvoices520_invoker.call(InvoiceManagerController_19.getInvoices())
      }
  
    // @LINE:669
    case controllers_InvoiceManagerController_getInvoiceBase64521_route(params) =>
      call { 
        controllers_InvoiceManagerController_getInvoiceBase64521_invoker.call(InvoiceManagerController_19.getInvoiceBase64())
      }
  
    // @LINE:672
    case controllers_TelcoStatisticalReportController_RedBaring522_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoStatisticalReportController_RedBaring522_invoker.call(TelcoStatisticalReportController_29.RedBaring(userId))
      }
  
    // @LINE:673
    case controllers_TelcoStatisticalReportController_getRedBarings523_route(params) =>
      call { 
        controllers_TelcoStatisticalReportController_getRedBarings523_invoker.call(TelcoStatisticalReportController_29.getRedBarings())
      }
  
    // @LINE:674
    case controllers_TelcoStatisticalReportController_ExpiratedPackage524_route(params) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_TelcoStatisticalReportController_ExpiratedPackage524_invoker.call(TelcoStatisticalReportController_29.ExpiratedPackage(userId))
      }
  
    // @LINE:675
    case controllers_TelcoStatisticalReportController_getExpiratedPackages525_route(params) =>
      call { 
        controllers_TelcoStatisticalReportController_getExpiratedPackages525_invoker.call(TelcoStatisticalReportController_29.getExpiratedPackages())
      }
  }
}
