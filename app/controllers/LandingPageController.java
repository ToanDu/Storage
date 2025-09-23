package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.MailerService;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.RegisterDeveloperDAO;
import vn.m2m.iot.models.RegisterDeveloper;
import vn.m2m.iot.models.WidgetMapData;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 6/25/21.
 */
//@Security.Authenticated(Secured.class)
public class LandingPageController extends AbstractController {
    @Inject
    private MailerService mailerService;
    @Inject
    private RegisterDeveloperDAO registerDeveloperDAO;
    @Inject
    public ApiService apiService;

    public Result home() {
        User userSession = getUserSession();
//        if(userSession == null){
//            userSession = new User();
//        }

        return ok(views.html.landingPageTelco.LandingPage.render(userSession));
    }
    public Result landingPage() {
        User userSession = getUserSession();
        return ok(views.html.landingPage.LandingPage.render(userSession));
    }
    public Result submitFormContactTelco() {
        User user = getUserSession();
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText().trim();
        String email = jsonGroup.get("email").asText().trim();
        String phone = jsonGroup.get("phone").asText().trim();
        String content = jsonGroup.get("content").asText();

//        if(StringUtils.isEmpty(email)){
//            respone.setIssuccess(false);
//            respone.setErrorString(getMessages().at("register.emailNotEmpty"));
//            return ok(Json.toJson(respone));
//        } else {
//            if(!StringUtil.validateEmail(email)){
//                respone.setIssuccess(false);
//                respone.setErrorString(getMessages().at("register.validateEmail"));
//                return ok(Json.toJson(respone));
//            }
//        }

        if (StringUtils.isEmpty(name)) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(email)) {
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
        if(!StringUtils.isEmpty(phone)) {
            if(!StringUtil.validatePhoneVnNew(phone)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("noti.valid.phone"));
                return ok(Json.toJson(respone));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.emtyPhone"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }
        String url = appfileConfig.ulrBackendIot + "/api/sendemail/supportcustomer";
        logger.info("url : {}", url);


        Map<String, Object> body = new HashMap<>();
        body.put("mail_to", "iot@viettel.com.vn");
        body.put("subject", "Hỗ trợ khách hàng");
        body.put("body", content);
        ApiResult apiRegisterAdmin = apiService.sendPostJsonWithoutToken(url, Json.toJson(body));
        if(apiRegisterAdmin.getResultStatus() == 200) {
            respone.setResultString(getMessages().at("Gửi liên hệ thành công"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("Gửi liên hệ không thành công"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getUserId() {
        User user = getUserSession();
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText().trim();
        String email = jsonGroup.get("email").asText().trim();
        String phone = jsonGroup.get("phone").asText().trim();
        String content = jsonGroup.get("content").asText();

//        if(StringUtils.isEmpty(email)){
//            respone.setIssuccess(false);
//            respone.setErrorString(getMessages().at("register.emailNotEmpty"));
//            return ok(Json.toJson(respone));
//        } else {
//            if(!StringUtil.validateEmail(email)){
//                respone.setIssuccess(false);
//                respone.setErrorString(getMessages().at("register.validateEmail"));
//                return ok(Json.toJson(respone));
//            }
//        }

        if (StringUtils.isEmpty(name)) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(email)) {
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
        if(!StringUtils.isEmpty(phone)) {
            if(!StringUtil.validatePhoneVnNew(phone)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("noti.valid.phone"));
                return ok(Json.toJson(respone));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.emtyPhone"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }
        String url = appfileConfig.ulrBackendIot + "/api/sendemail/supportcustomer";
        logger.info("url : {}", url);


        Map<String, Object> body = new HashMap<>();
        body.put("mail_to", "iot@viettel.com.vn");
        body.put("subject", "Hỗ trợ khách hàng");
        body.put("body", content);
        ApiResult apiRegisterAdmin = apiService.sendPostJsonWithoutToken(url, Json.toJson(body));
        if(apiRegisterAdmin.getResultStatus() == 200) {
            respone.setResultString(getMessages().at("Gửi liên hệ thành công"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("Gửi liên hệ không thành công"));
        }
        return ok(Json.toJson(respone));
    }
    public Result getListProductOfferPack(String offerType, String payType, String category) { //lay ds goi cuoc tra truoc/sau
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);


//        User userSession = getUserSession();
//        if(userSession == null){
//            respone.setIssuccess(false);
//            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
//            return ok(Json.toJson(respone));
//        }


        Map<String, String> params = new HashMap<>();
        params.put("offerType", offerType);
        params.put("payType", payType);
        params.put("category", category);


       // String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/offerM2M";
        logger.info("url: {}", url);
        ApiResult apiResult = apiService.getWithParams(url, "", params);
        logger.info("getListProductOfferPack : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        }
        return ok(Json.toJson(respone));
    }
    public Result submitFormContact(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText().trim();
        String email = jsonGroup.get("email").asText().trim();
        String phone = jsonGroup.get("phone").asText().trim();
        String field = jsonGroup.get("field").asText();
        String content = jsonGroup.get("content").asText();

        if (StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
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
        if(!StringUtils.isEmpty(phone)){
            if(!StringUtil.validatePhoneVnNew(phone)){
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("noti.valid.phone"));
                return ok(Json.toJson(respone));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.emptyPhone"));
            return ok(Json.toJson(respone));
        }
        if (StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.content"));
            return ok(Json.toJson(respone));
        }

        //send email

        try{
            String emailTitle = "InnoWay - IoT Platform";
            String emailBody = "Dear, " +
                    "\r\n "+
                    "\r\nInnoWay System sends you customer information: "+
                    "\r\n "+
                    "\r\nTên: "+name+
                    "\r\nEmail: "+email+
                    "\r\nSố điện thoại: "+phone+
                    "\r\nLĩnh vực: "+field+
                    "\r\nNội dung: "+content+
                    "\r\n "+
                    "\r\nBộ phận chăm sóc khách hàng vui lòng liên hệ hỗ trợ theo thông tin trên!"+
                    "\r\n "+
                    "\r\nBest Regards,"
                    ;
            List<String> toAddresses=new ArrayList<String>();
            String emails = appfileConfig.listEmailSendContact;
            toAddresses = Arrays.asList(emails.split("\\s*,\\s*"));

            if(toAddresses.size() > 0){
                mailerService.sendEmail(appfileConfig.serverEmail,
                        toAddresses,
                        emailTitle,
                        null,
                        emailBody,
                        null
                );
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("send email false!!!");
        }

        respone.setResultString(getMessages().at("landing7.Sendsuccess"));
        return ok(Json.toJson(respone));
    }


    public Result registerDeveloper() {
        User userSession = getUserSession();
        return ok(views.html.landingPage.page.RegisterDeveloper.render(userSession));
    }

    public Result submitRegisterDeveloper(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText().trim();
        String nameCompany = jsonGroup.get("nameCompany").asText().trim();
        String email = jsonGroup.get("email").asText().trim();
        String phone = jsonGroup.get("phone").asText().trim();
        String role = jsonGroup.get("role").asText().trim();
        String field = jsonGroup.get("field").asText().trim();
        int countDevice = jsonGroup.get("countDevice").asInt();
        int countUser = jsonGroup.get("countUser").asInt();

        RegisterDeveloper registerDeveloper = new RegisterDeveloper();
        registerDeveloper.setName(name);
        registerDeveloper.setNameCompany(nameCompany);
        registerDeveloper.setEmail(email);
        registerDeveloper.setPhone(phone);
        registerDeveloper.setRole(role);
        registerDeveloper.setField(field);
        registerDeveloper.setCountDevice(countDevice);
        registerDeveloper.setCountUser(countUser);

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
        logger.info("mapOLists:{}", Json.toJson(mapOLists));
        if(Json.toJson(mapOLists).get("X-Forwarded-For") != null){
            String ip = "";
            try {
                ip = Json.toJson(mapOLists).get("X-Forwarded-For").toString();
                logger.info("X-Forwarded-For:{}", ip);
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("Error description:",ex);
            }

            if(StringUtils.isEmpty(ip)){
                if(Json.toJson(mapOLists).get("Remote-Address") != null){
                    try {
                        ip = Json.toJson(mapOLists).get("Remote-Address").toString();
                        logger.info("Remote-Address:{}", ip);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        logger.error("Error description:",ex);
                    }
                }
            }
            registerDeveloper.setIp(ip);
        }

        registerDeveloperDAO.save(registerDeveloper);

        respone.setResultString(getMessages().at("Cảm ơn bạn! Thông tin đăng ký của bạn đã gửi thành công!"));
        return ok(Json.toJson(respone));
    }

}