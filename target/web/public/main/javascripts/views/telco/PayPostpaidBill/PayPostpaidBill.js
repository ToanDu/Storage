var statusContract = 0; //Trạng thái hợp đồng
var orderId = null;
$(document).on('keydown', function (e) {
    if (e.key === "Enter") {
        e.preventDefault();
        searchData();
    }
});

async function searchData() {
  let contractId = $("#contractId").val().trim();
  $('#paymentAmount').val("");
  $('.clear-btn').hide();
  $('#total').text(Messages("payPostpaidBill.js.zeroAmount"));
  $("#btn_confirm_payment").addClass("disabled");
  // validate input
  if (contractId === "") {
    showNotification("danger", Messages("payPostpaidBill.js.enterContractCode"));
    return;
  }
  let dataContract = await checkStatusContract(contractId);
  statusContract = dataContract?.status;
  isdn = dataContract?.isdn;
console.log(statusContract);

  if (statusContract) {
    checkInfoDetailContract(contractId);
  } else {
    showErrorMessage(Messages("payPostpaidBill.js.contractNotFound"));
  }
}

/**
 * Hàm Kiểm tra trạng thái hợp đồng và kiểm tra hợp đồng đó có thuộc về người dùng hiện tại
 * @param {Ha} contractId
 */
async function checkStatusContract(contractId) {
  let body = {
    userId: userId,
    accountId: contractId,
    page: 1,
    pageSize: 10,
  };
  StartProcess();
  let r = jsRoutes.controllers.TelcoContractController.getListAccountContract();
  try {
    let data = await $.ajax({
      type: r.type,
      data: JSON.stringify(body),
      contentType: "application/json; charset=utf-8",
      url: r.url,
    });
    if (
      data?.content?.listAccountDTO &&
      data.content.listAccountDTO.length > 0
    ) {
      return data.content.listAccountDTO[0];
    } else {
      return null;
    }
  } finally {
    FinishProcess();
  }
}

/**
 * Hàm kiểm tra thông tin chi tiết hợp đồng
 * @param {string} contractId
 */
async function checkInfoDetailContract(contractId) {
  let body = { contractIds: contractId };
  StartProcess();
  let r = jsRoutes.controllers.TelcoContractController.getDebitContract();
  try {
    let data = await $.ajax({
      type: r.type,
      data: JSON.stringify(body),
      contentType: "application/json; charset=utf-8",
      url: r.url,
    });
    if (data?.content?.data && data.content.data.length > 0) {
      showFormContent(contractId, data.content.data[0].remainAmount);
      return data.content.data[0];
    } else {
      showErrorMessage(Messages("payPostpaidBill.js.contractNotFound"));
    }
  } finally {
    FinishProcess();
  }
}

function resetData() {
  $("#contractId").val("");
  showErrorMessage(Messages("payPostpaidBill.js.noData")); //Mặc định
  statusContract = 0;
  orderId = null;
}

/**
 * Hiển thị nội dung form thanh toán cước
 * @param {*} contractNumber - Số hợp đồng
 * @param {*} totalDebt - Tổng nợ cước
 * @return {void}
 */
function showFormContent(contractNumber, totalDebt) {
  $("#pay_postpai_FormContent").removeClass("d-none");
  $("#pay_postpai_notice").addClass("d-none");

  $("#contractNumber").val(contractNumber);
  $("#totalDebt").val(formatCurrency(totalDebt, " VND"));
}

/**
 * Hàm định dạng tiền tệ
 * @param {*} value
 * @returns
 */
function formatCurrency(value, currencySymbol = "") {
  if (value === null || value === undefined || value === "") {
    return 0;
  }
  return (
    value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + currencySymbol
  );
}

/**
 * Hiển thị thông báo lỗi ra màn hình
 * @param {*} message
 */
function showErrorMessage(message) {
  $("#pay_postpai_notice").text(message);
  $("#pay_postpai_FormContent").addClass("d-none");
  $("#pay_postpai_notice").removeClass("d-none");
  $("#pay_postpai_Form")[0]?.reset();
}

function formatMoneyInput($input) {
  let value = $input.val().replace(/\./g, "");
  value = value.replace(/\D/g, ""); // chỉ giữ số

  // Nếu tất cả là số 0 => chỉ để lại 1 số 0
  if (/^0+$/.test(value)) {
    value = "0";
  } else {
    // Nếu số bắt đầu bằng 0 và có số khác => bỏ số 0 ở đầu
    value = value.replace(/^0+/, "");
  }

  // Giới hạn 10 chữ số
  if (value.length > 10) {
    value = value.substring(0, 10);
  }

  // Nếu không phải 0 thì format dấu chấm
  if (value !== "0" && value !== "") {
    value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ".");
  }

  $input.val(value);

  // hiển thị tổng thanh toán
  let totalValue = parseInt($input.val().replace(/\./g, ""), 10);
  $("#total").text(formatCurrency(isNaN(totalValue) ? 0 : totalValue, " đ"));
}

// Khi gõ vào input
$("#paymentAmount").on("input", function () {
  formatMoneyInput($(this));
  // Hiện hoặc ẩn nút X
  if ($(this).val()) {
    $(this).siblings(".clear-btn").show();
    $("#btn_confirm_payment").removeClass("disabled");
  } else {
    $("#btn_confirm_payment").addClass("disabled");
    $(this).siblings(".clear-btn").hide();
  }
});

// Khi bấm nút X
$(".clear-btn").on("click", function () {
  $("#btn_confirm_payment").addClass("disabled");
  let $input = $(this).siblings("input");
  $input.val("");
  $(this).hide();
});

$("#btn_confirm_payment").on("click", function () {
  let paymentAmount = $("#paymentAmount").val().trim();
  let contractId = $("#contractId").val().trim();
  let totalDebt = $("#totalDebt").val().trim();

  // Chuyển đổi giá trị để so sánh
  let paymentValue = parseInt(paymentAmount.replace(/\./g, ""), 10);
  let totalDebtValue = parseInt(totalDebt.replace(/[^\d]/g, ""), 10); // Loại bỏ " VND" và dấu chấm

  // Kiểm tra validation cơ bản
  if (isNaN(paymentValue) || paymentValue <= 0) {
    showNotification("danger", Messages("payPostpaidBill.js.enterPaymentAmount"));
    return;
  }

  // Kiểm tra theo trạng thái hợp đồng
  let isCanceled = statusContract == 3;
  let isOverPayment = paymentValue > totalDebtValue;

  if (isCanceled && isOverPayment) {
    showNotification(
      "danger",
      Messages("payPostpaidBill.js.cannotPayMoreThanDebt")
    );
    return;
  }

  // Hiển thị popup xác nhận
  $("#confirm_payment_amount").text(`${paymentAmount} VND`);
  $("#confirm_payment_contract").text(contractId);
  $("#modalpay_confirm_payment").modal("show");
});

// Xác nhận thanh toán

$("#btnpay_confirm_payment").on("click", function () {
  $("#modalpay_confirm_payment").modal("hide");
  let contractId = $("#contractId").val().trim();
  let paymentAmount = $("#paymentAmount").val().trim();
  let paymentValue = parseInt(paymentAmount.replace(/\./g, ""), 10);

  let data = {
    reason: Messages("payPostpaidBill.js.paymentReason"),
    user_id: userId,
    contracts: [
      {
        contract_id: contractId,
        amount: paymentValue,
      },
    ],
  };
  let request = jsRoutes.controllers.TelcoUtilitiesController.payDebit();

  StartProcess();

  $.ajax({
    type: request.type,
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(data),
    url: request.url,
    success: function (res) {
      if (res?.content?.data) {
        let { link_check_out, order_id } = res.content.data;
        orderId = order_id;
        window.open(link_check_out, "_blank");
        $("#comfirmRechargeModal").modal("show");
      } else {
        showNotification(
          "danger",
          Messages("payPostpaidBill.js.paymentLinkFailed")
        );
      }
    },
    error: function () {
      showNotification("danger", Messages("connection.failed"));
      FinishProcess();
    },
    complete: function () {
      FinishProcess();
    },
  });
});

function showBill() {
  if (!isdn) {
    showNotification("danger", Messages("payPostpaidBill.js.cannotGetIsdn"));
    return false;
  }
  if (!orderId) {
    showNotification("danger", Messages("payPostpaidBill.js.cannotGetOrderId"));
  }
  let body = {
    offset: 0,
    userId: userId,
    orderId: orderId,
    limit: 100,
    action_code: "pay_debit",
  };
  StartProcess();
  let r =
    jsRoutes.controllers.TelcoUtilitiesController.getListOrderIdByAction();
  $.ajax({
    type: r.type,
    data: JSON.stringify(body),
    contentType: "application/json; charset=utf-8",
    url: r.url,
    success: function (response) {
      if (
        response &&
        response.content &&
        Array.isArray(response.content.data) &&
        response.content.data[0]
      ) {
        setTimeout(function () {
            $("#comfirmRechargeModal").modal('hide');
            window.open(jsRoutes.controllers.TelcoUtilitiesController.payPostpaidBillDetail(userId, orderId).url);
            FinishProcess();
        }, 2000);
      } else {
        FinishProcess();
        showNotification("danger", Messages("payPostpaidBill.js.paymentFailed"));
      }
    },
  });
}
