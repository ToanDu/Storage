/**
 * Created by vtk-anhlt166 on 1/17/23.
 */
function checkComfirmConnect() {
    if(!validateInputId("goi_cuoc")){
        showNotification('danger',Messages("Bạn chưa chọn gói cước"));
        return;
    }
    if(!validateInputId("ly_do_dau_noi")){
        showNotification('danger',Messages("Bạn chưa chọn hình thức hoà mạng"));
        return;
    }

    var listRecord = document.getElementsByClassName("record-ct");
    console.log(listRecord);
    if(listRecord.length == 0){
        showNotification('danger',Messages("Bạn chưa tải chứng từ lên"));
        return;
    } else {
        var checkCountCt = 0;
        for(var i=0; i<listRecord.length; i++){
            console.log(listRecord[i].value);
            var index = listRecord[i].value;
            if($("#wizard-picture-"+index).prop("files")[0] == null || $("#wizard-picture-"+index).prop("files")[0] == undefined){
                checkCountCt++;
            }
        }
        if(checkCountCt > 0){
            showNotification('danger',Messages("Bạn chưa up đủ chứng từ đấu nối"));
            return;
        }
    }


    var goi_cuoc = $("#goi_cuoc").val();
    if(goi_cuoc != "" && goi_cuoc != undefined){
        var type = listPackType[goi_cuoc];
        if(type == "POST_PAID"){
            if(!validateInputId("tinh_tp_4") || !validateInputId("quan_huyen_4") || !validateInputId("phuong_xa_4") || !validateInputId("tinh_tp_4")){
                showNotification('danger',Messages("Bạn chưa điền địa chỉ Thông tin thanh toán"));
                return;
            }
            if(!validateInputId("dia_chi_hoa_don_cuoc")){
                showNotification('danger',Messages("Bạn chưa điền địa chỉ hoá đơn cước"));
                return;
            }
        }
    }

    var myTab = document.getElementById('smlTableChooseSubsChoose');
    var countSubscriber = 0;
    if(myTab != null && myTab != undefined){
        if(myTab.rows.length >= 1){
            var isdn ="";
            var serial ="";
            for (var i = 1; i < myTab.rows.length; i++) {
                console.log(myTab.rows[i]);
                var objCells = myTab.rows.item(i).cells;
                if(objCells.item(2).innerHTML != undefined && objCells.item(2).innerHTML != ""){
                    countSubscriber++;
                }
                if(i == myTab.rows.length-1){
                    console.log(objCells.item(1).innerHTML)
                    isdn += objCells.item(2).innerHTML;
                    serial += objCells.item(1).innerHTML;
                }
                else{
                    isdn += objCells.item(2).innerHTML+",";
                    serial += objCells.item(1).innerHTML+","
                }

            }

            if(countSubscriber == 0){
                console.log(1);
                showNotification('danger', Messages("Không có thuê bao nào được chọn"));
                return false;
            }

            var mtml =
                "<table id='' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
                "<thead>" +
                "<th>"+Messages("Mặt hàng")+"</th>" +
                "<th>"+Messages("Đơn giá")+"</th>" +
                "<th>"+Messages("Số lượng")+"</th>" +
                "<th>"+Messages("Thành tiền (VND)")+"</th>" +
                "</thead>" +
                "<tbody>";
            var total = 0;

            var body = new FormData;
            body.reasonId = $("#ly_do_dau_noi").val();
            body.productCode = $("#goi_cuoc").val();
            body.isdn = isdn;
            body.serial =serial;
            console.log(body);
            var r = jsRoutes.controllers.TelcoOrderController.getListSaleService();
            $.ajax({
                type: r.type,
                data: JSON.stringify(body),
                contentType: "application/json; charset=utf-8",
                url: r.url,
                success: function(datas){
                    console.log(datas);
                    var stt = 1;
                    if(datas.content != null && datas.content.data != null){
                        if(datas.content.data.listSaleServiceModel != null && datas.content.data.listSaleServiceModel.length > 0){
                            var listSaleServiceModel = datas.content.data.listSaleServiceModel;
                            console.log(listSaleServiceModel.length);
                            listSaleServiceModel.forEach(function (item) {
                                if(item.listSaleServiceDetail != null && item.listSaleServiceDetail.length > 0 ){
                                    // console.log(item.listSaleServiceDetail.length);
                                    item.listSaleServiceDetail.forEach(function (offer) {
                                        // console.log(offer);
                                        // var money = parseInt(offer.price);
                                        mtml += "<tr>";
                                        mtml += "<td>" +offer.offerName+ "</td>";
                                        mtml += "<td>" + (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(offer.price)) + "</td>";
                                        mtml += "<td>"+offer.amount+"</td>";
                                        mtml += "<td>"+ (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(offer.amount*offer.price)) +"</td>";
                                        mtml += "</tr>";

                                        i++;
                                        total += offer.amount*offer.price
                                    });

                                }
                            });
                            if(datas.content.data.listSaleServicePrice != null && datas.content.data.listSaleServicePrice.length > 0 ){
                                var saleServicePrice= datas.content.data.listSaleServicePrice;
                                saleServicePrice.forEach(function (item){
                                    mtml += "<tr>";
                                    mtml += "<td>" +item.name+ "</td>";
                                    mtml += "<td>" + (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(item.price)) + "</td>";
                                    mtml += "<td>"+item.amount+"</td>";
                                    mtml += "<td>"+ (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(item.amount*item.price)) +"</td>";
                                    mtml += "</tr>";
                                    total += item.amount*item.price
                                });

                            }

                            if(total > 0){
                                mtml += "<tr>";
                                mtml += "<td>" +"<span style='font-weight: 600;'>"+Messages("Tổng tiền")+"</span>" + "<br><small>"+Messages("*đơn vị: VNĐ, đã bao gồm VAT")+"</small>"+ "</td>";
                                mtml += "<td></td>";
                                mtml += "<td></td>";
                                mtml += "<td style='font-weight: 600;'>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(total))+"</td>";
                                mtml += "</tr>";
                            }

                            mtml += "</tbody></table>";
                            $("#comfirmTableTotalMoney").html(mtml);
                        } else {
                            $("#comfirmTableTotalMoney").html("");
                        }
                    } else {
                        $("#comfirmTableTotalMoney").html("");
                    }
                },
                complete: function (){
                    // FinishProcess();
                }
            });




            return true;
        } else {
            showNotification('danger', Messages("Không có thuê bao nào được chọn"));
            console.log(2);
            return false;
        }
    } else {
        showNotification('danger', Messages("Không có thuê bao nào được chọn"));
        console.log(3);
        return false;
    }
}

function appendDataPayConnectSim() {
    $("#confirmNamePack").html(Messages("Gói cước: ") + $("#goi_cuoc option:selected").text())
}

//up file chung tu
var countRecordCt = 0;
function uploadImgCt() {
    var listRecord = document.getElementsByClassName("record-ct");
    countRecordCt = listRecord.length;
    if(countRecordCt > 0){
        upfileFileRecordWithIndex(0);
    }
}

function upfileFileRecordWithIndex(index) {
    console.log(index);
    var groupData = new FormData();
    groupData.append("image_5", $("#wizard-picture-"+index).prop("files")[0]);
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.upfilePycTelco();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.content != null){
                if(data.content.link != null){
                    $("#url-img-"+index).val(data.content.link);
                } else {
                    console.log(data.errorString);
                }
            } else {
                console.log(data.errorString);
            }
        },
        complete: function (){
            // FinishProcess();
            if(index < countRecordCt-1){
                upfileFileRecordWithIndex(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}

function checkboxDksd(el) {
    console.log(el.checked);
    if(el.checked){
        $("#buttonConnectSim").attr('disabled', false);
    } else {
        $("#buttonConnectSim").attr('disabled', true);
    }
}

function connectSubscriberSimPay() {
    var goi_cuoc = $("#goi_cuoc").val();
    console.log(goi_cuoc);
    if(goi_cuoc != "" && goi_cuoc != undefined){
        connectSubscriberSimFinish();
    } else {
        showNotification('danger', Messages("Bạn chưa chọn gói cước"));
    }
}

function connectSubscriberSimFinish() {
    var body = new FormData;
    var customer = {
        "province": $("#tinh_tp").val(),
        "district": $("#quan_huyen").val().replace($("#tinh_tp").val(),""),
        "precinct": $("#phuong_xa").val().replace($("#quan_huyen").val(),""),
        "areaCode": $("#phuong_xa").val(),
        "address": $("#dia_chi_chi_tiet").val(),
        "name": $("#ten_dn").val(),
        "birthDate": moment(moment($("#ngay_thanh_lap").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
        "nationality": ($("#quoc_tich").val() != null ? $("#quoc_tich").val() : ""),
        "custType": $("#nhom_loai_kh").val(),
        "sex": $("#gioi_tinh_2").val(),
        "listCustIdentity": [
            {
                "idType": $("#loai_giay_to").val(),
                "idNo": $("#so_giay_to").val(),
                "idIssueDate": moment(moment($("#ngay_cap").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
                "idIssuePlace": $("#noi_cap").val()
            }
        ],
        "representativeCust": {
            "province": ($("#tinh_tp_2").val() != null ? $("#tinh_tp_2").val() : ""),
            "district": ($("#quan_huyen_2").val() != null ? $("#quan_huyen_2").val().replace($("#tinh_tp_2").val(),"") : ""),
            "precinct": ($("#phuong_xa_2").val() != null ? $("#phuong_xa_2").val().replace($("#quan_huyen_2").val(),"") : ""),
            "areaCode": $("#tinh_tp_2").val(),
            "address": ($("#dia_chi_chi_tiet_2").val() != null ? $("#dia_chi_chi_tiet_2").val() : ""),
            "name": $("#ten_khach_hang").val(),
            "nationality": ($("#quoc_tich_2").val() != null ? $("#quoc_tich_2").val() : ""),
            "birthDate": moment(moment($("#ngay_sinh").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
            "custType": $("#loai_kh_2").val(),
            "sex": $("#gioi_tinh_2").val(),
            "listCustIdentity": [
                {
                    "idType": $("#loai_giay_to_2").val(),
                    "idNo": $("#so_giay_to_2").val(),
                    "idIssueDate": moment(moment($("#ngay_cap_2").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
                    "idIssuePlace": $("#noi_cap_2").val(),
                    "idExpireDate": moment(moment($("#ngay_het_han_2").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD')
                }
            ]
        },
        "userInfoDTO": {
            "province": ($("#tinh_tp_3").val() != null ? $("#tinh_tp_3").val() : ""),
            "district": ($("#quan_huyen_3").val() != null ? $("#quan_huyen_3").val().replace($("#tinh_tp_3").val(),"") : ""),
            "precinct": ($("#phuong_xa_3").val() != null ? $("#phuong_xa_3").val().replace($("#quan_huyen_3").val(),"") : ""),
            "areaCode": $("#tinh_tp_3").val(),
            "address": ($("#dia_chi_chi_tiet_3").val() != null ? $("#dia_chi_chi_tiet_3").val() : ""),
            "name": $("#ten_khach_hang_3").val(),
            "nationality": ($("#quoc_tich_3").val() != null ? $("#quoc_tich_3").val() : ""),
            "birthDate": moment(moment($("#ngay_sinh_3").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
            "custType": $("#loai_kh_3").val(),
            "sex": $("#gioi_tinh_3").val(),
            "listCustIdentity": [
                {
                    "idType": $("#loai_giay_to_3").val(),
                    "idNo": $("#so_giay_to_3").val(),
                    "idIssueDate": moment(moment($("#ngay_cap_3").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
                    "idIssuePlace": $("#noi_cap_3").val(),
                    "idExpireDate": moment(moment($("#ngay_het_han_3").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD')
                }
            ]
        }
    };
    body.customer = customer;

    var myTab = document.getElementById('smlTableChooseSubsChoose');
    var subscriberDTO = new Array;
    for (var i = 1; i < myTab.rows.length; i++) {
        // console.log(myTab.rows[i]);
        var objCells = myTab.rows.item(i).cells;
        // console.log(objCells);
        if(objCells.item(2).innerHTML != undefined || objCells.item(2).innerHTML != ""){
            var offerCode = $("#goi_cuoc").val();
            var subscriber =  {
                "isdn": objCells.item(2).innerHTML,
                "serial": objCells.item(1).innerHTML,
                "productCode": offer.get(offerCode),
                "telecomServiceId": "1",
                "regType": listHinhThucHoaMang[$("#ly_do_dau_noi").val()],
                "subType": "VIE"
            };
            subscriberDTO.push(subscriber);
        }
    }
    body.subscribers = subscriberDTO;
    body.reasonId = $("#ly_do_dau_noi").val();
    body.action = "13";
    body.user_id = userId;

    var listRecord = document.getElementsByClassName("record-ct");
    var lstFile = [];
    for(var j=0; j<listRecord.length; j++){
        var index = listRecord[j].value;
        lstFile.push({
            "fileCode": $("#code-img-"+index).val(),
            "fileName": $("#url-img-"+index).val()
        });
    }
    body.profileDocument = {
        "lstFile" : lstFile
    };

    var goi_cuoc = $("#goi_cuoc").val();
    if(goi_cuoc != "" && goi_cuoc != undefined){
        var type = listPackType[goi_cuoc];
        if(type == "POST_PAID"){
            var accountDTO = {
                    "printMethod": $("#in_chi_tiet_cuoc").val(),
                    "printMethodName": $("#in_chi_tiet_cuoc option:selected").text(),
                    "payMethod": $("#hinh_thuc_thanh_toan").val(),
                    "payMethodName": $("#hinh_thuc_thanh_toan option:selected").text(),
                    "noticeCharge": $("#hinh_thuc_tbc").val(),
                    "noticeChargeName": $("#hinh_thuc_tbc option:selected").text(),
                    "province": $("#tinh_tp_4").val(),
                    "district": $("#quan_huyen_4").val(),
                    "precinct": $("#phuong_xa_4").val(),
                    "areaCode": $("#tinh_tp_4").val()+$("#quan_huyen_4").val()+$("#phuong_xa_4").val(),
                    "billCycleId": "1",
                    "billAddress": $("#dia_chi_hoa_don_cuoc").val(),
                    "address": $("#dia_chi_chi_tiet_4").val()
                };
            body.account = accountDTO;
            body.action = "12";
        }
    }
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.connectSubscriberSim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log('%c connectSubscriberSimPayBefore', 'background: #222; color: #bada55');
            console.log(datas);
            if (datas.content != null && datas.content.code == 200) {
                window.open(datas.content.data.link_check_out, "_blank");
                $("#notificationModal").modal('show');
                // $("#iframePaymentConnectSim").html('<iframe src="https://viettel.vn/partner-checkout" height="300px" width="100%"></iframe>')
            }
        },
        error: function (xhr) {
            console.log(xhr);
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function connectSubscriberSimPayAfter() {

}