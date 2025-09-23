package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import java.util.HashMap;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class TelcoAPNController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result APNview(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.apn.APN.render(userSession, userId));
    }

    public Result getAPNByPhone() {
        AbstractAjaxJsonModel response = new AbstractAjaxJsonModel();
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        String token = "Bearer " + userSession.getToken();

        response.setIssuccess(true);
        JsonNode bodyData = request().body().asJson();


        String url = appfileConfig.urlBackendIotTelco + "/api/telco/apn/get_info";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, bodyData, token);

        logger.info("getAPNByPhone : {}", Json.toJson(apiResult));
        response.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            response.setContent(apiResult.getJsonData());
            response.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            response.setIssuccess(false);
            response.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(response));
    }

    public Result registerAPN() {
        AbstractAjaxJsonModel response = new AbstractAjaxJsonModel();
        logger.info("request body: {}", request().body().asJson());
        User userSession = getUserSession();
        logger.info("userSession: {}", userSession);

        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        String token = "Bearer " + userSession.getToken();
        logger.info("userSession: {}", token);

        response.setIssuccess(true);
        JsonNode bodyData = request().body().asJson();

        String apnCode = bodyData.hasNonNull("apn_code") ? bodyData.get("apn_code").asText() : "";
        logger.info("APN Code: {}", apnCode);

        String url = appfileConfig.urlBackendIotTelco + (apnCode != null && !apnCode.isEmpty() ? "/api/telco/apn/register" : "/api/telco/apn/default/register");
        
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, bodyData, token);

        logger.info("registerAPN : {}", Json.toJson(apiResult));
        response.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            response.setContent(apiResult.getJsonData());
            response.setResultString(getMessages().at("noti.Registersuccess"));
        } else {
            response.setIssuccess(false);
            response.setErrorString(getMessages().at("noti.Registerfalse"));
        }

        return ok(Json.toJson(response));
    }

    public Result unRegisterAPN() {      
        AbstractAjaxJsonModel response = new AbstractAjaxJsonModel();
        logger.info("request body: {}", request().body().asJson());
        User userSession = getUserSession();
        logger.info("userSession: {}", userSession);

        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        String token = "Bearer " + userSession.getToken();
        logger.info("userSession: {}", token);

        response.setIssuccess(true);
        JsonNode bodyData = request().body().asJson();

        String apnCode = bodyData.hasNonNull("apn_code") ? bodyData.get("apn_code").asText() : "";
        logger.info("APN Code: {}", apnCode);

        String url = appfileConfig.urlBackendIotTelco + (apnCode != null && !apnCode.isEmpty() ? "/api/telco/apn/unregister" : "/api/telco/apn/default/unregister");
        
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, bodyData, token);

        logger.info("registerAPN : {}", Json.toJson(apiResult));
        response.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            response.setContent(apiResult.getJsonData());
            response.setResultString(getMessages().at("noti.Registersuccess"));
        } else {
            response.setIssuccess(false);
            response.setErrorString(getMessages().at("noti.Registerfalse"));
        }

        return ok(Json.toJson(response)); 
    }

    public Result getIpAllow(String isdn, String userId) {
        AbstractAjaxJsonModel response = new AbstractAjaxJsonModel();
        User userSession = getUserSession();

        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        String token = "Bearer " + userSession.getToken();
        response.setIssuccess(true);
        JsonNode bodyData = request().body().asJson();
        Map<String, String> param = new HashMap<>();
        param.put("user_id", userId);

        String url = appfileConfig.urlBackendIotTelco + "/api/telco/apn/allow/"+ isdn;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);

        // logger.info("getIPAllow : {}", Json.toJson(apiResult));
        response.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            response.setContent(apiResult.getJsonData());
            response.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            response.setIssuccess(false);
            response.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(response));
    }
}
