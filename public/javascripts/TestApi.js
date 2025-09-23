function sendPostFormUrlencoded() {
    var body = new FormData;
    body.url = $("#url").val();
    body.data = $("#data").val();

    var r = jsRoutes.controllers.HomeController.testPostFormUrlencoded();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            $("#resultData").text(data.body);
        },
        error: function (xhr) {
        console.log(xhr);
        showNotification('error',Messages("connection.failed"));
    }
    });
}

function sendPostJson() {
    var body = new FormData;
    body.url = $("#url").val();
    body.data = $("#data").val();

    var r = jsRoutes.controllers.HomeController.testPostJson();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            $("#resultData").text(data.body);
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('error',Messages("connection.failed"));
        }
    });
}

function sendGetByToken() {
    var body = new FormData;
    body.url = $("#url").val();
    body.token = $("#data").val();

    var r = jsRoutes.controllers.HomeController.testGetByToken();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            $("#resultData").text(data.body);
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('error',Messages("connection.failed"));
        }
    });
}