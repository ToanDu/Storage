package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.Logger;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.RegisterDeveloperDAO;
import vn.m2m.iot.models.RegisterDeveloper;
import vn.m2m.iot.models.WidgetMapData;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.*;


public class OrderSearchController extends AbstractController {
    @Inject
    public TelcoLogDAO telcoLogDAO;
    
    @Inject
    public ApiService apiService;

    public Result OrderSearchView() {
        User userSession = getUserSession();
//        if(userSession == null){
//            userSession = new User();
//        }

        return ok(views.html.orderSearch.OrderSearch.render(userSession));
    }
    
    public Result getSearchOrder(String orderId) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        Map<String, String> param = new HashMap<>();
        param.put("orderId", orderId);
     
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/noauth/order";
        logger.info("url : {}", url);
        ApiResult apiResult = apiService.getWithParams(url,"", param);
        logger.info("getSearchOrder : {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());

        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setContent(apiResult.getJsonData());
            respone.setResultString(getMessages().at("noti.Getsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Getfalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setName("getSearchOrder");
        telcoLog.setContent("Tim kiem don hang");
        telcoLog.setUrl(url);
        telcoLog.setParam(String.valueOf(param));
        telcoLog.setStatusCode(apiResult.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }
}