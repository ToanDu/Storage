/**
 * Created by vtk-anhlt166 on 6/21/21.
 */
function pageStatistical() {
    if(localStorage.deviceId != null && localStorage.deviceId != undefined && localStorage.deviceId != ""){
        window.location.href = jsRoutes.controllers.DeviceVariableController.deviceVariable(localStorage.deviceId).url;
    }
}