function handleOrderSearch() {
    const orderSearchInput = document.querySelector('input[name="order-code"]');
    const orderSearchValue = orderSearchInput ? orderSearchInput.value : '';
    var body = new FormData();
    body.orderCode = orderSearchValue.trim();
    $(".error-text-result").addClass("d-none");
    StartProcess();
    var r = jsRoutes.controllers.OrderSearchController.getSearchOrder(orderSearchValue.trim());
    $.ajax({
        type: r.type,
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            $("#order-search-result").removeClass("d-none");
            if (datas.content != null && datas.content.data != null) {
                orderInfoToTable(datas.content.data);
            } else {
                $("#order-search-result").addClass("d-none");
                $(".error-text-result").removeClass("d-none");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            $("#order-search-result").addClass("d-none");
            $(".error-text-result").removeClass("d-none");
            //showNotification('danger', Messages("connection.failed"));
        },
        complete: function () {
            FinishProcess();
        }
    })
}
function getLabelOrderType(orderType) {
    if (orderType === "order") {
        return "Đặt hàng";
    } else if (orderType === "change") {
        return "Đổi sim";
    } else {
        return "Không xác định";
    }
}
function orderInfoToTable(data, startAt) {
    var body = "";
    if(!data) {
        $("#order-search-table").find('tbody').html("");
        $("#notiNotData").html("Không có thông tin để hiển thị");
        return;
    }
    //const { orderSim } = data?.data
    console.log(data);
    let orderSim = data.data.orderSim;
    let changeSim = data.data.changeSim;

    console.log(orderSim);
    if (orderSim !=null) {
        $("#notiNotData").html("");
        $("#listOrderTable").css('display', '');
        $("#listChangeSimTable").css('display', 'none');
        const leftFields = document.querySelector(".left-section");
        const leftValues = leftFields?.querySelectorAll('.field-value');

        if (leftValues?.length > 0) {
            leftValues.forEach((el, idx) => {
                switch (idx) {
                    case 0:
                        el.textContent = data.id || '';
                        break;
                    case 1:
                        el.textContent = getLabelOrderType(data.type) || '';
                        break;
                    case 2:
                        el.textContent = data.createdTime ? moment.unix(data.createdTime).format("DD/MM/YYYY"): '';
                        break;
                    default:
                        el.textContent = 'Thành công';
                }
            });
        }
        const rightFields = document.querySelector(".right-section");
        const rightValues = rightFields?.querySelectorAll('.field-value');
        if (rightValues?.length > 0) {
            rightValues.forEach((el, idx) => {
                switch (idx) {
                    case 0:
                        el.textContent = data.bussinessName || '';
                        break;
                    case 1:
                        el.textContent = data.recipientName || '';
                        break;
                    case 2:
                        el.textContent = data.recipientPhone || '';
                        break;
                    default:
                        el.textContent = data.address || '';
                }
            });
        }
        for (var i = 0; i < orderSim.length; i++) {
            body += "<tr>";
            body += "<td>" + (i + 1) + "</td>";
            body += "<td>" + orderSim[i].productCode + "</td>";
            body += "<td>" + orderSim[i].numIsdn + "</td>";
            body += "</tr>";
        }
        $("#order-search-table").find('tbody').html(body);
    } else if(changeSim!= null) {
        $("#notiNotData").html("");
        $("#listOrderTable").css('display', 'none');
        $("#listChangeSimTable").css('display', '');
        const leftFields = document.querySelector(".left-section");
        const leftValues = leftFields?.querySelectorAll('.field-value');

        if (leftValues?.length > 0) {
            leftValues.forEach((el, idx) => {
                switch (idx) {
                case 0:
                    el.textContent = data.id || '';
                    break;
                case 1:
                    el.textContent = "Đổi sim";
                    break;
                case 2:
                    el.textContent = data.createdTime ? moment.unix(data.createdTime ).format("DD/MM/YYYY"): '';
                    break;
                default:
                    el.textContent = 'Thành công';
                }
            });
        }
        const rightFields = document.querySelector(".right-section");
        const rightValues = rightFields?.querySelectorAll('.field-value');
        if (rightValues?.length > 0) {
            rightValues.forEach((el, idx) => {
                switch (idx) {
                case 0:
                    el.textContent = data.bussinessName || '';
                    break;
                case 1:
                    el.textContent = data.recipientName || '';
                    break;
                case 2:
                    el.textContent = data.recipientPhone || '';
                    break;
                default:
                    el.textContent = data.address || '';
                }
            });
        }
        for (var i = 0; i < changeSim.length; i++) {
            body += "<tr>";
            body += "<td>" + (i + 1) + "</td>";
            body += "<td>" + changeSim[i] + "</td>";
            body += "</tr>";
        }
        $("#order-search-table").find('tbody').html(body);
    }
    else{
        $("#notiNotData").html("Không có thông tin để hiển thị");
        $("#order-search-table").find('tbody').html("");
    }

}


