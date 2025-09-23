/**
 * Created by vtk-anhlt166 on 1/3/23.
 */
var dataImportOpenSubs = new Array();
var listOpenSubs = new Array();
var arrayIsdnOpenSubs = new Array();
var listOpenSubsTrue = new Array();
var listOpenSubsFalse = new Array();
var listIdNoOpen1wSubsTrue = new Array;
function uploadOpenSubs(evt) {
    dataImportOpenSubs = [];
    arrayIsdnOpenSubs = [];
    listOpenSubs = [];
    listOpenSubsTrue = [];
    listOpenSubsFalse = [];
    listOpen1SubsTrueSubmit = [];
    listIdNoOpen1wSubsTrue = [];

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
        $("#nameFileOpenSubs").val(file.name);

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
            dataImportOpenSubs = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(dataImportOpenSubs);
            if(dataImportOpenSubs.length > 1){
                for(var i=1; i<dataImportOpenSubs.length; i++){
                    if(dataImportOpenSubs[i][1] != null){
                        if(validatePhone(dataImportOpenSubs[i][1])){
                            if(!arrayIsdnOpenSubs.includes(dataImportOpenSubs[i][1])){
                                arrayIsdnOpenSubs.push(dataImportOpenSubs[i][1]);
                                listOpenSubsTrue.push(dataImportOpenSubs[i][1]);
                            }
                        } else {
                            listOpenSubsFalse.push(dataImportOpenSubs[i][1]);
                        }
                    }
                }

                if(listOpenSubsTrue.length > 0){
                    checkValidateListOpen_1(0);
                }
            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
                return;
            }

            // $("#importOpenSubsModal").modal('hide');
            // document.getElementById('filesOpenSubs').value = '';
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesOpenSubs").value = "";
    }
}

var listOpen1SubsTrueSubmit = new Array;
function checkValidateListOpen_1(index) {
    var body = new FormData();
    body.userId = userId;
    body.isdn = listOpenSubsTrue[index];
    body.actionCode = "08";
    console.log(body);

    if(index == 0){
        StartProcess();
    }
    var r = jsRoutes.controllers.TelcoUtilitiesController.validateSubs();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.valid){
                    listOpen1SubsTrueSubmit.push(listOpenSubsTrue[index]);
                    listIdNoOpen1wSubsTrue[listOpenSubsTrue[index]] = datas.content.data.idNo;
                    listOpenSubs.push(listOpenSubsTrue[index]);
                } else {
                    listOpenSubsFalse.push(listOpenSubsTrue[index])
                }
            } else {
                listOpenSubsFalse.push(listOpenSubsTrue[index])
            }
        },
        error: function (xhr) {
            console.log(xhr);
            listOpenSubsFalse.push(listOpenSubsTrue[index])
        },
        complete: function (){
            // FinishProcess();
            $("#countOpenSubsTrue").html(listOpen1SubsTrueSubmit.length);
            $("#countOpenSubsFalse").html(listOpenSubsFalse.length);

            if(index < listOpenSubsTrue.length-1){
                checkValidateListOpen_1(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}


function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function comfirmTableListSubsOpen() {
    if(listOpen1SubsTrueSubmit.length > 0){
        $("#dataImportOpenSubs").html("");
        var mtml = "";
        mtml+="<div style='height: 27rem;overflow: scroll'>";
        mtml += "<table id='smlTableSubsOpen' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
            "<thead>" +
            "<th>"+"<input type='checkbox' id='checkall-openSub' onchange='checkAllOpenSubs(this)' checked>"+"</th>" +
            "<th>"+Messages("STT")+"</th>" +
            "<th>"+Messages("Số thuê bao")+"</th>" +
            "<th>"+Messages("Tác động")+"</th>" +
            "<th>"+Messages("Kết quả")+"</th>" +
            "<th>"+Messages("Lý do thất bại")+"</th>" +
            "</thead>" +
            "<tbody>";
        for(var i=0; i<listOpen1SubsTrueSubmit.length; i++){
            mtml += "<tr>";
            mtml += "<td>" +"<input type='checkbox' class='checkbox-openSub' value='"+listOpen1SubsTrueSubmit[i]+"' onchange='checkListCheckboxTableOpen()' checked>"+ "</td>";
            mtml += "<td>" +(i+1)+ "</td>";
            mtml += "<td>" + listOpen1SubsTrueSubmit[i] + "</td>";
            mtml += "<td class='wrap-text' id='action-open-"+listOpen1SubsTrueSubmit[i]+"'></td>";
            mtml += "<td class='wrap-text' id='result-open-"+listOpen1SubsTrueSubmit[i]+"'></td>";
            mtml += "<td class='wrap-text' id='noti-open-"+listOpen1SubsTrueSubmit[i]+"'></td>";
            mtml += "</tr>";
        }

        mtml += "</tbody></table></div>";
        $("#dataImportOpenSubs").html(mtml);
    } else {
        showNotification('danger',Messages("Không có thuê bao hợp lệ"));
    }
    $("#nameFileOpenSubs").val("");
    $("#countOpenSubsTrue").html("0");
    $("#countOpenSubsFalse").html("0");
}

function checkListCheckboxTableOpen() {
    var countCheckbox = true;
    $(".checkbox-openSub").each(function() {
        if(!this.checked){
            countCheckbox = false;
        }
    });
    if(countCheckbox){
        document.getElementById("checkall-openSub").checked = true;
    } else {
        document.getElementById("checkall-openSub").checked = false;
    }
}
function checkAllOpenSubs(el) {
    $(".checkbox-openSub").each(function() {
        this.checked = el.checked;
    });
}

function showComfirmOpenSubsModal(action) {
    listOpenSubs = [];
    $(".checkbox-openSub").each(function() {
        if(this.checked){
            listOpenSubs.push(this.value);
        }
    });
    console.log(listOpenSubs);
    if(listOpenSubs.length > 0){
        if(action == 1){
            $("#comfirmOpen1SubsModal").modal('show');
            $("#comfirmCountOpenSubs1").html('Bạn có chắc chắn muốn mở 1 chiều ' + listOpenSubs.length + ' thuê bao?');
        } else if(action == 2) {
            $("#comfirmOpen2SubsModal").modal('show');
            $("#comfirmCountOpenSubs2").html('Bạn có chắc chắn muốn mở 2 chiều ' + listOpenSubs.length + ' thuê bao?');
        } else {
            console.log("action = ", action)
        }
    } else {
        showNotification('danger',Messages("Không tìm thấy danh sách thuê bao mở"));
    }
}

function cancleImportFileOpen() {
    $("#importOpenSubsModal").modal('hide');
    listOpenSubs = [];
    $("#nameFileOpenSubs").val("");
    $("#countOpenSubsTrue").html("0");
    $("#countOpenSubsFalse").html("0");
    // $("#dataImportOpenSubs").html("");
}

var countOpenSubsSuccess = 0;
var orderIdOpen;
function processOpenListSubs() {
    var noti = "1 chiều";
    if(listOpenSubs.length <= 0){
        showNotification('danger',Messages("Không có thuê bao nào được chọn"));
        return;
    }

    var listIsdn = [];
    for(var i=0; i<listOpenSubs.length; i++){
        listIsdn.push({
            "isdn":listOpenSubs[i],
            "id_no":listIdNoOpen1wSubsTrue[listOpenSubs[i]]
        })
    }

    var body = new FormData;
    body.list = listIsdn;
    body.amount = 5000;
    body.user_id = userId;
    body.reason = "Mở chặn 1 chiều";
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.openSubcriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null){
                    orderIdOpen = datas.content.data.order_id;

                    $("#payMyViettelModal").modal('show');

                    window.open(datas.content.data.link_check_out, "_blank");
                }
            } else {
                showNotification('danger',Messages("Lấy link thanh toán không thành công"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function comfirmPayOpenSubsSuccess() {
    var noti = "1 chiều";
    $("#payMyViettelModal").modal('hide');

    if(orderIdOpen != undefined && orderIdOpen != null){
        StartProcess();
        checkStatusSubs(0, noti, orderIdOpen);
    }
}

function checkStatusSubs(index, noti, orderId) {
    var body = new FormData();
    body.isdn = listOpenSubs[index];
    body.order_id = orderId;
    body.userId = userId;
    console.log(body);

    var r = jsRoutes.controllers.TelcoUtilitiesController.getInfoOrderId();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                $("#action-open-"+listOpenSubs[index]).html("Mở "+noti);
                if(datas.content.data != null && datas.content.data.length > 0){
                    var state = datas.content.data[0].state;
                    if(state == "error"){
                        $("#result-open-"+listOpenSubs[index]).html("<span class='text-danger'>"+"Lỗi hệ thống"+"</span>");
                    } else if(state == "processing"){
                        $("#result-open-"+listOpenSubs[index]).html("<span class='text-warning'>"+"Đang xử lý"+"</span>");
                    } else {
                        if(state == "done:0"){
                            $("#result-open-"+listOpenSubs[index]).html("<span class='text-success'>"+"Thành công"+"</span>");
                        } else {
                            $("#result-open-"+listOpenSubs[index]).html("<span class='text-danger'>"+"Không thành công"+"</span>");
                        }
                    }
                    $("#noti-open-"+listOpenSubs[index]).html(datas.content.data[0].message);
                } else {
                    $("#result-open-"+listOpenSubs[index]).html("Thất bại");
                    $("#noti-open-"+listOpenSubs[index]).html("Không tìm thấy dữ liệu");
                }
            } else {
                $("#result-open-"+listOpenSubs[index]).html("Thất bại");
                $("#noti-open-"+listOpenSubs[index]).html("Không tìm thấy dữ liệu");
            }
        },
        complete: function (){
            if(index < listOpenSubs.length-1){
                setTimeout(function () {
                    checkStatusSubs(index+1, noti, orderId);
                },1000);
            } else {
                FinishProcess();

                // if(countBlockSubsSuccess > 0){
                //     $("#textNofitication1").html(Messages("Quý khách đã chặn ") + noti + Messages(" thành công "));
                //     $("#textNofitication2").html(countBlockSubsSuccess + Messages(" thuê bao"));
                //
                //     $("#notificationModal").modal('show');
                // }
            }
        }
    })
}

// function exportResultListSubsOpen() {
//     if(document.getElementById("smlTableSubsOpen") != null){
//         var x = document.getElementById("smlTableSubsOpen").rows.length;
//         if(x > 1){
//             var tableEx = $('#smlTableSubsOpen');
//             var table2excel = new Table2Excel({defaultFileName: "Export_Result_Subs_Open", tableNameDataAttribute: "myTableExport"});
//             table2excel.export(tableEx);
//         } else {
//             showNotification('danger',Messages("Dữ liệu không có sẵn"));
//         }
//     } else {
//         showNotification('danger',Messages("Dữ liệu không có sẵn"));
//     }
// }
function exportResultListSubsOpen() {
    if(document.getElementById("smlTableSubsOpen") != null){
        var oTable = document.getElementById('smlTableSubsOpen');
        var rowLength = oTable.rows.length;
        if(rowLength < 1){
            showNotification('danger',Messages("Dữ liệu không có sẵn"));
        } else {
            var table = document.createElement("table");
            table.setAttribute("class", "table");
            table.setAttribute("id", "tableResutlSubsOpen");
            document.body.appendChild(table);
            var tablethread=document.createElement("thead");
            var tablethreadtr=document.createElement("tr");

            var th0=document.createElement("th");
            var t0 = document.createTextNode(Messages("STT"));
            th0.appendChild(t0);
            tablethreadtr.appendChild(th0);

            var th1=document.createElement("th");
            var t1 = document.createTextNode(Messages("Số TB"));
            th1.appendChild(t1);
            tablethreadtr.appendChild(th1);

            var th2=document.createElement("th");
            var t2 = document.createTextNode(Messages("Tác động"));
            th2.appendChild(t2);
            tablethreadtr.appendChild(th2);

            var th4=document.createElement("th");
            var t4 = document.createTextNode(Messages("Kết quả"));
            th4.appendChild(t4);
            tablethreadtr.appendChild(th4);

            var th5=document.createElement("th");
            var t5 = document.createTextNode(Messages("Lý do"));
            th5.appendChild(t5);
            tablethreadtr.appendChild(th5);

            tablethread.appendChild(tablethreadtr);
            table.appendChild(tablethread);

            var tablebody=document.createElement("tbody");

            for (var i = 1; i < rowLength; i++){
                var oCells = oTable.rows.item(i).cells;
                var tabletr=document.createElement("tr");

                var td0=document.createElement("td");
                var text0 = document.createTextNode(oCells.item(1).innerText);
                td0.appendChild(text0);
                tabletr.appendChild(td0);

                var td1=document.createElement("td");
                var text1 = document.createTextNode(oCells.item(2).innerText);
                td1.appendChild(text1);
                tabletr.appendChild(td1);

                var td2=document.createElement("td");
                var text2 = document.createTextNode(oCells.item(3).innerText);
                td2.appendChild(text2);
                tabletr.appendChild(td2);

                var td4=document.createElement("td");
                var text4 = document.createTextNode(oCells.item(4).innerText);
                td4.appendChild(text4);
                tabletr.appendChild(td4);

                var td5=document.createElement("td");
                var text5 = document.createTextNode(oCells.item(5).innerText);
                td5.appendChild(text5);
                tabletr.appendChild(td5);

                tablebody.appendChild(tabletr);
            }

            table.appendChild(tablebody);

            var tableEx = $('#tableResutlSubsOpen');
            var table2excel = new Table2Excel({defaultFileName: "Export_DS_Thue_bao_mo_chan_chieu", tableNameDataAttribute: "myTableExport"});
            table2excel.export(tableEx);
            tableEx.remove();
        }
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}