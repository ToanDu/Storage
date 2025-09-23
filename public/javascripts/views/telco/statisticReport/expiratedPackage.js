$(document).ready(function () {
  getExpiratedPackages(true);
});
$(document).on("keypress", function (e) {
  if (e.which === 13) {
    e.preventDefault();
    getExpiratedPackages(true);
  }
});

const handleResetAllExpiratedPackages = () => {
  $("#statisticalReportSearchForm #isDn").val("");
  $("#statisticalReportSearchForm #contractId").val("");
  clearData();
  getExpiratedPackages(true);
};
const clearData = () => {
  $("#expiratedPackageTable table tbody").empty();
  $("#expiratedPackageTable table tbody").append(
    `<tr><td colspan="12" class="text-center">${Messages(
      "report.expirated.js.noData"
    )}</td></tr>`
  );
  $("#expiratedPackageContainer [name=page]").val("1");
  $("#expiratedPackageContainer #pagingTable").empty();
  $(
    '#statisticalReportSearchForm button[data-bs-target="#exportReportModal"]'
  ).addClass("d-none");
  $("#statisticalReportSearchForm #dateFrom").val(
    moment().format("DD/MM/YYYY")
  );
  $("#statisticalReportSearchForm #dateTo").val(
    moment().endOf("month").format("DD/MM/YYYY")
  );
  totalRecords = 0;
};

const convertBlockedType = (_type) => {
  switch (_type) {
    case "1":
      return Messages("report.expirated.js.subscriberTypeNormal");
    case "2":
      return "Roaming";

    default:
      return "";
  }
};

const getExpiratedPackages = async (resetPage) => {
  $("#expiratedPackageTable table tbody").empty();
  $(
    '#statisticalReportSearchForm button[data-bs-target="#exportReportModal"]'
  ).addClass("d-none");
  $("#expiratedPackageContainer #total_record").html(0);
  if (resetPage) {
    $("#expiratedPackageContainer [name=page]").val("1");
    $("#expiratedPackageContainer #pagingTable").empty();
  }
  let isDn = $("#statisticalReportSearchForm #isDn").val().trim();
  let contractId = $("#statisticalReportSearchForm #contractId").val().trim();

  let page = $("#expiratedPackageContainer [name=page]").val();
  let pageSize = $("#expiratedPackageContainer [name=pageSize]").val();
  let from = $("#statisticalReportSearchForm #dateFrom").val().trim();
  let to = $("#statisticalReportSearchForm #dateTo").val().trim();

  if (!validateTime(from, to)) {
    $("#expiratedPackageTable table tbody").append(
      `<tr><td colspan="12" class="text-center">${Messages(
        "report.expirated.js.noData"
      )}</td></tr>`
    );
    return showNotification(
      "danger",
      Messages("report.expirated.js.dateRangeError")
    );
  }  
  
  if (isDn && !isOnlyNumber(isDn)) {
    $("#expiratedPackageTable table tbody").append(
      `<tr><td colspan="12" class="text-center">${Messages(
        "report.expirated.js.noData"
      )}</td></tr>`
    );
    return showNotification(
      "danger",
      Messages("report.expirated.js.subscriberNumberError")
    );
  }  
  if (contractId && !isOnlyNumber(contractId)) {
    $("#expiratedPackageTable table tbody").append(
      `<tr><td colspan="12" class="text-center">${Messages(
        "report.expirated.js.noData"
      )}</td></tr>`
    );
    return showNotification(
      "danger",
      Messages("report.expirated.js.contractIdError")
    );
  }

  let bodyData = new FormData();
  bodyData.userId = userId;
  bodyData.limit = pageSize;
  bodyData.offset = (page - 1) * pageSize;
  bodyData.isDn = isDn ? nomoralizePhoneNumber(isDn) : "";
  bodyData.contractId = contractId ? contractId : "";
  bodyData.from = from ? moment(from, "DD/MM/YYYY").format("YYYY-MM-DD") : "";
  bodyData.to = to ? moment(to, "DD/MM/YYYY").format("YYYY-MM-DD") : "";

  StartProcess();

  const _r =
    jsRoutes.controllers.TelcoStatisticalReportController.getExpiratedPackages();
  await $.ajax({
    type: _r.type,
    data: JSON.stringify(bodyData),
    url: _r.url,
    contentType: "application/json",
    success: function (data) {
      try {
        if (data.content != null && data.content.data != null) {
          $("#expiratedPackageTable table tbody").empty();

          const tableData = data.content.data;
          totalRecords = data.content.total;
          if (!tableData || tableData.length == 0) {
            $("#expiratedPackageTable table tbody").append(
              `<tr><td colspan="12" class="text-center">${Messages(
                "report.expirated.js.noData"
              )}</td></tr>`
            );
          } else {
            let pagingHtml = paging2HTML(
              data.content.total,
              page,
              pageSize,
              applySearch
            );
            $("#expiratedPackageContainer #total_record").html(
              data.content.total
            );
            $(
              '#statisticalReportSearchForm button[data-bs-target="#exportReportModal"]'
            ).removeClass("d-none");
            $("#expiratedPackageContainer #pagingTable").html(pagingHtml);

            tableData.forEach((record, index) => {
              $("#expiratedPackageTable table tbody").append(
                `<tr>
                  <td>${(page-1)*pageSize + index + 1}</td>
                  <td>${record.isdn}</td>  
                  <td>${
                    record.contract_id && record.contract_id != "0" ? record.contract_id : "--"
                  }</td>
                  <td>${record.pay_type}</td>
                  <td>${record.package_name}</td>
                  <td>${moment(record.expired_date).format(
                    "HH:mm DD/MM/YYYY"
                  )}</td>                
                </tr>`
              );
            });
          }
        } else {
          $("#expiratedPackageTable table tbody").empty();
          $("#expiratedPackageTable table tbody").append(
            `<tr><td colspan="12" class="text-center">${Messages(
              "report.expirated.js.noData"
            )}</td></tr>`
          );
        }
        FinishProcess();
      } catch (error) {
        console.error("Fetching invoice error:", error);
        FinishProcess();
      }
    },
    error: function (error) {
      $("#service_invoice_table table tbody").empty();
      console.error("Fetching invoice error:", error);
      FinishProcess();
    },
  });
};

function applySearch(_page,_pageSize) { 
  $(`#expiratedPackageContainer #countPageSize`).html(_pageSize);
  $(`#expiratedPackageContainer [name=page]`).val(_page);
  $(`#expiratedPackageContainer [name=pageSize]`).val(_pageSize);
  getExpiratedPackages();
}

function handleChangePageModal(_pg) {
  $(`#exportReportModal [name=page]`).val(_pg);
  getExpiratedPackageFiles(_pg);
}

const handleChangePageSize = async (page, pageSize) => {
  $("#expiratedPackageContainer #countPageSize").html(pageSize);
  $("#expiratedPackageContainer [name=page]").val(page);
  $("#expiratedPackageContainer [name=pageSize]").val(pageSize);

  getExpiratedPackages(true);
};

const handleChangePageSizeModalExpiratedPackage = async (page, pageSize) => {
  $("#exportReportModal #countPageSize").html(pageSize);
  $("#exportReportModal [name=page]").val(page);
  $("#exportReportModal [name=pageSize]").val(pageSize);

  getExpiratedPackageFiles(page);
};

const getExpiratedPackageFiles = async (page = 1) => {
  let _page = $("#exportReportModal #page").val();
  let _pageSize = $("#exportReportModal #report-page-size").val().trim();
  let isValid = validatePageSize();

  if (!isValid) {
    return;
  }
  StartProcess();
  try {
    if (totalRecords > 0) {
      let fileNum =  $("#exportReportModal [name=pageSize]").val() || 10;
      $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-danger");
      $("#addBtnDownloadAll #btnDownloadAll").addClass("text-darker");
      $("#addBtnDownloadAll #btnDownloadAll").off("click");

      let stt = Math.ceil(totalRecords / _pageSize);
      let pagingExport = paging2HTML(stt, _page, fileNum, handleChangePageModal);
      $("#exportReportModal #total_record").html(stt);
      $("#exportReportModal #pagingTable").html(pagingExport);
      if (stt > 0) {
        $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-darker");
        $("#addBtnDownloadAll #btnDownloadAll").addClass("text-danger");
        $("#addBtnDownloadAll #btnDownloadAll").on("click", function () {
          downloadExpiratePackageFiles();
        });
      }
      let mtml =
        "<table id='file_export' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
        "<thead style='background-color: #FBCCD6;'>" +
        `<th class="text-center">` +
        Messages("STT") +
        "</th>" +
        `<th>` +
        Messages("File") +
        "</th>" +
        `<th>` +
        Messages("Thao tác ") +
        "</th>" +
        "</thead>" +
        "<tbody>";
      let filesRemaining =
        stt - fileNum * (page - 1) > fileNum
          ? fileNum
          : stt - fileNum * (page - 1);
      for (let i = 1; i <= filesRemaining; i++) {
        let name = `Export_ExpirationDate_Package_${fileNum * (page - 1) + i}`;
        mtml += "<tr>";
        mtml += `<td class="text-center">${fileNum * (page - 1) + i}</td>`;
        mtml += `<td class="text-danger">${name}</td>`;
        mtml += `<td><a class='down_file_excel' style='color: #EA0033; cursor: pointer;text-decoration: underline;' onclick='exportExpiratedPackageToExcel(${
          fileNum * (page - 1) + i
        })'>${Messages("Tải xuống")}</a></td>`;
        mtml += "</tr>";
      }

      mtml += "</tbody></table>";
      $("#report-export-table-container").html(mtml);
    } else {
      $("#report-export-table-container").html("");
      showNotification("danger", Messages("report.expirated.js.noData"));
    }
  } catch (error) {
    console.error("Error fetching blocked subscriber files:", error);
  }
  FinishProcess();
};

function downloadExpiratePackageFiles() {
  let downloadButtons = $(".down_file_excel");
  let index = 0;

  let downloadAllButton = $("#btnDownloadAll");
  downloadAllButton.text("Đang tải...");
  downloadAllButton.css("pointer-events", "none");

  let spinner = $(
    "<span class='spinner-border spinner-border-sm ml-2' role='status' aria-hidden='true'></span>"
  );
  downloadAllButton.append(spinner);

  function clickNextButton() {
    if (index < downloadButtons.length) {
      $(downloadButtons[index]).click();
      index++;
      setTimeout(clickNextButton, 1000); // 1 second delay
    } else {
      // Re-enable the "Tải tất cả" button and reset text after all downloads
      downloadAllButton.text("Tải tất cả");
      downloadAllButton.css("pointer-events", "auto");
    }
  }

  clickNextButton();
}

const exportExpiratedPackageToExcel = async (_page) => {
  let isDn = $("#statisticalReportSearchForm #isDn").val().trim();
  let contractId = $("#statisticalReportSearchForm #contractId").val().trim();
  let from = $("#statisticalReportSearchForm #dateFrom").val().trim();
  let to = $("#statisticalReportSearchForm #dateTo").val().trim();
  if (!validateTime(from, to)) {
    return showNotification(
      "danger",
      Messages("Vui lòng chọn Từ ngày lớn hơn Đến ngày!")
    );
  }
  let page = _page;
  let pageSize = $("#report-page-size").val().trim();

  let body = new FormData();
  body.userId = userId;
  body.limit = pageSize;
  body.offset = (page - 1) * pageSize;
  body.isDn = isDn ? nomoralizePhoneNumber(isDn) : "";
  body.contractId = contractId ? contractId : "";
  body.from = from ? moment(from, "DD/MM/YYYY").format("YYYY-MM-DD") : "";
  body.to = to ? moment(to, "DD/MM/YYYY").format("YYYY-MM-DD") : "";

  StartProcess();
  let r =
    jsRoutes.controllers.TelcoStatisticalReportController.getExpiratedPackages();
  await $.ajax({
    type: r.type,
    data: JSON.stringify(body),
    contentType: "application/json; charset=utf-8",
    url: r.url,
    success: async function (data) {
      try {
        if (data.content) {
          const { data: tableData } = data.content;
          if (!tableData || tableData.length === 0) {
            showNotification("danger", Messages("report.expirated.js.noDataToExport"));
            return;
          }
          const columnTitles = [
            Messages("STT"),
            Messages("Số thuê bao"),
            Messages("Mã hợp đồng"),
            Messages("Loại thuê bao"),
            Messages("Gói cước"),
            Messages("Ngày hết hạn gói cước"),
          ];
          let idExportTable = "exportReportTable";
          exportTable = document.createElement("table");
          exportTable.setAttribute("class", "apn-table-exported");
          exportTable.setAttribute("id", idExportTable);
          exportTable.setAttribute("style", "margin-top: 100%");
          document.body.appendChild(exportTable);

          var tableThead = document.createElement("thead");
          var tableTheadTr = document.createElement("tr");
          for (var j = 0; j < columnTitles.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitles[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
          }
          tableThead.appendChild(tableTheadTr);
          exportTable.appendChild(tableThead);
          var tableTbody = document.createElement("tbody");
          // create table body
          for (var i = 0; i < tableData.length; i++) {
            let tableTbodyTr = document.createElement("tr");
            for (var col = 0; col < columnTitles.length; col++) {
              let td = document.createElement("td");
              switch (col) {
                case 0:
                  td.appendChild(document.createTextNode(i + 1));
                  break;
                case 1:
                  td.appendChild(document.createTextNode(tableData[i].isdn));
                  break;
                case 2:
                  td.appendChild(
                    document.createTextNode(
                      tableData[i].contract_id !== "0"
                        ? tableData[i].contract_id
                        : "--"
                    )
                  );
                  break;
                case 3:
                  td.appendChild(
                    document.createTextNode(tableData[i].pay_type)
                  );
                  break;
                case 4:
                  td.appendChild(
                    document.createTextNode(tableData[i].package_name)
                  );
                  break;
                case 5:
                  td.appendChild(
                    document.createTextNode(
                      moment(tableData[i].expired_date).format("HH:mm DD/MM/YYYY")
                    )
                  );
                  break;

                default:
                  td.appendChild(document.createTextNode(""));
                  break;
              }
              tableTbodyTr.appendChild(td);
            }
            tableTbody.append(tableTbodyTr);
          }
          exportTable.appendChild(tableTbody);

          //
          var x = document.getElementById(idExportTable).rows.length;
          if (x > 1) {
            var tableEx = $("#" + idExportTable);
            var table2excel = new Table2Excel({
              defaultFileName: `Export_ExpirationDate_Package_${_page}`,
              tableNameDataAttribute: "myTableExport",
            });
            await table2excel.export(tableEx);
          } else {
            showNotification("danger", Messages("Dữ liệu không có sẵn"));
          }
          $("#" + idExportTable).remove();
        } else {
          showNotification("danger", Messages("Lấy dữ liệu không thành công"));
        }
      } catch (error) {
        console.error("Error exporting data:", error);
        showNotification("danger", Messages("Lỗi khi xuất dữ liệu"));
      }
    },
    error: function (xhr) {
      console.log(xhr);
      showNotification("danger", Messages("connection.failed"));
    },
    complete: function () {
      FinishProcess();
    },
  });
};


function paging2HTML(total, page, pageSize, handleSearch = () => {}) {
  console.log({ total, page, pageSize });
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
