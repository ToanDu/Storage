package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import models.forms.UserForm;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.data.Form;
import play.filters.csrf.AddCSRFToken;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.form.OrgForm;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.models.ApiResult;
import vn.m2m.models.Group;
import vn.m2m.models.GroupDAO;
import vn.m2m.models.GroupForm;
import vn.m2m.service.ApiService;
import vn.m2m.utils.*;

import javax.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Security.Authenticated(Secured.class)
public class GroupController extends AbstractController {
    @Inject
    public DeviceIotDAO deviceIotDAO;
    @Inject
    public GroupDAO groupDAO;
    @Inject
    public ApiService apiService;

    public Result orgList(String projectId) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.group.GroupList.render(userSession, projectId));
    }

    public Result getInfoOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String orgId = (jsonGroup.get("orgId") != null) ? jsonGroup.get("orgId").asText() :"";

        String url = appfileConfig.ulrBackendIot + "/api/organizations/" + orgId;
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));

        }

        return ok(Json.toJson(respone));
    }

    public Result getAttributeOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String orgId = (jsonGroup.get("orgId") != null) ? jsonGroup.get("orgId").asText() :"";

        String url = appfileConfig.ulrBackendIot + "/api/attributes/ORGANIZATION/" + orgId + "/values?limit=100&offset=0";
        logger.debug("url :{}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));

        }

        return ok(Json.toJson(respone));
    }

    public Result getGroupChildByGroupId() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();
        String id = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() :"";

        String token = "Bearer " + userSession.getToken();

        //get org
        String urlGetOrg = appfileConfig.ulrBackendIot + "/api/organizations/"+id;
        ApiResult apiGetGroup = apiService.getByToken(urlGetOrg, token);
        logger.info("Get thong tin Org:{}", Json.toJson(apiGetGroup));

        //TODO: return data
        Map<String, Object> dataResponses = new HashMap<>();

        if(apiGetGroup.getResultStatus() > 0){
            Group groupCurrent = new Group();
            groupCurrent.setId((apiGetGroup.getJsonData().get("id") != null) ? apiGetGroup.getJsonData().get("id").asText() : "");
            groupCurrent.setName((apiGetGroup.getJsonData().get("name") != null) ? apiGetGroup.getJsonData().get("name").asText() : "");
            String[] path={groupCurrent.getId()};
            groupCurrent.setPath(path);

            dataResponses.put("group", groupCurrent);

            logger.debug("dataResponses :{}", Json.toJson(dataResponses));
            respone.setContent(dataResponses);
            respone.setResultString(getMessages().at("noti.Getsuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }

    }

    //get list group of org
    public Result getListGroupOfOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() :"";
        String id = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() :"";

        Map<String, Object> dataResponses = new HashMap<>();

        //param
        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String urlGetGroup = appfileConfig.ulrBackendIot + "/api/groups";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetGroupList = apiService.getWithParams(urlGetGroup, token, param);
        logger.info("Get ds group:{}", Json.toJson(apiGetGroupList));

        if(apiGetGroupList.getResultStatus() >= 200 && apiGetGroupList.getResultStatus() <= 299){
            dataResponses.put("groupList", apiGetGroupList.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            dataResponses.put("groupList", "");
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.Getfalse"));
        }

        respone.setContent(dataResponses);
        return ok(Json.toJson(respone));
    }

    //get list user of org
    public Result getListUserOfOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() :"";
        String id = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() :"";

        Map<String, Object> dataResponses = new HashMap<>();

        //param
        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String urlGetUser = appfileConfig.ulrBackendIot + "/api/users";
        ApiResult apiGetUserList = apiService.getWithParams(urlGetUser, token, param);
        logger.info("Get ds user:{}", Json.toJson(apiGetUserList));

        if(apiGetUserList.getResultStatus() >= 200 && apiGetUserList.getResultStatus() <= 299){
            dataResponses.put("listGroupUsers", apiGetUserList.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            dataResponses.put("listGroupUsers", "");
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        respone.setContent(dataResponses);
        return ok(Json.toJson(respone));
    }

    //get list device of org
    public Result getListDeviceOfOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() :"";
        String id = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 0;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 15;
        int offset = (page-1)*pageSize;
        logger.info("offset :{} - limit :{}", offset, pageSize);

        //param
        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/devices?get_attributes=false" + "&offset=" + offset + "&limit=" + pageSize;
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        logger.info("Get ds Device:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }

    //get list event of org
    public Result getListEventOfOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() :"";
        String id = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() :"";

        Map<String, Object> dataResponses = new HashMap<>();

        //param
        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/events";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("Get ds event:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            dataResponses.put("eventList", apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            dataResponses.put("eventList", "");
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        respone.setContent(dataResponses);
        return ok(Json.toJson(respone));
    }
    //get list role of org
    public Result getListRoleOfOrg() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() :"";
        String id = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() :"";

        Map<String, Object> dataResponses = new HashMap<>();

        //param
        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);
        param.put("org_id", id);
        logger.debug("param :{}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/roles";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("Get ds role:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            dataResponses.put("roleList", apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            dataResponses.put("roleList", "");
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        respone.setContent(dataResponses);
        return ok(Json.toJson(respone));
    }



    //TODO organization
    public Result addGroupRoot() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Form<OrgForm> formRequest = formFactory.form(OrgForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        OrgForm orgForm = formRequest.get();
        String name = orgForm.getName();
        String description = orgForm.getDescription();
        String projectId = orgForm.getProjectId();
        String orgId = orgForm.getOrgId();
        String groupId = orgForm.getGroupId();

        Http.MultipartFormData.FilePart fileData = orgForm.getFileData();
        String imageName = "";
        if(fileData != null){
            String fileName = orgForm.getFileName();
            File file = (File) fileData.getFile();
            orgForm.setFileClientPath(file.getPath());
            imageName = UserHelper.generateUniqueFilename(fileName);
            logger.info("imageName :{}", imageName);

            try {
                ImageUtil.writeAvatarToDisk(imageName, appfileConfig.contentFolderImage, file);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        String urlCreateOrg = appfileConfig.ulrBackendIot + "/api/organizations";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("project_id", projectId);
        bodyData.put("org_id", orgId);
        bodyData.put("group_id", groupId);
        bodyData.put("name", name);
        bodyData.put("description", description);
        bodyData.put("image", imageName);
        logger.debug("bodyData :{}", Json.toJson(bodyData));
        ApiResult apiCreateOrg = apiService.sendPostJson(urlCreateOrg, Json.toJson(bodyData), token);
        logger.info("Create Org:{}", Json.toJson(apiCreateOrg));

        if(apiCreateOrg.getResultStatus() >= 200 && apiCreateOrg.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        respone.setStatus(apiCreateOrg.getResultStatus());
        respone.setContent(apiCreateOrg.getJsonData());
        return ok(Json.toJson(respone));
    }

    public Result updateGroup() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Form<OrgForm> formRequest = formFactory.form(OrgForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        OrgForm orgForm = formRequest.get();
        logger.debug("orgForm :{}", Json.toJson(orgForm));
        String org_id = orgForm.getId();
        String name = orgForm.getName();
        String description = orgForm.getDescription();

        Boolean isChangeImg = orgForm.getChangeImg();
        String imgOld = orgForm.getImgOld();

        Http.MultipartFormData.FilePart fileData = orgForm.getFileData();
        String imageName = imgOld;
        if(isChangeImg){
            if(fileData != null){
                String fileName = orgForm.getFileName();
                File file = (File) fileData.getFile();
                orgForm.setFileClientPath(file.getPath());
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

        String urlEditOrg = appfileConfig.ulrBackendIot + "/api/organizations/"+org_id;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("description", description);
        bodyData.put("image", imageName);

        ApiResult apiEditOrg = apiService.sendPutJson(urlEditOrg, Json.toJson(bodyData), token);
        logger.info("Update Org:{}", Json.toJson(apiEditOrg));

        if(apiEditOrg.getResultStatus() >= 200 && apiEditOrg.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        respone.setContent(apiEditOrg.getJsonData());
        respone.setStatus(apiEditOrg.getResultStatus());
        return ok(Json.toJson(respone));
    }

    public Result deleteGroup() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String groupid = jsonGroup.get("id").asText();

        if (StringUtils.isEmpty(groupid)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.form.error"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteOrg = appfileConfig.ulrBackendIot + "/api/organizations/"+groupid;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDeleteOrg = apiService.deleteByToken(urlDeleteOrg, token);
        logger.info("Delete Org:{}", Json.toJson(apiDeleteOrg));

        if(apiDeleteOrg.getResultStatus() >= 200 && apiDeleteOrg.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        respone.setStatus(apiDeleteOrg.getResultStatus());
        return ok(Json.toJson(respone));
    }


    public Result getListOrganizations(String projectId) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/organizations/expand?project_id=" + projectId + "&get_attributes=false";
        logger.info("url : {}", url);
        String token = "Bearer "+userSession.getToken();

        ApiResult apiGetOrgList = apiService.getByToken(url, token);
        if(apiGetOrgList.getResultStatus() >= 200 && apiGetOrgList.getResultStatus() <= 299){
            respone.setContent(apiGetOrgList.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));

        }
        respone.setStatus(apiGetOrgList.getResultStatus());
        return ok(Json.toJson(respone));
    }

    //TODO manage user of org
    public Result createUserInOrg(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = (jsonGroup.get("projectId") != null) ? jsonGroup.get("projectId").asText() : "";
        String orgId = (jsonGroup.get("orgId") != null) ? jsonGroup.get("orgId").asText() : "";
        String groupId = (jsonGroup.get("groupId") != null) ? jsonGroup.get("groupId").asText() : "";
        String roleId = jsonGroup.get("roleId").asText();
        String email = jsonGroup.get("email").asText();
        String password = jsonGroup.get("password").asText();
        String rePassword = jsonGroup.get("rePassword").asText();

        if(StringUtils.isEmpty(email)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.emailNotEmpty"));
            return ok(Json.toJson(respone));
        } else {
            if(!StringUtil.validateEmail(email)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("register.validateEmail"));
                return ok(Json.toJson(respone));
            }
        }

        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(rePassword)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.passNotEmpty"));
            return ok(Json.toJson(respone));
        } else {
//            if(!StringUtil.validateStrongPass(password)){
//                respone.setIssuccess(false);
//                respone.setErrorString(getMessages().at("register.validatePassword"));
//                return ok(Json.toJson(respone));
//            }
        }
        if(!password.equals(rePassword)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.passAgainNotFound"));
            return ok(Json.toJson(respone));
        }

        String urlCreateUser = appfileConfig.ulrBackendIot + "/api/users";
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("email", email);
        bodyData.put("password", password);
        bodyData.put("isAdmin", false);
        bodyData.put("project_id", projectId);
        bodyData.put("org_id", orgId);
        bodyData.put("role_id", roleId);
        bodyData.put("group_id", groupId);
        logger.debug("bodyData : {}", Json.toJson(bodyData));

        ApiResult apiCreateUser = apiService.sendPostJson(urlCreateUser, Json.toJson(bodyData), token);
        logger.info("Create User Child to Org:{}", Json.toJson(apiCreateUser));
        respone.setStatus(apiCreateUser.getResultStatus());
        if(apiCreateUser.getResultStatus() >= 200 && apiCreateUser.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
            return ok(Json.toJson(respone));
        }
    }

    //move user in group
    public Result processMoveUserToGroupOther() {
        User userSession = getUserSession();


        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);



        JsonNode json = request().body().asJson();
        String listUser = json.get("listUser").asText();
        List<String> listId = Arrays.asList(listUser.split("\\s*,\\s*"));
        logger.debug("list id :{}", listId.size());
        String groupIdNew = json.get("groupIdNew").asText();

        Group groupNew = groupDAO.getGroupById(groupIdNew);
        if (groupNew == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("manage.group.groupnotfound"));
            return ok(Json.toJson(respone));
        }

        for(String id: listId){
            User user = userDAO.getByKey(id);
            if(user != null){
                user.setGroupId(groupNew.getId());
                user.setGroupPath(groupNew.getPath());
                userDAO.save(user);
            }
        }

        respone.setResultString(getMessages().at("manage.user.moveSuccess"));
        return ok(Json.toJson(respone));
    }


    //TODO manage device of org
    //move device in group
    public Result processMoveDeviceToGroupOther() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode json = request().body().asJson();
        String orgId = json.get("orgId").asText();
        String deviceId = json.get("deviceId").asText();
        String projectId = json.get("projectId").asText();

        String url = appfileConfig.ulrBackendIot + "/api/devices/organization?project_id="+projectId;
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        List<String> listId = new ArrayList<>();
        listId.add(deviceId);
        bodyData.put("ids", listId);
        bodyData.put("org_id", orgId);
        logger.info("bodyData : {}", Json.toJson(bodyData));
        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(bodyData), token);
        logger.info("processMoveDeviceToGroupOther:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("manage.device.moveSuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
            return ok(Json.toJson(respone));
        }
    }


    //cap nhat vai tro cho group user
    public Result updateRoleToGroupUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode json = request().body().asJson();

        String url = appfileConfig.ulrBackendIot + "/api/users/roles";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, json, token);
        logger.info("updateRoleToGroupUser:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
            return ok(Json.toJson(respone));
        }
    }

    //cap nhat user cho group device
    public Result updateUserToGroupDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode json = request().body().asJson();

        String url = appfileConfig.ulrBackendIot + "/api/devices/assignForUser";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, json, token);
        logger.info("updateUserToGroupDevice:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
            return ok(Json.toJson(respone));
        }
    }

    //cap nhat role cho user
    public Result updateRoleForUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode json = request().body().asJson();
        String user_id = json.get("user_id").asText();
        String role_id = json.get("role_id").asText();

        Map<String, String> body = new HashMap<>();
        body.put("role_id", role_id);

        String url = appfileConfig.ulrBackendIot + "/api/users/"+user_id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.sendPutJson(url, Json.toJson(body), token);
        logger.info("updateRoleForUser:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
            return ok(Json.toJson(respone));
        }
    }
}
