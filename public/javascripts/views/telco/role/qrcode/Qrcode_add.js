var listSerialAdm1TrueSubmit = new Array();
var listSerialAdm1FalseSubmit = new Array();
var listConnectSim = new Array();
var listArrayConnectSim = new Array();

function importFileConnectSerialAdm1() {
    $("#filesSerials").click();
}
function uploadFilesSerialAdm1(evt) {
    if($("#staffCode").val().trim().length <= 0){
        document.getElementById("filesSerials").value = "";
        showNotification('danger',Messages("Bạn chưa nhập user đấu nối"));
        return;
    }
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        listConnectSim = [];
        listArrayConnectSim = [];

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
                            if(!listConnectSim.includes(serial)){
                                listConnectSim.push(serial);
                                listArrayConnectSim[index] = {
                                    "serial":serial,
                                    "adm1":adm1
                                };
                                index++;
                            }
                        }
                    }
                }

                if(listConnectSim.length > 0){
                    checkValidateSerialAdm1(0);
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
        document.getElementById("filesSerials").value = "";
    }
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

var countSerialTrue = 0;
var listSerialTrue = new Array();
var listAdm1True = new Array();
function checkValidateSerialAdm1(index) {
    if(index == 0){
        countSerialTrue = 0;
        listSerialTrue = [];
        listAdm1True = [];
    }

    StartProcess();
    var body = new FormData;
    body.serial = listArrayConnectSim[index].serial;
    body.adm1 = listArrayConnectSim[index].adm1;
    body.staffCode = $("#staffCode").val();
    console.log(body);

    var r = jsRoutes.controllers.TelcoQrcodeController.checkValidateSerialAdm1();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.content != null && data.content.success == "true"){
                countSerialTrue++;
                $("#countSerialAdm1True").html(countSerialTrue);
                listSerialTrue.push(body.serial);
                listAdm1True[body.serial] = body.adm1;
            }
        },
        complete: function (){
            // FinishProcess();
            if(index < listArrayConnectSim.length-1){
                checkValidateSerialAdm1(index+1);
            } else {
                if(listSerialTrue <= 0){
                    showNotification('danger',Messages("File không có Serial Thuê bao hợp lệ"));
                }
                FinishProcess();
            }
        }
    })
}

function validateListSerialConnect() {
    if($("#staffCode").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền user đấu nối"));
        return;
    }
    if($("#gpkdList").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn giấy phép kinh doanh"));
        return;
    }
    if(listSerialTrue.length <= 0){
        showNotification('danger',Messages("Bạn chưa import danh sách serial sim hợp lệ"));
        return;
    }
    if($("#packDataList").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn gói cước đấu nối"));
        return;
    }
    if($("#reasonList").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn lý do đấu nối"));
        return;
    }

    $("#addQrcodeModal").modal('hide');
    $("#addInfoCustomerModal").modal('show');

}