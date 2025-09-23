package vn.m2m.iot.form;

import models.forms.*;

import java.util.Date;

/**
 * Created by vtk-anhlt166 on 7/27/22.
 */
public class RegisterDeveloperForm extends models.forms.AbstractFormModel {
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

    public RegisterDeveloperForm(){}

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
}
