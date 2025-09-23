/**
 * Created by vtk-anhlt166 on 8/5/22.
 */
var hostname;
$(document).ready(function () {
    getGroupProduct();
    getAllProduct();

    hostname = location.protocol + '//' + location.host;
    console.log(hostname);
});

var TYPE_PRODUCT = {
    DEVICE: {value: 0, name: "Thiết bị"},
    SOLUTION: {value: 1, name: "Giải pháp"}
};

function getGroupProduct(){
    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getAllGroupProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                var optionDevice = "";
                var optionSolution = "";
                var optionAllDevice = "";
                var optionAllSolution = "";
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        if(data.content[i].type == 1){
                            optionSolution += '<div class="form-check">'+
                                '<input class="form-check-input groupSolution-check" type="checkbox" value="'+data.content[i].id+'" id="groupSolution'+i+'" onchange="getListSolution()">'+
                                '<label class="form-check-label" for="groupSolution'+i+'">'+data.content[i].name+'</label>'+
                                '</div>';
                            optionAllSolution += '<div class="form-check">'+
                                '<input class="form-check-input groupAllSolution-check" type="checkbox" value="'+data.content[i].id+'" id="groupAllSolution'+i+'" onchange="getAllProduct()">'+
                                '<label class="form-check-label" for="groupAllSolution'+i+'">'+data.content[i].name+'</label>'+
                                '</div>';
                        } else {
                            optionDevice += '<div class="form-check">'+
                                '<input class="form-check-input groupProduct-check" type="checkbox" value="'+data.content[i].id+'" id="groupProduct'+i+'" onchange="getListProduct()">'+
                                '<label class="form-check-label" for="groupProduct'+i+'">'+data.content[i].name+'</label>'+
                                '</div>';
                            optionAllDevice += '<div class="form-check">'+
                                '<input class="form-check-input groupAllProduct-check" type="checkbox" value="'+data.content[i].id+'" id="groupAllProduct'+i+'" onchange="getAllProduct()">'+
                                '<label class="form-check-label" for="groupAllProduct'+i+'">'+data.content[i].name+'</label>'+
                                '</div>';
                        }

                    }
                }
                $("#listGroupProduct").html(optionDevice);
                $("#listGroupSolution").html(optionSolution);
                $("#listGroupAllDevice").html(optionAllDevice);
                $("#listGroupAllSolution").html(optionAllSolution);
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



function notiMustLogin() {
    showNotification('danger', "Bạn hãy đăng nhập để sử dụng");
}