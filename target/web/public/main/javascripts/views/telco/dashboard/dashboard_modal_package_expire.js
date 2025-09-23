$("#expired_in_days").change(function () {
    getDetailPackageExpire(1);
});
function getDetailPackageExpire(page) {
    const body = { };
    body.userId = userId;
    body.expiredInDays = $("#expired_in_days").val();
    body.page = page ?? $("#pagePackageExpire").val();
    body.pageSize = $("#pageSizePackageExpire").val();
    const r = jsRoutes.controllers.TelcoDashboardController.getDetailPackageExpired();
    StartProcess();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            if (datas && datas?.content?.data) {
                let dataRes = datas.content.data;
                var startAt = (body.page - 1) * body.pageSize;
                let bodyTable = "";
                dataRes.forEach((item, index) => {
                    bodyTable += `
                    <tr>
                    <td>${startAt + index + 1}</td>
                    <td>${item.isdn}</td>
                    <td>${item.id_no}</td>
                    <td>${item.package_name}</td>
                    <td>${item.expired_date ? moment(item.expired_date).format("HH:mm:ss DD/MM/YYYY") : "--"}</td>
                    </tr>
                `;
                });
                $("#table_modal_package_expire tbody").html(bodyTable);

                $("#modal_package_expire").modal('show');
                renderPaginationPackageExpire(datas.content.total, body.page, body.pageSize);
            } else {
                 $("#modal_package_expire").modal('show');
                 $("#table_modal_package_expire tbody").html(`<tr><td colspan="5" class="text-center">${Messages("tableNoData")}</td></tr>`);
            }
            FinishProcess();
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        }
    });
}

function renderPaginationPackageExpire(total, page, pageSize) {
    $("#total_record_PackageExpire").text(total);
    let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
    let currentPage = parseInt(page);
    let totalPage = Math.ceil(total / pageSize);

    if (currentPage > 1) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(${currentPage - 1}, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
            </li>`;
    }

    if (currentPage - 1 > 0) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(${currentPage - 1}, ${pageSize})">${currentPage - 1}</a>
            </li>`;
    }

    paging += `
        <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(${currentPage}, ${pageSize})">${currentPage}</a>
        </li>`;

    if (currentPage + 1 <= totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(${currentPage + 1}, ${pageSize})">${currentPage + 1}</a>
            </li>`;
    }

    if (currentPage < totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(${currentPage + 1}, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchPackageExpire(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
            </li>`;
    }

    paging += '</ul>';
    $("#pagingTablePackageExpire").html(paging);
}

function applySearchPackageExpire(page, pageSize) {
    $("#countPagePackageExpire").html(pageSize);
    $('#pagePackageExpire').val(page);
    $('#pageSizePackageExpire').val(pageSize);
    getDetailPackageExpire();
}

function resetModalPackageExpire() {
    // $("#pagePackageExpire").val(1);
    // $("#pageSizePackageExpire").val(10);
    $("#pagingTablePackageExpire").html("");
    $("#total_record_PackageExpire").text("0");
}


var columnTitlesPackageExpire;
var tablePackageExpire;

function downloadExcelPackageExpire(index = 1) {
    if (index === 1) {
        // Xóa table cũ nếu có
        var oldTable = document.getElementById("idExportTablePackageExpire");
        if (oldTable) {
            oldTable.remove();
        }

        // Khởi tạo tiêu đề
        columnTitlesPackageExpire = [
            Messages("dashboard.columnSTT"),
            Messages("dashboard.columnSubscriberNumber"),
            Messages("GPKD"),
            Messages("dashboard.columnServicePackage"),
            Messages("dashboard.columnExpiryDatePackage")
        ];

        // Tạo table tạm
        tablePackageExpire = document.createElement("table");
        tablePackageExpire.setAttribute("class", "table");
        tablePackageExpire.setAttribute("id", "idExportTablePackageExpire");
        tablePackageExpire.setAttribute("style", "margin-top: 100%; "); // Ẩn bảng
        document.body.appendChild(tablePackageExpire);

        // Tạo head table
        var tableThead = document.createElement("thead");
        var tableTheadTr = document.createElement("tr");

        for (var j = 0; j < columnTitlesPackageExpire.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitlesPackageExpire[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
        }
        tableThead.appendChild(tableTheadTr);
        tablePackageExpire.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tablePackageExpire.appendChild(tableTbody);

    }

    // Gọi API lấy dữ liệu từng trang
    var body = {
        userId: userId,
        expiredInDays: $("#expired_in_days").val(),
        page: index,
        pageSize: 1000 // Load 1000 bản ghi mỗi lần để xuất
    };

    var r = jsRoutes.controllers.TelcoDashboardController.getDetailPackageExpired();
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

                createTablePackageExpire(datas.content.data, index, body.pageSize);
            }
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        },
        complete: function () {
            if (offset + limit < total) {
                downloadExcelPackageExpire(index + 1);
            } else {
                outExcelPackageExpire("Danh_sach_thue_bao_het_han_goi_cuoc");
                FinishProcess();
            }
        }
    });
}

function createTablePackageExpire(data, index, pageSize) {
    var tableBody = $('#idExportTablePackageExpire').find("tbody");
    for (var i = 0; i < data.length; i++) {
        var tableTbodyTr = document.createElement("tr");
        for (var col = 0; col < columnTitlesPackageExpire.length; col++) {
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
                valueTextNode = data[i].id_no;
                break;
              case 3:
                valueTextNode = data[i].package_name;
                break;
              case 4:
                valueTextNode = data[i].expired_date ? moment(data[i].expired_date).format("HH:mm:ss MM/DD/YYYY") : "--";
                break;
            }

            var valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}

function outExcelPackageExpire(name) {
    //var x = document.getElementById("idExportTablePackageExpire").rows.length;
    const table = document.getElementById("idExportTablePackageExpire");
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
        $('#idExportTablePackageExpire').remove();
    }

    // if (x > 1) {
    //     var tableEx = $('#idExportTablePackageExpire');
    //     var table2excel = new Table2Excel({ defaultFileName: name, tableNameDataAttribute: "myTableExport" });
    //     table2excel.export(tableEx);
    // } else {
    //     showNotification('danger', Messages("Không có dữ liệu"));
    // }
    //$('#idExportTablePackageExpire').remove(); // Xóa bảng tạm sau khi xuất
}
