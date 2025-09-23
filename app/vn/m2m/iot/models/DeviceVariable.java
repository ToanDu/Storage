package vn.m2m.iot.models;

/**
 * Created by vtk-anhlt166 on 6/3/21.
 */
public class DeviceVariable {
    private String id;
    private String name;
    private String type;
    private String value;
    private int stt;

    public DeviceVariable(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
}
