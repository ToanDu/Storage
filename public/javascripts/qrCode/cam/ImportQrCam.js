/**
 * Created by vtk-anhlt166 on 12/16/21.
 */
/**
 * Created by vtk-anhlt166 on 7/8/21.
 */
function importFileCSV() {
    $("#files").show();
}

var modelDataListQrImport = new Array();
function upload(evt) {
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var data = null;
        var file = evt.target.files[0];
        console.log(file);
        var reader = new FileReader();
        if(file == null || file == undefined){
            showNotification("danger", Messages("noti.chooseFile"));
            return;
        } else {
            if(file.name != undefined && file.name != null && file.name.length > 4){
                var formatFile = file.name.substring(file.name.length-4, file.name.length);
                console.log(formatFile);
                if(formatFile != ".csv"){
                    showNotification('danger', Messages("noti.fileWrongFormat"));
                    return;
                }
            } else {
                showNotification('danger', Messages("noti.fileWrongFormat"));
                return;
            }
        }
        reader.readAsText(file);
        reader.onload = function(event) {
            var csvData = event.target.result;
            modelDataListQrImport = $.csv.toArrays(csvData);

            if(modelDataListQrImport && modelDataListQrImport.length > 0){
                console.log(modelDataListQrImport);

                if(modelDataListQrImport.length > 5000){
                    showNotification('danger', Messages("noti.wrongBig5000"));
                    return;
                }

                // $("#id_qrcode").html("");
                $("#tableImport").find("tbody").html("");
                $("#buttonSubmitQrCode").show();
                for(var i=1; i<modelDataListQrImport.length; i++){
                    if(modelDataListQrImport[i].length == 2){
                        var tabletr=document.createElement("tr");

                        var td0=document.createElement("td");
                        var text0 = document.createTextNode(i);
                        td0.appendChild(text0);
                        tabletr.appendChild(td0);

                        var td1=document.createElement("td");
                        var text1 = document.createTextNode(modelDataListQrImport[i][0]);
                        td1.appendChild(text1);
                        tabletr.appendChild(td1);

                        var td2=document.createElement("td");
                        var text2 = document.createTextNode(modelDataListQrImport[i][1]);
                        td2.appendChild(text2);
                        tabletr.appendChild(td2);

                        $("#tableImport").find("tbody").append(tabletr);

                    } else {
                        showNotification('danger', Messages("noti.fileWrongTemplate"));
                        return;
                    }
                }
                $("#buttonSubmitImportCSV").click();
                $("#titleComfirmImport").text(Messages("qr.importComfirm", modelDataListQrImport.length-1));
                $("#divTableImport").show();
            }
        };
        reader.onerror = function() {
            console.log('Unable to read ' + file.fileName);
        };
    }
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function cancleImportCSV() {
    $("#files").val("");
}

function cancleImportResutlCSV() {
    $("#files").val("");
    window.location.reload();
}