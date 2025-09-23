/**
 * Created by vtk-anhlt166 on 11/30/21.
 */
function showPopupDelProject(id) {
    $("#idProjectDelete").val(id);

    $("#deleteProjectConfirm").modal('show');
}
function postDataProject() {
    var groupData = new FormData();
    groupData.id = $("#idProjectDelete").val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.ProjectController.delProject();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                getListProject();
            }else{
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