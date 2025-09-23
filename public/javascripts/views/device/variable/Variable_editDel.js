/**
 * Created by vtk-anhlt166 on 6/4/21.
 */
function setEditVariable(id, name, type, value) {
    console.log(name, type, value);
    $('#idVariableEdit').val(id);
    $('#nameVariableEdit').val(name);
    $('#typeVariableEdit').val(type).change();
    $('#valueVariableEdit').val(value);
}

function chooseEditTypeVariable() {
    var type = $("#typeVariableEdit").val();
    console.log(type);

    if(type == "text"){
        var inputType = '<label class="form-label text-darker">'+Messages("device.variable.value")+Messages(" *")+'</label>' +
            '<input id="valueVariableEdit" type="text" class="form-control" maxlength="50" autocomplete="off" required>';

        $("#divEditVariable").html(inputType);
    } else if(type == "number"){
        var inputType = '<label class="form-label text-darker">'+Messages("device.variable.value")+Messages(" *")+'</label>' +
            '<input id="valueVariableEdit" type="number" class="form-control" maxlength="50" autocomplete="off" required>';

        $("#divEditVariable").html(inputType);
    } else {
        $("#divEditVariable").html("");
    }
}

function postDelVariable() {
    var Data = new FormData();
    Data.idDevice = $('#deviceId').text();
    Data.idVariable = $('#idVariableEdit').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceVariableController.delVariable();
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