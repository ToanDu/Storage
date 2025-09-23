function selectMarkerV2 (idVehicle, stt) {
    console.log("idVehicle: " + idVehicle);
    localStorage.id = idVehicle;

    $.ajax({
        type: "GET",
        dataType: 'json',
        //data: JSON.stringify(datamodel),
        contentType: "application/json; charset=utf-8",
        url: "loadDeviceDataCurrent/"+ localStorage.id,
        success: function (data) {
            console.log(data);
            if (data !== undefined && data !== null) {
                if(data.lat > 0 && data.lng > 0){
                    updateMarkerV2(data, stt);

                    selectMarkerMapV2(data, stt);

                    zoomMarkerByIdV2(data.id, stt);
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
}


var infowindow = null;
var STATUS_DEVICE = {
    RUN: {value: 1, name: Messages("map.obdMonitor.footers.running"), color: "#20d0c9", bgColor: "#20d0c9" },
    PARK: {value: 2, name: Messages("map.obdMonitor.footers.parking"), color: "#0000ff", bgColor: "#3f61db"},
    LOST_GPS: {value: 3, name: Messages("map.obdMonitor.footers.lostGps"), color: "#f58c79", bgColor: "#f58c79"},
    DISCONNECT: {value: 4, name: Messages("map.obdMonitor.footers.disconnect"), color: "#9da2b5", bgColor: "#9da2b5"},
    ALARM: {value: 5, name: Messages("map.obdMonitor.footers.alarm"), color: "#EE0033", bgColor: "#f83378"}
};
function selectMarkerMapV2(data, stt) {
    console.log(data, stt);
    if (infowindow != null && infowindow.getMap() != null) {
        infowindow.close();
        infowindow = null;
    }

    var newLatLong = new google.maps.LatLng(data.lat,data.lon);

    var color = STATUS_DEVICE.PARK.color;

    var address = "";
    var geocoder= new google.maps.Geocoder();
    geocoder.geocode({
        latLng: newLatLong
    }, function(responses) {
        console.log(responses);
        if (responses && responses.length > 0) {
            address = responses[0].formatted_address;
            console.log(address);
        }

        var sContent =
            "<div>" +
            "<div class='infowindow-header' style='color: "+color+"'>" +
            "<div class=''>"+ Messages("ID: ") + data.id +"</div> " +
            "<div class=''>"+ Messages("Name: ") + data.name +"</div> " +
            "<div class=''>"+ Messages("Adress: ") + address +"</div> " +
            "<div class=''>"+ Messages("Battery: ") + data.battery + " %" +"</div> " +
            "</div>" +
            "</div>";

        infowindow = new google.maps.InfoWindow({
            // content: sContent
        });

        infowindow.setContent(sContent);
        infowindow.setPosition(newLatLong);
        infowindow.open(mapPositionList[stt]);
    });
}

function zoomMarkerByIdV2(id, stt) {
    if (markersClusterList[stt] == null || markersClusterList[stt].length == 0) return;
    for (var i = 0; i < markersClusterList[stt].length; i++) {
        if (markersClusterList[stt][i].tag == id) {
            mapPositionList[stt].setCenter(new google.maps.LatLng(markersClusterList[stt][i].position.lat(), markersClusterList[stt][i].position.lng()));
            if (mapPositionList[stt].getZoom() <= 16) {
                mapPositionList[stt].setZoom(16);//16
            }
            zoomCurrent = mapPositionList[stt].getZoom();
        }
    }
}