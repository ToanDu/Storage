var dataImportSubs = new Array();
var listSubsTrue = new Array();
var listSubsFalse = new Array();

function importFileSubs() {
    dataImportSubs =[];
    $("#filesSubs").click();
    $("#filesSubs").on("change", function() {
        $("#countSubsTrue").html("0");
        $("#countSubsFalse").html("0");
        // // Display the selected file name in the readonly input
        // var fileName = $(this).val().split('\\').pop(); // Extract file name from the full path
        // $("#nameFileSubs").val(fileName);
        //
        // // Call the confirmation function
        setTimeout(function() {
            comfirmTableListSubs();
        }, 500);
    });
}

function uploadSubs(evt) {
    dataImportSubs = [];
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
        $("#nameFileSubs").val(file.name);

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
            dataImportSubs = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            console.log(dataImportSubs);

            document.getElementById('filesSubs').value = '';
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesSubs").value = "";
    }
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function comfirmTableListSubs() {
    if(dataImportSubs.length > 1000000){
        showNotification('danger',Messages("File không được quá 1.000.000 dòng. Vui lòng kiểm tra lại!"));
        return;
    }
    console.log(dataImportSubs.length)
    if(dataImportSubs.length > 1){
        StartProcess();
        var isdns = [];
        for(let i = 1; i < dataImportSubs.length;i++){
            isdns.push(dataImportSubs[i][1]);
        }
        console.log(isdns);

        //validateAndAddSubToChildUser(1,dataImportSubs.length-1);
        validateAndAddSubToChildUser1(isdns);
        // validateAndAddSubToChildUser(dataImportSubs.length/2+1, dataImportSubs.length-1);
        // validateAndAddSubToChildUser(dataImportSubs.length/4);
        // validateAndAddSubToChildUser(3*dataImportSubs.length/8);
        // validateAndAddSubToChildUser(dataImportSubs.length/4);
        // validateAndAddSubToChildUser(5*dataImportSubs.length/8);
        // validateAndAddSubToChildUser(3*dataImportSubs.length/4);
        // validateAndAddSubToChildUser(7*dataImportSubs.length/8);

    } else {
        showNotification('danger',Messages("File không đủ dữ liệu"));
        return;
    }

}
function exitImportFile(){
    var body1 = new FormData;
    body1.userId = childUserId;
    body1.isdns = listSubsTrue;
    console.log(listSubsTrue)
    console.log(body1);
    var r = jsRoutes.controllers.TelcoChildUserController.addSubToChildUser1();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body1),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content.code==0){
                if(datas.content.data.valid !=null){
                    showNotification('success',Messages("Gán thành công "+datas.content.data.valid.length +" số thuê bao"));
                }
                if(datas.content.data.invalid !=null){
                    showNotification('danger',Messages("Gán thất bại "+datas.content.data.invalid.length +" số thuê bao"));
                }
            }
        },
        complete: function () {
            FinishProcess();
            getListSubManage();
            resetTableSub();
        }
    });
    $("#importSubsModal").modal('hide');
    $("#nameFileSubs").val("");
    $("#filesSubs").val("");
    $("#countSubsTrue").html("0");
    $("#countSubsFalse").html("0");
    listSubsTrue = [];
    listSubsFalse = [];



}


function validateAndAddSubToChildUser(index, endIndex) {
    // if(dataImportSubs[index][1] != null && dataImportSubs[index][1].trim() != ""){
    //     var formData = new FormData;
    //     formData.isdn = dataImportSubs[index][1].trim();
    //     formData.userId = userId;
    //     formData.actionCode = "LV2_ENT_ADD_ISDN";
    //     console.log(formData);
    //
    //     console.log(index);
    //
    //     var url = jsRoutes.controllers.TelcoUtilitiesController.validateSubs();
    //     $.ajax({
    //         type: url.type,
    //         data: JSON.stringify(formData),
    //         contentType: "application/json; charset=utf-8",
    //         url: url.url,
    //         success: function (datas) {
    //             console.log(datas);
    //             if (datas.content != null && datas.content.data != null) {
    //                 if (datas.content.data.valid) {
    //                     if (datas.content.data.idNo != null) {
    //
    //                         var body = new FormData;
    //                         body.idNo = datas.content.data.idNo;
    //                         body.isdn = dataImportSubs[index][1].trim();
    //                         body.userId = childUserId;
    //                         console.log(body);
    //
    //                         var r = jsRoutes.controllers.TelcoChildUserController.addSubToChildUser();
    //                         $.ajax({
    //                             type: r.type,
    //                             data: JSON.stringify(body),
    //                             contentType: "application/json; charset=utf-8",
    //                             url: r.url,
    //                             success: function(data){
    //                                 console.log(data);
    //                                 if(data.success){
    //                                     listSubsTrue.push(body.isdn);
    //                                     $("#countSubsTrue").html(listSubsTrue.length);
    //
    //                                 } else {
    //                                     listSubsFalse.push({
    //                                         "isdn": body.isdn,
    //                                         "reason": "Gán không thành công"
    //                                     });
    //                                     $("#countSubsFalse").html(listSubsFalse.length);
    //                                     console.log(false);
    //                                 }
    //                             }
    //                         })
    //                     } else {
    //                         listSubsFalse.push({
    //                             "isdn": formData.isdn,
    //                             "reason": "Không tìm thấy GPKD của thuê bao"
    //                         });
    //                         $("#countSubsFalse").html(listSubsFalse.length);
    //
    //                     }
    //                 } else {
    //                     listSubsFalse.push({
    //                         "isdn": formData.isdn,
    //                         "reason": "Số thuê bao không hợp lệ"
    //                     });
    //                     $("#countSubsFalse").html(listSubsFalse.length);
    //                 }
    //             } else {
    //                 console.log('cell')
    //                 listSubsFalse.push({
    //                     "isdn": formData.isdn,
    //                     "reason": "Số thuê bao không đủ điều kiện"
    //                 });
    //                 $("#countSubsFalse").html(listSubsFalse.length);
    //             }
    //         },
    //         complete: function (){
    //             // FinishProcess();
    //             if(index < endIndex){
    //                 validateAndAddSubToChildUser(index+1, endIndex);
    //             } else {
    //                 FinishProcess();
    //             }
    //         }
    //     })
    // } else {
    //     if(index < endIndex){
    //         validateAndAddSubToChildUser(index+1, endIndex);
    //     } else {
    //         FinishProcess();
    //     }
    // }
}
function validateAndAddSubToChildUser1(isdns) {
    listSubsTrue = new Array();
    listSubsFalse= new Array();
    if(dataImportSubs[1][1] != null && dataImportSubs[1][1].trim() != ""){
        var formData = new FormData;
        formData.isdns = isdns;
        formData.userId = userId;

        formData.actionCode = "LV2_ENT_ADD_ISDN";
        console.log(formData);
        var req = jsRoutes.controllers.TelcoChildUserController.validateSubToChildUser1();
        $.ajax({
            type: req.type,
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf-8",
            url: req.url,
            success: function (data) {
                const {content} = data;
                if(content && content.length > 0) {
                    let countValid = 0;
                    let countInvalid = 0;
                    content.forEach((item)=> {
                        if(!item.error) {
                            countValid++;
                            listSubsTrue.push(item);
                        } else {
                            countInvalid++;
                            listSubsFalse.push(item);
                        }
                    })
                    $("#countSubsTrue").html(countValid);
                    $("#countSubsFalse").html(countInvalid);
                }             
            },
            complete: function () {
                FinishProcess();
            }
        });
    } else {
            FinishProcess();
    }
}

//xuat file mau
function downloadTemplateSubs() {
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


//export list sub true/false
function exportListSubsTrue() {
    if(listSubsTrue.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListSubsTrue");
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

        tablethread.appendChild(tablethreadtr);
        table.appendChild(tablethread);

        var tablebody=document.createElement("tbody");
        for (var i=0; i<listSubsTrue.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listSubsTrue[i].isdn);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListSubsTrue');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsFalse() {
    if(listSubsFalse.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListSubsFalse");
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
        var t2 = document.createTextNode(Messages("Lý do"));
        th2.appendChild(t2);
        tablethreadtr.appendChild(th2);

        tablethread.appendChild(tablethreadtr);
        table.appendChild(tablethread);

        var tablebody=document.createElement("tbody");
        for (var i=0; i<listSubsFalse.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listSubsFalse[i].isdn);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            var td2=document.createElement("td");
            var text2 = document.createTextNode(listSubsFalse[i].error);
            td2.appendChild(text2);
            tabletr.appendChild(td2);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListSubsFalse');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function cancelImportFileSubs() {
    listSubsTrue =[];
    listSubsFalse = [];
    listSubsTrue.length = 0;
    listSubsFalse.length =0;
    $("#nameFileSubs").val("");
    $("#importSubsModal").modal('hide');
    $("#filesSubs").val("");
    $("#countSubsTrue").html("0");
    $("#countSubsFalse").html("0");
}