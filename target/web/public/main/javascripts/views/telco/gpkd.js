/**
 * Created by vtk-anhlt166 on 11/18/22.
 */
$(document).ready(function () {
    getInfoAccount();
});

function getInfoAccount() {
    var r = jsRoutes.controllers.TelcoAccountController.getInfoGpkdApproved();
    $.ajax({
        type: r.type,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(datas){
            console.log('%c getInfoAccount', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var data = datas.content.data[0];
                    console.log(data.business_license);
                    $("#gpkd").val(data.business_license != null ? data.business_license : "");
                } else {
                    showNotification('danger', Messages("Bạn chưa có giấy phép kinh doanh hoặc chưa được duyệt. Vui lòng cập nhật tại trang Thông tin tài khoản!"));
                }
            } else {
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('danger', datas.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
        }
    })
}