/**
 * Created by vtk-anhlt166 on 2/3/23.
 */
var hostname = location.protocol + '//' + location.host;
var hostGetImg = "https://cmp-api.innoway.vn/file/";
console.log(hostname);
var ROLE_CMP = {
    UNKNOWN: {value: "NONE", name: "Không xác định"},
    SUPER_ADMIN: {value: "SUPER_ADMIN", name: "Super Admin"},
    ADMIN: {value: "ADMIN", name: "Admin"},
    SUPER_ENTERPRISE: {value: "SUPER_ENTERPRISE", name: "Đại lý"},
    ENTERPRISE: {value: "ENTERPRISE", name: "Doanh nghiệp"},
    ENTERPRISE_VIEW: {value: "ENTERPRISE_VIEW", name: "TK Trải nghiệm"},
    ENTERPRISE_LV2: {value: "ENTERPRISE_LV2", name: "Doanh nghiệp cấp 2"}
};
$(document).ready(function () {
    getListApprovedInfo();
    getListProvince();
});

$("#formSearch").keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        onlickButtonSearch();
    }
});

function closeModal() {
    $("#infoCompanyModal").modal('hide');
    $("#tab_info_company").empty();
}

var listCompany = new Array;

function onlickButtonSearch() {
    $("#page").val(1);

    getListApprovedInfo();
}

function getListApprovedInfo() {
    var body = new FormData();
    body.email = $("#email").val().trim();
    body.phone = $("#phone").val().trim();
    body.name = $("#name").val().trim();
    body.businessLicense = $("#businessLicense").val().trim();
    body.status = $("#status").val();
    body.role_cmp = $("#role_cmp").val();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.AdminTelcoController.getListInfoApproved();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            listCompany = [];
            $("#tableListInfoCompany").find('tbody').html("");
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewDeviceToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    setTimeout(function () {
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    },1500);
                } else {
                    $("#listAccountsTable").find('tbody').html("");
                    $("#notiNotData").html("Không có thông tin để hiển thị");
                    showNotification('danger', "Lấy dữ liệu không thành công");
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
function viewDeviceToTable(datas, startAt, page, pageSize) {
    var body = "";
    var listData = datas.data;
    if (listData != null && listData.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listData.length; i++) {
            var color = "";
            if(listData[i].status == "SUBMITTED"){
                color = "orange";
            } else if(listData[i].status == "REJECTED"){
                color = "red";
            } else {
                color = "green";
            }
            body += "<tr>";
            body += "<td>" +(startAt+i+1)+ "</td>";
            body += "<td>" + "<a onclick='remotePageManageSubs(\""+listData[i].business_license+"\", \""+listData[i].user_id+"\")' style='color: #00a5bb; cursor: pointer;'>"+ listData[i].user_email +"</a>"+ "</td>";
            body += "<td>" + listData[i].user_phone + "</td>";
            body += "<td style='white-space: initial;' hidden>" + ((listData[i].name != null && listData[i].name != undefined) ? listData[i].name : "") + "</td>";
            body += "<td hidden>" + ((listData[i].business_license != null && listData[i].business_license != undefined) ? listData[i].business_license : "") + "</td>";
            body += "<td hidden>" + ((listData[i].tax_code != null && listData[i].tax_code != undefined) ? listData[i].tax_code : "") + "</td>";
            body += "<td style='white-space: initial;' hidden>" + ((listData[i].full_address != null && listData[i].full_address != undefined) ? listData[i].full_address : "") + "</td>";
            body += "<td>" + getRoleNameByCode(listData[i].user_cmp_role) + "</td>";
            body += "<td style='color: "+color+"'>" + listData[i].status + "</td>";
            if(listData[i].user_cmp_role == ROLE_CMP.ADMIN.value || listData[i].user_cmp_role == ROLE_CMP.SUPER_ENTERPRISE.value){
                body += "<td>"+'<a class="btn-tb cursor-pointer" onclick="setModalGpkdOfAdminAndSpEnterprise(\''+listData[i].user_id+'\')">'+Messages("Chi tiết")+'</a>'+"</td>";
            } else {
                body += "<td>"+'<a class="btn-tb cursor-pointer" onclick="getInfoCompanyApproved(\''+listData[i].user_id+'\')">'+Messages("Chi tiết")+'</a>'+"</td>";
            }
            body += "</tr>";

            listCompany[listData[i].user_id] = listData[i];
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#tableListInfoCompany").find('tbody').html(body);

    pagingTable(datas.total, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    // console.log("total : " + total);
    // console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);
}
function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListApprovedInfo();
}
function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListApprovedInfo();
}

function remotePageManageSubs(gpkd, userId) {
    if(gpkd == "" || gpkd == null || gpkd == undefined){
        gpkd = "demo";
    }
    window.open(jsRoutes.controllers.TelcoSubscriberController.subscriberManage(userId).url, '_blank');
}

function getInfoCompanyApproved(user_id) {
    $("#infoCompanyModal").modal('show');

    var body = new FormData;
    body.userId = user_id;
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
                if(data.approve_user_info.identity_info == null){
                    $("#notiApprovedAccount").html("<p style='color: green; font-weight: 600;'>" + Messages("*Thông tin cá nhân đã được duyệt!") + "</p>");
                    $("#buttonApproved").prop("disabled", true);
                    $("#buttonRejected").prop("disabled", true);
                } else {
                    if(data.approve_user_info.description == ""){
                        $("#notiApprovedAccount").html("<p style='color: orangered; font-weight: 600;'>" + Messages(" *Thông tin cá nhân đang chờ kiểm duyệt!") + "</p>")
                        $("#buttonApproved").prop("disabled", false);
                        $("#buttonRejected").prop("disabled", false);
                    } else {
                        $("#notiApprovedAccount").html("<p style='color: red; font-weight: 600;'>"+Messages(" *Thông tin cá nhân bị từ chối duyệt!")+"</p>")
                        // $("#buttonApproved").prop("disabled", true);
                        $("#buttonRejected").prop("disabled", true);
                    }
                }

                $("#idUser").val(user_id);
                $("#emailUser").val(data.email);
                $("#fullNameUser").val(data.name);
                $("#phoneUser").val(data.phone);
                $("#descriptionAccount").val(listCompany[user_id].description != null ? listCompany[user_id].description : "");

                if(data.profile != null){
                    var profile = data.profile;

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
                    }

                }
                if(data.approve_user_info != null && data.approve_user_info.identity_info != null){
                    if(data.approve_user_info.identity_info != null){
                        console.log("photo:"+data.approve_user_info.identity_info);
                        $("#cmtUser").val(data.approve_user_info.identity_info.identity != null ? data.approve_user_info.identity_info.identity : "");
                        var imgBack = data.approve_user_info.identity_info.back_image != "" ? (hostGetImg+data.approve_user_info.identity_info.back_image) : imgDefault;
                        $("#imgCmtBack").attr('src',  imgBack);
                        var imgFront = data.approve_user_info.identity_info.front_image != "" ? (hostGetImg+data.approve_user_info.identity_info. front_image) : imgDefault;
                        $("#imgCmtFront").attr('src',  imgFront);
                        var imgAuthorization = data.approve_user_info.identity_info.authorization_letter_image != "" ? (hostGetImg+data.approve_user_info.identity_info.authorization_letter_image) : imgDefault;
                        $("#imgAuthorization").attr('src',  imgAuthorization);
                        var imgRegistration = data.approve_user_info.identity_info.registration_form_image != "" ? (hostGetImg+data.approve_user_info.identity_info.registration_form_image) : imgDefault;
                        $("#imgRegistration").attr('src',  imgRegistration);
                    }
                } else {
                    if(data.profile != null) {
                        $("#cmtUser").val(data.profile.identity_info.identity != null ? data.profile.identity_info.identity : "");
                        var imgBack = data.profile.identity_info.back_image != "" ? (hostGetImg+data.profile.identity_info.back_image) : imgDefault;
                        $("#imgCmtBack").attr('src',  imgBack);
                        var imgFront = data.profile.identity_info.front_image != "" ? (hostGetImg+data.profile.identity_info. front_image) : imgDefault;
                        $("#imgCmtFront").attr('src',  imgFront);
                        var imgAuthorization = data.profile.identity_info.authorization_letter_image != "" ? (hostGetImg+data.profile.identity_info.authorization_letter_image) : imgDefault;
                        $("#imgAuthorization").attr('src',  imgAuthorization);
                        var imgRegistration = data.profile.identity_info.registration_form_image != "" ? (hostGetImg+data.profile.identity_info.registration_form_image) : imgDefault;
                        $("#imgRegistration").attr('src',  imgRegistration);

                    }
                }
                getListEnterpriseByBrowser();
            }
            else {
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

        }
    })

    // var data = listCompany[user_id];
    // console.log(data);

    // if(data.user_cmp_role == null || data.user_cmp_role == "" || data.user_cmp_role == "ENTERPRISE"){
    //     // document.getElementById("divRoleCmp").style.display = 'block';
    //     var optionRoleCmp =
    //         '<option value="ENTERPRISE" selected>'+Messages("Doanh nghiệp")+'</option>'+
    //         '<option value="ENTERPRISE_VIEW">'+Messages("TK trải nghiệm")+'</option>';
    //     $("#roleCmp").html(optionRoleCmp);
    // } else if(data.user_cmp_role == "ENTERPRISE_VIEW"){
    //     var optionRoleCmp =
    //         '<option value="ENTERPRISE" >'+Messages("Doanh nghiệp")+'</option>'+
    //         '<option value="ENTERPRISE_VIEW" selected>'+Messages("TK trải nghiệm")+'</option>';
    //     $("#roleCmp").html(optionRoleCmp);
    // } else {
    //     $("#roleCmp").html("");
    // }

    // if(data.status == "SUBMITTED"){
    //     $("#buttonApproved").prop("disabled", false);
    //     $("#buttonRejected").prop("disabled", false);
    // } else if(data.approve_status == "REJECTED"){
    //     $("#buttonApproved").prop("disabled", false);
    //     $("#buttonRejected").prop("disabled", true);
    // } else {
    //     $("#buttonApproved").prop("disabled", false);
    //     $("#buttonRejected").prop("disabled", true);
    // }
    //
    // $("#idUser").val(user_id);
    // $("#emailUser").val(data.user_email);
    // $("#fullNameUser").val(data.user_name);
    // $("#phoneUser").val(data.user_phone);
    // $("#descriptionAccount").val(data.description != null ? data.description : "");
    // if(data.identity_info != null){
    //     $("#cmtUser").val(data.identity_info.identity != null ? data.identity_info.identity : "");
    //     var imgBack = data.identity_info.back_image != "" ? (hostGetImg+data.identity_info.back_image) : imgDefault;
    //     $("#imgCmtBack").attr('src',  imgBack);
    //     var imgFront = data.identity_info.front_image != "" ? (hostGetImg+data.identity_info. front_image) : imgDefault;
    //     $("#imgCmtFront").attr('src',  imgFront);
    //     var imgAuthorization = data.identity_info.authorization_letter_image != "" ? (hostGetImg+data.identity_info.authorization_letter_image) : imgDefault;
    //     $("#imgAuthorization").attr('src',  imgAuthorization);
    //     var imgRegistration = data.identity_info.registration_form_image != "" ? (hostGetImg+data.identity_info.registration_form_image) : imgDefault;
    //     $("#imgRegistration").attr('src',  imgRegistration);
    // }
    // else{
    //     $("#cmtUser").val("");
    //     var imgBack =  imgDefault;
    //     $("#imgCmtBack").attr('src',  imgBack);
    //     var imgFront =  imgDefault;
    //     $("#imgCmtFront").attr('src',  imgFront);
    //     var imgAuthorization =  imgDefault;
    //     $("#imgAuthorization").attr('src',  imgAuthorization);
    //     var imgRegistration = imgDefault;
    //     $("#imgRegistration").attr('src',  imgRegistration);
    // }
    // if(data.status=="SUBMITTED"){
    //     $("#notiApprovedAccount").html("<p style='color: orangered; font-weight: 600;'>" + Messages(" *Thông tin cá nhân đang chờ kiểm duyệt!") + "</p>")
    // }else {
    //     if(data.status=="REJECTED"){
    //         $("#notiApprovedAccount").html("<p style='color: red; font-weight: 600;'>"+Messages(" *Thông tin cá nhân bị từ chối duyệt!")+"</p>")
    //     }
    //     else {
    //         $("#notiApprovedAccount").html("<p style='color: green; font-weight: 600;'>" + Messages("*Thông tin cá nhân đã được duyệt!") + "</p>")
    //     }
    // }
    // getListEnterpriseByBrowser();
}

function getListEnterpriseByBrowser() {
    var body = new FormData;
    body.userId = $("#idUser").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.AdminTelcoController.getListEnterpriseByBrowser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.data != null){
                if(datas.content.data.length > 0){
                    // var infoDn = datas.content.data[0];
                    // if(infoDn.update_info != null){
                    //     infoDn = infoDn.update_info;
                    // }
                    //
                    // $("#tenDoanhNghiep").val(infoDn.name != null ? infoDn.name : "");
                    // $("#maSoThue").val(infoDn.tax_code != null ? infoDn.tax_code : "");
                    // $("#soGpkd").val(infoDn.business_license != null ? infoDn.business_license : "");
                    // $("#ngayThanhLap").val(infoDn.founded != null ? infoDn.founded : "");
                    // $("#sdtDN").val(infoDn.phone != null ? infoDn.phone : "");
                    // $("#emailDN").val(infoDn.email != null ? infoDn.email : "");
                    // $("#diaChiChiTietDN").val(infoDn.full_address != null ? infoDn.full_address : "");
                    // $("#tinhTpDN").val(infoDn.province != null ? infoDn.province : "");
                    // var tinhTpDN = infoDn.province != null ? infoDn.province : "";
                    // var quanHuyenDN = infoDn.district != null ? infoDn.district : "";
                    // var phuongXaDN = infoDn.ward != null ? infoDn.ward : "";
                    //
                    // if(infoDn.business_license_image != null && infoDn.business_license_image != ""){
                    //     $("#wizardPicturePreview4").attr('src', hostGetImg + infoDn.business_license_image);
                    // }
                    //
                    // getListDistrict(tinhTpDN, quanHuyenDN, phuongXaDN);

                    $("#tab_info_company").html("");
                    for(var i=datas.content.data.length-1; i>=0; i--){
                        console.log(i);
                        var databody = datas.content.data[i];
                        console.log(databody);

                        var formInfoCompany =
                            '<input id="id_doanh_nghiep_'+i+'" class="id_doanh_nghiep" stt="'+i+'" hidden readonly>' +
                            '                        <div class="col-md-12 m-t-3" id="tt_doanh_nghiep_'+i+'" style="border: 1px solid #a2a2a2; padding: 10px;">' +
                            '                            <div class="row m-t-3">' +
                            '                                <div class="col-md-8">' +
                            '                                    <div class="row m-b-4">' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Tên DN")+'</label>' +
                            '                                        <div class="col-sm-10">' +
                            '                                            <input id="tenDoanhNghiep_'+i+'" type="text" class="form-control input-form" maxlength="250" value="" readonly>' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Mã số thuế")+'</label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="maSoThue_'+i+'" type="text" class="form-control input-form" maxlength="250" value="" readonly>\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Số GPKD")+'</label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="soGpkd_'+i+'" type="text" class="form-control input-form" maxlength="250" value="" readonly>\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Ngày thành lập")+'</label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="ngayThanhLap_'+i+'" type="text" class="form-control input-form date_timepicker" maxlength="250" readonly>\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                        <div class="col-sm-6">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Số điện thoại DN")+'</label>\n' +
                            '                                                <div class="col-sm-8">\n' +
                            '                                                    <input id="sdtDN_'+i+'" type="number" class="form-control input-form" pattern="/^-?\\d+\\.?\\d*$/" onKeyPress="if(this.value.length==11) return false;" readonly>\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Email DN")+'</label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <input id="emailDN_'+i+'" type="text" class="form-control input-form" maxlength="250" readonly>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="row m-b-3">\n' +
                            '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Địa chỉ")+'</label>\n' +
                            '                                        <div class="col-sm-10">\n' +
                            '                                            <div class="row">\n' +
                            '                                                <div class="col-sm-4">\n' +
                            '                                                    <input class="form-control" id="tinhTpDN_'+i+'" readonly>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-sm-4">\n' +
                            '                                                    <input class="form-control" id="quanHuyenDN_'+i+'" readonly>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-sm-4">\n' +
                            '                                                    <input class="form-control" id="phuongXaDN_'+i+'" readonly>\n' +
                            '                                                </div>\n' +
                            '                                                <div class="col-sm-12 m-t-3">\n' +
                            '                                                    <input id="diaChiChiTietDN_'+i+'" type="text" class="form-control input-form" maxlength="250" placeholder="Địa chỉ chi tiết" readonly>\n' +
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '\n' +
                            '                                <div class="col-md-4">\n' +
                            '                                    <div class="row m-b-4">\n' +
                            '                                        <label class="col-sm-3 col-form-label title-section-2">'+Messages("Ảnh GPKD")+'</label>\n' +
                            '                                        <div class="col-sm-9 position-relative">\n' +
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
                            '                                       <label class="col-sm-12 col-form-label title-section-2" id="notiApprovedEnterprise_'+i+'"></label>\n' +
                            '                                       <label class="col-sm-2 col-form-label title-section-2">'+Messages("Lý do từ chối")+'</label>\n' +
                            '                                       <div class="col-sm-10">\n' +
                            '                                           <textarea class="form-control" id="descriptionEnterprise_'+i+'" rows="2" maxlength="500"></textarea>\n' +
                            '                                       </div>'+
                            '                                    </div>' +
                            '                                </div>' +
                            '                            </div>' +
                            '                           <div class="modal-footer">\n' +
                            '                               <button type="button" class="btn btn-success" id="buttonApprovedCompany_'+i+'" onclick="processComfirmInfoCompany(\''+Messages("APPROVED")+'\', \''+i+'\')">'+Messages("btnComfirm")+'</button>\n' +
                            '                               <button type="button" class="btn btn-danger" id="buttonRejectedCompany_'+i+'" onclick="processComfirmInfoCompany(\''+Messages("REJECTED")+'\', \''+i+'\')">'+Messages("Từ chối")+'</button>\n' +
                            '                               <button type="button" class="btn btn-secondary" onclick="closeModal()" data-bs-dismiss="modal">'+Messages("Đóng")+'</button>\n' +
                            '                           </div>'+
                            '                        </div>';
                        $("#tab_info_company").append(formInfoCompany);


                        if(databody.action != "DELETE"){
                            if(databody.approve_status == "SUBMITTED"){
                                //databody = databody.update_info;
                                $("#buttonApprovedCompany_"+i).prop("disabled", false);
                                $("#buttonRejectedCompany_"+i).prop("disabled", false);
                                $("#notiApprovedEnterprise_"+i).html("<p style='color: orangered; font-weight: 600;'>"+Messages("*Thông tin doanh nghiệp đang chờ kiểm duyệt!")+"</p>");
                            } else if(databody.approve_status == "REJECTED"){
                                // databody = databody.update_info;
                                $("#buttonApprovedCompany_"+i).prop("disabled", false);
                                $("#buttonRejectedCompany_"+i).prop("disabled", true);
                                $("#notiApprovedEnterprise_"+i).html("<p style='color: red; font-weight: 600;'>"+Messages("*Thông tin doanh nghiệp bị từ chối!")+"</p>");
                            } else if(databody.approve_status == "APPROVED"){
                                $("#buttonApprovedCompany_"+i).prop("disabled", true);
                                $("#buttonRejectedCompany_"+i).prop("disabled", true);
                                $("#notiApprovedEnterprise_"+i).html("<p style='color: green; font-weight: 600;'>"+Messages("*Doanh nghiệp đã được duyệt!")+"</p>");
                            } else {
                                $("#notiApprovedEnterprise_"+i).html("");
                            }

                        } else {
                            if(databody.approve_status=="REJECTED"){
                                $("#buttonApprovedCompany_"+i).prop("disabled", true);
                                $("#buttonRejectedCompany_"+i).prop("disabled", true);
                                $("#notiApprovedEnterprise_"+i).html("<p style='color: orangered; font-weight: 600;'>"+Messages("* Thông tin doanh nghiệp bị từ chối xóa! ")+"</p>");
                            }
                            else{
                                $("#buttonApprovedCompany_"+i).prop("disabled", false);
                                $("#buttonRejectedCompany_"+i).prop("disabled", false);
                                $("#notiApprovedEnterprise_"+i).html("<p style='color: orangered; font-weight: 600;'>"+Messages("*Thông tin doanh nghiệp yêu cầu xóa")+"</p>");
                            }

                        }

                        $("#id_doanh_nghiep_"+i).val(databody.id != null ? databody.id : "");
                        $("#tenDoanhNghiep_"+i).val(databody.name != null ? databody.name : "");
                        $("#maSoThue_"+i).val(databody.tax_code != null ? databody.tax_code : "");

                        //nếu giấy phép kinh doanh ở business_license trống thì có thể tìm kiếm gpkd ở business_license_update

                        if(checkFormatDDMMYYYY(databody.founded)){
                            $("#ngayThanhLap_"+i).val(databody.founded);
                        } else {
                            var dateNow = new Date();
                            $("#ngayThanhLap_"+i).val(moment.unix(dateNow.getTime()/1000).format("DD/MM/YYYY"));
                        }
                        $("#sdtDN_"+i).val(databody.phone != null ? databody.phone : "");
                        $("#emailDN_"+i).val(databody.email != null ? databody.email : "");

                        var tinhTpDN = databody.province != null ? listProvince[databody.province] : "";
                        $("#tinhTpDN_"+i).val(tinhTpDN);

                        if(databody.province != null && databody.district != null){
                            getListDistrict(databody.province, databody.district, i);
                        } else {
                            $("#quanHuyenDN_"+i).val("");
                        }

                        if(databody.ward != null && databody.district != null){
                            getListWard(databody.district, databody.ward, i);
                        } else {
                            $("#phuongXaDN_"+i).val("");
                        }

                        $("#diaChiChiTietDN_"+i).val(databody.full_address != null ? databody.full_address : "");
                        if((databody.action=="DELETE" ) || databody.approve_status =="APPROVED"){

                            if(databody.business_license_image != null && databody.business_license_image != ""){
                                $("#wizardPicturePreview4_"+i).attr('src', hostGetImg + databody.business_license_image);
                                $("#imgOld4_"+i).val(databody.business_license_image);
                            }
                            if(databody.business_license === null || databody.business_license === ""){
                                $("#soGpkd_"+i).val( databody.business_license_update);
                            }
                            else {
                                $("#soGpkd_"+i).val( databody.business_license);
                            }
                        }
                        else{
                            if(databody.update_info.business_license_image != null || databody.update_info.business_license_image != ""){
                                $("#wizardPicturePreview4_"+i).attr('src', hostGetImg + databody.update_info.business_license_image);
                            }
                            else {
                                $("#wizardPicturePreview4_"+i).attr('src', imgDefault);
                            }
                            $("#imgOld4_"+i).val(databody.update_info.business_license_image);
                            if(databody.update_info.business_license != ""){
                                $("#soGpkd_"+i).val( databody.update_info.business_license);
                            }
                            else{
                                if(databody.update_info.business_license_update != null){
                                    $("#soGpkd_"+i).val( databody.update_info.business_license_update);
                                }
                                else {
                                    $("#soGpkd_"+i).val(imgDefault);
                                }
                            }
                        }

                        $("#descriptionEnterprise_"+i).val(databody.approve_description != null ? databody.approve_description : "");
                    }
                }
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function zoomImg(el) {
    console.log(el.src);
    $("#imgZoom").attr('src', el.src);
    $("#imgZoomModal").modal('show');
}

var listProvince = new Array();
function getListProvince() {
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
            console.log(data, " getListProvince");
            if(data.success){
                var province = '<option value="" selected>'+Messages("Tỉnh/ TP")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        // province += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                        listProvince[data.content[i].areaCode] = data.content[i].name;
                    }
                }
                // $("#tinhTpDN").html(province);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function getListDistrict(province, district, index) {
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
                var districtName = '';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        if(data.content[i].areaCode == district){
                            districtName = data.content[i].name;
                            break;
                        }
                    }
                }
                $("#quanHuyenDN_"+index).val(districtName);
            }
        },
        complete: function (){
            // FinishProcess();
            // if(district != ""){
            //     $("#quanHuyenDN").val(district);
            //     getListWard(district, ward);
            // }
        }
    })
}
function getListWard(district, ward, index) {
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
                var wardName = '';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        if(data.content[i].areaCode == ward){
                            wardName = data.content[i].name;
                            break;
                        }
                    }
                }
                $("#phuongXaDN_"+index).val(wardName);
            }
        },
        complete: function (){
            // FinishProcess();
            // $("#phuongXaDN").val(ward);
        }
    })
}

//chap nhan / tu choi
function processComfirmInfoAccount(status) {
    if(status == "REJECTED"){
        if($("#descriptionAccount").val().trim().length == 0){
            showNotification('danger', Messages("Bạn chưa nhập lý do từ chối!"));
            return;
        }
    }

    var body = new FormData;
    body.id = $("#idUser").val();
    body.status = status;
    if(status == "REJECTED"){
        body.description = $("#descriptionAccount").val().trim();
    }
    else {
        body.description = "";
    }
    body.update_info_only = true;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.AdminTelcoController.processComfirmInfoAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            closeModal();
            if(data.status == 200){
                showNotification('success', Messages("Cập nhật thành công"));
            } else {
                showNotification('danger', Messages("Cập nhật thất bại"));
            }
        },
        complete: function (){
            getListApprovedInfo();
        }
    })
}

function processComfirmInfoCompany(status, stt) {
    if(status == "REJECTED"){
        if($("#descriptionEnterprise_"+stt).val().trim().length == 0){
            showNotification('danger', Messages("Bạn chưa nhập lý do từ chối!"));
            return;
        }
    }

    var body = new FormData;
    body.id = $("#id_doanh_nghiep_"+stt).val();
    body.status = status;
    body.description = $("#descriptionEnterprise_"+stt).val().trim();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.AdminTelcoController.processComfirmInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            closeModal();
            if(data.status == 200){
                showNotification('success', Messages("Cập nhật thành công"));
            } else {
                showNotification('danger', Messages("Cập nhật thất bại"));
            }
        },
        complete: function (){
            getListApprovedInfo();
        }
    })
}

function checkFormatDDMMYYYY(input) {
    if(input != "" && input != undefined && input != null){
        var pattern =/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
        return pattern.test(input);
    } else {
        return false;
    }
}

function resetFormSearch() {
    console.log("resetFormSearch");
    $("#email").val('');
    $("#phone").val('');
    $("#name").val('');
    $("#businessLicense").val("");
    $("#role_cmp").val("");
    $("#status").val("");
    getListApprovedInfo();
}