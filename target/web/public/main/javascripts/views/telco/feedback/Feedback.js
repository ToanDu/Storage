function sendFeedback() {
    if($("#fullName").val().trim().length == 0){
        showNotification('danger', Messages("feedback.js.fullname.required"));
        return;
    }
    if($("#nameCompany").val().trim().length == 0){
        showNotification('danger', Messages("feedback.js.company.name.required"));
        return;
    }
    if($("#field").val().length == 0){
        showNotification('danger', Messages("feedback.js.field.not.selected"));
        return;
    }
    if($("#content").val().trim().length == 0){
        showNotification('danger', Messages("feedback.js.content.required"));
        return;
    }
    var body = new FormData();
    body.userId = userId;
    body.fullName = $("#fullName").val().trim();
    body.nameCompany = $("#nameCompany").val().trim();
    body.field = $("#field").val();
    body.content = $("#content").val().trim();
    body.rate = $("#rate").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoFeedbackController.sendFeedback();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success',Messages("noti.Sendsuccess"));

                $("#fullName").val("");
                $("#nameCompany").val("");
                $("#field").val("");
                $("#content").val("");
                $("#rate").val(0);
            }else{
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