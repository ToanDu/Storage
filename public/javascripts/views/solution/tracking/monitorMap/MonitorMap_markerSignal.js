/**
 * Created by vtk-anhlt166 on 9/20/21.
 */
/**
 * Created by vtk-anhlt166 on 4/12/21.
 */
var signalMarkers = [];
var markerVehicles = [];
var MARKER_TYPE = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    START: {value: 0, name: "Bắt đầu"},
    FINISH: {value: 1, name: "Kết thúc"},
    RUN: {value: 2, name: "Bắt đầu di chuyển", type : "AST"},
    PARK: {value: 3, name: "Dừng", type : "ASP"},
    WIFICELL: {value: 4, name: "Đang di chuyển", type : "WFC"},
    SOS: {value: 5, name: "Cảnh báo SOS", type : "SOS"},
    BL: {value: 6, name: "Pin yếu", type : "BL"}
};

var markerSignalController = (function () {
    var addMarkerByStatusFirst = function (idVehicle, latPos, longPos, name) {
        console.log("addMarker",idVehicle, latPos, longPos, name);
        if (latPos === null || latPos === undefined) {
            return;
        }
        if (longPos === null || longPos === undefined) {
            return;
        }

        var myLatLng = new google.maps.LatLng(latPos, longPos);

        var ico = getIconWithType();
        // console.log(ico);

        var markerVehicle = new google.maps.Marker({
            // map: mapPosition,
            zIndex: 1000,
            position: myLatLng,
            optimized: false,
            draggable: false,
            name: name,
            tag: idVehicle,
            icon: {
                anchor: new google.maps.Point(16, 16),
                size: new google.maps.Size(32, 32),
                url: ico,
                origin: new google.maps.Point(0, 0)
            }
        });
        markerVehicles.push(markerVehicle);

        google.maps.event.addListener(markerVehicle, 'click', function (pointer) {
            return function () {
                console.log(pointer);
                controller.selectMarker(pointer, true);
            };
        }(idVehicle));

        return markerVehicle;
    };

    var resetListMarkers = function() {
        markersClusterList = [];
    };

    var clearSignals = function() {
        if (signalMarkers == null || signalMarkers.length == 0) {
            return;
        }
        for (var j = 0; j < signalMarkers.length; j++) {
            signalMarkers[j].setMap(null);
        }
        signalMarkers = [];
    };

    var clearSignalById = function (id) {
        if (signalMarkers === null || signalMarkers.length === 0) {
            return;
        }
        // console.log("clearSignalById -- vehicleActive: " + vehicleActive + " <<< id: " + id);
        for (var i = 0; i < signalMarkers.length; i++) {
            if (signalMarkers[i].tag === id) {
                // console.log("clearSignalById: " + id);
                signalMarkers[i].setMap(null);
                signalMarkers.splice(i, 1);
                break;
            }
        }
    };

    return {
        init: function () {
            // console.log('Application has started.');
        },
        // getSignalImageByStatus: function (statusVehicle, battery) {
        //     return getSignalImageByStatus(statusVehicle, battery);
        // },
        getSignalImageByStatus: function () {
            return getSignalImageByStatus();
        },
        addSignal: function (idVehicle, latPos, lngPos, imageSignal, isShowSignal) {
            addSignal(idVehicle, latPos, lngPos, imageSignal, isShowSignal);
        },
        clearSignals: function () {
            clearSignals();
        },
        removeAllMarkerInCluster: function() {
            resetListMarkers();
            if(markerCluster != null){
                markerCluster.clearMarkers();
            }
        },
        allMarkerFirstTimeTracking: function () {
            var r = jsRoutes.controllers.SolutionTrackingController.getListGpsDevice();
            var formData = new FormData;
            formData.projectId = projectId;
            $.ajax({
                type: r.type,
                data: JSON.stringify(formData),
                contentType: "application/json; charset=utf-8",
                url: r.url,
                success: function (data) {
                    console.log(data);
                    if(data != null && data.success){
                        if(data.content != null){
                            markerSignalController.removeAllMarkerInCluster();
                            if(data.content.devices != null && data.content.devices.length > 0){
                                // deviceListController.renderDeviceListTable(data.content.devices);

                                markerSignalController.drawAllMarkerFirst(data.content.devices);
                                markerClusterController.newMarkerCluster();

                                fitBoundMarker();
                            }


                        }
                    } else {
                        showNotification('danger', data.errorString);
                    }
                }
            });
        },
        drawAllMarkerFirst: function (data) {
            // console.log(data);

            if (data === undefined || data === null || data.foundData === false) {
                showNotification('danger', Messages("ais.NotiNoHisdata"));
                return;
            }
            if (typeof data === "undefined") {
                console.log("error: data undefined");
                return;
            }

            if(data.length > 0){
                $("#table-map-view tbody:last-child").html("");

                var countDevice = 0;
                for (var i = 0; i < data.length; i++) {
                    var currentId;
                    var currentName;
                    var currentLat = 0;
                    var currentLon = 0;

                    var device = data[i];
                    currentId = device.id;
                    currentName = device.name;
                    if(device.attributes != null && device.attributes.length > 0){
                        device.attributes.forEach(function (item, index) {
                            // console.log(item, index);
                            if(item.attribute_key == "lat"){
                                currentLat = item.value;
                            }
                            if(item.attribute_key == "lon"){
                                currentLon = item.value;
                            }
                        })
                    }

                    if (currentLat > 0 && currentLon > 0) {
                        var markerTemp = addMarkerByStatusFirst(currentId, currentLat, currentLon, currentName);
                        markerClusterController.addMarkerToList(markerTemp);

                        //render list device
                        $("#table-map-view tbody:last-child").append('<tr onclick="controller.selectMarker(\'' + data[i].id + '\', ' + true + ' )" class="list_device" id="map-index-' + data[i].id + '" style="cursor: pointer; background-color: #fff; border-bottom: 1px solid #D6D6D7">' +
                            '<td class="text-center">' + (i + 1) + '</td>\n' +
                            '<td class="name_device">' + data[i].name + '</td>\n' +
                            '<td id="status_'+data[i].id+'">' + data[i].status + '</td>\n' +
                            '</tr>');
                        countDevice++;
                    }
                }
                $("#id-sum-stt").html(countDevice);
            }


        },
        zoomMarkerById: function (id) {
            zoomMarkerById(id);
        },
        clearSignalById: function (id) {
            clearSignalById(id);
        },
        createMarkerByStatus: function (idVehicle, latPos, longPos, name) {
            console.log(idVehicle, latPos, longPos, name);
            if (latPos === null || latPos === undefined) {
                return;
            }
            if (longPos === null || longPos === undefined) {
                return;
            }

            var myLatLng = new google.maps.LatLng(latPos, longPos);

            var ico = getIconWithType();
            // console.log(ico);

            var markerVehicle = new google.maps.Marker({
                // map: mapPosition,
                zIndex: 1000,
                position: myLatLng,
                optimized: false,
                draggable: false,
                // visible: isDisplay,
                name: name,
                tag: idVehicle,
                icon: {
                    anchor: new google.maps.Point(16, 16),
                    size: new google.maps.Size(32, 32),
                    url: ico,
                    origin: new google.maps.Point(0, 0)
                }
            });
            markerVehicles.push(markerVehicle);

            google.maps.event.addListener(markerVehicle, 'click', function (pointer) {
                return function () {
                    console.log(idVehicle);
                    controller.selectMarker(idVehicle, true);
                };
            }(idVehicle));

            return markerVehicle;
        }
    }
})();

function getSignalImageByStatus() {
    // console.log(statusVehicle);
    var result = circleSignal_run;
    // if(type == MARKER_TYPE.SOS.type || type == MARKER_TYPE.BL.type || (battery <= 15 && battery > 0)){
    //     result = circleSignal_alarm;
    // } else if(type == MARKER_TYPE.RUN.type){
    //     result = circleSignal_start;
    // } else if(type == MARKER_TYPE.PARK.type){
    //     result = circleSignal_stop;
    // } else {
    //     result = circleSignal_run;
    // }

    return result;
}

function addSignal(idVehicle, latPos, lngPos, imageSignal, isShowSignal) {
    console.log(idVehicle, latPos, lngPos, imageSignal, isShowSignal);
    if(signalMarkers.length > 1){
        for(var i=0; i<signalMarkers.length-1; i++){
            signalMarkers[i].setMap(null);
        }
    }
    // console.log("isShowSignal " + isShowSignal);
    if (latPos == null || latPos == undefined) {
        return;
    }
    if (lngPos == null || lngPos == undefined) {
        return;
    }
    var bounds = new google.maps.LatLngBounds();
    var myLatLng = new google.maps.LatLng(latPos, lngPos);
    bounds.extend(myLatLng);

    var signalMarkerVehicle = new google.maps.Marker({
        position: myLatLng,
        map: mapPosition,
        cursor: "default",
        flat: true,
        draggable: false,
        tag: idVehicle,
        icon: {
            anchor: new google.maps.Point(32, 32),
            size: new google.maps.Size(64, 64),
            url: imageSignal,
            origin: new google.maps.Point(0, 0)
        },
        optimized: false
    });
    signalMarkerVehicle.setVisible(isShowSignal);
    signalMarkers.push(signalMarkerVehicle);
}

function zoomMarkerById(id) {
    //console.log("zoomMarkerById: ", id)
    if (markerVehicles == null || markerVehicles.length == 0) return;
    for (var i = 0; i < markerVehicles.length; i++) {
        if (markerVehicles[i].tag == id) {
            mapPosition.setCenter(new google.maps.LatLng(markerVehicles[i].position.lat(), markerVehicles[i].position.lng()));
            if (mapPosition.getZoom() <= 16) {
                mapPosition.setZoom(16);//16
            }
            zoomCurrent = mapPosition.getZoom();
        }
    }
}

function fitBoundMarker() {
    var bounds = new google.maps.LatLngBounds();
    for (var i = 0; i < markerVehicles.length; i++) {
        bounds.extend(markerVehicles[i].position);
    }
    mapPosition.fitBounds(bounds);
}

