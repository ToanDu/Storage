/**
 * Created by vtk-anhlt166 on 5/12/22.
 */
function getHistoryClock() {
    var groupData = new FormData;
    groupData.token = token;
    groupData.start_time = $("#date_timepicker_start").val();
    groupData.end_time = $("#date_timepicker_end").val();
    groupData.listId = $("#chooseDeviceClock").val();
    console.log(groupData);

    // StartProcess();
    document.getElementById("buttonSearchHistory").disabled = true;
    var r = jsRoutes.controllers.WaterClockController.getHistoryClock();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if (data.success && data.content != null) {
                var arrayData = [];
                for(var key in data.content){
                    console.log(key);
                    var logs = data.content[key].logs;
                    if(logs.length > 0){
                        var arrayCurrent = [];
                        for(var i=logs.length-1; i>=0; i--){
                            var total = logs[i].value.total_vol/1000;

                            var date = logs[i].ts;
                            var dateTime = moment.unix(date/1000).format("YYYY/MM/DD");
                            var strDate = moment.unix(date/1000).format("DD/MM/YYYY");
                            var strMon = moment.unix(date/1000).format("MM/YYYY");

                            if(i > 0){
                                var dateNext = logs[i-1].ts;
                                var strDateNext = moment.unix(dateNext/1000).format("DD/MM/YYYY");
                                if(strDate == strDateNext){

                                } else {
                                    arrayData.push({
                                        "total": (arrayCurrent.length > 0) ? (total - arrayCurrent[arrayCurrent.length-1].totalDay) : total,
                                        "totalDay": total,
                                        "date":date,
                                        "dateTime":dateTime,
                                        "strDate":strDate,
                                        "strMonth":strMon
                                    });
                                    arrayCurrent.push({
                                        "total": (arrayCurrent.length > 0) ? (total - arrayCurrent[arrayCurrent.length-1].totalDay) : total,
                                        "totalDay": total,
                                        "date":date,
                                        "dateTime":dateTime,
                                        "strDate":strDate,
                                        "strMonth":strMon
                                    });
                                }
                            } else {
                                arrayData.push({
                                    "total":(arrayCurrent.length > 0) ? (total - arrayCurrent[arrayCurrent.length-1].totalDay) : total,
                                    "totalDay": total,
                                    "date":date,
                                    "dateTime":dateTime,
                                    "strDate":strDate,
                                    "strMonth":strMon
                                });
                                arrayCurrent.push({
                                    "total": (arrayCurrent.length > 0) ? (total - arrayCurrent[arrayCurrent.length-1].totalDay) : total,
                                    "totalDay": total,
                                    "date":date,
                                    "dateTime":dateTime,
                                    "strDate":strDate,
                                    "strMonth":strMon
                                });
                            }
                        }
                    }
                }

                // console.log(arrayData);
                if(arrayData.length > 0){
                    arrayData.sort((a, b) => a.dateTime.toLowerCase() > b.dateTime.toLowerCase() ? 1 : -1);
                    console.log(arrayData);

                    dataChartDay = [];
                    dataChartDay.push(['Ngày', 'Lượng nước (m³)']);
                    dataChartMonth = [];
                    dataChartMonth.push(['Tháng', 'Lượng nước (m³)']);

                    var totalDay = 0;
                    var strDay = arrayData[0].strDate;
                    var totalMonth = 0;
                    var strMonth = arrayData[0].strMonth;
                    for(var j=0; j<arrayData.length; j++){
                        if(arrayData[j].strDate == strDay){
                            totalDay += arrayData[j].total;
                        } else {
                            var arrayDataOne = [];
                            arrayDataOne.push(strDay);
                            arrayDataOne.push(totalDay);
                            dataChartDay.push(arrayDataOne);

                            strDay = arrayData[j].strDate;
                            totalDay = arrayData[j].total;
                        }

                        if(arrayData[j].strMonth == strMonth){
                            totalMonth += arrayData[j].total;
                        } else {
                            var arrayDataMonth = [];
                            arrayDataMonth.push(strMonth);
                            arrayDataMonth.push(totalMonth);
                            dataChartMonth.push(arrayDataMonth);

                            strMonth = arrayData[j].strMonth;
                            totalMonth = arrayData[j].total;
                        }
                    }

                    dataChartDay.push([strDay, totalDay]);
                    console.log(dataChartDay);
                    renderChartDataDay(dataChartDay);

                    dataChartMonth.push([strMonth, totalMonth]);
                    console.log(dataChartMonth);
                    renderChartDataMonth(dataChartMonth);
                }

            } else {
                showNotification('error', Messages("noti.Getfalse"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
            document.getElementById("buttonSearchHistory").disabled = false;
        }
    })
}

function renderChartDataDay(data) {
    var start_time = $("#date_timepicker_start").val();
    var end_time = $("#date_timepicker_end").val();
    var options = {
        title: 'Biểu đồ Lượng nước sử dụng theo ngày từ ' + start_time + ' đến ' + end_time,
        bars: 'vertical',
        vAxis: {format: 'decimal', minValue: 0},
        colors: ['#1b9e77'],
        legend: { position: 'top', alignment: 'start' }

    };

    if(data != null && data != undefined){
        var dataTable = google.visualization.arrayToDataTable(data);
        chartTotalDay = new google.visualization.ColumnChart(document.getElementById("columnChartDay"));
        chartTotalDay.draw(dataTable, options);
    }
}

function renderChartDataMonth(data) {
    var start_time = $("#date_timepicker_start").val();
    var end_time = $("#date_timepicker_end").val();
    var options = {
        title: 'Biểu đồ Lượng nước sử dụng theo tháng từ ' + start_time.substring(3, start_time.length) + ' đến ' + end_time.substring(3, start_time.length),
        bars: 'vertical',
        vAxis: {format: 'decimal', minValue: 0},
        colors: ['#1b9e77'],
        legend: { position: 'top', alignment: 'start' }

    };

    if(data != null && data != undefined){
        var dataTable = google.visualization.arrayToDataTable(data);
        chartTotalMonth = new google.visualization.ColumnChart(document.getElementById("columnChartMonth"));
        chartTotalMonth.draw(dataTable, options);
    }
}