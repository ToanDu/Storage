/**
 * Created by vtk-thangpt on 22/03/24.
 */
var user1,isdn1, serial1;
function viewInfoDataAccount(userId, isdn, serial){
    this.user1= userId;
    this.isdn1 = isdn;
    this.serial1 = serial;
    var numberSub = '0'+isdn
    $("#infoDataAccountModal").modal('show');
    var myDate = new Date().toISOString().slice(0, 10);
    // myDate.toLocaleDateString("en-US");
    console.log(myDate);
    var dateFrom = new Date(new Date().getTime() -2592000000 ).toISOString().slice(0, 10);
    // /$("#datetimepicker1").val(myDate);
    var dateFrom1= document.getElementById("staDatetimeFrom1"). defaultValue = dateFrom.split("-").reverse().join("/");
    var dateTo= document.getElementById("staDatetimeTo1"). defaultValue = myDate.split("-").reverse().join("/");
    // var $j = jQuery.noConflict();
    // $j( "#staDatetimeTo1" ).datepicker({ defaultDate: new Date() });
    //picker.setDate(myDate);
    $('#numberSubcriber').html(numberSub);

    const type = ['Tháng', 'Ngày'];

    // generate the radio groups
    const group = document.querySelector("#group");
    group.innerHTML = type.map((type,index) =>
        `<div>
                <input type="radio" name="type" value="${index}" id="${type}" checked>
                 <label for="${type}">${type}</label>
            </div>`).join(' ');



    // add an event listener for the change event
    const radioButtons = document.querySelectorAll('input[name="type"]');
    for(const radioButton of radioButtons){
        radioButton.addEventListener('click', showSelected);
    }
    showChart();

}

function checkDate(){
    var dateBegin = document.getElementById('staDatetimeFrom1').value;
    var dateEnd = document.getElementById('staDatetimeTo1').value;
    var currentDay = new Date();
    currentDay.setHours(0, 0, 0, 0);
    var dayFrom = new Date(dateBegin.split("/").reverse().join("-"));
    var dayTo = new Date(dateEnd.split("/").reverse().join("-"));
    console.log(dayTo);
    if(dateBegin !=  "" && dateEnd != ""){
        if ( dayTo - dayFrom <= 0 ) {
            showNotification('danger',Messages(" Vui lòng chọn ngày bắt đầu phải trước ngày kết thúc"));
            document.getElementById('staDatetimeFrom1').value = "";
        }
        else{
            if ( dayTo - dayFrom >2592000000 ) {
                showNotification('danger',Messages("Vui lòng chọn khoảng thời gian trong vòng 30 ngày"));
                document.getElementById('staDatetimeFrom1').value = "";
                document.getElementById('staDatetimeTo1').value = "";
            }
            else{
                showChart();
            }
        }

    }
    if ( dayFrom > currentDay) {
        showNotification('danger',Messages("Vui lòng chọn ngày bắt đầu trước ngày hiện tại"));
        document.getElementById('staDatetimeFrom1').value = "";
    }
    if ( dayTo>= currentDay+86400000 ) {
        showNotification('danger',Messages("Vui lòng chọn ngày kết thúc trước ngày hiện tại"));
        document.getElementById('staDatetimeTo1').value = "";
    }
}

function chartDataDate(){
var body = new FormData();
            body.userId = user1;
            body.isdn= isdn1;
            body.serial= serial1;
            body.from="";
            body.to = "";
            body.monthly="true";
            console.log(body)
            $( ".datetimepicker1" ).prop( "disabled", true ); //Disable
            $(".btnShowChart").prop("disabled",true); //Disable
            StartProcess();
            var r = jsRoutes.controllers.TelcoSubscriberController.getInfoDataAccount();
            $.ajax({
                type: r.type,
                data: JSON.stringify(body),
                contentType: "application/json; charset=utf-8",
                url: r.url,
                success: function(datas){
                    console.log(datas);
                    var date=[];
                    var quantity = [];

                    if(datas.content != null && datas.content.data.data!=null){
                        removeCanvas();
                        var data = datas.content.data.data;
                        console.log(data);
                        if (data != null) {
                            data.forEach(function (item) {
                                if (item.month != null) {
                                    date.push(item.month);
                                    quantity.push(Math.round(item.total_vol / 10000) / 100);
                                }
                                else {
                                    date.push(item.date);
                                    quantity.push(Math.round(item.total_vol / 10000) / 100);
                                }
                            });
                        }
                            var chartConfig = {
                                series: [
                                    {
                                        name: "Dung lượng (MB)",
                                        data: quantity,
                                    },
                                ],
                                chart: {
                                    type: "bar",
                                    height: 240,
                                    toolbar: {
                                        show: false,
                                    },
                                },
                                title: {
                                    show: "Lưu lượng sử dụng theo tháng",
                                },
                                dataLabels: {
                                    enabled: false,
                                },
                                colors: ["#6A5ACD"],
                                plotOptions: {
                                    bar: {
                                        columnWidth: "40%",
                                        borderRadius: 2,
                                    },
                                },
                                xaxis: {

                                    axisTicks: {
                                        show: false,
                                    },
                                    axisBorder: {
                                        show: false,
                                    },
                                    labels: {
                                        style: {
                                            colors: "#616161",
                                            fontSize: "12px",
                                            fontFamily: "inherit",
                                            fontWeight: 400,
                                        },
                                    },
                                    categories: date
                                },
                                yaxis: {
                                    title: {
                                        text: ''
                                    },
                                    labels: {
                                        style: {
                                            colors: "#616161",
                                            fontSize: "12px",
                                            fontFamily: "inherit",
                                            fontWeight: 400,
                                        },
                                    },
                                },
                                grid: {
                                    show: true,
                                    borderColor: "#dddddd",
                                    strokeDashArray: 5,
                                    xaxis: {
                                        lines: {
                                            show: true,
                                        },
                                    },
                                    padding: {
                                        top: 5,
                                        right: 20,
                                    },
                                },
                                fill: {
                                    opacity: 0.8,
                                },
                                tooltip: {
                                    theme: "dark",
                                },
                            };
                            const chart = new ApexCharts(document.querySelector("#bar-chart"), chartConfig);
                            chart.render();
                    } else {
                         document.getElementById("chartReport").innerHTML = " <span class='modal-title text-black' id='myModalLabel'>Không có thông  tin lưu lượng sử dụng</span>"
                        //showNotification('danger',Messages("Không tìm thấy dữ liệu"));
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
function showSelected(e) {
    console.log(e);
    if (this.checked) {
        if(this.value == 0){
            chartDataDate();
        }
        else{
            checkDate();
            $('.datetimepicker1').removeAttr('disabled'); //Enable
            $('.btnShowChart').removeAttr('disabled');
        }
    }
}

function closeModal(){
    removeCanvas();
    $('.datetimepicker1').removeAttr('disabled'); //Enable
    $('.btnShowChart').removeAttr('disabled');
    var myDate = new Date().toISOString().slice(0, 10);
    var dateFrom = new Date(new Date().getTime() -2592000000 ).toISOString().slice(0, 10);
    document.getElementById("staDatetimeFrom1"). defaultValue = dateFrom.split("-").reverse().join("/");
    document.getElementById("staDatetimeTo1"). defaultValue = myDate.split("-").reverse().join("/");
}
function removeCanvas(){
    $("canvas#myChart").remove();
    document.querySelector("#chartReport").innerHTML = '<canvas id="myChart"></canvas>';

}

function removeChartMonthly(){
    $("#bar-chart").remove();
    document.querySelector("#chartDataMonthly").innerHTML = '<div id="bar-chart"></div>';

}

function showChart(){
    removeChartMonthly()
    removeCanvas();

    var body = new FormData();
    body.userId = user1;
    body.isdn= isdn1;
    body.serial= serial1;
    body.from=$('#staDatetimeFrom1').val();
    body.to = $('#staDatetimeTo1').val();
    body.monthly="false";
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getInfoDataAccount();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            var date=[];
            var quantity = [];
            if(datas.content != null && datas.content.data.data != null){
                var data = datas.content.data.data;
               $("#infoDataAccountModal").modal('show');
               if (data != null) {
                   data.forEach(function (item) {
                       if (item.month != null) {
                           date.push(item.month);
                           quantity.push(Math.round(item.total_vol / 1024) / 1024);
                       }
                       else {
                           date.push(item.date);
                           quantity.push(Math.round(item.total_vol / 1024) / 1024);
                       }
                   });
               }
                    //$("canvas#myChart").remove();
                    if(window.myChart instanceof Chart)
                    {
                        window.myChart.destroy();
                    }
                    var ctx = document.getElementById('myChart').getContext('2d');
                    var chart = new Chart(ctx, {
                        type: 'line',
                        data: {
                            labels: date,
                            datasets: [{
                                label: 'Dữ liệu (MB)',
                                data: quantity,
                                backgroundColor: 'blue',
                                borderColor: 'rgb(75, 192, 192)',
                                borderWidth: 1,
                            }]
                        },
                        options: {
                            plugins:{
                                legend: {
                                    display: false
                                }
                            },
                            responsive: true,
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });

            } else {
                //showNotification('danger',Messages("Không tìm thấy dữ liệu"));
                 document.getElementById("chartReport").innerHTML = " <span class='modal-title text-black' id='myModalLabel'>Không có thông  tin lưu lượng sử dụng</span>"
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