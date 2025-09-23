package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.UserHelper;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vtk-anhlt166 on 8/12/22.
 */
@ModelData(collection = "ProductContact", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class ProductContact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date createDate;

    private String name;
    private String phone;
    private String email;
    private String company;
    private String content;
    private boolean status;

    private String productId;
    private String productName;

    public ProductContact(){
        this.id = UserHelper.generalUserID();
        this.createDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
