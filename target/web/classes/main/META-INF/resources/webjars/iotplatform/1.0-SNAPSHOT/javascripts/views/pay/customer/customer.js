/**
 * Created by vtk-anhlt166 on 12/17/21.
 */
var orgIdCurrent = "";
var usernameCurrent = "";
var userIdCurrent = "";
var planIdUserCurrent = "";

$(document).ready(function () {
    getNameProject();

    getOrgs("chooseOrg");

    getInfoVendor();
});

$('#searchCustomer').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchCustomer').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_customer').each(function() {
        var isMatch = $(this).find('h6').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

var nameProject = "";
function getNameProject() {
    StartProcess();
    var route = jsRoutes.controllers.ProjectController.getNameProject(projectId);
    $.ajax({
        type: route.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if (data.success) {
                nameProject = data.content;
            }
            else {
                showNotification('danger', Messages("connection.failed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    })
}

function getOrgs(id){
    StartProcess();
    var route = jsRoutes.controllers.GroupController.getListOrganizations(projectId);
    $.ajax({
        type: route.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#"+id).html('<option value="" selected disabled>'+Messages("packdata.chooseOrg")+'</option>');
                if(data.content.organizations != null && data.content.organizations.length>0){
                    var se = '<option value="'+projectId+'">'+Messages("Dự án: ") + nameProject+'</option>';
                    $("#"+id).append(se);

                    for(var i = 0; i < data.content.organizations.length; i++){
                        var op = '<option value="'+data.content.organizations[i].id+'">'+data.content.organizations[i].name+'</option>';
                        $("#"+id).append(op);

                        if(data.content.organizations[i].sub_orgs != null && data.content.organizations[i].sub_orgs.length > 0){
                            appendOptionOrg(data.content.organizations[i].sub_orgs, id);
                        }
                    }
                    $("#"+id).val(orgIdCurrent).change();
                }
            }
            else{
                showNotification('danger', Messages("connection.failed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}
function appendOptionOrg(data, id) {
    for(var i = 0; i < data.length; i++){
        var op = '<option value="'+data[i].id+'">'+data[i].name+'</option>';
        $("#"+id).append(op);

        if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
            appendOptionOrg(data[i].sub_orgs, id);
        }
    }
}

function getListUserOrg() {
    console.log($("#chooseOrg").val(), " - ", projectId);
    if($("#chooseOrg").val() == null || $("#chooseOrg").val() == ""){
        return;
    }

    var groupData = new FormData();
    groupData.projectId = projectId;
    if(projectId == $("#chooseOrg").val()){
        groupData.orgId = "";
    } else {
        groupData.orgId = $("#chooseOrg").val();
    }
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PayCustomerController.getListUserInOrg();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                if(datas.content != null && datas.content.data != null){
                    var listUser = datas.content.data.users;
                    var list = "";
                    if(listUser.length > 0){
                        for(var i=0; i<listUser.length; i++){
                            list += '<div class="card list_customer">'+
                                '<div class="d-flex align-items-center" id="customer-'+listUser[i].user_id+'" style="background-color: #858687; padding: 0px 0px 0px 20px;; border-radius: 5px 5px 0px 0px;">'+
                                '<h6 class="mb-0 text-white" style="cursor: pointer" onclick="getInfoPackOfUser(\''+listUser[i].p_plan_id+'\', \''+listUser[i].user_id+'\', \''+listUser[i].email+'\')">'+listUser[i].email+'</h6>'+
                                '<div class="font-22 ms-auto text-white">'+
                                '<i class="bx bx-dots-horizontal-rounded" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>'+
                                '<ul class="dropdown-menu dropdown-table">'+
                                '<li style="cursor: pointer"><a class="dropdown-item" onclick="getInfoPackOfUser(\''+listUser[i].p_plan_id+'\', \''+listUser[i].user_id+'\', \''+listUser[i].email+'\')"><img src="'+iconEdit+'" alt=""/>&nbsp&nbsp'+Messages("btnDetail")+'</a></li>'+
                                '<li style="cursor: pointer"><a class="dropdown-item" onclick="listBillOfUser(\''+listUser[i].user_id+'\')"><img src="'+iconList+'" alt=""/>&nbsp&nbsp'+Messages("Danh sách hóa đơn")+'</a></li>'+
                                '<li style="cursor: pointer"><a class="dropdown-item" onclick="showModalCancle()"><img src="'+iconDelete+'" alt=""/>&nbsp&nbsp'+Messages("Hủy gói cước")+'</a></li>'+
                                '</ul>'+
                                '</div>'+
                                '</div>'+
                                '<div class="row row-cols-1 row-cols-md-12 row-cols-xl-12 g-0 row-group text-center border-top" style="border: 1px solid #858687;">'+
                                '<div class="col">'+
                                '<div class="">'+
                                '<small class="mb-0" style="color: black" id="planName_'+listUser[i].user_id+'">'+Messages("Gói cước: ") + ((listUser[i].p_plan_name != null && listUser[i].p_plan_name != "") ? listUser[i].p_plan_name : Messages("Chưa có")) +'</small>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '</div>';
                        }
                        $("#listUserOfOrg").html(list);
                    } else {
                        $("#listUserOfOrg").html("");
                    }
                } else {
                    $("#listUserOfOrg").html("");
                }
            } else {
                $("#listUserOfOrg").html("");
                showNotification('danger', datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })

}

function getInfoPackOfUser(id, userid, email) {
    console.log(id, userid);
    if(userIdCurrent != ""){
        removeHoverCustomerItem(userIdCurrent);
    }

    userIdCurrent = userid;
    usernameCurrent = email;

    setHoverCustomerItem(userid);

    $("#idUserCurrent").html(Messages("ID: ") + userid);
    getInfoCustomer(userid);

    getSubsOfUser(userid);

    // cuoc tam tinh
    paymentInfo(userid);
}

function getInfoCustomer(userId) {
    StartProcess();
    var formData = new FormData;
    formData.userId = userId;
    var url = jsRoutes.controllers.PayCustomerController.getInfoCustomer();
    $.ajax({
        type: url.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: url.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                setEditCustomer(datas.content.data);
                $("#nameUserCurrent").html(Messages("Tên: ") + datas.content.data.name);
                $("#phoneUserCurrent").html(Messages("Số điện thoại: ") + datas.content.data.phone);
                $("#addressUserCurrent").html(Messages("Địa chỉ: ") + datas.content.data.address);
            } else {
                $("#nameUserCurrent").html(Messages("Tên: "));
                $("#phoneUserCurrent").html(Messages("Số điện thoại: "));
                $("#addressUserCurrent").html(Messages("Địa chỉ: "));

                $("#isUpdate").val(0);
                $("#idCustomerEdit").val(userId);
                $("#nameCustomerEdit").val("");
                $("#phoneCustomerEdit").val("");
                $("#addressCustomerEdit").val("");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function getSubsOfUser(userId) {
    var groupData = new FormData();
    groupData.userId = userId;

    StartProcess();
    var r = jsRoutes.controllers.PayCustomerController.getSubscription();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                $("#planName_"+ userId).html(Messages("Gói cước: ") + datas.content.data.p_name);

                $("#idPackDataUser").html(Messages("ID Gói cước: ") + datas.content.data.p_id);
                $("#idSubsUser").html(Messages("ID Đăng ký: ") + datas.content.data.s_id);
                planIdUserCurrent = datas.content.data.p_id;
                $("#namePackDataUser").html(Messages("Tên gói cước: ")+ datas.content.data.p_name);
                if(datas.content.data.p_type == "offical"){
                    $("#typePackDataUser").html(Messages("Loại gói: ") + Messages("Chính thức"));
                } else {
                    $("#typePackDataUser").html(Messages("Loại gói: ") + Messages("Dùng thử"));
                }
                if(datas.content.data.s_status == "Active"){
                    $("#statusPackDataUser").html(Messages("Trạng thái: ") + '<span style="color: green">'+datas.content.data.s_status+'</span>');
                } else if(datas.content.data.s_status == "Cancelled"){
                    $("#statusPackDataUser").html(Messages("Trạng thái: ") + '<span style="color: red">'+datas.content.data.s_status+'</span>');
                } else {
                    $("#statusPackDataUser").html(Messages("Trạng thái: ") + '<span style="color: orangered">'+datas.content.data.s_status+'</span>');
                }

                $("#contentPackDataUser").html(Messages("Mô tả: ") + datas.content.data.p_description);
                $("#datePackDataUser").html(Messages("Ngày đăng kí: ") + moment.unix(datas.content.data.s_date_register).format("HH:mm DD/MM/YYYY"));

                //thong tin goi cuoc
                $("#namePackCurrent").html(Messages("Gói hiện tại: ") + datas.content.data.p_name);
                if(datas.content.data.p_payment_type == "PREPAY"){
                    $("#paymentTypeCurrent").html(Messages("Trả trước"));
                } else {
                    $("#paymentTypeCurrent").html(Messages("Trả sau"));
                }
                if(datas.content.data.p_type_period == "PERIODIC"){
                    $("#typePeriodCurrent").html(Messages("Định kỳ"));
                } else {
                    $("#typePeriodCurrent").html(Messages("Một lần"));
                }
                if(datas.content.data.p_cal_unit == "day"){
                    $("#periodCurrent").html(datas.content.data.p_period + Messages(" Ngày"));
                } else if(datas.content.data.p_cal_unit == "week"){
                    $("#periodCurrent").html(datas.content.data.p_period + Messages(" Tuần"));
                } else if(datas.content.data.p_cal_unit == "month"){
                    $("#periodCurrent").html(datas.content.data.p_period + Messages(" Tháng"));
                } else{
                    $("#periodCurrent").html(datas.content.data.p_period + Messages(" Năm"));
                }
                $("#fixCostCurrent").html(datas.content.data.p_fix_cost);
                if(datas.content.data.p_charging_unit == "message"){
                    $("#chargingUnitCurrent").html(Messages("Kết nối"));
                } else {
                    $("#chargingUnitCurrent").html(Messages("Thiết bị"));
                }
                if(datas.content.data.p_estimate == "fix"){
                    $("#estimateCurrent").html(Messages("Cố định"));
                } else if(datas.content.data.p_estimate == "unit"){
                    $("#estimateCurrent").html(Messages("Theo đơn vị"));
                } else if(datas.content.data.p_estimate == "mass"){
                    $("#estimateCurrent").html(Messages("Khối lượng"));
                }  else if(datas.content.data.p_estimate == "accumulated"){
                    $("#estimateCurrent").html(Messages("Lũy kế"));
                } else{
                    $("#estimateCurrent").html(Messages("Bậc thang"));
                }
                $("#priceCurrent").html(datas.content.data.p_price);
                $("#numberFreeCurrent").html(datas.content.data.p_quantity_free);

                document.getElementById("buttonChangePackData").style.display = "none";

                $("#idDelete").val(datas.content.data.s_id);
            } else {
                planIdUserCurrent = "";
                $("#idPackDataUser").html(Messages("ID Gói cước: "));
                $("#idSubsUser").html(Messages("ID Đăng ký: "));
                $("#namePackDataUser").html(Messages("Tên gói cước: "));
                $("#typePackDataUser").html(Messages("Loại gói: "));
                $("#statusPackDataUser").html(Messages("Trạng thái: "));
                $("#contentPackDataUser").html(Messages("Mô tả: "));
                $("#datePackDataUser").html(Messages("Ngày tạo: "));

                $("#namePackCurrent").html(Messages("Gói hiện tại: Chưa có"));
                $("#paymentTypeCurrent").html("");
                $("#typePeriodCurrent").html("");
                $("#periodCurrent").html("");
                $("#fixCostCurrent").html("");
                $("#chargingUnitCurrent").html("");
                $("#estimateCurrent").html("");
                $("#priceCurrent").html("");
                $("#numberFreeCurrent").html("");

                document.getElementById("buttonChangePackData").style.display = "block";

                $("#idDelete").val("");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function paymentInfo(userid) {
    var groupData = new FormData();
    groupData.userid = userid;
    var r = jsRoutes.controllers.PayCustomerController.postPricingOfCustomer();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                $("#totalMessageUse").html(datas.content.data.messages != null ? datas.content.data.messages : 0);
                $("#totalConnectUse").html(datas.content.data.connect != null ? datas.content.data.connect : 0);
                $("#totalRegisterUse").html(datas.content.data.register != null ? datas.content.data.register : 0);
                $("#totalFeeUse").html(datas.content.data.cost != null ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(datas.content.data.cost)) : 0);
            } else {
                $("#totalMessageUse").html(0);
                $("#totalConnectUse").html(0);
                $("#totalRegisterUse").html(0);
                $("#totalFeeUse").html(0);
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

function updateCustomerInfo() {
    if(userIdCurrent == null || userIdCurrent == undefined || userIdCurrent == ""){
        showNotification('danger',Messages("Bạn chưa chọn người dùng"));
        return;
    } else {
        StartProcess();
        var formData = new FormData;


        var r = jsRoutes.controllers.PayCustomerController.updateInfoCustomer();
        if($("#isUpdate").val() == 0){
            r = jsRoutes.controllers.PayCustomerController.createInfoCustomer();

            formData.project_id = projectId;
            formData.user_id = userIdCurrent;
            formData.name = $("#nameCustomerEdit").val();
            formData.phone = $("#phoneCustomerEdit").val();
            formData.address = $("#addressCustomerEdit").val();
        } else {
            formData.user_id = userIdCurrent;
            formData.name = $("#nameCustomerEdit").val();
            formData.phone = $("#phoneCustomerEdit").val();
            formData.address = $("#addressCustomerEdit").val();
        }
        console.log(formData);

        $.ajax({
            type: r.type,
            dataType: 'json',
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (datas) {
                console.log(datas);
                if(datas.success){
                    getInfoCustomer(userIdCurrent);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
            },
            complete: function (jqXHR, textStatus) {
                FinishProcess();
            }
        });
    }
}

function setEditCustomer(data) {
    $("#isUpdate").val(1);
    $("#idCustomerEdit").val(userIdCurrent);
    $("#nameCustomerEdit").val(data.name);
    $("#phoneCustomerEdit").val(data.phone);
    $("#addressCustomerEdit").val(data.address);
}

function removeHoverCustomerItem(id) {
    $('#customer-' + id).css('background-color', '#858687');
}

function setHoverCustomerItem(id) {
    $('#customer-' + id).css('background-color', '#EC1B2E');
}

function listBillOfUser(userId) {
    window.location.href = jsRoutes.controllers.PayBillController.billUserList(projectId, userId).url;
}