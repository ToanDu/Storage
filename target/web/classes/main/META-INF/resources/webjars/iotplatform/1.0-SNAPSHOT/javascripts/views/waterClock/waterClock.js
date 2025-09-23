/**
 * Created by vtk-anhlt166 on 5/10/22.
 */
var chartColumn2;
var dataChartDay;
var dataChartMonth;
var chartTotalDay;
var chartTotalMonth;

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(loadDataChartTotalDay);
google.charts.setOnLoadCallback(loadDataChartTotalMonth);

$(document).ready(function () {
    initialize();
});

function loadDataChartTotalDay() {
    if (dataChartDay != null && dataChartDay.length > 0) {
        renderChartDataDay(dataChartDay);
    }
}

function loadDataChartTotalMonth() {
    if (dataChartMonth != null && dataChartMonth.length > 0) {
        renderChartDataMonth(dataChartMonth);
    }
}

function initialize(){
    $(window).resize(function(){
        loadDataChartTotalDay();
        loadDataChartTotalMonth();
    });
}

function drawChartDay() {
    var data = google.visualization.arrayToDataTable([
        ['Ngày', 'Lượng nước (m³)'],
        ['01/05/2022', 1000],
        ['02/05/2022', 1170],
        ['03/05/2022', 660],
        ['04/05/2022', 432],
        ['05/05/2022', 5435],
        ['06/05/2022', 3424],
        ['07/05/2022', 4321]
    ]);

    var options = {
        title: 'Biểu đồ Lượng nước sử dụng theo ngày 01 - 07/05/2022',
        bars: 'vertical',
        vAxis: {format: 'decimal'},
        // height: 400,
        colors: ['#1b9e77'],
        legend: { position: 'top', alignment: 'start' }

    };

    var chart = new google.visualization.ColumnChart(document.getElementById('columnchart_1'));
    chart.draw(data, options);
}

function drawChartMonth() {
    var data = google.visualization.arrayToDataTable([
        ['Date', 'Lượng nước (m³)'],
        ['01/2022', 10000],
        ['02/2022', 11700],
        ['03/2022', 6600],
        ['04/2022', 4320],
        ['05/2022', 54350]
    ]);

    var options = {
        title: 'Biểu đồ Lượng nước sử dụng theo tháng 01 - 05/2022',
        bars: 'vertical',
        vAxis: {format: 'decimal'},
        // height: 400,
        colors: ['#1b9e77'],
        legend: { position: 'top', alignment: 'start' }
    };

    chartColumn2 = new google.visualization.ColumnChart(document.getElementById('columnchart_2'));
    chartColumn2.draw(data, options);
}