/**
 * Created by vtk-anhlt166 on 4/13/23.
 */
$(document).ready(function () {
    getLogConnectSim();
});
function onlickButtonSearch() {
    $("#page").val(1);
    getLogConnectSim();
}

function getLogConnectSim() {
    var body = new FormData();
    body.action = $("#actionConnectSim").val();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    body.userId = userId;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoLogController.getLogConnectSim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewDataToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                $("#listLogsTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listLogsTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var listRespon = new Array;
function viewDataToTable(datas, startAt, page, pageSize) {
    var body = "";
    listRespon = [];
    var listData = datas.data;
    if (listData != null && listData.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listData.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listData[i].user_name + "</td>";
            body += "<td class='wrap-text'>" + listData[i].order_id + "</td>";
            body += "<td class='wrap-text'>" + listData[i].isdn_number + "</td>";
            if(listData[i].action_code == 13){
                body += "<td class='wrap-text'>" + Messages("Trả trước") + "</td>";
            } else if(listData[i].action_code == 12){
                body += "<td class='wrap-text'>" + Messages("Trả sau") + "</td>";
            } else {
                body += "<td class='wrap-text'>" + listData[i].action_code + "</td>";
            }
            body += "<td class='wrap-text'>" + listData[i].trans_amount + "</td>";
            body += "<td class='wrap-text'>" + listData[i].transaction_id + "</td>";
            body += "<td class='wrap-text'>" + listData[i].state + "</td>";
            body += "<td class='wrap-text'>" + listData[i].message + "</td>";
            body += "<td class='wrap-text'>" + moment.unix(listData[i].execute_time).format("DD/MM/YYYY HH:mm") + "</td>";

            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listLogsTable").find('tbody').html(body);

    pagingTable(datas.total, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    // console.log("total : " + total);
    // console.log("page : " + page);
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

    getLogConnectSim();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getLogConnectSim();
}