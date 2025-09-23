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
 * Created by vtk-anhlt166 on 12/2/21.
 */
@Security.Authenticated(Secured.class)
public class PayCustomerController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result payCustomer(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.pay.customer.Customer.render(userSession, projectId));
    }

    public Result payment(String projectId, String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.pay.customer.Pay.render(userSession, projectId, userId));
    }

    public Result getListUserInOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();
        String id = (jsonGroup.get("orgId") != null) ? jsonGroup.get("orgId").asText() : "";

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/users?project_id="+projectId+"&org_id="+id;
        logger.info("url :{}", url);
        ApiResult apiGetUserList = apiService.getByToken(url, token);
        logger.info("Get ds user:{}", Json.toJson(apiGetUserList));

        if(apiGetUserList.getResultStatus() >= 200 && apiGetUserList.getResultStatus() <= 299){
            respone.setContent(apiGetUserList.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result addPackdataNewForUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup : {}", jsonGroup);
        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/subscription";

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.debug("addPackdataNewForUser :{}", Json.toJson(apiResult));

        respone.setContent(apiResult.getJsonData());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result postPricingOfCustomer() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userid") != null) ? jsonGroup.get("userid").asText() : "";

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/priceplan/connections/"+userId;
        logger.info("url postPricingOfCustomer: {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("apiResult postPricingOfCustomer: {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }


    //customer
    public Result getInfoCustomer() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/customer/"+userId;
        logger.info("url: {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getInfoCustomer: {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result createInfoCustomer() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String token = "Bearer " + userSession.getToken();
        logger.debug("body : {}", Json.toJson(jsonGroup));

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/customer";
        logger.debug("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.debug("createInfoCustomer :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result updateInfoCustomer() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String user_id = jsonGroup.get("user_id").asText();

        String token = "Bearer " + userSession.getToken();
        logger.debug("body : {}", Json.toJson(jsonGroup));

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/customer/"+user_id;
        logger.debug("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, jsonGroup, token);
        logger.debug("updateInfoCustomer :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    //vendor
    public Result getInfoVendor() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/vendor/"+projectId;
        logger.info("url: {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getInfoCompany: {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result createVendor() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String token = "Bearer " + userSession.getToken();
        logger.debug("body : {}", Json.toJson(jsonGroup));

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/vendor";
        logger.debug("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.debug("createVendor :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result updateVendor() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String project_id = jsonGroup.get("project_id").asText();

        String token = "Bearer " + userSession.getToken();
        logger.debug("body : {}", Json.toJson(jsonGroup));

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/vendor/"+project_id;
        logger.debug("url : {}", url);
        ApiResult apiResult = apiService.sendPutJson(url, jsonGroup, token);
        logger.debug("updateVendor :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        return ok(Json.toJson(respone));
    }

    //subs
    public Result getSubscription() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/subscription/detail/"+userId;
        logger.info("url: {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getSubscription: {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result createSubscription() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup: {}", Json.toJson(jsonGroup));

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/subscription";
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("createSubscription: {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result cancelSubscription() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup: {}", Json.toJson(jsonGroup));
        String id = jsonGroup.get("id").asText();

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/priceplan/subscription/cancel/"+id;
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson("") , token);
        logger.info("cancelSubscription: {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }
}
