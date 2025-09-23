package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import vn.m2m.common.models.User;
import vn.m2m.config.AppfileConfig;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.form.DevicePositionInitMarker;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.service.DeviceConvertModalUtil;
import vn.m2m.models.ApiResult;
import vn.m2m.models.Group;
import vn.m2m.models.GroupDAO;
import vn.m2m.service.ApiService;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.*;

public class SocketService extends AbstractService {
    @Inject
    public DeviceIotDAO deviceIotDAO;
    @Inject
    public DeviceConvertModalUtil deviceConvertModalUtil;
    @Inject
    public AppfileConfig appfileConfig;
    @Inject
    public ApiService apiService;

    public JsonNode returnDataListDeviceIot(String userId) {
        logger.info("socket for user id :{}", userId);
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userCurrent = userDAO.getByKey(userId);
        if(userCurrent == null){
            respone.setIssuccess(false);
            respone.setResultString("User Null!");
            return Json.toJson(respone);
        }

        Map<String, Object> dataSocket = new HashMap<String, Object>();

        //get list device (list device + value of variable)
        int totalDevice = 0;
        try {
            String url = appfileConfig.ulrBackendIot + "/api/devices";
            String token = "Bearer " + userCurrent.getToken();
            ApiResult apiGetDeviceList = apiService.getByToken(url, token);

            if(apiGetDeviceList.getResultStatus() >= 200 && apiGetDeviceList.getResultStatus() <= 299) {
                totalDevice = (apiGetDeviceList.getJsonData().get("total") != null) ? apiGetDeviceList.getJsonData().get("total").asInt() : 0;

                JsonNode jsonBody = apiGetDeviceList.getJsonData();
                dataSocket.put("listDevice", jsonBody);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dataSocket.put("totalDevice", totalDevice);

        //get total message
        int totalMessage = 0;

        return Json.toJson(dataSocket);
    }
}
