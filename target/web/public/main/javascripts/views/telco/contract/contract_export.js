/**
 * Created by vtk-anhlt166 on 2/10/23.
 */
const idExportTable = 'TableListContracts';
var tableListContracts;
const pagesize = 1000;
var columnTitles = new Array;
var totalRecordExport = 0;

function onlickButtonExport() {
    $("#page").val(1);
    exportContractsToExcel(1);
}

function exportContractsToExcel(index) {
    if(index == 1){
        totalRecordExport = 0;

        columnTitles = [Messages("contract.table.stt"), Messages("contract.table.contractCode"), Messages("contract.table.contractNumber"), Messages("contract.table.status"), Messages("contract.table.effectiveDate"),
            Messages("contract.table.representativeNumber"), Messages("contract.table.address")
        ];

        tableListContracts = document.createElement("table");
        tableListContracts.setAttribute("class", "table");
        tableListContracts.setAttribute("id", idExportTable);
        tableListContracts.setAttribute("style", "margin-top: 100%");

        document.body.appendChild(tableListContracts);

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
        tableListContracts.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tableListContracts.appendChild(tableTbody);

    }
    var countData = 0;

    var body = new FormData();
    body.userId = userId;
    body.accountId = $('#accountId').val().trim();
    body.accountNo = $('#accountNo').val().trim();
    body.page = index;
    body.pageSize = pagesize;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoContractController.getListAccountContract();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                if(datas.content.listAccountDTO != null && datas.content.listAccountDTO.length > 0){
                    countData = datas.content.listAccountDTO.length;
                    totalRecordExport += countData;

                    createTable(datas.content.listAccountDTO, index);
                }
            } else {
                showNotification('danger', Messages("contract.js.dataFetchFailed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(countData == pagesize && totalRecordExport < 10000){
                exportContractsToExcel(index+1);
            } else {
                outExcelListContracts("Export_list_contracts");
                FinishProcess();
            }
        }
    })
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
                    valueTextNode = data[i].accountID;
                    break;
                case 2:
                    valueTextNode = data[i].accountNo;
                    break;
                case 3:
                    valueTextNode = getStatusByCode(data[i].status, data[i].payType);
                    break;
                case 4:
                    valueTextNode = data[i].effectDate.length > 0 ? (moment(moment(data[i].effectDate, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm') +"-"+ moment(moment(data[i].effectDate, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('DD/MM/YYYY')) : "";
                    break;
                case 5:
                    valueTextNode = data[i].isdn;
                    break;
                case 6:
                    valueTextNode = data[i].address;
                    break;
            }
            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}

function outExcelListContracts(name) {
    var x = document.getElementById(idExportTable).rows.length;
    console.log(x);
    if(x > 1){
        var tableEx = $('#' + idExportTable);
        var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
    } else {
        showNotification('danger',Messages("common.noData"));
    }
    $('#' + idExportTable).remove();
}