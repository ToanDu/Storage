package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import models.forms.UserForm;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.dao.UserDAO;
import vn.m2m.common.models.Role;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.*;
import vn.m2m.config.AppfileConfig;
import vn.m2m.iot.models.Organization;
import vn.m2m.models.ApiResult;
import vn.m2m.models.Group;
import vn.m2m.service.ApiService;
import vn.m2m.utils.*;

import javax.inject.Inject;
import java.util.*;

import static vn.m2m.utils.SearchUtil.*;

@Security.Authenticated(Secured.class)
public class UserController extends AbstractController {
    @Inject
    public UserDAO userDAO;
    @Inject
    public AppfileConfig appfileConfig;
    @Inject
    public ApiService apiService;

    public Result userList(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<User> userList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/users";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetUserList = apiService.getByToken(url, token);

        if(apiGetUserList.isSuccess() && apiGetUserList.getResultStatus() == 200) {
            JsonNode jsonBody = apiGetUserList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("users");
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    JsonNode device = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if (device.get("userId") != null) {
                        User user = new User();
                        user.setId(device.get("userId").asText());
                        user.setUsername((device.get("email") != null) ? device.get("email").asText() : "");
                        user.setOrgId((device.get("orgId") != null) ? device.get("orgId").asText() : "");
                        user.setOrgName((device.get("orgName") != null) ? device.get("orgName").asText() : "");
                        user.setRoleId((device.get("roleId") != null) ? device.get("roleId").asText() : "");
                        user.setRoleName((device.get("roleName") != null) ? device.get("roleName").asText() : "");

                        userList.add(user);
                    }

                }
            }
        } else {
            if(apiGetUserList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
        }
        List<Role> roleList = initRoles(userSession);

        //thêm organizationList
        List<Organization> organizationList = getOrganizationList(userSession);
        if(organizationList == null){
            return redirect(routes.Application.logout());
        }


        return ok(views.html.user.UserList.render(userSession, userList, roleList, organizationList));
    }

    public List<Role> initRoles(User userSession){
        List<Role> roleList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/roles";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetUserList = apiService.getByToken(url, token);

        if(apiGetUserList.isSuccess() && apiGetUserList.getResultStatus() == 200) {
            JsonNode jsonBody = apiGetUserList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("roles");
            for (int i = 0; i < arr.length(); i++) {
                JsonNode roleNode = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                if (roleNode.get("id") != null) {
                    Role role = new Role();
                    role.setId(roleNode.get("id").asText());
                    role.setName((roleNode.get("role_name") != null) ? roleNode.get("role_name").asText() : "");

                    roleList.add(role);
                }

            }
        }

        return roleList;

    }

    public Result addNewUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String email = jsonGroup.get("email").asText().trim();
        String orgId = jsonGroup.get("orgId").asText();
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
            if(!StringUtil.validateStrongPass(password)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("register.validatePassword"));
                return ok(Json.toJson(respone));
            }
        }
        if(!password.equals(rePassword)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.passAgainNotFound"));
            return ok(Json.toJson(respone));
        }


        if (org.springframework.util.StringUtils.isEmpty(orgId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("manage.deviceIot.chooseOrg"));
            return ok(Json.toJson(respone));
        }

        String urlCreateUser = appfileConfig.ulrBackendIot + "/api/users";
        String token = "Bearer " + userSession.getToken();
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("email", email);
        bodyData.put("password", password);
        bodyData.put("isAdmin", false);


        ApiResult apiCreateUser = apiService.sendPostJson(urlCreateUser, Json.toJson(bodyData), token);
        logger.info("Create User:{}", Json.toJson(apiCreateUser));
        respone.setStatus(apiCreateUser.getResultStatus());
        if(apiCreateUser.getResultStatus() >= 200 && apiCreateUser.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));

            String identity_id = (apiCreateUser.getJsonData() != null) ? apiCreateUser.getJsonData().get("identity_id").asText() : "";
            if(StringUtils.isEmpty(identity_id)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("noti.AddFalse"));
                return ok(Json.toJson(respone));
            } else {
                String urlAddUserToOrg = appfileConfig.ulrBackendIot + "/api/users/"+identity_id;
                Map<String, String> body = new HashMap<>();
                body.put("org_id", orgId);

                ApiResult apiAddUserToOrg = apiService.sendPutJson(urlAddUserToOrg, Json.toJson(body), token);
                logger.info("Add User To Org:{}", Json.toJson(apiAddUserToOrg));
                respone.setStatus(apiAddUserToOrg.getResultStatus());
                if(apiAddUserToOrg.getResultStatus() >= 200 && apiAddUserToOrg.getResultStatus() <= 299){
                    respone.setResultString(getMessages().at("noti.Addsuccess"));
                    return ok(Json.toJson(respone));
                } else {
                    respone.setIssuccess(false);
                    respone.setErrorString(getMessages().at("noti.AddFalse"));
                    return ok(Json.toJson(respone));
                }
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result addRoleForUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String roleId = jsonGroup.get("roleId").asText();

        String userId = jsonGroup.get("userId").asText();

//        if(StringUtils.isEmpty(email)){
//            flash("failed",getMessages().at("register.emailNotEmpty"));
//            return redirect(routes.Application.register());
//        } else {
//            if(!StringUtil.validateEmail(email)){
//                flash("failed",getMessages().at("register.validateEmail"));
//                return redirect(routes.Application.register());
//            }
//        }

        String urlCreateUser = appfileConfig.ulrBackendIot + "/api/roles/"+roleId+"/members/"+userId;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        ApiResult apiAddRole = apiService.sendPost(urlCreateUser, token);
        logger.info("Add role for user:{}", Json.toJson(apiAddRole));
        respone.setStatus(apiAddRole.getResultStatus());
        if(apiAddRole.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getTokenSendPassUser(){
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

        if(StringUtils.isEmpty(id)){
            flash("failed",getMessages().at("user.idEmpty"));
            return redirect(routes.Application.register());
        }

        String urlGetTokenPass = appfileConfig.ulrBackendIot + "/api/users/"+id+"/invite";
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetTokenSendPassUser = apiService.sendPost(urlGetTokenPass, token);
        logger.info("Get Link User:{}", Json.toJson(apiGetTokenSendPassUser));
        respone.setStatus(apiGetTokenSendPassUser.getResultStatus());
        if(apiGetTokenSendPassUser.getResultStatus() >= 200 && apiGetTokenSendPassUser.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            respone.setContent(apiGetTokenSendPassUser.getJsonData());

            JsonNode jsonBody = apiGetTokenSendPassUser.getJsonData();
            String inviteLink = jsonBody.get("invite_link").asText();
            String flowParam = inviteLink.split("\\?")[1].replaceAll(".*flow=([^&]+).*", "$1");
            String tokenParam = inviteLink.split("\\?")[1].replaceAll(".*token=([^&]+).*", "$1");

        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result editUser(){
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
        String email = jsonGroup.get("email").asText();

        if(StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

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

        String urlEditUser = appfileConfig.ulrBackendIot + "/api/users/"+id;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("email", email);
        ApiResult apiEditUser = apiService.sendPostJson(urlEditUser, Json.toJson(bodyData), token);
        logger.info("Edit User:{}", Json.toJson(apiEditUser));
        respone.setStatus(apiEditUser.getResultStatus());
        if(apiEditUser.getResultStatus() == 201){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deleteUser(){
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

        if(StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteUser = appfileConfig.ulrBackendIot + "/api/users/"+id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDeleteUser = apiService.deleteByToken(urlDeleteUser, token);
        logger.info("Delete User:{}", Json.toJson(apiDeleteUser));
        respone.setStatus(apiDeleteUser.getResultStatus());
        if(apiDeleteUser.getResultStatus() >= 200 && apiDeleteUser.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result updateUserOrg(){
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

        String userId = jsonGroup.get("userId").asText();

        String urlUpdateUserOrg = appfileConfig.ulrBackendIot + "/api/users/"+userId;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("org_id",orgId);

        ApiResult apiUpdateUserOrg = apiService.sendPutJson(urlUpdateUserOrg, Json.toJson(bodyData), token);
        logger.info("Update User Organization:{}", Json.toJson(apiUpdateUserOrg));
        respone.setStatus(apiUpdateUserOrg.getResultStatus());
        if(apiUpdateUserOrg.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.ChangeSuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.ChangeFalse"));
        }
        return ok(Json.toJson(respone));

    }

    private List<Organization> getOrganizationList(User userSession){
        List<Organization> organizationList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/organizations";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetOrganizationList = apiService.getByToken(url, token);

        if(apiGetOrganizationList.isSuccess() && apiGetOrganizationList.getResultStatus() == 200){
            JsonNode jsonBody = apiGetOrganizationList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("organizations");
            if(arr.length() > 0){
                for (int i = 0; i < arr.length(); i++){
                    JsonNode org = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if(org.get("id") != null){
                        Organization organization = new Organization();
                        organization.setId(org.get("id").asText());
                        organization.setName(org.get("name").asText());

                        organizationList.add(organization);
                    }
                }
            }
        }else{
            if(apiGetOrganizationList.getResultStatus() == 401){
                return null;
            }
        }
        return organizationList;
    }
}
