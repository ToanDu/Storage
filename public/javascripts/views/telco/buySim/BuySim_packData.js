/**
 * Created by vtk-anhlt166 on 1/31/23.
 */
$(document).ready(function () {
    getListPackData();
    // getListReasonFull();
    // getListSaleService(1);
});
var listPack = new Array;
var listSelectPack;
var listTypePack = new Array;
function getListPackData() {
    var r = jsRoutes.controllers.TelcoOrderController.getListProductOffer();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getListPackData', 'background: #222; color: #bada55');
            console.log(datas);
            listSelectPack = '<option value="">'+Messages("package.select.placeholder")+'</option>';
            if(datas.success){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var array = datas.content.data.sort((a, b) => a.offerCode.localeCompare(b.offerCode));

                    array.forEach(function (item) {
                        listSelectPack += '<option value="'+item.offerCode+'">'+item.offerCode+'</option>';
                        listPack[item.offerCode] = item.discountPromotionData;
                        listTypePack[item.offerCode] = item.payType;
                    });
                }
            }
            $("#goi_cuoc_1").html(listSelectPack);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

var listReason = new Array;
var listReasonCode = new Array;
var listSelectReason;
function getReasonWithPack(index){
    console.log(index);
    var body = new FormData;
    var pack = $("#goi_cuoc_"+index).val();
    if(pack.length == 0){
        $("#ly_do_dau_noi_"+index).html('<option value="">'+Messages("reason.select.placeholder")+'</option>');
        return;
    }

    if(listTypePack[pack] == "POST_PAID"){
        body.payType = 1;
    } else {
        body.payType = 2;
    }
    body.offerCode = $("#goi_cuoc_"+index).val();
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.getListReasonFull();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log('%c getListResonFull', 'background: #222; color: #bada55');
            console.log(data);

            listReason = [];
            listSelectReason = '<option value="">'+Messages("reason.select.placeholder")+'</option>';
            if(data.content != null && data.content.length > 0){
                var reasonArr = new Array();
                data.content.forEach(function (item) {
                    listSelectReason += '<option value="'+item.reasonId+'">'+item.name+'</option>';
                    listReason[item.reasonId] = item.name;
                    reasonArr[item.reasonId] = item.reasonCode;
                });
                var nameRs = "reason_"+index;
                listReasonCode[nameRs] = reasonArr;
            }
            $("#ly_do_dau_noi_"+index).html(listSelectReason);
            console.log(listReasonCode);
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var sttContentPackData = 1;
var listSaleService;
function getListSaleService(i) {//ds mat hang
    var count = $("#so_luong_"+i).val();
    if(count > 0){
        var mtml =
            "<table id='' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
            "<thead>" +
            "<th>"+Messages("package.item")+"</th>" +
            "<th>"+Messages("package.unit.price")+"</th>" +
            "<th>"+Messages("package.quantity")+"</th>" +
            "<th>"+Messages("package.total.amount")+"</th>" +
            "</thead>" +
            "<tbody>";
        var total = 0;

        var body = new FormData;
        body.reasonId = $("#ly_do_dau_noi_"+i).val();
        console.log(body);
        var r = jsRoutes.controllers.TelcoOrderController.getListSaleService();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function(datas){
                console.log(datas);
                if(datas.content != null && datas.content.data != null){
                    if(datas.content.data.listSaleServiceModel != null && datas.content.data.listSaleServiceModel.length > 0){
                        var listSaleServiceModel = datas.content.data.listSaleServiceModel;
                        // console.log(listSaleServiceModel.length);
                        var tong_don_gia = 0;
                        listSaleService = listSaleServiceModel;
                        listSaleServiceModel.forEach(function (item) {
                            if(item.listSaleServiceDetail != null && item.listSaleServiceDetail.length > 0){
                                // console.log(item.listSaleServiceDetail.length);
                                item.listSaleServiceDetail.forEach(function (offer) {
                                    // console.log(offer);
                                    // var money = parseInt(offer.price);
                                    mtml += "<tr>";
                                    mtml += "<td>" +offer.offerName+ "</td>";
                                    mtml += "<td>" + (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(offer.price)) + "</td>";
                                    mtml += "<td>"+count+"</td>";
                                    mtml += "<td>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(count*offer.price))+"</td>";
                                    mtml += "</tr>";

                                    total += count*offer.price;
                                    tong_don_gia += offer.price;
                                });
                            }
                        });

                        mtml += "<tr>";
                        mtml += "<td style='font-weight: 600;'>" +Messages("package.total.money")+ "</td>";
                        mtml += "<td class='tong_don_gia' id='tong_don_gia_"+i+"' sttId='"+i+"' hidden>"+tong_don_gia+"</td>";
                        mtml += "<td></td>";
                        mtml += "<td></td>";
                        mtml += "<td style='font-weight: 600;' class='total_money_packdata'>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(total))+"</td>";
                        mtml += "</tr>";

                        mtml += "</tbody></table>";
                        $("#ds_mat_hang_"+i).html(mtml);
                    } else {
                        $("#ds_mat_hang_"+i).html(mtml);
                    }
                } else {
                    $("#ds_mat_hang_"+i).html(mtml);
                }
            },
            complete: function (){
                // FinishProcess();
                // sttContentPackData++;

                sumTotalAllPackdata();
            }
        });
    }
}

function changeCountPackData(stt) {
    // console.log(stt);
    getListSaleService(stt);
}

function addContentPackData() {
    sttContentPackData++;
    console.log(sttContentPackData);
    var contentPack =
        '<div id="choose_pack_'+sttContentPackData+'">'+
        '<div class="row mt-3">'+
        '<div class="col-md-6">'+
        '<div class="row">'+
        '<label class="col-sm-4 col-form-label title-section-2" style="text-align: left">'+Messages("package.label")+'</label>'+
        '<div class="col-sm-8">'+
        '<select class="form-control" style="width: 100%;" id="goi_cuoc_'+sttContentPackData+'" name="productCode_'+sttContentPackData+'" onchange="getReasonWithPack('+sttContentPackData+'); updateDisabledPackOptions();">'+
        listSelectPack+
        '</select>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="col-md-3">'+
        '<div class="row m-b-3">'+
        '<label class="col-sm-6 col-form-label title-section-2">'+Messages("quantity.label")+'</label>'+
        '<div class="col-sm-6">'+
        '<input id="so_luong_'+sttContentPackData+'" stt="'+sttContentPackData+'" type="number" name="numIsdn_'+sttContentPackData+'" class="form-control input-form count_pack_data" min="1" max="1000000" value="1" onchange="changeCountPackData('+sttContentPackData+')" onKeyPress="if(this.value.length==8) return false;">'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="col-md-3">'+
        '<div class="row m-b-3" style="float: right;">'+
        
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="row mt-3">'+
        '<label class="col-sm-2 col-form-label title-section-2" style="text-align: left">'+Messages("connection.reason.label")+'</label>'+
        '<div class="col-sm-7">'+
        '<select class="form-control choose_reason" style="width: 100%;" id="ly_do_dau_noi_'+sttContentPackData+'" name="regReasonCode_'+sttContentPackData+'" onchange="getListSaleService('+sttContentPackData+')">'+
        '<option value="">'+Messages("reason.choose.package")+'</option>'+
        '</select>'+
        '</div>'+
        '<div class="col-sm-2 d-flex">'+
        '<button type="button" class="btn btn-search" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;" onclick="removePackData('+sttContentPackData+')">'+Messages("button.delete")+'</button>'+
        '<button type="button" class="btn btn-search" style="background: #EA0033; color: #FFFFFF;" onclick="addContentPackData()">'+Messages("button.add")+'</button>'+
        '</div>'+
        '</div>'+
        '<div class="row mt-4">'+
        '<div class="col-md-12" id="ds_mat_hang_'+sttContentPackData+'"></div>'+
        '</div>'+
        '<hr>'+
        '</div>';
    $("#content_pack").append(contentPack);
    // getListSaleService(sttContentPackData);
    updateDisabledPackOptions();
}

function removePackData(stt) {
    $("#choose_pack_"+stt).remove();
    sumTotalAllPackdata();
}

function sumTotalAllPackdata() {
    // console.log(document.getElementsByClassName("total_money_packdata"));
    var total_money_packdata = document.getElementsByClassName("total_money_packdata");
    if(total_money_packdata != null && total_money_packdata.length > 0){
        var total = 0;
        for(var i=0; i<total_money_packdata.length; i++){
            console.log(parseInt(total_money_packdata[i].outerText.replaceAll(".","")));
            total += parseInt(total_money_packdata[i].outerText.replaceAll(".",""));
        }
        $("#totalMoneyAllPack").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(total));
    }
}

function updateDisabledPackOptions() {
    // Lấy tất cả các select gói cước
    const selects = $('[id^="goi_cuoc_"]');
    // Lấy các giá trị đã chọn (trừ option rỗng)
    const selectedValues = [];
    selects.each(function() {
        const val = $(this).val();
        if (val) selectedValues.push(val);
    });

    // Disable các option đã chọn ở các select khác
    selects.each(function() {
        const currentSelect = $(this);
        const currentValue = currentSelect.val();
        currentSelect.find('option').each(function() {
            const optionValue = $(this).attr('value');
            if (
                optionValue &&
                optionValue !== "" &&
                optionValue !== currentValue &&
                selectedValues.includes(optionValue)
            ) {
                $(this).prop('disabled', true);
            } else {
                $(this).prop('disabled', false);
            }
        });
    });
}