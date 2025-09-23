var options = { // put in gridstack options here
    disableOneColumnMode: true, // for jfiddle small window size
    float: false
};
var grid = GridStack.init(options);

var WIDGET = {
    MAP: {value: 1, name: "map"},
    TABLE: {value: 2, name: "table"},
    CHART_COLUMN: {value: 3, name: "chart"},
    CHART_LINE: {value: 4, name: "line"},
    GAUGE: {value: 5, name: "gauge"},
    ROUND_SWITCH: {value: 6, name: "round-switch"},
    DATA: {value: 7, name: "data"},
    COMMAND: {value: 8, name: "command"},
};
var TYPE_MAP = {
    GOOGLE_MAP: {value: 1, name: "googlemap"},
    MAPBOX: {value: 2, name: "mapbox"}
};
var countData = 0;
$(document).ready(function () {
    var formData = new FormData;
    formData.id = idDashboard;

    var get = jsRoutes.controllers.DashboardV3Controller.getDashboardWithId();
    $.ajax({
        type: get.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.widgetSizeList != null && data.content.widgetSizeList.length > 0){
                    // markerVehiclesList = [];
                    // markersClusterList = [];

                    countData = data.content.widgetSizeList.length;
                    // for(var i = 0; i < data.content.widgetSizeList.length; i++){
                    //     if(data.content.widgetSizeList[i].type = WIDGET.MAP.value){
                    //         markerVehicles = [];
                    //         markersClusterArray = [];
                    //         markerCluster = [];
                    //
                    //         appendWidgetMap(i, data.content.widgetSizeList[i]);
                    //     }
                    //
                    // }
                    renderDataWidget(0, data.content.widgetSizeList);

                }
            } else {
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
});

function renderDataWidget(index, data) {
    console.log(data);
    if(data[index].type == WIDGET.MAP.value){
        // markerVehicles = [];
        // markersClusterArray = [];
        // markerCluster = [];
        if(data[index].typeMap == TYPE_MAP.MAPBOX.value){
            appendWidgetWithMapBox(index, data[index]);
        } else {
            appendWidgetMap(index, data[index]);
        }

    }
    else if(data[index].type == WIDGET.CHART_COLUMN.value){
        appendWidgetChartColumn(index, data[index]);
    }
    else if(data[index].type == WIDGET.CHART_LINE.value){
        appendWidgetChartLine(index, data[index]);
    }
    else if(data[index].type == WIDGET.TABLE.value){
        appendWidgetTable(index, data[index]);
    }
    else if(data[index].type == WIDGET.GAUGE.value){
        appendWidgetGauge(index, data[index]);
    }
    else if(data[index].type == WIDGET.ROUND_SWITCH.value){
        appendWidgetRoundSwitch(index, data[index]);
    }
    else if(data[index].type == WIDGET.DATA.value){
        appendWidgetData(index, data[index]);
    }
    else if(data[index].type == WIDGET.COMMAND.value){
        appendWidgetCommand(index, data[index]);
    }

    setTimeout(function () {
        if(index < countData-1){
            renderDataWidget(index+1, data);
        }
    },100);
}

function createRunner(callback){
    var min = 5;
    var max = 10;
    var timeout, flag = true;
    const runInterval = function () {
        callback();
        var delay = Math.floor(Math.random() * (max - min + 1)) + min;

        timeout = setTimeout(runInterval, delay * 1000);
    };

    runInterval();
    return {
        clear(){
            clearTimeout(timeout);
        }
    }
}