var hostGetImg = "https://cmpapi.innoway.vn:30983/file/";
var STATUS_CONNECT = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    PROCESSING: {value: "PROCESSING", name: "Đang tạo QR"},
    CREATED_SUCCESS: {value: "CREATED_SUCCESS", name: "Đã tạo QR"},
    CREATED_FAILED: {value: "CREATED_FAILED", name: "Đã tạo QR thất bại"},
    CREATED_PAYMENT: {value: "CREATED_PAYMENT", name: "Đã tạo thanh toán"},
    PAID_SUCCESS: {value: "PAID_SUCCESS", name: "Đã thanh toán thành công (Chưa đấu nối)"},
    PROVISIONED_FAILED: {value: "PROVISIONED_FAILED", name: "Đấu nối thất bại "},
    PROVISIONED_SUCCESS: {value: "PROVISIONED_SUCCESS", name: "Đấu nối thành công"}
};
function getStatusConnectByCode(code) {
    if (code == STATUS_CONNECT.PROCESSING.value) {
        return STATUS_CONNECT.PROCESSING.name;
    } else if (code == STATUS_CONNECT.CREATED_SUCCESS.value) {
        return STATUS_CONNECT.CREATED_SUCCESS.name;
    } else if (code == STATUS_CONNECT.CREATED_FAILED.value) {
        return STATUS_CONNECT.CREATED_FAILED.name;
    } else if (code == STATUS_CONNECT.CREATED_PAYMENT.value) {
        return STATUS_CONNECT.CREATED_PAYMENT.name;
    } else if (code == STATUS_CONNECT.PAID_SUCCESS.value) {
        return STATUS_CONNECT.PAID_SUCCESS.name;
    } else if (code == STATUS_CONNECT.PROVISIONED_FAILED.value) {
        return STATUS_CONNECT.PROVISIONED_FAILED.name;
    } else if (code == STATUS_CONNECT.PROVISIONED_SUCCESS.value) {
        return STATUS_CONNECT.PROVISIONED_SUCCESS.name;
    } else {
        return STATUS_CONNECT.UNKNOWN.name;
    }
}

$(document).ready(function () {
    getListQrcode();
    getListGpkd();
    getListPackDataQr();
});
function onlickButtonSearch() {
    $("#page").val(1);

    getListQrcode();
}
function getListQrcode() {
    var body = new FormData();
    body.serial = $("#serialSim").val();
    body.status = $("#statusConnectSub").val();
    if($("#fromDateCreateQr").val().length > 0){
        var dateString = $("#fromDateCreateQr").val();
        var dateMomentObject = moment(dateString, "DD/MM/YYYY"); // 1st argument - string, 2nd argument - format
        var dateObject = dateMomentObject.toDate();
        body.createdFrom = dateObject.getTime()/1000;
    } else {
        body.createdFrom = "";
    }
    if($("#toDateCreateQr").val().length > 0){
        var dateString = $("#toDateCreateQr").val();
        var dateMomentObject = moment(dateString, "DD/MM/YYYY"); // 1st argument - string, 2nd argument - format
        var dateObject = dateMomentObject.toDate();
        body.createdTo = dateObject.getTime()/1000;
    } else {
        body.createdTo = "";
    }

    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoQrcodeController.getListQrcodeCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas, "getListQrcode");
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewDeviceToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                $("#listQrcodeTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listQrcodeTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewDeviceToTable(data, startAt, page, pageSize) {
    var body = "";
    var listData = data.data;
    if (listData!=null && listData.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listData.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listData[i].staffCode + "</td>";
            body += "<td class='wrap-text'>" + "" + "</td>";
            body += "<td class='wrap-text'>" + listData[i].idNo + "</td>";
            body += "<td class='wrap-text'>" + listData[i].serial + "</td>";
            body += "<td class='wrap-text'>" + moment.unix(listData[i].createdTime).format("HH:mm DD/MM/YYYY") + "</td>";
            body += "<td class='wrap-text'>" + listData[i].productCode + "</td>";
            var urlImg = hostGetImg + listData[i].qrImage;
            body += "<td class='wrap-text'>" + "<img src='"+urlImg+"' height='50px' onclick='zoomImg(this)'>" + "</td>";
            body += "<td class='wrap-text'>" + listData[i].verificationCode + "</td>";
            body += "<td class='wrap-text'>" + getStatusConnectByCode(listData[i].status) + "</td>";
            body += "<td class='wrap-text'>" + (listData[i].provisioningTime > 0 ? moment.unix(listData[i].provisioningTime/1000).format("HH:mm DD/MM/YYYY") : "") + "</td>";
            body += "<td align='center' style='padding: 0px;'>";
            body += "<a class='btn' title='Tải QR' onclick='downloadQrcode(\""+urlImg+"\", \""+listData[i].serial+"\", \""+listData[i].verificationCode+"\")' style='padding: 2px;'><i class='bx bx-download'></i></a>";
            body += "<a class='btn' title='Xoá QR' onclick='setDelQrcode(\""+listData[i].id+"\")' style='padding: 2px;'><i class='bx bx-trash'></i></a>";
            body += "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listQrcodeTable").find('tbody').html(body);

    pagingTable(data.total, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListQrcode()
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListQrcode()
}

function zoomImg(el) {
    console.log(el.src);
    $("#imgZoom").attr('src', el.src);
    $("#imgZoomModal").modal('show');
}

function getListGpkd() {
    var body = new FormData();
    // StartProcess();
    var r = jsRoutes.controllers.TelcoQrcodeController.getListGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var option = '<option value="" selected>'+Messages("--- Chọn GPKD ---")+'</option>';
                    for(var i=0; i<datas.content.data.length; i++){
                        var item = datas.content.data[i];
                        if(item.approve_status == "APPROVED"){
                            option += '<option value="'+item.business_license+'">'+item.business_license+'</option>';
                        }
                    }
                    $("#gpkdList").html(option);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//TODO: lay danh sach goi cuoc
var listPack = new Array;
var listSelectPack;
var listTypePack = new Array;
function getListPackDataQr() {
    var r = jsRoutes.controllers.TelcoOrderController.getListProductOffer();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            // console.log('%c getListPackData', 'background: #222; color: #bada55');
            console.log(datas, "getListPackData");
            listSelectPack = '<option value="">'+Messages("-- Chọn gói cước --")+'</option>';
            if(datas.success && datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var array = datas.content.data.sort((a, b) => a.offerCode.localeCompare(b.offerCode));

                    array.forEach(function (item) {
                        listSelectPack += '<option value="'+item.offerCode+'">'+item.offerCode+'</option>';
                        listPack[item.offerCode] = item.discountPromotionData;
                        listTypePack[item.offerCode] = item.payType;
                    });
                }
            }
            $("#packDataList").html(listSelectPack);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//TODO: lay danh sach ly do
var listReason = new Array;
var listReasonCode = new Array;
var listSelectReason;
function getReasonWithPackQr(){
    var body = new FormData;
    var pack = $("#packDataList").val();
    if(pack.length == 0){
        $("#reasonList").html('<option value="">'+Messages("--- Chọn lý do ---")+'</option>');
        return;
    }

    console.log(listTypePack);
    if(listTypePack[pack] == "POST_PAID"){
        body.payType = 1;
        document.getElementById("tabHopDongTraSau").style.display = 'flex';
    } else {
        body.payType = 2;
        document.getElementById("tabHopDongTraSau").style.display = 'none';
    }
    body.offerCode = pack;
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
            listReasonCode = [];
            listSelectReason = '<option value="">'+Messages("---Chọn lý do---")+'</option>';
            if(data.content != null && data.content.length > 0){
                var array = data.content.sort((a, b) => a.name.localeCompare(b.name));
                array.forEach(function (item) {
                    listSelectReason += '<option value="'+item.reasonId+'">'+item.name+'</option>';
                    listReason[item.reasonId] = item.name;
                    listReasonCode[item.reasonId] = item.reasonCode;
                });
                // var nameRs = "reason_"+index;
                // listReasonCode[nameRs] = reasonArr;
            }
            $("#reasonList").html(listSelectReason);
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function resetFormSearch() {
    $("#serialSim").val('');
    $("#statusConnectSub").val('');
    $("#fromDateCreateQr").val('');
    $("#toDateCreateQr").val('');
}