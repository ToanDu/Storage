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
import vn.m2m.iot.dao.WidgetDAO;
import vn.m2m.iot.form.ProjectForm;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.iot.models.Widget;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ImageUtil;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * Created by vtk-anhlt166 on 11/19/21.
 */
@Security.Authenticated(Secured.class)
public class ProjectController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public WidgetDAO widgetDAO;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result project(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.project.ProjectList.render(userSession));
    }

    public Result getProject() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String urlGetProject = appfileConfig.ulrBackendIot + "/api/projects";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetProject = apiService.getByToken(urlGetProject, token);
        logger.info("apiGetProject:{}", Json.toJson(apiGetProject));
        respone.setStatus(apiGetProject.getResultStatus());
        if(apiGetProject.getResultStatus() >= 200 && apiGetProject.getResultStatus() <= 299){
            respone.setIssuccess(true);
            respone.setContent(apiGetProject.getJsonData());
        } else {
            respone.setIssuccess(false);
        }
        return ok(Json.toJson(respone));
    }

    public Result createProjectForm() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Form<ProjectForm> formRequest = formFactory.form(ProjectForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        ProjectForm projectForm = formRequest.get();
        logger.info("projectForm :{}", Json.toJson(projectForm));

        String name = projectForm.getName();
        String description = (projectForm.getDescription() != null) ? projectForm.getDescription() : "";
        String tagId = projectForm.getTagId();
        logger.info("tagId :{}", tagId);

        Http.MultipartFormData.FilePart fileData = projectForm.getFileData();
        String imageName = "";
        if(fileData != null){
            String fileName = projectForm.getFileName();
            File file = (File) fileData.getFile();
            projectForm.setFileClientPath(file.getPath());
            imageName = UserHelper.generateUniqueFilename(fileName);
            logger.info("imageName :{}", imageName);

            try {
                ImageUtil.writeAvatarToDisk(imageName, appfileConfig.contentFolderImage, file);

//                java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg = CompletableFuture.supplyAsync(
//                        () -> ImageUtil.delImage(fileName, appfileConfig.contentFolderImage));
//                logger.debug("promiseOfDelImg = {}", promiseOfDelImg);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        String urlCreateProject = appfileConfig.ulrBackendIot + "/api/projects";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("description", description);
        bodyData.put("image", imageName);

        ApiResult apiCreateProject = apiService.sendPostJson(urlCreateProject, Json.toJson(bodyData), token);
        logger.info("Create Project:{}", Json.toJson(apiCreateProject));
        respone.setStatus(apiCreateProject.getResultStatus());

        if(apiCreateProject.getResultStatus() >= 200 && apiCreateProject.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));

            String projectId = apiCreateProject.getJsonData().get("id").asText();
            String urlTag = appfileConfig.ulrBackendIot + "/api/projects/"+projectId;
            logger.info("urlTag:{}", urlTag);
            Map<String, Object> bodyTag = new HashMap<>();
            List<String> idTagS = Arrays.asList(tagId.split(","));
            bodyTag.put("tags", idTagS);
            bodyTag.put("remove", false);
            logger.info("bodyTag:{}", Json.toJson(bodyTag));
            ApiResult apiAddTagProject = apiService.sendPutJson(urlTag, Json.toJson(bodyTag), token);
            logger.info("Add tag to Project:{}", Json.toJson(apiAddTagProject));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        respone.setStatus(apiCreateProject.getResultStatus());
        return ok(Json.toJson(respone));
    }

    public Result addProject() {
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
        String description = (jsonGroup.get("description") != null) ? jsonGroup.get("description").asText() : "";

        String urlCreateProject = appfileConfig.ulrBackendIot + "/api/projects";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("description", description);

        ApiResult apiCreateProject = apiService.sendPostJson(urlCreateProject, Json.toJson(bodyData), token);
        logger.info("Create Project:{}", Json.toJson(apiCreateProject));
        respone.setStatus(apiCreateProject.getResultStatus());

        if(apiCreateProject.getResultStatus() >= 200 && apiCreateProject.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        respone.setStatus(apiCreateProject.getResultStatus());
        return ok(Json.toJson(respone));
    }

    public Result editProject() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Form<ProjectForm> formRequest = formFactory.form(ProjectForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        ProjectForm projectForm = formRequest.get();
//        logger.info("projectForm :{}", Json.toJson(projectForm));

        String projectId = projectForm.getId();
        String name = projectForm.getName();
        String description = (projectForm.getDescription() != null) ? projectForm.getDescription() : "";
        String tagId = projectForm.getTagId();
        Boolean isChangeImg = projectForm.getChangeImg();
        String imgOld = projectForm.getImgOld();

        Http.MultipartFormData.FilePart fileData = projectForm.getFileData();
        String imageName = imgOld;
        if(isChangeImg){
            if(fileData != null){
                String fileName = projectForm.getFileName();
                File file = (File) fileData.getFile();
                projectForm.setFileClientPath(file.getPath());
                imageName = UserHelper.generateUniqueFilename(fileName);
                logger.info("imageName :{}", imageName);

                try {
                    ImageUtil.writeAvatarToDisk(imageName, appfileConfig.contentFolderImage, file);

                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld, appfileConfig.contentFolderImage));
                    logger.debug("promiseOfDelImg = {}", promiseOfDelImg);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        String urlEditProject = appfileConfig.ulrBackendIot + "/api/projects/"+projectId;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("description", description);
        bodyData.put("image", imageName);
        logger.debug("bodyData ; {}", Json.toJson(bodyData));
        ApiResult apiEditProject = apiService.sendPutJson(urlEditProject, Json.toJson(bodyData), token);
        logger.info("Edit Project:{}", Json.toJson(apiEditProject));
        respone.setStatus(apiEditProject.getResultStatus());

        if(apiEditProject.getResultStatus() >= 200 && apiEditProject.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));

            String urlTag = appfileConfig.ulrBackendIot + "/api/projects/"+projectId;
            logger.info("urlTag:{}", urlTag);
            Map<String, Object> bodyTag = new HashMap<>();
            List<String> idTagS = Arrays.asList(tagId.split(","));
            bodyTag.put("tags", idTagS);
            bodyTag.put("remove", false);
            logger.info("bodyTag:{}", Json.toJson(bodyTag));
            ApiResult apiAddTagProject = apiService.sendPutJson(urlTag, Json.toJson(bodyTag), token);
            logger.info("Add tag to Project:{}", Json.toJson(apiAddTagProject));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        respone.setStatus(apiEditProject.getResultStatus());
        return ok(Json.toJson(respone));
    }

    public Result delProject() {
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
        logger.debug("projectId: {}", id);

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        String urlEditProject = appfileConfig.ulrBackendIot + "/api/projects/"+id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.deleteByToken(urlEditProject, token);
        logger.info("Del Project:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));

            List<Widget> widgets = widgetDAO.getWidgetList(id, userSession.getUsername());
            if(widgets.size() > 0){
                for(Widget widget: widgets){
                    widgetDAO.deleteByKey(widget.getId());
                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result getNameProject(String projectId) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/projects/" + projectId;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.debug("getNameProject :{}", apiResult.getJsonData());

        String name = "";
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            name = apiResult.getJsonData().get("name").asText();
            respone.setContent(name);
        }

        return ok(Json.toJson(respone));
    }

    //tao giai phap mau
    public Result sendPostJsonProjectTemplate() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String paramUrl = jsonGroup.get("url").asText();

        String jsonBody = jsonGroup.get("json").toString();
        JsonNode jsonData = ObjectUtil.jsonStrToJsonNode(jsonBody);
        logger.info("jsonData :{}", jsonData);

        String url = appfileConfig.ulrBackendIot + paramUrl;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPostJson(url, jsonData, token);
        logger.debug("apiResult :{}", apiResult.getJsonData());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result sendPutJsonProjectTemplate() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String paramUrl = jsonGroup.get("url").asText();

        String jsonBody = jsonGroup.get("json").toString();
        JsonNode jsonData = ObjectUtil.jsonStrToJsonNode(jsonBody);
        logger.info("jsonData :{}", jsonData);

        String url = appfileConfig.ulrBackendIot + paramUrl;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, jsonData, token);
        logger.debug("apiResult :{}", apiResult.getJsonData());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        return ok(Json.toJson(respone));
    }

    public Result createDashboardTemplate() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();

        Widget widget = new Widget();
        widget.setProjectId(projectId);
        widget.setName("Dashboard");
        widget.setUsername(userSession.getUsername());
        widgetDAO.save(widget);

        respone.setContent(widget);
        return ok(Json.toJson(respone));
    }

    //tag
    public Result getListTag() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/projects/tags?limit=100&offset=0";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.debug("getListTag :{}", apiResult.getJsonData());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        }

        return ok(Json.toJson(respone));
    }

    //active phone
    public Result activePhone() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String otp = jsonGroup.get("otp").asText();
        String phone = jsonGroup.get("phone").asText();

//        if(!StringUtils.isEmpty(userSession.getPhone())){
//            phone = userSession.getPhone();
//        }

        Map<String, String> body = new HashMap<>();
        body.put("otp", otp);
        body.put("phone", phone);
        logger.debug("body : {}", Json.toJson(body));

        String url = appfileConfig.ulrBackendIot + "/api/users/cmp/self";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("activePhone:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("Xác thực OTP thành công"));

            userSession.setPhone(jsonGroup.get("phone").asText());
            userDAO.save(userSession);
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Xác thực OTP không thành công"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("activePhone");
        telcoLog.setContent("Xác thực OTP");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
}
