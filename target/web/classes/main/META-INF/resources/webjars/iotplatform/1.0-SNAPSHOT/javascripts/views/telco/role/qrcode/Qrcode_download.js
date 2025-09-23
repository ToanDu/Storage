async function downloadQrcode(url, serial, code) {
    const a = document.createElement("a");
    a.href = await toDataURL(url);
    a.download = serial+"-"+code+".png";
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
}
async function toDataURL(url) {
    const blob = await fetch(url).then(res => res.blob());
    return URL.createObjectURL(blob);
}

function zipQrcode(url, serial, code) {
    // console.log(url, serial, code);
    var zip = new JSZip();
    var filename = serial+"-"+code+".png";
    JSZipUtils.getBinaryContent(url, function (err, data) {
        if (err) {
            throw err; // or handle the error
        }
        zip.file(filename, data, { binary: true });
        zip.generateAsync({ type: 'blob' }).then(function (content) {
            saveAs(content, "QRCode.zip");
        });
    });
}

function exportListQrCode() {
    var body = new FormData();
    body.serial = $("#serialSim").val();
    body.status = $("#statusConnectSub").val();
    if($("#fromDateCreateQr").val().length > 0){
        var dateString = $("#fromDateCreateQr").val();
        var dateMomentObject = moment(dateString, "DD/MM/YYYY"); // 1st argument - string, 2nd argument - format
        var dateObject = dateMomentObject.toDate();
        body.createdFrom = dateObject.getTime()/1000;
    } else {
        body.createdFrom = "";
    }
    if($("#toDateCreateQr").val().length > 0){
        var dateString = $("#toDateCreateQr").val();
        var dateMomentObject = moment(dateString, "DD/MM/YYYY"); // 1st argument - string, 2nd argument - format
        var dateObject = dateMomentObject.toDate();
        body.createdTo = dateObject.getTime()/1000;
    } else {
        body.createdTo = "";
    }

    body.page = 1;
    body.pageSize = 1000;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoQrcodeController.getListQrcodeCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success && datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var dataQrs = datas.content.data;
                    var zip = new JSZip();
                    var count = 0;
                    for (var i=0; i<dataQrs.length;i++) {
                        var filename = dataQrs[i].serial+"-"+dataQrs[i].verificationCode+".png";
                        var url = hostGetImg + dataQrs[i].qrImage;
                        JSZipUtils.getBinaryContent(url, function (err, data) {
                            if (err) {
                                throw err; // or handle the error
                            }
                            zip.file(filename, data, { binary: true });
                            count++;
                            if (count == dataQrs.length) {
                                zip.generateAsync({ type: 'blob' }).then(function (content) {
                                    saveAs(content, "QRCode.zip");
                                });
                            }
                        });
                    }
                }
            } else{
                showNotification('danger', Messages("Không có dữ liệu"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            FinishProcess();
        }
    })
}