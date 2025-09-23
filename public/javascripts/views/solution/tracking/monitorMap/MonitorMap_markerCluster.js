/**
 * Created by vtk-anhlt166 on 9/20/21.
 */
var markersClusterList = [];
var markerCluster = null;

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
                maxZoom:13
            };
            // console.log("new cluster marker");
            markerCluster = new MarkerClusterer(mapPosition, markersClusterList, options);
            markerCluster.setIgnoreHidden(true);
            markerCluster.setMinimumClusterSize(3);
        },
        removeMarkerFromCluster: function(imei){
            var marker = getMarkerFromCluster(markerCluster.getMarkers(),imei);

            if(marker !== null){
                markerCluster.removeMarker(marker);
            }
            // console.log("markersClusterList.length after remove"+markerCluster.getMarkers().length);
        },
        addMarkerToClusterSocketForm : function(device) {
            console.log(device);
            var id = device.id;
            var name = device.name;
            var currentLat = 0;
            var currentLon = 0;
            var dateTracking = 0;

            if(device.attributes != null && device.attributes.length > 0){
                device.attributes.forEach(function (item, index) {
                    // console.log(item, index);
                    if(item.attribute_key == "lat"){
                        currentLat = item.value;
                        dateTracking = item.last_update_ts;
                    }
                    if(item.attribute_key == "lon"){
                        currentLon = item.value;
                        if(item.last_update_ts > dateTracking){
                            dateTracking = item.last_update_ts;
                        }
                    }
                })
            }

            console.log(id, currentLat, currentLon);
            if (id !== null && currentLat !== null && currentLon !== null) {
                //position of new car Marker
                var newLatLng = new google.maps.LatLng(currentLat,currentLon);
                markerSignalController.clearSignalById(id);

                var imageSignal = markerSignalController.getSignalImageByStatus();

                if(id == localStorage.id){
                    console.log("localStorage.id: "+ id, currentLat, currentLon, imageSignal);
                    markerSignalController.addSignal(id, currentLat, currentLon, imageSignal, true);

                    // fillData(device);
                }else {
                    console.log("not current imei");
                }
                var marker = markerSignalController.createMarkerByStatus(id,currentLat,currentLon, name);
                if(marker !== null){
                    // markersClusterList.push(marker);
                    markerCluster.addMarker(marker);
                }

                var zoomLevel = mapPosition.getZoom();
                if(zoomLevel >= 14){
                    var bounds = mapPosition.getBounds();
                    if( bounds.contains(newLatLng) ){
                        var infoWindow = new google.maps.InfoWindow({
                            content: name
                        });
                        infoWindow.open(mapPosition, marker);
                    }
                }

            } else {
                console.log("null imei or lat lon");
            }
        }
    }
})();