function getDetailLowRemainingData() { 
     let body = new FormData();
    body.userId = userId;
    body.page = $("#pageLowRemainingData").val();
    body.pageSize = $("#pageSizeLowRemainingData").val();
    
    let r = jsRoutes.controllers.TelcoDashboardController.getDetailLowRemainingData();
    StartProcess();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            if (datas && datas?.content?.data) {
                let dataRes = datas?.content?.data;
                var startAt = (body.page - 1) * body.pageSize;
                let bodyTable = "";
                dataRes.forEach((item, index) => {
                    // Tính phần trăm data còn lại
                    let percentRemaining = 0;
                    if (item.total_data && item.total_data > 0) {
                        percentRemaining = ((item.remaining_data) / item.total_data) * 100;
                    }
                    bodyTable += `
                    <tr>
                        <td class="text-center">${startAt + index + 1}</td>
                        <td class="text-center">${item.isdn}</td>
                        <td class="text-center">${item.id_no}</td>
                        <td class="text-center">${item.package_name}</td>
                        <td class="text-center">${percentRemaining.toFixed(2)}% (${item.remaining_data} KB)</td>
                        <td class="text-center">${item.created_at ? moment(item.created_at).format("HH:mm:ss DD/MM/YYYY") : "--"}</td>
                    </tr>
                `;
                });
                $("#table_modal_low_remaining_data tbody").html(bodyTable);

                $("#modal_low_remaining_data").modal('show');
                renderPaginationLowRemainingData(datas.content.total, body.page, body.pageSize);
            } else {
                $("#modal_low_remaining_data").modal('show');
                $("#table_modal_low_remaining_data tbody").html(`<tr><td colspan="6" class="text-center">${Messages("tableNoData")}</td></tr>`);
            }
            FinishProcess();
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        }
    });
}

function renderPaginationLowRemainingData(total, page, pageSize) {
    $("#total_record_LowRemainingData").text(total);
    let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
    let currentPage = parseInt(page);
    let totalPage = Math.ceil(total / pageSize);

    if (currentPage > 1) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(${currentPage - 1}, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
            </li>`;
    }

    if (currentPage - 1 > 0) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(${currentPage - 1}, ${pageSize})">${currentPage - 1}</a>
            </li>`;
    }

    paging += `
        <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(${currentPage}, ${pageSize})">${currentPage}</a>
        </li>`;

    if (currentPage + 1 <= totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(${currentPage + 1}, ${pageSize})">${currentPage + 1}</a>
            </li>`;
    }

    if (currentPage < totalPage) {
        paging += `
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(${currentPage + 1}, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
            </li>
            <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="applySearchLowRemainingData(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
            </li>`;
    }

    paging += '</ul>';
    $("#pagingTableLowRemainingData").html(paging);
}

function applySearchLowRemainingData(page, pageSize) {
    $("#countPageLowRemainingData").html(pageSize);
    $('#pageLowRemainingData').val(page);
    $('#pageSizeLowRemainingData').val(pageSize);
    getDetailLowRemainingData();
}

function resetModalLowRemainingData() {
    // $("#pageLowRemainingData").val(1);
    // $("#pageSizeLowRemainingData").val(10);
    $("#pagingTableLowRemainingData").html("");
    $("#total_record_LowRemainingData").text("0");
}


var columnTitlesLowRemainingData;
var tableLowRemainingData;

function downloadExcelLowRemainingData(index = 1) {
    if (index === 1) {
        // Khởi tạo tiêu đề
        columnTitlesLowRemainingData = [
            Messages("dashboard.columnSTT"),
            Messages("dashboard.columnSubscriberNumber"),
            Messages("GPKD"),
            Messages("dashboard.columnServicePackage"),
            Messages("dashboard.columnDataRemaining"),
            Messages("dashboard.columnUpdateTime")
        ];

        // Tạo table tạm
        tableLowRemainingData = document.createElement("table");
        tableLowRemainingData.setAttribute("class", "table");
        tableLowRemainingData.setAttribute("id", "idExportTableLowRemainingData");
        tableLowRemainingData.setAttribute("style", "margin-top: 100%; "); // Ẩn bảng
        document.body.appendChild(tableLowRemainingData);

        // Tạo head table
        var tableThead = document.createElement("thead");
        var tableTheadTr = document.createElement("tr");

        for (var j = 0; j < columnTitlesLowRemainingData.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitlesLowRemainingData[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
        }
        tableThead.appendChild(tableTheadTr);
        tableLowRemainingData.appendChild(tableThead);

        var tableTbody = document.createElement("tbody");
        tableLowRemainingData.appendChild(tableTbody);

    }

    // Gọi API lấy dữ liệu từng trang
    var body = {
        userId: userId,
        page: index,
        pageSize: 1000 // Load 1000 bản ghi mỗi lần để xuất
    };

    var r = jsRoutes.controllers.TelcoDashboardController.getDetailLowRemainingData();
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

                createTableLowRemainingData(datas.content.data, index, body.pageSize);
            }
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        },
        complete: function () {
            if (offset + limit < total) {
                downloadExcelLowRemainingData(index + 1);
            } else {
                outExcelLowRemainingData("Danh_sach_thue_bao_co_luu_luong_data_duoi_20_phan_tram");
                FinishProcess();
            }
        }
    });
}

function createTableLowRemainingData(data, index, pageSize) {
    let tableBody = $('#idExportTableLowRemainingData').find("tbody");
    for (let i = 0; i < data.length; i++) {
        let tableTbodyTr = document.createElement("tr");
        for (let col = 0; col < columnTitlesLowRemainingData.length; col++) {
            let td = document.createElement("td");
            let valueTextNode = '';
            let stt = (index - 1) * pageSize;
            // Tính phần trăm data còn lại
            let percentRemaining = 0;
            if (data[i].total_data && data[i].total_data > 0) {
                percentRemaining = parseInt(((data[i].remaining_data) / data[i].total_data) * 100);
            }
            
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
                    valueTextNode = `${percentRemaining.toFixed(2)}% (${data[i].remaining_data} KB)`;
                    break;
                case 5:
                    valueTextNode = data[i].created_at ? moment(data[i].created_at).format("HH:mm:ss MM/DD/YYYY") : "--";
                    break;
            }

            let valueTd = document.createTextNode(valueTextNode);
            td.appendChild(valueTd);
            tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
    }
}

function outExcelLowRemainingData(name) {
    //var x = document.getElementById("idExportTableLowRemainingData").rows.length;
    const table = document.getElementById("idExportTableLowRemainingData");
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
        //$('#idExportTableLowRemainingData').remove();
    }

}
