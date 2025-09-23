/**
 * Created by ANHLT166 on 4/3/2020.
 */
var STATUS_VEHICLE = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    NO_SIGNAL_YET: {value: 0, name: "Chưa có tín hiệu"},
    RUNNING: {value: 1, name: "Đang chạy",  name2: "Knots"},
    PARKING: {value: 2, name: "Đang đậu"},
    GPS_LOST: {value: 3, name: "Mất tín hiệu GPS"},
    SIGNAL_LOST: {value: 4, name: "Mất tín hiệu về máy chủ"},
    ALARM: {value: 5, name: "Có cảnh báo"},
};
function rotateIconSlideWithStatus(status, deviceType) {
    // console.log(rotation, status, deviceType);
    var imageRotated = getIcoFromDegreeAndStatus(status, deviceType);
    var ico = {
        anchor: new google.maps.Point(16, 16),
        origin: new google.maps.Point(0, 0),
        url: imageRotated
    };
    return ico ;
}

function getIcoFromDegreeAndStatus(status, deviceType){
    // console.log(status, degree);
    var nameImageDegree = "";
    var step = 0;

    nameImageDegree = "device_vtag";

    if(nameImageDegree in window){
        return window[nameImageDegree];
    }else{
        return nameImageDegree;
    }
}