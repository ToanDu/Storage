var dsLinhVuc;
var dsDongThietBi;
//check doanh nghiep da khao sat hay chua
$(document).ready(function () {
    getInfoSurvey();
})
function getInfoSurvey() {
    // StartProcess();
    var body = new FormData();
    body.userId = userId;
    console.log(body);
    var r = jsRoutes.controllers.TelcoLogController.getInfoSurvey();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas, "getInfoSurvey");
            if(datas.content == null || datas.content.length == 0){
                $("#updateTypeBusinessModal").modal('show');
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
            getCategoryBusinessAndDevice();
        }
    })
}

function getCategoryBusinessAndDevice() {
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getCategoryBusinessAndDevice();
    $.ajax({
        type: r.type,
        // data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (datas) {
            console.log(datas, "getCategoryBusinessAndDevice");
            dsLinhVuc = '';
            dsDongThietBi = '';

            if (datas.content != null) {
                if(datas.content.business != null){
                    if(datas.content.business.data != null && datas.content.business.data.length > 0){
                        var business = datas.content.business.data;
                        for(var i=0; i<business.length; i++){
                            dsLinhVuc += '<option value="'+business[i].code+'">'+business[i].name+'</option>';
                        }
                    }
                }
                // console.log(dsLinhVuc);

                if(datas.content.device != null){
                    if(datas.content.device.data != null && datas.content.device.data.length > 0){
                        var device = datas.content.device.data;
                        for(var j=0; j<device.length; j++){
                            dsDongThietBi += '<option value="'+device[j].code+'">'+device[j].name+'</option>';
                        }
                    }
                }
                // console.log(dsDongThietBi);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
            getListEnterprise();
        }
    })
}

function getListEnterprise() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas, "getListEnterprise");
            var isShow = false;
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    $("#bodyTypeBusiness").html('<h6>'+Messages("Cập nhật lĩnh vực hoạt động của Doanh nghiệp")+'</h6>');
                    for(var i=0; i<datas.content.data.length; i++){
                        var databody = datas.content.data[i];
                        var nameDN = databody.name;
                        if(databody.approve_status == "SUBMITTED"){
                            nameDN = databody.update_info.name;
                        }
                        var divEnterprise =
                            '       <div class="m-t-3" style="border: 1px solid #dee2e6; padding: 15px;">\n' +
                            '          <input class="form-control id_doanh_nghiep" id="id_doanh_nghiep_'+i+'" value="'+databody.id+'" readonly hidden>\n' +
                            '          <div class="row m-b-3">\n' +
                            '            <label class="col-sm-3 col-form-label title-section-2">'+Messages("Doanh nghiệp")+'</label>\n' +
                            '            <div class="col-sm-9">\n' +
                            '              <input class="form-control" id="name_'+i+'" value="'+nameDN+'" readonly>\n' +
                            '            </div>\n' +
                            '          </div>\n' +
                            '          <div class="row m-t-3">\n' +
                            '            <label class="col-sm-3 col-form-label title-section-2">'+Messages("Lĩnh vực")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '            <div class="col-sm-9">\n' +
                            '              <select class="form-control" id="linhVuc_'+i+'" multiple="multiple">'+dsLinhVuc+'</select>\n' +
                            '            </div>\n' +
                            '          </div>\n' +
                            '          <div class="row m-t-3">\n' +
                            '            <label class="col-sm-3 col-form-label title-section-2">'+Messages("Dòng thiết bị")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
                            '            <div class="col-sm-9">\n' +
                            '              <select class="form-control" id="dongThietBi_'+i+'" multiple="multiple">'+dsDongThietBi+'</select>\n' +
                            '            </div>\n' +
                            '          </div>\n' +
                            '        </div>';
                        $("#bodyTypeBusiness").append(divEnterprise);

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
                        } else {
                            isShow = true;
                        }

                        var device_types = databody.device_types;
                        if(device_types != null && device_types.length > 0){
                            var dsDTB = new Array();
                            device_types.forEach(function (item) {
                                dsDTB.push(item.code);
                            });
                            $('#dongThietBi_'+i).val(dsDTB).trigger('change');
                        } else {
                            isShow = true;
                        }
                    }

                    // if(isShow){
                    //     $("#updateTypeBusinessModal").modal('show');
                    // }
                }
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

var listStt = new Array();
function comfirmUpdateTypeBusiness() {
    var listIdDn = document.getElementsByClassName("id_doanh_nghiep");
    listStt = [];
    var isCheckValidate = true;
    for(var i=0; i<listIdDn.length; i++){
        listStt.push(i);

        if($("#linhVuc_"+i).val().length == 0){
            isCheckValidate = false;
            showNotification('danger', Messages("Vui lòng chọn lĩnh vực hoạt động của doanh nghiệp"));
            break;
        }

        if($("#dongThietBi_"+i).val().length == 0){
            isCheckValidate = false;
            showNotification('danger', Messages("Vui lòng chọn dòng thiết bị của doanh nghiệp"));
            break;
        }
    }

    //TODO: check khao sat
    var listClassServey = ["experience", "easeUse", "sometimeUse", "manageSubs", "manageContract", "manageOrder", "blockSub", "open1Way", "open2Way", "rechargeMoney", "miAddon",
        "payFeeConnect", "payFeePackage", "payFeeOpenSub", "payFeeBlockSub", "payFeeRecharge", "payFeeMiAddon", "extraFeatures",
        "hard", "hardMonth", "realyUse"];
    var listContentServey = ["Đánh giá tổng thể về trải nghiệm sử dụng nền tảng quản lý kết nối M2M IoT",
        "Đánh giá về mức độ dễ sử dụng của website",
        "Bạn thường xuyên sử dụng dịch vụ nào nhất",
        "Đánh giá các dịch vụ của nền tảng - Quản lý thuê bao",
        "Đánh giá các dịch vụ của nền tảng - Quản lý hợp đồng",
        "Đánh giá các dịch vụ của nền tảng - Quản lý đơn hàng",
        "Đánh giá các dịch vụ của nền tảng - Chặn chiều TB",
        "Đánh giá các dịch vụ của nền tảng - Mở chặn 1 chiều",
        "Đánh giá các dịch vụ của nền tảng - Mở chặn 2 chiều",
        "Đánh giá các dịch vụ của nền tảng - Nạp tiền",
        "Đánh giá các dịch vụ của nền tảng - Đăng ký gói cước Mi, Add-on",
        "Bạn sẵn sàng chi trả cho những tính năng nào - Đấu nối thuê bao M2M/IOT",
        "Bạn sẵn sàng chi trả cho những tính năng nào - Mua gói (gói >=20K)",
        "Bạn sẵn sàng chi trả cho những tính năng nào - Mở chặn 1 chiều, 2 chiều",
        "Bạn sẵn sàng chi trả cho những tính năng nào - Chặn 1 chiều, 2 chiều",
        "Bạn sẵn sàng chi trả cho những tính năng nào - Nạp tiền",
        "Bạn sẵn sàng chi trả cho những tính năng nào - Đăng ký gói cước",
        "Nếu các tính năng liên quan đến phân tích và lọc dữ liệu được phát triển, bạn mong muốn có tính năng nào",
        "Bạn gặp phải những khó khăn gì khi xây dựng ứng dụng IoT cho doanh nghiệp của bạn",
        "Hàng tháng, doanh nghiệp của bạn gặp nhiều khó khăn trong việc nào",
        "Có sẵn sàng giới thiệu cho bạn bè thuộc DN khác, trải nghiệm dùng thử bộ công cụ CMP của Viettel"
    ];

    for(var i=0; i<listClassServey.length; i++){
        var clasname = listClassServey[i];
        var classDiv = document.getElementsByClassName(clasname);
        var isCheckChoosed = 0;
        for(var j=0; j<classDiv.length; j++){
            if(classDiv[j].checked){
                isCheckChoosed = classDiv[j].value;
            }
        }
        if(isCheckChoosed == 0){
            isCheckValidate = false;
            showNotification('danger', Messages("Bạn chưa chọn " + listContentServey[i]));
            break;
        }
    }

    if(!isCheckValidate){
        return;
    }

    if(listStt.length > 0){
        processUpdateTypeBusinessDN(0);
    }

    processFormCustomerSurvey();
}

function processUpdateTypeBusinessDN(index) {
    var groupData = new FormData();
    groupData.append("idDoanhNghiep", $('#id_doanh_nghiep_'+listStt[index]).val());
    groupData.append("dsLinhVuc", $("#linhVuc_"+listStt[index]).val().toString());
    groupData.append("dsDongThietBi", $("#dongThietBi_"+listStt[index]).val().toString());

    console.log(groupData);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.updateCategoryBusinessAndDevice();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', Messages("Cập nhật lĩnh vực doanh nghiệp thành công - ") + $('#name_'+listStt[index]).val());
            } else {
                showNotification('danger', Messages("Cập nhật lĩnh vực doanh nghiệp không thành công - ") + $('#name_'+listStt[index]).val());
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(index < listStt.length-1){
                processUpdateTypeBusinessDN(index+1);
            } else {
                $("#updateTypeBusinessModal").modal('hide');
                FinishProcess();
            }
        }
    })
}

function processFormCustomerSurvey() {
    var body = new FormData();
    body.contentFeedback = $("#contentFeedback").val().trim();
    body.contentUsePlatformOther = $("#contentUsePlatformOther").val().trim();
    body.contentFeeOneMonth = $("#contentFeeOneMonth").val().trim();
    body.nameEnterprise = $("#name_0").val();
    body.typeBusiness = $("#linhVuc_0").val().toString();
    body.typeDevice = $("#dongThietBi_0").val().toString();

    var classExperience = document.getElementsByClassName("experience");
    for(var j=0; j<classExperience.length; j++){
        if(classExperience[j].checked){
            body.experience = classExperience[j].value;
            break;
        }
    }

    var classEaseUse = document.getElementsByClassName("easeUse");
    for(var j=0; j<classEaseUse.length; j++){
        if(classEaseUse[j].checked){
            body.easeUse = classEaseUse[j].value;
            break;
        }
    }

    var classSometimeUse = document.getElementsByClassName("sometimeUse");
    var sometimeUseArr = [];
    for(var j=0; j<classSometimeUse.length; j++){
        if(classSometimeUse[j].checked){
            sometimeUseArr.push(classSometimeUse[j].value);
        }
    }
    body.sometimeUse = sometimeUseArr.toString();

    var classManageSubs = document.getElementsByClassName("manageSubs");
    for(var j=0; j<classManageSubs.length; j++){
        if(classManageSubs[j].checked){
            body.manageSubs = classManageSubs[j].value;
            break;
        }
    }
    var classManageContract = document.getElementsByClassName("manageContract");
    for(var j=0; j<classManageContract.length; j++){
        if(classManageContract[j].checked){
            body.manageContract = classManageContract[j].value;
            break;
        }
    }
    var classManageOrder = document.getElementsByClassName("manageOrder");
    for(var j=0; j<classManageOrder.length; j++){
        if(classManageOrder[j].checked){
            body.manageOrder = classManageOrder[j].value;
            break;
        }
    }
    var classBlockSub = document.getElementsByClassName("blockSub");
    for(var j=0; j<classBlockSub.length; j++){
        if(classBlockSub[j].checked){
            body.blockSub = classBlockSub[j].value;
            break;
        }
    }
    var classOpen1Way = document.getElementsByClassName("open1Way");
    for(var j=0; j<classOpen1Way.length; j++){
        if(classOpen1Way[j].checked){
            body.open1Way = classOpen1Way[j].value;
            break;
        }
    }
    var classOpen2Way = document.getElementsByClassName("open2Way");
    for(var j=0; j<classOpen2Way.length; j++){
        if(classOpen2Way[j].checked){
            body.open2Way = classOpen2Way[j].value;
            break;
        }
    }
    var classRechargeMoney = document.getElementsByClassName("rechargeMoney");
    for(var j=0; j<classRechargeMoney.length; j++){
        if(classRechargeMoney[j].checked){
            body.rechargeMoney = classRechargeMoney[j].value;
            break;
        }
    }
    var classMiAddon = document.getElementsByClassName("miAddon");
    for(var j=0; j<classMiAddon.length; j++){
        if(classMiAddon[j].checked){
            body.miAddon = classMiAddon[j].value;
            break;
        }
    }

    var classPayFeeConnect = document.getElementsByClassName("payFeeConnect");
    for(var j=0; j<classPayFeeConnect.length; j++){
        if(classPayFeeConnect[j].checked){
            body.payFeeConnect = classPayFeeConnect[j].value;
            break;
        }
    }
    var classPayFeePackage = document.getElementsByClassName("payFeePackage");
    for(var j=0; j<classPayFeePackage.length; j++){
        if(classPayFeePackage[j].checked){
            body.payFeePackage = classPayFeePackage[j].value;
            break;
        }
    }
    var classPayFeeOpenSub = document.getElementsByClassName("payFeeOpenSub");
    for(var j=0; j<classPayFeeOpenSub.length; j++){
        if(classPayFeeOpenSub[j].checked){
            body.payFeeOpenSub = classPayFeeOpenSub[j].value;
            break;
        }
    }
    var classPayFeeBlockSub = document.getElementsByClassName("payFeeBlockSub");
    for(var j=0; j<classPayFeeBlockSub.length; j++){
        if(classPayFeeBlockSub[j].checked){
            body.payFeeBlockSub = classPayFeeBlockSub[j].value;
            break;
        }
    }
    var classPayFeeRecharge = document.getElementsByClassName("payFeeRecharge");
    for(var j=0; j<classPayFeeRecharge.length; j++){
        if(classPayFeeRecharge[j].checked){
            body.payFeeRecharge = classPayFeeRecharge[j].value;
            break;
        }
    }
    var classPayFeeMiAddon = document.getElementsByClassName("payFeeMiAddon");
    for(var j=0; j<classPayFeeMiAddon.length; j++){
        if(classPayFeeMiAddon[j].checked){
            body.payFeeMiAddon = classPayFeeMiAddon[j].value;
            break;
        }
    }

    var classExtraFeatures = document.getElementsByClassName("extraFeatures");
    var extraFeaturesArr = [];
    for(var j=0; j<classExtraFeatures.length; j++){
        if(classExtraFeatures[j].checked){
            extraFeaturesArr.push(classExtraFeatures[j].value);
        }
    }
    body.extraFeatures = extraFeaturesArr.toString();

    var classHard = document.getElementsByClassName("hard");
    var hardArr = [];
    for(var j=0; j<classHard.length; j++){
        if(classHard[j].checked){
            hardArr.push(classHard[j].value);
        }
    }
    body.hard = hardArr.toString();

    var classHardMonth = document.getElementsByClassName("hardMonth");
    var hardMonthArr = [];
    for(var j=0; j<classHardMonth.length; j++){
        if(classHardMonth[j].checked){
            hardMonthArr.push(classHardMonth[j].value);
        }
    }
    body.hardMonth = hardMonthArr.toString();

    var classRealyUse = document.getElementsByClassName("realyUse");
    for(var j=0; j<classRealyUse.length; j++){
        if(classRealyUse[j].checked){
            body.realyUse = classRealyUse[j].value;
            break;
        }
    }
    // var listClassServey = ["experience", "easeUse", "sometimeUse", "manageSubs", "manageContract", "manageOrder", "blockSub", "open1Way", "open2Way", "rechargeMoney", "miAddon",
    //     "payFeeConnect", "payFeePackage", "payFeeOpenSub", "payFeeBlockSub", "payFeeRecharge", "payFeeMiAddon", "extraFeatures"];
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoLogController.updateFormCustomerSurvey();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', Messages("Gửi khảo sát thành công"));
            } else {
                showNotification('danger', Messages("Gửi khảo sát không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
        }
    })
}