package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ajaxjsons.AbstractAjaxJsonModel;
import okhttp3.HttpUrl;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Http;
import play.mvc.Result;
import vn.m2m.common.dao.UserCaptchaDAO;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.CaptchaResult;
import vn.m2m.common.models.forms.LoginForm;
import vn.m2m.iot.dao.DeviceIotDAO;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.models.RegisterForm;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.StringUtil;
import vn.m2m.utils.UserHelper;
import vn.m2m.utils.VersionHelper;

import javax.inject.Inject;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletionStage;

public class Application extends AbstractController {
    public Logger.ALogger logger = Logger.of(Application.class);

    @Inject
    public UserCaptchaDAO userCaptchaDAO;

    @Inject
    WSClient ws;

    @Inject
    public ApiService apiService;

    @Inject
    public TelcoLogDAO telcoLogDAO;


    public Result setLang(String lang){
        Optional<String> refererHeader = request().header("referer");//request().getHeader("referer");
        String referer = refererHeader.orElse(null);
        setLangSession(lang);
        if(StringUtils.isEmpty(referer)){
            return redirect(
                    routes.LandingPageController.home()
            );
        } else {
            return redirect(referer);
        }
    }

    //    @AddCSRFToken
    public Result login() {
        String lang = ctx().lang().code();
        setLangSession(lang);
        User user = getUserSession();
        if (user == null) {
            flash("false", getMessages().at("login.youMustRegister"));
            return ok(views.html.login.LoginTelco.apply());
        } else {
            return redirect(routes.ProjectController.project());
        }
    }
    public Result logindemo() {
        String lang = ctx().lang().code();
        setLangSession(lang);
        User user = getUserSession();
        if (user == null) {
            flash("false", getMessages().at("login.youMustRegister"));
            return ok(views.html.login.LoginTelcoDemo.apply());
        } else {
            return redirect(routes.ProjectController.project());
        }
    }
    public Result login(String returnUrl) {
        String lang = ctx().lang().code();
        setLangSession(lang);
        System.out.println("******************************: " + returnUrl);
        User user = getUserSession();
        if (user == null) {
            flash("false", getMessages().at("login.youMustRegister"));
            return ok(views.html.login.LoginTelco.apply());
        } else {
            return redirect(routes.ProjectController.project());
        }
    }

    //    @RequireCSRFCheck
    public Result authenticate() {
        Optional<String> referer = request().header("referer");//request().getHeader("referer");
        HttpUrl ref = HttpUrl.parse(referer.get());
        String returnUrl = ref.queryParameter("returnUrl");
        // System.out.println(returnUrl);

        Form<LoginForm> formRequest = formFactory.form(LoginForm.class);
        if (formRequest.hasErrors()) {
            flash("failed",getMessages().at("form.error"));
            return redirect(routes.Application.login());
        }
        LoginForm loginForm = formRequest.bindFromRequest().get();
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

//        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
//            flash("failed", getMessages().at("login.errorUsernameOrPass"));
//            return redirect(routes.Application.login());
//        }
//
//        if(username.length() > 50 || password.length() > 50){
//            flash("failed", getMessages().at("login.errorUsernameOrPass"));
//            return redirect(routes.Application.login());
//        }

//        session().put(UserHelper.SessionData.username, username);

        String urlLogin = appfileConfig.ulrBackendIot + "/api/login";
        logger.info("url login :{}", urlLogin);
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("identifier", username.trim());
        bodyData.put("password", password);
//        logger.info("body login :{}", Json.toJson(bodyData));
        ApiResult loginGetToken = apiService.sendApiWithJson(urlLogin, Json.toJson(bodyData).toString());
        logger.info("loginGetToken :{}", Json.toJson(loginGetToken));
        if(loginGetToken.getResultStatus() == 200){
            String user_id = (loginGetToken.getJsonData().get("user_id") != null)
                    ? loginGetToken.getJsonData().get("user_id").asText() : "";
            String token = (loginGetToken.getJsonData().get("token") != null)
                    ? loginGetToken.getJsonData().get("token").asText() : "";
            logger.info("token login :{}", token);
            String device_token = (loginGetToken.getJsonData().get("device_token") != null)
                    ? loginGetToken.getJsonData().get("device_token").asText() : "";
            String phone = (loginGetToken.getJsonData().get("phone") != null)
                    ? loginGetToken.getJsonData().get("phone").asText() : "";
            boolean isAdmin = loginGetToken.getJsonData().get("is_admin").asBoolean();
            String systemRole = (loginGetToken.getJsonData().get("system_role") != null)
                    ? loginGetToken.getJsonData().get("system_role").asText() : "NONE";
            String cmpRole = (loginGetToken.getJsonData().get("cmp_role") != null)
                    ? loginGetToken.getJsonData().get("cmp_role").asText() : "NONE";
            if(StringUtils.isEmpty(token) || StringUtils.isEmpty(user_id)){
                flash("failed", getMessages().at("login.notFoundUser"));
                return redirect(
                        routes.Application.login()
                );
            } else {
                Map<String, ArrayList<String>> mapOLists = new HashMap<String, ArrayList<String>>();
                Map<String, List<String>> headers = request().getHeaders().toMap();
                for (String key : headers.keySet()) {
                    ArrayList<String> singleList = new ArrayList<String>();
                    for (String item : headers.get(key)) {
                        Logger.info("{} : {}", key, item);
                        singleList.add(item);
                    }
                    mapOLists.put(key, singleList);
                }
                logger.debug("mapOLists:{}", Json.toJson(mapOLists));
                String ipBrowser = "";
                if (Json.toJson(mapOLists).get("X-Forwarded-For") != null) {
                    try {
                        ipBrowser = Json.toJson(mapOLists).get("X-Forwarded-For").toString();
                        logger.debug("X-Forwarded-For:{}", ipBrowser);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        logger.error("Error description:", ex);
                    }
                } else {
                    if (Json.toJson(mapOLists).get("Remote-Address") != null) {
                        try {
                            ipBrowser = Json.toJson(mapOLists).get("Remote-Address").toString();
                            logger.debug("Remote-Address:{}", ipBrowser);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            logger.error("Error description:", ex);
                        }
                    }
                }
                logger.info("ipBrowser : {}", ipBrowser);

                List<User> userList = userDAO.getListUserByUsername(username);
                logger.info("userList :{}", userList.size());
                if (userList.size() > 1) {
                    for (User user : userList) {
                        userDAO.deleteUser(user);
                    }
                }
                User user = userDAO.getByKey(user_id);
                logger.info("user :{}", Json.toJson(user));
                if (user == null) {
                    user = new User(username, password);
                    user.setId(user_id);
                    user.setToken(token);
                    user.setIp(ipBrowser);
                    user.setPhone(phone);
                    user.setAdmin(isAdmin);
                    user.setDeviceToken(device_token);
                    user.setSystemRole(User.SystemRole.valueOf(systemRole).getCode());
                    user.setCmpRole(User.CmpRole.valueOf(cmpRole).getCode());
//                    userDAO.save(userNew);

                    addUserSessionToCookie(user);
                } else {
                    user.setId(user_id);
                    user.setIp(ipBrowser);
                    user.setToken(token);
                    user.setPhone(phone);
                    user.setAdmin(isAdmin);
                    user.setDeviceToken(device_token);
                    user.setSystemRole(User.SystemRole.valueOf(systemRole).getCode());
                    user.setCmpRole(User.CmpRole.valueOf(cmpRole).getCode());
//                    userDAO.save(user);

                    addUserSessionToCookie(user);
                }

                logger.info("user: {}", Json.toJson(user));

                if (User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.SUPER_ADMIN.getCode()) {
                    flash("success", getMessages().at("login.loginSuccess"));

                    return redirect(routes.TelcoRoleAccountController.accountList());
                } else if (User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.ADMIN.getCode()
                        || User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.SUPER_ENTERPRISE.getCode()) {
                    return redirect(routes.TelcoRoleAccountController.infoAccountCmp(user_id));
                } else {
                    if (User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.ENTERPRISE_LV2.getCode()) {
                        String url_role_lv2 = appfileConfig.ulrBackendIot + "/api/roles/cmp/" + user_id;
                        ApiResult getRoleLv2 = apiService.getByToken(url_role_lv2, "Bearer " + token);
                        logger.info("getRoleLv2 :{}", Json.toJson(getRoleLv2));
                        if (getRoleLv2.getResultStatus() == 200) {
                            JsonNode data = getRoleLv2.getJsonData();
                            if (data.get("data") != null && data.get("data").size() > 0) {
                                try {
                                    JsonNode jsonData = data.get("data").get(0);
                                    logger.info("jsonData :{}", jsonData);
                                    JSONObject obj = new JSONObject(jsonData.toString());
                                    JSONArray arrAction = obj.getJSONArray("actions");
                                    List<String> feature = new ArrayList<>();
                                    if (arrAction.length() > 0) {
                                        for (int i = 0; i < arrAction.length(); i++) {
                                            feature.add(arrAction.get(i).toString());
                                        }
                                    }
                                    logger.info("feature :{}", feature);
                                    user.setFeatureRoles(feature);
                                    userDAO.save(user);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                user.setFeatureRoles(new ArrayList<>());
                                userDAO.save(user);
                            }
                        }
                        flash("success", getMessages().at("login.loginSuccess"));
//                    return redirect(routes.LandingPageController.home());
                        logger.info("returnUrl :{}", returnUrl);
                        if (returnUrl != null) {
                            return redirect(returnUrl);
                        } else {
                            return redirect(routes.LandingPageController.home());
                        }
                    } else {
                        String url_role_enterprise = appfileConfig.ulrBackendIot + "/api/users/" + user_id + "/enterprise?limit=1000&offset=0";
                        ApiResult apiResult1 = apiService.getByToken(url_role_enterprise, "Bearer " + token);
                        logger.info("getInfoCompany: {}", Json.toJson(apiResult1));
                        if (apiResult1.getResultStatus() == 200) {
                            JsonNode data = apiResult1.getJsonData();
                            if (data.get("data") != null && data.get("data").size() > 0) {
                                user.setProfileStatus(true);
                                userDAO.save(user);
                                flash("success", getMessages().at("login.loginSuccess"));
//                    return redirect(routes.LandingPageController.home());
                                logger.info("returnUrl :{}", returnUrl);
                                if (returnUrl != null) {
                                    return redirect(returnUrl);
                                } else {
                                    return redirect(routes.LandingPageController.home());
                                }
                            } else {
                                user.setProfileStatus(false);
                                userDAO.save(user);
                                flash("success", getMessages().at("login.loginSuccess"));
//                    return redirect(routes.LandingPageController.home());
                                logger.info("returnUrl :{}", returnUrl);
                                if (returnUrl != null) {
                                    return redirect(returnUrl);
                                } else {
                                    return redirect(routes.LandingPageController.home());
                                }
                            }
                        }
                    }
                }
            }
        } else {
            flash("failed", getMessages().at("login.errorUsernameOrPass"));
            return redirect(
                    routes.Application.login()
            );
        }
        flash("failed", getMessages().at("login.errorUsernameOrPass"));
        return redirect(
                routes.Application.login()
        );
    }


    //    @AddCSRFToken
    public Result authenticateDemo() {
        User userSession = getUserSession();

        Optional<String> referer = request().header("referer");//request().getHeader("referer");
        HttpUrl ref = HttpUrl.parse(referer.get());
        String returnUrl = ref.queryParameter("returnUrl");
        // System.out.println(returnUrl);

        Form<LoginForm> formRequest = formFactory.form(LoginForm.class);
        if (formRequest.hasErrors()) {
            flash("failed",getMessages().at("form.error"));
            return redirect(routes.Application.login());
        }
        LoginForm loginForm = formRequest.bindFromRequest().get();
        String username = "iot@viettel.com.vn";
        String password = "123456a@";
        String urlLogin = appfileConfig.ulrBackendIot + "/api/login";
        logger.info("url login :{}", urlLogin);
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("identifier", username.trim());
        bodyData.put("password", password);
//        logger.info("body login :{}", Json.toJson(bodyData));
        ApiResult loginGetToken = apiService.sendApiWithJson(urlLogin, Json.toJson(bodyData).toString());
        logger.info("loginGetToken :{}", Json.toJson(loginGetToken));
        if(loginGetToken.getResultStatus() == 200){
            String user_id = (loginGetToken.getJsonData().get("user_id") != null)
                    ? loginGetToken.getJsonData().get("user_id").asText() : "";
            String token = (loginGetToken.getJsonData().get("token") != null)
                    ? loginGetToken.getJsonData().get("token").asText() : "";
            logger.info("token login :{}", token);
            String device_token = (loginGetToken.getJsonData().get("device_token") != null)
                    ? loginGetToken.getJsonData().get("device_token").asText() : "";
            String phone = (loginGetToken.getJsonData().get("phone") != null)
                    ? loginGetToken.getJsonData().get("phone").asText() : "";
            boolean isAdmin = loginGetToken.getJsonData().get("is_admin").asBoolean();
            String systemRole = (loginGetToken.getJsonData().get("system_role") != null)
                    ? loginGetToken.getJsonData().get("system_role").asText() : "NONE";
            String cmpRole = (loginGetToken.getJsonData().get("cmp_role") != null)
                    ? loginGetToken.getJsonData().get("cmp_role").asText() : "NONE";
            if(StringUtils.isEmpty(token) || StringUtils.isEmpty(user_id)){
                flash("failed", getMessages().at("login.notFoundUser"));
                return redirect(
                        routes.Application.ChangePass()
                );
            } else {
                Map<String, ArrayList<String>> mapOLists = new HashMap<String, ArrayList<String>>();
                Map<String,List<String>> headers =request().getHeaders().toMap();
                for (String key : headers.keySet()) {
                    ArrayList<String> singleList = new ArrayList<String>();
                    for(String item: headers.get(key)) {
                        Logger.info("{} : {}", key, item);
                        singleList.add(item);
                    }
                    mapOLists.put(key, singleList);
                }
                logger.debug("mapOLists:{}", Json.toJson(mapOLists));
                String ipBrowser = "";
                if(Json.toJson(mapOLists).get("X-Forwarded-For") != null){
                    try {
                        ipBrowser = Json.toJson(mapOLists).get("X-Forwarded-For").toString();
                        logger.debug("X-Forwarded-For:{}", ipBrowser);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        logger.error("Error description:",ex);
                    }
                } else {
                    if(Json.toJson(mapOLists).get("Remote-Address") != null){
                        try {
                            ipBrowser = Json.toJson(mapOLists).get("Remote-Address").toString();
                            logger.debug("Remote-Address:{}", ipBrowser);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            logger.error("Error description:",ex);
                        }
                    }
                }
                logger.info("ipBrowser : {}", ipBrowser);

                List<User> userList = userDAO.getListUserByUsername(username);
                logger.info("userList :{}", userList.size());
                if(userList.size() > 1){
                    for(User user: userList){
                        userDAO.deleteUser(user);
                    }
                }
                User user = userDAO.getByKey(user_id);
                logger.info("user :{}", Json.toJson(user));
                if(user == null){
                    user = new User(username,password);
                    user.setId(user_id);
                    user.setToken(token);
                    user.setIp(ipBrowser);
                    user.setPhone(phone);
                    user.setAdmin(isAdmin);
                    user.setDeviceToken(device_token);
                    user.setSystemRole(User.SystemRole.valueOf(systemRole).getCode());
                    user.setCmpRole(User.CmpRole.valueOf(cmpRole).getCode());
//                    userDAO.save(userNew);

                    addUserSessionToCookie(user);
                } else {
                    user.setId(user_id);
                    user.setIp(ipBrowser);
                    user.setToken(token);
                    user.setPhone(phone);
                    user.setAdmin(isAdmin);
                    user.setDeviceToken(device_token);
                    user.setSystemRole(User.SystemRole.valueOf(systemRole).getCode());
                    user.setCmpRole(User.CmpRole.valueOf(cmpRole).getCode());
//                    userDAO.save(user);

                    addUserSessionToCookie(user);
                }

                logger.info("user: {}", Json.toJson(user));

                if(User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.SUPER_ADMIN.getCode()){
                    flash("success", getMessages().at("login.loginSuccess"));

                    return redirect(routes.TelcoRoleAccountController.accountList());
                } else if(User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.ADMIN.getCode()
                        || User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.SUPER_ENTERPRISE.getCode()){
                    return redirect(routes.TelcoRoleAccountController.infoAccountCmp(user_id));
                } else {
                    if(User.CmpRole.valueOf(cmpRole).getCode() == User.CmpRole.ENTERPRISE_LV2.getCode()){
                        String url_role_lv2 = appfileConfig.ulrBackendIot + "/api/roles/cmp/"+user_id;
                        ApiResult getRoleLv2 = apiService.getByToken(url_role_lv2, "Bearer "+token);
                        logger.info("getRoleLv2 :{}", Json.toJson(getRoleLv2));
                        if(getRoleLv2.getResultStatus() == 200){
                            JsonNode data = getRoleLv2.getJsonData();
                            if(data.get("data") != null && data.get("data").size() > 0){
                                try {
                                    JsonNode jsonData = data.get("data").get(0);
                                    logger.info("jsonData :{}", jsonData);
                                    JSONObject obj = new JSONObject(jsonData.toString());
                                    JSONArray arrAction = obj.getJSONArray("actions");
                                    List<String> feature = new ArrayList<>();
                                    if(arrAction.length() > 0){
                                        for(int i=0; i< arrAction.length(); i++){
                                            feature.add(arrAction.get(i).toString());
                                        }
                                    }
                                    logger.info("feature :{}", feature);
                                    user.setFeatureRoles(feature);
                                    userDAO.save(user);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                user.setFeatureRoles(new ArrayList<>());
                                userDAO.save(user);
                            }
                        }
                    }

                    flash("success", getMessages().at("login.loginSuccess"));
//                    return redirect(routes.LandingPageController.home());
                    logger.info("returnUrl :{}", returnUrl);
                    if(returnUrl != null) {
                        return redirect(returnUrl);
                    } else {
                        return redirect(routes.TelcoDashboardController.telcoDashboard(user_id));
                    }
                }
            }
        } else {
            flash("failed", getMessages().at("login.errorUsernameOrPass"));
            return redirect(
                    routes.Application.login()
            );
        }
    }

    public Result logout() {
        Http.Session session = Http.Context.current().session();
        String sessionId = session.get(UserHelper.SessionData.sessionId);
        logger.info("Call logout - sessionId = {}",sessionId);

        userService.cleanUserSessionInCookie(Http.Context.current());

        return redirect(
                routes.Application.login()
        );
    }

    //    @AddCSRFToken
    public Result register() {
        return ok(views.html.login.RegisterTelco.apply());
    }

    public Result ChangePass() {
        return ok(views.html.login.ChangPass.apply());
    }

    public Result newRegisterPost(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String email = jsonGroup.get("username").asText();
        String password = jsonGroup.get("password").asText();
        String passwordRepeat = jsonGroup.get("rePassword").asText();
        String optEmail = jsonGroup.get("optEmail").asText();

        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("login.emptyUsernameOrPass"));
            return ok(Json.toJson(respone));
        }

        if(email.length() > 50 || password.length() > 50){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Tên đăng nhập và mật khẩu không quá 50 kí tự!"));
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

        if(StringUtils.isEmpty(password)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.passNotEmpty"));
            return ok(Json.toJson(respone));
        }

        if(!password.equals(passwordRepeat)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.passAgainNotFound"));
            return ok(Json.toJson(respone));
        }

        if(StringUtils.isEmpty(optEmail)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa nhập mã OTP email"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/adminregister";
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("email", email);
        bodyData.put("password", password);
        bodyData.put("otp", optEmail);
        logger.info("bodyData :{}", Json.toJson(bodyData));
        ApiResult apiRegisterAdmin = apiService.sendApiWithJson(url, Json.toJson(bodyData).toString());
        logger.info("register :{}", apiRegisterAdmin.getJsonData());
        if(apiRegisterAdmin.getResultStatus() == 200){

            respone.setResultString(getMessages().at("register.registerSuccess"));
        }else {
            respone.setIssuccess(false);
            if(apiRegisterAdmin.getJsonData() != null){
                String message = (apiRegisterAdmin.getJsonData().get("message") != null) ? apiRegisterAdmin.getJsonData().get("message").asText() : "";
                if (apiRegisterAdmin.getJsonData().get("code").asInt() == 2006) {
                    message = getMessages().at("Tài khoản đã được sử dụng");
                }
                if (apiRegisterAdmin.getJsonData().get("code").asInt() == 2009) {
                    message = getMessages().at("OTP không đúng");
                }
                if(apiRegisterAdmin.getJsonData().get("code").asInt() == 2008) {
                    message = getMessages().at("OTP hết hạn");
                }
                if(StringUtils.isEmpty(message)){
                    respone.setErrorString(getMessages().at("noti.errorLogin"));
                } else {
                    respone.setErrorString(message);
                }
            } else {
                respone.setErrorString(getMessages().at("noti.disconnect"));
            }
        }

        return ok(Json.toJson(respone));
    }

    public Result getOtpEmail(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String email = jsonGroup.get("username").asText();

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

        String url = appfileConfig.ulrBackendIot + "/api/verifycode?email="+email;
        logger.info("url get otp : {}", url);

        ApiResult apiRegisterAdmin = apiService.getByUrl(url);
        logger.info("apiRegisterAdmin : {}", Json.toJson(apiRegisterAdmin));
        if(apiRegisterAdmin.getResultStatus() == 200){
            respone.setResultString(getMessages().at("Mã OTP đã được gửi tới mail của bạn!"));
        }else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Gửi OTP không thành công!"));
        }

        return ok(Json.toJson(respone)).withHeader("Access-Control-Allow-Origin", "https://iot.viettel.vn");
    }

    public Result getOtpPhone(){
        User user = getUserSession();

        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String phone = jsonGroup.get("phone").asText();

//        if (user != null) {
//            if(!StringUtils.isEmpty(user.getPhone())){
//                phone = user.getPhone();
//            }
//        }
        logger.info("getOtpPhone : {}", phone);

        if(StringUtils.isEmpty(phone)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Số điện thoại không được bỏ trống"));
            return ok(Json.toJson(respone));
        } else {
            if(!StringUtil.validatePhoneVnNew(phone)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("Không đúng định dạng số điện thoại"));
                return ok(Json.toJson(respone));
            }
        }

        String url = appfileConfig.ulrBackendIot + "/api/verifycode?phone="+phone;
        logger.info("url get otp : {}", url);

        ApiResult apiRegisterAdmin = apiService.getByUrl(url);
        logger.info("apiRegisterAdmin : {}", Json.toJson(apiRegisterAdmin));
        respone.setStatus(apiRegisterAdmin.getResultStatus());
        if(apiRegisterAdmin.getResultStatus() == 200){
            respone.setResultString(getMessages().at("Mã OTP đã được gửi tới số điện thoại của bạn!"));
        }else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("Gửi OTP không thành công!"));
        }

        TelcoLog telcoLog = new TelcoLog();
        if(user != null){
            telcoLog.setUsername(user.getUsername());
        } else {
            telcoLog.setUsername(phone);
        }
        telcoLog.setName("getOtpPhone");
        telcoLog.setContent("Lay OTP sdt");
        telcoLog.setUrl(url);
        telcoLog.setBody(phone);
        telcoLog.setStatusCode(apiRegisterAdmin.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiRegisterAdmin.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public CaptchaResult validCaptcha(String response, String remoteip){
        CaptchaResult captchaResult=new CaptchaResult();
        try {
            String url="https://www.google.com/recaptcha/api/siteverify";
            WSRequest request = ws.url(url);
            Duration timeout = Duration.ofMillis(3000);
            CompletionStage<CaptchaResult> responseCompletionStage = request.setRequestTimeout(timeout)
                    .addQueryParameter("secret", UserHelper.reCaptchaSecretKey)
                    .addQueryParameter("response", response)
                    .addQueryParameter("remoteip", remoteip)
                    .post("content")
                    .thenApply(wsResponse -> getCaptchaResult(wsResponse));
            captchaResult=responseCompletionStage.toCompletableFuture().get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return captchaResult;
    }

    private CaptchaResult getCaptchaResult(WSResponse wsResponse){
        String responetext=wsResponse.getBody();
        CaptchaResult captchaResult= new CaptchaResult();

        try{
            ObjectMapper objectMapper=new ObjectMapper();
            captchaResult = (CaptchaResult)objectMapper.readValue(responetext,CaptchaResult.class);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return captchaResult;
    }

    public Result forgotPassPage() {
        return ok(views.html.login.FogotPassTelco.apply());
    }

    public Result version(){
        Map<String, String> mapOLists = new LinkedHashMap<>();
        mapOLists.put("Name", VersionHelper.versionName);
        mapOLists.put("Organization", VersionHelper.versionOrganization);
        mapOLists.put("Number", VersionHelper.versionNumber);
        mapOLists.put("BuildDate", VersionHelper.versionBuildDate);
        return ok(Json.toJson(mapOLists));
    }

    //test
    public Result createAccount() {
        String username ="admin";
        String email = username + "@gmail.com";
        String pass = "123456aA@";

        User userCheck = userDAO.getByEmail(email);
        if(userCheck == null){
            User user = new User(username, email, pass);
            user.setRole(User.Roles.sadmin.getCode());
            userDAO.save(user);

            flash("success", getMessages().at("create success user " + username));
            return ok(views.html.login.Login.apply());
        } else {
            flash("failed", getMessages().at("create FAILED user!"));
            return ok(views.html.login.Login.apply());
        }
    }

    public Result sitemap() {
        String xml =
                "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n" +
                        "<url>\n" +
                        "<loc>https://innoway.vn/</loc>\n" +
                        "<lastmod>2022-07-25</lastmod>\n" +
                        "</url>\n" +
                        "<url>\n" +
                        "<loc>https://innoway.vn/solutionMaketPage</loc>\n" +
                        "<lastmod>2022-07-25</lastmod>\n" +
                        "</url>\n" +
                        "<url>\n" +
                        "<loc>https://innoway.vn/appSdkPage</loc>\n" +
                        "<lastmod>2022-07-25</lastmod>\n" +
                        "</url>\n" +
                        "<url>\n" +
                        "<loc>https://innoway.vn/appDebugPage</loc>\n" +
                        "<lastmod>2022-07-25</lastmod>\n" +
                        "</url>\n" +
                        "<url>\n" +
                        "<loc>https://innoway.vn/project</loc>\n" +
                        "<lastmod>2022-07-25</lastmod>\n" +
                        "</url>\n" +
                        "</urlset>";
        return ok(xml).as("text/xml");
    }
    public Result ForgetPassword(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String email = jsonGroup.get("username").asText();
        String password = jsonGroup.get("password").asText();
        String passwordRepeat = jsonGroup.get("rePassword").asText();
        String optEmail = jsonGroup.get("optEmail").asText();

        if(org.apache.commons.lang.StringUtils.isEmpty(email) || org.apache.commons.lang.StringUtils.isEmpty(password)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("login.emptyUsernameOrPass"));
            return ok(Json.toJson(respone));
        }

        if(email.length() > 50 || password.length() > 50){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Tên đăng nhập và mật khẩu không quá 50 kí tự!"));
            return ok(Json.toJson(respone));
        }

        if(org.apache.commons.lang.StringUtils.isEmpty(email)){
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

        if(org.apache.commons.lang.StringUtils.isEmpty(password)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("register.passNotEmpty"));
            return ok(Json.toJson(respone));
        }

        if(!password.equals(passwordRepeat)){
            respone.setIssuccess(false);
            respone.setErrorString("Nhập lại mật khẩu phải khớp với Mật khẩu.");
            return ok(Json.toJson(respone));
        }

        if(org.apache.commons.lang.StringUtils.isEmpty(optEmail)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa nhập mã OTP email"));
            return ok(Json.toJson(respone));
        }
        String url = appfileConfig.ulrBackendIot + "/api/password";
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("email", email);
        bodyData.put("password", password);
        bodyData.put("otp", optEmail);
        logger.info("bodyData :{}", Json.toJson(bodyData));
        ApiResult apiRegisterAdmin = apiService.sendApiWithJson(url, Json.toJson(bodyData).toString());
        logger.info("password :{}", apiRegisterAdmin.getJsonData());
        if(apiRegisterAdmin.getResultStatus() == 200){

            respone.setResultString(getMessages().at("forgot.passSuccess"));
        }else {
            respone.setIssuccess(false);
            if(apiRegisterAdmin.getJsonData() != null){
                String message = (apiRegisterAdmin.getJsonData().get("message") != null) ? apiRegisterAdmin.getJsonData().get("message").asText() : "";
                if (apiRegisterAdmin.getJsonData().get("code").asInt() == 2009) {
                    message = getMessages().at("OTP không đúng");
                }
                if (apiRegisterAdmin.getJsonData().get("code").asInt() == 2013) {
                    message = getMessages().at("Mật khẩu không đúng");
                }
                if(apiRegisterAdmin.getJsonData().get("code").asInt() == 2008) {
                    message = getMessages().at("OTP hết hạn");
                }
                if(StringUtils.isEmpty(message)){
                    respone.setErrorString(getMessages().at("noti.errorLogin"));
                } else {
                    respone.setErrorString(message);
                }
            } else {
                respone.setErrorString(getMessages().at("noti.disconnect"));
            }
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(email);
        telcoLog.setName("ForgetPassword");
        telcoLog.setContent("Quen mat khau");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(bodyData));
        telcoLog.setStatusCode(apiRegisterAdmin.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiRegisterAdmin.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result checkIpLogin(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String username = jsonGroup.get("username").asText();

        User user = userDAO.getByUsername(username);
        if(user == null){
            respone.setIssuccess(true);
            return ok(Json.toJson(respone));
        } else {
            logger.debug("checkIpLogin user:{}", Json.toJson(user));
            String ip = user.getIp();
            if(StringUtils.isEmpty(ip)){
                respone.setIssuccess(true);
                return ok(Json.toJson(respone));
            }

            Map<String, ArrayList<String>> mapOLists = new HashMap<String, ArrayList<String>>();
            Map<String,List<String>> headers =request().getHeaders().toMap();
            for (String key : headers.keySet()) {
                ArrayList<String> singleList = new ArrayList<String>();
                for(String item: headers.get(key)) {
                    Logger.info("{} : {}", key, item);
                    singleList.add(item);
                }
                mapOLists.put(key, singleList);
            }
            logger.debug("mapOLists:{}", Json.toJson(mapOLists));
            String ipBrowser = "";
            if(Json.toJson(mapOLists).get("X-Forwarded-For") != null){
                try {
                    ipBrowser = Json.toJson(mapOLists).get("X-Forwarded-For").toString();
                    logger.debug("X-Forwarded-For:{}", ipBrowser);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error("Error description:",ex);
                }
            } else {
                if(Json.toJson(mapOLists).get("Remote-Address") != null){
                    try {
                        ipBrowser = Json.toJson(mapOLists).get("Remote-Address").toString();
                        logger.debug("Remote-Address:{}", ipBrowser);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        logger.error("Error description:",ex);
                    }
                }
            }
            logger.info("ipBrowser : {}", ipBrowser);

            if(ip.equals(ipBrowser)){
                respone.setIssuccess(true);
                return ok(Json.toJson(respone));
            } else {
                //send otp to phone user
                String phone = user.getPhone();
                if(StringUtils.isEmpty(phone)){
                    respone.setIssuccess(true);
                    return ok(Json.toJson(respone));
                } else {
                    String url = appfileConfig.ulrBackendIot + "/api/verifycode?phone="+phone;
                    logger.info("url get otp : {}", url);
                    ApiResult apiRegisterAdmin = apiService.getByUrl(url);
                    logger.info("send otp to phone user : {}", Json.toJson(apiRegisterAdmin));
                    if(apiRegisterAdmin.getResultStatus() == 200){
                        respone.setIssuccess(false);
                        respone.setContent(phone);
                        return ok(Json.toJson(respone));
                    } else {
                        respone.setIssuccess(true);
                        return ok(Json.toJson(respone));
                    }
                }
            }
        }
    }

    public Result verifyPhone() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();

        String url = appfileConfig.ulrBackendIot + "/api/verifycode?phone=";

        ApiResult apiResult = apiService.sendPostJsonWithoutToken(url, jsonGroup);
        logger.info("verifyPhone:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("Xác thực OTP thành công"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Xác thực OTP không thành công"));
        }

        return ok(Json.toJson(respone));
    }
}
