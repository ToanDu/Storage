var actionMiaddon="";
var pageMiaddon= "";
var pageSizeMiaddon="";
var fromMiaddon ="";
var toMiaddon="";
var idNoMiaddon = "";
var isdnMiaddon= "";

$(document).ready(function () {
    getListHistoryMiAddon();
});
function onlickButtonSearch() {
    $("#page").val(1);
    getListHistoryMiAddon();
}
historyPackMiAddon
const nomoralizePhoneNumber = (phoneNumber) => {
    if (phoneNumber.startsWith("0")) {
        return phoneNumber.slice(1);
    }
    if (phoneNumber.length >= 11 && phoneNumber.startsWith("84")) {
        return phoneNumber.slice(2);
    }
    return phoneNumber;
};


function getListHistoryMiAddon() {
    $("#historyMiAddonPage #total_record").html(0);
    const phoneNumber = $('#isdn').val().trim()
        ? nomoralizePhoneNumber($('#isdn').val().trim())
        : "";
    var start = $('#fromDate').val();
    var end =  $('#toDate').val();
    actionMiaddon = $("#packMiAddon").val();
    pageMiaddon = $("#page").val();
    pageSizeMiaddon = $("#pageSize").val();
    if(moment(start, "DD/MM/YYYY").valueOf() <= moment(end, "DD/MM/YYYY").valueOf()){
        fromMiaddon = $('#fromDate').val();
        toMiaddon = $('#toDate').val();
    }
    idNoMiaddon =  $("#idNo").val().trim();
    isdnMiaddon =  phoneNumber;

    if(moment(start, "DD/MM/YYYY").valueOf()> moment(end, "DD/MM/YYYY").valueOf()){
        showNotification("danger", Messages("history.miaddon.js.date.validation.error"));
        return;
    }

    var body = new FormData();
    body.action = actionMiaddon;
    body.page = pageMiaddon;
    body.pageSize = pageSizeMiaddon;
    body.userId = userId;
    body.from = fromMiaddon;
    body.to = toMiaddon;
    body.idNo =  idNoMiaddon;
    body.isdn =  isdnMiaddon;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoHistoryController.getHistoryPackMiAddon();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if (datas.content.data.total == 0) {
                $('#btn_export_data_miaddon').hide();
            }
            else{
                $('#btn_export_data_miaddon').show();
            }
            if(datas.content != null && datas.content.data != null){
                var startAt = (body.page - 1)*body.pageSize;
                viewDataToTable(datas.content.data, startAt, body.page, body.pageSize);
            }else{
                $("#listHistorysTable").find('tbody').html("");
                $("#notiNotData").html(Messages("history.miaddon.js.no.data.display"));
                // showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listHistorysTable").find('tbody').html("");
            $("#notiNotData").html(Messages("history.miaddon.js.no.data.display"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var listRespon = new Array;
function viewDataToTable(datas, startAt, page, pageSize) {
    var body = "";
    listRespon = [];
    var listData = datas.data;
    if (listData != null && listData.length > 0) {
        $("#notiNotData").html("");

        // Lịch sử đổi gói == change
        var isActionChange = $("#packMiAddon").val() == "change";

        if (isActionChange) {
            $("#listHistorysTable thead").html(`
                <tr>
                    <th>${Messages("manage.stt")}</th>
                    <th>${Messages("history.miaddon.table.gpkd")}</th>
                    <th>${Messages("history.miaddon.table.isdn")}</th>
                    <th>${Messages("history.miaddon.js.table.old.package")}</th>
                    <th>${Messages("history.miaddon.js.table.new.package")}</th>
                    <th>${Messages("filter.status")}</th>
                    <th>${Messages("history.miaddon.js.table.description")}</th>
                    <th>${Messages("history.miaddon.js.table.reason")}</th>
                    <th>${Messages("history.miaddon.table.time")}</th>
                </tr>
            `);

            for (var i = 0; i < listData.length; i++) {
                const item = listData[i];

                const [oldPack = "", newPack = ""] = item.package ? item.package.split("|").map(p => p.trim()) : ["", ""];

                const [result = "", content = ""] = item.description ? item.description.split("|").map(p => p.trim()) : ["", ""];

                body += "<tr>";
                body += "<th>" + (startAt + i + 1) + "</th>";
                body += "<td class='wrap-text'>" + item.idNo + "</td>";
                body += "<td class='wrap-text'>" + item.isdn + "</td>";
                body += "<td class='wrap-text'>" + oldPack + "</td>";
                body += "<td class='wrap-text'>" + newPack + "</td>";
                body += "<td class='wrap-text'>" + (item.status == "0" ? Messages("success") : Messages("history.miaddon.js.status.failed")) + "</td>";
                body += "<td class='wrap-text'>" + (item.status == "0" ? Messages("history.miaddon.js.change.package.success") : getLabelResult(result)) + "</td>";
                body += "<td class='wrap-text'>" + content + "</td>";
                body += "<td class='wrap-text'>" + (item.issueDatetime.length > 0 ? moment.utc(item.issueDatetime).format('HH:mm DD/MM/YYYY') : "") + "</td>";
                body += "</tr>";
            }

        } else {
            $("#listHistorysTable thead").html(`
                <tr>
                  <th>${Messages("manage.stt")}</th>
                  <th>${Messages("history.miaddon.table.gpkd")}</th>
                  <th>${Messages("history.miaddon.table.isdn")}</th>
                  <th>${Messages("history.miaddon.table.package")}</th>
                  <th>${Messages("filter.status")}</th>
                  <th>${Messages("filter.content")}</th>
                  <th>${Messages("history.miaddon.table.time")}</th>
                </tr>
            `);
            for (var i = 0; i < listData.length; i++) {
                const item = listData[i];
                body += "<tr>";
                body += "<th>" + (startAt + i + 1) + "</th>";
                body += "<td class='wrap-text'>" + item.idNo + "</td>";
                body += "<td class='wrap-text'>" + item.isdn + "</td>";
                body += "<td class='wrap-text'>" + item.package + "</td>";
                body += "<td class='wrap-text'>" + (item.status == "0" ? Messages("success") : Messages("history.miaddon.js.status.failed")) + "</td>";
                body += "<td class='wrap-text'>" + item.description + "</td>";
                body += "<td class='wrap-text'>" + (item.issueDatetime.length > 0 ? moment.utc(item.issueDatetime).format('HH:mm DD/MM/YYYY') : "") + "</td>";
                body += "</tr>";
            }
        }
    } else {
        $("#notiNotData").html(Messages("history.miaddon.js.no.data.display"));
    }
    $("#listHistorysTable").find('tbody').html(body);
    $("#historyMiAddonPage #total_record").html(datas?.total || 0);
    const pagingHTML = paging2HTML(datas.total, page, pageSize, applySearch);
    $("#pagingTable").html(pagingHTML);
}

function getLabelResult(result) {
    if (result == "Register") {
        return Messages("history.miaddon.js.register.failed");
    } else if (result == "Unregister") {
        return Messages("history.miaddon.js.unregister.failed");
    } else if (result == "Validation") {
        return Messages("history.miaddon.js.subscriber.not.eligible");
    }
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


function applySearch(page, pageSize, isResetPage) {
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);
    getListHistoryMiAddon();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListHistoryMiAddon();
}

function resetFormSearch(){
    $('#isdn').val('');
    $('#idNo').val('');
    $('#fromDate').val('');
    $('#toDate').val('');
    $('#packMiAddon').val('21');

    getListHistoryMiAddon();
}
