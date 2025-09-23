/**
 * Created by vtk-anhlt166 on 8/12/22.
 */
function processSendContactMarket(){
    var body = {
        "productId": productId,
        "name" : $("#nameContact").val(),
        "phone" : $("#phoneContact").val(),
        "email" : $("#emailContact").val(),
        "company" : $("#companyContact").val(),
        "content" : $("#contentContact").val()
    };
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceContactController.sendContactMarket();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success', data.resultString);
                $("#contactFormModal").modal('hide');
            } else {
                showNotification('danger', data.errorString);
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
}

function resetFormContact() {
    $("#contentContact").val("");
}