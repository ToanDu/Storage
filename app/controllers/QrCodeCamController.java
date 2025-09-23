package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.springframework.util.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.QrCodeCamDAO;
import vn.m2m.iot.models.QrCodeCam;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 12/16/21.
 */
public class QrCodeCamController extends AbstractController {
    @Inject
    public QrCodeCamDAO qrCodeCamDAO;

    public Result qrCodeCam() {
        User userSession = userDAO.getByUsername("admin");

        List<QrCodeCam> qrCodeList = qrCodeCamDAO.getAll();

        return ok(views.html.qrCodeCam.QcCode.render(userSession, qrCodeList));
    }

    public Result createQrCodeCam() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String serial = jsonGroup.get("serial").asText();
        String mac = jsonGroup.get("mac").asText();
        String src = jsonGroup.get("src").asText();

        QrCodeCam qrCodeNew = new QrCodeCam();
        qrCodeNew.setSerial(serial);
        qrCodeNew.setMac(mac);
        qrCodeNew.setSrc(src);
        qrCodeCamDAO.save(qrCodeNew);

        respone.setResultString(getMessages().at("noti.Addsuccess") + getMessages().at(" - QR Code ") + serial);
        return ok(Json.toJson(respone));
    }

    public  Result deleteQrCodeCam(){
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        if(StringUtils.isEmpty(id)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.valid.id"));
            return ok(Json.toJson(respone));
        }

        QrCodeCam qrCode = qrCodeCamDAO.getByKey(id);
        if(qrCode == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.Deletefalse"));
            return ok(Json.toJson(respone));
        }

        qrCodeCamDAO.deleteByKey(id);

        respone.setResultString(getMessages().at("noti.Deletesuccess"));
        return ok(Json.toJson(respone));
    }
}
