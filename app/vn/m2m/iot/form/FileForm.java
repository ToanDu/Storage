package vn.m2m.iot.form;

import org.apache.commons.lang.StringUtils;
import play.data.validation.ValidationError;
import play.mvc.Http;
import vn.m2m.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Controller.request;

public class FileForm extends AbstractFormModel {
    private Http.MultipartFormData.FilePart filePart;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        Http.MultipartFormData data = request().body().asMultipartFormData();

        if (data != null){
            if(data.getFile("filePart") != null){
                if(!StringUtils.isEmpty(data.getFile("filePart").getFilename())){
                    filePart = data.getFile("filePart");
                    String contenttype = ImageUtil.getImageType(filePart.getFilename());

//                    if(!ImageUtil.checkValidImageType(contenttype)){
//                        errors.add(new ValidationError("filePart", "wrong format image"));
//                    }
                }
            }
        }

        return errors.isEmpty() ? null : errors;
    }

    public Http.MultipartFormData.FilePart getFilePart() {
        return filePart;
    }

    public void setFilePart(Http.MultipartFormData.FilePart filePart) {
        this.filePart = filePart;
    }
}
