/**
 * Created by vtk-anhlt166 on 12/21/22.
 */
$(document).ready(function () {
    getDataDashboardTelco();
    getTop5DataUsersOfMonth();
    getSubscriberStatistics();
    getAlertDashboard();
    getTrafficUsage();
    getDataWithRegion();
    if(view_dashboard_monthly_sub == "true"){
        getDataDashboardWithMonth();
    }

    if(view_dashboard_debit == "true"){
        getBalanceDashboardTelco();
    }

    document.querySelectorAll('.tab-btn').forEach(btn => {
      btn.addEventListener('click', function () {
        document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
        this.classList.add('active');
          // Show loading effect
        const chartContainer = document.querySelector("#chart-data-usage");
        if (chartContainer) {
            chartContainer.innerHTML = '<div class="loading-spinner" style="text-align:center;padding:120px 0;"><span class="spinner-border text-danger" role="status"></span></div>';
        }

      });
    });

    // Sự kiện click "Theo ngày"
    $("#filterByDay").on("click", function () {
        getTrafficUsage();
    });

    // Sự kiện click "Theo tháng"
    $("#filterByMonth").on("click", function () {
        // Gọi API lấy dữ liệu theo tháng cho biểu đồ lưu lượng sử dụng
        var body = { userId: userId, nMonth: 5 };
        var r = jsRoutes.controllers.TelcoDashboardController.getDataDashboardWithMonth();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (datas) {
                if (datas && datas.content && datas.content.data) {
                    renderTrafficUsageChart(datas, 'month');
                }
            }
        });
    });

    // Sau 5 phút, gọi lại 5 hàm trên để cập nhật
    setInterval(function () {
       refreshData();
    }, 300000); // 300000 ms = 5 phút
});

function refreshData(){
    getDataDashboardTelco();
    getTop5DataUsersOfMonth();
    getSubscriberStatistics();
    getDataDashboardWithMonth();
    getBalanceDashboardTelco();
    getTrafficUsage();
}

var totalSub = 0;
function getDataDashboardTelco() {
    const now = new Date();
    const dayCurrent = moment(now).format("DD/MM/YYYY");
    const lastDay = moment(now).subtract(7, 'days').format("DD/MM/YYYY");
    const body = {
        userId: userId,
        isCurrent: true,
        from: lastDay,
        to: dayCurrent
    };
    if($("#lowMoney").text() == "--"){
        StartProcess();
    }
    
    const r = jsRoutes.controllers.TelcoDashboardController.getDataDashboardTelco();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas) {
            const content = datas.content;
            if (content && content.data && content.data.length > 0) {
                const lastData = content.data[content.data.length - 1];

                if (view_dashboard_total_sub == "true") {
                    $("#totalSub").html(Number(lastData.totalSub).toLocaleString());
                }
                const formattedDate = formatDate(lastData.date);
                $("#tooltip_date").attr('title', `Dữ liệu thống kê tính đến ${formattedDate}`);
                $("#lowMoney").text(content.data[content.data.length - 1].lowMoneySub);
                $("#noDataLeft").text(content.data[content.data.length - 1].outOfDataSub);

                // if (view_dashboard_warning == "true") {
                //     pieChartLowMoney(content.data[0].lowMoneySub, content.data[0].totalSub);
                //     pieChart1BlockDebit(content.data[0].oneWayBlockHasDebit, content.data[0].totalSub);
                //     pieChartOutOfData(content.data[0].outOfDataSub, content.data[0].totalSub);
                // }
            } else if (datas.status == 401) {
                showNotification('danger', Messages("noti.sessionTimeOut"));
                setTimeout(() => {
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                }, 1500);
            } else {
                showNotification('danger', datas.errorString);
            }
        },
        error: function(xhr) {
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function() {
            FinishProcess();
        }
    });
}
function getTrafficUsage() {
    // Gọi API lấy dữ liệu theo ngày chỉ cho biểu đồ lưu lượng sử dụng
    let now = new Date();
    let dayCurrent = moment(now).format("DD/MM/YYYY");
    let lastDay = moment(now).subtract(7, 'days').format("DD/MM/YYYY");
    let body = {
        userId: userId,
        isCurrent: true,
        from: lastDay,
        to: dayCurrent
    };
    let r = jsRoutes.controllers.TelcoDashboardController.getDataDashboardTelco();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            if (datas && datas.content && datas.content.data) {
                renderTrafficUsageChart(datas, 'day');
            }
        }
    });
}


function renderProgressCountStatusTB(active, block1, block2, canceledSub) {
    var total = active + block1 + block2 + canceledSub;
    var pieActive = 100-Math.round(block1*100/total)-Math.round(block2*100/total)-Math.round(canceledSub*100/total);
    var pieBlockOne = Math.round(block1*100/total);
    var pieBlockTwo = Math.round(block2*100/total);
    var pieCancel = Math.round(canceledSub*100/total);

    document.getElementById("pieAtiveSubs").style.width = pieActive + "%";
    document.getElementById("pieBlock1Subs").style.width = pieBlockOne + "%";
    document.getElementById("pieBlock2Subs").style.width = pieBlockTwo + "%";
    document.getElementById("pieCancleSubs").style.width = pieCancel + "%";


    if(pieActive > 25){
        $("#pieAtiveSubs").html(pieActive  + " % " + Messages("dashboard.pieChart.active"));
    }
    if(pieBlockOne > 25){
        $("#pieBlock1Subs").html(pieBlockOne  + " % " + Messages("dashboard.pieChart.block1Way"));
    }
    if(pieBlockTwo > 25){
        $("#pieBlock2Subs").html(pieBlockOne  + " % " + Messages("dashboard.pieChart.block2Way"));
    }
    if(pieCancel > 25){
        $("#pieCancleSubs").html(pieCancel  + " % " + Messages("dashboard.pieChart.cancelled"));
    }
}

function renderProgressPrevPostTB(prev, post) {
    var total = prev + post;
    var pieBefore = Math.round(post*100/total);
    var piePrev = 100-Math.round(post*100/total);

    document.getElementById("piePrevSubs").style.width = piePrev + "%";
    document.getElementById("piePostSubs").style.width = pieBefore + "%";

    if(piePrev > 25){
        $("#piePrevSubs").html(piePrev  + " % " + Messages("dashboard.pieChart.prepaid"));
    }
    if(pieBefore > 25){
        $("#piePostSubs").html(pieBefore  + " % " + Messages("dashboard.pieChart.postpaid"));
    }
}

function renderChartPieSubActive(a, b , c) {
    var total = a + b + c;
    var pieActive = 100-Math.round(b*10000/total)/100-Math.round(c*10000/total)/100;
    var pieBlockOne = Math.round(b*10000/total)/100;
    var pieBlockTwo = Math.round(c*10000/total)/100;
    var options = {
        series: [pieActive, pieBlockOne, pieBlockTwo],
        chart: {
            foreColor: 'rgba(255, 255, 255, 0.65)',
            height: 160,
            type: 'donut'
        },
        colors: ["#299AFF", "#EFDD25", "#FF8131"],
        labels: ['TB hoạt động', 'TB chặn 1 chiều', 'TB chặn 2 chiều'],
        dataLabels: {
            enabled: false
        },
        legend: {
            show: false
        }
    };
    var chart = new ApexCharts(document.querySelector("#chart1"), options);
    chart.render();

    $("#tbActivePer").html(pieActive.toFixed(2) + "%");
    $("#tbOneWayPie").html(pieBlockOne.toFixed(2) + "%");
    $("#tbTwoWayPie").html(pieBlockTwo.toFixed(2) + "%");

}

function renderChartPieSubPrevPost(a, b) {
    var total = a + b;
    var pieBefore = Math.round(b*10000/total)/100;
    var piePrev = 100-Math.round(b*10000/total)/100;
    var options = {
        series: [piePrev, pieBefore],
        chart: {
            foreColor: 'rgba(255, 255, 255, 0.65)',
            height: 160,
            type: 'donut'
        },
        colors: ["#299AFF", "#52C93F"],
        labels: ['TB trả trước', 'TB trả sau'],
        dataLabels: {
            enabled: false
        },
        legend: {
            show: false
        }
    };
    var chart = new ApexCharts(document.querySelector("#chart2"), options);
    chart.render();

    $("#tbPrevPie").html(piePrev.toFixed(2) + "%");
    $("#tbPostPie").html(pieBefore.toFixed(2) + "%");
}

function getBalanceDashboardTelco() {
    var body = new FormData();
    body.userId = userId;

    // StartProcess();
    var r = jsRoutes.controllers.TelcoDashboardController.getBalanceDashboardTelco();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            if(datas.success){
                if(datas.content.data != null){
                    $("#adjustAmountBalance").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data.adjustAmount)));

                    $("#paymentBalance").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data.payment)));

                    $("#excessCashBalance").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data.excessCash)));

                    $("#staOfCycleBalance").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data.staOfCycle)));

                    $("#hotChargeBalance").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data.hotCharge)));

                    $("#remainAmountBalance").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data.remainAmount)));

                }

            }
        },
        error: function (xhr) {
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function getTop5DataUsersOfMonth() {
    var body = {};
    body.limit = 10;

    var now = new Date();

    // Lấy ngày đầu tháng hiện tạis
    var firstDayCurrentMonth = new Date(now.getFullYear(), now.getMonth(), 1);

    // Lấy hôm nay
    var today = now;

    body.from = formatDate(firstDayCurrentMonth);
    body.to = formatDate(today);
    body.userId = userId;

    var r = jsRoutes.controllers.TelcoDashboardController.getTop5DataUsersOfMonth();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            if (datas && datas.content && datas.content.data && Array.isArray(datas.content.data.data) && datas.content.data.data.length > 0) {
                var rows = '';
                datas.content.data.data.forEach(function(item, idx) {
                    var mb = item.total_vol ? (item.total_vol / (1024 * 1024 * 1024)).toFixed(2) : '0';
                    rows += `<tr>
                        <td class="p-3">${idx + 1}</td>
                        <td class="p-3">${item.isdn}</td>
                        <td class="p-3">${mb}</td>
                    </tr>`;
                });
                $('tbody[ib="top5DataUsersOfMonth"]').html(rows);
            } else {
                $('tbody[ib="top5DataUsersOfMonth"]').html(`<tr><td colspan="3" class="text-center">${Messages("tableNoData")}</td></tr>`);
            }
        },
        error: function (xhr) {
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function () {}
    });
}

// Định dạng lại ngày thành dd/mm/yyyy
function formatDate(date) {
    var dd = String(date.getDate()).padStart(2, '0');
    var mm = String(date.getMonth() + 1).padStart(2, '0'); // tháng bắt đầu từ 0
    var yyyy = date.getFullYear();
    return dd + '/' + mm + '/' + yyyy;
}

function getSubscriberStatistics() {

    var body = {};
    body.userId = userId;
    var r = jsRoutes.controllers.TelcoDashboardController.getSubscriberStatistics();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            if (datas) {
                let total = datas.content.total;
                

                let prepaidData = datas.content.prepaid_subscriber_status_count;
                let postpaid = datas.content.postpaid_subscriber_status_count;

                // Tính tổng của prepaid_subscriber_status_count
                let prepaidTotal = 0;
                $.each(prepaidData, function (key, value) {
                    prepaidTotal += value;
                });

                // Tính tổng của postpaid_subscriber_status_count
                let postpaidTotal = 0;
                $.each(postpaid, function (key, value) {
                    postpaidTotal += value;
                });
                //THUÊ BAO HOẠT ĐỘNG
                $("#totalSub_data").text(Number(datas.content.total).toLocaleString());
                renderSubscriberStatistics(prepaidTotal, prepaidData, 'chart-subscriber-statistics-prepaid', 'Thuê bao trả trước');
                renderSubscriberStatistics(postpaidTotal, postpaid, 'chart-subscriber-statistics-postpaid', 'Thuê bao trả sau');
            }
           
        },
        error: function (xhr) {
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function () {}
    });
}
//THUÊ BAO HOẠT ĐỘNG
function renderSubscriberStatistics(total, data, containerId, chartTitle = "") {
    const labelMap = {
        normal: Messages("dashboard.status.normal"),
        not_activate: Messages("dashboard.status.notActivate"),
        block_one_way_system: Messages("dashboard.status.blockOneWaySystem"),
        block_two_way_system: Messages("dashboard.status.blockTwoWaySystem"),
        block_one_way_user: Messages("dashboard.status.blockOneWayUser"),
        block_two_way_user: Messages("dashboard.status.blockTwoWayUser"),
        block_one_way_user_one_way_system: Messages("dashboard.status.blockOneWayUserOneWaySystem"),
        block_one_way_user_two_way_system: Messages("dashboard.status.blockOneWayUserTwoWaySystem"),
        block_two_way_user_one_way_system: Messages("dashboard.status.blockTwoWayUserOneWaySystem"),
        block_two_way_user_two_way_system: Messages("dashboard.status.blockTwoWayUserTwoWaySystem"),
        blocked_telecom_usage: Messages("dashboard.status.blockedTelecomUsage")
    };

    const labels = [];
    const values = [];

    Object.entries(data).forEach(([key, val]) => {
        if (val > 0) {
            labels.push(labelMap[key] || key);
            values.push(val);
        }
    });

    const container = document.querySelector(`#${containerId}`);
    if (container) {
        container.innerHTML = ""; // Clear container

        // Tạo vùng chart holder
        const chartDiv = document.createElement("div");
        chartDiv.style.position = "relative";

        // Tạo chart và tiêu đề
        const chartTitleDiv = document.createElement("div");
        chartTitleDiv.className = "chart-title-inside";
        chartTitleDiv.textContent = chartTitle;
        chartTitleDiv.style.textAlign = "center";
        chartTitleDiv.style.marginTop = "10px";
        chartTitleDiv.style.fontSize = ".75rem";

        container.appendChild(chartDiv);

        if (values.length === 0) {
            // Không có dữ liệu
            const options = {
                series: [1],
                chart: { type: 'donut', width: 200 },
                labels: [Messages("tableNoData")],
                colors: ["#e0e0e0"],
                tooltip: {
                    enabled: true,
                    custom: function() {
                        return `<div style="padding:8px 12px;">${Messages("tableNoData")}</div>`;
                    }
                },
                legend: { show: false },
                dataLabels: { enabled: false },
                states: {
                    hover: {
                        filter: {
                            type: 'none'
                        }
                    },
                    active: {
                        filter: {
                            type: 'none'
                        }
                    }
                }
            };
            new ApexCharts(chartDiv, options).render();
        } else {
            const options = {
                series: values,
                chart: { 
                    type: 'donut', 
                    width: 200,
                    events: {
                        dataPointMouseEnter: function(event, chartContext, config) {
                            setTimeout(() => {
                                const chart = chartContext.el;
                                // Thử nhiều selector khác nhau cho donut chart
                                let allSlices = chart.querySelectorAll('.apexcharts-pie-slice path');
                                if (allSlices.length === 0) {
                                    allSlices = chart.querySelectorAll('.apexcharts-pie-area');
                                }
                                if (allSlices.length === 0) {
                                    allSlices = chart.querySelectorAll('path[class*="apexcharts-pie"]');
                                }
                                if (allSlices.length === 0) {
                                    allSlices = chart.querySelectorAll('.apexcharts-datalabel-label');
                                }
                                
                                const hoveredDataPointIndex = config.dataPointIndex;
                                
                                // Giảm opacity cho tất cả các slice
                                allSlices.forEach((slice, index) => {
                                    slice.style.opacity = '0.3';
                                });
                                
                                // Giữ nguyên opacity cho slice đang hover
                                if (allSlices[hoveredDataPointIndex]) {
                                    allSlices[hoveredDataPointIndex].style.opacity = '1';
                                }
                            }, 10);
                        },
                        dataPointMouseLeave: function(event, chartContext, config) {
                            setTimeout(() => {
                                const chart = chartContext.el;
                                // Khôi phục opacity cho tất cả các slice
                                let allSlices = chart.querySelectorAll('.apexcharts-pie-slice path');
                                if (allSlices.length === 0) {
                                    allSlices = chart.querySelectorAll('.apexcharts-pie-area');
                                }
                                if (allSlices.length === 0) {
                                    allSlices = chart.querySelectorAll('path[class*="apexcharts-pie"]');
                                }
                                if (allSlices.length === 0) {
                                    allSlices = chart.querySelectorAll('.apexcharts-datalabel-label');
                                }
                                
                                allSlices.forEach(slice => {
                                    slice.style.opacity = '1';
                                });
                            }, 10);
                        }
                    }
                },
                labels,
                colors: ["#d6b5fc", "#7f8bff", "#a8a3ff", "#ffddaf", "#ffa55c", "#ffbd84"],
                tooltip: {
                    custom: function({ series, seriesIndex, w }) {
                        const val = series[seriesIndex];
                        const percent = ((val / total) * 100).toFixed(2);
                        const label = w.globals.labels[seriesIndex];
                        return `
                            <div style="padding:8px 12px;">
                            ${label}: ${percent} % (${val.toLocaleString()} thuê bao) 
                            </div>
                        `;
                    }
                },
                legend: { show: false },
                dataLabels: {
                    enabled: false // Ẩn hiển thị % trên chart
                },
                states: {
                    hover: {
                        filter: {
                            type: 'none' // Tắt hiệu ứng hover mặc định
                        }
                    }
                }
            };
            new ApexCharts(chartDiv, options).render();
        }

        // Gắn tiêu đề bên trong container, dưới biểu đồ
        container.appendChild(chartTitleDiv);
    }
}


/**
 * Render chart phân bổ thuê bao;
 * @param {*} data - data được trả ra từ API
 */
function renderSubscriberDistributionChart($data = null) {
    // Biến dưới đây hiển thị phần trăm của các loại thuê bao
    let postPaidPercent = 0;  // Trả sau
    let prePaidPercent = 0;   // Trả trước
    let cancelledStatusPercent = 0; // Cắt/Hủy
    let activeStatusPercent = 0;    // Hoạt động

    // Biến duong dưới đây hiển thị số lượng thuê bao thực tế trong tooltip
    let postPaidSubData = 0; // Trả sau
    let prePaidSubData = 0;  // Trả trước
    let canceledSubData = 0; // Cắt/Hủy
    let activeSubData = 0; // Hoạt động

    let {postPaidSub, prePaidSub, canceledSub, activeSub} = $data;

    if (view_dashboard_status_sub == "true") {
        let total = canceledSub + activeSub;
        //tooltip
        canceledSubData = canceledSub;
        activeSubData = activeSub;
        // Tính phần trăm
        cancelledStatusPercent = Math.round((canceledSub/ total) * 100);
        activeStatusPercent = Math.round((activeSub/ total) * 100);
    }

    if (view_dashboard_paytype_sub == "true") {
        let total = postPaidSub + prePaidSub;
        //tooltip
        postPaidSubData = postPaidSub;
        prePaidSubData = prePaidSub;
        // Tính phần trăm
        postPaidPercent = Math.round((postPaidSub/ total) * 100);
        prePaidPercent = Math.round((prePaidSub/ total) * 100);
    }

    const actualValues = [
        [postPaidSubData, 0],         
        [prePaidSubData, 0],         
        [0, canceledSubData],         
        [0, activeSubData]            
    ];
    const chartId = "chart-subscriber-distribution";
    const chartContainer = document.querySelector(`#${chartId}`);
    if (chartContainer) chartContainer.innerHTML = "";

    let options1 = {
        chart: {
            type: 'bar',
            stacked: true,
            height: 300,
            toolbar: { show: false },
            events: {
                legendClick: function () {
                    // Khi click legend, đợi chart render xong rồi gán lại hover
                    setTimeout(() => {
                        bindHoverEvents();
                    }, 300);
                }
            }
        },
        series: [
            { name: 'Trả sau', data: [postPaidPercent, 0] },
            { name: 'Trả trước', data: [prePaidPercent, 0] },
            { name: 'Cắt/Hủy', data: [0, cancelledStatusPercent] },
            { name: 'Hoạt động', data: [0, activeStatusPercent] }
        ],
        colors: ['#C893FD', '#E07CBC', '#FFA9BF', '#FE5F88'],
        xaxis: {
            categories: ['Loại thuê bao', 'Trạng thái thuê bao']
        },
        yaxis: {
            min: 0,
            max: 100,
            tickAmount: 10,
            forceNiceScale: false,
            labels: {
                formatter: function (val) {
                    const targets = [0, 30, 70, 100];
                    return targets.includes(Math.round(val)) ? `${val}%` : '';
                }
            }
        },
        plotOptions: {
            bar: {
                columnWidth: '20%'
            }
        },
        grid: {
            show: true,
            borderColor: "#dddddd",
            strokeDashArray: 5,
            xaxis: {
                lines: {
                    show: false,
                },
            },
            padding: {
                top: 5,
                right: 20,
            },
        },
        legend: {
            position: 'top',
            horizontalAlign: 'left',
            fontSize: '12px',
            markers: {
                width: 12,
                height: 12
            }
        },
        tooltip: {
            custom: function ({ series, seriesIndex, dataPointIndex, w }) {
                const actual = actualValues[seriesIndex][dataPointIndex];
                if (actual === 0) return "";

                const seriesName = w.globals.seriesNames[seriesIndex];
                const xLabel = w.globals.labels[dataPointIndex];
                const seriesColor = w.config.colors[seriesIndex];

                // Nội dung mô tả chi tiết
                let description = '';
                if (seriesName === 'Trả sau' || seriesName === 'Trả trước') {
                    description = '(Tính trên tổng số thuê bao đang hoạt động)';
                }

                return `
                <div style="min-width: 180px; font-family: sans-serif;">
                    <!-- X-axis label -->
                    <div style="background: #f2f2f2; padding: 6px 10px; font-size: 13px; border-bottom: 1px solid #ECEFF1;">
                        ${xLabel}
                    </div>

                    <!-- Dòng tên + chấm + số thuê bao -->
                    <div style="padding: 8px 10px 4px 10px; display: flex; align-items: center; font-size: 12px;">
                        <span style="
                            display: inline-block;
                            width: 10px;
                            height: 10px;
                            border-radius: 50%;
                            background-color: ${seriesColor};
                            margin-right: 8px;
                            flex-shrink: 0;
                        "></span>
                        ${seriesName}:&nbsp;<span style="font-weight: 600;">${actual.toLocaleString()} thuê bao</span>
                    </div>

                    <!-- Dòng mô tả -->
                    <div style="padding: 0 10px 8px 8px; font-size: 12px; color: #666;">
                        ${description}
                    </div>
                </div>
            `;
            }
        },
         dataLabels: {
            enabled: true,
            formatter: function (val, opts) {
                // Hiển thị % nếu > 0
                return val > 0 ? `${val}%` : '';
            },
            style: {
                fontSize: '12px',
                fontWeight: 'bold'
            }
        },
        states: {
            normal: { filter: { type: 'none', value: 1 } },
            hover: { filter: { type: 'lighten', value: 0.5 } },
            active: { filter: { type: 'none', value: 1 } }
        }
    };

    const chart = new ApexCharts(document.querySelector(`#${chartId}`), options1);
    chart.render();

    // Gán hover ngay sau khi render
    setTimeout(() => {
        bindHoverEvents();
    }, 400);

    // Hàm bind lại sự kiện hover
    function bindHoverEvents() {
        const chartEl = document.querySelector(`#${chartId} .apexcharts-inner`);
        if (!chartEl) return;

        const bars = chartEl.querySelectorAll('.apexcharts-series path, .apexcharts-series rect');
        bars.forEach(bar => {
            bar.onmouseenter = function () {
                bars.forEach(b => { if (b !== bar) b.style.opacity = "0.3"; });
                bar.style.opacity = "1";
            };
            bar.onmouseleave = function () {
                bars.forEach(b => b.style.opacity = "1");
            };
        });
    }
}

function renderTrafficUsageChart(apiResponse, filterCategory = "day") {
    // Show loading effect
    const chartContainer = document.querySelector("#chart-data-usage");
    setTimeout(function () {
        const data = apiResponse.content.data;
        let categories = [];
        if (filterCategory == 'day') {
            categories = data.map(item => {
                    let date = new Date(item.date);
                    let day = String(date.getDate()).padStart(2, '0');
                    let month = String(date.getMonth() + 1).padStart(2, '0');
                    return `${day}/${month}`;
                });
        } else {
            categories = data.map(item => {
                    // month dạng yyyy-mm, đổi thành mm/yyyy
                    const [year, month] = item.month.split('-');
                    return `${month}/${year}`;
                });
        }
        

        const usageData = data.map(item => (item.totalUsedData / (1024 * 1024 * 1024)).toFixed(2));

        const options = {
            chart: {
                type: 'area',
                height: 300,
                toolbar: { show: false }
            },
            series: [{
                name: 'Data sử dụng (GB)',
                data: usageData
            }],
            xaxis: {
                categories: categories
            },
            colors: ['#E60023'],
            stroke: {
                curve: 'straight'
            },
            tooltip: {
                y: {
                    formatter: val => val + ' GB'
                }
            }
        };

        chartContainer.innerHTML = ""; // Clear loading
        new ApexCharts(chartContainer, options).render();
    }, 100); // Delay for effect, adjust as needed
}

const $refreshIcon = $('#refreshIcon');

$refreshIcon.on('click', function () {
    // Thêm class để bắt đầu animation
    $refreshIcon.addClass('rotate');

    // Loại bỏ class sau khi xoay xong để click lại vẫn hoạt động
    setTimeout(function () {
        $refreshIcon.removeClass('rotate');
    }, 1000); // Trùng với thời gian animation
});

function getAlertDashboard() {
    let now = new Date();
    let today = moment(now).format("DD/MM/YYYY");
    let body = { userId: userId, date: today, limit: 200 };
    let r = jsRoutes.controllers.TelcoDashboardController.getAlertDashboard();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas) {
            if (datas && datas.content) {
                let data = datas.content;
                $("#PACKAGE_EXPIRED").text(data.package_expired);
                $("#RED_ALERT").text(data.red_alert);
                $("#PREPAID_EXPIRED").text(data.prepaid_expired);
                $("#LOW_REMAINING_DATA").text(data.low_remaining_data);
            }
        },
        error: function(xhr) {
            showNotification('danger', Messages("connection.failed"));
        }
    });
}
var regionJson = new Array();
function getDataWithRegion() {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=REGION';
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].region != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].region.long, datas.content.data[i].region.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].region.name,
                                    "description": datas.content.data[i].region.full_name,
                                    "id": datas.content.data[i].region.id,
                                    "total": datas.content.data[i].total_sub
                                }
                            })
                        }
                    }
                    regionJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderMarkerWithData(regionJson, "region");
                } else {
                    showNotification('danger',Messages("noti.notFoundData"));
                }
            } else {
                showNotification('danger',Messages("noti.notFoundData"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var provinceJson = new Array();
function getDataWithProvince() {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=PROVINCE';
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].province != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].province.long, datas.content.data[i].province.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].province.name,
                                    "description": datas.content.data[i].province.full_name,
                                    "id": datas.content.data[i].province.id,
                                    "total": datas.content.data[i].total_sub
                                }
                            })
                        }
                    }
                    provinceJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderMarkerWithData(provinceJson, "province");
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var districtJson = new Array();
function getDataWithDistrict() {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=DISTRICT';
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].district != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].district.long, datas.content.data[i].district.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].district.name,
                                    "description": datas.content.data[i].district.full_name,
                                    "id": datas.content.data[i].district.id,
                                    "total": datas.content.data[i].total_sub
                                }
                            })
                        }
                    }
                    districtJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderMarkerWithData(districtJson, "district");
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var cellJson;
function getDataWithCell(districtId) {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=CELL&districtId='+districtId;
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].cell != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].cell.long, datas.content.data[i].cell.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].cell.cell_id,
                                    "description": datas.content.data[i].cell.address,
                                    "id": datas.content.data[i].cell.cell_id,
                                    "total": datas.content.data[i].total_sub,
                                    "lac": datas.content.data[i].cell.lac
                                }
                            })
                        }
                    }
                    cellJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    console.log(cellJson);
                    renderMarkerWithData(cellJson, "cell");
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();

            setTimeout(function () {
                isShowRegion = false;
                isShowProvince = false;
                isShowDistrict = false;
            }, 1000);
        }
    })
}


var cellPointJson;
var IsdnFeatures = [];
var zoomOnSearch = false;




function dbclickDistrictMarker(id) {
    console.log(id);
    removeAllMarker();
    getDataWithCell(id);
}


