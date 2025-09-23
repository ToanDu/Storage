/**
 * Created by vtk-anhlt166 on 3/10/23.
 */
function downloadTemplate() {
    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", "tableTemplateAdd");
    document.body.appendChild(table);
    var tablethread=document.createElement("thead");
    var tablethreadtr=document.createElement("tr");

    var th0=document.createElement("th");
    var t0 = document.createTextNode(Messages("STT"));
    th0.appendChild(t0);
    tablethreadtr.appendChild(th0);

    var th1=document.createElement("th");
    var t1 = document.createTextNode(Messages("Tên doanh nghiệp"));
    th1.appendChild(t1);
    tablethreadtr.appendChild(th1);

    var th4=document.createElement("th");
    var t4 = document.createTextNode(Messages("Số GPKD"));
    th4.appendChild(t4);
    tablethreadtr.appendChild(th4);

    tablethread.appendChild(tablethreadtr);
    table.appendChild(tablethread);

    var tablebody = document.createElement("tbody");

    table.appendChild(tablebody);

    var tableEx = $('#tableTemplateAdd');
    var table2excel = new Table2Excel({defaultFileName: "Template_Add_Enterprise", tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableEx);
    tableEx.remove();
}

var dataImportEnterpriseAdd;
var listGpkd;
function uploadListEnterprise(evt) {
    dataImportEnterpriseAdd = [];
    listGpkd=[];
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
        $("#nameFilesAddEnterprise").val(file.name);

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
            var dataImport = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            console.log(dataImport);
            if(dataImport.length > 1){
                dataImportEnterpriseAdd = [];

                var mtml = "";
                mtml += "<table id='' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
                    "<thead>" +
                    "<th>"+Messages("STT")+"</th>" +
                    "<th>"+Messages("Tên doanh nghiệp")+"</th>" +
                    "<th>"+Messages("Số GPKD")+"</th>" +
                    "<th>"+Messages("Kiểm tra")+"</th>" +
                    "<th>"+Messages("Kết quả")+"</th>" +
                    "</thead>" +
                    "<tbody>";
                var checkListGpkd = [];
                for(var i=1; i<dataImport.length; i++){
                    if(dataImport[i].length > 2 && dataImport[i][1] != undefined && dataImport[i][2] != undefined ){
                        var nameDN = dataImport[i][1].trim();
                        var gpkd = dataImport[i][2].trim();
                        listGpkd.push({"name": nameDN,"business_license":gpkd})
                        if(validateTextEmpty(nameDN) && validateTextEmpty(gpkd) ){
                            if(!checkListGpkd.includes(gpkd)){
                                var index = dataImportEnterpriseAdd.length;
                                mtml += "<tr>";
                                mtml += "<td>" +i+ "</td>";
                                mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                mtml += "<td>" + gpkd + "</td>";
                                mtml += "<td id='checkValid-"+gpkd.replaceAll("/","")+"'></td>";
                                mtml += "<td id='result_"+gpkd.replaceAll("/","")+"'></td>";
                                mtml += "</tr>";

                                dataImportEnterpriseAdd.push({
                                    "name": nameDN,
                                    "gpkd": gpkd
                                });
                                checkListGpkd.push(gpkd);
                            } else {
                                mtml += "<tr>";
                                mtml += "<td>" +i+ "</td>";
                                mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                mtml += "<td>" + gpkd + "</td>";
                                mtml += "<td>" + Messages("Bị trùng lặp") + "</td>";
                                mtml += "<td></td>";
                                mtml += "</tr>";
                            }
                        } else {
                            mtml += "<tr>";
                            mtml += "<td>" +i+ "</td>";
                            mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                            mtml += "<td>" + gpkd + "</td>";
                            mtml += "<td>" + Messages("Không hợp lệ") + "</td>";
                            mtml += "<td></td>";
                            mtml += "</tr>";
                        }
                    }
                    else{
                        if( dataImport[i][1] == undefined ){
                             nameDN = "";
                             gpkd = dataImport[i][2].trim();
                            listGpkd.push({"name": nameDN,"business_license":gpkd})
                            mtml += "<tr>";
                            mtml += "<td>" +i+ "</td>";
                            mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                            mtml += "<td>" + gpkd + "</td>";
                            mtml += "<td>" + Messages("Không hợp lệ") + "</td>";
                            mtml += "<td></td>";
                            mtml += "</tr>";
                        }
                        else{
                            if( dataImport[i][2] == undefined ){
                                nameDN = dataImport[i][1].trim();
                                gpkd = "";
                                listGpkd.push({"name": nameDN,"business_license":gpkd})
                                mtml += "<tr>";
                                mtml += "<td>" +i+ "</td>";
                                mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                mtml += "<td>" + gpkd + "</td>";
                                mtml += "<td>" + Messages("Không hợp lệ") + "</td>";
                                mtml += "<td></td>";
                                mtml += "</tr>";
                            }
                            else{
                                if(dataImport[i][2] == undefined && dataImport[i][1] == undefined  ){
                                    nameDN = "";
                                    gpkd = "";
                                    listGpkd.push({"name": nameDN,"business_license":gpkd})
                                    mtml += "<tr>";
                                    mtml += "<td>" +i+ "</td>";
                                    mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                    mtml += "<td>" + gpkd + "</td>";
                                    mtml += "<td>" + Messages("Không hợp lệ") + "</td>";
                                    mtml += "<td></td>";
                                    mtml += "</tr>";
                                }
                            }
                        }
                    }
                }
                mtml += "</tbody></table>";
                console.log(listGpkd);

                if(dataImportEnterpriseAdd.length > 0){
                    $("#tableAddEnterprise").html(mtml);
                    checkValidGpkdListImport(0);
                } else {
                    showNotification('danger',Messages("Không có dữ liệu hợp lệ"));
                }
            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
                return;
            }
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
        document.getElementById("filesAddEnterprise").value = "";
    }
}

var listImportEnterpriseAddTrue = new Array;
function checkValidGpkdExist(){
    var body = new FormData();
    body.data= listGpkd;
    //var idNo = dataImportEnterpriseAdd[index].gpkd;
    console.log(body);
    StartProcess();
    listImportEnterpriseAddTrue =[];
    var r = jsRoutes.controllers.TelcoRoleAccountController.checkValidateGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null )
            {
                datas.content.data.forEach(function (item,index) {
                    console.log(item);
                    if (item.code == 0) {
                        $("#checkValid-" + item.business_license.replaceAll("/", "")).html(Messages("Hợp lệ"));
                        listImportEnterpriseAddTrue.push(dataImportEnterpriseAdd[index]);
                        console.log("hop le");
                    } else if(item.code==2027){
                        $("#checkValid-" + item.business_license.replaceAll("/", "")).html(Messages("GPKD không thuộc quyền quản lí"));
                    }else{
                        $("#checkValid-" + item.business_license.replaceAll("/", "")).html(Messages("GPKD không thuộc quyền quản lí"));
                    }
                });
            }
        },
        error: function (xhr) {
            console.log(xhr);
            // showNotification('danger',Messages("connection.failed"));
            listGpkd.forEach(function(item){
                $("#checkValid-"+item.business_license.replaceAll("/","")).html(Messages("GPKD không tồn tại trong hệ thống"));
            })
        },
        complete: function (){
            FinishProcess();
        }
    })
}
function checkValidGpkdListImport(index) {
    var body = new FormData();
    body.idNo = dataImportEnterpriseAdd[index].gpkd;
    console.log(body);

    if(index == 0){
        StartProcess();
        listImportEnterpriseAddTrue =[];
    }
    var r = jsRoutes.controllers.TelcoRoleAccountController.validateGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                $("#checkValid-"+body.idNo.replaceAll("/","")).html(Messages("Hợp lệ"));
                listImportEnterpriseAddTrue.push(dataImportEnterpriseAdd[index]);
            } else {
                $("#checkValid-"+body.idNo.replaceAll("/","")).html(Messages("GPKD không tồn tại trong hệ thống"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            // showNotification('danger',Messages("connection.failed"));
            $("#checkValid-"+body.idNo.replaceAll("/","")).html(Messages("GPKD không tồn tại trong hệ thống"));
        },
        complete: function (){
            if(index < dataImportEnterpriseAdd.length-1){
                checkValidGpkdListImport(index+1);
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

function cancleImportAddEnterprise() {
    $("#importAddEnterpriseModal").modal('hide');
    $("#filesAddEnterprise").val("");

    dataImportEnterpriseAdd = [];
    listImportEnterpriseAddTrue = [];
    $("#tableAddEnterprise").html("");
}

function processImportAddEnterprise() {
    console.log(listImportEnterpriseAddTrue);
    if(listImportEnterpriseAddTrue.length > 0){
        processSubmitAddEnpByFile(0);
    } else {
        showNotification('danger', Messages("Không có doanh nghiệp hợp lệ"));
        return;
    }
}

function processSubmitAddEnpByFile(index) {
    var body = new FormData();
    body.name = listImportEnterpriseAddTrue[index].name;
    body.business_license = listImportEnterpriseAddTrue[index].gpkd;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.addEnterpriseByAdminOrSEnterprise();
    console.log(roleCmp);
    if(userCurrentId != userId){
        r = jsRoutes.controllers.TelcoRoleAccountController.addEnterpriseBySAdmin();

        body = new FormData();
        body.user_id = userId;
        var dataArr = [];
        dataArr.push({
            "name": listImportEnterpriseAddTrue[index].name,
            "business_license": listImportEnterpriseAddTrue[index].gpkd
        });
        body.data = dataArr;
    }
    console.log(body);
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(userCurrentId != userId){
                    if(datas.content.data != null){
                        var respon = datas.content.data;
                        if(respon.length > 0 && respon[0].code == 0){
                            $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Thành công"));
                        } else {
                            if(respon.length > 0 && respon[0].code == 2021){
                                $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Số GPKD đã tồn tại"));
                            } else {
                                $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Không thành công"));
                            }
                        }
                    } else {
                        $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Không thành công"));
                    }
                } else {
                    var respon = datas.content;
                    if(respon.code == 0){
                        $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Thành công"));
                    } else {
                        if(respon.code == 2021){
                            $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Số GPKD đã tồn tại"));
                        } else {
                            $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Không thành công"));
                        }
                    }
                }
            } else {
                $("#result_"+listImportEnterpriseAddTrue[index].gpkd.replaceAll("/","")).html(Messages("Không thành công"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(index < listImportEnterpriseAddTrue.length-1){
                processSubmitAddEnpByFile(index+1);
            } else {
                // $("#importAddEnterpriseModal").modal('hide');
                FinishProcess();
                getInfoAccountCmp();
            }
        }
    })
}

function setImportEnterprise() {
    $("#nameFilesAddEnterprise").val("");
    document.getElementById("filesAddEnterprise").value = '';
}