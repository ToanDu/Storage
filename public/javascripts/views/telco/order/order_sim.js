/**
 * Created by vtk-anhlt166 on 1/9/23.
 */
var hostGetImg = "https://cmpapi.innoway.vn:30983/file/";
$(document).ready(function () {
    if(roleCmp == "ENTERPRISE"){
        getInfoAccount();
    } else {
        appendListProvince();
    }
});

var tinhTP = "";
var quanHuyen = "";
var phuongXa = "";
var tinhTpDN = "";
var quanHuyenDN = "";
var phuongXaDN = "";
function getInfoAccount() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getInfoAccount();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getInfoAccount', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.status == 200 && datas.content != null){
                var data = datas.content.info;
                // $("#sdt").val(data.phone != null ? data.phone : "");

                $("#ten_khach_hang").val(data.name != null ? data.name : "");
                $("#ten_khach_hang_3").val(data.name != null ? data.name : "");

                if(data.profile != null){
                    var profile = data.profile;
                    $("#ngay_sinh").val(profile.dob != null ? profile.dob : "");
                    $("#ngay_sinh_3").val(profile.dob != null ? profile.dob : "");

                    $("#quoc_tich_2").val(profile.nationality != null ? profile.nationality : "");
                    $("#quoc_tich_3").val(profile.nationality != null ? profile.nationality : "");

                    tinhTP = profile.province != null ? profile.province : "";
                    quanHuyen = profile.district != null ? profile.district : "";
                    phuongXa = profile.ward != null ? profile.ward : "";

                    $("#dia_chi_chi_tiet_2").val(profile.full_address != null ? profile.full_address : "");
                    $("#dia_chi_chi_tiet_3").val(profile.full_address != null ? profile.full_address : "");

                    $("#gioi_tinh_2").val(profile.gender != null ? profile.gender : "");
                    $("#gioi_tinh_3").val(profile.gender != null ? profile.gender : "");

                    if(profile.identity_info != null){
                        $("#so_giay_to_2").val(profile.identity_info.identity != null ? profile.identity_info.identity : "");
                        $("#so_giay_to_3").val(profile.identity_info.identity != null ? profile.identity_info.identity : "");
                    }

                    if(profile.identity_info != null){
                        $("#cmnd").val(profile.identity_info.identity != null ? profile.identity_info.identity : "");
                        if(profile.identity_info.front_image != null && profile.identity_info.front_image != ""){
                            $("#wizardPicturePreview2").attr('src', hostGetImg + profile.identity_info.front_image);
                            $("#imgOld2").val(profile.identity_info.front_image);
                        }
                        if(profile.identity_info.back_image != null && profile.identity_info.back_image != ""){
                            $("#wizardPicturePreview3").attr('src', hostGetImg + profile.identity_info.back_image);
                            $("#imgOld3").val(profile.identity_info.back_image);
                        }
                    }
                    if(profile.profile_image != null && profile.profile_image != ""){
                        $("#wizardPicturePreview1").attr('src', hostGetImg + profile.profile_image);
                        $("#imgOld1").val(profile.profile_image);
                    }
                }
            } else {
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    setTimeout(function () {
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    },1500);
                } else {
                    showNotification('danger', datas.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
            getInfoCompany();
        }
    })
}
function getInfoCompany() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getInfoCompany', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var data = datas.content.data[0];
                    if(data.approve_status == "SUBMITTED"){
                        data = data.update_info;
                    }

                    // $("#id_doanh_nghiep").val(data.id != null ? data.id : "");
                    $("#ten_dn").val(data.name != null ? data.name : "");
                    $("#ma_so_thue").val(data.tax_code != null ? data.tax_code : "");
                    $("#so_giay_to").val(data.business_license != null ? data.business_license : "");
                    tinhTpDN = data.province != null ? data.province : "";
                    quanHuyenDN = data.district != null ? data.district : "";
                    phuongXaDN = data.ward != null ? data.ward : "";
                    $("#dia_chi_chi_tiet").val(data.full_address != null ? data.full_address : "");

                    if(data.business_license_image != null && data.business_license_image != ""){
                        $("#wizardPicturePreview4").attr('src', hostGetImg + data.business_license_image);
                        $("#imgOld4").val(data.business_license_image);
                    }
                }
            } else {
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    setTimeout(function () {
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    },1500);
                } else {
                    showNotification('danger', datas.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            appendListProvince();
        }
    })
}

function appendListProvince() {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var province = '<option value="" selected>'+Messages("Tỉnh/ TP")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        province += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#tinh_tp").html(province);
                $("#tinh_tp_2").html(province);
                $("#tinh_tp_3").html(province);
                $("#tinh_tp_4").html(province);
            }
        },
        complete: function (){
            // FinishProcess();
            $("#tinh_tp").val(tinhTpDN);
            $("#tinh_tp_2").val(tinhTP);
            $("#tinh_tp_3").val(tinhTP);

            appendListDistrictDN(tinhTpDN);
            appendListDistrict(tinhTP);
        }
    })
}
function appendListDistrictDN(province) {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = province;
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen").html(district);
            }
        },
        complete: function (){
            // FinishProcess();
            $("#quan_huyen").val(quanHuyenDN);
            appendListWardDN(quanHuyenDN);
        }
    })
}
function appendListWardDN(district) {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = district;
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuong_xa").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
            $("#phuong_xa").val(phuongXaDN);
        }
    })
}
//ca nhan
function appendListDistrict(province) {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = province;
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen_2").html(district);
                $("#quan_huyen_3").html(district);
            }
        },
        complete: function (){
            // FinishProcess();
            $("#quan_huyen_2").val(quanHuyen);
            $("#quan_huyen_3").val(quanHuyen);

            appendListWard(quanHuyen);
        }
    })
}
function appendListWard(district) {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = district;
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuong_xa_2").html(ward);
                $("#phuong_xa_3").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
            $("#phuong_xa_2").val(phuongXa);
            $("#phuong_xa_3").val(phuongXa);
        }
    })
}

//onchange select
function selectDistrict() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinh_tp").val();
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen").html(district);
                $("#phuong_xa").html('<option value="">'+Messages("Phường/Xã")+'</option>');
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function selectWard() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quan_huyen").val();
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuong_xa").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function selectDistrict_2() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinh_tp_2").val();
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen_2").html(district);
                $("#phuong_xa_2").html('<option value="">'+Messages("Phường/Xã")+'</option>');
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function selectWard_2() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quan_huyen_2").val();
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuong_xa_2").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function selectDistrict_3() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinh_tp_3").val();
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen_3").html(district);
                $("#phuong_xa_3").html('<option value="">'+Messages("Phường/Xã")+'</option>');
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function selectWard_3() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quan_huyen_3").val();
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuong_xa_3").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function zoomImg(el) {
    // console.log(el.src);
    $("#imgZoom").attr('src', el.src);
    $("#imgZoomModal").modal('show');
}
function imageIsLoaded5(e) {
    $('#wizardPicturePreview5').attr('src', e.target.result);
    document.getElementById("buttonResetImg5").style.display = 'block';
}
function resetImageNumber(el) {
    $('#wizardPicturePreview'+el).attr('src', imgDefault);
    $("#wizard-picture-"+el).val("");
    $("#imgOld"+el).val("");
    document.getElementById("buttonResetImg"+el).style.display = 'none';
}

function upfilePycConnectSim() {
    var groupData = new FormData();
    groupData.append("image_5", $("#wizard-picture-5").prop("files")[0]);
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.upfilePycTelco();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.content != null){
                if(data.content.link != null){
                    $("#imgOld5").val(data.content.link);
                } else {
                    showNotification('danger', data.errorString);
                }
            } else {
                showNotification('danger', data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}