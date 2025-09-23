/**
 * Created by vtk-anhlt166 on 2/2/23.
 */
function contentComfirmOrder() {
    var tong_don_gia = document.getElementsByClassName("tong_don_gia");
    if(tong_don_gia != null && tong_don_gia.length > 0){
        var total = 0;
        var mtml =
            "<table id='' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
            "<thead>" +
            "<th>"+Messages("product.name")+"</th>" +
            "<th>"+Messages("package.quantity")+"</th>" +
            "<th>"+Messages("unit.price")+"</th>" +
            "<th>"+Messages("total.amount.vnd")+"</th>" +
            "</thead>" +
            "<tbody>";
        for(var i=0; i<tong_don_gia.length; i++){
            console.log(parseInt(tong_don_gia[i].outerText.replaceAll(".","")));
            console.log(tong_don_gia[i].getAttribute("sttId"));

            var sttId = tong_don_gia[i].getAttribute("sttId");
            var don_gia = parseInt(tong_don_gia[i].outerText.replaceAll(".",""));

            var ten_goi = $("#goi_cuoc_"+sttId).val();
            var so_luong = $("#so_luong_"+sttId).val();

            mtml += "<tr>";
            mtml += "<td class='comfirm_name_pack' sttId='"+sttId+"'>" +ten_goi+ "</td>";
            mtml += "<td>" +so_luong+ "</td>";
            mtml += "<td>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(don_gia))+"</td>";
            mtml += "<td>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(don_gia*so_luong))+"</td>";
            // mtml += "<td>" +"<a onclick='exportDetailOrderBuySim("+ten_goi+")'>"+Messages("Xem chi tiết")+"</a>"+ "</td>";
            mtml += "</tr>";

            total += don_gia*so_luong;
        }

        if(total > 0){
            mtml += "<tr>";
            mtml += "<td style='font-weight: 600;'>" +Messages("total.money")+"<br><small>"+Messages("unit.vnd.vat")+"</small>"+"</td>";
            mtml += "<td></td>";
            mtml += "<td></td>";
            mtml += "<td style='font-weight: 600;' class=''>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(total))+"</td>";
            mtml += "</tr>";
        }

        mtml += "</tbody></table>";
        $("#tableTotalOrder").html(mtml);
    }

    $("#dia_chi_nhan_sim").html($("#dia_chi_chi_tiet").val());
}

function checkboxDksd(el) {
    console.log(el.checked);
    if(el.checked){
        $("#buttonCommfirmBuySim").attr('disabled', false);
    } else {
        $("#buttonCommfirmBuySim").attr('disabled', true);
    }
}

var listIsdnBuy = new Array;
function checkListBuySubs() {
    listIsdnBuy = [];
    var chooseSubsBuy = document.getElementsByClassName("chooseSubsBuy");
    if(chooseSubsBuy != null && chooseSubsBuy.length > 0){
        for(var i=0; i<chooseSubsBuy.length; i++) {
            console.log(chooseSubsBuy[i].getAttribute("value"));
            console.log(chooseSubsBuy[i].checked);
            if(chooseSubsBuy[i].checked){
                var isdn = chooseSubsBuy[i].getAttribute("value");
                listIsdnBuy.push(isdn);
            }
        }
    }
    console.log(listIsdnBuy);

    if(listIsdnBuy.length > 0){
        processOrderBuyWithIsdn(0);
    }
}

var listBuySuccess = new Array;
var listBuyFalse = new Array;
var listBuyDetail = new Array;

function processOrderBuyWithIsdn(index) {
    var body = new FormData;
    body.userId = userId;
    body.isdn = listIsdnBuy[index];
    body.customer = {
        "name": $("#ten_ng_dai_dien").val(),
        "idNo": $("#ma_so_doanh_nghiep").val(),
        "idType": "BUS"
    };
    body.address = {
        "province": $("#tinh_tp").val(),
        "provinceName": $("#tinh_tp option:selected").text(),
        "district": $("#quan_huyen").val().replace($("#tinh_tp").val(), ""),
        "precinct": $("#phuong_xa").val().replace($("#quan_huyen").val(), ""),
        "fullAddress": $("#dia_chi_chi_tiet").val(),
        "areaCode": $("#phuong_xa").val(),
        "districtCode": $("#quan_huyen").val()
    };

    if(document.getElementById("inlineRadio1").checked){
        body.transactionPlace = "HOME";
    } else {
        body.transactionPlace = "SHOP";
    }
    body.payInfo = {
        "immediatePay": false,
        "cardRecords": []
    };
    body.recipientName = $("#ten_ng_dai_dien").val();
    body.recipientPhone = $("#so_dien_thoai_lien_he").val();
    body.myViettelAccount = $("#so_dien_thoai_lien_he").val();
    body.createUser = 437725;
    body.payStatus = 0;

    // console.log(document.getElementById("checkbox-"+listIsdnBuy[index]).getAttribute("pack"));
    var orderCode = document.getElementById("checkbox-"+listIsdnBuy[index]).getAttribute("pack");
    console.log(orderCode);
    if(listTypePack[orderCode] == "PRE_PAID"){
        body.orderType = "CONNECT_PREPAID";
    } else {
        body.orderType = "CONNECT_POSTPAID";
    }

    var sttId = document.getElementById("checkbox-"+listIsdnBuy[index]).getAttribute("sttId");
    body.productInfo = {
        "bundleCode": orderCode,
        "bundleName": orderCode,
        "productCode": orderCode,
        "regReasonCode": listReasonCode["reason_"+sttId][$("#ly_do_dau_noi_"+sttId).val()],
        "regReasonId": parseFloat($("#ly_do_dau_noi_"+sttId).val()),
        "productInfoId": 0
    };
    body.totalFee = parseInt($("#tong_don_gia_"+sttId).text());
    body.feeRecords = [
        {
            "feeCode": "TRANSFER_FEE",
            "feeAmount": 0
        }
    ];
    console.log(body);

    StartProcess();
    if(index == 0){
        listBuyDetail = [];
        $("#notificationModal").modal('show');
        //TODO: tao cac dong ket qua goi cuoc
        var count_pack_data = document.getElementsByClassName("comfirm_name_pack");
        var mtml = "";
        for(var i=0; i<count_pack_data.length; i++){
            var sttIdPack = count_pack_data[i].getAttribute("sttId");
            var namePack = count_pack_data[i].innerText;

            mtml += "<tr>";
            mtml += "<td align='center'>" +namePack+ "</td>";
            mtml += "<td align='center'>" + $("#so_luong_"+sttIdPack).val() + "</td>";
            mtml += "<td align='center' id='count_success_"+sttIdPack+"'>0</td>";
            mtml += "<td align='center' id='count_false_"+sttIdPack+"'>0</td>";
            mtml += "<td>" +"<a onclick='exportDetailOrderBuySim(\""+sttIdPack+"\")' style='cursor: pointer; color: #00a5bb;'>"+Messages("view.details")+"</a>"+ "</td>";
            mtml += "</tr>";
        }
        $("#tableResultBuySim").find('tbody').html(mtml);
    }
    var r = jsRoutes.controllers.TelcoOrderController.processOrderBuySim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.content != null){
                if(data.content.return != null && data.content.return.success == "true"){
                    var countSuccess = parseInt($("#count_success_"+sttId).text());
                    $("#count_success_"+sttId).html(countSuccess+1);

                    listBuyDetail.push({
                        "sttId": sttId,
                        "isdn":listIsdnBuy[index],
                        "pack": orderCode,
                        "status": Messages("status.success"),
                        "reason": ""
                    })
                } else {
                    var countFalse = parseInt($("#count_false_"+sttId).text());
                    $("#count_false_"+sttId).html(countFalse+1);

                    listBuyDetail.push({
                        "sttId": sttId,
                        "isdn":listIsdnBuy[index],
                        "pack": orderCode,
                        "status": Messages("status.failed"),
                        "reason": (data.content.return.description != null ? data.content.return.description : "")
                    })
                }
            } else {
                var countFalse = parseInt($("#count_false_"+sttId).text());
                $("#count_false_"+sttId).html(countFalse+1);

                listBuyDetail.push({
                    "sttId": sttId,
                    "isdn":listIsdnBuy[index],
                    "pack": orderCode,
                    "status": Messages("status.failed"),
                    "reason": Messages("reason.unknown")
                })
            }
        },
        complete: function (){
            if(index < listIsdnBuy.length-1){
                processOrderBuyWithIsdn(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}

function exportDetailOrderBuySim(sttId) {
    console.log(listBuyDetail);

    if(listBuyDetail.length > 0){
        var mtml = "";
        var stt = 1;
        listBuyDetail.forEach(function (item) {
            if(item.sttId == sttId){
                mtml += "<tr>";
                mtml += "<td align='center'>" +stt+ "</td>";
                mtml += "<td align='center'>" +item.isdn+ "</td>";
                mtml += "<td align='center'>" +item.pack+ "</td>";
                mtml += "<td align='center'>" +item.status+ "</td>";
                mtml += "<td align='center'>" +item.reason+ "</td>";
                mtml += "</tr>";
                stt++;
            }
        });
        $("#tableFinishDetail").find('tbody').html(mtml);
    } else {
        showNotification('danger',Messages("notification.no.data"));
        return;
    }

    $("#finishDetailModal").modal('show');
    $("#notificationModal").modal('hide');
}

function closePopupFinishDetail() {
    $("#finishDetailModal").modal('hide');
    $("#notificationModal").modal('show');
}