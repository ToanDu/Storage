function showHistoryListIsdn(isdn, serial) {
    $("#isdnHistory").val(isdn);
    $("#serialHistory").val(serial);
    $('#pageHistoryIsdn').val(1);
    var now = new Date();
    $("#fromDateHistory").val(moment.unix(now.getTime()/1000-6*24*60*60).format("DD/MM/YYYY"));
    $("#toDateHistory").val(moment.unix(now.getTime()/1000).format("DD/MM/YYYY"));

    getHistoryIsdn();

    $("#listHistoryModal").modal('show');
}

function searchHistoryIsdn() {
    var startTime = $("#fromDateHistory").val();
    var endTime = $("#toDateHistory").val();
    if(startTime.length > 0 && endTime.length > 0){
        var dateNow = new Date();
        var strNow = moment.unix(dateNow.getTime()/1000).format("DD/MM/YYYY");
        var nowMomentObject = moment(strNow, "DD/MM/YYYY");
        var nowObject = nowMomentObject.toDate();

        var startMomentObject = moment(startTime, "DD/MM/YYYY");
        var startObject = startMomentObject.toDate();
        if(startObject.getTime() > nowObject.getTime()){
            showNotification('danger',Messages("Ngày bắt đầu không được lớn hơn ngày hiện tại"));
            return;
        }

        var endMomentObject = moment(endTime, "DD/MM/YYYY");
        var endObject = endMomentObject.toDate();
        if(startObject.getTime() > endObject.getTime()){
            showNotification('danger',Messages("Ngày bắt đầu không được lớn hơn ngày kết thúc"));
            return;
        }
    } else {
        showNotification('danger',Messages("Bạn chưa chọn thời gian"));
        return;
    }

    $('#pageHistoryIsdn').val(1);
    getHistoryIsdn();
}

function getHistoryIsdn() {
    StartProcess();
    var page = $("#pageHistoryIsdn").val();
    var pageSize = $("#pageSizeHistoryIsdn").val();
    var offset = (page-1)*pageSize;
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/history?userId='+userId+'&isdn='+$("#isdnHistory").val()+'&serial='+$("#serialHistory").val()+
        '&from='+$("#fromDateHistory").val()+'&to='+$("#toDateHistory").val()+
        '&limit='+pageSize+'&offset='+offset;
    console.log(formData);
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.data != null){
                var startAt = (page - 1)*pageSize;
                viewHistoryIsdnToTable(datas.content.data, startAt, page, pageSize);
            } else {
                $("#listHistoryIsdnTable").find('tbody').html("");
                $("#notiNotHistoryIsdn").html("Không có thông tin để hiển thị");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listHistoryIsdnTable").find('tbody').html("");
            $("#notiNotHistoryIsdn").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewHistoryIsdnToTable(data, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = data.data;
    if (listSubscriber!=null && listSubscriber.length > 0) {
        $("#notiNotHistoryIsdn").html("");
        for (var i = 0; i < listSubscriber.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td>" + listSubscriber[i].isdn + "</td>";
            body += "<td class='wrap-text'>" + moment(moment(listSubscriber[i].date, "YYYY-MM-DD'T'HH:mm:ss'Z'")).format('DD/MM/YYYY HH:mm:ss') + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].address + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].lat +', '+listSubscriber[i].long + "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotHistoryIsdn").html("Không có thông tin để hiển thị");
    }
    $("#listHistoryIsdnTable").find('tbody').html(body);

    pagingTableHistoryIsdn(data.total, page, pageSize);
}

//paging
function pagingTableHistoryIsdn(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchHistoryIsdn(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchHistoryIsdn('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchHistoryIsdn('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearchHistoryIsdn('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchHistoryIsdn('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchHistoryIsdn('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchHistoryIsdn('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTableHistoryIsdn").html(paging);
}

function applySearchHistoryIsdn(page, pageSize) {
    $('#pageHistoryIsdn').val(page);
    $('#pageSizeHistoryIsdn').val(pageSize);

    getHistoryIsdn()
}

function ApplyFilterHistoryIsdn(page, pageSize) {
    $("#countPageSizeHistoryIsdn").html(pageSize);
    $('#pageHistoryIsdn').val(page);
    $('#pageSizeHistoryIsdn').val(pageSize);

    getHistoryIsdn()
}