const idExportTable = 'TableListHistoryDeposits';
const pageSize = 1000;
let tableListHistoryDeposits;
let totalRecordExport = 0;
let columnTitles = [];

function onlickButtonExport() {
    exportHistoryDepositsToExcel(1);
}

function exportHistoryDepositsToExcel(index) {
    if (index === 1) {
        totalRecordExport = 0;
        columnTitles = [
            Messages("manage.stt"),
            Messages("history.deposit.order.id"),
            Messages("history.deposit.subscriber.number"),
            Messages("history.deposit.action"),
            Messages("history.deposit.amount"),
            Messages("history.deposit.total.amount"), 
            Messages("history.deposit.status"),
            Messages("history.deposit.description"),
            Messages("history.deposit.time")
        ];

        // Clear old table if exists
        if (tableListHistoryDeposits) tableListHistoryDeposits.remove();

        tableListHistoryDeposits = document.createElement("table");
        tableListHistoryDeposits.className = "table";
        tableListHistoryDeposits.id = idExportTable;
        // Ẩn hoàn toàn bảng khỏi UI
        tableListHistoryDeposits.style.position = "absolute";
        tableListHistoryDeposits.style.top = "-9999px";
        tableListHistoryDeposits.style.left = "-9999px";
        tableListHistoryDeposits.style.visibility = "hidden";

        document.body.appendChild(tableListHistoryDeposits);

        // Create header
        const thead = document.createElement("thead");
        const headerRow = document.createElement("tr");

        columnTitles.forEach(title => {
            const th = document.createElement("th");
            th.textContent = title;
            headerRow.appendChild(th);
        });

        thead.appendChild(headerRow);
        tableListHistoryDeposits.appendChild(thead);
        tableListHistoryDeposits.appendChild(document.createElement("tbody"));
    }

    const from = $('#from').val() ? moment($('#from').val(), 'DD-MM-YYYY').format('YYYY-MM-DD') : '';
    const to = $('#to').val() ? moment($('#to').val(), 'DD-MM-YYYY').format('YYYY-MM-DD') : '';

    const body = {
        action: "10",
        orderId: $('#orderId').val().trim(),
        isdn: $('#isdn').val(),
        from: $('#from').val(),
        to: $('#to').val(),
        page: $("#page").val(),
        pageSize: $("#pageSize").val(),
        userId: userId
    };

    StartProcess();

    const r = jsRoutes.controllers.TelcoUtilitiesController.getListOrderIdByAction();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json",
        success: function (res) {
            const data = res?.content?.data || [];
            const tbody = tableListHistoryDeposits.querySelector("tbody");

            data.forEach((item, i) => {
                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${((index - 1) * pageSize) + i + 1}</td>
                    <td class='wrap-text'>${item.order_id}</td>
                    <td class='wrap-text'>${item.isdn_number}</td>
                    <td class='wrap-text'>${Messages("history.deposit.js.action.recharge")}</td>
                    <td class='wrap-text'>${item.units_amount}</td>
                    <td class='wrap-text'>${item.trans_amount}</td>
                    <td class='wrap-text'>${item.state == "done:00" ? Messages("success") : Messages("history.deposit.js.status.failed")}</td>
                    <td class='wrap-text'>${item.message}</td>
                    <td class='wrap-text'>${moment.unix(item.created_time).format("DD/MM/YYYY HH:mm")}</td>
                `;
                tbody.appendChild(row);
            });

            totalRecordExport += data.length;

            if (data.length === pageSize && totalRecordExport < 10000) {
                exportHistoryDepositsToExcel(index + 1);
            } else {
                outExcelListHistoryDeposits(Messages("history.deposit.title"));
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.error(xhr);
            showNotification('danger', Messages("history.deposit.js.export.error"));
            FinishProcess();
        }
    });
}

function outExcelListHistoryDeposits(name) {
    const table = document.getElementById(idExportTable);
    if (table.rows.length <= 1) {
        showNotification('warning', Messages("history.deposit.js.no.export.data"));
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
        showNotification('danger', Messages("history.deposit.js.excel.export.error"));
    } finally {
        $('#' + idExportTable).remove();
    }
}
