/**
 * Created by vtk-anhlt166 on 3/16/23.
 */
function setDeleteAccountCmp(id, email) {
    $("#idAccountCmpDel").val(id);
    $("#nameAccountCmpDel").html("Bạn có chắc chắn muốn xoá tài khoản " + email + " ?");
    $("#delAccountCmpModal").modal('show');
}

function processDeleteAccountCmp() {
    var body = new FormData();
    body.userId = $("#idAccountCmpDel").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.deleteAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success',datas.resultString);
                getListAccount();
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