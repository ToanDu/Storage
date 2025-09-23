$(document).ready(function () {
    getListSubManage();
});

$(document).keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        getListSubManage();
    }
});

function onlickButtonSearch() {
    $("#page").val(1);
    getListSubManage();
}
function checkCondition(inputString) {
    var regex = /^[0-9]+$/;

    if (regex.test(inputString)) {
        return true;
    }
    return false;
}
function getListSubManage() {
    var body = new FormData();
    body.userId = childUserId;
    body.idNo = $("#idNo").val().trim();

    body.isdn = $("#isdn").val().trim();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.getListSubsOfChildUser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewSubsChildToTable(datas.content.data, startAt, body.page, body.pageSize);
                console.log(datas.content.data)
            }else{
                $("#listSubsChildUserTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listSubsChildUserTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            // getTotalContract(body.page, body.pageSize);
        }
    })
}
function resetTableSub() {
    var body = new FormData();
    body.userId = childUserId;

    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.getListSubsOfChildUser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewSubsChildToTable(datas.content.data, startAt, body.page, body.pageSize);
                console.log(datas.content.data)
            }else{
                $("#listSubsChildUserTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listSubsChildUserTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            // getTotalContract(body.page, body.pageSize);
        }
    })
}

function viewSubsChildToTable(datas, startAt, page, pageSize) {
    var body = "";
    var listSubs = datas.data;
    console.log(datas.data);
    if (listSubs != null && listSubs.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listSubs.length; i++) {
            // var r = jsRoutes.controllers.TelcoInvoiceController.invoiceOfContract(listAccountDTO[i].accountID);
            // var idTooltip = "tooltip_"+listSubscriber[i].isdn;
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listSubs[i].id_no + "</td>";
            body += "<td class='wrap-text'>" + listSubs[i].isdn + "</td>";
            body += "<td class='wrap-text'>" + moment.unix(listSubs[i].created_time).format("DD/MM/YYYY HH:mm")+ "</td>";
            body += "<td align='center'>";
            body += '<i class="bx bx-trash cursor-pointer" style="font-size: 20px;" title="Cập nhật" onclick="setDelSubOfChildUser(\''+listSubs[i].isdn+'\')"></i>';
            body += "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listSubsChildUserTable").find('tbody').html(body);
    console.log(datas);
    if(listSubs != null ){
        pagingTable(datas.total, page, pageSize);
    }
    else pagingTable(0, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
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

    getListSubManage();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListSubManage();
}

function resetFormSearch() {
    console.log("resetFormSearch");
    $("#isdn").val('');
    $("#idNo").val('');
    getListSubManage();
    resetTableSub();
}