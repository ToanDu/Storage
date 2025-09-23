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
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 3/2/23.
 */
@Security.Authenticated(Secured.class)
public class TelcoRoleAccountController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result accountList() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.role.account.AccountList.render(userSession));
    }

    public Result getListAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String email = (jsonGroup.get("email") != null) ? jsonGroup.get("email").asText() :"";
        String cmpRole = (jsonGroup.get("cmpRole") != null) ? jsonGroup.get("cmpRole").asText() :"";
//        String enterpriseName = (jsonGroup.get("enterpriseName") != null) ? jsonGroup.get("enterpriseName").asText() :"";
//        String businessLicense = (jsonGroup.get("businessLicense") != null) ? jsonGroup.get("businessLicense").asText() :"";

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, String> param = new HashMap<>();
//        param.put("enterpriseName", enterpriseName);
//        param.put("businessLicense", businessLicense);
        param.put("email", email);
        param.put("cmpRole", cmpRole);
        param.put("offset", String.valueOf(startAt));
        param.put("limit", String.valueOf(pageSize));
        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp";
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

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getListAccountCmp");
        telcoLog.setContent("Lay danh sach tai khoan CMP");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result addAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String cmp_role = jsonGroup.get("cmp_role").asText();
        String phone = jsonGroup.get("phone").asText();
        String email = jsonGroup.get("email").asText();

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("cmp_role", cmp_role);
        param.put("phone", phone);
        param.put("email", email);
        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp";
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(param), token);
        logger.info("url : {}", url);
        logger.info("addAccountCmp : {}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            String identity_id = apiResult.getJsonData().get("identity_id").asText();
            if(!StringUtils.isEmpty(identity_id)){
                JSONObject obj = new JSONObject(jsonGroup.toString());
                JSONArray listEnterpriseArr = obj.getJSONArray("listEnterprise");
                if(listEnterpriseArr.length() > 0){
                    List<Object> listdata = new ArrayList<>();
                    for(int i=0; i<listEnterpriseArr.length(); i++) {
                        listdata.add(ObjectUtil.jsonStrToJsonNode(listEnterpriseArr.get(i).toString()));
                    }
                    logger.info("listdata : {}", listdata);
                    Map<String, Object> body = new HashMap<>();
                    body.put("user_id", identity_id);
                    body.put("data", listdata);
                    logger.info("bodyData : {}", Json.toJson(body));

                    String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise/bulk";
                    ApiResult apiResult_enterprise = apiService.sendPostJson(url_enterprise, Json.toJson(body), token);
                    logger.info("url_enterprise : {}", url_enterprise);
                    logger.info("apiResult_enterprise : {}", Json.toJson(apiResult_enterprise));
                    respone.setContent(apiResult_enterprise.getJsonData());
                    if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
                        respone.setResultString(getMessages().at("noti.Addsuccess"));
                    } else {
                        respone.setResultString(getMessages().at("Tạo danh sách doanh nghiệp không thành công"));
                    }
                }
            } else {
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("noti.AddFalse"));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("addAccountCmp");
        telcoLog.setContent("Tao tai khoan user CMP");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result addAccountCmpV2() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String cmp_role = jsonGroup.get("cmp_role").asText();
        String phone = jsonGroup.get("phone").asText();
        String email = jsonGroup.get("email").asText();
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray listEnterpriseArr = obj.getJSONArray("listEnterprise");
        List<Object> listdata = new ArrayList<>();
        for(int i=0; i<listEnterpriseArr.length(); i++) {
            listdata.add(ObjectUtil.jsonStrToJsonNode(listEnterpriseArr.get(i).toString()));
        }

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("cmp_role", cmp_role);
        param.put("phone", phone);
        param.put("email", email);
        param.put("data", listdata);

        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmpV2";
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(param), token);
        logger.info("url : {}", url);
        logger.info("addAccountCmp : {}", Json.toJson(apiResult));

        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            String identity_id = apiResult.getJsonData().get("identity_id").asText();
//            if(!StringUtils.isEmpty(identity_id)){
//                JSONObject obj = new JSONObject(jsonGroup.toString());
//                JSONArray listEnterpriseArr = obj.getJSONArray("listEnterprise");
//                if(listEnterpriseArr.length() > 0){
//                    List<Object> listdata = new ArrayList<>();
//                    for(int i=0; i<listEnterpriseArr.length(); i++) {
//                        listdata.add(ObjectUtil.jsonStrToJsonNode(listEnterpriseArr.get(i).toString()));
//                    }
//                    logger.info("listdata : {}", listdata);
//                    Map<String, Object> body = new HashMap<>();
//                    body.put("user_id", identity_id);
//                    body.put("data", listdata);
//                    logger.info("bodyData : {}", Json.toJson(body));
//
//                    String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise/bulk";
//                    ApiResult apiResult_enterprise = apiService.sendPostJson(url_enterprise, Json.toJson(body), token);
//                    logger.info("url_enterprise : {}", url_enterprise);
//                    logger.info("apiResult_enterprise : {}", Json.toJson(apiResult_enterprise));
//                    respone.setContent(apiResult_enterprise.getJsonData());
//                    if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
//                        respone.setResultString(getMessages().at("noti.Addsuccess"));
//                    } else {
//                        respone.setResultString(getMessages().at("Tạo danh sách doanh nghiệp không thành công"));
//                    }
//                }
//            } else {
//                respone.setIssuccess(false);
//                respone.setErrorString(getMessages().at("noti.AddFalse"));
//            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("addAccountCmp");
        telcoLog.setContent("Tao tai khoan user CMP");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result addAccountCmp1() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String cmp_role = jsonGroup.get("cmp_role").asText();
        String phone = jsonGroup.get("phone").asText();
        String email = jsonGroup.get("email").asText();
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray listEnterpriseArr = obj.getJSONArray("listEnterprise");

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("cmp_role", cmp_role);
        param.put("phone", phone);
        param.put("email", email);
        param.put("data", listEnterpriseArr);
        logger.info("param : {}", Json.toJson(param));

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp";
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(param), token);
        logger.info("url : {}", url);
        logger.info("addAccountCmp : {}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("addAccountCmp");
        telcoLog.setContent("Tao tai khoan user CMP");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    //info account cmp
    public Result infoAccountCmp(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.role.account.InfoAccountCmp.render(userSession, userId));
    }

    public Result getInfoAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        Map<String, String> param = new HashMap<>();
        JsonNode jsonGroup = request().body().asJson();
        String user_id = jsonGroup.get("user_id").asText();

        if(jsonGroup.get("businessLicense") != null){
            logger.info("businessLicenseTNull", "0");
            String businessLicense = jsonGroup.get("businessLicense").asText();
            param.put("businessLicense", String.valueOf(businessLicense));
        }

        int page = (jsonGroup.get("page") != null) ? jsonGroup.get("page").asInt(): 1;
        int pageSize = (jsonGroup.get("pageSize") != null) ? jsonGroup.get("pageSize").asInt(): 10;
        int startAt = (page-1)*pageSize;
        logger.info("startAt :{} - pageSize :{}", startAt, pageSize);

        Map<String, Object> data = new HashMap<>();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/"+user_id+"/enterprise";

        param.put("offset", String.valueOf(startAt));
        param.put("limit", String.valueOf(pageSize));

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("url : {}", url);
        logger.info("getInfoAccountCmp : {}", apiResult.getJsonData());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            data.put("enterprises", apiResult.getJsonData());
        }

        String url_2 = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+user_id;
        ApiResult apiResult_2 = apiService.getByToken(url_2, token);
        logger.info("url : {}", url_2);
        logger.info("getInfoAccountCmp : {}", apiResult_2.getJsonData());
        respone.setStatus(apiResult_2.getResultStatus());
        if(apiResult_2.getResultStatus() >= 200 && apiResult_2.getResultStatus() <= 299){
            data.put("info", apiResult_2.getJsonData());
        }

        respone.setContent(data);

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("getInfoAccountCmp");
        telcoLog.setContent("Lay ds doanh nghiep cua tai khoan CMP");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(respone));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result generatePassAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String user_id = jsonGroup.get("user_id").asText();

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/"+user_id+"/password";
        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("url : {}", url);
        logger.info("generatePassAccountCmp : {}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("generatePassAccountCmp");
        telcoLog.setContent("Lay pass tai khoan CMP");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result addEnterpriseBySAdmin() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
//        String user_id = jsonGroup.get("user_id").asText();

        String token = "Bearer " + userSession.getToken();
        String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise/bulk";
        ApiResult apiResult_enterprise = apiService.sendPostJson(url_enterprise, jsonGroup, token);
        logger.info("url_enterprise : {}", url_enterprise);
        logger.info("addEnterpriseBySAdmin : {}", Json.toJson(apiResult_enterprise));
        respone.setContent(apiResult_enterprise.getJsonData());
        if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));

        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Tạo doanh nghiệp không thành công"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("addEnterpriseBySAdmin");
        telcoLog.setContent("Tao doanh nghiep cho admin / dai ly");
        telcoLog.setUrl(url_enterprise);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult_enterprise.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult_enterprise.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result addEnterpriseByAdminOrSEnterprise() {
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
        String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise";
        ApiResult apiResult_enterprise = apiService.sendPostJson(url_enterprise, jsonGroup, token);
        logger.info("url_enterprise : {}", url_enterprise);
        logger.info("addEnterpriseByAdminOrSEnterprise : {}", Json.toJson(apiResult_enterprise));
        respone.setContent(apiResult_enterprise.getJsonData());

        if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Tạo doanh nghiệp không thành công"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("addEnterpriseByAdminOrSEnterprise");
        telcoLog.setContent("Admin / dai ly tao them doanh nghiep");
        telcoLog.setUrl(url_enterprise);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult_enterprise.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult_enterprise.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result deleteEnterprise() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String enterpriseId = jsonGroup.get("enterpriseId").asText();

        String token = "Bearer " + userSession.getToken();
        String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise/"+enterpriseId;
        ApiResult apiResult_enterprise = apiService.deleteByToken(url_enterprise, token);
        logger.info("url_enterprise : {}", url_enterprise);
        logger.info("deleteEnterprise : {}", Json.toJson(apiResult_enterprise));
        if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("deleteEnterprise");
        telcoLog.setContent("Xoa doanh nghiep trong admin / dai ly");
        telcoLog.setUrl(url_enterprise);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult_enterprise.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult_enterprise.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result editEnterprise() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String name = jsonGroup.get("name").asText();
        String gpkd = jsonGroup.get("business_license").asText();

        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("business_license", gpkd);

        String token = "Bearer " + userSession.getToken();
        String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise/"+id;
        ApiResult apiResult_enterprise = apiService.putJson(url_enterprise, Json.toJson(body), token);
        logger.info("url_enterprise : {}", url_enterprise);
        logger.info("editEnterprise : {}", Json.toJson(apiResult_enterprise));
        respone.setContent(apiResult_enterprise.getJsonData());
        if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("editEnterprise");
        telcoLog.setContent("Sua thong tin doanh nghiep cho admin / dai ly");
        telcoLog.setUrl(url_enterprise);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult_enterprise.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult_enterprise.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result updateEnterprise() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String name = jsonGroup.get("name").asText();
        String phone = jsonGroup.get("phone").asText();

        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("phone", phone);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+id;
        ApiResult apiResult = apiService.putJson(url, Json.toJson(body), token);
        logger.info("url : {}", url);
        logger.info("editEnterprise : {}", Json.toJson(apiResult));
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("updateEnterprise");
        telcoLog.setContent("Cap nhat thong tin tai khoan cho admin / dai ly");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result deleteAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        if(StringUtils.isEmpty(userId)){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.notFoundUser"));
            return ok(Json.toJson(respone));
        }

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+userId;
        ApiResult apiResult = apiService.deleteByToken(url, token);
        logger.info("url : {}", url);
        logger.info("deleteAccountCmp : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("deleteAccountCmp");
        telcoLog.setContent("Xoa tai khoan CMP");
        telcoLog.setUrl(url);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result validateGpkd() {
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
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/idNo/validate";

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("validateGpkd");
        telcoLog.setContent("Kiem tra GPKD hop le ");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result checkValidateGpkd() {
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
        String url =appfileConfig.ulrBackendIot + "/api/users/validateGpkdExist";

        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("validateGpkd");
        telcoLog.setContent("Kiem tra GPKD hop le ");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(jsonGroup));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result updatRoleAccountCmp() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
        String cmp_role = jsonGroup.get("cmp_role").asText();

        Map<String, String> body = new HashMap<>();
        body.put("cmp_role", cmp_role);

        String token = "Bearer " + userSession.getToken();
        String url = appfileConfig.urlBackendIotTelco + "/api/users/cmp/"+userId;
        ApiResult apiResult = apiService.putJson(url, Json.toJson(body), token);
        logger.info("url : {}", url);
        logger.info("apiResult : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("updateRoleAccountCmp");
        telcoLog.setContent("Sua quyen tai khoan");
        telcoLog.setUrl(url);
        telcoLog.setBody(String.valueOf(body));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
}
