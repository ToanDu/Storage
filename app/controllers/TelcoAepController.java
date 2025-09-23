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
public class TelcoAepController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result aepUtilities(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.aep.AepUtilities.render(userSession, userId));
    }

    public Result requestDataAepWeather(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String urlLogin = appfileConfig.ulrBackendIot + "/api/login";
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("identifier", "vtag@viettel.com.vn");
        bodyData.put("password", "test1a@");
        ApiResult apiResultLogin = apiService.sendApiWithJson(urlLogin, Json.toJson(bodyData).toString());
//        logger.info("apiResultLogin : {}", Json.toJson(apiResultLogin));
        String token = "";
        if(apiResultLogin.getResultStatus() == 200){
            token = apiResultLogin.getJsonData().get("token").asText();
        } else {
            respone.setIssuccess(false);
            respone.setErrorString("Lấy token không thành công");
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String url = appfileConfig.ulrBackendIot + "/api/flowEngine?timeout=20000&project_id=2fe61355-a7a2-4e6d-9a38-694f2c2ce21b";
        logger.info("url :{}", url);
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, "Bearer "+token);
        logger.info("requestDataAepWeather :{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }
        return ok(Json.toJson(respone));
    }

    public Result requestDataAepGps(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String urlLogin = appfileConfig.ulrBackendIot + "/api/login";
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("identifier", "vtag@viettel.com.vn");
        bodyData.put("password", "test1a@");
        ApiResult apiResult = apiService.sendApiWithJson(urlLogin, Json.toJson(bodyData).toString());
        logger.info("apiResult : {}", Json.toJson(apiResult));
        String token = "";
        if(apiResult.getResultStatus() == 200){
            token = apiResult.getJsonData().get("token").asText();
        } else {
            respone.setIssuccess(false);
            respone.setErrorString("Lấy token không thành công");
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String url = appfileConfig.ulrBackendIot + "/api/flowEngine?timeout=20000&project_id=2fe61355-a7a2-4e6d-9a38-694f2c2ce21b";
        logger.info("url :{}", url);
        ApiResult getGps = apiService.sendPostJson(url, jsonGroup, "Bearer "+token);
        logger.info("getGps :{}", Json.toJson(getGps));
        if(getGps.getResultStatus() == 200){
            respone.setContent(getGps.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString("Lấy định vị không thành công");
        }
        return ok(Json.toJson(respone));
    }
}
