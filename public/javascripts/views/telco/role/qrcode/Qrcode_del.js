function setDelQrcode(id) {
    $("#idQrcodeDel").val(id);
    $("#deleteQrcodeModal").modal('show');
}
function delQrcode() {
    var body = new FormData();
    body.id = $("#idQrcodeDel").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoQrcodeController.delQrcodeById();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success && datas.content != null){
                if(datas.content.code == 0){
                    showNotification('success', 'Xóa thành công');
                    getListQrcode();
                } else {
                    showNotification('danger', 'Xóa không thành công');
                }
            } else{
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