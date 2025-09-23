var infowindow = null;
var STATUS_DEVICE = {
    RUN: {value: 1, name: Messages("map.obdMonitor.footers.running"), color: "#20d0c9", bgColor: "#20d0c9" },
    PARK: {value: 2, name: Messages("map.obdMonitor.footers.parking"), color: "#0000ff", bgColor: "#3f61db"},
    LOST_GPS: {value: 3, name: Messages("map.obdMonitor.footers.lostGps"), color: "#f58c79", bgColor: "#f58c79"},
    DISCONNECT: {value: 4, name: Messages("map.obdMonitor.footers.disconnect"), color: "#9da2b5", bgColor: "#9da2b5"},
    ALARM: {value: 5, name: Messages("map.obdMonitor.footers.alarm"), color: "#EE0033", bgColor: "#f83378"}
};
function selectMarkerMap(index) {
    console.log(index);
    if (markerVehicles.length == 0) {
        return;
    }
    if (infowindow != null && infowindow.getMap() != null) {
        infowindow.close();
        infowindow = null;
    }

    var newLatLong = new google.maps.LatLng(index.lat,index.lon);

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
            "<div class=''>"+ Messages("ID: ") + index.id +"</div> " +
            "<div class=''>"+ Messages("Name: ") + index.name +"</div> " +
            "<div class=''>"+ Messages("Adress: ") + address +"</div> " +
            "<div class=''>"+ Messages("Battery: ") + index.battery + " %" +"</div> " +
            "</div>" +
            "</div>";

        infowindow = new google.maps.InfoWindow({
            // content: sContent
        });

        infowindow.setContent(sContent);
        infowindow.setPosition(newLatLong);
        infowindow.open(mapPosition);
    });
}