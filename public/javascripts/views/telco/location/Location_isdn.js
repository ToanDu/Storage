var PAY_TYPE = {
    UNKNOWN: {value: 0, name: ""},
    SAU: {value: 1, name: "Trả sau"},
    TRUOC: {value: 2, name: "Trả trước"}
};

var cellIdCurrent;
var lacCurrent;
function clickCellMarker(id, lac, name, total) {
    console.log(id, lac, name);
    $("#countIsdnCell").html(total != null ? total : "");
    $("#addressIsdnCell").html(name);
    $("#isdnSearch").val("");
    $("#page").val(1);
    cellIdCurrent =id;
    lacCurrent = lac;
    getIsdnListWitdCellAndPaging();

}

function getIsdnListWitdCellAndPaging() {
    StartProcess();
    var page = $("#page").val();
    var pageSize = $("#pageSize").val();
    var offset = (page-1)*pageSize;
    var isdnSearch = $("#isdnSearch").val().trim();
    var formData = new FormData();
    if(isdnSearch.length > 0){
        formData.param='/api/telco/subscriber/location?userId='+userId+'&cellId='+cellIdCurrent+'&lac='+lacCurrent+'&limit='+pageSize+'&offset='+offset+'&isdn='+isdnSearch;
    } else {
        formData.param='/api/telco/subscriber/location?userId='+userId+'&cellId='+cellIdCurrent+'&lac='+lacCurrent+'&limit='+pageSize+'&offset='+offset;
    }
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
                viewIsdnsToTable(datas.content.data, startAt, page, pageSize);
            } else {
                $("#listIsdnInCellTable").find('tbody').html("");
                $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listIsdnInCellTable").find('tbody').html("");
            $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            $("#listIsdnCellModal").modal('show');
            FinishProcess();
        }
    })
}

function viewIsdnsToTable(data, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = data.data;
    if (listSubscriber!=null && listSubscriber.length > 0) {
        $("#notiNotDataSubs").html("");
        for (var i = 0; i < listSubscriber.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td>" + listSubscriber[i].isdn + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].productCode + "</td>";
            body += "<td class='wrap-text'>" + getStatusByCode(listSubscriber[i].actStatus, listSubscriber[i].payType) + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].balanceInfo != null ? listSubscriber[i].balanceInfo.data : "") + "</td>";
            body += "<td align='center'>";
            body += '<a><img class="cursor-pointer" src="'+mapIcon+'" height="100%" alt="" onclick="showHistoryMapIsdn(\''+listSubscriber[i].isdn+'\', \''+listSubscriber[i].serial+'\')"></a>';
            body += '<a><img class="cursor-pointer" src="'+infoIcon+'" height="100%" alt="" onclick="showHistoryListIsdn(\''+listSubscriber[i].isdn+'\', \''+listSubscriber[i].serial+'\')" style="margin-left: 10px;"></a>';
            body += "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
    }
    $("#listIsdnInCellTable").find('tbody').html(body);

    pagingTable(data.total, page, pageSize);
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

    //an phan trang neu so ban ghi it hon 1 trang
    // if(total <= pageSize){
    //     document.getElementById("divPagingTable").style.display = 'none';
    // } else {
    //     document.getElementById("divPagingTable").style.display = 'block';
    // }
}

function applySearch(page, pageSize) {
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getIsdnListWitdCellAndPaging(cellIdCurrent, lacCurrent);
}

function ApplyFilter(page, pageSize) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getIsdnListWitdCellAndPaging(cellIdCurrent, lacCurrent);
}

var filterSearchIsdn = document.getElementById("isdnSearch");
filterSearchIsdn.addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        $("#page").val(1);
        getIsdnListWitdCellAndPaging()
    }
});