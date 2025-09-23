/**
 * Created by vtk-anhlt166 on 12/3/21.
 */
$(document).ready(function () {
    getListPackdata();
});

$('#searchPackData').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchPackData').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_packdata').each(function() {
        var isMatch = $(this).find('h4').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

var idPackdataCurrent = "";
function getListPackdata() {
    var groupData = new FormData();
    groupData.projectId = projectId;
    console.log(groupData);

    // StartProcess();
    var r = jsRoutes.controllers.PayPackDataController.getListPackdata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                var listPack = "";
                if(datas.content != null){
                    if(datas.content.data != null && datas.content.data.length > 0){
                        for(var i=0; i<datas.content.data.length; i++){
                            var chuki = Messages("packdata.day");
                            if(datas.content.data[i].rate_type == 1){
                                chuki = Messages("packdata.week");
                            } else if(datas.content.data[i].rate_type == 2){
                                chuki = Messages("packdata.month");
                            } else if(datas.content.data[i].rate_type == 3){
                                chuki = Messages("packdata.year");
                            }
                            listPack +=
                                '<div class="card list_packdata">'+
                                '<div class="d-flex" id="packdata-'+datas.content.data[i].id+'" style="background-color: #858687; padding: 5px 10px 0px 10px; border-radius: 5px 5px 0px 0px;">'+
                                '<h4 class="mb-0 text-white">'+'<a style="cursor: pointer; width: 100%; font-weight: normal;" onclick="choosePackdata(\''+datas.content.data[i].id+'\')" id="namePack_'+datas.content.data[i].id+'">'+datas.content.data[i].name+'</a>'+'</h4>'+
                                '<div class="font-22 ms-auto text-white">'+
                                '<i class="bx bx-dots-horizontal-rounded" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>'+
                                '<ul class="dropdown-menu dropdown-table">'+
                                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="choosePackdata(\''+datas.content.data[i].id+'\')"><img src="'+iconEdit+'" alt=""/>&nbsp&nbsp '+Messages("btnDetail")+'</a></li>'+
                                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditPack(\''+datas.content.data[i].id+'\')"><img src="'+iconEdit+'" alt=""/>&nbsp&nbsp '+Messages("btnEdit")+'</a></li>'+
                                '<li style="cursor: pointer"><a class="dropdown-item" onclick="setIdDelPack(\''+datas.content.data[i].id+'\')"><img src="'+iconDelete+'" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>'+
                                '</ul>'+
                                '</div>'+
                                '</div>'+
                                '<div class="row row-cols-1 row-cols-md-12 row-cols-xl-12 g-0 row-group border-top" style="border: 1px solid #858687;">'+
                                '<div class="col">'+
                                '<div class="p-3">'+
                                '<h6 class="mb-0">'+'<span style="font-weight: 300">'+Messages("ID")+Messages(": ")+datas.content.data[i].id+'</span>'+'</h6>'+
                                '<h6 class="mb-0 mt-1 textOverflow">'+'<span style="font-weight: 300" id="content_'+datas.content.data[i].id+'">'+Messages("packdata.content")+Messages(": ")+datas.content.data[i].description+'</span></h6>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '</div>';
                        }
                    }
                }
                $("#listPackData").html(listPack);

                if(idPackdataCurrent.length > 0){
                    choosePackdata(idPackdataCurrent);
                } else {
                    if(datas.content.data != null && datas.content.data.length > 0){
                        choosePackdata(datas.content.data[0].id);
                    }
                }
            }else {
                showNotification('danger', datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

var rate_type = 0;
function change_Checkbox_action(el) {
    rate_type = el;
}



function choosePackdata(id) {
    if(idPackdataCurrent != ""){
        removeHoverPackDataItem(idPackdataCurrent);
    }

    idPackdataCurrent = id;

    getInfoPack(id);

    setTimeout(function () {
        setHoverPackDataItem(id);
    },300)
}

function getInfoPack(id) {
    console.log(id);

    var groupData = new FormData();
    groupData.id = id;

    StartProcess();
    var r = jsRoutes.controllers.PayPackDataController.getInfoPackdata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                // showNotification('success', datas.resultString);

                $("#namePack_"+id).html(datas.content.data.name);
                $("#content_"+id).html(Messages("Mô tả: ") + datas.content.data.description );

                $("#idPackDataInfo").html(Messages("ID: ") + datas.content.data.id);
                $("#namePackDataInfo").html(Messages("Tên gói cước: ") + datas.content.data.name);
                if(datas.content.data.type == "offical"){
                    $("#typePackDataInfo").html(Messages("Loại gói: ") + Messages("Chính thức"));
                } else {
                    $("#typePackDataInfo").html(Messages("Loại gói: ") + Messages("Dùng thử"));
                }
                if(datas.content.data.status == "present"){
                    $("#statusPackDataInfo").html(Messages("Trạng thái: ") + Messages("Hiện"));
                } else {
                    $("#statusPackDataInfo").html(Messages("Trạng thái: ") + Messages("Ẩn"));
                }
                $("#contentPackDataInfo").html(Messages("Mô tả: ") + datas.content.data.description);
                $("#datePackDataInfo").html(Messages("Ngày tạo: ") + moment.unix(datas.content.data.date_created).format("HH:mm DD/MM/YYYY"));

                if(datas.content.data.payment_type == "PREPAY"){
                    $("#paymentTypeInfo").html(Messages("Phương thức thanh toán: ") + Messages("Trả trước"));
                } else {
                    $("#paymentTypeInfo").html(Messages("Phương thức thanh toán: ") + Messages("Trả sau"));
                }
                if(datas.content.data.type_period == "PERIODIC"){
                    $("#typePeriodInfo").html(Messages("Loại chu kỳ tính tiền: ") + Messages("Định kỳ"));
                } else {
                    $("#typePeriodInfo").html(Messages("Loại chu kỳ tính tiền: ") + Messages("Một lần"));
                }
                if(datas.content.data.cal_unit == "day"){
                    $("#periodInfo").html(Messages("Chu kì tính tiền: ") + datas.content.data.period + Messages(" Ngày"));
                } else if(datas.content.data.cal_unit == "week"){
                    $("#periodInfo").html(Messages("Chu kì tính tiền: ") + datas.content.data.period + Messages(" Tuần"));
                } else if(datas.content.data.cal_unit == "month"){
                    $("#periodInfo").html(Messages("Chu kì tính tiền: ") + datas.content.data.period + Messages(" Tháng"));
                } else{
                    $("#periodInfo").html(Messages("Chu kì tính tiền: ") + datas.content.data.period + Messages(" Năm"));
                }
                $("#fixCostInfo").html(Messages("Chi phí cố định hàng kỳ: ") + datas.content.data.fix_cost + Messages(" VND"));
                if(datas.content.data.charging_unit == "message"){
                    $("#chargingUnitInfo").html(Messages("Đơn vị tính: ") + Messages("Kết nối"));
                } else if(datas.content.data.charging_unit == "device"){
                    $("#chargingUnitInfo").html(Messages("Đơn vị tính: ") + Messages("Thiết bị"));
                }else {
                    $("#chargingUnitInfo").html(Messages("Đơn vị tính: ") + Messages("API"));
                }
                if(datas.content.data.estimate == "fix"){
                    $("#estimateInfo").html(Messages("Phương pháp định giá: ") + Messages("Cố định"));
                } else if(datas.content.data.estimate == "unit"){
                    $("#estimateInfo").html(Messages("Phương pháp định giá: ") + Messages("Theo đơn vị"));
                } else if(datas.content.data.estimate == "mass"){
                    $("#estimateInfo").html(Messages("Phương pháp định giá: ") + Messages("Khối lượng"));
                }  else if(datas.content.data.estimate == "accumulated"){
                    $("#estimateInfo").html(Messages("Phương pháp định giá: ") + Messages("Lũy kế"));
                } else{
                    $("#estimateInfo").html(Messages("Phương pháp định giá: ") + Messages("Bậc thang"));
                }
                $("#priceInfo").html(Messages("Số tiền: ") + datas.content.data.price + Messages(" VND"));
                $("#numberFreeInfo").html(Messages("Số lượng miễn phí: ") + datas.content.data.quantity_free);

                //Phương pháp định giá...
                $("#planLevelInfo").html("");
                if(datas.content.data.plan_lv != null && datas.content.data.plan_lv.length > 0){
                    document.getElementById("tabPlanLevelInfo").style.display = "block";
                    if(datas.content.data.estimate == "accumulated"){
                        for(var i=0; i<datas.content.data.plan_lv.length; i++){
                            var textLevelEdit = Messages("Từ 1 đến ");
                            if(i > 0){
                                textLevelEdit = Messages("Từ ") + (parseInt(datas.content.data.plan_lv[i-1].level)+1) + Messages(" đến ");
                            }

                            var levelPlan = (datas.content.data.plan_lv[i].level != null) ? datas.content.data.plan_lv[i].level : Messages(" vô cùng");
                            var pricePlan = Messages("Đơn giá: ") + datas.content.data.plan_lv[i].price + " VND";
                            var planLv =
                                '<div class="row">'+
                                '<div class="col-md-6">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+ textLevelEdit + levelPlan +'</h4>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-6">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+pricePlan+'</h4>'+
                                '</div>'+
                                '</div>'+
                                '</div>';
                            $("#planLevelInfo").append(planLv);
                        }
                    } else if(datas.content.data.estimate == "step"){
                        for(var i=0; i<datas.content.data.plan_lv.length; i++){
                            var levelPlan = (datas.content.data.plan_lv[i].level != null) ? (Messages("Tối đa: ") + datas.content.data.plan_lv[i].level) : Messages("Tối đa: vô cùng");
                            var pricePlan = Messages("Số tiền: ") + datas.content.data.plan_lv[i].price + " VND";
                            var planLv =
                                '<div class="row">'+
                                '<div class="col-md-6">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+ levelPlan +'</h4>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-6">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+pricePlan+'</h4>'+
                                '</div>'+
                                '</div>'+
                                '</div>';
                            $("#planLevelInfo").append(planLv);
                        }
                    } else {
                        for(var i=0; i<datas.content.data.plan_lv.length; i++){
                            var textLevelEdit = Messages("Từ 1 đến ");
                            if(i > 0){
                                textLevelEdit = Messages("Từ ") + (parseInt(datas.content.data.plan_lv[i-1].level)+1) + Messages(" đến ");
                            }

                            var levelPlan = (datas.content.data.plan_lv[i].level != null) ? datas.content.data.plan_lv[i].level : Messages(" vô cùng");
                            var pricePlan = Messages("Đơn giá: ") + datas.content.data.plan_lv[i].price + " VND";
                            var freePlan = Messages("Miễn phí: ") + datas.content.data.plan_lv[i].free;
                            var planLv =
                                '<div class="row">'+
                                '<div class="col-md-4">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+ textLevelEdit + levelPlan +'</h4>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-5">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+pricePlan+'</h4>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-3">'+
                                '<div class="row mb-4">'+
                                '<h4 class="col-sm-12 col-form-label" >'+freePlan+'</h4>'+
                                '</div>'+
                                '</div>'+
                                '</div>';
                            $("#planLevelInfo").append(planLv);
                        }
                    }

                } else {
                    document.getElementById("tabPlanLevelInfo").style.display = "none";
                }

            }else {
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
    });
}

function removeHoverPackDataItem(id) {
    $('#packdata-' + id).css('background-color', '#858687');
}

function setHoverPackDataItem(id) {
    $('#packdata-' + id).css('background-color', '#EC1B2E');
}


//delete
function setIdDelPack(id) {
    $("#idPackdataDelete").val(id);
    $("#deletePackdataConfirm").modal('show');
}
function postDataDelPackdata() {
    var groupData = new FormData();
    groupData.id = $("#idPackdataDelete").val();

    StartProcess();
    var r = jsRoutes.controllers.PayPackDataController.deletePackdata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                idPackdataCurrent = "";
                showNotification('success', datas.resultString);
                getListPackdata();
            }else {
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
    });
}
