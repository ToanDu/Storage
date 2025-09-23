const idExportTable = 'TableListHistoryApn';

let tableListHistoryApn;
let totalRecordExport = 0;
let columnTitles = [];
let total = 0;

function onlickButtonExport() {
    exportHistoryApnToExcel(1);
}

function exportHistoryApnToExcel(index) {
    var pageSize = parseInt($("#pageSize").val(), 10);
    if (index === 1) {
        totalRecordExport = 0;
        columnTitles = [
            Messages("manage.stt"),
            Messages("history.apn.subscriber.number"),
            Messages("history.apn.action"),
            Messages("history.apn.apn"),
            Messages("history.apn.ip"),
            Messages("history.apn.start.date"),
            Messages("history.apn.end.date"),
            Messages("history.apn.result"),
            Messages("history.apn.failure.reason"),
            Messages("history.apn.time")
        ];

        // Clear old table if exists
        if (tableListHistoryApn) tableListHistoryApn.remove();

        tableListHistoryApn = document.createElement("table");
        tableListHistoryApn.className = "table";
        tableListHistoryApn.id = idExportTable;

        // Ẩn hoàn toàn bảng khỏi UI
        tableListHistoryApn.style.position = "absolute";
        tableListHistoryApn.style.top = "-9999px";
        tableListHistoryApn.style.left = "-9999px";
        tableListHistoryApn.style.visibility = "hidden";

        document.body.appendChild(tableListHistoryApn);

        // Create header
        const thead = document.createElement("thead");
        const headerRow = document.createElement("tr");

        columnTitles.forEach(title => {
            const th = document.createElement("th");
            th.textContent = title;
            headerRow.appendChild(th);
        });

        thead.appendChild(headerRow);
        tableListHistoryApn.appendChild(thead);
        tableListHistoryApn.appendChild(document.createElement("tbody"));
    }

    var actionCode = "";
    if( $('#actionHistoryAPN').val()==null){
        actionCode = "reg_prv,unreg_prv,reg_def,unreg_def";
    }
    else{
        actionCode =$('#actionHistoryAPN').val();
    }
    let body = {
        action: actionApn,
        //orderId: $('#orderId').val().trim(),
        isdn: isdnApn,
        from: fromApn,
        to: toApn,
        page: index,
        pageSize: pageSizeApn,
        userId: userId
    };

    StartProcess();

    var r = jsRoutes.controllers.TelcoHistoryController.getHistoryApn();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json",
        success: function (res) {
            const data = res?.content?.data.data || [];
            const tbody = tableListHistoryApn.querySelector("tbody");
            total = res?.content?.data.total;
            data.forEach((item, i) => {
                const row = document.createElement("tr");
                var package = item.package ? item.package.split("|"):["","","",""];

                var action = transferTypeAction(item.actionCode);
                console.log(((index - 1) * pageSize) + i + 1);
                var stt = ((index - 1) * pageSize) + i + 1;
                var body = "<td>"+stt+"</td>";
                body += "<td class='wrap-text'>" + item.isdn + "</td>";
                body += "<td class='wrap-text'>" + action + "</td>";
                body += "<td class='wrap-text'>" + package[0] + "</td>";
                body += "<td class='wrap-text'>" + (item.actionCode==="reg_prv" && package[1].trim().length===0? Messages("history.apn.js.dynamic.ip"):package[1].trim()) + "</td>";
                body += "<td class='wrap-text'>" + (package[2].trim().length > 0 ? moment(package[2].trim()).format('DD/MM/YYYY') : "") + "</td>";
                body += "<td class='wrap-text'>" + (package[3].trim().length > 0 ? moment(package[3].trim()).format('DD/MM/YYYY') : "") + "</td>";
                body += "<td class='wrap-text'>" + (item.BCCSRespCode == "0" ? Messages("success") : Messages("history.apn.js.status.failed")) + "</td>";
                body += "<td class='wrap-text'>" + (item.BCCSRespCode == "0" ?" ":item.description )+ "</td>";
                body += "<td class='wrap-text'>" + (item.issueDatetime.length > 0 ? moment.utc(item.issueDatetime).format('HH:mm DD/MM/YYYY') : "") + "</td>";
                row.innerHTML = body;
                tbody.appendChild(row);
            });

            totalRecordExport += data.length;
            console.log(data.length,pageSize,totalRecordExport,total)
            if (data.length === pageSize && totalRecordExport < total) {
                console.log("heree")
                exportHistoryApnToExcel(index + 1);
            } else {
                outExcelListHistoryApn(Messages("history.apn.title"));
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.error(xhr);
            showNotification('danger', Messages("history.apn.js.export.error"));
            FinishProcess();
        }
    });
}

function outExcelListHistoryApn(name) {
    const table = document.getElementById(idExportTable);
    if (table.rows.length <= 1) {
        showNotification('warning', Messages("history.apn.js.no.export.data"));
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
        showNotification('danger', Messages("history.apn.js.excel.export.error"));
    } finally {
        $('#' + idExportTable).remove();
    }
}
