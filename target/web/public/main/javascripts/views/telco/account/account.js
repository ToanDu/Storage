/**
 * Created by vtk-anhlt166 on 10/24/22.
 */
var hostname;
var hostGetImg = "https://cmp-api.innoway.vn/file/";
$(document).ready(function () {
    hostname = location.protocol + '//' + location.host;
    console.log(hostname);

    $("#wizard-picture-1").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("account.error.avatarWrongFormat"));
                
                $('#wizardPicturePreview1').attr('src', img1!=""?hostGetImg+img1:imgDefault);
                $("#wizard-picture-1").val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("account.error.avatarTooLarge"));
                    $('#wizardPicturePreview1').attr('src', img1!=""?hostGetImg+img1:imgDefault);
                    $("#wizard-picture-1").val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = imageIsLoaded1;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-2").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("account.error.idCardFrontWrongFormat"));
                $('#wizardPicturePreview2').attr('src', img2!=""?hostGetImg+img2:imgDefault);
                $("#wizard-picture-2").val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("account.error.idCardFrontTooLarge"));
                    $('#wizardPicturePreview2').attr('src', img2!=""?hostGetImg+img2:imgDefault);
                    $("#wizard-picture-2").val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = imageIsLoaded2;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-3").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("account.error.idCardBackWrongFormat"));
                $('#wizardPicturePreview3').attr('src', img3!=""?hostGetImg+img3:imgDefault);
                $("#wizard-picture-3").val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("account.error.idCardBackTooLarge"));
                    $('#wizardPicturePreview3').attr('src', img3!=""?hostGetImg+img3:imgDefault);
                    $("#wizard-picture-3").val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = imageIsLoaded3;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-4_0").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("account.error.businessLicenseWrongFormat"));
                $('#wizardPicturePreview4').attr('src', imgDefault);
                $("#wizard-picture-4").val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("account.error.businessLicenseTooLarge"));
                    $('#wizardPicturePreview4').attr('src', imgDefault);
                    $("#wizard-picture-4").val("");
                    return;
                }
            }
            var reader = new FileReader();
            reader.onload = imageIsLoaded4;
            reader.readAsDataURL(this.files[0]);
        }
    });

    $("#wizard-picture-5").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("account.error.authorizationWrongFormat"));
                $('#wizardPicturePreview5').attr('src', img5!=""?hostGetImg+img5:imgDefault);
                $("#wizard-picture-5").val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("account.error.authorizationTooLarge"));
                    $('#wizardPicturePreview5').attr('src', img5!=""?hostGetImg+img5:imgDefault);
                    $("#wizard-picture-5").val("");
                    return;
                }
            }
            var reader = new FileReader();
            reader.onload = imageIsLoaded5;
            reader.readAsDataURL(this.files[0]);
        }
    });

    $("#wizard-picture-6").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("account.error.registrationFormWrongFormat"));
                $('#wizardPicturePreview6').attr('src', img6!=""?hostGetImg+img6:imgDefault);
                $("#wizard-picture-6").val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("account.error.registrationFormTooLarge"));
                    $('#wizardPicturePreview6').attr('src', img6!=""?hostGetImg+img6:imgDefault);
                    $("#wizard-picture-6").val("");
                    return;
                }
            }
            var reader = new FileReader();
            reader.onload = imageIsLoaded6;
            reader.readAsDataURL(this.files[0]);
        }
    });

    getCategoryBusinessAndDevice();
    getInfoAccount();
});


function agreeDksd(el) {
    console.log(el.checked);
    if(el.checked){
        $("#buttonVerifyAccount").attr('disabled', false);
    } else {
        $("#buttonVerifyAccount").attr('disabled', true);
    }
}

var tinhTP = "";
var quanHuyen = "";
var phuongXa = "";
// var tinhTpDN = "";
// var quanHuyenDN = "";
// var phuongXaDN = "";
var img1="";
var img2="";
var img3=""; 
var img5="";
var img6="";
function getInfoAccount() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getInfoAccount();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.status != 401 && datas.content != null){
                var data = datas.content.info;
                // $("#soGpkd").val(data.business_license != null ? data.business_license : "");
                $("#email").val(data.email != null ? data.email : "");
                $("#sdt").val(data.phone != null ? data.phone : "");
                phoneUser = data.phone != null ? data.phone : "";
                $("#hoTen").val(data.name != null ? data.name : "");

                if(data.profile != null){
                    var profile = data.profile;
                    $("#emailContact").val(profile.contact_email != null ? profile.contact_email : "");
                    $("#sdtContact").val(profile.contact_phone != null ? profile.contact_phone : "");

                    if(checkFormatDDMMYYYY(profile.dob)){
                        $("#ngaySinh").val(profile.dob);
                    }
                    // else {
                    //     var dateNow = new Date();
                    //     $("#ngaySinh").val(moment.unix(dateNow.getTime()/1000).format("DD/MM/YYYY"));
                    // }
                    $("#quocTich").val(profile.nationality != null ? profile.nationality : "");

                    tinhTP = profile.province != null ? profile.province : "";
                    // $("#tinhTP").val(tinhTP);

                    quanHuyen = profile.district != null ? profile.district : "";
                    // $("#quanHuyen").val(quanHuyen);

                    phuongXa = profile.ward != null ? profile.ward : "";
                    // $("#phuongXa").val(phuongXa);

                    $("#diaChiChiTiet").val(profile.full_address != null ? profile.full_address : "");
                    $("#gioiTinh").val(profile.gender != null ? profile.gender : "");

                    if(profile.identity_info != null){
                        $("#cmnd").val(profile.identity_info.identity != null ? profile.identity_info.identity : "");
                    }
                    if(profile.profile_image != null && profile.profile_image != ""){
                        $("#wizardPicturePreview1").attr('src', hostGetImg + profile.profile_image);
                        $("#imgOld1").val(profile.profile_image);
                        img1 = profile.profile_image;
                    }

                }
                // if( data.approve_user_info.identity_info != null && data.approve_user_info.status != "REJECTED" && data.approve_user_info.description == ""){
                //     $("#notiApprovedAccount").html("<p style='color: orangered; font-weight: 600;'>" + Messages(" *Thông tin cá nhân đang được kiểm duyệt!") + "</p>")
                // }
                // else {
                //     if ( data.approve_user_info.description!="" && data.approve_user_info.identity_info != null) {
                //         $("#notiApprovedAccount").html("<p style='color: red; font-weight: 600;'>" + Messages(" * Thông tin tài khoản bị từ chối! Bạn vui lòng liên hệ chăm sóc khách hàng để nhận được hỗ trợ!") + "</p>")
                //     } else if ( data.approve_user_info.identity_info == null) {
                //         $("#notiApprovedAccount").html("<p style='color: green; font-weight: 600;'>" + Messages(" *Thông tin cá nhân đã được duyệt!") + "</p>")
                //     }
                // }
                if (data.approve_user_info != null && data.approve_user_info.identity_info == null) {
                    $("#notiApprovedAccount").html("<p style='color: green; font-weight: 600;'>" + Messages("account.status.approved") + "</p>")
                } else {
                    if(data.approve_user_info != null && data.approve_user_info.description == ""){
                        $("#notiApprovedAccount").html("<p style='color: orangered; font-weight: 600;'>" + Messages("account.status.pending") + "</p>")
                    } else {
                        if(data.approve_user_info != null){
                            $("#notiApprovedAccount").html("<p style='color: red; font-weight: 600;'>" + Messages("account.status.rejected") + "</p>")
                        }
                    }
                }
                if(data.approve_user_info != null && data.approve_user_info.identity_info != null && data.approve_user_info.status != "REJECTED"){
                        console.log("photo:"+data.approve_user_info.identity_info);
                        $("#cmnd").val(data.approve_user_info.identity_info.identity != null ? data.approve_user_info.identity_info.identity : "");

                        var imgFront = data.approve_user_info.identity_info.front_image != "" ? data.approve_user_info.identity_info.front_image : "";
                        $("#wizardPicturePreview2").attr('src', hostGetImg + imgFront);
                        $("#imgOld2").val(imgFront);

                        var imgBack = data.approve_user_info.identity_info.back_image != "" ? data.approve_user_info.identity_info.back_image : "";
                        $("#wizardPicturePreview3").attr('src', hostGetImg + imgBack);
                        $("#imgOld3").val(imgBack);

                        var imgAuthorization = data.approve_user_info.identity_info.authorization_letter_image != "" ? data.approve_user_info.identity_info.authorization_letter_image : "";
                        $("#wizardPicturePreview5").attr('src', hostGetImg + imgAuthorization);
                        $("#imgOld5").val(imgAuthorization);

                        var imgRegistration = data.approve_user_info.identity_info.registration_form_image != "" ? data.approve_user_info.identity_info.registration_form_image : "";
                        $("#wizardPicturePreview6").attr('src', hostGetImg + imgRegistration);
                        $("#imgOld6").val(imgRegistration);
                } else {
                        if(data.profile != null) {
                            var profile = data.profile;
                            if(profile.identity_info != null){
                                if(profile.identity_info.front_image != null && profile.identity_info.front_image != ""){
                                    $("#wizardPicturePreview2").attr('src', hostGetImg + profile.identity_info.front_image);
                                    $("#imgOld2").val(profile.identity_info.front_image);
                                    img2 = profile.identity_info.front_image;
                                }
                                if(profile.identity_info.back_image != null && profile.identity_info.back_image != ""){
                                    $("#wizardPicturePreview3").attr('src', hostGetImg + profile.identity_info.back_image);
                                    $("#imgOld3").val(profile.identity_info.back_image);
                                    img3= profile.identity_info.back_image;
                                }

                                if(profile.identity_info.authorization_letter_image != null && profile.identity_info.authorization_letter_image != ""){
                                    $("#wizardPicturePreview5").attr('src', hostGetImg + profile.identity_info.authorization_letter_image);
                                    $("#imgOld5").val(profile.identity_info.authorization_letter_image);
                                    img5 = profile.identity_info.authorization_letter_image;
                                }
                                if(profile.identity_info.registration_form_image != null && profile.identity_info.registration_form_image != ""){
                                    $("#wizardPicturePreview6").attr('src', hostGetImg + profile.identity_info.registration_form_image);
                                    $("#imgOld6").val(profile.identity_info.registration_form_image);
                                    img6 = profile.identity_info.registration_form_image;
                                }
                            }
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
            getListProvince();
            getInfoCompany();
        }
    })
}

var infoCompanyCurrent;
function getInfoCompany() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var header =
                        '<div class="col-md-12">' +
                        '<span class="display-4 title-section-1">'+Messages("account.businessInfo")+'</span>' +
                        '</div>';
                    $("#tab_info_company").html(header);

                    formStt = datas.content.data.length-1;
                    for(var i=0; i<datas.content.data.length; i++){
                        var databody = datas.content.data[i];
                        console.log(databody);

                        var formInfoCompany =
                            '<input id="id_doanh_nghiep_'+i+'" class="id_doanh_nghiep" stt="'+i+'" hidden readonly>\n' +
                            '                        <div class="col-md-12 m-t-3" id="tt_doanh_nghiep_'+i+'" style="border: 1px solid #a2a2a2;">\n' +
                            '                            <div class="row m-t-3">\n' +
                            '                                <div class="col-md-8">\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Tên DN")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <input id="tenDoanhNghiep_'+i+'" type="text" class="form-control input-form" maxlength="250" value="">\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Mã số thuế")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="maSoThue_'+i+'" type="text" class="form-control input-form" maxlength="250" value="">\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Số GPKD")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="soGpkd_'+i+'" type="text" class="form-control input-form id_no" maxlength="250" value="" >\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Ngày thành lập")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="ngayThanhLap_'+i+'" type="text" class="form-control input-form date_timepicker" maxlength="250">\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Số điện thoại DN")+'</label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="sdtDN_'+i+'" type="number" class="form-control input-form" pattern="/^-?\\d+\\.?\\d*$/" onKeyPress="if(this.value.length==11) return false;">\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Email DN")+'</label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <input id="emailDN_'+i+'" type="text" class="form-control input-form" maxlength="250">\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-3">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Địa chỉ")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <div class="col-sm-4">\n' +
                            '                                                    <select class="form-control" id="tinhTpDN_'+i+'" onchange="selectDistrictDN('+i+')">'+listOptionProvince+'</select>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-sm-4">\n' +
                            '                                                    <select class="form-control" id="quanHuyenDN_'+i+'" onchange="selectWardDN('+i+')">\n' +
                            '                                                        <option value="" selected>'+Messages("Huyện/ Quận")+'</option>\n' +
                            '                                                    </select>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-sm-4">\n' +
                            '                                                    <select class="form-control" id="phuongXaDN_'+i+'">\n' +
                            '                                                        <option value="" selected>'+Messages("Phường/Xã")+'</option>\n' +
                            '                                                    </select>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-sm-12 m-t-3">\n' +
                            '                                                    <input id="diaChiChiTietDN_'+i+'" type="text" class="form-control input-form" maxlength="250" placeholder="Địa chỉ chi tiết">\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +

                            '                                   <div class="row m-t-3">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Lĩnh vực")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <select class="form-control" id="linhVuc_'+i+'" multiple="multiple">\n' +
                                                                            dsLinhVuc +
                            '                                            </select>\n' +
                            '                                        </div>\n' +
                            '                                    </div>'+
                            '                                   <div class="row m-t-3">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Dòng thiết bị")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <select class="form-control" id="dongThietBi_'+i+'" multiple="multiple">\n' +
                                                                            dsDongThietBi +
                            '                                            </select>\n' +
                            '                                        </div>\n' +
                            '                                    </div>'+

                            '                                </div>\n' +
                            '                                <div class="col-md-4">\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <label class="col-sm-12 col-form-label title-section-2">'+Messages("Ảnh GPKD")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '                                        <div class="col-sm-12 position-relative">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <div class="col-md-4 position-relative">\n' +
                            '                                                    <input id="imgOld4_'+i+'" type="text" class="form-control" hidden>\n' +
                            '                                                    <input id="changeImg4_'+i+'" type="checkbox" hidden>\n' +
                            '                                                    <div class="d-flex flex-column align-items-center text-center square-item" >\n' +
                            '                                                        <img src="'+imgDefault+'" id="wizardPicturePreview4_'+i+'" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">\n' +
                            '                                                        <input id="wizard-picture-4_'+i+'" onchange="onchangeImg(this, '+i+')" stt="'+i+'" name="avatar" type="file" hidden/>' +
                            '                                                    </div>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-md-8 position-relative">\n' +
                            '                                                    <label class="form-label ">'+Messages("Upload image")+'</label><br>\n' +
                            '                                                    <label class="form-label ">'+Messages("Kéo thả file ảnh hoặc mở file ")+'<a onclick="$(\'#wizard-picture-4_'+i+'\').click();" class="cursor-pointer text-danger">'+Messages("tại đây")+'</a></label>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-md-12 position-relative">\n' +
                            '                                                    <small class="form-label ">'+Messages("File jpg, png,... dung lượng file không quá 3mb")+'</small>\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>' +
                            '                                </div>' +
                            '                                <div class="col-md-12">\n' +
                            '                                    <div class="row m-t-3">\n' +
                            '                                            <label class="col-sm-12 col-form-label title-section-2" id="notiApproved_'+i+'"></label>\n' +
                            '                                   </div>' +
                            '                               </div>' +
                            '                       </div>' +
                            '<div class="row m-t-2 m-b-4">' +
                            '<div class="col-md-12 mx-auto text-center">' +
                            '<button type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getOtpUpdateEnterprise('+i+')">'+Messages("btnComfirm")+'</button>';
                        // if(i < datas.content.data.length-1){
                            formInfoCompany +=
                                '<button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="comfirmRemoveInfoEnterprise('+i+')">'+Messages("Yêu cầu xóa")+'</button>';
                        // }
                        formInfoCompany +=
                            '</div>' +
                            '</div>'+
                            '</div>';
                        $("#tab_info_company").append(formInfoCompany);

                        $('#linhVuc_'+i).select2({
                            theme: 'bootstrap4',
                            width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                            placeholder: $(this).data('placeholder'),
                            allowClear: Boolean($(this).data('allow-clear'))
                        });
                        $('#dongThietBi_'+i).select2({
                            theme: 'bootstrap4',
                            width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                            placeholder: $(this).data('placeholder'),
                            allowClear: Boolean($(this).data('allow-clear'))
                        });

                        var business_types = databody.business_types;
                        if(business_types != null && business_types.length > 0){
                            var dsLV = new Array();
                            business_types.forEach(function (item) {
                                dsLV.push(item.code);
                            });
                            $('#linhVuc_'+i).val(dsLV).trigger('change');
                        }

                        var device_types = databody.device_types;
                        if(device_types != null && device_types.length > 0){
                            var dsDTB = new Array();
                            device_types.forEach(function (item) {
                                dsDTB.push(item.code);
                            });
                            $('#dongThietBi_'+i).val(dsDTB).trigger('change');
                        }


                        if(databody.action != "DELETE"){
                            if(databody.approve_status == "SUBMITTED"){
                                databody = databody.update_info;
                                $("#notiApproved_"+i).html("<p style='color: orangered; font-weight: 600;'>"+Messages("*Thông tin doanh nghiệp đang được kiểm duyệt!")+"</p>");
                            } else if(databody.approve_status == "REJECTED"){
                                // databody = databody.update_info;
                                $("#notiApproved_"+i).html("<p style='color: red; font-weight: 600;'>"+Messages("*Thông tin doanh nghiệp bị từ chối! Bạn vui lòng liên hệ chăm sóc khách hàng để nhận được hỗ trợ.")+"</p>");
                            } else if(databody.approve_status == "APPROVED"){
                                $("#notiApproved_"+i).html("<p style='color: green; font-weight: 600;'>"+Messages("*Doanh nghiệp đã được duyệt!")+"</p>");
                            } else {
                                $("#notiApproved_"+i).html("");
                            }
                        } else {
                            if(databody.approve_status == "REJECTED") {
                                $("#notiApproved_" + i).html("<p style='color: red; font-weight: 600;'>" + Messages("*Yêu cầu xóa thông tin doanh nghiệp bị từ chối! Bạn vui lòng liên hệ chăm sóc khách hàng để nhận được hỗ trợ!") + "</p>");
                            }
                            else {
                                $("#notiApproved_" + i).html("<p style='color: orangered; font-weight: 600;'>" + Messages("*Thông tin doanh nghiệp đang chờ duyệt xóa") + "</p>");
                            }

                        }

                        $("#id_doanh_nghiep_"+i).val(databody.id != null ? databody.id : "");
                        $("#tenDoanhNghiep_"+i).val(databody.name != null ? databody.name : "");
                        $("#maSoThue_"+i).val(databody.tax_code != null ? databody.tax_code : "");

                        //nếu giấy phép kinh doanh ở business_license trống thì có thể tìm kiếm gpkd ở business_license_update
                        if(databody.business_license === null || databody.business_license === ""){
                            $("#soGpkd_"+i).val( databody.business_license_update);
                        }
                        else {
                            $("#soGpkd_"+i).val( databody.business_license);
                        }
                        if(checkFormatDDMMYYYY(databody.founded)){
                            $("#ngayThanhLap_"+i).val(databody.founded);
                        } else {
                            var dateNow = new Date();
                            $("#ngayThanhLap_"+i).val(moment.unix(dateNow.getTime()/1000).format("DD/MM/YYYY"));
                        }
                        $("#sdtDN_"+i).val(databody.phone != null ? databody.phone : "");
                        $("#emailDN_"+i).val(databody.email != null ? databody.email : "");

                        $("#diaChiChiTietDN_"+i).val(databody.full_address != null ? databody.full_address : "");

                        if(databody.business_license_image != null && databody.business_license_image != ""){
                            $("#wizardPicturePreview4_"+i).attr('src', hostGetImg + databody.business_license_image);
                            $("#imgOld4_"+i).val(databody.business_license_image);
                        }

                        var tinhTpDN = databody.province != null ? databody.province : "";
                        var quanHuyenDN = databody.district != null ? databody.district : "";
                        var phuongXaDN = databody.ward != null ? databody.ward : "";
                        getListProvinceDN(tinhTpDN, quanHuyenDN, phuongXaDN, i);
                    }

                }
                else {
                    $("#linhVuc_0").html(dsLinhVuc);
                    $("#dongThietBi_0").html(dsDongThietBi);

                    $('#linhVuc_0').select2({
                        theme: 'bootstrap4',
                        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                        placeholder: $(this).data('placeholder'),
                        allowClear: Boolean($(this).data('allow-clear'))
                    });
                    $('#dongThietBi_0').select2({
                        theme: 'bootstrap4',
                        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                        placeholder: $(this).data('placeholder'),
                        allowClear: Boolean($(this).data('allow-clear'))
                    });
                }
            } else {
                $("#linhVuc_0").html(dsLinhVuc);
                $("#dongThietBi_0").html(dsDongThietBi);

                $('#linhVuc_0').select2({
                    theme: 'bootstrap4',
                    width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                    placeholder: $(this).data('placeholder'),
                    allowClear: Boolean($(this).data('allow-clear'))
                });
                $('#dongThietBi_0').select2({
                    theme: 'bootstrap4',
                    width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                    placeholder: $(this).data('placeholder'),
                    allowClear: Boolean($(this).data('allow-clear'))
                });
                // if(datas.status == 401){
                //     showNotification('danger', Messages("noti.sessionTimeOut"));
                //     window.location.href = jsRoutes.controllers.Application.logout().url;
                // } else {
                //     showNotification('danger', datas.errorString);
                // }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
            $('.date_timepicker').bootstrapMaterialDatePicker({
                format: 'DD/MM/YYYY',
                time: false
            });

            getListProvinceDN();
        }
    })
}

function zoomImg(el) {
    console.log(el.src);
    $("#imgZoom").attr('src', el.src);
    $("#imgZoomModal").modal('show');
}

function checkFormatDDMMYYYY(input) {
    if(input != "" && input != undefined && input != null){
        var pattern =/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
        return pattern.test(input);
    } else {
        return false;
    }
}

function imageIsLoaded1(e) {
    $('#wizardPicturePreview1').attr('src', e.target.result);
    // document.getElementById("buttonResetImg1").style.display = 'block';
}
function imageIsLoaded2(e) {
    $('#wizardPicturePreview2').attr('src', e.target.result);
    // document.getElementById("buttonResetImg2").style.display = 'block';
}
function imageIsLoaded3(e) {
    $('#wizardPicturePreview3').attr('src', e.target.result);
    // document.getElementById("buttonResetImg3").style.display = 'block';
}
function imageIsLoaded4(e) {
    $('#wizardPicturePreview4_0').attr('src', e.target.result);
    // document.getElementById("buttonResetImg4").style.display = 'block';
}
function imageIsLoaded5(e) {
    $('#wizardPicturePreview5').attr('src', e.target.result);
    // document.getElementById("buttonResetImg5").style.display = 'block';
}
function imageIsLoaded6(e) {
    $('#wizardPicturePreview6').attr('src', e.target.result);
    // document.getElementById("buttonResetImg6").style.display = 'block';
}
function imageIsLoadedStt(e, stt) {
    $('#wizardPicturePreview4_'+stt).attr('src', e.target.result);
    // document.getElementById("buttonResetImg6").style.display = 'block';
}
function resetImageNumber(el) {
    $('#wizardPicturePreview'+el).attr('src', imgDefault);
    $("#wizard-picture-"+el).val("");
    // document.getElementById("buttonResetImg"+el).style.display = 'none';
}