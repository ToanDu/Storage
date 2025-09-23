var dsLinhVuc;
var dsDongThietBi;
//check doanh nghiep da khao sat hay chua
$(document).ready(function () {
    getInfoSurvey();
})
function getInfoSurvey() {
    // StartProcess();
    var body = new FormData();
    body.userId = userId;
    console.log(body);
    var r = jsRoutes.controllers.TelcoLogController.getInfoSurvey();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas, "getInfoSurvey");
            if(datas.content == null || datas.content.length == 0){
                $("#updateTypeBusinessModal").modal('show');
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    })
}

var listStt = new Array();
function comfirmSurvey() {
    if($("#tenKhachHang").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền tên khách hàng"));
        return;
    }
    if($("#ngLienHe").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền người liên hệ"));
        return;
    }
    if($("#chucVu").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền chức vụ"));
        return;
    }
    if($("#soThueBao").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền số thuê bao"));
        return;
    }

    if($("#q1").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }
    if($("#q4").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }
    // if($("#q5").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }
    if($("#q6").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }
    // if($("#q7").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }if($("#q8").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }if($("#q9").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }if($("#q10").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }
    // if($("#q11").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }
    // if($("#q12").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }
    // if($("#q13").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }if($("#q14").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }
    // if($("#q15").val().trim().length <= 0){
    //     showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
    //     return;
    // }
    if($("#q17").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }if($("#q19").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }if($("#q20").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }
    if($("#q21").val().trim().length <= 0){
        showNotification('danger',Messages("Bạn chưa điền đủ thông tin"));
        return;
    }

    var classDivNewUtilities = document.getElementsByClassName("q2");
    var isCheckChoosedNewUtilities = false;
    for(var j=0; j<classDivNewUtilities.length; j++){
        if(classDivNewUtilities[j].checked){
            isCheckChoosedNewUtilities = true;
            break;
        }
    }
    if(!isCheckChoosedNewUtilities){
        showNotification('danger', Messages("Bạn chưa chọn tính năng nâng cao sắp triển khai trên hệ thống CMP "));
        return;
    }

    var classDivUtilitiesSurvey = document.getElementsByClassName("q3");
    var isCheckChoosedUtilitiesSurvey = false;
    for(var k=0; k<classDivUtilitiesSurvey.length; k++){
        if(classDivUtilitiesSurvey[k].checked){
            isCheckChoosedUtilitiesSurvey = true;
            break;
        }
    }
    if(!isCheckChoosedUtilitiesSurvey){
        showNotification('danger', Messages("Bạn chưa chọn các tính năng chưa dùng thử trên CMP"));
        return;
    }

    var q5 = document.getElementsByClassName("q5");
    var isCheckChoosedQ5 = false;
    for(var k=0; k<q5.length; k++){
        if(q5[k].checked){
            isCheckChoosedQ5 = true;
            break;
        }
    }
    if(!isCheckChoosedQ5){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q7 = document.getElementsByClassName("q7");
    var isCheckChoosedQ7 = false;
    for(var k=0; k<q7.length; k++){
        if(q7[k].checked){
            isCheckChoosedQ7 = true;
            break;
        }
    }
    if(!isCheckChoosedQ7){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q8 = document.getElementsByClassName("q8");
    var isCheckChoosedQ8 = false;
    for(var k=0; k<q8.length; k++){
        if(q8[k].checked){
            isCheckChoosedQ8 = true;
            break;
        }
    }
    if(!isCheckChoosedQ8){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q9 = document.getElementsByClassName("q9");
    var isCheckChoosedQ9 = false;
    for(var k=0; k<q9.length; k++){
        if(q9[k].checked){
            isCheckChoosedQ9 = true;
            break;
        }
    }
    if(!isCheckChoosedQ9){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q10 = document.getElementsByClassName("q10");
    var isCheckChoosedQ10 = false;
    for(var k=0; k<q10.length; k++){
        if(q10[k].checked){
            isCheckChoosedQ10 = true;
            break;
        }
    }
    if(!isCheckChoosedQ10){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q11 = document.getElementsByClassName("q11");
    var isCheckChoosedQ11 = false;
    for(var k=0; k<q11.length; k++){
        if(q11[k].checked){
            isCheckChoosedQ11 = true;
            break;
        }
    }
    if(!isCheckChoosedQ11){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q12 = document.getElementsByClassName("q12");
    var isCheckChoosedQ12 = false;
    for(var k=0; k<q12.length; k++){
        if(q12[k].checked){
            isCheckChoosedQ12 = true;
            break;
        }
    }
    if(!isCheckChoosedQ12){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q13 = document.getElementsByClassName("q13");
    var isCheckChoosedQ13 = false;
    for(var k=0; k<q13.length; k++){
        if(q13[k].checked){
            isCheckChoosedQ13 = true;
            break;
        }
    }
    if(!isCheckChoosedQ13){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q14 = document.getElementsByClassName("q14");
    var isCheckChoosedQ14 = false;
    for(var k=0; k<q14.length; k++){
        if(q14[k].checked){
            isCheckChoosedQ14 = true;
            break;
        }
    }
    if(!isCheckChoosedQ14){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }

    var q15 = document.getElementsByClassName("q15");
    var isCheckChoosedQ15 = false;
    for(var k=0; k<q15.length; k++){
        if(q15[k].checked){
            isCheckChoosedQ15 = true;
            break;
        }
    }
    if(!isCheckChoosedQ15){
        showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
        return;
    }
    // for(var  i = 7;i < 16;i++ ){
    //     var q = document.getElementsByClassName(query);
    //     var query = "q"+i;
    //     var isCheckChoosedQ = false;
    //     for(var k=0; k<q.length; k++){
    //         if(q[k].checked){
    //             isCheckChoosedQ = true;
    //             break;
    //         }
    //     }
    //     if(!isCheckChoosedQ){
    //         showNotification('danger', Messages("Bạn chưa trả lời câu hỏi"));
    //         return;
    //     }
    // }

    var classDivApplicationField = document.getElementsByClassName("q16");
    var isCheckChoosedApplicationField = false;
    for(var k=0; k<classDivApplicationField.length; k++){
        if(classDivApplicationField[k].checked){
            isCheckChoosedApplicationField = true;
            break;
        }
    }
    if(!isCheckChoosedApplicationField){
        showNotification('danger', Messages("Bạn chưa chọn lĩnh vực cho doanh nghiệp của bạn"));
        return;
    }

    var classDivQuestionSurvey = document.getElementsByClassName("q18");
    var isCheckChoosedQuestionSurvey = false;
    for(var k=0; k<classDivQuestionSurvey.length; k++){
        if(classDivQuestionSurvey[k].checked){
            isCheckChoosedQuestionSurvey = true;
            break;
        }
    }
    if(!isCheckChoosedQuestionSurvey){
        showNotification('danger', Messages("Bạn chưa đưa ra lựa chọn của mình"));
        return;
    }

    processSaveFormCustomerSurvey();
}

function processSaveFormCustomerSurvey() {
    var classDivQ3 = document.getElementsByClassName("q3");
    var q3 = "";
    for(var j=0; j<classDivQ3.length; j++){
        if(classDivQ3[j].checked){
            q3 = classDivQ3[j].value;
            break;
        }
    }

    var classDivQ5 = document.getElementsByClassName("q5");
    var q5 = "";
    for(var j=0; j<classDivQ5.length; j++){
        if(classDivQ5[j].checked){
            q5 = classDivQ5[j].value;
            break;
        }
    }

    var classDivQ7 = document.getElementsByClassName("q7");
    var q7 = "";
    for(var j=0; j<classDivQ7.length; j++){
        if(classDivQ7[j].checked){
            q7 = classDivQ7[j].value;
            break;
        }
    }

    var classDivQ8 = document.getElementsByClassName("q8");
    var q8 = "";
    for(var j=0; j<classDivQ8.length; j++){
        if(classDivQ8[j].checked){
            q8 = classDivQ8[j].value;
            break;
        }
    }

    var classDivQ9 = document.getElementsByClassName("q9");
    var q9 = "";
    for(var j=0; j<classDivQ9.length; j++){
        if(classDivQ9[j].checked){
            q9 = classDivQ9[j].value;
            break;
        }
    }

    var classDivQ10 = document.getElementsByClassName("q10");
    var q10 = "";
    for(var j=0; j<classDivQ10.length; j++){
        if(classDivQ10[j].checked){
            q10 = classDivQ10[j].value;
            break;
        }
    }

    var classDivQ11 = document.getElementsByClassName("q11");
    var q11 = "";
    for(var j=0; j<classDivQ11.length; j++){
        if(classDivQ11[j].checked){
            q11 = classDivQ11[j].value;
            break;
        }
    }

    var classDivQ12 = document.getElementsByClassName("q12");
    var q12 = "";
    for(var j=0; j<classDivQ12.length; j++){
        if(classDivQ12[j].checked){
            q12 = classDivQ12[j].value;
            break;
        }
    }

    var classDivQ13 = document.getElementsByClassName("q13");
    var q13 = "";
    for(var j=0; j<classDivQ13.length; j++){
        if(classDivQ13[j].checked){
            q13 = classDivQ13[j].value;
            break;
        }
    }
    var classDivQ14 = document.getElementsByClassName("q14");
    var q14 = "";
    for(var j=0; j<classDivQ14.length; j++){
        if(classDivQ14[j].checked){
            q14 = classDivQ14[j].value;
            break;
        }
    }

    var classDivQ15 = document.getElementsByClassName("q15");
    var q15 = "";
    for(var j=0; j<classDivQ15.length; j++){
        if(classDivQ15[j].checked){
            q15 = classDivQ15[j].value;
            break;
        }
    }

    var classDivQ2 = document.getElementsByClassName("q2");
    var q2 = "";
    for(var k=0; k<classDivQ2.length; k++){
        if(classDivQ2[k].checked){
            if(k<classDivQ2.length-1){
                q2 += classDivQ2[k].value+",";
            } else {
                q2 += classDivQ2[k].value;
            }
        }
    }

    var classDivQ16 = document.getElementsByClassName("q16");
    var q16 = "";
    for(var k=0; k<classDivQ16.length; k++){
        if(classDivQ16[k].checked){
            if(k<classDivQ16.length-1){
                q16 += classDivQ16[k].value+",";
            } else {
                q16 += classDivQ16[k].value;
            }
        }
    }

    var classDivQ18 = document.getElementsByClassName("q18");
    var q18 = "";
    for(var j=0; j<classDivQ18.length; j++){
        if(classDivQ18[j].checked){
            q18 = classDivQ18[j].value;
            break;
        }
    }

    var groupData = {
        "tenKhachHang": $("#tenKhachHang").val().trim(),
        "ngLienHe": $("#ngLienHe").val().trim(),
        "chucVu": $("#chucVu").val().trim(),
        "soThueBao": $("#soThueBao").val(),
        "q1":$("#q1").val().trim(),
        "q2":q2,
        "q3":q3,
        "q4":$("#q4").val().trim(),
        "q5":q5,
        "q6":$("#q6").val().trim(),
        "q7":q7,
        "q8":q8,
        "q9":q9,
        "q10":q10,
        "q11":q11,
        "q12":q12,
        "q13":q13,
        "q14":q14,
        "q15":q15,
        "q16":q16,
        "q17":$("#q17").val().trim(),
        "q18":q18,
        "q19":$("#q19").val().trim(),
        "q20":$("#q20").val().trim(),
        "q21":$("#q21").val().trim(),
    }

    console.log(groupData);
    StartProcess();
    var r = jsRoutes.controllers.TelcoLogController.saveFormCustomerSurvey();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                showNotification('success', Messages("Gửi khảo sát thành công"));
                $("#updateTypeBusinessModal").modal('hide');
            } else {
                showNotification('danger', Messages("Gửi khảo sát không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}