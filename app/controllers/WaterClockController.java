package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.DateUtil;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 5/10/22.
 */
public class WaterClockController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result waterClock(){
        String urlLogin = appfileConfig.ulrBackendIot + "/api/login";
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("identifier", "smartwater@viettel.com.vn");
        bodyData.put("password", "test1a@");

        String token = "";
        ApiResult loginGetToken = apiService.sendApiWithJson(urlLogin, Json.toJson(bodyData).toString());
        if(loginGetToken.getResultStatus() == 200) {
            token = (loginGetToken.getJsonData().get("token") != null)
                    ? loginGetToken.getJsonData().get("token").asText() : "";
        }
        return ok(views.html.iot.waterClock.WaterClock.render(token));
    }

    public Result getListClock() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String token = (jsonGroup.get("token") != null) ? jsonGroup.get("token").asText() :"";

        String url = appfileConfig.ulrBackendIot + "/api/devices?project_id=85cf8d6f-8809-4a6d-9779-34f6960a1462&limit=1000";
        logger.info("url :{}", url);

        ApiResult apiResult = apiService.getByToken(url, "Bearer " + token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result getHistoryClock() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String token = jsonGroup.get("token").asText();

        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arrId = obj.getJSONArray("listId");
        logger.info("arrId :{}", arrId);
        if(arrId.length() == 0){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Error ID empty"));
            return ok(Json.toJson(respone));
        }

        String start_time = jsonGroup.get("start_time").asText();
        String end_time = jsonGroup.get("end_time").asText();
        if(StringUtils.isEmpty(start_time) || StringUtils.isEmpty(end_time)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Error Date time empty"));
            return ok(Json.toJson(respone));
        }

        Date dateFrom = DateUtil.convertStringtoDate(start_time+",00:00",DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
        Date dateTo = DateUtil.convertStringtoDate(end_time+",23:59",DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
        logger.debug("dateFrom:{} - dateTo:{}",dateFrom , dateTo);

        long starttime = dateFrom.getTime();
        long endtime = dateTo.getTime();

        Map<String, Object> result = new HashMap<>();
        for(int i=0; i<arrId.length(); i++){
            String id = arrId.getString(i);
            String url = appfileConfig.ulrBackendIot + "/api/attributes/logged/DEVICE/"+id+"/SCOPE_CLIENT/telegram/values?starttime="+starttime+"&endtime="+endtime;
            logger.info("url :{}", url);

            ApiResult apiResult = apiService.getByToken(url, "Bearer " + token);
            if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){

                result.put(id, apiResult.getJsonData());
            }
        }

        respone.setContent(result);
        return ok(Json.toJson(respone));
    }
}
