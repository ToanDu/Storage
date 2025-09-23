package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.springframework.util.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 12/2/21.
 */
@Security.Authenticated(Secured.class)
public class PayPackDataController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result packData(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.pay.packData.PackData.render(userSession, projectId));
    }

    public Result getListPackdata() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();
        logger.debug("projectId :{} ", projectId);

        if (org.springframework.util.StringUtils.isEmpty(projectId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/allplans?project_id="+projectId;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getListPackdata :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setStatus(apiResult.getResultStatus());
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result addNewPackdata() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String project_id = jsonGroup.get("project_id").asText();

        if (StringUtils.isEmpty(project_id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        logger.info("bodyData :{}", Json.toJson(jsonGroup));

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/plan";
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("addNewPackdata :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setStatus(apiResult.getResultStatus());
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getInfoPackdata() {
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

        if (StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/plan/"+id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getInfoPackdata :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setStatus(apiResult.getResultStatus());
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result editPackdata() {
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
        if (StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        logger.debug("bodyData :{}", jsonGroup);

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/plan/"+ id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, jsonGroup, token);
        logger.info("editPackdata :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setStatus(apiResult.getResultStatus());
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deletePackdata() {
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

        if (StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("id", id);
        logger.debug("bodyData :{}", Json.toJson(bodyData));

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/plan/"+id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.deleteByToken(url, token);
        logger.info("getInfoPackdata :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setStatus(apiResult.getResultStatus());
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }
}
