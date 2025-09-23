var markerVehicles = [];
var infowindow = null;
var lastIndexMarkerSelected = 0;

var MARKER_TYPE = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    START: {value: 0, name: "Bắt đầu"},
    FINISH: {value: 1, name: "Kết thúc"},
    RUN: {value: 2, name: "Bắt đầu di chuyển", type : "AST"},
    PARK: {value: 3, name: "Dừng", type : "ASP"},
    WIFICELL: {value: 4, name: "Đang di chuyển", type : "WFC"},
    SOS: {value: 5, name: "Cảnh báo SOS", type : "SOS"},
    BL: {value: 6, name: "Pin yếu", type : "BL"}
};
//--------

function clearAllMarkers() {
    if (markerVehicles != null && markerVehicles.length > 0) {
        for (var i = 0; i < markerVehicles.length; i++) {
            markerVehicles[i].setMap(null);
        }
    }
    markerVehicles = [];
}




function drawSourceDestinationPostionMarker(image, position, index) {
    console.log("drawSourceDestinationPostionMarker: ", index, image);
    var markerVehicle = new google.maps.Marker({
        map: mapHistory,
        position: position,
        optimized: false, // must set this to apply set index later
        draggable: false,
        trackingType: null,
        tag: index,
        icon: image,
    });
    markerVehicle.setVisible(true);
    markerVehicles.push(markerVehicle);

    google.maps.event.addListener(markerVehicle, 'click', function (index) {
        return function () {
            console.log("drawSourceDestinationPostionMarker click: ", index);
            selectMarker(index, true);

        };
    }(index));
}

function drawPlaybackPositionMarker(index, imageVehicle) {
    for (var i = 0; i < historyPositionModals.length; i++) {
        if (historyPositionModals[i].index == index && historyPositionModals[i].position != null) {

            var markerVehicle = new google.maps.Marker({
                map: mapHistory,
                position: historyPositionModals[i].position,
                optimized: false, // must set this to apply set index later
                draggable: false,
                trackingType: historyPositionModals[i].trackingType,
                tag: historyPositionModals[i].index,
                icon: {
                    anchor: new google.maps.Point(8, 8),
                    size: new google.maps.Size(16, 16),
                    url: imageVehicle,
                    origin: new google.maps.Point(0, 0)
                }

            });
            markerVehicle.setVisible(true);
            markerVehicles.push(markerVehicle);

            google.maps.event.addListener(markerVehicle, 'click', function (index) {
                return function () {
                    console.log("drawMarkersInHistoryView click: " + index);
                    selectMarker(index, true);

                };
            }(historyPositionModals[i].index));
            break;
        }
    }
}


function drawMarkersInHistoryView() {
    if (historyPositionModals == undefined || historyPositionModals.length == 0)
        return;
    for (var i = 0; i < historyPositionModals.length; i++) {
        if (historyPositionModals[i].position != null) {
            var image = null;
            var markerVehicle = null;
            if (i == 0) {
                image = startRacing;

                markerVehicle = new google.maps.Marker({
                    map: mapHistory,
                    position: historyPositionModals[i].position,
                    optimized: false, // must set this to apply set index later
                    draggable: false,
                    trackingType: historyPositionModals[i].trackingType,
                    tag: historyPositionModals[i].index,
                    icon: image
                });
            } else if (i == historyPositionModals.length - 1) {
                image = destRacing;

                markerVehicle = new google.maps.Marker({
                    map: mapHistory,
                    position: historyPositionModals[i].position,
                    optimized: false, // must set this to apply set index later
                    draggable: false,
                    trackingType: historyPositionModals[i].trackingType,
                    tag: historyPositionModals[i].index,
                    icon: image
                });
            } else {
                image = point;

                markerVehicle = new google.maps.Marker({
                    map: mapHistory,
                    position: historyPositionModals[i].position,
                    optimized: false, // must set this to apply set index later
                    draggable: false,
                    trackingType: historyPositionModals[i].trackingType,
                    tag: historyPositionModals[i].index,
                    icon: {
                        anchor: new google.maps.Point(8, 8),
                        size: new google.maps.Size(16, 16),
                        url: image,
                        origin: new google.maps.Point(0, 0)
                    }

                });
            }
            // var myLatLng = new google.maps.LatLng(historyModals[i].latPos, historyModals[i].longPos);

            markerVehicle.setVisible(true);
            markerVehicles.push(markerVehicle);

            google.maps.event.addListener(markerVehicle, 'click', function (index) {
                return function () {
                    console.log("drawMarkersInHistoryView click: " + index);
                    selectMarker(index, true);

                };
            }(historyPositionModals[i].index));
        }
        lastIndexMarkerSelected = 0;
        setHoverHistoryItem(lastIndexMarkerSelected);
    }
}

function selectMarker(index, isClickMarker) {
    if (markerVehicles.length == 0 || historyPositionModals.length == 0) {
        return;
    }
    if (infowindow != null && infowindow.getMap() != null) {
        infowindow.close();
        infowindow = null;
    }
    //console.log(infowindow != null ? infowindow.opened : "");

    var modalHis = null;
    for (var i = 0; i < historyPositionModals.length; i++) {
        if (historyPositionModals[i].index == index) {
            modalHis = historyPositionModals[i];
            break;
        }
    }


    if (modalHis != null) {

        if (isClickMarker) {
            scrollViewHistoryItems(lastIndexMarkerSelected, modalHis.index);
        } else {
            removeHoverHistoryItem(lastIndexMarkerSelected);
            setHoverHistoryItem(modalHis.index);
        }
        lastIndexMarkerSelected = modalHis.index;


        //console.log(modalHis);
        var infoTable = "<table id='infoTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
            "<thead>" +
            "<th></th>" +
            "<th></th>" +
            "</thead>" +
            "<tbody align=\"left\">";

        infoTable += "<tr>";
        infoTable += "<td><b>" + Messages("ID") + "</b></td>";
        infoTable += "<td><b>" + modalHis.id + "</b></td>";
        infoTable += "</tr>";

        var logdate = (modalHis.timeTracking > 0) ? moment.unix(modalHis.timeTracking).format("DD/MM/YYYY HH:mm:ss"): "";
        infoTable += "<tr>";
        infoTable += "<td>" + Messages("Thời gian") + "</td>";
        infoTable += "<td>" + logdate + "</td>";
        infoTable += "</tr>";

        infoTable += "<tr>";
        infoTable += "<td>" + Messages("Vị trí") + "</td>";
        infoTable += "<td>" + convertDMS(modalHis.position.lat(),modalHis.position.lng()) + "</td>";
        infoTable += "</tr>";

        for (key in modalHis) {
            if (modalHis.hasOwnProperty(key)) {
                if(key != "index" && key != "id" && key != "position" && key != "lat" && key != "lon" && key != "timeTracking"){
                    // attr += "<div>"+key+": " + modalHis[key] + "</div>";

                    if(modalHis[key] != "" && modalHis[key] != undefined){
                        infoTable += "<tr>";
                        infoTable += "<td>" + key + "</td>";
                        infoTable += "<td>" + modalHis[key] + "</td>";
                        infoTable += "</tr>";
                    }

                }
            }
        }
        infoTable += "</tbody></table>";

        // var sContent = "<div>" +
        //     "<div><b>" + Messages("ID")+ ": " + modalHis.id + "</b></div>" +
        //     "<div>"+Messages("Thời gian")+": " + logdate + "</div>" +
        //     "<div>"+Messages("Vị trí")+": " + convertDMS(modalHis.position.lat(),modalHis.position.lng()) + "</div>" +
        //     attr +
        //     "</div>";

        var newLatLong = new google.maps.LatLng(modalHis.position.lat(),modalHis.position.lng());
        mapHistory.setCenter(newLatLong);
        if (mapHistory.getZoom() <= 16) {
            mapHistory.setZoom(16);
        }

        infowindow = new google.maps.InfoWindow({
            content: infoTable,
        });
        infowindow.setPosition(modalHis.position);
        infowindow.open(mapHistory);

    }
}

function fitBoundMarker() {
    var bounds = new google.maps.LatLngBounds();
    for (var i = 0; i < markerVehicles.length; i++) {
        bounds.extend(markerVehicles[i].position);
    }
    mapHistory.fitBounds(bounds);
}

