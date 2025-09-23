/**
 * Created by vtk-anhlt166 on 2/22/22.
 */
$(document).ready(function () {
    var r = jsRoutes.controllers.SolutionTrackingController.getListGpsDevice();
    var formData = new FormData;
    formData.projectId = projectId;
    $.ajax({
        url: r.url,
        data: JSON.stringify(formData),
        dataType: "json",
        type: r.type,
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null){
                    if(data.content.devices != null && data.content.devices.length > 0){
                        var option ='<select id="idDevice" class="single-select" style="width: 100%">' +
                            '<option value="">'+Messages("manage.tracking.history.chooseDevice")+'</option>';
                        for(var i=0; i< data.content.devices.length ; i++){
                            option += '<option value="'+data.content.devices[i].id+'">'+data.content.devices[i].name+'</option>';
                        }
                        option += '</select>';
                        $("#selectDevice").html(option);

                        $('.single-select').select2({
                            theme: 'bootstrap4',
                            width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                            placeholder: $(this).data('placeholder'),
                            allowClear: Boolean($(this).data('allow-clear'))
                        });

                        console.log(localStorage.id);
                        $("#idDevice").val(localStorage.id).trigger('change');
                        if(localStorage.id != "" && localStorage.id != undefined){
                            processGetListHistory();
                        }
                    }
                }
            } else {
                showNotification('danger', data.errorString);
            }
        }
    })
});

function searchQuickHistory() {
    var day = $("#searchQuickHistory").val();
    var now = new Date();
    var dateNow = moment.unix(now.getTime()/1000).format("DD/MM/YYYY HH:mm");
    console.log(dateNow);
    if(day == 1){
        $("#date_timepicker_end").val(dateNow);

        var day1 = now.getTime() - 24*60*60*1000;
        var getDay1 = moment.unix(day1/1000).format("DD/MM/YYYY") + " 00:00";
        $("#date_timepicker_start").val(getDay1);

        viewHistoryDataByImei();
    } else if(day == 3){
        $("#date_timepicker_end").val(dateNow);

        var day3 = now.getTime() - 3*24*60*60*1000;
        var getDay3 = moment.unix(day3/1000).format("DD/MM/YYYY") + " 00:00";
        $("#date_timepicker_start").val(getDay3);

        viewHistoryDataByImei();
    } else if(day == 7){
        $("#date_timepicker_end").val(dateNow);

        var day7 = now.getTime() - 7*24*60*60*1000;
        var getDay7 = moment.unix(day7/1000).format("DD/MM/YYYY") + " 00:00";
        $("#date_timepicker_start").val(getDay7);

        viewHistoryDataByImei();
    } else if(day == 15){
        $("#date_timepicker_end").val(dateNow);

        var day7 = now.getTime() - 7*24*60*60*1000;
        var getDay7 = moment.unix(day7/1000).format("DD/MM/YYYY") + " 00:00";
        $("#date_timepicker_start").val(getDay7);

        viewHistoryDataByImei();
    } else if(day == 30){
        $("#date_timepicker_end").val(dateNow);

        var day30 = now.getTime() - 30*24*60*60*1000;
        var getDay30 = moment.unix(day30/1000).format("DD/MM/YYYY") + " 00:00";
        $("#date_timepicker_start").val(getDay30);

        viewHistoryDataByImei();
    }
}

// ------------ Constructor ------------
$(document).ready(function () {

    $('#tohour').on('change', function () {
        if ($('#tohour').val() == "24:") {
            $('select[id=tominute]').val("00");
            $('select[id=tominute]').attr("disabled", true);
            $('select[id=tominute]').change();
        }
        else {
            $('select[id=tominute]').removeAttr('disabled');
            $('select[id=tominute]').change();
        }
    });
    $("#slider-default").slider({
        value: 50,
        orientation: "horizontal",
        range: "min",
        animate: true,
        change: function (event, ui) {
            // console.log("ui: ", ui);
            delay_playback = delay_playback_max - (delay_playback_max * (ui.value / 100));
            if (delay_playback <= 0) {
                delay_playback = delay_playback_min;
            }
            console.log("delay : " + delay_playback);
        }
    });
});
// ///// Click left-panel
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

google.maps.event.addDomListener(window, 'load', initialize);
function initialize() {
    SlidingMarker.initializeGlobally();
    markerSlide = new SlidingMarker({
        icon: point,
        duration: 1000,
        easing: "linear",
    });
}


function processGetListHistory() {
    $("#searchQuickHistory").val("").trigger("change");

    viewHistoryDataByImei();
}
// ------------ Function ------------
function viewHistoryDataByImei() {
    var data = new FormData;
    data.start_time = $("#date_timepicker_start").val().replace(/\//g, "-").replace(" ", ",");
    data.end_time = $("#date_timepicker_end").val().replace(/\//g, "-").replace(" ", ",");
    data.id = $("#idDevice").val();
    if(data.id == null || data.id == "" || data.id == undefined){
        showNotification('danger',Messages("manage.tracking.history.idNull"));
        return;
    }
    localStorage.id = data.id;
    if(data.start_time == undefined || data.start_time.length == 0 || data.end_time == undefined || data.end_time.length == 0){
        showNotification('danger',Messages("manage.tracking.history.empty"));
        return;
    }
    console.log(data);

    if (infowindow != null && infowindow.getMap() != null) {
        infowindow.close();
        infowindow = null;
    }

    StartProcess();
    var r = jsRoutes.controllers.SolutionTrackingController.loadLocationHistory();
    $.ajax({
        url: r.url,
        data: JSON.stringify(data),
        dataType: "json",
        type: r.type,
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            console.log(data);
            if(!data.success){
                emptyItemInScrollArea();
                clearAllMarkers();
                clearArrowCoordinates();
                clearArrowPlaybackCoordinates();
                clearSlideMarker();

                showNotification('danger',data.errorString);
                return;
            }

            emptyItemInScrollArea();
            clearAllMarkers();
            clearArrowCoordinates();
            clearArrowPlaybackCoordinates();
            clearSlideMarker();

            // $("#scroll-area-position table tbody").html("");

            var idx = 0;
            var logs = data.content.logs;
            if(logs.length > 0){
                for (var i = 0; i < logs.length; i++) {
                    isGPSZero = false;

                    if(logs[i].value != null){
                        var valueLocation = logs[i].value;
                        var currentLat = (valueLocation.lat != null) ? valueLocation.lat : 0;
                        var currentLon = (valueLocation.lon != null) ? valueLocation.lon : 0;

                        if (currentLat == 0 || currentLon == 0) {
                            isGPSZero = true;
                        }

                        var newLatLong = new google.maps.LatLng(currentLat, currentLon);

                        if (!isGPSZero) {
                            arrowPathCoordinates.push(newLatLong);
                            // sumdistanceOldGPS = data.positionHistoryList[i].distanceOldGPS;

                            var dataModal = new FormData();
                            dataModal.position = newLatLong;
                            dataModal.index = (idx++);
                            dataModal.id = logs[i].entity_id;
                            dataModal.lat = currentLat;
                            dataModal.lon = currentLon;
                            dataModal.timeTracking = logs[i].ts;
                            for (key in valueLocation) {
                                if (valueLocation.hasOwnProperty(key)) {
                                    // console.log(key, valueLocation[key]);
                                    dataModal[key] = valueLocation[key];
                                }
                            }
                            // console.log(dataModal);
                            historyPositionModals.push(dataModal);
                        }
                    }
                }
            } else {
                showNotification('danger', Messages("manage.tracking.history.noGetHistory"));
            }

            console.log(historyPositionModals);
            $("#id-sum-stt").html(idx);

            if (historyPositionModals.length > 0) {
                for (var i = 0; i < historyPositionModals.length; i++) {
                    console.log(historyPositionModals[i]);

                    appendItemToArea(historyPositionModals[i]);
                    // drawMarkerInHistoryView(historyModals[i], (i==(historyModals.length-1)?destRacing:startRacing));
                }
                drawMarkersInHistoryView();
                fitBoundMarker();
            }

            arrowPath.setMap(mapHistory);
            arrowPathList.push(arrowPath);

        },
        statusCode: {
            404: function () {
                showNotification('danger', Messages("maphistory.emptyDate"));
            }
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
    //FinishProcess();
}

//---------------------------
function appendItemToArea(modalHis) {
    // console.log(modalHis, times);
    var sAction = convertDMS(modalHis.position.lat(),modalHis.position.lng());

    var logdate = (modalHis.timeTracking > 0) ? moment.unix(modalHis.timeTracking).format("DD/MM/YYYY HH:mm:ss") : 0;
    $("#scroll-area-position table tbody:last-child").append('<tr onclick="selectMarker(' + modalHis.index + ',' + false + ' )" style="cursor: pointer" id="history-index-' + modalHis.index + '">' +
        '<td class="text-center">' + (modalHis.index + 1) + '</td>\n' +
        '                            <td>' + sAction + '</td>\n' +
        '                            <td>' + logdate + '</td>\n' +
        '</tr>');
}


function emptyItemInScrollArea() {
    historyPositionModals = [];
    distanceItems = [];
    indexPosition = 0;
    drawPlayBackFlag = false;
    //console.log(" indexOfPosition "+indexOfPosition);
    // $("#scroll-area-position").empty();
    $("#scroll-area-position table tbody").html("");
}

function removeHoverHistoryItem(index) {
    $('#history-index-' + index).css('background-color', '#fff');
}

function setHoverHistoryItem(index) {
    $('#history-index-' + index).css('background-color', '#bac8ff');
    return $('#history-index-' + index);
}

function scrollViewHistoryItems(indexBefore, indexCurrent) {
    // $('#history-index-' + indexBefore).css('background-color', '#fff');
    removeHoverHistoryItem(indexBefore);
    setHoverHistoryItem(indexCurrent);
    var row = setHoverHistoryItem(indexCurrent);
    if (row.length) {
        $("#scroll-area-position").scrollTop(indexCurrent * row.outerHeight() - 15);
    }
}

function changeTotalDistanceHistoryItem(distance) {
    $('#id-sum-total').html((distance / 1000).toFixed(3));
}

function download(filename, text) {
    var pom = document.createElement('a');
    pom.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    pom.setAttribute('download', filename);

    if (document.createEvent) {
        var event = document.createEvent('MouseEvents');
        event.initEvent('click', true, true);
        pom.dispatchEvent(event);
    }
    else {
        pom.click();
    }
}
function getMarkerImageByStatus(type, battery) {
    //0-chưa có tín hiệu; 1-Đang chạy; 2-Đang đậu; 3-Mất GPS; 4-Mất tín hiệu về server; 5-Có Alarm;
    console.log(type);
    var result = point;
    if(type == MARKER_TYPE.SOS.type || type == MARKER_TYPE.BL.type || battery <= 15){
        result = alarm;
    } else if(type == MARKER_TYPE.RUN.type){
        result = startRun;
    } else if(type == MARKER_TYPE.PARK.type){
        result = stop;
    } else {
        result = point;
    }

    return result;

}