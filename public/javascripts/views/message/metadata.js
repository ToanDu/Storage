$(document).ready(function () {
    getMetadata();
});

function processMetadata() {
    var Data = new FormData();
    Data.content = $('#sendJsonMetadata').val();
    Data.deviceId = deviceId;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.MessagesDeviceController.sendMetadata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
            }else{
                showNotification('danger',data.errorString);
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
}

function getMetadata() {
    var Data = new FormData();
    Data.deviceId = deviceId;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.MessagesDeviceController.getMetadata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                if(data.content != null){
                    var strMetadata = JSON.stringify(data.content, undefined, 4);
                    document.getElementById("contentMetadata").appendChild(document.createElement('pre')).innerHTML = strMetadata;
                }
            }else{
                showNotification('danger',data.errorString);
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
}