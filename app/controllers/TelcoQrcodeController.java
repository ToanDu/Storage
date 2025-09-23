package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.data.Form;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.form.AccountTelcoForm;
import vn.m2m.iot.form.FileForm;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TelcoQrcodeController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result qrcodeList() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.role.qrcode.QrcodeList.render(userSession));
    }

    public Result getListQrcodeCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String serial = (jsonGroup.get("serial") != null) ? jsonGroup.get("serial").asText() :"";
        String status = (jsonGroup.get("status") != null) ? jsonGroup.get("status").asText() :"";
        String createdFrom = (jsonGroup.get("createdFrom") != null) ? jsonGroup.get("createdFrom").asText() :"";
        String createdTo = (jsonGroup.get("status") != null) ? jsonGroup.get("createdTo").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("serial", serial);
        param.put("status", status);
        if(!StringUtils.isEmpty(createdFrom)){
            param.put("createdFrom", createdFrom);
        }
        if(!StringUtils.isEmpty(createdTo)){
            param.put("createdTo", createdTo);
        }

        param.put("offset", String.valueOf(startAt));
        param.put("limit", String.valueOf(pageSize));
        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/provisioning/qr";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("url : {}", url);
//        logger.info("getListAccountCmp : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListQrcodeCmp");
        telcoLog.setContent("Lay danh sach QRcode dau noi");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListGpkd() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String user_id = userSession.getId();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/" + user_id + "/enterprise?offset=0&limit=10000&status=APPROVED";
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("url : {}", url);
        logger.info("getListGpkd : {}", apiResult.getJsonData());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result checkValidateSerialAdm1() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String serial = (jsonGroup.get("serial") != null) ? jsonGroup.get("serial").asText() :"";
        String adm1 = (jsonGroup.get("adm1") != null) ? jsonGroup.get("adm1").asText() :"";
        String staffCode = (jsonGroup.get("staffCode") != null) ? jsonGroup.get("staffCode").asText() :"";
        logger.info("serial : {} - adm1 :{} ", serial, adm1);

        Map<String, String> param = new HashMap<>();
        param.put("serial", serial);
        param.put("adm1", adm1);
        param.put("staffCode", staffCode);
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/validateSerialSim";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("checkValidateSerialAdm1 : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("checkValidateSerialAdm1");
        telcoLog.setContent("Validate serial sim + adm1 - " + serial);
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result saveFileChungTu() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        String token = "Bearer " + userSession.getToken();
        logger.info("token :{}", token);
        Form<FileForm> formRequest = formFactory.form(FileForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        FileForm fileForm = formRequest.get();
        logger.info("fileForm :{}", Json.toJson(fileForm));

        Http.MultipartFormData.FilePart filePart = fileForm.getFilePart();

        String url_upImg = appfileConfig.urlBackendIotTelco + "/api/miniovt/file/upload";
//        String url_upImg = "http://116.101.122.190:80/api/miniovt/file/upload";
        logger.info("url_upImg :{}", url_upImg);
        if(filePart != null) {
            File file = (File) filePart.getFile();
            String nameFile = filePart.getFilename().replaceAll(" ", "");
            ApiResult sendFile = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameFile, file);
            logger.info("sendFile :{}", Json.toJson(sendFile));
            if(sendFile.getJsonData() != null && sendFile.getJsonData().get("link") != null){
                String link = sendFile.getJsonData().get("link").asText();

                respone.setContent(link);
                return ok(Json.toJson(respone));
            } else {
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("Lưu file không thành công"));
                return ok(Json.toJson(respone));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy file"));
            return ok(Json.toJson(respone));
        }
    }

    public Result createQrcode() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/provisioning/qr";
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("createQrcode : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("createQrcode");
        telcoLog.setContent("Create Qrcode");
        telcoLog.setUrl(url);
//        telcoLog.setParam(String.valueOf(param));
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result qrCodeConnect(String id){
        return ok(views.html.telco.role.qrcode.QrcodeConnect.render(id));
    }

    public Result getInfoConnectSubs() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String idLink = jsonGroup.get("idLink").asText();
        String code = jsonGroup.get("code").asText();

        Map<String, Object> data = new HashMap<>();
        data.put("verificationCode", code);
        data.put("viewConnectRequest", false);

        String url = appfileConfig.urlBackendIotTelco + "/api/telco/provisioning/qr/"+idLink+"/view";
        logger.info("url : {}", url);
        logger.info("data : {}", Json.toJson(data));

        ApiResult apiResult = apiService.sendPostJsonWithoutToken(url, Json.toJson(data));
        logger.info("getInfoConnectSubs : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result paymentConnectSubs() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String idLink = jsonGroup.get("idLink").asText();
        String code = jsonGroup.get("code").asText();

        Map<String, Object> data = new HashMap<>();
        data.put("verificationCode", code);

        String url = appfileConfig.urlBackendIotTelco + "/api/telco/provisioning/qr/"+idLink+"/connect";
        logger.info("url : {}", url);
        logger.info("data : {}", Json.toJson(data));

        ApiResult apiResult = apiService.sendPostJsonWithoutToken(url, Json.toJson(data));
        logger.info("paymentConnectSubs : {}", Json.toJson(apiResult));
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

    public Result delQrcodeById() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/provisioning/qr/"+id;
        logger.info("url : {}", url);

        ApiResult apiResult = apiService.deleteByToken(url, token);
        logger.info("delQrcodeById : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }

        return ok(Json.toJson(respone));
    }
}
