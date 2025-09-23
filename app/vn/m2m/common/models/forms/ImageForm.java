package vn.m2m.common.models.forms;

import models.forms.AbstractFormModel;
import org.apache.commons.lang.StringUtils;
import play.data.validation.ValidationError;
import play.mvc.Http;
import vn.m2m.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Controller.request;

public class ImageForm extends AbstractFormModel {
    private String imgOld;
    private Http.MultipartFormData.FilePart image;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        Http.MultipartFormData data = request().body().asMultipartFormData();

        if (data != null){
            if(data.getFile("image") != null){
                if(!StringUtils.isEmpty(data.getFile("image").getFilename())){
                    image = data.getFile("image");
                    String contenttype = ImageUtil.getImageType(image.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_1", "wrong format image"));
                    }
                }
            }
        }

        return errors.isEmpty() ? null : errors;
    }

    public String getImgOld() {
        return imgOld;
    }

    public void setImgOld(String imgOld) {
        this.imgOld = imgOld;
    }

    public Http.MultipartFormData.FilePart getImage() {
        return image;
    }

    public void setImage(Http.MultipartFormData.FilePart image) {
        this.image = image;
    }
}
