function setIdGenPass(id, email) {
    $("#genId").val(id);
    $("#emailResetChildUser").val(email);
    $("#comfirmGenPassModal").modal('show');
}

function generatePass() {
    var body = new FormData();
    body.user_id = $("#genId").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.generatePassAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                $("#generatePassModal").modal('show');
                $("#genPass").val(datas.content.password);
            } else {
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