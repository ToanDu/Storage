/**
 * Created by vtk-anhlt166 on 8/5/22.
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
    $("#wizard-picture-1-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit1;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-2-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit2;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-3-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit3;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-4-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit4;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-5-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit5;
            reader.readAsDataURL(this.files[0]);
        }
    });
});
function imageIsLoadedEdit(e) {
    $('#wizardPicturePreviewEdit').attr('src', e.target.result);
}
function imageIsLoadedEdit1(e) {
    $('#wizardPicturePreviewEdit1').attr('src', e.target.result);
    document.getElementById("buttonResetImgEdit1").style.display = 'block';
    document.getElementById("changeImg1").checked = true;
}
function imageIsLoadedEdit2(e) {
    $('#wizardPicturePreviewEdit2').attr('src', e.target.result);
    document.getElementById("buttonResetImgEdit2").style.display = 'block';
    document.getElementById("changeImg2").checked = true;
}
function imageIsLoadedEdit3(e) {
    $('#wizardPicturePreviewEdit3').attr('src', e.target.result);
    document.getElementById("buttonResetImgEdit3").style.display = 'block';
    document.getElementById("changeImg3").checked = true;
}
function imageIsLoadedEdit4(e) {
    $('#wizardPicturePreviewEdit4').attr('src', e.target.result);
    document.getElementById("buttonResetImgEdit4").style.display = 'block';
    document.getElementById("changeImg4").checked = true;
}
function imageIsLoadedEdit5(e) {
    $('#wizardPicturePreviewEdit5').attr('src', e.target.result);
    document.getElementById("buttonResetImgEdit5").style.display = 'block';
    document.getElementById("changeImg5").checked = true;
}

function resetImageEdit() {
    $('#wizardPicturePreviewEdit').attr('src', imgDefault);
    $("#wizard-picture-edit").val("");
    document.getElementById("buttonResetImgEdit").style.display = 'none';
}
function resetImageNumberEdit(el) {
    $('#wizardPicturePreviewEdit'+el).attr('src', imgDefault);
    $("#wizard-picture-"+el+"-edit").val("");
    document.getElementById("buttonResetImgEdit"+el).style.display = 'none';
    if($('#imgProductOld'+el).val() != null && $('#imgProductOld'+el).val() != ""){
        document.getElementById("changeImg"+el).checked = true;
    } else {
        document.getElementById("changeImg"+el).checked = false;
    }
}

function getInfoProduct(id) {
    var body = {
        "id": id
    };
    StartProcess();
    var r = jsRoutes.controllers.ProductListController.getProductById();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                var status = STATUS_PRODUCT.NEW.name;
                if(data.content.statusApprove == 1){
                    status = STATUS_PRODUCT.APPROVED.name;
                } else if(data.content.statusApprove == 2){
                    status = STATUS_PRODUCT.REFUSE.name;
                } else if(data.content.statusApprove == 3){
                    status = STATUS_PRODUCT.WAIT.name;
                }
                $("#statusApprove").html('<p>'+Messages("Trạng thái: ")+'</p>' + '<p class="fw-bold">'+status+'</p>');
                $("#contentApprove").html('<p>'+Messages("Lý do: ")+'</p>' + '<p class="fw-bold">'+(data.content.contentApprove != null ? data.content.contentApprove : "")+'</p>');
                $("#createDate").html('<p>'+Messages("Ngày tạo: ")+'</p>' + '<p class="fw-bold">'+moment.unix(data.content.createDate/1000).format("HH:mm DD/MM/YYYY")+'</p>');
                $("#updateDate").html('<p>'+Messages("Cập nhật cuối: ")+'</p>' + '<p class="fw-bold">'+moment.unix(data.content.updateDate/1000).format("HH:mm DD/MM/YYYY")+'</p>');

                $('#idProductEdit').val(data.content.id);
                $('#codeProductEdit').val(data.content.code);
                $('#nameProductEdit').val(data.content.name);
                $('#priceProductEdit').val(data.content.price);

                $('#showProductEdit').val(data.content.statusShow.toString());
                $('#infoProductEdit').val(data.content.info);
                $('#contentProductEdit').val(data.content.content);
                $('#featureProductEdit').val(data.content.feature);
                $('#linkDocsProductEdit').val(data.content.linkDocs);
                $('#supportPersionEdit').val(data.content.supportPersion);
                $('#solutionEdit').val(data.content.solution);

                $("#imgProductOld").val(data.content.imgName);
                var img = hostname + "/getImg/" + data.content.imgName;
                $('#wizardPicturePreviewEdit').attr('src', img);
                document.getElementById("buttonResetImgEdit").style.display = 'block';

                document.getElementById("changeImg1").checked = false;
                if(data.content.image_1 != null && data.content.image_1 != undefined){
                    $("#imgProductOld1").val(data.content.image_1);
                    var img1 = hostname + "/getImg/" + data.content.image_1;
                    $('#wizardPicturePreviewEdit1').attr('src', img1);
                    document.getElementById("buttonResetImgEdit1").style.display = 'block';
                } else {
                    $("#imgProductOld1").val("");
                    $('#wizardPicturePreviewEdit1').attr('src', imgDefault);
                    document.getElementById("buttonResetImgEdit1").style.display = 'none';
                }

                document.getElementById("changeImg2").checked = false;
                if(data.content.image_2 != null && data.content.image_2 != undefined){
                    $("#imgProductOld2").val(data.content.image_2);
                    var img2 = hostname + "/getImg/" + data.content.image_2;
                    $('#wizardPicturePreviewEdit2').attr('src', img2);
                    document.getElementById("buttonResetImgEdit2").style.display = 'block';
                } else {
                    $("#imgProductOld2").val("");
                    $('#wizardPicturePreviewEdit2').attr('src', imgDefault);
                    document.getElementById("buttonResetImgEdit2").style.display = 'none';
                }

                document.getElementById("changeImg3").checked = false;
                if(data.content.image_3 != null && data.content.image_3 != undefined){
                    $("#imgProductOld3").val(data.content.image_3);
                    var img3 = hostname + "/getImg/" + data.content.image_3;
                    $('#wizardPicturePreviewEdit3').attr('src', img3);
                    document.getElementById("buttonResetImgEdit3").style.display = 'block';
                } else {
                    $("#imgProductOld3").val("");
                    $('#wizardPicturePreviewEdit3').attr('src', imgDefault);
                    document.getElementById("buttonResetImgEdit3").style.display = 'none';
                }

                document.getElementById("changeImg4").checked = false;
                if(data.content.image_4 != null && data.content.image_4 != undefined){
                    $("#imgProductOld4").val(data.content.image_4);
                    var img4 = hostname + "/getImg/" + data.content.image_4;
                    $('#wizardPicturePreviewEdit4').attr('src', img4);
                    document.getElementById("buttonResetImgEdit4").style.display = 'block';
                } else {
                    $("#imgProductOld4").val("");
                    $('#wizardPicturePreviewEdit4').attr('src', imgDefault);
                    document.getElementById("buttonResetImgEdit4").style.display = 'none';
                }

                document.getElementById("changeImg5").checked = false;
                if(data.content.image_5 != null && data.content.image_5 != undefined){
                    $("#imgProductOld5").val(data.content.image_5);
                    var img5 = hostname + "/getImg/" + data.content.image_5;
                    $('#wizardPicturePreviewEdit5').attr('src', img5);
                    document.getElementById("buttonResetImgEdit5").style.display = 'block';
                } else {
                    $("#imgProductOld5").val("");
                    $('#wizardPicturePreviewEdit5').attr('src', imgDefault);
                    document.getElementById("buttonResetImgEdit5").style.display = 'none';
                }

                // if(data.content.statusApprove != 1){
                //     document.getElementById("buttonSendRequest").style.display = "block";
                // } else {
                //     document.getElementById("buttonSendRequest").style.display = "none";
                // }

                if(data.content.groupType == 0){
                    $("#typeGroupProductEdit").val(0);
                    getGroupDeviceEdit();
                } else if(data.content.groupType == 1){
                    $("#typeGroupProductEdit").val(1);
                    getGroupSolutionEdit();
                }
                setTimeout(function () {
                    $('#groupProductEdit').val(data.content.groupId);
                },1000);

            } else{
                showNotification('danger',data.errorString);
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
function processEditProduct() {
    if($('#nameProductEdit').val().length == 0){
        showNotification('danger',Messages("Bạn chưa điền tên sản phẩm "));
        $('#nameProductEdit').focus();
        return;
    }
    if($('#infoProductEdit').val().length == 0){
        showNotification('danger',Messages("Bạn chưa điền giới thiệu sản phẩm "));
        $('#infoProductEdit').focus();
        return;
    }
    if($('#contentProductEdit').val().length == 0){
        showNotification('danger',Messages("Bạn chưa điền mô tả sản phẩm "));
        $('#contentProductEdit').focus();
        return;
    }

    var groupData = new FormData();
    groupData.append("id", $('#idProductEdit').val());
    groupData.append("code", $('#codeProductEdit').val());
    groupData.append("name", $('#nameProductEdit').val().trim());
    groupData.append("price", $('#priceProductEdit').val());
    groupData.append("groupId", $('#groupProductEdit').val());
    groupData.append("statusShow", $('#showProductEdit').val());
    groupData.append("info", $('#infoProductEdit').val().trim());
    groupData.append("content", $('#contentProductEdit').val().trim());
    groupData.append("feature", $('#featureProductEdit').val());
    groupData.append("linkDocs", $('#linkDocsProductEdit').val());
    groupData.append("supportPersion", $('#supportPersionEdit').val());
    groupData.append("solution", $('#solutionEdit').val());
    groupData.append("avatar", $("#wizard-picture-edit").prop("files")[0]);
    groupData.append("imgOld", $('#imgProductOld').val());
    if($("#wizard-picture-edit").prop("files")[0] != null){
        groupData.append("changeImg", true);
    } else {
        groupData.append("changeImg", false);
    }

    groupData.append("imgOld1", $('#imgProductOld1').val());
    if($("#wizard-picture-1-edit").prop("files")[0] != null && $("#wizard-picture-1-edit").prop("files")[0] != undefined){
        groupData.append("image_1", $("#wizard-picture-1-edit").prop("files")[0]);
    }
    groupData.append("changeImg1", (document.getElementById('changeImg1').checked) ? true : false);

    groupData.append("imgOld2", $('#imgProductOld2').val());
    if($("#wizard-picture-2-edit").prop("files")[0] != null  && $("#wizard-picture-2-edit").prop("files")[0] != undefined){
        groupData.append("image_2", $("#wizard-picture-2-edit").prop("files")[0]);
    }
    groupData.append("changeImg2", (document.getElementById('changeImg2').checked) ? true : false);

    groupData.append("imgOld3", $('#imgProductOld3').val());
    if($("#wizard-picture-3-edit").prop("files")[0] != null  && $("#wizard-picture-3-edit").prop("files")[0] != undefined){
        groupData.append("image_3", $("#wizard-picture-3-edit").prop("files")[0]);
    }
    groupData.append("changeImg3", (document.getElementById('changeImg3').checked) ? true : false);

    groupData.append("imgOld4", $('#imgProductOld4').val());
    if($("#wizard-picture-4-edit").prop("files")[0] != null  && $("#wizard-picture-4-edit").prop("files")[0] != undefined){
        groupData.append("image_4", $("#wizard-picture-4-edit").prop("files")[0]);
    }
    groupData.append("changeImg4", (document.getElementById('changeImg4').checked) ? true : false);

    groupData.append("imgOld5", $('#imgProductOld5').val());
    if($("#wizard-picture-5-edit").prop("files")[0] != null  && $("#wizard-picture-5-edit").prop("files")[0] != undefined){
        groupData.append("image_5", $("#wizard-picture-5-edit").prop("files")[0]);
    }
    groupData.append("changeImg5", (document.getElementById('changeImg5').checked) ? true : false);

    console.log(groupData);

    $("#editConfirmModal").modal('hide');

    StartProcess();
    var r = jsRoutes.controllers.ProductListController.editProduct();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                getListProduct();
                showNotification('success',data.resultString);
            } else{
                showNotification('danger',data.errorString);
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

function sendRequestApproveProduct(id) {
    var body = {
        "id": id
    };
    StartProcess();
    var r = jsRoutes.controllers.ProductListController.requestApproveProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getListProduct();
                showNotification('success',data.resultString);
            } else{
                showNotification('danger',data.errorString);
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

function selectGroupProductEdit() {
    if($("#typeGroupProductEdit").val() == 0){//device
        getGroupDeviceEdit();
    } if($("#typeGroupProductEdit").val() == 1) {//solution
        getGroupSolutionEdit();
    }
}
function getGroupDeviceEdit(){
    // StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getAllGroupDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                var option = '<option value="">'+Messages("Chọn nhóm sản phẩm")+'</option>';
                console.log(data.content.length);
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        option += '<option value="'+data.content[i].id+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#groupProductEdit").html(option);
            }

        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}
function getGroupSolutionEdit(){
    // StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getAllGroupSolution();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                var option = '<option value="">'+Messages("Chọn nhóm sản phẩm")+'</option>';
                console.log(data.content.length);
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        option += '<option value="'+data.content[i].id+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#groupProductEdit").html(option);
            }

        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}