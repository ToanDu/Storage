package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import services.MailerService;
import vn.m2m.common.models.User;
import vn.m2m.config.AppfileConfig;
import vn.m2m.iot.dao.WidgetDAO;
import vn.m2m.iot.models.Widget;
import vn.m2m.utils.DateUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiController extends AbstractController {
    @Inject
    public MailerService mailerService;
    @Inject
    public AppfileConfig appfileConfig;
    @Inject
    public WidgetDAO widgetDAO;

    public Result sendMail(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode json = request().body().asJson();
        String key = json.get("key").asText();
        String title = json.get("title").asText();
        String body = json.get("body").asText();
        String emailList = json.get("emailList").asText();

        if(!key.equals("123456!@#$%^")){
            respone.setIssuccess(false);
            respone.setContent("Error");
            return ok(Json.toJson(respone));
        }

        List<String> myList = new ArrayList<String>();
        myList = Arrays.asList(emailList.split(","));

//        String emailTitle = "NAP - " + username + DateUtil.getDateByFormat(DateUtil.now(), DateUtil.DATE_TIME_CONVERT);
//        String emailBody = "Dear, " +
//                "\r\nTên: " + username
//                ;
//        List<String> toAddresses=new ArrayList<String>();
//        toAddresses.add("123@gmail.com");
        try {
            mailerService.sendEmail(appfileConfig.serverEmail,
                    myList,
                    title,
                    null,
                    body,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
            respone.setIssuccess(false);
            respone.setContent("Exception");
            return ok(Json.toJson(respone));
        }

        return ok(Json.toJson(respone));
    }

    public Result getJsonWidget(String username) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        Widget widget = widgetDAO.getByUsername(username);
        if(widget != null){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
            respone.setContent(widget);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.notFoundData"));
            return ok(Json.toJson(respone));
        }
    }
}
