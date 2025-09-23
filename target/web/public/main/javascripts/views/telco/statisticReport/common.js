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
  const pageSize = $("#report-page-size-field #report-page-size").val();
  $("#report-page-size-field .error-text").text("");
  if (!pageSize || pageSize <= 0|| pageSize > 1000) {
    $("#report-page-size-field .error-text").text(Messages("Số bản ghi trên 1 file tối thiểu là 1 và tối đa là 1000"));
    return false;
  }
  return true;
}

const isNumberKey = (e) => {
  var charCode = e.which ? e.which : e.keyCode;
  if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    return false;
  } else {
    return true;
  }
};


const isOnlyNumber = (str) => {
  return /^[0-9]+$/.test(str);
};
