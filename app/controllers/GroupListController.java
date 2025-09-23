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
import vn.m2m.models.ApiResult;
import vn.m2m.models.Group;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class GroupListController extends AbstractController{
    @Inject
    public ApiService apiService;

    public Result groupsList() {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<Group> groupList = new ArrayList<Group>();

        String url = appfileConfig.ulrBackendIot + "/api/groups";
        String token = "Bearer "+userSession.getToken();
        ApiResult apiGetGroupList = apiService.getByToken(url, token);

        if(apiGetGroupList.isSuccess() && apiGetGroupList.getResultStatus() == 200) {
            JsonNode jsonBody = apiGetGroupList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("groups");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode group = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (group.get("id") != null) {
                        Group groupGet = new Group();
                        groupGet.setId(group.get("id").asText());
                        groupGet.setName((group.get("name") != null) ? group.get("name").asText() : "");
                        groupGet.setOrgId((group.get("organization") != null) ? group.get("organization").asText() : "");

                        groupList.add(groupGet);
                    }

                }
            }
        } else {
            if(apiGetGroupList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            } else {
                return redirect(routes.DashboardController.dashboard());
            }
        }

        return ok(views.html.groupList.GroupsList.render(userSession, groupList));
    }

    public Result addNewGroups() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = (jsonGroup.get("name") != null) ? jsonGroup.get("name").asText() :"";
        String orgId = (jsonGroup.get("orgId") != null) ? jsonGroup.get("orgId").asText() : "";
        String entity = (jsonGroup.get("orgId") != null) ? jsonGroup.get("entity").asText() :"";
        String projectId = jsonGroup.get("projectId").asText();

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        String urlCreateGroup = appfileConfig.ulrBackendIot + "/api/groups";
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("project_id", projectId);
        bodyData.put("org_id", orgId);
        bodyData.put("entity_type", entity);
        bodyData.put("metadata", Json.toJson(new HashMap<>()));
        logger.debug("create data group :{}", Json.toJson(bodyData));

        ApiResult apiCreateGroup = apiService.sendPostJson(urlCreateGroup, Json.toJson(bodyData), token);
        logger.info("Create Group:{}", Json.toJson(apiCreateGroup));
        respone.setStatus(apiCreateGroup.getResultStatus());
        if(apiCreateGroup.getResultStatus() >= 200 && apiCreateGroup.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deleteGroup() {
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
            respone.setErrorString(getMessages().at("group.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String urlCreateGroup = appfileConfig.ulrBackendIot + "/api/groups/" + id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDeleteGroup = apiService.deleteByToken(urlCreateGroup, token);
        logger.info("Delete Group:{}", Json.toJson(apiDeleteGroup));
        respone.setStatus(apiDeleteGroup.getResultStatus());
        if(apiDeleteGroup.getResultStatus() >= 200 && apiDeleteGroup.getResultStatus() <= 299 ){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse") + " - "
                    + ((apiDeleteGroup.getJsonData().get("error") != null) ? apiDeleteGroup.getJsonData().get("error").asText() : ""));
        }
        return ok(Json.toJson(respone));
    }

    public Result editNameGroups() {
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
        String id = jsonGroup.get("id").asText();
        String orgId = jsonGroup.get("orgId").asText();

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        String urlEditNameGroup = appfileConfig.ulrBackendIot + "/api/groups/"+id;
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("name", name);
        bodyData.put("org_id", orgId);
        bodyData.put("metadata", Json.toJson(new HashMap<>()));
        logger.debug("edit data group :{}", Json.toJson(bodyData));

        ApiResult apiEditNameGroup = apiService.putJson(urlEditNameGroup, Json.toJson(bodyData), token);
        logger.info("Edit Name Group:{}", Json.toJson(apiEditNameGroup));
        respone.setStatus(apiEditNameGroup.getResultStatus());
        if(apiEditNameGroup.getResultStatus() >= 200 && apiEditNameGroup.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result updateOrgIdForGroups() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText().trim();
        String idOrg = jsonGroup.get("idOrg").asText().trim();

        if (StringUtils.isEmpty(idOrg)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("group.chooseOrg"));
            return ok(Json.toJson(respone));
        }

        String urlUpdateOrgForGroup = appfileConfig.ulrBackendIot + "/api/groups/" + id + "/organization/" + idOrg;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
//        bodyData.put("name", name);
        ApiResult apiUpdateOrgForGroup = apiService.sendPostJson(urlUpdateOrgForGroup, Json.toJson(bodyData), token);
        logger.info("Edit Name Group:{}", Json.toJson(apiUpdateOrgForGroup));
        respone.setStatus(apiUpdateOrgForGroup.getResultStatus());
        if(apiUpdateOrgForGroup.getResultStatus() >= 200 && apiUpdateOrgForGroup.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getListGroups() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        List<Group> groupList = new ArrayList<Group>();

        String url = appfileConfig.ulrBackendIot + "/api/groups";
        String token = "Bearer "+userSession.getToken();

        ApiResult apiGetOrgList = apiService.getByToken(url, token);
        respone.setStatus(apiGetOrgList.getResultStatus());
        if(apiGetOrgList.getResultStatus() >= 200 && apiGetOrgList.getResultStatus() <= 299){
            JsonNode jsonBody = apiGetOrgList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("groups");
            if(arr.length() > 0){
                for(int i=0; i<arr.length(); i++){
                    Group group = new Group();
                    JsonNode jsonOneGroup = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());
                    String id = (jsonOneGroup.get("id") != null) ? jsonOneGroup.get("id").asText() : "";
                    if(!StringUtils.isEmpty(id)){
                        group.setId(id);
                        group.setName(jsonOneGroup.get("name").asText());
                        String[] path={id};
                        group.setPath(path);

                        groupList.add(group);
                    }
                }
            }

            respone.setContent(groupList);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result getGroupWithEntityType() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();
//        String entityType = "ORGANIZATION";

        String url = appfileConfig.ulrBackendIot + "/api/groups";
        String token = "Bearer "+userSession.getToken();

        Map<String, Object> data = new HashMap<>();

        Map<String, String> paramOrg = new HashMap<>();
        paramOrg.put("org_id", orgId);
        paramOrg.put("project_id", projectId);
        paramOrg.put("entity_type", "ORGANIZATION");
        ApiResult apiResultOrg = apiService.getWithParams(url, token, paramOrg);
        if(apiResultOrg.getResultStatus() >= 200 && apiResultOrg.getResultStatus() <= 299){
            data.put("ORGANIZATION", apiResultOrg.getJsonData());
        } else {
            data.put("ORGANIZATION", "");
        }

        Map<String, String> paramDevice = new HashMap<>();
        paramDevice.put("org_id", orgId);
        paramDevice.put("project_id", projectId);
        paramDevice.put("entity_type", "DEVICE");
        ApiResult apiResultDevice = apiService.getWithParams(url, token, paramDevice);
        if(apiResultDevice.getResultStatus() >= 200 && apiResultDevice.getResultStatus() <= 299){
            data.put("DEVICE", apiResultDevice.getJsonData());
        } else {
            data.put("DEVICE", "");
        }

        Map<String, String> paramUser = new HashMap<>();
        paramUser.put("org_id", orgId);
        paramUser.put("project_id", projectId);
        paramUser.put("entity_type", "USER");
        ApiResult apiResultUser = apiService.getWithParams(url, token, paramUser);
        if(apiResultUser.getResultStatus() >= 200 && apiResultUser.getResultStatus() <= 299){
            data.put("USER", apiResultUser.getJsonData());
        } else {
            data.put("USER", "");
        }

        Map<String, String> paramEvent = new HashMap<>();
        paramEvent.put("org_id", orgId);
        paramEvent.put("project_id", projectId);
        paramEvent.put("entity_type", "EVENT");
        ApiResult apiResultEvent = apiService.getWithParams(url, token, paramEvent);
        if(apiResultEvent.getResultStatus() >= 200 && apiResultEvent.getResultStatus() <= 299){
            data.put("EVENT", apiResultEvent.getJsonData());
        } else {
            data.put("EVENT", "");
        }

        respone.setContent(data);
        return ok(Json.toJson(respone));
    }

    public Result getListGroupOrganization() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("org_id", orgId);
        param.put("project_id", projectId);
        param.put("entity_type", "ORGANIZATION");
        logger.debug("param :{}", Json.toJson(param));

        String urlGetGroup = appfileConfig.ulrBackendIot + "/api/groups";
        ApiResult apiResult = apiService.getWithParams(urlGetGroup, token, param);
        logger.info("Get ds group:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        return ok(Json.toJson(respone));
    }

    public Result getListGroupUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("org_id", orgId);
        param.put("project_id", projectId);
        param.put("entity_type", "USER");
        logger.debug("param :{}", Json.toJson(param));

        String urlGetGroup = appfileConfig.ulrBackendIot + "/api/groups";
        ApiResult apiResult = apiService.getWithParams(urlGetGroup, token, param);
        logger.info("Get ds group:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        return ok(Json.toJson(respone));
    }

    public Result getListGroupDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("org_id", orgId);
        param.put("project_id", projectId);
        param.put("entity_type", "DEVICE");
        logger.debug("param :{}", Json.toJson(param));

        String urlGetGroup = appfileConfig.ulrBackendIot + "/api/groups";
        ApiResult apiResult = apiService.getWithParams(urlGetGroup, token, param);
        logger.info("Get ds group:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        return ok(Json.toJson(respone));
    }

    public Result getListGroupEvent() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();

        JsonNode jsonGroup = request().body().asJson();
        String orgId = jsonGroup.get("orgId").asText();
        String projectId = jsonGroup.get("projectId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("org_id", orgId);
        param.put("project_id", projectId);
        param.put("entity_type", "EVENT");
        logger.debug("param :{}", Json.toJson(param));

        String urlGetGroup = appfileConfig.ulrBackendIot + "/api/groups";
        ApiResult apiResult = apiService.getWithParams(urlGetGroup, token, param);
        logger.info("Get ds group:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
        }

        return ok(Json.toJson(respone));
    }
}
