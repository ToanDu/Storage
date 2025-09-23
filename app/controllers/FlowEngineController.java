package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
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
 * Created by vtk-anhlt166 on 12/3/21.
 */
@Security.Authenticated(Secured.class)
public class FlowEngineController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result getListFlow() {
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

        String url = appfileConfig.ulrBackendIot + "/api/ruleChains";
        logger.debug("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        Map<String, String> param = new HashMap<>();
        param.put("projectId", projectId);
        param.put("pageSize", "1000");
        param.put("page", "0");
        param.put("sortProperty", "createdTime");
        param.put("sortOrder", "DESC");
        logger.debug("param :{}", Json.toJson(param));

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getListFlow:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result addFlow() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String url = appfileConfig.ulrBackendIot + "/api/ruleChains";
        logger.debug("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("addFlow:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

}
