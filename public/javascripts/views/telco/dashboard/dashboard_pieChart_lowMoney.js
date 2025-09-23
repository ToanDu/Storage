$(document).ready(function() {
    getInitialLowMoneyCount();
});
function showListSubsLowMoney() {
    $("#pageLowMoney").val(1);
    getListSubsLowMoney();
}

function getInitialLowMoneyCount() {
    var body = new FormData();
    body.userId = userId;
    body.key = "LOW_MONEY";
    body.page = 1;
    body.pageSize = 1; 
    
    var r = jsRoutes.controllers.TelcoDashboardController.getListSubsDashboardByKey();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            if(datas.success && datas.content){
                let totalCount = datas.content.total || 0;
                $("#lowMoneyCount").text(totalCount);
            }
        },
        error: function (xhr) {
           
        }
    });
}

function getListSubsLowMoney() {
    var body = new FormData();
    body.userId = userId;
    body.key = "LOW_MONEY";
    body.page = $("#pageLowMoney").val();
    body.pageSize = $("#pageSizeLowMoney").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoDashboardController.getListSubsDashboardByKey();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c showListSubsLowMoney', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewLowMoneyToTable(datas.content, startAt, body.page, body.pageSize);
                $("#listLowMoneyModal").modal('show');
            } else {
                $("#tableLowMoney").find('tbody').html("");
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    setTimeout(function () {
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    },1500);
                } else {
                    showNotification('danger', datas.errorString);
                }
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

function viewLowMoneyToTable(datas, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = datas.data;
    if (listSubscriber!=null && listSubscriber.length > 0) {
        for (var i = 0; i < listSubscriber.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listSubscriber[i].isdn + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].moneyBalance != null ? listSubscriber[i].moneyBalance : "") + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].actStatusText != null ? listSubscriber[i].actStatusText : "") + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].statusText != null ? listSubscriber[i].statusText : "") + "</td>";
            body += "<td class='wrap-text'>" + formatUnixTime(listSubscriber[i].updatedTime) + "</td>";
            body += "</tr>";
        }
    }
    $("#tableLowMoney").find('tbody').html(body);

    pagingTableLowMoney(datas.total, page, pageSize);
}
function formatUnixTime(seconds) {
    return seconds ? moment(seconds * 1000).format("HH:mm:ss DD/MM/YYYY") : "";
}
function pagingTableLowMoney(total, page, pageSize) {
     $("#total_record_LowMoney").text(total);
    let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
    let currentPage = parseInt(page);
    let totalPage = Math.ceil(total / pageSize);

    if (currentPage > 1) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(${currentPage - 1}, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
                </li>`;
    }

    if (currentPage - 1 > 0) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(${currentPage - 1}, ${pageSize})">${currentPage - 1}</a>
                </li>`;
    }

    paging += `
            <li class="paginate_button page-item active">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(${currentPage}, ${pageSize})">${currentPage}</a>
            </li>`;

    if (currentPage + 1 <= totalPage) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(${currentPage + 1}, ${pageSize})">${currentPage + 1}</a>
                </li>`;
    }

    if (currentPage < totalPage) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(${currentPage + 1}, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowMoney(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
                </li>`;
    }

    paging += '</ul>';
    $("#pagingTableLowMoney").html(paging);
}
function applySearchLowMoney(page, pageSize) {
    $('#pageLowMoney').val(page);
    $('#pageSizeLowMoney').val(pageSize);
    $("#countPageSizeLowMoney").html(pageSize);
    getListSubsLowMoney();
}

function resetModalLowMoney() {
    // $("#pageLowMoney").val(1);
    // $("#pageSizeLowMoney").val(10);
    $("#total_record").text(0);
    $("#tableLowMoney").find('tbody').html("");
    $("#pagingTableLowMoney").html("");
}
var columnTitles;
var tableListSubscriber;
function downloadLowMoney(index) {
    if(index == 1){
        columnTitles = [Messages("manage.stt"), Messages("dashboard.modal.subscriber.number"), Messages("dashboard.modal.root.account"), Messages("dashboard.modal.block.status"), Messages("dashboard.modal.activity.status"), Messages("dashboard.modal.update.time")];
        tableListSubscriber = document.createElement("table");
        tableListSubscriber.setAttribute("class", "table");
        tableListSubscriber.setAttribute("id", "idExportTableLowMoney");
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
    }

    var body = new FormData();
    body.userId = userId;
    body.key = "LOW_MONEY";
    body.page = index;
    body.pageSize = 1000;
    console.log(body);
    StartProcess();
    var total = 0;
    var offset = 0;
    var limit = 0;
    var r = jsRoutes.controllers.TelcoDashboardController.getListSubsDashboardByKey();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c showListSubsLowMoney', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    total = datas.content.total;
                    offset = datas.content.offset;
                    limit = datas.content.limit;

                    createTableLowMoney(datas.content.data, index, body.pageSize);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(offset+limit < total){
                downloadLowMoney(index+1);
            } else {
                outExcelListLowMoney("Danh_sach_thue_bao_TK_goc_duoi_1000");
                FinishProcess();
            }
        }
    })
}
function createTableLowMoney(data, index, pageSize) {
    var tableBody = $('#idExportTableLowMoney').find("tbody");
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
                    valueTextNode = data[i].moneyBalance != null ? data[i].moneyBalance:"";
                    break;
                case 3:
                    valueTextNode = data[i].actStatusText != null ? data[i].actStatusText:"";
                    break;
                case 4:
                    valueTextNode = data[i].statusText != null ? data[i].statusText:"";
                    break;
                case 5:
                    valueTextNode = formatUnixTime(data[i].updatedTime);
                    break;
            }
            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}
function outExcelListLowMoney(name) {
    var x = document.getElementById("idExportTableLowMoney").rows.length;
    if(x > 1){
        var tableEx = $('#idExportTableLowMoney');
        var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
    } else {
        showNotification('danger',Messages("manage.no.data"));
    }
    $('#idExportTableLowMoney').remove();
}