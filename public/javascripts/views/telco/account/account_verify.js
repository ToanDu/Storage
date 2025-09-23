/**
 * Created by vtk-anhlt166 on 10/31/22.
 */
var myTimer;
var second = 180;
function otpPhone() {


    console.log(document.getElementsByClassName("id_doanh_nghiep"));
    var listFormDN = document.getElementsByClassName("id_doanh_nghiep");
    var countInfoFalse = 0;
    for(var i=0; i<listFormDN.length; i++){
        console.log(listFormDN[i].id);
        var id = listFormDN[i].id;
        var stt = id.replace("id_doanh_nghiep_", "");
        console.log(stt);

        var formCompany = document.getElementById("tt_doanh_nghiep_"+stt);
        if(formCompany != null && formCompany != undefined){
            if(!validateText("tenDoanhNghiep_"+stt)){
                countInfoFalse++;
                showNotification('danger', Messages("account.error.businessNameRequired"));
                break;
            }
            if(!validateText("maSoThue_"+stt)){
                countInfoFalse++;
                showNotification('danger', Messages("account.error.taxCodeRequired"));
                break;
            }
            if(!validateText("soGpkd_"+stt)){
                countInfoFalse++;
                showNotification('danger', Messages("account.error.businessLicenseNumberRequired"));
                break;
            }
            if(!validateText("ngayThanhLap_"+stt)){
                countInfoFalse++;
                showNotification('danger', Messages("account.error.establishmentDateRequired"));
                break;
            }
            if(!validateTimeCurrent("ngayThanhLap_"+stt)){
                countInfoFalse++;
                showNotification('danger',Messages("account.error.establishmentDateInvalid"));
                break;
            }
            if($('#sdtDN_'+stt).val().length > 0){
                if(!validatePhoneVn($('#sdtDN_'+stt).val())){
                    countInfoFalse++;
                    showNotification('danger', Messages("account.error.businessPhoneInvalid"));
                    break;
                }
            }
            if($('#emailDN_'+stt).val().trim().length > 0){
                if(!validateEmail($('#emailDN_'+stt).val().trim())){
                    countInfoFalse++;
                    showNotification('danger', Messages("account.error.businessEmailInvalid"));
                    break;
                }
            }
            if(!validateText("tinhTpDN_"+stt) || !validateText("quanHuyenDN_"+stt) || !validateText("phuongXaDN_"+stt)){
                countInfoFalse++;
                showNotification('danger', Messages("account.error.addressRequired"));
                break;
            }
            if(!validateText("diaChiChiTietDN_"+stt)){
                countInfoFalse++;
                showNotification('danger', Messages("account.error.detailAddressRequired"));
                break;
            }
            if($("#imgOld4_"+stt).val().length == 0){
                if($("#wizard-picture-4_"+stt).prop("files")[0] == null || $("#wizard-picture-4_"+stt).prop("files")[0] == undefined){
                    countInfoFalse++;
                    showNotification('danger', Messages("account.error.businessLicenseImageRequired"));
                    break;
                }
            }
        }
    }

    console.log(countInfoFalse);
    if(countInfoFalse > 0){
        // showNotification('danger', Messages("Vui lòng up đầy đủ thông tin doanh nghiệp"));
        return;
    }

    //check trung gpkd
    var listIdNo = document.getElementsByClassName("id_no");
    var arrCheck = [];
    var countCheck = 0;
    for(var i=0; i<listIdNo.length; i++){
        console.log(listIdNo[i].value.trim());
        if(arrCheck.includes(listIdNo[i].value.trim())){
            countCheck++;
        } else {
            arrCheck.push(listIdNo[i].value.trim());
        }
    }
    if(countCheck > 0){
        showNotification('danger', Messages("account.error.businessLicenseDuplicate"));
        return;
    }

    console.log(second);
    if(second < 120){
        return;
    }

    var data = new FormData();
    data.phone = $('#sdt').val();
    if(data.phone.length < 9 || data.phone.length > 11){
        showNotification('danger', Messages("account.error.phoneInvalid"));
        return;
    }
    console.log(data);
    StartProcess();
    var r = jsRoutes.controllers.Application.getOtpPhone();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                $("#optPhoneModal").modal('show');
                $("#inputOtpPhone").val("");
                showNotification('success', data.resultString);

                myTimer = setInterval(function () {
                    // console.log(second);
                    if(second > 0){
                        $("#buttonGetOtpPhone").html("Nhập OTP (" + second + ")");
                        second--;
                    } else {
                        $("#buttonGetOtpPhone").html("Nhận mã OTP");
                        clearInterval(myTimer);
                        second = 180;
                    }
                },1000);

                $("#inputOtpPhone").focus();
            } else {
                if(data.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('danger', data.errorString);
                }
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

function clearinterval() {
    clearInterval(myTimer);
    second = 180;
}

function activePhone() {
    if($('#inputOtpPhone').val().trim().length == 0){
        showNotification('danger', Messages("account.error.otpRequired"));
        return;
    }
    var data = new FormData();
    data.phone = $('#sdt').val();
    data.otp = $('#inputOtpPhone').val();
    console.log(data);
    StartProcess();
    var r = jsRoutes.controllers.ProjectController.activePhone();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                clearinterval();

                $("#optPhoneModal").modal('hide');
                verifyFormInfoAccount();
            } else {
                if(data.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('danger', data.errorString);
                    FinishProcess();
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            // FinishProcess();
        }
    })
}



var listStt = new Array();
var listSttDelInfo = new Array();
function verifyFormInfoCompany() {
    listStt = [];
    listSttDelInfo = [];
    var listFormDN = document.getElementsByClassName("id_doanh_nghiep");
    for(var i=0; i<listFormDN.length; i++) {
        console.log(listFormDN[i].id);
        var id = listFormDN[i].id;
        var stt = id.replace("id_doanh_nghiep_", "");
        console.log(stt);

        var formCompany = document.getElementById("tt_doanh_nghiep_"+stt);
        if(formCompany != null && formCompany != undefined){
            listStt.push(stt);
        } else {
            if($("#"+id).val() != null && $("#"+id).val() != undefined && $("#"+id).val() != ""){
                listSttDelInfo.push(stt);
            }
        }
    }

    console.log("listStt : " + listStt);
    if(listStt.length > 0){
        processUpdateInfoCompany(0);
    }
    console.log("listSttDelInfo : " + listSttDelInfo);
    if(listSttDelInfo.length > 0){
        processDeleteInfoCompany(0);
    }
}



function processDeleteInfoCompany(index) {
    var stt = listSttDelInfo[index];
    var groupData = new FormData();
    groupData.enterpriseId = $('#id_doanh_nghiep_'+stt).val();
    console.log(groupData);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.deleteInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', Messages("account.success.businessDeleteRequest") + $('#tenDoanhNghiep_'+stt).val().trim());
            } else {
                if(data.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('danger', data.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(index < listSttDelInfo.length-1){
                processDeleteInfoCompany(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}