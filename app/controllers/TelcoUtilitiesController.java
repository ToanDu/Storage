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
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.StringUtil;
import java.util.List;
import java.util.ArrayList;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 11/16/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoUtilitiesController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result utilitiesManage(String userId) {
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

        return ok(views.html.telco.utilities.Utilities.render(userSession, userId));
    }

    public Result utilitiesBlock(String userId) {
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

        return ok(views.html.telco.blockUtilities.BlockUtilities.render(userSession, userId));
    }

    public Result utilitiesTopup(String userId) {
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

        return ok(views.html.telco.topUp.Utilities.render(userSession, userId));
    }

    public Result utilitiesBuyPackage(String userId) {
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

        return ok(views.html.telco.buyPackage.Utilities.render(userSession, userId));
    }

    public Result getListPackMiAndAddOn() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/massPackage?type=MI,ADDON&isMass=0";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getListPackMiAndAddOn : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListPackMiAndAddOn");
        telcoLog.setContent("Danh sach goi cuoc MI, Add-on");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result registerMiAddon() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String vasCode = (jsonGroup.get("vasCode") != null) ? jsonGroup.get("vasCode").asText() :"";
        String pkgName = (jsonGroup.get("pkgName") != null) ? jsonGroup.get("pkgName").asText() :"";
        String userId = jsonGroup.get("userId").asText();

        if(!StringUtils.isEmpty(isdn)){
            if(!StringUtil.validatePhoneVn84(isdn)){
                if(StringUtil.validatePhoneVn(isdn)){
                    isdn = "84"+isdn.substring(0);
                } else {
                    if(StringUtil.validatePhoneNotFirstNumber(isdn)){
                        isdn = "84"+isdn;
                    }
                }
            }
        }
        logger.info("isdn :{}", isdn);

        Map<String, String> body = new HashMap<>();
        body.put("userId", userId);
        body.put("msisdn", isdn);
        body.put("vasCode", vasCode);
        body.put("pkgName", pkgName);
        body.put("sendMt", "0");
        body.put("isRegisterOnly", "1");
        body.put("requestId", "1");
        body.put("systemClient", "iot.viettel.vn");
        body.put("userAction", userSession.getUsername());
        body.put("description", "dang ki goi cuoc");

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/data/register";

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("registerMiAddon");
        telcoLog.setContent("Dang ky MI, Add-on cho thue bao "+ isdn);
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result unregisterMiAddon() {
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
        String vasCode = (jsonGroup.get("vasCode") != null) ? jsonGroup.get("vasCode").asText() :"";
        String pkgName = (jsonGroup.get("pkgName") != null) ? jsonGroup.get("pkgName").asText() :"";
        String userId = jsonGroup.get("userId").asText();

        if(!StringUtils.isEmpty(isdn)){
            if(!StringUtil.validatePhoneVn84(isdn)){
                if(StringUtil.validatePhoneVn(isdn)){
                    isdn = "84"+isdn.substring(0);
                } else {
                    if(StringUtil.validatePhoneNotFirstNumber(isdn)){
                        isdn = "84"+isdn;
                    }
                }
            }
        }
        logger.info("isdn :{}", isdn);

        Map<String, String> body = new HashMap<>();
        body.put("userId", userId);
        body.put("idNo", idNo);
        body.put("msisdn", isdn);
        body.put("vasCode", vasCode);
        body.put("pkgName", pkgName);
        body.put("sendMt", "0");
        body.put("isRegisterOnly", "1");
        body.put("requestId", "1");
        body.put("systemClient", "iot.viettel.vn");
        body.put("userAction", userSession.getUsername());
        body.put("description", "dang ki goi cuoc");

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/data/unregister";

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("unregisterMiAddon");
        telcoLog.setContent("Huy goi MI, Add-on cho thue bao "+ isdn);
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result unextendMiAddon() {
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
        String vasCode = (jsonGroup.get("vasCode") != null) ? jsonGroup.get("vasCode").asText() :"";
        String pkgName = (jsonGroup.get("pkgName") != null) ? jsonGroup.get("pkgName").asText() :"";
        String userId = jsonGroup.get("userId").asText();

        if(!StringUtils.isEmpty(isdn)){
            if(!StringUtil.validatePhoneVn84(isdn)){
                if(StringUtil.validatePhoneVn(isdn)){
                    isdn = "84"+isdn.substring(0);
                } else {
                    if(StringUtil.validatePhoneNotFirstNumber(isdn)){
                        isdn = "84"+isdn;
                    }
                }
            }
        }
        logger.info("isdn :{}", isdn);

        Map<String, String> body = new HashMap<>();
        body.put("userId", userId);
        body.put("idNo", idNo);
        body.put("msisdn", isdn);
        body.put("vasCode", vasCode);
        body.put("pkgName", pkgName);
        body.put("sendMt", "0");
        body.put("isRegisterOnly", "1");
        body.put("requestId", "1");
        body.put("systemClient", "iot.viettel.vn");
        body.put("userAction", userSession.getUsername());
        body.put("description", "dang ki goi cuoc");

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/data/cancel-extend";

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("unextendMiAddon");
        telcoLog.setContent("Huy gia han goi MI, Add-on cho thue bao "+ isdn);
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getInfoOrderId() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String order_id = (jsonGroup.get("order_id") != null) ? jsonGroup.get("order_id").asText() :"";
        String offset = (jsonGroup.get("offset") != null) ? jsonGroup.get("offset").asText() : "0";
        String limit = (jsonGroup.get("limit") != null) ? jsonGroup.get("limit").asText() : "100";
        String user_id = jsonGroup.get("userId").asText();

        Map<String, String> param = new HashMap<>();
        if(!StringUtils.isEmpty(isdn)){
            param.put("isdn", isdn);
        }
        if(!StringUtils.isEmpty(order_id)){
            param.put("orderId", order_id);
        }
//        param.put("order_id", "M2M2301039736948-298");
        param.put("offset", offset);
        param.put("limit", limit);
        param.put("userId", user_id);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/query";
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
        telcoLog.setName("getInfoOrderId");
        telcoLog.setContent("Lay thong tin thanh toan");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result rechargeSubcriber() { //nap tien cho thue bao
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/topUp";
        logger.info("url : {}", url);

//        Map<String, Object> body = new HashMap<>();
//        body.put("action", actionCode);
//        body.put("reason", "Nạp tiền thuê bao");
//        body.put("user_id", user_id);
//
//        if(arrIsdn.length() > 0){
//            Map<String, Object> listIsdn = new HashMap<>();
//            for(int i = 0; i<arrIsdn.length(); i++){
//                listIsdn.put(arrIsdn.get(i).toString(), money);
//            }
//            body.put("list", listIsdn);
//        }
//
//        logger.info("body : {}", Json.toJson(body));

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
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
        telcoLog.setName("rechargeSubcriber");
        telcoLog.setContent("Nap tien thue bao");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //get danh sach order ID
    public Result getListOrderIdByAction() {
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
        String orderId  = (jsonGroup.get("orderId") != null) ? jsonGroup.get("orderId").asText() :"";
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
        param.put("orderId", orderId);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/query";
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
        telcoLog.setName("getListOrderIdByAction");
        telcoLog.setContent("Lay danh sach order thanh toan");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getHistoryBlockUnblock() {
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
        String orderId  = (jsonGroup.get("orderId") != null) ? jsonGroup.get("orderId").asText() :"";
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
        param.put("orderId", orderId);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/telco/actionLog";

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
        telcoLog.setName("getHistoryBlockUnblock");
        telcoLog.setContent("Lấy lịch sử block/unblock thuê bao");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result validateSubs() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/isdn/validate";

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        logger.info("apiResult : {}", Json.toJson(jsonGroup));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("validateSubs");
        telcoLog.setContent("Kiem tra thue bao hop le ");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        logger.info("respone : {}", String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone)).withHeader("Access-Control-Allow-Origin", "https://iot.viettel.vn");
    }

    public Result prepayCharges(String userId) {
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

        return ok(views.html.telco.prepayCharges.PrepayCharges.render(userSession, userId));
    }

    public Result prepayChargesBill(String userId, String isdn, String orderId) {
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

        return ok(views.html.telco.prepayCharges.PrepayCharges_bill.render(userSession, userId));
    }

    public Result getDataPrepaidInfo(String prom_code, String product_code) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Map<String, String> param = new HashMap<>();
        param.put("prom_code", prom_code);
        param.put("product_code", product_code);

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/prepaid";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getDataPrepaidInfo : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDataPrepaidInfo");
        telcoLog.setContent("Lấy dữ liệu đóng cước trước");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    // Nạp tiền đóng cước trước
    public Result rechargePrepaid() {
         AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup : {}", jsonGroup);
        String reason = (jsonGroup.get("reason") != null) ? jsonGroup.get("reason").asText() :"";
        String user_id = (jsonGroup.get("user_id") != null) ? jsonGroup.get("user_id").asText() :"";
        JsonNode listPrepaid = jsonGroup.get("list_pre_paid");
        String isdn = "";
            String id_no =  "";
            String product_code = "";
            String promotion_code =  "";
            String pay_type =  "";
            String pre_paid_code ="";
            int amount = 0;
            String prom_month =  "";
            String prom_percent = "";
            String prom_value =  "";
            String display_prom_month = "";
            String contract_id =  "";

        if (listPrepaid != null && listPrepaid.isArray() && listPrepaid.size() > 0) {
            JsonNode firstItem = listPrepaid.get(0); // chỉ lấy phần tử đầu tiên
            logger.info("firstItem : {}", firstItem);
             isdn = firstItem.hasNonNull("isdn") ? firstItem.get("isdn").asText() : "";
             id_no = firstItem.hasNonNull("id_no") ? firstItem.get("id_no").asText() : "";
             product_code = firstItem.hasNonNull("product_code") ? firstItem.get("product_code").asText() : "";
             promotion_code = firstItem.hasNonNull("promotion_code") ? firstItem.get("promotion_code").asText() : "";
             pay_type = firstItem.hasNonNull("pay_type") ? firstItem.get("pay_type").asText() : "";
             pre_paid_code = firstItem.hasNonNull("pre_paid_code") ? firstItem.get("pre_paid_code").asText() : "";
             amount = firstItem.hasNonNull("amount") ? firstItem.get("amount").asInt() : 0;
             prom_month = firstItem.hasNonNull("prom_month") ? firstItem.get("prom_month").asText() : "";
             prom_percent = firstItem.hasNonNull("prom_percent") ? firstItem.get("prom_percent").asText() : "";
             prom_value = firstItem.hasNonNull("prom_value") ? firstItem.get("prom_value").asText() : "";
             display_prom_month = firstItem.hasNonNull("display_prom_month") ? firstItem.get("display_prom_month").asText() : "";
             contract_id = firstItem.hasNonNull("contract_id") ? firstItem.get("contract_id").asText() : "";
            // Bạn có thể dùng các biến ở đây
            logger.info("isdn = {}", isdn);
        } else {
            logger.warn("list_pre_paid is empty or missing!");
        }

        Map<String, Object> item = new HashMap<>();
        item.put("isdn", isdn);
        item.put("id_no", id_no);
        item.put("product_code", product_code);
        item.put("promotion_code", promotion_code);
        item.put("pay_type", pay_type);
        item.put("pre_paid_code", pre_paid_code);
        item.put("amount", amount);
        item.put("prom_month", prom_month);
        item.put("prom_percent", prom_percent);
        item.put("prom_value", prom_value);
        item.put("display_prom_month", display_prom_month);
        item.put("contract_id", contract_id);

        List<Map<String, Object>> listPrePaid = new ArrayList<>();
        listPrePaid.add(item);

        Map<String, Object> param = new HashMap<>();
        param.put("reason", reason);
        param.put("list_pre_paid", listPrePaid);
        param.put("user_id", user_id);


        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/prePaid";

        ApiResult apiResult = apiService.sendPostJson(url,Json.toJson(param), token);
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
        telcoLog.setName("rechargePrepaid");
        telcoLog.setContent("Nạp tiền đóng cước trước");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getHistoryPrepayCharges() {
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
        String orderId  = (jsonGroup.get("orderId") != null) ? jsonGroup.get("orderId").asText() :"";
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
        param.put("orderId", orderId);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/telco/actionLog";

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
        telcoLog.setName("getHistoryPrepayCharges");
        telcoLog.setContent("Lịch sử đóng cước trước");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result payPostpaidBill(String userId) {
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

        return ok(views.html.telco.payPostpaidBill.PayPostpaidBill.render(userSession, userId));
    }
    // Nạp tiền thanh toán cước trả sau
    public Result payDebit() {
         AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup : {}", jsonGroup);
        String reason = (jsonGroup.get("reason") != null) ? jsonGroup.get("reason").asText() :"";
        String user_id = (jsonGroup.get("user_id") != null) ? jsonGroup.get("user_id").asText() :"";
        JsonNode contractsNode = jsonGroup.get("contracts");
        
        List<Map<String, Object>> contractsList = new ArrayList<>();
        
        if (contractsNode != null && contractsNode.isArray() && contractsNode.size() > 0) {
            for (JsonNode contractNode : contractsNode) {
                logger.info("contractNode : {}", contractNode);
                String contract_id = contractNode.hasNonNull("contract_id") ? contractNode.get("contract_id").asText() : "";
                int amount = contractNode.hasNonNull("amount") ? contractNode.get("amount").asInt() : 0;
                
                Map<String, Object> contractItem = new HashMap<>();
                contractItem.put("contract_id", contract_id);
                contractItem.put("amount", amount);
                
                contractsList.add(contractItem);
                logger.info("contract_id = {}, amount = {}", contract_id, amount);
            }
        } else {
            logger.warn("contracts is empty or missing!");
        }

        Map<String, Object> param = new HashMap<>();
        param.put("reason", reason);
        param.put("contracts", contractsList);
        param.put("user_id", user_id);


        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/payDebit";

        ApiResult apiResult = apiService.sendPostJson(url,Json.toJson(param), token);
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
        telcoLog.setName("payDebit");
        telcoLog.setContent("Nạp tiền thanh toán cước trả sau");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result payPostpaidBillDetail(String userId, String orderId) {
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

        return ok(views.html.telco.payPostpaidBill.PayPostpaidBill_detail.render(userSession, userId));
    }
    
    public Result getHistoryPayPostBill() {
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
        String contractId  = (jsonGroup.get("contractId") != null) ? jsonGroup.get("contractId").asText() :"";
        String orderId  = (jsonGroup.get("orderId") != null) ? jsonGroup.get("orderId").asText() :"";
        logger.info("offset :{} - limit :{}", startAt, pageSize);
        String user_id = jsonGroup.get("userId").asText();

        Map<String, String> param = new HashMap<>();
        param.put("actionCode", action);
        param.put("offset", Integer.toString(startAt));
        param.put("limit", Integer.toString(pageSize));
        param.put("userId", user_id);
        param.put("from", from);
        param.put("to", to);
        param.put("contractId", contractId);
        param.put("orderId", orderId);

        String token = "Bearer " + userSession.getToken();
        logger.info("token : {}", token);
        logger.info("param : {}", param);
        String url = appfileConfig.ulrBackendIot + "/api/telco/actionLog";

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
        telcoLog.setName("getHistoryPayPostBill");
        telcoLog.setContent("Lịch sử thanh toán trước trả sau");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
}
