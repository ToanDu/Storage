/**
 * Created by vtk-anhlt166 on 3/8/23.
 */
function viewInfoAccountCmp(id){
    var body = new FormData();
    body.user_id = id;
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
            if(datas.content != null && datas.content.info != null){
                $("#infoAccountModal").modal('show');

                $("#emailInfo").val(datas.content.info.email);
                $("#fullnameInfo").val(datas.content.info.name != null ? datas.content.info.name : "");
                $("#phoneInfo").val(datas.content.info.phone != null ? datas.content.info.phone : "");
                $("#roleInfo").val(datas.content.info.cmp_role != null ? getRoleNameByCode(datas.content.info.cmp_role) : "");
                // $("#nameEnterpriseInfo").val(datas.content.info.enterprise_name != null ? datas.content.info.enterprise_name : "");
                // $("#gpkdEnterpriseInfo").val(datas.content.info.enterprise_business_license != null ? datas.content.info.enterprise_business_license : "");

                if(datas.content.info.profile != null){
                    $("#diaChiChiTiet").val(datas.content.info.profile.full_address != null ? datas.content.info.profile.full_address : "");

                    if(datas.content.info.profile.province != null){
                        getListProvince(datas.content.info.profile.province, datas.content.info.profile.district, datas.content.info.profile.ward);
                    }
                } else {
                    $("#diaChiChiTiet").val("");
                    $("#tinhTP").val("");
                    $("#quanHuyen").val("");
                    $("#phuongXa").val("");
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
                        $("#tinhTP").val(data.content[i].name);
                        break;
                    }
                }
            } else {
                $("#tinhTP").val("");
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