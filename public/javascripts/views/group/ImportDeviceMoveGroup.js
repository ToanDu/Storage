/**
 * Created by vtk-anhlt166 on 2/3/20.
 */
var typeFileImport;
var TYPE_FILE = {
    imei: {value: 1, name: "IMEI"},
    serial: {value: 2, name: "SERIAL"}
};
function importFileMoveDeviceCSV(i) {
    $("#files").show();
    typeFileImport = i;
}

var modelData = new Array();
// function upload(evt) {
//     if (!browserSupportFileUpload()) {
//         console.log('The File APIs are not fully supported in this browser!');
//     } else {
//         var data = null;
//         var file = evt.target.files[0];
//         var reader = new FileReader();
//         reader.readAsText(file);
//         reader.onload = function(event) {
//             var csvData = event.target.result;
//             modelData = $.csv.toArrays(csvData);
//
//             if(modelData && modelData.length > 0){
//                 console.log(modelData);
//                 $("#buttonDeviceMoveCSV").click();
//
//                 document.getElementById("tableImportDeviceMove").style.display = "none";
//                 document.getElementById("listGroupTreeDiv").style.display = "block";
//                 document.getElementById("submitDeviceImportMoveGroup").style.display = "block";
//                 $("#tableDeviceMoveResult").find("tbody").html("");
//             }
//         };
//         reader.onerror = function() {
//             console.log('Unable to read ' + file.fileName);
//         };
//     }
// }

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function selectMoveListDeviceGroup(data) {
    console.log(data);
    $("#chooseGroupMoveListDevice").val(data[0]);
}

function DataModel() {
    this.jsonList = "";
    this.groupCurrent = "";
    this.groupMove = "";
    this.typeFile="";
}
function submitDataModelCsv() {
    StartProcess();
    if (modelData && modelData.length > 0) {
        console.log(modelData);

        var data = new DataModel();
        data.jsonList = modelData;
        data.groupCurrent = currentSelectedGroup.id;
        data.groupMove = $("#chooseGroupMoveListDevice").val();
        data.typeFile = typeFileImport;
        console.log(data);

        var r = jsRoutes.controllers.GroupController.importListMoveDevice();
        $.ajax({
            type: r.type,
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (data) {
                console.log(data);

                if(data){
                    if(data.success == true){

                        if(data.content != null && data.content.length > 0){
                            document.getElementById("tableImportDeviceMove").style.display = "block";
                            document.getElementById("listGroupTreeDiv").style.display = "none";

                            var number = 0;
                            for(var i=0; i<data.content.length; i++){
                                var tabletr=document.createElement("tr");

                                var td0=document.createElement("td");
                                var text0 = document.createTextNode(i+1);
                                td0.appendChild(text0);
                                tabletr.appendChild(td0);

                                var td1=document.createElement("td");
                                var text1 = document.createTextNode(data.content[i].id);
                                td1.appendChild(text1);
                                tabletr.appendChild(td1);

                                if(data.content[i].success){
                                    number++;
                                }
                                var td2=document.createElement("td");
                                var text2 = document.createTextNode((data.content[i].success) ? "Success":"Error");
                                td2.appendChild(text2);
                                tabletr.appendChild(td2);

                                var td3=document.createElement("td");
                                var text3 = document.createTextNode((data.content[i].resultString != null) ? data.content[i].resultString : "");
                                td3.appendChild(text3);
                                tabletr.appendChild(td3);

                                $("#tableDeviceMoveResult").find("tbody").append(tabletr);

                                // var div = document.getElementById("tableResult");
                                // div.scrollTop = div.scrollHeight - div.clientHeight;
                            }

                            if(number > 0){
                                showNotification_slow('top', 'center', 'success', Messages("Admin.Updatesuccess") + " " + number + " device", 'notifications');

                            } else {
                                var numberDeviceFalse = data.content.length - number;
                                showNotification_slow('top', 'center', 'danger', Messages("Admin.Updatefailed")+ " " + numberDeviceFalse + " device", 'notifications');
                            }

                        } else {
                            showNotification_slow('top', 'center', 'danger', Messages("Admin.Updatefailed"), 'notifications');
                        }

                    } else {
                        showNotification_slow('top', 'center', 'danger', data.resultString, 'notifications');
                    }
                }

            },
            complete: function (jqXHR, textStatus) {
                document.getElementById("submitDeviceImportMoveGroup").style.display = "none";

                var tableex=  $('#tableDeviceMoveResult');
                var table2excel = new Table2Excel({defaultFileName:"name",tableNameDataAttribute:"myTableExport"});
                table2excel.export(tableex);

                FinishProcess();

            }
        });
    } else {
        console.log('No data to import!');
    }
}

function finishButton() {
    selectGroup(currentSelectedGroup.id);

    $("#files").hide();
    document.getElementById('files').value= null;
}