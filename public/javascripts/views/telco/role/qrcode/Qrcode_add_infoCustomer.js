$(document).ready(function () {
    getListProvince();
})
function getListProvince() {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    // console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var province = '<option value="" selected>'+Messages("Tỉnh/ TP")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        province += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#tinhTp").html(province);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function selectDistrict() {
    if($("#tinhTp").val().length <= 0){
        $("#quanHuyen").html('<option value="" selected>'+Messages("Quận/Huyện")+'</option>');
        $("#phuongXa").html('<option value="" selected>'+Messages("Phường/Xã")+'</option>');
        return;
    }
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinhTp").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].district+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quanHuyen").html(district);
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function selectWard() {
    if($("#quanHuyen").val().length <= 0){
        $("#phuongXa").html('<option value="" selected>'+Messages("Phường/Xã")+'</option>');
        return;
    }
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#tinhTp").val()+$("#quanHuyen").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].precinct+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuongXa").html(ward);
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function backModalImportSerial() {
    $("#addQrcodeModal").modal('show');
    $("#addInfoCustomerModal").modal('hide');
}

function nextModalUpfileCustomer() {
    //validate
    if($("#nameCustomer").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền tên khách hàng"));
        return;
    }
    if($("#birthdayCustomer").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền ngày sinh"));
        return;
    }
    var birthdayCustomer = $('#birthdayCustomer').val();
    var dateMomentObject = moment(birthdayCustomer, "DD/MM/YYYY");
    var dateObject = dateMomentObject.toDate();
    var now = new Date();
    if((now.getTime() - dateObject.getTime())/1000 < 441504000){
        showNotification('danger',Messages("Thông tin ngày sinh khách hàng không đủ 14 tuổi"));
        return;
    }
    if($("#tinhTp").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn tỉnh/thành phố"));
        return;
    }
    if($("#quanHuyen").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn quận/huyện"));
        return;
    }
    if($("#phuongXa").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn phường/xã"));
        return;
    }
    if($("#diaChiChiTiet").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền địa chỉ chi tiết"));
        return;
    }
    if($("#so_giay_to").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền số giấy tờ"));
        return;
    }
    if($("#noi_cap").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền nơi cấp"));
        return;
    }
    if($("#ngay_cap").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn ngày cấp"));
        return;
    }
    if($("#ngay_het_han").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn ngày hết hạn"));
        return;
    }
    var ngay_cap = $('#ngay_cap').val();
    var ngay_cap_object = moment(ngay_cap, "DD/MM/YYYY");
    var ngayCapObject = ngay_cap_object.toDate();
    var ngay_het_han = $('#ngay_het_han').val();
    var ngay_het_han_object = moment(ngay_het_han, "DD/MM/YYYY");
    var ngayHetHanObject = ngay_het_han_object.toDate();
    if(ngayCapObject.getTime() >= now.getTime()){
        showNotification('danger',Messages("Ngày cấp không được quá ngày hiện tại"));
        return;
    }
    if(ngayCapObject.getTime() >= ngayHetHanObject.getTime()){
        showNotification('danger',Messages("Ngày cấp phải nhỏ hơn ngày hết hạn"));
        return;
    }

    //lay danh sach chung tư
    StartProcess();
    var body = new FormData();
    body.idNo = $("#gpkdList").val();
    console.log(body);
    var r = jsRoutes.controllers.TelcoOrderController.getCustomerType();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log('%c getCustomerType', 'background: #222; color: #bada55');
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.type != null){
                    var body = new FormData();
                    body.payType = listTypePack[$("#packDataList").val()];
                    body.actionCode = "00";
                    if(datas.content.data.type != null && datas.content.data.type.length > 0){
                        body.custType = datas.content.data.type;
                    } else {
                        body.custType = $("#typeCustomer").val();
                    }
                    body.serviceType = "M";
                    console.log(body);
                    var r = jsRoutes.controllers.TelcoOrderController.getListCt();
                    $.ajax({
                        type: r.type,
                        data: JSON.stringify(body),
                        contentType: "application/json; charset=utf-8",
                        url: r.url,
                        success: function(data){
                            console.log('%c getListCt', 'background: #222; color: #bada55');
                            console.log(data);
                            if(data.content != null){
                                if(data.content.listRecord != null && data.content.listRecord.length > 0){
                                    var record = "";
                                    for(var i=0; i<data.content.listRecord.length; i++){
                                        record +=
                                            '<div class="row mb-2 chung-tu" stt="'+i+'" code="'+data.content.listRecord[i].recordCode+'">' +
                                            '<span class="col-sm-6 col-form-label">'+data.content.listRecord[i].recordName+'</span>' +
                                            '<div class="col-sm-4" style="padding-left: 0px;">' +
                                            '<input type="file" id="filesCt-'+i+'" name="files" style="background-color: #aaa; width: 100%;" hidden/>' +
                                            '<input type="text" class="form-control input-form" id="nameCt-'+i+'" readonly/>' +
                                            '</div>' +
                                            '<label class="col-sm-2 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="clickButtonUpfile('+i+')">' +
                                            '<i class="bx bx-upload"></i> '+Messages("Upload file")+
                                            '</label>' +
                                            '</div>'
                                    }
                                    $("#listChungTu").html(record);
                                }
                            }
                        },
                        complete: function (){
                            FinishProcess();
                            $("#addInfoCustomerModal").modal('hide');
                            $("#addUpfileCustomerModal").modal('show');
                        }
                    })
                } else {
                    showNotification('danger',Messages("Không lấy được danh sách chứng từ"));
                    FinishProcess();
                    return;
                }
            } else {
                showNotification('danger',Messages("Không lấy được danh sách chứng từ"));
                FinishProcess();
                return;
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function clickButtonUpfile(index) {
    $("#filesCt-"+index).click();
    $("#filesCt-"+index).change(function (evt) {
        if (!browserSupportFileUpload()) {
            console.log('The File APIs are not fully supported in this browser!');
        } else {
            var file = evt.target.files[0];
            console.log(file);
            if(file != undefined){
                if (file.name.toLowerCase().endsWith(".pdf") || file.name.toLowerCase().endsWith(".jpeg") || file.name.toLowerCase().endsWith(".jpg") || file.name.toLowerCase().endsWith(".png")) {
                    $("#nameCt-"+index).val(file.name);
                    // document.getElementById("filesCt-"+index).value = "";
                } else {
                    showNotification('danger', Messages("File không đúng format pdf, jpeg, jpg, png"));
                    $("#nameCt-"+index).val("");
                    document.getElementById("filesCt-"+index).value = "";
                }
            }
        }
    });
}