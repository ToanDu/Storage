/**
 * Created by vtk-anhlt166 on 11/22/22.
 */
function showInfoContact(contractIds, accountNo, status, payType) {
    $("#infoContract").modal('show');
    $("#accountIdDetail").val(contractIds).attr('title', contractIds);
    $("#accountNoDetail").val(accountNo).attr('title', accountNo);
    $("#accountStatus").val(getStatusByCode(status, payType)).attr('title', getStatusByCode(status, payType));

    getDebitContract(contractIds);
}

function getDebitContract(contractIds) {
    var body = new FormData();
    body.contractIds = contractIds;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoContractController.getDebitContract();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log("getDebitSubscriber ", datas);
            if(datas.success && datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    $("#adjustAmountContract").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].adjustAmount)))
                        .attr('title', new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].adjustAmount)));
                    $("#hotChargeContract").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].hotCharge)))
                        .attr('title', new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].hotCharge)));
                    $("#paymentContract").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].payment)))
                        .attr('title', new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].payment)));
                    $("#staOfCycleContract").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].staOfCycle)))
                        .attr('title', new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].staOfCycle)));
                    $("#remainAmountContract").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].remainAmount)))
                        .attr('title', new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].remainAmount)));
                    $("#excessCashContract").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].excessCash)))
                        .attr('title', new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].excessCash)));
                } else {
                    $("#adjustAmountContract").val("");
                    $("#hotChargeContract").val("");
                    $("#paymentContract").val("");
                    $("#staOfCycleContract").val("");
                    $("#remainAmountContract").val("");
                    $("#excessCashContract").val("");
                }
            } else {
                $("#adjustAmountContract").val("");
                $("#hotChargeContract").val("");
                $("#paymentContract").val("");
                $("#staOfCycleContract").val("");
                $("#remainAmountContract").val("");
                $("#excessCashContract").val("");
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}