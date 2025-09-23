/**
 * Created by vtk-anhlt166 on 6/3/21.
 */
function chooseTypeVariable() {
    var type = $("#typeVariableAdd").val();
    console.log(type);

    if(type == "string"){
        var inputType = '<label class="form-label text-darker">'+Messages("device.variable.value")+Messages(" *")+'</label>' +
                '<input id="valueVariableAdd" type="text" class="form-control" maxlength="50" autocomplete="off" required>';

        $("#divValueVariable").html(inputType);
    } else if(type == "number"){
        var inputType = '<label class="form-label text-darker">'+Messages("device.variable.value")+Messages(" *")+'</label>' +
            '<input id="valueVariableAdd" type="number" class="form-control" maxlength="50" autocomplete="off" required>';

        $("#divValueVariable").html(inputType);
    } else {
        $("#divValueVariable").html("");
    }
}

function postDataAddVariable() {
    var Data = new FormData();
    Data.id = $('#deviceId').text();
    Data.name = $('#nameVariableAdd').val();
    Data.type = $('#typeVariableAdd').val();
    Data.value = $('#valueVariableAdd').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceVariableController.addVariable();
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