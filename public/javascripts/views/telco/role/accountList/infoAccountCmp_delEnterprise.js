/**
 * Created by vtk-anhlt166 on 3/8/23.
 */
function setDelEnterprise(id, name) {
    $("#idEnterpriseDel").val(id);
    $("#nameEnterpriseDel").html("Bạn có chắc chắn muốn xoá doanh nghiệp " + name + " ?");
    $("#delEnterpriseModal").modal('show');
}

function processSubmitDeleteEnterprise() {
    var body = new FormData();
    body.enterpriseId = $("#idEnterpriseDel").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.deleteEnterprise();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                if(roleCmp == "SUPER_ADMIN"){
                    showNotification('success',Messages("noti.Deletesuccess"));
                } else {
                    showNotification('success',Messages("Yêu cầu xóa thành công"));
                }
                $("#delEnterpriseModal").modal('hide');
                getInfoAccountCmp();
            } else {
                showNotification('danger',Messages("noti.Deletefalse"));
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