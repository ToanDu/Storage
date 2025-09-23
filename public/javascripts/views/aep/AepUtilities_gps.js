function submitGps() {
    if(validateJson($("#editorRequestGps").val().trim())){
        var body = {
            "request": "convert",
            "data": JSON.parse($("#editorRequestGps").val().trim())
        };
        console.log(body);

        StartProcess();
        var r = jsRoutes.controllers.TelcoAepController.requestDataAepGps();
        $.ajax({
            type: r.type,
            dataType: 'json',
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (datas) {
                console.log(datas);
                if(datas.success){
                    editorResponseGps.setValue(JSON.stringify(datas.content, null, 2));

                    if(datas.content.data != null){
                        var lat = datas.content.data.lat;
                        var lon = datas.content.data.lon;

                        var myLatLng = new google.maps.LatLng(lat, lon);
                        var markerVehicle = new google.maps.Marker({
                            position: myLatLng,
                            map: mapPosition,
                            cursor: "default",
                            flat: true,
                            draggable: false,
                            icon: {
                                anchor: new google.maps.Point(32, 32),
                                size: new google.maps.Size(64, 64),
                                url: point,
                                origin: new google.maps.Point(0, 0)
                            },
                            optimized: false
                        });
                        mapPosition.setCenter(myLatLng);
                        if (mapPosition.getZoom() <= 16) {
                            mapPosition.setZoom(16);
                        }
                    }
                } else {
                    showNotification('danger', datas.errorString);
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
    } else {
        showNotification('danger', Messages("Request định vị không đúng định dạng JSON"));
    }
}

function changeApiGeocoding(el) {
    if(el.value == 1){
        var json = {
            "radio": "gsm",
            "cells": [
                {
                    "lac": 42900,
                    "cid": 74875925,
                    "signal": -71
                }
            ],
            "wifi": [
                {
                    "bssid": "34:36:54:bc:5:30",
                    "signal": -53
                },
                {
                    "bssid": "78:58:60:7d:8:1c",
                    "signal": -54
                }
            ]
        };
        editorRequestGps.setValue(JSON.stringify(json, null, 2));
    } else if(el.value == 2){
        var json = {
            "request": "convert",
            "data": {
                "radio": "gsm",
                "cells": [
                    {
                        "lac": 42900,
                        "cid": 74875925,
                        "signal": -71
                    }
                ]
            }
        };
        editorRequestGps.setValue(JSON.stringify(json, null, 2));
    } else if(el.value == 3){
        var json = {
            "request": "convert",
            "data": {
                "radio": "nb-iot",
                "cells": [
                    {
                        "lac": 42900,
                        "cid": 74875925,
                        "signal": -71
                    }
                ]
            }
        };
        editorRequestGps.setValue(JSON.stringify(json, null, 2));
    }

}