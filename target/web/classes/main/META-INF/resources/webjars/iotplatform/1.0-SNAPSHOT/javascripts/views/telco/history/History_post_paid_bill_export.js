const idExportTable = 'TableListHistoryPostPaidBill';
let tableListHistoryPostPaidBill;
let totalRecordExport = 0;
let columnTitles = [];

function onlickButtonExport() {
    exportHistoryPostPaidBillToExcel(1);
}

function exportHistoryPostPaidBillToExcel(index) {
    let pageSize = parseInt($("#pageSize").val(), 10);
    if (index === 1) {
        totalRecordExport = 0;
        columnTitles = [
            Messages("manage.stt"),
            Messages("history.postpaid.transaction.code"),
            Messages("history.postpaid.contract.number"),
            Messages("history.postpaid.amount"),
            Messages("history.postpaid.status"),
            Messages("history.postpaid.description"),
            Messages("history.postpaid.time")
        ];

        // Clear old table if exists
        if (tableListHistoryPostPaidBill) tableListHistoryPostPaidBill.remove();

        tableListHistoryPostPaidBill = document.createElement("table");
        tableListHistoryPostPaidBill.className = "table";
        tableListHistoryPostPaidBill.id = idExportTable;
        // Ẩn hoàn toàn bảng khỏi UI
        tableListHistoryPostPaidBill.style.position = "absolute";
        tableListHistoryPostPaidBill.style.top = "-9999px";
        tableListHistoryPostPaidBill.style.left = "-9999px";
        tableListHistoryPostPaidBill.style.visibility = "hidden";

        document.body.appendChild(tableListHistoryPostPaidBill);

        // Create header
        const thead = document.createElement("thead");
        const headerRow = document.createElement("tr");

        columnTitles.forEach(title => {
            const th = document.createElement("th");
            th.textContent = title;
            headerRow.appendChild(th);
        });

        thead.appendChild(headerRow);
        tableListHistoryPostPaidBill.appendChild(thead);
        tableListHistoryPostPaidBill.appendChild(document.createElement("tbody"));
    }

    const body = {
        action: "pay_debit",
        orderId: $('#orderId').val().trim(),
        contractId: $('#contractId').val(),
        from: $('#from').val(),
        to: $('#to').val(),
        page: index,
        pageSize: pageSize,
        userId: userId
    };

    StartProcess();

    const r = jsRoutes.controllers.TelcoUtilitiesController.getHistoryPayPostBill();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json",
        success: function (res) {
            const data = res?.content?.data?.data || [];
            const tbody = tableListHistoryPostPaidBill.querySelector("tbody");
            total = res?.content?.data.total;
            data.forEach((item, i) => {
                const row = document.createElement("tr");

                const startAt = (index - 1) * pageSize;
                row.innerHTML = `
                    <th>${startAt + i + 1}</th>
                    <td class='wrap-text'>${item.orderId}</td>
                    <td class='wrap-text'>${item.contractId}</td>
                    <td class='wrap-text'>${item.fee}</td>
                    <td class='wrap-text'>${item.status == "0" ? Messages("success") : Messages("history.postpaid.js.status.failed")}</td>
                    <td class='wrap-text'>${item.status != "0" ? item.description : ""}</td>
                    <td class='wrap-text'>${moment.utc(item.issueDatetime).format("DD/MM/YYYY HH:mm")}</td>
                `;
                tbody.appendChild(row);
            });

            totalRecordExport += data.length;

            if (data.length === pageSize && totalRecordExport < total) {
                exportHistoryPostPaidBillToExcel(index + 1);
            } else {
                outExcelListHistoryPostPaidBill(Messages("history.postpaid.title"));
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.error(xhr);
            showNotification('danger', Messages("history.postpaid.js.export.error"));
            FinishProcess();
        }
    });
}

function outExcelListHistoryPostPaidBill(name) {
    const table = document.getElementById(idExportTable);
    if (table.rows.length <= 1) {
        showNotification('warning', Messages("history.postpaid.js.no.export.data"));
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
        showNotification('danger', Messages("history.postpaid.js.excel.export.error"));
    } finally {
        $('#' + idExportTable).remove();
    }
}
