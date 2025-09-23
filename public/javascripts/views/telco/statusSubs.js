/**
 * Created by vtk-anhlt166 on 11/30/22.
 */
var ACT_STATUS = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    s000: {value: 0, name: "Bình thường"},
    s020: {value: 20, name: "Chặn 2 chiều nợ cước"},
    s010: {value: 10, name: "Chặn 1 chiều nợ cước"},
    s030: {value: 30, name: "Chưa kích hoạt"},
    s100: {value: 100, name: "Chặn 1 chiều khách hàng yêu cầu"},
    s110: {value: 110, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước"},
    s120: {value: 120, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước"},
    s200: {value: 200, name: "Chặn 2 chiều khách hàng yêu cầu"},
    s210: {value: 210, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước"},
    s220: {value: 220, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước"}
};

var ACT_STATUS_SAU = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    s000: {value: 0, name: "Bình thường"},
    s010: {value: 10, name: "Chặn 1 chiều nợ cước"},
    s020: {value: 20, name: "Chặn 2 chiều nợ cước"},
    s030: {value: 30, name: "Chưa kích hoạt"},
    s100: {value: 100, name: "Chặn 1 chiều khách hàng yêu cầu"},
    s110: {value: 110, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước"},
    s120: {value: 120, name: "Chặn 1 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước"},
    s200: {value: 200, name: "Chặn 2 chiều khách hàng yêu cầu"},
    s210: {value: 210, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước"},
    s220: {value: 220, name: "Chặn 2 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước"}
};

function getStatusByCode(code, type) {
    code = parseInt(code);
    type = parseInt(type);

    if(type = PAY_TYPE.TRUOC.value){
        if(code == ACT_STATUS.s000.value){
            return ACT_STATUS.s000.name;
        } else if(code == ACT_STATUS.s010.value){
            return ACT_STATUS.s010.name;
        } else if(code == ACT_STATUS.s020.value){
            return ACT_STATUS.s020.name;
        } else if(code == ACT_STATUS.s030.value){
            return ACT_STATUS.s030.name;
        } else if(code == ACT_STATUS.s100.value){
            return ACT_STATUS.s100.name;
        } else if(code == ACT_STATUS.s110.value){
            return ACT_STATUS.s110.name;
        } else if(code == ACT_STATUS.s120.value){
            return ACT_STATUS.s120.name;
        } else if(code == ACT_STATUS.s200.value){
            return ACT_STATUS.s200.name;
        } else if(code == ACT_STATUS.s220.value){
            return ACT_STATUS.s220.name;
        } else if(code == ACT_STATUS.s210.value){
            return ACT_STATUS.s210.name;
        } else {
            return ACT_STATUS.UNKNOWN.name;
        }
    } else if(type = PAY_TYPE.SAU.value){
        if(code == ACT_STATUS_SAU.s000.value){
            return ACT_STATUS_SAU.s000.name;
        } else if(code == ACT_STATUS_SAU.s010.value){
            return ACT_STATUS_SAU.s010.name;
        } else if(code == ACT_STATUS_SAU.s020.value){
            return ACT_STATUS_SAU.s020.name;
        } else if(code == ACT_STATUS.s030.value){
            return ACT_STATUS.s030.name;
        } else if(code == ACT_STATUS_SAU.s100.value){
            return ACT_STATUS_SAU.s100.name;
        } else if(code == ACT_STATUS_SAU.s110.value){
            return ACT_STATUS_SAU.s110.name;
        } else if(code == ACT_STATUS_SAU.s120.value){
            return ACT_STATUS_SAU.s120.name;
        } else if(code == ACT_STATUS_SAU.s200.value){
            return ACT_STATUS_SAU.s200.name;
        } else if(code == ACT_STATUS_SAU.s220.value){
            return ACT_STATUS_SAU.s220.name;
        } else if(code == ACT_STATUS_SAU.s210.value){
            return ACT_STATUS_SAU.s210.name;
        } else {
            return ACT_STATUS_SAU.UNKNOWN.name;
        }
    } else {
        return ACT_STATUS.UNKNOWN.name;
    }
}