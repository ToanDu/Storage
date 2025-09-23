function processSubmitAddChildUser(userId) {
    if(!validateTextEmpty($('#fullNameAdd').val().trim())){
        showNotification('danger', Messages("Họ tên không được bỏ trống"));
        return;
    }
    if($('#emailAdd').val().trim()==''||$('#emailAdd').val().trim()==null){
        showNotification('danger', Messages("Email không được để trống"));
        return;
    }
    if(!validateEmail($('#emailAdd').val().trim())){
        showNotification('danger', Messages("Email không hợp lệ"));
        return;
    }
    if($('#phoneAdd').val().trim() == '' || $('#phoneAdd').val().trim() == null){
        showNotification('danger', Messages("Số điện thoại không được để trống"));
        return;
    }
    if(!validatePhoneVn($('#phoneAdd').val().trim())){
        showNotification('danger', Messages("Số điện thoại không đúng định dạng"));
        return;
    }
    if(inValidPhoneNumber($('#phoneAdd').val().trim())){
        showNotification('danger', Messages("Số điện thoại không đúng định dạng"));
        return;
    }

    var body = new FormData();
    body.name = $('#fullNameAdd').val().trim();
    body.cmp_role = "ENTERPRISE_LV2";
    body.phone = $('#phoneAdd').val();
    body.email = $('#emailAdd').val().trim();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.addChildUserCmp(userId);
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success',Messages("noti.Addsuccess"));
                $("#addChildUserModal").modal('hide');
                getListChildUser();
            } else {
                if(datas.content != null && datas.content.code == 2006){
                    showNotification('danger',Messages("Email đã được sử dụng"));
                } else if(datas.content != null && datas.content.code == 1006){
                    showNotification('danger',Messages("Số điện thoại đã được sử dụng"));
                } else {
                    showNotification('danger',Messages("noti.AddFalse"));
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
            // $('#phoneAdd').val("");
            // $('#emailAdd').val('');
            // $('#fullNameAdd').val('');
        }
    })
}
function inValidPhoneNumber(phoneNumber) {
    if (phoneNumber.length > 11) {
        return true;
    }
    if (!(phoneNumber.startsWith('0') || phoneNumber.startsWith('84'))) {
        return true;
    }
    return false;
}
function closeFormAdd(){
    $('#phoneAdd').val("");
    $('#emailAdd').val('');
    $('#fullNameAdd').val('');

}