package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
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
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Security.Authenticated(Secured.class)
public class WidgetListController extends AbstractController {
    @Inject
    public WidgetDAO widgetDAO;
    @Inject
    public ApiService apiService;

    //custom page dashboard
    public Result widgetPage(String projectId, String idDashboard) {
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        String url = appfileConfig.ulrBackendIot + "/api/projects/" + projectId;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiResult = apiService.getByToken(url, token);
        logger.debug("apiResult :{}", apiResult.getJsonData());

        String name = "";
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            name = apiResult.getJsonData().get("name").asText();
        }

        return ok(views.html.iot.dashboard.widget.WidgetList.render(userSession, projectId, idDashboard, name));
    }

    public Result saveWidgetData(){
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
        JSONObject obj = new JSONObject(jsonGroup.toString());
        JSONArray arr = new JSONArray();

        try {
            arr = obj.getJSONArray("widgetList");
        } catch (Exception e){
            e.printStackTrace();
            logger.info("JSONArray arr widgetList Exception");
        }

//        if(arr.length() == 0){
//            respone.setIssuccess(false);
//            respone.setErrorString(getMessages().at("widget.youNoCreateWidget"));
//            return ok(Json.toJson(respone));
//        }

        Widget widget = widgetDAO.getByUsername(userSession.getUsername());
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

                    widgetSizeList.add(widgetSize);
                }
            }
            widget.setWidgetSizeList(widgetSizeList);
            widgetDAO.save(widget);
        } else {
            Widget widgetNew = new Widget();
            widgetNew.setUsername(userSession.getUsername());

            List<WidgetSize> widgetSizeList = new ArrayList<>();
            if(arr.length() > 0){
                for (int i = 0; i < arr.length(); i++){
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

                    widgetSizeList.add(widgetSize);
                }
            }
            widgetNew.setWidgetSizeList(widgetSizeList);
            widgetDAO.save(widgetNew);
        }

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getWidgetCurrent(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Widget widget = widgetDAO.getByUsername(userSession.getUsername());
        if(widget != null){
            List<WidgetSize> widgetSizeList = widget.getWidgetSizeList();
            if(widgetSizeList.size() > 0){
                Collections.sort(widgetSizeList, new Comparator<WidgetSize>() {
                    public int compare(WidgetSize o1, WidgetSize o2) {
                        if (String.valueOf(o1.getY()) == null || String.valueOf(o2.getY()) == null) {
                            return 0;
                        }
                        return String.valueOf(o1.getY()).compareTo(String.valueOf(o2.getY()));
                    }
                });
            }
            widget.setWidgetSizeList(widgetSizeList);

            respone.setContent(widget);
            return ok(Json.toJson(respone));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("widget.notFound"));
            return ok(Json.toJson(respone));
        }
    }

}
