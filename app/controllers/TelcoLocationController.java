package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
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

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Security.Authenticated(Secured.class)
public class TelcoLocationController extends AbstractController {
    @Inject
    public ApiService apiService;

    public TelcoLogDAO telcoLogDAO;


    public Result telcoLocation(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.telco.location.Location.render(userSession, userId));
    }

    public Result searchByIsdn() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        JsonNode jsonGroup = request().body().asJson();
        JsonNode arrIsdn = jsonGroup.get("isdns");
        Map<String, Object> body = new HashMap<>();
        body.put("isdns", arrIsdn);
        body.put("limit", 100);
        body.put("offset", 0);
        logger.info("body : {}", Json.toJson(body));
        String token = "Bearer "+userSession.getToken();
        String url = appfileConfig.ulrBackendIot + "/api/telco/subscriber/location/search";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(body), token);
        logger.info("searchByIsdn : {}", Json.toJson(apiResult));
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }
}
