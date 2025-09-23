package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TemplateDeviceDAO;
import vn.m2m.iot.models.TemplateDevice;
import vn.m2m.iot.models.TemplateDeviceAttribute;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 11/18/21.
 */
@Security.Authenticated(Secured.class)
public class DeviceTemplateController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TemplateDeviceDAO templateDeviceDAO;

    public Result deviceTemplate(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.deviceTemplate.DeviceTemplate.render(userSession, projectId));
    }

    public Result getListDeviceTemplate() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();

        String url = appfileConfig.ulrBackendIot + "/api/templates";
        String token = "Bearer " + userSession.getToken();

        Map<String, String> param = new HashMap<>();
        param.put("project_id", projectId);

        logger.debug("param :{}", Json.toJson(param));

        ApiResult apiResult = apiService.getWithParams(url, token, param);
        logger.info("getListFlow:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result createDeviceTemplate() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String projectId = jsonGroup.get("projectId").asText();
        String name = jsonGroup.get("name").asText();
        String idFlow = jsonGroup.get("idFlow").asText();

        String url = appfileConfig.ulrBackendIot + "/api/templates";
        String token = "Bearer " + userSession.getToken();

        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("project_id", projectId);
        bodyData.put("name", name);
        bodyData.put("rule_chain_id", idFlow);

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(bodyData), token);
        logger.info("createDeviceTemplate:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deleteDeviceTemplate() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        logger.debug("id :{}", id);

        String url = appfileConfig.ulrBackendIot + "/api/templates/" + id;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.deleteByToken(url, token);
        logger.info("deleteDeviceTemplate:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    //tao thiet bi mau
    public Result createTemDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup:{}", jsonGroup);
        String id = jsonGroup.get("id").asText();
        String project_id = jsonGroup.get("project_id").asText();

        TemplateDevice templateDevice = templateDeviceDAO.getByKey(id);
        if(templateDevice == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy mẫu thiết bị"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/templates";
        String token = "Bearer " + userSession.getToken();

        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("project_id", project_id);
        bodyData.put("name", templateDevice.getDeviceName() + " " + (int )(Math.random() * 10000 + 1));
        logger.info("bodyData:{}", Json.toJson(bodyData));

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(bodyData), token);
        logger.info("createTemDevice:{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            String idTem = apiResult.getJsonData().get("id").asText();
            Map<String, Object> mapTemplate = new HashMap<>();
            mapTemplate.put("entity_id", idTem);
            mapTemplate.put("entity_type", "TEMPLATE");

            List<Object> attrList = new ArrayList<>();
            List<TemplateDeviceAttribute> templateDeviceAttributes = templateDevice.getTemplateDeviceAttributeList();
            if(templateDeviceAttributes.size() > 0){
                for(TemplateDeviceAttribute temAttr: templateDeviceAttributes){
                    Map<String, Object> attr = new HashMap<>();
                    attr.put("attribute_type", "SCOPE_SERVER");
                    attr.put("attribute_key", temAttr.getAttribute());
                    attr.put("logged", temAttr.isSaveLog());
                    attr.put("value", "");
                    attr.put("value_t", temAttr.getAttrType());

                    attrList.add(attr);
                }
            }
            mapTemplate.put("attributes", attrList);
            logger.info("mapTemplate:{}", Json.toJson(mapTemplate));

            String urlAtrr = appfileConfig.ulrBackendIot + "/api/attributes";
            ApiResult apiResultAttr = apiService.sendPostJson(urlAtrr, Json.toJson(mapTemplate), token);
            logger.info("create attr template device:{}", Json.toJson(apiResultAttr));
            if(apiResultAttr.getResultStatus() >= 200 && apiResultAttr.getResultStatus() <= 299){
                respone.setContent(apiResultAttr.getJsonData());
                respone.setResultString(getMessages().at("noti.Addsuccess"));
            } else {
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("noti.AddFalse"));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }
}
