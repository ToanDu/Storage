
function toDegreesMinutesAndSeconds(coordinate) {
    var absolute = Math.abs(coordinate);
    var degrees = Math.floor(absolute);
    var minutesNotTruncated = (absolute - degrees) * 60;
    var minutes = Math.floor(minutesNotTruncated);
    // var seconds = Math.floor((minutesNotTruncated - minutes) * 60);
    var seconds = ((minutesNotTruncated - minutes) * 60).toFixed(2);
    return degrees + "°" + minutes + "'" + seconds +"''";
}

function convertDMS(lat, lng) {
    var latitude = toDegreesMinutesAndSeconds(lat);
    var latitudeCardinal = Math.sign(lat) >= 0 ? "N" : "S";

    var longitude = toDegreesMinutesAndSeconds(lng);
    var longitudeCardinal = Math.sign(lng) >= 0 ? "E" : "W";

    return latitude + " " + latitudeCardinal + "<br>" + longitude + " " + longitudeCardinal;
}

function convertDmsLat(lat) {
    var latitude = toDegreesMinutesAndSeconds(lat);
    var latitudeCardinal = Math.sign(lat) >= 0 ? "N" : "S";

    return latitude + " " + latitudeCardinal;
}
function convertDmsLon(lng) {
    var longitude = toDegreesMinutesAndSeconds(lng);
    var longitudeCardinal = Math.sign(lng) >= 0 ? "E" : "W";

    return longitude + " " + longitudeCardinal;
}

function convertDMSUsingSeparate(lat, lng, char) {
    var latitude = toDegreesMinutesAndSeconds(lat);
    var latitudeCardinal = Math.sign(lat) >= 0 ? "N" : "S";

    var longitude = toDegreesMinutesAndSeconds(lng);
    var longitudeCardinal = Math.sign(lng) >= 0 ? "E" : "W";

    return latitude + " " + latitudeCardinal + char + longitude + " " + longitudeCardinal;
}

function analysicDate(timestamp_unix) {
    var newDate = new Date();
    var msRemainder = Date.parse(newDate) - timestamp_unix;
    var days = Math.floor(msRemainder / 86400000, 0);
    msRemainder = msRemainder - (days * 86400000);
    var hours = Math.floor(msRemainder / 3600000, 0);
    msRemainder = msRemainder - (hours * 3600000);
    var minutes = Math.floor(msRemainder / 60000, 0);
    msRemainder = msRemainder - (minutes * 60000);
    var seconds = Math.floor(msRemainder / 1000, 0);
    msRemainder = msRemainder - (seconds * 1000);
    var milliseconds = msRemainder;
    var kq = "";
    if (days > 0) {
        kq = days + "d     ";
    }
    if (days > 0 || hours > 0) {
        kq += hours + "h ";
    }
    if (days > 0 || hours > 0 || minutes > 0) {
        kq += minutes + "' ";
    }
    kq += seconds + "''";
    return kq;

}