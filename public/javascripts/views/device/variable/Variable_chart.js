/**
 * Created by vtk-anhlt166 on 6/9/21.
 */
var categoriesChart = [];
var dataChart = [];
function showChartOfVariable(idVar, name) {
    console.log(idVar);
    localStorage.nameVarCurrent = name;

    var Data = new FormData();
    Data.varName = name;
    Data.deviceId = localStorage.deviceId;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceVariableController.getDataVariableById();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success && data.content != null){
                $("#chartModal").modal('show');
                categoriesChart = [];
                dataChart = [];

                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        dataChart.push(data.content[i].value);

                        var curdate = new Date();
                        curdate.setTime(data.content[i].updatetime/1000000000);
                        console.log(curdate);
                        var logDate = moment.unix(curdate).format("DD/MM/YYYY HH:mm");
                        categoriesChart.push(logDate);
                    }

                    console.log(categoriesChart);
                    console.log(dataChart);

                    chooseTypeChartVariable();
                } else {
                    showNotification('danger', Messages("noti.notFoundData"));
                }

            }else{
                showNotification('danger',data.errorString, data.status);
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
    // $("#checkBoxChart_0").click();
}

function chooseTypeChartVariable() {
    chartLine();

    chartColumn();

    tableHistoryVariable();
}

function chartLine() {
    var options = {
        series: [{
            name: 'Likes',
            data: dataChart
        }],
        chart: {
            foreColor: 'rgba(255, 255, 255, 0.65)',
            height: 400,
            type: 'line',
            zoom: {
                enabled: false
            },
            toolbar: {
                show: true
            },
            dropShadow: {
                enabled: true,
                top: 3,
                left: 14,
                blur: 4,
                opacity: 0.10,
            }
        },
        stroke: {
            width: 5,
            curve: 'smooth'
        },
        grid: {
            show: true,
            borderColor: 'rgba(255, 255, 255, 0.12)',
            strokeDashArray: 4,
        },
        tooltip: {
            theme: 'dark',
        },
        xaxis: {
            type: 'date',
            categories: categoriesChart,
        },
        title: {
            text: 'Line Chart',
            align: 'left',
            style: {
                fontSize: "16px",
                color: '#fff'
            }
        },
        fill: {
            type: 'gradient',
            gradient: {
                shade: 'light',
                gradientToColors: ['#fff'],
                shadeIntensity: 1,
                type: 'horizontal',
                opacityFrom: 1,
                opacityTo: 1,
                stops: [0, 100, 100, 100]
            },
        },
        markers: {
            size: 4,
            colors: ["#000"],
            strokeColors: "#fff",
            strokeWidth: 2,
            hover: {
                size: 7,
            }
        },
        colors: ["#fff"],
        yaxis: {
            title: {
                text: 'Engagement',
            },
        }
    };
    var chart = new ApexCharts(document.querySelector("#divChartLineVariable"), options);
    chart.render();
}

function chartColumn() {
    var chartjs = '<div class="chart-container1"><canvas id="chartJs"></canvas></div>';
    $("#divChartColumnVariable").html(chartjs);

    new Chart(document.getElementById("chartJs"), {
        type: 'bar',
        data: {
            labels: categoriesChart,
            datasets: [{
                label: localStorage.nameVarCurrent,
                backgroundColor: "#fff",
                data: dataChart
            }
                // , {
                //     label: "Europe",
                //     backgroundColor: "rgba(255, 255, 255, 0.24)",
                //     data: [408, 547, 675, 734]
                // }
            ]
        },
        options: {
            maintainAspectRatio: false,
            title: {
                display: true,
                text: 'BAR CHART'
            },
            legend: {
                position :"top",
                display: true,
                labels: {
                    fontColor: '#fff',
                    boxWidth:15
                }
            },
            scales: {
                xAxes: [{
                    ticks: {
                        beginAtZero: true,
                        fontColor: '#fff'
                    },
                    gridLines: {
                        display: true,
                        color: "rgba(255, 255, 255, 0.24)"
                    },
                }],
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                        fontColor: 'rgba(255, 255, 255, 0.64)'
                    },
                    gridLines: {
                        display: true,
                        color: "rgba(255, 255, 255, 0.24)"
                    },
                }]
            }
        }
    });
}

function tableHistoryVariable() {
    var tbody = "";
    for(var i=0; i<dataChart.length; i++){
        tbody += "<tr class='text-white'>" +
            "<td>"+ (i+1) +"</td>" +
            "<td>"+ localStorage.nameVarCurrent +"</td>" +
            "<td>"+ dataChart[i] +"</td>" +
            "<td>"+ categoriesChart[i] +"</td>" +
            "</tr>";
    }
    $("#divTableVariable").find("tbody").html(tbody);
}

function getRamdom(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}