var signalMarkers = [];
var markerVehicles = [];
var markerVehiclesList = [];
var markersClusterList = {};
var markersClusterArray = [];
function drawAllMarkerFirstV2(data, stt) {
    if (data === undefined || data === null || data.foundData === false) {
        showNotification('danger', Messages("noti.notFoundData"));
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

        if (currentLat > 0 && currentLon > 0) {
            var markerTemp = addMarkerByStatusFirstV2(currentId, currentLat, currentLon, currentTrakingType, currentRotation, stt);
            markersClusterArray.push(markerTemp);
        }
    }

    markersClusterList[stt] = markersClusterArray;
}

function addMarkerByStatusFirstV2(idVehicle, latPos, longPos, statusVehicle, rotation, stt) {
    console.log("addMarker",idVehicle, latPos, longPos, statusVehicle, rotation);
    if (latPos === null || latPos === undefined) {
        return;
    }
    if (longPos === null || longPos === undefined) {
        return;
    }

    var myLatLng = new google.maps.LatLng(latPos, longPos);

    var ico = rotateIconSlideWithStatusV2(statusVehicle);
    // console.log(ico);

    var markerVehicle = new google.maps.Marker({
        map: mapPositionList[stt],
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
            selectMarkerV2(pointer, stt);
        };
    }(idVehicle));

    return markerVehicle;
}

function rotateIconSlideWithStatusV2(status) {
    // console.log(rotation, status, deviceType);
    var imageRotated = getIcoFromDegreeAndStatusV2(status);
    var ico = {
        anchor: new google.maps.Point(16, 16),
        origin: new google.maps.Point(0, 0),
        url: imageRotated
    };
    return ico ;
}

function getIcoFromDegreeAndStatusV2(status){
    // console.log(status, degree);
    var nameImageDegree = "";
    var step = 0;

    nameImageDegree = "device_vtag";

    if(nameImageDegree in window){
        return window[nameImageDegree];
    }else{
        return nameImageDegree;
    }
}