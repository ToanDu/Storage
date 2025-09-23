const idExportTable = 'TableListHistoryMiaddon';
let tableListHistoryMiaddon;
let totalRecordExport = 0;
let columnTitles = [];

function onlickButtonExport() {
    exportHistoryMiaddonToExcel(1);
}

function exportHistoryMiaddonToExcel(index) {
    var pageSize = parseInt($("#pageSize").val(), 10);
    if (index === 1) {
        totalRecordExport = 0;
        if($("#packMiAddon").val()=="change"){
            columnTitles = [
                "STT",
                Messages("history.miaddon.table.gpkd"),
                Messages("subscriber.phoneNumber"),
                Messages("history.miaddon.js.table.old.package"),
                Messages("history.miaddon.js.table.new.package"),
                Messages("filter.status"),
                Messages("filter.content"),
                Messages("content.reason"),
                Messages("history.miaddon.table.time"),
            ];
        }
        else{
            columnTitles = [
                "STT",
                Messages("history.miaddon.table.gpkd"),
                Messages("subscriber.phoneNumber"),
                Messages("history.miaddon.table.package"),
                Messages("filter.status"),
                Messages("filter.content"),
                Messages("history.miaddon.table.time"),
            ];
        }

        // Clear old table if exists
        if (tableListHistoryMiaddon) tableListHistoryMiaddon.remove();

        tableListHistoryMiaddon = document.createElement("table");
        tableListHistoryMiaddon.className = "table";
        tableListHistoryMiaddon.id = idExportTable;
        // Ẩn hoàn toàn bảng khỏi UI
        tableListHistoryMiaddon.style.position = "absolute";
        tableListHistoryMiaddon.style.top = "-9999px";
        tableListHistoryMiaddon.style.left = "-9999px";
        tableListHistoryMiaddon.style.visibility = "hidden";

        document.body.appendChild(tableListHistoryMiaddon);

        // Create header
        const thead = document.createElement("thead");
        const headerRow = document.createElement("tr");

        columnTitles.forEach(title => {
            const th = document.createElement("th");
            th.textContent = title;
            headerRow.appendChild(th);
        });

        thead.appendChild(headerRow);
        tableListHistoryMiaddon.appendChild(thead);
        tableListHistoryMiaddon.appendChild(document.createElement("tbody"));
    }
    var actionCode = $('#packMiAddon').val();
    const body = {
    //     body.action = actionMiaddon;
    // body.page = pageMiaddon;
    // body.pageSize = pageSizeMiaddon;
    // body.userId = userId;
    // body.from = fromMiaddon;
    // body.to = toMiaddon;
    // body.idNo =  idNoMiaddon;
    // body.isdn =  isdnMiaddon;

        action: actionMiaddon,
        isdn: isdnMiaddon,
        idNo: idNoMiaddon,
        from: fromMiaddon,
        to: toMiaddon,
        page: index,
        pageSize: pageSizeMiaddon,
        userId: userId
    };

    StartProcess();

    const r = jsRoutes.controllers.TelcoHistoryController.getHistoryPackMiAddon();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json",
        success: function (res) {
            const data = res?.content?.data.data || [];
            const tbody = tableListHistoryMiaddon.querySelector("tbody");
            total = res?.content?.data.total;
            data.forEach((item, i) => {
                const row = document.createElement("tr");
                console.log(((index - 1) * pageSize) + i + 1);
                var stt = ((index - 1) * pageSize) + i + 1;
                var body = "<td>"+stt+"</td>";
                if(actionCode == "change"){
                    var [oldPack = "", newPack = ""] = item.package ? item.package.split("|").map(p => p.trim()) : ["", ""];
                    var [result = "", content = ""] = item.description ? item.description.split("|").map(p => p.trim()) : ["", ""];
                    body += "<td class='wrap-text'>" + item.idNo + "</td>";
                    body += "<td class='wrap-text'>" + item.isdn + "</td>";
                    body += "<td class='wrap-text'>" + oldPack + "</td>";
                    body += "<td class='wrap-text'>" + newPack + "</td>";
                    body += "<td class='wrap-text'>" + (item.status == "0" ? Messages("success") : Messages("status.failed")) + "</td>";
                    body += "<td class='wrap-text'>" + getLabelResult(result) + "</td>";
                    body += "<td class='wrap-text'>" + content + "</td>";
                    body += "<td class='wrap-text'>" + (item.issueDatetime.length > 0 ? moment.utc(item.issueDatetime).format('HH:mm DD/MM/YYYY') : "")  + "</td>";
                }
                else{
                    body += "<td class='wrap-text'>" + item.idNo + "</td>";
                    body += "<td class='wrap-text'>" + item.isdn + "</td>";
                    body += "<td class='wrap-text'>" + item.package + "</td>";
                    body += "<td class='wrap-text'>" + (item.BCCSRespCode == "0" ? Messages("Thành công") : Messages("Thất bại")) + "</td>";
                    body += "<td class='wrap-text'>" + item.description + "</td>";
                    body += "<td class='wrap-text'>" + (item.issueDatetime.length > 0 ? moment.utc(item.issueDatetime).format('HH:mm DD/MM/YYYY') : "")  +"</td>";
                }
                row.innerHTML = body;
                tbody.appendChild(row);
            });

            totalRecordExport += data.length;
            if (data.length === pageSize && totalRecordExport < total) {
                exportHistoryMiaddonToExcel(index + 1);
            } else {
                outExcelListHistoryMiaddon("Lịch sử gói Mi, Add-on");
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.error(xhr);
            showNotification('danger', "Lỗi khi lấy dữ liệu");
            FinishProcess();
        }
    });
}

function getLabelResult(result) {
    if (result == "Register") {
        return Messages("Đăng ký thất bại");
    } else if (result == "Unregister") {
        return Messages("Hủy đăng ký thất bại");
    } else if (result == "Validation") {
        return Messages("Thuê bao không đủ điều kiện");
    }
}

function outExcelListHistoryMiaddon(name) {
    const table = document.getElementById(idExportTable);
    if (table.rows.length <= 1) {
        showNotification('warning', "Không có dữ liệu để xuất");
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
        showNotification('danger', "Lỗi khi xuất file Excel");
    } finally {
        $('#' + idExportTable).remove();
    }
}
