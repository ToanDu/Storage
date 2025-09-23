/**
 * Created by vtk-anhlt166 on 9/14/22.
 */
$(document).ready(function () {
    // if(phone == null || phone == undefined || phone == ""){
    //     $("#activePhoneModal").modal('show');
    // }
});

function getOtpPhone() {
    var data = new FormData();
    data.phone = $('#phoneUser').val();
    StartProcess();
    var r = jsRoutes.controllers.Application.getOtpPhone();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', data.resultString);

                var second = 600;
                var myTimer = setInterval(function () {
                    console.log(second);
                    if(second > 0){
                        $("#buttonGetOtpPhone").html("Nhập OTP (" + second + ")");
                        second--;
                    } else {
                        $("#buttonGetOtpPhone").html("Nhận mã OTP");
                        clearInterval(myTimer);
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
            FinishProcess();
        }
    })
}

function processActivePhone() {
    var data = new FormData();
    data.phone = $('#phoneUser').val();
    data.otp = $('#inputOtpPhone').val();
    console.log(data);
    StartProcess();
    var r = jsRoutes.controllers.ProjectController.activePhone();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', data.resultString);
                $("#activePhoneModal").modal('hide');
            } else {
                showNotification('danger', data.errorString);
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