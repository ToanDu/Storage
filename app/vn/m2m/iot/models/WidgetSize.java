package vn.m2m.iot.models;

import java.util.HashMap;
import java.util.Map;

public class WidgetSize {

    private String id;
    private int x;
    private int y;
    private int w;
    private int h;
    private String title;
    private String unit;
    private String topic;
    private String cmdon;
    private String cmdoff;

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    private double maxValue;

    private int type;
    private String orgId;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String filter;

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    private String filterValue;
    private String data;

    private int typeMap;

    public WidgetSize(){}

    public enum Type {
        map(1),
        table(2);

        private final int code;

        private static final Map<Integer, Type> roleByCode = new HashMap<Integer, Type>();

        static {
            for(Type role: Type.values()){
                roleByCode.put(role.getCode(),role);
            }
        }

        private Type(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name();
        }

        public static Type fromCode(int code){
            return roleByCode.get(code);
        }

        public static String getNameByCode(int code){
            Type role = roleByCode.get(code);
            if(role!=null){
                return role.getName();
            }
            return "";
        }

    }

    public enum TypeMap {
        googlemap(1),
        mapbox(2);

        private final int code;

        private static final Map<Integer, TypeMap> roleByCode = new HashMap<Integer, TypeMap>();

        static {
            for(TypeMap role: TypeMap.values()){
                roleByCode.put(role.getCode(),role);
            }
        }

        private TypeMap(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name();
        }

        public static TypeMap fromCode(int code){
            return roleByCode.get(code);
        }

        public static String getNameByCode(int code){
            TypeMap typeMap = roleByCode.get(code);
            if(typeMap!=null){
                return typeMap.getName();
            }
            return "";
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCmdon() {
        return cmdon;
    }

    public void setCmdon(String cmdon) {
        this.cmdon = cmdon;
    }

    public String getCmdoff() {
        return cmdoff;
    }

    public void setCmdoff(String cmdoff) {
        this.cmdoff = cmdoff;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(int typeMap) {
        this.typeMap = typeMap;
    }
}
