package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 10/6/22.
 */
@Security.Authenticated(Secured.class)
public class AdminManageSimController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result adminManageSim() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.admin.manageSim.ManageSim.render(userSession));
    }

    public Result getAllProjectWithPaging() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 0;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 100;
        int offset = (page-1)*pageSize;
        logger.info("offset :{} - limit :{}", offset, pageSize);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/projects/overviews?offset=" + offset + "&limit=" + pageSize;

        Map<String, Object> bodyData = new HashMap<>();

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(bodyData), token);
        logger.info("apiResult :{}", apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result getListDeviceWithProjectId() {
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
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 0;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 15;
        int offset = (page-1)*pageSize;
        logger.info("offset :{} - limit :{}", offset, pageSize);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/devices?project_id=" + projectId + "&expand=true&get_attributes=false&limit=" + pageSize + "&offset=" + offset;

        ApiResult apiResult = apiService.getByToken(url, token);
//        if(projectId.equals("a802cfe5-ae6b-4381-97ab-494b9277ea63")){
//            logger.info("url :{}", url);
//            logger.info("projectId :{}", projectId);
//            logger.info("apiResult :{}", apiResult.getJsonData());
//        }

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result getAttrSimDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = jsonGroup.get("deviceId").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/attributes/DEVICE/" + deviceId + "/SCOPE_SERVER/tpp/values";

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            logger.info("apiResult :{}", apiResult.getJsonData());
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }
}
