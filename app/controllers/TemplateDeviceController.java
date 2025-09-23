package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.AbstractController;
import controllers.Secured;
import controllers.routes;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.TemplateDeviceDAO;
import vn.m2m.iot.models.TemplateDevice;
import vn.m2m.iot.models.TemplateDeviceAttribute;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 6/14/22.
 */
@Security.Authenticated(Secured.class)
public class TemplateDeviceController extends AbstractController {
    @Inject
    public TemplateDeviceDAO templateDeviceDAO;

    public Result templateDeviceList() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.admin.templateDevice.TemplateDeviceList.render(userSession));
    }

    public Result addTemplateDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String businessType = (jsonGroup.get("businessType") != null) ? jsonGroup.get("businessType").asText() : "";
        String deviceType = (jsonGroup.get("deviceType") != null) ? jsonGroup.get("deviceType").asText() : "";
        String deviceGroup = (jsonGroup.get("deviceGroup") != null) ? jsonGroup.get("deviceGroup").asText() : "";
        String deviceName = (jsonGroup.get("deviceName") != null) ? jsonGroup.get("deviceName").asText() : "";
        String protocols = (jsonGroup.get("protocols") != null) ? jsonGroup.get("protocols").asText() : "";
        String urlImage = (jsonGroup.get("urlImage") != null) ? jsonGroup.get("urlImage").asText() : "";

        List<TemplateDeviceAttribute> templateDeviceAttributeList = new ArrayList<>();
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arr = obj.getJSONArray("attributes");
        if(arr.length() > 0){
            for(Object object: arr){
                JsonNode attrs = ObjectUtil.jsonStrToJsonNode(object.toString());
                String attribute = (attrs.get("attribute") != null) ? attrs.get("attribute").asText() : "";
                String type = (attrs.get("type") != null) ? attrs.get("type").asText() : "";
                boolean checkbox = attrs.get("checkbox").asBoolean();
                String content = (attrs.get("content") != null) ? attrs.get("content").asText() : "";

                TemplateDeviceAttribute attributeDevice = new TemplateDeviceAttribute();
                attributeDevice.setAttribute(attribute);
                attributeDevice.setAttrType(type);
                attributeDevice.setSaveLog(checkbox);
                attributeDevice.setContentAttr(content);

                templateDeviceAttributeList.add(attributeDevice);
            }
        }

        TemplateDevice templateDevice = new TemplateDevice();
        templateDevice.setBusinessType(businessType);
        templateDevice.setDeviceType(deviceType);
        templateDevice.setDeviceName(deviceName);
        templateDevice.setDeviceGroup(deviceGroup);
        templateDevice.setProtocols(protocols);
        templateDevice.setUrlImage(urlImage);
        templateDevice.setTemplateDeviceAttributeList(templateDeviceAttributeList);
        templateDeviceDAO.save(templateDevice);

        respone.setResultString(getMessages().at("noti.Addsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result editTemplateDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";
        TemplateDevice templateDevice = templateDeviceDAO.getByKey(id);
        if(templateDevice == null){
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("Không tìm thấy template device"));
            return ok(Json.toJson(respone));
        }

        String businessType = (jsonGroup.get("businessType") != null) ? jsonGroup.get("businessType").asText() : "";
        String deviceType = (jsonGroup.get("deviceType") != null) ? jsonGroup.get("deviceType").asText() : "";
        String deviceGroup = (jsonGroup.get("deviceGroup") != null) ? jsonGroup.get("deviceGroup").asText() : "";
        String deviceName = (jsonGroup.get("deviceName") != null) ? jsonGroup.get("deviceName").asText() : "";
        String protocols = (jsonGroup.get("protocols") != null) ? jsonGroup.get("protocols").asText() : "";
        String urlImage = (jsonGroup.get("urlImage") != null) ? jsonGroup.get("urlImage").asText() : "";

        List<TemplateDeviceAttribute> templateDeviceAttributeList = new ArrayList<>();
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arr = obj.getJSONArray("attributes");
        if(arr.length() > 0){
            for(Object object: arr){
                JsonNode attrs = ObjectUtil.jsonStrToJsonNode(object.toString());
                String attribute = (attrs.get("attribute") != null) ? attrs.get("attribute").asText() : "";
                String type = (attrs.get("type") != null) ? attrs.get("type").asText() : "";
                boolean checkbox = attrs.get("checkbox").asBoolean();
                String content = (attrs.get("content") != null) ? attrs.get("content").asText() : "";

                TemplateDeviceAttribute attributeDevice = new TemplateDeviceAttribute();
                attributeDevice.setAttribute(attribute);
                attributeDevice.setAttrType(type);
                attributeDevice.setSaveLog(checkbox);
                attributeDevice.setContentAttr(content);

                templateDeviceAttributeList.add(attributeDevice);
            }
        }

        templateDevice.setBusinessType(businessType);
        templateDevice.setDeviceType(deviceType);
        templateDevice.setDeviceGroup(deviceGroup);
        templateDevice.setDeviceName(deviceName);
        templateDevice.setProtocols(protocols);
        templateDevice.setUrlImage(urlImage);
        templateDevice.setTemplateDeviceAttributeList(templateDeviceAttributeList);
        templateDeviceDAO.save(templateDevice);

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getListTemplateDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<TemplateDevice> templateDevices = templateDeviceDAO.getAll();

        respone.setContent(templateDevices);
        respone.setResultString(getMessages().at("noti.Getsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getTemplateDeviceById() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";

        TemplateDevice templateDevices = templateDeviceDAO.getByKey(id);
        if(templateDevices != null){
            respone.setContent(templateDevices);
            respone.setResultString(getMessages().at("noti.Getsuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
            return ok(Json.toJson(respone));
        }
    }

    public Result deleteTemplateDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";

        TemplateDevice templateDevices = templateDeviceDAO.getByKey(id);
        if(templateDevices == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy thiết bị mẫu"));
            return ok(Json.toJson(respone));
        }

        templateDeviceDAO.deleteByKey(id);

        respone.setResultString(getMessages().at("noti.Deletesuccess"));
        return ok(Json.toJson(respone));
    }
}
