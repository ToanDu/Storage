function comfirmRemoveInfoEnterprise(stt) {
    $("#idEnterpriseDel").val("");
    $("#nameEnterpriseDel").val("");
    $("#gpkdEnterpriseDel").val("");

    var idEnterprise = $("#id_doanh_nghiep_"+stt).val();
    $("#idEnterpriseDel").val(idEnterprise);
    $("#sttEnterpriseDel").val(stt);
    $("#nameEnterpriseDel").val($("#tenDoanhNghiep_"+stt).val());
    $("#gpkdEnterpriseDel").val($("#soGpkd_"+stt).val());

    $("#delEnterpriseModal").modal('show');
}

function processRemoveInfoEnterprise() {
    var data = new FormData();
    data.enterpriseId = $("#idEnterpriseDel").val();
    console.log(data);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.deleteInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                if(!data.content.skip_approve){
                    $("#delEnterpriseModal").modal('hide');
                    showNotification('success', Messages("Đã gửi yêu cầu xóa thông tin doanh nghiệp ") + $('#nameEnterpriseDel').val());
                    $("#notiApproved_"+$("#sttEnterpriseDel").val()).html("<p style='color: orangered; font-weight: 600;'>"+Messages("*Thông tin doanh nghiệp đang chờ duyệt xóa")+"</p>");
                }
                else{
                    $("#delEnterpriseModal").modal('hide');
                    // getInfoCompany();
                    showNotification('success', Messages("Xóa thông tin doanh nghiệp thành công ") + $('#nameEnterpriseDel').val());
                }
                setTimeout(function () {
                    window.location.reload();
                },1500);
            } else {
                showNotification('success', Messages("Gửi yêu cầu xóa thông tin doanh nghiệp ") + $('#nameEnterpriseDel').val() + Messages(" không thành công"));
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