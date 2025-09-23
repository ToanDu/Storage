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
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 6/21/21.
 */
@Security.Authenticated(Secured.class)
public class LogDeviceController extends AbstractController {
    @Inject
    public DeviceIotDAO deviceIotDAO;
    @Inject
    public ApiService apiService;

    public Result logDeviceList(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<DeviceIot> deviceIotList = new ArrayList<>();

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
            } else {
                return redirect(routes.DashboardController.dashboard());
            }
        }

        return ok(views.html.report.log.LogDevice.render(userSession, deviceIotList));
    }

    public Result getAllLogMessage() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String deviceId = jsonGroup.get("deviceId").asText();

        if (StringUtils.isEmpty(deviceId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        String urlGetMessage = appfileConfig.ulrBackendIot + "/api/messages?deviceId=" + deviceId + "&offset=0&limit=50";
        logger.debug("urlGetMessage :{}", urlGetMessage);
        String token = "Bearer " + userSession.getToken();
        String deviceToken = userSession.getDeviceToken();

        ApiResult apiGetListMessage = apiService.getByUserTokenAndDeviceToken(urlGetMessage, token, deviceToken);
        try {
            if(apiGetListMessage.getJsonData() != null){
                if(apiGetListMessage.getJsonData().get("messages") != null){
                    respone.setContent(apiGetListMessage.getJsonData().get("messages"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(apiGetListMessage.getResultStatus() >= 200 && apiGetListMessage.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
        }
        return ok(Json.toJson(respone));
    }
}
