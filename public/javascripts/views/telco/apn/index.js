var privateAPN = [];

function resetForm() {
  $("#addPrivateAPN #apn-name").html(
    `<option value="" disabled selected hidden>${Messages("apn.js.chooseAPN")}</option>`
  );
  $("#addPrivateAPN #apn-name").val("");
  $("#addPrivateAPN #apn-ip").html(
    `<option value="" disabled selected hidden>${Messages("apn.js.chooseIP")}</option>`
  );
  $("#addPrivateAPN #apn-ip").val("");
  $("#addPrivateAPN #apn-fromDate").val(moment().format("DD/MM/YYYY"));
  $("#addPrivateAPN #apn-toDate").val("");
  $("#addPrivateAPN #apn-reason").val("299799");

  $("#addPrivateAPN #apn-name-field .helper-text").text("");
  $("#addPrivateAPN #apn-ip-field .helper-text").text("");
  $("#addPrivateAPN #apn-fromDate-field .helper-text").text("");
  $("#addPrivateAPN #apn-toDate-field .helper-text").text("");
  $("#addPrivateAPN #apn-reason-field .helper-text").text("");
}

function resetAll() {
  $('input[name="telephoneNumber"]').val("");

  $("#apnContractInfo #apn-isdn").val("");
  $("#apnContractInfo #apn-serial").val("");
  $("#apnContractInfo #apn-idNo").val("");
  $("#apnContractInfo #apn-payTypeView").val("");
  $("#apnContractInfo #apn-productCode").val("");
  $("#apnContractInfo #apn-actStatusText").val("");
  $("#apnContractInfo #apn-activeDatetime").val("");
  $("#apnContractInfo #apn-staDatetime").val("");
  $("#apnDetail #apn-detail-table tbody").empty();

  resetForm();
  privateAPN = [];
}

async function handleSearchAPN() {
  const phoneNumberInput = document.querySelector(
    'input[name="telephoneNumber"]'
  );
  const phoneNumber = phoneNumberInput
    ? nomoralizePhoneNumber(phoneNumberInput.value.trim())
    : "";

  const phoneErrorMessage = validatePhoneNumber(phoneNumber);
  $("#searchAPNCard #apn-phoneNumber-field .helper-text").text("");
  if (phoneErrorMessage) {
    $("#searchAPNCard #apn-phoneNumber-field .helper-text").text(
      Messages(phoneErrorMessage)
    );
    return;
  }

  var body = new FormData();
  body.user_id = userId;
  body.isdns = [phoneNumber];

  $(".error-text-result").addClass("d-none");
  $('button[data-bs-target="#addDefaultAPN"]').removeClass("disabled");
  $('button[data-bs-target="#addPrivateAPN"]').removeClass("disabled");
  StartProcess();
  privateAPN = [];
  //Get info by phone number
  try {
    const bodySubscriber = new FormData();
    bodySubscriber.userId = userId;
    bodySubscriber.isdn = phoneNumber;

    var r1 =
      jsRoutes.controllers.TelcoSubscriberController.getListSubsByBeVht();
    await $.ajax({
      type: r1.type,
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(bodySubscriber),
      url: r1.url,
      success: function (data) {
        if (data.content != null && data.content.data != null) {
          $("#apnSubscriptionInfo").removeClass("d-none");
          $("#apnSubscriptionCard #noDataFound").addClass("d-none");
          const dataContent = data.content.data[0];

          Object.keys(dataContent).forEach(function (key) {
            if (dataContent[key] !== null && dataContent[key] !== undefined) {
              $(`#apnContractInfo #apn-${key}`).val(
                ["activeDatetime", "staDatetime"].includes(key)
                  ? moment(dataContent[key]).format("DD-MM-YYYY")
                  : dataContent[key]
              );
            } else {
              $(`#apnContractInfo #${key}`).val("");
            }
          });
        } else {
          $("#apnSubscriptionInfo").addClass("d-none");
          $("#apnSubscriptionCard #noDataFound").removeClass("d-none");
          $("#apnSubscriptionCard #noDataFound").html(
            `<div class="col-md-12">${Messages(
              "error.notFound"
            )}</div>`
          );
        }
      },
      error: function (xhr) {
        console.log(xhr);
        $("#apnSubscriptionInfo").addClass("d-none");
        $("#apnSubscriptionCard #noDataFound").removeClass("d-none");
        $("#apnSubscriptionCard #noDataFound").html(
          `<div class="col-md-12">${Messages(
            "error.notFound"
          )}</div>`
        );
        showNotification("danger", Messages("error.notFound"));
      },
      complete: function () {},
    });
    const { content: dataDetail } = await getAPNByPhoneNumbers([phoneNumber]);

    if (dataDetail && dataDetail.data) {
      const { data } = dataDetail;
      $("#apnDetail #apn-detail-table tbody").empty();
      if (data.length == 0) {
        $('button[data-bs-target="#addDefaultAPN"]').removeClass("disabled");
        $('button[data-bs-target="#addPrivateAPN"]').removeClass("disabled");
        $("#apnDetail #apn-detail-table tbody").append(
          `<tr><td colspan="7" class="text-center">${Messages(
            "apn.js.noData"
          )}</td></tr>`
        );
      }

      const apnDefault = data[0]?.apn_default
        ? `<tr>
          <td>1</td>
          <td>${Messages("apn.js.default")}</td>
          <td>---</td>
          <td>---</td>
          <td>---</td>
          <td>---</td>
          <td  class="d-flex justify-content-center" style="height: 48px">
           <img src="${iconAction}" 
                width="20" 
                height="20"
                data-bs-toggle="modal" data-bs-target="#cancelDefaultAPN"
                class="cursor-pointer m-auto"
                rel="tooltip" title="${Messages("apn.js.clickToCancelAPN")}"
                />
          </td>
        </tr>`
        : "";

      const apnPrivate = data[0]?.apns
        ? data[0]?.apns.map(
            (item, ind) =>
              `<tr>
          <td>${ind + 2}</td>
          <td>${Messages("apn.js.private")}</td>
          <td>${item.apn_name}</td>
          <td>${!item.ip || item.ip === "-1" ? Messages("apn.js.dynamicIp") : item.ip}</td>
          <td>${moment(item.sta_datetime).format("DD/MM/YYYY")}</td>
          <td>${moment(item.end_datetime).format("DD/MM/YYYY")}</td>
          <td  class="d-flex justify-content-center" style="height: 48px">
           <img src="${iconAction}" 
                width="20" 
                height="20"
                data-bs-toggle="modal" data-bs-target="#cancelPrivateAPN"
                class="cursor-pointer m-auto"
                rel="tooltip" title="${Messages("apn.js.clickToCancelAPN")}"
                onclick="handleRowClick('${item.apn_code}', '${item.ip}');"
                />
          </td>
        </tr>`
          )
        : "";
      if (apnDefault !== "") {
        $('button[data-bs-target="#addDefaultAPN"]').addClass("disabled");
      } else {
        $('button[data-bs-target="#addDefaultAPN"]').removeClass("disabled");
      }

      if (apnPrivate.length > 0) {
        $('button[data-bs-target="#addPrivateAPN"]').addClass("disabled");
      } else {
        const dataIp = await getIpAllow();
        if (dataIp.content.data) {
          $('button[data-bs-target="#addPrivateAPN"]').removeClass("disabled");
          privateAPN = dataIp.content.data;
          const apnName = $("#addPrivateAPN #apn-name");
          apnName.empty();
          apnName.append(
            `<option value="" disabled selected hidden>${Messages("apn.js.chooseAPN")}</option>`
          );

          privateAPN.forEach(function (apn) {
            apnName.append(
              $("<option>", {
                value: apn.apn_code,
                text: apn.apn_code,
              })
            );
          });
        }
      }

      if (!apnDefault && !apnPrivate.length) {
        $("#apnDetail #apn-detail-table tbody").append(
          `<tr><td colspan="7" class="text-center">${Messages(
            "apn.js.noData"
          )}</td></tr>`
        );
      }
      $("#apnDetail #apn-detail-table tbody").append(apnDefault, apnPrivate);
    }
    FinishProcess();
  } catch (error) {
    console.error("Error searching APN:", error);
    FinishProcess();
    showNotification("danger", Messages("error.errorServer"));
  }
}
async function RegisterAPN(_default) {
  try {
    let body = {
      user_id: userId,
      isdn: $("#apnContractInfo #apn-isdn").val(),
    };
    if (!_default) {
      body.apn_ip =
        $("#addPrivateAPN #apn-ip").val() === Messages("apn.add.dynamicIP")
          ? undefined
          : $("#addPrivateAPN #apn-ip").val();
      body.apn_code = $("#addPrivateAPN #apn-name").val();
      body.start_date = moment(
        moment(
          $("#addPrivateAPN #apn-fromDate").val() +
            " " +
            moment().format("HH:mm:ss"),
          "DD/MM/YYYY HH:mm:ss"
        )
      ).toISOString();
      body.end_date = moment(
        moment(
          $("#addPrivateAPN #apn-toDate").val() +
            " " +
            moment().format("HH:mm:ss"),
          "DD/MM/YYYY HH:mm:ss"
        )
      ).toISOString();
      console.log(validateAPNIPForm(), "validateAPNIPForm");
      if (!validateAPNIPForm()) return;
    }
    StartProcess();
    $(".confirm-register-apn").addClass("disabled");

    let r = jsRoutes.controllers.TelcoAPNController.registerAPN();

    await $.ajax({
      type: r.type,
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(body),
      url: r.url,
      success: function (data) {
        if (data.content != null && data.content.code != null) {
          if (data.content.code == "0") {
            showNotification(
              "success",
              Messages(
                _default ? "apn.add.default.success" : "apn.add.private.success"
              )
            );
            handleSearchAPN();
            return;
          }
          showNotification(
            "danger",
            _default
              ? `<div class="d-flex flex-column justify-content-start"> <div>${Messages(
                  "apn.add.default.error"
                )} (${data.content.code})</div> <div>${
                  data.content.description
                }</div></div>`
              : `<div class="d-flex flex-column justify-content-start"> <div>${Messages(
                  "apn.add.private.error"
                )} (${data.content.code})</div> <div>${
                  data.content.description
                }</div></div>`
          );
          FinishProcess();
        } else {
          showNotification(
            "danger",
            _default
              ? Messages("apn.add.default.error")
              : Messages("apn.add.error")
          );
        }
      },
      error: function (xhr) {
        console.log(xhr, "register APN error");
        showNotification("danger", Messages("error.errorServer"));
        FinishProcess();
      },
      complete: function () {
        resetForm();
        FinishProcess();
        $(_default ? "#addDefaultAPN" : "#addPrivateAPN").modal("hide");
      },
    });
  } catch (error) {
    console.error("Error registering APN:", error);
    throw error;
  }
  $(".confirm-register-apn").removeClass("disabled");
}
async function UnRegisterAPN() {
  $(".confirm-remove-apn").addClass("disabled");
  try {
    StartProcess();
    let body = {
      user_id: userId,
      isdn: $("#apnContractInfo #apn-isdn").val(),
    };
    let selectedAPNRemove = $("#cancelPrivateAPN #apn-name").val();
    if (selectedAPNRemove) {
      body.apn_code = selectedAPNRemove;
      const { isValid: isValidApnName } = validateCancelApnReason();
      if (!isValidApnName) return;
    }

    let r = jsRoutes.controllers.TelcoAPNController.unRegisterAPN();

    await $.ajax({
      type: r.type,
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(body),
      url: r.url,
      success: function (data) {
        if (
          data.content != null &&
          data.content.code != null &&
          data.content.code == "0"
        ) {
          showNotification(
            "success",
            Messages(
              !selectedAPNRemove
                ? "apn.remove.default.success"
                : "apn.remove.private.success"
            )
          );
          handleSearchAPN();
        } else {
          showNotification(
            "danger",
            !selectedAPNRemove
              ? `<div class="d-flex flex-column justify-content-start"> <div>${Messages(
                  "apn.remove.default.error"
                )} (${data.content.code})</div> <div>${
                  data.content.description
                }</div></div>`
              : `<div class="d-flex flex-column justify-content-start"> <div>${Messages(
                  "apn.remove.private.error"
                )} (${data.content.code})</div> <div>${
                  data.content.description
                }</div></div>`
          );
          FinishProcess();
        }
      },
      error: function (xhr) {
        console.log(xhr, "unregister APN error");
        showNotification("danger", Messages("error.errorServer"));
        FinishProcess();
      },
      complete: function () {
        $(!selectedAPNRemove ? "#cancelDefaultAPN" : "#cancelPrivateAPN").modal(
          "hide"
        );
      },
    });
  } catch (error) {
    showNotification("danger", Messages("error.errorServer"));
    FinishProcess();
    throw error;
  }
  $(".confirm-remove-apn").removeClass("disabled");
}

async function getAPNByPhoneNumbers(phoneNumberList) {
  var body = new FormData();
  body.user_id = userId;
  body.isdns = phoneNumberList;

  StartProcess();
  let r = jsRoutes.controllers.TelcoAPNController.getAPNByPhone();
  return await $.ajax({
    type: r.type,
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(body),
    url: r.url,
    success: function (data) {
      if (data.content != null && data.content.data != null) {
        return data.content.data;
      } else {
        return [];
      }
    },
    error: function (xhr) {
      console.log(xhr);
      showNotification("danger", Messages("error.errorServer"));
    },
    complete: function () {},
  });
}

async function getIpAllow() {
  var body = new FormData();
  StartProcess();
  const rIp = jsRoutes.controllers.TelcoAPNController.getIpAllow(
    $(`input[name="telephoneNumber"]`).val(),
    userId
  );
  return await $.ajax({
    type: rIp.type,
    contentType: "application/json; charset=utf-8",
    url: rIp.url,
    success: function (data) {
      if (data.content != null && data.content.data != null) {
        return data.content.data;
      } else {
        return null;
      }
    },
    error: function (xhr) {
      console.log(xhr);
      showNotification("danger", Messages("error.errorServer"));
    },
    complete: function () {},
  });
}

function handleChooseAPN() {
  validateApnName();
  const apnName = $("#addPrivateAPN #apn-name");
  const apnIp = $("#addPrivateAPN #apn-ip");
  const selectedAPN = apnName.val();
  apnIp.prop("disabled", true);
  const _apnPrivate = privateAPN.find((item) => item.apn_code === selectedAPN);
  apnIp.empty();
  apnIp.html(
    `<option value="" disabled selected hidden>${Messages(
      "apn.add.private.selectIP"
    )}</option>`
  );
  if (_apnPrivate) {
    if (_apnPrivate.ip === "-1") {
      apnIp.append(
        $("<option>", {
          value: Messages("apn.add.dynamicIP"),
          text: Messages("apn.add.dynamicIP"),
        })
      );
      apnIp.val(Messages("apn.add.dynamicIP"));
      $("#addPrivateAPN #apn-ip").prop("disabled", true);
    } else {
      const ips = _apnPrivate.ips;

      $("#addPrivateAPN #apn-ip").prop("disabled", false);

      if (ips && ips.length > 0) {
        allIps = ips;
        ips.forEach((ip) => {
          apnIp.append(
            $("<option>", {
              value: ip.ip,
              text: ip.ip,
            })
          );
        });
      } else {
        apnIp.val("");
      }
    }
  }
  apnIp.prop("disabled", false);
}

handleRowClick = (apn_code, ip) => {
  $("#cancelPrivateAPN #apn-name").val(apn_code);
  $("#cancelPrivateAPN #apn-ip").val(ip ? ip : Messages("apn.js.dynamicIp"));
};
