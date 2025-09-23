

function showPassword() {
    console.log("showPassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHidePass").attr("onclick","hidePassword()");
    document.getElementById("inputChoosePassword").type = "text";
}

function hidePassword() {
    console.log("hidePassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHidePass").attr("onclick","showPassword()");
    document.getElementById("inputChoosePassword").type = "password";
}

var phoneUsername = "";
function checkIpLogin(){
    var data = new FormData();
    data.username = $("#inputEmail").val().trim();
    console.log(data.username);
    StartProcess();
    var r = jsRoutes.controllers.Application.checkIpLogin();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if (data.success) {
                $("#form-login").submit();
            } else {
                //send otp
                $("#optPhoneLoginModal").modal('show');
                showNotification('success', Messages("OTP đã được gửi tới số điện thoại ***")+data.content.substring(6));
                phoneUsername = data.content;
            }
        }, error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("noti.disconnect"));
        }, complete: function (){
            FinishProcess();
        }
    })
}

function comfirmOtpLogin() {
    if($('#optPhoneLogin').val().length == 0){
        showNotification('danger', Messages("Bạn chưa nhập mã OTP"));
        return;
    }
    var data = new FormData();
    data.phone = phoneUsername;
    data.otp = $('#optPhoneLogin').val();
    console.log(data);
    StartProcess();
    var r = jsRoutes.controllers.Application.verifyPhone();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                $("#optPhoneLoginModal").modal('hide');
                $("#form-login").submit();
            } else {
                showNotification('danger', Messages("Xác thực không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}