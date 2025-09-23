/**
 * Created by vtk-anhlt166 on 1/9/23.
 */
$(document).ready(function () {
    getListPackMiAndAddOn();

    // getListResonFull();

    getListPayMethod();
    getListNoticeCharge();
    getListPrintMethod();
});
var listHinhThucHoaMang = new Array;
function getListResonFull(payType, goi_cuoc){
    var body = new FormData;
    body.payType = payType;
    body.offerCode = goi_cuoc;
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
            listHinhThucHoaMang = [];
            var selectReason = '<option value="">'+Messages("---Chọn hình thức---")+'</option>';
            if(data.success){
                if(data.content != null && data.content.length > 0){
                    data.content.forEach(function (item, key) {
                        selectReason += '<option value="'+item.reasonId+'">'+item.name+'</option>';
                        listHinhThucHoaMang[item.reasonId] = item.reasonCode;
                    })
                }
            }
            $("#ly_do_dau_noi").html(selectReason);
        },
        complete: function (){
            FinishProcess();
        }
    })
}
var offer = new Map();
var listPack = new Array;
var listPackSms = new Array;
var listPackType = new Array;
function getListPackMiAndAddOn() {
    var r = jsRoutes.controllers.TelcoOrderController.getListProductOffer();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getListPackMiAndAddOn', 'background: #222; color: #bada55');
            console.log(datas);
            var ProductOffering = '<option value="">'+Messages("-- Chọn gói cước --")+'</option>';
            if(datas.success){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var array = datas.content.data.sort((a, b) => a.offerCode.localeCompare(b.offerCode));

                    array.forEach(function (item) {
                        ProductOffering += '<option value="'+item.offerCode+'">'+item.offerCode+'</option>';
                        listPack[item.offerCode] = item.discountPromotionData;
                        listPackSms[item.offerCode] = item.discountPromotionSMS;
                        listPackType[item.offerCode] = item.payType;
                        offer.set(item.offerCode, item.productCode);
                    });
                }
            }
            $("#goi_cuoc").html(ProductOffering);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function getConnectSubscriberRamdom(){
    $("#tableChooseSubscriber").html("");
    document.getElementById("searchChooseSubscriber").style.display = 'none';

    var body = new FormData;
    body.count = listSerialTrue.length;
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.getConnectSubscriberRamdom();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log('%c getConnectSubscriberRamdom', 'background: #222; color: #bada55');
            console.log(data);
            if(data.content != null){
                if(data.content.lstIsdn != null && data.content.lstIsdn.length > 0){
                    var listIsdnArr = new Array;
                    var mtml = "";
                    mtml +=
                        "<table id='smlTableChooseSubsChoose' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
                        "<thead>" +
                        "<th>"+Messages("STT")+"</th>" +
                        "<th>"+Messages("Serial")+"</th>" +
                        "<th>"+Messages("Số thuê bao")+"</th>" +
                        "<th style='display: none;'></th>" +
                        "</thead>" +
                        "<tbody>";
                    for(var i=0; i<listSerialTrue.length; i++){
                        mtml += "<tr>";
                        mtml += "<td>" +(i+1)+ "</td>";
                        mtml += "<td>" + listSerialTrue[i] + "</td>";
                        mtml += "<td class='tb-choose' id='tb-choose-"+listSerialTrue[i]+"'>" + (data.content.lstIsdn[i] != null ? data.content.lstIsdn[i].isdn : "") + "</td>";
                        mtml += "<td style='display: none;'>"+"<i class='bx bx-x' title='Xoá thuê bao' onclick='removeChooseTb(\""+listSerialTrue[i]+"\")' style='color: red; cursor: pointer;'></i>"+"</td>";
                        mtml += "</tr>";

                        var isdns = {
                            "isdn": data.content.lstIsdn[i].isdn,
                            "serial": listSerialTrue[i],
                            "adm1": listAdm1True[listSerialTrue[i]]
                        };
                        listIsdnArr.push(isdns);
                    }

                    mtml += "</tbody></table>";
                    $("#tableChooseSubscriber").html(mtml);

                    var table = $("#smlTableChooseSubsChoose").DataTable({
                        // responsive: true,
                        order: false,
                        lengthMenu: false,
                        searching: false,
                        "bLengthChange" : false,
                        "bInfo":false
                    });
                    table.on('order.dt search.dt', function () {
                        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                            cell.innerHTML = i+1;
                        } );
                    } ).draw();

                    if(listIsdnArr.length > 0){
                        blockIsdnVht(listIsdnArr);
                    }
                } else {
                    showNotification('danger',data.content.description);
                }
            } else {
                showNotification('danger',Messages("Lấy dữ liệu không thành công"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function getConnectSubscriberChoose() {
    $("#tableChooseSubscriber").html("");
    document.getElementById("searchChooseSubscriber").style.display = 'block';

    var mtml = "";
    mtml +=
        "<table id='smlTableChooseSubsChoose' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
        "<thead>" +
        "<th>"+Messages("STT")+"</th>" +
        "<th>"+Messages("Serial")+"</th>" +
        "<th>"+Messages("Số TB")+"</th>" +
        "<th></th>" +
        "</thead>" +
        "<tbody>";
    for(var i=0; i<listSerialTrue.length; i++){
        mtml += "<tr>";
        mtml += "<td>" +(i+1)+ "</td>";
        mtml += "<td style='overflow-wrap: anywhere;'>" + listSerialTrue[i] + "</td>";
        mtml += "<td class='tb-choose' id='tb-choose-"+listSerialTrue[i]+"'></td>";
        mtml += "<td>"+"<i class='bx bx-x' title='Xoá thuê bao' onclick='removeChooseTb(\""+listSerialTrue[i]+"\")' style='color: red; cursor: pointer;'></i>"+"</td>";
        mtml += "</tr>";
    }

    mtml += "</tbody></table>";
    $("#tableChooseSubscriber").html(mtml);

    var table = $("#smlTableChooseSubsChoose").DataTable({
        // responsive: true,
        order: false,
        lengthMenu: false,
        searching: false,
        "bLengthChange" : false,
        "bInfo":false
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function removeChooseTb(serial) {
    //mo khoa so
    if($("#tb-choose-"+serial).text().length > 0){
        $("#tb-choose-"+serial).html("");
        // var body = new FormData;
        // body.isdns = [$("#tb-choose-"+serial).text()];
        // console.log(body);
        // var r = jsRoutes.controllers.TelcoOrderController.unlockIsdnVht();
        // $.ajax({
        //     type: r.type,
        //     data: JSON.stringify(body),
        //     contentType: "application/json; charset=utf-8",
        //     url: r.url,
        //     success: function (datas) {
        //         console.log('%c blockIsdnVht', 'background: #222; color: #bada55');
        //         console.log(datas);
        //         if (datas.success) {
        //             $("#tb-choose-"+serial).html("");
        //             // document.getElementById("tb-choose-"+serial).style.color = "#dee2e6";
        //             showNotification('success',Messages("Huỷ khoá số thành công"));
        //         } else {
        //             showNotification('danger',Messages("Huỷ khoá số không thành công"));
        //         }
        //     },
        //     error: function (xhr) {
        //         console.log(xhr);
        //     },
        //     complete: function (){
        //         // FinishProcess();
        //     }
        // })
    }
}

function choosePackPayAfterOrBefore() {
    var goi_cuoc = $("#goi_cuoc").val();
    console.log(goi_cuoc);
    if(goi_cuoc != "" && goi_cuoc != undefined){
        var type = listPackType[goi_cuoc];
        var paid = Messages("Trả trước");
        if(type == "POST_PAID"){
            document.getElementById("tab_chooseTB_after").style.display = "block";
            paid = Messages("Trả sau");

            getListResonFull(1, goi_cuoc);
        } else {
            document.getElementById("tab_chooseTB_after").style.display = "none";

            getListResonFull(2, goi_cuoc);
        }
        $("#discountPromotionData").html(paid + " - " + listPack[goi_cuoc] + " - " + listPackSms[goi_cuoc]);

        //upload chung tu
        var body = new FormData();
        body.idNo = $("#so_giay_to").val().trim();
        console.log(body);
        var r = jsRoutes.controllers.TelcoOrderController.getCustomerType();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function(datas){
                console.log('%c getCustomerType', 'background: #222; color: #bada55');
                console.log(datas);
                if(datas.content != null){
                    if(datas.content.data != null && datas.content.data.type != null){
                        document.getElementById("tab_chooseCt").style.display = 'block';
                        $("#customerTypeCt").val(datas.content.data.type);

                        var body = new FormData();
                        body.payType = type;
                        body.actionCode = "00";
                        if(datas.content.data.type != null && datas.content.data.type.length > 0){
                            body.custType = datas.content.data.type;
                        } else {
                            body.custType = $("#nhom_loai_kh").val();
                        }
                        body.serviceType = "M";
                        console.log(body);
                        var r = jsRoutes.controllers.TelcoOrderController.getListCt();
                        $.ajax({
                            type: r.type,
                            data: JSON.stringify(body),
                            contentType: "application/json; charset=utf-8",
                            url: r.url,
                            success: function(data){
                                console.log('%c getListCt', 'background: #222; color: #bada55');
                                console.log(data);
                                if(data.content != null){
                                    if(data.content.listRecord != null && data.content.listRecord.length > 0){
                                        var record = "";
                                        for(var i=0; i<data.content.listRecord.length; i++){
                                            record +=
                                                '<div class="col-md-4 m-t-3">'+
                                                '<label class="col-sm-12 col-form-label title-section-2">'+data.content.listRecord[i].recordName+'</label>'+
                                                '<input id="code-img-'+i+'" type="text" value="'+data.content.listRecord[i].recordCode+'" readonly hidden/>'+
                                                '<input id="url-img-'+i+'" type="text" hidden/>'+
                                                '<input id="index-img-'+i+'" class="record-ct" type="text" value="'+i+'" readonly hidden/>'+
                                                '</div>'+
                                                '<div class="col-md-8 m-t-3">'+
                                                '<div class="row m-b-4">'+
                                                '<div class="col-sm-12 position-relative">'+
                                                '<div class="row">'+
                                                '<div class="col-md-7 position-relative">'+
                                                '<input id="imgOld'+i+'" type="text" class="form-control" hidden>'+
                                                '<div class="d-flex flex-column align-items-center text-center square-item" >'+
                                                '<img src="'+imgDefault+'" id="wizardPicturePreview'+i+'" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">'+
                                                '<input id="wizard-picture-'+i+'" name="avatar" type="file" hidden/>'+
                                                '<div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg'+i+'" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber('+i+')"></i></div>'+
                                                '</div>'+
                                                '</div>'+
                                                '<div class="col-md-5 position-relative">'+
                                                '<label class="form-label ">'+Messages("Upload image")+'</label><br>'+
                                                '<label class="form-label ">'+Messages("Kéo thả file ảnh hoặc mở file ")+'<a onclick="clickButtonUpfile('+i+')" class="cursor-pointer text-danger">'+Messages("tại đây")+'</a></label>'+
                                                '</div>'+
                                                '<div class="col-md-12 position-relative">'+
                                                '<small class="form-label ">'+Messages("File jpg, png, jpeg dung lượng file không quá 3mb")+'</small>'+
                                                '</div>'+
                                                '</div>'+
                                                '</div>'+
                                                '</div>'+
                                                '</div>';
                                        }
                                        $("#listCt").html(record);
                                    }
                                }
                            },
                            complete: function (){
                                FinishProcess();
                            }
                        })
                    }
                }
            },
            complete: function (){
                // FinishProcess();
            }
        })
    } else {
        document.getElementById("tab_chooseTB_after").style.display = "none";
        $("#discountPromotionData").html("");

        $("#ly_do_dau_noi").html('<option value="">'+Messages("---Chọn hình thức---")+'</option>');

        document.getElementById("tab_chooseCt").style.display = "none";
    }
}

function clickButtonUpfile(index) {
    $('#wizard-picture-'+index).click();
    $("#wizard-picture-"+index).change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
                showNotification('danger', Messages("File không đúng định dạng"));
                $('#wizardPicturePreview'+index).attr('src', imgDefault);
                $("#wizard-picture-"+index).val("");
                return;
            } else {
                if(this.files[0].size > 3000000){
                    showNotification('danger', Messages("File dung lượng không được quá 3mb"));
                    $('#wizardPicturePreview'+index).attr('src', imgDefault);
                    $("#wizard-picture-"+index).val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = function (e) {
                $('#wizardPicturePreview'+index).attr('src', e.target.result);
                document.getElementById("buttonResetImg"+index).style.display = 'block';
            };
            reader.readAsDataURL(this.files[0]);
        }
    });
}

function chooseReasonConnect() {

}

//onchange area
function selectDistrict_4() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinh_tp_4").val();
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen_4").html(district);
                $("#phuong_xa_4").html("");
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function selectWard_4() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quan_huyen_4").val();
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuong_xa_4").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function getListPayMethod(){ //lấy danh sách hình thức thanh toán
    var r = jsRoutes.controllers.TelcoOrderController.getDataTelcoByUrl("/api/telco/cm/getListPayMethod");
    $.ajax({
        type: r.type,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(datas){
            console.log('%c getListPayMethod', 'background: #222; color: #bada55');
            console.log(datas);
            var select = '';
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    datas.content.data.forEach(function (item, key) {
                        select += '<option value="'+item.value+'">'+item.name+'</option>';
                    })
                }
            }
            $("#hinh_thuc_thanh_toan").html(select);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function getListNoticeCharge(){ //lấy danh sách hình thức thông báo cước
    var r = jsRoutes.controllers.TelcoOrderController.getDataTelcoByUrl("/api/telco/cm/getListNoticeCharge");
    $.ajax({
        type: r.type,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(datas){
            console.log('%c getListNoticeCharge', 'background: #222; color: #bada55');
            console.log(datas);
            var select = '';
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    datas.content.data.forEach(function (item, key) {
                        select += '<option value="'+item.value+'">'+item.name+'</option>';
                    })
                }
            }
            $("#hinh_thuc_tbc").html(select);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function getListPrintMethod(){ //lấy danh sách hình thức in chi tiết cước
    var r = jsRoutes.controllers.TelcoOrderController.getDataTelcoByUrl("/api/telco/cm/getListPrintMethod");
    $.ajax({
        type: r.type,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(datas){
            console.log('%c getListPrintMethod', 'background: #222; color: #bada55');
            console.log(datas);
            var select = '';
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    datas.content.data.forEach(function (item, key) {
                        select += '<option value="'+item.value+'">'+item.name+'</option>';
                    })
                }
            }
            $("#in_chi_tiet_cuoc").html(select);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}