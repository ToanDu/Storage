/**
 * Created by vtk-anhlt166 on 1/4/23.
 */
function getListHistoryRechargeByAction() {
    var body = new FormData();
    body.action = "10";
    body.page = $("#pageHistoryRecharge").val();
    body.pageSize = $("#pageSizeHistoryRecharge").val();
    body.userId = userId;
    console.log(body);

    var r = jsRoutes.controllers.TelcoUtilitiesController.getListOrderIdByAction();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getListHistoryRechargeByAction', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.success){
                viewHistoryRechargeToTable(datas.content, body.page, body.pageSize);
            } else {

            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewHistoryRechargeToTable(datas, page, pageSize) {
    var startAt = (page-1)*pageSize;
    var data = datas.data;
    var body = "";
    if (data != null && data.length > 0) {
        $("#notiNotDataHistory").html("");
        for (var i = 0; i < data.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + data[i].order_id + "</td>";
            body += "<td class='wrap-text'>" + data[i].isdn_number + "</td>";
            body += "<td class='wrap-text'>" + data[i].description + "</td>";
            body += "<td class='wrap-text'>" + data[i].units_amount + "</td>";
            body += "<td class='wrap-text'>" + data[i].trans_amount + "</td>";
            body += "<td class='wrap-text'>" + data[i].state + "</td>";
            body += "<td class='wrap-text'>" + data[i].message + "</td>";
            body += "<td class='wrap-text'>" + moment.unix(data[i].execute_time).format("DD/MM/YYYY HH:mm") + "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotDataHistory").html("Không có thông tin để hiển thị");
    }
    $("#listHistoryRechargeTable").find('tbody').html(body);

    pagingTableHistoryRecharge(datas.total, page, pageSize);
}

//paging
function pagingTableHistoryRecharge(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+pageSize+')"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-1)+','+pageSize+')"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-item)+','+pageSize+')">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+parseInt(page)+','+pageSize+')">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+item)+','+pageSize+')">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+1)+','+pageSize+')"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+pageSize+')"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTableHistoryRecharge").html(paging);

    //an phan trang neu so ban ghi it hon 1 trang
    // if(total <= pageSize){
    //     document.getElementById("divPagingTableHistoryRecharge").style.display = 'none';
    // } else {
    //     document.getElementById("divPagingTableHistoryRecharge").style.display = 'block';
    // }
}

function applySearch(page, pageSize) {
    console.log(page, pageSize);

    $('[name=pageHistoryRecharge]').val(page);
    $('[name=pageSizeHistoryRecharge]').val(pageSize);

    getListHistoryRechargeByAction();
}