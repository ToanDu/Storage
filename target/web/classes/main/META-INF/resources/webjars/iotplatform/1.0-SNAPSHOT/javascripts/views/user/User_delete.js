/**
 * Created by vtk-anhlt166 on 6/2/21.
 */
function setDeleteUser(id) {
    $('#idUserDelete').val(id);
}

function postDataDeleteUser() {
    var Data = new FormData();
    Data.id = $('#idUserDelete').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.UserController.deleteUser();
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
            }else{  //tra ve cau hinh truoc do
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