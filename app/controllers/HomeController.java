package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.WidgetDAO;
import vn.m2m.iot.models.Widget;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;

import javax.inject.Inject;
import java.io.File;
import java.util.List;

public class HomeController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public WidgetDAO widgetDAO;

    public Result getImg(String id){
        String path = appfileConfig.contentFolderImage;
        return ok().sendFile(new File(path + id));
    }

    public Result pageTestApi(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.TestApi.render(userSession));
    }

    public Result testPostFormUrlencoded(){
        JsonNode jsonGroup = request().body().asJson();
        String url = jsonGroup.get("url").asText();
        String data = jsonGroup.get("data").asText();

        ApiResult apiGetGroupList = apiService.sendApiWithFormUrlencoded(url, data);

        return ok(Json.toJson(apiGetGroupList));
    }

    public Result testPostJson(){
        JsonNode jsonGroup = request().body().asJson();
        String url = jsonGroup.get("url").asText();
        String data = jsonGroup.get("data").asText();

        ApiResult apiGetGroupList = apiService.sendApiWithJson(url, data);

        return ok(Json.toJson(apiGetGroupList));
    }

    public Result testGetByToken(){
        JsonNode jsonGroup = request().body().asJson();
        String url = jsonGroup.get("url").asText();
        String token = jsonGroup.get("token").asText();

        ApiResult apiGetGroupList = apiService.getByToken(url, token);

        return ok(Json.toJson(apiGetGroupList));
    }

    public Result success(){
        return ok("");
    }
    public Result cancel(){
        return ok("");
    }

    public Result provision(){
        return ok(views.html.Provision.apply());
    }

    public Result getDashboardByIdOrg(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("getDashboardByIdOrg :{}", jsonGroup);
        String idOrg = jsonGroup.get("idOrg").asText();

        if(StringUtils.isEmpty(idOrg)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy tổ chức"));
            return ok(Json.toJson(respone));
        }

        Widget widgetOrg = widgetDAO.getByOrgId(idOrg);
        if(widgetOrg == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Tổ chức chưa có dashboard"));
            return ok(Json.toJson(respone));
        }

        String url = "/appDashboard/"+widgetOrg.getProjectId()+"/"+widgetOrg.getId();
        respone.setContent(url);
        return ok(Json.toJson(respone));
    }

    public Result getDashboardByProjectId(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("getDashboardByIdOrg :{}", jsonGroup);
        String projectId = jsonGroup.get("projectId").asText();

        if(StringUtils.isEmpty(projectId)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy dự án"));
            return ok(Json.toJson(respone));
        }

        List<Widget> widgetOrg = widgetDAO.getWidgetListByProjectId(projectId);

        respone.setContent(widgetOrg);
        return ok(Json.toJson(respone));
    }

    public Result termsOfUse(){
        return ok(views.html.telco.TermOfUse.apply());
    }

    public Result pageSuccess(){
        return ok(views.html.telco.PageSuccess.apply());
    }
}
