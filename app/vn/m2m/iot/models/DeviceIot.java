package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 4/2/21.
 */
@ModelData(collection = "DeviceIot", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class DeviceIot implements Serializable {
    private static final long serialVersionUID = 1L; //1L

    @Id
    private String id;
    private String imei;
    private String name;

    private double currentLat;
    private String keyLatitude;
    private double currentLong;
    private String keyLongitude;
    private double battery;
    private String keyBattery;

    private String groupId; //org
    private String[] groupPath;
    private String groupName;
    private String orgID;
    private String orgName;

    private String groupChildId;
    private String groupChildName;

    private String typeID;
    private String typeName;

    private List<DeviceVariable> variables;

    private Date createDate;
    private Date logDate;
    private Date dateTracking;

    private int deviceType; //1=vtag

    private boolean status;

    public enum Types {
        none(0),
        vtag(1);

        private final int code;

        private static final Map<Integer, Types> roleByCode = new HashMap<Integer, Types>();

        static {
            for(Types role: Types.values()){
                roleByCode.put(role.getCode(),role);
            }
        }

        private Types(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name();
        }

        public static Types fromCode(int code){
            return roleByCode.get(code);
        }

        public static String getNameByCode(int code){
            Types role = roleByCode.get(code);
            if(role!=null){
                return role.getName();
            }
            return "";
        }

    }

    public DeviceIot() {
        this.createDate = DateUtil.now();
        this.logDate = DateUtil.now();
    }

    public DeviceIot(String id) {
        this.id = id;
        this.createDate = DateUtil.now();
        this.logDate = DateUtil.now();
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

    public double getCurrentLat() {
        return currentLat;
    }

    public void setCurrentLat(double currentLat) {
        this.currentLat = currentLat;
    }

    public double getCurrentLong() {
        return currentLong;
    }

    public void setCurrentLong(double currentLong) {
        this.currentLong = currentLong;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String[] getGroupPath() {
        return groupPath;
    }

    public void setGroupPath(String[] groupPath) {
        this.groupPath = groupPath;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public Date getDateTracking() {
        return dateTracking;
    }

    public void setDateTracking(Date dateTracking) {
        this.dateTracking = dateTracking;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getKeyLatitude() {
        return keyLatitude;
    }

    public void setKeyLatitude(String keyLatitude) {
        this.keyLatitude = keyLatitude;
    }

    public String getKeyLongitude() {
        return keyLongitude;
    }

    public void setKeyLongitude(String keyLongitude) {
        this.keyLongitude = keyLongitude;
    }

    public String getKeyBattery() {
        return keyBattery;
    }

    public void setKeyBattery(String keyBattery) {
        this.keyBattery = keyBattery;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DeviceVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<DeviceVariable> variables) {
        this.variables = variables;
    }

    public String getGroupChildId() {
        return groupChildId;
    }

    public void setGroupChildId(String groupChildId) {
        this.groupChildId = groupChildId;
    }

    public String getGroupChildName() {
        return groupChildName;
    }

    public void setGroupChildName(String groupChildName) {
        this.groupChildName = groupChildName;
    }
}
