google.charts.load('current', {'packages':['corechart']});
// google.charts.setOnLoadCallback(insertChartColumn);
google.load('visualization', '1', {packages:['corechart'], callback: insertChartColumn});
// $(document).ready(function () {
//     initialize();
// });
// function initialize(){
//     $(window).resize(function(){
//         insertChartColumn();
//     });
// }

var chartLines = {}, chartColumns = [];

function appendWidgetChartLine(stt, data) {
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
        '<div class="paper-middle" style="">' +
        '<div id="'+wid+'" style="height: 100%"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);

    var options = {
        chart: {
            foreColor: 'rgb(0, 0, 0)',
            height: '100%',
            type: 'line',
            zoom: {
                enabled: false
            },
            dropShadow: {
                enabled: true,
                top: 3,
                left: 2,
                blur: 4,
                opacity: 0.1,
            },
            toolbar: {
                show: false
            },
        },
        stroke: {
            curve: 'smooth',
            width: 3
        },
        series: [],
        // title: {
        //     text: 'Multiline Chart',
        //     align: 'left',
        //     offsetY: 25,
        //     offsetX: 20
        // },
        markers: {
            size: 4,
            strokeWidth: 0,
            hover: {
                size: 7
            }
        },
        grid: {
            show: true,
            borderColor: '#d9d9d9',
            strokeDashArray: 4,
        },
        tooltip: {
            theme: 'dark',
            x: {
                show: true,
                format: 'HH:mm:ss dd/M/yyyy',
                formatter: undefined,
            }
        },
        // labels: ['01/15/2002', '01/16/2002', '01/17/2002', '01/18/2002', '01/19/2002', '01/20/2002'],
        xaxis: {
            // tooltip: {
            //     enabled: false
            // }
            type: 'datetime',
            labels: {
                datetimeUTC: false
            }
        },
        yaxis: {
            labels: {
                formatter: function (value) {
                    return value.toFixed(2);
                }
            }
        },
        legend: {
            show: true,
            onItemClick: {
                toggleDataSeries: false
            },
        },
    };
    var chartLine = new ApexCharts(document.querySelector('#'+wid), options);
    chartLine.render();

    console.log(JSON.parse(data.data));
    // if(JSON.parse(data.data).length > 0){
    //     var dataChartLine = [];
    //     for(var i=0; i<JSON.parse(data.data).length; i++){
    //         showDataChartLine(JSON.parse(data.data)[i], wid, dataChartLine);
    //     }
    //
    //     // console.log(dataChartLine);
    //     setTimeout(function () {
    //         insertChartLine(wid, dataChartLine, chartLine);
    //     },3000);
    // }

    createRunner(function () {
        var dataChartLine = [];
        JSON.parse(data.data).forEach(function(dev, i){
            showDataChartLine(dev, wid, dataChartLine);

            setTimeout(function () {
                insertChartLine(wid, dataChartLine, chartLine);
            },1500);
        });
    });
}

function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}

var chartLinesData = {};
function showDataChartLine(widgetData, wid, dataChartLine){
    var chart = chartLines[wid];
    // if(chart != null && chart != undefined){
    //     chart.destroy();
    // }
    console.log(localStorage.config);
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
                console.log(widgetData.attribute_key, data);
                if(data.content != null){
                    chartLineCluster(data.content, widgetData, dataChartLine);
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
                console.log(widgetData.attribute_key, data);
                if(data.content != null){
                    chartLineCluster(data.content, widgetData, dataChartLine);
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

function chartLineCluster(data, widgetData, dataChartLine) {
    console.log(data, widgetData);
    var datas = [];
    if(data.length > 0){
        for(var i=0; i<data.length; i++){
            var curdate = new Date().setTime(data[i].updatetime/1000);
            curdate = moment.unix(curdate);
            console.log(curdate);
            var xy = {
                "x":curdate,
                "y":data[i].value
            };
            datas.push(xy);
        }
        dataChartLine.push({
            "attr":widgetData.attribute_key,
            "data":datas
        });
    }

}

function insertChartLine(wid, dataChartLine, chartLine) {
    console.log(wid, dataChartLine);

    if(dataChartLine.length>0){
        var dataSeries = [];
        for(var i=0; i<dataChartLine.length; i++){
            var data1 = [];
            if(dataChartLine[i].data != null && dataChartLine[i].data.length > 0){
                for(var k=0; k<dataChartLine[i].data.length; k++){
                    data1.push({
                        "x": dataChartLine[i].data[k].x,
                        "y": dataChartLine[i].data[k].y
                    })
                }
                dataSeries.push({
                    name: dataChartLine[i].attr != null ? dataChartLine[i].attr : "",
                    data: data1
                })
            }
        }

        console.log(dataSeries);
        chartLine.updateSeries(dataSeries);
    }

}

//column
function appendWidgetChartColumn(stt, data) {
    console.log(data);
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
        '<h5 class="card-title">' +
        '<div>' +
        '<span>'+(data.title == "null" ? "" : data.title)+'</span>'+
        '</div> '+
        '</h5>'+
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div id="'+wid+'" style="height: 100%"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);

    // console.log(JSON.parse(data.data));
    // if(JSON.parse(data.data).length > 0){
    //     var dataChartColumn = [];
    //     for(var i=0; i<JSON.parse(data.data).length; i++){
    //         showDataChartColumn(JSON.parse(data.data)[i], wid, dataChartColumn);
    //     }
    //
    //     console.log(dataChartColumn);
    //     setTimeout(function () {
    //         insertChartColumn(wid, dataChartColumn);
    //     },3000);
    // }

    createRunner(function () {
        var dataChartColumn = [];
        JSON.parse(data.data).forEach(function(dev, i){
            showDataChartColumn(dev, wid, dataChartColumn);

            setTimeout(function () {
                insertChartColumn(wid, dataChartColumn);
            },1500);
        });
    });
}

var chartColumnsData = [];
function showDataChartColumn(widgetData, wid, dataChartColumn){
    // console.log(widgetData, wid);
    var chart = chartColumns[wid];
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
                chartColumnCluster(data.content, widgetData, dataChartColumn);
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

function chartColumnCluster(data, widgetData, dataChartColumn){
    // console.log(data, widgetData);
    var dataValues = [];
    dataValues.push(widgetData.deviceName + "(" + widgetData.attribute_key + ")");
    dataValues.push(parseInt(data[0].value));
    // var color = "#" + Math.floor(Math.random()*16777215).toString(16);
    dataValues.push("color: #EE0033");
    // console.log(dataValues);
    dataChartColumn.push(dataValues);
}

function insertChartColumn(wid, dataChartColumn) {
    // console.log(wid, dataChartColumn);
    if(dataChartColumn != undefined && dataChartColumn.length > 0){
        var legendPosition = 'none';
        var chartOption = {
            height: '100%',
            width: '100%',
            legend: { position: 'none' }
        };

        // add value
        var dataChart = [];
        for(var i=0; i<dataChartColumn.length; i++){
            dataChart.push(dataChartColumn[i]);
        }
        // console.log(dataChart);

        var data = new google.visualization.DataTable();
        // console.log(data);
        data.addColumn('string', 'Name');
        data.addColumn('number', 'Value');
        data.addColumn({type: 'string', role: 'style'});
        data.addRows(dataChart);
        // console.log(data);

        if(wid != null && wid != undefined){
            if(document.getElementById(wid) != null){
                var chart = new google.visualization.ColumnChart(document.querySelector("#"+wid));
                chart.draw(data, chartOption);
            }
        }
    }
}

