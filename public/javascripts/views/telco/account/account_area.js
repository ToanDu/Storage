/**
 * Created by vtk-anhlt166 on 1/10/23.
 */
var listOptionProvince;
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
                $("#tinhTP").html(province);
                $("#tinhTpDN_0").html(province);
                listOptionProvince = province;
            }
        },
        complete: function (){
            // FinishProcess();
            // console.log(tinhTP);
            if(tinhTP != undefined && tinhTP.length > 0){
                $("#tinhTP").val(tinhTP);
                getListDistrict(tinhTP);
            }
        }
    })
}

function getListDistrict(province) {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = province;
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
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quanHuyen").html(district);
            }
        },
        complete: function (){
            // FinishProcess();
            // console.log(quanHuyen);
            if(quanHuyen != undefined && quanHuyen.length > 0){
                $("#quanHuyen").val(quanHuyen);
                getListWard(tinhTP, quanHuyen);
            }
        }
    })
}

function getListWard(province, district) {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = district;
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
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuongXa").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
            // console.log(phuongXa);
            if(quanHuyen != undefined && quanHuyen.length > 0){
                $("#phuongXa").val(phuongXa);
            }
        }
    })
}

//doanh nghiep
function getListProvinceDN(tinhTpDN, quanHuyenDN, phuongXaDN, stt) {
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
                $("#tinhTpDN_"+stt).html(province);

                setTimeout(function () {
                    $("#tinhTpDN_"+stt).val(tinhTpDN);
                },500);
            }
        },
        complete: function (){
            // FinishProcess();
            // console.log(tinhTpDN);
            if(tinhTpDN != undefined && tinhTpDN.length > 0){
                getListDistrictDN(tinhTpDN, quanHuyenDN, phuongXaDN, stt);
            }
        }
    })
}

function getListDistrictDN(tinhTpDN, quanHuyenDN, phuongXaDN, stt) {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = tinhTpDN;
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
                var district = '<option value="" selected>'+Messages("Quận/Huyện")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quanHuyenDN_"+stt).html(district);

                setTimeout(function () {
                    $("#quanHuyenDN_"+stt).val(quanHuyenDN);
                },500);
            }
        },
        complete: function (){
            // FinishProcess();
            if(quanHuyenDN != undefined && quanHuyenDN.length > 0){
                getListWardDN(tinhTpDN, quanHuyenDN, phuongXaDN, stt);
            }
        }
    })
}

function getListWardDN(tinhTpDN, quanHuyenDN, phuongXaDN, stt) {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = quanHuyenDN;
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
                var ward = '<option value="" selected>'+Messages("Phường/Xã")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuongXaDN_"+stt).html(ward);

                setTimeout(function () {
                    $("#phuongXaDN_"+stt).val(phuongXaDN);
                },500);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//onchange select
function selectDistrict() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinhTP").val();
    console.log(body);
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
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quanHuyen").html(district);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function selectWard() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quanHuyen").val();
    console.log(body);
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
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuongXa").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function selectDistrictDN(stt) {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinhTpDN_"+stt).val();
    console.log(body);
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
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quanHuyenDN_"+stt).html(district);
                $("#phuongXaDN_"+stt).html('<option value="">'+Messages("Phường/Xã")+'</option>');
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function selectWardDN(stt) {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quanHuyenDN_"+stt).val();
    console.log(body);
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
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#phuongXaDN_"+stt).html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}