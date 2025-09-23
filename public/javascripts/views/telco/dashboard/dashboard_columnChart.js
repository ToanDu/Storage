function getDataDashboardWithMonth() {
    const body = { userId, nMonth: 5 };
    const route = jsRoutes.controllers.TelcoDashboardController.getDataDashboardWithMonth();

    $.ajax({
        type: route.type,
        url: route.url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(body),
        success: function (datas) {
            const dataList = datas?.content?.data;
            if (!dataList || dataList.length < 2) return;

            const lastIndex = dataList.length - 1;
            const current = dataList[lastIndex]; // tháng hiện tại
            const previous = dataList[lastIndex - 1]; // tháng trước đó

            const { totalSub: totalSubNow } = current;
            const { totalSub: totalSubPre } = previous;
            //PHÂN BỔ THUÊ BAO
            renderSubscriberDistributionChart(current);

            // Hiển thị số thuê bao mới
            $("#totalSubNow").text(Number(totalSubNow - totalSubPre).toLocaleString());
            $("#totalUsedData").text(formatDataSize(current.totalUsedData));
            // % tăng trưởng thuê bao
            if (typeof totalSubNow === "number" && typeof totalSubPre === "number" && totalSubPre !== 0) {
                const growthPercent = (((totalSubNow - totalSubPre) / totalSubPre) * 100).toFixed(2);
                const growthClass = growthPercent >= 0 ? 'up' : 'down';
                const sign = growthPercent >= 0 ? '+' : '-';
                $("#pieIncreaseSubs").html(
                    `<span class="telco__totals-item-percent--${growthClass}">${sign} ${Math.abs(growthPercent)}${Messages("%")}</span>`
                );
            } else {
                $("#pieIncreaseSubs").html('<span></span>');
            }

            // Chuẩn bị dữ liệu biểu đồ
            const dataActive = [];
            const dataCancel = [];
            const categoryMonths = [];

            for (let i = 0; i < dataList.length; i++) {
                const { activeSub = 0, canceledSub = 0, month = 0 } = dataList[i];
                dataActive.push(activeSub);
                dataCancel.push(canceledSub);
                // Chuyển đổi từ yyyy-mm sang mm/yyyy
                if (typeof month === "string" && month.includes("-")) {
                    const [year, mon] = month.split("-");
                    categoryMonths.push(`${mon}/${year}`);
                } else {
                    categoryMonths.push(month);
                }
            }

            renderChartSubWithMonth(dataActive, dataCancel, categoryMonths);
        }
    });
}

// Hàm format dd/mm/yyyy
function formatDate(rawDate) {
    if (!rawDate) return "";
    const dateObj = new Date(rawDate);
    const day = String(dateObj.getDate()).padStart(2, '0');
    const month = String(dateObj.getMonth() + 1).padStart(2, '0');
    const year = dateObj.getFullYear();
    return `${day}/${month}/${year}`;
}


function formatDataSize(bits) {
    if (bits == null || isNaN(bits)) return "0 B";
    const units = ["B", "KB", "MB", "GB", "TB"];
    let size = bits;
    let unitIndex = 0;
    while (size >= 1024 && unitIndex < units.length - 1) {
        size = size / 1024;
        unitIndex++;
    }
    // Giới hạn 2 số thập phân
    return size.toFixed(2) + " " + units[unitIndex];
}

function renderChartActiveSubWithMonth(data, category) {
    var options = {
        series: [{
            name: 'Thuê bao hoạt động',
            data: data
        }],
        chart: {
            foreColor: 'rgb(234, 0, 51)',
            type: 'bar',
            height: 400
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '35%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            colors: ['transparent']
        },
        // title: {
        //     text: 'TK thuê bao hoạt động',
        //     align: 'left',
        //     style: {
        //         fontSize: '14px'
        //     }
        // },
        colors: ["#bada55"],
        xaxis: {
            categories: category,
        },
        // yaxis: {
        //     title: {
        //         text: 'TK Thuê bao hoạt động'
        //     }
        // },
        fill: {
            opacity: 1
        },
        grid: {
            show: true,
            borderColor: 'rgb(170, 170, 170)',
            strokeDashArray: 3,
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
    var chart = new ApexCharts(document.querySelector("#chartActiveSubWithMonth"), options);
    chart.render();
}

function renderChartCancledSubWithMonth(data, category) {
    var options = {
        series: [{
            name: 'Thuê bao cắt hủy',
            data: data
        }],
        chart: {
            foreColor: 'rgb(234, 0, 51)',
            type: 'bar',
            height: 400
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '35%',
                endingShape: 'rounded'
            }
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            colors: ['transparent']
        },
        // title: {
        //     text: 'TK thuê bao cắt hủy',
        //     align: 'left',
        //     style: {
        //         fontSize: '14px',
        //         fontStyle: 'normal',
        //     }
        // },
        colors: ["#aaa"],
        xaxis: {
            categories: category,
        },
        // yaxis: {
        //     title: {
        //         text: 'TK Thuê bao cắt hủy'
        //     }
        // },
        fill: {
            opacity: 1
        },
        grid: {
            show: true,
            borderColor: 'rgb(170, 170, 170)',
            strokeDashArray: 3,
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
    var chart = new ApexCharts(document.querySelector("#chartCancledSubWithMonth"), options);
    chart.render();
}

/**
 * Render chart lũy kế thuê bao;
 * @param {*} dataActive
 * @param {*} dataCancle
 * @param {*} categoryMonths
 */

function renderChartSubWithMonth(dataActive, dataCancle, categoryMonths) {
    // Tìm giá trị lớn nhất trong cả 2 mảng
    const maxActive = Math.max(...dataActive);
    const maxCancel = Math.max(...dataCancle);
    const maxValue = Math.max(maxActive, maxCancel); // Max thật

    let options = {
            chart: {
                type: 'bar',
                height: 300,
                toolbar: { show: false },
                events: {
                    dataPointMouseEnter: function(event, chartContext, config) {
                        const chart = chartContext.el;
                        const allBars = chart.querySelectorAll('.apexcharts-bar-area');
                        const hoveredSeriesIndex = config.seriesIndex;
                        const hoveredDataPointIndex = config.dataPointIndex;
                        
                        // Giảm opacity cho tất cả các cột trước
                        allBars.forEach(bar => {
                            bar.style.opacity = '0.3';
                        });
                        
                        // Tìm và giữ nguyên opacity cho cột đang hover
                        const seriesGroups = chart.querySelectorAll('.apexcharts-series');
                        if (seriesGroups[hoveredSeriesIndex]) {
                            const barsInSeries = seriesGroups[hoveredSeriesIndex].querySelectorAll('.apexcharts-bar-area');
                            if (barsInSeries[hoveredDataPointIndex]) {
                                barsInSeries[hoveredDataPointIndex].style.opacity = '1';
                            }
                        }
                    },
                    dataPointMouseLeave: function(event, chartContext, config) {
                        // Khôi phục opacity cho tất cả các cột
                        const chart = chartContext.el;
                        const allBars = chart.querySelectorAll('.apexcharts-bar-area');
                        allBars.forEach(bar => {
                            bar.style.opacity = '1';
                        });
                    }
                }
            },
        series: [
            { name: 'Hoạt động', data: dataActive },
            { name: 'Cắt/Hủy', data: dataCancle }
        ],
        colors: ['#4EE6A6', '#BEBEBE'],
        xaxis: {
            categories: categoryMonths,
        },
        yaxis: {
            min: 0,
            max: maxValue,
            tickAmount: 5,
            labels: {
                formatter: val => (val >= 1000 ? Math.round(val / 1000).toFixed(2) + 'k' : Math.round(val).toFixed(2))
            }
        },

        tooltip: {
            y: {
                formatter: val => val.toLocaleString() + " " + "thuê bao"
            }
        },
        plotOptions: {
            bar: {
                columnWidth: '50%',
                borderRadius: 2
            }
        },
        dataLabels: {
            enabled: false
        },
        states: {
            hover: {
                filter: {
                    type: 'none' // Tắt hiệu ứng hover mặc định
                }
            }
        }
    };
    
    new ApexCharts(document.querySelector("#chart-cumulative"), options).render();
}
