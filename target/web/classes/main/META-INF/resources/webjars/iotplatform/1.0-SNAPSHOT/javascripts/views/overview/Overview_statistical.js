/**
 * Created by vtk-anhlt166 on 4/14/23.
 */
$(document).ready(function () {
    getDataStatistical();
})
function getDataStatistical() {
    getDataLatency();

    countSuccessRate();
}

function getDataLatency() {
    var body = new FormData;
    body.project_id = projectId;
    body.method = $("#methodRequest").val();
    body.url = $("#urlRequest").val();

    var dateStart = moment($("#date_timepicker_start").val(), "DD/MM/YYYY HH:mm");
    var dateObjectStart = dateStart.toDate();
    body.start_time = Math.round(dateObjectStart.getTime());

    var dateEnd = moment($("#date_timepicker_end").val(), "DD/MM/YYYY HH:mm");
    var dateObjectEnd = dateEnd.toDate();
    body.end_time = Math.round(dateObjectEnd.getTime());

    console.log(body);

    if(body.start_time >= body.end_time ){
        showNotification('danger', Messages("Ngày bắt đầu phải nhỏ hơn ngày kết thúc"));
        return;
    }

    StartProcess();
    var route = jsRoutes.controllers.OverviewController.countDataLatency();
    $.ajax({
        type: route.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if (data.content != null) {
                $("#avgLatency").html(data.content.avg_latency != null ? data.content.avg_latency : 0);
                $("#totalRequest").html(data.content.total_request != null ? data.content.total_request : 0);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}

function countSuccessRate() {
    var body = new FormData;
    body.project_id = projectId;
    body.method = $("#methodRequest").val();
    body.url = $("#urlRequest").val();

    var dateStart = moment($("#date_timepicker_start").val(), "DD/MM/YYYY HH:mm");
    var dateObjectStart = dateStart.toDate();
    body.start_time = Math.round(dateObjectStart.getTime());

    var dateEnd = moment($("#date_timepicker_end").val(), "DD/MM/YYYY HH:mm");
    var dateObjectEnd = dateEnd.toDate();
    body.end_time = Math.round(dateObjectEnd.getTime());

    console.log(body);

    if(body.start_time >= body.end_time ){
        showNotification('danger', Messages("Ngày bắt đầu phải nhỏ hơn ngày kết thúc"));
        return;
    }

    StartProcess();
    var route = jsRoutes.controllers.OverviewController.countDataSuccessRate();
    $.ajax({
        type: route.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if (data.content != null) {
                $("#successRate").html(data.content.success_rate != null ? data.content.success_rate : 0);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}