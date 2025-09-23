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
 * Created by vtk-anhlt166 on 10/26/22.
 */
public class AccountForm extends AbstractFormModel {
    private String nameAccount;
    private String phoneAccount;
    private String cmndAccount;
    private String nameCompanyAccount;
    private String gpkdAccount;
    private String addressAccount;

    private String imgOld1;
    private String imgOld2;
    private String imgOld3;
    private String imgOld4;
    private String imgOld5;
    private Http.MultipartFormData.FilePart image_1;
    private Http.MultipartFormData.FilePart image_2;
    private Http.MultipartFormData.FilePart image_3;
    private Http.MultipartFormData.FilePart image_4;
    private Http.MultipartFormData.FilePart image_5;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        Http.MultipartFormData data = request().body().asMultipartFormData();

        if (data != null){
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

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPhoneAccount() {
        return phoneAccount;
    }

    public void setPhoneAccount(String phoneAccount) {
        this.phoneAccount = phoneAccount;
    }

    public String getCmndAccount() {
        return cmndAccount;
    }

    public void setCmndAccount(String cmndAccount) {
        this.cmndAccount = cmndAccount;
    }

    public String getNameCompanyAccount() {
        return nameCompanyAccount;
    }

    public void setNameCompanyAccount(String nameCompanyAccount) {
        this.nameCompanyAccount = nameCompanyAccount;
    }

    public String getGpkdAccount() {
        return gpkdAccount;
    }

    public void setGpkdAccount(String gpkdAccount) {
        this.gpkdAccount = gpkdAccount;
    }

    public String getAddressAccount() {
        return addressAccount;
    }

    public void setAddressAccount(String addressAccount) {
        this.addressAccount = addressAccount;
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
}
