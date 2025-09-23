package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.DateUtil;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 11/15/21.
 */
@Security.Authenticated(Secured.class)
public class OverviewController extends AbstractController{
    @Inject
    public ApiService apiService;

    public Result overview(String id){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.overview.Overview.render(userSession, id));
    }

    public Result countDeviceAndUser(String projectId){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/projects/overview/" + projectId;
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result countDevice7Day(String projectId){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Date now = DateUtil.now();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date lastDate = cal.getTime();

        String url = appfileConfig.ulrBackendIot + "/api/overviews/device?project_id=" + projectId;
        logger.info("url :{}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("countDevice7Day :{}", apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result countUser7Day(String projectId){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Date now = DateUtil.now();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date lastDate = cal.getTime();

        String url = appfileConfig.ulrBackendIot + "/api/overviews/enduser?project_id=" + projectId;
        logger.info("url :{}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("countUser7Day :{}", apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result countMess7Day(String projectId){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Date now = DateUtil.now();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date lastDate = cal.getTime();

        String url = appfileConfig.ulrBackendIot + "/api/overviews/useronline?project_id=" + projectId;
        logger.info("url :{}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("countMess7Day :{}", apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result countDataLatency(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode json = request().body().asJson();
        String project_id = json.get("project_id").asText();
        String method = json.get("method").asText();
        String url = json.get("url").asText();
        String start_time = json.get("start_time").asText();
        String end_time = json.get("end_time").asText();

        Map<String, String> body = new HashMap<>();
        body.put("project_id", project_id);
        body.put("method", method);
        body.put("url", url);

        String urlGet = appfileConfig.ulrBackendIot + "/api/overviews/latency?start_time="+start_time+"&end_time="+end_time;
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(urlGet, Json.toJson(body), token);
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result countDataSuccessRate(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode json = request().body().asJson();
        String project_id = json.get("project_id").asText();
        String method = json.get("method").asText();
        String url = json.get("url").asText();
        String start_time = json.get("start_time").asText();
        String end_time = json.get("end_time").asText();

        Map<String, String> body = new HashMap<>();
        body.put("project_id", project_id);
        body.put("method", method);
        body.put("url", url);

        String urlGet = appfileConfig.ulrBackendIot + "/api/overviews/successrate?start_time="+start_time+"&end_time="+end_time;
        logger.info("url :{}", urlGet);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(urlGet, Json.toJson(body), token);
        logger.info("apiResult :{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299) {
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }
}
