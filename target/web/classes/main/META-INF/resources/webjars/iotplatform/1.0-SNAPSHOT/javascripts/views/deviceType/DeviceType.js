function deleteDeviceType(id) {
    $("#idDeviceTypeDel").val(id);
}
function processDeleteTypeId() {
    var groupData = new FormData();
    groupData.id = $('#idDeviceTypeDel').val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.DeviceTypeController.deleteDeviceType();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
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
                showNotification('danger',data.errorString, data.status);
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

function editDeviceType(id, name) {
    $("#idDeviceTypeEdit").val(id);
    $("#nameDeviceTypeEdit").val(name);
}
function postEditDeviceType() {
    var Data = new FormData();
    Data.id = $('#idDeviceTypeEdit').val();
    Data.name = $('#nameDeviceTypeEdit').val().trim();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceTypeController.editDeviceType();
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
                showNotification('danger',data.errorString, data.status);
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