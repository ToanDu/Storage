$(document).ready(function () {
    getListHistoryDepositAction();
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY',
        time: false
    });
});

function getListHistoryDepositAction() {
    let body = {
        action: "10",
        orderId: $('#orderId').val().trim(),
        isdn: $('#isdn').val(),
        from: $('#from').val(),
        to: $('#to').val(),
        page: $("#page").val(),
        pageSize: $("#pageSize").val(),
        userId: userId
    };

    let r = jsRoutes.controllers.TelcoUtilitiesController.getListOrderIdByAction();
    StartProcess();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (datas) {
            if (datas?.success) {
                viewHistoryDepositTable(datas?.content, body.page, body.pageSize);
            }
        },
        complete: function () {
            FinishProcess();
        }
    });
}

// render lịch sử nạp tiền
function viewHistoryDepositTable(datas, page, pageSize) {
    let startAt = (page - 1) * pageSize;
    let data = datas?.data;
    let body = "";

    if (data && data.length > 0) {
        $("#notiNotDataHistory").html("");
        data.forEach((item, i) => {
            body += `
                        <tr>
                            <th>${startAt + i + 1}</th>
                            <td class='wrap-text'>${item.order_id}</td>
                            <td class='wrap-text'>${item.isdn_number}</td>
                            <td class='wrap-text'>${Messages("history.deposit.js.action.recharge")}</td>
                            <td class='wrap-text'>${item.units_amount}</td>
                            <td class='wrap-text'>${item.trans_amount}</td>
                            <td class='wrap-text'>${item.state == "done:00" ? Messages("success") : Messages("history.deposit.js.status.failed")}</td>
                            <td class='wrap-text'>${item.message}</td>
                            <td class='wrap-text'>${moment.unix(item.created_time).format("DD/MM/YYYY HH:mm")}</td>
                        </tr>`;
        });
    } else {
        $("#notiNotDataHistory").html(Messages("history.deposit.js.no.data.display"));
    }

    $("#listHistoryDepositTable tbody").html(body);
    pagingTableHistoryRecharge(datas?.total, page, pageSize);
}

function pagingTableHistoryRecharge(total, page, pageSize) {
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

function ApplyFilter(page, pageSize, isResetPage = false) {
    $("#countPageSize").html(pageSize);
    $("#page").val(page);
    $("#pageSize").val(pageSize);
    $("#isResetPage").val(isResetPage);
    getListHistoryDepositAction();
}

function resetFormSearch() {
    $('#orderId').val('');
    $('#isdn').val('');
    $('#from').val('');
    $('#to').val('');
    getListHistoryDepositAction();
}
