$(function () {
    "use strict";
    // chart 1
    renderChart1([414, 555, 257, 901, 613, 727, 414, 555, 257]);

    // chart 2
    renderChart2([414, 555, 257, 901, 613, 727, 414, 555, 257]);

// chart 3
    renderChart3([414, 555, 257, 901, 613, 727, 414, 555, 257]);


// chart 4
//     renderChart4([414, 555, 257, 901, 613, 727, 414, 555, 257]);


// chart 5
    renderChart5([414, 555, 257, 901, 613, 727, 414, 555, 257]);

// chart 12
//     Highcharts.chart('chart12', {
//         chart: {
//             plotBackgroundColor: null,
//             plotBorderWidth: null,
//             plotShadow: false,
//             type: 'pie',
//             styledMode: true
//         },
//         credits: {
//             enabled: false
//         },
//         title: {
//             text: 'May, 2021'
//         },
//         tooltip: {
//             pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
//         },
//         accessibility: {
//             point: {
//                 valueSuffix: '%'
//             }
//         },
//         plotOptions: {
//             pie: {
//                 allowPointSelect: false,
//                 cursor: 'pointer',
//                 dataLabels: {
//                     enabled: true,
//                     format: '<b>{point.name}</b>: {point.percentage:.1f} %'
//                 }
//             }
//         },
//         series: [{
//             name: 'Brands',
//             colorByPoint: true,
//             data: [{
//                 name: 'Hà Nội',
//                 y: 33,
//                 sliced: true,
//                 selected: true
//             }, {
//                 name: 'TP.Hồ Chí Minh',
//                 y: 23
//             }, {
//                 name: 'Đà Nẵng',
//                 y: 9
//             }, {
//                 name: 'Huế',
//                 y: 9
//             }, {
//                 name: 'Nha Trang',
//                 y: 7
//             }, {
//                 name: 'Quy Nhơn',
//                 y: 6
//             }, {
//                 name: 'Quảng Ngãi',
//                 y: 6
//             }, {
//                 name: 'Cà Mau',
//                 y: 5
//             }, {
//                 name: 'Khác',
//                 y: 2
//             }]
//         }]
//     });
    //end
});

function renderChart1(data) {
    var options1 = {
        series: [{
            name: 'Sessions',
            data: data
        }],
        chart: {
            type: 'line',
            height: 60,
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
                color: '#ec1b2e',
            },
            sparkline: {
                enabled: true
            }
        },
        markers: {
            size: 0,
            colors: ["#ec1b2e"],
            strokeColors: "#ec1b2e",
            strokeWidth: 2,
            hover: {
                size: 7
            }
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '45%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2.5,
            curve: 'smooth'
        },
        colors: ["#ec1b2e"],
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            theme: 'dark',
            fixed: {
                enabled: false
            },
            x: {
                show: false
            },
            y: {
                title: {
                    formatter: function (seriesName) {
                        return ''
                    }
                }
            },
            marker: {
                show: false
            }
        }
    };
    var chart1 = new ApexCharts(document.querySelector("#chart1"), options1);
    chart1.render();
}

function renderChart2(data) {
    var options2 = {
        series: [{
            name: 'Total Users',
            data: data
        }],
        chart: {
            type: 'bar',
            height: 60,
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
                color: '#ec1b2e'
            },
            sparkline: {
                enabled: true
            }
        },
        markers: {
            size: 0,
            colors: ["#ec1b2e"],
            strokeColors: "#ec1b2e",
            strokeWidth: 2,
            hover: {
                size: 7
            }
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '40%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2.5,
            curve: 'smooth'
        },
        colors: ["#ec1b2e"],
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            theme: 'dark',
            fixed: {
                enabled: false
            },
            x: {
                show: false
            },
            y: {
                title: {
                    formatter: function (seriesName) {
                        return ''
                    }
                }
            },
            marker: {
                show: false
            }
        }
    };
    var chart2 = new ApexCharts(document.querySelector("#chart2"), options2);
    chart2.render();
}

function renderChart3(data) {
    var options3 = {
        series: [{
            name: 'Page Views',
            data: data
        }],
        chart: {
            type: 'area',
            height: 60,
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
                color: '#ec1b2e',
            },
            sparkline: {
                enabled: true
            }
        },
        markers: {
            size: 0,
            colors: ["#ec1b2e"],
            strokeColors: "#ec1b2e",
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
            width: 2.5,
            curve: 'smooth'
        },
        fill: {
            type: 'gradient',
            gradient: {
                shade: 'light',
                type: "vertical",
                shadeIntensity: 0.5,
                gradientToColors: ["#ec1b2e"],
                inverseColors: true,
                opacityFrom: 0.2,
                opacityTo: 0.5,
                stops: [0, 50, 100],
                colorStops: []
            }
        },
        colors: ["#ec1b2e"],
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
        tooltip: {
            theme: 'dark',
            fixed: {
                enabled: false
            },
            x: {
                show: false
            },
            y: {
                title: {
                    formatter: function (seriesName) {
                        return ''
                    }
                }
            },
            marker: {
                show: false
            }
        }
    };
    var chart3 = new ApexCharts(document.querySelector("#chart3"), options3);
    chart3.render();
}

function renderChart4(data) {
    var options4 = {
        series: [{
            name: 'Bounce Rate',
            data: data
        }],
        chart: {
            type: 'bar',
            height: 60,
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
                color: '#ec1b2e'
            },
            sparkline: {
                enabled: true
            }
        },
        markers: {
            size: 0,
            colors: ["#ec1b2e"],
            strokeColors: "#ec1b2e",
            strokeWidth: 2,
            hover: {
                size: 7
            }
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '40%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2.4,
            curve: 'smooth'
        },
        colors: ["#ec1b2e"],
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            theme: 'dark',
            fixed: {
                enabled: false
            },
            x: {
                show: false
            },
            y: {
                title: {
                    formatter: function (seriesName) {
                        return ''
                    }
                }
            },
            marker: {
                show: false
            }
        }
    };
    var chart4 = new ApexCharts(document.querySelector("#chart4"), options4);
    chart4.render();
}

function renderChart5(data) {
    var options5 = {
        series: [{
            name: 'Avg. Session Duration',
            data: data
        }],
        chart: {
            type: 'line',
            height: 60,
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
                color: '#ec1b2e'
            },
            sparkline: {
                enabled: true
            }
        },
        markers: {
            size: 0,
            colors: ["#ec1b2e"],
            strokeColors: "#ec1b2e",
            strokeWidth: 2,
            hover: {
                size: 7
            }
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '45%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2.5,
            curve: 'smooth'
        },
        colors: ["#ec1b2e"],
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            theme: 'dark',
            fixed: {
                enabled: false
            },
            x: {
                show: false
            },
            y: {
                title: {
                    formatter: function (seriesName) {
                        return ''
                    }
                }
            },
            marker: {
                show: false
            }
        }
    };
    var chart5 = new ApexCharts(document.querySelector("#chart5"), options5);
    chart5.render();
}