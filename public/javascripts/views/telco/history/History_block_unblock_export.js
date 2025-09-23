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
            Messages("history.blockunblock.subscriber.number"),
            Messages("history.blockunblock.action"),
            Messages("history.blockunblock.result"),
            Messages("history.blockunblock.reason"),
            Messages("history.blockunblock.time"), 
        ];

        // Clear old table if exists
        if (tableListHistoryDeposits) tableListHistoryDeposits.remove();

        tableListHistoryDeposits = document.createElement("table");
        tableListHistoryDeposits.className = "table";
        tableListHistoryDeposits.id = idExportTable;

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

    let actionCode = $('#action').val();
    let body = {
        action: actionCode || "06,07,08,09",
        isdn: $('#isdn').val().trim(),
        from: $('#from').val(),
        to: $('#to').val(),
        page: $("#page").val(),
        pageSize: $("#pageSize").val(),
        userId
    };

    StartProcess();

    const r = jsRoutes.controllers.TelcoUtilitiesController.getHistoryBlockUnblock();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json",
        success: function (res) {
            const data = res?.content?.data.data || [];
            const tbody = tableListHistoryDeposits.querySelector("tbody");

            data?.forEach((item, i) => {
                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${((index - 1) * pageSize) + i + 1}</td>
                    <td class='wrap-text'>${item.isdn}</td>
                    <td class='wrap-text'>${getActionLabel(item.actionCode)}</td>
                    <td class='wrap-text'>${item.status == 0 ? Messages("success") : Messages("history.blockunblock.js.status.failed")}</td>
                    <td class='wrap-text'>${item.description}</td>
                    <td class='wrap-text'>${moment.utc(item.issueDatetime).format("DD/MM/YYYY HH:mm")}</td>
                `;
                tbody.appendChild(row);
            });

            totalRecordExport += data.length;

            if (data.length === pageSize && totalRecordExport < 10000) {
                exportHistoryDepositsToExcel(index + 1);
            } else {
                outExcelListHistoryDeposits(Messages("history.blockunblock.title"));
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.error(xhr);
            showNotification('danger', Messages("history.blockunblock.js.export.error"));
            FinishProcess();
        }
    });
}

function outExcelListHistoryDeposits(name) {
    const table = document.getElementById(idExportTable);
    if (table.rows.length <= 1) {
        showNotification('warning', Messages("history.blockunblock.js.no.export.data"));
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
        showNotification('danger', Messages("history.blockunblock.js.excel.export.error"));
    } finally {
        $('#' + idExportTable).remove();
    }
}
