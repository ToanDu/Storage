function getOtpUpdateInfoAcc() {
    //validate
    if(!validateText("hoTen")){
        showNotification('danger', Messages("Họ tên không được bỏ trống"));
        return;
    }
    if($('#sdt').val().length > 0){
        console.log(validatePhoneVn($('#sdt').val()));
        if(validatePhoneVn($('#sdt').val()) == false){
            showNotification('danger', Messages("Số điện thoại không đúng định dạng"));
            return;
        }
    } else {
        showNotification('danger', Messages("Số điện thoại không được bỏ trống"));
        return;
    }
    if(!validateTimeCurrent("ngaySinh")){
        showNotification('danger',Messages("Ngày sinh không được lớn hơn ngày hiện tại"));
        return;
    }
    var dateString = $('#ngaySinh').val();
    var dateMomentObject = moment(dateString, "DD/MM/YYYY");
    var dateObject = dateMomentObject.toDate();
    var now = new Date();
    console.log((now.getTime() - dateObject.getTime())/1000);
    if((now.getTime() - dateObject.getTime())/1000 < 441504000){
        showNotification('danger',Messages("Thông tin người đại diện không đủ 14 tuổi"));
        return;
    }

    if(!validateTimeCurrent("ngayThanhLap")){
        showNotification('danger',Messages("Ngày thành lập không được lớn hơn ngày hiện tại"));
        return;
    }

    // if($("#imgOld1").val().length == 0){
    //     if($("#wizard-picture-1").prop("files")[0] == null || $("#wizard-picture-1").prop("files")[0] == undefined){
    //         showNotification('danger', Messages("Vui lòng up ảnh đại diện"));
    //         return;
    //     }
    // }
    console.log($("#imgOld2").val());
    console.log($("#imgOld3").val());
    console.log($("#imgOld5").val());
    console.log($("#imgOld6").val());
    if($("#imgOld2").val().length == 0){
        if($("#wizard-picture-2").prop("files")[0] == null || $("#wizard-picture-2").prop("files")[0] == undefined){
            showNotification('danger', Messages("Vui lòng up ảnh mặt trước CMT/CCCD"));
            console.log($("#wizard-picture-2").prop("files")[0]);
            return;
        }
    }
    if($("#imgOld3").val().length == 0){
        if($("#wizard-picture-3").prop("files")[0] == null || $("#wizard-picture-3").prop("files")[0] == undefined){
            showNotification('danger', Messages("Vui lòng up ảnh mặt sau CMT/CCCD"));
            console.log($("#wizard-picture-3").prop("files")[0]);
            return;
        }
    }
    if($("#imgOld5").val().length == 0){
        if($("#wizard-picture-5").prop("files")[0] == null || $("#wizard-picture-5").prop("files")[0] == undefined){
            showNotification('danger', Messages("Vui lòng up ảnh giấy ủy quyền"));
            return;
        }
    }
    if($("#imgOld6").val().length == 0){
        if($("#wizard-picture-6").prop("files")[0] == null || $("#wizard-picture-6").prop("files")[0] == undefined){
            showNotification('danger', Messages("Vui lòng up ảnh phiếu đăng ký tài khoản"));
            return;
        }
    }

    var data = new FormData();
    data.phone = $('#sdt').val();
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
                $("#updateInfoAccModal").modal('show');
                $("#optUpdateInfoAcc").val("");
                showNotification('success', data.resultString);
            } else {
                if(data.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('danger', data.errorString);
                }
            }
            $("#updateInfoAccModal").modal('show');
            $("#optUpdateInfoAcc").val("");
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

function processUpdateInfoAcc() {
    if($('#optUpdateInfoAcc').val().length == 0){
        showNotification('danger', Messages("Bạn chưa nhập mã OTP"));
        return;
    }
    var data = new FormData();
    data.phone = $('#sdt').val();
    data.otp = $('#optUpdateInfoAcc').val();
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
                $("#updateInfoAccModal").modal('hide');
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

function verifyFormInfoAccount() {
    var email = $('#emailContact').val().trim();
    if (email && email.length > 128) {
        showNotification('danger', Messages("Email không được vượt quá 128 ký tự"));
        return;
    }
    if (email && !validateEmail(email)) {
        showNotification('danger', Messages("Email không hợp lệ"));
        return;
    }

    var sdtContact = $('#sdtContact').val().trim();
    if (sdtContact.length > 0 && !validatePhoneVn(sdtContact)) {
        showNotification('danger', Messages("Định dạng của số điện thoại này không đúng. Vui lòng kiếm tra lại số điện thoại"));
        return;
    }

    var groupData = new FormData();
    groupData.append("hoTen", $('#hoTen').val().trim());
    groupData.append("cmnd", $('#cmnd').val().trim());
    groupData.append("sdt", $('#sdt').val());
    groupData.append("ngaySinh", $('#ngaySinh').val());
    groupData.append("sdt", $('#sdtContact').val()==null?"":$('#sdtContact').val());
    if ($('#quocTich').val()== null){
        groupData.append("quocTich", $('#quocTich').val());
    }else{
        groupData.append("quocTich", $('#quocTich').val().trim());
    }
    groupData.append("tinhTP", $('#tinhTP').val());
    groupData.append("quanHuyen", $('#quanHuyen').val());
    groupData.append("phuongXa", $('#phuongXa').val());
    groupData.append("diaChiChiTiet", $('#diaChiChiTiet').val().trim());
    groupData.append("gioiTinh", $('#gioiTinh').val());
    groupData.append("emailContact", email);
    groupData.append("sdtContact", sdtContact);
    if($("#wizard-picture-1").prop("files")[0] != null && $("#wizard-picture-1").prop("files")[0] != undefined){
        groupData.append("image_1", $("#wizard-picture-1").prop("files")[0]);
    }
    groupData.append("imgOld1", $("#imgOld1").val());

    if($("#wizard-picture-5").prop("files")[0] != null && $("#wizard-picture-5").prop("files")[0] != undefined){
        groupData.append("image_5", $("#wizard-picture-5").prop("files")[0]);
    }
    groupData.append("imgOld5", $("#imgOld5").val());

    if($("#wizard-picture-6").prop("files")[0] != null && $("#wizard-picture-6").prop("files")[0] != undefined){
        groupData.append("image_6", $("#wizard-picture-6").prop("files")[0]);
    }
    groupData.append("imgOld6", $("#imgOld6").val());

    if($("#wizard-picture-2").prop("files")[0] != null && $("#wizard-picture-2").prop("files")[0] != undefined){
        groupData.append("image_2", $("#wizard-picture-2").prop("files")[0]);
    }
    groupData.append("imgOld2", $("#imgOld2").val());

    if($("#wizard-picture-3").prop("files")[0] != null && $("#wizard-picture-3").prop("files")[0] != undefined){
        groupData.append("image_3", $("#wizard-picture-3").prop("files")[0]);
    }
    groupData.append("imgOld3", $("#imgOld3").val());
    // for (const [key, value] of groupData.entries()) {
    // console.log(key, value);
    // }
    console.log(groupData);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.updateDetailAccountTelco();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.content != null){
                if(data.content.updateUser){
                    showNotification('success', Messages("Cập nhật thông tin tài khoản thành công"));
                    setTimeout(function () {
                        window.location.reload();
                    },1500);
                } else {
                    showNotification('danger', Messages("Cập nhật thông tin tài khoản không thành công"));
                }
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
            FinishProcess();
        },
        complete: function (){
            FinishProcess();
        }
    })
}
var groupData = new FormData();
function verifyFormInfoAccountTest() {

    groupData.append("hoTen", $('#hoTen').val().trim());
    groupData.append("cmnd", $('#cmnd').val().trim());
    groupData.append("sdt", $('#sdt').val());
    groupData.append("ngaySinh", $('#ngaySinh').val());
    if ($('#quocTich').val()== null){
        groupData.append("quocTich", $('#quocTich').val());
    }else{
        groupData.append("quocTich", $('#quocTich').val().trim());
    }
    groupData.append("tinhTP", $('#tinhTP').val());
    groupData.append("quanHuyen", $('#quanHuyen').val());
    groupData.append("phuongXa", $('#phuongXa').val());
    groupData.append("diaChiChiTiet", $('#diaChiChiTiet').val().trim());
    groupData.append("gioiTinh", $('#gioiTinh').val());

    groupData.append("imgOld1", $("#imgOld1").val());

    groupData.append("imgOld5", $("#imgOld5").val());

    groupData.append("imgOld6", $("#imgOld6").val());

    groupData.append("imgOld2", $("#imgOld2").val());

    groupData.append("imgOld3", $("#imgOld3").val());
    var wizardIds = ["wizard-picture-1", "wizard-picture-2", "wizard-picture-3", "wizard-picture-5", "wizard-picture-6"];

    executeSequentially(wizardIds, 0);

}
function executeSequentially(idsArray, index, callback) {
    if (index < idsArray.length) {
        // sendImageRequest(idsArray[index]);
        // setTimeout(function() {
        //     executeSequentially(idsArray, index + 1);
        // }, 100); // Đợi 0.5 giây trước khi thực hiện hàm tiếp theo
        sendImageRequest(idsArray[index], function() {
            executeSequentially(idsArray, index + 1, callback);
        });
    }else{
        StartProcess();
        var r = jsRoutes.controllers.TelcoAccountController.updateDetailAccountTelco();
        $.ajax({
            type: r.type,
            data: groupData,
            contentType: false,
            processData: false,
            url: r.url,
            success: function(data){
                console.log(data);
                if(data.content != null){
                    if(data.content.updateUser){
                        showNotification('success', Messages("Cập nhật thông tin tài khoản thành công"));
                        setTimeout(function () {
                            window.location.reload();
                        },1500);
                    } else {
                        showNotification('danger', Messages("Cập nhật thông tin tài khoản không thành công"));
                    }
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
                FinishProcess();
            },
            complete: function (){
                FinishProcess();
            }
        })

    }
}
function sendImageRequest(wizardId, callback) {

    var groupDataFile = new FormData();

    if ($("#" + wizardId).prop("files")[0] != null && $("#" + wizardId).prop("files")[0] != undefined) {
        groupDataFile.append("image", $("#" + wizardId).prop("files")[0]);
    }

    StartProcess();
    var route = jsRoutes.controllers.SendApiController.upfileImage();

    $.ajax({
        type: route.type,
        data: groupDataFile,
        contentType: false,
        processData: false,
        url: route.url,
        success: function (data) {
            // FinishProcess();
            if (data.content != null){

                if(wizardId === "wizard-picture-1"){
                    groupData.append("imageName1", data.content.link);
                    console.log(data.content.link)
                }
                if(wizardId === "wizard-picture-2"){
                    groupData.append("imageName2", data.content.link);
                    console.log(data.content.link)
                }
                if(wizardId === "wizard-picture-3"){
                    groupData.append("imageName3", data.content.link);
                    console.log(data.content.link)
                }
                if(wizardId === "wizard-picture-5"){
                    groupData.append("imageName5", data.content.link);
                    console.log(data.content.link)
                }
                if(wizardId === "wizard-picture-6"){
                    groupData.append("imageName6", data.content.link);
                    console.log(data.content.link)
                }
            }
            callback();


        },
        error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
                // FinishProcess();
            },
        complete: function () {
            // FinishProcess();
        }
    })


}