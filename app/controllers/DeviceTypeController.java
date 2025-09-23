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
import vn.m2m.iot.models.DeviceType;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class DeviceTypeController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result deviceTypeList(String projectId){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<DeviceType> deviceTypeList = new ArrayList<DeviceType>();

        String url = appfileConfig.ulrBackendIot + "/api/devicetypes";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetTypeList = apiService.getByToken(url, token);

        if(apiGetTypeList.getResultStatus() >= 200 && apiGetTypeList.getResultStatus() <= 299) {
            JsonNode jsonBody = apiGetTypeList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devicetypes");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode type = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (type.get("id") != null) {
                        DeviceType deviceType = new DeviceType();
                        deviceType.setId(type.get("id").asText());
                        deviceType.setName((type.get("name") != null) ? type.get("name").asText() : "");
                        deviceType.setOrganization((type.get("organization") != null) ? type.get("organization").asText() : "");
                        deviceType.setOrganizationName((type.get("organizationName") != null) ? type.get("organizationName").asText() : "");

                        deviceTypeList.add(deviceType);
                    }

                }
            }
        } else {
            if(apiGetTypeList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
        }

        return ok(views.html.iot.deviceType.DeviceTypeList.render(userSession, deviceTypeList, projectId));
    }

    public Result addNewDeviceType() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String orgId = jsonGroup.get("orgId").asText();

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }
        if (org.springframework.util.StringUtils.isEmpty(orgId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("manage.deviceIot.chooseOrg"));
            return ok(Json.toJson(respone));
        }

        String urlCreateDeviceType = appfileConfig.ulrBackendIot + "/api/devicetypes";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("name", name);
        ApiResult apiCreateDeviceType = apiService.sendPostJson(urlCreateDeviceType, Json.toJson(bodyData), token);
        logger.info("Create Type:{}", Json.toJson(apiCreateDeviceType));
        respone.setStatus(apiCreateDeviceType.getResultStatus());
        if(apiCreateDeviceType.getResultStatus() >= 200 && apiCreateDeviceType.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));

            String typeId = (apiCreateDeviceType.getJsonData() != null) ? apiCreateDeviceType.getJsonData().get("id").asText() : "";
            if(!StringUtils.isEmpty(typeId)){
                String urlUpdateOrgDeviceType = appfileConfig.ulrBackendIot + "/api/devicetypes/"+ typeId + "/organization/" + orgId;

                ApiResult apiUpdateOrganizationType = apiService.sendPut(urlUpdateOrgDeviceType, token);
                logger.info("Update organization:{}", Json.toJson(apiUpdateOrganizationType));
                respone.setStatus(apiUpdateOrganizationType.getResultStatus());
                if(apiUpdateOrganizationType.getResultStatus() >= 200 && apiUpdateOrganizationType.getResultStatus() <= 299){
                    respone.setResultString(getMessages().at("noti.Addsuccess"));
                } else {
                    respone.setIssuccess(false);
                    respone.setErrorString(getMessages().at("manage.deviceIot.updateOrg"));
                }
            } else {
                respone.setStatus(0);
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("manage.deviceIot.updateOrg"));
            }

        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deleteDeviceType() {
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
            respone.setErrorString(getMessages().at("deviceType.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteType = appfileConfig.ulrBackendIot + "/api/devicetypes/" + id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDeleteType = apiService.deleteByToken(urlDeleteType, token);
        logger.info("Delete Type:{}", Json.toJson(apiDeleteType));
        respone.setStatus(apiDeleteType.getResultStatus());
        if(apiDeleteType.getResultStatus() >= 200 && apiDeleteType.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result editDeviceType() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText().trim();
        String id = jsonGroup.get("id").asText().trim();

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        String urlEditDeviceType = appfileConfig.ulrBackendIot + "/api/devicetypes/"+id;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("name", name);
        ApiResult apiEditDeviceType = apiService.putJson(urlEditDeviceType, Json.toJson(bodyData), token);
        logger.info("Edit Device Type:{}", Json.toJson(apiEditDeviceType));
        respone.setStatus(apiEditDeviceType.getResultStatus());
        if(apiEditDeviceType.getResultStatus() >= 200 && apiEditDeviceType.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getListTypes() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<DeviceType> deviceTypeList = new ArrayList<DeviceType>();

        String url = appfileConfig.ulrBackendIot + "/api/devicetypes";
        String token = "Bearer "+userSession.getToken();

        ApiResult apiGetOrgList = apiService.getByToken(url, token);
        respone.setStatus(apiGetOrgList.getResultStatus());
        if(apiGetOrgList.getResultStatus() >= 200 && apiGetOrgList.getResultStatus() <= 299){
            JsonNode jsonBody = apiGetOrgList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devicetypes");
            if(arr.length() > 0){
                for(int i=0; i<arr.length(); i++){
                    DeviceType deviceType = new DeviceType();
                    JsonNode jsonOneGroup = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                    String id = (jsonOneGroup.get("id") != null) ? jsonOneGroup.get("id").asText() : "";
                    if(!StringUtils.isEmpty(id)){
                        deviceType.setId(id);
                        deviceType.setName(jsonOneGroup.get("name").asText());

                        deviceTypeList.add(deviceType);
                    }
                }
            }

            respone.setContent(deviceTypeList);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

}
