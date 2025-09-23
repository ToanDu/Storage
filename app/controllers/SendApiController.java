package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.data.Form;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.ImageForm;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.io.File;

@Security.Authenticated(Secured.class)
public class SendApiController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result getDataWithParam(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String param = jsonGroup.get("param").asText();

        String token = "Bearer " + userSession.getToken();

        String url = appfileConfig.ulrBackendIot + param;
        logger.info("url :{}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        return ok(Json.toJson(respone));
    }

    public Result portDataWithParam(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String param = jsonGroup.get("param").asText();
        JsonNode body = ObjectUtil.jsonStrToJsonNode(jsonGroup.get("body").toString());
        logger.info("body :{}", body);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + param;
        logger.info("url :{}", url);
        ApiResult apiResult = apiService.sendPostJson(url, body, token);
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        return ok(Json.toJson(respone));
    }

    public Result putDataWithParam(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String param = jsonGroup.get("param").asText();
        JsonNode body = ObjectUtil.jsonStrToJsonNode(jsonGroup.get("body").toString());
        logger.info("body :{}", body);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + param;
        logger.info("url :{}", url);
        ApiResult apiResult = apiService.sendPutJson(url, body, token);
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        return ok(Json.toJson(respone));
    }

    public Result upfileImage() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        String token = "Bearer " + userSession.getToken();

        Form<ImageForm> formRequest = formFactory.form(ImageForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        ImageForm ImageForm = formRequest.get();

        Http.MultipartFormData.FilePart fileImage = ImageForm.getImage();
        String url_upImg = appfileConfig.urlBackendUpfile + "/api/miniovt/file/upload";
//        String url_upImg =  "http://116.101.122.190/api/miniovt/file/upload";
        if(fileImage != null) {
            File file = (File) fileImage.getFile();
            String nameImg = fileImage.getFilename().replaceAll(" ", "");
            ApiResult sendFile = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg, file);
            logger.info("sendFile :{}", Json.toJson(sendFile));
            respone.setContent(sendFile.getJsonData());
        }

        return ok(Json.toJson(respone));
    }

    public Result deleteDataWithParam(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String param = jsonGroup.get("param").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + param;
        logger.info("url :{}", url);
        ApiResult apiResult = apiService.deleteByToken(url, token);
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        return ok(Json.toJson(respone));
    }
}
