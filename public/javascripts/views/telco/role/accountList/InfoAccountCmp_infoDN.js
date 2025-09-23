/**
 * Created by vtk-anhlt166 on 3/10/23.
 */
function viewInfoAccount(userId, idEnterprise, businessLicense) {
    var body = new FormData();
    body.user_id = userId;
    body.id = idEnterprise;
    body.business_license = businessLicense;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.getInfoAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                $("#infoAccountModal").modal('show');

                if(datas.content.info != null){
                    $("#emailInfo").val(datas.content.info.email);
                    $("#fullnameInfo").val(datas.content.info.name != null ? datas.content.info.name : "");
                    $("#phoneInfo").val(datas.content.info.phone != null ? datas.content.info.phone : "");
                    $("#roleInfo").val(datas.content.info.cmp_role != null ? getRoleNameByCode(datas.content.info.cmp_role) : "");


                    if(datas.content.info.profile != null){
                        $("#diaChiChiTiet").val(datas.content.info.profile.full_address != null ? datas.content.info.profile.full_address : "");
                        $("#cmtInfo").val(datas.content.info.profile.identity_info != null ? datas.content.info.profile.identity_info.identity : "");
                        $("#ngaysinhInfo").val(datas.content.info.profile.dob != null ? datas.content.info.profile.dob : "");

                        if(datas.content.info.profile.province != null && datas.content.info.profile.province != ""){
                            getListProvince(datas.content.info.profile.province, datas.content.info.profile.district, datas.content.info.profile.ward);
                        }
                    } else {
                        $("#diaChiChiTiet").val("");
                    }
                }

                if(datas.content.enterprises != null && datas.content.enterprises.data != null){
                    var data = datas.content.enterprises.data;
                    $("#soGpkd").val(businessLicense);
                    for (i=0;i<data.length;i++){
                        if(data[i].business_license === businessLicense || (data[i].business_license_update === businessLicense)){
                            $("#tenDoanhNghiep").val(data[i].name);
                            $("#maSoThue").val(data[i].tax_code);

                            $("#ngayThanhLap").val(data[i].founded);
                            $("#sdtDN").val(data[i].phone);
                            $("#emailDN").val(data[i].email);
                            $("#diaChiChiTietDN").val(data[i].full_address);

                            $("#wizardPicturePreview").attr('src', hostname + "/getImg/" + data[i].business_license_image);

                            if(data[i].province != null && data[i].province != ""){
                                getListProvinceDN(data[i].province, data[i].district, data[i].ward);
                            }
                        }
                    }
                    console.log(data)
                    // if(data.length > 0){
                    //     $("#tenDoanhNghiep").val(data[0].name);
                    //     $("#maSoThue").val(data[0].tax_code);
                    //     $("#soGpkd").val(data[0].business_license);
                    //     $("#ngayThanhLap").val(data[0].founded);
                    //     $("#sdtDN").val(data[0].phone);
                    //     $("#emailDN").val(data[0].email);
                    //     $("#diaChiChiTietDN").val(data[0].full_address);
                    //
                    //     $("#wizardPicturePreview").attr('src', hostname + "/getImg/" + data[0].business_license_image);
                    //
                    //     if(data[0].province != null && data[0].province != ""){
                    //         getListProvinceDN(data[0].province, data[0].district, data[0].ward);
                    //     }
                    // }

                }
            } else {
                showNotification('danger',Messages("Không tìm thấy dữ liệu"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function getListProvince(province, district, ward) {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == province){
                        $("#tinhTp").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#tinhTp").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListDistrict(province, district, ward);
        }
    })
}
function getListDistrict(province, district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == district){
                        $("#quanHuyen").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#quanHuyen").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListWard(district, ward);
        }
    })
}
function getListWard(district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == ward){
                        $("#phuongXa").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#phuongXa").val("");
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function getListProvinceDN(province, district, ward) {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == province){
                        $("#tinhTpDN").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#tinhTpDN").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListDistrictDN(province, district, ward);
        }
    })
}
function getListDistrictDN(province, district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == district){
                        $("#quanHuyenDN").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#quanHuyenDN").val("");
            }
        },
        complete: function (){
            // FinishProcess();
            getListWardDN(district, ward);
        }
    })
}
function getListWardDN(district, ward) {
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
            if(data.content != null && data.content.length > 0){
                for(var i=0; i<data.content.length; i++){
                    if(data.content[i].areaCode == ward){
                        $("#phuongXaDN").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#phuongXaDN").val("");
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}