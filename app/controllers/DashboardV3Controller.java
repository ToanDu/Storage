package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.WidgetDAO;
import vn.m2m.iot.models.Widget;
import vn.m2m.iot.models.WidgetSize;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 1/5/22.
 */
@Security.Authenticated(Secured.class)
public class DashboardV3Controller extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public WidgetDAO widgetDAO;

    public Result dashboardList(String projectId) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.dashboardV3.DashboardList.render(userSession, projectId));
    }

    public Result getListDashboard(){
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

        List<Widget> widgets = widgetDAO.getWidgetList(projectId, userSession.getUsername());
        respone.setContent(widgets);

        return ok(Json.toJson(respone));
    }

    public Result addNewDashboard(){
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
        String content = jsonGroup.get("content").asText();

        Widget widget = new Widget();
        widget.setProjectId(projectId);
        widget.setUsername(userSession.getUsername());
        widget.setName(name);
        widget.setContent(content);
        widgetDAO.save(widget);

        respone.setResultString(getMessages().at("noti.Addsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result editContentDashboard(){
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
        String name = jsonGroup.get("name").asText();
        String content = jsonGroup.get("content").asText();

        Widget widget = widgetDAO.getByKey(id);
        if(widget != null){
            widget.setName(name);
            widget.setContent(content);
            widgetDAO.save(widget);
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
            return ok(Json.toJson(respone));
        }

        respone.setResultString(getMessages().at("noti.Addsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result deleteDashboard(){
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

        Widget widget = widgetDAO.getByKey(id);
        if(widget != null){
            widgetDAO.deleteByKey(id);

            respone.setResultString(getMessages().at("noti.Deletesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
            return ok(Json.toJson(respone));
        }
    }

    //dashboard detail
    public Result dashboard(String projectId, String idDashboard) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.dashboard.DashboardVer2.render(userSession, projectId, idDashboard));
    }

    public Result getDashboardWithId(){
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

        Widget widget = widgetDAO.getByKey(id);
        if(widget != null){
            respone.setContent(widget);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
            return ok(Json.toJson(respone));
        }
    }

    public Result saveDashboard(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.debug("jsonGroup : {}", jsonGroup);
        String id = jsonGroup.get("id").asText();
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arr = new JSONArray();

        try {
            arr = obj.getJSONArray("widgetList");
        } catch (Exception e){
            e.printStackTrace();
            logger.info("JSONArray arr widgetList Exception");
        }

        Widget widget = widgetDAO.getByKey(id);
        if(widget != null){
            List<WidgetSize> widgetSizeList = new ArrayList<>();

            if(arr.length() > 0){
                for (int i = 0; i < arr.length(); i ++){
                    JsonNode widgetSizeJson = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    WidgetSize widgetSize = new WidgetSize();
                    widgetSize.setX(widgetSizeJson.get("x").asInt());
                    widgetSize.setY(widgetSizeJson.get("y").asInt());
                    widgetSize.setW(widgetSizeJson.get("w").asInt());
                    widgetSize.setH(widgetSizeJson.get("h").asInt());
                    widgetSize.setType(widgetSizeJson.get("type").asInt());
                    widgetSize.setOrgId(widgetSizeJson.get("org").asText());
                    widgetSize.setId(widgetSizeJson.get("id").asText());
                    widgetSize.setFilter(widgetSizeJson.get("filter").asText());
                    widgetSize.setFilterValue(widgetSizeJson.get("filterValue").asText());
                    widgetSize.setData(widgetSizeJson.get("data").asText());
                    widgetSize.setTitle(widgetSizeJson.get("title").asText());
                    widgetSize.setUnit(widgetSizeJson.get("unit").asText());
                    widgetSize.setMaxValue(widgetSizeJson.get("maxValue").asDouble());
                    widgetSize.setTopic(widgetSizeJson.get("topic").asText());
                    widgetSize.setCmdon(widgetSizeJson.get("cmdon").asText());
                    widgetSize.setCmdoff(widgetSizeJson.get("cmdoff").asText());
                    widgetSize.setTypeMap(widgetSizeJson.get("typeMap").asInt());

                    widgetSizeList.add(widgetSize);
                }
            }
            widget.setWidgetSizeList(widgetSizeList);
            widget.setToken(userSession.getToken());
            widgetDAO.save(widget);

            respone.setResultString(getMessages().at("noti.Updatesuccess"));
            return ok(Json.toJson(respone));
        } else {
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
            respone.setIssuccess(false);
            return ok(Json.toJson(respone));
        }
    }

    public Result moveDashboardToOrg(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String dashboardId = jsonGroup.get("dashboardId").asText();
        String idOrg = jsonGroup.get("idOrg").asText();
        String nameOrg = jsonGroup.get("nameOrg").asText();

        if(StringUtils.isEmpty(idOrg)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa chọn tổ chức"));
            return ok(Json.toJson(respone));
        }

        Widget widget = widgetDAO.getByKey(dashboardId);
        if(widget == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy dashboard"));
            return ok(Json.toJson(respone));
        }

        Widget widgetOrg = widgetDAO.getByOrgId(idOrg);
        if(widgetOrg != null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Dashboard đã đc gán vào tổ chức rồi"));
            return ok(Json.toJson(respone));
        }

        widget.setOrgId(idOrg);
        widget.setOrgName(nameOrg);
        widgetDAO.save(widget);

        respone.setResultString(getMessages().at("Cập nhật thành công"));
        return ok(Json.toJson(respone));
    }
}
