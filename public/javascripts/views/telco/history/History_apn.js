var actionApn="";
var pageApn= "";
var pageSizeApn="";
var fromApn ="";
var toApn="";
var idNoApn = "";
var isdnApn= "";

$(document).ready(function () {
    getListHistoryApnAction();
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY',
        time: false
    });
});

$('#sdtHistoryAPN').on('keydown', function (e) {
    if (e.key === "Enter") {
        e.preventDefault();
        getListHistoryApnAction();
    }
});

const nomoralizePhoneNumber = (phoneNumber) => {
    if (phoneNumber.startsWith("0")) {
        return phoneNumber.slice(1);
    }
    if (phoneNumber.length >= 11 && phoneNumber.startsWith("84")) {
        return phoneNumber.slice(2);
    }
    return phoneNumber;
};

function getListHistoryApnAction() {

    const phoneNumber = $('#sdtHistoryAPN').val().trim()
        ? nomoralizePhoneNumber($('#sdtHistoryAPN').val().trim())
        : "";

    var actionCode = "";
    if( $('#actionHistoryAPN').val()==null){
        actionCode = "reg_prv,unreg_prv,reg_def,unreg_def";
    }
    else{
        actionCode =$('#actionHistoryAPN').val();
    }
    const isValid = validateDate();
    actionApn = actionCode;
    pageApn = $("#page").val();
    pageSizeApn = $("#pageSize").val();
    if(isValid){
        fromApn = $('#fromHistoryAPN').val();
        toApn = $('#toHistoryAPN').val();
    }
    isdnApn =  phoneNumber;
    let body = {
        action: actionApn,
        //orderId: $('#orderId').val().trim(),
        isdn: isdnApn,
        from: fromApn,
        to: toApn,
        page: pageApn,
        pageSize: pageSizeApn,
        userId: userId
    };

    if (!isValid) {
        showNotification("danger", Messages("history.apn.js.date.validation.error"));
        return;
    }

    let r = jsRoutes.controllers.TelcoHistoryController.getHistoryApn();
    StartProcess();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (datas) {
            if (datas.content.data.total == 0) {
                $('#buttonExportApn').hide();
            }
            else{
                $('#buttonExportApn').show();
            }
            if (datas?.success) {
                viewHistoryApnTable(datas?.content.data, body.page, body.pageSize);
            }
        },
        complete: function () {
            FinishProcess();
        }
    });
}

// render lịch sử nạp tiền
function viewHistoryApnTable(datas, page, pageSize) {
    let startAt = (page - 1) * pageSize;
    let data = datas?.data;
    let body = "";

    if (data && data.length > 0) {
        $("#notiNotDataHistory").html("");
        for (var i = 0; i < data.length; i++) {
            const item = data[i];
            var package = item.package ? item.package.split("|"):["","","",""];

            var action = transferTypeAction(item.actionCode);


            let _ip = "--"
            switch (item.actionCode) {
                case "reg_prv":
                    _ip = package[1].trim().length > 0 ? package[1].trim() : Messages("history.apn.js.dynamic.ip");
                    break;
                default:
                    break;
            }

            body += "<tr>";
            body += "<th>" + (startAt + i + 1) + "</th>";
            body += "<td class='wrap-text'>" + item.isdn + "</td>";
            body += "<td class='wrap-text'>" + action + "</td>";
            body += `<td class='wrap-text'> ${package[0].trim().length > 0 ? package[0].trim() : "--"} </td>`;
            body += `<td class='wrap-text'> ${_ip} </td>`;
            body += "<td class='wrap-text'>" + (package[2].trim().length > 0 ? moment(package[2].trim()).format('DD/MM/YYYY') : "--") + "</td>";
            body += "<td class='wrap-text'>" + (package[3].trim().length > 0 ? moment(package[3].trim()).format('DD/MM/YYYY') : "--") + "</td>";
            body += "<td class='wrap-text'>" + (item.BCCSRespCode == "0" ? Messages("success") : Messages("history.apn.js.status.failed")) + "</td>";
            body += "<td class='wrap-text'>" + (item.BCCSRespCode == "0" ? "--" : item.description )+ "</td>";
            body += "<td class='wrap-text'>" + (item.issueDatetime.length > 0 ? moment.utc(item.issueDatetime).format('HH:mm DD/MM/YYYY') : "") + "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotDataHistory").html(Messages("history.apn.js.no.data.display"));
    }

    $("#listHistoryApnTable tbody").html(body);
    pagingTableHistoryApn(datas?.total, page, pageSize);
}

function transferTypeAction(action) {
    switch (action) {
        case 'reg_prv':
            return Messages("history.apn.assign.private.apn");

        case 'unreg_prv':
            return Messages("history.apn.cancel.private.apn");

        case 'reg_def':
            return Messages("history.apn.assign.default.apn");

        case 'unreg_def':
            return Messages("history.apn.cancel.default.apn");

        default:
            return "";
    }
}

function pagingTableHistoryApn(total, page, pageSize) {
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
    getListHistoryApnAction();
}

function resetFormSearch() {
    $('#sdtHistoryAPN').val('');
    $('#actionHistoryAPN').val('');
    $('#fromHistoryAPN').val('');
    $('#toHistoryAPN').val('');
    getListHistoryApnAction();
}
