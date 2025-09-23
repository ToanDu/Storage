package vn.m2m.iot.models;

import java.util.Date;

/**
 * Created by vtk-anhlt166 on 2/19/20.
 */
public class DevicePositionInitMarker {
    private String id;
    private String imei;
    private String idName;
    private String phonenb;
    private String name;
    private double currentLat ;
    private double currentLon ;
    private double rotation ;
    private int status;
    private Date dateTracking;
    private String sDateTracking;
    private String type;
    private float speed;
    private int trackingType;
    private int deviceType;
    private String serial;
    private String vin;
    private String stationCode;
    private double battery;
    private String nameGroup;

    public DevicePositionInitMarker(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getPhonenb() {
        return phonenb;
    }

    public void setPhonenb(String phonenb) {
        this.phonenb = phonenb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentLat() {
        return currentLat;
    }

    public void setCurrentLat(double currentLat) {
        this.currentLat = currentLat;
    }

    public double getCurrentLon() {
        return currentLon;
    }

    public void setCurrentLon(double currentLon) {
        this.currentLon = currentLon;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getsDateTracking() {
        return sDateTracking;
    }

    public void setsDateTracking(String sDateTracking) {
        this.sDateTracking = sDateTracking;
    }

    public int getTrackingType() {
        return trackingType;
    }

    public void setTrackingType(int trackingType) {
        this.trackingType = trackingType;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateTracking() {
        return dateTracking;
    }

    public void setDateTracking(Date dateTracking) {
        this.dateTracking = dateTracking;
    }
}
