var id_no = null;
var pay_type = null;
var contract_id = null;
var product_code = null;
var promotion_code = null;
var orderId = null;
  const phoneInput = document.getElementById("isdn");

  function cleanPhoneInput(value) {
    return value.replace(/[^\d]/g, "").slice(0, 11);
  }

  // Bắt cả sự kiện gõ và dán
  phoneInput.addEventListener("input", function () {
    this.value = cleanPhoneInput(this.value);
  });

  phoneInput.addEventListener("paste", function (e) {
    e.preventDefault();
    const pasted = (e.clipboardData || window.clipboardData).getData("text");
    this.value = cleanPhoneInput(pasted);
  });
  phoneInput.addEventListener("keypress", function (event) {
    // If the user presses the "Enter" key on the keyboard
    if (event.key === "Enter") {
      searchData();
    }
  });
  const nomoralizePhoneNumber = (phoneNumber) => {
    if (phoneNumber.startsWith("0")) {
      return phoneNumber.slice(1);
    }
    if (phoneNumber.startsWith("84")) {
      return phoneNumber.slice(2);
    }
    return phoneNumber;
  };
function searchData() {
    let phoneNumber = $("#isdn").val()?.trim();
    if (!phoneNumber) {
        showNotification("danger", Messages("prepayCharges.js.enterPostpaidNumber"));
        return false;
    }
    phoneNumber = nomoralizePhoneNumber(phoneNumber);

    let body = {
        userId: userId,
        limit: 20,
        offset: 0,
        isdn: phoneNumber
    };

    const request = jsRoutes.controllers.TelcoSubscriberController.getListSubsByBeVht();

    StartProcess();

    $.ajax({
        type: request.type,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(body),
        url: request.url,
        success: function (res) {
            if (res && res.content && Array.isArray(res.content.data) && res.content.data[0]) {
                $("#btn_pay").prop("disabled", false);
                
                let infoIsdn = res.content.data[0];
                if (infoIsdn.payType == 2) {
                    FinishProcess();
                    showNotification('danger', Messages("prepayCharges.js.invalidPostpaidNumber"));
                    return false;
                }
                var {
                    idNo,
                    productCode,
                    promotionCode,
                    payType,
                    accountId,
                } = infoIsdn;
                getDataPrepaidInfo(productCode, promotionCode);
                id_no = idNo;
                pay_type =payType;
                contract_id = accountId;
                product_code = productCode;
                promotion_code = promotionCode;
            } else {
                showNotification('danger', Messages("prepayCharges.js.invalidSubscriber"));
                resetFormData();
                FinishProcess();
            }
            
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        }
    });
}

function getDataPrepaidInfo(productCode, promotionCode) {
    const request = jsRoutes.controllers.TelcoUtilitiesController.getDataPrepaidInfo(promotionCode, productCode);
    $.ajax({
        type: request.type,
        contentType: "application/json; charset=utf-8",
        url: request.url,
        success: function (res) {
            if (res && res.content && Array.isArray(res.content.data) && res.content.data.length > 0) {
                renderPrepayOptions(res.content.data, productCode, promotionCode);
            } else {
                showNotification('danger', Messages("prepayCharges.js.noPromotionProgram"));
                resetFormData();                
                FinishProcess(); 
            }
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        }
    });
}

function renderPrepayOptions(data, productCode, promotionCode) {
    $("#prepayCharges_no_data").addClass("d-none").text("");
    $("#form_info").removeClass("d-none");

    $("#phoneNumber").val($("#isdn").val());
    $("#productCode").val(productCode);
    $("#promotionCode").val(promotionCode);
    $("#prepayOptions").empty();

    data.forEach((item, index) => {
        let { displayPromMonth = 0, prepaidCode } = item;
        let { numMonth = 0, promValue = 0, promPercent = 0 } = item.data[0] || {};
        let price = numMonth * promValue;
        if (index === 0) {
          $("#total").text(formatVND(price));
        }
        let option = `
            <div class="col-lg-6 mb-3">
                <label class="box-option ${index === 0 ? 'active' : ''}">
                    <input type="radio" name="prepayOption" value="${price}" ${index === 0 ? 'checked' : ''} hidden>
                    <input type="hidden" name="numMonth" value="${numMonth}">
                    <input type="hidden" name="promValue" value="${promValue}">
                    <input type="hidden" name="promPercent" value="${promPercent}">
                    <input type="hidden" name="prepaidCode" value="${prepaidCode}">
                    <input type="hidden" name="displayPromMonth" value="${displayPromMonth}">
                    <div class="box-title">
                        <span>${numMonth} ${Messages("prepayCharges.months")} - ${formatVND(price)}</span>
                    </div>
                    ${(displayPromMonth || promPercent) ? `
                        <div class="box-promotion">
                            ${displayPromMonth ? `${Messages("prepayCharges.bonus")} ${displayPromMonth} ${Messages("prepayCharges.months")}` : ''}
                            ${(displayPromMonth && promPercent) ? ' + ' : ''}
                            ${promPercent ? `${Messages("prepayCharges.promotion")} ${promPercent}%` : ''}
                        </div>` : ''}
                </label>
            </div>
        `;

        $("#prepayOptions").append(option);
    });

    FinishProcess();
}


function resetFormData() {
    $("#phoneNumber").val("");
    $("#productCode").val("");
    $("#prepayOptions").empty();
    $("#total").text("0");
    $("#btn_pay").prop("disabled", true);
    $("#form_info").addClass("d-none");
    $("#prepayCharges_no_data").removeClass("d-none").text(Messages("prepayCharges.noData"));
}

function showErrorMessage(message) {
    $("#prepayCharges_no_data").removeClass("d-none").text(message);
    $("#form_info").addClass("d-none");
}

function formatVND(amount) {
    amount = Number(amount) || 0;
    return amount.toLocaleString('vi-VN') + ' đ';
}

// Sử dụng event delegation để xử lý các phần tử được tạo động
$('#prepayOptions').on('click', '.box-option', function () {
    $('.box-option').removeClass('active');
    $(this).addClass('active');
    $(this).find('input[type="radio"]').prop('checked', true);
    let price = $(this).find('input[type="radio"]').val();
    $("#total").text(formatVND(price));
});

// Mở modal xác nhận khi nhấn nút thanh toán
$('#btn_pay').on('click', function () {
    const phone = $("#isdn").val()?.trim();
    const $activeOption = $("#prepayOptions .box-option.active");
    const numMonth = $activeOption.find("input[name='numMonth']").val();

    $("#numMonth_val").text(numMonth);
    $("#phoneNumber_val").text(phone);
    $("#modalPrepayConfirm").modal('show');
});
// Xác nhận
$("#btnPrepayConfirm").on('click', function () {
    $('#modalPrepayConfirm').modal('hide');
    const phone = $("#isdn").val()?.trim();
    const $activeOption = $("#prepayOptions .box-option.active");

    const numMonth = $activeOption.find("input[name='numMonth']").val();
    const promValue = $activeOption.find("input[name='promValue']").val();
    const promPercent = $activeOption.find("input[name='promPercent']").val();
    const displayPromMonth = $activeOption.find("input[name='displayPromMonth']").val();
    const prepaidCode = $activeOption.find("input[name='prepaidCode']").val();
    const amount = parseFloat(numMonth) * parseFloat(promValue);

    const data = {
        reason: "Dong cuoc truoc",
        user_id: userId,
        list_pre_paid: [
            {
                isdn: phone,
                id_no,
                product_code,
                promotion_code,
                pay_type,
                contract_id,
                pre_paid_code: prepaidCode,
                amount: Number(amount),
                prom_month: numMonth,
                prom_percent: promPercent,
                prom_value: promValue,
                display_prom_month: displayPromMonth
            }
        ]
    };
    const request = jsRoutes.controllers.TelcoUtilitiesController.rechargePrepaid();

    StartProcess();

    $.ajax({
        type: request.type,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        url: request.url,
        success: function (res) {
            if (res?.content?.data) {
                let {link_check_out, order_id} = res.content.data;
                    orderId = order_id
                 window.open(link_check_out, "_blank");
                  $("#comfirmRechargeSubsModal").modal('show');
            } else {
                showNotification('danger',Messages("prepayCharges.js.paymentLinkFailed"));
            }
        },
        error: function () {
            showNotification('danger', Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            FinishProcess();
        }
    });
});

function showBill() {
    let isdn = $("#isdn").val()?.trim();
    if (!orderId) {
         showNotification("danger", Messages("prepayCharges.js.orderIdFailed"));
    }
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
                setTimeout(function () {
                    $("#comfirmRechargeSubsModal").modal('hide');
                    window.open(jsRoutes.controllers.TelcoUtilitiesController.prepayChargesBill(userId, isdn, orderId).url);
                    FinishProcess();
                }, 4000);
                
            } else {
                FinishProcess();
                showNotification('danger', Messages("prepayCharges.js.prepayFailed"));
            }

        }
    });
}

function resetData() {
    $("#isdn").val("");
    resetFormData();   
}