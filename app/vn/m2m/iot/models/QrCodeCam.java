package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vtk-anhlt166 on 7/8/21.
 */
@ModelData(collection = "QrCodeCam", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class QrCodeCam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String serial;
    private String mac;
    private Date logDate;

    private String src;
    private String linkIos;
    private String linkAndroid;
    private String title;

    public QrCodeCam(){
        this.id = StringUtil.getTimeUUIDString();
        this.logDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
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
}
