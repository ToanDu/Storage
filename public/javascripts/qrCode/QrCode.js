/**
 * Created by vtk-anhlt166 on 7/8/21.
 */
function createQrCode() {
    $("#id_qrcode").html("");
    var qrcode = new QRCode("id_qrcode", {
        id:"abc",
        text:"abcsdsadgdfs",
        width:200,
        height:200,
        colorDark:"#000000",
        colorLight:"#ffffff",
        correctLevel:QRCode.CorrectLevel.H
    });
    document.querySelector('#id_qrcode img').style.margin = "auto";
    // document.querySelector('#id_qrcode img').style.width = "80%";

    setTimeout(function () {
        var src= document.querySelector('#id_qrcode img').getAttribute("src");
        console.log(src);

        // document.getElementById("id_qrcode_2").src = src;
    },3000);
}

var qrcode;
function submitQrCode(index) {
    StartProcess();

    $("#id_qrcode").html("");
    $("#divTableImport").hide();
    $("#buttonSubmitQrCode").hide();

    var idQr = modelDataListDeviceImport[index][0].trim();
    var name = modelDataListDeviceImport[index][1].trim();
    $("#titleComfirmImport").text(idQr);
    qrcode = new QRCode("id_qrcode", {
        id:idQr,
        text:"https://iotvtsystem.site/qrCodeImg/"+ idQr,
        width:250,
        height:250,
        colorDark:"#000000",
        colorLight:"#ffffff",
        correctLevel:QRCode.CorrectLevel.H
    });
    document.querySelector('#id_qrcode img').style.margin = "auto";

    setTimeout(function () {
        var dataForm = new FormData();
        dataForm.idDevice = idQr;
        dataForm.name = name;
        dataForm.src = document.querySelector('#id_qrcode img').getAttribute("src");
        console.log(dataForm);

        var r = jsRoutes.controllers.QrCodeController.createQrCode();
        $.ajax({
            type: r.type,
            dataType: 'json',
            data: JSON.stringify(dataForm),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                if(data.success){
                    showNotification('success',data.resultString);
                }else{
                    showNotification('danger',data.errorString);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
            },
            complete: function (jqXHR, textStatus) {
                qrcode.clear();

                if(index < modelDataListDeviceImport.length-1){
                    submitQrCode(index+1);
                } else {
                    FinishProcess();
                    setTimeout(function () {
                        window.location.reload();
                    },1000)
                }
            }
        });
    },1000);
}

function setDeleteQr(id) {
    $('#idDelete').val(id);
}
function processDeleteQr() {
    var dataForm = new FormData();
    dataForm.id = $('#idDelete').val();
    console.log(dataForm);

    StartProcess();
    var r = jsRoutes.controllers.QrCodeController.deleteQrCode();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(dataForm),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
            }else{  //tra ve cau hinh truoc do
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function setEditQr(id, name, linkAndroid, linkIos) {
    $("#idQrEdit").val(id);
    $("#nameQrEdit").val(name);
    $("#androidQrEdit").val(linkAndroid);
    $("#iosQrEdit").val(linkIos);
}
function postEditQr() {
    var dataForm = new FormData();
    dataForm.id = $('#idQrEdit').val();
    dataForm.name = $('#nameQrEdit').val();
    dataForm.linkAndroid = $('#androidQrEdit').val();
    dataForm.linkIos = $('#iosQrEdit').val();
    console.log(dataForm);

    StartProcess();
    var r = jsRoutes.controllers.QrCodeController.editQrCode();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(dataForm),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
            }else{  //tra ve cau hinh truoc do
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}