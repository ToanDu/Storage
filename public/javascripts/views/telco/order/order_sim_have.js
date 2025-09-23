/**
 * Created by vtk-anhlt166 on 1/9/23.
 */
//xuat file mau
function downloadTemplateConnectHaveSim() {
    createTableTemplate();
    var filename = "List_Sim";
    outExcel(filename);
}
function importFileConnectHaveSim() {
    $("#filesConnectHaveSim").click();
}
function createTableTemplate() {
    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", "myTableListSim");

    document.body.appendChild(table);

    var tablethread = document.createElement("thead");

    var tablethreadtr = document.createElement("tr");

    tablethreadtr.appendChild(createTh(Messages("STT")));
    tablethreadtr.appendChild(createTh(Messages("Serial Sim")));
    tablethreadtr.appendChild(createTh(Messages("ATM1")));

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
    var tableex = $('#myTableListSim');
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableex);

    $('#myTableListSim').remove();
}

//import file sim da co
var listConnectHaveSim = new Array;
var listJsonConnectHaveSim = new Array;
var listArrayConnectHaveSim = new Array;
var listRemoveDuplicateSim = new Array;
function uploadFilesConnectHaveSim(evt) {
    listConnectHaveSim = [];
    listJsonConnectHaveSim = [];
    listArrayConnectHaveSim =[];
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var file = evt.target.files[0];
        console.log(file);
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("File không đúng format xlsx"));
            return;
        }
        $("#nameFileImport").val(file.name);

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
            var listFile = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(listFile);
            if(listFile.length > 1){
                var index = 0;
                for(var i=1; i<listFile.length; i++){
                    if(listFile[i][1] != null && listFile[i][1].trim() != ""){
                        var serial = listFile[i][1].trim().replaceAll("'","");
                        var adm1 = listFile[i][2].trim().replaceAll("'","");
                        if(serial.length > 0 && adm1.length > 0){
                            listConnectHaveSim.push(serial);
                            listArrayConnectHaveSim[index] = {
                                "serial":serial,
                                "adm1":adm1
                            };
                            index++;
                        }
                    }
                }
                console.log(listConnectHaveSim);
                console.log(listArrayConnectHaveSim);
                listRemoveDuplicateSim = removeDuplicatesBySerial(listArrayConnectHaveSim);
                // console.log(listArrayConnectHaveSim);
                if(listRemoveDuplicateSim.length > 0){
                    checkValidateSerialSim(0);
                } else {
                    showNotification('danger',Messages("Dữ liệu không hợp lệ"));
                }
            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
                return;
            }
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesConnectHaveSim").value = "";
    }
}
function removeDuplicatesBySerial(arr) {
    var serialSet = new Set();
    var uniqueArray = [];

    for (var i = 0; i < arr.length; i++) {
        var currentSerial = arr[i].serial;

        // Kiểm tra xem serial đã xuất hiện chưa
        if (!serialSet.has(currentSerial)) {
            // Nếu chưa xuất hiện, thêm vào tập hợp và mảng kết quả
            serialSet.add(currentSerial);
            uniqueArray.push(arr[i]);
        }
    }

    return uniqueArray;
}
function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

var countSerialTrue = 0;
var listSerialTrue = new Array;
var listAdm1True = new Array;
function checkValidateSerialSim(index) {
    if(index == 0){
        countSerialTrue = 0;
        listSerialTrue = [];
        listAdm1True = [];
    }

    StartProcess();
    var body = new FormData;
    body.serial = listRemoveDuplicateSim[index].serial;
    body.adm1 = listRemoveDuplicateSim[index].adm1;
    console.log(body);

    var r = jsRoutes.controllers.TelcoOrderController.checkValidateSerialSim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.success == "true"){
                    countSerialTrue++;
                    $("#countConnectHaveSimTrue").val(countSerialTrue);
                    listSerialTrue.push(body.serial);
                    listAdm1True[body.serial] = body.adm1;
                }
            }
        },
        complete: function (){
            // FinishProcess();
            if(index < listRemoveDuplicateSim.length-1){
                checkValidateSerialSim(index+1);
            } else {
                if(listSerialTrue <= 0){
                    showNotification('danger',Messages("File không có Serial Thuê bao hợp lệ"));
                }
                FinishProcess();
            }
        }
    })
}

function toPlainString(num) {
    return (''+ +num).replace(/(-?)(\d*)\.?(\d*)e([+-]\d+)/,
        function(a,b,c,d,e) {
            return e < 0
                ? b + '0.' + Array(1-e-c.length).join(0) + c + d
                : b + c + d + Array(e-d.length+1).join(0);
        });
}

//export list sub block
function exportListConnectHaveSimTrue() {
    if(listSerialTrue.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListConnectHaveSimTrue");
        document.body.appendChild(table);
        var tablethread=document.createElement("thead");
        var tablethreadtr=document.createElement("tr");

        var th0=document.createElement("th");
        var t0 = document.createTextNode(Messages("STT"));
        th0.appendChild(t0);
        tablethreadtr.appendChild(th0);

        var th1=document.createElement("th");
        var t1 = document.createTextNode(Messages("Serial Sim"));
        th1.appendChild(t1);
        tablethreadtr.appendChild(th1);

        var th2=document.createElement("th");
        var t2 = document.createTextNode(Messages("ADM1"));
        th2.appendChild(t2);
        tablethreadtr.appendChild(th2);

        tablethread.appendChild(tablethreadtr);
        table.appendChild(tablethread);

        var tablebody=document.createElement("tbody");
        for (var i=0; i<listSerialTrue.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode("'"+listSerialTrue[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            var td2=document.createElement("td");
            var text2 = document.createTextNode(listAdm1True[listSerialTrue[i]]);
            td2.appendChild(text2);
            tabletr.appendChild(td2);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListConnectHaveSimTrue');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Serial_True", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

//ktra co thue bao hop le thi cho next
function checkImportSerial(el) {
    if(listSerialTrue.length > 0){
        $("#progressBar").find(".active").next().addClass("active");

        $(el).parents(".row").fadeOut("slow", function () {
            $(el).next(".row").fadeIn("slow");
        });
    } else {
        showNotification('danger',Messages("Bạn chưa import serial sim hợp lệ"));
        return;
    }
}