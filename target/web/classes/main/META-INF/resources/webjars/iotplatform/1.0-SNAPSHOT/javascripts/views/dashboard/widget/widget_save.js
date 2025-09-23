function savePageWidget() {
    console.log($('.grid-stack-item').length);
    // console.log($('.grid-stack-item')[0].getAttribute('gs-id'));

    var countWidget = $('.grid-stack-item').length;

    var dataModel = new FormData;
    dataModel.id = idDashboard;

    var widgetList = [];
    for(var i=countWidget-1; i>=0; i--){
        var widgetdata = {
            "x": $('.grid-stack-item')[i].getAttribute('gs-x'),
            "y": $('.grid-stack-item')[i].getAttribute('gs-y'),
            "w": $('.grid-stack-item')[i].getAttribute('gs-w'),
            "h": $('.grid-stack-item')[i].getAttribute('gs-h'),
            "id": $('.grid-stack-item')[i].getAttribute('gs-id'),
            "type": $('.grid-stack-item')[i].getAttribute('type'),
            "org": $('.grid-stack-item')[i].getAttribute('org'),
            "filter": $('.grid-stack-item')[i].getAttribute('filter'),
            "filterValue": $('.grid-stack-item')[i].getAttribute('filter-value'),
            "data": $('.grid-stack-item')[i].getAttribute('data'),
            "title": $('.grid-stack-item')[i].getAttribute('title'),
            "unit": $('.grid-stack-item')[i].getAttribute('unit'),
            "maxValue": $('.grid-stack-item')[i].getAttribute('max-value'),
            "topic": $('.grid-stack-item')[i].getAttribute('topic'),
            "cmdon": $('.grid-stack-item')[i].getAttribute('cmdon'),
            "cmdoff": $('.grid-stack-item')[i].getAttribute('cmdoff'),
            "typeMap": $('.grid-stack-item')[i].getAttribute('typeMap'),

        };
        widgetList.push(widgetdata);
    }
    dataModel.widgetList = widgetList;

    console.log(dataModel);

    var r = jsRoutes.controllers.DashboardV3Controller.saveDashboard();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(dataModel),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.href = jsRoutes.controllers.DashboardV3Controller.dashboard(projectId, idDashboard).url;
                },1000);
            }else{
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
}

function autoSaveWidget() {
    var countWidget = $('.grid-stack-item').length;

    var dataModel = new FormData;

    var widgetList = [];
    for(var i=countWidget-1; i>=0; i--){
        var widgetdata = {
            "x": $('.grid-stack-item')[i].getAttribute('gs-x'),
            "y": $('.grid-stack-item')[i].getAttribute('gs-y'),
            "w": $('.grid-stack-item')[i].getAttribute('gs-w'),
            "h": $('.grid-stack-item')[i].getAttribute('gs-h'),
            "id": $('.grid-stack-item')[i].getAttribute('gs-id'),
            "type": $('.grid-stack-item')[i].getAttribute('type'),
            "org": $('.grid-stack-item')[i].getAttribute('org'),
            "filter": $('.grid-stack-item')[i].getAttribute('filter'),
            "filterValue": $('.grid-stack-item')[i].getAttribute('filter-value'),
            "data": $('.grid-stack-item')[i].getAttribute('data'),
            "title": $('.grid-stack-item')[i].getAttribute('title'),
            "unit": $('.grid-stack-item')[i].getAttribute('unit'),
            "maxValue": $('.grid-stack-item')[i].getAttribute('max-value'),
            "cmdon": $('.grid-stack-item')[i].getAttribute('cmdon'),
            "cmdoff": $('.grid-stack-item')[i].getAttribute('cmdoff'),
        };
        widgetList.push(widgetdata);
    }
    dataModel.widgetList = widgetList;

    console.log(dataModel);

    var r = jsRoutes.controllers.WidgetListController.getWidgetCurrent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(dataModel),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}