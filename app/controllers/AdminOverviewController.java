package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.*;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import java.util.*;

/**
 * Created by vtk-anhlt166 on 6/16/22.
 */
@Security.Authenticated(Secured.class)
public class AdminOverviewController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result adminOverview() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.admin.overview.AdminOverview.render(userSession));
    }

    public Result getTotalOverview() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        logger.info("getTotalOverview userSession :{}", Json.toJson(userSession));

        JsonNode jsonGroup = request().body().asJson();
        String paramUrl = jsonGroup.get("url").asText();

        String url = appfileConfig.ulrBackendIot + paramUrl;
        String token = "Bearer "+userSession.getToken();
        logger.info("getTotalOverview token :{}", token);

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        return ok(Json.toJson(respone));
    }

    public Result postJsonTotalOverview() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String paramUrl = jsonGroup.get("url").asText();
        String jsonBody = jsonGroup.get("json").toString();
        JsonNode jsonData = ObjectUtil.jsonStrToJsonNode(jsonBody);
        logger.info("jsonData :{}", jsonData);

        String url = appfileConfig.ulrBackendIot + paramUrl;
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(url, jsonData, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        return ok(Json.toJson(respone));
    }

    public Result getListProjectWithPaging() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = (jsonGroup.get("name") != null) ? jsonGroup.get("name").asText() :"";
        String sortKey = jsonGroup.get("sortKey").asText();
        String sortType = jsonGroup.get("sortType").asText();
        String tag = (jsonGroup.get("tag") != null) ? jsonGroup.get("tag").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 0;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 15;
        int offset = (page-1)*pageSize;
        logger.info("offset :{} - limit :{}", offset, pageSize);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/projects/overviews?offset=" + offset + "&limit=" + pageSize + "&by=" + sortKey + "&order=" + sortType;
        if(!StringUtils.isEmpty(name)){
            url = appfileConfig.ulrBackendIot + "/api/projects/overviews?name=" + name + "&offset=" + offset + "&limit=" + pageSize + "&by=" + sortKey + "&order=" + sortType;
        }

        Map<String, Object> bodyData = new HashMap<>();
        if(!StringUtils.isEmpty(tag)){
            List<String> idTagS = Arrays.asList(tag.split(","));
            bodyData.put("tags", idTagS);
        }
        logger.info("url :{}", url);
        logger.info("bodyData :{}", bodyData);
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

    public Result getInfoOVerviewSmarthome() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer "+userSession.getToken();

        Map<String, Object> objectMap = new HashMap<>();

        String url1 = appfileConfig.ulrBackendIot + "/api/overviews/device?project_id=912e5599-70e4-4d54-b14b-049a1efe889d";
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        if(apiResult1.getResultStatus() >= 200 && apiResult1.getResultStatus() <= 299){
            objectMap.put("deviceSmarthome", apiResult1.getJsonData());
        }

        String url2 = appfileConfig.ulrBackendIot + "/api/overviews/deviceactive?project_id=912e5599-70e4-4d54-b14b-049a1efe889d";
        ApiResult apiResult2 = apiService.getByToken(url2, token);
        if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
            objectMap.put("onSmarthome", apiResult2.getJsonData());
        }

        String url3 = appfileConfig.ulrBackendIot + "/api/overviews/enduser?project_id=912e5599-70e4-4d54-b14b-049a1efe889d";
        ApiResult apiResult3 = apiService.getByToken(url3, token);
        if(apiResult3.getResultStatus() >= 200 && apiResult3.getResultStatus() <= 299){
            objectMap.put("customerSmarthome", apiResult3.getJsonData());
        }

        respone.setContent(objectMap);
        return ok(Json.toJson(respone));
    }

    public Result getInfoOVerviewVtag() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer "+userSession.getToken();

        Map<String, Object> objectMap = new HashMap<>();

        String url1 = appfileConfig.ulrBackendIot + "/api/overviews/device?project_id=a802cfe5-ae6b-4381-97ab-494b9277ea63";
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        if(apiResult1.getResultStatus() >= 200 && apiResult1.getResultStatus() <= 299){
            objectMap.put("deviceVtag", apiResult1.getJsonData());
        }

        String url2 = appfileConfig.ulrBackendIot + "/api/overviews/deviceactive?project_id=a802cfe5-ae6b-4381-97ab-494b9277ea63";
        ApiResult apiResult2 = apiService.getByToken(url2, token);
        if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
            objectMap.put("onVtag", apiResult2.getJsonData());
        }

        String url3 = appfileConfig.ulrBackendIot + "/api/overviews/enduser?project_id=a802cfe5-ae6b-4381-97ab-494b9277ea63";
        ApiResult apiResult3 = apiService.getByToken(url3, token);
        if(apiResult3.getResultStatus() >= 200 && apiResult3.getResultStatus() <= 299){
            objectMap.put("customerVtag", apiResult3.getJsonData());
        }

        respone.setContent(objectMap);
        return ok(Json.toJson(respone));
    }

    public Result getInfoOVerviewFleet() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer "+userSession.getToken();

        Map<String, Object> objectMap = new HashMap<>();

        String url1 = appfileConfig.ulrBackendIot + "/api/overviews/device?project_id=e4873054-9a96-4b13-a50d-c1cd014db227";
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        if(apiResult1.getResultStatus() >= 200 && apiResult1.getResultStatus() <= 299){
            objectMap.put("deviceFleet", apiResult1.getJsonData());
        }

        String url2 = appfileConfig.ulrBackendIot + "/api/overviews/deviceactive?project_id=e4873054-9a96-4b13-a50d-c1cd014db227";
        ApiResult apiResult2 = apiService.getByToken(url2, token);
        if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
            objectMap.put("onFleet", apiResult2.getJsonData());
        }

        String url3 = appfileConfig.ulrBackendIot + "/api/overviews/enduser?project_id=e4873054-9a96-4b13-a50d-c1cd014db227";
        ApiResult apiResult3 = apiService.getByToken(url3, token);
        if(apiResult3.getResultStatus() >= 200 && apiResult3.getResultStatus() <= 299){
            objectMap.put("customerFleet", apiResult3.getJsonData());
        }

        respone.setContent(objectMap);
        return ok(Json.toJson(respone));
    }

    public Result getInfoOVerviewMetter() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer "+userSession.getToken();

        Map<String, Object> objectMap = new HashMap<>();

        String url1 = appfileConfig.ulrBackendIot + "/api/overviews/device?project_id=85cf8d6f-8809-4a6d-9779-34f6960a1462";
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        if(apiResult1.getResultStatus() >= 200 && apiResult1.getResultStatus() <= 299){
            objectMap.put("deviceMetter", apiResult1.getJsonData());
        }

        String url2 = appfileConfig.ulrBackendIot + "/api/overviews/deviceactive?project_id=85cf8d6f-8809-4a6d-9779-34f6960a1462";
        ApiResult apiResult2 = apiService.getByToken(url2, token);
        if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
            objectMap.put("onMetter", apiResult2.getJsonData());
        }

        String url3 = appfileConfig.ulrBackendIot + "/api/overviews/enduser?project_id=85cf8d6f-8809-4a6d-9779-34f6960a1462";
        ApiResult apiResult3 = apiService.getByToken(url3, token);
        if(apiResult3.getResultStatus() >= 200 && apiResult3.getResultStatus() <= 299){
            objectMap.put("customerMetter", apiResult3.getJsonData());
        }

        respone.setContent(objectMap);
        return ok(Json.toJson(respone));
    }
}
