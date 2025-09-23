package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ModelData(collection = "DeviceType", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class DeviceType implements Serializable {
    private static final long serialVersionUID = 1L; //1L

    @Id
    private String id;
    private String name;
    private String organization;
    private String organizationName;
    private List<DeviceVariable> attrList = new ArrayList<DeviceVariable>();

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public DeviceType(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public List<DeviceVariable> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<DeviceVariable> attrList) {
        this.attrList = attrList;
    }
}
