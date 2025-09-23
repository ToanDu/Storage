function getOtpUpdateEnterprise(stt) {
    if(!validateText("tenDoanhNghiep_"+stt)){
        showNotification('danger', Messages("Vui lòng điền đầy đủ tên doanh nghiệp"));
        return;
    }
    if(!validateText("maSoThue_"+stt)){
        showNotification('danger', Messages("Vui lòng điền đầy đủ mã số thuế"));
        return;
    }
    if(!validateText("soGpkd_"+stt)){
        showNotification('danger', Messages("Vui lòng điền đầy đủ số giấy phép kinh doanh"));
        return;
    }
    if(!validateText("ngayThanhLap_"+stt)){
        showNotification('danger', Messages("Vui lòng điền đầy đủ ngày thành lập"));
        return;
    }
    if(!validateTimeCurrent("ngayThanhLap_"+stt)){
        showNotification('danger',Messages("Ngày thành lập không được lớn hơn ngày hiện tại"));
        return;
    }
    if($('#sdtDN_'+stt).val().length > 0){
        if(!validatePhoneVn($('#sdtDN_'+stt).val())){
            showNotification('danger', Messages("Số điện thoại doanh nghiệp không dúng định dạng"));
            return;
        }
    }
    if($('#emailDN_'+stt).val().trim().length > 0){
        if(!validateEmail($('#emailDN_'+stt).val().trim())){
            showNotification('danger', Messages("Email doanh nghiệp không dúng định dạng"));
            return;
        }
    }
    if(!validateText("tinhTpDN_"+stt) || !validateText("quanHuyenDN_"+stt) || !validateText("phuongXaDN_"+stt)){
        showNotification('danger', Messages("Vui lòng chọn địa chỉ Tỉnh/Thành phố, Quận huyện và Phường xã"));
        return;
    }
    if(!validateText("diaChiChiTietDN_"+stt)){
        showNotification('danger', Messages("Vui lòng điền đầy đủ địa chỉ chi tiết"));
        return;
    }
    if($("#imgOld4_"+stt).val().length == 0){
        if($("#wizard-picture-4_"+stt).prop("files")[0] == null || $("#wizard-picture-4_"+stt).prop("files")[0] == undefined){
            showNotification('danger', Messages("Vui lòng up đầy đủ ảnh GPKD"));
            return;
        }
    }

    console.log($('#linhVuc_'+stt).val());
    if($("#linhVuc_"+stt).val().length == 0){
        showNotification('danger', Messages("Vui lòng chọn lĩnh vực hoạt động của doanh nghiệp"));
        return;
    }
    console.log($('#dongThietBi_'+stt).val());
    if($("#dongThietBi_"+stt).val().length == 0){
        showNotification('danger', Messages("Vui lòng chọn dòng thiết bị của doanh nghiệp"));
        return;
    }

    var gpkd = $("#soGpkd_"+stt).val().trim();
    var data = new FormData();
    data.idNo = gpkd;
    console.log(data);
    var phoneGetOtp = $("#sdt").val().trim();
    console.log(phoneGetOtp)
    if(phoneGetOtp.length > 0){
        var select = '<select class="form-control" id="numberRepresent_'+stt+'">';
        select += '<option value="'+phoneGetOtp+'">'+phoneGetOtp+'</option>';
        select += '</select>';
        $("#phoneRepresent").html(select);
        $("#buttonOtpOfEnterprise").html('<a onclick="getOtpOfEnterprise('+stt+')" class="input-group-text cursor-pointer">'+Messages("Lấy mã")+'</a>');
        $("#buttonUpdateEnterprise").html('<button type="button" class="btn btn-danger" onclick="processUpdateEnterprise('+stt+')">'+Messages("btnComfirm")+'</button>');
        $("#updateEnterpriseModal").modal('show');
    } else {
        //showNotification('danger', Messages("Không tìm thấy thuê bao đại diện"));

        StartProcess();
        var r = jsRoutes.controllers.TelcoContractController.getListContractByIdNo();
        $.ajax({
            type: r.type,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (data) {
                console.log(data);
                if (data.success && data.content != null) {
                    var listAccountDTO = data.content.listAccountDTO;
                    if (listAccountDTO != null && listAccountDTO.length > 0) {
                        var select = '<select class="form-control" id="numberRepresent_' + stt + '">';
                        for (var i = 0; i < listAccountDTO.length; i++) {
                            select += '<option value="0' + listAccountDTO[i].isdn + '">' + "0" + listAccountDTO[i].isdn + '</option>'
                        }
                        select += '</select>';
                        $("#phoneRepresent").html(select);
                        $("#buttonOtpOfEnterprise").html('<a onclick="getOtpOfEnterprise(' + stt + ')" class="input-group-text cursor-pointer">' + Messages("Lấy mã") + '</a>');
                        $("#buttonUpdateEnterprise").html('<button type="button" class="btn btn-danger" onclick="processUpdateEnterprise(' + stt + ')">' + Messages("btnComfirm") + '</button>');
                        $("#updateEnterpriseModal").modal('show');
                    } else {
                        //get phone of user
                        if (phoneUser.length > 0) {
                            var select = '<select class="form-control" id="numberRepresent_' + stt + '">';
                            select += '<option value="' + phoneUser + '">' + phoneUser + '</option>';
                            select += '</select>';
                            $("#phoneRepresent").html(select);
                            $("#buttonOtpOfEnterprise").html('<a onclick="getOtpOfEnterprise(' + stt + ')" class="input-group-text cursor-pointer">' + Messages("Lấy mã") + '</a>');
                            $("#buttonUpdateEnterprise").html('<button type="button" class="btn btn-danger" onclick="processUpdateEnterprise(' + stt + ')">' + Messages("btnComfirm") + '</button>');
                            $("#updateEnterpriseModal").modal('show');
                        } else {
                            showNotification('danger', Messages("Không tìm thấy thuê bao đại diện"));
                        }
                    }

                } else {
                    //get phone of user
                    if (phoneUser.length > 0) {
                        var select = '<select class="form-control" id="numberRepresent_' + stt + '">';
                        select += '<option value="' + phoneUser + '">' + phoneUser + '</option>';
                        select += '</select>';
                        $("#phoneRepresent").html(select);
                        $("#buttonOtpOfEnterprise").html('<a onclick="getOtpOfEnterprise(' + stt + ')" class="input-group-text cursor-pointer">' + Messages("Lấy mã") + '</a>');
                        $("#buttonUpdateEnterprise").html('<button type="button" class="btn btn-danger" onclick="processUpdateEnterprise(' + stt + ')">' + Messages("btnComfirm") + '</button>');
                        $("#updateEnterpriseModal").modal('show');
                    } else {
                        showNotification('danger', Messages("Không tìm thấy thuê bao đại diện"));
                    }
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
            },
            complete: function () {
                FinishProcess();
            }
        })
    }
}

function getOtpOfEnterprise(stt) {
    var numberRepresent = $("#numberRepresent_"+stt).val();
    console.log(numberRepresent);
    if(numberRepresent != null && numberRepresent.length > 0){
        var data = new FormData();
        data.phone = numberRepresent;
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
                    showNotification('success', data.resultString);
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
    } else {
        showNotification('danger', Messages("Bạn chưa chọn thuê bao đại diện"));
    }
}

function processUpdateEnterprise(stt) {
    if($('#optUpdateEnterprise').val().trim().length == 0){
        showNotification('danger', Messages("Bạn chưa nhập mã OTP"));
        return;
    }
    var data = new FormData();
    data.phone = $("#numberRepresent_"+stt).val();
    data.otp = $('#optUpdateEnterprise').val();
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
                submitUpdateEnterprise(stt);
            } else {
                showNotification('danger', data.errorString);
                FinishProcess();
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

function submitUpdateEnterprise(stt) {
    if($('#optUpdateEnterprise').val().trim().length == 0){
        showNotification('danger', Messages("Bạn chưa nhập mã OTP"));
        return;
    }

    var groupData = new FormData();
    groupData.append("idDoanhNghiep", $('#id_doanh_nghiep_'+stt).val());
    groupData.append("tenDoanhNghiep", $('#tenDoanhNghiep_'+stt).val().trim());
    groupData.append("maSoThue", $('#maSoThue_'+stt).val().trim());
    groupData.append("soGpkd", $('#soGpkd_'+stt).val().trim());
    groupData.append("ngayThanhLap", $('#ngayThanhLap_'+stt).val());
    groupData.append("sdtDN", $('#sdtDN_'+stt).val().trim());
    groupData.append("emailDN", $('#emailDN_'+stt).val().trim());
    groupData.append("tinhTpDN", $('#tinhTpDN_'+stt).val());
    groupData.append("quanHuyenDN", $('#quanHuyenDN_'+stt).val());
    groupData.append("phuongXaDN", $('#phuongXaDN_'+stt).val());
    groupData.append("diaChiChiTietDN", $('#diaChiChiTietDN_'+stt).val().trim());
    if($("#wizard-picture-4_"+stt).prop("files")[0] != null && $("#wizard-picture-4_"+stt).prop("files")[0] != undefined){
        groupData.append("image_1", $("#wizard-picture-4_"+stt).prop("files")[0]);
    }
    groupData.append("imgOld1", $("#imgOld4_"+stt).val());

    groupData.append("dsLinhVuc", $("#linhVuc_"+stt).val().toString());
    groupData.append("dsDongThietBi", $("#dongThietBi_"+stt).val().toString());

    console.log(groupData);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.updateInfoCompanyTelco();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', Messages("Cập nhật thông tin doanh nghiệp thành công - ") + $('#tenDoanhNghiep_'+stt).val().trim());
                $("#updateEnterpriseModal").modal('hide');
                setTimeout(function () {
                    window.location.reload();
                },1500);
            } else {
                if(data.content != null && data.content.code == 2023){
                    showNotification('danger', Messages("GPKD ") + $('#soGpkd_'+stt).val().trim() + Messages(" không tồn tại trên hệ thống"));
                }
                if(data.content != null && data.content.code == 2021){
                    showNotification('danger', Messages("GPKD ") + $('#soGpkd_'+stt).val().trim() + Messages(" đã tồn tại trên hệ thống"));
                } else {
                    if(data.status == 401){
                        showNotification('danger', Messages("noti.sessionTimeOut"));
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    } else {
                        showNotification('danger', Messages("Cập nhật thông tin doanh nghiệp không thành công - ") + $('#tenDoanhNghiep_'+stt).val().trim());
                    }
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