function validateStartCreateQr() {
    var dsCt = document.getElementsByClassName("chung-tu");
    if(dsCt.length > 0){
        var isUpfileCt = true;
        for(var i=0; i<dsCt.length; i++){
            var stt = dsCt[i].getAttribute("stt");
            if($("#filesCt-"+stt).prop("files")[0] == undefined || $("#filesCt-"+stt).prop("files")[0] == null){
                isUpfileCt = false;
                break;
            }
        }
        if(!isUpfileCt){
            showNotification('danger',Messages("Bạn chưa upload dủ file chứng từ"));
            return;
        }
    }

    // if($("#wizard-picture-1").prop("files")[0] == null || $("#wizard-picture-1").prop("files")[0] == undefined){
    //     showNotification('danger', Messages("Vui lòng up ảnh đại diện"));
    //     return;
    // }
    // if($("#wizard-picture-2").prop("files")[0] == null || $("#wizard-picture-2").prop("files")[0] == undefined){
    //     showNotification('danger', Messages("Vui lòng up ảnh mặt trước CMT/CCCD"));
    //     return;
    // }
    // if($("#wizard-picture-3").prop("files")[0] == null || $("#wizard-picture-3").prop("files")[0] == undefined){
    //     showNotification('danger', Messages("Vui lòng up ảnh mặt sau CMT/CCCD"));
    //     return;
    // }

    StartProcess();
    $("#addUpfileCustomerModal").modal('hide');
    $("#addQrcodeFinishModal").modal('show');

    processUpfileChungTu();
}

function getContractByIdno(el) {
    var gpkd = el.value;
    if(gpkd.length <= 0){
        $("#contractList").html('<option value="">'+Messages("--- Chọn hợp đồng ---")+'</option>');
        return;
    }
    var data = new FormData();
    data.idNo = gpkd;
    console.log(data);
    StartProcess();
    var r = jsRoutes.controllers.TelcoContractController.getListContractByIdNo();
    $.ajax({
        type: r.type,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success && data.content != null){
                var listAccountDTO = data.content.listAccountDTO;
                if(listAccountDTO != null && listAccountDTO.length > 0){
                    var select = '<option value="">'+Messages("--- Chọn hợp đồng ---")+'</option>';
                    for(var i=0; i<listAccountDTO.length; i++){
                        select += '<option value="'+listAccountDTO[i].accountID+'">'+"0"+listAccountDTO[i].accountNo+'</option>'
                    }
                    select += '</select>';
                    $("#contractList").html(select);
                } else {
                    $("#contractList").html('<option value="">'+Messages("--- Chọn hợp đồng ---")+'</option>');
                }
            } else {
                $("#contractList").html('<option value="">'+Messages("--- Chọn hợp đồng ---")+'</option>');
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function backModalInfoCustomer() {
    $("#addUpfileCustomerModal").modal('hide');
    $("#addInfoCustomerModal").modal('show');
}