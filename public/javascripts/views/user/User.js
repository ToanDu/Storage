

function getTokenPass(id) {
    var Data = new FormData();
    Data.id = id;

    StartProcess();
    var r = jsRoutes.controllers.UserController.getTokenSendPassUser();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            if(data.success){
                $('#linkCopy').val(data.content.invite_link)
            }else{  //tra ve cau hinh truoc do
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

function copyLinkTokenUser() {

    var copyText = document.getElementById("linkCopy");
    var length = String($('#linkCopy').val()).length;
    copyText.select();
    copyText.setSelectionRange(0, length);
    document.execCommand("copy");
    showNotification('success',"link đã được copy");
}

function setSelectedUser(userId, roleId) {
    localStorage.setItem("selectedUser", userId);
    $('#listRoleDrd').val(roleId).change();
}

function addRoleForUser() {
    var Data = new FormData();
    Data.roleId = $('#listRoleDrd').val();
    Data.userId = localStorage.getItem("selectedUser")

    StartProcess();
    var r = jsRoutes.controllers.UserController.addRoleForUser();
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