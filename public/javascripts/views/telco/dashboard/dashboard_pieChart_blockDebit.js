function showListSubsBlockDebit() {
    $("#pageBlockDebit").val(1);
    getListSubsBlockDebit();
}
function getListSubsBlockDebit() {
    var body = new FormData();
    body.userId = userId;
    body.page = $("#pageBlockDebit").val();
    body.pageSize = $("#pageSizeBlockDebit").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoDashboardController.getListSubsDashboardBlockDebit();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c showListSubsBlockDebit', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewBlockDebitToTable(datas.content, startAt, body.page, body.pageSize);
                $("#listBlockDebitModal").modal('show');
            } else {
                $("#tableBlockDebit").find('tbody').html("");
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

function viewBlockDebitToTable(datas, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = datas.listSubscriber;
    if (listSubscriber!=null && listSubscriber.length > 0) {
        for (var i = 0; i < listSubscriber.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listSubscriber[i].isdn + "</td>";
            // body += "<td class='wrap-text'>" + (listSubscriber[i].moneyBalance != null ? listSubscriber[i].moneyBalance : "") + "</td>";
            body += "<td class='wrap-text'>" + Messages("chặn 1 chiều nợ cước") + "</td>";
            // body += "<td class='wrap-text'>" + (listSubscriber[i].statusText != null ? listSubscriber[i].statusText : "") + "</td>";
            body += "</tr>";
        }
    }
    $("#tableBlockDebit").find('tbody').html(body);

    pagingTableBlockDebit(datas.countSubscriber, page, pageSize);
}
function pagingTableBlockDebit(total, page, pageSize) {
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchBlockDebit(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchBlockDebit('+(parseInt(page)-1)+','+pageSize+')"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchBlockDebit('+(parseInt(page)-item)+','+pageSize+')">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearchBlockDebit('+parseInt(page)+','+pageSize+')">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchBlockDebit('+(parseInt(page)+item)+','+pageSize+')">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchBlockDebit('+(parseInt(page)+1)+','+pageSize+')"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchBlockDebit('+getTotalPage+','+pageSize+')"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTableBlockDebit").html(paging);
}
function applySearchBlockDebit(page, pageSize) {
    $('#pageBlockDebit').val(page);
    $('#pageSizeBlockDebit').val(pageSize);
    getListSubsBlockDebit();
}

function downloadBlockDebit(index) {
    if(index == 1){
        columnTitles = [Messages("STT"), Messages("Số thuê bao"), Messages("Trạng thái chặn cắt")];
        tableListSubscriber = document.createElement("table");
        tableListSubscriber.setAttribute("class", "table");
        tableListSubscriber.setAttribute("id", "idExportTableBlockDebit");
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
    body.page = index;
    body.pageSize = 100;
    console.log(body);
    StartProcess();
    var total = 0;
    var offset = 0;
    var limit = 0;
    var r = jsRoutes.controllers.TelcoDashboardController.getListSubsDashboardBlockDebit();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c showListSubsBlockDebit', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.content != null){
                if(datas.content.listSubscriber != null && datas.content.listSubscriber.length > 0){
                    total = datas.content.countSubscriber;
                    offset = body.page*body.pageSize;
                    limit = body.pageSize;

                    createTableBlockDebit(datas.content.listSubscriber, index, body.pageSize);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(offset+limit < total){
                downloadBlockDebit(index+1);
            } else {
                outExcelListBlockDebit("Danh_sach_thue_bao_chan_1_chieu_no_cuoc");
                FinishProcess();
            }
        }
    })
}
function createTableBlockDebit(data, index, pageSize) {
    var tableBody = $('#idExportTableBlockDebit').find("tbody");
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
                    valueTextNode = Messages("chặn 1 chiều nợ cước");
                    break;
            }
            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}
function outExcelListBlockDebit(name) {
    var x = document.getElementById("idExportTableBlockDebit").rows.length;
    if(x > 1){
        var tableEx = $('#idExportTableBlockDebit');
        var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
    } else {
        showNotification('danger',Messages("Không có dữ liệu "));
    }
    $('#idExportTableBlockDebit').remove();
}