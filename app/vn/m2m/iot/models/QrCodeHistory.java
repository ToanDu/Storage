package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vtk-anhlt166 on 7/12/21.
 */
@ModelData(collection = "QrCodeHistory", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class QrCodeHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String idQr;
    private String name;
    private Date logDate;

    private String src;
    private String linkIos;
    private String linkAndroid;
    private String title;

    private String action;
    private Date createDate;

    public QrCodeHistory(){

    }

    public QrCodeHistory(QrCode qrCode, String action){
        this.id = StringUtil.getTimeUUIDString();
        this.idQr = qrCode.getId();
        this.name = qrCode.getName();
        this.logDate = qrCode.getLogDate();
        this.src = qrCode.getSrc();
        this.linkIos = qrCode.getLinkIos();
        this.linkAndroid = qrCode.getLinkAndroid();
        this.createDate = DateUtil.now();
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQr() {
        return idQr;
    }

    public void setIdQr(String idQr) {
        this.idQr = idQr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getLinkIos() {
        return linkIos;
    }

    public void setLinkIos(String linkIos) {
        this.linkIos = linkIos;
    }

    public String getLinkAndroid() {
        return linkAndroid;
    }

    public void setLinkAndroid(String linkAndroid) {
        this.linkAndroid = linkAndroid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
