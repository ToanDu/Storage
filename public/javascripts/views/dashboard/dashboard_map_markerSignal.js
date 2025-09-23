/**
 * Created by vtk-anhlt166 on 4/12/21.
 */
var signalMarkers = [];
var markerVehicles = [];
var STATUS_VEHICLE = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    NO_SIGNAL_YET: {value: 0, name: "Chưa có tín hiệu"},
    RUNNING: {value: 1, name: "Đang chạy",  name2: "Knots"},
    PARKING: {value: 2, name: "Đang đậu"},
    GPS_LOST: {value: 3, name: "Mất tín hiệu GPS"},
    SIGNAL_LOST: {value: 4, name: "Mất tín hiệu về máy chủ"},
    ALARM: {value: 5, name: "Có cảnh báo"},
};

var markerSignalController = (function () {
    var addMarkerByStatusFirst = function (idVehicle, latPos, longPos, statusVehicle, rotation, deviceType) {
        console.log("addMarker",idVehicle, latPos, longPos, statusVehicle, rotation);
        if (latPos === null || latPos === undefined) {
            return;
        }
        if (longPos === null || longPos === undefined) {
            return;
        }

        var myLatLng = new google.maps.LatLng(latPos, longPos);

        var ico = rotateIconSlideWithStatus(statusVehicle, deviceType);
        // console.log(ico);

        var markerVehicle = new google.maps.Marker({
            // map: mapPosition,
            zIndex: 1000,
            position: myLatLng,
            optimized: false,
            draggable: false,
            // visible: isDisplay,
            trackingType: statusVehicle,
            tag: idVehicle,
            icon : ico
        });
        markerVehicles.push(markerVehicle);

        google.maps.event.addListener(markerVehicle, 'click', function (pointer) {
            return function () {
                console.log(pointer);
                controller.selectMarker(pointer, deviceType, true);
            };
        }(idVehicle));

        return markerVehicle;
    };

    var resetListMarkers = function() {

        markersClusterList = [];
        markersClusterListMore = [];
    };

    var clearSignals = function() {
        if (signalMarkers == null || signalMarkers.length == 0) {
            return;
        }
        for (j = 0; j < signalMarkers.length; j++) {
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
        getSignalImageByStatus: function (statusVehicle) {
            return getSignalImageByStatus(statusVehicle);
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
        allMarkerFirstTime: function (groupId) {
            var datamodel = new DataPaging();
            markerGroupInit = 1; //page first
            datamodel.page = markerGroupInit;
            datamodel.pageSize = markerGroupOffset;
            datamodel.groupId = groupId;
            console.log(datamodel);

            // statusCountBar.resetStatusShip();

            var r = jsRoutes.controllers.DashboardController.getListDeviceWithPaging();
            $.ajax({
                type: r.type,
                data: JSON.stringify(datamodel),
                contentType: "application/json; charset=utf-8",
                url: r.url,
                success: function (data) {
                    console.log(data);
                    if(data != null && data.success){
                        if(data.initMapMarkerList.length > 0){
                            // markerSignalController.removeAllMarkerInCluster();
                            if(data.initMapMarkerList){
                                // console.log(data.initMapMarkerList);
                                markerSignalController.drawAllMarkerFirst(data.initMapMarkerList);
                                markerClusterController.newMarkerCluster();

                                deviceListController.renderDeviceListTable(data.initMapMarkerList);

                                fitBoundMarker();
                            }
                            // statusCountBar.updateStatus(data.demMaps,true);
                            // updateCountBar(data.demMaps);
                        }
                    }else {
                        // window.location.reload();
                        showNotification('error', Messages("noti.disconnect"));
                        console.log("data is null");
                    }
                }
            });
        },
        drawAllMarkerFirst: function (data) {
            // console.log(data);

            if (data === undefined || data === null || data.foundData === false) {
                showNotification_slow('top', 'center', 'danger', Messages("ais.NotiNoHisdata"), 'pe-7s-close-circle');
                return;
            }
            if (typeof data === "undefined") {
                console.log("error: data undefined");
                return;
            }

            var initMapMarkerList = data;

            var currentId;
            var currentLat;
            var currentLon;
            var currentTrakingType;
            var currentRotation;
            var deviceType;

            for (var i = 0; i < initMapMarkerList.length; i++) {
                var value = initMapMarkerList[i];

                currentId = value.id;
                currentRotation = value.rotation;
                currentLat = value.currentLat;
                currentLon = value.currentLon;
                currentTrakingType = value.trackingType;
                deviceType = value.deviceType;

                if (currentLat > 0 && currentLon > 0) {
                    var markerTemp = addMarkerByStatusFirst(currentId, currentLat, currentLon, currentTrakingType, currentRotation, deviceType);
                    markerClusterController.addMarkerToList(markerTemp);
                }
            }

        },
        zoomMarkerById: function (id) {
            zoomMarkerById(id);
        },
        clearSignalById: function (id) {
            clearSignalById(id);
        },
        createMarkerByStatus: function (idVehicle, latPos, longPos, statusVehicle, rotation, deviceType) {
            if (latPos === null || latPos === undefined) {
                return;
            }
            if (longPos === null || longPos === undefined) {
                return;
            }

            var myLatLng = new google.maps.LatLng(latPos, longPos);

            var ico = rotateIconSlideWithStatus(statusVehicle, deviceType);
            // console.log(ico);

            var markerVehicle = new google.maps.Marker({
                // map: mapPosition,
                zIndex: 1000,
                position: myLatLng,
                optimized: false,
                draggable: false,
                // visible: isDisplay,
                trackingType: statusVehicle,
                tag: idVehicle,
                icon : ico
            });
            markerVehicles.push(markerVehicle);

            google.maps.event.addListener(markerVehicle, 'click', function (pointer) {
                return function () {
                    console.log(idVehicle);
                    controller.selectMarker(idVehicle, deviceType, true);
                };
            }(idVehicle));

            return markerVehicle;
        }
    }
})();

function getSignalImageByStatus(statusVehicle) {
    //0-chưa có tín hiệu; 1-Đang chạy; 2-Đang đậu; 3-Mất GPS; 4-Mất tín hiệu về server; 5-Có Alarm;

    // console.log(statusVehicle);
    var result = circleSignal_parking;

    return result;
}

function addSignal(idVehicle, latPos, lngPos, imageSignal, isShowSignal) {
    // console.log(signalMarkers);
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

