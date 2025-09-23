function getDetailRedAlert() {
     let body = new FormData();
    body.userId = userId;
    body.page = $("#pageRedAlert").val();
    body.pageSize = $("#pageSizeRedAlert").val();
    console.log("getDetailRedAlert", body);
    
    let r = jsRoutes.controllers.TelcoDashboardController.getDetailRedAlert();
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
                        <td class="text-center">${item.sms_type}%</td>
                        <td class="text-center">${item.create_date ? moment(item.create_date).format("HH:mm:ss DD/MM/YYYY") : "--"}</td>
                    </tr>
                `;
                });
                $("#table_modal_red_alert tbody").html(bodyTable);

                $("#modal_red_alert").modal('show');
                renderPaginationRedAlert(datas.content.total, body.page, body.pageSize);
            } else {
                $("#modal_red_alert").modal('show');
                $("#table_modal_red_alert tbody").html(`<tr><td colspan="5" class="text-center">${Messages("tableNoData")}</td></tr>`);
            }
            FinishProcess();
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        }
    });
}

function renderPaginationRedAlert(total, page, pageSize) {
    $("#total_record_RedAlert").text(total);
    let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
    let currentPage = parseInt(page);
    let totalPage = Math.ceil(total / pageSize);

    if (currentPage > 1) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(${currentPage - 1}, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
            </li>`;
    }

    if (currentPage - 1 > 0) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(${currentPage - 1}, ${pageSize})">${currentPage - 1}</a>
            </li>`;
    }

    paging += `
        <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(${currentPage}, ${pageSize})">${currentPage}</a>
        </li>`;

    if (currentPage + 1 <= totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(${currentPage + 1}, ${pageSize})">${currentPage + 1}</a>
            </li>`;
    }

    if (currentPage < totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(${currentPage + 1}, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchRedAlert(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
            </li>`;
    }

    paging += '</ul>';
    $("#pagingTableRedAlert").html(paging);
}

function applySearchRedAlert(page, pageSize) {
    $("#countPageRedAlert").html(pageSize);
    $('#pageRedAlert').val(page);
    $('#pageSizeRedAlert').val(pageSize);
    getDetailRedAlert();
}

function resetModalRedAlert() {
    // $("#pageRedAlert").val(1);
    // $("#pageSizeRedAlert").val(10);
    $("#pagingTableRedAlert").html("");
    $("#total_record_RedAlert").text("0");
}


var columnTitlesRedAlert;
var tableRedAlert;

function downloadExcelRedAlert(index = 1) {
    if (index === 1) {
        // Xóa table cũ nếu có
        var oldTable = document.getElementById("idExportTableRedAlert");
        if (oldTable) {
            oldTable.remove();
        }

        // Khởi tạo tiêu đề
        columnTitlesRedAlert = [Messages("dashboard.columnSTT"), Messages("dashboard.columnSubscriberNumber"), Messages("dashboard.columnContractCode"), Messages("dashboard.columnThresholdExceeded"), Messages("dashboard.columnUpdateTime")];

        // Tạo table tạm
        tableRedAlert = document.createElement("table");
        tableRedAlert.setAttribute("class", "table");
        tableRedAlert.setAttribute("id", "idExportTableRedAlert");
        tableRedAlert.setAttribute("style", "margin-top: 100%; "); // Ẩn bảng
        document.body.appendChild(tableRedAlert);

        // Tạo head table
        var tableThead = document.createElement("thead");
        var tableTheadTr = document.createElement("tr");

        for (var j = 0; j < columnTitlesRedAlert.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitlesRedAlert[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
        }
        tableThead.appendChild(tableTheadTr);
        tableRedAlert.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tableRedAlert.appendChild(tableTbody);

    }

    // Gọi API lấy dữ liệu từng trang
    var body = {
        userId: userId,
        page: index,
        pageSize: 1000 // Load 1000 bản ghi mỗi lần để xuất
    };

    var r = jsRoutes.controllers.TelcoDashboardController.getDetailRedAlert();
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

                createTableRedAlert(datas.content.data, index, body.pageSize);
            }
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        },
        complete: function () {
            if (offset + limit < total) {
                downloadExcelRedAlert(index + 1);
            } else {
                outExcelRedAlert("Danh_sach_thue_bao_bao_dong_do");
                FinishProcess();
            }
        }
    });
}

function createTableRedAlert(data, index, pageSize) {
    var tableBody = $('#idExportTableRedAlert').find("tbody");
    for (var i = 0; i < data.length; i++) {
        var tableTbodyTr = document.createElement("tr");
        for (var col = 0; col < columnTitlesRedAlert.length; col++) {
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
                    valueTextNode = data[i].sms_type;
                    break;
                case 4:
                    valueTextNode = data[i].create_date ? moment(data[i].create_date).format("HH:mm:ss MM/DD/YYYY") : "--";
                    break;
            }

            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}

function outExcelRedAlert(name) {
    //var x = document.getElementById("idExportTableRedAlert").rows.length;
    const table = document.getElementById("idExportTableRedAlert");
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
        $('#idExportTableRedAlert').remove();
    }

    // if (x > 1) {
    //     var tableEx = $('#idExportTableRedAlert');
    //     var table2excel = new Table2Excel({ defaultFileName: name, tableNameDataAttribute: "myTableExport" });
    //     table2excel.export(tableEx);
    // } else {
    //     showNotification('danger', Messages("Không có dữ liệu"));
    // }
    //$('#idExportTableRedAlert').remove(); // Xóa bảng tạm sau khi xuất
}
