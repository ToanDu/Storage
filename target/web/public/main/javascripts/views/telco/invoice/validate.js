const validateDate = () => {
    const dateFrom = $("#service_invoice #dateFrom").val();
    const dateTo = $("#service_invoice #dateTo").val();
    const fromDate = moment(dateFrom, "DD/MM/YYYY");
    const toDate = moment(dateTo, "DD/MM/YYYY");
    if (fromDate.isValid() && toDate.isValid()) {
        if (fromDate.isAfter(toDate)) {
            showNotification("danger", Messages("invoice.js.dateValidation"));
            return false;
        }
        return true;
    }
}
