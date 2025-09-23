package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.springframework.util.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import services.MailerService;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.UserChangePassDAO;
import vn.m2m.iot.models.UserChangePass;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 7/3/21.
 */
public class FogotPassController extends AbstractController {
    @Inject
    private MailerService mailerService;
    @Inject
    public UserChangePassDAO userChangePassDAO;
    @Inject
    public ApiService apiService;

    //    change pass user
    public Result userGetCodeChangePass(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode json = request().body().asJson();
        String email = json.get("username").asText();
        if(StringUtils.isEmpty(email)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("forgot.usernameEmpty"));
            return ok(Json.toJson(respone));
        }

        if(!StringUtil.validateEmail(email)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.email"));
            return ok(Json.toJson(respone));
        }

        //send email
        int number = StringUtil.randomNumber(100000, 999999);
        logger.debug("number :{}", number);
        try{
            String emailTitle = "InnoWay - IoT Platform";
            String emailBody = "Dear sir, " +
                    "\r\n "+
                    "\r\nInnoWay System send you code: " + number +
                    "\r\n "+
                    "\r\nBest Regards,"
                    ;
            List<String> toAddresses=new ArrayList<String>();
            toAddresses.add(email);

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
        }

        UserChangePass userChangePass = userChangePassDAO.getByUsername(email);
        if(userChangePass != null){
            userChangePass.setCode(number);
            userChangePass.setLogDate(DateUtil.now());
            userChangePassDAO.save(userChangePass);
        } else {
            UserChangePass userChangePassNew = new UserChangePass();
            userChangePassNew.setUsername(email);
            userChangePassNew.setCode(number);
            userChangePassDAO.save(userChangePassNew);
        }

        respone.setResultString(getMessages().at("forgot.sendSmsSuccess" , " " +email));
        return ok(Json.toJson(respone));
    }
    public Result ChangePassword(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        JsonNode jsonGroup = request().body().asJson();
        String new_password = jsonGroup.get("new_password").asText();
        String old_password = jsonGroup.get("old_password").asText();

        String url = appfileConfig.ulrBackendIot + "/api/tenant/changepassword";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("new_password", new_password);
        bodyData.put("old_password", old_password);
        logger.info("bodyData :{}", Json.toJson(bodyData));
        ApiResult apifogotPass = apiService.sendPostJson(url, Json.toJson(bodyData), token);
        logger.info("respone", apifogotPass.getJsonData());
        logger.info("new_password :{}", new_password);
        logger.info("old_password :{}", apifogotPass.getJsonData());
        if(apifogotPass.getResultStatus() == 200){
            respone.setResultString(getMessages().at("ChangePass.registerSuccess"));
        }else {
            respone.setIssuccess(false);
            if(apifogotPass.getJsonData() != null){
                String message = (apifogotPass.getJsonData().get("message") != null) ? apifogotPass.getJsonData().get("message").asText() : "";
                if (apifogotPass.getJsonData().get("code").asInt() == 2013) {
                    message = getMessages().at("Mật khẩu không đúng.");
                }
                if(org.apache.commons.lang.StringUtils.isEmpty(message)){
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
}
