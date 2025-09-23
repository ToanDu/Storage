package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.springframework.util.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.QrCodeDAO;
import vn.m2m.iot.dao.QrCodeHistoryDAO;
import vn.m2m.iot.models.QrCode;
import vn.m2m.iot.models.QrCodeHistory;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 7/7/21.
 */
public class QrCodeController extends AbstractController {
    @Inject
    public QrCodeDAO qrCodeDAO;
    @Inject
    public QrCodeHistoryDAO qrCodeHistoryDAO;

    public Result qrCode() {
        return ok(views.html.QrCodePage.QrCodePage.apply());
    }

    public Result qrCodeList() {
        User userSession = userDAO.getByUsername("admin");

        List<QrCode> qrCodeList = qrCodeDAO.getAll();

        return ok(views.html.QrCodePage.QrCodeList.render(userSession, qrCodeList));
    }

    public Result createQrCode() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String idDevice = jsonGroup.get("idDevice").asText();
        String name = jsonGroup.get("name").asText();
        String src = jsonGroup.get("src").asText();

        if(StringUtils.isEmpty(idDevice) || StringUtils.isEmpty(src)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }
        if(StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        QrCode qrCode = qrCodeDAO.getByKey(idDevice);
        if(qrCode != null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("qr.code.exited"));
            return ok(Json.toJson(respone));
        }

        QrCode qrCodeNew = new QrCode();
        qrCodeNew.setId(idDevice);
        qrCodeNew.setName(name);
        qrCodeNew.setSrc(src);
        qrCodeNew.setLinkAndroid(appfileConfig.urlAndroidVtag);
        qrCodeNew.setLinkIos(appfileConfig.urlIosVtag);
        qrCodeDAO.save(qrCodeNew);

        respone.setResultString(getMessages().at("noti.Addsuccess") + getMessages().at(" - QR Code ") + idDevice);
        return ok(Json.toJson(respone));
    }

    public Result qrCodeImg(String id) {
        QrCode qrCode = qrCodeDAO.getByKey(id);

        return ok(views.html.QrCodePage.QrCodeList_view.render(qrCode));
    }

    public Result getListQrCode() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<QrCode> qrCodeList = qrCodeDAO.getAll();

        return ok(Json.toJson(qrCodeList));
    }

    public Result editQrCode(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String name = jsonGroup.get("name").asText();
        String linkAndroid = (jsonGroup.get("linkAndroid")!= null) ? jsonGroup.get("linkAndroid").asText() : "";
        String linkIos = (jsonGroup.get("linkIos")!= null) ? jsonGroup.get("linkIos").asText() : "";

        if(StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }
        if(StringUtils.isEmpty(name)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.name"));
            return ok(Json.toJson(respone));
        }

        QrCode qrCode = qrCodeDAO.getByKey(id);
        if(qrCode == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notFoundData"));
            return ok(Json.toJson(respone));
        }

        QrCodeHistory qrCodeHistory = new QrCodeHistory(qrCode, "EDIT");
        qrCodeHistoryDAO.save(qrCodeHistory);

        qrCode.setName(name);
        qrCode.setLinkAndroid(linkAndroid);
        qrCode.setLinkIos(linkIos);
        qrCodeDAO.save(qrCode);

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

    public  Result deleteQrCode(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        if(StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        QrCode qrCode = qrCodeDAO.getByKey(id);
        if(qrCode == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
            return ok(Json.toJson(respone));
        }

        QrCodeHistory qrCodeHistory = new QrCodeHistory(qrCode, "DELETE");
        qrCodeHistoryDAO.save(qrCodeHistory);

        qrCodeDAO.deleteByKey(id);

        respone.setResultString(getMessages().at("noti.Deletesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result qrCodeHistoryList() {
        User userSession = userDAO.getByUsername("admin");

        List<QrCodeHistory> qrCodeHistories = qrCodeHistoryDAO.getAll();

        return ok(views.html.QrCodePage.QrCodeHistoryList.render(userSession, qrCodeHistories));
    }
}
