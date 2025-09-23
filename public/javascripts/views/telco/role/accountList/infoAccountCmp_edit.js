/**
 * Created by vtk-anhlt166 on 3/9/23.
 */
$(document).ready(function () {
    // $('#fullName').bind('keypress', textInput);
    var fullNameInput = document.getElementById("fullName");
    fullNameInput.addEventListener("input", function() {
        var inputValue = fullNameInput.value;

        var updatedValue = "";
        for (var i = 0; i < inputValue.length; i++) {
            var currentChar = inputValue.charAt(i);

            if (isVietnameseCharacter(currentChar)) {
                updatedValue += currentChar;
            }
        }

        fullNameInput.value = updatedValue;

    });
});
function textInput(event) {
    var value = String.fromCharCode(event.which);
    var pattern = new RegExp(/[a-zåäö ]/i);
    return pattern.test(value);
}

function setEditEnterprise(id, name, gpkd) {
    $("#idEnterpriseEdit").val(id);
    $("#nameEnterpriseEdit").val(name);
    $("#gpkdEnterpriseEdit").val(gpkd);

    $("#editEnterpriseModal").modal('show');
}

function processSubmitEditEnterprise() {
    if(!validateTextEmpty($('#nameEnterpriseEdit').val().trim())){
        showNotification('danger', Messages("Tên doanh nghiệp không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#gpkdEnterpriseEdit').val().trim())){
        showNotification('danger', Messages("GPKD không được bỏ trống"));
        return;
    }

    var body = new FormData();
    body.idNo = $('#gpkdEnterpriseEdit').val().trim();
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.validateGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                var body2 = new FormData();
                body2.id = $('#idEnterpriseEdit').val();
                body2.name = $('#nameEnterpriseEdit').val().trim();
                body2.business_license = $('#gpkdEnterpriseEdit').val().trim();
                console.log(body2);
                // StartProcess();
                var r = jsRoutes.controllers.TelcoRoleAccountController.editEnterprise();
                $.ajax({
                    type: r.type,
                    data: JSON.stringify(body2),
                    contentType: "application/json; charset=utf-8",
                    url: r.url,
                    success: function(datas){
                        console.log(datas);
                        var respon = datas.content.code;
                        console.log(respon);
                        if(datas.success){
                            showNotification('success',Messages("noti.Updatesuccess"));
                            $("#editEnterpriseModal").modal('hide');
                            getInfoAccountCmp();

                        } else {
                            if(respon == 2021){
                                showNotification('danger',Messages("Số GPKD đã tồn tại"));
                            }else{
                                showNotification('danger',Messages("noti.Updatefalse"));
                            }

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
            } else {
                showNotification('danger',Messages("GPKD không tồn tại trên hệ thống"));
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            // FinishProcess();
        }
    })


}

function processSubmitUpdateEnterprise() {
    if(!validateTextEmpty($('#fullName').val().trim())){
        showNotification('danger', Messages("Họ tên không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#phone').val().trim())){
        showNotification('danger', Messages("Số điện thoại không được bỏ trống"));
        return;
    }
    if(!validatePhoneVn($('#phone').val().trim())){
        showNotification('danger', Messages("Số điện thoại không hợp lệ"));
        return;
    }

    var body = new FormData();
    body.id = $('#id').val();
    body.name = $('#fullName').val().trim();
    body.phone = $('#phone').val().trim();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.updateEnterprise();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.success){
                showNotification('success',Messages("noti.Updatesuccess"));
            } else {
                if(datas.content != null && datas.content.code == 1006){
                    showNotification('danger',Messages("Số điện thoại đã được sử dụng"));
                } else {
                    showNotification('danger',Messages("noti.Updatefalse"));
                }
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