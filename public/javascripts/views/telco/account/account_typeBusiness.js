var dsLinhVuc;
var dsDongThietBi;
function getCategoryBusinessAndDevice() {
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getCategoryBusinessAndDevice();
    $.ajax({
        type: r.type,
        // data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (datas) {
            console.log(datas, "getCategoryBusinessAndDevice");
            dsLinhVuc = '';
            dsDongThietBi = '';

            if (datas.content != null) {
                if(datas.content.business != null){
                    if(datas.content.business.data != null && datas.content.business.data.length > 0){
                        var business = datas.content.business.data;
                        for(var i=0; i<business.length; i++){
                            dsLinhVuc += '<option value="'+business[i].code+'">'+business[i].name+'</option>';
                        }
                    }
                }
                // console.log(dsLinhVuc);

                if(datas.content.device != null){
                    if(datas.content.device.data != null && datas.content.device.data.length > 0){
                        var device = datas.content.device.data;
                        for(var j=0; j<device.length; j++){
                            dsDongThietBi += '<option value="'+device[j].code+'">'+device[j].name+'</option>';
                        }
                    }
                }
                // console.log(dsDongThietBi);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    })
}