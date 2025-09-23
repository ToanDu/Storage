/**
 * Created by vtk-anhlt166 on 3/10/23.
 */
var ROLE_CMP = {
    UNKNOWN: {value: "NONE", name: "Không xác định"},
    SUPER_ADMIN: {value: "SUPER_ADMIN", name: "Super Admin"},
    ADMIN: {value: "ADMIN", name: "Admin"},
    SUPER_ENTERPRISE: {value: "SUPER_ENTERPRISE", name: "Đại lý"},
    ENTERPRISE: {value: "ENTERPRISE", name: "Doanh nghiệp"},
    ENTERPRISE_LV2: {value: "ENTERPRISE_LV2", name: "Doanh nghiệp cấp 2"},
    ENTERPRISE_VIEW: {value: "ENTERPRISE_VIEW", name: "TK Trải nghiệm"}
};
function getRoleNameByCode(code) {
    console.log(code);
    if(code != null && code != ""){
        if(code == ROLE_CMP.SUPER_ADMIN.value){
            return ROLE_CMP.SUPER_ADMIN.name;
        } else if(code == ROLE_CMP.ADMIN.value){
            return ROLE_CMP.ADMIN.name;
        } else if(code == ROLE_CMP.SUPER_ENTERPRISE.value){
            return ROLE_CMP.SUPER_ENTERPRISE.name;
        } else if(code == ROLE_CMP.ENTERPRISE.value){
            return ROLE_CMP.ENTERPRISE.name;
        } else if(code == ROLE_CMP.ENTERPRISE_VIEW.value){
            return ROLE_CMP.ENTERPRISE_VIEW.name;
        } else if(code == ROLE_CMP.ENTERPRISE_LV2.value){
            return ROLE_CMP.ENTERPRISE_LV2.name;
        } else if(code == ROLE_CMP.UNKNOWN.value){
            return ROLE_CMP.UNKNOWN.name;
        }
        else{
            return "NONE";
        }
    } else {
        return ROLE_CMP.UNKNOWN.name;
    }
}