package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vtk-anhlt166 on 7/27/22.
 */
@ModelData(collection = "RegisterDeveloper", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class RegisterDeveloper implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date logDate;
    private String ip;

    private String name;
    private String nameCompany;
    private String email;
    private String phone;

    private String role;
    private String field;
    private int countDevice;
    private int countUser;

    public RegisterDeveloper(){
        this.id = StringUtil.getTimeUUIDString();
        this.logDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getCountDevice() {
        return countDevice;
    }

    public void setCountDevice(int countDevice) {
        this.countDevice = countDevice;
    }

    public int getCountUser() {
        return countUser;
    }

    public void setCountUser(int countUser) {
        this.countUser = countUser;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
