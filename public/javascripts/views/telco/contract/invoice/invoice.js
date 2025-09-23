/**
 * Created by vtk-anhlt166 on 11/23/22.
 */
var HD_TYPE = {
    UNKNOWN: {value: -1, name: Messages("invoice.contract.type.unknown")},
    HDIS: {value: "HDIS", name: Messages("invoice.contract.type.hdis")},
    HDDC: {value: "HDDC", name: Messages("invoice.contract.type.hddc")},
    HDCDT: {value: "HDCDT", name: Messages("invoice.contract.type.hdcdt")},
    HDTT: {value: "HDTT", name: Messages("invoice.contract.type.hdtt")},
    HDT: {value: "HDT", name: Messages("invoice.contract.type.hdt")},
    HDKTGD: {value: "HDKTGD", name: Messages("invoice.contract.type.hdktgd")}
};
$(document).ready(function () {
    getListInvoiceOfContract();
});

$(document).keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        getListInvoiceOfContract();
    }
});

function getListInvoiceOfContract() {
    var body = new FormData();
    body.contractId = $('#contractId').val();
    body.billCycle = $('#monthInvoice').val();
    if(body.contractId == undefined || body.contractId == ""){
        showNotification('danger', Messages("invoice.contract.js.contractNotFound"));
        return;
    }
    if(body.billCycle == undefined || body.billCycle == ""){
        showNotification('danger', Messages("invoice.contract.js.monthNotSelected"));
        return;
    }
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoInvoiceController.getListInvoiceOfContract();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            var mtmlBody =
                "<table id='tableListInvoice' class='table table-striped' style='width: 100%;'>" +
                "<thead style='background-color: #ff000054;'>" +
                "<th>"+Messages("invoice.contract.table.stt")+"</th>" +
                "<th>"+Messages("invoice.contract.table.invoiceNumber")+"</th>" +
                "<th>"+Messages("invoice.contract.table.type")+"</th>" +
                "<th>"+Messages("invoice.contract.table.beforeTax")+"</th>" +
                "<th>"+Messages("invoice.contract.table.afterTax")+"</th>" +
                "<th>"+Messages("invoice.contract.table.assignDate")+"</th>";
            if(isDownloadInvoice == "true"){
                mtmlBody += "<th>"+Messages("invoice.contract.table.actions")+"</th>";
            }
            mtmlBody +=
                "</thead>" +
                "<tbody>";
            if(datas.success){
                $("#notiNotDatatable").html("");
                if(datas.content.data != null && datas.content.data.length > 0){
                    var data = datas.content.data;
                    // var tableBody = $('#tableListInvoice').find("tbody");

                    for(var i=0; i<data.length; i++){
                        mtmlBody += "<tr>";
                        mtmlBody += "<td>"+(i+1)+"</td>";
                        mtmlBody += "<td>" + data[i].invoiceNo + "</td>";
                        mtmlBody += "<td class='wrap-text'>" + getTypeByCode(data[i].invoiceType) + "</td>";
                        mtmlBody += "<td>" + (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(data[i].amountNotTax))) + "</td>";
                        mtmlBody += "<td>" + (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(data[i].amount))) + "</td>";
                        mtmlBody += "<td class='wrap-text'>" + (data[i].issuesDate.length > 0 ? moment(moment(data[i].issuesDate, "DD/MM/YYYY HH:mm:ss")).format("YYYY/DD/MM HH:mm") : "") + "</td>";
                        if(isDownloadInvoice == "true"){
                            mtmlBody += "<td>" + '<a class="btn-tb cursor-pointer" onclick="downloadInvoice(\''+data[i].invoiceNo+'\', \''+data[i].issuesDate+'\')">'+Messages("Download")+'</a>' + "</td>";
                        }
                        mtmlBody += "</tr>";
                    }
                    mtmlBody += "</tbody></table>";
                    $("#divTableInvoice").html(mtmlBody);

                    var table = $("#tableListInvoice").DataTable({
                        responsive: true,
                        order: [[ 5, "desc" ]],
                        lengthMenu: [
                            [ 10, 50, -1],
                            ['10', '50', 'Tất cả']
                        ],
                        "columnDefs": [ {
                            "targets": 0,
                            "orderable": false
                            }],
                        bSort: true,
                        searching: false,
                        "bLengthChange" : false,
                        "bInfo":true
                    });
                    table.on('order.dt search.dt', function () {
                        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                            cell.innerHTML = i+1;
                        } );
                    } ).draw();
                } else {
                    mtmlBody += "</tbody></table>";
                    $("#divTableInvoice").html(mtmlBody);
                    $("#notiNotDatatable").html(Messages("invoice.contract.js.noDataToDisplay"));
                    showNotification('danger', Messages("invoice.contract.js.noInvoicesInMonth"));
                }
            } else {
                mtmlBody += "</tbody></table>";
                $("#divTableInvoice").html(mtmlBody);
                $("#notiNotDatatable").html(Messages("invoice.contract.js.noDataToDisplay"));
                showNotification('danger', Messages("invoice.contract.js.invoicesNotFound"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            $("#divTableInvoice").html("");
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function downloadInvoice(invoiceNo, date) {
    console.log(invoiceNo, date);
    var dateArr = date.split(' ');

    var body = new FormData();
    body.invoiceNo = invoiceNo;
    body.invoiceDate = dateArr[0];

    StartProcess();
    var r = jsRoutes.controllers.TelcoInvoiceController.getLinkDownloadInvoice();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                if(datas.content != null && datas.content.fileContent != ""){
                    downloadPDF(datas.content.fileContent, datas.content.fileName);
                } else {
                    showNotification('danger', Messages("invoice.contract.js.noDownloadFile"));
                }
            } else {
                showNotification('danger', Messages("invoice.contract.js.invoicesNotFound"));
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
function downloadPDF(pdf, name) {
    const linkSource = `data:application/pdf;base64,${pdf}`;
    const downloadLink = document.createElement("a");
    const fileName = name;
    downloadLink.href = linkSource;
    downloadLink.download = fileName;
    downloadLink.click();
}

function getTypeByCode(code) {
    if(code == HD_TYPE.HDIS.value){
        return HD_TYPE.HDIS.name;
    } else if(code == HD_TYPE.HDDC.value){
        return HD_TYPE.HDDC.name;
    }  else if(code == HD_TYPE.HDCDT.value){
        return HD_TYPE.HDCDT.name;
    } else if(code == HD_TYPE.HDTT.value){
        return HD_TYPE.HDTT.name;
    } else if(code == HD_TYPE.HDT.value){
        return HD_TYPE.HDT.name;
    } else if(code == HD_TYPE.HDKTGD.value){
        return HD_TYPE.HDKTGD.name;
    } else {
        return HD_TYPE.UNKNOWN.name;
    }
}