/**
 * Created by vtk-anhlt166 on 8/25/22.
 */
function setEditContact(id, status) {
    $("#idContactEdit").val(id);
    $("#statusContactEdit").val(status);
}
function processEditContact() {
    var body = {
        "id": $("#idContactEdit").val(),
        "status": $("#statusContactEdit").val()
    };
    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceContactController.editContactMarket();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);

                if(data.content){
                    $("#td-status-"+body.id).html(Messages("Đã xử lý"));
                    document.getElementById("td-status-"+body.id).style.color = 'green';
                } else {
                    $("#td-status-"+body.id).html(Messages("Chưa xử lý"));
                    document.getElementById("td-status-"+body.id).style.color = 'black';
                }

            } else{
                showNotification('danger',data.errorString);
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