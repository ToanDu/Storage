/**
 * Created by vtk-anhlt166 on 4/17/23.
 */
var mapboxPositionList = {};
var mapboxClusterLayerList = {};
var listBounds = {};
function appendWidgetWithMapBox(stt, data) {
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
    var map = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<h5 class="card-title" style="margin-bottom: 0px">' +
        '<div>' +
        '<span>'+(data.title == "null" ? "" : data.title)+'</span>'+
        '</div> '+
        '</h5>'+
        '<div class="paper-middle" >' +
        '<div class="map-canvas" id="'+wid+'"></div>' +
        '</div>' +
        '</div>';
    node.content = map;
    node.id = wid;
    grid.addWidget(node);

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

    mapboxPositionList[wid] = L.map(wid).setView(defaultCoord, zoomLevel);
    L.tileLayer(linkMapbox,
        {
            tileSize: 512,
            zoomOffset: -1,
            attribution: '© <a href="#">Viettel IoT</a>'
        }).addTo(mapboxPositionList[wid]);

    mapboxClusterLayerList[wid] = L.markerClusterGroup({
        disableClusteringAtZoom: 16,
        animate:false
    }).addTo(mapboxPositionList[wid]);

    mapboxPositionList[wid].zoomControl.setPosition('topright');


    //flags[wid] = false;

    if(data.filter == "alldevice"){
        createRunner(function () {
            getCurrentAllDeviceMapBox("#", wid);
        })
        // getCurrentAllDeviceMapBox("#", wid);
    } else {
        JSON.parse(data.data).forEach(function(dev, i) {
            createRunner(function () {
                getCurrentAllDeviceMapBoxFilter(dev, wid);
            })
            // getCurrentAllDeviceMapBoxFilter(dev, wid);
        });
    }

}

var markerMapbox = [];
function getCurrentAllDeviceMapBox(orgId, wid) {
    var dataModel = new FormData;
    dataModel.orgId = orgId;
    dataModel.projectId = projectId;

    var get = jsRoutes.controllers.DashboardWidgetController.getListDeviceWithWidgetMap();

    $.ajax({
        type: get.type,
        data: JSON.stringify(dataModel),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                for (var key in data.initMapMarkerList) {
                    var data = data.initMapMarkerList[key];
                    if(data.lat > 0 && data.lng > 0){
                        var uid = `${wid}-${data.id}`;
                        var flag = false;
                        if(!markerMapbox[uid]) {
                            var ico = L.icon({
                                iconUrl: device_vtag,
                                iconSize: [32, 32]
                            });
                            var myLatLng = [data.lat, data.lng];
                            var marker = L.marker(myLatLng, {id: uid, icon: ico}).on('click', function(e) {
                                console.log(e.target.options.id);

                                // markerListController.selectMarker(id, status, rotation);
                            });
                            marker._id = uid;
                            markerMapbox[uid] = marker;
                            if(listBounds[wid]){
                                listBounds[wid].push(marker);
                            } else {
                                listBounds[wid] = [];
                                listBounds[wid].push(marker);
                            }

                            marker.addTo(mapboxClusterLayerList[wid]);

                            //infowindow
                            flag = true;
                        } else {
                            var position = [data.lat, data.lng];
                            markerMapbox[uid].setLatLng(position).addTo(mapboxPositionList[wid]);

                            //infowindow
                        }

                        //fit bound
                        if(flag){
                            var group = new L.featureGroup(listBounds[wid]);
                            mapboxPositionList[wid].fitBounds(group.getBounds());
                        }
                    }
                }
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

function getCurrentAllDeviceMapBoxFilter(data, wid) {
    // StartProcess();
    console.log(data, wid);
    var get = jsRoutes.controllers.AttributeController.getPositionDeviceByAttribute();
    $.ajax({
        type: get.type,
        data: JSON.stringify({
            "deviceId": data.device,
            "entity_type": "DEVICE",
            "attribute_type": data.attribute_type,
            "lat": data.lat,
            "lon": data.long
        }),
        contentType: "application/json; charset=utf-8",
        url: get.url,
        success: function (datas) {
            var data = datas.content;
            console.log(data);
            if(data.lat > 0 && data.lng > 0){
                var uid = `${wid}-${data.id}`;
                var flag = false;
                if(!markerMapbox[uid]) {
                    var ico = L.icon({
                        iconUrl: device_vtag,
                        iconSize: [32, 32]
                    });
                    var myLatLng = [data.lat, data.lng];
                    var marker = L.marker(myLatLng, {id: uid, icon: ico}).on('click', function(e) {
                        console.log(e.target.options.id);

                        // markerListController.selectMarker(id, status, rotation);
                    });
                    marker._id = uid;
                    markerMapbox[uid] = marker;
                    if(listBounds[wid]){
                        listBounds[wid].push(marker);
                    } else {
                        listBounds[wid] = [];
                        listBounds[wid].push(marker);
                    }

                    //infowindow
                    flag = true;
                    var sContent =
                        '<div>'+
                        '<p><b>Thiết bị: </b>'+data.id+'<br>'+
                        '<p><b>Thời điểm: </b>'+moment.unix(data.timeStamp/1000).format("DD/MM/YYYY HH:mm:ss")+'<br>'+
                        '<b>Vị trí: </b><br>'+
                        'Kinh độ: '+data.lat+', Vĩ độ: '+data.lng+
                        '</div>';
                    var popup = L.popup();
                    popup.setContent(sContent);
                    marker.bindPopup(popup);

                    marker.addTo(mapboxClusterLayerList[wid]);

                } else {
                    //infowindow
                    var sContent =
                        '<div>'+
                        '<p><b>Thiết bị: </b>'+data.id+'<br>'+
                        '<p><b>Thời điểm: </b>'+moment.unix(data.timeStamp/1000).format("DD/MM/YYYY HH:mm:ss")+'<br>'+
                        '<b>Vị trí: </b><br>'+
                        'Kinh độ: '+data.lat+', Vĩ độ: '+data.lng+
                        '</div>';
                    var popup = L.popup();
                    popup.setContent(sContent);
                    markerMapbox[uid].bindPopup(popup);

                    var position = [data.lat, data.lng];
                    markerMapbox[uid].setLatLng(position).addTo(mapboxPositionList[wid]);
                }

                //fit bound
                if(flag){
                    var group = new L.featureGroup(listBounds[wid]);
                    mapboxPositionList[wid].fitBounds(group.getBounds());
                }
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