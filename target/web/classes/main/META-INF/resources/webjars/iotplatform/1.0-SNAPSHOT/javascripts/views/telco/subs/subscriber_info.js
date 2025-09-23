/**
 * Created by vtk-anhlt166 on 11/14/22.
 */

// Thêm event listener cho modal khi nó được mở
$(document).ready(function() {
  // Cập nhật event listener cho dataUnitSelect
  $('#dataUnitSelect').on('change', function() {
    convertUnit('dataBalanceInfo', this);
  });
});

async function showInfoSubscriber(isdn, promotionCode, serial, payType, actStatus, staDatetime, activeDatetime, productCode) {
    await getAPNByIsdn(isdn);
    console.log('%c showInfoSubscriber - isdn: ' + isdn, 'background: #222; color: #bada55');
    // console.log(isdn);
    $("#infoSubscriber").modal('show');
    syncAllUnits(currentGlobalUnit);
    $("#isdnInfo").val(isdn).attr('title', isdn);
    $("#serialInfo").val(serial).attr('title', serial);
    $("#payTypeInfo").val(getPayTypeByCode(payType)).attr('title', getPayTypeByCode(payType));
    $("#actStatusInfo").val(getStatusByCode(actStatus, payType)).attr('title', getStatusByCode(actStatus, payType));
    $("#staDatetimeInfo").val(staDatetime.length > 0 ? moment(moment(staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "").attr('title', staDatetime.length > 0 ? moment(moment(staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "");
    $("#activeDatetimeInfo").val(activeDatetime.length > 0 ? moment(moment(activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "").attr('title', activeDatetime.length > 0 ? moment(moment(activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "");
    $("#productCodeSubs").val(productCode).attr('title', productCode);

    getHybridInfo(isdn);

    getCtkm(promotionCode);

    getBalanceInfo(isdn, payType);

    getDebitSubscriber(isdn);

    getKttkAndKtmi(isdn);
}

const getAPNByIsdn = async (isdn) => {
  let body = new FormData();
  body.user_id = userId;
  body.isdns = [isdn];

  StartProcess();
  let r = jsRoutes.controllers.TelcoAPNController.getAPNByPhone();
  return await $.ajax({
    type: r.type,
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(body),
    url: r.url,
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          const { apn_default, apns } = data.content.data[0];
          $("input[id=apnDefault]")
            .val(apn_default ? Messages("subscriber.info.yes") : Messages("subscriber.info.no"))
            .attr("title", apn_default);
          if (apns && apns.length > 0) {
            let _apnPrivate = apns.concat(apns).reduce((acc, apn) => {
              if (apn.apn_name && apn.ip) {
                return `${acc ? acc + ";" : acc} ${apn.apn_name}/${
                  (!apn.ip || apn.ip === "-1") ? Messages("subscriber.info.dynamicIP") : apn.ip
                }`;
              }
              return acc;
            }, "");
            $("input[id=apnPrivate]")
            .val(_apnPrivate)
            .attr("title", _apnPrivate);
          }
        } else {
          $("input[id=apnDefault]").val("").attr("title", "");
          $("input[id=apnPrivate]").val("").attr("title", "");
        }
      } catch (error) {
        $("input[id=apnDefault]").val("").attr("title", "");
        $("input[id=apnPrivate]").val("").attr("title", "");
        showNotification("danger", Messages("error.errorServer"));
      }
    },
    error: function (xhr) {
      console.log(xhr);
      $("input[id=apnDefault]").val("").attr("title", "");
      $("input[id=apnPrivate]").val("").attr("title", "");
      showNotification("danger", Messages("error.errorServer"));
      FinishProcess();
    },
    complete: function () {
      FinishProcess();
    },
  });
};

function getHybridInfo(isdn) {
    var body = new FormData();
    body.isdn = isdn;
    // console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getHybridInfo();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log('%c getHybridInfo', 'background: #222; color: #bada55');
            console.log(datas);
            if (datas.success) {
                if (datas.content.hybridBalance != null) {
                    var balance = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.hybridBalance));
                    $("#moneyHybridInfo").val(balance).attr('title', balance);

                    $("#typeInfo").val(Messages("Hybrid")).attr('title', Messages("Hybrid"));
                } else {
                    $("#moneyHybridInfo").val(0).attr('title', Messages("0"));
                    $("#typeInfo").val(Messages("subscriber.info.normal")).attr('title', Messages("subscriber.info.normal"));
                }
            } else {
                $("#moneyHybridInfo").val(0);
            }
        },
        complete: function () {
            // FinishProcess();
        }
    })
}

function getCtkm(promotionCode) {
    var body = new FormData();
    body.promotionCode = promotionCode;
    // console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getCtkm();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log('%c getCtkm', 'background: #222; color: #bada55');
            console.log(datas);
            if (datas.success && datas.content != null) {
                $("#codeCtkm").val(datas.content.code != null ? datas.content.code : "").attr('title', datas.content.code != null ? datas.content.code : "");
                $("#nameCtkm").val(datas.content.name != null ? datas.content.name : "").attr('title', datas.content.name != null ? datas.content.name : "");
                var effectCtkm = (datas.content.effectDatetime != null && datas.content.effectDatetime.length > 0) ? moment(moment(datas.content.effectDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "";
                $("#effectCtkm").val(effectCtkm).attr('title', effectCtkm);
                var expireCtkm = (datas.content.expireDatetime != null && datas.content.expireDatetime.length > 0) ? moment(moment(datas.content.expireDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "";
                $("#expireCtkm").val(expireCtkm).attr('title', expireCtkm);
                $("#descriptionCtkm").val(datas.content.description != null ? datas.content.description : "").attr('title', datas.content.description != null ? datas.content.description : "");

            } else {
                $("#codeCtkm").val("");
                $("#nameCtkm").val("");
                $("#effectCtkm").val("");
                $("#expireCtkm").val("");
                $("#descriptionCtkm").val("");
            }
        },
        complete: function () {
            // FinishProcess();
        }
    })
}

function getBalanceInfo(isdn, payType) {
    var body = new FormData();
    body.isdn = isdn;
    // body.isdn = "862002085";
    body.payType = payType;
    // console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getBalanceInfo();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log('%c getBalanceInfo', 'background: #222; color: #bada55');
            console.log(datas);
            if (datas.success) {
                // $("#codeCtkm").val(datas.content.code != null ? datas.content.code : "").attr('title', datas.content.code != null ? datas.content.code : "");
                //TODO: doi chu thich api
                if (datas.content != null && datas.content.balanceInfo != null) {
                    $("#dataBalanceInfo").val(datas.content.balanceInfo.data != null ? datas.content.balanceInfo.data : 0);
                    $("#smsBalanceInfo").val(datas.content.balanceInfo.sms);
                    // $("#voiceBalanceInfo").val(datas.content.balanceInfo.voice);
                    $("#moneyBalanceInfo").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.balanceInfo.money)));
                    $("#promotionBalanceInfo").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.balanceInfo.promotionMoney)));
                    $("#promotionVtBalanceInfo").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.balanceInfo.promotionVTMoney)));
                    $("#otherBalanceInfo").val(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.balanceInfo.otherMoney)));

                }
            } else {

            }
        },
        complete: function () {
            // FinishProcess(); 
        }
    })
}

function getDebitSubscriber(isdn) {
    var body = new FormData();
    body.isdns = isdn;
    // console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getDebitSubscriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log('%c getDebitSubscriber', 'background: #222; color: #bada55');
            console.log(datas);
            if (datas.success && datas.content != null) {
                if (datas.content.data != null && datas.content.data.length > 0) {
                    var adjustAmountSubs = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].adjustAmount));
                    $("#adjustAmountSubs").val(adjustAmountSubs).attr('title', adjustAmountSubs);

                    var hotChargeSubs = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].hotCharge));
                    $("#hotChargeSubs").val(hotChargeSubs).attr('title', hotChargeSubs);

                    var paymentSubs = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].payment));
                    $("#paymentSubs").val(paymentSubs).attr('title', paymentSubs);

                    var staOfCycleSubs = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].staOfCycle));
                    $("#staOfCycleSubs").val(staOfCycleSubs).attr('title', staOfCycleSubs);

                    var remainAmountSubs = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(datas.content.data[0].remainAmount));
                    $("#remainAmountSubs").val(remainAmountSubs).attr('title', remainAmountSubs);
                } else {
                    $("#adjustAmountSubs").val("");
                    $("#hotChargeSubs").val("");
                    $("#paymentSubs").val("");
                    $("#staOfCycleSubs").val("");
                    $("#remainAmountSubs").val("");
                }
            } else {
                $("#adjustAmountSubs").val("");
                $("#hotChargeSubs").val("");
                $("#paymentSubs").val("");
                $("#staOfCycleSubs").val("");
                $("#remainAmountSubs").val("");
            }
        },
        complete: function () {
            // FinishProcess();
        }
    })
}

/**
 * Gửi yêu cầu lấy thông tin các gói KTTK và KTMI của thuê bao
 * @param {string} isdn - Số điện thoại thuê bao
 */
function getKttkAndKtmi(isdn) {
  // Tạo body truyền vào (dưới dạng object chứ không phải FormData vì dùng JSON)
  var body = {
    isdn: isdn
  };

  // Gọi API thông qua jsRoutes (Play Framework hoặc similar backend)
  var r = jsRoutes.controllers.TelcoSubscriberController.getKttkAndKtmi();

  $.ajax({
    type: r.type,
    data: JSON.stringify(body), // Truyền dữ liệu dạng JSON
    contentType: "application/json; charset=utf-8",
    url: r.url,
    success: function (datas) {
      console.log('%c getKttkAndKtmi', 'background: #222; color: #bada55');
      console.log(datas);

      $('#tableKttkKtmiSubs').find("tbody").html("");

      if (datas.success && datas.content != null) {
        $("#voiceBalanceInfo").val(datas.content.usedBalance ?? 0);

        if (datas.content.infos && datas.content.infos.length > 0) {
          const infos = datas.content.infos;
          const tableBody = $('#tableKttkKtmiSubs').find("tbody");

          infos.forEach((info, i) => {
            // Áp dụng đơn vị đã lưu (currentGlobalUnit) vào dữ liệu mới
            let displayValue = info.remainData;
            if (currentGlobalUnit !== 'MB') {
              // Convert từ MB (mặc định từ API) sang đơn vị đã lưu
              if (currentGlobalUnit === 'KB') {
                displayValue = Math.round(info.remainData * 1024);
              } else if (currentGlobalUnit === 'GB') {
                displayValue = (info.remainData / 1024).toFixed(2);
              }
            }
            
            const uniqueId = `remainData_${i}`;
            const rowHtml = `
              <tr>
                <td>${i + 1}</td>
                <td>${info.pkgName}</td>
                <td>
                  <div style="display: flex; gap: 4px;">
                    <input type="text" id="${uniqueId}" value="${displayValue}" data-unit="${currentGlobalUnit}" style="max-width: 80px; background:transparent;border:none;outline:none" readonly />
                    <select class="form-select" style="width: 80px; font-size:12px" onchange="convertUnit('${uniqueId}', this)">
                      <option value="KB" ${currentGlobalUnit === 'KB' ? 'selected' : ''}>KB</option>
                      <option value="MB" ${currentGlobalUnit === 'MB' ? 'selected' : ''}>MB</option>
                      <option value="GB" ${currentGlobalUnit === 'GB' ? 'selected' : ''}>GB</option>
                    </select>
                  </div>
                </td>
                <td>${info.expDate}</td>
                <td class="wrap-text">${info.info}</td>
              </tr>`;
            tableBody.append(rowHtml);
          });
        }
        
        // Đồng bộ dataUnitSelect chính với đơn vị hiện tại
        const dataUnitSelect = document.getElementById('dataUnitSelect');
        if (dataUnitSelect) {
          dataUnitSelect.value = currentGlobalUnit;
          
          // Áp dụng chuyển đổi cho dataBalanceInfo nếu có dữ liệu
          if (datas.content.dataBalance) {
            let dataBalanceValue = datas.content.dataBalance;
            const dataBalanceInput = document.getElementById('dataBalanceInfo');
            
            if (dataBalanceInput) {
              // Chuyển đổi từ đơn vị mặc định của API (giả sử là MB) sang đơn vị hiện tại
              if (currentGlobalUnit === 'KB') {
                dataBalanceValue = Math.round(dataBalanceValue * 1024);
              } else if (currentGlobalUnit === 'GB') {
                dataBalanceValue = (dataBalanceValue / 1024).toFixed(2);
              }
              
              dataBalanceInput.value = dataBalanceValue;
              dataBalanceInput.dataset.unit = currentGlobalUnit;
            }
          }
        }
      }
    },
    complete: function () {
      FinishProcess(); // Kết thúc hiển thị loading (nếu có)
    }
  });
}
// Biến toàn cục để lưu đơn vị hiện tại giữa các lần mở modal
let currentGlobalUnit = 'MB'; // Đơn vị mặc định ban đầu

/**
 * Chuyển đổi đơn vị dữ liệu giữa KB, MB và GB
 * @param {string} inputId - ID của ô input chứa giá trị
 * @param {HTMLElement} selectElement - Select element thay đổi đơn vị
 * @param {boolean} syncAll - Có đồng bộ tất cả các đơn vị khác không
 */
function convertUnit(inputId, selectElement, syncAll = true) {
  const input = document.getElementById(inputId);
  let value = parseFloat(input.value);
  if (isNaN(value)) return;

  const currentUnit = input.dataset.unit || 'MB';
  const newUnit = selectElement.value;

  if (currentUnit === newUnit) return;

  // Bước 1: Đưa về KB (đơn vị trung gian)
  let valueInKB;
  switch (currentUnit) {
    case 'KB': valueInKB = value; break;
    case 'MB': valueInKB = value * 1024; break;
    case 'GB': valueInKB = value * 1024 * 1024; break;
    default: valueInKB = value;
  }

  // Bước 2: Chuyển từ KB sang đơn vị mới
  let newValue;
  switch (newUnit) {
    case 'KB': newValue = valueInKB; break;
    case 'MB': newValue = valueInKB / 1024; break;
    case 'GB': newValue = valueInKB / (1024 * 1024); break;
    default: newValue = valueInKB;
  }

  // Bước 3: Hiển thị giá trị với định dạng phù hợp
  input.value = newUnit === 'KB' ? Math.round(newValue) : newValue.toFixed(2);
  input.dataset.unit = newUnit; // Cập nhật đơn vị hiện tại
  
  // Lưu đơn vị hiện tại để sử dụng cho lần mở modal tiếp theo
  currentGlobalUnit = newUnit;
  
  // Nếu cần đồng bộ, thì áp dụng đơn vị mới cho tất cả các select box khác
  if (syncAll) {
    syncAllUnits(newUnit);
  }
}

/**
 * Đồng bộ tất cả các đơn vị trong modal
 * @param {string} unit - Đơn vị cần đồng bộ (KB, MB, GB)
 */
function syncAllUnits(unit) {
  // 1. Đồng bộ dataUnitSelect chính
  const dataUnitSelect = document.getElementById('dataUnitSelect');
  if (dataUnitSelect && dataUnitSelect.value !== unit) {
    dataUnitSelect.value = unit;
    convertUnit('dataBalanceInfo', dataUnitSelect, false); // false để tránh vòng lặp vô hạn
  }
  
  // 2. Đồng bộ tất cả các select trong bảng
  const tableSelects = document.querySelectorAll('#tableKttkKtmiSubs select.form-select');
  tableSelects.forEach(select => {
    if (select.value !== unit) {
      select.value = unit;
      // Lấy ID của input tương ứng (từ onchange handler)
      const inputId = select.getAttribute('onchange').match(/convertUnit\('([^']+)'/)[1];
      if (inputId) {
        convertUnit(inputId, select, false); // false để tránh vòng lặp vô hạn
      }
    }
  });
}
