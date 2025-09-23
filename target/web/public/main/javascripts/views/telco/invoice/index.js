$(document).ready(function () {
  getInvoices("service", true);
});

document
  .querySelectorAll('#invoiceTab a[data-bs-toggle="tab"]')
  .forEach((tab) => {
    tab.addEventListener("shown.bs.tab", function (event) {
      const activatedTabId = event.target.id;

      if (activatedTabId === "service_invoice_tab") {
        handleResetAll("service");
      } else if (activatedTabId === "fee_invoice_tab") {
        handleResetAll("fee");
      }
    });
  });

$(document).on("keydown", function (e) {
  if (e.key === "Enter") {
    const activeTab = $('#invoiceTab a[data-bs-toggle="tab"].active').attr(
      "id"
    );
    if (activeTab === "service_invoice_tab") {
      getInvoices("service", false);
    } else if (activeTab === "fee_invoice_tab") {
      getInvoices("fee", false);
    }
  }
});

const validateTime = (startDate, endDate) => {
  if (startDate && endDate) {
    const start = moment(startDate, "DD/MM/YYYY").valueOf();
    const end = moment(endDate, "DD/MM/YYYY").valueOf();
    if (start > end) {
      return false;
    }
  }

  return true;
};

const handleResetAll = (type = "service") => {
  $("#total_record").text(0);
  if (type === "service") {
    $("#service_invoice #invoiceNumber").val("");
    $("#service_invoice #invoiceType").val("08,09,10");
    $("#service_invoice #dateFrom").val(
      moment().startOf("month").format("DD/MM/YYYY")
    );
    $("#service_invoice #dateTo").val(moment().format("DD/MM/YYYY"));

    $("#service_invoice_table table tbody").html(
      `<tr><td colspan="7" class="text-center">${Messages(
        "common.noData"
      )}</td></tr>`
    );

    $("#service_invoice_info [name=page]").val("1");
    $("#pagingTable").html(`
        <ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">
          <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="">1</a>
          </li>
        </ul>`);
  } else {
    $("#fee_invoice #invoiceNumber").val("");
    $("#fee_invoice #invoiceType").val("HDIS,HDTT,HDCDT,HDDC");
    $("#fee_invoice #accountId").val("");
    $("#fee_invoice #dateFrom").val(
      moment().startOf("month").format("DD/MM/YYYY")
    );
    $("#fee_invoice #dateTo").val(moment().format("DD/MM/YYYY"));

    $("#fee_invoice_table table tbody").html(
      `<tr><td colspan="7" class="text-center">${Messages(
        "common.noData"
      )}</td></tr>`
    );

    $("#fee_invoice_info [name=page]").val("1");
    $("#pagingTable").html(`
        <ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">
          <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="">1</a>
          </li>
        </ul>`);
  }

  getInvoices(type, true);
};

const convertOrderType = (orderType) => {
  switch (orderType) {
    case "10":
      return Messages("invoice.js.convertOrderType.topup");
    case "08":
      return Messages("invoice.js.convertOrderType.unblock1");
    case "09":
      return Messages("invoice.js.convertOrderType.unblock2");
    default:
      return "";
  }
};
const convertInvoiceType = (orderType) => {
  switch (orderType) {
    case "HDIS":
      return Messages("invoice.js.convertInvoiceType.ready");
    case "HDTT":
      return Messages("invoice.js.convertInvoiceType.surplus");
    case "HDCDT":
      return Messages("invoice.js.convertInvoiceType.prepaid");
    case "HDDC":
      return Messages("invoice.js.convertInvoiceType.adjustment");
    default:
      return "";
  }
};

const getInvoices = async (type = "service", resetPage) => {
  const isService = type === "service";
  if (isService) {
    $("#service_invoice_table table tbody").empty();
    $("#service_invoice_info #total_record").text(0);
    $("#service_invoice_info #pagingTable").empty();
  } else {
    $("#fee_invoice_table table tbody").empty();
    $("#fee_invoice_info #total_record").text(0);
    $("#fee_invoice_info #pagingTable").empty();
  }

  const isValidDate = validateDate();
  if (!isValidDate) {
    return;
  }
  if (resetPage) {
    if (isService) {
      $("#service_invoice_info [name=page]").val("1");
      $("#service_invoice_info #pagingTable").html(`
        <ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">
          <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="">1</a>
          </li>
        </ul>`);
    } else {
      $("#fee_invoice_info [name=page]").val("1");
      $("#fee_invoice_info #pagingTable").html(`
        <ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">
          <li class="paginate_button page-item active">
            <a class="page-link cursor-pointer rounded-3" onclick="">1</a>
          </li>
        </ul>`);
    }
  }
  const invoiceNumber = isService
    ? $("#service_invoice #invoiceNumber").val().trim()
    : $("#fee_invoice #invoiceNumber").val().trim();
  const invoiceType = isService
    ? $("#service_invoice #invoiceType option:selected").val()
    : $("#fee_invoice #invoiceType option:selected").val();
  const accountId = isService
    ? $("#service_invoice #accountId").val()?.trim()
    : $("#fee_invoice #accountId").val()?.trim();
  const dateFrom = isService
    ? $("#service_invoice #dateFrom").val()
    : $("#fee_invoice #dateFrom").val();
  const dateTo = isService
    ? $("#service_invoice #dateTo").val()
    : $("#fee_invoice #dateTo").val();
  const page = isService
    ? $("#service_invoice_info [name=page]").val()
    : $("#fee_invoice_info [name=page]").val();
  const pageSize = isService
    ? $("#service_invoice_info [name=pageSize]").val()
    : $("#fee_invoice_info [name=pageSize]").val();

  if (!validateTime(dateFrom, dateTo)) {
    return showNotification(
      "danger",
      Messages("invoice.js.timeValidation")
    );
  }

  let bodyData = new FormData();
  bodyData.userId = userId;
  bodyData.from = moment(dateFrom, "DD/MM/YYYY").format("YYYY-MM-DD");
  bodyData.to = moment(dateTo, "DD/MM/YYYY").format("YYYY-MM-DD");
  bodyData.limit = pageSize;
  bodyData.offset = (page - 1) * pageSize;
  bodyData.invoiceType = invoiceType ? invoiceType : null;
  bodyData.invoiceId = invoiceNumber ? invoiceNumber : null;
  bodyData.accountId = accountId ? accountId : null;

  StartProcess();
  const _r = jsRoutes.controllers.InvoiceManagerController.getInvoices();
  await $.ajax({
    url: _r.url,
    type: _r.type,
    data: JSON.stringify(bodyData),
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          if (isService) {
            $("#service_invoice_table table tbody").empty();
          } else {
            $("#fee_invoice_table table tbody").empty();
          }

          const tableData = data.content.data;
          if (tableData.length == 0) {
            if (isService) {
              $("#service_invoice_table table tbody").append(
                `<tr><td colspan="7" class="text-center">${Messages(
                  "common.noData"
                )}</td></tr>`
              );
            } else {
              $("#fee_invoice_table table tbody").append(
                `<tr><td colspan="7" class="text-center">${Messages(
                  "common.noData"
                )}</td></tr>`
              );
            }
          } else {
            let pagingHtml = paging2HTML(
              data.content.total,
              page,
              pageSize,
              isService ? searchServiceInvoice : searchFeeInvoice
            );

            if (isService) {
              $("#service_invoice_info #total_record").text(data.content.total);
              $("#service_invoice_info #pagingTable").html(pagingHtml);
            } else {
              $("#fee_invoice_info #total_record").text(data.content.total);
              $("#fee_invoice_info #pagingTable").html(pagingHtml);
            }

            tableData.forEach((invoice, index) => {
              if (isService) {
                $("#service_invoice_table table tbody").append(
                  `<tr>
                  <td>${(page - 1) * pageSize + index + 1}</td>
                  <td>${invoice.invoice_id}</td>
                  <td>${convertOrderType(invoice.invoice_type)}</td>
                  <td>${new Intl.NumberFormat("vi-VN", {
                    style: "currency",
                    currency: "VND",
                  }).format(invoice.total_amount)}</td>
                  <td>${moment(invoice.date).format("DD/MM/YYYY")}</td>
                  <td class="d-flex gap-2 justify-content-center align-items-center">
                  <!-- Nút Preview dùng ảnh SVG từ thư mục -->
                  <img src="/assets/images/telco/preview.svg" width="24" height="24" class="cursor-pointer"
                       title="Xem trước hóa đơn"
                       onclick='handlePreviewInvoice(${JSON.stringify(
                         invoice.data
                       )})' />
                
                  <!-- Nút download -->
                  <i class="bx bx-download fs-4 cursor-pointer" style="color: #1F1A1B;" 
                     onclick='handleDownloadInvoice(${JSON.stringify(
                       invoice.data
                     )})'></i>
                </td>
                </tr>`
                );
              } else {
                let invoiceData = {
                  invoiceNo: invoice.invoice_id,
                  invoiceDate: moment(invoice.date).format("DD/MM/YYYY"),
                  userId: userId,
                };
                $("#fee_invoice_table table tbody").append(
                  `<tr>
                  <td>${(page - 1) * pageSize + index + 1}</td>
                  <td>${invoice.invoice_id}</td>
                  <td>${convertInvoiceType(invoice.invoice_type)}</td>
                  <td>${invoice.account_id}</td>
                  <td>${new Intl.NumberFormat("vi-VN", {
                    style: "currency",
                    currency: "VND",
                  }).format(invoice.total_amount)}</td>
                  <td>${moment(invoice.date).format("DD/MM/YYYY")}</td>
                  <td class="d-flex gap-2 justify-content-center align-items-center">
                  <!-- Nút Preview dùng ảnh SVG từ thư mục -->
                  <img src="/assets/images/telco/preview.svg" width="24" height="24" class="cursor-pointer"
                       title="Xem trước hóa đơn"
                       onclick='handlePreviewBillingInvoice(${JSON.stringify(
                         invoiceData
                       )})' />
                
                  <!-- Nút download -->
                  <i class="bx bx-download fs-4 cursor-pointer" style="color: #1F1A1B;" 
                     onclick='handleDownloadBillingInvoice(${JSON.stringify(
                       invoiceData
                     )})'></i>
                </td>
                </tr>`
                );
              }
            });
          }
        } else {
          if (isService) {
            $("#service_invoice_table table tbody").html(
              `<tr><td colspan="7" class="text-center">${Messages(
                "common.noData"
              )}</td></tr>`
            );
          } else {
            $("#fee_invoice_table table tbody").html(
              `<tr><td colspan="7" class="text-center">${Messages(
                "common.noData"
              )}</td></tr>`
            );
          }
        }
        FinishProcess();
      } catch (error) {
        console.error("Fetching invoice error:", error);
        FinishProcess();
      }
    },
    error: function (error) {
      if (isService) {
        $("#service_invoice_table table tbody").empty();
      } else {
        $("#fee_invoice_table table tbody").empty();
      }
      console.error("Fetching invoice error:", error);
      FinishProcess();
    },
  });
};

// Convert Base64 string to a Blob (Excel MIME type)
function base64ToBlob(base64, mime) {
  const byteChars = atob(base64);
  const byteNumbers = new Array(byteChars.length);
  for (let i = 0; i < byteChars.length; i++) {
    byteNumbers[i] = byteChars.charCodeAt(i);
  }
  const byteArray = new Uint8Array(byteNumbers);
  return new Blob([byteArray], { type: mime });
}

async function handlePreviewInvoice(invoiceIds) {
  const bodyData = {
    userId: userId,
    listSaleTransId: invoiceIds.slice(0, 1),
  };
  const _r = jsRoutes.controllers.InvoiceManagerController.getInvoiceBase64();
  StartProcess();
  await $.ajax({
    url: _r.url,
    type: _r.type,
    data: JSON.stringify(bodyData),
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          //const { fileContent: base64Data, fileName } = data.content.data[0];
          const base64 = data.content.data[0].fileContent; // hoặc data.pdfBase64 / data.imageBase64
          const fileType = data.type || "pdf"; // hoặc 'image'

          let fullSrc = "";

          if (fileType === "pdf") {
            fullSrc = "data:application/pdf;base64," + base64;
          } else if (fileType === "image") {
            fullSrc = "data:image/png;base64," + base64;
          } else {
            alert("Không hỗ trợ định dạng này!");
            return;
          }
          document.getElementById("fileFrame").src = fullSrc;
          document.getElementById("fileModal").style.display = "flex";
        } else {
          console.error("No data found for the invoice download.");
          showNotification("danger", "Không có dữ liệu để tải xuống");
        }
      } catch (error) {
        console.error("Export data:", error);
        showNotification("danger", "Lỗi trong quá trình xuất dữ liệu");
      }
    },
    error: function (error) {
      console.error("Export data:", error);
      showNotification("danger", "Lỗi hệ thống, vui lòng thử lại sau");
    },
  });
  FinishProcess();
}

const handlePreviewBillingInvoice = async (invoice) => {
  const _r = jsRoutes.controllers.InvoiceManagerController.getInvoiceBase64();
  StartProcess();
  await $.ajax({
    url: _r.url,
    type: _r.type,
    data: JSON.stringify(invoice),
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          const base64 = data.content.data.fileContent; // hoặc data.pdfBase64 / data.imageBase64
          const fileType = data.type || "pdf"; // hoặc 'image'

          let fullSrc = "";

          if (fileType === "pdf") {
            fullSrc = "data:application/pdf;base64," + base64;
          } else if (fileType === "image") {
            fullSrc = "data:image/png;base64," + base64;
          } else {
            alert("Không hỗ trợ định dạng này!");
            return;
          }
          document.getElementById("fileFrame").src = fullSrc;
          document.getElementById("fileModal").style.display = "flex";
        } else {
          console.error("No data found for the invoice download.");
          showNotification("danger", "Không có dữ liệu để tải xuống");
        }
      } catch (error) {
        console.error("Export data:", error);
        showNotification("danger", "Lỗi trong quá trình xuất dữ liệu");
      }
    },
    error: function (error) {
      console.error("Export data:", error);
      showNotification("danger", "Lỗi hệ thống, vui lòng thử lại sau");
    },
  });
  FinishProcess();
};

function closeModal() {
  document.getElementById("fileModal").style.display = "none";
  document.getElementById("fileFrame").src = ""; // clear nội dung khi đóng
}

const handleDownloadInvoice = async (invoiceIds) => {
  const bodyData = {
    userId: userId,
    listSaleTransId: invoiceIds.slice(0, 1),
  };
  const _r = jsRoutes.controllers.InvoiceManagerController.getInvoiceBase64();
  StartProcess();
  await $.ajax({
    url: _r.url,
    type: _r.type,
    data: JSON.stringify(bodyData),
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          const { fileContent: base64Data, fileName } = data.content.data[0];
          const blob = base64ToBlob(base64Data, "application/pdf");
          const url = URL.createObjectURL(blob);
          const a = document.createElement("a");
          a.href = url;
          a.download = fileName;
          document.body.appendChild(a);
          a.click();
          document.body.removeChild(a);
          URL.revokeObjectURL(url);
        } else {
          console.error("No data found for the invoice download.");
          showNotification("danger", "Không có dữ liệu để tải xuống");
        }
      } catch (error) {
        console.error("Export data:", error);
        showNotification("danger", "Lỗi trong quá trình xuất dữ liệu");
      }
    },
    error: function (error) {
      console.error("Export data:", error);
      showNotification("danger", "Lỗi hệ thống, vui lòng thử lại sau");
    },
  });
  FinishProcess();
};
const handleDownloadBillingInvoice = async (invoice) => {
  const _r = jsRoutes.controllers.InvoiceManagerController.getInvoiceBase64();
  StartProcess();
  await $.ajax({
    url: _r.url,
    type: _r.type,
    data: JSON.stringify(invoice),
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          const { fileContent: base64Data, fileName } = data.content.data;
          const blob = base64ToBlob(base64Data, "application/pdf");
          const url = URL.createObjectURL(blob);
          const a = document.createElement("a");
          a.href = url;
          a.download = fileName;
          document.body.appendChild(a);
          a.click();
          document.body.removeChild(a);
          URL.revokeObjectURL(url);
        } else {
          console.error("No data found for the invoice download.");
          showNotification("danger", "Không có dữ liệu để tải xuống");
        }
      } catch (error) {
        console.error("Export data:", error);
        showNotification("danger", "Lỗi trong quá trình xuất dữ liệu");
      }
    },
    error: function (error) {
      console.error("Export data:", error);
      showNotification("danger", "Lỗi hệ thống, vui lòng thử lại sau");
    },
  });
  FinishProcess();
};

const handleChangePageSizeService = async (page, pageSize) => {
  $("#service_invoice_info #countPageSize").html(pageSize);
  $("#service_invoice_info [name=page]").val(page);
  $("#service_invoice_info [name=pageSize]").val(pageSize);

  getInvoices("service", false);
};
const handleChangePageSizeFee = async (page, pageSize) => {
  $("#fee_invoice_info #countPageSize").html(pageSize);
  $("#fee_invoice_info [name=page]").val(page);
  $("#fee_invoice_info [name=pageSize]").val(pageSize);

  getInvoices("fee", false);
};

function paging2HTML(total, page, pageSize, handleSearch = () => {}) {
  let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
  let currentPage = parseInt(page);
  let totalPage = Math.ceil(total / pageSize);

  if (currentPage > 1) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage - 1
    }, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
                </li>`;
  }

  if (currentPage - 1 > 0) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage - 1
    }, ${pageSize})">${currentPage - 1}</a>
                </li>`;
  }

  paging += `
            <li class="paginate_button page-item active">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${currentPage}, ${pageSize})">${currentPage}</a>
            </li>`;

  if (currentPage + 1 <= totalPage) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage + 1
    }, ${pageSize})">${currentPage + 1}</a>
                </li>`;
  }

  if (currentPage < totalPage) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage + 1
    }, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
                </li>`;
  }

  paging += "</ul>";
  return paging;
}

function searchServiceInvoice(_page) {
  $(`#service_invoice_info #page`).val(_page);
  getInvoices(`service`, false);
}
function searchFeeInvoice(_page) {
  $(`#fee_invoice_info #page`).val(_page);
  getInvoices(`fee`, false);
}

function isNumberKey(e) {
  var charCode = e.which ? e.which : e.keyCode;
  if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    return false;
  } else {
    return true;
  }
};
