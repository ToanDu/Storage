var arrowPathList = [];
var arrowPlaybackPathList = [];

var lineSymbol = {
    path: 'M 0,-1 0,1',
    strokeOpacity: 1,
    scale: 2
};


var arrowSymbol = {
    path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
    strokeColor: "#00a5bb",
    strokeOpacity: 0.9,
    strokeWeight: 1.5,
    scale: 2.5
};
var arrowPath = new google.maps.Polyline({
    map: mapHistory,
    strokeColor: "#00a5bb",
    strokeOpacity: 1.0,
    strokeWeight: 2,
    // strokeOpacity: 0,
    // strokeColor: "#00a5bb",
    icons: [{
        repeat: '150px', //Khoảng cách giữa các mũi tên
        icon: arrowSymbol,
        offset: '90%',
    }, {
        icon: lineSymbol,
        offset: '0',
        repeat: '10px'
    }],
});

var arrowPlaybackPath = new google.maps.Polyline({
    map: mapHistory,
    strokeColor: "#00a5bb",
    strokeOpacity: 1.0,
    strokeWeight: 2,
    icons: [{
        repeat: '150px', //Khoảng cách giữa các mũi tên
        icon: arrowSymbol,
        offset: '90%',
    }],
});


var arrowPathCoordinates = arrowPath.getPath();
var arrowPlaybackPathCoordinates = arrowPlaybackPath.getPath();

function clearArrowCoordinates() {
    //console.log(arrowPathList);
    if (arrowPathList.length == 0) {
        return;
    }
    for (var i = 0; i < arrowPathList.length; i++) {
        arrowPathList[i].setMap(null);
    }
    arrowPathList = [];
    while (arrowPathCoordinates.length > 0) {
        arrowPathCoordinates.pop();
    }
}

function clearArrowPlaybackCoordinates() {
    //console.log(arrowPathList);
    if (arrowPlaybackPathList.length == 0) {
        return;
    }
    for (var i = 0; i < arrowPlaybackPathList.length; i++) {
        arrowPlaybackPathList[i].setMap(null);
    }
    arrowPlaybackPathList = [];
    while (arrowPlaybackPathCoordinates.length > 0) {
        arrowPlaybackPathCoordinates.pop();
    }
}

function clearSlideMarker() {
    if (slideMarkerList.length == 0) {
        return;
    }
    for (var i = 0; i < slideMarkerList.length; i++) {
        slideMarkerList[i].setMap(null);
    }
    slideMarkerList = [];
}

var scrollTopLength = 0;

function playbackHistory() {
    if (drawPlayBackFlag) {
        console.log("playbackHistory return: ", drawPlayBackFlag);
        showNotification('danger',Messages("manage.tracking.history.playView"));
        return;
    }
    if (historyPositionModals.length == 0) {
        console.log("playbackHistory return: not found history");
        showNotification('danger',Messages("manage.tracking.history.notHistory"));
        return;
    }

    drawPlayBackFlag = true;
    var isNew = (indexPosition == 0);

    if (infowindow != null && infowindow.getMap() != null) {
        infowindow.close();
        infowindow = null;
    }

    document.getElementById("buttonPlayStop").setAttribute('onclick','stopPlayBack()');
    $("#buttonPlayStop").html('<i class="bx bx-pause-circle"></i> ' + Messages("manage.tracking.history.stop"));

    if (isNew) {
        scrollTopLength = 0;
        clearAllMarkers();
        clearArrowCoordinates();
        clearArrowPlaybackCoordinates();
        clearSlideMarker();
        removeHoverHistoryItem(lastIndexMarkerSelected);
        setHoverHistoryItem(0);
        lastIndexMarkerSelected = 0;

        drawSourceDestinationPostionMarker(startRacing, historyPositionModals[indexPosition].position, indexPosition);
        markerSlide.setDuration(delay_playback);
        markerSlide.setEasing(effect_playback);

        markerSlide.setPosition(historyPositionModals[indexPosition].position);
        markerSlide.setMap(mapHistory);
        markerSlide.setIcon(rotateMarkerSlide(historyPositionModals[indexPosition].position, historyPositionModals[indexPosition + 1].position));
        slideMarkerList.push(markerSlide);

        markerSlide.setPosition(historyPositionModals[indexPosition++].position);
        //arrowPlaybackPathCoordinates.push(historyPositionModals[indexPosition].position);
        arrowPlaybackPath.setMap(mapHistory);
        arrowPlaybackPathList.push(arrowPlaybackPath);

    } else {
        if (indexPosition > 0)
            indexPosition--;
        markerSlide.setPosition(historyPositionModals[indexPosition].position);
    }
}

function finish() {
    if (!drawPlayBackFlag) {
        // indexPosition = 0 ;
        return;
    }
    //console.log(" indexPosition before: ", indexPosition);
    if (indexPosition == 1) {
        // removeHoverforDiv(historyPositionModals.length - 1);
        scrollViewHistoryItems(indexPosition - 1, indexPosition);
    }

    if (indexPosition >= historyPositionModals.length) {
        // displayDrawPlayBackBtn();
        //  flightPlanCoordinates.push(historyPositionModals[indexPosition - 1].position);
        drawSourceDestinationPostionMarker(destRacing, historyPositionModals[indexPosition - 1].position, indexPosition - 1);
        arrowPlaybackPathCoordinates.push(historyPositionModals[indexPosition - 1].position);
        drawPlayBackFlag = false;
        indexPosition = 0;

        setTimeout(function () {
            document.getElementById("buttonPlayStop").setAttribute('onclick','playbackHistory()');
            $("#buttonPlayStop").html('<i class="bx bx-play-circle"></i> ' + Messages("manage.tracking.history.play"));
        },500);

        return;
    }
    // setHoverforDiv(indexPosition);
    // removeHoverforDiv(indexPosition - 1);
    scrollViewHistoryItems(lastIndexMarkerSelected, indexPosition);
    lastIndexMarkerSelected = indexPosition;
    changeTotalDistanceHistoryItem(historyPositionModals[indexPosition].distanceOld);


    //var radianAngle = bearing(historyPositionModals[indexPosition - 1].position, historyPositionModals[indexPosition].postion);

    var ico = rotateMarkerSlide(historyPositionModals[indexPosition - 1].position, historyPositionModals[indexPosition].position);

    //RESET old Marker state/icon/tag
    markerSlide.setIcon(ico);
    ico = null;

    markerSlide.setDuration(delay_playback);

    markerSlide.setPosition(historyPositionModals[indexPosition].position);

    arrowPlaybackPathCoordinates.push(historyPositionModals[indexPosition - 1].position);
    if (indexPosition > 1) {

        drawPlaybackPositionMarker(indexPosition - 1, getMarkerImageByStatus(historyPositionModals[indexPosition - 1].type, historyPositionModals[indexPosition - 1].battery));
    }

    boundMapOnPlayback(indexPosition);

    indexPosition++;
}

function stopPlayBack() {
    console.log("pausePlayBack");
    drawPlayBackFlag = false;

    document.getElementById("buttonPlayStop").setAttribute('onclick','playbackHistory()');
    $("#buttonPlayStop").html('<i class="bx bx-play-circle"></i> ' + Messages("manage.tracking.history.play"));
}


function bearing(from, to) {

    google.maps.LatLng.prototype.latRadians = function () {
        return (Math.PI * this.lat()) / 180;
    };

    google.maps.LatLng.prototype.lngRadians = function () {
        return (Math.PI * this.lng()) / 180;
    };
    // Convert to radians.
    var lat1 = from.latRadians();
    var lon1 = from.lngRadians();
    var lat2 = to.latRadians();
    var lon2 = to.lngRadians();
    // Compute the angle.
    var angle = -Math.atan2(Math.sin(lon1 - lon2) * Math.cos(lat2), Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    if (angle < 0.0)
        angle += Math.PI * 2.0;
    if (angle == 0) {
        angle = 1.5;
    }
    return angle;
}

function rotateMarkerSlide(from, to) {
    //console.log(from, to);
    var radianAngle = bearing(from, to);

    var RotateIcon = function (options) {
        this.options = options || {};
        this.rImg = options.img || new Image();
        this.rImg.src = this.rImg.src || this.options.url || '';
        this.options.width = this.options.width || this.rImg.width || 52;
        this.options.height = this.options.height || this.rImg.height || 60;
        var canvas = document.createElement("canvas");
        canvas.width = this.options.width;
        canvas.height = this.options.height;
        this.context = canvas.getContext("2d");
        this.canvas = canvas;
    };

    RotateIcon.makeIcon = function (url) {
        return new RotateIcon({url: url});
    };

    RotateIcon.prototype.setRotation = function (options) {
        var canvas = this.context,
            angle = options.deg ? options.deg * Math.PI / 180 :
                options.rad,
            centerX = this.options.width / 2,
            centerY = this.options.height / 2;
        canvas.clearRect(0, 0, this.options.width, this.options.height);
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(angle);
        canvas.translate(-centerX, -centerY);
        canvas.drawImage(this.rImg, 0, 0);
        canvas.restore();
        return this;
    };

    RotateIcon.prototype.getUrl = function () {
        return this.canvas.toDataURL('image/png');
    };

    var ico = {
        anchor: new google.maps.Point(8, 8),
        origin: new google.maps.Point(16, 16),
        url: RotateIcon
            .makeIcon(point)
            .setRotation({rad: radianAngle})
            .getUrl()
    };

    return ico;
}


function boundMapOnPlayback(index) {
    if (!checkMapBounds(historyPositionModals[index].position.lat(), historyPositionModals[index].position.lng())) {
        mapHistory.setCenter(historyPositionModals[index].position);
    }

}

function checkMapBounds(lat, lng) {
    var MapBound = mapHistory.getBounds();
    if (lat > MapBound.getNorthEast().lat()) return false;
    if (lat < MapBound.getSouthWest().lat()) return false;
    if (lng > MapBound.getNorthEast().lng()) return false;
    if (lng < MapBound.getSouthWest().lng()) return false;
    return true;
}

function changeSpeedPlay() {
    var speed = $("#changeSpeedPlay").val();
    delay_playback = delay_playback_max/speed;
    console.log(delay_playback);
}