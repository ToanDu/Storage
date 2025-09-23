/**
 * Created by vtk-anhlt166 on 6/16/22.
 */
$(document).ready(function () {
    var input = document.getElementById("searchNameProject");
    input.addEventListener("keypress", function(event) {
        // If the user presses the "Enter" key on the keyboard
        if (event.key === "Enter") {
            // Cancel the default action, if needed
            event.preventDefault();
            // Trigger the button element with a click
            getListProjectAdmin();
        }
    });

    totalProject();
    totalDevice();
    totalUser();
    totalDevelopActive();
    totalCustomer();
});
function totalProject() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/project";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalProject").html(data.content.total);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function totalDevice() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/device";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalDevice").html(data.content.total);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function totalUser() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/tenant";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalUser").html(data.content.total);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function totalCustomer() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/enduser";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalCustomer").html(data.content.total);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function totalDevelopActive() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/tenantactive";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalDevelopActive").html(data.content.today_total +"/"+ data.content.total);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}


const idExportTable = 'ExportDataTable';
function exportDataDevelopActive() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/tenantactiveinfo";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                createTable(data.content.users);
                outExcel("Export_Developer_Active");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}
function createTable(data) {
    var columnTitles = ["STT",
        Messages("Tên"),
        Messages("Email"),
        Messages("SĐT"),
        Messages("Số dự án"),
        Messages("Số thiết bị"),
        Messages("Tên dự án"),
        Messages("Tổng số TB"),
        Messages("Số TB hoạt động"),
        Messages("Tổng số bản tin"),
        Messages("Số user"),
        Messages("Lĩnh vực")
    ];

    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", idExportTable);
    document.body.appendChild(table);

    // create table head
    var tableThead = document.createElement("thead");
    var tableTheadTr = document.createElement("tr");

    for (var i = 0; i < columnTitles.length; i++) {
        var th = document.createElement("th");
        var value = document.createTextNode(columnTitles[i]);
        th.appendChild(value);
        tableTheadTr.appendChild(th);
    }
    tableThead.appendChild(tableTheadTr);
    table.appendChild(tableThead);

    // create table rows
    var tableBody = document.createElement("tbody");
    var stt = 1;
    for (var j = 0; j < data.length; j++) {
        if(data[j].projects_statistics != null && data[j].projects_statistics.length > 0){
            for(var k = 0; k < data[j].projects_statistics.length; k++){
                var tableTbodyTr = document.createElement("tr");
                for (var col = 0; col < columnTitles.length; col++) {
                    var td = document.createElement("td");
                    var valueTextNode = '';
                    switch (col) {
                        case 0:
                            valueTextNode = (k == 0) ? (j+1) : '';
                            break;
                        case 1:
                            valueTextNode = (k == 0) ? data[j].name : '';
                            break;
                        case 2:
                            valueTextNode =  (k == 0) ? data[j].email : '';
                            break;
                        case 3:
                            valueTextNode =  (k == 0) ? data[j].phone : '';
                            break;
                        case 4:
                            valueTextNode = (k == 0) ? data[j].projects_statistics.length : '';
                            break;
                        case 5:
                            valueTextNode = (k == 0) ? data[j].total_device_active : '';
                            break;
                        case 6:
                            valueTextNode = data[j].projects_statistics[k].project_name;
                            var textArr = data[j].projects_statistics[k].project_name.split(" ");
                            // console.log(textArr);
                            if(textArr.length > 1){
                                valueTextNode = '';
                                if(isNumber(textArr[textArr.length-1])){
                                    textArr.forEach(function (item, key) {
                                        if(key < textArr.length-2){
                                            valueTextNode += item + " ";
                                        } else {
                                            valueTextNode += item;
                                        }
                                    })
                                } else {
                                    valueTextNode = data[j].projects_statistics[k].project_name;
                                }
                            }
                            break;
                        case 7:
                            valueTextNode = data[j].projects_statistics[k].device_quantity;
                            break;
                        case 8:
                            valueTextNode = data[j].projects_statistics[k].device_active;
                            break;
                        case 9:
                            valueTextNode = data[j].projects_statistics[k].msg_quantity;
                            break;
                        case 10:
                            valueTextNode = data[j].projects_statistics[k].user_quantity;
                            break;
                        case 11:
                            valueTextNode = data[j].projects_statistics[k].tags != null ? JSON.stringify(data[j].projects_statistics[k].tags) : "";
                            break;
                    }
                    var valueTd = document.createTextNode(valueTextNode);
                    td.appendChild(valueTd);
                    tableTbodyTr.appendChild(td);
                }
                tableBody.appendChild(tableTbodyTr);
                stt++;
            }

        } else {
            var tableTbodyTr = document.createElement("tr");
            for (var col = 0; col < columnTitles.length; col++) {
                var td = document.createElement("td");
                var valueTextNode = '';
                switch (col) {
                    case 0:
                        valueTextNode = j+1;
                        break;
                    case 1:
                        valueTextNode = data[j].name;
                        break;
                    case 2:
                        valueTextNode =  data[j].email;
                        break;
                    case 3:
                        valueTextNode =  data[j].phone;
                        break;
                    case 4:
                        valueTextNode = 0;
                        break;
                    case 5:
                        valueTextNode = data[j].total_device_active;
                        break;
                    case 6:
                        valueTextNode = " ";
                        break;
                    case 7:
                        valueTextNode = " ";
                        break;
                    case 8:
                        valueTextNode = " ";
                        break;
                    case 9:
                        valueTextNode = " ";
                        break;
                    case 10:
                        valueTextNode = " ";
                        break;
                    case 11:
                        valueTextNode = " ";
                        break;
                }
                var valueTd = document.createTextNode(valueTextNode);
                td.appendChild(valueTd);
                tableTbodyTr.appendChild(td);
            }
            tableBody.appendChild(tableTbodyTr);
            stt++;
        }

    }
    table.appendChild(tableBody);
}
function outExcel(name) {
    var tableEx = $('#' + idExportTable);
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableEx);
    $('#' + idExportTable).remove();
}

function isNumber(n) {
    return /^-?[\d.]+(?:e-?\d+)?$/.test(n);
}