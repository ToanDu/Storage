/**
 * Created by vtk-anhlt166 on 6/16/22.
 */
var chartTotal;
$(document).ready(function () {
    getDataChartDevice();
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
    modalData.url = "/api/overviews/graph/devicecon?start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000) + "&get_total=true";
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

function getDataChartProject() {
    var startStr = $("#date_timepicker_start").val();
    var DMY_start = startStr.split('-');
    var dateStart = new Date(+DMY_start[2], DMY_start[1] - 1, +DMY_start[0], +0, +0, +0);
    console.log(dateStart);

    var endStr = $("#date_timepicker_end").val();
    var DMY_end = endStr.split('-');
    var dateEnd = new Date(+DMY_end[2], DMY_end[1] - 1, +DMY_end[0], +23, +59, +59);
    console.log(dateEnd);

    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/projectcreate?start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000)+ "&get_total=true";
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

                renderApexChartDay(seriesDataDay, categoriesDataDay, "Tổng số dự án ");
                $("#titleChart").html('<i class="bx bx-circle" style="color: red;"></i>'+Messages("Tổng số dự án "));
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
    modalData.url = "/api/overviews/graph/tenantregister?start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000)+ "&get_total=true";
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
    modalData.url = "/api/overviews/graph/enduserregister?start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000)+ "&get_total=true";
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

function getDataChartDeveloperActive() {
    var startStr = $("#date_timepicker_start").val();
    var DMY_start = startStr.split('-');
    var dateStart = new Date(+DMY_start[2], DMY_start[1] - 1, +DMY_start[0], +0, +0, +0);
    console.log(dateStart);

    var endStr = $("#date_timepicker_end").val();
    var DMY_end = endStr.split('-');
    var dateEnd = new Date(+DMY_end[2], DMY_end[1] - 1, +DMY_end[0], +23, +59, +59);
    console.log(dateEnd);

    var modalData = new FormData;
    modalData.url = "/api/overviews/graph/tenantactive?start="+ Math.round(dateStart.getTime()/1000) + "&end=" + Math.round(dateEnd.getTime()/1000)+ "&get_total=true";
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

                renderApexChartDay(seriesDataDay, categoriesDataDay, "Tổng số developer active ");
                $("#titleChart").html('<i class="bx bx-circle" style="color: red;"></i>'+Messages("Tổng số developer active "));
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
        document.getElementById("tabTotalDevice").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalProject").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevelopActive").style.border = "0px solid #EE0033";
        getDataChartDevice();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartDevice()');
        document.getElementById("buttonDataDevelopExport").style.display = 'none';
    } else if(stt == 2){
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalProject").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevelopActive").style.border = "0px solid #EE0033";
        getDataChartProject();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartProject()');
        document.getElementById("buttonDataDevelopExport").style.display = 'none';
    } else if(stt == 3){
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalProject").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevelopActive").style.border = "0px solid #EE0033";
        getDataChartUser();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartUser()');
        document.getElementById("buttonDataDevelopExport").style.display = 'none';
    } else if(stt == 4){
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalProject").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "1px solid #EE0033";
        document.getElementById("tabTotalDevelopActive").style.border = "0px solid #EE0033";
        getDataChartCustomer();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartCustomer()');
        document.getElementById("buttonDataDevelopExport").style.display = 'none';
    } else if(stt == 5){
        document.getElementById("tabTotalDevice").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalProject").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalUser").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalCustomer").style.border = "0px solid #EE0033";
        document.getElementById("tabTotalDevelopActive").style.border = "1px solid #EE0033";
        getDataChartDeveloperActive();
        $("#buttonGetDataChart").attr('onclick', 'getDataChartCustomer()');
        document.getElementById("buttonDataDevelopExport").style.display = 'block';
    }
}