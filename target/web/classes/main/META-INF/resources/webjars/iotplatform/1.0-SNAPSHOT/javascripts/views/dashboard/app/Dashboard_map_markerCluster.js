/**
 * Created by vtk-anhlt166 on 2/21/20.
 */

var DEVICE_MODEL = {
    imei: "imei",
    currentLat: "currentLat",
    currentLng: "currentLon",
    trackingType: "trackingType",
    rotation: "rotation",
    sDateTracking: "sDateTracking",
    status: "status",
    deviceName: "deviceName",
    groupId: "groupId",
    deviceType: "deviceType"
};

function newMarkerClusterV2(stt) {
    var options = {
        //20km
        maxZoom:8
    };
    // console.log("new cluster marker");
    markerCluster = new MarkerClusterer(mapPositionList[stt], markersClusterList[stt], options);
    markerCluster.setIgnoreHidden(true);
    markerCluster.setMinimumClusterSize(5);
}

function fitBoundMarkerV2(stt) {
    console.log(markersClusterList[stt]);
    var bounds = new google.maps.LatLngBounds();
    for (var i = 0; i < markersClusterList[stt].length; i++) {
        bounds.extend(markersClusterList[stt][i].position);
    }
    mapPositionList[stt].fitBounds(bounds);
}