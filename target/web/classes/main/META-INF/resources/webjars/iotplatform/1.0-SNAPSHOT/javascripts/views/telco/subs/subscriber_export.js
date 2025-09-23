/**
 * Created by vtk-anhlt166 on 11/18/22.
 */
const idExportTable = 'TableListSubscriber';
var tableListSubscriber;
const pagesize = 1000;
var columnTitles = new Array;
var totalRecordExport = 0;
$('#countOnefileExport').on('input', function() {
    this.value = this.value.replace(/[^0-9]/g, '');
});
function onlickButtonExport() {
    $("#countOnefileExport").val(5000);
    $("#exportListFileModal").modal('show');
}
function getListFileExport() {
    if($("#countOnefileExport").val() <= 0 || $("#countOnefileExport").val() > 5000){
        showNotification('danger', Messages("subscriber.export.minMaxRecords"));
        return;
    }
    if ($("#exportListFileModal").hasClass('show') && !$("#select_type_unit").val()) {
        showNotification('danger', Messages("subscriber.export.selectDataType"));
        return;
    }
    if($("#select_type_data").val() === '2'){
        if($("#fromDate").val() === '' || $("#toDate").val() ===''){
            showNotification('danger', Messages("subscriber.export.selectDateRange"));
            return;
        }
        var dateBegin = document.getElementById('fromDate').value;
        var dateEnd = document.getElementById('toDate').value;
        var currentDay = new Date();
        currentDay.setHours(0, 0, 0, 0);
        var dayFrom = new Date(dateBegin.split("/").reverse().join("-"));
        var dayTo = new Date(dateEnd.split("/").reverse().join("-"));
        console.log(dayTo);
        if(dateBegin !=  "" && dateEnd != ""){
            if ( dayTo - dayFrom < 0 ) {
                showNotification('danger',Messages("subscriber.export.fromDateLessEqualToDate"));
                document.getElementById('fromDate').value = "";
            }
            else{
                if ( dayTo - dayFrom >2678400000 ) {
                    showNotification('danger',Messages("subscriber.export.dateRangeMaxDays"));
                    document.getElementById('fromDate').value = "";
                    document.getElementById('toDate').value = "";
                    return;
                }
            }

        }
        if ( dayFrom > currentDay) {
            showNotification('danger',Messages("subscriber.export.fromDateLessCurrentDate"));
            document.getElementById('fromDate').value = "";
            return;
        }
        if ( dayTo>= currentDay ) {
            showNotification('danger',Messages("subscriber.export.toDateLessCurrentDate"));
            document.getElementById('toDate').value = "";
            return;
        }
    }
    var body = new FormData();
    body.userId = userId;
    body.isdn = $('#isdn').val().trim();
    body.serial = $('#serialSim').val().trim();
    body.idNo = $('#idNo').val();
    body.accountId = $('#accountId').val().trim();
    body.payType = $('#payType').val();
    body.productCode = $('#productCode').val();
    body.actStatus = $('#actStatus').val();
    body.status = "1";
    body.promotionCode = $('#promotionCode').val();
    body.fromStaDatetime = $('#staDatetimeFrom').val().replaceAll("/","-");
    body.toStaDatetime = $('#staDatetimeTo').val().replaceAll("/","-");
    body.fromActiveDatetime = $('#activeDateFrom').val().replaceAll("/","-");
    body.toActiveDatetime = $('#activeDateTo').val().replaceAll("/","-");
    body.page = 1;
    body.pageSize = 10;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getListSubsByBeVht();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log("-------------------",datas);
            if(datas.content != null){
                if(datas.content.total > 0){
                    var pagesize = $("#countOnefileExport").val();
                    var stt = Math.floor(datas.content.total/pagesize);
                    var sodu = datas.content.total%pagesize;
                    console.log(stt, sodu);
                    if(sodu > 0){
                        stt++;
                    }
                    if (stt > 2) {
                        $("#addBtnDownloadAll").html('<span class="text-danger" id="btnDownloadAll" onclick="downloadAllFiles()" style="cursor: pointer; text-decoration: underline;">'+Messages("subscriber.export.downloadAll")+'</span>');
                    }
                    var mtml =
                        "<table id='file_export' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
                        "<thead style='background-color: #FBCCD6;'>" +
                        "<th>"+Messages("subscriber.modal.export.table.index")+"</th>" +
                        "<th>"+Messages("subscriber.modal.export.table.file")+"</th>" +
                        "<th>"+Messages("subscriber.modal.export.table.action")+"</th>" +
                        "</thead>" +
                        "<tbody>";
                    for(var i= 0 ; i<stt; i++){
                        var name;
                        if($("#select_type_data").val() === '2'){
                            name = "Export_history_data_"+(i+1);
                        }
                        else{
                            name = "Export_list_subscriber_"+(i+1);
                        }

                        mtml += "<tr>";
                        mtml += "<td>" +(i+1)+ "</td>";
                        mtml += "<td>" + name + "</td>";
                        mtml += "<td>"+"<a class='down_file_excel' style='color: #EA0033; cursor: pointer;text-decoration: underline;' onclick='downloadFileExcelSubsList("+(i+1)+", "+pagesize+", \""+name+"\")'>"+Messages("subscriber.export.download")+"</a>"+"</td>";
                        mtml += "</tr>";
                    }

                    mtml += "</tbody></table>";
                    $("#tabListFileExport").html(mtml);
                
                } else {
                    $("#tabListFileExport").html("");
                    showNotification('danger', Messages("tableNoData"));
                }
            } else {
                showNotification('danger', Messages("subscriber.export.getDataFailed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function downloadFileExcelSubsList(index, pageSize, name) {
    console.log(index, pageSize, name);
    totalRecordExport = 0;
    let typeData = $("#select_type_unit").val();
    if (!typeData) {
        showNotification('danger', Messages("subscriber.export.selectDataType"));
        return;
    }
    if($("#select_type_data").val() == 1){
        console.log($("#select_type_data").val())
        columnTitles = [Messages("subscriber.stt"), Messages("subscriber.phoneNumber"), Messages("subscriber.subscriberCode"), Messages("subscriber.servicePackage"), Messages("subscriber.promotionCode"), Messages("subscriber.contractCode"),
            Messages("subscriber.customerCode"), Messages("subscriber.simSerial"), Messages("subscriber.blockStatus"), Messages("subscriber.activation"), Messages("subscriber.connection"),
            Messages("subscriber.serviceType"), Messages("subscriber.hybridAmount"), Messages("subscriber.miAddonPromotion"),
            Messages("subscriber.debtStartPeriod"), Messages("subscriber.paidCharges"), Messages("subscriber.remainingDebt"), Messages("subscriber.adjustmentAmount"), Messages("subscriber.hotChargeEstimate"),
            Messages("subscriber.promotionName"), Messages("subscriber.promotionEffectiveDate"), Messages("subscriber.promotionExpiryDate"), Messages("subscriber.promotionDescription"),
            Messages("subscriber.remainingData"), Messages("subscriber.remainingSMS"), Messages("subscriber.remainingVoice"),
            Messages("subscriber.rootAccount"), Messages("subscriber.promotionAccount"), Messages("subscriber.internalPromoAccount"), Messages("subscriber.otherAccount"),
            Messages("subscriber.updateDate"), Messages("subscriber.subscriberStatus")
        ];

        tableListSubscriber = document.createElement("table");
        tableListSubscriber.setAttribute("class", "table");
        tableListSubscriber.setAttribute("id", idExportTable);
        tableListSubscriber.setAttribute("style", "margin-top: 100%");
        document.body.appendChild(tableListSubscriber);

        // create table head
        var tableThead = document.createElement("thead");
        var tableTheadTr = document.createElement("tr");

        for (var j = 0; j < columnTitles.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitles[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
        }
        tableThead.appendChild(tableTheadTr);
        tableListSubscriber.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tableListSubscriber.appendChild(tableTbody);

        var countData = 0;

        var body = new FormData();
        body.userId = userId;
        body.idNo = $('#idNo').val();
        body.isdn = $('#isdn').val().trim();
        body.serial = $('#serialSim').val().trim();
        body.accountId = $('#accountId').val().trim();
        body.payType = $('#payType').val();
        body.productCode = $('#productCode').val();
        body.actStatus = $('#actStatus').val();
        body.status = "1";
        body.promotionCode = $('#promotionCode').val();
        body.fromStaDatetime = $('#staDatetimeFrom').val().replaceAll("/","-");
        body.toStaDatetime = $('#staDatetimeTo').val().replaceAll("/","-");
        body.fromActiveDatetime = $('#activeDateFrom').val().replaceAll("/","-");
        body.toActiveDatetime = $('#activeDateTo').val().replaceAll("/","-");
        body.page = index;
        body.pageSize = pageSize;
        console.log(body);
        var r = jsRoutes.controllers.TelcoSubscriberController.getListSubsByBeVht();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function(datas){
                console.log(datas);
                if(datas.content != null){
                    if(datas.content.data != null && datas.content.data.length > 0){
                        createTable(datas.content.data, index, pageSize, typeData);

                        outExcelListSubs(name);
                    }
                } else {
                    showNotification('danger', Messages("subscriber.error.dataFetchFailed"));
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
            },
            complete: function (){
            }
        })
    } else{
        console.log($("#select_type_data").val())
        var formData = new FormData();
        var page = (index-1)*pageSize;
        console.log(page,pageSize)
        var from = $("#fromDate").val();
        var to = $("#toDate").val();
        console.log(to,from)
        var limit = pageSize;
        var offset = page;
        var unit = $('#select_type_unit').val();
        //formData.param='/api/telco/subscriber/exportUsedData?userId='+userId+ '&from='+$("#fromDate").val()+'&to='+$("#toDate").val()+ '&limit='+pageSize+'&offset='+page + '&unit='+$('#select_type_unit').val();
        console.log(formData);
        var param = '?userId=' +userId +
                    '&from=' +from+
                    '&to=' + to +
                    '&limit=' + limit +
                    '&offset=' + offset +
                    '&unit=' + unit;
        var paramEncode = encodeURIComponent(param)
        var r = jsRoutes.controllers.DownloadFileController.downloadFileFromApi(paramEncode);
        $.ajax({
            type: r.type,
            //data: JSON.stringify(formData),
            contentType: 'application/json; charset=utf-8',
            xhrFields: { responseType: 'blob' },
            url: r.url,
            success: function(data, status, xhr){
                let filename = name || 'download.xlsx';
                const disposition = xhr.getResponseHeader('Content-Disposition');

                if (disposition && disposition.includes('filename=')) {
                    filename = disposition.split('filename=')[1].replace(/"/g, '');
                }

                // Tạo blob URL và tải file
                const url = window.URL.createObjectURL(data);
                const a = document.createElement('a');
                a.href = url;
                a.download = filename;
                document.body.appendChild(a);
                a.click();
                a.remove();
                window.URL.revokeObjectURL(url);
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
            },
            complete: function (){
            }
        })
        //callExportUsedDataAPI(index,pageSize);
    }

}
async function callExportUsedDataAPI(index,pageSize) {
    try {
        // Đường dẫn endpoint gốc của API (bạn cần thay bằng đúng domain staging hoặc production)
        var apiBaseUrl = "https://cmp-api.innoway.vn";

        // Các tham số cần truyền
        var page = (index-1)*pageSize;
        console.log(page,pageSize)
        var from = $("#fromDate").val();
        var to = $("#toDate").val();
        console.log(to,from)
        var limit = pageSize;
        var offset = page;
        var unit = $('#select_type_unit').val();

        // Tạo full query string
        const rawPath = `/api/telco/subscriber/exportUsedData?userId=${userId}&from=${from}&to=${to}&limit=${limit}&offset=${offset}&unit=${unit}`;

        // Chỉ encode 1 lần!
        //const encodedPath = encodeURIComponent(rawPath);

        // Gọi API endpoint có param đã mã hóa
        const fullUrl = `${apiBaseUrl}${rawPath}`;

        console.log("Gọi đến:", fullUrl);

        const response = await fetch(fullUrl, {
            method: "GET",
            headers: {
                // Thêm token nếu cần xác thực
                "Authorization": "Bearer N2BLXBAhc4oE7Z6Xlg95l0WhdsKZ4pPW",
                "Accept": "*/*"
            }
        });

        if (!response.ok) {
            throw new Error(`Lỗi ${response.status}: ${await response.text()}`);
        }

        // Lấy tên file từ header nếu có
        const disposition = response.headers.get("content-disposition");
        let filename = "exported_file";

        if (disposition && disposition.includes("filename=")) {
            const match = disposition.match(/filename="?(.+)"?/);
            if (match) {
                filename = match[1];
            }
        }

        const blob = await response.blob();
        const downloadUrl = URL.createObjectURL(blob);
        const a = document.createElement("a");
        a.href = downloadUrl;
        a.download = filename;
        document.body.appendChild(a);
        a.click();
        a.remove();
        URL.revokeObjectURL(downloadUrl);

        console.log("File đã được tải về:", filename);

    } catch (error) {
        console.error("Lỗi khi gọi API:", error.message);
    }
}

function createTable(data, index, pageSize, typeData) {
    // create table rows
    var tableBody = $('#'+ idExportTable).find("tbody");
    for (var i = 0; i < data.length; i++) {
        var tableTbodyTr = document.createElement("tr");
        for (var col = 0; col < columnTitles.length; col++) {
            var td = document.createElement("td");
            var valueTextNode = '';
            var stt = (index-1)*pageSize;
            switch (col) {
                case 0:
                    valueTextNode = stt+i+1;
                    break;
                case 1:
                    valueTextNode = data[i].isdn;
                    break;
                case 2:
                    valueTextNode = data[i].subId;
                    break;
                case 3:
                    valueTextNode = data[i].productCode;
                    break;
                case 4:
                    valueTextNode = data[i].promotionCode;
                    break;
                case 5:
                    valueTextNode = data[i].accountId;
                    break;
                case 6:
                    valueTextNode = data[i].custId;
                    break;
                case 7:
                    valueTextNode = "'"+data[i].serial;
                    break;
                case 8:
                    valueTextNode = getStatusByCode(data[i].actStatus, data[i].payType);
                    break;
                case 9:
                    valueTextNode = (data[i].staDatetime != null ? (moment(moment(data[i].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("HH:mm")+"-"+moment(moment(data[i].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("DD/MM/YYYY")) : "");
                    break;
                case 10:
                    valueTextNode = (data[i].activeDatetime != null ? (moment(moment(data[i].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("HH:mm")+"-"+moment(moment(data[i].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("DD/MM/YYYY")) : "");
                    break;
                case 11:
                    valueTextNode = getPayTypeByCode(data[i].payType);
                    break;
                case 12:
                    valueTextNode = data[i].hybridBalance;
                    break;
                case 13:
                    valueTextNode = data[i].dataPackageInfo != null ? data[i].dataPackageInfo.message : "";
                    break;
                case 14:
                    valueTextNode = data[i].debitInfo != null ? data[i].debitInfo.staOfCycle : "";
                    break;
                case 15:
                    valueTextNode = data[i].debitInfo != null ? data[i].debitInfo.payment : "";
                    break;
                case 16:
                    valueTextNode = data[i].debitInfo != null ? data[i].debitInfo.remainAmount : "";
                    break;
                case 17:
                    valueTextNode = data[i].debitInfo != null ? data[i].debitInfo.adjustAmount : "";
                    break;
                case 18:
                    valueTextNode = data[i].debitInfo != null ? data[i].debitInfo.hotCharge : "";
                    break;
                case 19:
                    valueTextNode = data[i].discountPromotion != null ? data[i].discountPromotion.name : "";
                    break;
                case 20:
                    valueTextNode = (data[i].discountPromotion != null && data[i].discountPromotion.effectDatetime.length > 0) ? (moment(moment(data[i].discountPromotion.effectDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm') +"-"+ moment(moment(data[i].discountPromotion.effectDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('DD/MM/YYYY')) : "";
                    break;
                case 21:
                    valueTextNode = (data[i].discountPromotion != null && data[i].discountPromotion.expireDatetime.length > 0) ? (moment(moment(data[i].discountPromotion.expireDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm') +"-"+ moment(moment(data[i].discountPromotion.expireDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('DD/MM/YYYY')) : "";
                    break;
                case 22:
                    valueTextNode = data[i].discountPromotion != null ? data[i].discountPromotion.description : "";
                    break;

                case 23:
                    valueTextNode = data[i].dataRemain != null ? convertData(data[i].dataRemain, typeData ) : "0";
                    break;
                case 24:
                    valueTextNode = data[i].balanceInfo != null ? data[i].balanceInfo.sms : "0";
                    break;
                case 25:
                    valueTextNode = data[i].balanceInfo != null ? data[i].balanceInfo.voice : "0";
                    break;
                case 26:
                    valueTextNode = data[i].balanceInfo != null ? data[i].balanceInfo.money : "0";
                    break;
                case 27:
                    valueTextNode = data[i].balanceInfo != null ? data[i].balanceInfo.promotionMoney : "0";
                    break;
                case 28:
                    valueTextNode = data[i].balanceInfo != null ? data[i].balanceInfo.promotionVTMoney : "0";
                    break;
                case 29:
                    valueTextNode = data[i].balanceInfo != null ? data[i].balanceInfo.otherMoney : "0";
                    break;

                case 30:
                    valueTextNode = moment.unix(data[i].updatedTime).format("HH:mm")+"-"+moment.unix(data[i].updatedTime).format("DD/MM/YYYY");
                    break;

                case 31:
                    valueTextNode = data[i].status == 1 ? Messages("subscriber.status.active") : Messages("subscriber.status.cancelled");
                    break;
            }
            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}
function convertData(data, unitType = "MB") {
    if (unitType === "KB") {
        // Convert MB to KB
        return Math.round(data * 1024) + " KB";
    } else if (unitType === "MB") {
        // Data is already in MB
        return data.toFixed(0) + " MB";
    } else if (unitType === "GB") {
        // Convert MB to GB
        return (data / 1024).toFixed(2) + " GB";
    }
}
function outExcelListSubs(name) {
    var x = document.getElementById(idExportTable).rows.length;
    console.log(x);
    if(x > 1){
        var tableEx = $('#' + idExportTable);
        var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
    } else {
    showNotification('danger',Messages("subscriber.export.noDataAvailable"));
    }
    $('#' + idExportTable).remove();
}

function downloadAllFiles() {
    let downloadButtons = $(".down_file_excel");
    let index = 0;

    // Disable the "Tải tất cả" button and show loading text
    let downloadAllButton = $("#btnDownloadAll");
    downloadAllButton.text("Đang tải...");
    downloadAllButton.css("pointer-events", "none");

    // Add loading spinner
    let spinner = $("<span class='spinner-border spinner-border-sm ml-2' role='status' aria-hidden='true'></span>");
    downloadAllButton.append(spinner);

    function clickNextButton() {
        if (index < downloadButtons.length) {
            $(downloadButtons[index]).click();
            index++;
            setTimeout(clickNextButton, 1000); // 1 second delay
        } else {
            // Re-enable the "Tải tất cả" button and reset text after all downloads
            downloadAllButton.text("Tải tất cả");
            downloadAllButton.css("pointer-events", "auto");
        }
    }

    clickNextButton();
}
$('#select_type_data').on('change', function() {
    console.log(this.value);
    if (this.value == 2) {
        // Clear tbody and add "Chưa có dữ liệu" row
        $("#file_export tbody").html(
            `<tr></tr>
            <td colspan="3" class="text-center">Chưa có dữ liệu</td>
            </tr>`
        );
        // Show with animation
        $('#select_date').stop(true, true).slideDown(200);
    } else {
        // Hide with animation
        $('#select_date').stop(true, true).slideUp(200);
    }
});

$(document).ready(function () {
    $('#exportListFileModal').on('hidden.bs.modal', function () {
      // Reset các select
      $('#select_type_data').prop('selectedIndex', 0);
      $('#select_type_unit').prop('selectedIndex', 1);

      // Reset input
      $('#countOnefileExport').val('5000');
      $('#fromDate').val('');
      $('#toDate').val('');

      // Ẩn vùng chọn thời gian (nếu đang hiển thị)
      $('#select_date').hide();

      // Reset bảng danh sách file
      $('#file_export tbody').html('<tr><td colspan="3" class="text-center">Chưa có dữ liệu</td></tr>');

      // Xóa vùng nút tải về
      $('#addBtnDownloadAll').empty();
    });
  });
// function onlickButtonExport() {
//     $("#page").val(1);
//
//     var subsText = $('#isdn').val();
//     var listSubs = subsText.split(",");
//
//     var serialText = $('#serialSim').val();
//     var listSerial = serialText.split(",");
//
//     listCheckSubs = [];
//     if(listSubs.length > 0){
//         for(var s=0; s<listSubs.length; s++){
//             var sub = parseFloat(listSubs[s].trim().replace(/\D/g,''));
//             // var sub = listSubs[s].replace(/\D/g,'').trim();
//             if(sub > 0){
//                 if(!listCheckSubs.includes(sub.toString())){
//                     listCheckSubs.push(sub.toString());
//                 }
//             }
//         }
//     }
//     console.log(listCheckSubs);
//     listCheckSerial = [];
//     if(listSerial.length > 0){
//         for(var i=0; i<listSerial.length; i++){
//             var serial = listSerial[i].trim().replace(/\D/g,'');
//             if(serial.length > 0){
//                 if(!listCheckSerial.includes(serial)){
//                     listCheckSerial.push(serial);
//                 }
//             }
//         }
//     }
//
//     if(listCheckSubs.length <= 1 && listCheckSerial.length <= 1){
//         exportSubscriberToExcel(1);
//     } else {
//         if(listCheckSubs.length > 1 && listCheckSerial.length <= 1){
//             if(listCheckSubs.length <= 10000){
//                 listSubsImport = listCheckSubs;
//                 exportMultiSearchSubs(0);
//             } else {
//                 showNotification('danger',Messages("Không hỗ trợ tìm kiếm quá 10000 số thuê bao"));
//                 return;
//             }
//         } else if(listCheckSubs.length <= 1 && listCheckSerial.length > 1){
//             if(listCheckSerial.length <= 10000){
//                 listSerialImport = listCheckSerial;
//                 exportMultiSearchSerial(0);
//             } else {
//                 showNotification('danger',Messages("Không hỗ trợ tìm kiếm quá 10000 số Serial"));
//                 return;
//             }
//         } else {
//             showNotification('danger',Messages("Không hỗ trợ tìm kiếm cùng lúc nhiều số thuê bao và nhiều số serial"));
//             return;
//         }
//
//         // setTimeout(function () {
//         //     var tableEx = $('#listSubsTable');
//         //     var table2excel = new Table2Excel({
//         //         defaultFileName: "Export_list_subscriber",
//         //         tableNameDataAttribute: "myTableExport",
//         //         columns : [1,2,3,4,5,6]
//         //     });
//         //     table2excel.export(tableEx);
//         // },3000);
//     }
// }