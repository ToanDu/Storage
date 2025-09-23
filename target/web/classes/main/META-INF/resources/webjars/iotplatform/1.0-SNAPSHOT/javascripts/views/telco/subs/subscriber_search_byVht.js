/**
 * Created by vtk-anhlt166 on 2/23/23.
 */
function getListByFileSubsVht() {
    var body = new FormData();
    body.userId = userId;
    body.isdn = $('#isdn').val().trim();
    body.serial = $('#serialSim').val().trim();
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
    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getListSubsByBeVht();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                var startAt = (body.page - 1)*body.pageSize;
                viewDataSearchFile(datas.content, startAt, body.page, body.pageSize);
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
        }
    })
}

// function getListByFileSerialVht() {
//     var body = new FormData();
//     body.idNo = $('#gpkd').val();
//     body.isdn = $('#isdn').val().trim();
//     body.serial = listCheckSerial.toString();
//     body.accountId = $('#accountId').val().trim();
//     body.payType = $('#payType').val();
//     body.productCode = $('#productCode').val();
//     body.actStatus = $('#actStatus').val();
//     body.promotionCode = $('#promotionCode').val();
//     body.fromStaDatetime = $('#staDatetimeFrom').val();
//     body.toStaDatetime = $('#staDatetimeTo').val();
//     body.fromActiveDatetime = $('#activeDateFrom').val();
//     body.toActiveDatetime = $('#activeDateTo').val();
//     body.page = $("#page").val();
//     body.pageSize = $("#pageSize").val();
//     console.log(body);
//     StartProcess();
//     var r = jsRoutes.controllers.TelcoSubscriberController.getListSubsByBeVht();
//     $.ajax({
//         type: r.type,
//         data: JSON.stringify(body),
//         contentType: "application/json; charset=utf-8",
//         url: r.url,
//         success: function(datas){
//             console.log(datas);
//             if(datas.content != null){
//                 var startAt = (body.page - 1)*body.pageSize;
//                 viewDataSearchFile(datas.content, startAt, body.page, body.pageSize);
//             }else{
//                 $("#count-tb").html(0);
//                 $("#listSubsTable").find('tbody').html("");
//                 $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
//                 showNotification('danger',datas.errorString);
//             }
//         },
//         error: function (xhr) {
//             console.log(xhr);
//             showNotification('danger',Messages("connection.failed"));
//             $("#count-tb").html(0);
//             $("#listSubsTable").find('tbody').html("");
//             $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
//         },
//         complete: function (){
//             FinishProcess();
//         }
//     })
// }

function viewDataSearchFile(datas, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = datas.data;
    if (listSubscriber != null && listSubscriber.length > 0) {
        $("#notiNotDataSubs").html("");
        // $("#count-tb").html(listSubscriber.length);
        for (var i = 0; i < listSubscriber.length; i++) {
            var r = jsRoutes.controllers.TelcoSubscriberController.subscriberDetail(listSubscriber[i].isdn);
            var idTooltip = "tooltip_"+listSubscriber[i].isdn;
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td>" + '<a class="tb cursor-pointer" onclick="showInfoSubscriber(\''+listSubscriber[i].isdn+'\', \''+listSubscriber[i].promotionCode+'\', \''+listSubscriber[i].serial+'\', \''+listSubscriber[i].payType+'\', \''+listSubscriber[i].actStatus+'\', \''+listSubscriber[i].staDatetime+'\', \''+listSubscriber[i].activeDatetime+'\', \''+listSubscriber[i].productCode+'\')">'+ listSubscriber[i].isdn +'</a>' + "</td>";
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
            body += "<td>" +
                '<a class="btn-tb cursor-pointer" id="boton" onclick="showTooltips(\''+idTooltip+'\', \''+listSubscriber[i].isdn+'\')">'+Messages("subscriber.checkDataUsage")+'</a>' +
                '<div class="tooltip" id="'+idTooltip+'">' +
                '<div class="row">' +
                '<div class="col-sm-6">' +
                '<span style="font-size: 20px; color: #EA0029;" id="infoUsedBalance_'+listSubscriber[i].isdn+'"></span><br>' +
                '<span class="text-white" style="font-size: 16px;">'+Messages("subscriber.dataUsed")+'</span><hr style="border: 1px solid white;">' +
                '<span style="font-size: 20px; color: #FBCCD6;" id="infoRemainBalance_'+listSubscriber[i].isdn+'"></span><br>' +
                '<span class="text-white" style="font-size: 16px;">'+Messages("subscriber.dataRemaining")+'</span><hr>' +
                '<a class="cursor-pointer" onclick="closeTooltip()" style="position: absolute;top: 0px;right: 5px;font-size: 20px;color: white;"><i class="bx bx-x"></i></a>' +
                '</div> '+
                '<div class="col-sm-6" style="padding: 0px;">' +
                '<div id="chartInfoBalance_'+listSubscriber[i].isdn+'" style="width: 100%;"></div>'+
                '</div> '+

                '</div> '+

                '</div>' +
                "</td>";
            body += "</tr>";
        }
    } else {
        $("#count-tb").html(0);
        $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
    }
    $("#listSubsTable").find('tbody').html(body);

    $("#count-tb").html(datas.total);
    pagingTable(datas.total, page, pageSize);
}