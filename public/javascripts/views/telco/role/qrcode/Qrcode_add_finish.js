var dsChungTu = new Array();
var dsLinkChungTu = new Array();
function processUpfileChungTu() {
    // StartProcess();
    dsChungTu = [];
    dsLinkChungTu = [];
    var dsCt = document.getElementsByClassName("chung-tu");
    if(dsCt.length > 0){
        for(var i=0; i<dsCt.length; i++){
            var recordCode = dsCt[i].getAttribute("code");
            var stt = dsCt[i].getAttribute("stt");
            dsChungTu.push({
                "code": recordCode,
                "stt": stt
            })
        }
        // console.log(dsChungTu);
        saveFileChungTu(0);
    } else {
        FinishProcess();
    }
}

function saveFileChungTu(index) {
    if($("#filesCt-"+index).prop("files")[0] != null && $("#filesCt-"+index).prop("files")[0] != undefined){
        var groupData = new FormData();
        groupData.append("filePart", $("#filesCt-"+index).prop("files")[0]);
        // StartProcess();
        var r = jsRoutes.controllers.TelcoQrcodeController.saveFileChungTu();
        $.ajax({
            type: r.type,
            data: groupData,
            contentType: false,
            processData: false,
            url: r.url,
            success: function(data){
                console.log(data);
                if(data.success){
                    dsLinkChungTu.push({
                        "contents": "",
                        "fileCode": dsChungTu[index].code,
                        "fileName": data.content
                    });
                    console.log(dsLinkChungTu);
                } else {
                    if(data.status == 401){
                        showNotification('danger', Messages("noti.sessionTimeOut"));
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    } else {
                        showNotification('danger', data.errorString);
                    }
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
                FinishProcess();
            },
            complete: function (){
                if(index < dsChungTu.length-1){
                    saveFileChungTu(index+1);
                } else {
                    // FinishProcess();
                    console.log(listSerialTrue);
                    StartProcess();
                    countQrCreateSuccess = [];
                    processCreateQrcode(0);
                }
            }
        })
    } else {
        if(index < dsChungTu.length-1){
            saveFileChungTu(index+1);
        } else {
            // FinishProcess();
            console.log(listSerialTrue);
            StartProcess();
            countQrCreateSuccess = [];
            processCreateQrcode(0);
        }
    }
}

// function saveFileCmtCccd(index) {
//     var groupData = new FormData();
//     groupData.append("filePart", $("#wizard-picture-"+index).prop("files")[0]);
//     StartProcess();
//     var r = jsRoutes.controllers.TelcoQrcodeController.saveFileChungTu();
//     $.ajax({
//         type: r.type,
//         data: groupData,
//         contentType: false,
//         processData: false,
//         url: r.url,
//         success: function(data){
//             console.log(data);
//             if(data.success){
//                 var keyCode = document.getElementById("wizard-picture-"+index).getAttribute("key");
//                 dsLinkChungTu.push({
//                     "contents": "",
//                     "fileCode": keyCode,
//                     "fileName": data.content
//                 });
//                 console.log(dsLinkChungTu);
//             } else {
//                 if(data.status == 401){
//                     showNotification('danger', Messages("noti.sessionTimeOut"));
//                     window.location.href = jsRoutes.controllers.Application.logout().url;
//                 } else {
//                     showNotification('danger', data.errorString);
//                 }
//             }
//         },
//         error: function (xhr) {
//             console.log(xhr);
//             showNotification('danger',Messages("connection.failed"));
//             FinishProcess();
//         },
//         complete: function (){
//             if(index < 3){
//                 saveFileCmtCccd(index+1);
//             } else {
//                 // FinishProcess();
//                 console.log(listSerialTrue);
//                 StartProcess();
//                 countQrCreateSuccess = [];
//                 processCreateQrcode(0);
//             }
//         }
//     })
// }

var countQrCreateSuccess = new Array();
function processCreateQrcode(index) {
    var body = new FormData;
    body.serials = [listSerialTrue[index]];
    body.staffCode = $("#staffCode").val().trim();
    body.productCode = $("#packDataList").val();
    body.reasonId = $("#reasonList").val();
    body.reasonCode = listReasonCode[$("#reasonList").val()];
    body.idNo = $("#gpkdList").val();
    body.userInfo = {
        "province": $("#tinhTp").val(),
        "district": $("#quanHuyen").val(),
        "precinct": $("#phuongXa").val(),
        "areaCode": $("#tinhTp").val()+$("#quanHuyen").val()+$("#phuongXa").val(),
        "address": $("#diaChiChiTiet").val().trim(),
        "name": $("#nameCustomer").val().trim(),
        "nationality": $("#nationCustomer").val(),
        "birthDate": moment(moment($("#birthdayCustomer").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
        "custType": $("#typeCustomer").val(),
        "sex": $("#sexCustomer").val(),
        "listCustIdentity": [
            {
                "idType": $("#loai_giay_to").val(),
                "idNo": $("#so_giay_to").val(),
                "idIssueDate": moment(moment($("#ngay_cap").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD'),
                "idIssuePlace": $("#noi_cap").val(),
                "idExpireDate": moment(moment($("#ngay_het_han").val(), 'DD/MM/YYYY')).format('YYYY-MM-DD')
            }
        ]
    };
    body.profileDocument = {
        "lstFile": dsLinkChungTu
    };
    var pack = $("#packDataList").val();
    if(listTypePack[pack] == "POST_PAID"){
        body.accountId = $("#contractList").val();
    }
    console.log(body);

    var r = jsRoutes.controllers.TelcoQrcodeController.createQrcode();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success && datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var urlImg = hostGetImg + datas.content.data[0].qrImage;
                    countQrCreateSuccess.push({
                        "name": listSerialTrue[index],
                        "src": urlImg,
                        "verify": datas.content.data[0].verificationCode

                    });
                    $("#titleFinishCreateQrcode").html(Messages("Mã QR tạo thành công: ")+countQrCreateSuccess.length);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            if(index < listSerialTrue.length-1){
                processCreateQrcode(index+1);
            } else {
                FinishProcess();
                if(countQrCreateSuccess.length > 0){
                    var download =
                        '<div class="row">' +
                        '<span class="col-sm-4 col-form-label">'+Messages("Danh sách QR code")+'</span>' +
                        '<div class="col-sm-5 col-form-label" >' +Messages("Danh_sach_qr_code.xlsx")+ '</div>' +
                        '<label class="col-sm-3 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="exportZipImg()">' +
                        '<i class="bx bx-download"></i> '+Messages("Tải về")+
                        '</label>' +
                        '</div>';
                    $("#resultCreateQrcode").html(download);
                }
            }
        }
    })
}

function exportZipImg() {
    if(countQrCreateSuccess.length > 0){
        var zip = new JSZip();
        var count = 0;
        for (var i=0; i<countQrCreateSuccess.length;i++) {
            var filename = countQrCreateSuccess[i].name+"-"+countQrCreateSuccess[i].verify+".png";
            var url = countQrCreateSuccess[i].src;
            JSZipUtils.getBinaryContent(url, function (err, data) {
                if (err) {
                    throw err; // or handle the error
                }
                zip.file(filename, data, { binary: true });
                count++;
                if (count == countQrCreateSuccess.length) {
                    zip.generateAsync({ type: 'blob' }).then(function (content) {
                        saveAs(content, "QRCode.zip");
                    });
                }
            });
        }
    }
}


function backModalUpfileCustomer() {
    $("#addQrcodeFinishModal").modal('hide');
    $("#addUpfileCustomerModal").modal('show');
}