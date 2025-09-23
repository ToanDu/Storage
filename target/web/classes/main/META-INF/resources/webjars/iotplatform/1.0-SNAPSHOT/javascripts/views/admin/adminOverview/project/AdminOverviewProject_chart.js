/**
 * Created by vtk-anhlt166 on 8/22/22.
 */
var chartTotal;
$(document).ready(function () {
    getDataChartDevice();

    radialChartDevice();
});
function getDataChartDevice() {
    var startStr = $("#date_timepicker_start").val();
    var DMY_start = startStr.split('-');
    var dateStart = new Date(+DMY_start[2], DMY_start[1] - 1, +DMY_start[0], +0, +0, +0);
    console.log(dateStart);

    var endStr = $("#date_timepicker_end").val();
    var DMY_end = endStr.split('-');
    var dateEnd = new Date(+DMY_end[2], DMY_end[1] - 1, +DMY_end[0], +23, +59, +59);
    console.log(dateEnd);

    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/devicecon?project_id="+projectId+"&start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000) + "&get_total=true";
    console.log(modalData);
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                var dataChart = datas.content.data;
                dataChart.sort((a, b) => a.date_time.toLowerCase() > b.date_time.toLowerCase() ? 1 : -1);
                console.log(dataChart);

                var seriesDataDay = [];
                var categoriesDataDay = [];
                for(var i=0; i<dataChart.length; i++){
                    seriesDataDay.push(dataChart[i].total);
                    categoriesDataDay.push(dataChart[i].date_time);
                }

                renderApexChartDay(seriesDataDay, categoriesDataDay, "Tổng số thiết bị");
                $("#titleChart").html('<i class="bx bx-circle" style="color: red;"></i>'+Messages("Tổng số thiết bị"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function getDataChartDeviceConnect() {//dang hoat dong
    var startStr = $("#date_timepicker_start").val();
    var DMY_start = startStr.split('-');
    var dateStart = new Date(+DMY_start[2], DMY_start[1] - 1, +DMY_start[0], +0, +0, +0);
    console.log(dateStart);

    var endStr = $("#date_timepicker_end").val();
    var DMY_end = endStr.split('-');
    var dateEnd = new Date(+DMY_end[2], DMY_end[1] - 1, +DMY_end[0], +23, +59, +59);
    console.log(dateEnd);

    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/deviceactive?project_id="+projectId+"&start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000) + "&get_total=true";
    console.log(modalData);
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                var dataChart = datas.content.data;
                dataChart.sort((a, b) => a.date_time.toLowerCase() > b.date_time.toLowerCase() ? 1 : -1);
                console.log(dataChart);

                var seriesDataDay = [];
                var categoriesDataDay = [];
                for(var i=0; i<dataChart.length; i++){
                    seriesDataDay.push(dataChart[i].total);
                    categoriesDataDay.push(dataChart[i].date_time);
                }

                renderApexChartDay(seriesDataDay, categoriesDataDay, "Tổng số thiết bị");
                $("#titleChart").html('<i class="bx bx-circle" style="color: red;"></i>'+Messages("Tổng số thiết bị"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function getDataChartUser() {
    var startStr = $("#date_timepicker_start").val();
    var DMY_start = startStr.split('-');
    var dateStart = new Date(+DMY_start[2], DMY_start[1] - 1, +DMY_start[0], +0, +0, +0);
    console.log(dateStart);

    var endStr = $("#date_timepicker_end").val();
    var DMY_end = endStr.split('-');
    var dateEnd = new Date(+DMY_end[2], DMY_end[1] - 1, +DMY_end[0], +23, +59, +59);
    console.log(dateEnd);

    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/tenantregister?project_id="+projectId+"&start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000)+ "&get_total=true";
    console.log(modalData);
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                var dataChart = datas.content.data;
                dataChart.sort((a, b) => a.date_time.toLowerCase() > b.date_time.toLowerCase() ? 1 : -1);
                console.log(dataChart);

                var seriesDataDay = [];
                var categoriesDataDay = [];
                for(var i=0; i<dataChart.length; i++){
                    seriesDataDay.push(dataChart[i].total);
                    categoriesDataDay.push(dataChart[i].date_time);
                }

                renderApexChartDay(seriesDataDay, categoriesDataDay, "Tổng số người dùng ");
                $("#titleChart").html('<i class="bx bx-circle" style="color: red;"></i>'+Messages("Tổng số người dùng "));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function getDataChartCustomer() {
    var startStr = $("#date_timepicker_start").val();
    var DMY_start = startStr.split('-');
    var dateStart = new Date(+DMY_start[2], DMY_start[1] - 1, +DMY_start[0], +0, +0, +0);
    console.log(dateStart);

    var endStr = $("#date_timepicker_end").val();
    var DMY_end = endStr.split('-');
    var dateEnd = new Date(+DMY_end[2], DMY_end[1] - 1, +DMY_end[0], +23, +59, +59);
    console.log(dateEnd);

    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/enduserregister?project_id="+projectId+"&start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000)+ "&get_total=true";
    console.log(modalData);
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                var dataChart = datas.content.data;
                dataChart.sort((a, b) => a.date_time.toLowerCase() > b.date_time.toLowerCase() ? 1 : -1);
                console.log(dataChart);

                var seriesDataDay = [];
                var categoriesDataDay = [];
                for(var i=0; i<dataChart.length; i++){
                    seriesDataDay.push(dataChart[i].total);
                    categoriesDataDay.push(dataChart[i].date_time);
                }

                renderApexChartDay(seriesDataDay, categoriesDataDay, "Tổng số khách hàng ");
                $("#titleChart").html('<i class="bx bx-circle" style="color: red;"></i>'+Messages("Tổng số khách hàng "));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function renderApexChartDay(seriesData, categoriesData, title) {
    if(chartTotal != null && chartTotal != undefined){
        chartTotal.destroy();
    }

    var options = {
        series: [{
            name: title,
            data: seriesData

        }],
        chart: {
            foreColor: "rgba(0, 0, 0, 0.65)",
            type: 'line',
            height: 300,
            width: '99%',
            stacked: false,
            toolbar: {
                show: false
            },
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '45%',
                endingShape: 'rounded'
            },
        },
        legend: {
            show: false,
            position: 'top',
            horizontalAlign: 'left',
            offsetX: -20
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 3,
            // colors: ['transparent']
        },
        fill: {
            type: "gradient",
            gradient: {
                shade: "light",
                type: "horizontal",
                shadeIntensity: .5,
                gradientToColors: ["#ff0000", "rgba(255, 0, 0, 1)"],
                inverseColors: !1,
                opacityFrom: 1,
                opacityTo: 1,
                stops: [0, 100]
            }
        },
        markers: {
            size: 4,
            colors: ["#ff0000"],
            strokeColors: "#fff",
            strokeWidth: 2,
            hover: {
                size: 7,
            }
        },
        colors: ["#ff0000", "rgba(255, 0, 0)"],
        yaxis: {
            labels: {
                formatter: function (value) {
                    return value;
                }
            },
        },
        xaxis: {
            categories: categoriesData,
        },
        grid: {
            borderColor: 'rgba(0, 0, 0, 0.12)',
            show: true,
        },
        tooltip: {
            theme: 'dark',
            y: {
                formatter: function (val) {
                    return val
                }
            }
        }
    };

    chartTotal = new ApexCharts(document.querySelector("#chartTotalOverview"), options);
    chartTotal.render();
}

function changeChartTotal(stt) {
    if(stt == 1){
        document.getElementById("tabTotalDeviceActive").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        getDataChartDevice();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartDevice()');
    } else if(stt == 2){
        document.getElementById("tabTotalDeviceActive").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevice").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        getDataChartDeviceConnect();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartProject()');
    } else if(stt == 3){
        document.getElementById("tabTotalDeviceActive").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        getDataChartUser();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartUser()');
    } else if(stt == 4){
        document.getElementById("tabTotalDeviceActive").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "1px solid #EE0033";
        getDataChartCustomer();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartCustomer()');
    }
}

//radial chart
function radialChartDevice() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/templates?project_id="+projectId;
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content.data != null && data.content.data.length > 0){
                    var series = [];
                    var labels = [];
                    var colors = [];
                    var total = 0;
                    for(var i=0; i<data.content.data.length; i++){
                        if(data.content.data[i].template_name != null && data.content.data[i].template_name.length > 0){
                            labels.push(data.content.data[i].template_name);
                        } else {
                            labels.push("Khác");
                        }
                        series.push(data.content.data[i].total);
                        total += data.content.data[i].total;
                        colors.push("#"+Math.floor(Math.random()*16777215).toString(16));
                    }

                    var options = {
                        series: series,
                        labels: labels,
                        chart: {
                            foreColor: 'rgba(255, 255, 255, 0.65)',
                            height: 380,
                            type: 'donut',
                        },
                        colors: colors,
                        legend: {
                            show: false
                        },
                        responsive: [{
                            breakpoint: 480,
                            options: {
                                chart: {
                                    height: 320
                                },
                                legend: {
                                    position: 'bottom'
                                }
                            }
                        }]
                    };
                    var chart = new ApexCharts(document.querySelector("#chartRadialDevice"), options);
                    chart.render();

                    //render labels
                    console.log(total);
                    var seriesKhac = 0;
                    var colorKhac = "";
                    if(labels.length > 0){
                        labels.forEach(function(item, index){
                            var per = series[index]*100/total;
                            var border = "3px solid " + colors[index];
                            console.log(border);
                            if(item != "Khác"){
                                var itemLabel = '<div class="col-md-2" style="border-left: '+border+'">'+
                                    '<label>'+item+'</label><br>'+
                                    '<label>'+Math.round(per*10)/10+" %"+'</label>'+
                                    '</div>';
                                $("#labelsChart").append(itemLabel);
                            } else {
                                seriesKhac = Math.round(per*10)/10;
                                colorKhac = border;
                            }
                        });

                        var itemLabelKhac = '<div class="col-md-2" style="border-left: '+colorKhac+'">'+
                            '<label>'+Messages("Khác")+'</label><br>'+
                            '<label>'+seriesKhac+" %"+'</label>'+
                            '</div>';
                        $("#labelsChart").append(itemLabelKhac);
                    }
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}