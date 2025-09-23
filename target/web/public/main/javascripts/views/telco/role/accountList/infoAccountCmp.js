/**
 * Created by vtk-anhlt166 on 3/3/23.
 */
var hostname = location.protocol + '//' + location.host;
console.log(hostname);
$(document).ready(function () {
    getInfoAccountCmp();
});
function getInfoAccountCmp() {
    var body = new FormData();
    body.user_id = userId;
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.getInfoAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content.info == null){
                backToAccountList();
            }
            if(datas.content != null && datas.content.info != null){
                $("#id").val(datas.content.info.user_id);
                $("#fullName").val(datas.content.info.name);
                $("#roleCmp").val(getRoleNameByCode(datas.content.info.cmp_role));
                $("#email").val(datas.content.info.email);
                $("#phone").val(datas.content.info.phone);
                $("#genEmail").val(datas.content.info.email);

                if(datas.content.info.profile != null){
                    $("#cmnd").val(datas.content.info.profile.identity_info != null ? datas.content.info.profile.identity_info.identity : "");
                    $("#ngaysinh").val(datas.content.info.profile.dob != null ? datas.content.info.profile.dob : "");

                    if(datas.content.info.profile.province != null && datas.content.info.profile.province != ""){
                        getListProvinceAccount(datas.content.info.profile.province, datas.content.info.profile.district, datas.content.info.profile.ward);
                    }

                    $("#diaChi").val(datas.content.info.profile.full_address != null ? datas.content.info.profile.full_address : "");
                } else {
                    $("#diaChi").val("");
                }

                if(datas.content.info.cmp_role == "ENTERPRISE" || datas.content.info.cmp_role == "ENTERPRISE_VIEW"){
                    document.getElementById("buttonImportEnterprise").style.display = "none";
                    document.getElementById("buttonAddEnterprise").style.display = "none";
                } else {
                    document.getElementById("buttonImportEnterprise").style.display = "initial";
                    document.getElementById("buttonAddEnterprise").style.display = "initial";
                }

                if(roleCmp == "SUPER_ENTERPRISE"){
                    document.getElementById("buttonResetEnterprise").style.display = "none";
                    document.getElementById("buttonUpdateEnterprise").style.display = "initial";
                } else {
                    document.getElementById("buttonResetEnterprise").style.display = "initial";
                    document.getElementById("buttonUpdateEnterprise").style.display = "initial";
                }
            }{
            }

            if(datas.content != null && datas.content.enterprises != null){
                if(datas.content.info.user_cmp_role == "ENTERPRISE" || datas.content.info.user_cmp_role == "ENTERPRISE_VIEW" ){
                    if(datas.content.enterprises != null && datas.content.enterprises.data != null){
                        document.getElementById("infoAccountEnterprise").style.display = "block";
                        var data = datas.content.enterprises.data;
                        if(data.length > 0){
                            $("#tenDoanhNghiepEnterprise").val(data[0].name);
                            $("#maSoThueEnterprise").val(data[0].tax_code);
                            $("#soGpkdEnterprise").val(data[0].business_license);
                            $("#ngayThanhLapEnterprise").val(data[0].founded);
                            $("#sdtDnEnterprise").val(data[0].phone);
                            $("#emailDnEnterprise").val(data[0].email);
                            $("#diaChiChiTietDnEnterprise").val(data[0].full_address);

                            $("#wizardPicturePreviewEnterprise").attr('src', hostname + "/getImg/" + data[0].business_license_image);

                            if(data[0].province != null && data[0].province != ""){
                                getListProvinceDnEnterprise(data[0].province, data[0].district, data[0].ward);
                            }
                        }
                    }
                } else {
                    document.getElementById("listEnterprise").style.display = "block";

                    var startAt = (body.page - 1)*body.pageSize;
                    viewdataToTable(datas.content.enterprises, startAt, body.page, body.pageSize, datas.content.info);
                }
            } else {
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    setTimeout(function () {
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    },1500);
                } else {
                    $("#listEnterpriseTable").find('tbody').html("");
                    $("#notiNotData").html("Không có thông tin để hiển thị");
                    showNotification('danger', "Không có thông tin để hiển thị");
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

function viewdataToTable(datas, startAt, page, pageSize, info) {
    var body = "";
    var roleCmp = info.cmp_role;
    var listEnterprise = datas.data;
    if (listEnterprise != null && listEnterprise.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listEnterprise.length; i++) {
            var dataEnterprise = listEnterprise[i];
            // if(dataEnterprise.approve_status != "APPROVED" && dataEnterprise.action != "DELETE"){
            //     dataEnterprise = listEnterprise[i].update_info;
            // }
            if(dataEnterprise.approve_status == "REJECTED" && dataEnterprise.action == "CREATE"){
                    dataEnterprise = listEnterprise[i].update_info;
            }

            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + dataEnterprise.name + "</td>";
            // if(listEnterprise[i].approve_status == "REJECTED" && listEnterprise[i].action == "CREATE"){
            //     body += "<td>"+dataEnterprise.business_license+ "</td>";
            // }
            if (listEnterprise[i].approve_status == "SUBMITTED" && listEnterprise[i].action == "CREATE") {
                body += "<td>"+dataEnterprise.business_license_update+ "</td>"
            }else{
                body += "<td>"+dataEnterprise.business_license+ "</td>";
            }

            if(listEnterprise[i].action== ""){
                body += "<td>CREATE</td>";
            }
            else{
                body += "<td>"+listEnterprise[i].action+ "</td>";
            }
            body += "<td hidden>" + listEnterprise[i].tax_code + "</td>";
            body += "<td hidden>" + listEnterprise[i].founded + "</td>";
            body += "<td class='wrap-text' hidden>" + listEnterprise[i].full_address + "</td>";
            if(listEnterprise[i].approve_status == "APPROVED"){
                body += "<td style='color: green'>" + listEnterprise[i].approve_status + "</td>";
            } else if(listEnterprise[i].approve_status == "SUBMITTED"){
                body += "<td style='color: orange'>" + listEnterprise[i].approve_status + "</td>";
            } else {
                body += "<td style='color: red'>" + listEnterprise[i].approve_status + "</td>";
            }
            body += "<td align='center' style='padding: 0px;'>";
           // body += "<a class='btn' onclick='viewInfoAccount(\""+dataEnterprise.user_id+"\", \""+dataEnterprise.id+"\" , \""+dataEnterprise.business_license+"\")'><i class='bx bx-show'></i></a>";
            if(roleCmp != "ENTERPRISE" && roleCmp != "ENTERPRISE_VIEW"){
                //body += "<a class='btn' onclick='setEditEnterprise(\""+dataEnterprise.id+"\", \""+dataEnterprise.name+"\", \""+dataEnterprise.business_license+"\")'><i class='bx bx-edit'></i></a>";
                body += "<a class='btn' onclick='setDelEnterprise(\""+dataEnterprise.id+"\", \""+dataEnterprise.name+"\")'><i class='bx bx-trash'></i></a>";
            }
            body += "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listEnterpriseTable").find('tbody').html(body);

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

    getInfoAccountCmp();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getInfoAccountCmp();
}

function remotePageManageSubs(gpkd) {
    window.open(jsRoutes.controllers.TelcoSubscriberController.subscriberManage(gpkd).url, '_blank');
}


//thong tin doanh nghiep
function getListProvinceDnEnterprise(province, district, ward) {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == province){
                        $("#tinhTpDnEnterprise").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#tinhTpDnEnterprise").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListDistrictDnEnterprise(province, district, ward);
        }
    })
}
function getListDistrictDnEnterprise(province, district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == district){
                        $("#quanHuyenDnEnterprise").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#quanHuyenDnEnterprise").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListWardDnEnterprise(district, ward);
        }
    })
}
function getListWardDnEnterprise(district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == ward){
                        $("#phuongXaDnEnterprise").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#phuongXaDnEnterprise").val("");
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//thong tin account
function getListProvinceAccount(province, district, ward) {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == province){
                        $("#tinh").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#tinh").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListDistrictAccount(province, district, ward);
        }
    })
}
function getListDistrictAccount(province, district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == district){
                        $("#quan").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#quan").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListWardAccount(district, ward);
        }
    })
}
function getListWardAccount(district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == ward){
                        $("#phuong").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#phuong").val("");
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function backToAccountList() {
    //console.log(jsRoutes.controllers.TelcoRoleAccountController.accountList().url);
    //window.open(jsRoutes.controllers.TelcoRoleAccountController.accountList().url, "_blank");
     window.location.href = "http://iot.viettel.vn/telco/accountList";

}