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
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.dao.WidgetDAO;
import vn.m2m.iot.form.DevicePositionInitMarker;
import vn.m2m.iot.form.DeviceSocketForm;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.Widget;
import vn.m2m.iot.models.WidgetMapData;
import vn.m2m.iot.service.DeviceConvertModalUtil;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import java.util.*;

@Security.Authenticated(Secured.class)
public class DashboardWidgetController extends AbstractController{
    @Inject
    public DeviceIotDAO deviceIotDAO;
    @Inject
    public DeviceConvertModalUtil deviceConvertModalUtil;
    @Inject
    public ApiService apiService;
    @Inject
    public WidgetDAO widgetDAO;

    public Result dashboardVer2(String projectId) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

//        Widget widget = widgetDAO.getByUsername(userSession.getUsername());
//        if(widget == null){
//            return redirect(routes.WidgetListController.widgetPage());
//        }

        return ok(views.html.iot.dashboard.DashboardVer2.render(userSession, projectId, ""));
    }

    public Result getListDeviceWithWidgetMap(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DevicePositionInitMarker> initMapMarkerList = new ArrayList<DevicePositionInitMarker>();
        Map<String, Object> dataResponses = new HashMap<>();

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();

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

        String token = "Bearer " + userSession.getToken();
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

    public Result getDeviceDataCurrent(String deviceId, String latId, String longId) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        int webMapTimeLostConnectionMinutes = 720;

        WidgetMapData widgetMapData = new WidgetMapData();
        widgetMapData.setId(deviceId);

        String url = appfileConfig.ulrBackendIot + "/api/variables/" + deviceId;
        String token = "Bearer "+userSession.getToken();

        String urlDevice = appfileConfig.ulrBackendIot + "/api/devices/" + deviceId;
        ApiResult apiGetDeviceById = apiService.getByToken(urlDevice, token);
        logger.debug("apiGetDeviceById :{}", Json.toJson(apiGetDeviceById));
        if(apiGetDeviceById.getResultStatus() >= 200 && apiGetDeviceById.getResultStatus() <= 299){
            widgetMapData.setName(apiGetDeviceById.getJsonData().get("name").asText());
        }

        ApiResult apiGetVariableOfDevice = apiService.getByToken(url, token);
        logger.info("apiGetVariableOfDevice :{}", Json.toJson(apiGetVariableOfDevice));
        if(apiGetVariableOfDevice.getResultStatus() >= 200 && apiGetVariableOfDevice.getResultStatus() <= 299){
            JsonNode jsonBody = apiGetVariableOfDevice.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("variables");
            if(arr.length() > 0){
                for(int i=0; i<arr.length(); i++){
                    JsonNode jsonOneVariable = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                    //String name = jsonOneVariable.get("name").asText();
                    String varId = jsonOneVariable.get("id").asText();

                    if(latId.equals(varId)){
                        widgetMapData.setLat(jsonOneVariable.get("value").asDouble());
                    }
                    else if(longId.equals(varId)){
                        widgetMapData.setLng(jsonOneVariable.get("value").asDouble());
                    }

                    widgetMapData.setTimeStamp(jsonOneVariable.get("updatetime").asLong());
                }

                return ok(Json.toJson(widgetMapData));
            }
        }

        return ok(Json.toJson(widgetMapData));
    }

    public Result getHistoryRpc() {
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
        String deviceId = jsonGroup.get("deviceId").asText();

        String url = appfileConfig.ulrBackendIot + "/api/rpc/device/"+deviceId+"/history?offset=0&limit=100";
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getHistoryRpc:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }
}
