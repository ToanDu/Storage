/**
 * Created by vtk-anhlt166 on 3/15/23.
 */
var dataImportOpenSubs2 = new Array();
var listOpenSubs2 = new Array();
var arrayIsdnOpenSubs2 = new Array();
var listOpenSubsTrue2 = new Array();
var listOpenSubsFalse2 = new Array();
var listIdNoOpen2wSubsTrue = new Array;
function uploadOpenSubs2(evt) {
    dataImportOpenSubs2 = [];
    arrayIsdnOpenSubs2 = [];
    listOpenSubs2 = [];
    listOpenSubsTrue2 = [];
    listOpenSubsFalse2 = [];
    listOpen2SubsTrueSubmit = [];
    listIdNoOpen2wSubsTrue = [];

    if (!browserSupportFileUploadOpen2()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var fileList = evt.target.files;
        console.log("fileList", fileList);
        var file = fileList[0];
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("File không đúng format xlsx"));
            return;
        }
        $("#nameFileOpenSubs2").val(file.name);

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
            dataImportOpenSubs2 = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(dataImportOpenSubs2);
            if(dataImportOpenSubs2.length > 1){
                for(var i=1; i<dataImportOpenSubs2.length; i++){
                    if(dataImportOpenSubs2[i][1] != null){
                        if(validatePhone(dataImportOpenSubs2[i][1])){
                            if(!arrayIsdnOpenSubs2.includes(dataImportOpenSubs2[i][1])){
                                arrayIsdnOpenSubs2.push(dataImportOpenSubs2[i][1]);
                                listOpenSubsTrue2.push(dataImportOpenSubs2[i][1]);
                            }
                        } else {
                            listOpenSubsFalse2.push(dataImportOpenSubs2[i][1]);
                        }
                    }
                }

                if(listOpenSubsTrue2.length > 0){
                    checkValidateListOpen_2(0);
                }
            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
            }

            // $("#importOpenSubsModal").modal('hide');
            // document.getElementById('filesOpenSubs').value = '';
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesOpenSubs2").value = "";
    }
}

var listOpen2SubsTrueSubmit = new Array;
function checkValidateListOpen_2(index) {
    var body = new FormData();
    body.userId = userId;
    body.isdn = listOpenSubsTrue2[index];
    body.actionCode = "09";
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
                    listOpen2SubsTrueSubmit.push(listOpenSubsTrue2[index]);
                    listIdNoOpen2wSubsTrue[listOpenSubsTrue2[index]] = datas.content.data.idNo;
                } else {
                    listOpenSubsFalse2.push(listOpenSubsTrue2[index])
                }
            } else {
                listOpenSubsFalse2.push(listOpenSubsTrue2[index])
            }
        },
        error: function (xhr) {
            console.log(xhr);
            listOpenSubsFalse2.push(listOpenSubsTrue2[index])
        },
        complete: function (){
            // FinishProcess();
            $("#countOpenSubsTrue2").html(listOpen2SubsTrueSubmit.length);
            $("#countOpenSubsFalse2").html(listOpenSubsFalse2.length);

            if(index < listOpenSubsTrue2.length-1){
                checkValidateListOpen_2(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}


function browserSupportFileUploadOpen2() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function comfirmTableListSubsOpen2() {
    if(listOpen2SubsTrueSubmit.length > 0){
        $("#dataImportOpenSubs2").html("");
        var mtml = "";
        mtml+="<div style='height: 27rem;overflow: scroll'>";
        mtml += "<table id='smlTableSubsOpen2' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
            "<thead>" +
            "<th>"+"<input type='checkbox' id='checkall-openSub-2' onchange='checkAllOpenSubs2(this)' checked>"+"</th>" +
            "<th>"+Messages("STT")+"</th>" +
            "<th>"+Messages("Số thuê bao")+"</th>" +
            "<th>"+Messages("Tác động")+"</th>" +
            "<th>"+Messages("Kết quả")+"</th>" +
            "<th>"+Messages("Lý do thất bại")+"</th>" +
            "</thead>" +
            "<tbody>";
        for(var i=0; i<listOpen2SubsTrueSubmit.length; i++){
            mtml += "<tr>";
            mtml += "<td>" +"<input type='checkbox' class='checkbox-openSub-2' value='"+listOpen2SubsTrueSubmit[i]+"' onchange='checkListCheckboxTableOpen2()' checked>"+ "</td>";
            mtml += "<td>" +(i+1)+ "</td>";
            mtml += "<td>" + listOpen2SubsTrueSubmit[i] + "</td>";
            mtml += "<td class='wrap-text' id='action-open-"+listOpen2SubsTrueSubmit[i]+"'></td>";
            mtml += "<td class='wrap-text' id='result-open-"+listOpen2SubsTrueSubmit[i]+"'></td>";
            mtml += "<td class='wrap-text' id='noti-open-"+listOpen2SubsTrueSubmit[i]+"'></td>";
            mtml += "</tr>";
        }

        mtml += "</tbody></table></div>";
        $("#dataImportOpenSubs2").html(mtml);
    } else {
        showNotification('danger',Messages("Không có thuê bao hợp lệ"));
    }
    $("#nameFileOpenSubs2").val("");
    $("#countOpenSubsTrue2").html("0");
    $("#countOpenSubsFalse2").html("0");
}

function checkListCheckboxTableOpen2() {
    var countCheckbox = true;
    $(".checkbox-openSub-2").each(function() {
        if(!this.checked){
            countCheckbox = false;
        }
    });
    if(countCheckbox){
        document.getElementById("checkall-openSub-2").checked = true;
    } else {
        document.getElementById("checkall-openSub-2").checked = false;
    }
}
function checkAllOpenSubs2(el) {
    $(".checkbox-openSub-2").each(function() {
        this.checked = el.checked;
    });
}

function showComfirmOpenSubsModal2() {
    listOpenSubs2 = [];
    $(".checkbox-openSub-2").each(function() {
        if(this.checked){
            listOpenSubs2.push(this.value);
        }
    });
    console.log(listOpenSubs2);
    if(listOpenSubs2.length > 0){
        $("#comfirmOpen2SubsModal").modal('show');
        $("#comfirmCountOpenSubs2").html('Bạn có chắc chắn muốn mở 2 chiều ' + listOpenSubs2.length + ' thuê bao?');
    } else {
        showNotification('danger',Messages("Không tìm thấy danh sách thuê bao mở"));
    }
}

function cancleImportFileOpen2() {
    $("#importOpenSubsModal2").modal('hide');
    listOpenSubs2 = [];
    $("#nameFileOpenSubs2").val("");
    $("#countOpenSubsTrue2").html("0");
    $("#countOpenSubsFalse2").html("0");
}

var countOpenSubsSuccess = 0;
var orderIdOpen2;
function processOpenListSubs2() {
    if(listOpenSubs2.length <= 0){
        showNotification('danger',Messages("Không có thuê bao nào được chọn"));
        return;
    }
    var noti = "2 chiều";

    var listIsdn = [];
    for(var i=0; i<listOpenSubs2.length; i++){
        listIsdn.push({
            "isdn":listOpenSubs2[i],
            "id_no":listIdNoOpen2wSubsTrue[listOpenSubs2[i]]
        })
    }

    var body = new FormData;
    body.list = listIsdn;
    body.amount = 5000;
    body.user_id = userId;
    body.reason = "Mở chặn 2 chiều";
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.open2wSubcriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null){
                    orderIdOpen2 = datas.content.data.order_id;
                    console.log(orderIdOpen2);

                    $("#pay2MyViettelModal").modal('show');

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

function comfirmPayOpenSubsSuccess2() {
    console.log("comfirmPayOpenSubsSuccess2");
    var noti = "2 chiều";
    $("#pay2MyViettelModal").modal('hide');

    if(orderIdOpen2 != undefined && orderIdOpen2 != null){
        StartProcess();
        checkStatusSubs2(0, noti, orderIdOpen2);
    }
}

function checkStatusSubs2(index, noti, orderId) {
    var body = new FormData();
    body.isdn = listOpenSubs2[index];
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
                $("#action-open-"+listOpenSubs2[index]).html("Mở "+noti);
                if(datas.content.data != null && datas.content.data.length > 0){
                    var state = datas.content.data[0].state;
                    if(state == "error"){
                        $("#result-open-"+listOpenSubs2[index]).html("<span class='text-danger'>"+"Lỗi hệ thống"+"</span>");
                    } else if(state == "processing"){
                        $("#result-open-"+listOpenSubs2[index]).html("<span class='text-warning'>"+"Đang xử lý"+"</span>");
                    } else {
                        if(state == "done:0"){
                            $("#result-open-"+listOpenSubs2[index]).html("<span class='text-success'>"+"Thành công"+"</span>");
                        } else {
                            $("#result-open-"+listOpenSubs2[index]).html("<span class='text-danger'>"+"Không thành công"+"</span>");
                        }
                    }
                    $("#noti-open-"+listOpenSubs2[index]).html(datas.content.data[0].message);
                } else {
                    $("#result-open-"+listOpenSubs2[index]).html("Thất bại");
                    $("#noti-open-"+listOpenSubs2[index]).html("Không tìm thấy dữ liệu");
                }
            } else {
                $("#result-open-"+listOpenSubs2[index]).html("Thất bại");
                $("#noti-open-"+listOpenSubs2[index]).html("Không tìm thấy dữ liệu");
            }
        },
        complete: function (){
            if(index < listOpenSubs2.length-1){
                setTimeout(function () {
                    checkStatusSubs2(index+1, noti, orderId);
                },1000);
            } else {
                FinishProcess();
            }
        }
    })
}

function exportResultListSubsOpen2() {
    if(document.getElementById("smlTableSubsOpen2") != null){
        var oTable = document.getElementById('smlTableSubsOpen2');
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