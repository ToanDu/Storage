/**
 * Created by vtk-anhlt166 on 2/15/23.
 */
const idExportTable = 'TableListOrders';
var tableListOrders;
const pagesize = 1000;
var columnTitles = new Array;
var totalRecordExport = 0;

function onclickButtonExport() {
    $("#page").val(1);
    exportOrdersToExcel(1);
}

function exportOrdersToExcel(index) {
    if(index == 1){
        totalRecordExport = 0;

        columnTitles = ["STT", Messages("history.table.order.code"), Messages("history.table.order.type"), Messages("history.table.company.name"), Messages("history.table.representative"),
            Messages("history.table.phone.number"), Messages("history.table.status"), Messages("history.table.time")
        ];

        tableListOrders = document.createElement("table");
        tableListOrders.setAttribute("class", "table");
        tableListOrders.setAttribute("id", idExportTable);
        tableListOrders.setAttribute("style", "margin-top: 100%");

        document.body.appendChild(tableListOrders);

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
        tableListOrders.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tableListOrders.appendChild(tableTbody);
    }
    var countData = 0;

    let fromDate = $("#fromDate").val().trim();
    let toDate = $("#toDate").val().trim();
    var body = new FormData();
    body.orderId = $('#orderId').val().trim();
    body.page = index;
    body.pageSize = totalOrders;
    body.userId = userId;
    body.orderType = $("#orderType").val();
    body.status = $("#status").val();
    body.from =  getUnixTimestamp(fromDate);
    body.to = getUnixTimestamp(toDate);
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.getListOrderBuySim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.orders != null){
                    countData = datas.content.data.orders.length;
                    totalRecordExport += countData;

                    if(datas.content.data.orders.length > 0){
                        createTable(datas.content.data.orders, index);
                    }  else {
                        // showNotification('danger', Messages("Dữ liệu không có sẵn"));
                    }
                }  else {
                    // showNotification('danger', Messages("Dữ liệu không có sẵn"));
                }
            } else {
                // showNotification('danger', Messages("Lấy dữ liệu không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(countData == pagesize && totalRecordExport < 10000){
                exportOrdersToExcel(index+1);
            } else {
                if(totalRecordExport > 0){
                    outExcelListOrders("Export_list_orders");
                } else {
                    showNotification('danger', Messages("Dữ liệu không có sẵn"));
                    $('#' + idExportTable).remove();
                }
                FinishProcess();
            }
        }
    })
}
function getLabelOrderType(orderType) {
    if (orderType === "order") {
        return "Đặt hàng";
    } else if (orderType === "change") {
        return "Đổi sim";
    } else {
        return "Không xác định";
    }
}
function createTable(data, index) {
    // create table rows
    var tableBody = $('#'+ idExportTable).find("tbody");
    for (var i = 0; i < data.length; i++) {
        var tableTbodyTr = document.createElement("tr");
        for (var col = 0; col < columnTitles.length; col++) {
            var td = document.createElement("td");
            var valueTextNode = '';
            var stt = (index-1)*pagesize;
            switch (col) {
                case 0:
                    valueTextNode = stt+i+1;
                    break;
                case 1:
                    valueTextNode = data[i].id;
                    break;
                case 2:
                    valueTextNode = getLabelOrderType(data[i].type);
                    break;
                case 3:
                    valueTextNode = data[i].bussinessName;
                    break;
                case 4:
                    valueTextNode = data[i].recipientName;
                    break;
                case 5:
                    valueTextNode = data[i].recipientPhone;
                    break;
                case 6:
                    valueTextNode = "Thành công";
                    break;
                case 7:
                    valueTextNode = moment.unix(data[i].createdTime).format("HH:mm DD/MM/YYYY");
                    break;
            }
            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}

function outExcelListOrders(name) {
    var tableEx = $('#' + idExportTable);
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableEx);
    $('#' + idExportTable).remove();
}