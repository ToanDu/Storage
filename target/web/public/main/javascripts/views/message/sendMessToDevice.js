function processMessToDevice() {
    var Data = new FormData();
    Data.content = $('#sendMessageData').val();
    Data.deviceId = deviceId;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.MessagesDeviceController.sendMessageData();
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
            }else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            setTimeout(function () {
                window.location.reload();
            },1000);
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}