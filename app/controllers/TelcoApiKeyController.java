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
import vn.m2m.utils.DateUtil;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 10/26/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoApiKeyController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result apiKeyManage(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()) {
            if (!userId.equals(userSession.getId())) {
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.apiKey.ApiKey.render(userSession, userId));
    }
    public Result getListApiKey() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Map<String, String> param = new HashMap<>();
        logger.info("param : {}", Json.toJson(param));
        String token = "Bearer " + userSession.getToken();
//        String url = appfileConfig.ulrBackendIotTelco + "/api/telco/listSubscribe?" + "idNo=" + idNo;
        String url = appfileConfig.urlBackendIotTelco + "/api/tenant/apikey";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        ApiResult apiResult = apiService.getByToken(url, token);
        logger.info("getListApiKey : {}", Json.toJson(apiResult));

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