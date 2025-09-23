/**
 * Created by vtk-anhlt166 on 1/4/23.
 */
var dataImportRechargeSubs = new Array();
var listRechargeSubs = new Array();
var arrayIsdnRechargeSubs = new Array();
var listRechargeSubsTrue = new Array();
var listRechargeSubsFalse = new Array();
var listIdNoRechargeSubsTrue = new Array();
function uploadRechargeSubs(evt) {
    dataImportRechargeSubs = [];
    arrayIsdnRechargeSubs = [];
    listRechargeSubs = [];
    listRechargeSubsTrue = [];
    listRechargeSubsFalse = [];
    listRechargeSubsTrueSubmit = [];
    listIdNoRechargeSubsTrue = [];

    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var fileList = evt.target.files;
        console.log("fileList", fileList);
        var file = fileList[0];
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("File không đúng format xlsx"));
            return;
        }
        $("#nameFileRechargeSubs").val(file.name);

        var reader = new FileReader();
        reader.readAsBinaryString(file);
        reader.onload = function (event) {
            var data = event.target.result;
            var workbook = XLSX.read(data, {
                type: 'binary'
            });
            var firstSheet = workbook.SheetNames[0];
            console.log(firstSheet.name);
            //header: 1 de lay deader
            dataImportRechargeSubs = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(dataImportRechargeSubs);
            if(dataImportRechargeSubs.length > 1){
                for(var i=1; i<dataImportRechargeSubs.length; i++){
                    if(dataImportRechargeSubs[i][1] != null){
                        if(validatePhone(dataImportRechargeSubs[i][1])){
                            if(!arrayIsdnRechargeSubs.includes(dataImportRechargeSubs[i][1])){
                                arrayIsdnRechargeSubs.push(dataImportRechargeSubs[i][1]);
                                listRechargeSubsTrue.push(dataImportRechargeSubs[i][1]);
                            }
                        } else {
                            listRechargeSubsFalse.push(dataImportRechargeSubs[i][1]);
                        }
                    }
                }

                if(listRechargeSubsTrue.length > 0){
                    checkValidateListSubRecharge(0);
                }

            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
                return;
            }

            // $("#importRechargeSubsModal").modal('hide');
            // document.getElementById('filesRechargeSubs').value = '';
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesRechargeSubs").value = "";
    }
}

var listRechargeSubsTrueSubmit = new Array();
function checkValidateListSubRecharge(index) {
    // console.log(listRechargeSubsTrue);
    var body = new FormData();
    body.userId = userId;
    body.isdn = listRechargeSubsTrue[index];
    body.actionCode = "10";
    console.log(body);

    if(index == 0){
        StartProcess();
    }
    var r = jsRoutes.controllers.TelcoUtilitiesController.validateSubs();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.valid){
                    listRechargeSubsTrueSubmit.push(listRechargeSubsTrue[index]);
                    listIdNoRechargeSubsTrue[listRechargeSubsTrue[index]] = datas.content.data.idNo;
                } else {
                    listRechargeSubsFalse.push(listRechargeSubsTrue[index]);
                }
            } else {
                listRechargeSubsFalse.push(listRechargeSubsTrue[index]);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            listRechargeSubsFalse.push(listRechargeSubsTrue[index]);
        },
        complete: function (){
            // FinishProcess();
            $("#countRechargeSubsTrue").html(listRechargeSubsTrueSubmit.length);
            $("#countRechargeSubsFalse").html(listRechargeSubsFalse.length);

            if(index < listRechargeSubsTrue.length-1){
                checkValidateListSubRecharge(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function cancleImportFileSubsRecharge() {
    $("#importListSubMiAddonModal").modal('hide');
    $("#nameFileRechargeSubs").val("");
    $("#countRechargeSubsTrue").html("0");
    $("#countRechargeSubsFalse").html("0");
}

function comfirmTableListSubsRecharge() {
    if(listRechargeSubsTrueSubmit.length > 0){
        $("#dataImportRechargeSubs").html("");
        var mtml = "";
        mtml+="<div style='height: 27rem;overflow: scroll;background-color: #f6f6f6;'>";
        mtml += "<h4>"+Messages("Danh sách thuê bao")+"</h4>" +
            "<table id='smlTableSubsRecharge' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
            "<thead>" +
            "<th>"+"<input type='checkbox' id='checkall-rechargeSub' onchange='checkAllRechargeSubs(this)' checked>"+"</th>" +
            "<th>"+Messages("STT")+"</th>" +
            "<th>"+Messages("Số thuê bao")+"</th>" +
            "<th>"+Messages("Trạng thái")+"</th>" +
            "</thead>" +
            "<tbody>";
        for(var i=0; i<listRechargeSubsTrueSubmit.length; i++){
            mtml += "<tr>";
            mtml += "<td>" +"<input type='checkbox' class='checkbox-rechargeSub' value='"+listRechargeSubsTrueSubmit[i]+"' onchange='checkListCheckboxTableRecharge()' checked>"+ "</td>";
            mtml += "<td>" +(i+1)+ "</td>";
            mtml += "<td>" + listRechargeSubsTrueSubmit[i] + "</td>";
            mtml += "<td class='wrap-text' id='status-recharge-"+listRechargeSubsTrueSubmit[i]+"'></td>";
            mtml += "</tr>";
        }

        mtml += "</tbody></table></div>";
        $("#dataImportRechargeSubs").html(mtml);
        chooseMoneyNap($("#moneyRecharge").val());
    } else {
        showNotification('danger',Messages("Không có thuê bao hợp lệ"));
    }
    $("#nameFileRechargeSubs").val("");
    $("#countRechargeSubsTrue").html("0");
    $("#countRechargeSubsFalse").html("0");
}
function checkListCheckboxTableRecharge() {
    var countCheckbox = true;
    $(".checkbox-rechargeSub").each(function() {
        if(!this.checked){
            countCheckbox = false;
        }
    });
    if(countCheckbox){
        document.getElementById("checkall-rechargeSub").checked = true;
    } else {
        document.getElementById("checkall-rechargeSub").checked = false;
    }

    chooseMoneyNap($("#moneyRecharge").val());
}
function checkAllRechargeSubs(el) {
    $(".checkbox-rechargeSub").each(function() {
        this.checked = el.checked;
    });
    chooseMoneyNap($("#moneyRecharge").val());
}

function chooseMoneyNap(money) {
    if(money == null || money == undefined || money == ""){
        money = 0;
    }
    listRechargeSubs = [];
    $(".checkbox-rechargeSub").each(function() {
        if(this.checked){
            listRechargeSubs.push(this.value);
        }
    });
    console.log(listRechargeSubs);
    $("#moneyRecharge").val(money);
    $("#moneyRechargeOneSub").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(money)));
    $("#countRechargeSub").html(listRechargeSubs.length);
    $("#totalRecharge").html(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(money)*listRechargeSubs.length));

    if(listRechargeSubs.length > 0){
        if(parseInt(money) < 5000 || parseInt(money) > 2000000 || parseInt(money) % 5000 != 0){
            $("#buttonRecharge" ).prop( "disabled", true );
            showNotification('danger',Messages("Số tiền nạp phải lớn hơn 5.000 VNĐ, nhỏ hơn 2.000.000 VNĐ và là bội số của 5000"));
        } else {
            $("#buttonRecharge" ).prop( "disabled", false );
        }
    } else {
        $("#buttonRecharge" ).prop( "disabled", true );
    }
}
function inputMoneyRechargeSubs(el) {
    console.log(el.value);
    // if(el.value < 5000 || el.value > 2000000 || el.value % 5000 != 0){
    //     $("#buttonRecharge" ).prop( "disabled", true );
    //     showNotification('danger',Messages("Số tiền nạp phải lớn hơn 5.000 VNĐ, nhỏ hơn 2.000.000 VNĐ và là bội số của 5000"));
    //     return;
    // } else {
    //     $("#buttonRecharge" ).prop( "disabled", false );
    // }
    chooseMoneyNap(el.value)
}