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
 * Created by vtk-anhlt166 on 1/12/22.
 */
public class OrgForm extends AbstractFormModel {
    private String id;
    private String name;
    private String description;
    private String projectId;
    private String orgId;
    private String groupId;
    private Boolean changeImg;
    private String imgOld;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        Http.MultipartFormData data = request().body().asMultipartFormData();

        if (data!=null&&data.getFile("avatar") != null){
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

        return errors.isEmpty() ? null : errors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getChangeImg() {
        return changeImg;
    }

    public void setChangeImg(Boolean changeImg) {
        this.changeImg = changeImg;
    }

    public String getImgOld() {
        return imgOld;
    }

    public void setImgOld(String imgOld) {
        this.imgOld = imgOld;
    }
}
