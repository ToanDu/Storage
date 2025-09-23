function updateMarkerV2(data, stt) {
    console.log(markersClusterList[stt]);
    var sttMarker = getMarkerFromClusterV2(markersClusterList[stt],data.id);
    console.log(sttMarker);
    if(sttMarker != null){
        markersClusterList[stt].splice(sttMarker, 1);
    }

    var deviceSocketForm = new FormData();
    deviceSocketForm.id = data.id;
    deviceSocketForm.imei = data.imei;
    deviceSocketForm.currentLat = data.lat;
    deviceSocketForm.currentLng = data.lon;
    deviceSocketForm.trackingType = data.trackingType;
    deviceSocketForm.rotation = data.rotation;
    deviceSocketForm.deviceType = data.deviceType;
    deviceSocketForm.vol = data.vol;
    deviceSocketForm.serial = data.serial;
    deviceSocketForm.status = data.status;
    deviceSocketForm.sDateTracking = data.sDateTracking;
    console.log(deviceSocketForm);

    //remove marker
    addMarkerToClusterSocketFormV2(deviceSocketForm, stt);

}

function getMarkerFromClusterV2(vehicleMarkerList, Id) {
    for (var i = 0; i < vehicleMarkerList.length; i++) {
        if (vehicleMarkerList[i].tag == Id) {
            return i;
        }
    }
    return null;
}

function addMarkerToClusterSocketFormV2(deviceSocketForm, stt) {
    console.log(deviceSocketForm);
    var id = deviceSocketForm.id;
    var currentLat = deviceSocketForm.currentLat;
    var currentLon = deviceSocketForm.currentLng;
    var trackingType = deviceSocketForm.trackingType;

    if (id !== null && currentLat !== null && currentLon !== null) {
        //position of new car Marker
        // var newLatLng = new google.maps.LatLng(currentLat,currentLon);
        var marker = createMarkerByStatusV2(id,currentLat,currentLon,trackingType, stt);
        if(marker !== null){
            markersClusterList[stt].push(marker);
        }
    } else {
        console.log("null imei or lat lon");
    }
}

function createMarkerByStatusV2(idVehicle, latPos, longPos, statusVehicle, stt) {
    if (latPos === null || latPos === undefined) {
        return;
    }
    if (longPos === null || longPos === undefined) {
        return;
    }

    var myLatLng = new google.maps.LatLng(latPos, longPos);

    var ico = rotateIconSlideWithStatusV2(statusVehicle);
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
    markersClusterList[stt].push(markerVehicle);

    google.maps.event.addListener(markerVehicle, 'click', function (pointer) {
        return function () {
            console.log(idVehicle);
            selectMarkerV2(idVehicle, stt);
        };
    }(idVehicle));

    return markerVehicle;
}