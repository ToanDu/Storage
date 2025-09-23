package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.UserHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 6/14/22.
 */
@ModelData(collection = "TemplateDevice", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class TemplateDevice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String businessType;
    private String deviceType;
    private String deviceGroup;
    private String deviceName;
    private String protocols;
    private String urlImage;
    private List<TemplateDeviceAttribute> templateDeviceAttributeList = new ArrayList<>();

    public TemplateDevice(){
        this.id = UserHelper.generalUserID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(String deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    public String getProtocols() {
        return protocols;
    }

    public void setProtocols(String protocols) {
        this.protocols = protocols;
    }

    public List<TemplateDeviceAttribute> getTemplateDeviceAttributeList() {
        return templateDeviceAttributeList;
    }

    public void setTemplateDeviceAttributeList(List<TemplateDeviceAttribute> templateDeviceAttributeList) {
        this.templateDeviceAttributeList = templateDeviceAttributeList;
    }
}
