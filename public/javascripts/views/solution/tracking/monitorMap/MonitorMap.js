/**
 * Created by vtk-anhlt166 on 9/20/21.
 */
var lastIndexMarkerSelected;
var zoomCurrent;
var infowindowList = [];
var contentList = [];

$('#search-device').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#search-device').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_device').each(function() {
        var isMatch = $(this).find('.name_device').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

$(document).ready(function () {
    markerSignalController.allMarkerFirstTimeTracking();

    google.maps.event.addListener(mapPosition, 'zoom_changed', function() {
        controller.showInfoWindowWhenZoom();
    });
});

var controller = (function(){
    var selectMarker = function (idVehicle, isClickMarker) {
        console.log("idVehicle: " + idVehicle + " -- isClickMarker:" + isClickMarker);
        //remove old selected
        localStorage.id = idVehicle;
        vehicleActive = idVehicle;

        var datamodel = new FormData;
        datamodel.id = idVehicle;
        var r = jsRoutes.controllers.SolutionTrackingController.getInfoDevice();
        $.ajax({
            type: r.type,
            dataType: 'json',
            data: JSON.stringify(datamodel),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (data) {
                console.log(data);
                if (data !== undefined && data !== null) {
                    if (isClickMarker) {
                        zoomMarkerById(vehicleActive);

                        scrollViewMapItems(lastIndexMarkerSelected, data.content.id);
                    } else {
                        removeHoverMapItem(lastIndexMarkerSelected);
                        setHoverMapItem(data.content.id);
                    }

                    lastIndexMarkerSelected = data.content.id;

                    if(data.content != null){
                        updateVehicleMarker(data.content, isClickMarker, true);
                    }

                    //show & update infowindows
                    showInfoWindow(data.content, isClickMarker);

                    // console.log(infowindowList);
                    // if(infowindowList.length > 0){
                    //     for(var i=0; i<infowindowList.length; i++){
                    //         infowindowList[i].close();
                    //     }
                    // }
                }
            },
            error: function (response) {
                console.log("error : ",response);
            },
            failure: function (response) {
                console.log("failure : ",response);
            }
        });
    };

    var zoomMarkerById = function (id) {
        //console.log("zoomMarkerById: ", id)
        if (markerVehicles === null || markerVehicles.length === 0) return;
        for (var i = 0; i < markerVehicles.length; i++) {
            if (markerVehicles[i].tag === id) {
                mapPosition.setCenter(new google.maps.LatLng(markerVehicles[i].position.lat(), markerVehicles[i].position.lng()));
                if (mapPosition.getZoom() <= 15) {
                    mapPosition.setZoom(15);
                }
                zoomCurrent = mapPosition.getZoom();
                console.log("zoomCurrent ", zoomCurrent);
            }
        }
    };

    var updateVehicleMarker = function (data, isClickMarker, isShowMarker) {
        console.log(data);

        markerClusterController.removeMarkerFromCluster(data.id);
        //clear signal
        markerSignalController.clearSignals(data.id);
        //redraw
        markerClusterController.addMarkerToClusterSocketForm(data);


        //add signal
        // var imageSignal = markerSignalController.getSignalImageByStatus();
        // markerSignalController.addSignal(data.id, data.currentLat, data.currentLon, imageSignal, isShowMarker);

        // infoWindowCtrl.showInfoWindow(data, isClickMarker);

    };

    return {
        init: function () {

        },
        selectMarker: function (idVehicle, isClickMarker) {
            selectMarker(idVehicle, isClickMarker);
        },
        showInfoWindowWhenZoom: function () {
            var zoomLevel = mapPosition.getZoom();
            if(zoomLevel >= 14){
                console.log(zoomLevel);
                for(var i = markerVehicles.length, bounds = mapPosition.getBounds(); i--;) {
                    if( bounds.contains(markerVehicles[i].getPosition()) ){
                        // code for showing your object
                        // console.log(markerVehicles[i]);

                        var infoWindow = new google.maps.InfoWindow({
                            content: markerVehicles[i].name
                        });
                        if(!contentList.includes(markerVehicles[i].tag)){
                            infowindowList.push(infoWindow);
                            contentList.push(markerVehicles[i].tag);

                            infoWindow.open(mapPosition, markerVehicles[i]);
                        }

                    }
                }
            } else {
                // console.log(infowindowList);
                if(infowindowList.length > 0){
                    for(var i=0; i<infowindowList.length; i++){
                        infowindowList[i].close();
                    }

                    infowindowList = [];
                    contentList = [];
                }
            }
        },
    }
})();

function removeHoverMapItem(index) {
    $('#map-index-' + index).css('background-color', '#fff');
}

function setHoverMapItem(index) {
    $('#map-index-' + index).css('background-color', '#bac8ff');
    return $('#history-index-' + index);
}

function scrollViewMapItems(indexBefore, indexCurrent) {
    removeHoverMapItem(indexBefore);
    setHoverMapItem(indexCurrent);

    var row = setHoverMapItem(indexCurrent);
    if (row.length) {
        $("#scroll-area-position").scrollTop(indexCurrent * row.outerHeight() - 15);
    }
}

$('#menu-toggle').click(function () {
    if ($(this).hasClass("move-in")) {
        $(this).addClass("move-out");
        $('#sidebar-wrapper').addClass("left-panel-2");
        $(this).removeClass("move-in");
        $('#sidebar-wrapper').removeClass("left-panel");
        $('#sidebar-wrapper').hide();
    } else {
        $(this).addClass("move-in");
        $('#sidebar-wrapper').addClass("left-panel");
        $(this).removeClass("move-out");
        $('#sidebar-wrapper').removeClass("left-panel-2");
        $('#sidebar-wrapper').show();
    }
});

$('#searchPhoneNb').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchPhoneNb').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_device').each(function() {
        var isMatch = $(this).find('span').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});