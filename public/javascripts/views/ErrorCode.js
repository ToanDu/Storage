/**
 * Created by vtk-anhlt166 on 12/13/21.
 */
var ERROR_CODE = {
    AUTHEN: {value: 401, name: Messages("error.authen")},
    FORBIDDEN: {value: 403, name: Messages("error.forbidden")},
    NOT_FOUND: {value: 404, name: Messages("error.notFound")},
    METHOD_NOT_ALLOWED: {value: 409, name: Messages("error.methodNotAllowed")},
    ERROR_SERVER: {value: 500, name: Messages("error.errorServer")},

};
function showErrorCode(errorString, code) {
    if(code == ERROR_CODE.AUTHEN.value){
        showNotification('danger', Messages(ERROR_CODE.AUTHEN.name));
    } else if(code == ERROR_CODE.FORBIDDEN.value){
        showNotification('danger', Messages(ERROR_CODE.FORBIDDEN.name));
    } else if(code == ERROR_CODE.NOT_FOUND.value){
        showNotification('danger', Messages(ERROR_CODE.NOT_FOUND.name));
    } else if(code == ERROR_CODE.METHOD_NOT_ALLOWED.value){
        showNotification('danger', Messages(ERROR_CODE.METHOD_NOT_ALLOWED.name));
    } else if(code == ERROR_CODE.ERROR_SERVER.value){
        showNotification('danger', Messages(ERROR_CODE.ERROR_SERVER.name));
    }
    else {
        showNotification('danger', Messages(errorString));
    }
}