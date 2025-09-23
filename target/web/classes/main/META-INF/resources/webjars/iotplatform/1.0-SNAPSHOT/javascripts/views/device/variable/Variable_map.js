/**
 * Created by vtk-anhlt166 on 6/4/21.
 */
function processConfigGpsDevice() {
    var Data = new FormData();
    Data.deviceId = $('#idDeviceConfig').val();
    Data.keyLat = $('#latitudeDeviceConfig').val();
    Data.keyLong = $('#longitudeDeviceConfig').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.configGpsDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
            }else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function getConfigOfDeviceIot() {
    var deviceId = $('#idDeviceConfig').val();

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.getConfigOfDeviceIot(deviceId);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                // showNotification('success',data.resultString);
                $('#latitudeDeviceConfig').val(data.content.keyLatitude).change();
                $('#longitudeDeviceConfig').val(data.content.keyLongitude).change();
            }

        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

var markerVehicles = [];
function addMarkerMap(latPos, longPos, battery, deviceId) {
    var myLatLng = new google.maps.LatLng(latPos, longPos);
    const iconBase =
        device_vtag;
    var markerVehicle = new google.maps.Marker({
        zIndex: 1000,
        position: myLatLng,
        // optimized: false,
        // draggable: false,
        icon : device_vtag
    });
    markerVehicle.setMap(mapPosition);

    mapPosition.setCenter(myLatLng);
    mapPosition.setZoom(15);

    // infoWindow
    if(battery > 0){
        var pin = Math.round(battery);
        var sContent = '<div>'+
            '<div class="batteryContainer">'+
            '<div class="batteryOuter"><div id="batteryLevel" style="width: '+pin+'%"></div></div>'+
            '<div class="batteryBump"></div>'+
            '</div>'+
            '</div>';

        infowindow = new google.maps.InfoWindow({
            // content: sContent
        });
        infowindow.setContent(sContent);
        // infowindow.setPosition(myLatLng);
        infowindow.open(mapPosition);

        google.maps.event.addListener(markerVehicle, 'click', function() {
            infowindow.open(mapPosition, markerVehicle);
        });
    }
}