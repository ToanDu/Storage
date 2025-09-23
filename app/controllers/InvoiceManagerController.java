package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import java.util.HashMap;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class InvoiceManagerController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result invoiceManage(String userId){
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

        return ok(views.html.telco.invoice.Invoice.render(userSession, userId));
    }

    public Result getInvoices() {
        AbstractAjaxJsonModel response = new AbstractAjaxJsonModel();
        response.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        String token = "Bearer " + userSession.getToken();

        JsonNode bodyData = request().body().asJson();

        String _userId = bodyData.get("userId") != null ? bodyData.get("userId").asText() : ""; 
        String _from = bodyData.get("from") != null ? bodyData.get("from").asText() : ""; 
        String _to = bodyData.get("to") != null ? bodyData.get("to").asText() : ""; 
        String _limit = bodyData.get("limit") != null ? bodyData.get("limit").asText() : ""; 
        String _offset = bodyData.get("offset") != null ? bodyData.get("offset").asText() : ""; 

        Map<String, String> param = new HashMap<>();
        
        param.put("userId", _userId);
        param.put("from", _from);
        param.put("to", _to);
        param.put("limit", _limit);
        param.put("offset", _offset);
        if(bodyData.get("invoiceType").isNull() == false){
            param.put("invoiceType", bodyData.get("invoiceType").asText());
        }        
        if(bodyData.get("invoiceId").isNull() == false){
            param.put("invoiceId", bodyData.get("invoiceId").asText());
        }        
        if(bodyData.get("accountId").isNull() == false){
            param.put("accountId", bodyData.get("accountId").asText());
        }
        
        logger.info("param : {}", param);

        String url = appfileConfig.urlBackendIotTelco + "/api/telco/invoice";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url,token,param);

        logger.info("getInvoices : {}", Json.toJson(apiResult));
        response.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            response.setContent(apiResult.getJsonData());
            response.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            response.setIssuccess(false);
            response.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(response));
    }    
    public Result getInvoiceBase64() {
        AbstractAjaxJsonModel response = new AbstractAjaxJsonModel();
        response.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        String token = "Bearer " + userSession.getToken();

        JsonNode bodyData = request().body().asJson();
        String url;
        if (bodyData.has("listSaleTransId") && !bodyData.get("listSaleTransId").isNull()) {
            url = appfileConfig.urlBackendIotTelco + "/api/telco/invoice";
        } else {
            url = appfileConfig.urlBackendIotTelco + "/api/telco/invoice/billing";
        }
        
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, bodyData, token);

        logger.info("getInvoiceBase64 : {}", Json.toJson(apiResult));
        response.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            response.setContent(apiResult.getJsonData());
            response.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            response.setIssuccess(false);
            response.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(response));
    }


}
