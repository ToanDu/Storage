package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.gson.internal.LinkedHashTreeMap;
import com.google.gson.internal.LinkedTreeMap;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;
import sh.ory.hydra.ApiClient;
import sh.ory.hydra.ApiException;
import sh.ory.hydra.ApiResponse;
import sh.ory.hydra.Configuration;
import sh.ory.hydra.api.AdminApi;
import sh.ory.hydra.model.*;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.ConsentForm;
import vn.m2m.common.models.forms.LoginForm;
import vn.m2m.config.AppfileConfig;
import vn.m2m.iot.models.DeviceVariable;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.*;

//test: http://202.191.56.104:5534/oauth2/auth?client_id=test&prompt=consent&redirect_uri=http://localhost:9000/oauth/callback&response_type=code&scope=users.write+users.read+users.edit&state=121212121212121212dsdsd2121dsd
public class OAuthController extends AbstractController {

    private ApiClient hydraClient = Configuration.getDefaultApiClient();

    @Inject
    public OAuthController(AppfileConfig appfileConfig){
        logger.info("---------------- Hydra Client: " + appfileConfig.urlHydraAdmin);
        hydraClient.setBasePath(appfileConfig.urlHydraAdmin);
        //hydraClient.addDefaultHeader("X-Forwarded-Proto", "https");
    }

    @Inject
    private ApiService apiService;

    public Result getLogin(String loginChallenge) throws ApiException {
        if(Strings.isNullOrEmpty(loginChallenge)){
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("errorTitle", "Login Challenge Is Not Exist");
                    put("errorContent", "Login Challenge Is Not Exist!");
                }
            }));
        }

        AdminApi adminApi = new AdminApi(hydraClient);
        //logger.info("------------ Build Hydra Admin Url : {} ------------", hydraClient.buildUrl("/test", null, null));
        try{
            LoginRequest resLoginRequest = adminApi.getLoginRequest(loginChallenge);

            if(resLoginRequest.getSkip()){
                AcceptLoginRequest body = new AcceptLoginRequest();
                body.setSubject(resLoginRequest.getSubject());
                CompletedRequest resAcceptLogin =  adminApi.acceptLoginRequest(loginChallenge, body);

                return redirect(resAcceptLogin.getRedirectTo());
            }

            String projectID = ObjectUtil.objToJsonNode(resLoginRequest.getClient().getMetadata())
                    .findPath("project_id").asText();
            String appKey = ObjectUtil.objToJsonNode(resLoginRequest.getClient().getMetadata())
                    .findPath("app_key").asText();
            String appSecret = ObjectUtil.objToJsonNode(resLoginRequest.getClient().getMetadata())
                    .findPath("app_secret").asText();

            //return ok(views.html.login.Login.apply());
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("loginChallenge", loginChallenge);
                    put("projectID", projectID);
                    put("appKey", appKey);
                    put("appSecret", appSecret);
                }
            }));
        } catch (Exception e){
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("errorTitle", "Failed When Get Login Request Info");
                    put("errorContent", e.getMessage());
                }
            }));
        }

    }

    public Result postLogin() {
        Form<LoginForm> formRequest = formFactory.form(LoginForm.class);
        if (formRequest.hasErrors()) {
            flash("failed", getMessages().at("form.error"));
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("errorTitle", getMessages().at("form.error"));
                }
            }));
        }
        LoginForm loginForm = formRequest.bindFromRequest().get();
        String username = loginForm.getUsername().trim();
        String password = loginForm.getPassword();
        String projectID = loginForm.getProjectID();
        String appKey = loginForm.getAppKey();
        String appSecret = loginForm.getAppSecret();
        String loginChallenge = loginForm.getLoginChallenge();

        session().put(UserHelper.SessionData.username, username);

        // String urlLogin = appfileConfig.ulrBackendIot + "/api/app/login";
        String urlLogin = appfileConfig.ulrBackendIot + appfileConfig.urlBackendAppLogin;
        logger.info("appLogin: {}", urlLogin);

        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("identifier", username);
        bodyData.put("password", password);
        // bodyData.put("project_id", projectID);

        ApiResult loginGetToken = apiService.sendApiAppWithJson(urlLogin, appKey, appSecret, Json.toJson(bodyData).toString());
        if(loginGetToken.getResultStatus() == 200){
            String token = (loginGetToken.getJsonData().get("token") != null)
                    ? loginGetToken.getJsonData().get("token").asText() : "";
            String userID = (loginGetToken.getJsonData().get("user_id") != null)
                    ? loginGetToken.getJsonData().get("user_id").asText() : "";
            String roleID = (loginGetToken.getJsonData().get("role_id") != null)
                    ? loginGetToken.getJsonData().get("role_id").asText() : "";
            String orgID = (loginGetToken.getJsonData().get("org_id") != null)
                    ? loginGetToken.getJsonData().get("org_id").asText() : "";

            if(StringUtils.isEmpty(token) || StringUtils.isEmpty(userID) || StringUtils.isEmpty(roleID)){
                flash("failed", getMessages().at("login.notFoundUser"));
                return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                    {
                        put("loginChallenge", loginChallenge);
                        put("projectID", projectID);
                        put("appKey", appKey);
                        put("appSecret", appSecret);
                    }
                }));
            }
            else {
                flash("success", getMessages().at("login.loginSuccess"));
                AdminApi adminApi = new AdminApi(hydraClient);

                try{
                    LoginRequest resLoginRequest = adminApi.getLoginRequest(loginChallenge);
                } catch (ApiException e){
                    return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                        {
                            put("errorTitle", "Error Get Login Request");
                            put("errorContent", e.getMessage());
                        }
                    }));
                }

                AcceptLoginRequest body = new AcceptLoginRequest();
                // Context is an optional object which can hold arbitrary data. The data will be made available when fetching the
                // consent request under the "context" field. This is useful in scenarios where login and consent endpoints share
                // data.
                LinkedTreeMap<String, String> ctx = new LinkedTreeMap<String, String>();
                ctx.put("role_id", roleID);
                ctx.put("project_id", projectID);
                ctx.put("user_id", userID);
                ctx.put("org_id", orgID);
                body.setContext(ctx);
                body.setSubject(userID);
                body.setRemember(false);
                //body.setRememberFor(0L); // When the session expires, in seconds. Set this to 0 so it will never expire.
                ApiResponse<CompletedRequest> resAcceptLogin;
                try{
                    resAcceptLogin =  adminApi.acceptLoginRequestWithHttpInfo(loginChallenge, body);
                } catch (ApiException e){
                    // ory hydra bug
                    if(e.getCode() == 409){
                        return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                            {
                                put("loginChallenge", loginChallenge);
                                put("projectID", projectID);
                                put("appKey", appKey);
                                put("appSecret", appSecret);
                            }
                        }));
                    }
                    return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                        {
                            put("errorTitle", "Error Accept Login Request");
                            put("errorContent", e.getMessage());
                        }
                    }));
                }

                return redirect(resAcceptLogin.getData().getRedirectTo());
            }
        } else {
            flash("failed", getMessages().at("login.errorUsernameOrPass"));
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("loginChallenge", loginChallenge);
                    put("projectID", projectID);
                    put("appKey", appKey);
                    put("appSecret", appSecret);
                }
            }));
        }
    }

    public Result getConsent(String consentChallenge) {
        if(Strings.isNullOrEmpty(consentChallenge)){
            return ok(views.html.oauth.Consent.render(new HashMap<String, String>(){
                {
                    put("errorTitle", "Consent Challenge Is Not Exist");
                    put("errorContent", "Consent Challenge Is Not Exist!");
                }
            }, null));
        }

        AdminApi adminApi = new AdminApi(hydraClient);
        ConsentRequest resConsentRequest;
        try{
            resConsentRequest = adminApi.getConsentRequest(consentChallenge);
        }catch (ApiException e){
            return ok(views.html.oauth.Consent.render(new HashMap<String, String>(){
                {
                    put("errorTitle", "Get Consent Request");
                    put("errorContent", e.getMessage());
                }
            }, null));
        }

        if(resConsentRequest.getSkip()){
            AcceptConsentRequest body = new AcceptConsentRequest();
            body.setGrantScope(resConsentRequest.getRequestedScope());
            body.setGrantAccessTokenAudience(resConsentRequest.getRequestedAccessTokenAudience());
            CompletedRequest resAcceptConsent;
            try {
                resAcceptConsent = adminApi.acceptConsentRequest(consentChallenge, body);
            }catch (Exception e){
                return ok(views.html.oauth.Consent.render(new HashMap<String, String>(){
                    {
                        put("errorTitle", "Accept Consent Request");
                        put("errorContent", e.getMessage());
                    }
                }, null));
            }
            return redirect(resAcceptConsent.getRedirectTo());
        }

        return ok(views.html.oauth.Consent.render(new HashMap<String, String>(){
            {
                put("consentChallenge", consentChallenge);
                put("consentMessage", "Cho phép ứng dụng " + resConsentRequest.getClient().getClientName() + " truy cập với quyền: ");
            }
        }, resConsentRequest.getRequestedScope()));
    }

    public Result postConsent(){
        Form<ConsentForm> formRequest = formFactory.form(ConsentForm.class);
        if (formRequest.hasErrors()) {
            flash("failed", getMessages().at("form.error"));
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("errorTitle", getMessages().at("form.error"));
                }
            }));
        }
        ConsentForm loginForm = formRequest.bindFromRequest().get();
        String consentChallenge = loginForm.getConsentChallenge();
        String[] grantScope = loginForm.getGrantScope();

        AdminApi adminApi = new AdminApi(hydraClient);
        ApiResponse<ConsentRequest> resConsentRequest;
        try{
            resConsentRequest = adminApi.getConsentRequestWithHttpInfo(consentChallenge);
        } catch (ApiException e){
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("errorTitle", "Error Get Consent Request");
                    put("errorContent", e.getMessage());
                }
            }));
        }

        AcceptConsentRequest body = new AcceptConsentRequest();
        if(grantScope != null)
            body.setGrantScope(Arrays.asList(grantScope));
        ConsentRequestSession session = new ConsentRequestSession();

        Map<String, String> ctx = (Map<String, String>)resConsentRequest.getData().getContext();
        // This data will be available when introspecting the token.
        session.setAccessToken(new HashMap<String, Object>(){
            {
                put("role_id", ctx.get("role_id").toString());
                put("project_id", ctx.get("project_id").toString());
                put("user_id", ctx.get("user_id").toString());
                put("org_id", ctx.get("org_id").toString());
            }
        });
        // This data will be available in the ID token.
//        session.setIdToken(new HashMap<String, Object>(){
//            {
//                put("metadata", resConsentRequest.getClient().getMetadata());
//            }
//        });
        body.setSession(session);
        CompletedRequest resAcceptConsent;
        try{
            resAcceptConsent =  adminApi.acceptConsentRequest(consentChallenge, body);

            // create instance of client in devices
//            String token = ObjectUtil.objToJsonNode(resConsentRequest.getContext()).findPath("token").asText();
//            String deviceName = ObjectUtil.objToJsonNode(resConsentRequest.getClient().getMetadata()).findPath("device_name").asText();
//            String deviceType = ObjectUtil.objToJsonNode(resConsentRequest.getClient().getMetadata()).findPath("device_type").asText();
//            if(StringUtils.isNotEmpty(deviceName) && StringUtils.isNotEmpty(deviceType) && StringUtils.isNotEmpty(token)){
//                String urlCreateDevice = appfileConfig.ulrBackendIot + "/api/devices";
//                token = "Bearer " + token;
//                Map<String, Object> bodyData = new HashMap<>();
//                bodyData.put("name", deviceName);
//                bodyData.put("metadata", new HashMap<String, String>(){
//                    {
//                        put("type", deviceType);
//                        put("productName", resConsentRequest.getClient().getClientName());
//                    }
//                });
//                ApiResult apiCreateDevice = apiService.sendPostJson(urlCreateDevice, Json.toJson(bodyData), token);
//                logger.info("Create Device:{}", Json.toJson(apiCreateDevice));
//                if(apiCreateDevice.getResultStatus() >= 200 && apiCreateDevice.getResultStatus() <= 299){
//                    String deviceId = (apiCreateDevice.getJsonData() != null) ? apiCreateDevice.getJsonData().get("id").asText():"";
//                    if(!org.springframework.util.StringUtils.isEmpty(deviceId)) {
//                        ApiResult apiGetGroups = apiService.getByToken(appfileConfig.ulrBackendIot + "/api/groups", token);
//                        if(apiGetGroups.getResultStatus() >= 200 && apiGetGroups.getResultStatus() <= 299){
//                            JsonNode group = apiGetGroups.getJsonData().get("groups").get(0);
//                            if(group != null)
//                            {
//                                ApiResult apiAddDeviceToGroup = apiService.sendPut(appfileConfig.ulrBackendIot + "/api/devices/" + deviceId + "/group/" + group.findPath("id").asText(), token);
//                            }
//                        }
//                    }
//                }
//            }

        } catch (Exception e){
            return ok(views.html.oauth.Login.render(new HashMap<String, String>(){
                {
                    put("errorTitle", "Error Accept Consent Request");
                    put("errorContent", e.getMessage());
                }
            }));
        }

        return redirect(resAcceptConsent.getRedirectTo());
    }

    public Result callback(String code){
        return ok(code);
    }
}
