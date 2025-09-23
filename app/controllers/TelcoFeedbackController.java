package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.FeedbackLogDAO;
import vn.m2m.iot.models.FeedbackLog;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class TelcoFeedbackController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public FeedbackLogDAO feedbackLogDAO;

    public Result feedback(String userId){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.feedback.Feedback.render(userSession, userId));
    }

    public Result sendFeedback() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId") != null ? jsonGroup.get("userId").asText() : "";
        String fullName = jsonGroup.get("fullName") != null ? jsonGroup.get("fullName").asText() : "";
        String nameCompany = jsonGroup.get("nameCompany") != null ? jsonGroup.get("nameCompany").asText() : "";
        String field = jsonGroup.get("field") != null ? jsonGroup.get("field").asText() : "";
        String content = jsonGroup.get("content") != null ? jsonGroup.get("content").asText() : "";
        int rate = jsonGroup.get("rate").asInt();

        User user = userDAO.getByKey(userId);
        if(user == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy user"));
            return ok(Json.toJson(respone));
        }

        FeedbackLog feedbackLog = new FeedbackLog();
        feedbackLog.setEmail(user.getEmail());
        feedbackLog.setPhone(user.getPhone());
        feedbackLog.setFullname(fullName);
        feedbackLog.setNameCompany(nameCompany);
        feedbackLog.setField(field);
        feedbackLog.setContent(content);
        feedbackLog.setRate(rate);
        feedbackLogDAO.save(feedbackLog);
        logger.debug("feedbackLog :{}", Json.toJson(feedbackLog));

        return ok(Json.toJson(respone));
    }

    public Result logFeedback(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.telco.feedback.LogFeedback.render(userSession));
    }

    public Result getLogListFeedback() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        int page = jsonGroup.get("page").asInt();
        int pageSize = jsonGroup.get("pageSize").asInt();
        String email = jsonGroup.get("email") != null ? jsonGroup.get("email").asText() : " ";
        String phone = jsonGroup.get("phone") != null ? jsonGroup.get("phone").asText() : " ";

        Map<String, Object> returnData = new HashMap<>();

        List<FeedbackLog> feedbackLogList = feedbackLogDAO.getLogListFeedbackPaging(page, pageSize, email, phone);
        logger.info("feedbackLogList : {}", feedbackLogList.size());
        returnData.put("logFeedback", feedbackLogList);

        long countLogListCmp = feedbackLogDAO.countLogListFeedback(email, phone);
        returnData.put("total", countLogListCmp);

        respone.setContent(returnData);
        return ok(Json.toJson(respone));
    }
}
