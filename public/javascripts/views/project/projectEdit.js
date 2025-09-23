/**
 * Created by vtk-anhlt166 on 11/29/21.
 */
//edit
$(function () {
    $("#wizard-picture-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit;
            reader.readAsDataURL(this.files[0]);
        }
    });
});
function imageIsLoadedEdit(e) {
    $('#wizardPicturePreviewEdit').attr('src', e.target.result);
}

function showPopupEditProject(id, name, tagId, des, image) {
    console.log(id, name, tagId, des, image);
    $("#idProjectEdit").val(id);
    $("#nameProjectEdit").val(name);
    $("#descriptionProjectEdit").val(des);
    $("#tagEdit").val(tagId);

    var img = "";
    if(image != null && image.length > 0){
        img = hostname + "/getImg/" + image;
        $('#wizardPicturePreviewEdit').attr('src', img);
    } else {
        $('#wizardPicturePreviewEdit').attr('src', imgProject0);
    }

    $("#imgOld").val(image);

    $("#editProjectModal").modal('show');
}
function postDataEditProject() {
    if($('#nameProjectEdit').val().length == 0){
        showNotification('danger',Messages("noti.valid.name"));
        $('#nameProjectEdit').focus();
        return;
    }
    if($('#descriptionProjectEdit').val().length == 0){
        showNotification('danger',Messages("noti.valid.description"));
        $('#descriptionProjectEdit').focus();
        return;
    }

    if($('#nameProjectEdit').val().length > 30){
        showNotification('danger',Messages("Tên dự án không quá 30 kí tự"));
        $('#nameProjectEdit').focus();
        return;
    }
    if($('#descriptionProjectEdit').val().length == 0){
        showNotification('danger',Messages("Mô tả dự án không quá 100 kí tự"));
        $('#descriptionProjectEdit').focus();
        return;
    }
    if($('#tagEdit').val().length == 0){
        showNotification('danger',Messages("Bạn chưa chọn lĩnh vực của dự án"));
        return;
    }

    var groupData = new FormData();
    groupData.append("id", $('#idProjectEdit').val());
    groupData.append("name", $('#nameProjectEdit').val());
    groupData.append("description", $('#descriptionProjectEdit').val());
    groupData.append("tagId", $('#tagEdit').val());
    groupData.append("avatar", $("#wizard-picture-edit").prop("files")[0]);
    groupData.append("imgOld", $('#imgOld').val());
    if($("#wizard-picture-edit").prop("files")[0] != null){
        groupData.append("changeImg", true);
    } else {
        groupData.append("changeImg", false);
    }
    console.log(groupData);

    $("#editProjectModal").modal('hide');

    StartProcess();
    var r = jsRoutes.controllers.ProjectController.editProject();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                getListProject();
            }else{
                showErrorCode(data.errorString, data.status);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}