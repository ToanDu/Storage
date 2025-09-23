package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.UserHelper;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
@ModelData(collection = "Product", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String userId;
    private String userName;
    private String code;
    private String name;
    private String nameLowerCase;
    private String info;
    private String content;
    private String version;
    private String feature;
    private String linkDocs;
    private String supportPersion;
    private String solution;

    private double price;
    private String imgName;
    private String image_1;
    private String image_2;
    private String image_3;
    private String image_4;
    private String image_5;

    private String groupId;
    private int groupType;
    private String groupName;
    private boolean statusGroup = true;
    private boolean statusShow = true;

    private int statusApprove; //0-Mới khởi tạo; 1-duyệt; 2-từ chối; 3-chờ duyệt
    private String contentApprove;
    private double pointTB;
    private int countView;

    private Date createDate;
    private Date updateDate;

    private int countContact;

    public Product(){
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

    public String getNameLowerCase() {
        return nameLowerCase;
    }

    public void setNameLowerCase(String nameLowerCase) {
        this.nameLowerCase = nameLowerCase;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getStatusApprove() {
        return statusApprove;
    }

    public void setStatusApprove(int statusApprove) {
        this.statusApprove = statusApprove;
    }

    public String getContentApprove() {
        return contentApprove;
    }

    public void setContentApprove(String contentApprove) {
        this.contentApprove = contentApprove;
    }

    public boolean isStatusShow() {
        return statusShow;
    }

    public void setStatusShow(boolean statusShow) {
        this.statusShow = statusShow;
    }

    public double getPointTB() {
        return pointTB;
    }

    public void setPointTB(double pointTB) {
        this.pointTB = pointTB;
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

    public int getCountContact() {
        return countContact;
    }

    public void setCountContact(int countContact) {
        this.countContact = countContact;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSupportPersion() {
        return supportPersion;
    }

    public void setSupportPersion(String supportPersion) {
        this.supportPersion = supportPersion;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getLinkDocs() {
        return linkDocs;
    }

    public void setLinkDocs(String linkDocs) {
        this.linkDocs = linkDocs;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }

    public String getImage_4() {
        return image_4;
    }

    public void setImage_4(String image_4) {
        this.image_4 = image_4;
    }

    public String getImage_5() {
        return image_5;
    }

    public void setImage_5(String image_5) {
        this.image_5 = image_5;
    }

    public int getCountView() {
        return countView;
    }

    public void setCountView(int countView) {
        this.countView = countView;
    }

    public boolean isStatusGroup() {
        return statusGroup;
    }

    public void setStatusGroup(boolean statusGroup) {
        this.statusGroup = statusGroup;
    }
}
