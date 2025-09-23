/**
 * Created by vtk-anhlt166 on 3/2/22.
 */
function cancelPackData(){
    var groupData = new FormData();
    groupData.id = $("#idDelete").val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PayCustomerController.cancelSubscription();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                getSubsOfUser(userIdCurrent);

                showNotification('success', Messages("connection.Updatesuccess"));
            } else {
                showNotification('danger', datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}

function showModalCancle() {
    $("#cancelPackdataConfirm").modal('show');
}