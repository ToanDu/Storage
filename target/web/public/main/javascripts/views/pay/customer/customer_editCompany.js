/**
 * Created by vtk-anhlt166 on 3/2/22.
 */
function getInfoVendor() {
    // StartProcess();
    var formData = new FormData;
    formData.projectId = projectId;
    console.log(formData);
    var url = jsRoutes.controllers.PayCustomerController.getInfoVendor();
    $.ajax({
        type: url.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: url.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                $("#isUpdateVendor").val(1);
                $("#nameVendorEdit").val(datas.content.data.name);
                $("#faxVendorEdit").val(datas.content.data.tax_code);
                $("#addressVendorEdit").val(datas.content.data.address);

                $("#nameVendor").html(Messages("Tên nhà cung cấp: ") + datas.content.data.name);
                $("#faxVendor").html(Messages("Mã số thuế: ") + datas.content.data.tax_code);
                $("#addressVendor").html(Messages("Địa chỉ: ") + datas.content.data.address);
            } else {
                $("#nameVendor").html(Messages("Tên nhà cung cấp: "));
                $("#faxVendor").html(Messages("Mã số thuế: "));
                $("#addressVendor").html(Messages("Địa chỉ: "));

                $("#isUpdateVendor").val(0);
                $("#nameVendorEdit").val("");
                $("#faxVendorEdit").val("");
                $("#addressVendorEdit").val("");
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function updateVendorInfo() {
    StartProcess();
    var formData = new FormData;

    var r = jsRoutes.controllers.PayCustomerController.updateVendor();
    if($("#isUpdateVendor").val() == 0){
        r = jsRoutes.controllers.PayCustomerController.createVendor();
    }
    formData.project_id = projectId;
    formData.name = $("#nameVendorEdit").val();
    formData.tax_code = $("#faxVendorEdit").val();
    formData.address = $("#addressVendorEdit").val();
    console.log(formData);

    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                getInfoVendor();
                showNotification('success',Messages("noti.Updatesuccess"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess();
        }
    });
}