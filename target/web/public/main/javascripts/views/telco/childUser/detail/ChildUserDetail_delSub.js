function setDelSubOfChildUser(isdn) {
    $("#isdnDel").val(isdn);
    $("#delSubOfChildUserModal").modal('show');
}

function processDeleteSubOfChildUser() {
    var body = new FormData();
    body.userId = childUserId;
    body.isdn = $("#isdnDel").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.removeSubOfChildUser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                getListSubManage();
                showNotification('success',datas.resultString);
            } else{
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}