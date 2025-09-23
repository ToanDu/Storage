$(document).ready( function () {
    getInfoCompany();
    getInfoCompanyEnterpriseLv2();
})
function getInfoCompany() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas, "getInfoCompany");
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var option = "<option value=''>"+Messages("-- Chọn số GPKD --")+"</option>";
                    for(var i=0; i<datas.content.data.length; i++){
                        var databody = datas.content.data[i];
                        console.log(databody);
                        if(databody.business_license != null  && databody.business_license != ""){
                            option += "<option value='"+databody.business_license+"'>"+databody.business_license+"</option>";
                        }
                    }
                    $("#idNo").html(option);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function getInfoCompanyEnterpriseLv2() {
    var body = new FormData;
    body.userId = userId;
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getInfoCompanyEnterpriseLv2();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas, "getInfoCompanyEnterpriseLv2");
            if(datas.content != null){
                if(datas.content.length > 0){
                    var option = "<option value=''>"+Messages("-- Chọn số GPKD --")+"</option>";
                    for(var i=0; i<datas.content.length; i++){
                        var databody = datas.content[i];
                        console.log(databody);
                            option += "<option value='"+databody.id_no+"'>"+databody.id_no+"</option>";
                    }
                    $("#idNo").html(option);
                }
            }

        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
        }
    })
}