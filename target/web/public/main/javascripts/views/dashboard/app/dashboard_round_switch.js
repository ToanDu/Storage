var objectSwitch = {};
function appendWidgetRoundSwitch(stt, data) {
    console.log(data);
    var wdata = JSON.parse(data.data);
    if(deviceId && deviceId != "") {
        wdata[0].device = deviceId;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        noMove: true, noResize: true, locked: true
    };
    //var id = "map-canvas-"+stt;
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden;">\n' +
        '<h5 class="card-title" style="margin-bottom: 0px">' +
        '<div>' +
        '<span>'+(wdata[0].deviceName == "null" ? "" : wdata[0].deviceName)+'</span>'+
        '</div> '+
        '</h5>'+
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+wid+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    $("#bodyDashboard").append(wrapper);
    objectSwitch[wid] = data;

    document.getElementById(wid).innerHTML =
        '<div class="toggle toggle--text">'+
        '<input id="'+wid+'-checkbox" class="toggle--checkbox" type="checkbox" checked>'+
        '<label class="toggle--btn" onclick="sendMessageToDevice(\''+wid+'\', \''+data.topic+'\', \''+wdata[0].device+'\')" for="'+wid+'-checkbox" data-label-on="on" data-label-off="off"></label>'+
        '</div>';

    wdata.forEach(function(dev, i) {
        showSwitch(dev, wid);
    });
}

function sendMessageToDevice(wid, topic, device){
    console.log(wid, topic, device);
    //console.log(objectSwitch[wid]);

    var checkbox = document.getElementById(wid+"-checkbox").checked;
    var Data = new FormData();
    if(checkbox){
        Data.content = objectSwitch[wid].cmdoff;
    } else {
        Data.content = objectSwitch[wid].cmdon;
    }
    Data.topic = topic;
    Data.deviceId = device;
    console.log(Data);
    StartProcess();
    var r = jsRoutes.controllers.DashboardAppController.sendMessageOnOffApp();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success', Messages("Gửi lệnh thành công"));
            } else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess();
        }
    });
}

function showSwitch(widgetData, wid){
    var get = jsRoutes.controllers.AttributeController.getLastValueAttribute();
    $.ajax({
        type: get.type,
        data: JSON.stringify({
            "deviceId": widgetData.device,
            "entity_type": "DEVICE",
            "attribute_type": widgetData.attribute_type,
            "attribute_key": widgetData.attribute_key
        }),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (data) {
            console.log(wid);
            if(data.content != null && data.content != undefined) {
                if(data.content[0].value){
                    // document.getElementById(wid + "-checkbox").checked = true;
                    $("#"+wid+"-checkbox").prop("checked", true);
                } else {
                    // document.getElementById(wid + "-checkbox").checked = true;
                    $("#"+wid+"-checkbox").prop("checked", false);
                }
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