const idExportTable = 'TableListHistoryPrepayCharges';
let tableListHistoryPrepayCharges;
let totalRecordExport = 0;
let columnTitles = [];

function onlickButtonExport() {
    exportHistoryPrepayChargesToExcel(1);
}

function exportHistoryPrepayChargesToExcel(index) {
    let pageSize = parseInt($("#pageSize").val(), 10);
    if (index === 1) {
        totalRecordExport = 0;
        columnTitles = [
            Messages("manage.stt"),
            Messages("history.prepay.table.transaction.code"),
            Messages("history.prepay.table.subscriber.number"),
            Messages("history.miaddon.table.package"),
            Messages("history.prepay.table.promotion"),
            Messages("history.prepay.table.months"),
            Messages("history.prepay.table.bonus"),
            Messages("history.prepay.table.amount"),
            Messages("filter.status"),
            Messages("history.prepay.table.description"),
            Messages("history.miaddon.table.time")
        ];

        // Clear old table if exists
        if (tableListHistoryPrepayCharges) tableListHistoryPrepayCharges.remove();

        tableListHistoryPrepayCharges = document.createElement("table");
        tableListHistoryPrepayCharges.className = "table";
        tableListHistoryPrepayCharges.id = idExportTable;
        // Ẩn hoàn toàn bảng khỏi UI
        tableListHistoryPrepayCharges.style.position = "absolute";
        tableListHistoryPrepayCharges.style.top = "-9999px";
        tableListHistoryPrepayCharges.style.left = "-9999px";
        tableListHistoryPrepayCharges.style.visibility = "hidden";

        document.body.appendChild(tableListHistoryPrepayCharges);

        // Create header
        const thead = document.createElement("thead");
        const headerRow = document.createElement("tr");

        columnTitles.forEach(title => {
            const th = document.createElement("th");
            th.textContent = title;
            headerRow.appendChild(th);
        });

        thead.appendChild(headerRow);
        tableListHistoryPrepayCharges.appendChild(thead);
        tableListHistoryPrepayCharges.appendChild(document.createElement("tbody"));
    }

    const body = {
        action: "pre_paid",
        orderId: $('#orderId').val().trim(),
        isdn: $('#isdn').val().trim(),
        from: $('#from').val().trim(),
        to: $('#to').val().trim(),
        page: index,
        pageSize: pageSize,
        userId: userId
    };

    StartProcess();

    const r = jsRoutes.controllers.TelcoUtilitiesController.getHistoryPrepayCharges();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            let data = res?.content?.data.data || [];
            let tbody = tableListHistoryPrepayCharges.querySelector("tbody");
            total = res?.content?.data.total;
            
            data.forEach((item, i) => {

                let requestBody = item.requestBody;
                let state = item.status == "1" ? false : true;
                let text_prom_value = "";
                let displayPromMonth = parseInt(requestBody.display_prom_month);
                //console.log(requestBody.prom_percent)
                let promPercent = parseInt(requestBody.prom_percent);
                if (displayPromMonth || promPercent) {
                    if (displayPromMonth) {
                        text_prom_value += `${Messages("history.prepay.js.bonus")} ${displayPromMonth} ${Messages("history.prepay.js.months")}`;
                    }
                    if (displayPromMonth && promPercent) {
                        text_prom_value += " + ";
                    }
                    if (promPercent) {
                        text_prom_value += requestBody.prom_percent;
                    }
                }

                let row = document.createElement("tr");

                row.innerHTML = `
                    <td>${((index - 1) * pageSize) + i + 1}</td>
                    <td class='wrap-text'>${item.orderId}</td>
                    <td class='wrap-text'>${item.isdn}</td>
                    <td class='wrap-text'>${requestBody.product_code?requestBody.product_code:""}</td>
                    <td class='wrap-text'>${requestBody.promotion_code?requestBody.promotion_code:""}</td>
                    <td class='wrap-text'>${requestBody.prom_month?requestBody.prom_month:""}</td>
                    <td class='wrap-text'>${text_prom_value ? text_prom_value : ""}</td>
                    <td class='wrap-text'>${item.fee}</td>
                    <td class='wrap-text ${!state && 'text-danger'}'>${state ? Messages("success") : Messages("history.prepay.js.status.failed")}</td>
                    <td class='wrap-text ${!state && 'text-danger'}'>${item.status == "1" ? item.description : ""}</td>
                    <td class='wrap-text'>${moment(item.issueDatetime).utc().format("DD/MM/YYYY HH:mm")}</td>
                `;
                tbody.appendChild(row);
            });

            console.log(tbody);
            
            totalRecordExport += data.length;
            if (data.length === pageSize && totalRecordExport < total) {
                exportHistoryPrepayChargesToExcel(index + 1);
            } else {
                outExcelListHistoryPrepayCharges(Messages("history.prepay.title"));
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.error(xhr);
            showNotification('danger', Messages("history.prepay.js.export.error"));
            FinishProcess();
        }
    });
    console.log("Exporting page:", tableListHistoryPrepayCharges);
}

function outExcelListHistoryPrepayCharges(name) {
    const table = document.getElementById(idExportTable);
    if (table.rows.length <= 1) {
        showNotification('warning', Messages("history.prepay.js.no.data.display"));
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
        $('#' + idExportTable).remove();
    }
}
