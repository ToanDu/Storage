$(document).ready(function () {
    getListHistoryPostPaidBillAction();
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY',
        time: false
    });
});
$(document).on('keydown', function (e) {
    if (e.key === "Enter") {
        e.preventDefault();
        getListHistoryPostPaidBillAction();
    }
});
function getListHistoryPostPaidBillAction() {
    
    let action = "pay_debit";
    let orderId = $('#orderId').val().trim();
    let contractId = $('#contractId').val().trim();
    let from = $('#from').val();
    let to = $('#to').val();
    let page = $("#page").val();
    let pageSize = $("#pageSize").val();
    //Tìm kiếm thì set page 1
    if(orderId || contractId || from || to){
        page = 1;
    }
    if ( from || to) {
        if (!validateFromTo(from, to)) return;
    }
    let body = {
        action,
        orderId,
        contractId,
        from,
        to,
        page,
        pageSize,
        userId
    };
    $("#listHistoryPostPaidBillTable tbody").html('<tr><td colspan="12" class="text-center">' + Messages("history.postpaid.js.no.data") + '</td></tr>');
    $("#listHistoryPostPaidBillPaging #pagingTable").empty();
    $("#listHistoryPostPaidBillPaging #total_record").text(0);

    let r = jsRoutes.controllers.TelcoUtilitiesController.getHistoryPayPostBill();
    StartProcess();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            let content = res?.content?.data;
            $('#export_data').toggle(content?.total > 0);
            if (res) {
                viewHistoryPostPaidBillTable(content, body.page, body.pageSize);
            }
        },
        complete: function () {
            FinishProcess();
        }
    });
}
function validateFromTo(from, to) {
    let fromDate = from ? moment(from, 'DD/MM/YYYY', true) : null;
    let toDate = to ? moment(to, 'DD/MM/YYYY', true) : null;
    if (fromDate && toDate && fromDate.isAfter(toDate)) {
        showNotification('danger', Messages("history.postpaid.js.date.validation.error"));
        return false;
    }
    return true;
}
// render lịch sử 
function viewHistoryPostPaidBillTable(datas, page, pageSize) {
    let startAt = (page - 1) * pageSize;
    let data = datas?.data;
    let body = "";

    if (data && data.length > 0) {
        $("#notiNotDataHistory").html("");
        data.forEach((item, i) => {
            body += `
                        <tr>
                            <th>${startAt + i + 1}</th>
                            <td class='wrap-text'>${item.orderId}</td>
                            <td class='wrap-text'>${item.contractId}</td>
                            <td class='wrap-text'>${item.fee.toLocaleString('vi-VN')}</td>
                            <td class='wrap-text'>${item.status == "0" ? Messages("success") : Messages("history.postpaid.js.status.failed")}</td>
                            <td class='wrap-text'>${item.status != "0" ? item.description : ""}</td>
                            <td class='wrap-text'>${moment.utc(item.issueDatetime).format("DD/MM/YYYY HH:mm")}</td>
                        </tr>`;
        });
    } else {
        $("#notiNotDataHistory").html(Messages("history.postpaid.js.no.data.display"));
    }

    $("#listHistoryPostPaidBillTable tbody").html(body);
    $("#total_record").text(datas?.total || 0);

    pagingTableHistoryPostPaidBill(datas?.total, page, pageSize);
}

function pagingTableHistoryPostPaidBill(total, page, pageSize) {
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
    getListHistoryPostPaidBillAction();
}

function resetFormSearch() {
    $('#orderId').val('');
    $('#contractId').val('');
    $('#from').val('');
    $('#to').val('');
    $("#page").val(1);
    $('#export_data').show();
    getListHistoryPostPaidBillAction();
}
