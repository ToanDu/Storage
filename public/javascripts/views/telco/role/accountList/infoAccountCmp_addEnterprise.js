/**
 * Created by vtk-anhlt166 on 3/8/23.
 */

function clearDataAddEnterpriseByAdmin(){
    $("#nameEnterpriseAdd").val('');
    $("#gpkdEnterpriseAdd").val('');

}
function processSubmitAddEnterpriseBySAdmin() {
    if(!validateTextEmpty($('#nameEnterpriseAdd').val().trim())){
        showNotification('danger', Messages("Tên doanh nghiệp không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#gpkdEnterpriseAdd').val().trim())){
        showNotification('danger', Messages("GPKD không được bỏ trống"));
        return;
    }

    var body = new FormData();
    body.idNo = $('#gpkdEnterpriseAdd').val().trim();
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.validateGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                var body = new FormData();
                body.user_id = userId;
                var dataArr = [];
                dataArr.push({
                    "name": $('#nameEnterpriseAdd').val().trim(),
                    "business_license": $('#gpkdEnterpriseAdd').val().trim()
                });
                body.data = dataArr;
                console.log(body);
                // StartProcess();
                var r = jsRoutes.controllers.TelcoRoleAccountController.addEnterpriseBySAdmin();
                $.ajax({
                    type: r.type,
                    data: JSON.stringify(body),
                    contentType: "application/json; charset=utf-8",
                    url: r.url,
                    success: function(datas){
                        console.log(datas);
                        if(datas.content != null && datas.content.data != null){
                            var respon = datas.content.data;
                            if(respon.length > 0 && respon[0].code == 0){
                                showNotification('success',Messages("noti.Addsuccess"));
                                $("#addEnterpriseModal").modal('hide');
                                getInfoAccountCmp();
                            } else {
                                if(respon.length > 0 && respon[0].code == 2021){
                                    showNotification('danger',Messages("Số GPKD đã tồn tại"));
                                } else {
                                    showNotification('danger',Messages("noti.AddFalse"));
                                }
                            }

                        } else {
                            showNotification('danger',Messages("noti.AddFalse"));
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
            } else {
                showNotification('danger',Messages("GPKD không tồn tại trên hệ thống"));
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

/**
 * Created by vtk-anhlt166 on 3/8/23.
 */
function processSubmitAddEnpByAdminOrSEnterprise() {
    if(!validateTextEmpty($('#nameEnterpriseAdd').val().trim())){
        showNotification('danger', Messages("Tên doanh nghiệp không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#gpkdEnterpriseAdd').val().trim())){
        showNotification('danger', Messages("GPKD không được bỏ trống"));
        return;
    }

    var body = new FormData();
    body.idNo = $('#gpkdEnterpriseAdd').val().trim();
    console.log(body);
    // StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.validateGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                var body = new FormData();
                if(userCurrentId == userId){
                    body.name = $('#nameEnterpriseAdd').val().trim();
                    body.business_license = $('#gpkdEnterpriseAdd').val().trim();
                    console.log(body);

                    StartProcess();
                    var r = jsRoutes.controllers.TelcoRoleAccountController.addEnterpriseByAdminOrSEnterprise();
                    $.ajax({
                        type: r.type,
                        data: JSON.stringify(body),
                        contentType: "application/json; charset=utf-8",
                        url: r.url,
                        success: function(datas){
                            console.log(datas);
                            if(datas.content != null){
                                var respon = datas.content;
                                if(respon.code == 0){
                                    showNotification('success',Messages("noti.Addsuccess"));
                                    clearDataAddEnterpriseByAdmin();
                                    $("#addEnterpriseModal").modal('hide');
                                    getInfoAccountCmp();
                                } else {
                                    if(respon.code == 2021 || respon.code == 2035){
                                        showNotification('danger',Messages("Số GPKD đã tồn tại"));
                                    } else {
                                        showNotification('danger',Messages("noti.AddFalse"));
                                    }
                                }
                            } else {
                                showNotification('danger',Messages("noti.AddFalse"));
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
                } else {
                    body.user_id = userId;
                    var dataArr = [];
                    dataArr.push({
                        "name": $('#nameEnterpriseAdd').val().trim(),
                        "business_license": $('#gpkdEnterpriseAdd').val().trim()
                    });
                    body.data = dataArr;
                    console.log(body);

                    StartProcess();
                    var r = jsRoutes.controllers.TelcoRoleAccountController.addEnterpriseBySAdmin();
                    $.ajax({
                        type: r.type,
                        data: JSON.stringify(body),
                        contentType: "application/json; charset=utf-8",
                        url: r.url,
                        success: function(datas){
                            console.log(datas);
                            if(datas.content != null){
                                var respon = datas.content.data;
                                if(respon.length > 0 && respon[0].code == 0){
                                    showNotification('success',Messages("noti.Addsuccess"));
                                    $("#addEnterpriseModal").modal('hide');
                                    getInfoAccountCmp();
                                } else {
                                    if(respon.length > 0 && respon[0].code == 2021){
                                        showNotification('danger',Messages("Số GPKD đã tồn tại"));
                                    } else {
                                        showNotification('danger',Messages("noti.AddFalse"));
                                    }
                                }
                            } else {
                                showNotification('danger',Messages("noti.AddFalse"));
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


            } else {
                showNotification('danger',Messages("GPKD không tồn tại trên hệ thống"));
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
    });
}