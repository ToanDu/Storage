/**
 * Created by vtk-anhlt166 on 2/7/22.
 */
var total_device = [];
var total_msg = [];
var total_user = [];
var time_device = [];
var time_msg = [];
var time_user = [];

var chartDevice;
var chartMess;
var chartUser;
$(document).ready(function () {
    countDeviceOfProject();
    countUserOfProject();
    countMessOfProject();

    // setInterval(function () {
    //     loadDataCount();
    // },300000)
});

function countDeviceOfProject() {
    var r = jsRoutes.controllers.OverviewController.countDevice7Day(projectId);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                total_device = [];
                var countDevice = 0;

                if(data.content != null){
                    // for(var i=0; i<data.content.data.length; i++){
                    //     total_device.push({
                    //         "x":data.content.data[i].date_time,
                    //         "y":data.content.data[i].total
                    //     });
                    //     countDevice = data.content.data[i].total;
                    // }
                    countDevice = data.content.total;
                }

                $("#countDevice").text(countDevice);
                // lineChart("chartTotalDevice", "device", total_device);
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

function countUserOfProject() {
    var r = jsRoutes.controllers.OverviewController.countUser7Day(projectId);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                total_user = [];
                var countUser = 0;

                if(data.content != null){
                    // for(var i=0; i<data.content.data.length; i++){
                    //     total_user.push({
                    //         "x":data.content.data[i].date_time,
                    //         "y":data.content.data[i].total
                    //     });
                    //     countUser = data.content.data[i].total;
                    // }
                    countUser = data.content.total;
                }

                $("#countUser").text(countUser);
                // lineChart("chartTotalUser", "user", total_user);
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

function countMessOfProject() {
    var r = jsRoutes.controllers.OverviewController.countMess7Day(projectId);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                total_msg = [];
                var countMgs = 0;

                if(data.content != null){
                    // for(var i=0; i<data.content.data.length; i++){
                    //     total_msg.push({
                    //         "x":data.content.data[i].date_time,
                    //         "y":data.content.data[i].total
                    //     });
                    //     countMgs = data.content.data[i].total;
                    // }
                    countMgs = data.content.total;
                }

                $("#countMess").text(countMgs);
                // lineChart("chartTotalMess", "mess", total_msg);
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

function lineChart(id, chart, data) {
    var options = {
        series: [{
            name: 'Total',
            data: data
        }],
        chart: {
            type: 'area',
            foreColor: "rgba(255, 255, 255, 0.65)",
            height: 400,
            // width: "100%",
            toolbar: {
                show: false
            },
            zoom: {
                enabled: false
            },
            dropShadow: {
                enabled: false,
                top: 3,
                left: 14,
                blur: 4,
                opacity: 0.12,
                color: '#0d6efd',
            },
            sparkline: {
                enabled: false
            }
        },
        markers: {
            size: 0,
            colors: ["#0d6efd"],
            strokeColors: "#fff",
            strokeWidth: 2,
            hover: {
                size: 7,
            }
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '45%',
                endingShape: 'rounded'
            },
        },

        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 3,
            curve: 'smooth'
        },
        fill: {
            type: 'gradient',
            gradient: {
                shade: 'light',
                type: 'vertical',
                shadeIntensity: 0.5,
                gradientToColors: ['#fff'],
                inverseColors: false,
                opacityFrom: 0.8,
                opacityTo: 0.5,
                stops: [0, 100]
            }
        },
        colors: ["#fff"],
        grid: {
            borderColor: 'rgba(255, 255, 255, 0.12)',
            show: true,
        },
        yaxis: {
            // labels: {
            //     formatter: function (value) {
            //         return value > 1000 ? (Math.round(value/1000) + "K") : value;
            //     }
            // },
        },
        // xaxis: {
        //     categories: categories,
        // },

        tooltip: {
            theme: 'dark',
            y: {
                formatter: function (val) {
                    return "" + val
                }
            }
        }
    };
    if(chart == "device"){
        chartDevice = new ApexCharts(document.querySelector("#" + id), options);
        chartDevice.render();
    } else if(chart == "mess"){
        chartMess = new ApexCharts(document.querySelector("#" + id), options);
        chartMess.render();
    } else if(chart == "user"){
        chartUser = new ApexCharts(document.querySelector("#" + id), options);
        chartUser.render();
    }

}

function poligonChart() {
    var options = {
        series: [44, 55, 13, 43],
        chart: {
            foreColor: 'rgba(255, 255, 255, 0.65)',
            // width: "100%",
            height: 250,
            type: 'pie',
        },
        colors: ["#673ab7", "#32ab13", "#f02769", "#ffc107"],
        labels: ['CoAP', 'HTTP/HTTPS', 'MQTT', 'Websocket'],
        responsive: [{
            breakpoint: 480,
            options: {
                chart: {
                    height: 360
                },
                legend: {
                    position: 'bottom'
                }
            }
        }]
    };
    var chart = new ApexCharts(document.querySelector("#chart3"), options);
    chart.render();
}

function getRamdom(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}

//update chart
function loadDataCount() {
    var r = jsRoutes.controllers.OverviewController.countDeviceAndUser(projectId);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#countDevice").text(data.content.total_device);
                $("#countMess").text(data.content.total_msg);
                $("#countUser").text(data.content.total_user);

                var curdate = Date.now();
                var logDate = moment.unix(curdate/1000).format("HH:mm");
                if(total_device.length >= 10){
                    total_device.shift();
                }
                total_device.push({
                    "x":logDate,
                    "y": data.content.total_device
                });

                if(total_msg.length >= 10){
                    total_msg.shift();
                }
                total_msg.push({
                    "x":logDate,
                    "y": data.content.total_msg
                });

                if(total_user.length >= 10){
                    total_user.shift();
                }
                total_user.push({
                    "x":logDate,
                    "y": data.content.total_user
                });

                updateSeriesChart(total_device, "device");
                updateSeriesChart(total_msg, "mess");
                updateSeriesChart(total_user, "user");
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

function updateSeriesChart(data, chart) {
    console.log(data);
    if(chart == "device"){
        chartDevice.updateSeries([{
            data: data
        }])
    } else if(chart == "mess"){
        chartMess.updateSeries([{
            data: data
        }])
    } else if(chart == "user"){
        chartUser.updateSeries([{
            data: data
        }])
    }
}