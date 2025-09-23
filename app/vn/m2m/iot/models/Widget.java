package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ModelData(collection = "Widget", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class Widget implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String projectId;
    private String username;
    private String name;
    private String content;
    private Date logDate;
    private boolean active;
    private String token;
    private String orgId;
    private String orgName;

    private List<WidgetSize> widgetSizeList = new ArrayList<>();

    public Widget(){
        this.id = StringUtil.getTimeUUIDString();
        this.logDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<WidgetSize> getWidgetSizeList() {
        return widgetSizeList;
    }

    public void setWidgetSizeList(List<WidgetSize> widgetSizeList) {
        this.widgetSizeList = widgetSizeList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
