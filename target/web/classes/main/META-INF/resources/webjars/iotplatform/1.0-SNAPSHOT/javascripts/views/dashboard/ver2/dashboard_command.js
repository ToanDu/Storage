/**
 * Created by vtk-anhlt166 on 11/1/22.
 */
function appendWidgetCommand(index, data) {
    // console.log(index, data);
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
    grid.addWidget(node);

    var wdata = JSON.parse(data.data);
    document.getElementById(wid).innerHTML =
        '<div class="console">'+
        '<div class="consolebody" id="'+wid+'-consolebody">'+
        '<div id="'+wid+'-command-result">' +
        '<p class="text-white">Please enter the command sent to the device</p>'+
        '</div>'+
        '<textarea rows="1" id="'+wid+'-command-input" class="command-input" onkeydown="checkInput(this);" wid="'+wid+'" deviceId="'+wdata[0].device+'" placeholder=">_"></textarea>'+
        '</div>'+
        '</div>';


    // JSON.parse(data.data).forEach(function(dev, i) {
    //     createRunner(function () {
    //         showDataData(dev, wid);
    //     })
    // });

    //get lich su rpc
    var groupData = new FormData();
    groupData.deviceId = wdata[0].device;
    console.log(groupData);
    var r = jsRoutes.controllers.DashboardWidgetController.getHistoryRpc();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas, textStatus, jqXHR) {
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    for(var i=datas.content.data.length-1 ; i >= 0; i--){
                        var text = JSON.stringify(datas.content.data[i].params) + " " + datas.content.data[i].method;
                        var textNode = '<p>'+Messages(" ")+text+'</p>';
                        $("#"+wid+"-command-result").append(textNode);

                        var result = '<p class="text-danger">'+datas.content.data[i].persistent_state+'</p>';
                        $("#"+wid+"-command-result").append(result);
                    }
                }
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function checkInput(el) {
    var wid = el.getAttribute('wid');
    var event = window.event || event.which;
    if (event.keyCode == 13) {
        event.preventDefault();

        //TODO send command
        addLine(document.getElementById(wid+"-command-input").value, wid);
        var deviceId = el.getAttribute("deviceId");
        var get = jsRoutes.controllers.MessagesDeviceController.sendCommandRPC();
        var bodyData = new FormData;
        bodyData.deviceId = deviceId;
        bodyData.command = document.getElementById(wid+"-command-input").value;
        console.log(bodyData);
        document.getElementById(wid+"-command-input").value = "";
        $.ajax({
            type: get.type,
            data: JSON.stringify(bodyData),
            contentType: "application/json; charset=utf-8",
            url: get.url,
            success: function (data) {
                console.log(data);
                addLineRequest(JSON.stringify(data.content), wid);
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
            },
            complete: function (jqXHR, textStatus) {
                // FinishProcess(); //Stop display loading...
                var objDiv = document.getElementById(wid+"-consolebody");
                objDiv.scrollTop = objDiv.scrollHeight;
            }
        });
    }
}

function addLine(line, wid) {
    var textNode = '<p>'+Messages("> ")+line+'</p>';
    $("#"+wid+"-command-result").append(textNode);
}
function addLineRequest(line, wid) {
    var textNode = '<p class="text-danger">'+line+'</p>';
    $("#"+wid+"-command-result").append(textNode);
}

function sendDataCommand(){
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
            console.log(data);
            if(data.content != null) {

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