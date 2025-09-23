var tablesData = {};

function appendWidgetTable(stt, data) {
    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        noMove: true, noResize: true, locked: true
    };
    //var id = "chart-column-" + stt;
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<h5 class="card-title" style="margin-bottom: 0px">' +
        '<div>' +
        '<span>'+(data.title == "null" ? "" : data.title)+'</span>'+
        '</div> '+
        '</h5>'+
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+wid+'" style="overflow-y: auto; padding: 5px;"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);
    tablesData[wid] = {};

    JSON.parse(data.data).forEach(function(dev, i) {
        createRunner(function () {
            showDataTable(dev, wid);
        })
    });
}

function showDataTable(widgetData, wid){
    console.log(widgetData, wid);
    var template = $('#dashboard-widget-table-template').html();
    if(localStorage.config == "false"){
        var get = jsRoutes.controllers.AttributeController.getDataAttributeById();
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
                var uid = `${widgetData.device}_${widgetData.attribute_key}`;
                if(data.content != null){
                    tablesData[wid][uid] = data.content.map(v => {
                            return {
                                device: widgetData.deviceName,
                                var: widgetData.attribute_key,
                                data: v.value,
                                time: moment.unix(new Date().setTime(v.updatetime/1000)).format('HH:mm:ss DD/MM/YYYY')
                            };
                }) || [];

                    var arr = Object.keys(tablesData[wid]).map(k => {
                            return tablesData[wid][k];
                }).flat();
                    var render = Mustache.render(template, arr);
                    $(`#${wid}`).html(render);
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
    } else {
        var dateStart = moment($("#date_timepicker_start").val(), "DD/MM/YYYY HH:mm");
        var dateObjectStart = dateStart.toDate();

        var dateEnd = moment($("#date_timepicker_end").val(), "DD/MM/YYYY HH:mm");
        var dateObjectEnd = dateEnd.toDate();

        var get = jsRoutes.controllers.AttributeController.getValueAttributeWithTime();
        $.ajax({
            type: get.type,
            data: JSON.stringify({
                "deviceId": widgetData.device,
                "entity_type": "DEVICE",
                "attribute_type": widgetData.attribute_type,
                "attribute_key": widgetData.attribute_key,
                "startTime": dateObjectStart.getTime(),
                "endTime": dateObjectEnd.getTime(),
                "aggType": $("#aggType").val(),
                "interval": $("#interval").val()
            }),
            contentType: "application/json; charset=utf-8",
            url: get.url,
            success: function (data) {
                console.log(data);
                var uid = `${widgetData.device}_${widgetData.attribute_key}`;
                if(data.content != null){
                    tablesData[wid][uid] = data.content.map(v => {
                            return {
                                device: widgetData.deviceName,
                                var: widgetData.attribute_key,
                                data: v.value,
                                time: moment.unix(new Date().setTime(v.updatetime/1000)).format('HH:mm:ss DD/MM/YYYY')
                            };
                }) || [];

                    var arr = Object.keys(tablesData[wid]).map(k => {
                            return tablesData[wid][k];
                }).flat();
                    var render = Mustache.render(template, arr);
                    $(`#${wid}`).html(render);
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

}