package vn.m2m.iot.form;

import vn.m2m.iot.models.DeviceIot;
import vn.m2m.utils.DateUtil;

import java.util.Date;

import static vn.m2m.utils.DateUtil.TIME_FORMAT_POSITION_MAP_SIDEBAR;


/**
 * Created by vtk-anhlt166 on 2/24/20.
 */
public class DeviceSocketForm {
    private String id;
    private String imei;
    private String name;
    private String serial;
    private double battery;
    private double ampe;
    private double temp;
    private double fuel;
    private double lat;
    private double lon;
    private int trackingType;
    private int status;
    private double rotation;
    private float speed;
    private Date dateTracking;
    private String sDateTracking;
    private int deviceType;
    private String stationCode;


    public DeviceSocketForm(){}

    public DeviceSocketForm(DeviceIot deviceIot, int webMapTimeLostConnectionMinutes){
        this.id = deviceIot.getId();
        this.imei = (deviceIot.getImei()!=null) ? deviceIot.getImei() : "";
        this.name = (deviceIot.getName()!=null) ? deviceIot.getName() : "";
        this.lat = deviceIot.getCurrentLat();
        this.lon = deviceIot.getCurrentLong();
        this.rotation =  0;
        this.dateTracking = deviceIot.getDateTracking();

        String sTime = DateUtil.convertDatetoString(deviceIot.getDateTracking(), TIME_FORMAT_POSITION_MAP_SIDEBAR);
        this.sDateTracking = sTime;

        this.battery = deviceIot.getBattery();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmpe() {
        return ampe;
    }

    public void setAmpe(double ampe) {
        this.ampe = ampe;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getTrackingType() {
        return trackingType;
    }

    public void setTrackingType(int trackingType) {
        this.trackingType = trackingType;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Date getDateTracking() {
        return dateTracking;
    }

    public void setDateTracking(Date dateTracking) {
        this.dateTracking = dateTracking;
    }

    public String getsDateTracking() {
        return sDateTracking;
    }

    public void setsDateTracking(String sDateTracking) {
        this.sDateTracking = sDateTracking;
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

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
}
