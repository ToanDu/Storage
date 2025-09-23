function processVerifyCodeConnectSubs() {
    if($("#codeVerify").val().trim().length <= 0){
        showNotification('danger', Messages("Bạn chưa nhập mã xác nhận"));
        return;
    }

    var body = new FormData;
    body.idLink = idLink;
    body.code = $("#codeVerify").val().trim();
    StartProcess();
    var r = jsRoutes.controllers.TelcoQrcodeController.getInfoConnectSubs();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success && datas.content != null){
                if(datas.content.code == 0 && datas.content.data != null){
                    var tbody =
                        '<div><label style="width: 110px;">'+Messages("User đấu nối")+'</label>'+'<span>'+datas.content.data.staffCode+'</span>'+'</div>'+
                        '<div><label style="width: 110px;">'+Messages("Gói cước")+'</label>'+'<span>'+datas.content.data.productCode+'</span>'+'</div>'+
                        '<div><label style="width: 110px;">'+Messages("Serial Sim")+'</label>'+'<span>'+datas.content.data.serial+'</span>'+'</div>'+
                        '<div><label style="width: 110px;">'+Messages("Giá tiền")+'</label>'+'<span>'+datas.content.data.amount+'</span>'+'</div>';

                    $("#detailInfoConnectSubs").html(tbody);
                    document.getElementById("formDetailConnectSubs").style.display = 'block';
                    document.getElementById("formVerifyConnectSubs").style.display = 'none';

                    document.getElementById("buttonPaymentConnect").style.display = 'block';
                    document.getElementById("buttonFinishConnect").style.display = 'none';
                } else {
                    showNotification('danger', Messages("Lấy thông tin không thành công"));
                    return;
                }
            } else {
                showNotification('danger', Messages("Lấy thông tin không thành công"));
                return;
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function paymentConnectSubs() {
    var body = new FormData;
    body.idLink = idLink;
    body.code = $("#codeVerify").val().trim();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoQrcodeController.paymentConnectSubs();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success && datas.content != null){
                if(datas.content.data != null){
                    document.getElementById("buttonPaymentConnect").style.display = 'none';
                    document.getElementById("buttonFinishConnect").style.display = 'block';
                    window.open(datas.content.data.link_check_out, "_blank");
                }
            } else {
                showNotification('danger', Messages("Lấy link thanh toán không thành công"));
                return;
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function finishQrConnect() {
    window.location.reload();
}

function backFormVerifyConnect() {
    document.getElementById("formDetailConnectSubs").style.display = 'none';
    document.getElementById("formVerifyConnectSubs").style.display = 'block';
}