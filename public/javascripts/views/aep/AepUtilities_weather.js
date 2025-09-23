function submitWeather() {
    if(validateJson($("#editorRequestWeather").val().trim())){
        var body = {
            "request": "weather",
            "data": JSON.parse($("#editorRequestWeather").val().trim())
        };
        console.log(body);

        StartProcess();
        var r = jsRoutes.controllers.TelcoAepController.requestDataAepWeather();
        $.ajax({
            type: r.type,
            dataType: 'json',
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (datas) {
                console.log(datas);
                if(datas.success){
                    editorResponseWeather.setValue(JSON.stringify(datas.content, null, 2));
                } else {
                    showNotification('danger', Messages("noti.SendFalse"));
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
            },
            complete: function (jqXHR, textStatus) {
                FinishProcess(); //Stop display loading...
            }
        });
    } else {
        showNotification('danger', Messages("Request không đúng định dạng JSON"));
    }
}