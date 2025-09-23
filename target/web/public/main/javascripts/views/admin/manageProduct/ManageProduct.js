/**
 * Created by vtk-anhlt166 on 8/5/22.
 */
var hostname;
$(document).ready(function () {
    hostname = location.protocol + '//' + location.host;
    console.log(hostname);
});
function showDetailProduct(id) {
    var body = {
        "id": id
    };
    StartProcess();
    var r = jsRoutes.controllers.ProductListController.getProductById();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#statusApproveDetail").val(data.content.statusApprove);
                $("#contentApproveDetail").val(data.content.contentApprove);
                $("#logDate").html(moment.unix(data.content.createDate/1000).format("HH:mm DD/MM/YYYY"));
                $("#updateDate").html(moment.unix(data.content.updateDate/1000).format("HH:mm DD/MM/YYYY"));

                $('#idProduct').val(data.content.id);
                $('#codeProduct').html(data.content.code);
                $('#nameProduct').html(data.content.name);
                $('#priceProduct').html((new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data.content.price)));
                $('#groupProduct').html(data.content.groupName);
                $('#showProduct').html((data.content.statusShow ? Messages("Hiện") : Messages("Ẩn")));
                $('#infoProduct').html(data.content.info);
                $('#contentProduct').html(data.content.content);
                $('#supportPersionProduct').html(data.content.supportPersion);
                $('#solutionProduct').html(data.content.solution);

                var img = hostname + "/getImg/" + data.content.imgName;
                $('#wizardPicturePreview').attr('src', img);

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

function processChangeStatusProduct() {
    var body = {
        "id": $("#idProduct").val(),
        "contentApprove": $("#contentApproveDetail").val(),
        "statusApprove": $("#statusApproveDetail").val()
    };
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.ProductListController.changeStatusProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1500);
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