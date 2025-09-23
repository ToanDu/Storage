var dsLinhVuc = new Array();
var dsDongThietBi = new Array();
function getCategoryBusinessAndDevice() {
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getCategoryBusinessAndDevice();
    $.ajax({
        type: r.type,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (datas) {
            console.log(datas, "getCategoryBusinessAndDevice");
            if (datas.content != null) {
                if(datas.content.business != null){
                    if(datas.content.business.data != null && datas.content.business.data.length > 0){
                        var business = datas.content.business.data;
                        for(var i=0; i<business.length; i++){
                            dsLinhVuc[business[i].code] = business[i].name;

                        }
                    }
                }
                console.log(dsLinhVuc);

                if(datas.content.device != null){
                    if(datas.content.device.data != null && datas.content.device.data.length > 0){
                        var device = datas.content.device.data;
                        for(var j=0; j<device.length; j++){
                            dsDongThietBi[device[j].code] = device[j].name;
                        }
                    }
                }
                console.log(dsDongThietBi);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    })
}
function getLinhVucByCode(codeStr) {
    // console.log(codeStr);
    if(codeStr != null && codeStr != undefined){
        var myArray = codeStr.split(",");
        // console.log(myArray);
        var strReturn = "";
        if(myArray.length > 0){
            for(var i=0; i< myArray.length; i++){
                if(i>0){
                    strReturn += ",";
                }
                strReturn += dsLinhVuc[myArray[i]];
            }
        }
        // console.log(strReturn);
        return strReturn;
    } else {
        return "";
    }
}
function getDongThietBiByCode(codeStr) {
    if(codeStr != null && codeStr != undefined){
        var myArray = codeStr.split(",");
        var strReturn = "";
        if(myArray.length > 0){
            for(var i=0; i< myArray.length; i++){
                if(i>0){
                    strReturn += ",";
                }
                strReturn += dsDongThietBi[myArray[i]];
            }
        }
        return strReturn;
    } else {
        return "";
    }
}

var hardMonth = {
    1: "Nạp tiền cho SIM",
    2: "Kiểm tra trạng thái SIM (chặn cắt, lưu lượng còn lại...)",
    3: "Đấu nối SIM mới",
    4: "Thao tác chặn / khôi phục hoạt động của SIM",
    5: "Mua SIM mới",
    6: "Quản lý hóa đơn",
    7: "Quản lý hợp đồng"
}
function hardMonthByCode(codeStr) {
    // console.log(codeStr);
    if(codeStr != null && codeStr != undefined){
        var myArray = codeStr.split(",");
        var strReturn = "";
        if(myArray.length > 0){
            for(var i=0; i< myArray.length; i++){
                if(i>0){
                    strReturn += ",";
                }
                strReturn += hardMonth[myArray[i]];
            }
        }
        return strReturn;
    } else {
        return "";
    }
}

var pointSatisfied = {
    1: "Rất không hài lòng",
    2: "Không hài lòng",
    3: "Hài lòng",
    4: "Rất hài lòng"
}

var somtimeUse = {
    1: "Quản lý thuê bao",
    2: "Quản lý hợp đồng",
    3: "Quản lý đơn hàng",
    4: "Chặn/mở chiều thuê bao",
    5: "Nạp tiền",
    6: "Đăng ký gói cước"
}
function somtimeUseByCode(codeStr) {
    // console.log(codeStr);
    if(codeStr != null && codeStr != undefined){
        var myArray = codeStr.split(",");
        var strReturn = "";
        if(myArray.length > 0){
            for(var i=0; i< myArray.length; i++){
                if(i>0){
                    strReturn += ",";
                }
                strReturn += somtimeUse[myArray[i]];
            }
        }
        return strReturn;
    } else {
        return "";
    }
}

var willingToPay = {
    1: "0-5.000 VNĐ",
    2: "5.000 - 10.000 VNĐ",
    3: "10.000 - 50.000 VNĐ",
    4: "Trên 50.000 VNĐ"
}

var wishFeature = {
    1: "Quản lý thiết bị: theo dõi trạng thái hoạt động, cấu hình và bật tắt thiết bị từ xa. ",
    2: "Tích hợp và phân tích dữ liệu: Thu thập dữ liệu từ nhiều nguồn khác nhau, bao gồm các thiết bị IoT, cảm biến, hệ thống khác. Phân tích dữ liệu theo các tiêu chí tùy chỉnh. ",
    3: "Xử lý dữ liệu thời gian thực: Nhận được thông tin và cảnh báo ngay lập tức. ",
    4: "Tạo và quản lý các quy tắc tự động: Tạo các quy tắc tự động dựa trên dữ liệu IoT, tự động hóa quy trình và phản ứng tức thì vào các sự kiện và trạng thái của thiết bị IoT. ",
    5: "Tạo bảng điều khiển tùy chỉnh: Giúp hiển thị thông tin quan trọng theo nhu cầu của từng khách hàng. ",
    6: "Tính năng khác"
}
function wishFeatureByCode(codeStr) {
    // console.log(codeStr);
    if(codeStr != null && codeStr != undefined){
        var myArray = codeStr.split(",");
        var strReturn = "";
        if(myArray.length > 0){
            for(var i=0; i< myArray.length; i++){
                if(i>0){
                    strReturn += ",";
                }
                strReturn += wishFeature[myArray[i]];
            }
        }
        return strReturn;
    } else {
        return "";
    }
}

var hardIot = {
    1: "Tích hợp thiết bị",
    2: "Triển khai hạ tầng server",
    3: "Chất lượng kết nối vô tuyến không đảm bảo",
    4: "Thời gian phát triển ứng dụng quá lâu",
    5: "Thiếu nhân sự vận hành",
    6: "Thiếu các đầu bài cụ thể từ khách hàng"
}
function hardIotByCode(codeStr) {
    // console.log(codeStr);
    if(codeStr != null && codeStr != undefined){
        var myArray = codeStr.split(",");
        var strReturn = "";
        if(myArray.length > 0){
            for(var i=0; i< myArray.length; i++){
                if(i>0){
                    strReturn += ",";
                }
                strReturn += hardIot[myArray[i]];
            }
        }
        return strReturn;
    } else {
        return "";
    }
}

var realyUse = {
    1: "Sẵn sàng",
    2: "Cần trải nghiệm thêm",
    3: "Hoàn toàn không muốn"
}