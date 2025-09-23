function pieChartLowMoney(lowMoney, total) {
    var pie = Math.ceil(lowMoney*100/total);
    var options = {
        series: [lowMoney, total-lowMoney],
        chart: {
            foreColor: '#EA0033',
            height: 180,
            type: 'donut',
        },
        colors: ["#EA0033", "#aaa"],
        labels: ['TKG < 1000d', 'Còn lại'],
        dataLabels: {
            enabled: true,
            formatter: function (val) {
                return Math.floor(val*100)/100 + "%"
            },
        },
        legend: {
            show: false
        },
        plotOptions: {
            pie: {
                donut: {
                    labels: {
                        show: true,
                        // name: {
                        //     show: true,
                        //     fontSize: '12px',
                        //     fontFamily: 'Rubik',
                        //     color: '#dfsda',
                        //     offsetY: 0
                        // },
                        // value: {
                        //     show: true,
                        //     fontSize: '16px',
                        //     fontFamily: 'Helvetica, Arial, sans-serif',
                        //     color: undefined,
                        //     offsetY: 12,
                        //     formatter: function (val) {
                        //         return val
                        //     }
                        // },
                        name: {
                            show: false,
                        },
                        total: {
                            show: true,
                            label: '',
                            color: '#EA0033',
                            formatter: function () {
                                return lowMoney
                            }
                        }
                    }
                }
            }
        },
    };
    var chart = new ApexCharts(document.querySelector("#chartLowMoney"), options);
    chart.render();
}

function pieChart1BlockDebit(block, total) {
    var pie = Math.ceil(block*100/total);
    var options = {
        series: [block, total-block],
        chart: {
            foreColor: '#EA0033',
            height: 180,
            type: 'donut',
        },
        colors: ["#EA0033", "#aaa"],
        labels: ['Chặn 1 chiều nợ cước', 'Còn lại'],
        dataLabels: {
            enabled: true,
            formatter: function (val) {
                return Math.floor(val*100)/100 + "%"
            },
        },
        legend: {
            show: false
        },
        plotOptions: {
            pie: {
                donut: {
                    labels: {
                        show: true,
                        name: {
                            show: false,
                        },
                        total: {
                            show: true,
                            label: '',
                            color: '#EA0033',
                            formatter: function () {
                                return block
                            }
                        }
                    }
                }
            }
        }
    };
    var chart = new ApexCharts(document.querySelector("#chart1BlockDebit"), options);
    chart.render();
}

function pieChartOutOfData(outData, total) {
    var pie = Math.ceil(outData*100/total);
    var options = {
        series: [outData, total-outData],
        chart: {
            foreColor: '#EA0033',
            height: 180,
            type: 'donut'
        },
        colors: ["#EA0033", "#aaa"],
        labels: [Messages("dashboard.dataLimitExceeded"), Messages("dashboard.dataRemaining")],
        dataLabels: {
            enabled: true,
            formatter: function (val) {
                return Math.floor(val*100)/100 + "%"
            }
        },
        legend: {
            show: false
        },
        plotOptions: {
            pie: {
                donut: {
                    labels: {
                        show: true,
                        name: {
                            show: false,
                        },
                        total: {
                            show: true,
                            label: '',
                            color: '#EA0033',
                            formatter: function () {
                                return outData
                            }
                        }
                    }
                }
            }
        }
    };
    var chart = new ApexCharts(document.querySelector("#chartOutOfData"), options);
    chart.render();
}