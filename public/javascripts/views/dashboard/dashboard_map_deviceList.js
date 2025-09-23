var deviceListController = (function () {

    return {
        init: function () {
            // console.log('Application has started.');

        },
        renderDeviceListTable: function (data) {
            console.log(data);
            $("#totalDeviceHeader").html(data.length);
            if(data.length > 0){
                var dataBattery = [];
                for(var i =0; i<data.length; i++){
                    var device = "<div class=\"customers-list-item d-flex align-items-center border-top border-bottom p-2 cursor-pointer\" >"+
                        "<div class=\"ms-2\" onclick='controller.selectMarker(\""+data[i].id+"\", "+data[i].deviceType+", true)'>" +
                        "<h6 class=\"mb-1 font-15\">"+ data[i].name +"</h6>" +
                        "<p class=\"mb-0 font-12\">"+ data[i].id +"</p>" +
                        "</div>" +
                        "<div class=\"list-inline d-flex customers-contacts ms-auto\">" +
                        "<a onclick='nextPage(\""+data[i].id+"\")' class=\"list-inline-item\"><i class='bx bx-cog'></i></a>" +
                        "</div>"+
                        "</div>";
                    $("#deviceListTable").append(device);

                    //add data
                    var obj = new Object();
                    obj.name = data[i].name;
                    obj.y  = data[i].vol;
                    obj.drilldown = data[i].name;
                    var jsonString= JSON.stringify(obj);
                    dataBattery.push(JSON.parse(jsonString));
                }

                $("#totalListDevice").html(data.length);



                renderHightChart(dataBattery);
            }
        }
    }
})();

function nextPage(id) {
    // window.location.href = jsRoutes.controllers.DeviceVariableController.deviceVariable(id).url;
    window.open(jsRoutes.controllers.DeviceVariableController.deviceVariable(id).url, '_blank');
}

function renderHightChart(data) {
    Highcharts.chart('hightChartBattery', {
        chart: {
            type: 'column',
            styledMode: true
        },
        credits: {
            enabled: false
        },
        title: {
            text: Messages("dashboard.chartContent")
        },
        // subtitle: {
        //     text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
        // },
        accessibility: {
            announceNewData: {
                enabled: true
            }
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: Messages("dashboard.chartContent")
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}%'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
        },
        series: [{
            name: "Battery",
            colorByPoint: true,
            data: data
        }]
    });
}