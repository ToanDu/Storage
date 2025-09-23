package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.UserHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 8/12/22.
 */
@ModelData(collection = "ProductComment", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class ProductComment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date createDate;
    private Date updateDate;

    private String productId;
    private String parent;
    private String name;
    private String username;
    private String email;
    private String content;
    private boolean createByAdmin;
    private boolean createByUser;
    private boolean createByGuest;
    private int countChildCmt;
    private boolean like;

    public ProductComment(){
        this.id = UserHelper.generalUserID();
        this.createDate = DateUtil.now();
        this.updateDate = DateUtil.now();
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCreateByAdmin() {
        return createByAdmin;
    }

    public void setCreateByAdmin(boolean createByAdmin) {
        this.createByAdmin = createByAdmin;
    }

    public boolean isCreateByUser() {
        return createByUser;
    }

    public void setCreateByUser(boolean createByUser) {
        this.createByUser = createByUser;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public boolean isCreateByGuest() {
        return createByGuest;
    }

    public void setCreateByGuest(boolean createByGuest) {
        this.createByGuest = createByGuest;
    }

    public int getCountChildCmt() {
        return countChildCmt;
    }

    public void setCountChildCmt(int countChildCmt) {
        this.countChildCmt = countChildCmt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
