/**
 * Created by vtk-anhlt166 on 6/8/21.
 */
var checkPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,20}$/;
// $('#inputChoosePassword').on("change", function (){
//     var valid = checkPassword.test($(this).val())
//     console.log(valid)
//     if (valid == false) {
//         showNotification('danger', Messages("Mật khẩu phải có ít nhất 1 ký tự viết hoa, 1 ký tự viết thường, 1 ký tự số, 1 ký tự đặc biệt và Mật khẩu phải có ít nhất 1 ký tự viết hoa, 1 ký tự viết thường, 1 ký tự số, 1 ký tự đặc biệt và có độ dài từ 6-20 kí tự"));
//     }
// })
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

function sendRegister(){
    username = $('#inputUsername').val();
    var data = new FormData();
    data.username = username.trim();
    console.log(data.username);

    data.password = $('#inputChoosePassword').val();
    data.rePassword = $('#inputChooseRePassword').val();
    data.optEmail = $('#inputOtpEmail').val();
    var checkPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,20}$/;
    var checkEmail  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(data.username == undefined || data.username == null || data.username == ""){
        showNotification('danger',Messages("forgot.usernameEmpty"));
        $("inputUsername").focus();
        return;
    }
    if (!checkEmail.test(data.username)) {
        showNotification('danger',Messages("Email không đúng định dạng"));
        $("#inputUsername").focus();
        return;
    }

    var r = jsRoutes.controllers.Application.ForgetPassword();
    var valid = checkPassword.test(data.password);
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
                        window.location.replace("/login");
                    }, 1000);

                } else {
                    showNotification('danger', data.errorString);
                }

            }, error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("Tên đăng nhập và mật khẩu  không được để trống"));
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
    document.getElementById("inputChoosePassword").type = "text";
}

function hidePassword() {
    console.log("hidePassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHidePass").attr("onclick","showPassword()");
    document.getElementById("inputChoosePassword").type = "password";
}

function showRePassword() {
    console.log("showRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHideRePass").attr("onclick","hideRePassword()");
    document.getElementById("inputChooseRePassword").type = "text";
}

function hideRePassword() {
    console.log("hideRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHideRePass").attr("onclick","showRePassword()");
    document.getElementById("inputChooseRePassword").type = "password";
}
function getOtpEmail() {
    var data = new FormData();
    username = $('#inputUsername').val();
    data.username = username.trim()

    var r = jsRoutes.controllers.Application.getOtpEmail();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            var second = 180;
            console.log(data);
            if(data.success){
                showNotification('success', data.resultString);
                var link = document.getElementById('buttonSmsCodeChangePass');
                link.style.pointerEvents = 'none'; // Disable link
                setTimeout(function() {
                    link.style.pointerEvents = 'auto'; // able link
                }, second * 1000+1000);

                var myTimer = setInterval(function () {
                    if(second > 0){
                        $("#buttonSmsCodeChangePass").html("Nhập OTP (" + second + ")");
                        second--;
                        $("#buttonSmsCodeChangePass")[0].disabled = true
                    } else {
                        $("#buttonSmsCodeChangePass").html("Nhận mã OTP");
                        clearInterval(myTimer);
                        $("#buttonSmsCodeChangePass")[0].disabled = false;
                    }
                },1000);

            } else {
                showNotification('danger', data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){

        }
    })
}