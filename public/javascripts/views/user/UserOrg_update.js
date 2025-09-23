function setUserOrg(userId,orgId){
    localStorage.setItem("selectedUserOrg",userId);
    value = "" + orgId;
    $('#listOrgUser').val(value);
}

function changeUserOrganization(){
    var Data = new FormData();
    Data.orgId = $('#listOrgUser').val();
    Data.userId = localStorage.getItem("selectedUserOrg");

    StartProcess()
    var r = jsRoutes.controllers.UserController.updateUserOrg();

    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
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
                showNotification('danger',data.errorString, data.status);
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