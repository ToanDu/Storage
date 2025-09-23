package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import views.html.telco.log.LogCmp;
import vn.m2m.common.dao.UserDAO;
import vn.m2m.common.models.Role;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.CustomerSurveyDAO;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.CustomerSurvey;
import vn.m2m.iot.models.Organization;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 3/20/23.
 */
@Security.Authenticated(Secured.class)
public class TelcoLogController extends AbstractController {
    @Inject
    public UserDAO userDAO;
    @Inject
    public TelcoLogDAO telcoLogDAO;
    @Inject
    public ApiService apiService;
    @Inject
    public CustomerSurveyDAO customerSurveyDAO;

    public Result logCmp(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.telco.log.LogCmp.render(userSession));
    }

    public Result getLogListCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        int page = jsonGroup.get("page").asInt();
        int pageSize = jsonGroup.get("pageSize").asInt();
        String username = jsonGroup.get("username") != null ? jsonGroup.get("username").asText() : " ";
        String function = jsonGroup.get("function") != null ? jsonGroup.get("function").asText() : "";
//        String action = jsonGroup.get("action") != null ? jsonGroup.get("action").asText() : "";
        String url = jsonGroup.get("url") != null ? jsonGroup.get("url").asText() : "";

        Map<String, Object> returnData = new HashMap<>();

        List<TelcoLog> logCmpList = telcoLogDAO.getLogListCmpPaging(page, pageSize, username, function, url);
        logger.info("logCmpList : {}", logCmpList.size());
        returnData.put("logCmp", logCmpList);


        long countLogListCmp = telcoLogDAO.countLogListCmp(username, function, url);
        returnData.put("total", countLogListCmp);

        respone.setContent(returnData);
        return ok(Json.toJson(respone));
    }

    //lich su dau noi
    public Result logConnectSim(String userId){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.order.log.LogConnectSim.render(userSession, userId));
    }
    public Result getLogConnectSim() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String action = jsonGroup.get("action") != null ? jsonGroup.get("action").asText() : " ";
        String user_id = jsonGroup.get("userId").asText();
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("offset", Integer.toString(startAt));
        param.put("limit", Integer.toString(pageSize));
        param.put("action", action);
        param.put("user_id", user_id);
        logger.info("param : {}", param);

        String url = appfileConfig.urlBackendIotTelco + "/api/pricing/payment/telco/query";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("url : {}", url);
        logger.info("getLogConnectSim : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getLogConnectSim");
        telcoLog.setContent("Lay lich su dau noi");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //khảo sát KH
    public Result updateFormCustomerSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String nameEnterprise = jsonGroup.get("nameEnterprise").asText();
        String typeBusiness = jsonGroup.get("typeBusiness").asText();
        String typeDevice = jsonGroup.get("typeDevice").asText();

        int experience = jsonGroup.get("experience").asInt();
        int easeUse = jsonGroup.get("easeUse").asInt();
        String sometimeUse = jsonGroup.get("sometimeUse").asText();
        int manageSubs = jsonGroup.get("manageSubs").asInt();
        int manageContract = jsonGroup.get("manageContract").asInt();
        int manageOrder = jsonGroup.get("manageOrder").asInt();
        int blockSub = jsonGroup.get("blockSub").asInt();
        int open1Way = jsonGroup.get("open1Way").asInt();
        int open2Way = jsonGroup.get("open2Way").asInt();
        int rechargeMoney = jsonGroup.get("rechargeMoney").asInt();
        int miAddon = jsonGroup.get("miAddon").asInt();
        String contentFeedback = jsonGroup.get("contentFeedback").asText();
        int payFeeConnect = jsonGroup.get("payFeeConnect").asInt();
        int payFeePackage = jsonGroup.get("payFeePackage").asInt();
        int payFeeOpenSub = jsonGroup.get("payFeeOpenSub").asInt();
        int payFeeBlockSub = jsonGroup.get("payFeeBlockSub").asInt();
        int payFeeRecharge = jsonGroup.get("payFeeRecharge").asInt();
        int payFeeMiAddon = jsonGroup.get("payFeeMiAddon").asInt();
        String extraFeatures = jsonGroup.get("extraFeatures").asText();
        String hard = jsonGroup.get("hard").asText();
        String contentUsePlatformOther = jsonGroup.get("contentUsePlatformOther").asText();
        String contentFeeOneMonth = jsonGroup.get("contentFeeOneMonth").asText();
        String hardMonth = jsonGroup.get("hardMonth").asText();
        int realyUse = jsonGroup.get("realyUse").asInt();

        CustomerSurvey customerSurvey = new CustomerSurvey();
        customerSurvey.setUsername(userSession.getUsername());
        customerSurvey.setSurvey(true);
        customerSurvey.setNameEnterprise(nameEnterprise);
        customerSurvey.setTypeBusiness(typeBusiness);
        customerSurvey.setTypeDevice(typeDevice);

        customerSurvey.setExperience(experience);
        customerSurvey.setEaseUse(easeUse);
        customerSurvey.setSometimeUse(sometimeUse);
        customerSurvey.setManageSubs(manageSubs);
        customerSurvey.setManageContract(manageContract);
        customerSurvey.setManageOrder(manageOrder);
        customerSurvey.setBlockSub(blockSub);
        customerSurvey.setOpen1Way(open1Way);
        customerSurvey.setOpen2Way(open2Way);
        customerSurvey.setRechargeMoney(rechargeMoney);
        customerSurvey.setMiAddon(miAddon);
        customerSurvey.setContentFeedback(contentFeedback);
        customerSurvey.setPayFeeConnect(payFeeConnect);
        customerSurvey.setPayFeePackage(payFeePackage);
        customerSurvey.setPayFeeOpenSub(payFeeOpenSub);
        customerSurvey.setPayFeeBlockSub(payFeeBlockSub);
        customerSurvey.setPayFeeRecharge(payFeeRecharge);
        customerSurvey.setPayFeeMiAddon(payFeeMiAddon);
        customerSurvey.setExtraFeatures(extraFeatures);
        customerSurvey.setHard(hard);
        customerSurvey.setContentUsePlatformOther(contentUsePlatformOther);
        customerSurvey.setContentFeeOneMonth(contentFeeOneMonth);
        customerSurvey.setHardMonth(hardMonth);
        customerSurvey.setRealyUse(realyUse);
        customerSurveyDAO.save(customerSurvey);

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result logCustomerSurvey(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.telco.log.survey.LogSurvey.render(userSession));
    }

    public Result getLogListCustomerSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        int page = jsonGroup.get("page").asInt();
        int pageSize = jsonGroup.get("pageSize").asInt();
        String email = jsonGroup.get("email") != null ? jsonGroup.get("email").asText() : " ";

        Map<String, Object> returnData = new HashMap<>();

        List<CustomerSurvey> logListCustomerSurveyPaging = customerSurveyDAO.getLogListCustomerSurveyPaging(page, pageSize);
        logger.info("logList : {}", logListCustomerSurveyPaging.size());
        returnData.put("logCmp", logListCustomerSurveyPaging);

        long countLogList = customerSurveyDAO.countLogListCustomerSurvey();
        returnData.put("total", countLogList);

        respone.setContent(returnData);
        return ok(Json.toJson(respone));
    }

    public Result getInfoSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        if(userSession.getCmpRole() == User.CmpRole.SUPER_ADMIN.getCode() || userSession.getCmpRole() == User.CmpRole.ADMIN.getCode()){
            respone.setIssuccess(true);
            respone.setErrorString(getMessages().at("Không hiện khảo sát với admin và sadmin"));
            return ok(Json.toJson(respone));
        }

        User user = userDAO.getByKey(userId);

        List<CustomerSurvey> customerSurveys = customerSurveyDAO.getCustomerSurveyByUsername(user.getUsername());
        if(customerSurveys.size() > 0){
            respone.setContent(customerSurveys);
            respone.setResultString(getMessages().at("noti.Getsuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy khảo sát"));
            return ok(Json.toJson(respone));
        }
    }


    public Result editSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id") != null ? jsonGroup.get("id").asText() : " ";
        boolean isSurvey = jsonGroup.get("isSurvey").asBoolean();

        CustomerSurvey customerSurvey = customerSurveyDAO.getByKey(id);
        if(customerSurvey != null){
            customerSurvey.setSurvey(isSurvey);
            customerSurveyDAO.save(customerSurvey);

            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy khảo sát"));
            return ok(Json.toJson(respone));
        }
    }

    public Result deleteSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id") != null ? jsonGroup.get("id").asText() : " ";

        CustomerSurvey customerSurvey = customerSurveyDAO.getByKey(id);
        if(customerSurvey != null){
            customerSurveyDAO.deleteByKey(id);

            respone.setResultString(getMessages().at("noti.Deletesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy khảo sát"));
            return ok(Json.toJson(respone));
        }
    }

    public Result exportLogCustomerSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<CustomerSurvey> logListCustomerSurvey = customerSurveyDAO.getAll();
        logger.info("logList : {}", logListCustomerSurvey.size());

        respone.setContent(logListCustomerSurvey);
        return ok(Json.toJson(respone));
    }

    public Result saveFormCustomerSurvey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String tenKhachHang = jsonGroup.get("tenKhachHang").asText();
        String ngLienHe = jsonGroup.get("ngLienHe").asText();
        String chucVu = jsonGroup.get("chucVu").asText();
        int soThueBao = jsonGroup.get("soThueBao").asInt();
        String q1 = jsonGroup.get("q1").asText();
        String q2 = jsonGroup.get("q2").asText();
        String q3 = jsonGroup.get("q3").asText();
        String q4 = jsonGroup.get("q4").asText();
        String q5 = jsonGroup.get("q5").asText();
        String q6 = jsonGroup.get("q6").asText();
        String q7 = jsonGroup.get("q7").asText();
        String q8 = jsonGroup.get("q8").asText();
        String q9 = jsonGroup.get("q9").asText();
        String q10 = jsonGroup.get("q10").asText();
        String q11 = jsonGroup.get("q11").asText();
        String q12 = jsonGroup.get("q12").asText();
        String q13 = jsonGroup.get("q13").asText();
        String q14 = jsonGroup.get("q14").asText();
        String q15 = jsonGroup.get("q15").asText();
        String q16 = jsonGroup.get("q16").asText();
        String q17 = jsonGroup.get("q17").asText();
        String q18 = jsonGroup.get("q18").asText();
        String q19 = jsonGroup.get("q19").asText();
        String q20 = jsonGroup.get("q20").asText();
        String q21 = jsonGroup.get("q21").asText();

        CustomerSurvey customerSurvey = new CustomerSurvey();
        customerSurvey.setUsername(userSession.getUsername());
        customerSurvey.setTenKhachHang(tenKhachHang);
        customerSurvey.setNgLienHe(ngLienHe);
        customerSurvey.setChucVu(chucVu);
        customerSurvey.setSoThueBao(soThueBao);
        customerSurvey.setQ1(q1);
        customerSurvey.setQ2(q2);
        customerSurvey.setQ3(q3);
        customerSurvey.setQ4(q4);
        customerSurvey.setQ5(q5);
        customerSurvey.setQ6(q6);
        customerSurvey.setQ7(q7);
        customerSurvey.setQ8(q8);
        customerSurvey.setQ9(q9);
        customerSurvey.setQ10(q10);
        customerSurvey.setQ11(q11);
        customerSurvey.setQ12(q12);
        customerSurvey.setQ13(q13);
        customerSurvey.setQ14(q14);
        customerSurvey.setQ15(q15);
        customerSurvey.setQ16(q16);
        customerSurvey.setQ17(q17);
        customerSurvey.setQ18(q18);
        customerSurvey.setQ19(q19);
        customerSurvey.setQ20(q20);
        customerSurvey.setQ21(q21);
        customerSurveyDAO.save(customerSurvey);

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }
}
