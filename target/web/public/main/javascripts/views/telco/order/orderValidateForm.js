/**
 * Created by vtk-anhlt166 on 2/6/23.
 */
function validateFormInfoCustomer() {
    if(!validateInputId("ten_dn")){
        showNotification('danger',Messages("Bạn chưa điền tên doanh nghiệp"));
        return false;
    }
    if(!validateInputId("ma_so_thue")){
        showNotification('danger',Messages("Bạn chưa điền mã số thuế"));
        return false;
    }
    if(!validateTimeCurrent("ngay_thanh_lap")){
        showNotification('danger',Messages("Bạn chưa điền ngày thành lập"));
        return false;
    }
    if(!validateInputId("tinh_tp") || !validateInputId("quan_huyen") || !validateInputId("phuong_xa") || !validateInputId("dia_chi_chi_tiet")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin địa chỉ"));
        return false;
    }
    if(!validateInputId("quoc_tich") || !validateInputId("quoc_tich_3") || !validateInputId("quoc_tich_2")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin Quốc tịch"));
        return false;
    }
    if(!validateInputId("so_giay_to") || !validateInputId("noi_cap") || !validateInputId("ngay_cap")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin giấy tờ"));
        return false;
    }
    if(!validateInputId("ten_khach_hang")){
        showNotification('danger',Messages("Bạn chưa điền tên người đại diện"));
        return false;
    }
    if(!validateInputId("ngay_sinh")){
        showNotification('danger',Messages("Bạn chưa điền ngày sinh người đại diện"));
        return false;
    }
    if(!validateInputId("tinh_tp_2") || !validateInputId("quan_huyen_2") || !validateInputId("phuong_xa_2") || !validateInputId("dia_chi_chi_tiet_2")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin địa chỉ người đại diện"));
        return false;
    }
    if(!validateInputId("so_giay_to_2") || !validateInputId("noi_cap_2") || !validateInputId("ngay_cap_2") || !validateInputId("ngay_het_han_2")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin giấy tờ người đại diện"));
        return false;
    }
    if(!validateInputId("ten_khach_hang_3")){
        showNotification('danger',Messages("Bạn chưa điền tên người sử dụng"));
        return false;
    }
    if(!validateInputId("ngay_sinh_3")){
        showNotification('danger',Messages("Bạn chưa điền ngày sinh người sử dụng"));
        return false;
    }
    if(!validateInputId("tinh_tp_3") || !validateInputId("quan_huyen_3") || !validateInputId("phuong_xa_3") || !validateInputId("dia_chi_chi_tiet_3")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin địa chỉ người sử dụng"));
        return false;
    }
    if(!validateInputId("so_giay_to_3") || !validateInputId("noi_cap_3") || !validateInputId("ngay_cap_3") || !validateInputId("ngay_het_han_3")){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin giấy tờ người sử dụng"));
        return false;
    }

    if(!validateTimeCurrent("ngay_cap") || !validateTimeCurrent("ngay_cap_2") || !validateTimeCurrent("ngay_cap_3")){
        showNotification('danger',Messages("Ngày cấp không được lớn hơn ngày hiện tại"));
        return false;
    }
    if(!validateTimeCurrent("ngay_sinh") || !validateTimeCurrent("ngay_sinh_3")){
        showNotification('danger',Messages("Ngày sinh không được lớn hơn ngày hiện tại"));
        return false;
    }

    // if(!validateInputId("imgOld1")){
    //     showNotification('danger',Messages("Bạn chưa up ảnh đại diện, vui lòng cập nhật trong trang Cập nhật tài khoản"));
    //     return false;
    // }
    // if(!validateInputId("imgOld2")){
    //     showNotification('danger',Messages("Bạn chưa up ảnh Mặt trước CMT/ CCCD, vui lòng cập nhật trong trang Cập nhật tài khoản"));
    //     return false;
    // }
    // if(!validateInputId("imgOld3")){
    //     showNotification('danger',Messages("Bạn chưa up ảnh Mặt sau CMT/ CCCD, vui lòng cập nhật trong trang Cập nhật tài khoản"));
    //     return false;
    // }
    // if(!validateInputId("imgOld4")){
    //     showNotification('danger',Messages("Bạn chưa up ảnh GPKD, vui lòng cập nhật trong trang Cập nhật tài khoản"));
    //     return false;
    // }
    // if($("#wizard-picture-5").prop("files")[0] == null || $("#wizard-picture-5").prop("files")[0] == undefined){
    //     showNotification('danger',Messages("Bạn chưa up ảnh phiếu yêu cầu đấu nối"));
    //     return false;
    // }


    return true;
}

function validateTimeCurrent(id) {
    var input = document.getElementById(id);
    if(input != null && input != undefined){
        var dateString = $("#"+id).val();
        var dateParts = dateString.split("/");
        var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
        var dateNow = new Date();
        if(dateObject.getTime() > dateNow.getTime()){
            return false;
        } else {
            return true;
        }
    }

    return true;
}

function validateInputId(id) {
    var input = document.getElementById(id);
    if(input != null && input != undefined){
        var value = $("#"+id).val();
        if(value != undefined && value != null && value.length > 0){
            if(value.replaceAll(/\s/g, '').length > 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        return true;
    }
}