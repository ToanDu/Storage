var mapPositionList = {};
var markers = {};
var inforWindows = {};
var markerClusters = {};
var flags = {};

function appendWidgetMap(stt, data) {
    console.log(stt , data);
    var node = {
        x: data.x,
        y: data.y,
        w: data.w,
        h: data.h,
        noMove: true, noResize: true, locked: true
    };
    //var id = "map-canvas-"+stt;
    var wid = data.id;
    var map = '<div class="card-body" style="height: 100%; min-height: 300px; overflow: hidden">\n' +
        '<h5 class="card-title" style="margin-bottom: 0px">' +
        '<div>' +
        '<span>'+(data.title == "null" ? "" : data.title)+'</span>'+
        '</div> '+
        '</h5>'+
        '<div class="paper-middle" >' +
        '<div class="map-canvas" id="'+wid+'" style="min-height: 300px"></div>' +
        '</div>' +
        '</div>';
    node.content = map;
    node.id = wid;
    $("#bodyDashboard").append(map);

    var initLatLng = new google.maps.LatLng(21.025703, 105.832758);
    var mapOptions = {
        center: initLatLng,
        zoom: 7,
        zoomControl: true,
        zoomControlOptions: {
            position: google.maps.ControlPosition.RIGHT_BOTTOM
        },
        // mapTypeControlOptions: {
        //     position: google.maps.ControlPosition.TOP_RIGHT
        // },
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        fullscreenControl: true,
        fullscreenControlOptions: {
            position: google.maps.ControlPosition.RIGHT_BOTTOM
        },
        gestureHandling: 'greedy'
    };
    var mapPosition = new google.maps.Map(document.getElementById(wid), mapOptions);
    mapPositionList[wid] = mapPosition;
    markerClusters[wid] = [];
    //flags[wid] = false;

    if(data.filter == "alldevice"){
        createRunner(function () {
            getCurrentDataAllDevice("#", wid);
        })
    }
    else{
        JSON.parse(data.data).forEach(function(dev, i) {
            createRunner(function () {
                getListDeviceWithWidgetMapV2(dev, wid);
            })
        });
    }

}

function getListDeviceWithWidgetMapV2(data, wid) {
    // StartProcess();
    console.log(data, wid);
    var get = jsRoutes.controllers.DashboardAppController.getPositionDeviceByAttributeApp();
    $.ajax({
        type: get.type,
        data: JSON.stringify({
            "deviceId": data.device,
            "entity_type": "DEVICE",
            "attribute_type": data.attribute_type,
            "lat": data.lat,
            "lon": data.long,
            "token": token
        }),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (datas) {

            var data = datas.content;
            console.log(data);
            if(data.lat > 0 && data.lng > 0){
                var uid = `${wid}-${data.id}`;
                console.log(uid);
                var flag = false;
                if(!markers[uid])
                {
                    var marker = new google.maps.Marker({
                        position: {lat: data.lat, lng: data.lng},
                        map: mapPositionList[wid],
                        icon: device_vtag
                    });

                    var time = moment.unix(data.timeStamp/1000).format("DD/MM/YYYY HH:mm:ss");

                    var infowindow = new google.maps.InfoWindow({
                        content:
                            `<div>
                            <p><b>Thiết bị: </b>${data.id}<br>
                            <p><b>Thời điểm: </b>${time}<br>
                            <b>Vị trí: </b><br>
                            Kinh độ: ${data.lat}<br>
                            Vĩ độ: ${data.lng}
                        </div>`,
                    });
                    marker.addListener("click", () => {
                        infowindow.open({
                            anchor: marker,
                            map: mapPositionList[wid],
                            shouldFocus: false,
                        });
                    });
                    markers[uid] = marker;
                    inforWindows[uid] = infowindow;
                    markerClusters[wid].push(marker);
                    flag = true;
                }
                else{
                    var time = moment.unix(data.timeStamp/1000).format("DD/MM/YYYY HH:mm:ss");

                    markers[uid].setPosition(new google.maps.LatLng(data.lat, data.lng));
                    inforWindows[uid].setContent( `<div>
                            <p><b>Thiết bị: </b>${data.id}<br>
                            <p><b>Thời điểm: </b>${time}<br>
                            <b>Vị trí: </b><br>
                            Kinh độ: ${data.lat}, Vĩ độ: ${data.lng}
                        </div>`);
                }

                //fit bound
                if(flag){
                    var bounds = new google.maps.LatLngBounds();
                    for (var i = 0; i < markerClusters[wid].length; i++) {
                        bounds.extend(markerClusters[wid][i].position);
                    }
                    mapPositionList[wid].fitBounds(bounds);
                    //mapPositionList[wid].setZoom(7);
                }

                // marker cluster
                // new MarkerClusterer(mapPositionList[wid], Object.keys(markerClusters[wid]).map(k => markerClusters[wid][k]),
                //     {
                //         maxZoom : 8,
                //     });
                // markerClusters[wid].setIgnoreHidden(true);
                // markerClusters[wid].setMinimumClusterSize(5);
            }
        },
        error: function (xhr) {
            //console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function getCurrentDataAllDevice(orgId, wid) {
    var dataModel = new FormData;
    dataModel.orgId = orgId;
    dataModel.projectId = projectId;
    dataModel.token = token;

    var get = jsRoutes.controllers.DashboardAppController.getListDeviceWithWidgetMapApp();

    $.ajax({
        type: get.type,
        data: JSON.stringify(dataModel),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                for (var key in data.initMapMarkerList) {
                    var dev = data.initMapMarkerList[key];
                    if(dev.currentLat > 0 && dev.currentLon > 0){
                        var uid = `${wid}-${dev.id}`;
                        var flag = false;
                        if(!markers[uid])
                        {
                            var marker = new google.maps.Marker({
                                position: {lat: dev.currentLat, lng: dev.currentLon},
                                map: mapPositionList[wid],
                                icon: device_vtag
                            });

                            var infowindow = new google.maps.InfoWindow({
                                content:
                                    `<div>
                                        <p><b>Thiết bị: </b>${dev.name}<br>
                                        <b>Vị trí: </b><br>
                                        Kinh độ: ${dev.currentLat}<br>
                                        Vĩ độ: ${dev.currentLon}
                                        ${dev.vol >= 0 ? "<br><b>Battery: </b>" + dev.vol : ""}
                                    </div>`,
                            });
                            marker.addListener("click", () => {
                                infowindow.open({
                                    anchor: marker,
                                    map: mapPositionList[wid],
                                    shouldFocus: false,
                                });
                            });
                            markers[uid] = marker;
                            inforWindows[uid] = infowindow;
                            markerClusters[wid].push(marker);
                            flag = true;
                        }
                        else{
                            markers[uid].setPosition(new google.maps.LatLng(dev.currentLat, dev.currentLon));
                            inforWindows[uid].setContent(
                                    `<div>
                                        <p><b>Thiết bị: </b>${dev.name}<br>
                                        <b>Vị trí: </b><br>
                                        Kinh độ: ${dev.currentLat}<br>
                                        Vĩ độ: ${dev.currentLon}
                                        ${dev.vol >= 0 ? "<br><b>Battery: </b>" + dev.vol : ""}
                                    </div>`);
                        }

                        //fit bound
                        if(flag){
                            var bounds = new google.maps.LatLngBounds();
                            for (var i = 0; i < markerClusters[wid].length; i++) {
                                bounds.extend(markerClusters[wid][i].position);
                            }
                            mapPositionList[wid].fitBounds(bounds);
                            //mapPositionList[wid].setZoom(7);
                        }
                    }
                }

                // marker cluster
                new MarkerClusterer(mapPositionList[wid], Object.keys(markerClusters[wid]).map(k => markerClusters[wid][k]),
                    {
                        maxZoom : 8,

                    });
                // markerClusters[wid].setIgnoreHidden(true);
                // markerClusters[wid].setMinimumClusterSize(5);
            }

        },
        error: function (xhr) {
            //console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}