/**
 * Created by vtk-anhlt166 on 4/12/21.
 */
var mapPosition;
var pageInit = 0;
var pageOffset = 15; //paging 15 item one ajax load
var markerGroupInit = 0;
var markerGroupOffset = 3000; //paging 15 item one ajax load
var vehicleActive = "";
function DataPaging(){
    this.groupId="";
    this.page = 1;
    this.pageSize = 15;
}

$(document).ready(function () {
    localStorage.id="";

    markerSignalController.allMarkerFirstTime();
});

var controller = (function () {
    return {
        init: function () {


        },
        selectMarker : function (idVehicle, deviceType, isClickMarker) {
            console.log(idVehicle, deviceType, isClickMarker);
            selectMarker(idVehicle, deviceType, isClickMarker);
        }
    }
})();

var selectMarker = function (idVehicle, deviceType, isClickMarker) {
    console.log("idVehicle: " + idVehicle + " -- deviceType:" + deviceType);
    localStorage.id = idVehicle;
    localStorage.deviceType = deviceType;

    // $("#txtSearch").val("");
    // sideBarCtrl.updateClassActiveItem(vehicleActive, false);
    vehicleActive = idVehicle;

    $.ajax({
        type: "GET",
        dataType: 'json',
        //data: JSON.stringify(datamodel),
        contentType: "application/json; charset=utf-8",
        url: "loadDeviceDataCurrent/" + localStorage.id,
        success: function (data) {
            console.log(data);
            if (data !== undefined && data !== null) {
                if(data.lat > 0 && data.lon > 0){
                    localStorage.id = data.id;

                    updateVehicleMarker(data, isClickMarker, true);

                    if (isClickMarker) {
                        markerSignalController.zoomMarkerById(vehicleActive);

                        selectMarkerMap(data);
                    }
                    // sideBarCtrl.updateListItems(vehicleActive, true);

                    // positionSideBar.upOneShipInGroup(data);
                } else {
                    showNotification('danger', Messages("dashboard.deviceNotTracking"));
                }
            }
        },
        error: function (response) {
            // console.log("getDeviceAISDataLast",response);
        },
        failure: function (response) {
            // console.log("getDeviceAISDataLast",response);
        }
    });
};

var updateVehicleMarker = function (data, isClickMarker, isShowMarker) {
    console.log(data);
    markerClusterController.removeMarkerFromCluster(data.imei);

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
    markerClusterController.addMarkerToClusterSocketForm(deviceSocketForm);
    //clear signal
    markerSignalController.clearSignals(data.imei);
    //remove marker
    //add signal
    var imageSignal = markerSignalController.getSignalImageByStatus(data.trackingType);
    console.log(imageSignal);
    markerSignalController.addSignal(data.imei, data.lat, data.lon, imageSignal, isShowMarker);
};