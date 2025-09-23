/**
 * Created by vtk-anhlt166 on 1/4/23.
 */
var orderIdRecharge;

function comfirmProcessRechargeSubs() {
    if(listRechargeSubs.length <= 0){
        showNotification('danger',Messages("Không có thuê bao nào được chọn"));
        return;
    }

    $("#comfirmProcessRechargeSubsModal").modal('show');
    $("#comfirmProcessRechargeSubs").html("Xác nhận thanh toán " + $("#totalRecharge").text() + " cho " + $("#countRechargeSub").text() + " thuê bao");
}

function processRechargeListSubs() {
    StartProcess();

    console.log(listRechargeSubs);
    var listIsdn = [];
    for(var i=0; i<listRechargeSubs.length; i++){
        listIsdn.push({
            "isdn":listRechargeSubs[i],
            "id_no":listIdNoRechargeSubsTrue[listRechargeSubs[i]]
        })
    }

    var body = new FormData;
    body.list = listIsdn;
    body.amount = parseInt($("#moneyRecharge").val());
    body.user_id = userId;
    body.reason = "Nạp tiền";
    console.log(body);

    var r = jsRoutes.controllers.TelcoUtilitiesController.rechargeSubcriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null){
                    $("#comfirmRechargeSubsModal").modal('show');
                    orderIdRecharge = datas.content.data.order_id;
                    window.open(datas.content.data.link_check_out, "_blank");
                }
            } else {
                showNotification('danger',Messages("Lấy link thanh toán không thành công"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function comfirmPayRechargeSuccess() {
    if(orderIdRecharge != undefined && orderIdRecharge != null){
        StartProcess();
        checkStatusSubRecharge(0, orderIdRecharge);
    }
}
function checkStatusSubRecharge(index, orderId) {
    console.log(index, orderId);
    var body = new FormData();
    body.isdn = listRechargeSubs[index];
    body.order_id = orderId;
    body.userId = userId;
    console.log(body);

    var r = jsRoutes.controllers.TelcoUtilitiesController.getInfoOrderId();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var state = datas.content.data[0].state;
                    if(state == "error"){
                        $("#status-recharge-"+listRechargeSubs[index]).html("<span class='text-danger'>"+"Lỗi hệ thống"+"</span>");
                    } else if(state == "processing"){
                        $("#status-recharge-"+listRechargeSubs[index]).html("<span class='text-warning'>"+"Đang xử lý"+"</span>");
                    } else {
                        if(state == "done:0" || state == "done:00"){
                            $("#status-recharge-"+listRechargeSubs[index]).html("<span class='text-success'>"+"Thành công"+"</span>");
                        } else {
                            $("#status-recharge-"+listRechargeSubs[index]).html("<span class='text-danger'>"+"Không thành công"+"</span>");
                        }
                    }
                } else {
                    $("#status-recharge-"+listRechargeSubs[index]).html("<span class='text-danger'>"+"Không tìm thấy dữ liệu"+"</span>");
                }
            } else {
                $("#status-recharge-"+listRechargeSubs[index]).html("<span class='text-danger'>"+"Không tìm thấy dữ liệu"+"</span>");
            }
        },
        complete: function (){
            if(index < listRechargeSubs.length-1){
                setTimeout(function () {
                    checkStatusSubRecharge(index+1, orderId);
                },1000);
            } else {
                FinishProcess();
            }
        }
    })
}