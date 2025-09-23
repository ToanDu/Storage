package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
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

import java.util.*;

/**
 * Created by vtk-anhlt166 on 12/23/21.
 */
@Security.Authenticated(Secured.class)
public class AttributeController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result addAttribute() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String entity_id = (jsonGroup.get("entity_id") != null) ? jsonGroup.get("entity_id").asText() :"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText() :"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText() :"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText() :"";
        String value_t = (jsonGroup.get("value_t") != null) ? jsonGroup.get("value_t").asText() :"";
        String value = (jsonGroup.get("value") != null) ? jsonGroup.get("value").asText() :"";
        logger.debug("value :{}", value);
        Boolean logged = jsonGroup.get("logged").asBoolean();

        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("entity_id", entity_id);
        bodyData.put("entity_type", entity_type);

        List<Object> attributes = new ArrayList<>();
        Map<String, Object> attr = new HashMap<>();
        attr.put("attribute_key", attribute_key);
        attr.put("attribute_type", attribute_type);
        attr.put("value_t", value_t);
        attr.put("value", value);
        attr.put("logged", logged);
        attributes.add(attr);

        bodyData.put("attributes", attributes);

        logger.debug("bodyData :{}", bodyData);

        String url = appfileConfig.ulrBackendIot + "/api/attributes";
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(bodyData), token);
        logger.debug("apiResult :{}", apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result deleteAttributeOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String entity_id = (jsonGroup.get("entity_id") != null) ? jsonGroup.get("entity_id").asText() :"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText() :"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText() :"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText() :"";

        String url = appfileConfig.ulrBackendIot + "/api/attributes/"+entity_type+"/"+entity_id+"/"+attribute_type+"/"+attribute_key+"/values";
        logger.debug("url : {}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.deleteByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result editAttributeOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String entity_id = (jsonGroup.get("entity_id") != null) ? jsonGroup.get("entity_id").asText() :"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText() :"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText() :"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText() :"";
        String value_t = (jsonGroup.get("value_t") != null) ? jsonGroup.get("value_t").asText() :"";
        String value = (jsonGroup.get("value") != null) ? jsonGroup.get("value").asText() :"";

        Map<String, Object> result = new HashMap<>();

        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("value_t", value_t);
        bodyData.put("value", value);
        logger.debug("bodyData :{}", bodyData);

        String url = appfileConfig.ulrBackendIot + "/api/attributes/"+entity_type+"/"+entity_id+"/"+attribute_type+"/"+attribute_key+"/values";
        logger.debug("url : {}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(bodyData), token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            result.put("value", true);
        } else {
            result.put("value", false);
        }

        if(jsonGroup.get("logged") != null){
            Boolean logged = jsonGroup.get("logged").asBoolean();
            logger.debug("logged :{}", logged);

            Map<String, Object> bodyData2 = new HashMap<>();
            bodyData2.put("logged", logged);

            String url2 = appfileConfig.ulrBackendIot + "/api/attributes/"+entity_type+"/"+entity_id+"/"+attribute_type+"/"+attribute_key+"/logged";

            ApiResult apiResult2 = apiService.sendPutJson(url2, Json.toJson(bodyData2), token);
            if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
                result.put("logged", true);
            } else {
                result.put("logged", false);
            }
        }

        respone.setContent(result);
        return ok(Json.toJson(respone));
    }

    //device
    public Result attributeDevice(String projectId, String deviceId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.attribute.device.AttributeDevice.render(userSession, projectId, deviceId));
    }

    public Result getAttributeList() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() :"";
        String type = (jsonGroup.get("type") != null) ? jsonGroup.get("type").asText() :"";

        String url = appfileConfig.ulrBackendIot + "/api/attributes/"+ type +"/" + id + "/values?limit=1000&offset=0";
        logger.debug("url :{}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));

        }

        return ok(Json.toJson(respone));
    }

    public Result getAttributeHistory() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() :"";
        String start_time = (jsonGroup.get("starttime") != null) ? jsonGroup.get("starttime").asText() :"";
        String end_time = (jsonGroup.get("endtime") != null) ? jsonGroup.get("endtime").asText() :"";
        String type = (jsonGroup.get("type") != null) ? jsonGroup.get("type").asText() :"";

        Date starttime = DateUtil.convertStringtoDate(start_time,DateUtil.DATE_HISTORY_ATTRIBUTE,DateUtil.VN_GMT_7);
        Date endtime = DateUtil.convertStringtoDate(end_time,DateUtil.DATE_HISTORY_ATTRIBUTE,DateUtil.VN_GMT_7);


        if(starttime.getTime() > endtime.getTime()){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.dateTimeFromTo"));
            return ok(Json.toJson(respone));
        }

        long startTime = starttime.getTime();
        long endTime = endtime.getTime();
        logger.debug("starttime:{} - endtime:{}", startTime , endTime);

        String url = appfileConfig.ulrBackendIot + "/api/attributes/logged/"+ type +"/" + id + "/values?limit=1000&offset=0&starttime=" + startTime + "&endtime=" + endTime;
        logger.info("url :{}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));

        }

        return ok(Json.toJson(respone));
    }


    //user
    public Result attributeUser(String projectId, String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.attribute.user.AttributeUser.render(userSession, projectId, userId));
    }

    //event
    public Result attributeEvent(String projectId, String eventId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.attribute.event.AttributeEvent.render(userSession, projectId, eventId));
    }

    //template
    public Result attributeTemplate(String projectId, String templateId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.attribute.template.AttributeTemplate.render(userSession, projectId, templateId));
    }

    //group
    public Result attributeGroup(String projectId, String groupId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.attribute.group.AttributeGroup.render(userSession, projectId, groupId));
    }

    public Result getDataAttributeById() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";

//        if (StringUtils.isEmpty(varName) || StringUtils.isEmpty(deviceId)){
//            respone.setIssuccess(false);
//            respone.setErrorString(getMessages().at("noti.valid.id"));
//            return ok(Json.toJson(respone));
//        }

        String url = appfileConfig.ulrBackendIot + "/api/attributes/logged/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + attribute_key + "/values?offset=0&limit=100";
        logger.debug("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            try {
                JsonNode jsonBody = apiResult.getJsonData();
                JSONObject obj = new JSONObject(jsonBody.toString());
                if(obj.get("logs") instanceof JSONArray){
                    JSONArray arr = obj.getJSONArray("logs");

                    List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
                    if(arr.length() > 0){
                        for(int i=0; i<arr.length(); i++){
                            JsonNode jsonOneGroup = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                            String value = (jsonOneGroup.get("value") != null) ? jsonOneGroup.get("value").asText() : "";
                            String updatetime = (jsonOneGroup.get("ts") != null) ? jsonOneGroup.get("ts").asText() : "";

                            Map<String, Object> var = new HashMap<String, Object>();
                            var.put("value", value);
                            var.put("updatetime", updatetime);

                            data.add(var);
                        }

                        respone.setContent(data);
                    } else {
                        respone.setIssuccess(false);
                        respone.setErrorString(getMessages().at("noti.notFoundData"));
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getLastValueAttribute() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";

        String url = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + attribute_key + "/values";
        logger.debug("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.debug("getLastValueAttribute :{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            JsonNode jsonBody = apiResult.getJsonData();

            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            Map<String, Object> var = new HashMap<String, Object>();
            var.put("value", jsonBody.get("value").asText());
            var.put("updatetime", jsonBody.get("last_update_ts").asText());

            data.add(var);
            respone.setContent(data);
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getPositionDeviceByAttribute() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String lat = (jsonGroup.get("lat") != null) ? jsonGroup.get("lat").asText():"";
        String lon = (jsonGroup.get("lon") != null) ? jsonGroup.get("lon").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", deviceId);

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + lat + "/values";
        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            JsonNode jsonBody = apiResult.getJsonData();
            String value = (jsonBody.get("value") != null) ? jsonBody.get("value").asText() : "";
            String timeStamp = (jsonBody.get("last_update_ts") != null) ? jsonBody.get("last_update_ts").asText() : "";

            result.put("lat", Double.parseDouble(value));
            result.put("timeStamp", timeStamp);
        }

        String url2 = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + lon + "/values";
        ApiResult apiResult2 = apiService.getByToken(url2, token);
        if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
            JsonNode jsonBody = apiResult2.getJsonData();
            String value = (jsonBody.get("value") != null) ? jsonBody.get("value").asText() : "";

            result.put("lng", Double.parseDouble(value));
        }

        respone.setContent(result);
        return ok(Json.toJson(respone));
    }

    public Result getValueAttributeWithTime() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);

        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";
        String startTime = jsonGroup.get("startTime").asText();
        String endTime = jsonGroup.get("endTime").asText();
        String aggType = jsonGroup.get("aggType").asText();
        int interval = jsonGroup.get("interval").asInt();
        String url = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+
                "/timeseries?startTime="+startTime+"&endTime="+endTime+"&aggType="+aggType+"&keys="+attribute_key;
        if(!aggType.equals("NONE")){
            url += "&interval="+interval;
        }
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            try {
                JsonNode jsonBody = apiResult.getJsonData();
                JSONObject obj = new JSONObject(jsonBody.toString());
                if(obj.get("logs") instanceof JSONArray){
                    JSONArray arr = obj.getJSONArray("logs");

                    List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
                    if(arr.length() > 0){
                        for(int i=0; i<arr.length(); i++){
                            JsonNode jsonOneGroup = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                            String value = (jsonOneGroup.get("value") != null) ? jsonOneGroup.get("value").asText() : "";
                            String updatetime = (jsonOneGroup.get("ts") != null) ? jsonOneGroup.get("ts").asText() : "";

                            Map<String, Object> var = new HashMap<String, Object>();
                            var.put("value", value);
                            var.put("updatetime", updatetime);

                            data.add(var);
                        }

                        respone.setContent(data);
                    } else {
                        respone.setIssuccess(false);
                        respone.setErrorString(getMessages().at("noti.notFoundData"));
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
        }
        return ok(Json.toJson(respone));
    }

}
