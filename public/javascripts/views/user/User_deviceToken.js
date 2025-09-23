/**
 * Created by vtk-anhlt166 on 6/15/21.
 */
function postDataCreateDeviceToken() {
    StartProcess();
    var r = jsRoutes.controllers.MessagesDeviceController.postCreateDeviceToken();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
            }else{  //tra ve cau hinh truoc do
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

function copyLinkTokenDevice() {
    if($('#deviceToken').val() == ""){
        showNotification('danger',Messages("Bạn chưa tạo device t"));
    } else {
        var copyText = document.getElementById("deviceToken");
        var length = String($('#deviceToken').val()).length;
        copyText.select();
        copyText.setSelectionRange(0, length);
        document.execCommand("copy");
        showNotification('success',"Copy device token thành công");
    }

}