vtmapgl.accessToken = 'd5a99809c51e52d6ea31d0b3034ed921';
// Init map
let map = new vtmapgl.Map({
    container: 'viettel_map',
    style: vtmapgl.STYLES.VTRANS,
    center: [108.21162700000002, 16.05967],
    zoom: 5
});
const scale = new vtmapgl.ScaleControl({
    position: 'bottom-right'
});
map.addControl(scale);

map.on('mousemove', function (e) {
    map.getCanvas().style.cursor = 'pointer';
});

let zoomCurrent = map.getZoom();
let isShowRegion = true;
let isShowProvince = false;
let isShowDistrict = false;
//let zoomOnSearch = true;
map.on('zoom', function () {
    const currentZoom = map.getZoom();
    // console.log(currentZoom);
    // console.log('onSearch', zoomOnSearch);
    if (zoomOnSearch == false) {
        if (currentZoom <= 7) {
            if (!isShowRegion) {
                isShowRegion = true;
                isShowProvince = false;
                isShowDistrict = false;
                removeAllMarker();
                getDataWithRegion();
            }
        } else if (currentZoom > 7 && currentZoom <= 9) {
            if (!isShowProvince) {
                isShowRegion = false;
                isShowProvince = true;
                isShowDistrict = false;
                removeAllMarker();
                getDataWithProvince();
            }
        } else if (currentZoom > 9 && currentZoom <= 11) {
            if (!isShowDistrict) {
                isShowRegion = false;
                isShowProvince = false;
                isShowDistrict = true;
                removeAllMarker();
                getDataWithDistrict();
            }
        }
    }
    if (currentZoom > 11) {
        zoomOnSearch = false;
    }
});

function fitBoundMap(fitBoundArr) {
    let bounds = new vtmapgl.LngLatBounds();
    if (fitBoundArr.length > 0) {
        fitBoundArr.forEach(function (feature) {
            bounds.extend(feature);
        });
        map.fitBounds(bounds, {
            padding: 30
        });
    }
}

function removeAllMarker() {
    if (listMarkers != null && listMarkers.length > 0) {
        for (let i = 0; i < listMarkers.length; i++) {
            let marker = listMarkers[i];
            marker.remove();
        }
        listMarkers = [];
    }
}

let listMarkers = [];
function renderMarkerWithData(geojson, type) {
    let fitBounds = [];
    geojson.features.forEach(function (marker, i) {
        // create a HTML element for each feature
        let el = document.createElement('div');
        if (type == "cell") {
            el.className = 'marker markerCell';
        } else {
            el.className = 'marker';
        }
        el.innerHTML = '<span><b>' + marker.properties.total + '</b></span>';
        if (type == "district") {
            el.ondblclick = function () {
                dbclickDistrictMarker(marker.properties.id);
            };
        }
        if (type == "cell") {
            el.onclick = function () {
                clickCellMarker(marker.properties.id, marker.properties.lac, marker.properties.description, marker.properties.total);
            };
        }

        let mk = new vtmapgl.Marker(el)
            .setLngLat(marker.geometry.coordinates)
            .setPopup(new vtmapgl.Popup({
                offset: 25
            }).setHTML('<h6 style="">' + marker.properties.title + '</h6>')
                // '<small>' + Messages("Tổng số TB: ")+ marker.properties.total + '</small>')
            )  // add popups
            .addTo(map);
        listMarkers.push(mk);

        if (type == "cell") {
            fitBounds.push(marker.geometry.coordinates);
        }
    });
    if (type == "cell") {
        fitBoundMap(fitBounds);
    }
}