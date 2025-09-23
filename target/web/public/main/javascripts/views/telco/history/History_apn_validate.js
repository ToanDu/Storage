const validateDate = () => {
  const startDate = $("#fromHistoryAPN").val();
  const endDate = $("#toHistoryAPN").val();
//   $("#fromHistoryAPN-field .helper-text").empty();
//   $("#toHistoryAPN-field .helper-text").empty();

  if (startDate && endDate) {
    const start = moment(startDate, "DD/MM/YYYY").valueOf();
    const end = moment(endDate, "DD/MM/YYYY").valueOf();
    if (start > end) {
    //   message = "Ngày bắt đầu không được lớn hơn ngày kết thúc.";
    //   $("#fromHistoryAPN-field .helper-text").text(
    //     Messages("Ngày bắt đầu không được lớn hơn ngày kết thúc.")
    //   );
    //   $("#toHistoryAPN-field .helper-text").text(
    //     Messages("Ngày kết thúc không được nhỏ hơn ngày bắt đầu.")
    //   );
      return false;
    }
  }

  return true;
};
