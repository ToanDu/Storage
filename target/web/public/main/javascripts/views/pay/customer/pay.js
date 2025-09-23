/**
 * Created by vtk-anhlt166 on 12/20/21.
 */
$(document).ready(function () {
    getInfoPackUser();
});

function getInfoPackUser() {
    var groupData = new FormData();
    groupData.userid = userid;

    // StartProcess();
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
                $("#namePackUserCurrent").html(Messages("Tên: ") + datas.content.name);
                // $("#idPackUserCurrent").html(Messages("Mã ID: ") + datas.content.id);
                $("#datePackUserCurrent").html(Messages("Ngày áp dụng gói cước: "));
                var chuki = Messages("packdata.day");
                if(datas.content.rate_type == 1){
                    chuki = Messages("packdata.week");
                } else if(datas.content.rate_type == 2){
                    chuki = Messages("packdata.month");
                } else if(datas.content.rate_type == 3){
                    chuki = Messages("packdata.year");
                }
                $("#cyclePackUserCurrent").html(Messages("Chu kỳ: ") + chuki);


                $("#countMaxConnectUser").html(datas.content.num_device_connected + "/" + datas.content.max_number_device);
                $("#countMaxMessUser").html(datas.content.num_message_usage + "/" + datas.content.max_number_msg);

                if(datas.content.num_message_usage <= datas.content.max_number_msg){
                    $("#countMessChargingUser").html(0);
                } else {
                    $("#countMessChargingUser").html(datas.content.num_message_usage - datas.content.max_number_msg);
                }

                $("#feeWithPack").html(datas.content.default_price);
                if(datas.content.amount <= datas.content.default_price){
                    $("#feeCharging").html(0);
                } else {
                    $("#feeCharging").html(datas.content.amount - datas.content.default_price);
                }
                $("#totalFee").html(datas.content.amount);

            } else {

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