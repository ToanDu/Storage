function getDetailPrepaidExpired() {
     let body = new FormData();
    body.userId = userId;
    body.page = $("#pagePrepaidExpired").val();
    body.pageSize = $("#pageSizePrepaidExpired").val();
    
    let r = jsRoutes.controllers.TelcoDashboardController.getDetailPrepaidExpired();
    StartProcess();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            
            if (datas && datas?.content?.data) {
                let dataRes = datas?.content?.data;
                var startAt = (body.page - 1) * body.pageSize;
                let bodyTable = "";
                dataRes.forEach((item, index) => {
                    bodyTable += `
                    <tr>
                        <td class="text-center">${startAt + index + 1}</td>
                        <td class="text-center">${item.isdn}</td>
                        <td class="text-center">${item.contract_id}</td>
                        <td class="text-center">${item.end_prepaid && item.end_prepaid !== 0 && !moment(item.end_prepaid).isSame('0001-01-01', 'day') ? moment(item.end_prepaid).format("DD/MM/YYYY") : "--"}</td>
                        <td class="text-center">${item.created_at ? moment(item.created_at).format("HH:mm:ss DD/MM/YYYY") : "--"}</td>
                    </tr>
                `;
                });
                $("#table_modal_prepaid_expired tbody").html(bodyTable);

                $("#modal_prepaid_expired").modal('show');
                renderPaginationPrepaidExpired(datas.content.total, body.page, body.pageSize);
            } else {
                $("#modal_prepaid_expired").modal('show');
                $("#table_modal_prepaid_expired tbody").html(`<tr><td colspan="5" class="text-center">${Messages("tableNoData")}</td></tr>`);
            }
            FinishProcess();
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        }
    });
}

function renderPaginationPrepaidExpired(total, page, pageSize) {
    $("#total_record_PrepaidExpired").text(total);
    let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
    let currentPage = parseInt(page);
    let totalPage = Math.ceil(total / pageSize);

    if (currentPage > 1) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(${currentPage - 1}, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
            </li>`;
    }

    if (currentPage - 1 > 0) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(${currentPage - 1}, ${pageSize})">${currentPage - 1}</a>
            </li>`;
    }

    paging += `
        <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(${currentPage}, ${pageSize})">${currentPage}</a>
        </li>`;

    if (currentPage + 1 <= totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(${currentPage + 1}, ${pageSize})">${currentPage + 1}</a>
            </li>`;
    }

    if (currentPage < totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(${currentPage + 1}, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPrepaidExpired(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
            </li>`;
    }

    paging += '</ul>';
    $("#pagingTablePrepaidExpired").html(paging);
}

function applySearchPrepaidExpired(page, pageSize) {
    $("#countPagePrepaidExpired").html(pageSize);
    $('#pagePrepaidExpired').val(page);
    $('#pageSizePrepaidExpired').val(pageSize);
    getDetailPrepaidExpired();
}

function resetModalPrepaidExpired() {
    // $("#pagePrepaidExpired").val(1);
    // $("#pageSizePrepaidExpired").val(10);
    $("#pagingTablePrepaidExpired").html("");
    $("#total_record_PrepaidExpired").text("0");
}


var columnTitlesPrepaidExpired;
var tablePrepaidExpired;

function downloadExcelPrepaidExpired(index = 1) {
    if (index === 1) {
        // Khởi tạo tiêu đề
        columnTitlesPrepaidExpired = [Messages("dashboard.columnSTT"), Messages("dashboard.columnSubscriberNumber"), Messages("dashboard.columnContractCode"), Messages("dashboard.columnExpiryDate"), Messages("dashboard.columnUpdateTime")];

        // Tạo table tạm
        tablePrepaidExpired = document.createElement("table");
        tablePrepaidExpired.setAttribute("class", "table");
        tablePrepaidExpired.setAttribute("id", "idExportTablePrepaidExpired");
        tablePrepaidExpired.setAttribute("style", "margin-top: 100%; "); // Ẩn bảng
        document.body.appendChild(tablePrepaidExpired);

        // Tạo head table
        var tableThead = document.createElement("thead");
        var tableTheadTr = document.createElement("tr");

        for (var j = 0; j < columnTitlesPrepaidExpired.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitlesPrepaidExpired[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
        }
        tableThead.appendChild(tableTheadTr);
        tablePrepaidExpired.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tablePrepaidExpired.appendChild(tableTbody);

    }

    // Gọi API lấy dữ liệu từng trang
    var body = {
        userId: userId,
        page: index,
        pageSize: 1000 // Load 1000 bản ghi mỗi lần để xuất
    };

    var r = jsRoutes.controllers.TelcoDashboardController.getDetailPrepaidExpired();
    StartProcess();
    var total = 0;
    var offset = 0;
    var limit = 0;

    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            if (datas && datas.content && datas.content.data && datas.content.data.length > 0) {
                total = datas.content.total;
                offset = datas.content.offset;
                limit = datas.content.limit;

                createTablePrepaidExpired(datas.content.data, index, body.pageSize);
            }
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        },
        complete: function () {
            if (offset + limit < total) {
                downloadExcelPrepaidExpired(index + 1);
            } else {
                outExcelPrepaidExpired("Danh_sach_thue_bao_het_han_cuoc_dong_truoc");
                FinishProcess();
            }
        }
    });
}

function createTablePrepaidExpired(data, index, pageSize) {
    var tableBody = $('#idExportTablePrepaidExpired').find("tbody");
    for (var i = 0; i < data.length; i++) {
        var tableTbodyTr = document.createElement("tr");
        for (var col = 0; col < columnTitlesPrepaidExpired.length; col++) {
            var td = document.createElement("td");
            var valueTextNode = '';
            var stt = (index - 1) * pageSize;

            switch (col) {
                case 0:
                    valueTextNode = stt + i + 1;
                    break;
                case 1:
                    valueTextNode = data[i].isdn;
                    break;
                case 2:
                    valueTextNode = data[i].contract_id;
                    break;
                case 3:
                    valueTextNode = data[i].end_prepaid && data[i].end_prepaid !== 0 && !moment(data[i].end_prepaid).isSame('0001-01-01', 'day') ? moment(data[i].end_prepaid).format("MM/DD/YYYY") : "--";
                    break;
                case 4:
                    valueTextNode = data[i].created_at ? moment(data[i].created_at).format("HH:mm:ss MM/DD/YYYY") : "--";
                    break;
            }

            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}

function outExcelPrepaidExpired(name) {
    //var x = document.getElementById("idExportTablePrepaidExpired").rows.length;
    const table = document.getElementById("idExportTablePrepaidExpired");
    if (table.rows.length <= 1) {
        showNotification('warning', Messages("noti.notFoundData"));
        return;
    }
    try {
        const table2excel = new Table2Excel({
            defaultFileName: name,
            tableNameDataAttribute: "myTableExport",
            preserveColors: true
        });
        table2excel.export($(table));
    } catch (e) {
        console.error("Export error:", e);
        showNotification('danger', Messages("dashboard.excelExportError"));
    } finally {
        //$('#idExportTablePrepaidExpired').remove();
    }

}
