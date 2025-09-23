package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.*;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.DeviceVariable;
import vn.m2m.models.ApiResult;
import vn.m2m.models.Group;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.SearchUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static vn.m2m.utils.SearchUtil.*;
import static vn.m2m.utils.SearchUtil.SEARCH_INT_TYPE;

@Security.Authenticated(Secured.class)
public class DeviceIotController extends AbstractController {
    @Inject
    public DeviceIotDAO deviceIotDAO;
    @Inject
    public ApiService apiService;

    public Result deviceIotList(String projectId){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<DeviceIot> deviceIotList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        ApiResult apiGetDeviceList = apiService.getWithParams(url, token, param);
        logger.debug("Get ds device:{}", Json.toJson(apiGetDeviceList));

        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (device.get("id") != null) {
                        DeviceIot deviceIot = new DeviceIot();
                        deviceIot.setId(device.get("id").asText());
                        deviceIot.setName((device.get("name") != null) ? device.get("name").asText() : "");
                        deviceIot.setGroupId((device.get("groupID") != null) ? device.get("groupID").asText() : "");
                        deviceIot.setGroupName((device.get("groupName") != null) ? device.get("groupName").asText() : "");
                        deviceIot.setOrgID((device.get("organizationID") != null) ? device.get("organizationID").asText() : "");
                        deviceIot.setOrgName((device.get("organizationName") != null) ? device.get("organizationName").asText() : "");
                        deviceIot.setTypeID((device.get("typeID") != null) ? device.get("typeID").asText() : "");
                        deviceIot.setTypeName((device.get("typeName") != null) ? device.get("typeName").asText() : "");
                        deviceIot.setStatus((device.get("status") != null) ? device.get("status").asBoolean() : false);

                        deviceIotList.add(deviceIot);
                    }

                }
            }
        } else {
            if(apiGetDeviceList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
        }

        return ok(views.html.iot.DeviceIot.DeviceIotList.render(userSession, deviceIotList, projectId));
    }

    public Result addNewDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = (jsonGroup.get("name") != null) ? jsonGroup.get("name").asText() : "";
        String orgId = (jsonGroup.get("orgId") != null) ? jsonGroup.get("orgId").asText() : "";
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() : "";
        String groupId = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() : "";
        String templateId = (jsonGroup.get("templateId") != null) ? jsonGroup.get("templateId").asText() : "";

        if (StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        String urlCreateDevice = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("org_id", orgId);
        bodyData.put("project_id", projectId);
        bodyData.put("group_id", groupId);
        bodyData.put("template_id", templateId);
        bodyData.put("metadata", Json.toJson(new HashMap<>()));
        logger.debug("create data device :{}", Json.toJson(bodyData));

        ApiResult apiCreateDevice = apiService.sendPostJson(urlCreateDevice, Json.toJson(bodyData), token);
        logger.info("Create Device:{}", Json.toJson(apiCreateDevice));
        respone.setStatus(apiCreateDevice.getResultStatus());
        if(apiCreateDevice.getResultStatus() >= 200 && apiCreateDevice.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deleteDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("device.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteDevice = appfileConfig.ulrBackendIot + "/api/devices/" + id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDeleteDevice = apiService.deleteByToken(urlDeleteDevice, token);
        logger.info("Delete Device:{}", Json.toJson(apiDeleteDevice));

        if(apiDeleteDevice.getResultStatus() >= 200 && apiDeleteDevice.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result editNameDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String name = jsonGroup.get("name").asText();
        String groupId = jsonGroup.get("groupId").asText();
        String templateId = jsonGroup.get("templateId").asText();

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        String urlEditNameDevice = appfileConfig.ulrBackendIot + "/api/devices/"+id;
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("group_id", groupId);
        bodyData.put("template_id", templateId);
        bodyData.put("metadata", Json.toJson(new HashMap<>()));
        logger.debug("edit data device :{}", Json.toJson(bodyData));

        ApiResult apiEditNameDevice = apiService.putJson(urlEditNameDevice, Json.toJson(bodyData), token);
        logger.info("Edit Name Device:{}", Json.toJson(apiEditNameDevice));
        respone.setStatus(apiEditNameDevice.getResultStatus());
        if(apiEditNameDevice.getResultStatus() >= 200 && apiEditNameDevice.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    //update
    public Result updateDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = jsonGroup.get("id").asText();
        String idOrg = (jsonGroup.get("idOrg")!=null) ? jsonGroup.get("idOrg").asText() : "";
        String idGroup = (jsonGroup.get("idGroup")!=null) ? jsonGroup.get("idGroup").asText() :"";
        String idType = (jsonGroup.get("idType")!=null) ? jsonGroup.get("idType").asText() :"";

        if (StringUtils.isEmpty(deviceId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        if (StringUtils.isEmpty(idOrg) && StringUtils.isEmpty(idGroup) && StringUtils.isEmpty(idType)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.chooseInfoUpdateDevice"));
            return ok(Json.toJson(respone));
        }

        Map<String, Object> result = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(idOrg)){
            String urlUpdateOrgDevice = appfileConfig.ulrBackendIot + "/api/devices/"+ deviceId + "/organization/" + idOrg;
            String token = "Bearer " + userSession.getToken();

            ApiResult apiUpdateOrganizationDevice = apiService.sendPut(urlUpdateOrgDevice, token);
            logger.info("Update organization:{}", Json.toJson(apiUpdateOrganizationDevice));
            result.put("orgStatus", apiUpdateOrganizationDevice.getResultStatus());
            if(apiUpdateOrganizationDevice.getResultStatus() >= 200 && apiUpdateOrganizationDevice.getResultStatus() <= 299){
                result.put("organization", true);
            } else {
                result.put("organization", false);
            }
        }

        if (!StringUtils.isEmpty(idGroup)){
            String urlUpdateGroupDevice = appfileConfig.ulrBackendIot + "/api/devices/"+ deviceId + "/group/" + idGroup;
            String token = "Bearer " + userSession.getToken();

            ApiResult apiUpdateGroupDevice = apiService.sendPut(urlUpdateGroupDevice, token);
            logger.info("Update group:{}", Json.toJson(apiUpdateGroupDevice));
            result.put("groupStatus", apiUpdateGroupDevice.getResultStatus());
            if(apiUpdateGroupDevice.getResultStatus() >= 200 && apiUpdateGroupDevice.getResultStatus() <= 299){
                result.put("group", true);
            } else {
                result.put("group", false);
            }
        }

        if (!StringUtils.isEmpty(idType)){
            String urlUpdateTypeDevice = appfileConfig.ulrBackendIot + "/api/devices/"+ deviceId + "/type/" + idType;
            String token = "Bearer " + userSession.getToken();

            ApiResult apiUpdateTypeDevice = apiService.sendPut(urlUpdateTypeDevice, token);
            logger.info("Update type:{}", Json.toJson(apiUpdateTypeDevice));
            result.put("typeStatus", apiUpdateTypeDevice.getResultStatus());
            if(apiUpdateTypeDevice.getResultStatus() >= 200 && apiUpdateTypeDevice.getResultStatus() <= 299){
                result.put("type", true);
            } else {
                result.put("type", false);
            }
        }

        if((boolean)result.get("type") && (boolean)result.get("group") && (boolean)result.get("organization")){
            String urlUpdatedDevice = appfileConfig.ulrBackendIot + "/api/devices/"+ deviceId;
            String token = "Bearer " + userSession.getToken();

            ApiResult apiGetUpdatedDevice = apiService.getByToken(urlUpdatedDevice, token);
            logger.info("Update type:{}", Json.toJson(apiGetUpdatedDevice));
            result.put("getUpdatedDeviceStatus", apiGetUpdatedDevice.getResultStatus());
            if(apiGetUpdatedDevice.getResultStatus() >= 200 && apiGetUpdatedDevice.getResultStatus() <= 299) {
                JsonNode jsonBody = apiGetUpdatedDevice.getJsonData();
                JSONObject obj = new JSONObject(jsonBody.toString());
                JsonNode UpdatedDevice = ObjectUtil.jsonStrToJsonNode(obj.toString());

                DeviceIot deviceIot = new DeviceIot();

                deviceIot.setId(UpdatedDevice.get("id").asText());
                deviceIot.setName((UpdatedDevice.get("name") != null) ? UpdatedDevice.get("name").asText() : "");
                deviceIot.setGroupId((UpdatedDevice.get("groupID") != null) ? UpdatedDevice.get("groupID").asText() : "");
                deviceIot.setGroupName((UpdatedDevice.get("groupName") != null) ? UpdatedDevice.get("groupName").asText() : "");
                deviceIot.setOrgID((UpdatedDevice.get("organizationID") != null) ? UpdatedDevice.get("organizationID").asText() : "");
                deviceIot.setOrgName((UpdatedDevice.get("organizationName") != null) ? UpdatedDevice.get("organizationName").asText() : "");
                deviceIot.setTypeID((UpdatedDevice.get("typeID") != null) ? UpdatedDevice.get("typeID").asText() : "");
                deviceIot.setTypeName((UpdatedDevice.get("typeName") != null) ? UpdatedDevice.get("typeName").asText() : "");

                result.put("updatedDevice", deviceIot);
            }
        }


        respone.setContent(result);
        respone.setResultString(getMessages().at("noti.Updatesuccess") + " " + deviceId);
        return ok(Json.toJson(respone));
    }

    public Result configGpsDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String idDevice = (jsonGroup.get("deviceId") != null) ? jsonGroup.get("deviceId").asText():"";
        String keyLat = (jsonGroup.get("keyLat") != null) ? jsonGroup.get("keyLat").asText():"";
        String keyLong = (jsonGroup.get("keyLong") != null) ? jsonGroup.get("keyLong").asText():"";

        if (StringUtils.isEmpty(idDevice)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(keyLat) || StringUtils.isEmpty(keyLong)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        if(keyLat.equals(keyLong)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.notVariableSame"));
            return ok(Json.toJson(respone));
        }

        DeviceIot deviceIot = deviceIotDAO.getByKey(idDevice);
        if(deviceIot != null){
            deviceIot.setKeyLatitude(keyLat);
            deviceIot.setKeyLongitude(keyLong);

            deviceIotDAO.save(deviceIot);
        } else {
            DeviceIot deviceIotNew = new DeviceIot();
            deviceIotNew.setId(idDevice);
            deviceIotNew.setKeyLatitude(keyLat);
            deviceIotNew.setKeyLongitude(keyLong);

            deviceIotDAO.save(deviceIotNew);
        }

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getConfigOfDeviceIot(String id){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        DeviceIot deviceIot = deviceIotDAO.getByKey(id);
        if(deviceIot == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("device.variable.notFoundConfig"));
            return ok(Json.toJson(respone));
        } else {
            respone.setContent(deviceIot);
            return ok(Json.toJson(respone));
        }
    }

    public Result getListDeviceIot(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DeviceIot> deviceIotList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getByToken(url, token);
        respone.setStatus(apiGetDeviceList.getResultStatus());
        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (device.get("id") != null) {
                        DeviceIot deviceIot = new DeviceIot();
                        deviceIot.setId(device.get("id").asText());
                        deviceIot.setName((device.get("name") != null) ? device.get("name").asText() : "");
                        deviceIot.setGroupId((device.get("groupID") != null) ? device.get("groupID").asText() : "");
                        deviceIot.setGroupName((device.get("groupName") != null) ? device.get("groupName").asText() : "");
                        deviceIot.setOrgID((device.get("organization") != null) ? device.get("organization").asText() : "");
                        deviceIot.setOrgName((device.get("organizationName") != null) ? device.get("organizationName").asText() : "");
                        deviceIot.setTypeID((device.get("typeID") != null) ? device.get("typeID").asText() : "");
                        deviceIot.setTypeName((device.get("typeName") != null) ? device.get("typeName").asText() : "");

                        JSONObject objVariable = new JSONObject(device.toString());
                        JSONArray arrVariable = objVariable.optJSONArray("variables");
                        List<DeviceVariable> deviceVariables = new ArrayList<>();

                        for(int j = 0; arrVariable != null && j < arrVariable.length(); j++){
                            JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(j).toString());
                            DeviceVariable deviceVariable = new DeviceVariable();
                            deviceVariable.setId((variable.get("id") != null) ? variable.get("id").asText() : "");
                            deviceVariable.setName((variable.get("varname") != null) ? variable.get("varname").asText() : "");
                            deviceVariable.setValue((variable.get("value") != null) ? variable.get("value").asText() : "");
                            deviceVariable.setType((variable.get("vartype") != null) ? variable.get("vartype").asText() : "");

                            deviceVariables.add(deviceVariable);
                        }
                        deviceIot.setVariables(deviceVariables);

                        deviceIotList.add(deviceIot);
                    }

                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        respone.setContent(deviceIotList);
        return ok(Json.toJson(respone));
    }

    public Result getListDeviceByOrg(String id, String projectId){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DeviceIot> deviceIotList = new ArrayList<>();

        if(projectId.equals(id)){
            id = "";
        }

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getWithParams(url, token, param);
        logger.debug("apiGetDeviceList : {}", Json.toJson(apiGetDeviceList));
        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (device.get("id") != null) {
                        DeviceIot deviceIot = new DeviceIot();
                        deviceIot.setId(device.get("id").asText());
                        deviceIot.setName((device.get("name") != null) ? device.get("name").asText() : "");
                        deviceIot.setGroupId((device.get("groupID") != null) ? device.get("groupID").asText() : "");
                        deviceIot.setGroupName((device.get("groupName") != null) ? device.get("groupName").asText() : "");
                        deviceIot.setOrgID((device.get("organization") != null) ? device.get("organization").asText() : "");
                        deviceIot.setOrgName((device.get("organizationName") != null) ? device.get("organizationName").asText() : "");
                        deviceIot.setTypeID((device.get("typeID") != null) ? device.get("typeID").asText() : "");
                        deviceIot.setTypeName((device.get("typeName") != null) ? device.get("typeName").asText() : "");

                        JSONObject objVariable = new JSONObject(device.toString());
                        JSONArray arrVariable = objVariable.optJSONArray("variables");
                        List<DeviceVariable> deviceVariables = new ArrayList<>();

                        for(int j = 0; arrVariable != null && j < arrVariable.length(); j++){
                            JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(j).toString());
                            DeviceVariable deviceVariable = new DeviceVariable();
                            deviceVariable.setId((variable.get("id") != null) ? variable.get("id").asText() : "");
                            deviceVariable.setName((variable.get("varname") != null) ? variable.get("varname").asText() : "");
                            deviceVariable.setValue((variable.get("value") != null) ? variable.get("value").asText() : "");
                            deviceVariable.setType((variable.get("vartype") != null) ? variable.get("vartype").asText() : "");

                            deviceVariables.add(deviceVariable);
                        }
                        deviceIot.setVariables(deviceVariables);

                        deviceIotList.add(deviceIot);
                    }

                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        respone.setContent(deviceIotList);
        return ok(Json.toJson(respone));
    }

    public Result getListDeviceAndAttrByOrg(String id, String projectId){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        if(projectId.equals(id)){
            id = "";
        }

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getWithParams(url, token, param);
        logger.debug("apiGetDeviceList : {}", Json.toJson(apiGetDeviceList));
        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");

            List<Object> deviceIotList = new ArrayList<>();
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                    deviceIotList.add(device);
                }
            }

            respone.setContent(deviceIotList);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
    }

    public Result getListDeviceByGroup(String id){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DeviceIot> deviceIotList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/devices/group/" + id;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getByToken(url, token);
        respone.setStatus(apiGetDeviceList.getResultStatus());
        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (device.get("id") != null) {
                        DeviceIot deviceIot = new DeviceIot();
                        deviceIot.setId(device.get("id").asText());
                        deviceIot.setName((device.get("name") != null) ? device.get("name").asText() : "");
                        deviceIot.setGroupId((device.get("groupID") != null) ? device.get("groupID").asText() : "");
                        deviceIot.setGroupName((device.get("groupName") != null) ? device.get("groupName").asText() : "");
                        deviceIot.setOrgID((device.get("organization") != null) ? device.get("organization").asText() : "");
                        deviceIot.setOrgName((device.get("organizationName") != null) ? device.get("organizationName").asText() : "");
                        deviceIot.setTypeID((device.get("typeID") != null) ? device.get("typeID").asText() : "");
                        deviceIot.setTypeName((device.get("typeName") != null) ? device.get("typeName").asText() : "");

                        JSONObject objVariable = new JSONObject(device.toString());
                        JSONArray arrVariable = objVariable.optJSONArray("variables");
                        List<DeviceVariable> deviceVariables = new ArrayList<>();

                        for(int j = 0; arrVariable != null && j < arrVariable.length(); j++){
                            JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(j).toString());
                            DeviceVariable deviceVariable = new DeviceVariable();
                            deviceVariable.setId((variable.get("id") != null) ? variable.get("id").asText() : "");
                            deviceVariable.setName((variable.get("varname") != null) ? variable.get("varname").asText() : "");
                            deviceVariable.setValue((variable.get("value") != null) ? variable.get("value").asText() : "");
                            deviceVariable.setType((variable.get("vartype") != null) ? variable.get("vartype").asText() : "");

                            deviceVariables.add(deviceVariable);
                        }
                        deviceIot.setVariables(deviceVariables);

                        deviceIotList.add(deviceIot);
                    }

                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        respone.setContent(deviceIotList);
        return ok(Json.toJson(respone));
    }

    public Result getListDeviceByDeviceType(String id){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DeviceIot> deviceIotList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/devices/type/" + id;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getByToken(url, token);
        respone.setStatus(apiGetDeviceList.getResultStatus());
        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (device.get("id") != null) {
                        DeviceIot deviceIot = new DeviceIot();
                        deviceIot.setId(device.get("id").asText());
                        deviceIot.setName((device.get("name") != null) ? device.get("name").asText() : "");
                        deviceIot.setGroupId((device.get("groupID") != null) ? device.get("groupID").asText() : "");
                        deviceIot.setGroupName((device.get("groupName") != null) ? device.get("groupName").asText() : "");
                        deviceIot.setOrgID((device.get("organization") != null) ? device.get("organization").asText() : "");
                        deviceIot.setOrgName((device.get("organizationName") != null) ? device.get("organizationName").asText() : "");
                        deviceIot.setTypeID((device.get("typeID") != null) ? device.get("typeID").asText() : "");
                        deviceIot.setTypeName((device.get("typeName") != null) ? device.get("typeName").asText() : "");

                        JSONObject objVariable = new JSONObject(device.toString());
                        JSONArray arrVariable = objVariable.optJSONArray("variables");
                        List<DeviceVariable> deviceVariables = new ArrayList<>();

                        for(int j = 0; arrVariable != null && j < arrVariable.length(); j++){
                            JsonNode variable = ObjectUtil.jsonStrToJsonNode(arrVariable.get(j).toString());
                            DeviceVariable deviceVariable = new DeviceVariable();
                            deviceVariable.setId((variable.get("id") != null) ? variable.get("id").asText() : "");
                            deviceVariable.setName((variable.get("varname") != null) ? variable.get("varname").asText() : "");
                            deviceVariable.setValue((variable.get("value") != null) ? variable.get("value").asText() : "");
                            deviceVariable.setType((variable.get("vartype") != null) ? variable.get("vartype").asText() : "");

                            deviceVariables.add(deviceVariable);
                        }
                        deviceIot.setVariables(deviceVariables);

                        deviceIotList.add(deviceIot);
                    }

                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        respone.setContent(deviceIotList);
        return ok(Json.toJson(respone));
    }

    public Result getListDeviceVarsByDevice(String id){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DeviceVariable> deviceVarList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/variables/" + id;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetDeviceList = apiService.getByToken(url, token);
        respone.setStatus(apiGetDeviceList.getResultStatus());
        if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetDeviceList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("variables");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode var = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (var.get("id") != null) {
                        DeviceVariable deviceVar = new DeviceVariable();
                        deviceVar.setId(var.get("id").asText());
                        deviceVar.setName((var.get("varname") != null) ? var.get("varname").asText() : "");
                        deviceVar.setType((var.get("vartype") != null) ? var.get("vartype").asText() : "");
                        deviceVar.setValue((var.get("value") != null) ? var.get("value").asText() : "");

                        deviceVarList.add(deviceVar);
                    }

                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        respone.setContent(deviceVarList);
        return ok(Json.toJson(respone));
    }

    public Result createDeviceWithSerialSim() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String urlCreateDevice = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiCreateDevice = apiService.sendPostJson(urlCreateDevice, jsonGroup, token);
        logger.info("createDeviceWithSerialSim:{}", Json.toJson(apiCreateDevice));
        respone.setStatus(apiCreateDevice.getResultStatus());
        if(apiCreateDevice.getResultStatus() >= 200 && apiCreateDevice.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Serial Sim đã được tạo"));
        }
        return ok(Json.toJson(respone));
    }
}
