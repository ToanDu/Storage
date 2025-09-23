package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 12/21/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoDashboardController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result telcoDashboard(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            logger.info("sessionTelcoDashboard :{}", userSession);
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }
//        if (!userSession.isBusinessLicense()) {
//            return redirect(routes.TelcoAccountController.accountInfo());
//        }
        logger.info("sessionTelcoDashboard2 :{}", userSession);
        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.dashboard.DashboardTelco.render(userSession, userId));
    }

    public Result getDataDashboardTelco() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
//        String isCurrent = jsonGroup.get("isCurrent").asText();
        String from = (jsonGroup.get("from") != null) ? jsonGroup.get("from").asText() :"";
        String to = (jsonGroup.get("to") != null) ? jsonGroup.get("to").asText() :"";

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
//        param.put("isCurrent", isCurrent);
        if(!StringUtils.isEmpty(from)){
            param.put("from", from);
        }
        if(!StringUtils.isEmpty(to)){
            param.put("to", to);
        }
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/dashboard";
//        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDataDashboardTelco : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDataDashboardTelco");
        telcoLog.setContent("Lấy dữ liệu dashboard");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getTop5DataUsersOfMonth() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        int limit = (jsonGroup.get("limit") != null) ? jsonGroup.get("limit").asInt(): 5;
        String from = (jsonGroup.get("from") != null) ? jsonGroup.get("from").asText() :"";
        String to = (jsonGroup.get("to") != null) ? jsonGroup.get("to").asText() :"";
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";

        Map<String, String> param = new HashMap<>();
        param.put("limit", Integer.toString(limit));
        param.put("from", from);
        param.put("to", to);
        param.put("userId", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/subscriber/listUsedData";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getTop5DataUsersOfMonth : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getTop5DataUsersOfMonth");
        telcoLog.setContent("Lấy dữ liệu dashboard");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getAlertDashboard() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        int limit = (jsonGroup.get("limit") != null) ? jsonGroup.get("limit").asInt(): 5;
        String date = (jsonGroup.get("date") != null) ? jsonGroup.get("date").asText() :"";
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";

        Map<String, String> param = new HashMap<>();
        param.put("limit", Integer.toString(limit));
        param.put("date", date);
        param.put("user_id", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/alerts/summary";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getAlertDashboard : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getAlertDashboard");
        telcoLog.setContent("Lấy dữ liệu cảnh báo");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getDetailAlertDashboard() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String date = (jsonGroup.get("date") != null) ? jsonGroup.get("date").asText() :"";
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        String detail = (jsonGroup.get("detail") != null) ? jsonGroup.get("detail").asText() :"summary";
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int offset = (page-1)*pageSize;
        Map<String, String> param = new HashMap<>();
        // param.put("limit", Integer.toString(limit));
        // param.put("offset", Integer.toString(offset));
        param.put("date", date);
        param.put("userId", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/alerts/" + detail + "?limit=" + pageSize + "&offset=" + offset;

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDetailAlertDashboard : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDetailAlertDashboard");
        telcoLog.setContent("Lấy chi tiết dữ liệu cảnh báo");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //Thuê bao hoạt động
    public Result getSubscriberStatistics() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/subscriber/statistics";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("get : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getSubscriberStatistics");
        telcoLog.setContent("Lấy dữ liệu thuê bao hoạt động");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getDataDashboardWithMonth() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
        String nMonth = jsonGroup.get("nMonth").asText();

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("nMonth", nMonth);
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/dashboard/month";
//        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDataDashboardWithMonth : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDataDashboardWithMonth");
        telcoLog.setContent("Lay thue bao luy ke theo thang");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getBalanceDashboardTelco() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/dashboard/contract";
//        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDataDashboardTelco : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDataDashboardTelco");
        telcoLog.setContent("Lấy dữ liệu dashboard");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListSubsDashboardByKey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
        String key = jsonGroup.get("key").asText();
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int offset = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", offset, pageSize);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/subscriber?limit="+pageSize+"&offset="+Integer.toString(offset)+"&userId="+userId+"&queryDashboardType="+key;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getListSubsDashboardByKey : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListSubsDashboardByKey");
        telcoLog.setContent("Lay danh sach thue bao TK goc < 1000 dashboard");
        telcoLog.setUrl(url);
//        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListSubsDashboardBlockDebit() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int offset = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", offset, pageSize);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/listSubscribe?rowNum="+pageSize+"&startAt="+Integer.toString(offset)+"&userId="+userId+"&payType=1&actStatus=010";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getListSubsDashboardBlockDebit : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListSubsDashboardBlockDebit");
        telcoLog.setContent("Lay danh sach thue bao chan 1 chieu no cuoc dashboard");
        telcoLog.setUrl(url);
//        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getDetailRedAlert() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int offset = (page-1)*pageSize;
        Map<String, String> param = new HashMap<>();
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(offset));
        param.put("user_id", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/alerts/red_alert";

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDetailRedAlert : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDetailRedAlert");
        telcoLog.setContent("Lấy chi tiết dữ liệu cảnh báo báo động đỏ");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
    public Result getDetailPrepaidExpired() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int offset = (page-1)*pageSize;
        Map<String, String> param = new HashMap<>();
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(offset));
        param.put("user_id", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/alerts/prepaid_expired";

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDetailPrepaidExpired : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDetailPrepaidExpired");
        telcoLog.setContent("Cảnh báo hết hạn cước đóng trước");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getDetailLowRemainingData() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int offset = (page-1)*pageSize;
        Map<String, String> param = new HashMap<>();
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(offset));
        param.put("user_id", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/alerts/low_remaining_data";

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDetailLowRemainingData : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDetailLowRemainingData");
        telcoLog.setContent("Lưu lượng data còn lại dưới 20%");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
    public Result getDetailPackageExpired() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        int expiredInDays = (jsonGroup.get("expiredInDays") != null) ? jsonGroup.get("expiredInDays").asInt(): 1;
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int offset = (page-1)*pageSize;
        Map<String, String> param = new HashMap<>();
        param.put("expired_in_days", Integer.toString(expiredInDays));
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(offset));
        param.put("user_id", userId);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/alerts/package_expired";

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDetailPackageExpired : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDetailPackageExpired");
        telcoLog.setContent("Danh sách thuê bao hết hạn gói cước");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
}

