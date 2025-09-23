package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.dao.WidgetDAO;
import vn.m2m.iot.form.DevicePositionInitMarker;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.Widget;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by vtk-anhlt166 on 10/13/22.
 */
public class DashboardAppController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public WidgetDAO widgetDAO;
    @Inject
    public DeviceIotDAO deviceIotDAO;
    //app dashboard
    public Result appDashboard(String projectId, String idDashboard, String token, String deviceId, String deviceToken) {
        return ok(views.html.iot.dashboard.app.AppDashboard.render(projectId, idDashboard, token, deviceId, deviceToken));
    }

    public Result getDashboardWithId(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        Widget widget = widgetDAO.getByKey(id);
        if(widget != null){
            respone.setContent(widget);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
            return ok(Json.toJson(respone));
        }
    }

    //app dashboard
    public Result getPositionDeviceByAttributeApp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String lat = (jsonGroup.get("lat") != null) ? jsonGroup.get("lat").asText():"";
        String lon = (jsonGroup.get("lon") != null) ? jsonGroup.get("lon").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";
        String token = (jsonGroup.get("token") != null) ? jsonGroup.get("token").asText():"";

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", deviceId);

        String tokenS = "Bearer " + token;

        String url = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + lat + "/values";
        ApiResult apiResult = apiService.getByToken(url, tokenS);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            JsonNode jsonBody = apiResult.getJsonData();
            String value = (jsonBody.get("value") != null) ? jsonBody.get("value").asText() : "";
            String timeStamp = (jsonBody.get("last_update_ts") != null) ? jsonBody.get("last_update_ts").asText() : "";

            result.put("lat", Double.parseDouble(value));
            result.put("timeStamp", timeStamp);
        }

        String url2 = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + lon + "/values";
        ApiResult apiResult2 = apiService.getByToken(url2, tokenS);
        if(apiResult2.getResultStatus() >= 200 && apiResult2.getResultStatus() <= 299){
            JsonNode jsonBody = apiResult2.getJsonData();
            String value = (jsonBody.get("value") != null) ? jsonBody.get("value").asText() : "";

            result.put("lng", Double.parseDouble(value));
        }

        respone.setContent(result);
        return ok(Json.toJson(respone));
    }

    public Result getDataAttributeByIdApp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";
        String token = "Bearer " + ((jsonGroup.get("token") != null) ? jsonGroup.get("token").asText():"");

        String url = appfileConfig.ulrBackendIot + "/api/attributes/logged/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + attribute_key + "/values?offset=0&limit=100";
        logger.debug("url :{}", url);

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
    public Result getLastValueAttributeApp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String attribute_key = (jsonGroup.get("attribute_key") != null) ? jsonGroup.get("attribute_key").asText():"";
        String attribute_type = (jsonGroup.get("attribute_type") != null) ? jsonGroup.get("attribute_type").asText():"";
        String entity_type = (jsonGroup.get("entity_type") != null) ? jsonGroup.get("entity_type").asText():"";
        String token = "Bearer " + ((jsonGroup.get("token") != null) ? jsonGroup.get("token").asText():"");

        String url = appfileConfig.ulrBackendIot + "/api/attributes/" + entity_type + "/" + deviceId+ "/" + attribute_type + "/" + attribute_key + "/values";
        logger.debug("url :{}", url);

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

    public Result getListDeviceWithWidgetMapApp(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<DevicePositionInitMarker> initMapMarkerList = new ArrayList<DevicePositionInitMarker>();
        Map<String, Object> dataResponses = new HashMap<>();

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();
        String token = "Bearer " + jsonGroup.get("token").asText();

        if(StringUtils.isEmpty(orgId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
            return ok(Json.toJson(respone));
        }

        String url = "";
        if(orgId.equals("#")){
            url = appfileConfig.ulrBackendIot + "/api/devices";
        } else {
            url = appfileConfig.ulrBackendIot + "/api/devices/organization/"+orgId;
        }

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);

        ApiResult apiGetDeviceList = apiService.getWithParams(url, token, param);
        logger.debug("getListDeviceWithWidgetMap - apiGetDeviceList :{}", apiGetDeviceList.getJsonData());

        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    JSONObject objVariable = new JSONObject(device.toString());
                    JSONArray arrVariable = objVariable.optJSONArray("variables");

                    if (device.get("id") != null) {
                        DevicePositionInitMarker devicePositionInitMarker = new DevicePositionInitMarker();
                        devicePositionInitMarker.setId(device.get("id").asText());
                        devicePositionInitMarker.setName((device.get("name") != null) ? device.get("name").asText() : "");

                        if(arrVariable != null && arrVariable.length() > 0){
                            DeviceIot deviceIot = deviceIotDAO.getByKey(device.get("id").asText());
                            if(deviceIot != null){
                                deviceIot.setName((device.get("name") != null) ? device.get("name").asText() : "");
                                deviceIot.setCurrentLat(0);
                                deviceIot.setCurrentLong(0);

                                String keyLatitude = deviceIot.getKeyLatitude();
                                String keyLongitude = deviceIot.getKeyLongitude();
                                String battery = deviceIot.getKeyBattery();
                                if(!StringUtils.isEmpty(keyLatitude) && !StringUtils.isEmpty(keyLongitude)){
                                    for (int v = 0; v < arrVariable.length(); v++) {
                                        JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(v).toString());
                                        String name = variable.get("varname").asText();
                                        logger.debug("name var :{}", name);
                                        if(name.equals(keyLatitude)){
                                            devicePositionInitMarker.setCurrentLat(variable.get("value").asDouble());
                                            deviceIot.setCurrentLat(variable.get("value").asDouble());

                                            if(device.get("updateTime") != null){
                                                logger.debug("update time :{}", variable.get("updateTime").asLong());
                                                Long time = variable.get("updateTime").asLong()/1000000;
                                                logger.debug("timetime :{}", time);
                                                deviceIot.setDateTracking(new Date(time));
                                            }

                                        }
                                        if(name.equals(keyLongitude)){
                                            devicePositionInitMarker.setCurrentLon(variable.get("value").asDouble());
                                            deviceIot.setCurrentLong(variable.get("value").asDouble());
                                        }
                                        if(name.equals("battery")){
                                            devicePositionInitMarker.setVol(variable.get("value").asDouble());
                                            deviceIot.setBattery(variable.get("value").asDouble());
                                        }
                                    }
                                } else {
                                    for (int v = 0; v < arrVariable.length(); v++) {
                                        JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(v).toString());
                                        String name = variable.get("varname").asText();
                                        logger.debug("name var :{}", name);
                                        if(name.equals("latitude")){
                                            devicePositionInitMarker.setCurrentLat(variable.get("value").asDouble());
                                            deviceIot.setCurrentLat(variable.get("value").asDouble());

                                            if(device.get("updateTime") != null){
                                                Long time = Long.parseLong(device.get("updateTime").asText())/1000;
                                                deviceIot.setDateTracking(new Date(time));
                                            }

                                        }
                                        if(name.equals("longitude")){
                                            devicePositionInitMarker.setCurrentLon(variable.get("value").asDouble());
                                            deviceIot.setCurrentLong(variable.get("value").asDouble());
                                        }
                                        if(name.equals("battery")){
                                            devicePositionInitMarker.setVol(variable.get("value").asDouble());
                                            deviceIot.setBattery(variable.get("value").asDouble());
                                        }
                                    }
                                }

                                deviceIotDAO.save(deviceIot);
                            } else {
                                DeviceIot deviceIotNew = new DeviceIot();
                                deviceIotNew.setId(device.get("id").asText());
                                deviceIotNew.setName((device.get("name") != null) ? device.get("name").asText() : "");

                                for (int v = 0; v < arrVariable.length(); v++) {
                                    JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(v).toString());
                                    String name = variable.get("varname").asText();
                                    logger.debug("name var :{}", name);
                                    if(name.equals("latitude")){
                                        devicePositionInitMarker.setCurrentLat(variable.get("value").asDouble());
                                        deviceIotNew.setCurrentLat(variable.get("value").asDouble());

                                        if(device.get("updateTime") != null){
                                            Long time = Long.parseLong(device.get("updateTime").asText())/1000;
                                            deviceIotNew.setDateTracking(new Date(time));
                                        }
                                    }
                                    if(name.equals("longitude")){
                                        devicePositionInitMarker.setCurrentLon(variable.get("value").asDouble());
                                        deviceIotNew.setCurrentLong(variable.get("value").asDouble());
                                    }
                                    if(name.equals("battery")){
                                        devicePositionInitMarker.setVol(variable.get("value").asDouble());
                                        deviceIotNew.setBattery(variable.get("value").asDouble());
                                    }
                                }

                                deviceIotDAO.save(deviceIotNew);
                            }
                        }

                        initMapMarkerList.add(devicePositionInitMarker);
                    }

                }
            }
        } else {
            if(apiGetDeviceList.getResultStatus() == 401){
                dataResponses.put("success", false);
                return ok(Json.toJson(dataResponses));
            }
        }

        if(initMapMarkerList.size() > 0){
            Collections.sort(initMapMarkerList, new Comparator<DevicePositionInitMarker>() {
                public int compare(DevicePositionInitMarker o1, DevicePositionInitMarker o2) {
                    if (o1.getName() == null || o2.getName() == null) {
                        return 0;
                    }
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

        dataResponses.put("initMapMarkerList", initMapMarkerList);
        dataResponses.put("success", true);
        return ok(Json.toJson(dataResponses));
    }

    public Result sendMessageOnOffApp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String content = jsonGroup.get("content").asText();
        String topic = jsonGroup.get("topic").asText();
        String deviceId = jsonGroup.get("deviceId").asText();

        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/commands/" + deviceId + "/"+topic;
        logger.info("url:{}", url);
        String userToken = request().getHeader("Authorization");
        String deviceToken = request().getHeader("Token");
        logger.info("Referer: {}, Header: token={}, deviceToken={}", request().getHeader("referer"), userToken, deviceToken);
        if(Strings.isNullOrEmpty(userToken)) {
            Matcher m = Pattern.compile(".*/([^?]+)").matcher(request().getHeader("referer"));
            if(m.find()) {
                userToken = "Bearer " + m.group(1);
            }

        }
        if(Strings.isNullOrEmpty(deviceToken)) {
            Matcher m = Pattern.compile("deviceToken=([^&]*)").matcher(request().getHeader("referer"));
            if(m.find()) {
                deviceToken = m.group(1);
            }
        }
        logger.info("token:{}, deviceToken: {}", userToken, deviceToken);

        ApiResult apiSendMessage = apiService.sendMessageOnOffByJson(url, content, deviceToken, userToken);
        logger.info("Send Message:{}", Json.toJson(apiSendMessage));
        respone.setStatus(apiSendMessage.getResultStatus());
        if(apiSendMessage.getResultStatus() == 202){
            respone.setResultString(getMessages().at("noti.Sendsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.SendFalse"));
        }
        return ok(Json.toJson(respone));
    }
}
