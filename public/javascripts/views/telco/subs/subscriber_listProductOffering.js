/**
 * Created by vtk-anhlt166 on 11/15/22.
 */
$(document).ready(function () {
    getListProductOffering();
});
function getListProductOffering() {
    console.log("getListProductOffering");
    var r = jsRoutes.controllers.TelcoSubscriberController.getListProductOffering();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            var ProductOffering = '<option value="" selected>'+Messages("-- Chọn --")+'</option>';
            if(datas.success){
                if(datas.content.length > 0){
                    var array = datas.content.sort((a, b) => a.name.localeCompare(b.name));

                    array.forEach(function (item) {
                        ProductOffering += '<option value="'+item.code+'">'+item.name+'</option>';
                    });
                }
            }
            $("#productCode").html(ProductOffering);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}