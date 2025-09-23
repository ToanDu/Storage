/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
var STATUS_PRODUCT = {
    NEW: {value: 0, name: "Mới khởi tạo"},
    APPROVED: {value: 1, name: "Đã duyệt"},
    REFUSE: {value: 2, name: "Từ chối"},
    WAIT: {value: 2, name: "Chờ duyệt"}
};
var hostname;
$(document).ready(function () {
    getListProduct();
    getGroupDevice();

    hostname = location.protocol + '//' + location.host;
    console.log(hostname);
});

$('#searchProduct').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchProduct').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_product').each(function() {
        var isMatch = $(this).find('h6').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

function getListProduct(){
    var body = {
        "id": userId,
        "filterKey": "DESC",
        "sortKey": "createDate"
    };
    StartProcess();
    var r = jsRoutes.controllers.ProductListController.getProductByUser(userId);
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
                        var status = STATUS_PRODUCT.NEW.name;
                        if(data.content[i].statusApprove == 1){
                            status = STATUS_PRODUCT.APPROVED.name;
                        } else if(data.content[i].statusApprove == 2){
                            status = STATUS_PRODUCT.REFUSE.name;
                        } else if(data.content[i].statusApprove == 3){
                            status = STATUS_PRODUCT.WAIT.name;
                        }
                        listProduct +=
                            '<div class="col list_product">'+
                            '<div class="card">'+
                            '<img src="'+img+'" class="card-img-top" alt="..." height="250px">'+
                            '<div class="card-body">'+
                            '<div class="clearfix flex-height">' +
                            '<h6 class="card-title cursor-pointer name-product">'+data.content[i].name+'</h6>'+
                            '</div>' +
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start">'+Messages("Mã SP: ")+'</p>'+
                            '<p class="mb-0 float-end fw-bold"><span class="text-blue">'+data.content[i].code+'</span></p>'+
                            '</div>'+
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start">'+Messages("Trạng thái: ")+'</p>'+
                            '<p class="mb-0 float-end fw-bold"><span class="text-blue">'+status+'</span></p>'+
                            '</div>'+
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start">'+Messages("Đơn giá: ")+'</p>'+
                            '<p class="mb-0 float-end fw-bold"><span class="text-blue">'+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content[i].price))+'</span></p>'+
                            '</div>'+
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start">'+Messages("Hiển thị: ")+'</p>'+
                            '<p class="mb-0 float-end fw-bold"><span class="text-blue">'+(data.content[i].statusShow ? Messages("Hiện") : Messages("Ẩn"))+'</span></p>'+
                            '</div>'+
                            '<div class="clearfix">'+
                            '<p class="mb-0 float-start">'+Messages("Ngày tạo: ")+'</p>'+
                            '<p class="mb-0 float-end fw-bold"><span class="text-blue">'+moment.unix(data.content[i].createDate/1000).format("DD/MM/YYYY")+'</span></p>'+
                            '</div>'+
                            '<div class="clearfix mt-3">'+
                            '<div class="btn-group" role="group">' +
                            '<button class="btn btn-light float-start" onclick="getInfoProduct(\''+data.content[i].id+'\')" data-bs-toggle="modal" data-bs-target="#editConfirmModal">'+Messages("Chi tiết")+'</button>'+
                            '<button class="btn btn-light float-start" onclick="sendRequestApproveProduct(\''+data.content[i].id+'\')">'+Messages("Gửi duyệt")+'</button>'+
                            '<button class="btn btn-light float-end" onclick="setDelIdProduct(\''+data.content[i].id+'\')" data-bs-toggle="modal" data-bs-target="#delConfirmModal">'+Messages("Xoá")+'</button>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                    }
                }
            }

            $("#girdProductList").html(listProduct);
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

function selectGroupProductAdd() {
    if($("#typeGroupProductAdd").val() == 0){//device
        getGroupDevice();
    } if($("#typeGroupProductAdd").val() == 1) {//solution
        getGroupSolution();
    }
}
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
                var option = '<option value="">'+Messages("Chọn nhóm sản phẩm")+'</option>';
                console.log(data.content.length);
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        option += '<option value="'+data.content[i].id+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#groupProductAdd").html(option);
                // $("#groupProductEdit").html(option);
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
                var option = '<option value="">'+Messages("Chọn nhóm sản phẩm")+'</option>';
                console.log(data.content.length);
                if(data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        option += '<option value="'+data.content[i].id+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#groupProductAdd").html(option);
                // $("#groupProductEdit").html(option);
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


//delete
function setDelIdProduct(id) {
    $("#idDelete").val(id);
}
function postDeleteProduct() {
    var body = {
        "id": $("#idDelete").val()
    };
    StartProcess();
    var r = jsRoutes.controllers.ProductListController.deleteProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getListProduct();
                showNotification('success',data.resultString);
            } else{
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

