package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 2/21/22.
 */
@Security.Authenticated(Secured.class)
public class SolutionTrackingController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result monitorMap(String projectId) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.solution.tracking.MonitorMap.render(userSession, projectId));
    }

    public Result getListGpsDevice(){
        User userSession = getUserSession();

        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() :"";

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        logger.debug("param :{}", Json.toJson(param));

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("Get ds Device:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result getInfoDevice() {
        User userSession = getUserSession();

        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        String url = appfileConfig.ulrBackendIot + "/api/devices/"+id;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.debug("getInfoDevice :{}", Json.toJson(apiResult));
        if (apiResult.getResultStatus() == 200) {
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    //history map
    public Result historyMap(String projectId) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.solution.tracking.HistoryMap.render(userSession, projectId));
    }

    public Result loadLocationHistory(){
        User userSession = getUserSession();

        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String start_time = jsonGroup.get("start_time").asText();
        String end_time = jsonGroup.get("end_time").asText();
        Date dateFrom = DateUtil.convertStringtoDate(start_time,DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
        Date dateTo = DateUtil.convertStringtoDate(end_time,DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
        logger.debug("dateFrom:{} - dateTo:{}",dateFrom , dateTo);

        if(dateFrom.getTime() >= dateTo.getTime()){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("history.dateTimeFromTo"));
            return ok(Json.toJson(respone));
        }
        if((dateTo.getTime() - dateFrom.getTime())/60000L > 24*60){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("history.time31day"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/attributes/logged/DEVICE/"+id+"/SCOPE_SERVER/location/values?starttime="+dateFrom.getTime()/1000+"&endtime="+dateTo.getTime()/1000+"&order_by=ASC";
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("loadLocationHistory :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("history.apiFalse"));
        }

        return ok(Json.toJson(respone));
    }

}
