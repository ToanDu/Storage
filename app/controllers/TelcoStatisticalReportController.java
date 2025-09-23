package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by vtk-anhlt166 on 11/23/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoStatisticalReportController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result RedBaring(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.statisticalReport.redBaring.render(userSession, userId));
    }
    
    public Result ExpiratedPackage(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.statisticalReport.expiratedPackage.render(userSession, userId));
    }



    public Result getRedBarings() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String limit = (jsonGroup.get("limit") != null) ? jsonGroup.get("limit").asText() : "10";
        String offset = (jsonGroup.get("offset") != null) ? jsonGroup.get("offset").asText() : "0";
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() : "";
        String contractId = (jsonGroup.get("contractId") != null) ? jsonGroup.get("contractId").asText() : "";  
        String isDn = (jsonGroup.get("isDn") != null) ? jsonGroup.get("isDn").asText() : "";

        Map<String, String> param = new HashMap<>();
        if(!userId.isEmpty()) {
            param.put("user_id", userId);
        } 

        if(!contractId.isEmpty()) {
            param.put("contract_id", contractId);
        }    
        if(!isDn.isEmpty()) {
            param.put("isdn", isDn);
        }
        param.put("limit", limit);
        param.put("offset", offset);

        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/reports/red_barring";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getRedBarings : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getExpiratedPackages() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String limit = (jsonGroup.get("limit") != null) ? jsonGroup.get("limit").asText() : "10";
        String offset = (jsonGroup.get("offset") != null) ? jsonGroup.get("offset").asText() : "0";
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() : "";
        String contractId = (jsonGroup.get("contractId") != null) ? jsonGroup.get("contractId").asText() : "";  
        String isDn = (jsonGroup.get("isDn") != null) ? jsonGroup.get("isDn").asText() : "";
        String from = (jsonGroup.get("from") != null) ? jsonGroup.get("from").asText() : "";
        String to = (jsonGroup.get("to") != null) ? jsonGroup.get("to").asText() : "";

        Map<String, String> param = new HashMap<>();
        if(!userId.isEmpty()) {
            param.put("user_id", userId);
        } 

        if(!contractId.isEmpty()) {
            param.put("contract_id", contractId);
        }    
        if(!isDn.isEmpty()) {
            param.put("isdn", isDn);
        }
        if(!from.isEmpty()) {
            param.put("from", from);
        }
        if(!to.isEmpty()) {
            param.put("to", to);
        }
        param.put("limit", limit);
        param.put("offset", offset);

        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/reports/package_expired";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getRedBarings : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }
}
