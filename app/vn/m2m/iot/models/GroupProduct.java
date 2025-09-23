package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.UserHelper;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
@ModelData(collection = "GroupProduct", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class GroupProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String code;
    private String name;
    private int type;
    private long countProduct;
    private boolean status;
    private Date logDate;

    public enum Types {
        device(0),
        solution(1);

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

    public GroupProduct(){
        this.id = UserHelper.generalUserID();
        this.logDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(long countProduct) {
        this.countProduct = countProduct;
    }
}
