/**
 * Created by vtk-anhlt166 on 6/8/21.
 */
var checkPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,20}$/;
$("#inputChoosePassword").keyup(function(event) {
    if (event.keyCode == 13) {
        $("#loginButton").click();
    }
});

$("#inputChooseRePassword").keyup(function(event) {
    if (event.keyCode == 13) {
        $("#loginButton").click();
    }
});

function sendChangPassword(){
    old_password = $('#inputoldPassword').val();
    var data = new FormData();
    data.old_password = old_password.trim();
    console.log(data.old_password);

    data.new_password = $('#inputnewPassword').val();
    data.new_passwordRepeat = $('#inputnewRePassword').val();
    var checkPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,20}$/;
    if(data.old_password == undefined || data.old_password == null || data.old_password == ""){
        showNotification('danger',Messages("Mật khẩu cũ không được để trống"));
        $("inputoldPassword").focus();
        return;
    }
    if(data.new_password == undefined || data.new_password == null || data.new_password == ""){
        showNotification('danger',Messages("Mật khẩu mới không được để trống."));
        $("inputoldPassword").focus();
        return;
    }
    if(data.new_passwordRepeat == undefined || data.new_passwordRepeat == null || data.new_passwordRepeat == ""){
        showNotification('danger',Messages("Xác nhận mật khẩu mới không được để trống."));
        $("inputoldPassword").focus();
        return;
    }
    if(data.old_password == data.new_password){
        showNotification('danger',Messages("Mật khẩu mới không được trùng mật khẩu cũ"));
        $("inputoldPassword").focus();
        return;
    }
    if(data.new_passwordRepeat != data.new_password){
        showNotification('danger',Messages("Nhập lại mật khẩu phải khớp với Mật khẩu."));
        $("inputoldPassword").focus();
        return;
    }


    var r = jsRoutes.controllers.FogotPassController.ChangePassword();
    var valid = checkPassword.test(data.new_password);
    if(valid == true) {
        $.ajax({
            type: r.type,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (data) {
                console.log(data);
                if (data.success) {
                    showNotification('success', data.resultString);
                    setTimeout(function () {
                        window.location.replace("/");
                    }, 1000);

                } else {
                    showNotification('danger', "Mật khẩu cũ không đúng");
                }

            }, error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("Mật khẩu không được để trống"));
            }, complete: function (){}
        })
    } else {
        showNotification('danger', Messages("Mật khẩu phải có ít nhất 1 ký tự viết hoa, 1 ký tự viết thường, 1 ký tự số, 1 ký tự đặc biệt và có độ dài từ 6-20 kí tự"));
    }
}

function showPassword() {
    console.log("showPassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHidePass").attr("onclick","hidePassword()");
    document.getElementById("inputoldPassword").type = "text";
}

function hidePassword() {
    console.log("hidePassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHidePass").attr("onclick","showPassword()");
    document.getElementById("inputoldPassword").type = "password";
}
function showPassword1() {
    console.log("showPassword1");
    document.getElementById("iconHidenewPass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHidenewPass").attr("onclick","hidePassword1()");
    document.getElementById("inputnewPassword").type = "text";
}

function hidePassword1() {
    console.log("hidePassword1");
    document.getElementById("iconHidenewPass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHidenewPass").attr("onclick","showPassword1()");
    document.getElementById("inputnewPassword").type = "password";
}

function showRePassword() {
    console.log("showRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHideRePass").attr("onclick","hideRePassword()");
    document.getElementById("inputnewRePassword").type = "text";
}

function hideRePassword() {
    console.log("hideRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHideRePass").attr("onclick","showRePassword()");
    document.getElementById("inputnewRePassword").type = "password";
}

