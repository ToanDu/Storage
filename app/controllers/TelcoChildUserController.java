package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class TelcoChildUserController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result listChildUser(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.childUser.ChildUserList.render(userSession, userId));
    }

    public Result getListChildUser() {
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
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(startAt));
        param.put("email", jsonGroup.get("email")!= null ?jsonGroup.get("email").asText():"");
        logger.info("emailLV2 : {}", Json.toJson(jsonGroup.get("email")));
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+userId+"/child";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);

        logger.info("getListChildUser : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result addChildUserCmp(String userId) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String cmp_role = jsonGroup.get("cmp_role").asText();
        String phone = jsonGroup.get("phone").asText();
        String email = jsonGroup.get("email").asText();

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("cmp_role", cmp_role);
        param.put("phone", phone);
        param.put("email", email);
        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+userId;
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(param), token);
        logger.info("url : {}", url);
        logger.info("addAccountCmp : {}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if (apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setErrorString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("addChildUserCmp");
        telcoLog.setContent("Tao tai khoan DN cap 2");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getRolesOfChildUser() {
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

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/roles/cmp/"+userId;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getRolesOfChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result updateRolesOfChildUser() {
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

        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arrAction = obj.getJSONArray("action");

        Map<String, Object> policies = new HashMap<>();
        policies.put("type", "generic");
        List<String> resources = new ArrayList<>();
        resources.add("telco");
        policies.put("resources", resources);
        policies.put("actions", arrAction);

        List<Object> policieArray = new ArrayList<>();
        policieArray.add(policies);

        Map<String, Object> body = new HashMap<>();
        body.put("policies", policieArray);
        logger.info("body :{}", Json.toJson(body));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/roles/cmp/"+userId;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("updateRolesOfChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }


    //page detail
    public Result childUserDetail(String userId, String childUserId, String email) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.childUser.detail.ChildUserDetail.render(userSession, userId, childUserId, email));
    }

    public Result getListSubsOfChildUser() {
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
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String idNo = (jsonGroup.get("idNo") != null) ? jsonGroup.get("idNo").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        if(!StringUtils.isEmpty(isdn)){
            param.put("isdn", isdn);
        }
        if(!StringUtils.isEmpty(idNo)){
            param.put("idNo", idNo);
        }
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(startAt));
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+userId+"/isdn";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getListSubsOfChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result addSubToChildUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String childUserId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String idNo = (jsonGroup.get("idNo") != null) ? jsonGroup.get("idNo").asText() :"";

        List<Object> listIsdn = new ArrayList<>();
        Map<String, String> isdnMap = new HashMap<>();
        isdnMap.put("isdn", isdn);
        isdnMap.put("id_no", idNo);
        listIsdn.add(isdnMap);
        Map<String, Object> body = new HashMap<>();
        body.put("isdns", listIsdn);
        logger.info("body : {}", Json.toJson(body));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+childUserId+"/isdn/add";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("addSubToChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result addSubToChildUser1() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String childUserId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JsonNode arrIsdn = jsonGroup.get("isdns");
        Map<String, Object> body = new HashMap<>();
        body.put("listIsdn", arrIsdn);
        logger.info("body : {}", Json.toJson(body));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+childUserId+"/isdn/add";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("addSubToChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result validateSubToChildUser1() {
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
        String actionCode = (jsonGroup.get("actionCode") != null) ? jsonGroup.get("actionCode").asText() :"";
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arrIsdn = obj.getJSONArray("isdns");
        Map<String, Object> body = new HashMap<>();
        body.put("userId", userId);
        body.put("actionCode", actionCode);
        body.put("listIsdn", arrIsdn);
        logger.info("body : {}", Json.toJson(body));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/isdn/validate/bulk";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("addSubToChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result removeSubOfChildUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String childUserId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";

        List<Object> listIsdn = new ArrayList<>();
        listIsdn.add(isdn);
        Map<String, Object> body = new HashMap<>();
        body.put("isdns", listIsdn);
        logger.info("body : {}", Json.toJson(body));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+childUserId+"/isdn/remove";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("addSubToChildUser : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }
}
