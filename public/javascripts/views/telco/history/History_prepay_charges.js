$(document).ready(function () {
    getListPrepayChargesAction();
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY',
        time: false
    });

// Chỉ cho nhập số
$('#isdn').on('input', function() {
        var val = this.value.replace(/[^\d]/g, '');
        if (val.length > 11) val = val.slice(0, 12);
        this.value = val;
    });

});


$(document).on('keydown', function (e) {
    if (e.key === "Enter") {
        e.preventDefault();
        getListPrepayChargesAction();
    }
});

function formatVND(amount) {
    amount = Number(amount) || 0;
    return amount.toLocaleString('vi-VN');
}
const nomoralizePhoneNumber = (phoneNumber) => {
    if (phoneNumber.startsWith("0")) {
        return phoneNumber.slice(1);
    }
    if (phoneNumber.length >= 11 && phoneNumber.startsWith("84")) {
        return phoneNumber.slice(2);
    }
    return phoneNumber;
};
function getListPrepayChargesAction(isNewSearch = false) {
    let orderId = $('#orderId').val().trim();
    let isdn = $('#isdn').val().trim()
        ? nomoralizePhoneNumber($('#isdn').val().trim())
        : "";
    let from = $('#from').val().trim();
    let to = $('#to').val().trim();
    // Chỉ validate nếu có dữ liệu nhập vào
    if ( from || to) {
        if (!validateFromToPrepay(from, to)) return;
    }
    let page = $("#page").val().trim();
    if (isNewSearch) {
        page = 1;
        $("#page").val(page);
    }
    let body = {
        action: "pre_paid",
        orderId: orderId,
        isdn: isdn,
        from: from,
        to: to,
        page: page,
        pageSize: $("#pageSize").val().trim(),
        userId: userId
    };

    let r = jsRoutes.controllers.TelcoUtilitiesController.getHistoryPrepayCharges();
    StartProcess();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (datas) {
            if (datas?.success) {
                datas?.content?.data?.total <= 0 ? $('#btn_export').addClass('d-none') : $('#btn_export').removeClass('d-none')
                viewPrepayChargesTable(datas?.content?.data, body.page, body.pageSize);
            }
        },
        complete: function () {
            FinishProcess();
        }
    });
}

// Validate các trường from và to, dùng showNotification nếu có lỗi
function validateFromToPrepay(from, to) {
    let fromDate = from ? moment(from, 'DD/MM/YYYY', true) : null;
    let toDate = to ? moment(to, 'DD/MM/YYYY', true) : null;
    if (fromDate && toDate && fromDate.isAfter(toDate)) {
        showNotification('danger', Messages("history.prepay.js.date.validation.error"));
        return false;
    }
    return true;
}

// render
function viewPrepayChargesTable(datas, page, pageSize) {
    let startAt = (page - 1) * pageSize;
    let data = datas?.data;
    let body = "";

    if (data && data.length > 0) {
        $("#notiNotDataHistory").html("");
        data.forEach((item, i) => {
            
            let requestBody = item.requestBody;
            let state = item.status == "1" ? false : true;
            let text_prom_value = "";
            let displayPromMonth = parseInt(requestBody.display_prom_month);
            let promPercent = parseInt(requestBody.prom_percent);
            if (displayPromMonth || promPercent) {
                if (displayPromMonth) {
                    text_prom_value += `${Messages("history.prepay.js.bonus")} ${displayPromMonth} ${Messages("history.prepay.js.months")}`;
                }
                if (displayPromMonth && promPercent) {
                    text_prom_value += " + ";
                }
                if (promPercent) {
                    text_prom_value += `${Messages("history.prepay.js.promotion")} ${promPercent}%`;
                }
            }
            body += `
                        <tr>
                            <th>${startAt + i + 1}</th>
                            <td class='wrap-text'>${item.orderId}</td>
                            <td class='wrap-text'>${item.isdn}</td>
                            <td class='wrap-text'>${requestBody.product_code}</td>
                            <td class='wrap-text'>${requestBody.promotion_code}</td>
                            <td class='wrap-text'>${requestBody.prom_month}</td>
                            <td class='wrap-text'>${text_prom_value}</td> 
                            <td class='wrap-text'>${ formatVND(item.fee)}</td>
                            <td class='wrap-text ${!state && 'text-danger'}'>${state ? Messages("success") : Messages("history.prepay.js.status.failed")}</td>
                            <td class='wrap-text ${!state && 'text-danger'}'>${item.status == "1" ? item.description : ""}</td>
                            <td class='wrap-text'>${moment(item.issueDatetime).utc().format("DD/MM/YYYY HH:mm")}</td>
                        </tr>`;
        });
    } else {
        $("#notiNotDataHistory").html(Messages("history.prepay.js.no.data.display"));
    }

    $("#listPrepayChargesTable tbody").html(body);
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
    getListPrepayChargesAction();
}

function resetFormSearch() {
    $('#orderId').val('');
    $('#isdn').val('');
    $('#from').val('');
    $('#to').val('');
    getListPrepayChargesAction();
}
