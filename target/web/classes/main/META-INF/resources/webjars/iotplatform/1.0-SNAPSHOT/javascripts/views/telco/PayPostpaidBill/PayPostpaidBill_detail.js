async function getInfoOrderId() {
  const pathParts = window.location.pathname.split("/");
  const orderId = pathParts[5];
  const body = {
    offset: 0,
    userId: userId,
    orderId: orderId,
    limit: 100,
    action_code: "pay_debit",
  };
 
  StartProcess();

  const r =
    jsRoutes.controllers.TelcoUtilitiesController.getListOrderIdByAction();

  $.ajax({
    type: r.type,
    data: JSON.stringify(body),
    contentType: "application/json; charset=utf-8",
    url: r.url,
    success: async function (response) {
      if (
        response &&
        response.content &&
        Array.isArray(response.content.data) &&
        response.content.data[0]
      ) {
        const item = response.content?.data?.[0];
        if (!item) return;
        let dataContract = await checkInfoDetailContract(item.isdn_number);// gọi api để lấy Tổng nợ cước
        
        // Fill data vào các trường
        $("#contractNumber").val(item.isdn_number);
        $("#total_debt").val(formatCurrency(dataContract?.remainAmount, " VND")); //chưa có
        $("#payment_amount").val(formatCurrency(item.trans_amount, " VNĐ"));

        if (item.state === "done:0") {
          $("#state")
            .val(Messages("payPostpaidBill.js.statusSuccess"))
            .removeClass("text-danger")
            .addClass("text-success");
            $("#description").val("");
        } else {
          $("#state")
            .val(Messages("payPostpaidBill.js.statusFailed"))
            .removeClass("text-success")
            .addClass("text-danger");
          $("#description").val(item.message);
        }

        $("#execute_time").val(formatUnixTime(item.execute_time));
        FinishProcess();
      } else {
        showNotification("danger", Messages("connection.failed"));
        FinishProcess();
      }
    },
  });
}

// Chuyển Unix timestamp → dd/MM/yyyy HH:mm:ss
function formatUnixTime(unixTimestamp) {
  const date = new Date(unixTimestamp * 1000);
  const pad = (n) => n.toString().padStart(2, "0");
  return `${pad(date.getHours())}:${pad(date.getMinutes())}:${pad(
    date.getSeconds()
  )} ${pad(date.getDate())}/${pad(date.getMonth() + 1)}/${date.getFullYear()}`;
}

getInfoOrderId();
