var historyMap = new vtmapgl.Map({
    container: 'map-history',
    style: vtmapgl.STYLES.VTRANS,
    center: [104.266281, 15.664142],
    zoom: 5
});
const scaleHistory = new vtmapgl.ScaleControl({
    position: 'bottom-right'
});
historyMap.addControl(scaleHistory);

function showHistoryMapIsdn(isdn, serial) {
    $("#mapHistoryModal").modal('show');
    setTimeout(function () {
        historyMap.resize();

        $("#isdnHistoryMap").val(isdn);
        $("#serialHistoryMap").val(serial);
        var now = new Date();
        $("#fromDateHistoryMap").val(moment.unix(now.getTime()/1000-6*24*60*60).format("DD/MM/YYYY"));
        $("#toDateHistoryMap").val(moment.unix(now.getTime()/1000).format("DD/MM/YYYY"));
        getHistoryMap();
    },200);
}

function searchHistoryMap() {
    var startTime = $("#fromDateHistoryMap").val();
    var endTime = $("#toDateHistoryMap").val();
    if(startTime.length > 0 && endTime.length > 0){
        var dateNow = new Date();
        var strNow = moment.unix(dateNow.getTime()/1000).format("DD/MM/YYYY");
        var nowMomentObject = moment(strNow, "DD/MM/YYYY");
        var nowObject = nowMomentObject.toDate();

        var startMomentObject = moment(startTime, "DD/MM/YYYY");
        var startObject = startMomentObject.toDate();
        if(startObject.getTime() > nowObject.getTime()){
            showNotification('danger',Messages("Ngày bắt đầu không được lớn hơn ngày hiện tại"));
            return;
        }

        var endMomentObject = moment(endTime, "DD/MM/YYYY");
        var endObject = endMomentObject.toDate();
        if(startObject.getTime() > endObject.getTime()){
            showNotification('danger',Messages("Ngày bắt đầu không được lớn hơn ngày kết thúc"));
            return;
        }
    } else {
        showNotification('danger',Messages("Bạn chưa chọn thời gian"));
        return;
    }

    getHistoryMap();
}

var historyJson = [];
function getHistoryMap() {
    StartProcess();
    removeAllHistory();
    $("#listHistoryMapTable").find('tbody').html("");

    var pageSize = 1000;
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/history?userId='+userId+'&isdn='+$("#isdnHistoryMap").val()+'&serial='+$("#serialHistoryMap").val()+
        '&from='+$("#fromDateHistoryMap").val()+'&to='+$("#toDateHistoryMap").val()+
        '&limit='+pageSize+'&offset=0';
    console.log(formData);
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.data != null){
                if(datas.content.data.data != null && datas.content.data.data.length > 0){
                    var body = "";
                    $("#notiNotHistoryMap").html("");

                    var historys = datas.content.data.data;
                    var features = [];
                    for(var i=0; i < historys.length; i++){
                        var idMk = historys[i].isdn +"-"+i;
                        body += "<tr class='cursor-pointer' onclick='clickMarkerHistory(\""+idMk+"\")'>";
                        body += "<th>"+(i+1)+"</th>";
                        body += "<td class='wrap-text'>" + moment(moment(historys[i].date, "YYYY-MM-DD'T'HH:mm:ss'Z'")).format('DD/MM/YYYY HH:mm:ss') + "</td>";
                        body += "<td class='wrap-text'>" + historys[i].address + "</td>";
                        body += "</tr>";

                        features.push({
                            "type": "Feature",
                            "geometry": {
                                "type": "Point",
                                "coordinates": [historys[i].long, historys[i].lat]
                            },
                            "properties": {
                                "id": idMk,
                                "address": historys[i].address,
                                "time": moment(moment(historys[i].date, "YYYY-MM-DD'T'HH:mm:ss'Z'")).format('DD/MM/YYYY HH:mm:ss')
                            },
                            "id": idMk
                        });
                    }
                    $("#listHistoryMapTable").find('tbody').html(body);

                    historyJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderHistoryWithData(historyJson);
                } else {
                    $("#listHistoryMapTable").find('tbody').html("");
                    $("#notiNotHistoryMap").html("Không có thông tin để hiển thị");
                }
            } else {
                $("#listHistoryMapTable").find('tbody').html("");
                $("#notiNotHistoryMap").html("Không có thông tin để hiển thị");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var listMarkerHistory = [];
function renderHistoryWithData(geojson){
    var fitBounds = [];
    geojson.features.forEach(function(marker, i) {
        // create a HTML element for each feature
        var el = document.createElement('div');
        el.id = marker.properties.id;
        el.className = '';
        el.innerHTML = '<img src="'+iconHistory+'" alt="">';
        el.onclick = function () {
            clickMarkerHistory(marker.properties.id);
        };
        var mk = new vtmapgl.Marker(el)
            .setLngLat(marker.geometry.coordinates)
            .setPopup(new vtmapgl.Popup({
                    offset: 25
                }).setHTML('<h6 style="font-weight: 600;">' + marker.properties.time + '</h6><hr style="border: 0.5px solid #aaa;">' +
                '<h6>' + marker.properties.address + '</h6>')
            )  // add popups
            .addTo(historyMap);
        listMarkerHistory.push(mk);

        fitBounds.push(marker.geometry.coordinates);
    });
    fitBoundHistoryMap(fitBounds);
}

function fitBoundHistoryMap(fitBoundArr) {
    var bounds = new vtmapgl.LngLatBounds();
    if(fitBoundArr.length > 0){
        fitBoundArr.forEach(function(feature) {
            bounds.extend(feature);
        });
        historyMap.fitBounds(bounds, {
            padding: 30
        });
    }
}

function removeAllHistory() {
    if(listMarkerHistory != null && listMarkerHistory.length > 0){
        for (var i = 0; i < listMarkerHistory.length; i++) {
            var marker = listMarkerHistory[i];
            marker.remove();
        }
        listMarkerHistory = [];
    }
}

function clickMarkerHistory(idHistory) {
    var marker = listMarkerHistory.find(x => x._element.id === idHistory);
    console.log(marker);
    historyMap.setCenter([marker._lngLat.lng, marker._lngLat.lat]);
    marker.togglePopup();
}