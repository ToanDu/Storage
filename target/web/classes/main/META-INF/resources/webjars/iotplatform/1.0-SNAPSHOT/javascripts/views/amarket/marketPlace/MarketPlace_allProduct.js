/**
 * Created by vtk-anhlt166 on 8/10/22.
 */
function getAllProduct(){
    var attrGroupAll = [];
    $('#listGroupAllDevice').children().each(function () {
        var checkbox = $(this).find('.groupAllProduct-check')[0];
        if($(checkbox).is(':checked')){
            attrGroupAll.push([$(checkbox).val()][0]);
        }
    });
    $('#listGroupAllSolution').children().each(function () {
        var checkbox = $(this).find('.groupAllSolution-check')[0];
        if($(checkbox).is(':checked')){
            attrGroupAll.push([$(checkbox).val()][0]);
        }
    });

    var body = {
        "filterKey": $("#priceSortAllProduct").val(),
        "sortKey": "price",
        "groupProduct": (attrGroupAll.length > 0) ? attrGroupAll.toString() : "",
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getAllProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            var listProduct = "";
            if(data.success){
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        var img = hostname + "/getImg/" + data.content[i].imgName;
                        var price = (data.content[i].price > 0) ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content[i].price)) : "Thoả thuận";
                        listProduct +=
                            '<div class="col-md-3 product-grid cursor-pointer">'+
                            '<div class="card">'+
                            '<div>'+
                            '<img src="'+img+'" class="card-img-top" alt="..." height="250px">'+
                            '</div>'+
                            '<div class="">'+
                            '<div class="position-absolute top-0 end-0 m-3 product-discount"><i class="bx bx-heart" style="font-size: 24px;"></i></div>'+
                            '</div>'+
                            '<div class="card-body" style="padding: 1rem;">'+
                            '<h6 class="group-product flex-height-group" style="letter-spacing: 0.5px; color: #6B7177;">'+data.content[i].groupName+'</h6>'+
                            '<div class="clearfix flex-height">' +
                            '<h6 class="card-title name-product">'+data.content[i].name+'</h6>'+
                            '</div>' +
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start price-product"><span>'+Messages("Giá: ")+'</span><span class="text-danger fw-bold">'+price+'</span></p>'+
                            '</div>'+
                            '<div class="d-flex align-items-center mt-2 fs-6">'+
                            '<div class="cursor-pointer">'+
                            '<i class="fa fa-star text-warning"> 5.0</i>'+
                            '</div>'+
                            // '<span class="ms-auto text-star" style="margin-top: 2px;">'+Messages("0 đánh giá")+'</span>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                    }
                }
            }

            $("#girdAllList").html(listProduct);
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