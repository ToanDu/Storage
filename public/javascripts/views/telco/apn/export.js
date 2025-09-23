const idExportTable = "apn-export-table";
var apnExportTable;

function getSubscriberFiles(page = 1) {
  var body = new FormData();
  body.userId = userId;
  body.page = $("#apn-page").val();
  body.pageSize = $("#apn-page-size").val().trim();

  const isValid = validatePageSize();

  if (!isValid) {
    return;
  }

  StartProcess();
  var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
  $.ajax({
    type: r.type,
    data: JSON.stringify(body),
    contentType: "application/json; charset=utf-8",
    url: r.url,
    success: function (data) {
      if (data.content) {
        pagingTable(
          Math.ceil(data.content.countSubscriber / body.pageSize),
          page
        );
      }

      $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-danger");
      $("#addBtnDownloadAll #btnDownloadAll").addClass("text-darker");

      if (data.content) {
        if (data.content.countSubscriber > 0) {
          var pagesize = body.pageSize;
          var stt = Math.ceil(data.content.countSubscriber / pagesize);

          if (stt > 0) {
            $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-darker");
            $("#addBtnDownloadAll #btnDownloadAll").addClass("text-danger");
            $("#addBtnDownloadAll #btnDownloadAll").on("click", function () {
              downloadAllFiles();
            });
          }
          var mtml =
            "<table id='file_export' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
            "<thead style='background-color: #FBCCD6;'>" +
            `<th class="text-center">` +
            Messages("apn.export.serialNumber") +
            "</th>" +
            `<th>` +
            Messages("apn.export.file") +
            "</th>" +
            `<th>` +
            Messages("apn.export.action") +
            "</th>" +
            "</thead>" +
            "<tbody>";
          for (var i = 1; i <= stt; i++) {
            var name = `APN_info_${i}`;
            mtml += "<tr>";
            mtml += `<td class="text-center">${i}</td>`;
            mtml += `<td class="text-danger">${name}</td>`;
            mtml += `<td><a class='down_file_excel' style='color: #EA0033; cursor: pointer;text-decoration: underline;' onclick='exportAPNToExcel(${i})'>${Messages(
              "apn.export.download"
            )}</a></td>`;
            mtml += "</tr>";
          }

          mtml += "</tbody></table>";
          $("#apn-export-table-container").html(mtml);
        } else {
          $("#apn-export-table-container").html("");
          showNotification("danger", Messages("apn.js.noData"));
        }
      } else {
        showNotification("danger", Messages("error.getData"));
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
}

//paging
function pagingTable(total, page) {
  const pageSize = 10;
  var paging =
    `<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">${Messages(
      "apn.export.total"
    )}${total}${Messages("apn.export.files")}</label>` +
    `<ul class="pagination" style="float: right!important; margin: 0px 0;">`;

  if (page > 1) {
    paging +=
      `<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,${pageSize})"> << </a></li>` +
      `<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(${
        parseInt(page) - 1
      },${pageSize})"> < </a></li>`;
  }

  for (var item = 1; item < 2; item++) {
    if (parseInt(page) - item > 0) {
      paging += `<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(${
        parseInt(page) - item
      },${pageSize})">${parseInt(page) - item}</a></li>`;
    }
  }

  paging += `<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch(${parseInt(
    page
  )},${pageSize})">${page}</a></li>`;

  var getTotalPage = Math.floor(total / pageSize);
  if (total % pageSize >= 1) {
    getTotalPage++;
  }
  for (var item = 1; item < 2; item++) {
    if ((parseInt(page) + item) * pageSize <= total) {
      paging += `<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(${
        parseInt(page) + item
      },${pageSize})">${parseInt(page) + item}</a></li>`;
    }
  }

  if (parseInt(page) * pageSize < total) {
    paging +=
      `<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(${
        parseInt(page) + 1
      },${pageSize})"> > </a></li>` +
      `<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(${getTotalPage},${pageSize})"> >> </a></li>`;
  }

  paging += "</ul>";

  $("#pagingAPNTable").html(paging);
}

function applySearch(page) {
  $("#apn-page").val(page);
  getSubscriberFiles();
}

function downloadAllFiles() {
  let downloadButtons = $(".down_file_excel");
  let index = 0;

  let downloadAllButton = $("#btnDownloadAll");
  downloadAllButton.text(Messages("apn.export.downloading"));
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
      downloadAllButton.text(Messages("apn.export.downloadAll"));
      downloadAllButton.css("pointer-events", "auto");
    }
  }

  clickNextButton();
}

function exportAPNToExcel(_page) {
  var body = new FormData();
  body.userId = userId;
  body.page = _page;
  body.pageSize = $("#apn-page-size").val();

  StartProcess();
  var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
  $.ajax({
    type: r.type,
    data: JSON.stringify(body),
    contentType: "application/json; charset=utf-8",
    url: r.url,
    success: async function (data) {
      try {
        if (data.content) {
          const { listSubscriber } = data.content;
          const isdns = listSubscriber?.map(
            (subscriber, index) => subscriber.isdn
          );
          const resp = await getAPNByPhoneNumbers(isdns);
          const appData = resp?.content?.data ?? [];
          const dataExport = listSubscriber.map((subscriber, index) => {
            const apnInfo =
              appData.find((item) => item.isdn == subscriber.isdn) || {};
            const privateApns = apnInfo?.apns ? apnInfo?.apns : [];
            return {
              ...subscriber,
              apnDefault: apnInfo.apn_default,
              apnPrivate: privateApns,
            };
          });

          const columnTitles = [
            Messages("apn.table.stt"),
            Messages("apn.table.subscriberNumber"),
            Messages("apn.table.simSerial"),
            Messages("apn.table.serviceType"),
            Messages("apn.table.servicePackage"),
            Messages("apn.table.contractCode"),
            Messages("apn.table.customerCode"),
            Messages("apn.table.defaultAPN"),
            Messages("apn.table.privateAPNIP"),
            Messages("apn.table.startEndDate"),
          ];
          apnExportTable = document.createElement("table");
          apnExportTable.setAttribute("class", "apn-table-exported");
          apnExportTable.setAttribute("id", idExportTable);
          apnExportTable.setAttribute("style", "margin-top: 100%");
          document.body.appendChild(apnExportTable);

          // create table head
          var tableThead = document.createElement("thead");
          var tableTheadTr = document.createElement("tr");

          for (var j = 0; j < columnTitles.length; j++) {
            var th = document.createElement("th");
            var value = document.createTextNode(columnTitles[j]);
            th.appendChild(value);
            tableTheadTr.appendChild(th);
          }
          tableThead.appendChild(tableTheadTr);
          apnExportTable.appendChild(tableThead);

          var tableTbody = document.createElement("tbody");
          apnExportTable.appendChild(tableTbody);
          createTable(dataExport, _page, body.pageSize, columnTitles);

          var x = document.getElementById(idExportTable).rows.length;
          if (x > 1) {
            var tableEx = $("#" + idExportTable);
            var table2excel = new Table2Excel({
              defaultFileName: `APN_info_${_page}`,
              tableNameDataAttribute: "myTableExport",
            });
            await table2excel.export(tableEx);
          } else {
            showNotification("danger", Messages("apn.js.noDataAvailable"));
          }
          $("#" + idExportTable).remove();
        } else {
          showNotification("danger", Messages("error.getData"));
        }
      } catch (error) {
        console.error("Error exporting data:", error);
        showNotification("danger", Messages("apn.export.error"));
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

  function createTable(data, index, pageSize, columnTitles) {
    // create table rows
    var tableBody = $("#" + idExportTable).find("tbody");
    for (var i = 0; i < data.length; i++) {
      if (data[i].apnPrivate.length === 0) {
        let tableTbodyTr = document.createElement("tr");
        for (var col = 0; col < columnTitles.length; col++) {
          let td = document.createElement("td");
          let stt = (index - 1) * pageSize;
          switch (col) {
            case 0:
              td.appendChild(document.createTextNode(stt + i + 1));
              break;
            case 1:
              td.appendChild(document.createTextNode(data[i].isdn));
              break;
            case 2:
              td.appendChild(document.createTextNode("'" + data[i].serial));
              break;
            case 3:
              td.appendChild(document.createTextNode(data[i].payTypeView));
              break;
            case 4:
              td.appendChild(document.createTextNode(data[i].productCode));
              break;
            case 5:
              td.appendChild(document.createTextNode(data[i].accountId));
              break;
            case 6:
              td.appendChild(document.createTextNode(data[i].custId));
              break;
            case 7:
              td.appendChild(
                document.createTextNode(data[i].apnDefault ? Messages("common.yes") : Messages("common.no"))
              );
              break;
            case 8:
              td.appendChild(document.createTextNode(""));

              break;
            case 9:
              td.appendChild(document.createTextNode(""));
              break;
          }

          tableTbodyTr.appendChild(td);
        }
        tableBody.append(tableTbodyTr);
      } else {
        data[i].apnPrivate.forEach((_apn, ind) => {
          let tableTbodyTr = document.createElement("tr");
          for (var col = 0; col < columnTitles.length; col++) {
            let stt = (index - 1) * pageSize;
            if (ind === 0) {
              let td = document.createElement("td");

              if (col !== 8 && col !== 9) {
                td.rowSpan = data[i].apnPrivate.length;
              }
              switch (col) {
                case 0:
                  td.appendChild(document.createTextNode(stt + i + 1));
                  break;
                case 1:
                  td.appendChild(document.createTextNode(data[i].isdn));
                  break;
                case 2:
                  td.appendChild(document.createTextNode("'" + data[i].serial));
                  break;
                case 3:
                  td.appendChild(document.createTextNode(data[i].payTypeView));
                  break;
                case 4:
                  td.appendChild(document.createTextNode(data[i].productCode));
                  break;
                case 5:
                  td.appendChild(document.createTextNode(data[i].accountId));
                  break;
                case 6:
                  td.appendChild(document.createTextNode(data[i].custId));
                  break;
                case 7:
                  td.appendChild(
                    document.createTextNode(data[i].apnDefault ? Messages("common.yes") : Messages("common.no"))
                  );
                  break;
                case 8:
                  td.appendChild(
                    document.createTextNode(
                      _apn
                        ? _apn.apn_name + "/" + (_apn.ip ? _apn.ip : Messages("apn.add.dynamicIP"))
                        : ""
                    )
                  );
                  break;
                case 9:
                  td.appendChild(
                    document.createTextNode(
                      _apn
                        ? `${moment(
                            moment(
                              _apn.sta_datetime,
                              "YYYY-MM-DD'T'HH:mm:ss+07:00"
                            )
                          ).format("DD/MM/YYYY")} - ${moment(
                            moment(
                              _apn.end_datetime,
                              "YYYY-MM-DD'T'HH:mm:ss+07:00"
                            )
                          ).format("DD/MM/YYYY")}`
                        : ""
                    )
                  );
                  break;
              }
              tableTbodyTr.appendChild(td);
            } else {
              if (col === 8) {
                let td = document.createElement("td");
                td.appendChild(
                  document.createTextNode(
                    _apn
                      ? _apn.apn_name + "/" + (_apn.ip ? _apn.ip : Messages("apn.add.dynamicIP"))
                      : ""
                  )
                );
                tableTbodyTr.appendChild(td);
              } else if (col === 9) {
                let td = document.createElement("td");
                td.appendChild(
                  document.createTextNode(
                    _apn
                      ? `${moment(
                          moment(
                            _apn.sta_datetime,
                            "YYYY-MM-DD'T'HH:mm:ss+07:00"
                          )
                        ).format("DD/MM/YYYY")} - ${moment(
                          moment(
                            _apn.end_datetime,
                            "YYYY-MM-DD'T'HH:mm:ss+07:00"
                          )
                        ).format("DD/MM/YYYY")}`
                      : ""
                  )
                );
                tableTbodyTr.appendChild(td);
              }
            }
          }
          tableBody.append(tableTbodyTr);
        });
      }
    }
  }
}
