package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 4/21/23.
 */
@Security.Authenticated(Secured.class)
public class TelcoHistoryController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result historyPackMiAddon(String userId){
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

        return ok(views.html.telco.history.HistoryMiAddon.render(userSession, userId));
    }

     public Result historyDeposit (String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.history.HistoryDeposit.render(userSession, userId));
     }

     public Result historyBlockUnblock (String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.history.HistoryBlockUnblock.render(userSession, userId));
    }

    public Result historyApn (String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.history.HistoryApn.render(userSession, userId));
    }

    public Result getHistoryPackMiAddon() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String idNo = (jsonGroup.get("idNo") != null) ? jsonGroup.get("idNo").asText() :"";
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String from = (jsonGroup.get("from") != null) ? jsonGroup.get("from").asText() :"";
        String to = (jsonGroup.get("to") != null) ? jsonGroup.get("to").asText() :"";
        String action = (jsonGroup.get("action") != null) ? jsonGroup.get("action").asText() :"";
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("offset :{} - limit :{}", startAt, pageSize);
        String userId = jsonGroup.get("userId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("idNo", idNo);
        param.put("isdn", isdn);
        param.put("actionCode", action);
        param.put("offset", Integer.toString(startAt));
        param.put("limit", Integer.toString(pageSize));
        param.put("userId", userId);
        param.put("from", from);
        param.put("to", to);
//        param.put("status", userId);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        String url = appfileConfig.ulrBackendIot + "/api/telco/actionLog";
//        String url = "https://api.innoway.vn/api/pricing/payment/telco/query";

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("apiResult : {} ", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("historyPackMiAddon");
        telcoLog.setContent("Lay lich su dang ki/huy/gia han goi MI Addon");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
    public Result getHistoryApn() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String action = (jsonGroup.get("action") != null) ? jsonGroup.get("action").asText() :"";
        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        String from = (jsonGroup.get("from") != null) ? jsonGroup.get("from").asText() :"";
        String to = (jsonGroup.get("to") != null) ? jsonGroup.get("to").asText() :"";
        String isdn  = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        //String orderId  = (jsonGroup.get("orderId") != null) ? jsonGroup.get("orderId").asText() :"";
        logger.info("offset :{} - limit :{}", startAt, pageSize);
        String user_id = jsonGroup.get("userId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("actionCode", action);
        param.put("offset", Integer.toString(startAt));
        param.put("limit", Integer.toString(pageSize));
        param.put("userId", user_id);
        param.put("from", from);
        param.put("to", to);
        param.put("isdn", isdn);
        //param.put("orderId", orderId);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/telco/actionLog";
//        String url = "https://api.innoway.vn/api/pricing/payment/telco/query";

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("apiResult : {} ", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListAPNByAction");
        telcoLog.setContent("Lay danh sach APN");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result historyPrepayCharges (String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.history.HistoryPrepayCharges.render(userSession, userId));
    }
    public Result historyPostPaidBill (String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.history.HistoryPostPaidBill.render(userSession, userId));
    }

}
