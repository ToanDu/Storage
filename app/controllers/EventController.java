package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import models.forms.UserForm;
import org.json.JSONArray;
import org.json.JSONObject;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.Event;
import vn.m2m.iot.models.Organization;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;

@Security.Authenticated(Secured.class)
public class EventController extends AbstractController {

    @Inject
    public ApiService apiService;

    @Inject
    public ObjectMapper mapper;

    public Result addNewEvent() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);

        String url = appfileConfig.ulrBackendIot + "/api/events";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("Create Event:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result addNewSchedule() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);

        String url = appfileConfig.ulrBackendIot + "/api/events/schedule";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("Create Schedule:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Addsuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.AddFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result editEvent(String idEvent) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);

        String url = appfileConfig.ulrBackendIot + "/api/events/"+idEvent;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPutJson(url, jsonGroup, token);
        logger.info("editEvent:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result editSchedule(String idEvent) {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);

        String url = appfileConfig.ulrBackendIot + "/api/events/schedule/"+idEvent;
        logger.info("url :{}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPutJson(url, jsonGroup, token);
        logger.info("editSchedule:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Updatefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result eventList(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        List<Event> eventList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/events";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetList = apiService.getByToken(url, token);

        if(apiGetList.isSuccess() && apiGetList.getResultStatus() == 200) {
            JsonNode jsonBody = apiGetList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("events");
            Event[] events = null;
            try {
                events = mapper.readValue(arr.toString(), Event[].class);
            } catch (IOException e) {
                logger.error("Get List Event:{}", e);
            }
            if (events != null) {
                eventList = Arrays.asList(events);
            }
        } else {
            if(apiGetList.getResultStatus() == 401){
                return redirect(routes.Application.logout());
            }
        }

        List<DeviceIot> deviceList = initDevices(userSession);

        //thêm organizationList
        List<Organization> organizationList = getOrganizationList(userSession);
        if(organizationList == null){
            return redirect(routes.Application.logout());
        }


        return ok(views.html.events.EventList.render(userSession, deviceList, eventList, organizationList));
    }

    public List<DeviceIot> initDevices(User userSession){
        List<DeviceIot> deviceList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/devices";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetList = apiService.getByToken(url, token);

        if(apiGetList.isSuccess() && apiGetList.getResultStatus() == 200) {
            JsonNode jsonBody = apiGetList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("devices");
            for (int i = 0; i < arr.length(); i++) {
                JsonNode node = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                if (node.get("id") != null) {
                    DeviceIot device = new DeviceIot();
                    device.setId(node.get("id").asText());
                    device.setName((node.get("name") != null) ? node.get("name").asText() : "");

                    deviceList.add(device);
                }

            }
        }
        return deviceList;

    }

    public Result getVarsByDevice(){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        String deviceId = request().queryString().get("deviceId")[0];

        String url = appfileConfig.ulrBackendIot + "/api/variables/" + deviceId;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetList = apiService.getByToken(url, token);


        if(apiGetList.isSuccess() && apiGetList.getResultStatus() == 200) {
            JsonNode jsonBody = apiGetList.getJsonData();
            return ok(jsonBody);
        }
        return ok(Json.toJson("{}"));

    }

    public Result deleteEvent() {
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
        String projectId = jsonGroup.get("projectId").asText();
        logger.debug("id event del :{}", id);

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("device.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String urlDeleteDevice = appfileConfig.ulrBackendIot + "/api/events/" + id + "?project_id="+projectId;
        String token = "Bearer " + userSession.getToken();

        ApiResult apiDelete= apiService.deleteByToken(urlDeleteDevice, token);
        logger.info("Delete Event:{}", Json.toJson(apiDelete));

        if(apiDelete.getResultStatus() >= 200 && apiDelete.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.Deletefalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result getEvent() {
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
        String projectId = jsonGroup.get("projectId").asText();

        if (org.springframework.util.StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("device.idEmpty"));
            return ok(Json.toJson(respone));
        }

        String url = appfileConfig.ulrBackendIot + "/api/events/" + id + "?project_id="+projectId;
        logger.info("url:{}", url);
        String token = "Bearer " + userSession.getToken();

        ApiResult apiGetSingle = apiService.getByToken(url, token);
        logger.info("get Event:{}", Json.toJson(apiGetSingle));

        if(apiGetSingle.getResultStatus() == 200){
            respone.setIssuccess(true);
            respone.setContent(apiGetSingle.getJsonData());
        } else {
            respone.setIssuccess(false);
        }
        return ok(Json.toJson(respone));
    }

    public Result updateEvent() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String eventId = jsonGroup.get("id").asText();

        if (org.springframework.util.StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }


        String urlUpdate = appfileConfig.ulrBackendIot + "/api/events/" + eventId;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiUpdate = apiService.sendPutJson(urlUpdate, Json.toJson(jsonGroup), token);
        logger.info("Update Event:{}", Json.toJson(urlUpdate));

        if(apiUpdate.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.Update.nothing"));
        }
        return ok(Json.toJson(respone));
    }

    public Result changeEventOrg(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String eventId = jsonGroup.get("eventId").asText();
        String orgId = jsonGroup.get("orgId").asText();

        String urlChangeEventOrg = appfileConfig.ulrBackendIot + "/api/events/"+eventId+"/organization/"+orgId;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        ApiResult apiChangeEventOrg = apiService.sendPost(urlChangeEventOrg, token);
        logger.info("Change Organization for event:{}", Json.toJson(apiChangeEventOrg));
        if(apiChangeEventOrg.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.ChangeSuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.ChangeFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result removeEventOrg(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String eventId = jsonGroup.get("eventId").asText();
        String orgId = jsonGroup.get("orgId").asText();

        String urlChangeEventOrg = appfileConfig.ulrBackendIot + "/api/events/"+eventId+"/organization/"+orgId;
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        ApiResult apiChangeEventOrg = apiService.deleteByToken(urlChangeEventOrg, token);
        logger.info("Remove Organization for event:{}", Json.toJson(apiChangeEventOrg));
        if(apiChangeEventOrg.getResultStatus() == 200){
            respone.setResultString(getMessages().at("noti.removeSuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.removeFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result activeEvent(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String eventId = jsonGroup.get("eventId").asText();

        String urlChangeEventOrg = appfileConfig.ulrBackendIot + "/api/events/"+eventId+"/active";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        ApiResult apiChangeEventOrg = apiService.sendPost(urlChangeEventOrg, token);
        logger.info("Active Event :{}", Json.toJson(apiChangeEventOrg));
        if(apiChangeEventOrg.getResultStatus() == 200){
            respone.setResultString(getMessages().at("event.activeSuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("event.activeFalse"));
        }
        return ok(Json.toJson(respone));
    }

    public Result deActiveEvent(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String eventId = jsonGroup.get("eventId").asText();

        String urlChangeEventOrg = appfileConfig.ulrBackendIot + "/api/events/"+eventId+"/deactive";
        String token = "Bearer " + userSession.getToken();
        Map<String, String> bodyData = new HashMap<>();
        ApiResult apiChangeEventOrg = apiService.sendPost(urlChangeEventOrg, token);
        logger.info("DeActive Event :{}", Json.toJson(apiChangeEventOrg));
        if(apiChangeEventOrg.getResultStatus() == 200){
            respone.setResultString(getMessages().at("event.deactiveSuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("event.deactiveFalse"));
        }
        return ok(Json.toJson(respone));
    }

    private List<Organization> getOrganizationList(User userSession){
        List<Organization> organizationList = new ArrayList<>();

        String url = appfileConfig.ulrBackendIot + "/api/organizations";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiGetOrganizationList = apiService.getByToken(url, token);

        if(apiGetOrganizationList.isSuccess() && apiGetOrganizationList.getResultStatus() == 200){
            JsonNode jsonBody = apiGetOrganizationList.getJsonData();
            JSONObject obj = new JSONObject(jsonBody.toString());
            JSONArray arr = obj.getJSONArray("organizations");
            if(arr.length() > 0){
                for (int i = 0; i < arr.length(); i++){
                    JsonNode org = ObjectUtil.jsonStrToJsonNode(arr.get(i).toString());

                    if(org.get("id") != null){
                        Organization organization = new Organization();
                        organization.setId(org.get("id").asText());
                        organization.setName(org.get("name").asText());

                        organizationList.add(organization);
                    }
                }
            }
        }else{
            if(apiGetOrganizationList.getResultStatus() == 401){
                return null;
            }
        }
        return organizationList;
    }

    public Result onclickEvent() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String eventId = jsonGroup.get("eventId").asText();
        String projectId = jsonGroup.get("eventId").asText();

        String url = appfileConfig.ulrBackendIot + "/api/events/"+eventId+"/activate?project_id="+projectId;
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.sendPostJson(url, jsonGroup, token);
        logger.info("onclickEvent:{}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        respone.setContent(apiResult.getJsonData());
        if(apiResult.getResultStatus() >= 200 && apiResult.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("Kích hoạt thành công"));
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Kích hoạt không thành công"));
        }
        return ok(Json.toJson(respone));
    }
}
