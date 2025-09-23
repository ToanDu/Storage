package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;

/**
 * Created by vtk-anhlt166 on 11/23/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoInvoiceController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result invoiceOfContract(String userId, String invoice) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.contract.invoice.InvoiceContract.render(userSession, invoice, userId));
    }

    public Result getListInvoiceOfContract() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String contractId = (jsonGroup.get("contractId") != null) ? jsonGroup.get("contractId").asText() :"";
        String billCycle = (jsonGroup.get("billCycle") != null) ? jsonGroup.get("billCycle").asText() :"";

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/debitInvoice?" + "contractId=" + contractId + "&billCycle=" + billCycle;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getListInvoiceOfContract : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getLinkDownloadInvoice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String invoiceNo = (jsonGroup.get("invoiceNo") != null) ? jsonGroup.get("invoiceNo").asText() :"";
        String invoiceDate = (jsonGroup.get("invoiceDate") != null) ? jsonGroup.get("invoiceDate").asText() :"";

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/invoiceFile?" + "invoiceNo=" + invoiceNo + "&invoiceDate=" + invoiceDate;
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getLinkDownloadInvoice : {}", Json.toJson(apiResult));

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
