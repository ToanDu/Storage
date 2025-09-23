/**
 * Created by vtk-anhlt166 on 2/6/23.
 */
function validateFormInfoDNOrderSim() {

    if(!validateInputId("ten_ng_dai_dien")){
        showNotification('danger',Messages("validation.representative.required"));
        return false;
    }
    if(!validateInputId("ma_so_doanh_nghiep")){
        showNotification('danger',Messages("validation.businessLicense.required"));
        return false;
    }
    if(!validateInputId("so_dien_thoai_lien_he")){
        showNotification('danger',Messages("validation.phone.required"));
        return false;
    }
    let sdtContact = $('#so_dien_thoai_lien_he').val().trim();
    if (sdtContact.length > 0 && !validatePhoneVn(sdtContact)) {
        showNotification('danger', Messages("validation.phone.format"));
        return false;
    }
    if(!validateInputId("ten_doanh_nghiep")){
        showNotification('danger',Messages("validation.businessName.required"));
        return false;
    }
    
    if(!document.getElementById("inlineRadio1").checked && !document.getElementById("inlineRadio2").checked){
        showNotification('danger',Messages("validation.deliveryMethod.required"));
        return false;
    }
    if(!validateInputId("tinh_tp") || !validateInputId("quan_huyen") || !validateInputId("phuong_xa")){
        showNotification('danger',Messages("validation.address.required"));
        return false;
    }
    if(!validateInputId("dia_chi_chi_tiet")){
        showNotification('danger',Messages("validation.detailAddress.required"));
        return false;
    }   
    return true;
}

//validate form choose packdata
function validateFormChoosePack() {
    var reasonList = document.getElementsByClassName("choose_reason");
    var count = 0;
    for(var i=0; i<reasonList.length; i++){
        // console.log(reasonList[i].value);
        if(reasonList[i].value == "" || reasonList[i].value == undefined){
            count++;
        }
    }
    if(count > 0){
        showNotification('danger',Messages("validation.package.required"));
        return false;
    }

    var countPackList = document.getElementsByClassName("count_pack_data");
    var countPack = 0;
    for(var j=0; j<countPackList.length; j++){
        // console.log(reasonList[j]);
        if(countPackList[j].value == "" || countPackList[j].value <= 0){
            countPack++;
        }
    }
    if(countPack > 0){
        showNotification('danger',Messages("validation.simQuantity.required"));
        return false;
    }

    return true;
}

function validateInputId(id) {
    var input = document.getElementById(id);
    if(input != null && input != undefined){
        var value = $("#"+id).val();
        if(value != undefined && value != null && value.length > 0){
            if(value.replaceAll(/\s/g, '').length > 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        return true;
    }
}

function validateFormChooseSubs() {
    var countSubscriberBuy = document.getElementsByClassName("countSubscriberBuy");
    for(var i=0; i<countSubscriberBuy.length; i++){
        var stt = countSubscriberBuy[i].getAttribute("id").replace("countSubscriberBuy_","");
        // console.log(stt);
        var countSub = $("#countSubscriberBuy_"+stt).val();

        var countChoosed = 0;
        var checkboxChooseSubsBuy = document.getElementsByClassName("checkbox-chooseSubsBuy-"+stt);
        if(checkboxChooseSubsBuy != undefined && checkboxChooseSubsBuy.length > 0){
            for(var j=0; j<checkboxChooseSubsBuy.length; j++){
                if(checkboxChooseSubsBuy[j].checked){
                    countChoosed++;
                }
            }
        }
        if(countChoosed != countSub){
            showNotification('danger',Messages("validation.subscriber.quantity.invalid"));

            return false;
            break;
        }
    }



    // var countTotal = 0;
    // var listCount = document.getElementsByClassName("count_pack_data");
    // if(listCount != undefined && listCount.length>0){
    //     for(var i=0 ; i<listCount.length; i++){
    //         // console.log(listCount[i].value);
    //         countTotal += parseInt(listCount[i].value);
    //     }
    // }
    // console.log(countTotal);
    // var checkboxChooseSubsBuy = document.getElementsByClassName("chooseSubsBuy");
    // var countCheckBuySub = 0;
    // if(checkboxChooseSubsBuy != undefined && checkboxChooseSubsBuy.length > 0){
    //     for(var j=0; j<checkboxChooseSubsBuy.length; j++){
    //         // console.log(checkboxChooseSubsBuy[j]);
    //         if(checkboxChooseSubsBuy[j].checked){
    //             countCheckBuySub++;
    //         }
    //     }
    // }
    // console.log(countCheckBuySub);
    // if(countCheckBuySub == 0){
    //     showNotification('danger',Messages("Bạn chưa chọn thuê bao"));
    //     return false;
    // }
    // if(countCheckBuySub != countTotal){
    //     showNotification('danger',Messages("Bạn chưa chọn đủ số lượng thuê bao"));
    //     return false;
    // }

    return true;
}
