package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 10/4/22.
 */
@Security.Authenticated(Secured.class)
public class ManageSimController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result manageSim(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.pay.sim.ManageSim.render(userSession, projectId));
    }

    public Result detailSim(String projectId, String simnb) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.pay.sim.Sim.render(userSession, projectId, simnb));
    }

    public Result getDataCustomer() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String project_id = jsonGroup.get("project_id").asText().trim();
        String key = jsonGroup.get("key").asText().trim();
        int type = jsonGroup.get("type").asInt();

        String token = "Bearer " +userSession.getToken();
        String url = "http://vttapi.innoway.vn/api/flowEngine?timeout=15000&project_id="+project_id;
        logger.info("url : {}", url);

        Map<String, Object> bodyData = new HashMap<>();
        if(type == 1){//imei
            bodyData.put("request", "SearchByProperty");
            Map<String, Object> datas = new HashMap<>();
            datas.put("type", "imei");
            datas.put("query", key);
            bodyData.put("data", datas);
            logger.info("bodyData : {}", Json.toJson(bodyData));
        } else if(type == 2){
            bodyData.put("request", "SearchByProperty");
            Map<String, Object> datas = new HashMap<>();
            datas.put("type", "owner");
            datas.put("query", key);
            bodyData.put("data", datas);
            logger.info("bodyData : {}", Json.toJson(bodyData));
        } else if(type == 3){
            bodyData.put("request", "SearchByProperty");
            Map<String, Object> datas = new HashMap<>();
            datas.put("type", "isdn");
            datas.put("query", key);
            bodyData.put("data", datas);
            logger.info("bodyData : {}", Json.toJson(bodyData));
        } else if(type == 4){
            bodyData.put("request", "SearchByProperty");
            Map<String, Object> datas = new HashMap<>();
            datas.put("type", "esim");
            datas.put("query", key);
            bodyData.put("data", datas);
            logger.info("bodyData : {}", Json.toJson(bodyData));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa chọn kiểu tìm kiếm"));
            return ok(Json.toJson(respone));
        }

        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(bodyData), token);
        logger.info("getDataCustomer apiResult :{}", Json.toJson(apiResult));

        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        return ok(Json.toJson(respone));
    }
}
