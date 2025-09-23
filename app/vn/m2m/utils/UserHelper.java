package vn.m2m.utils;

import com.typesafe.config.Config;
import vn.m2m.common.models.User;
import vn.m2m.common.models.UserAdmin;
import vn.m2m.config.AppfileConfig;
import vn.m2m.models.Group;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import play.Logger;

public class UserHelper {
    public class SessionData{
        public static final String sessionId = "sessionId";
        public static final String token = "token";
        public static final String email = "email";
        public static final String avatar = "avatar";
        public static final String name = "username"; // substring email 12 character
        public static final String TIMEOUT_KEY = "session.timeout";
        public static final String language = "language";
        public static final String lastModified = "lastModified";
        public static final String isApp = "isApp";
        public static final String subMenu = "subMenu";
        public static final String sessionEmailLogin = "emaillogin";
        public static final String username = "email";
        public static final String flow = "flow";
    }

    public static String linkGoogleMapApi(){
        //src="https://maps.googleapis.com/maps/api/js?v=3&key=AIzaSyD94Yo1rr5OQWWkSGNVGW84nA3vZLIdfbA&lang=vi"
        String apiKeyRandom = getGoogleApiKeyRandom();
        String linkapi = "https://maps.googleapis.com/maps/api/js?key="+apiKeyRandom+"&lang=vi";
        return linkapi;
    }
    public static String getGoogleApiKeyRandom(){
        //random from 1-9

        int rand = StringUtil.randomNumber(1,maxGoogleApiBrowserKey);
        String keyRandom = getAppConfigString(StaticContent.GOOGLE_API_BROWSER_KEY + rand);

//        System.out.println("GoogleApiBrowserKeyMax:"+maxGoogleApiBrowserKey);
//        System.out.println("GoogleApiBrowserKeyRandom:"+keyRandom);

        return keyRandom;
    }

    public static String genaralSessionId() {
        return StringUtil.getTimeUUIDString();
    }
    public static String generateFilename(String contentType) {
        return StringUtil.getTimeUUIDString() + "." + contentType;
    }
    public static String generalUserID() {
        return generalID();
    }
    public static String generalID() {
        return StringUtil.getTimeUUIDString();
    }

    public static String hashPassword(String password){
        String passwordHash = "";
        try {
            passwordHash = PasswordHash.createHash(password);
        }
        catch(NoSuchAlgorithmException |InvalidKeySpecException ex){
            ex.printStackTrace();
        }
        return passwordHash;
    }

    public static boolean validPassword(String password, String passwordHash){
        try{
            return PasswordHash.validatePassword(password, passwordHash);
        }
        catch (NoSuchAlgorithmException |InvalidKeySpecException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static String generalUserPassword() {
        try {
            return SecretUtil.keyGenHex512();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }
    public static String generalNonce() {
        return StringUtil.getTimeUUIDString();
    }
    public static String generateAuthenCode(){
        return Long.toString(StringUtil.generateRandom(8));
    }

    public static String generateSSRC(){
        try{
            String ssrc=Integer.toString(StringUtil.randomNumber());
            return ssrc;
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    public static Config getAppConfig(){
        return AppHelper.getAppConfig();
    }
    public static String getAppConfigString(String key){
        String value = getAppConfig().getString(key);
        return value;
    }
    public static Integer getAppConfigInt(String key){
        return getAppConfig().getInt(key);
    }
    public static Long getConfigLong(String key){
        return getAppConfig().getLong(key);
    }
    public static Double getAppConfigDouble(String key){
        return getAppConfig().getDouble(key);
    }

    public static Boolean getAppConfigBoolean(String key){
        return getAppConfig().getBoolean(key);
    }

    public static boolean isSessionTimeOut(String sessionId){
        long timeSession = DateUtil.convertStringByteArrayToDate(sessionId);
        Date dateSession = DateUtil.convertDate(timeSession);
        Date currentDate = DateUtil.now();
        int timeout = getAppConfigInt(SessionData.TIMEOUT_KEY);
//        logger.info("dateSession: {}",dateSession);
//        logger.info("timeout: {}",timeout);


        if(DateUtil.diffMinutes(currentDate,dateSession)>timeout){
            return true;
        }
        return false;
    }


    public class StaticContent{
        public static final String WEB_LINK_ROOT_KEY ="web.link.root";
        public static final String LINK_AVATAR_USERADMIN_KEY ="content.link.avatar.useradmin";
        public static final String LINK_AVATAR_DEFAULT ="content.default.linkavatar";
        public static final String FOLDER_AVATAR_USER_KEY ="content.folder.avatar.useradmin";

        //ais map
        public static final String GOOGLE_API_BROWSER_KEY ="google.api.browserkey";
        public static final String GOOGLE_API_BROWSER_KEY_MAX ="google.api.browserkeymax";

        public static final String MAPBOX_BROWSER_KEY ="mapbox.api.browserkey";
        public static final String MAPBOX_BROWSER_KEY_MAX ="mapbox.api.browserkeymax";

//        public static final String LINK_IMG_AVATAR ="content.folder.avatar";

        public static final String MAP_DISPLAY_BTS ="map.displayBTS";

        public static final String USER_ADMIN_MAIL ="user.admin.mail";

    }

    public static String linkGoogleMapbox(){
        String apiKeyRandom = getMapboxKeyRandom();
        String linkapi = "https://api.mapbox.com/styles/v1/mapbox/streets-v11/tiles/{z}/{x}/{y}?access_token="+apiKeyRandom;
        return linkapi;
    }

    public static Integer maxMapboxBrowserKey = getAppConfigInt(StaticContent.MAPBOX_BROWSER_KEY_MAX);
    public static String getMapboxKeyRandom(){
        int rand = StringUtil.randomNumber(1, maxMapboxBrowserKey);
        String keyRandom = getAppConfigString(StaticContent.MAPBOX_BROWSER_KEY + rand);

        return keyRandom;
    }

    public static String imgAvatarLinkPath = "/data/content/image";

    //phan quyen
    public static boolean isSAdmin(User user){
        if (user.getRole()== User.Roles.sadmin.getCode()){return true;}
        return false;
    }
    public static boolean isAdmin(User user){
        String mailAdmin = AppHelper.getAppConfigString(StaticContent.USER_ADMIN_MAIL);
        if (user.getEmail().equals(mailAdmin)){return true;}
        return false;
    }
    public static boolean isSMod(User user){
        if (user.getRole()== User.Roles.supermod.getCode()){return true;}
        return false;
    }
    public static boolean isMod(User user){
        if (user.getRole()== User.Roles.mod.getCode()){return true;}
        return false;
    }
    public static boolean isUser(User user){
        if (user.getRole()== User.Roles.user.getCode()){return true;}
        return false;
    }

    public static boolean isFeatureRole(User user, String idElement){
        if(user.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()){
            List<String> roleList = user.getFeatureRoles();
            Logger.info("roleList : {}", roleList);
            if(roleList.size() > 0){
                if(roleList.contains(idElement)){
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static String generateUniqueFilename(String filename) {
        return StringUtil.getTimeUUIDString() +"-"+ filename;
    }

    public static String webLinkRoot = AppHelper.getAppConfigString(StaticContent.WEB_LINK_ROOT_KEY);


    public static String avatarUserLinkPath = webLinkRoot + AppHelper.getAppConfigString(StaticContent.LINK_AVATAR_USERADMIN_KEY);
    public static String avatarDefaultLinkPath = AppHelper.getAppConfigString(StaticContent.LINK_AVATAR_DEFAULT);

    public static String avatarUserFolderPath = AppHelper.getAppConfigString(StaticContent.FOLDER_AVATAR_USER_KEY);

    public static Integer maxGoogleApiBrowserKey = getAppConfigInt(StaticContent.GOOGLE_API_BROWSER_KEY_MAX);

    public class reCaptcha{
        public static final String SITE_KEY ="recaptcha.sitekey";
        public static final String SECRET_KEY ="recaptcha.secretkey";
    }

    public static String reCaptchaSiteKey = AppHelper.getAppConfigString(reCaptcha.SITE_KEY);
    public static String reCaptchaSecretKey = AppHelper.getAppConfigString(reCaptcha.SECRET_KEY);

    public static final int MAX_AUTHEN_FAILED=5; //5 time
}
