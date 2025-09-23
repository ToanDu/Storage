package controllers;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
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
import com.google.common.base.Strings;
import vn.m2m.utils.ObjectUtil;
import java.util.regex.*;

import javax.inject.Inject;
import java.util.*;

@Security.Authenticated(Secured.class)
public class MessagesDeviceController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result messagesDevice(String deviceId){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        String urlGetDeviceToken = appfileConfig.ulrBackendIot + "/api/devicetokens";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetDeviceToken = apiService.getByToken(urlGetDeviceToken, token);
        logger.info("apiGetDeviceToken:{}", Json.toJson(apiGetDeviceToken));

        try {
            if(apiGetDeviceToken.isSuccess() && apiGetDeviceToken.getResultStatus() == 200) {
                if(apiGetDeviceToken.getJsonData() != null){
                    JSONObject obj = new JSONObject(apiGetDeviceToken.getJsonData().toString());
                    if(obj.getJSONArray("devicetokens") != null){
                        JSONArray arr = obj.getJSONArray("devicetokens");
                        if(arr.length() > 0){
                            JsonNode jsonOneDevice = ObjectUtil.jsonStrToJsonNode(arr.get(0).toString());

                            if(jsonOneDevice.get("devicetoken") != null){
                                logger.info("device token :{}", jsonOneDevice.get("devicetoken").asText());
                                userSession.setDeviceToken(jsonOneDevice.get("devicetoken").asText());
                                userDAO.save(userSession);
                            }
                        } else {
                            flash("failed",getMessages().at("noti.notDeviceToken"));
                        }
                    }
                }
            } else {
                if(apiGetDeviceToken.getResultStatus() == 401){
                    return redirect(routes.Application.logout());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok(views.html.iot.message.MessagesDevice.render(userSession, deviceId));
    }

    public Result getMetadata(){
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

        String urlGetDevice = appfileConfig.ulrBackendIot + "/api/devices/" + deviceId;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetMetadata = apiService.sendApiWithParam(urlGetDevice, token);
        logger.info("get metadata:{}", Json.toJson(apiGetMetadata));

        if(apiGetMetadata.getResultStatus() == 200){
            if(apiGetMetadata.getJsonData() != null){
                if(apiGetMetadata.getJsonData().get("metadata") != null){
                    respone.setContent(apiGetMetadata.getJsonData().get("metadata"));
                }
            }

        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result sendMetadata() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String content = jsonGroup.get("content").asText();
        String deviceId = jsonGroup.get("deviceId").asText();
        logger.info("content :{}", content);

        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        String urlPutMetadata = appfileConfig.ulrBackendIot + "/api/devices/" + deviceId;
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("metadata", ObjectUtil.jsonStrToJsonNode(content));
        logger.info("bodyData:{}", Json.toJson(bodyData));

        ApiResult apiPutMetadata = apiService.putJson(urlPutMetadata, Json.toJson(bodyData), token);
        logger.info("Put metadata:{}", Json.toJson(apiPutMetadata));

        if(apiPutMetadata.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.Sendsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.SendFalse"));
        }
        return ok(Json.toJson(respone));
    }

    //message
    public Result sendMessageToDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String content = jsonGroup.get("content").asText();
        String deviceId = jsonGroup.get("deviceId").asText();
        String type = jsonGroup.get("type").asText();

        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        String urlSendMessage = appfileConfig.ulrBackendIot + "/api/messages/" + deviceId + "/" + type;
        String deviceToken = userSession.getDeviceToken();
        logger.debug("device token :{}", deviceToken);
        String userToken = "Bearer " + userSession.getToken();
        ApiResult apiSendMessage = apiService.sendMessage(urlSendMessage, content, deviceToken, userToken);
        logger.info("Send Message:{}", Json.toJson(apiSendMessage));

        if(apiSendMessage.getResultStatus() == 202){
            respone.setResultString(getMessages().at("noti.Sendsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.SendFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getMessageFormDevice() {
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
        String param = jsonGroup.get("param").asText();

        if (StringUtils.isEmpty(param)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        String urlGetMessage = appfileConfig.ulrBackendIot + "/api/messages/" + param + "?limit=100&offset=0&deviceId=" + deviceId;
        String deviceToken = userSession.getDeviceToken();
        logger.debug("device token :{}", deviceToken);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetListMessage = apiService.getListMessageOfDevice(urlGetMessage, token, deviceToken);
        logger.info("get list message:{}", Json.toJson(apiGetListMessage));

        try {
            if(apiGetListMessage.getJsonData() != null){
                if(apiGetListMessage.getJsonData().get("messages") != null){
                    respone.setContent(apiGetListMessage.getJsonData().get("messages"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(apiGetListMessage.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result postCreateDeviceToken(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String urlCreateDeviceToken = appfileConfig.ulrBackendIot + "/api/devicetokens";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiCreateDeviceToken = apiService.sendPost(urlCreateDeviceToken, token);
        logger.info("apiCreateDeviceToken:{}", Json.toJson(apiCreateDeviceToken));

        if(apiCreateDeviceToken.getResultStatus() >= 200 && apiCreateDeviceToken.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    //send mess to device
    public Result sendMessageData() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String content = jsonGroup.get("content").asText();
        String deviceId = jsonGroup.get("deviceId").asText();

        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        String urlSendMessage = appfileConfig.ulrBackendIot + "/api/commands/" + deviceId + "/device/controls";
        String deviceToken = userSession.getDeviceToken();
        logger.debug("device token :{}", deviceToken);
        String userToken = "Bearer " + userSession.getToken();
        ApiResult apiSendMessage = apiService.sendMessage(urlSendMessage, content, deviceToken, userToken);
        logger.info("Send Message:{}", Json.toJson(apiSendMessage));

        if(apiSendMessage.getResultStatus() == 202){
            respone.setResultString(getMessages().at("noti.Sendsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.SendFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result sendMessageOnOff() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

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
        String deviceToken = userSession.getDeviceToken();
        String userToken = "Bearer " + userSession.getToken();

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

    public Result sendCommandRPC() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String command = jsonGroup.get("command").asText();
        logger.info("command :{}", command);
        String deviceId = jsonGroup.get("deviceId").asText();

        if (StringUtils.isEmpty(command)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        if (StringUtils.isEmpty(deviceId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Chưa có thiết bị để gửi"));
            return ok(Json.toJson(respone));
        }

        String[] stringList = command.split(" ");
        if(stringList.length < 2){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Cú pháp lệnh chưa đúng"));
            return ok(Json.toJson(respone));
        }

        String method = stringList[0];
        String param = stringList[1];

        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("device_id", deviceId);
        bodyData.put("device_token", userSession.getDeviceToken());
        bodyData.put("protocol", "tcp");
        bodyData.put("method", method);
        bodyData.put("params", ObjectUtil.jsonStrToJsonNode(param));
        bodyData.put("timeout", 5000);
        bodyData.put("retries", 5);
        bodyData.put("qos", 0);
        bodyData.put("retain", false);
        bodyData.put("persistent", true);
        bodyData.put("pub_topic", "data");
        bodyData.put("sub_topic", "resdata");
        logger.info("bodyData :{}", Json.toJson(bodyData));

        String url = appfileConfig.ulrBackendSendCommandRPC;
        logger.info("url :{}", url);
        String userToken = "Bearer " + userSession.getToken();
        ApiResult apiSendRPC = apiService.sendPostJson(url, Json.toJson(bodyData), userToken);
        logger.info("sendCommandRPC :{}", apiSendRPC.getJsonData());
        respone.setStatus(apiSendRPC.getResultStatus());
        respone.setContent(apiSendRPC.getJsonData());
        if(apiSendRPC.getResultStatus() >= 200 && apiSendRPC.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Sendsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.SendFalse"));
        }
        return ok(Json.toJson(respone));
    }
}
