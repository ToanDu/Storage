/**
 * Created by vtk-anhlt166 on 12/16/21.
 */
/**
 * Created by vtk-anhlt166 on 7/8/21.
 */

var qrcode;
function submitQrCodeCam(index) {
    // StartProcess();

    $("#id_qrcode").html("");
    $("#divTableImport").hide();
    $("#buttonSubmitQrCode").hide();

    var serial = modelDataListQrImport[index][0].trim();
    var mac = modelDataListQrImport[index][1].trim();

    $("#titleComfirmImport").text(serial);
    $("#serialQr").text("S/N: "+serial);
    $("#macQr").text("MAC: "+mac);

    var text = "VIETTEL VHUB-Y04-VVT01 " + serial + " " + mac;
    qrcode = new QRCode("id_qrcode", {
        id:serial,
        text:text,
        width: 172,
        height: 172,
        colorDark:"#000000",
        colorLight:"#ffffff",
        correctLevel:QRCode.CorrectLevel.H
    });
    // document.querySelector('#id_qrcode img').style.margin = "auto";
    document.querySelector('#id_qrcode img').style.marginTop = "19.2pt";
    document.querySelector('#id_qrcode img').style.marginLeft = "19.2pt";

    setTimeout(function () {
        capture(serial);
    },1000);

    setTimeout(function () {
        var dataForm = new FormData();
        dataForm.serial = serial;
        dataForm.mac = mac;
        dataForm.src = document.querySelector('#id_qrcode img').getAttribute("src");
        console.log(dataForm);

        var r = jsRoutes.controllers.QrCodeCamController.createQrCodeCam();
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

                if(index < modelDataListQrImport.length-1){
                    submitQrCodeCam(index+1);
                } else {
                    FinishProcess();
                }
            }
        });
    },1500);
}

function capture(serial) {
    const captureElement = document.querySelector('#imgQrCode')
    html2canvas(captureElement)
        .then(canvas => {
            canvas.style.display = 'none';
            document.body.appendChild(canvas);
            return canvas;
    })
    .then(canvas => {
            const image = canvas.toDataURL('image/jpeg').replace('image/jpeg', 'image/octet-stream');
            const a = document.createElement('a');
            a.setAttribute('download', serial+'.jpeg');
            a.setAttribute('href', image);
            a.click();
            canvas.remove();
    })
}

//pdf
function submitQrCodeCamPdf(index) {
    // StartProcess();

    // $("#id_qrcode").html("");
    // $("#divTableImport").hide();
    // $("#buttonSubmitQrCode").hide();

    if(index == 1){
        $("#divPdfQrcode").html("");
    }

    var serial = modelDataListQrImport[index][0].trim();
    var mac = modelDataListQrImport[index][1].trim();

    var div = '<div class="col mt-3">\n' +
        '                <div style="height: 59.5pt; width: 127.6pt; border-radius: 6pt; border: 0.5px solid #000000; background-color: #FFFFFF" id="">\n' +
        '                  <div class="" style="height: 12.6pt; border-bottom: 0.5px solid #000000;">\n' +
        '                    <span style="float: left; margin-left: 4.3pt; font-size: 8pt; color: #333333; font-weight: 600; margin-top: 0.6pt;">'+Messages("Home Hub")+'</span>\n' +
        '                    <img src="'+viettel3x+'" alt="..." class="" style="height: 7.4pt; width: 37.9pt; float: right; margin-right: 6pt; margin-top: 2.6pt;">\n' +
        '                  </div>\n' +
        '                  <div class="">\n' +
        '                    <span class="form-label" style="font-size: 5pt; float: left; margin-top: 3.2pt; margin-left: 3.3pt; color: #333333; font-weight: 600">'+Messages("Model: VHUB-Y04")+'</span>\n' +
        '                    <span style="font-size: 5pt; float: left; margin-top: 12.8pt; margin-left: -47.8pt; color: #333333; font-weight: 600">'+Messages("INPUT: 48V - 0.5A")+'</span>\n' +
        '                    <span style="font-size: 5pt; float: left; margin-top: 22.4pt; margin-left: -48.2pt; color: #333333; font-weight: 600" id="serialQr">'+Messages("S/N: ")+serial+'</span>\n' +
        '                    <span style="font-size: 5pt; float: left; margin-top: 31.6pt; margin-left: -48.2pt; color: #333333; font-weight: 600" id="macQr">'+Messages("MAC: ")+mac+'</span>\n' +
        '                    <img src="'+re3x+'" alt="..." class="" style="height: 13.8pt; width: 13.1pt; margin-top: 6.8px; margin-left: -12pt;">\n' +
        '                    <img src="'+ro3x+'" alt="..." class="" style="height: 7.9pt; width: 19.6pt; position: absolute; margin-top: 28.8px; margin-left: -16.8pt;">\n' +
        '                    <div class="" style="width: 42.5pt; height: 42.5pt; border-radius: 5pt; border: 0.5px solid #000000; float: right; margin-right: 2.1pt; margin-top: 1.9pt;" id="id_qrcode_'+index+'">\n' +
        // '                      <img src="@routes.Assets.versioned("images/cam/qr3x.png")" alt="..." class="" style="height: 36pt; width: 36pt; margin-top: 3.2pt;">\n' +
        '                    </div>\n' +
        '                  </div>\n' +
        '                </div>\n' +
        '              </div>';
    $("#divPdfQrcode").append(div);

    $("#titleComfirmImport").text(serial);
    // $("#serialQr").text("S/N: "+serial);
    // $("#macQr").text("MAC: "+mac);

    var text = "VIETTEL VHUB-Y04-VVT01 " + serial + " " + mac;
    qrcode = new QRCode("id_qrcode_"+index, {
        id:serial,
        text:text,
        width: 43,
        height: 43,
        colorDark:"#000000",
        colorLight:"#ffffff",
        correctLevel:QRCode.CorrectLevel.H
    });
    // document.querySelector('#id_qrcode img').style.margin = "auto";
    document.querySelector('#id_qrcode_'+index+' img').style.marginTop = "4.8pt";
    document.querySelector('#id_qrcode_'+index+' img').style.marginLeft = "4.8pt";

    // return;

    setTimeout(function () {
        qrcode.clear();

        if(index < modelDataListQrImport.length-1){
            submitQrCodeCam(index+1);
        } else {
            //export pdf
            console.log("export pdf");
            html2canvas(document.getElementById('divPdfQrcode')).then(function (canvas) {
                document.body.appendChild(canvas);
                var imgdata = canvas.toDataURL("image/jpg");
                var doc = new jspdf.jsPDF();
                doc.addImage(imgdata, "JPG", 10, 10);
                doc.save("sample.pdf");
            });
        }
    },1000);


    // setTimeout(function () {
    //     capture(serial);
    // },1000);


}


//delete
function setDeleteQr(id) {
    $('#idDelete').val(id);
}
function processDeleteQr() {
    var dataForm = new FormData();
    dataForm.id = $('#idDelete').val();
    console.log(dataForm);

    StartProcess();
    var r = jsRoutes.controllers.QrCodeCamController.deleteQrCodeCam();
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