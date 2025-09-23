function getInfoOrderId() {
    const pathParts = window.location.pathname.split('/');
    const isdn = pathParts[4];
    const orderId = pathParts[5];
    const body = {
        offset: 0,
        userId: userId,
        isdn: isdn,
        orderId: orderId,
        limit: 100,
        action_code: "pre_paid"
    };

    StartProcess();

    const r = jsRoutes.controllers.TelcoUtilitiesController.getListOrderIdByAction();

    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (response) {
            if (response && response.content && Array.isArray(response.content.data) && response.content.data[0]) {
                const item = response.content?.data?.[0];
                if (!item) return;

                const data = item.pre_paid_data;
                let text_prom_value = "";
                let displayPromMonth = parseInt(data.display_prom_month);
                let promPercent = parseInt(data.prom_percent);

                if (displayPromMonth || promPercent) {
                    if (displayPromMonth ) {
                        text_prom_value += `${Messages("prepayCharges.bonus")} ${displayPromMonth} ${Messages("prepayCharges.months")}`;
                    }
                    if (displayPromMonth && promPercent) {
                        text_prom_value += " + ";
                    }
                    if (promPercent) {
                        text_prom_value += `${Messages("prepayCharges.promotion")} ${promPercent}%`;
                    }
                }
                // Fill data vào các trường
                $("#isdn").val(data.isdn);
                $("#product_code").val(data.product_code); // Gói cước
                $("#promotion_code").val(data.promotion_code); // Mã CTKM
                $("#prom_month").val(data.prom_month + " " + Messages("prepayCharges.js.month"));

                $("#prom_value").val(text_prom_value);
                $("#amount").val(data.amount.toLocaleString('vi-VN') + " VNĐ");
                if (item.state === "done:0") {
                    $("#state").val(Messages("prepayCharges.js.success")).removeClass("text-danger").addClass("text-success");
                } else {
                    $("#state").val(Messages("prepayCharges.js.failed")).removeClass("text-success").addClass("text-danger");
                }
                $("#description").val(item.message === "success" ? "" : Messages("prepayCharges.js.paymentFailed"));
                $("#execute_time").val(formatUnixTime(item.execute_time));
                FinishProcess();
            } else {
                showNotification('danger', Messages("connection.failed"));
                FinishProcess();
            }

        }
    });
}

// Chuyển Unix timestamp → dd/MM/yyyy HH:mm:ss
function formatUnixTime(unixTimestamp) {
    const date = new Date(unixTimestamp * 1000);
    const pad = n => n.toString().padStart(2, '0');
    return `${pad(date.getHours())}:${pad(date.getMinutes())}:${pad(date.getSeconds())} ${pad(date.getDate())}/${pad(date.getMonth() + 1)}/${date.getFullYear()}`;
}

getInfoOrderId();
