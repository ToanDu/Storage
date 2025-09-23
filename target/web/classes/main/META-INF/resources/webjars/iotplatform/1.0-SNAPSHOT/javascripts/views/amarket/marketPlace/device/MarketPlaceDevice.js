var hostname;
$(document).ready(function () {
    hostname = location.protocol + '//' + location.host;
    console.log(hostname);

    getGroupDevice();
    getListDevice();

    var input = document.getElementById("searchProduct");
    input.addEventListener("keypress", function(event) {
        // If the user presses the "Enter" key on the keyboard
        if (event.key === "Enter") {
            // Cancel the default action, if needed
            event.preventDefault();
            // Trigger the button element with a click
            getListDevice();
        }
    });
});

var TYPE_PRODUCT = {
    DEVICE: {value: 0, name: "Thiết bị"},
    SOLUTION: {value: 1, name: "Giải pháp"}
};

function getGroupDevice(){
    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getAllGroupDevice();
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
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        optionDevice += '<div class="form-check">'+
                            '<input class="form-check-input groupDevice-check" type="checkbox" value="'+data.content[i].id+'" id="groupDevice'+i+'" onchange="getListDevice()">'+
                            '<label class="form-check-label" for="groupDevice'+i+'">'+data.content[i].name+'</label>'+
                            '<label class="form-check-label" style="float: right;">'+Messages("(")+data.content[i].countProduct+Messages(")")+'</label>'+
                            '</div>';
                    }
                }
                optionDevice += '<hr style="border: 0.75px solid #E9E9E9">';
                $("#listGroupDevice").html(optionDevice);
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

function getListDevice(){
    var attrGroupDevice = [];
    $('#listGroupDevice').children().each(function () {
        var checkbox = $(this).find('.groupDevice-check')[0];
        if($(checkbox).is(':checked')){
            attrGroupDevice.push([$(checkbox).val()][0]);
        }
    });

    var body = {
        "filterKey": $("#priceSortDevice").val(),
        "sortKey": "price",
        "groupProduct": (attrGroupDevice.length > 0) ? attrGroupDevice.toString() : "",
        "groupType": TYPE_PRODUCT.DEVICE.value,
        "name": $("#searchProduct").val()
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getProductMarket();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            var listDevice = "";
            if(data.success){
                $("#totalProduct").html(data.content.length + Messages(" kết quả"));
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        var img = hostname + "/getImg/" + data.content[i].imgName;
                        var price = (data.content[i].price > 0) ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content[i].price)) : "Thoả thuận";
                        listDevice +=
                            '<div class="col-md-4 product-grid cursor-pointer" onclick="remotePageDetailProduct(\''+data.content[i].id+'\')">'+
                            '<div class="card product-card">'+
                            '<div>'+
                            '<img src="'+img+'" class="card-img-top product-img" alt="..." height="250px">'+
                            '</div>'+
                            // '<div class="">'+
                            // '<div class="position-absolute top-0 end-0 m-3 product-discount"><i class="bx bx-heart" style="font-size: 18px;"></i></div>'+
                            // '</div>'+
                            '<div class="card-body product-body" style="padding: 1rem;">'+
                            '<h6 class="group-product flex-height-group" style="letter-spacing: 0.5px; color: #6B7177;">'+data.content[i].groupName+'</h6>'+
                            '<div class="clearfix flex-height">' +
                            '<h6 class="card-title name-product">'+data.content[i].name+'</h6>'+
                            '</div>' +
                            '<div class="d-flex align-items-center mt-2 fs-6">'+
                            '<div class="cursor-pointer">'+
                            '<i class="fa fa-star star-icon"></i> <span class="text-star">5.0</span>'+
                            '</div>'+
                            '</div>'+
                            '<hr style="border-bottom: 1px solid #E9E9E9; margin-top: 1rem; margin-bottom: 1rem;">' +
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start price-product"><span>'+Messages("Giá: ")+'</span><span class="text-danger fw-bold">'+price+'</span></p>'+
                            '<p class="mb-0 float-end text-countView"><span>'+Messages("Đã xem: ")+ (data.content[i].countView + 500)+'</span></p>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                    }
                }
            }

            $("#girdDeviceList").html(listDevice);
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

function remotePageDetailProduct(id) {
    window.location.href = jsRoutes.controllers.MarketPlaceController.detailProduct(id).url;
}