package controllers;

import controllers.*;
import controllers.routes;
import jsmessages.JsMessages;
import jsmessages.JsMessagesFactory;
import jsmessages.japi.Helper;
import play.libs.Scala;
import play.mvc.Controller;
import play.mvc.Result;
import play.routing.JavaScriptReverseRouter;

import javax.inject.Inject;

public class JsController extends Controller {
    private final JsMessages jsMessages;


    @Inject
    public JsController(JsMessagesFactory jsMessagesFactory) {
        jsMessages = jsMessagesFactory.all();
    }

    public Result jsMessages() {
        return ok(jsMessages.apply(
            Scala.Option("window.Messages"),
            Helper.messagesFromCurrentHttpContext()
        )).withHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        .withHeader("Pragma", "no-cache")
        .withHeader("Expires", "0");
    }

    public Result javascriptRoutes() {
        return ok(
                JavaScriptReverseRouter.create("jsRoutes",
                        controllers.routes.javascript.Application.logout(),
                        controllers.routes.javascript.Application.getOtpEmail(),
                        controllers.routes.javascript.Application.ForgetPassword(),
                        controllers.routes.javascript.FogotPassController.ChangePassword(),
                        controllers.routes.javascript.Application.getOtpPhone(),
                        controllers.routes.javascript.UserController.addNewUser(),
                        controllers.routes.javascript.UserController.getTokenSendPassUser(),
                        controllers.routes.javascript.UserController.addRoleForUser(),
                        controllers.routes.javascript.UserController.editUser(),
                        controllers.routes.javascript.UserController.deleteUser(),
                        controllers.routes.javascript.Application.checkIpLogin(),
                        controllers.routes.javascript.Application.verifyPhone(),

                        //Location Controller
                        controllers.routes.javascript.TelcoLocationController.searchByIsdn(),



                        controllers.routes.javascript.SendApiController.getDataWithParam(),
                        controllers.routes.javascript.SendApiController.portDataWithParam(),
                        controllers.routes.javascript.SendApiController.putDataWithParam(),
                        controllers.routes.javascript.SendApiController.upfileImage(),
                        controllers.routes.javascript.SendApiController.deleteDataWithParam(),

                        controllers.routes.javascript.UserController.updateUserOrg(),

                        controllers.routes.javascript.DownloadFileController.downloadFileFromApi(),


                        controllers.routes.javascript.FogotPassController.userGetCodeChangePass(),

                        controllers.routes.javascript.LandingPageController.home(),
                        controllers.routes.javascript.LandingPageController.submitFormContact(),
                        controllers.routes.javascript.LandingPageController.submitRegisterDeveloper(),
                        controllers.routes.javascript.LandingPageController.submitFormContactTelco(),
                        controllers.routes.javascript.LandingPageController.getListProductOfferPack(),

                        controllers.routes.javascript.AdminRegisterDeveloperController.exportRegisterDeveloperList(),

//                        PROJECT
                        controllers.routes.javascript.ProjectController.getProject(),
                        controllers.routes.javascript.ProjectController.createProjectForm(),
                        controllers.routes.javascript.ProjectController.addProject(),
                        controllers.routes.javascript.ProjectController.editProject(),
                        controllers.routes.javascript.ProjectController.delProject(),
                        controllers.routes.javascript.ProjectController.getNameProject(),
                        controllers.routes.javascript.ProjectController.sendPostJsonProjectTemplate(),
                        controllers.routes.javascript.ProjectController.sendPutJsonProjectTemplate(),
                        controllers.routes.javascript.ProjectController.createDashboardTemplate(),
                        controllers.routes.javascript.ProjectController.getListTag(),
                        controllers.routes.javascript.ProjectController.activePhone(),

                        controllers.routes.javascript.OverviewController.overview(),
                        controllers.routes.javascript.OverviewController.countDeviceAndUser(),
                        controllers.routes.javascript.OverviewController.countDevice7Day(),
                        controllers.routes.javascript.OverviewController.countUser7Day(),
                        controllers.routes.javascript.OverviewController.countMess7Day(),
                        controllers.routes.javascript.OverviewController.countDataLatency(),
                        controllers.routes.javascript.OverviewController.countDataSuccessRate(),

//                        DEVICE
                        controllers.routes.javascript.DeviceIotController.addNewDevice(),
                        controllers.routes.javascript.DeviceIotController.createDeviceWithSerialSim(),
                        controllers.routes.javascript.DeviceIotController.deleteDevice(),
                        controllers.routes.javascript.DeviceIotController.editNameDevice(),
                        controllers.routes.javascript.DeviceIotController.updateDevice(),
                        controllers.routes.javascript.DeviceIotController.configGpsDevice(),
                        controllers.routes.javascript.DeviceIotController.getConfigOfDeviceIot(),
                        controllers.routes.javascript.DeviceIotController.getListDeviceIot(),
                        controllers.routes.javascript.DeviceIotController.getListDeviceByGroup(),
                        controllers.routes.javascript.DeviceIotController.getListDeviceVarsByDevice(),
                        controllers.routes.javascript.DeviceIotController.getListDeviceByOrg(),
                        controllers.routes.javascript.DeviceIotController.getListDeviceAndAttrByOrg(),
                        controllers.routes.javascript.DeviceIotController.getListDeviceByDeviceType(),

//                        MESSAGE LOG
                        controllers.routes.javascript.LogDeviceController.getAllLogMessage(),

//                        VARIABLE
                        controllers.routes.javascript.DeviceVariableController.addVariable(),
                        controllers.routes.javascript.DeviceVariableController.delVariable(),
                        controllers.routes.javascript.DeviceVariableController.deviceVariable(),
                        controllers.routes.javascript.DeviceVariableController.getDataVariableById(),
                        controllers.routes.javascript.DeviceVariableController.getListVarByIdDevice(),

//                        ATTRIBUTE
                        controllers.routes.javascript.AttributeController.addAttribute(),
                        controllers.routes.javascript.AttributeController.deleteAttributeOrg(),
                        controllers.routes.javascript.AttributeController.editAttributeOrg(),
                        controllers.routes.javascript.AttributeController.attributeDevice(),
                        controllers.routes.javascript.AttributeController.getAttributeList(),
                        controllers.routes.javascript.AttributeController.getAttributeHistory(),
                        controllers.routes.javascript.AttributeController.attributeUser(),
                        controllers.routes.javascript.AttributeController.attributeEvent(),
                        controllers.routes.javascript.AttributeController.attributeTemplate(),
                        controllers.routes.javascript.AttributeController.attributeGroup(),
                        controllers.routes.javascript.AttributeController.getDataAttributeById(),
                        controllers.routes.javascript.AttributeController.getPositionDeviceByAttribute(),
                        controllers.routes.javascript.AttributeController.getLastValueAttribute(),
                        controllers.routes.javascript.AttributeController.getValueAttributeWithTime(),

//                        TYPE
                        controllers.routes.javascript.DeviceTypeController.addNewDeviceType(),
                        controllers.routes.javascript.DeviceTypeController.deleteDeviceType(),
                        controllers.routes.javascript.DeviceTypeController.editDeviceType(),
                        controllers.routes.javascript.DeviceTypeController.getListTypes(),

//                        ORG
                        controllers.routes.javascript.GroupController.addGroupRoot(),
                        controllers.routes.javascript.GroupController.getInfoOrg(),
                        controllers.routes.javascript.GroupController.getAttributeOrg(),
                        controllers.routes.javascript.GroupController.getGroupChildByGroupId(),
                        controllers.routes.javascript.GroupController.getListGroupOfOrg(),
                        controllers.routes.javascript.GroupController.getListUserOfOrg(),
                        controllers.routes.javascript.GroupController.getListDeviceOfOrg(),
                        controllers.routes.javascript.GroupController.getListEventOfOrg(),
                        controllers.routes.javascript.GroupController.getListRoleOfOrg(),
                        controllers.routes.javascript.GroupController.updateGroup(),
                        controllers.routes.javascript.GroupController.deleteGroup(),
                        controllers.routes.javascript.GroupController.updateRoleToGroupUser(),
                        controllers.routes.javascript.GroupController.getListOrganizations(),
                        controllers.routes.javascript.GroupController.processMoveUserToGroupOther(),
                        controllers.routes.javascript.GroupController.processMoveDeviceToGroupOther(),
                        controllers.routes.javascript.GroupController.createUserInOrg(),
                        controllers.routes.javascript.GroupController.updateUserToGroupDevice(),
                        controllers.routes.javascript.GroupController.updateRoleForUser(),

//                        GROUP
                        controllers.routes.javascript.GroupListController.addNewGroups(),
                        controllers.routes.javascript.GroupListController.deleteGroup(),
                        controllers.routes.javascript.GroupListController.editNameGroups(),
                        controllers.routes.javascript.GroupListController.updateOrgIdForGroups(),
                        controllers.routes.javascript.GroupListController.getListGroups(),
                        controllers.routes.javascript.GroupListController.getGroupWithEntityType(),
                        controllers.routes.javascript.GroupListController.getListGroupUser(),
                        controllers.routes.javascript.GroupListController.getListGroupDevice(),
                        controllers.routes.javascript.GroupListController.getListGroupEvent(),
                        controllers.routes.javascript.GroupListController.getListGroupOrganization(),

                        controllers.routes.javascript.DashboardController.getMarkersWithPaging(),
                        controllers.routes.javascript.DashboardController.getListDeviceWithPaging(),

                        controllers.routes.javascript.DashboardWidgetController.dashboardVer2(),

                        controllers.routes.javascript.DashboardWidgetController.getListDeviceWithWidgetMap(),
                        controllers.routes.javascript.DashboardWidgetController.getDeviceDataCurrent(),
                        controllers.routes.javascript.DashboardWidgetController.getHistoryRpc(),

                        controllers.routes.javascript.WidgetListController.widgetPage(),
                        controllers.routes.javascript.WidgetListController.saveWidgetData(),
                        controllers.routes.javascript.WidgetListController.getWidgetCurrent(),

                        controllers.routes.javascript.DashboardV3Controller.dashboardList(),
                        controllers.routes.javascript.DashboardV3Controller.getListDashboard(),
                        controllers.routes.javascript.DashboardV3Controller.addNewDashboard(),
                        controllers.routes.javascript.DashboardV3Controller.editContentDashboard(),
                        controllers.routes.javascript.DashboardV3Controller.deleteDashboard(),
                        controllers.routes.javascript.DashboardV3Controller.dashboard(),
                        controllers.routes.javascript.DashboardV3Controller.getDashboardWithId(),
                        controllers.routes.javascript.DashboardV3Controller.saveDashboard(),
                        controllers.routes.javascript.DashboardV3Controller.moveDashboardToOrg(),

                        controllers.routes.javascript.DashboardAppController.appDashboard(),
                        controllers.routes.javascript.DashboardAppController.getDashboardWithId(),
                        controllers.routes.javascript.DashboardAppController.getPositionDeviceByAttributeApp(),
                        controllers.routes.javascript.DashboardAppController.getListDeviceWithWidgetMapApp(),
                        controllers.routes.javascript.DashboardAppController.getDataAttributeByIdApp(),
                        controllers.routes.javascript.DashboardAppController.getLastValueAttributeApp(),
                        controllers.routes.javascript.DashboardAppController.sendMessageOnOffApp(),

                        controllers.routes.javascript.MessagesDeviceController.getMetadata(),
                        controllers.routes.javascript.MessagesDeviceController.sendMetadata(),
                        controllers.routes.javascript.MessagesDeviceController.sendMessageToDevice(),
                        controllers.routes.javascript.MessagesDeviceController.getMessageFormDevice(),
                        controllers.routes.javascript.MessagesDeviceController.postCreateDeviceToken(),
                        controllers.routes.javascript.MessagesDeviceController.sendMessageData(),
                        controllers.routes.javascript.MessagesDeviceController.sendMessageOnOff(),
                        controllers.routes.javascript.MessagesDeviceController.sendMessageOnOffApp(),
                        controllers.routes.javascript.MessagesDeviceController.sendCommandRPC(),

                        controllers.routes.javascript.HomeController.testPostFormUrlencoded(),
                        controllers.routes.javascript.HomeController.testPostJson(),
                        controllers.routes.javascript.HomeController.testGetByToken(),

                        //ROLE
                        controllers.routes.javascript.RoleController.addNewRole(),
                        controllers.routes.javascript.RoleController.deleteRole(),
                        controllers.routes.javascript.RoleController.getRole(),
                        controllers.routes.javascript.RoleController.updateRole(),

                        //Event
                        controllers.routes.javascript.EventController.getVarsByDevice(),
                        controllers.routes.javascript.EventController.addNewEvent(),
                        controllers.routes.javascript.EventController.addNewSchedule(),
                        controllers.routes.javascript.EventController.editEvent(),
                        controllers.routes.javascript.EventController.editSchedule(),
                        controllers.routes.javascript.EventController.onclickEvent(),
                        controllers.routes.javascript.EventController.deleteEvent(),
                        controllers.routes.javascript.EventController.getEvent(),
                        controllers.routes.javascript.EventController.updateEvent(),
                        controllers.routes.javascript.EventController.changeEventOrg(),
                        controllers.routes.javascript.EventController.removeEventOrg(),
                        controllers.routes.javascript.EventController.activeEvent(),
                        controllers.routes.javascript.EventController.deActiveEvent(),

                        controllers.routes.javascript.QrCodeController.createQrCode(),
                        controllers.routes.javascript.QrCodeController.getListQrCode(),
                        controllers.routes.javascript.QrCodeController.deleteQrCode(),
                        controllers.routes.javascript.QrCodeController.editQrCode(),

                        controllers.routes.javascript.QrCodeCamController.createQrCodeCam(),
                        controllers.routes.javascript.QrCodeCamController.deleteQrCodeCam(),

                        //device template
                        controllers.routes.javascript.DeviceTemplateController.createDeviceTemplate(),
                        controllers.routes.javascript.DeviceTemplateController.getListDeviceTemplate(),
                        controllers.routes.javascript.DeviceTemplateController.deleteDeviceTemplate(),
                        controllers.routes.javascript.DeviceTemplateController.createTemDevice(),

                        //pay
                        controllers.routes.javascript.PayPackDataController.addNewPackdata(),
                        controllers.routes.javascript.PayPackDataController.getListPackdata(),
                        controllers.routes.javascript.PayPackDataController.getInfoPackdata(),
                        controllers.routes.javascript.PayPackDataController.editPackdata(),
                        controllers.routes.javascript.PayPackDataController.deletePackdata(),

                        controllers.routes.javascript.PayCustomerController.getListUserInOrg(),
                        controllers.routes.javascript.PayCustomerController.addPackdataNewForUser(),
                        controllers.routes.javascript.PayCustomerController.postPricingOfCustomer(),
                        controllers.routes.javascript.PayCustomerController.getInfoCustomer(),
                        controllers.routes.javascript.PayCustomerController.createInfoCustomer(),
                        controllers.routes.javascript.PayCustomerController.updateInfoCustomer(),
                        controllers.routes.javascript.PayCustomerController.getInfoVendor(),
                        controllers.routes.javascript.PayCustomerController.createVendor(),
                        controllers.routes.javascript.PayCustomerController.updateVendor(),
                        controllers.routes.javascript.PayCustomerController.getSubscription(),
                        controllers.routes.javascript.PayCustomerController.createSubscription(),
                        controllers.routes.javascript.PayCustomerController.cancelSubscription(),

                        controllers.routes.javascript.PayBillController.getAllBill(),
                        controllers.routes.javascript.PayBillController.getLinkPayment(),
                        controllers.routes.javascript.PayBillController.getInfoBill(),
                        controllers.routes.javascript.PayBillController.getBillOfUser(),
                        controllers.routes.javascript.PayBillController.billUserList(),

                        controllers.routes.javascript.PaySubsController.getAllSubs(),
                        controllers.routes.javascript.PaySubsController.getInfoSub(),
                        controllers.routes.javascript.PaySubsController.getLinkPaymentSub(),

                        controllers.routes.javascript.ManageSimController.getDataCustomer(),
                        controllers.routes.javascript.ManageSimController.detailSim(),

                        //flow
                        controllers.routes.javascript.FlowEngineController.getListFlow(),
                        controllers.routes.javascript.FlowEngineController.addFlow(),

                        controllers.routes.javascript.RuleChainController.flowEngineWithId(),
                        controllers.routes.javascript.RuleChainController.ruleChain(),

                        controllers.routes.javascript.Application.newRegisterPost(),

                        controllers.routes.javascript.OAuthController.getLogin(),
                        controllers.routes.javascript.OAuthController.getConsent(),
                        controllers.routes.javascript.OAuthController.postLogin(),
                        controllers.routes.javascript.OAuthController.postConsent(),

                        controllers.routes.javascript.SolutionTrackingController.getListGpsDevice(),
                        controllers.routes.javascript.SolutionTrackingController.getInfoDevice(),
                        controllers.routes.javascript.SolutionTrackingController.loadLocationHistory(),

                        controllers.routes.javascript.WaterClockController.getListClock(),
                        controllers.routes.javascript.WaterClockController.getHistoryClock(),

                        controllers.routes.javascript.TemplateDeviceController.addTemplateDevice(),
                        controllers.routes.javascript.TemplateDeviceController.getListTemplateDevice(),
                        controllers.routes.javascript.TemplateDeviceController.getTemplateDeviceById(),
                        controllers.routes.javascript.TemplateDeviceController.editTemplateDevice(),
                        controllers.routes.javascript.TemplateDeviceController.deleteTemplateDevice(),

                        controllers.routes.javascript.AdminOverviewController.getTotalOverview(),
                        controllers.routes.javascript.AdminOverviewController.getInfoOVerviewSmarthome(),
                        controllers.routes.javascript.AdminOverviewController.getInfoOVerviewVtag(),
                        controllers.routes.javascript.AdminOverviewController.getInfoOVerviewFleet(),
                        controllers.routes.javascript.AdminOverviewController.getInfoOVerviewMetter(),
                        controllers.routes.javascript.AdminOverviewController.getListProjectWithPaging(),

                        controllers.routes.javascript.AdminManageSimController.getAllProjectWithPaging(),
                        controllers.routes.javascript.AdminManageSimController.getListDeviceWithProjectId(),
                        controllers.routes.javascript.AdminManageSimController.getAttrSimDevice(),

                        controllers.routes.javascript.AdminOverviewProjectController.adminOverviewProject(),

                        controllers.routes.javascript.AdminGroupProductController.getListGroupProduct(),
                        controllers.routes.javascript.AdminGroupProductController.addGroupProduct(),
                        controllers.routes.javascript.AdminGroupProductController.deleteGroupProduct(),
                        controllers.routes.javascript.AdminGroupProductController.editGroupProduct(),

                        controllers.routes.javascript.ProductListController.productList(),
                        controllers.routes.javascript.ProductListController.createProduct(),
                        controllers.routes.javascript.ProductListController.getProductByUser(),
                        controllers.routes.javascript.ProductListController.deleteProduct(),
                        controllers.routes.javascript.ProductListController.getProductById(),
                        controllers.routes.javascript.ProductListController.editProduct(),
                        controllers.routes.javascript.ProductListController.changeStatusProduct(),
                        controllers.routes.javascript.ProductListController.requestApproveProduct(),

                        controllers.routes.javascript.MarketPlaceController.getProductMarket(),
                        controllers.routes.javascript.MarketPlaceController.getAllProduct(),
                        controllers.routes.javascript.MarketPlaceController.getAllGroupProduct(),
                        controllers.routes.javascript.MarketPlaceController.getAllGroupSolution(),
                        controllers.routes.javascript.MarketPlaceController.getAllGroupDevice(),
                        controllers.routes.javascript.MarketPlaceController.getAllSolution(),
                        controllers.routes.javascript.MarketPlaceController.getAllDevice(),
                        controllers.routes.javascript.MarketPlaceController.detailProduct(),
                        controllers.routes.javascript.MarketPlaceController.getDetailProductWithId(),
                        controllers.routes.javascript.MarketPlaceController.getSameProduct(),
                        controllers.routes.javascript.MarketPlaceController.marketPlaceDevice(),
                        controllers.routes.javascript.MarketPlaceController.marketPlaceSolution(),

                        controllers.routes.javascript.MarketPlaceContactController.sendContactMarket(),

                        controllers.routes.javascript.MarketPlaceCommentController.commentWithProductId(),
                        controllers.routes.javascript.MarketPlaceCommentController.getListCommentProduct(),

                        controllers.routes.javascript.MarketPlaceContactController.editContactMarket(),

                        controllers.routes.javascript.UserTenantListController.getListUserTenant(),
                        controllers.routes.javascript.UserTenantListController.createUserTenant(),
                        controllers.routes.javascript.UserTenantListController.delUserTenant(),
                        controllers.routes.javascript.UserTenantListController.editUserTenant(),
                        controllers.routes.javascript.UserTenantListController.getListRoleOfOrg(),
                        controllers.routes.javascript.UserTenantListController.updateRoleUserPermission(),
                        controllers.routes.javascript.UserTenantListController.delRoleUserPermission(),

                        controllers.routes.javascript.TelcoDashboardController.getDataDashboardTelco(),
                        controllers.routes.javascript.TelcoDashboardController.getDataDashboardWithMonth(),
                        controllers.routes.javascript.TelcoDashboardController.getTop5DataUsersOfMonth(),
                        controllers.routes.javascript.TelcoDashboardController.getAlertDashboard(),
                        controllers.routes.javascript.TelcoDashboardController.getDetailAlertDashboard(),
                        controllers.routes.javascript.TelcoDashboardController.getSubscriberStatistics(),
                        controllers.routes.javascript.TelcoDashboardController.getBalanceDashboardTelco(),
                        controllers.routes.javascript.TelcoDashboardController.getListSubsDashboardByKey(),
                        controllers.routes.javascript.TelcoDashboardController.getListSubsDashboardBlockDebit(),
                        controllers.routes.javascript.TelcoDashboardController.getDetailRedAlert(),
                        controllers.routes.javascript.TelcoDashboardController.getDetailPrepaidExpired(),
                        controllers.routes.javascript.TelcoDashboardController.getDetailLowRemainingData(),
                        controllers.routes.javascript.TelcoDashboardController.getDetailPackageExpired(),

                        controllers.routes.javascript.TelcoAccountController.updateDetailAccountTelco(),
                        controllers.routes.javascript.TelcoAccountController.updateInfoCompanyTelco(),
                        controllers.routes.javascript.TelcoAccountController.deleteInfoCompany(),
                        controllers.routes.javascript.TelcoAccountController.getInfoAccount(),
                        controllers.routes.javascript.TelcoAccountController.accountInfo(),
                        controllers.routes.javascript.TelcoAccountController.getInfoCompany(),
                        controllers.routes.javascript.TelcoAccountController.getInfoCompanyEnterpriseLv2(),
                        controllers.routes.javascript.TelcoAccountController.getListArea(),
                        controllers.routes.javascript.TelcoAccountController.getInfoGpkdApproved(),
                        controllers.routes.javascript.TelcoAccountController.getCategoryBusinessAndDevice(),
                        controllers.routes.javascript.TelcoAccountController.updateCategoryBusinessAndDevice(),

                        controllers.routes.javascript.TelcoQrcodeController.getListQrcodeCmp(),
                        controllers.routes.javascript.TelcoQrcodeController.checkValidateSerialAdm1(),
                        controllers.routes.javascript.TelcoQrcodeController.getListGpkd(),
                        controllers.routes.javascript.TelcoQrcodeController.saveFileChungTu(),
                        controllers.routes.javascript.TelcoQrcodeController.createQrcode(),
                        controllers.routes.javascript.TelcoQrcodeController.getInfoConnectSubs(),
                        controllers.routes.javascript.TelcoQrcodeController.paymentConnectSubs(),
                        controllers.routes.javascript.TelcoQrcodeController.delQrcodeById(),

                        controllers.routes.javascript.AdminTelcoController.getListInfoApproved(),
                        controllers.routes.javascript.AdminTelcoController.processComfirmInfoAccountCmp(),
                        controllers.routes.javascript.AdminTelcoController.processComfirmInfoCompany(),
                        controllers.routes.javascript.AdminTelcoController.getListEnterpriseByBrowser(),
                        controllers.routes.javascript.AdminTelcoController.getListEnterpriseSubmitOfAdminSpe(),

                        controllers.routes.javascript.TelcoSubscriberController.subscriberManage(),
                        controllers.routes.javascript.TelcoSubscriberController.getListSubscriber(),
                        controllers.routes.javascript.TelcoSubscriberController.getListSubsByBeVht(),
                        controllers.routes.javascript.TelcoSubscriberController.getDetailSubscriber(),
                        controllers.routes.javascript.TelcoSubscriberController.subscriberDetail(),
                        controllers.routes.javascript.TelcoSubscriberController.getListProductOffering(),
                        controllers.routes.javascript.TelcoSubscriberController.getInfoDataAccount(),
                        controllers.routes.javascript.TelcoSubscriberController.getTotalSubscriber(),
                        controllers.routes.javascript.TelcoSubscriberController.getHybridInfo(),
                        controllers.routes.javascript.TelcoSubscriberController.getCtkm(),
                        controllers.routes.javascript.TelcoSubscriberController.getBalanceInfo(),
                        controllers.routes.javascript.TelcoSubscriberController.getDebitSubscriber(),
                        controllers.routes.javascript.TelcoSubscriberController.getKttkAndKtmi(),
                        controllers.routes.javascript.TelcoSubscriberController.blockSubcriber(),
                        controllers.routes.javascript.TelcoSubscriberController.openSubcriber(),
                        controllers.routes.javascript.TelcoSubscriberController.open2wSubcriber(),

                        controllers.routes.javascript.TelcoContractController.getListAccountContract(),
                        controllers.routes.javascript.TelcoContractController.getDebitContract(),
                        controllers.routes.javascript.TelcoContractController.getTotalAccount(),
                        controllers.routes.javascript.TelcoContractController.getListContractByIdNo(),

                        controllers.routes.javascript.TelcoInvoiceController.invoiceOfContract(),
                        controllers.routes.javascript.TelcoInvoiceController.getListInvoiceOfContract(),
                        controllers.routes.javascript.TelcoInvoiceController.getLinkDownloadInvoice(),

                        controllers.routes.javascript.TelcoUtilitiesController.getListPackMiAndAddOn(),
                        controllers.routes.javascript.TelcoUtilitiesController.registerMiAddon(),
                        controllers.routes.javascript.TelcoUtilitiesController.unregisterMiAddon(),
                        controllers.routes.javascript.TelcoUtilitiesController.unextendMiAddon(),
                        controllers.routes.javascript.TelcoUtilitiesController.getInfoOrderId(),
                        controllers.routes.javascript.TelcoUtilitiesController.rechargeSubcriber(),
                        controllers.routes.javascript.TelcoUtilitiesController.getListOrderIdByAction(),
                        controllers.routes.javascript.TelcoUtilitiesController.getHistoryBlockUnblock(),
                        controllers.routes.javascript.TelcoUtilitiesController.validateSubs(),
                        controllers.routes.javascript.TelcoUtilitiesController.prepayChargesBill(),
                        controllers.routes.javascript.TelcoUtilitiesController.getDataPrepaidInfo(),
                        controllers.routes.javascript.TelcoUtilitiesController.rechargePrepaid(),
                        controllers.routes.javascript.TelcoUtilitiesController.getHistoryPrepayCharges(),
                        controllers.routes.javascript.TelcoUtilitiesController.payDebit(),
                        controllers.routes.javascript.TelcoUtilitiesController.payPostpaidBillDetail(),
                        controllers.routes.javascript.TelcoUtilitiesController.getHistoryPayPostBill(),

                        controllers.routes.javascript.TelcoOrderController.getDataTelcoByUrl(),
                        controllers.routes.javascript.TelcoOrderController.checkValidateSerialSim(),
                        controllers.routes.javascript.TelcoOrderController.getListReasonFull(),
                        controllers.routes.javascript.TelcoOrderController.getConnectSubscriberRamdom(),
                        controllers.routes.javascript.TelcoOrderController.searchSubscriberByStock(),
                        controllers.routes.javascript.TelcoOrderController.blockIsdnVht(),
                        controllers.routes.javascript.TelcoOrderController.unlockIsdnVht(),
                        controllers.routes.javascript.TelcoOrderController.connectSubscriberSim(),
                        controllers.routes.javascript.TelcoOrderController.getListProductOffer(),
                        controllers.routes.javascript.TelcoOrderController.getListSaleService(),
                        controllers.routes.javascript.TelcoOrderController.getListSaleService1(),
                        controllers.routes.javascript.TelcoOrderController.processOrderBuySim(),
                        controllers.routes.javascript.TelcoOrderController.getListOrderBuySim(),
                        controllers.routes.javascript.TelcoOrderController.upfilePycTelco(),
                        controllers.routes.javascript.TelcoOrderController.getCustomerType(),
                        controllers.routes.javascript.TelcoOrderController.getListCt(),

                        controllers.routes.javascript.TelcoLogController.getLogConnectSim(),

                        controllers.routes.javascript.TelcoRoleAccountController.getListAccountCmp(),
                        controllers.routes.javascript.TelcoRoleAccountController.addAccountCmp(),
                        controllers.routes.javascript.TelcoRoleAccountController.addAccountCmpV2(),
                        controllers.routes.javascript.TelcoRoleAccountController.infoAccountCmp(),
                        controllers.routes.javascript.TelcoRoleAccountController.getInfoAccountCmp(),
                        controllers.routes.javascript.TelcoRoleAccountController.generatePassAccountCmp(),
                        controllers.routes.javascript.TelcoRoleAccountController.addEnterpriseBySAdmin(),
                        controllers.routes.javascript.TelcoRoleAccountController.addEnterpriseByAdminOrSEnterprise(),
                        controllers.routes.javascript.TelcoRoleAccountController.deleteEnterprise(),
                        controllers.routes.javascript.TelcoRoleAccountController.editEnterprise(),
                        controllers.routes.javascript.TelcoRoleAccountController.updateEnterprise(),
                        controllers.routes.javascript.TelcoRoleAccountController.deleteAccountCmp(),
                        controllers.routes.javascript.TelcoRoleAccountController.validateGpkd(),
                        controllers.routes.javascript.TelcoRoleAccountController.checkValidateGpkd(),
                        controllers.routes.javascript.TelcoRoleAccountController.updatRoleAccountCmp(),

                        controllers.routes.javascript.TelcoHistoryController.getHistoryPackMiAddon(),
                        controllers.routes.javascript.TelcoHistoryController.getHistoryApn(),

                        controllers.routes.javascript.TelcoChildUserController.getListChildUser(),
                        controllers.routes.javascript.TelcoChildUserController.addChildUserCmp(),
                        controllers.routes.javascript.TelcoChildUserController.getRolesOfChildUser(),
                        controllers.routes.javascript.TelcoChildUserController.updateRolesOfChildUser(),
                        controllers.routes.javascript.TelcoChildUserController.childUserDetail(),
                        controllers.routes.javascript.TelcoChildUserController.getListSubsOfChildUser(),
                        controllers.routes.javascript.TelcoChildUserController.addSubToChildUser(),
                        controllers.routes.javascript.TelcoChildUserController.addSubToChildUser1(),
                        controllers.routes.javascript.TelcoChildUserController.validateSubToChildUser1(),
                        controllers.routes.javascript.TelcoChildUserController.removeSubOfChildUser(),

                        controllers.routes.javascript.TelcoFeedbackController.sendFeedback(),
                        controllers.routes.javascript.TelcoFeedbackController.getLogListFeedback(),

                        controllers.routes.javascript.TelcoLogController.getLogListCmp(),
                        controllers.routes.javascript.TelcoLogController.updateFormCustomerSurvey(),
                        controllers.routes.javascript.TelcoLogController.getLogListCustomerSurvey(),
                        controllers.routes.javascript.TelcoLogController.editSurvey(),
                        controllers.routes.javascript.TelcoLogController.deleteSurvey(),
                        controllers.routes.javascript.TelcoLogController.getInfoSurvey(),
                        controllers.routes.javascript.TelcoLogController.exportLogCustomerSurvey(),
                        controllers.routes.javascript.TelcoLogController.saveFormCustomerSurvey(),

                        controllers.routes.javascript.TelcoApiKeyController.getListApiKey(),



                        controllers.routes.javascript.TelcoAepController.requestDataAepWeather(),
                        controllers.routes.javascript.TelcoAepController.requestDataAepGps(),

                        controllers.routes.javascript.OrderSearchController.getSearchOrder(),
                        //APN
                        controllers.routes.javascript.TelcoAPNController.getAPNByPhone(),
                        controllers.routes.javascript.TelcoAPNController.registerAPN(),
                        controllers.routes.javascript.TelcoAPNController.unRegisterAPN(),
                        controllers.routes.javascript.TelcoAPNController.getIpAllow(),

                        //Invoice Manager
                        controllers.routes.javascript.InvoiceManagerController.getInvoices(),
                        controllers.routes.javascript.InvoiceManagerController.getInvoiceBase64(),

                        //Statistical Report
                        controllers.routes.javascript.TelcoStatisticalReportController.RedBaring(),
                        controllers.routes.javascript.TelcoStatisticalReportController.getRedBarings(),
                        controllers.routes.javascript.TelcoStatisticalReportController.ExpiratedPackage(),
                        controllers.routes.javascript.TelcoStatisticalReportController.getExpiratedPackages()
                )

        ).as("text/javascript");

    }
}
