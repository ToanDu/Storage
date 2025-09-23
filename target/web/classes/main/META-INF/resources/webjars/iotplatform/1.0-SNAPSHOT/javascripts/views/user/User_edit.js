/**
 * Created by vtk-anhlt166 on 6/2/21.
 */
function setEditUser(id, email) {
    $('#idUserEdit').val(id);
    $('#emailUserEdit').val(email);
}

function postDataEditUser() {
    var Data = new FormData();
    Data.id = $('#idUserEdit').val();
    Data.email = $('#emailUserEdit').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.UserController.editUser();
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