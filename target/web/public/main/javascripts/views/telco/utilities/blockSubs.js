/**
 * Created by vtk-anhlt166 on 11/18/22.
 */
var dataImportBlockSubs = new Array();
var listBlockSubs = new Array();
var arrayIsdnBlockSubs = new Array();
var listBlockSubsTrue = new Array();
var listBlockSubsFalse = new Array();
function uploadBlockSubs(evt) {
    dataImportBlockSubs = [];
    arrayIsdnBlockSubs = [];
    listBlockSubs = [];
    listBlockSubsTrue = [];
    listBlockSubsFalse = [];

    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var fileList = evt.target.files;
        console.log("fileList", fileList);
        var file = fileList[0];
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("blockUtilities.fileWrongFormat"));
            return;
        }
        $("#nameFileBlockSubs").val(file.name);

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
            dataImportBlockSubs = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(dataImportBlockSubs);
            if(dataImportBlockSubs.length > 1){
                // var mtml = "<span class='text-danger'>"+Messages("Tổng số: ")+(dataImportBlockSubs.length-1)+"</span>";


                for(var i=1; i<dataImportBlockSubs.length; i++){
                    if(dataImportBlockSubs[i][1] != null){
                        if(validatePhone(dataImportBlockSubs[i][1])){
                            if(!arrayIsdnBlockSubs.includes(dataImportBlockSubs[i][1])){
                                arrayIsdnBlockSubs.push(dataImportBlockSubs[i][1]);
                                listBlockSubsTrue.push(dataImportBlockSubs[i][1]);
                            }
                        } else {
                            listBlockSubsFalse.push(dataImportBlockSubs[i][1]);
                        }
                    }
                }

                $("#countBlockSubsTrue").html(listBlockSubsTrue.length);
                $("#countBlockSubsFalse").html(listBlockSubsFalse.length);
            } else {
                showNotification('danger',Messages("blockUtilities.fileInsufficientData"));
                return;
            }

            // $("#importBlockSubsModal").modal('hide');
            // document.getElementById('filesBlockSubs').value = '';
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesBlockSubs").value = "";
    }
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function comfirmTableListSubsBlock() {
    if(listBlockSubsTrue.length > 0){
        $("#dataImportBlockSubs").html("");
        var mtml = "";
        mtml+="<div style='height: 27rem;overflow: scroll'>";
        mtml += "<table id='smlTableSubsBlock' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
            "<thead>" +
            "<th>"+"<input type='checkbox' id='checkall-blockSub' onchange='checkAllBlockSubs(this)' checked>"+"</th>" +
            "<th>"+Messages("common.stt")+"</th>" +
            "<th>"+Messages("blockUtilities.subscriberNumber")+"</th>" +
            "<th>"+Messages("blockUtilities.action")+"</th>" +
            "<th>"+Messages("blockUtilities.result")+"</th>" +
            "<th>"+Messages("blockUtilities.reason")+"</th>" +
            "</thead>" +
            "<tbody>";
        for(var i=0; i<listBlockSubsTrue.length; i++){
            mtml += "<tr>";
            mtml += "<td>" +"<input type='checkbox' class='checkbox-blockSub' value='"+listBlockSubsTrue[i]+"' onchange='checkListCheckboxTableBlock()' checked>"+ "</td>";
            mtml += "<td>" +(i+1)+ "</td>";
            mtml += "<td>" + listBlockSubsTrue[i] + "</td>";
            mtml += "<td class='wrap-text' id='status-subs-"+listBlockSubsTrue[i]+"'></td>";
            mtml += "<td class='wrap-text' id='status-block-"+listBlockSubsTrue[i]+"'></td>";
            mtml += "<td class='wrap-text' id='reason-block-"+listBlockSubsTrue[i]+"'></td>";
            mtml += "</tr>";
        }

        mtml += "</tbody></table>";
        $("#dataImportBlockSubs").html(mtml);
    } else {
        showNotification('danger',Messages("Không có thuê bao hợp lệ"));
    }
    $("#nameFileBlockSubs").val("");
    $("#countBlockSubsTrue").html("0");
    $("#countBlockSubsFalse").html("0");
}

function checkListCheckboxTableBlock() {
    var countCheckbox = true;
    $(".checkbox-blockSub").each(function() {
        if(!this.checked){
            countCheckbox = false;
        }
    });
    if(countCheckbox){
        document.getElementById("checkall-blockSub").checked = true;
    } else {
        document.getElementById("checkall-blockSub").checked = false;
    }
}
function checkAllBlockSubs(el) {
    $(".checkbox-blockSub").each(function() {
        this.checked = el.checked;
    });
}

function showComfirmBlockSubsModal(action) {
    listBlockSubs = [];
    $(".checkbox-blockSub").each(function() {
        if(this.checked){
            listBlockSubs.push(this.value);
        }
    });
    console.log(listBlockSubs);
    if(listBlockSubs.length > 0){
        if(action == 1){
            $("#comfirmBlockSubsModal").modal('show');
            $("#comfirmCountBlockSubs").html('Bạn có chắc chắn muốn chặn 1 chiều ' + listBlockSubs.length + ' thuê bao?');
        } else if(action == 2) {
            $("#comfirmBlockSubs2Modal").modal('show');
            $("#comfirmCountBlockSubs2").html('Bạn có chắc chắn muốn chặn 2 chiều ' + listBlockSubs.length + ' thuê bao?');
        } else {
            console.log("action = ", action)
        }
    } else {
        showNotification('danger',Messages("Không tìm thấy danh sách thuê bao chặn"));
    }
}

var countBlockSubsSuccess = 0;
function processBlockListSubs(index, actionCode) {
    if(listBlockSubs.length <= 0){
        showNotification('danger',Messages("Không có thuê bao nào được chọn"));
        return;
    }
    // document.getElementById("buttonImportBlockSubs").disabled = true;
    // document.getElementById("buttonProcessBlockSubs1").disabled = true;
    // document.getElementById("buttonProcessBlockSubs2").disabled = true;
    if(index == 0){
        console.log(index, actionCode);
        countBlockSubsSuccess = 0;
        StartProcess();
    }

    var noti = "";
    if(actionCode == '06'){
        noti = "1 chiều";
    } else if(actionCode == '07') {
        noti = "2 chiều";
    }

    // console.log(listBlockSubs);
    $("#status-subs-"+listBlockSubs[index]).html(Messages("Chặn ")+noti);
    $("#status-block-"+listBlockSubs[index]).html("Đang thực hiện...");
    $("#reason-block-"+listBlockSubs[index]).html("");

    //validate & get gpkd
    var formData = new FormData;
    formData.isdn = listBlockSubs[index];
    formData.userId = userId;
    formData.actionCode = actionCode;
    console.log(formData);

    var url = jsRoutes.controllers.TelcoUtilitiesController.validateSubs();
    $.ajax({
        type: url.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: url.url,
        success: function (datas) {
            console.log(datas);

            if (datas.content != null && datas.content.data != null) {
                if (datas.content.data.valid) {
                    if (datas.content.data.idNo != null) {

                        var body = new FormData;
                        body.idNo = datas.content.data.idNo;
                        body.isdn = listBlockSubs[index];
                        body.actionCode = actionCode;
                        body.userId = userId;
                        console.log(body);

                        var r = jsRoutes.controllers.TelcoSubscriberController.blockSubcriber();
                        $.ajax({
                            type: r.type,
                            data: JSON.stringify(body),
                            contentType: "application/json; charset=utf-8",
                            url: r.url,
                            success: function(data){
                                console.log(data);
                                if(data.content != null){
                                    if(data.content.code == 0){
                                        $("#status-block-"+listBlockSubs[index]).html("<span class='text-success'>"+Messages("Thành công")+"</span>");
                                        $("#reason-block-"+listBlockSubs[index]).html("");

                                        countBlockSubsSuccess++;
                                    } else {
                                        if(data.content.description != null){
                                            $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                                            $("#reason-block-"+listBlockSubs[index]).html(Messages(data.content.description));
                                        } else {
                                            if(data.content.code == 2408){
                                                $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                                                $("#reason-block-"+listBlockSubs[index]).html(Messages("Số thuê bao không thuộc GPKD"));
                                            } else {
                                                $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                                                $("#reason-block-"+listBlockSubs[index]).html(Messages("Không xác định"));
                                            }
                                        }
                                    }
                                } else {
                                    $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                                    $("#reason-block-"+listBlockSubs[index]).html(Messages("Không có dữ liệu"));
                                }

                                // checkStatusBlockSubs(listBlockSubs[index]);
                            }
                        })

                    } else {
                        $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                        $("#reason-block-"+listBlockSubs[index]).html(Messages("Không tìm thấy GPKD của thuê bao"));
                    }
                } else {
                    $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                    $("#reason-block-"+listBlockSubs[index]).html(Messages("Số thuê bao không hợp lệ"));
                }
            } else {
                $("#status-block-"+listBlockSubs[index]).html("<span class='text-danger'>"+Messages("Không thành công")+"</span>");
                $("#reason-block-"+listBlockSubs[index]).html(Messages("Số thuê bao không đủ điều kiện"));
            }
        },
        complete: function (){
            // FinishProcess();
            if(index < listBlockSubs.length-1){
                setTimeout(function () {
                    processBlockListSubs(index+1, actionCode);
                },500);
            } else {
                // document.getElementById("buttonImportBlockSubs").disabled = false;
                // document.getElementById("buttonProcessBlockSubs1").disabled = false;
                // document.getElementById("buttonProcessBlockSubs2").disabled = false;
                FinishProcess();

                if(countBlockSubsSuccess > 0){
                    $("#textNofitication1").html(Messages("Quý khách đã chặn ") + noti + Messages(" thành công "));
                    $("#textNofitication2").html(countBlockSubsSuccess + Messages(" thuê bao"));

                    $("#notificationModal").modal('show');
                }
            }
        }
    })
}

function checkStatusBlockSubs(phoneNum) {
    var body = new FormData();
    body.userId = userId;
    body.isdn = phoneNum;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.listSubscriber != null && datas.content.listSubscriber.length > 0){
                    var statusText = getStatusByCode(datas.content.listSubscriber[0].actStatus, datas.content.listSubscriber[0].payType);
                    $("#status-subs-"+phoneNum).html(statusText);
                } else {
                    $("#status-subs-"+phoneNum).html(Messages("Không tìm thấy dữ liệu"));
                }
            } else {
                $("#status-subs-"+phoneNum).html(Messages("Không tìm thấy dữ liệu"));
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//xuat file mau
function downloadTemplateBlockSubs() {
    createTableTemplate();
    var filename = "List_Subs";
    outExcel(filename);
}
function createTableTemplate() {
    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", "myTableExcel");

    document.body.appendChild(table);

    var tablethread = document.createElement("thead");

    var tablethreadtr = document.createElement("tr");

    tablethreadtr.appendChild(createTh(Messages("STT")));
    tablethreadtr.appendChild(createTh(Messages("Số thuê bao")));

    tablethread.appendChild(tablethreadtr);

    table.appendChild(tablethread);
}
function createTh(message) {
    var th0 = document.createElement("th");
    var t0 = document.createTextNode(message);
    th0.appendChild(t0);
    return th0;
}
function outExcel(name) {
    console.log(name);
    var tableex = $('#myTableExcel');
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableex);

    $('#myTableExcel').remove();
}

function cancleImportFileBlock() {
    $("#importBlockSubsModal").modal('hide');
    listBlockSubs = [];
    $("#nameFileBlockSubs").val("");
    $("#countBlockSubsTrue").html("0");
    $("#countBlockSubsFalse").html("0");
    // $("#dataImportBlockSubs").html("");
}

function validatePhone(inputtxt) {
    var phone9 = /^\d{9}$/;
    var phone10 = /^\d{10}$/;
    if(phone9.test(inputtxt) || phone10.test(inputtxt)) {
        return true;
    } else {
        return false;
    }
}

// function exportResultListSubsBlock() {
//     if(document.getElementById("smlTableSubsBlock") != null){
//         var x = document.getElementById("smlTableSubsBlock").rows.length;
//         if(x > 1){
//             var tableEx = $('#smlTableSubsBlock');
//             var table2excel = new Table2Excel({defaultFileName: "Export_Result_Subs_Block", tableNameDataAttribute: "myTableExport"});
//             table2excel.export(tableEx);
//         } else {
//             showNotification('danger',Messages("Dữ liệu không có sẵn"));
//         }
//     } else {
//         showNotification('danger',Messages("Dữ liệu không có sẵn"));
//     }
// }
function exportResultListSubsBlock() {
    if(document.getElementById("smlTableSubsBlock") != null){
        var oTable = document.getElementById('smlTableSubsBlock');
        var rowLength = oTable.rows.length;
        if(rowLength < 1){
            showNotification('danger',Messages("Dữ liệu không có sẵn"));
        } else {
            var table = document.createElement("table");
            table.setAttribute("class", "table");
            table.setAttribute("id", "tableResutlSubsBlock");
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
            var t2 = document.createTextNode(Messages("Trạng thái hiện tại"));
            th2.appendChild(t2);
            tablethreadtr.appendChild(th2);

            var th4=document.createElement("th");
            var t4 = document.createTextNode(Messages("Kết quả"));
            th4.appendChild(t4);
            tablethreadtr.appendChild(th4);

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

                var td5=document.createElement("td");
                var text5 = document.createTextNode(oCells.item(4).innerText);
                td5.appendChild(text5);
                tabletr.appendChild(td5);

                tablebody.appendChild(tabletr);
            }

            table.appendChild(tablebody);

            var tableEx = $('#tableResutlSubsBlock');
            var table2excel = new Table2Excel({defaultFileName: "Export_DS_Thue_bao_chan_chieu", tableNameDataAttribute: "myTableExport"});
            table2excel.export(tableEx);
            tableEx.remove();
        }
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

