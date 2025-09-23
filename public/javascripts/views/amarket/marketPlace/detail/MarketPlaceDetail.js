var hostname;
$(document).ready(function () {
    hostname = location.protocol + '//' + location.host;
    console.log(hostname);

    console.log(productId);
    getDetailProduct();

    getListCommentProduct();

    getSameProduct();

    // $("textarea").each(function () {
    //     this.setAttribute("style", "height:" + (this.scrollHeight) + "px;overflow-y:hidden;");
    // }).on("input", function () {
    //     this.style.height = "auto";
    //     this.style.height = (this.scrollHeight) + "px";
    // });
});

function getDetailProduct(){
    var body = {
        "id" : productId
    };
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.MarketPlaceController.getDetailProductWithId();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                var img = hostname + "/getImg/" + data.content.imgName;
                $("#avatarProduct").attr('src', img);
                var imgAvt = '<img src="'+img+'" width="70" class="border rounded cursor-pointer" alt="" width="100%" onclick="changeImgAvt(\''+data.content.imgName+'\')">';
                $("#imgAvatar").html(imgAvt);

                for(var i=1; i<=5; i++){
                    var imgKey = "image_"+i;
                    if(data.content[imgKey] != null && data.content[imgKey].length > 0){
                        var urlImg = hostname + "/getImg/" + data.content[imgKey];
                        $("#img"+i).html('<img src="'+urlImg+'" width="70" class="border rounded cursor-pointer" alt="" width="100%" onclick="changeImgAvt(\''+data.content[imgKey]+'\')">');
                        document.getElementById("img"+i).style.display = "block";
                    } 
                    else {
                        document.getElementById("img"+i).style.display = "none";
                    }
                }

                $("#nameProduct").html(data.content.name);
                $("#infoProduct").html(data.content.info);
                var price = (data.content.price > 0) ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content.price)) : "Thoả thuận";
                $("#priceProduct").html(price);

                $("#contentProduct").html(data.content.content.replaceAll("\r\n","<br>"));
                $("#featureProduct").html((data.content.feature != null) ? data.content.feature.replaceAll("\r\n","<br>") : "");
                $("#linkDocsProduct").html((data.content.linkDocs != null) ? data.content.linkDocs.replaceAll("\r\n","<br>") : "");

                if(data.content.groupType == 1){
                    $("#titleContentProduct").html(Messages("Tính năng nổi bật"));
                    $("#productSame").html(Messages("Giải pháp tương tự"));
                } else {
                    $("#titleContentProduct").html(Messages("Thông số kỹ thuật"));
                    $("#productSame").html(Messages("Thiết bị tương tự"));
                }
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

function changeImgAvt(nameImg) {
    var img = hostname + "/getImg/" + nameImg;
    $("#avatarProduct").attr('src', img);
}

function getSameProduct(){
    var body = {
        "id" : productId
    };
    console.log(body);
    var r = jsRoutes.controllers.MarketPlaceController.getSameProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            var listProduct = "";
            if(data.success){
                if(data.content.length > 0){
                    var stt = 0;
                    for(var i=0; i<data.content.length; i++){
                        if(stt >= 4){
                            break;
                        } else {
                            if(data.content[i].id != productId){
                                var img = hostname + "/getImg/" + data.content[i].imgName;
                                var price = (data.content[i].price > 0) ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content[i].price)) : "Thoả thuận";
                                listProduct +=
                                    '<div class="col-md-3 product-grid cursor-pointer" onclick="remotePageDetailProduct(\''+data.content[i].id+'\')">'+
                                    '<div class="card product-card">'+
                                    '<div>'+
                                    '<img src="'+img+'" class="card-img-top product-img" alt="..." height="250px">'+
                                    '</div>'+
                                    '<div class="">'+
                                    '<div class="position-absolute top-0 end-0 m-3 product-discount"><i class="bx bx-heart" style="font-size: 18px;"></i></div>'+
                                    '</div>'+
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
                                stt++;
                            }
                        }
                    }
                }
            }
            $("#listProductSame").html(listProduct);
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function remotePageDetailProduct(id) {
    window.location.href = jsRoutes.controllers.MarketPlaceController.detailProduct(id).url;
}