/**
 * Created by vtk-anhlt166 on 1/13/22.
 */
var datas = {}, datasData = {};

function appendWidgetData(stt, data) {
    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        noMove: true, noResize: true, locked: true
    };
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
            '<h5 class="card-title">' +
            '<div>' +
            '<span>'+(data.title == "null" ? "" : data.title)+'</span>'+
            '</div> '+
            '</h5>'+
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+wid+'" style="overflow-y: auto;"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    $("#bodyDashboard").append(wrapper);

    document.getElementById(wid).innerHTML =
        '<div class="card bg-transparent shadow-none mb-0">'+
        '<div class="card-body text-center">'+
        '<h5 class="mt-3 mb-1" id="'+wid+'-value" style="font-weight: 600;">'+ "0" +'</h5>'+
        '<h6 class="mb-3 text-black-50" style="margin-left: 25%;">'+Messages("Unit: ")+((data.unit != null ? data.unit : ""))+'</h6>'+
        '<small class="mt-3 text-black-50" id="'+wid+'-date">'+"01/01/2022 00:00"+'</small>'+
        '</div>'+
        '</div>';

    JSON.parse(data.data).forEach(function(dev, i) {
        if(deviceId && deviceId != "")
            dev.device = deviceId;
        createRunner(function () {
            showDataData(dev, wid);
        });
    });
}

function showDataData(widgetData, wid){
    var get = jsRoutes.controllers.DashboardAppController.getLastValueAttributeApp();
    $.ajax({
        type: get.type,
        data: JSON.stringify({
            "deviceId": widgetData.device,
            "entity_type": "DEVICE",
            "attribute_type": widgetData.attribute_type,
            "attribute_key": widgetData.attribute_key,
            "token": token
        }),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (data) {
            console.log(data);
            var uid = `${widgetData.device}_${widgetData.attribute_key}`;
            console.log(wid);
            if(data.content != null && data.content != undefined) {
                $("#" + wid + "-value").html((data.content[0].value != null ? data.content[0].value : ""));
                var date = "01/01/2022 00:00";
                if(data.content[0].updatetime != null){
                    date = moment.unix(data.content[0].updatetime/1000).format("DD/MM/YYYY HH:mm");
                }
                $("#" + wid + "-date").html(date);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}