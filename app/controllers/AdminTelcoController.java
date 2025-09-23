package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 2/3/23.
 */
@Security.Authenticated(Secured.class)
public class AdminTelcoController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result approvedInfoCompanyTelco() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.admin.ApprovedInfoCompany.render(userSession));
    }

    public Result getListInfoApproved() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String email = jsonGroup.get("email") != null ? jsonGroup.get("email").asText() : "";
        String phone = jsonGroup.get("phone") != null ? jsonGroup.get("phone").asText() : "";
        String name = jsonGroup.get("name") != null ? jsonGroup.get("name").asText() : "";
        String businessLicense = jsonGroup.get("businessLicense") != null ? jsonGroup.get("businessLicense").asText() : "";
        String status = jsonGroup.get("status") != null ? jsonGroup.get("status").asText() : "";
        String role_cmp = jsonGroup.get("role_cmp") != null ? jsonGroup.get("role_cmp").asText() : "";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("phone", phone);
        param.put("email", email);
        param.put("name", name);
        param.put("businessLicense", businessLicense);
        param.put("status", status);
        param.put("cmpRole", role_cmp);

        param.put("offset", String.valueOf(startAt));
        param.put("limit", String.valueOf(pageSize));
        logger.info("param : {}", Json.toJson(param));

        String url = appfileConfig.ulrBackendIot + "/api/users/cmp/approve";
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getInfoCompany: {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListInfoApproved");
        telcoLog.setContent("Lay danh sach yeu cau phe duyet");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
//        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result processComfirmInfoAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id  = jsonGroup.get("id").asText();
        String status  = jsonGroup.get("status").asText();
        String description  = jsonGroup.get("description") != null ? jsonGroup.get("description").asText() : "";
        boolean update_info_only = jsonGroup.get("update_info_only").asBoolean();

        Map<String, Object> body = new HashMap<>();
        body.put("status", status);
        if(!StringUtils.isEmpty(description)){
            body.put("description", description);
        }
        body.put("update_info_only", update_info_only);
        logger.info("body :{}", Json.toJson(body));
        String url = appfileConfig.ulrBackendIot + "/api/users/cmp/approve/"+id;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("apiResult: {}", apiResult.getJsonData());
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("processComfirmInfoCompany");
        telcoLog.setContent("Phe duyet thong tin tai khoan");
        telcoLog.setUrl(url);
//        telcoLog.setParam(String.valueOf(param));
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result processComfirmInfoCompany() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id  = jsonGroup.get("id").asText();
        String status  = jsonGroup.get("status").asText();
        String description  = jsonGroup.get("description") != null ? jsonGroup.get("description").asText() : "";

        Map<String, Object> body = new HashMap<>();
        body.put("status", status);
        body.put("description", description);
        body.put("cmp_role", "ENTERPRISE");
        logger.info("request :{}", request().body().asJson());
        logger.info("body :{}", Json.toJson(body));
        String url = appfileConfig.ulrBackendIot + "/api/users/enterprise/approve/"+id;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("apiResult: {}", apiResult.getJsonData());
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("processComfirmInfoCompany");
        telcoLog.setContent("Phe duyet thong tin doanh nghiep");
        telcoLog.setUrl(url);
//        telcoLog.setParam(String.valueOf(param));
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListEnterpriseByBrowser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId") != null ? jsonGroup.get("userId").asText() : "";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("offset", String.valueOf(startAt));
        param.put("limit", String.valueOf(pageSize));
        logger.info("param : {}", Json.toJson(param));

        String url = appfileConfig.ulrBackendIot + "/api/users/"+ userId + "/enterprise";
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        logger.info("getInfoCompany: {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListEnterpriseByBrowser");
        telcoLog.setContent("Lay thong tin DN can duyet");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListEnterpriseSubmitOfAdminSpe() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId") != null ? jsonGroup.get("userId").asText() : "";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
//        param.put("userId", userId);
        param.put("offset", String.valueOf(startAt));
        param.put("limit", String.valueOf(pageSize));
        param.put("status", "SUBMITTED");
        logger.info("param : {}", Json.toJson(param));

        String url = appfileConfig.ulrBackendIot + "/api/users/"+ userId + "/enterprise";
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        logger.info("getInfoCompany: {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListEnterpriseSubmitOfAdminSpe");
        telcoLog.setContent("Lay ds GPKD can duyet cua admin/ dai ly");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
}
