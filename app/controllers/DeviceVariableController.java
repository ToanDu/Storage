package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.DeviceVariable;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 6/3/21.
 */
@Security.Authenticated(Secured.class)
public class DeviceVariableController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public DeviceIotDAO deviceIotDAO;

    public Result deviceVariable(String projectId, String id){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        DeviceIot deviceIot = deviceIotDAO.getByKey(id);
        String keyLatitude = "latitude";
        double latitude = 0;
        String keyLongitude = "longitude";
        double longitude = 0;
        String keyBattery = "battery";
        double battery = 0;
        if(deviceIot != null){
            if(!StringUtils.isEmpty(deviceIot.getKeyLatitude())){
                keyLatitude = deviceIot.getKeyLatitude();
            }
            if(!StringUtils.isEmpty(deviceIot.getKeyLongitude())){
                keyLongitude = deviceIot.getKeyLongitude();
            }
            logger.debug("key :{} :{}", keyLatitude, keyLongitude);
        }

        List<DeviceVariable> deviceVariableList = new ArrayList<DeviceVariable>();

        String url = appfileConfig.ulrBackendIot + "/api/variables/" + id;
        String token = "Bearer "+userSession.getToken();

        ApiResult apiGetVariableOfDevice = apiService.getByToken(url, token);
        logger.info("apiGetVariableOfDevice :{}", Json.toJson(apiGetVariableOfDevice));
        if(apiGetVariableOfDevice.getResultStatus() >= 200 && apiGetVariableOfDevice.getResultStatus() <= 299){
            JsonNode jsonBody = apiGetVariableOfDevice.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("variables");
            if(arr.length() > 0){
                for(int i=0; i<arr.length(); i++){
                    DeviceVariable deviceVariable = new DeviceVariable();
                    JsonNode jsonOneGroup = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                    String idVar = (jsonOneGroup.get("id") != null) ? jsonOneGroup.get("id").asText() : "";

                    if(!StringUtils.isEmpty(id)){
                        String name = (jsonOneGroup.get("varname") != null) ? jsonOneGroup.get("varname").asText() : "";
                        String type = (jsonOneGroup.get("vartype") != null) ? jsonOneGroup.get("vartype").asText() : "";
                        String value = (jsonOneGroup.get("value") != null) ? jsonOneGroup.get("value").asText() : "";

                        deviceVariable.setStt(i+1);
                        deviceVariable.setId(idVar);
                        deviceVariable.setName(name);
                        if(type.equals("string")){
                            deviceVariable.setType("text");
                        }else{
                            deviceVariable.setType(type);
                        }

                        deviceVariable.setValue(value);

                        deviceVariableList.add(deviceVariable);

                        try {
                            if(name.equals(keyLatitude)){
                                latitude = Double.parseDouble(value);
                            }
                            if(name.equals(keyLongitude)){
                                longitude = Double.parseDouble(value);
                            }
                            if(name.equals(keyBattery)){
                                battery = Double.parseDouble(value);
                            }
                            logger.debug("value :{} :{}", latitude, longitude);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        } else {
            if(apiGetVariableOfDevice.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
        }

        return ok(views.html.iot.DeviceIot.variable.DeviceIotVariable.render(userSession, projectId, deviceVariableList, id, latitude, longitude, battery));
    }

    public Result getListVarByIdDevice(String id){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/variables/" + id;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetVarList = apiService.getByToken(url, token);

        if(apiGetVarList.getResultStatus() >= 200 && apiGetVarList.getResultStatus() <= 299) {
            respone.setContent(apiGetVarList.getJsonData());
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
    }

    public Result addVariable() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText():"";
        String name = (jsonGroup.get("name") != null) ? jsonGroup.get("name").asText().trim():"";
        String type = (jsonGroup.get("type") != null) ? jsonGroup.get("type").asText().trim():"";
        String value = (jsonGroup.get("value") != null) ? jsonGroup.get("value").asText().trim():"";

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(type) || StringUtils.isEmpty(value)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.chooseInfoVariable"));
            return ok(Json.toJson(respone));
        }

        String urlCreateVariable = appfileConfig.ulrBackendIot + "/api/devices/variables";
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("deviceid", id);
        Map<String, String> var = new HashMap<>();
        var.put("varname", name);
        var.put("vartype", type);
        var.put("value", value);
        List<Object> variables = new ArrayList<>();
        variables.add(var);
        bodyData.put("variables", variables);
        logger.debug("bodyData : {}", Json.toJson(bodyData));

        ApiResult apiCreateVariable = apiService.sendPostJson(urlCreateVariable, Json.toJson(bodyData), token);
        logger.info("Create Variable:{}", Json.toJson(apiCreateVariable));
        respone.setStatus(apiCreateVariable.getResultStatus());
        if(apiCreateVariable.getResultStatus() >= 200 && apiCreateVariable.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        respone.setStatus(apiCreateVariable.getResultStatus());
        return ok(Json.toJson(respone));
    }

    public Result delVariable() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String idDevice = (jsonGroup.get("idDevice") != null) ? jsonGroup.get("idDevice").asText():"";
        String idVariable = (jsonGroup.get("idVariable") != null) ? jsonGroup.get("idVariable").asText():"";

        if (StringUtils.isEmpty(idDevice) || StringUtils.isEmpty(idVariable)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        String urlDelVariable = appfileConfig.ulrBackendIot + "/api/devices/"+idDevice+"/variables/"+idVariable;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDelVariable = apiService.deleteByToken(urlDelVariable, token);
        logger.info("Delete Variable:{}", Json.toJson(apiDelVariable));
        respone.setStatus(apiDelVariable.getResultStatus());
        if(apiDelVariable.getResultStatus() >= 200 && apiDelVariable.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getDataVariableById() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String varName = (jsonGroup.get("varName") != null) ? jsonGroup.get("varName").asText():"";
        String deviceId = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";

        if (StringUtils.isEmpty(varName) || StringUtils.isEmpty(deviceId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        String urlGetHistoryVariable = appfileConfig.ulrBackendIot + "/api/variables?deviceid=" + deviceId + "&varname=" + varName+"&offset=0&limit=500";
        logger.debug("urlGetHistoryVariable :{}", urlGetHistoryVariable);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetHistoryVariable = apiService.getByToken(urlGetHistoryVariable, token);
        respone.setStatus(apiGetHistoryVariable.getResultStatus());
        if(apiGetHistoryVariable.getResultStatus() >= 200 && apiGetHistoryVariable.getResultStatus() <= 299){
            JsonNode jsonBody = apiGetHistoryVariable.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("variables");

            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            if(arr.length() > 0){
                for(int i=0; i<arr.length(); i++){
                    JsonNode jsonOneGroup = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                    String value = (jsonOneGroup.get("value") != null) ? jsonOneGroup.get("value").asText() : "";
                    String updatetime = (jsonOneGroup.get("updatetime") != null) ? jsonOneGroup.get("updatetime").asText() : "";

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
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
        }
        return ok(Json.toJson(respone));
    }
}
