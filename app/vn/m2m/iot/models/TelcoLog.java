package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vtk-anhlt166 on 12/20/22.
 */
@ModelData(collection = "TelcoLog", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class TelcoLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String username;
    private String name;
    private String content;
    private String action;
    private String url;
    private String param;
    private String body;
    private int statusCode;
    private String response;
    private Date logDate;

    public TelcoLog(){
        this.id = StringUtil.getTimeUUIDString();
        this.logDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
