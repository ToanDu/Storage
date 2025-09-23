$(document).ready(function () {
    loadWidgetCurrent();
});
var TYPE_MAP = {
    GOOGLE_MAP: {value: 1, name: "googlemap"},
    MAPBOX: {value: 2, name: "mapbox"}
};
function loadWidgetCurrent() {
    var formData = new FormData;
    formData.id = idDashboard;

    var get = jsRoutes.controllers.DashboardV3Controller.getDashboardWithId();
    $.ajax({
        type: get.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.widgetSizeList != null && data.content.widgetSizeList.length > 0){
                    count = data.content.widgetSizeList.length;

                    if(count > 0){
                        for(var i = 0; i < count; i++){
                            if(data.content.widgetSizeList[i].type == WIDGET.MAP.value){
                                renderMap(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.CHART_COLUMN.value){
                                renderChartColumn(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.CHART_LINE.value){
                                renderChartLine(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.TABLE.value){
                                renderTable(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.GAUGE.value){
                                renderGauge(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.ROUND_SWITCH.value){
                                renderRoundSwitch(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.DATA.value){
                                renderData(data.content.widgetSizeList[i], i);
                            }
                            else if(data.content.widgetSizeList[i].type == WIDGET.COMMAND.value){
                                renderCommand(data.content.widgetSizeList[i], i);
                            }
                        }
                    }
                }
            } else {
                showNotification('danger', data.errorString);
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

// function addAttributeWidgetMap(element, org) {
//     element.setAttribute('org', org);
// }

// function changeOrgWidgetEditModal(){
//     var id = $("#idWidgetMapEditOrg").val();
//     $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('org',$("#selectWidgetMapEditOrg").val());
// }

var mapPositionList = [];
var mapboxPositionList = {};
function renderMap(data, stt) {
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        // noMove: true, noResize: true, locked: true
    };
    var id = data.id;
    var map = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center" style="white-space: nowrap;">' +
        '<div style="white-space: nowrap; overflow:hidden;">' +
        '<h6 class="mb-0 text-dark">'+Messages("dashboard.map")+Messages(": ")+ (data.title != null ? data.title : "")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetMap(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetMapModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle">' +
        '<div class="map-canvas" id="'+id+'"></div>' +
        '</div>' +
        '</div>';
    node.content = map;
    node.id = id;
    grid.addWidget(node);

    if(data.typeMap == TYPE_MAP.MAPBOX.value){
        var zoomLevel = 6;
        var defaultCoord = [15.664142, 104.266281];
        var mapConfig = {
            attributionControl: false,
            center: defaultCoord,
            zoom: zoomLevel,
            fullscreenControl: {
                pseudoFullscreen: false
            }
        };

        mapboxPositionList[id] = L.map(id).setView(defaultCoord, zoomLevel);
        L.tileLayer(linkMapbox,
            {
                tileSize: 512,
                zoomOffset: -1,
                attribution: '© <a href="#">Viettel IoT</a>'
            }).addTo(mapboxPositionList[id]);

        mapboxPositionList[id].zoomControl.setPosition('topright');
    } else {
        var initLatLng = new google.maps.LatLng(15.664142, 104.266281);
        var mapOptions = {
            center: initLatLng,
            zoom: 6,
            zoomControl: true,
            zoomControlOptions: {
                position: google.maps.ControlPosition.RIGHT_BOTTOM
            },
            mapTypeControlOptions: {
                position: google.maps.ControlPosition.TOP_RIGHT
            },
            scaleControl: true,
            streetViewControl: false,
            fullscreenControl: true,
            fullscreenControlOptions: {
                position: google.maps.ControlPosition.RIGHT_BOTTOM
            },
            gestureHandling: 'greedy'
        };
        var mapPosition = new google.maps.Map(document.getElementById(id), mapOptions);
        mapPositionList.push(mapPosition);
    }

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type', WIDGET.MAP.value);
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('typeMap', data.typeMap);
    //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('org', $("#selectMapOrg").val());
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('filter', data.filter);
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('filter-value', data.filterValue);
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', data.data);
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('title', data.title);

    $("#addAttribute-"+stt).click();
}

function renderChartColumn(data, stt) {
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        // noMove: true, noResize: true, locked: true
    };
    var id = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Biểu đồ cột")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetChartColumn(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetChartColumnModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+id+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = id;
    grid.addWidget(node);

    var options = {
        series: [{
            name: 'Temperature',
            data: [44, 55, 57, 56, 61, 58, 63, 60, 66]
        }, {
            name: 'Humid',
            data: [76, 85, 101, 98, 87, 105, 91, 114, 94]
        }],
        chart: {
            type: 'bar',
            height: '90%',
        },
        title: {
            text: data.title == "null" ? "" : data.title,
            align: 'center',
            offsetY: 20
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '55%',
                endingShape: 'rounded'
            },
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            colors: ['transparent']
        },
        xaxis: {
            categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct'],
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            y: {
                formatter: function (val) {
                    return val
                }
            }
        }
    };

    var chart = new ApexCharts(document.getElementById(id), options);
    chart.render();

    //add data
    var widget = $('.grid-stack-item[gs-id="'+id+'"]')[0];
    widget.setAttribute('type', WIDGET.CHART_COLUMN.value);
    //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('org', $("#selectMapOrg").val());
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
    widget.setAttribute('data', data.data);
    widget.setAttribute('title', data.title);

    $("#addAttribute-"+stt).click();
}

function renderChartLine(data, stt){
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        // noMove: true, noResize: true, locked: true
    };
    var id = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Biểu đồ đường")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetChartLine(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetChartLineModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+id+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = id;
    grid.addWidget(node);

    var options = {
        series: [{
            name: "Test",
            data: [23, 25, 30, 32, 35, 37, 33, 20, 19]
        }],
        chart: {
            height: '90%',
            type: 'line',
            zoom: {
                enabled: false
            }
        },
        title: {
            text: data.title == "null" ? "" : data.title,
            align: 'center',
            offsetY: 20
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            curve: 'straight'
        },
        grid: {
            row: {
                colors: ['#f3f3f3', 'transparent'],
                opacity: 0.5
            },
        },
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
        }
    };

    var chart = new ApexCharts(document.getElementById(id), options);
    chart.render();

    //add data
    var widget = $('.grid-stack-item[gs-id="'+id+'"]')[0];
    widget.setAttribute('type', WIDGET.CHART_LINE.value);
    //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('org', $("#selectMapOrg").val());
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
    widget.setAttribute('data', data.data);
    widget.setAttribute('title', data.title);

    $("#addAttribute-"+stt).click();
}

function renderTable(data, stt){
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        // noMove: true, noResize: true, locked: true
    };
    var id = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Bảng dữ liệu")+Messages(": ")+ (data.title != null ? data.title : "")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetTable(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetTableModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+id+'">table</div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = id;
    grid.addWidget(node);

    document.getElementById(id).innerHTML = '<table class="table table-striped">'+
      '<thead>'+
        '<tr>'+
          '<th scope="col">#</th>'+
          '<th scope="col">Group</th>'+
          '<th scope="col">Device</th>'+
          '<th scope="col">Var</th>'+
          '<th scope="col">Data</th>'+
        '</tr>'+
      '</thead>'+
      '<tbody>'+
        '<tr>'+
          '<th scope="row">1</th>'+
          '<td>Sonoff</td>'+
          '<td>Light</td>'+
          '<td>var1</td>'+
          '<td>2121</td>'+
        '</tr>'+
        '<tr>'+
          '<th scope="row">2</th>'+
          '<td>Sonoff</td>'+
          '<td>Smoke</td>'+
          '<td>var</td>'+
          '<td>8/24/2021, 4:50:43 PM</td>'+
        '</tr>'+
        '<tr>'+
          '<th scope="row">3</th>'+
          '<td>Sonoff</td>'+
          '<td>Switch</td>'+
          '<td>status</td>'+
          '<td>ON</td>'+
        '</tr>'+
        '<tr>'+
          '<th scope="row">3</th>'+
          '<td>Sonoff</td>'+
          '<td>Switch</td>'+
          '<td>test</td>'+
          '<td>8/24/2021, 4:51:43 PM</td>'+
        '</tr>'+
      '</tbody>'+
    '</table>';

    //add data
    var widget = $('.grid-stack-item[gs-id="'+id+'"]')[0];
    widget.setAttribute('type', WIDGET.TABLE.value);
    //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('org', $("#selectMapOrg").val());
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
    widget.setAttribute('data', data.data);
    widget.setAttribute('title', data.title);

    $("#addAttribute-"+stt).click();
}

function renderGauge(data, stt){
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        // noMove: true, noResize: true, locked: true
    };
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Biểu đồ máy đo")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetGauge(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetGaugeModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+wid+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);

    var options = {
        series: [76 * 100 / (parseFloat(data.maxValue) || 100)],
        labels: [''],
        title: {
            text: data.title == "null" ? "" : data.title,
            align: 'center'
        },
        chart: {
            type: 'radialBar',
            offsetY: -20,
            sparkline: {
                enabled: true
            }
        },
        legend: {
            show: true,
            floating: false,
            horizontalAlign: 'center',
            position: 'bottom'
        },
        plotOptions: {
            radialBar: {
                startAngle: -90,
                endAngle: 90,
                track: {
                    background: "#e7e7e7",
                    strokeWidth: '97%',
                    margin: 5, // margin is in pixels
                    dropShadow: {
                        enabled: true,
                        top: 2,
                        left: 0,
                        color: '#999',
                        opacity: 1,
                        blur: 2
                    }
                },
                dataLabels: {
                    name: {
                        show: false
                    },
                    value: {
                        offsetY: 25,
                        fontSize: '22px',
                        formatter: function (val) {
                            return val + " " + (data.unit != null ? data.unit : "");
                        }
                    }
                }
            }
        },
        grid: {
            padding: {
                top: -10
            }
        },

    };

    var chart = new ApexCharts(document.getElementById(wid), options);
    chart.render();

    //add data
    var widget = $('.grid-stack-item[gs-id="'+wid+'"]')[0];
    widget.setAttribute('type', WIDGET.GAUGE.value);
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
    widget.setAttribute('data', data.data);
    widget.setAttribute('title', data.title || "");
    widget.setAttribute('unit', data.unit || "");
    widget.setAttribute('max-value', data.maxValue || 100);

    $("#addAttribute-"+stt).click();
}

function renderRoundSwitch(data, stt){
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h
        // noMove: true, noResize: true, locked: true
    };
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Công tắc")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetRoundSwitch(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetRoundSwitchModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 5px">' +
        '<div class="map-canvas" id="'+wid+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);

    // document.getElementById(wid).innerHTML =
    //     '<div class="round-switch demo1">'+
    //         '<input type="checkbox">'+
    //         '<label></label>'+
    //     '</div>';
    document.getElementById(wid).innerHTML =
        '<div class="toggle toggle--text">'+
        '<input id="" class="toggle--checkbox" type="checkbox" checked>'+
        '<label class="toggle--btn" for="" data-label-on="on" data-label-off="off"></label>'+
        '</div>';

    //add data
    var widget = $('.grid-stack-item[gs-id="'+wid+'"]')[0];
    widget.setAttribute('type', WIDGET.ROUND_SWITCH.value);
    widget.setAttribute('data', data.data);
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
    widget.setAttribute('topic', data.topic);
    widget.setAttribute('cmdon', data.cmdon);
    widget.setAttribute('cmdoff', data.cmdoff);
}

function renderData(data, stt){
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        // noMove: true, noResize: true, locked: true
    };
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Dữ liệu ")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetData(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetDataModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle">' +
        '<div class="map-canvas" id="'+wid+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);

    var dateNow = new Date();
    document.getElementById(wid).innerHTML =
        // '<image src="'+dataImg+'" width="100%" alt="" />';
        '<div class="card bg-transparent shadow-none mb-0">'+
        '<div class="text-center">'+
        '<h5 class="mt-3 mb-1" style="font-weight: 600;">'+ "80.123" +'</h5>'+
        '<h6 class="mb-3 text-black-50" style="margin-left: 25%;">'+Messages("Unit: %")+'</h6>'+
        '<small class="mt-3 text-black-50">'+moment.unix(dateNow/1000).format("hh:mm DD/MM/YYYY")+'</small>'+
        '</div>'+
        '</div>';

    //add data
    var widget = $('.grid-stack-item[gs-id="'+wid+'"]')[0];
    widget.setAttribute('type', WIDGET.DATA.value);
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
    widget.setAttribute('data', data.data);
    widget.setAttribute('title', data.title || "");
    widget.setAttribute('unit', data.unit || "");
}

function renderCommand(data, stt){
    console.log(data);
    x = data.x;
    y = data.y;
    w = data.w;
    h = data.h;
    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h
        // noMove: true, noResize: true, locked: true
    };
    var wid = data.id;
    var wrapper = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+data.title+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetCommand(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+data.id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetCommandModal" style="margin-right: 5px"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+data.id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 5px">' +
        '<div class="map-canvas" id="'+wid+'"></div>' +
        '</div>' +
        '</div>';
    node.content = wrapper;
    node.id = wid;
    grid.addWidget(node);

    document.getElementById(wid).innerHTML =
        '<div class="console">'+
        '<div class="consolebody">'+
        '<p>please enter the command sent to the device</p>'+
        '<p>>_</p>'+
        '</div>'+
        '</div>';

    //add data
    var widget = $('.grid-stack-item[gs-id="'+wid+'"]')[0];
    widget.setAttribute('type', WIDGET.COMMAND.value);
    widget.setAttribute('data', data.data);
    widget.setAttribute('filter', data.filter);
    widget.setAttribute('filter-value', data.filterValue);
}