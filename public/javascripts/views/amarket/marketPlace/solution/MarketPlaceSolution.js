var hostname;
$(document).ready(function () {
    hostname = location.protocol + '//' + location.host;
    console.log(hostname);

    getGroupSolution();
    getListSolution();

    var input = document.getElementById("searchProduct");
    input.addEventListener("keypress", function(event) {
        // If the user presses the "Enter" key on the keyboard
        if (event.key === "Enter") {
            // Cancel the default action, if needed
            event.preventDefault();
            // Trigger the button element with a click
            getListSolution();
        }
    });
});

var TYPE_PRODUCT = {
    DEVICE: {value: 0, name: "Thiết bị"},
    SOLUTION: {value: 1, name: "Giải pháp"}
};

function getGroupSolution(){
    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getAllGroupSolution();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                var optionSolution = "";
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        optionSolution += '<div class="form-check">'+
                            '<input class="form-check-input groupSolution-check" type="checkbox" value="'+data.content[i].id+'" id="groupSolution'+i+'" onchange="getListSolution()">'+
                            '<label class="form-check-label" for="groupSolution'+i+'">'+data.content[i].name+'</label>'+
                            '<label class="form-check-label" style="float: right;">'+Messages("(")+data.content[i].countProduct+Messages(")")+'</label>'+
                            '</div>';
                    }
                }
                optionSolution += '<hr style="border: 0.75px solid #E9E9E9">';
                $("#listGroupSolution").html(optionSolution);
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

function getListSolution(){
    var attrGroupSolution = [];
    $('#listGroupSolution').children().each(function () {
        var checkbox = $(this).find('.groupSolution-check')[0];
        if($(checkbox).is(':checked')){
            attrGroupSolution.push([$(checkbox).val()][0]);
        }
    });

    var body = {
        "filterKey": $("#priceSortSolution").val(),
        "sortKey": "price",
        "groupProduct": (attrGroupSolution.length > 0) ? attrGroupSolution.toString() : "",
        "groupType": TYPE_PRODUCT.SOLUTION.value,
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
            var listSolution = "";
            if(data.success){
                $("#totalProduct").html(data.content.length + Messages(" kết quả"));
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        var img = hostname + "/getImg/" + data.content[i].imgName;
                        var price = (data.content[i].price > 0) ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content[i].price)) : "Thoả thuận";
                        listSolution +=
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

            $("#girdSolutionList").html(listSolution);
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