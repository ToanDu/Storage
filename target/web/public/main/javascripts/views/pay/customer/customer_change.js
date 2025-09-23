/**
 * Created by vtk-anhlt166 on 12/17/21.
 */
$('#searchPackChange').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchPackChange').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.namePackDiv').each(function() {
        var isMatch = $(this).find('label').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

function changePackDataModal() {
    if(userIdCurrent == ""){
        showNotification('danger', Messages("Bạn chưa chọn người dùng?"));
        return;
    } else {
        console.log(planIdUserCurrent);
        if(planIdUserCurrent != "" && planIdUserCurrent != null && planIdUserCurrent != undefined){
            return;
        } else {
            getListPackdata();
            $("#changePackDataModal").modal('show');

            $("#serviceTypeNew").val(nameProject);
        }
    }
}

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
                            if(planIdUserCurrent != datas.content.data[i].id){
                                listPack += '<div class="namePackDiv" style="border: 1px solid #858687;">'+
                                    '<input type="radio" onchange="choosePackdataNew(\''+datas.content.data[i].id+'\')" class="form-check-input" id="flexRadioDefault'+i+'" name="flexRadioDefault"/>'+
                                    '<label class="form-check-label" for="flexRadioDefault'+i+'" style="margin-left: 10px">'+datas.content.data[i].name+'</label><br>'+
                                    '</div>';
                            }
                        }
                    }
                }
                $("#listPackData").html(listPack);

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

var packNewId = "";
function choosePackdataNew(packId) {
    console.log(packId);
    packNewId = packId;

    var groupData = new FormData();
    groupData.id = packId;
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
                $("#idPackDataInfoNew").html(Messages("ID: ") + datas.content.data.id);
                $("#namePackDataInfoNew").html(Messages("Tên gói cước: ") + datas.content.data.name);
                if(datas.content.data.type == "offical"){
                    $("#typePackDataInfoNew").html(Messages("Loại gói: ") + Messages("Chính thức"));
                } else {
                    $("#typePackDataInfoNew").html(Messages("Loại gói: ") + Messages("Dùng thử"));
                }
                if(datas.content.data.status == "present"){
                    $("#statusPackDataInfoNew").html(Messages("Trạng thái: ") + Messages("Hiện"));
                } else {
                    $("#statusPackDataInfoNew").html(Messages("Trạng thái: ") + Messages("Ẩn"));
                }
                $("#contentPackDataInfoNew").html(Messages("Mô tả: ") + datas.content.data.description);
                $("#datePackDataInfoNew").html(Messages("Ngày tạo: ") + moment.unix(datas.content.data.date_created).format("HH:mm DD/MM/YYYY"));

                //thong tin goi cuoc
                $("#namePackNew").html(Messages("Gói mới: ") + datas.content.data.name);

                if(datas.content.data.payment_type == "PREPAY"){
                    $("#paymentTypeNew").html(Messages("Trả trước"));
                } else {
                    $("#paymentTypeNew").html(Messages("Trả sau"));
                }
                if(datas.content.data.type_period == "PERIODIC"){
                    $("#typePeriodNew").html(Messages("Định kỳ"));
                } else {
                    $("#typePeriodNew").html(Messages("Một lần"));
                }
                if(datas.content.data.cal_unit == "day"){
                    $("#periodNew").html(datas.content.data.period + Messages(" Ngày"));
                } else if(datas.content.data.cal_unit == "week"){
                    $("#periodNew").html(datas.content.data.period + Messages(" Tuần"));
                } else if(datas.content.data.cal_unit == "month"){
                    $("#periodNew").html(datas.content.data.period + Messages(" Tháng"));
                } else{
                    $("#periodNew").html(datas.content.data.period + Messages(" Năm"));
                }
                $("#fixCostNew").html(datas.content.data.fix_cost);
                if(datas.content.data.charging_unit == "message"){
                    $("#chargingUnitNew").html(Messages("Kết nối"));
                } else {
                    $("#chargingUnitNew").html(Messages("Thiết bị"));
                }
                if(datas.content.data.estimate == "fix"){
                    $("#estimateNew").html(Messages("Cố định"));
                } else if(datas.content.data.estimate == "unit"){
                    $("#estimateNew").html(Messages("Theo đơn vị"));
                } else if(datas.content.data.estimate == "mass"){
                    $("#estimateNew").html(Messages("Khối lượng"));
                }  else if(datas.content.data.estimate == "accumulated"){
                    $("#estimateNew").html(Messages("Lũy kế"));
                } else{
                    $("#estimateNew").html(Messages("Bậc thang"));
                }
                $("#priceNew").html(datas.content.data.price);
                $("#numberFreeNew").html(datas.content.data.quantity_free);

                //chon goi cuoc thi cho select plan_lv neu co
                if(datas.content.data.plan_lv != null && datas.content.data.plan_lv.length > 0){
                    var select = '<select id="registerNew" class="form-select" aria-label="select">';
                    for(var i=0; i<datas.content.data.plan_lv.length; i++){
                        select += '<option value="'+datas.content.data.plan_lv[i].level+'">'+datas.content.data.plan_lv[i].level+'</option>';
                    }
                    select += '</select>';

                    $("#planLvNew").html(select);
                } else {
                    $("#planLvNew").html('<input id="registerNew" type="number" class="form-control" autocomplete="off" value="0" required>');
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

function processChangePackdataForUser() {
    if(packNewId == ""){
        showNotification('danger',Messages("Bạn chưa chọn gói cước mới?"));
        return;
    }

    var groupData = new FormData();
    groupData.user_id = userIdCurrent;
    groupData.plan_id = packNewId;
    groupData.project_id = projectId;
    groupData.service_type= $("#serviceTypeNew").val();
    groupData.register= parseInt($("#registerNew").val());
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PayCustomerController.addPackdataNewForUser();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                getSubsOfUser(userIdCurrent);

                paymentInfo(userIdCurrent);

                showNotification('success', datas.resultString);
            } else {
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

function resetFormChangePackdata() {
    //thong tin goi cuoc
    $("#nameInfoPackInfoNew").html(Messages("Tên: "));
    $("#contentInfoPackInfoNew").html(Messages("Mô tả: "));
    $("#countMaxConnectInfoNew").html(Messages("Số lượng kết nối tối đa: "));
    $("#countMaxMessInfoNew").html(Messages("Số lượng bản tin tối đa: "));
    $("#countMessOnUnitInfoNew").html(Messages("Giá đơn vị phụ trội: "));
    $("#cycleInfoPackInfoNew").html(Messages("Chu kỳ gói cước: "));

    $("#namePackCurrent").html(Messages("Gói hiện tại: Chưa có"));
    $("#countMaxConnectCurrent").html("");
    $("#countMaxMessCurrent").html("");
    $("#countMessOnUnitCurrent").html("");
    $("#countPriceOnUnitCurrent").html("");
    $("#countCyclePackCurrent").html("");

    $("#namePackNew").html(Messages("Gói mới: Chưa chọn"));
    $("#countMaxConnectNew").html("");
    $("#countMaxMessNew").html("");
    $("#countMessOnUnitNew").html("");
    $("#countPriceOnUnitNew").html("");
    $("#countCyclePackNew").html("");
}