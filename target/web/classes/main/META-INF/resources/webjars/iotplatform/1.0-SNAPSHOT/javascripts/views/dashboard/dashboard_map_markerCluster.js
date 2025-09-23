/**
 * Created by vtk-anhlt166 on 2/21/20.
 */
var markersClusterList = [];
var markersClusterListMore = [];
var markerCluster = [];
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

var markerClusterController = (function() {
    var getMarkerFromCluster = function(vehicleMarkerList, Id) {
        // console.log("findVehicle");
        for (var i = 0; i < vehicleMarkerList.length; i++) {
            // console.log("vehicleMarkerList[i].tag:  "+vehicleMarkerList[i].tag);
            if (vehicleMarkerList[i].tag === Id) {
                return vehicleMarkerList[i];
            }
        }
        return null;

    };

    return {
        init: function () {

        },
        addMarkerToList: function(item) {
            markersClusterList.push(item);
        },
        newMarkerCluster: function () {
            var options = {
                //20km
                maxZoom:8
            };
            // console.log("new cluster marker");
            markerCluster = new MarkerClusterer(mapPosition, markersClusterList, options);
            markerCluster.setIgnoreHidden(true);
            markerCluster.setMinimumClusterSize(5);
        },
        removeMarkerFromCluster: function(imei){
            var marker = getMarkerFromCluster(markerCluster.getMarkers(),imei);

            if(marker !== null){
                markerCluster.removeMarker(marker);
            }
            // console.log("markersClusterList.length after remove"+markerCluster.getMarkers().length);
        },
        addMarkerToClusterSocketForm : function(deviceSocketForm) {
            console.log(deviceSocketForm);
            var id = deviceSocketForm.id;
            var currentLat = deviceSocketForm.currentLat;
            var currentLon = deviceSocketForm.currentLng;
            var trackingType = deviceSocketForm.trackingType;
            var rotation = deviceSocketForm.rotation;
            var deviceType = deviceSocketForm.deviceType;
            var vol = deviceSocketForm.vol;

            if (id !== null && currentLat !== null && currentLon !== null) {
                //position of new car Marker
                var newLatLng = new google.maps.LatLng(currentLat,currentLon);
                markerSignalController.clearSignalById(id);

                var imageSignal = markerSignalController.getSignalImageByStatus(trackingType);
                // console.log(imageSignal);
                // sideBarController.updateOneDeviceInSideBar(deviceSocketForm);
                if(id === localStorage.id){
                    console.log("localStorage.id: "+localStorage.id);
                    markerSignalController.addSignal(id, currentLat, currentLon, imageSignal, true);
                    // fillData(deviceSocketForm);
                }else {
                    console.log("not current imei");
                }
                var marker = markerSignalController.createMarkerByStatus(id,currentLat,currentLon,trackingType,rotation, deviceType);
                if(marker !== null){
                    // markersClusterList.push(marker);
                    markerCluster.addMarker(marker);
                }
            } else {
                console.log("null imei or lat lon");
            }
        }
    }
})();