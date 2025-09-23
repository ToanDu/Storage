var isWSClosed = true;
var missed_reconnects = 0;

function isSecure()
{
    return window.location.protocol == 'https:';
}

function startSocket(urlWS, minuteMode) {
    var socket = new WS(urlWS);
    var heartbeat_ping_msg = '{"type":"ping", "minuteMode" : ' + minuteMode + '}';

    var openSocketEvent = function(event) {
        // showNotification('success',Messages("ais.socket.NotiOpenConnect"));
        isWSClosed = false;
        missed_reconnects = 0;
        // clientPingHeartbeat(socket);
        socket.send(heartbeat_ping_msg);
    };
    var receiveSocketEvent = function(event) {
        // console.log(event);
        var datajson = event.data;

        if(datajson=== null||datajson===""||typeof datajson !== 'string'){
            return;
        }

        updateData(JSON.parse(datajson));
        // start Web Socket load device position after 20s
        // setTimeout(function() { socket.send(heartbeat_ping_msg) }, minuteMode ? 60000 : 60000);

    };
    var closeSocketEvent = function(event) {
        // showNotification('danger',Messages("ais.socket.NotiLostConnect"));
        isWSClosed = true;
    };
    var errorSocketEvent = function(event) {
        // showNotification('danger',Messages("ais.socket.NotiErrorConnect"));
    };

    socket.onopen = openSocketEvent;
    socket.onmessage = receiveSocketEvent;
    socket.onclose = closeSocketEvent;
    socket.onerror = errorSocketEvent;
    return socket;
}

function updateData(datajson) {
    console.log(datajson);
    $("#totalUserHeader").html(datajson.totalUser);
    $("#totalDeviceHeader").html(datajson.totalDevice);


}