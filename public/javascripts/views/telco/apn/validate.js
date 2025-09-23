function validateApnName() {
  const apnName = $("#addPrivateAPN #apn-name").val();

  if (!apnName || apnName.trim() === "0") {
    $("#addPrivateAPN #apn-name-field .helper-text").text(
      Messages("apn.validation.selectAPN")
    );
    return { isValid: false, message: Messages("apn.validation.selectAPN") };
  }

  $("#addPrivateAPN #apn-name-field .helper-text").text("");
  return { isValid: true };
}

function validateApnIp() {
  const apnIp = $("#addPrivateAPN #apn-ip").val();
  if (!apnIp || apnIp.trim() === "0") {
    $("#addPrivateAPN #apn-ip-field .helper-text").text(
      Messages("apn.validation.selectIP")
    );
    return { isValid: false, message: Messages("apn.validation.selectIP") };
  }
  $("#addPrivateAPN #apn-ip-field .helper-text").text("");
  return { isValid: true };
}

function validateApnStartDate() {
  const fromDate = $("#addPrivateAPN #apn-fromDate").val();
  const toDate = $("#addPrivateAPN #apn-toDate").val();

  if (!fromDate || fromDate.trim() === "") {
    $("#addPrivateAPN #apn-fromDate-field .helper-text").text(
      Messages("apn.validation.selectStartDate")
    );
    return { isValid: false, message: Messages("apn.validation.selectStartDate") };
  }
  const dateToTimestamp = moment(fromDate, "DD/MM/YYYY").valueOf();

  if (dateToTimestamp < dateNow) {
    $("#addPrivateAPN #apn-fromDate-field .helper-text").text(
      Messages("apn.validation.startDateFuture")
    );
    return {
      isValid: false,
      message: Messages("apn.validation.startDateFuture"),
    };
  }
  if (toDate && dateToTimestamp > moment(toDate, "DD/MM/YYYY").valueOf()) {
    $("#addPrivateAPN #apn-fromDate-field .helper-text").text(
      Messages("apn.validation.startDateBeforeEnd")
    );
    return {
      isValid: false,
      message: Messages("apn.validation.startDateBeforeEnd"),
    };
  }
  $("#addPrivateAPN #apn-fromDate-field .helper-text").text("");

  return { isValid: true };
}
function validateApnEndDate() {
  const toDate = $("#addPrivateAPN #apn-toDate").val();
  const fromDate = $("#addPrivateAPN #apn-fromDate").val();
  if (!toDate || toDate.trim() === "") {
    $("#addPrivateAPN #apn-toDate-field .helper-text").text(
      Messages("apn.validation.selectEndDate")
    );
    return { isValid: false, message: Messages("apn.validation.selectEndDate") };
  }
  const dateToTimestamp = moment(toDate, "DD/MM/YYYY").valueOf();

  if (dateToTimestamp < dateNow) {
    $("#addPrivateAPN #apn-toDate-field .helper-text").text(
      Messages("apn.validation.endDateFuture")
    );
    return {
      isValid: false,
      message: Messages("apn.validation.endDateFuture"),
    };
  }
  if (fromDate && dateToTimestamp < moment(fromDate, "DD/MM/YYYY").valueOf()) {
    $("#addPrivateAPN #apn-toDate-field .helper-text").text(
      Messages("apn.validation.endDateAfterStart")
    );
    return {
      isValid: false,
      message: Messages("apn.validation.endDateAfterStart"),
    };
  }
  $("#addPrivateAPN #apn-toDate-field .helper-text").text("");

  return { isValid: true };
}
function validateApnReason() {
  const reason = $("#addPrivateAPN #apn-reason").val();
  if (!reason || reason.trim() === "0") {
    $("#addPrivateAPN #apn-reason-field .helper-text").text(
      Messages("apn.validation.selectReason")
    );
    return { isValid: false, message: Messages("apn.validation.selectReason") };
  }
  $("#addPrivateAPN #apn-reason-field .helper-text").text("");
  return { isValid: true };
}
validateCancelApnReason = () => {
  const reason = $("#cancelPrivateAPN #apn-reason").val();
  if (!reason || reason.trim() === "0") {
    $("#cancelPrivateAPN .helper-text").text(Messages("apn.validation.selectReason"));
    return { isValid: false, message: Messages("apn.validation.selectReason") };
  }
  $("#cancelPrivateAPN .helper-text").text("");
  return { isValid: true };
};

function validateAPNIPForm() {
  const { isValid: validName } = validateApnName();
  const { isValid: validIp } = validateApnIp();
  const { isValid: validStartDate } = validateApnStartDate();
  const { isValid: validEndDate } = validateApnEndDate();
  const { isValid: validReason } = validateApnReason();
  if (
    !validName ||
    !validIp ||
    !validStartDate ||
    !validEndDate ||
    !validReason
  ) {
    return false;
  }
  return true;
}

const validatePhoneNumber = (phoneNumber) => {
  let errorMessage = "";

  if (!phoneNumber || phoneNumber === "") {
    errorMessage = Messages("apn.validation.enterPhoneNumber");
  } else if (phoneNumber.length < 9 || phoneNumber.length > 10) {
    errorMessage = Messages("apn.validation.invalidPhoneNumber");
  }

  return errorMessage;
};

function isNumberKey(e) {
  var charCode = e.which ? e.which : e.keyCode;
  if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    return false;
  } else {
    return true;
  }
}

const nomoralizePhoneNumber = (phoneNumber) => {
  if (phoneNumber.startsWith("0")) {
    return phoneNumber.slice(1);
  }
  if (phoneNumber.startsWith("84")) {
    return phoneNumber.slice(2);
  }
  return phoneNumber;
};

const validatePageSize = () => {
  const pageSize = $("#apn-page-size-field #apn-page-size").val();
  $("#apn-page-size-field .error-text").text("");
  if (!pageSize || pageSize <= 0|| pageSize > 1000) {
    $("#apn-page-size-field .error-text").text(Messages("apn.validation.recordsRange"));
    return false;
  }
  return true;
}