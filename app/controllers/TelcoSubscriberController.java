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
import vn.m2m.utils.DateUtil;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 10/26/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoSubscriberController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result subscriberManage(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            logger.info("sessionSubscriberManage :{}", userSession);
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }
        logger.info("sessionSubscriberManage2 :{}", userSession);

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.subs.Subscriber.render(userSession, userId));
    }

    public Result getListSubscriber() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() : userSession.getId();
        String idNo = (jsonGroup.get("idNo") != null) ? jsonGroup.get("idNo").asText() :"";
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String serial = (jsonGroup.get("serial") != null) ? jsonGroup.get("serial").asText() :"";
        String accountId = (jsonGroup.get("accountId") != null) ? jsonGroup.get("accountId").asText() :"";
        String payType = (jsonGroup.get("payType") != null) ? jsonGroup.get("payType").asText() :"";
        String productCode = (jsonGroup.get("productCode") != null) ? jsonGroup.get("productCode").asText() :"";
        String actStatus = (jsonGroup.get("actStatus") != null) ? jsonGroup.get("actStatus").asText() :"";
        String promotionCode = (jsonGroup.get("promotionCode") != null) ? jsonGroup.get("promotionCode").asText() :"";
        String fromStaDatetime = (jsonGroup.get("fromStaDatetime") != null) ? jsonGroup.get("fromStaDatetime").asText() :"";
        String toStaDatetime = (jsonGroup.get("toStaDatetime") != null) ? jsonGroup.get("toStaDatetime").asText() :"";
        String fromActiveDatetime = (jsonGroup.get("fromActiveDatetime") != null) ? jsonGroup.get("fromActiveDatetime").asText() :"";
        String toActiveDatetime = (jsonGroup.get("toActiveDatetime") != null) ? jsonGroup.get("toActiveDatetime").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("idNo", idNo);
        param.put("isdn", isdn);
        param.put("serial", serial);
        param.put("accountId", accountId);
        param.put("payType", payType);
        param.put("productCode", productCode);
        param.put("actStatus", actStatus);
        param.put("promotionCode", promotionCode);
        param.put("rowNum", Integer.toString(pageSize));
        param.put("startAt", Integer.toString(startAt));
        param.put("fromStaDatetime", fromStaDatetime);
        param.put("toStaDatetime", toStaDatetime);
        param.put("fromActiveDatetime", fromActiveDatetime);
        param.put("toActiveDatetime", toActiveDatetime);
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/listSubscribe";
//        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("url : {}", url);
        logger.info("getListSubscriber : {}", Json.toJson(apiResult));
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
        telcoLog.setName("getListSubscriber");
        telcoLog.setContent("Lay danh sach thue bao");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListSubsByBeVht() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = (jsonGroup.get("userId") != null) ? jsonGroup.get("userId").asText() :"";
        String idNo = (jsonGroup.get("idNo") != null) ? jsonGroup.get("idNo").asText() :"";

        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";
        String serial = (jsonGroup.get("serial") != null) ? jsonGroup.get("serial").asText() :"";
        String accountId = (jsonGroup.get("accountId") != null) ? jsonGroup.get("accountId").asText() :"";
        String payType = (jsonGroup.get("payType") != null) ? jsonGroup.get("payType").asText() :"";
        String productCode = (jsonGroup.get("productCode") != null) ? jsonGroup.get("productCode").asText() :"";
        String actStatus = (jsonGroup.get("actStatus") != null) ? jsonGroup.get("actStatus").asText() :"";
        String status = (jsonGroup.get("status") != null) ? jsonGroup.get("status").asText() :"";
        String promotionCode = (jsonGroup.get("promotionCode") != null) ? jsonGroup.get("promotionCode").asText() :"";
        String fromStaDatetime = (jsonGroup.get("fromStaDatetime") != null) ? jsonGroup.get("fromStaDatetime").asText() :"";
        String toStaDatetime = (jsonGroup.get("toStaDatetime") != null) ? jsonGroup.get("toStaDatetime").asText() :"";
        String fromActiveDatetime = (jsonGroup.get("fromActiveDatetime") != null) ? jsonGroup.get("fromActiveDatetime").asText() :"";
        String toActiveDatetime = (jsonGroup.get("toActiveDatetime") != null) ? jsonGroup.get("toActiveDatetime").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 20;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("idNo", idNo);
        param.put("isdn", isdn);
        param.put("serial", serial);
        param.put("accountId", accountId);
        param.put("payType", payType);
        param.put("productCode", productCode);
        param.put("actStatus", actStatus);
        param.put("status", status);
        param.put("promotionCode", promotionCode);
        param.put("limit", Integer.toString(pageSize));
        param.put("offset", Integer.toString(startAt));

        SimpleDateFormat formater = new SimpleDateFormat(DateUtil.TIME_DATA_MAP);
        formater.setTimeZone(DateUtil.VN_GMT_7);
        if(!StringUtils.isEmpty(fromStaDatetime)){
            Date dateFromStaDatetime = DateUtil.convertStringtoDate(fromStaDatetime+",00:00",DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
            param.put("fromStaDatetime", String.valueOf(dateFromStaDatetime.getTime()/1000));
        }
        if(!StringUtils.isEmpty(toStaDatetime)){
            Date dateToStaDatetime = DateUtil.convertStringtoDate(toStaDatetime+",23:59",DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
            param.put("toStaDatetime", String.valueOf(dateToStaDatetime.getTime()/1000));
        }
        if(!StringUtils.isEmpty(fromActiveDatetime)){
            Date dateFromActiveDatetime = DateUtil.convertStringtoDate(fromActiveDatetime+",00:00",DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
            param.put("fromActiveDatetime", String.valueOf(dateFromActiveDatetime.getTime()/1000));
        }
        if(!StringUtils.isEmpty(toActiveDatetime)){
            Date dateToActiveDatetime = DateUtil.convertStringtoDate(toActiveDatetime+",23:59",DateUtil.TIME_DATA_MAP,DateUtil.VN_GMT_7);
            param.put("toActiveDatetime", String.valueOf(dateToActiveDatetime.getTime()/1000));
        }

        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/subscriber";
//        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("url : {}", url);
//        logger.info("getListSubsByBeVht : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListSubscriber");
        telcoLog.setContent("Lay danh sach thue bao");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getTotalSubscriber() {
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
        String serial = (jsonGroup.get("serial") != null) ? jsonGroup.get("serial").asText() :"";
        String accountId = (jsonGroup.get("accountId") != null) ? jsonGroup.get("accountId").asText() :"";
        String payType = (jsonGroup.get("payType") != null) ? jsonGroup.get("payType").asText() :"";
        String productCode = (jsonGroup.get("productCode") != null) ? jsonGroup.get("productCode").asText() :"";
        String actStatus = (jsonGroup.get("actStatus") != null) ? jsonGroup.get("actStatus").asText() :"";
        String promotionCode = (jsonGroup.get("promotionCode") != null) ? jsonGroup.get("promotionCode").asText() :"";
        String fromStaDatetime = (jsonGroup.get("fromStaDatetime") != null) ? jsonGroup.get("fromStaDatetime").asText() :"";
        String toStaDatetime = (jsonGroup.get("toStaDatetime") != null) ? jsonGroup.get("toStaDatetime").asText() :"";
        String fromActiveDatetime = (jsonGroup.get("fromActiveDatetime") != null) ? jsonGroup.get("fromActiveDatetime").asText() :"";
        String toActiveDatetime = (jsonGroup.get("toActiveDatetime") != null) ? jsonGroup.get("toActiveDatetime").asText() :"";

        Map<String, String> param = new HashMap<>();
        param.put("idNo", idNo);
        param.put("isdn", isdn);
        param.put("serial", serial);
        param.put("accountId", accountId);
        param.put("payType", payType);
        param.put("productCode", productCode);
        param.put("actStatus", actStatus);
        param.put("promotionCode", promotionCode);
        param.put("fromStaDatetime", fromStaDatetime);
        param.put("toStaDatetime", toStaDatetime);
        param.put("fromActiveDatetime", fromActiveDatetime);
        param.put("toActiveDatetime", toActiveDatetime);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/countSubscribe";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getTotalSubscriber : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getTotalSubscriber");
        telcoLog.setContent("Lay tong so thue bao");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //thong tin thue bao
    public Result subscriberDetail(String gpkd, String subs) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.subs.SubscriberDetail.render(userSession, subs, gpkd));
    }

    public Result getDetailSubscriber() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String phoneNum = (jsonGroup.get("phoneNum") != null) ? jsonGroup.get("phoneNum").asText() :"";

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/accountInfo?" + "&phoneNum=" + phoneNum;
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getDetailSubscriber : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDetailSubscriber");
        telcoLog.setContent("Lay chi tiet thue bao");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);
        return ok(Json.toJson(respone));
    }

    public Result getHybridInfo() {
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

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/hybridInfo?" + "isdn=" + isdn;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getHybridInfo : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getHybridInfo - DetailSubscriber");
        telcoLog.setContent("Thong tin tai khoan hybrid");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getCtkm() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String promotionCode = (jsonGroup.get("promotionCode") != null) ? jsonGroup.get("promotionCode").asText() :"";

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/discountPromotionByCodeAndType?" + "code=" + promotionCode + "&type=1";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token); 
        logger.info("getCtkm : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getCtkm - DetailSubscriber");
        telcoLog.setContent("Thong tin chuong trinh khuyen mai");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getBalanceInfo() {
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
        int payType = jsonGroup.get("payType").asInt();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/lstBalanceInfo?" + "isdn=" + isdn + "&payType="+payType;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getBalanceInfo : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getBalanceInfo - DetailSubscriber");
        telcoLog.setContent("Thong tin tai khoan goc");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getDebitSubscriber() {//cong no thue bao
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String isdns = (jsonGroup.get("isdns") != null) ? jsonGroup.get("isdns").asText() :"";

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/debitSubscriber?" + "isdns=" + isdns;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getDebitSubscriber : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getDebitSubscriber - DetailSubscriber");
        telcoLog.setContent("Thong tin cong no thue bao");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getKttkAndKtmi() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        Map<String, Object> returnData = new HashMap<>();

        JsonNode jsonGroup = request().body().asJson();
        String isdn = (jsonGroup.get("isdn") != null) ? jsonGroup.get("isdn").asText() :"";

        String token = "Bearer " + userSession.getToken();
        String urlKttk = appfileConfig.urlBackendIotTelco + "/api/telco/listDataPackage?" + "msisdn=84" + isdn + "&sendMt=0";
        logger.info("urlKttk : {}", urlKttk);
        ApiResult apiResultKttk = apiService.getByToken(urlKttk, token);
        logger.info("getKttk : {}", Json.toJson(apiResultKttk));
        respone.setStatus(apiResultKttk.getResultStatus());
        if(apiResultKttk.getResultStatus() >= 200 && apiResultKttk.getResultStatus() <= 299){
            respone.setContent(apiResultKttk.getJsonData());
        }

//        String urlKtmi = appfileConfig.ulrBackendIot + "/api/telco/ktmi?" + "msisdn=84" + isdn + "&sendSms=0";
//        ApiResult apiResultKtmi = apiService.getByToken(urlKtmi, token);
//        logger.info("getKtmi : {}", Json.toJson(apiResultKtmi));
//        if(apiResultKtmi.getResultStatus() >= 200 && apiResultKtmi.getResultStatus() <= 299){
//            returnData.put("ktmi", apiResultKtmi.getJsonData());
//        }
//        respone.setContent(returnData);

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getKttk - DetailSubscriber");
        telcoLog.setContent("Thong tin danh sach MI, Add-on");
        telcoLog.setUrl(urlKttk);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResultKttk.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResultKttk.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //chan thue bao - page tien ich
    public Result blockSubcriber() {
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
        String actionCode = (jsonGroup.get("actionCode") != null) ? jsonGroup.get("actionCode").asText() :"";
        String userId = jsonGroup.get("userId").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/blockSubscriber?staffCode=VTT1&shopCode=VT&actionCode="+actionCode+"&isdn=" + isdn + "&idNo=" + idNo + "&userId="+userId;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("blockSubcriber : {} - {}", isdn, Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("blockSubcriber");
        telcoLog.setContent("Chan chieu thue bao");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //mo thue bao - page tien ich
    public Result openSubcriber() {
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
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/openOneWay";
        logger.info("url : {}", url);

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
        telcoLog.setName("openSubcriber");
        telcoLog.setContent("Mo 1 chieu thue bao");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result open2wSubcriber() {
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
        String url = appfileConfig.ulrBackendIot + "/api/pricing/payment/telco/openTwoWay";
        logger.info("url : {}", url);

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
        telcoLog.setName("open2wSubcriber");
        telcoLog.setContent("Mo 2 chieu thue bao");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //ds goi cuoc su dung
    public Result getListProductOffering() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/lstProductOfferingBySpecChars";
        logger.info("url : {}", url);
        Map<String, Object> body = new HashMap<>();
        body.put("type_id", "200");
        List<String> properties = new ArrayList<>();
        properties.add("GOI_CUOC_DAC_THU");
        body.put("properties", properties);
        logger.info("body : {}", Json.toJson(body));
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("getListProductOffering : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListProductOffering");
        telcoLog.setContent("Danh sach goi cuoc dac thu");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(Json.toJson(body)));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getInfoDataAccount() {
//        String token1="";
//        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
//        respone.setIssuccess(true);
//        String urlLogin = appfileConfig.urlBackendIot2 + "/api/login";
//        logger.info("url login :{}", urlLogin);
//        Map<String, String> bodyData = new HashMap<>();
//        bodyData.put("identifier", "systemadmin05@test.com");
//        bodyData.put("password", "test1a@");
//        ApiResult loginGetToken = apiService.sendApiWithJson(urlLogin, Json.toJson(bodyData).toString());
//        logger.info("loginGetToken :{}", Json.toJson(loginGetToken));
//        if(loginGetToken.getResultStatus() == 200){
//            token1 = (loginGetToken.getJsonData().get("token") != null)
//                    ? loginGetToken.getJsonData().get("token").asText() : "";
//            logger.info("token login :{}", token1);
//        }
//        String token = "Bearer " + token1;
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        String token = "Bearer " + userSession.getToken();
        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
        String isdn = jsonGroup.get("isdn").asText();
        String serial = jsonGroup.get("serial").asText();
        String to = jsonGroup.get("to").asText();
        String monthly = jsonGroup.get("monthly").asText();
        String from = (jsonGroup.get("from") != null) ? jsonGroup.get("from").asText() :"";

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("isdn", isdn);
        param.put("serial", serial);
        param.put("monthly", monthly);
        if(to!=null && from!= null){
            param.put("to", to);
            param.put("from", from);
        }
        //String url = appfileConfig.urlBackendIot2 + "/api/telco/subscriber/usedData";
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/subscriber/usedData";
        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("url : {}", url);
//        logger.info("getListAccountCmp : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }


        return ok(Json.toJson(respone));
    }
}
