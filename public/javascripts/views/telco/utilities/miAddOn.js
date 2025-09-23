/**
 * Created by vtk-anhlt166 on 12/29/22.
 */
var PAY_TYPE = {
    UNKNOWN: {value: 0, name: ""},
    SAU: {value: 1, name: Messages("utilities.postpaid")},
    TRUOC: {value: 2, name: Messages("utilities.prepaid")}
};
function getPayTypeByCode(code) {
    code = parseInt(code);
    if(code == PAY_TYPE.SAU.value){
        return PAY_TYPE.SAU.name;
    } else if(code == PAY_TYPE.TRUOC.value){
        return PAY_TYPE.TRUOC.name;
    } else {
        return PAY_TYPE.UNKNOWN.name;
    }
}
var listPackMiAddOn = new Array;
function getListPackMiAddOn() {
    // StartProcess();
    var r = jsRoutes.controllers.TelcoUtilitiesController.getListPackMiAndAddOn();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getListPackMiAddOn', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.success){
                listPackMiAddOn = [];
                if(datas.content.data != null && datas.content.data.length > 0){
                    datas.content.data.sort((a, b) => a.name.localeCompare(b.name));

                    listPackMiAddOn = datas.content.data;
                }
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function appendTablePackMiAddon() {
    $("#tableRegisterMiAddon").html("");
    var mtml = "";
    mtml += "<table id='smlTableRegisterMiAddon' class='table table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th style='text-align: center'>"+Messages("common.stt")+"</th>" +
        "<th>"+Messages("utilities.packageName")+"</th>" +
        "<th>"+Messages("utilities.type")+"</th>" +
        "<th>"+Messages("utilities.details")+"</th>" +
        "<th style='text-align: center'>"+Messages("utilities.select")+"</th>" +
        "</thead>" +
        "<tbody>";
    for(var i=0; i<listPackMiAddOn.length; i++){
        mtml += "<tr>";
        mtml += "<td align='center'>" + (i+1) + "</td>";
        mtml += "<td>" + listPackMiAddOn[i].name + " (" + Messages("utilities.code") + ": " + listPackMiAddOn[i].code+ ")" + "</td>";
        mtml += "<td>" + getPayTypeByCode(listPackMiAddOn[i].payType) + "</td>";
        mtml += "<td>" + listPackMiAddOn[i].description + "</td>";
        mtml += "<td align='center'>" +'<input class="form-check-input" type="checkbox" name="flexRadioDefault" value="'+listPackMiAddOn[i].code+'" namepack="'+listPackMiAddOn[i].name+'" onchange="choosePackMiAddon(this)" >'+ "</td>";
        mtml += "</tr>";
    }

    mtml += "</tbody></table>";
    $("#tableRegisterMiAddon").html(mtml);
    $("#smlTableRegisterMiAddon").DataTable({
        lengthChange: false,
        "info": true,
        bSort: false,
        "order": false,
        "paging" : true,
        searching: true,
        language: { 
            search: "",
            searchPlaceholder: Messages("utilities.enterPackageName"),
            infoEmpty: Messages("common.noResultsFound"),
            info: Messages("common.showingPage"),
            zeroRecords: Messages("common.noResultsFound"),
            paginate: {
                first: Messages("common.first"),
                last: Messages("common.last"),
                next: Messages("common.next"),
                previous: Messages("common.previous")
            },
            lengthMenu: Messages("common.showEntries"),
            emptyTable: Messages("common.noData"),
            sInfoFiltered: "(lọc từ tổng số _MAX_ dòng)",
            sInfoThousands: ",",
            sLoadingRecords: "Đang tải...",
            sProcessing: "Đang xử lý...",
        },
    })
}

var codeRegisterMiAddon = "";
var nameRegisterMiAddon = "";
function choosePackMiAddon(el) {
    var table = $("#smlTableRegisterMiAddon").DataTable();
    var rows = table.rows({ 'search': 'applied' }).nodes();
    $('input[value="'+codeRegisterMiAddon+'"]', rows).prop('checked', !el.checked);
    // console.log(el);
    codeRegisterMiAddon = el.value;
    nameRegisterMiAddon = el.getAttribute('namepack');
}

function comfirmRegisterMiAddon() {
    listMiAddonSubsRegister = [];
    $("#dataImportMiAddOn .checkbox-MiAddonSub").each(function() {
        if(this.checked){
            listMiAddonSubsRegister.push(this.value);
        }
    });

    if(listMiAddonSubsRegister.length > 0){
        if(nameRegisterMiAddon.length > 0){
            $("#textComfirmRegisterMiAddon").html('Bạn có chắc chắn muốn thực hiện đăng kí gói ' + nameRegisterMiAddon + ' cho ' + listMiAddonSubsRegister.length + ' thuê bao?');
            $("#registerMiAddonModal").modal('hide');
            $("#comfirmRegisterMiAddonModal").modal('show');
            console.log(listMiAddonSubsRegister);
        } else {
            showNotification('danger',Messages("Bạn chưa chọn gói cước MI, Add-on"));
        }
    } else {
        showNotification('danger',Messages("Không có thuê bao được chọn để đăng ký"));
    }
}

var countRegisterMiAddonSuccess = 0;
function processRegisterMiAddon(index) {
    let body = new FormData;
    body.param = "/api/telco/data/register/bulk";
    body.body = {
        isdns: listMiAddonSubsRegister,
        vasCode: codeRegisterMiAddon,
        pkgName: nameRegisterMiAddon,
        userId: userId,
    }
    console.log("body", body);
    StartProcess();
    let route = jsRoutes.controllers.SendApiController.portDataWithParam();
    $.ajax({
        type: route.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data,"data")
            if (data.content) {
                data.content.forEach(item => {
                    let $result = $(`#dataImportMiAddOn #result-MiAddon-${item.isdn}`);
                    let $reason = $(`#dataImportMiAddOn #reason-MiAddon-${item.isdn}`);
                    $(`#dataImportMiAddOn #pack-MiAddon-${item.isdn}`).html(nameRegisterMiAddon);
                    $(`#dataImportMiAddOn #action-MiAddon-${item.isdn}`).html("Đăng ký");

                    if (item.errCode === "0" || item.failed_on === "") {
                        $result.html(`<span class='text-success'>${Messages("Đăng ký thành công")}</span>`);
                        $reason.html("");
                    } else {
                        let reason = getErrorMessages(item.errCode, item?.failed_on, item.description, item.message);
                        $result.html(`<span class='text-danger'>${Messages("Đăng ký không thành công")}</span>`);
                        $reason.html(reason);
                    }
                });
            } else {
                listMiAddonSubsRegister.forEach(isdn => {
                    $(`#dataImportMiAddOn #pack-MiAddon-${isdn}`).html(nameRegisterMiAddon);
                    $(`#dataImportMiAddOn #action-MiAddon-${isdn}`).html("Đăng ký");
                    $(`#dataImportMiAddOn #result-MiAddon-${isdn}`).html(`<span class='text-danger'>${Messages("Đăng ký không thành công")}</span>`);
                    $(`#dataImportMiAddOn #reason-MiAddon-${isdn}`).html(Messages("Không có dữ liệu"));
                });
            }
        },
        complete: function () {
            FinishProcess();
        }
    });
}
function lowercaseFirstLetter(str) {
    return str ? str.charAt(0).toLowerCase() + str.slice(1) : null;
}

function getErrorMessages(errCode, failed_on, description, messages) {
    // Hàm viết thường chữ cái đầu của description
    if (errCode === "2411") {
        return Messages("So thue bao khong hop le");
    } else if (errCode === "2408") {
        return Messages("Khong tim thay thong tin thue bao");
    } else if (errCode === "2001") {
        return Messages("Du lieu khong hop le");
    }  else if (errCode === "2407" || errCode === "2406" || errCode === "-1") {
        return Messages("Co loi xay ra, vui long thu lai sau");
    } else {
        var formattedDescription = lowercaseFirstLetter(description);
        var formattedMessages = lowercaseFirstLetter(messages);
        if (failed_on == "Unregister") {
            return Messages(`Huy goi khong thanh cong do ${formattedMessages}`);
        } else if (failed_on == "Register") {
            return Messages(`Dang ky khong thanh cong do ${formattedMessages}`);
        }
        return Messages(formattedMessages);
    }
}

//import file data
var dataImportMiAddonSubs = new Array();
var listMiAddonSubsRegister = new Array();
var arrayIsdnMiAddonSubs = new Array();
var listMiAddonSubsTrue = new Array();
var listMiAddonSubsFalse = new Array();
function uploadMiAddonSubs(evt) {
    dataImportMiAddonSubs = [];
    arrayIsdnMiAddonSubs = [];
    listMiAddonSubsTrue = [];
    listMiAddonSubsFalse = [];

    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var fileList = evt.target.files;
        console.log("fileList", fileList);
        var file = fileList[0];
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("File không đúng format xlsx"));
            return;
        }
        $("#nameFileMiAddOnSubs").val(file.name);

        var reader = new FileReader();
        reader.readAsBinaryString(file);
        reader.onload = function (event) {
            var data = event.target.result;
            var workbook = XLSX.read(data, {
                type: 'binary'
            });
            var firstSheet = workbook.SheetNames[0];
            console.log(firstSheet.name);
            //header: 1 de lay deader
            dataImportMiAddonSubs = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(dataImportMiAddonSubs);
            if(dataImportMiAddonSubs.length > 1){
                for(var i=1; i<dataImportMiAddonSubs.length; i++){
                    if(dataImportMiAddonSubs[i][1] != null){
                        if(validatePhone(dataImportMiAddonSubs[i][1])){
                            if(!arrayIsdnMiAddonSubs.includes(dataImportMiAddonSubs[i][1])){
                                arrayIsdnMiAddonSubs.push(dataImportMiAddonSubs[i][1]);
                                listMiAddonSubsTrue.push(dataImportMiAddonSubs[i][1]);
                            }
                        } else {
                            listMiAddonSubsFalse.push(dataImportMiAddonSubs[i][1]);
                        }
                    }
                }

                $("#countMiAddonSubsTrue").html(listMiAddonSubsTrue.length);
                $("#countMiAddonSubsFalse").html(listMiAddonSubsFalse.length);

                if (listMiAddonSubsTrue.length > 0) {
                    $("#checkChangeInformation").prop("disabled", false);
                } else {
                    $("#checkChangeInformation").prop("disabled", true);
                }
            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
                $("#checkChangeInformation").prop("disabled", true);
                return;
            }
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesMiAddOnSubs").value = "";
    }
}

function comfirmTableListSubsMiAddon() {
    $("#checkChangeInformation").prop("disabled", true);
    if(listMiAddonSubsTrue.length > 0){
        if (!positionListRender) {
            showNotification('danger',Messages("Vui lòng tải lại trang"));
            return;
        }
        $(`#${positionListRender}`).html("");
        var mtml = "";
        mtml+="<div style='height: 27rem;overflow: scroll'>";
        mtml += "<table id='export-" + positionListRender + "' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
            "<thead style='background:#FBCCD6'>" +
            "<th>"+"<input type='checkbox' id='checkall-MiAddonSub' onchange='checkAllMiAddonSubs(this)' checked>"+"</th>" +
            "<th>"+Messages("STT")+"</th>" +
            "<th>"+Messages("Số thuê bao")+"</th>" +
            "<th>"+Messages("Thao tác")+"</th>";
        if (positionListRender === "dataImportMiAddOnChangelPackage") {
            mtml += "<th>"+Messages("Gói cước cũ")+"</th>";
            mtml += "<th>"+Messages("Gói cước mới")+"</th>";
        } else {
            mtml += "<th>"+Messages("Gói cước")+"</th>";
        }
        mtml += "<th>"+Messages("Kết quả")+"</th>" +
            "<th>"+Messages("Lý do")+"</th>" +
            "</thead>" +
            "<tbody>";
        for(var i=0; i<listMiAddonSubsTrue.length; i++){
            mtml += "<tr>";
            mtml += "<td>" +"<input type='checkbox' class='checkbox-MiAddonSub' value='"+listMiAddonSubsTrue[i]+"' onchange='checkListCheckboxMiAddon()' checked='true'>"+ "</td>";
            mtml += "<td>" +(i+1)+ "</td>";
            mtml += "<td>" + listMiAddonSubsTrue[i] + "</td>";
            mtml += "<td class='wrap-text' id='action-MiAddon-"+listMiAddonSubsTrue[i]+"'></td>";
            if (positionListRender === "dataImportMiAddOnChangelPackage") {
                mtml += "<td class='wrap-text' id='old-pack-MiAddon-"+listMiAddonSubsTrue[i]+"'></td>";
                mtml += "<td class='wrap-text' id='pack-MiAddon-"+listMiAddonSubsTrue[i]+"'></td>";
            } else {
                mtml += "<td class='wrap-text' id='pack-MiAddon-"+listMiAddonSubsTrue[i]+"'></td>";
            }
            mtml += "<td class='wrap-text' id='result-MiAddon-"+listMiAddonSubsTrue[i]+"'></td>";
            mtml += "<td class='wrap-text' id='reason-MiAddon-"+listMiAddonSubsTrue[i]+"'></td>";
            mtml += "</tr>";
        }

        mtml += "</tbody></table></div>";
        $(`#${positionListRender}`).html(mtml);
        positionListRender = null; // reset
    } else {
        showNotification('danger',Messages("Không có thuê bao hợp lệ"));
    }
    listMiAddonSubsUnregister = [];
    listMiAddonSubsUnextend = [];
    $("#nameFileMiAddOnSubs").val("");
    $("#countMiAddonSubsTrue").html("0");
    $("#countMiAddonSubsFalse").html("0");
}

function checkListCheckboxMiAddon() {
    var countCheckbox = true;
    $(".checkbox-MiAddonSub").each(function() {
        if(!this.checked){
            countCheckbox = false;
        }
    });
    if(countCheckbox){
        document.getElementById("checkall-MiAddonSub").checked = true;
    } else {
        document.getElementById("checkall-MiAddonSub").checked = false;
    }
}
function checkAllMiAddonSubs(el) {
    $(".checkbox-MiAddonSub").each(function() {
        this.checked = el.checked;
    });
}

function exportResultMiAddon(idTable) {
    var exportTable = document.getElementById("export-" + idTable);
    
    if (exportTable) {
        var rowLength = exportTable.rows.length;
        if (rowLength < 1) {
            showNotification('danger', Messages("Dữ liệu không có sẵn"));
            return;
        }

        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableResutlUltilities");
        document.body.appendChild(table);

        var thead = document.createElement("thead");
        var headerRow = document.createElement("tr");

        // Custom render header for dataImportMiAddOnChangelPackage
        if (idTable === "dataImportMiAddOnChangelPackage") {
            ["STT", "Số thuê bao", "Thao tác", "Gói cước cũ", "Gói cước mới", "Kết quả", "Lý do"].forEach(text => {
                var th = document.createElement("th");
                th.textContent = Messages(text);
                headerRow.appendChild(th);
            });
        } else {
            // Default case
            ["STT", "Số thuê bao", "Thao tác", "Gói cước", "Kết quả", "Lý do"].forEach(text => {
                var th = document.createElement("th");
                th.textContent = Messages(text);
                headerRow.appendChild(th);
            });
        }

        thead.appendChild(headerRow);
        table.appendChild(thead);

        var tbody = document.createElement("tbody");

        for (var i = 1; i < rowLength; i++) {
            var cells = exportTable.rows[i].cells;
            var tr = document.createElement("tr");

            // Custom render for dataImportMiAddOnChangelPackage
            if (idTable === "dataImportMiAddOnChangelPackage") {
                // cells[1] = STT, 2 = Số TB, 3 = Thao tác, 4 = Gói cước cũ, 5 = Gói cước mới, 6 = Kết quả, 7 = Lý do
                for (var j = 1; j <= 7; j++) {
                    var td = document.createElement("td");
                    td.textContent = cells[j]?.innerText || "";
                    tr.appendChild(td);
                }
            } else {
                // Default render
                for (var j = 1; j <= 6; j++) {
                    var td = document.createElement("td");
                    td.textContent = cells[j]?.innerText || "";
                    tr.appendChild(td);
                }
            }

            tbody.appendChild(tr);
        }

        table.appendChild(tbody);

        var tableEx = $('#tableResutlUltilities');
        var table2excel = new Table2Excel({ defaultFileName: "Export_DS_Thue_bao_mi_addon" });
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger', Messages("Dữ liệu không có sẵn"));
    }
}

function cancleImportFileMiAddon() {
    $("#importListSubMiAddonModal").modal('hide');
    listMiAddonSubsRegister = [];
    listMiAddonSubsUnregister = [];
    listMiAddonSubsUnextend = [];
    $("#nameFileMiAddOnSubs").val("");
    $("#countMiAddonSubsTrue").html("0");
    $("#countMiAddonSubsFalse").html("0");
}

// open modal
var positionListRender = null;
function openSubMiAddonModal(positionRender) {
    $("#importListSubMiAddonModal").modal('show');
    positionListRender = positionRender;
    
}