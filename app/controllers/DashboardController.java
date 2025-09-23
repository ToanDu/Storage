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
import vn.m2m.common.models.forms.SearchFilter;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.form.DevicePositionInitMarker;
import vn.m2m.iot.form.DeviceSocketForm;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.DeviceVariable;
import vn.m2m.iot.service.DeviceConvertModalUtil;
import vn.m2m.models.ApiResult;
import vn.m2m.models.Group;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.UserHelper;

import java.util.*;

@Security.Authenticated(Secured.class)
public class DashboardController extends AbstractController {
    @Inject
    public DeviceIotDAO deviceIotDAO;
    @Inject
    public DeviceConvertModalUtil deviceConvertModalUtil;
    @Inject
    public ApiService apiService;

    public Result dashboard() {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        User user = userDAO.getByUsername(userSession.getUsername());
        if(StringUtils.isEmpty(user.getDeviceToken())){
            try {
                String urlCreateDeviceToken = appfileConfig.ulrBackendIot + "/api/devicetokens";
                String tokenStr = "Bearer " + user.getToken();

                ApiResult apiCreateDeviceToken = apiService.sendPost(urlCreateDeviceToken, tokenStr);

                if(apiCreateDeviceToken.getResultStatus() >= 200 && apiCreateDeviceToken.getResultStatus() <= 299) {
                    String urlGetDeviceToken = appfileConfig.ulrBackendIot + "/api/devicetokens";

                    ApiResult apiGetDeviceToken = apiService.getByToken(urlGetDeviceToken, tokenStr);
                    if(apiGetDeviceToken.getResultStatus() >= 200 && apiGetDeviceToken.getResultStatus() <= 299) {
                        if(apiGetDeviceToken.getJsonData() != null){
                            JSONObject obj = new JSONObject(apiGetDeviceToken.getJsonData().toString());
                            if(obj.getJSONArray("devicetokens") != null){
                                JSONArray arr = obj.getJSONArray("devicetokens");
                                if(arr.length() > 0){
                                    JsonNode jsonOneDevice = ObjectUtil.jsonStrToJsonNode(arr.get(0).toString());
                                    if(jsonOneDevice.get("devicetoken") != null){
                                        logger.info("device token :{}", jsonOneDevice.get("devicetoken").asText());
                                        user.setDeviceToken(jsonOneDevice.get("devicetoken").asText());
                                        userDAO.save(user);
                                    }
                                }
                            }
                        }
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("Error description:",ex);
            }
        }

//        long countTotalDevice = 0;
//        long countTotalUser = 0;
//        //get total user
//        String url = appfileConfig.ulrBackendIot + "/api/users";
//        String token = "Bearer " + userSession.getToken();
//        ApiResult apiGetUserList = apiService.getByToken(url, token);
//        logger.info("apiGetUserList :{}", Json.toJson(apiGetUserList));
//        if(apiGetUserList.getResultStatus() >= 200 && apiGetUserList.getResultStatus() <= 299) {
//            countTotalUser = (apiGetUserList.getJsonData().get("total") != null) ? apiGetUserList.getJsonData().get("total").asInt() : 0;
//        } else {
//            if(apiGetUserList.getResultStatus() == 401){
//                logger.info("status 401 :{}", apiGetUserList.getResultStatus());
//                return redirect(routes.Application.logout());
//            }
//        }

        return ok(views.html.iot.dashboard.Dashboard.render(userSession));
    }

    public Result getListDeviceWithPaging(){
        User userSession = getUserSession();

        List<DevicePositionInitMarker> initMapMarkerList = new ArrayList<DevicePositionInitMarker>();
        Map<String, Object> dataResponses = new HashMap<>();

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getByToken(url, token);

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

    public Result getMarkersWithPaging(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<Group> groupList = new ArrayList<Group>();

        groupList = groupDAO.getAll();
        logger.debug("groupList size :{}", groupList.size());

        boolean isMore = true;

        List<DevicePositionInitMarker> initMapMarkerList = new ArrayList<DevicePositionInitMarker>();

        List<DeviceIot> deviceIotList = deviceIotDAO.getAll();

        if (deviceIotList.size() > 0) {
            logger.debug("deviceIotList :{}", deviceIotList.size());
            for (DeviceIot deviceIot : deviceIotList) {
                DevicePositionInitMarker positionInitMap = deviceConvertModalUtil.convertDeviceIotToInitMapMarker(deviceIot, 720);
                if(positionInitMap != null){
                    if(positionInitMap.getCurrentLat() != 0 && positionInitMap.getCurrentLon() != 0){
                        initMapMarkerList.add(positionInitMap);
                    }
                }
            }
        }

        Collections.sort(initMapMarkerList, new Comparator<DevicePositionInitMarker>() {
            public int compare(DevicePositionInitMarker o1, DevicePositionInitMarker o2) {
                if (o1.getImei() == null || o2.getImei() == null) {
                    return 0;
                }
                return o1.getImei().compareTo(o2.getImei());
            }
        });

        Map<String, Object> dataResponses = new HashMap<>();
        dataResponses.put("isMore", isMore);
        dataResponses.put("initMapMarkerList", initMapMarkerList);
        return ok(Json.toJson(dataResponses));
    }

    public Result loadDeviceDataCurrent(String id) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        int webMapTimeLostConnectionMinutes = 720;

        DeviceIot deviceIot = deviceIotDAO.getByKey(id);
        if(deviceIot == null){
            deviceIot = new DeviceIot();
            deviceIot.setId(id);
        }
        logger.debug("device iot  :{}", Json.toJson(deviceIot));

        String url = appfileConfig.ulrBackendIot + "/api/variables/" + id;
        String token = "Bearer "+userSession.getToken();

        String urlDevice = appfileConfig.ulrBackendIot + "/api/devices/" + id;
        ApiResult apiGetDeviceById = apiService.getByToken(urlDevice, token);
        logger.debug("apiGetDeviceById :{}", Json.toJson(apiGetDeviceById));
        if(apiGetDeviceById.getResultStatus() >= 200 && apiGetDeviceById.getResultStatus() <= 299){
            deviceIot.setName(apiGetDeviceById.getJsonData().get("name").asText());
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
                    String name = jsonOneVariable.get("name").asText();

                    String keyLatitude = deviceIot.getKeyLatitude();
                    String keyLongitude = deviceIot.getKeyLongitude();
                    String keyBattery = deviceIot.getKeyBattery();
                    if(!StringUtils.isEmpty(keyLatitude) && !StringUtils.isEmpty(keyLongitude)){
                        if(name.equals(keyLatitude)){
                            deviceIot.setCurrentLat(jsonOneVariable.get("value").asDouble());
                        }
                        if(name.equals(keyLongitude)){
                            deviceIot.setCurrentLong(jsonOneVariable.get("value").asDouble());
                        }
                        if(name.equals(keyBattery)){
                            deviceIot.setBattery(jsonOneVariable.get("value").asDouble());
                        }
                    } else {
                        if(name.equals("latitude")){
                            deviceIot.setCurrentLat(jsonOneVariable.get("value").asDouble());
                        }
                        if(name.equals("longitude")){
                            deviceIot.setCurrentLong(jsonOneVariable.get("value").asDouble());
                        }
                        if(name.equals("battery")){
                            deviceIot.setBattery(jsonOneVariable.get("value").asDouble());
                        }
                    }
                }
                deviceIotDAO.save(deviceIot);

                DeviceSocketForm deviceSocketForm = new DeviceSocketForm(deviceIot, webMapTimeLostConnectionMinutes);
                logger.debug("deviceSocketForm :{}", Json.toJson(deviceSocketForm));
                return ok(Json.toJson(deviceSocketForm));
            }
        }

        DeviceSocketForm deviceSocketForm = new DeviceSocketForm();
        return ok(Json.toJson(deviceSocketForm));
    }

}
