/**
 * Created by vtk-anhlt166 on 10/26/22.
 */


var ACT_STATUS = {
    UNKNOWN: {value: -1, name: Messages("subscriber.status.unknown")},
    s000: {value: 0, name: Messages("subscriber.status.normal")},
    s010: {value: 10, name: Messages("subscriber.status.block1WaySystem")},
    s020: {value: 20, name: Messages("subscriber.status.block2WaySystem")},
    s030: {value: 30, name: Messages("subscriber.status.notActivated")},
    s100: {value: 100, name: Messages("subscriber.status.block1WayCustomer")},
    s110: {value: 110, name: Messages("subscriber.status.block1WayCustomer1WaySystem")},
    s120: {value: 120, name: Messages("subscriber.status.block1WayCustomer2WaySystem")},
    s200: {value: 200, name: Messages("subscriber.status.block2WayCustomer")},
    s210: {value: 210, name: Messages("subscriber.status.block2WayCustomer1WaySystem")},
    s220: {value: 220, name: Messages("subscriber.status.block2WayCustomer2WaySystem")}
};
var ACT_STATUS_SAU = {
    UNKNOWN: {value: -1, name: Messages("subscriber.status.unknown")},
    s000: {value: 0, name: Messages("subscriber.status.normal")},
    s010: {value: 10, name: Messages("subscriber.status.block1WayDebt")},
    s020: {value: 20, name: Messages("subscriber.status.block2WayDebt")},
    s030: {value: 30, name: Messages("subscriber.status.notActivated")},
    s100: {value: 100, name: Messages("subscriber.status.block1WayCustomer")},
    s110: {value: 110, name: Messages("subscriber.status.block1WayCustomer1WayDebt")},
    s120: {value: 120, name: Messages("subscriber.status.block1WayCustomer2WayDebt")},
    s200: {value: 200, name: Messages("subscriber.status.block2WayCustomer")},
    s210: {value: 210, name: Messages("subscriber.status.block2WayCustomer1WayDebt")},
    s220: {value: 220, name: Messages("subscriber.status.block2WayCustomer2WayDebt")}
};
var PAY_TYPE = {
    UNKNOWN: {value: -1, name: Messages("subscriber.status.unknown")},
    SAU: {value: 1, name: Messages("subscriber.postpaid")},
    TRUOC: {value: 2, name: Messages("subscriber.prepaid")}
};
$(document).ready(function () {
    if(view_sub == "true"){
        getListSubscriber();
    }
});

$(document).keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        if(view_sub == "true"){
            onlickButtonSearch();
        }
    }
});

var listCheckSubs = new Array;
var listCheckSerial = new Array;
function onlickButtonSearch() {
    $("#page").val(1);

    var subsText = $('#isdn').val();
    var listSubs = subsText.split(",");

    var serialText = $('#serialSim').val();
    var listSerial = serialText.split(",");

    listCheckSubs = [];
    if(listSubs.length > 0){
        for(var s=0; s<listSubs.length; s++){
            var sub = parseFloat(listSubs[s].trim().replace(/\D/g,''));
            // var sub = listSubs[s].replace(/\D/g,'').trim();
            if(sub > 0){
                if(!listCheckSubs.includes(sub.toString())){
                    listCheckSubs.push(sub.toString());
                }
            }
        }
    }
    console.log(listCheckSubs);
    listCheckSerial = [];
    if(listSerial.length > 0){
        for(var i=0; i<listSerial.length; i++){
            var serial = listSerial[i].trim().replace(/\D/g,'');
            if(serial.length > 0){
                if(!listCheckSerial.includes(serial)){
                    listCheckSerial.push(serial);
                }
            }
        }
    }

    if(listCheckSubs.length <= 1 && listCheckSerial.length <= 1){
        getListSubscriber();
    } else {
        if(listCheckSubs.length > 1 && listCheckSerial.length <= 1){
            if(listCheckSubs.length <= 100000){
                getListByFileSubsVht();
            } else {
                showNotification('danger',Messages("subscriber.error.maxPhoneNumbers"));
                return;
            }
        } else if(listCheckSubs.length <= 1 && listCheckSerial.length > 1){
            if(listCheckSerial.length <= 100000){
                getListByFileSubsVht()
            } else {
                showNotification('danger',Messages("subscriber.error.maxSerials"));
                return;
            }
        } else {
            showNotification('danger',Messages("subscriber.error.combinedSearch"));
            return;
        }
    }

}

function getListSubscriber() {
    document.getElementById("divPagingTable").style.display = 'flex';

    var body = new FormData();
    body.userId = userId;
    body.isdn = listCheckSubs[0] != null ? listCheckSubs[0].trim() : $('#isdn').val().trim();
    body.serial = listCheckSerial[0] != null ? listCheckSerial[0].trim() : $('#serialSim').val().trim();
    body.idNo = $('#idNo').val();
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
            showNotification('danger', Messages("subscriber.error.activationDateRange"));
            return;
        }
    }
    if(body.fromStaDatetime != undefined && body.fromStaDatetime != ""){
        var dateMomentSta = moment(body.fromStaDatetime, "DD/MM/YYYY");
        var dateObjectSta = dateMomentSta.toDate();
        if(dateObjectSta.getTime() > dateNow.getTime()){
            showNotification('danger', Messages("subscriber.error.activationDateRange"));
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
            showNotification('danger', Messages("subscriber.error.connectionDateRange"));
            return;
        }
    }
    if(body.fromActiveDatetime != undefined && body.fromActiveDatetime != ""){
        var dateMomentActive = moment(body.fromActiveDatetime, "DD/MM/YYYY");
        var dateObjectActive = dateMomentActive.toDate();
        if(dateObjectActive.getTime() > dateNow.getTime()){
            showNotification('danger', Messages("subscriber.error.connectionDateRange"));
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
                $("#count-tb").html(0);
                $("#listSubsTable").find('tbody').html("");
                $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#count-tb").html(0);
            $("#listSubsTable").find('tbody').html("");
            $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
        },
        complete: function (){
            FinishProcess();
            // getTotalSubscriber(body.page, body.pageSize);
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
            var r = jsRoutes.controllers.TelcoSubscriberController.subscriberDetail(listSubscriber[i].isdn);
            var idTooltip = "tooltip_"+listSubscriber[i].isdn;
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            if(view_detail_sub == "true"){
                body += "<td>" + '<a class="tb cursor-pointer" onclick="showInfoSubscriber(\''+listSubscriber[i].isdn+'\', \''+listSubscriber[i].promotionCode+'\', \''+listSubscriber[i].serial+'\', \''+listSubscriber[i].payType+'\', \''+listSubscriber[i].actStatus+'\', \''+listSubscriber[i].staDatetime+'\', \''+listSubscriber[i].activeDatetime+'\', \''+listSubscriber[i].productCode+'\')">'+ listSubscriber[i].isdn +'</a>' + "</td>";
            } else {
                body += "<td>" + '<a class="tb cursor-pointer" >'+ listSubscriber[i].isdn +'</a>' + "</td>";
            }
            body += "<td class='wrap-text'>" + listSubscriber[i].subId + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].productCode + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].promotionCode + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].accountId + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].custId + "</td>";
            body += "<td class='wrap-text'>" + listSubscriber[i].serial + "</td>";
            body += "<td class='wrap-text'>" + getStatusByCode(listSubscriber[i].actStatus, listSubscriber[i].payType) + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].staDatetime.length > 0 ? moment(moment(listSubscriber[i].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
            body += "<td class='wrap-text'>" + (listSubscriber[i].activeDatetime.length > 0 ? moment(moment(listSubscriber[i].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
            body += "<td class='wrap-text'>" + getPayTypeByCode(listSubscriber[i].payType) + "</td>";
//            if(view_data_sub == "true"){
//                body += "<td>" +
//                    '<a class="btn-tb cursor-pointer" id="boton" onclick="showTooltips(\''+idTooltip+'\', \''+listSubscriber[i].isdn+'\')">'+Messages("Kiểm tra LL")+'</a>' +
//                    '<div class="tooltip" id="'+idTooltip+'">' +
//                    '<div class="row">' +
//                    '<div class="col-sm-6">' +
//                    '<span style="font-size: 20px; color: #EA0029;" id="infoUsedBalance_'+listSubscriber[i].isdn+'"></span><br>' +
//                    '<span class="text-white" style="font-size: 16px;">'+Messages("Lưu lượng đã sử dụng")+'</span><hr style="border: 1px solid white;">' +
//                    '<span style="font-size: 20px; color: #FBCCD6;" id="infoRemainBalance_'+listSubscriber[i].isdn+'"></span><br>' +
//                    '<span class="text-white" style="font-size: 16px;">'+Messages("Lưu lượng còn lại")+'</span><hr>' +
//                    '<a class="cursor-pointer" onclick="closeTooltip()" style="position: absolute;top: 0px;right: 5px;font-size: 20px;color: white;"><i class="bx bx-x"></i></a>' +
//                    '</div> '+
//                    '<div class="col-sm-6" style="padding: 0px;">' +
//                    '<div id="chartInfoBalance_'+listSubscriber[i].isdn+'" style="width: 100%;"></div>'+
//                    '</div> '+
//
//                    '</div> '+
//
//                    '</div>' +
//                    "</td>";
//            }
            body+= '<td><a class="btn-tb cursor-pointer" id="button" onclick="viewInfoDataAccount( \''+userId+'\', \''+listSubscriber[i].isdn+'\',\''+listSubscriber[i].serial+'\')">'+Messages("subscriber.viewDetail")+'</a></td>';
            body += "</tr>";
        }
    } else {
        $("#count-tb").html(0);
        $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
    }
    $("#listSubsTable").find('tbody').html(body);

    $("#soThueBao").val(data.countSubscriber);
    $("#count-tb").html(data.countSubscriber);
    pagingTable(data.countSubscriber, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("subscriber.totalRecords")+" "+total+" "+Messages("subscriber.records")+'</label>' +
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

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    if(listCheckSubs.length <= 1 && listCheckSerial.length <= 1){
        getListSubscriber();
    } else {
        if(listCheckSubs.length > 1 && listCheckSerial.length <= 1){
            if(listCheckSubs.length <= 10000){
                getListByFileSubsVht();
            } else {
                showNotification('danger',Messages("subscriber.error.max10kPhoneNumbers"));
                return;
            }
        } else if(listCheckSubs.length <= 1 && listCheckSerial.length > 1){
            if(listCheckSerial.length <= 10000){
                getListByFileSubsVht();
            } else {
                showNotification('danger',Messages("subscriber.error.max10kSerials"));
                return;
            }
        } else {
            showNotification('danger',Messages("subscriber.error.combinedSearch"));
            return;
        }
    }
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    if(listCheckSubs.length <= 1 && listCheckSerial.length <= 1){
        getListSubscriber();
    } else {
        if(listCheckSubs.length > 1 && listCheckSerial.length <= 1){
            if(listCheckSubs.length <= 10000){
                getListByFileSubsVht();
            } else {
                showNotification('danger',Messages("subscriber.error.max10kPhoneNumbers"));
                return;
            }
        } else if(listCheckSubs.length <= 1 && listCheckSerial.length > 1){
            if(listCheckSerial.length <= 10000){
                getListByFileSubsVht();
            } else {
                showNotification('danger',Messages("subscriber.error.max10kSerials"));
                return;
            }
        } else {
            showNotification('danger',Messages("subscriber.error.combinedSearch"));
            return;
        }
    }
}

// function getTotalSubscriber(page, pageSize) {
//     var body = new FormData();
//     body.idNo = gpkd;
//     body.isdn = $('#isdn').val();
//     body.serial = $('#serialSim').val();
//     body.accountId = $('#accountId').val();
//     body.payType = $('#payType').val();
//     body.productCode = $('#productCode').val();
//     body.actStatus = $('#actStatus').val();
//     body.promotionCode = $('#promotionCode').val();
//     body.fromStaDatetime = $('#staDatetimeFrom').val();
//     body.toStaDatetime = $('#staDatetimeTo').val();
//     body.fromActiveDatetime = $('#activeDateFrom').val();
//     body.toActiveDatetime = $('#activeDateTo').val();
//     console.log(body);
//     var r = jsRoutes.controllers.TelcoSubscriberController.getTotalSubscriber();
//     $.ajax({
//         type: r.type,
//         data: JSON.stringify(body),
//         contentType: "application/json; charset=utf-8",
//         url: r.url,
//         success: function(datas){
//             console.log(datas);
//             if(datas.success){
//                 $("#count-tb").html(datas.content);
//
//                 pagingTable(datas.content, page, pageSize);
//             }
//         },
//         complete: function (){
//             FinishProcess();
//         }
//     })
// }

function resetFormSearch() {
    console.log("resetFormSearch");
    // $("#numberSubs").tagsinput('removeAll');
    // $("#serialSim").tagsinput('removeAll');
    // $("#accountId").tagsinput('removeAll');
    $("#idNo").val("");
    $("#isdn").val("");
    $("#serialSim").val("");
    $("#accountId").val("");
    $("#actStatus").val("");
    $("#productCode").val("");
    $("#payType").val("");
    $("#staDatetimeFrom").val("");
    $("#staDatetimeTo").val("");
    $("#activeDateFrom").val("");
    $("#activeDateTo").val("");
    onlickButtonSearch();
}

function getStatusByCode(code, type) {
    console.log(code, type);
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
        } else if(code == ACT_STATUS.s030.value) {
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

var tooltip;
var open = false;
function closeTooltip () {
    // Oculto el tooltip.
    tooltip.classList.remove('abierto');
    open = false;

    console.log('Click en cualquier parte y oculto el Tooltip');
}

function showTooltips(tool, isdn) {
    if(open){
        closeTooltip();
    }
    // console.log(tool, isdn);
    var remain = 0;
    var used = 0;

    var body = new FormData();
    body.isdn = isdn;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getKttkAndKtmi();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getKttkAndKtmi', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.success && datas.content != null){
                remain = datas.content.remainBalance != null ? datas.content.remainBalance : 0;
                used = datas.content.usedBalance != null ? datas.content.usedBalance : 0;
            }
        },
        complete: function (){
            FinishProcess();

            $("#infoUsedBalance_"+isdn).html(used + " mb");
            $("#infoRemainBalance_"+isdn).html(remain + " mb");

            //drawChart(isdn, remain, used);

            tooltip = document.getElementById(tool);  // El tooltip.
            tooltip.classList.add('abierto');
            open = true;
        }
    });
}

// function drawChart(isdn, remain, used) {
//     if(isdn != null && isdn != undefined){
//         var data = google.visualization.arrayToDataTable([
//             ['Task', 'Data per'],
//             ['Lưu lượng còn lại', remain],
//             ['Lưu lượng đã sử dụng', used]
//         ]);
//
//         var options = {
//             pieHole: 0.5,
//             pieSliceTextStyle: {
//                 color: 'white'
//             },
//             colors: ['#EA0029', '#FBCCD6'],
//             legend: 'none',
//             backgroundColor: 'transparent',
//             width: 200,
//
//         };
//
//         var chart = new google.visualization.PieChart(document.getElementById('chartInfoBalance_'+isdn));
//         chart.draw(data, options);
//     }
//
// }

function choosePayType(el) {
    console.log(el);
    if(el.value == 1){
        var sellect =
            '<option value="" selected>'+Messages("subscriber.status.choose")+'</option>'+
            '<option value="000">'+Messages("subscriber.status.normal")+'</option>'+
            '<option value="020">'+Messages("subscriber.status.block_2way_debt")+'</option>'+
            '<option value="010">'+Messages("subscriber.status.block_1way_debt")+'</option>'+
            '<option value="030">'+Messages("subscriber.status.not_activated")+'</option>'+
            '<option value="100">'+Messages("subscriber.status.block_1way_customer")+'</option>'+
            '<option value="110">'+Messages("subscriber.status.block_1way_customer_1way_debt")+'</option>'+
            '<option value="120">'+Messages("subscriber.status.block_1way_customer_2way_debt")+'</option>'+
            '<option value="200">'+Messages("subscriber.status.block_2way_customer")+'</option>'+
            '<option value="220">'+Messages("subscriber.status.block_2way_customer_2way_debt")+'</option>'+
            '<option value="210">'+Messages("subscriber.status.block_2way_customer_1way_debt")+'</option>';
        $("#actStatus").html(sellect);
    } else if(el.value == 2){
        var sellect =
            '<option value="" selected>'+Messages("subscriber.status.choose")+'</option>'+
            '<option value="000">'+Messages("subscriber.status.normal")+'</option>'+
            '<option value="020">'+Messages("subscriber.status.block2WaySystem")+'</option>'+
            '<option value="010">'+Messages("subscriber.status.block1WaySystem")+'</option>'+
            '<option value="030">'+Messages("subscriber.status.not_activated")+'</option>'+
            '<option value="100">'+Messages("subscriber.status.block_1way_customer")+'</option>'+
            '<option value="110">'+Messages("subscriber.status.block_1way_customer_1way_system")+'</option>'+
            '<option value="120">'+Messages("subscriber.status.block_1way_customer_2way_system")+'</option>'+
            '<option value="200">'+Messages("subscriber.status.block_2way_customer")+'</option>'+
            '<option value="220">'+Messages("subscriber.status.block_2way_customer_2way_system")+'</option>'+
            '<option value="210">'+Messages("subscriber.status.block_2way_customer_1way_system")+'</option>';
        $("#actStatus").html(sellect);
    } else {
        $("#actStatus").html('<option value="" selected>'+Messages("subscriber.status.chooseServiceType")+'</option>');
    }
}