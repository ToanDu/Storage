package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.dao.UserDAO;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 4/6/23.
 */
@Security.Authenticated(Secured.class)
public class UserTenantListController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result userTenantList(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.userTenant.UserTenantList.render(userSession));
    }

    public Result getListUserTenant() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name") != null ? jsonGroup.get("name").asText() : "";
        String phone = jsonGroup.get("phone") != null ? jsonGroup.get("phone").asText() : "";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("offset", Integer.toString(startAt));
        param.put("limit", Integer.toString(pageSize));
        if(!StringUtils.isEmpty(name)){
            param.put("name", name.trim());
        }
        if(!StringUtils.isEmpty(phone)){
            param.put("phone", phone.trim());
        }

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/tenant";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getListUserTenant : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result createUserTenant() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/tenant";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("createUserTenant : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result delUserTenant() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/tenant/"+id;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.deleteByToken(url, token);
        logger.info("delUserTenant : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result editUserTenant() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String email = jsonGroup.get("email").asText();
        String name = jsonGroup.get("name").asText();
        String phone = jsonGroup.get("phone").asText();
        String password = jsonGroup.get("password").asText();

        Map<String, String> body = new HashMap<>();
        if(!StringUtils.isEmpty(email)){
            body.put("email", email);
        }
        if(!StringUtils.isEmpty(name)){
            body.put("name", name);
        }
        if(!StringUtils.isEmpty(phone)){
            body.put("phone", phone);
        }
        if(!StringUtils.isEmpty(password)){
            body.put("password", password);
        }

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/tenant/"+id;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("editUserTenant : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    //list role of project
    public Result getListRoleOfOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("limit", "100");
        param.put("offset", "0");

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/roles";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getListRoleOfOrg:{}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }


        return ok(Json.toJson(respone));
    }

    public Result updateRoleUserPermission() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        List<Object> project_permission = new ArrayList<>();
        project_permission.add(jsonGroup);
        Map<String, Object> body = new HashMap<>();
        body.put("project_permission", project_permission);
        logger.info("body:{}", Json.toJson(body));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/tenant/permission";
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("updateRoleUserPermission:{}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result delRoleUserPermission() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String tenant_id = jsonGroup.get("tenant_id").asText();
        String project_id = jsonGroup.get("project_id").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/tenant/"+tenant_id+"/project/"+project_id;
        ApiResult apiResult = apiService.deleteByToken(url, token);
        logger.info("updateRoleUserPermission:{}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }
}
