package vn.m2m.iot.form;

import org.apache.commons.lang.StringUtils;
import play.data.validation.ValidationError;
import play.mvc.Http;
import vn.m2m.utils.ImageUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static play.mvc.Controller.request;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
public class ProductForm extends AbstractFormModel {
    private String id;
    private String code;
    private String name;
    private String info;
    private String content;
    private String feature;
    private String linkDocs;
    private String supportPersion;
    private String solution;
    private String version;
    private double price;
    private String imgName;
    private String imgOld;
    private Boolean changeImg;

    private String groupId;
    private String groupName;
    private boolean statusShow;

    private String imgOld1;
    private String imgOld2;
    private String imgOld3;
    private String imgOld4;
    private String imgOld5;
    private Boolean changeImg1;
    private Boolean changeImg2;
    private Boolean changeImg3;
    private Boolean changeImg4;
    private Boolean changeImg5;
    private Http.MultipartFormData.FilePart image_1;
    private Http.MultipartFormData.FilePart image_2;
    private Http.MultipartFormData.FilePart image_3;
    private Http.MultipartFormData.FilePart image_4;
    private Http.MultipartFormData.FilePart image_5;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        Http.MultipartFormData data = request().body().asMultipartFormData();

        if (data != null){
            if(data.getFile("avatar") != null){
                if(!StringUtils.isEmpty(data.getFile("avatar").getFilename())){
                    fileData = data.getFile("avatar");
                    fileName = fileData.getFilename();
                    contentType = ImageUtil.getImageType(fileName);
                    File file = (File )fileData.getFile();
                    fileClientPath = file.getParent();

                    if(!ImageUtil.checkValidImageType(contentType)){
                        errors.add(new ValidationError("avatar", "wrong format image"));
                    }
                }
            }

            if(data.getFile("image_1") != null){
                if(!StringUtils.isEmpty(data.getFile("image_1").getFilename())){
                    image_1 = data.getFile("image_1");
                    String contenttype = ImageUtil.getImageType(image_1.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_1", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_2") != null){
                if(!StringUtils.isEmpty(data.getFile("image_2").getFilename())){
                    image_2 = data.getFile("image_2");
                    String contenttype = ImageUtil.getImageType(image_2.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_2", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_3") != null){
                if(!StringUtils.isEmpty(data.getFile("image_3").getFilename())){
                    image_3 = data.getFile("image_3");
                    String contenttype = ImageUtil.getImageType(image_3.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_3", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_4") != null){
                if(!StringUtils.isEmpty(data.getFile("image_4").getFilename())){
                    image_4 = data.getFile("image_4");
                    String contenttype = ImageUtil.getImageType(image_4.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_4", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_5") != null){
                if(!StringUtils.isEmpty(data.getFile("image_5").getFilename())){
                    image_5 = data.getFile("image_5");
                    String contenttype = ImageUtil.getImageType(image_5.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_5", "wrong format image"));
                    }
                }
            }
        }

        return errors.isEmpty() ? null : errors;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
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

    public boolean isStatusShow() {
        return statusShow;
    }

    public void setStatusShow(boolean statusShow) {
        this.statusShow = statusShow;
    }

    public String getImgOld() {
        return imgOld;
    }

    public void setImgOld(String imgOld) {
        this.imgOld = imgOld;
    }

    public Boolean getChangeImg() {
        return changeImg;
    }

    public void setChangeImg(Boolean changeImg) {
        this.changeImg = changeImg;
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

    public Http.MultipartFormData.FilePart getImage_1() {
        return image_1;
    }

    public void setImage_1(Http.MultipartFormData.FilePart image_1) {
        this.image_1 = image_1;
    }

    public Http.MultipartFormData.FilePart getImage_2() {
        return image_2;
    }

    public void setImage_2(Http.MultipartFormData.FilePart image_2) {
        this.image_2 = image_2;
    }

    public Http.MultipartFormData.FilePart getImage_3() {
        return image_3;
    }

    public void setImage_3(Http.MultipartFormData.FilePart image_3) {
        this.image_3 = image_3;
    }

    public Http.MultipartFormData.FilePart getImage_4() {
        return image_4;
    }

    public void setImage_4(Http.MultipartFormData.FilePart image_4) {
        this.image_4 = image_4;
    }

    public Http.MultipartFormData.FilePart getImage_5() {
        return image_5;
    }

    public void setImage_5(Http.MultipartFormData.FilePart image_5) {
        this.image_5 = image_5;
    }

    public Boolean getChangeImg1() {
        return changeImg1;
    }

    public void setChangeImg1(Boolean changeImg1) {
        this.changeImg1 = changeImg1;
    }

    public Boolean getChangeImg2() {
        return changeImg2;
    }

    public void setChangeImg2(Boolean changeImg2) {
        this.changeImg2 = changeImg2;
    }

    public Boolean getChangeImg3() {
        return changeImg3;
    }

    public void setChangeImg3(Boolean changeImg3) {
        this.changeImg3 = changeImg3;
    }

    public Boolean getChangeImg4() {
        return changeImg4;
    }

    public void setChangeImg4(Boolean changeImg4) {
        this.changeImg4 = changeImg4;
    }

    public Boolean getChangeImg5() {
        return changeImg5;
    }

    public void setChangeImg5(Boolean changeImg5) {
        this.changeImg5 = changeImg5;
    }

    public String getImgOld1() {
        return imgOld1;
    }

    public void setImgOld1(String imgOld1) {
        this.imgOld1 = imgOld1;
    }

    public String getImgOld2() {
        return imgOld2;
    }

    public void setImgOld2(String imgOld2) {
        this.imgOld2 = imgOld2;
    }

    public String getImgOld3() {
        return imgOld3;
    }

    public void setImgOld3(String imgOld3) {
        this.imgOld3 = imgOld3;
    }

    public String getImgOld4() {
        return imgOld4;
    }

    public void setImgOld4(String imgOld4) {
        this.imgOld4 = imgOld4;
    }

    public String getImgOld5() {
        return imgOld5;
    }

    public void setImgOld5(String imgOld5) {
        this.imgOld5 = imgOld5;
    }
}
