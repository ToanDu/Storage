/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
$(function () {
    $("#wizard-picture").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-1").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded1;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-2").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded2;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-3").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded3;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-4").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded4;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-5").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded5;
            reader.readAsDataURL(this.files[0]);
        }
    });
});
function imageIsLoaded(e) {
    $('#wizardPicturePreview').attr('src', e.target.result);
    document.getElementById("buttonResetImg").style.display = 'block';
}
function imageIsLoaded1(e) {
    $('#wizardPicturePreview1').attr('src', e.target.result);
    document.getElementById("buttonResetImg1").style.display = 'block';
}
function imageIsLoaded2(e) {
    $('#wizardPicturePreview2').attr('src', e.target.result);
    document.getElementById("buttonResetImg2").style.display = 'block';
}
function imageIsLoaded3(e) {
    $('#wizardPicturePreview3').attr('src', e.target.result);
    document.getElementById("buttonResetImg3").style.display = 'block';
}
function imageIsLoaded4(e) {
    $('#wizardPicturePreview4').attr('src', e.target.result);
    document.getElementById("buttonResetImg4").style.display = 'block';
}
function imageIsLoaded5(e) {
    $('#wizardPicturePreview5').attr('src', e.target.result);
    document.getElementById("buttonResetImg5").style.display = 'block';
}

function resetImage() {
    $('#wizardPicturePreview').attr('src', imgDefault);
    $("#wizard-picture").val("");
    document.getElementById("buttonResetImg").style.display = 'none';
}
function resetImageNumber(el) {
    $('#wizardPicturePreview'+el).attr('src', imgDefault);
    $("#wizard-picture-"+el).val("");
    document.getElementById("buttonResetImg"+el).style.display = 'none';
}

function postDataCreateProduct() {
    if($('#nameProductAdd').val().length == 0){
        showNotification('danger',Messages("Bạn chưa điền tên sản phẩm "));
        $('#nameProductAdd').focus();
        return;
    }
    if($('#infoProductAdd').val().length == 0){
        showNotification('danger',Messages("Bạn chưa điền giới thiệu sản phẩm "));
        $('#infoProductAdd').focus();
        return;
    }
    if($('#contentProductAdd').val().length == 0){
        showNotification('danger',Messages("Bạn chưa điền mô tả sản phẩm "));
        $('#contentProductAdd').focus();
        return;
    }
    console.log($('#groupProductAdd').val())
    if($('#groupProductAdd').val().length == 0){
        showNotification('danger',Messages("Bạn chưa chọn nhóm sản phẩm "));
        return;
    }
    if($("#wizard-picture").prop("files")[0] == null || $("#wizard-picture").prop("files")[0] == undefined){
        showNotification('danger',Messages("Bạn chưa tải ảnh sản phẩm "));
        return;
    }

    var groupData = new FormData();
    groupData.append("code", $('#codeProductAdd').val());
    groupData.append("name", $('#nameProductAdd').val().trim());
    groupData.append("price", $('#priceProductAdd').val());
    groupData.append("groupId", $('#groupProductAdd').val());
    groupData.append("statusShow", $('#showProductAdd').val());
    groupData.append("info", $('#infoProductAdd').val());
    groupData.append("content", $('#contentProductAdd').val());
    groupData.append("feature", $('#featureProductAdd').val());
    groupData.append("linkDocs", $('#linkDocsProductAdd').val());
    groupData.append("supportPersion", $('#supportPersionAdd').val());
    groupData.append("solution", $('#solutionAdd').val());
    groupData.append("avatar", $("#wizard-picture").prop("files")[0]);
    if($("#wizard-picture-1").prop("files")[0] != null && $("#wizard-picture-1").prop("files")[0] != undefined){
        groupData.append("image_1", $("#wizard-picture-1").prop("files")[0]);
    }
    if($("#wizard-picture-2").prop("files")[0] != null && $("#wizard-picture-2").prop("files")[0] != undefined){
        groupData.append("image_2", $("#wizard-picture-2").prop("files")[0]);
    }
    if($("#wizard-picture-3").prop("files")[0] != null && $("#wizard-picture-3").prop("files")[0] != undefined){
        groupData.append("image_3", $("#wizard-picture-3").prop("files")[0]);
    }
    if($("#wizard-picture-4").prop("files")[0] != null && $("#wizard-picture-4").prop("files")[0] != undefined){
        groupData.append("image_4", $("#wizard-picture-4").prop("files")[0]);
    }
    if($("#wizard-picture-5").prop("files")[0] != null && $("#wizard-picture-5").prop("files")[0] != undefined){
        groupData.append("image_5", $("#wizard-picture-5").prop("files")[0]);
    }
    console.log(groupData);

    $("#addProductModal").modal('hide');


    StartProcess();
    var r = jsRoutes.controllers.ProductListController.createProduct();
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
                getListProduct();
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