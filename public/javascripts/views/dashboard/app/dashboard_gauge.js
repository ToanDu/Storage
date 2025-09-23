var gauges = {}, gaugesData = {};

function appendWidgetGauge(stt, data) {
    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        noMove: true, noResize: true, locked: true
    };
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<h5 class="card-title" style="margin-bottom: 0px">' +
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
    gaugesData[wid] = {};

    var options = {
        series: [0],
        labels: [''],
        title: {
            text: "",
            align: 'center',
            offsetY: 10,
            floating: false,
        },
        chart: {
            type: 'radialBar',
            offsetY: 0,
            sparkline: {
                enabled: true
            }
        },
        legend: {
            show: true,
            floating: false,
            horizontalAlign: 'center',
            position: 'bottom'
        },
        plotOptions: {
            radialBar: {
                startAngle: -90,
                endAngle: 90,
                track: {
                    background: "#e7e7e7",
                    strokeWidth: '97%',
                    margin: 5, // margin is in pixels
                    dropShadow: {
                        enabled: true,
                        top: 2,
                        left: 0,
                        color: '#999',
                        opacity: 1,
                        blur: 2
                    }
                },
                dataLabels: {
                    name: {
                        show: false
                    },
                    value: {
                        offsetY: 25,
                        fontSize: '22px',
                        formatter: function (val) {
                            return val.toFixed(2) + (data.unit == "null" ? "" : data.unit);
                        }
                    }
                }
            }
        },
        grid: {
            padding: {
                top: -10
            }
        },
    };

    var chart = new ApexCharts(document.getElementById(wid), options);
    chart.render();
    gauges[wid] = chart;
    gaugesData[wid] = {};

    JSON.parse(data.data).forEach(function(dev, i) {
        if(deviceId && deviceId != "")
            dev.device = deviceId;
        createRunner(function () {
            showDataGauge(dev, wid, data.maxValue);
        })
    });
}

function showDataGauge(widgetData, wid, maxValue){
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
            var uid = `${widgetData.device}_${widgetData.attribute_key}`;

            if(!gaugesData[wid][uid]){
                gauges[wid].updateOptions({
                    labels: [`${widgetData.deviceName} - ${widgetData.attribute_key}`]
                });
            }
            if(data.content && gaugesData[wid][uid] != data.content[0].value)
            {
                gaugesData[wid][uid] = data.content[0].value * 100 / (parseFloat(maxValue) || 100);
                gauges[wid].updateSeries([gaugesData[wid][uid]]);
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