/**
 * Created by vtk-anhlt166 on 4/21/23.
 */
function exportInvoiceCSV() {
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
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var rowsData = [];
                    var header = [];
                    header.push(Messages("invoice.contract.table.stt"));
                    header.push(Messages("invoice.contract.table.invoiceNumber"));
                    header.push(Messages("invoice.contract.table.type"));
                    header.push(Messages("invoice.contract.table.beforeTax"));
                    header.push(Messages("invoice.contract.table.afterTax"));
                    header.push(Messages("invoice.contract.table.assignDate"));
                    rowsData.push(header);
                    var data = datas.content.data;
                    for(var i=0; i<data.length; i++){
                        var item = [];
                        item.push(i+1);
                        item.push(data[i].invoiceNo);
                        item.push(getTypeByCode(data[i].invoiceType));
                        item.push(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(data[i].amountNotTax)));
                        item.push(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(data[i].amount)));
                        item.push(data[i].issuesDate.length > 0 ? moment(moment(data[i].issuesDate, "DD/MM/YYYY HH:mm:ss")).format("HH:mm DD/MM/YYYY") : "");
                        rowsData.push(item);
                    }

                    var filename = "invoice_" + body.contractId + "_" + body.billCycle + ".csv";
                    exportToCsv(filename, rowsData);
                } else {
                    showNotification('danger', Messages("invoice.contract.js.noInvoices"));
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

    // var filename = "invoice.csv";
    // var rows = [[Messages("Name"), Messages("#ff0000")],
    //     [Messages("Latitude"), Messages("Longtitude")],
    //     ["22.4859", "109.1938"],
    //     ["21", "109.5572"],
    //     ["19.5424", "108.9364"]
    // ];
    // exportToCsv(filename, rows);
}

function exportToCsv(filename, rows) {
    var processRow = function (row) {
        var finalVal = '';
        for (var j = 0; j < row.length; j++) {
            var innerValue = row[j] === null ? '' : row[j].toString();
            if (row[j] instanceof Date) {
                innerValue = row[j].toLocaleString();
            }
            var result = innerValue.replace(/"/g, '""');
            if (result.search(/("|,|\n)/g) >= 0)
                result = '"' + result + '"';
            if (j > 0)
                finalVal += ',';
            finalVal += result;
        }
        return finalVal + '\n';
    };

    var csvFile = '';
    for (var i = 0; i < rows.length; i++) {
        csvFile += processRow(rows[i]);
    }

    var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
    if (navigator.msSaveBlob) { // IE 10+
        navigator.msSaveBlob(blob, filename);
    } else {
        var link = document.createElement("a");
        if (link.download !== undefined) { // feature detection
            // Browsers that support HTML5 download attribute
            var url = URL.createObjectURL(blob);
            link.setAttribute("href", url);
            link.setAttribute("download", filename);
            link.style.visibility = 'hidden';
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        }
    }
}