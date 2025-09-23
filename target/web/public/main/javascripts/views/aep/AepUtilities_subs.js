var ACT_STATUS = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    s000: {value: 0, name: "Bình thường"},
    s010: {value: 10, name: "Chặn 1 chiều do hệ thống"},
    s020: {value: 20, name: "Chặn 2 chiều do hệ thống"},
    s030: {value: 30, name: "Chưa kích hoạt"},
    s100: {value: 100, name: "Chặn 1 chiều khách hàng yêu cầu"},
    s110: {value: 110, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 1 chiều do hệ thống"},
    s120: {value: 120, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 2 chiều do hệ thống"},
    s200: {value: 200, name: "Chặn 2 chiều khách hàng yêu cầu"},
    s210: {value: 210, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 1 chiều do hệ thống"},
    s220: {value: 220, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 2 chiều do hệ thống"}
};
var ACT_STATUS_SAU = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    s000: {value: 0, name: "Bình thường"},
    s010: {value: 10, name: "Chặn 1 chiều nợ cước"},
    s020: {value: 20, name: "Chặn 2 chiều nợ cước"},
    s030: {value: 30, name: "Chưa kích hoạt"},
    s100: {value: 100, name: "Chặn 1 chiều khách hàng yêu cầu"},
    s110: {value: 110, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước"},
    s120: {value: 120, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước"},
    s200: {value: 200, name: "Chặn 2 chiều khách hàng yêu cầu"},
    s210: {value: 210, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước"},
    s220: {value: 220, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước"}
};
var PAY_TYPE = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    SAU: {value: 1, name: "Trả sau"},
    TRUOC: {value: 2, name: "Trả trước"}
};

function onlickButtonSearchSubs() {
    $("#page").val(1);
    getListSubscriberCmp();
}

function getListSubscriberCmp() {
    document.getElementById("divPagingTable").style.display = 'flex';
    document.getElementById("check-all-subs").checked = false;
    $("#countCheckSubs").html("(0)");

    var body = new FormData();
    body.userId = userId;
    body.isdn = $('#isdn').val().trim();
    body.serial = $('#serialSim').val().trim();
    // body.idNo = $('#idNo').val();
    body.accountId = $('#accountId').val().trim();
    body.payType = $('#payType').val();
    body.productCode = $('#productCode').val();
    body.actStatus = $('#actStatus').val();
    body.promotionCode = $('#promotionCode').val();
    body.fromStaDatetime = $('#staDatetimeFrom').val();
    body.toStaDatetime = $('#staDatetimeTo').val();
    body.fromActiveDatetime = $('#activeDateFrom').val();
    body.toActiveDatetime = $('#activeDateTo').val();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    var dateNow = new Date();
    if(body.fromStaDatetime != undefined && body.fromStaDatetime != "" && body.toStaDatetime != undefined && body.toStaDatetime != ""){
        var dateMomentSta = moment(body.fromStaDatetime, "DD/MM/YYYY");
        var dateObjectSta = dateMomentSta.toDate();
        console.log(dateObjectSta.getTime());

        var dateMomentTo = moment(body.toStaDatetime, "DD/MM/YYYY");
        var dateObjectTo = dateMomentTo.toDate();
        console.log(dateObjectTo.getTime());

        if(dateObjectSta.getTime() >= dateObjectTo.getTime()){
            showNotification('danger', Messages("Bạn phải chọn ngày kích hoạt bắt đầu nhỏ hơn ngày kết thúc"));
            return;
        }
    }
    if(body.fromStaDatetime != undefined && body.fromStaDatetime != ""){
        var dateMomentSta = moment(body.fromStaDatetime, "DD/MM/YYYY");
        var dateObjectSta = dateMomentSta.toDate();
        if(dateObjectSta.getTime() > dateNow.getTime()){
            showNotification('danger', Messages("Bạn phải chọn ngày kích hoạt bắt đầu nhỏ hơn hoặc bằng ngày hiện tại"));
            return;
        }
    }

    if(body.fromActiveDatetime != undefined && body.fromActiveDatetime != "" && body.toActiveDatetime != undefined && body.toActiveDatetime != ""){
        var dateMomentActive = moment(body.fromActiveDatetime, "DD/MM/YYYY");
        var dateObjectActive = dateMomentActive.toDate();
        console.log(dateObjectActive.getTime());

        var dateMomentTo = moment(body.toActiveDatetime, "DD/MM/YYYY");
        var dateObjectTo = dateMomentTo.toDate();
        console.log(dateObjectTo.getTime());

        if(dateObjectActive.getTime() >= dateObjectTo.getTime()){
            showNotification('danger', Messages("Bạn phải chọn ngày đấu nối bắt đầu nhỏ hơn ngày kết thúc"));
            return;
        }
    }
    if(body.fromActiveDatetime != undefined && body.fromActiveDatetime != ""){
        var dateMomentActive = moment(body.fromActiveDatetime, "DD/MM/YYYY");
        var dateObjectActive = dateMomentActive.toDate();
        if(dateObjectActive.getTime() > dateNow.getTime()){
            showNotification('danger', Messages("Bạn phải chọn ngày đấu nối bắt đầu nhỏ hơn hoặc bằng ngày hiện tại"));
            return;
        }
    }

    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewDeviceToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    $("#listSubsTable").find('tbody').html("");
                    $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
                    showNotification('danger',datas.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listSubsTable").find('tbody').html("");
            $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewDeviceToTable(data, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = data.listSubscriber;
    if (listSubscriber!=null && listSubscriber.length > 0) {
        $("#notiNotDataSubs").html("");
        // $("#count-tb").html(listSubscriber.length);
        for (var i = 0; i < listSubscriber.length; i++) {
            var idTooltip = "tooltip_"+listSubscriber[i].isdn;
            body += "<tr>";
            body += "<th><input class='form-check-input check-sub' type='checkbox' value='"+listSubscriber[i].serial+"' sub='"+listSubscriber[i].isdn+"' onchange='chooseOneSub()'></th>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td>" + '<a class="tb cursor-pointer" >'+ listSubscriber[i].isdn +'</a>' + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].subId + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].productCode + "</td>";
            // body += "<td class='wrap-text'>" + listSubscriber[i].accountId + "</td>";
            // body += "<td class='wrap-text'>" + listSubscriber[i].custId + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].serial + "</td>";
            body += "<td class='wrap-text'>" + getStatusByCode(listSubscriber[i].actStatus, listSubscriber[i].payType) + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].staDatetime.length > 0 ? moment(moment(listSubscriber[i].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].activeDatetime.length > 0 ? moment(moment(listSubscriber[i].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
            body += "<td class='wrap-text'>" + getPayTypeByCode(listSubscriber[i].payType) + "</td>";
            body += "<td>" +
                '<a class="btn-tb cursor-pointer" id="boton" onclick="createOneDevice(\''+listSubscriber[i].isdn+'\', \''+listSubscriber[i].serial+'\')">'+Messages("Tạo thiết bị")+'</a>' +
                "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
    }
    $("#listSubsTable").find('tbody').html(body);

    pagingTable(data.countSubscriber, page, pageSize);
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

    getListSubscriberCmp();

    document.getElementById("check-all-subs").checked = false;
    $("#countCheckSubs").html("(0)");
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListSubscriberCmp();

    document.getElementById("check-all-subs").checked = false;
    $("#countCheckSubs").html("(0)");
}

function resetFormSearch() {
    console.log("resetFormSearch");
    // $("#idNo").val('');
    $("#isdn").val('');
    $("#serialSim").val('');
    $("#accountId").val('');
    $("#actStatus").val("");
    $("#productCode").val("");
    $("#payType").val("");
    $("#staDatetimeFrom").val("");
    $("#staDatetimeTo").val("");
    $("#activeDateFrom").val("");
    $("#activeDateTo").val("");
}

function getStatusByCode(code, type) {
    // console.log(code, type);
    code = parseInt(code);
    type = parseInt(type);

    if(type == PAY_TYPE.TRUOC.value){
        if(code == ACT_STATUS.s000.value){
            return ACT_STATUS.s000.name;
        } else if(code == ACT_STATUS.s010.value){
            return ACT_STATUS.s010.name;
        } else if(code == ACT_STATUS.s020.value){
            return ACT_STATUS.s020.name;
        } else if(code == ACT_STATUS.s030.value){
            return ACT_STATUS.s030.name;
        } else if(code == ACT_STATUS.s100.value){
            return ACT_STATUS.s100.name;
        } else if(code == ACT_STATUS.s110.value){
            return ACT_STATUS.s110.name;
        } else if(code == ACT_STATUS.s120.value){
            return ACT_STATUS.s120.name;
        } else if(code == ACT_STATUS.s200.value){
            return ACT_STATUS.s200.name;
        } else if(code == ACT_STATUS.s220.value){
            return ACT_STATUS.s220.name;
        } else if(code == ACT_STATUS.s210.value){
            return ACT_STATUS.s210.name;
        } else {
            return ACT_STATUS.UNKNOWN.name;
        }
    } else if(type == PAY_TYPE.SAU.value){
        if(code == ACT_STATUS_SAU.s000.value){
            return ACT_STATUS_SAU.s000.name;
        } else if(code == ACT_STATUS_SAU.s010.value){
            return ACT_STATUS_SAU.s010.name;
        } else if(code == ACT_STATUS_SAU.s020.value){
            return ACT_STATUS_SAU.s020.name;
        } else if(code == ACT_STATUS.s030.value){
            return ACT_STATUS.s030.name;
        } else if(code == ACT_STATUS_SAU.s100.value){
            return ACT_STATUS_SAU.s100.name;
        } else if(code == ACT_STATUS_SAU.s110.value){
            return ACT_STATUS_SAU.s110.name;
        } else if(code == ACT_STATUS_SAU.s120.value){
            return ACT_STATUS_SAU.s120.name;
        } else if(code == ACT_STATUS_SAU.s200.value){
            return ACT_STATUS_SAU.s200.name;
        } else if(code == ACT_STATUS_SAU.s220.value){
            return ACT_STATUS_SAU.s220.name;
        } else if(code == ACT_STATUS_SAU.s210.value){
            return ACT_STATUS_SAU.s210.name;
        } else {
            return ACT_STATUS_SAU.UNKNOWN.name;
        }
    } else {
        return ACT_STATUS.UNKNOWN.name;
    }
}

function getPayTypeByCode(code) {
    code = parseInt(code);

    if(code == PAY_TYPE.SAU.value){
        return PAY_TYPE.SAU.name;
    } else if(code == PAY_TYPE.TRUOC.value){
        return PAY_TYPE.TRUOC.name;
    } else {
        return PAY_TYPE.UNKNOWN.name;
    }
}

function checkAllSubs(el) {
    var listCheckboxSubs = document.getElementsByClassName("check-sub");
    for(var i=0; i<listCheckboxSubs.length; i++){
        if(el.checked){
            listCheckboxSubs[i].checked = true;
        } else {
            listCheckboxSubs[i].checked = false;
        }
    }

    countCheckSubs();
}
function chooseOneSub() {
    var listCheckboxSubs = document.getElementsByClassName("check-sub");
    var countNotCheck = 0;

    for(var i=0; i<listCheckboxSubs.length; i++){
        if(!listCheckboxSubs[i].checked){
            countNotCheck++;
        }
    }

    if(countNotCheck == 0){
        document.getElementById("check-all-subs").checked = true;
    } else {
        document.getElementById("check-all-subs").checked = false;
    }

    countCheckSubs();
}
function countCheckSubs() {
    var listCheckboxSubs = document.getElementsByClassName("check-sub");
    var countCheck = 0;

    for(var i=0; i<listCheckboxSubs.length; i++){
        if(listCheckboxSubs[i].checked){
            countCheck++;
        }
    }

    $("#countCheckSubs").html("("+countCheck+")");
}