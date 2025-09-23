$(document).ready(function () {
    getListHistoryBlockUnblockAction();
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY',
        time: false
    });
});

function getListHistoryBlockUnblockAction() {
    let actionCode = $('#action').val();
    let body = {
        action: actionCode || "06,07,08,09",
        isdn: $('#isdn').val().trim(),
        from: $('#from').val(),
        to: $('#to').val(),
        page: $("#page").val(),
        pageSize: $("#pageSize").val(),
        userId
    };
    $("#listHistoryBlockUnblockTable tbody").html(`<tr><td colspan="12" class="text-center">${Messages("history.blockunblock.js.no.data")}</td></tr>`);

    let r = jsRoutes.controllers.TelcoUtilitiesController.getHistoryBlockUnblock();
    StartProcess();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (datas) {
            if (datas?.success) {
                viewHistoryBlockUnblockToTable(datas?.content.data, body.page, body.pageSize);
            }
        },
        complete: function () {
            FinishProcess();
        }
    });
}

// render Lịch sử chặn/mở thuê bao
function viewHistoryBlockUnblockToTable(datas, page, pageSize) {
    const startAt = (page - 1) * pageSize;
    const data = datas?.data;
    let body = "";
    console.log(datas);
    if (data && data.length > 0) {
        $("#notiNotDataHistory").html("");
        data.forEach((item, i) => {
            body += `
                        <tr>
                            <th>${startAt + i + 1}</th>
                            <td class='wrap-text'>${item.isdn}</td>
                            <td class='wrap-text'>${getActionLabel(item.actionCode)}</td>
                            <td class='wrap-text'>${item.status == 0 ? Messages("success") : Messages("history.blockunblock.js.status.failed")}</td>
                            <td class='wrap-text'>${item.description}</td>
                            <td class='wrap-text'>${moment.utc(item.issueDatetime).format("DD/MM/YYYY HH:mm")}</td>
                        </tr>`;
        });
    } else {
        $("#notiNotDataHistory").html(Messages("history.blockunblock.js.no.data.display"));
    }

    $("#listHistoryBlockUnblockTable tbody").html(body);
    $("#total_record").text(datas?.total || 0);
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
    getListHistoryBlockUnblockAction();
}

function resetFormSearch() {
    $('#orderId').val('');
    $('#isdn').val('');
    $('#from').val('');
    $('#to').val('');
    $('#action').val('');
    getListHistoryBlockUnblockAction();
}

function getActionLabel(actionCode) {
    let actionMap = {
        "00": Messages("history.blockunblock.js.action.connect.sim"),
        "06": Messages("history.blockunblock.block.one.way"),
        "07": Messages("history.blockunblock.block.two.way"),
        "08": Messages("history.blockunblock.open.one.way"),
        "09": Messages("history.blockunblock.open.two.way"),
        "10": Messages("history.blockunblock.js.action.recharge"),
        "11": Messages("history.blockunblock.js.action.pay.contract"),
        "21": Messages("history.blockunblock.js.action.register.vas"),
        "22": Messages("history.blockunblock.js.action.cancel.vas"),
        "23": Messages("history.blockunblock.js.action.cancel.renewal")
    };

    return actionMap[actionCode] || Messages("history.blockunblock.js.action.unknown");
}
