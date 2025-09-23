/**
 * Created by vtk-anhlt166 on 3/3/22.
 */
function paymentBill(id) {
    console.log(id);
    var formData = new FormData;
    formData.id = id;
    StartProcess();
    var route = jsRoutes.controllers.PayBillController.getLinkPayment();
    $.ajax({
        type: route.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                $("#tdIdBill").html(id);
                $("#tdLinkPayBill").html(datas.content.data);
                document.getElementById("tdLinkPayBill").setAttribute("href", datas.content.data);
                document.getElementById("tdLinkPayBill").setAttribute("target", "_blank");
            } else {
                $("#tdIdBill").html("");
                $("#tdLinkPayBill").html("");
                document.getElementById("tdLinkPayBill").removeAttribute("href");
                document.getElementById("tdLinkPayBill").removeAttribute("target");
                showNotification('danger', Messages("noti.Getfalse"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function checkStatusBill() {
    var formData = new FormData;
    formData.id = $("#tdIdBill").text();
    console.log(formData);

    StartProcess();
    var route = jsRoutes.controllers.PayBillController.getInfoBill();
    $.ajax({
        type: route.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                var color = "#333333";
                var status = "Khởi tạo";
                if(datas.content.data.status == "Pending"){
                    color = "#ff6e07";
                    status = "Chờ thanh toán";
                    showNotification('danger', Messages("Hóa đơn đang chờ thanh toán"));
                } else if(datas.content.data.status == "Paid"){
                    color = "#17a00e";
                    status = "Đã thanh toán";
                    showNotification('success', Messages("Hóa đơn đã được thanh toán"));
                } else if(datas.content.data.status == "Expired"){
                    color = "#ff0019";
                    status = "Quá hạn";
                    showNotification('danger', Messages("Hóa đơn đã quá hạn"));
                } else {
                    showNotification('danger', Messages("Hóa đơn đang khởi tạo"));
                }
                document.getElementById("status-"+datas.content.data.id).style.color = color;
                $("#status-"+datas.content.data.id).html(status);

                if(datas.content.data.status == "Pending" || datas.content.data.status == "Expired"){
                    var button = '<button class="btn btn-info" onclick="paymentBill(\''+data[i].id+'\')" data-bs-toggle="modal" data-bs-target="#paymentBillConfirm" type="button" style="cursor: pointer" title="'+Messages("Thanh toán")+'"><i class="bx bx-credit-card"></i></button>';
                    $("#action-"+datas.content.data.id).html(button);
                } else {
                    var button = '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-credit-card"></i></button>';
                    $("#action-"+datas.content.data.id).html(button);
                }

            } else {
                showNotification('danger', Messages("Hóa đơn chưa được thanh toán"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}