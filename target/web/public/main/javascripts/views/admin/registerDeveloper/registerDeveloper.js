/**
 * Created by vtk-anhlt166 on 7/27/22.
 */
function setDelRegister(id) {
    $("#idDelete").val(id);
}

const idExportTable = 'ExportDataTable';
function exportToExcelRegister() {
    StartProcess();
    var r = jsRoutes.controllers.AdminRegisterDeveloperController.exportRegisterDeveloperList();
    $.ajax({
        type: r.type,
        url: r.url,
        data: $('#advanced-search-bar #search-filter-body #search-filter-form').serialize(),
        success: function (data) {
            console.log(data);
            if(data && data.length > 0){
                createTable(data);
                outExcel("Export_Register_Developer_List");
            } else {
                showNotification('danger', Messages("Export false"));
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            showNotification('danger', Messages("request.error"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function createTable(data) {
    var columnTitles = ["STT",
        Messages("filter.name"),
        Messages("filter.nameCompany"),
        Messages("filter.email"),
        Messages("filter.phone"),
        Messages("filter.role"),
        Messages("filter.field"),
        Messages("filter.countDevice"),
        Messages("filter.countUser"),
        Messages("filter.ip"),
        Messages("filter.logDate")
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
    for (var j = 0; j < data.length; j++) {
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
                    valueTextNode = data[j].nameCompany;
                    break;
                case 3:
                    valueTextNode = data[j].email;
                    break;
                case 4:
                    valueTextNode = "'"+data[j].phone;
                    break;
                case 5:
                    valueTextNode = data[j].role;
                    break;
                case 6:
                    valueTextNode = data[j].field;
                    break;
                case 7:
                    valueTextNode = data[j].countDevice;
                    break;
                case 8:
                    valueTextNode = data[j].countUser;
                    break;
                case 9:
                    valueTextNode = data[j].ip;
                    break;
                case 10:
                    valueTextNode = moment.unix(data[j].logDate/1000).format("HH:mm DD/MM/YYYY");
                    break;

            }
            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.appendChild(tableTbodyTr);
    }
    table.appendChild(tableBody);
}

function outExcel(name) {
    var tableEx = $('#' + idExportTable);
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableEx);
    $('#' + idExportTable).remove();
}