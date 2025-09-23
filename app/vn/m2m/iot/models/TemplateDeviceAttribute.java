package vn.m2m.iot.models;

/**
 * Created by vtk-anhlt166 on 6/14/22.
 */
public class TemplateDeviceAttribute {
    private String attribute;
    private String attrType;
    private boolean saveLog;
    private String contentAttr;

    public TemplateDeviceAttribute(){}

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public boolean isSaveLog() {
        return saveLog;
    }

    public void setSaveLog(boolean saveLog) {
        this.saveLog = saveLog;
    }

    public String getContentAttr() {
        return contentAttr;
    }

    public void setContentAttr(String contentAttr) {
        this.contentAttr = contentAttr;
    }
}
