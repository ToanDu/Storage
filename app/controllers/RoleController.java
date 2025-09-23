package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.Role;
import vn.m2m.common.models.User;
import vn.m2m.iot.models.Event;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;

@Security.Authenticated(Secured.class)
public class RoleController extends AbstractController{

    @Inject
    public ApiService apiService;
    @Inject
    public ObjectMapper mapper;

    public Result roleList(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<Role> roleList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/roles";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetList = apiService.getByToken(url, token);

        logger.info("Get list Role:{}", Json.toJson(apiGetList));

        if(apiGetList.getResultStatus() >= 200 && apiGetList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("roles");
            if(arr.length() > 0){
                for(int i=0; i<arr.length(); i++){
                    try {
                        Role roles = mapper.readValue(arr.get(i).toString(), Role.class);
                        if (roles != null) {
                            roleList.add(roles);
                        }
                    } catch (IOException e) {
                        logger.error("Get List Role:{}", e);
                    }
                }
            }
        } else {
            if(apiGetList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
        }
//        logger.debug("roleList :{}", Json.toJson(roleList));

        return ok(views.html.roles.RoleList.render(userSession, roleList));
    }

    public Result pageRole(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }
        List<Role> roleList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/roles";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetRoleList = apiService.getByToken(url, token);

        if(apiGetRoleList.getResultStatus() >= 200 && apiGetRoleList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetRoleList.getJsonData();
            return ok(jsonBody);
        } else {
            if(apiGetRoleList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
            return ok();
        }
    }

    public Result addNewRole() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
//        String name = jsonGroup.get("name").asText();
//        logger.debug("jsonGroup : {}", jsonGroup);
//
//        if (org.springframework.util.StringUtils.isEmpty(name)){
//            respone.setIssuccess(false);
//            respone.setErrorString(getMessages().at("noti.valid.name"));
//            return ok(Json.toJson(respone));
//        }

        String urlCreateRole = appfileConfig.ulrBackendIot + "/api/roles";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiCreateRole = apiService.sendPostJson(urlCreateRole, jsonGroup, token);
        logger.info("Create Role:{}", Json.toJson(apiCreateRole));

        if(apiCreateRole.getResultStatus() >= 200 && apiCreateRole.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deleteRole() {
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

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("device.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteDevice = appfileConfig.ulrBackendIot + "/api/roles/" + id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDelete= apiService.deleteByToken(urlDeleteDevice, token);
        logger.info("Delete Role:{}", Json.toJson(apiDelete));
        respone.setStatus(apiDelete.getResultStatus());
        if(apiDelete.getResultStatus() >= 200 && apiDelete.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getRole() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String id = request().getQueryString("id");

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("device.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteDevice = appfileConfig.ulrBackendIot + "/api/roles/" + id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetSingle = apiService.getByToken(urlDeleteDevice, token);
        logger.info("get Role:{}", Json.toJson(apiGetSingle));
        respone.setStatus(apiGetSingle.getResultStatus());
        if(apiGetSingle.getResultStatus() >= 200 && apiGetSingle.getResultStatus() <= 299){
            respone.setIssuccess(true);
            respone.setContent(apiGetSingle.getJsonData());
        } else {
            respone.setIssuccess(false);
        }
        return ok(Json.toJson(respone));
    }
    public Result updateRole() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("role_name").asText();
        String role_id = jsonGroup.get("id").asText();
        logger.info("Update Role:{}>>>>>>>>>>>>>>>>>", Json.toJson(jsonGroup));

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }


        String urlUpdate = appfileConfig.ulrBackendIot + "/api/roles/" + role_id;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiUpdate = apiService.sendPutJson(urlUpdate, Json.toJson(jsonGroup), token);
        logger.info("Update Role:{}", Json.toJson(urlUpdate));
        respone.setStatus(apiUpdate.getResultStatus());
        if(apiUpdate.getResultStatus() >= 200 && apiUpdate.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Update.nothing"));
        }
        return ok(Json.toJson(respone));
    }
}
