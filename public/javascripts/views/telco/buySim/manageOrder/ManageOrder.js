$(document).ready(function () {
    getListOrder();
});

$(document).keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        onlickButtonSearch();
    }
});
var totalOrders = 0;
var listOrder = new Array;

function onlickButtonSearch() {
    $("#page").val(1);
    getListOrder();
}
function getUnixTimestamp(dateString, isEndOfDay = false) {
    if (!dateString) return null;
    const [day, month, year] = dateString.split("/").map(Number);
    if (isEndOfDay) {
        // 23:59:59
        return Math.floor(new Date(year, month - 1, day, 23, 59, 59).getTime() / 1000);
    } else {
        // 00:00:00
        return Math.floor(new Date(year, month - 1, day, 0, 0, 0).getTime() / 1000);
    }
}

function getLabelOrderType(orderType) {
    if (orderType === "order") {
        return Messages("history.js.order.type.order");
    } else if (orderType === "change") {
        return Messages("history.js.order.type.change");
    } else {
        return Messages("history.js.order.type.unknown");
    }
}
function getListOrder() {
    let fromDate = $("#fromDate").val().trim();
    let toDate = $("#toDate").val().trim();
    if (fromDate && toDate) {
        const fromTimestamp = getUnixTimestamp(fromDate, false);
        const toTimestamp = getUnixTimestamp(toDate, true);
        if (fromTimestamp > toTimestamp) {
            showNotification('danger', Messages("history.js.date.validation.error"));
            return;
        }
    }
    var body = new FormData();
    body.orderId = $('#orderId').val().trim();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    body.userId = userId;
    body.orderType = $("#orderType").val();
    body.status = $("#status").val();
    body.from =  getUnixTimestamp(fromDate, false);
    body.to = getUnixTimestamp(toDate, true);
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.getListOrderBuySim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            if (datas.content.data.total == 0) {
              $('#btn_export_data').hide();
            }
            else{
                $('#btn_export_data').show();
                totalOrders = datas.content.data.total;
            }
            if(datas.content != null && datas.content.data != null){
                var startAt = (body.page - 1)*body.pageSize;
                viewContractToTable(datas.content.data, startAt, body.page, body.pageSize);
            }else{
                $("#listOrderTable").find('tbody').html("");
                $("#notiNotData").html(Messages("history.js.no.data.display"));
                showNotification('danger', Messages("history.js.no.data.found"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listOrderTable").find('tbody').html("");
            $("#notiNotData").html(Messages("history.js.no.data.display"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewContractToTable(data, startAt, page, pageSize) {
    var body = "";
    var lOrder = data.orders;
    if (lOrder != null && lOrder.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < lOrder.length; i++) {
            body += "<tr>";
            body += "<td>" +(startAt+i+1)+ "</td>";
            body += "<td>" + lOrder[i].id + "</td>";
            body += "<td>" + getLabelOrderType(lOrder[i].type) + "</td>";
            body += "<td>" + lOrder[i].bussinessName + "</td>";
            body += "<td>" + lOrder[i].recipientName + "</td>";
            body += "<td>" + lOrder[i].recipientPhone + "</td>";
            body += "<td> " + Messages("history.js.status.success") + "</td>";
            body += "<td>" + moment.unix(lOrder[i].createdTime).format("HH:mm DD/MM/YYYY") + "</td>";
            body += "<td><button class='btn-tb cursor-pointer' onclick='getDetailOrder(\"" + lOrder[i].id + "\")'>" + Messages("history.js.button.detail") + "</button></td>";
            body += "</tr>";

            listOrder[lOrder[i].createdTime.toString()] = lOrder[i];
        }
    } else {
        $("#notiNotData").html(Messages("history.js.no.data.display"));
    }
    $("#listOrderTable").find('tbody').html(body);

    pagingTable(data.total, page, pageSize);
}

function getDetailOrder(orderId) {
    const r = jsRoutes.controllers.TelcoOrderController.getListOrderBuySim();
    StartProcess();
    $("#orderDetailModal #total_record").text(0);
    $("#orderDetailModal #pagingTable").empty();
    const _pageSize = $('#orderDetailModal [name=pageSize]').val() ||10
    $.ajax({
        type: r.type,
        data: JSON.stringify({ orderId: orderId ,userId:userId}),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (response) {
            let order = response.content.data.orders[0];
            orderType = order.type;
            // Đổ dữ liệu vào input
            $("#orderCodeReadonly").val(order.id);
            $("#orderTypeReadonly").val(getLabelOrderType(orderType)); 
            $("#orderStatusReadonly").val(Messages("history.js.status.success"));
            $("#orderTimeReadonly").val(moment.unix(order.createdTime).format("DD/MM/YYYY HH:mm"));
            $("#orderMethodReadonly").val(order.transactionPlace === "HOME" ? Messages("history.js.receive.at.address") : Messages("history.js.receive.at.store"));
            $("#bussinessNameReadonly").val(order.bussinessName);
            $("#recipientNameReadonly").val(order.recipientName);
            $("#recipientPhoneReadonly").val(order.recipientPhone);
            $("#recipientAddressReadonly").val(order.address);

            // Hiển thị dữ liệu sim
            ordersTemp = orderType == "order" ? order.data?.orderSim : order.data?.changeSim;
            renderDetailDataTable(ordersTemp, orderType, 1, _pageSize);
            $("#orderDetailModal #total_record").text(ordersTemp.length || 0);
            const pagingHTML = paging2HTML(ordersTemp.length, 1, _pageSize, applySearchModalDetail);
            $("#orderDetailModal #pagingTable").html(pagingHTML);
            $("#orderDetailModal").modal("show");
        },
        error: function () {
            alert(Messages("history.js.error.get.order.detail"));
        },
        complete: function () {
            FinishProcess();
        }
    });
}

function renderDetailDataTable(data, orderType, page, itemsPerPage) {
    let start = (page - 1) * itemsPerPage;
    let end = start + itemsPerPage;
    let pageItems = data.slice(start, end);

    let html = '';

    if (orderType === 'order') {
        html = pageItems.length
            ? pageItems.map((item, index) => `
                <tr>
                    <td>${start + index + 1}</td>
                    <td>${item.productCode}</td>
                    <td>${item.numIsdn}</td>
                </tr>`).join("")
            : `<tr><td colspan="3">${Messages("history.js.no.products")}</td></tr>`;

        $("#orderProductTable thead").html(`
            <tr style="background-color: #FBCCD6;">
                <th>${Messages("history.js.table.no")}</th>
                <th>${Messages("history.js.table.package")}</th>
                <th>${Messages("history.js.table.sim.quantity")}</th>
            </tr>
        `);
    } else if (orderType === 'change') {
        html = pageItems.length
            ? pageItems.map((item, index) => `
                <tr>
                    <td>${start + index + 1}</td>
                    <td>${item}</td>
                </tr>`).join("")
            : `<tr><td colspan="2">${Messages("history.js.no.phone.numbers")}</td></tr>`;

        $("#orderProductTable thead").html(`
            <tr style="background-color: #FBCCD6;">
                <th>${Messages("history.js.table.no")}</th>
                <th>${Messages("history.js.table.phone.number")}</th>
            </tr>
        `);
    }

    $("#orderProductTable tbody").html(html);
}

function paging2HTML(total, page, pageSize, handleSearch = () => {}) {
  let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
  let currentPage = parseInt(page);
  let totalPage = Math.ceil(total / pageSize);

  if (currentPage > 1) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage - 1
    }, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
                </li>`;
  }

  if (currentPage - 1 > 0) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage - 1
    }, ${pageSize})">${currentPage - 1}</a>
                </li>`;
  }

  paging += `
            <li class="paginate_button page-item active">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${currentPage}, ${pageSize})">${currentPage}</a>
            </li>`;

  if (currentPage + 1 <= totalPage) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage + 1
    }, ${pageSize})">${currentPage + 1}</a>
                </li>`;
  }

  if (currentPage < totalPage) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage + 1
    }, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
                </li>`;
  }

  paging += "</ul>";
  return paging;
}


//paging
function pagingTable(total, page, pageSize) {
     $("#total_record").text(total);
    let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
    let currentPage = parseInt(page);
    let totalPage = Math.ceil(total / pageSize);

    if (currentPage > 1) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(${currentPage - 1}, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
                </li>`;
    }

    if (currentPage - 1 > 0) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(${currentPage - 1}, ${pageSize})">${currentPage - 1}</a>
                </li>`;
    }

    paging += `
            <li class="paginate_button page-item active">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(${currentPage}, ${pageSize})">${currentPage}</a>
            </li>`;

    if (currentPage + 1 <= totalPage) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(${currentPage + 1}, ${pageSize})">${currentPage + 1}</a>
                </li>`;
    }

    if (currentPage < totalPage) {
        paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(${currentPage + 1}, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="ApplyFilter(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
                </li>`;
    }

    paging += '</ul>';
    $("#pagingTable").html(paging);
}

function applySearchModalDetail(page, pageSize) {
    $('#orderDetailModal [name=page]').val(page);
    $('#orderDetailModal [name=pageSize]').val(pageSize);
    renderDetailDataTable(ordersTemp, orderType, page, pageSize);
    const _pagingHTML = paging2HTML(ordersTemp.length, page, pageSize, applySearchModalDetail);
    $('#orderDetailModal #pagingTable').html(_pagingHTML);
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListOrder();
}


function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListOrder();
}

function resetFormSearch() {
    console.log("resetFormSearch");
    $("#page").val('1');
    $("#pageSize").val('10');
    $("#countPageSize").html('10');
    $("#orderId").val('');
    $("#orderType").val('');
    $("#fromDate").val('');
    $("#toDate").val('');
    $("#status").val('');
    getListOrder();
}

