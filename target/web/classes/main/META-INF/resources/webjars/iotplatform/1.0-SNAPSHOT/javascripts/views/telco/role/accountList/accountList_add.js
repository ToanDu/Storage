/**
 * Created by vtk-anhlt166 on 3/2/23.
 */
function addAccount() {
    listEnterpriseSubmit = [];
    listImportEnterpriseAddTrue = [];
    var mtnl =
        "<table id='tableEnterpriseSubmit' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("STT")+"</th>" +
        "<th>"+Messages("Tên doanh nghiệp")+"</th>" +
        "<th>"+Messages("Số GPKD")+"</th>" +
        "<th>"+Messages("Thao tác")+"</th>" +
        "</thead>" +
        "<tbody>" +
        "</tbody>" +
        "</table>";
    $("#divEnterpriseSubmit").html(mtnl);

    var table = $('#tableEnterpriseSubmit').DataTable( {
        lengthChange: false,
        "info": true,
        bSort: false,
        "order": false,
        "paging" : true,
        searching: true
    });

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

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

    // var th2=document.createElement("th");
    // var t2 = document.createTextNode(Messages("Mã số thuế"));
    // th2.appendChild(t2);
    // tablethreadtr.appendChild(th2);

    var th4=document.createElement("th");
    var t4 = document.createTextNode(Messages("Số GPKD"));
    th4.appendChild(t4);
    tablethreadtr.appendChild(th4);

    // var th5=document.createElement("th");
    // var t5 = document.createTextNode(Messages("Ngày thành lập"));
    // th5.appendChild(t5);
    // tablethreadtr.appendChild(th5);

    // var th6=document.createElement("th");
    // var t6 = document.createTextNode(Messages("SDT doanh nghiệp"));
    // th6.appendChild(t6);
    // tablethreadtr.appendChild(th6);

    // var th7=document.createElement("th");
    // var t7 = document.createTextNode(Messages("Địa chỉ"));
    // th7.appendChild(t7);
    // tablethreadtr.appendChild(th7);

    tablethread.appendChild(tablethreadtr);
    table.appendChild(tablethread);

    var tablebody = document.createElement("tbody");

    table.appendChild(tablebody);

    var tableEx = $('#tableTemplateAdd');
    var table2excel = new Table2Excel({defaultFileName: "Export_Template", tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableEx);
    tableEx.remove();
}

function importFileListEnterprise() {
    $("#addAccountModal").modal('hide');
    $("#importAddEnterpriseModal").modal('show');

    dataImportEnterpriseAdd = [];
    listImportEnterpriseAddTrue = [];
    $("#filesAddEnterprise").val("");
    $("#tableAddEnterprise").html("");
    $("#nameFilesAddEnterprise").val("")
}

function cancleImportAddEnterprise() {
    listImportEnterpriseAddTrue = [];
    $("#importAddEnterpriseModal").modal('hide');
    $("#filesAddEnterprise").val("");

    $("#addAccountModal").modal('show');
}

var dataImportEnterpriseAdd=[];
var listGpkd;
function uploadListEnterprise(evt) {

    listGpkd = []
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
                var mtml = "";
                mtml += "<table id='checkedEnterpriseTable' class='table align-middle mb-0 mt-3 table-responsive table-striped' style='width: 100%'>" +
                    "<thead>" +
                    "<th>"+Messages("STT")+"</th>" +
                    "<th>"+Messages("Tên doanh nghiệp")+"</th>" +
                    "<th>"+Messages("Số GPKD")+"</th>" +
                    "<th>"+Messages("Kiểm tra")+"</th>" +
                    "</thead>" +
                    "<tbody>";
                var checkListGpkd = [];
                for(var i=1; i<dataImport.length; i++){
                    console.log(dataImport[i]);
                    if(dataImport[i].length > 2 ){
                        if(dataImport[i][1]!=null){
                            var nameDN = dataImport[i][1].trim();
                        }
                        else {
                            var nameDN = "";
                        }
                        if( dataImport[i][2]!=null){
                            var gpkd = dataImport[i][2].trim();
                        }
                        else{
                            var gpkd="";
                        }
                        listGpkd.push({"name": nameDN,"business_license":gpkd})
                        if(validateTextEmpty(nameDN) && validateTextEmpty(gpkd)){
                            if(checkImportWithTableEnterprise(gpkd)){
                                if(!checkListGpkd.includes(gpkd)){
                                    mtml += "<tr>";
                                    mtml += "<td>" +i+ "</td>";
                                    mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                    mtml += "<td>" + gpkd + "</td>";
                                    mtml += "<td id='checkValid-"+gpkd.replaceAll("/","")+"'></td>";
                                    mtml += "</tr>";

                                    dataImportEnterpriseAdd.push(dataImport[i]);
                                    checkListGpkd.push(gpkd);
                                } else {
                                    mtml += "<tr>";
                                    mtml += "<td>" +i+ "</td>";
                                    mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                    mtml += "<td>" + gpkd + "</td>";
                                    mtml += "<td>" + Messages("Bị trùng lặp") + "</td>";
                                    mtml += "</tr>";
                                }
                            } else {
                                mtml += "<tr>";
                                mtml += "<td>" +i+ "</td>";
                                mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                                mtml += "<td>" + gpkd + "</td>";
                                mtml += "<td>" + Messages("Bị trùng lặp") + "</td>";
                                mtml += "</tr>";
                            }
                        }
                        else {
                            mtml += "<tr>";
                            mtml += "<td>" +i+ "</td>";
                            mtml += "<td class='td-wrapword'>" + nameDN + "</td>";
                            mtml += "<td>" + gpkd + "</td>";
                            mtml += "<td>" + Messages("Không hợp lệ") + "</td>";
                            mtml += "</tr>";
                        }
                    } else {
                        showNotification('danger', "Không hợp lệ");
                        return;
                    }
                }
                mtml += "</tbody></table>";
                if(dataImport.length > 0){
                    $("#tableAddEnterprise").html(mtml);
                    //checkValidGpkdListImport(0);
                    checkValidGpkdExist();
                } else {
                    showNotification('danger',Messages("Không có dữ liệu hợp lệ"));
                    return;
                }

                var checkedTable = $("#checkedEnterpriseTable").DataTable({
                    lengthChange: false,
                    "info": true,
                    bSort: false,
                    "order": false,
                    "paging" : true,
                    searching: false
                });

                checkedTable.on("page.dt", function() {
                    setTimeout(function() {
                        var info = checkedTable.page.info();
                        var currentPage = info.page + 1; // Trang hiện tại
                        var rowsPerPage = info.length; // Số hàng trên mỗi trang
                        var totalRows = info.recordsDisplay; // Tổng số hàng hiển thị
                        var startRow = info.start; // Chỉ số bắt đầu của hàng trong trang hiện tại

                        var rowsInCurrentPage = Math.min(rowsPerPage, totalRows - startRow);
                        for (var i = startRow; i < startRow + rowsInCurrentPage; i++) {
                            if (checkedList[i].code == 0) {
                                $("#checkValid-" + checkedList[i].business_license.replaceAll("/", "")).html(Messages("Hợp lệ"));
                            } else if(checkedList[i].code == 2027){
                                $("#checkValid-" + checkedList[i].business_license.replaceAll("/", "")).html(Messages("GPKD không thuộc quyền quản lí"));
                            }else{
                                $("#checkValid-" + checkedList[i].business_license.replaceAll("/", "")).html(Messages("GPKD không thuộc quyền quản lí"));
                            }
                        }
                    }, 20)
                })
                // console.log(dataImportEnterpriseAdd);
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
var checkedList = []
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
            var listGpkdExist = [];
            if(datas.content != null )
            {
                checkedList = datas.content.data
                datas.content.data.forEach(function (item,index) {
                    if (item.code == 0) {
                        $("#checkValid-" + item.business_license.replaceAll("/", "")).html(Messages("Hợp lệ"));
                        if(!listGpkdExist.includes(item.business_license)){
                            listGpkdExist.push(item.business_license);
                            for(var i=0; i< dataImportEnterpriseAdd.length; i++){
                                if(dataImportEnterpriseAdd[i][2]=== item.business_license){
                                    listImportEnterpriseAddTrue.push(dataImportEnterpriseAdd[i]);
                                }
                            }
                        }
                    } else if(item.code == 2027){
                        $("#checkValid-" + item.business_license.replaceAll("/", "")).html(Messages("GPKD không thuộc quyền quản lí"));
                    }else{
                        $("#checkValid-" + item.business_license.replaceAll("/", "")).html(Messages("GPKD không thuộc quyền quản lí"));
                    }
                });
            }
            console.log(listImportEnterpriseAddTrue);
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
    body.idNo = dataImportEnterpriseAdd[index][2];
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
                console.log(dataImportEnterpriseAdd);
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

function checkImportWithTableEnterprise(value) {
    var check = true;
    var table = $('#tableEnterpriseSubmit').DataTable();
    var data = table.rows().data().toArray();
    if(data.length > 0){
        for(var i = 0; i < data.length; i++) {
            var cell_value = data[i][2];
            if(cell_value == value){
                check = false;
                break;
            }
        }
    }

    return check;
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

var countEnterpriseAdd = 0;
var listEnterpriseSubmit = new Array;
function comfirmImportAddEnterprise() {
    console.log(listEnterpriseSubmit);
    $("#addAccountModal").modal('show');
    $("#importAddEnterpriseModal").modal('hide');
    $("#filesAddEnterprise").val("");

    if(listImportEnterpriseAddTrue.length > 0){
        console.log(listImportEnterpriseAddTrue);
        for(var i=0 ; i<listImportEnterpriseAddTrue.length; i++){
            var table = $('#tableEnterpriseSubmit').DataTable();
            var dataRow = table.rows().data().toArray();
            var remove = "<i class='bx bx-trash cursor-pointer' onclick='removeGpkdEnterprise(\""+listImportEnterpriseAddTrue[i][2]+"\", this)' style='font-size: 16px;'></i>";
            $('#tableEnterpriseSubmit').DataTable().row.add([
                dataRow.length, listImportEnterpriseAddTrue[i][1], listImportEnterpriseAddTrue[i][2], remove
            ]).draw();

            listEnterpriseSubmit.push({
                "name": listImportEnterpriseAddTrue[i][1],
                "business_license": listImportEnterpriseAddTrue[i][2]
            });
            countEnterpriseAdd++;
        }
    } else {
        showNotification('danger',Messages("Không có dữ liệu hợp lệ"));
        cancleImportAddEnterprise();
    }
}

function showAddInfoEnterprise() {
    $("#infoEnterpriseModal").modal('show');
    $("#addAccountModal").modal('hide');

    $("#nameEnterprise").val("");
    // $("#mstEnterprise").val("");
    $("#gpkdEnterprise").val("");
    // $("#dateEnterprise").val("");
    // $("#phoneEnterprise").val("");
    // $("#addressEnterprise").val("");
}

function hideAddInfoEnterprise() {
    $("#infoEnterpriseModal").modal('hide');
    $("#addAccountModal").modal('show');
}

function comfirmAddInfoEnterprise() {
    if(!validateTextEmpty($('#nameEnterprise').val().trim())){
        showNotification('danger', Messages("Tên doanh nghiệp không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#gpkdEnterprise').val().trim())){
        showNotification('danger', Messages("GPKD không được bỏ trống"));
        return;
    }

    var nameEnterprise = $('#nameEnterprise').val().trim();
    var gpkdEnterprise = $('#gpkdEnterprise').val().trim();
    if(checkImportWithTableEnterprise(gpkdEnterprise)){
        var idNos=[];
        var body = new FormData();
       // body.idNo = gpkdEnterprise;
        body.data= [{
            "name": nameEnterprise,
            "business_license": gpkdEnterprise
        }];
        console.log(body);
        StartProcess();
        var r = jsRoutes.controllers.TelcoRoleAccountController.checkValidateGpkd();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function(datas){
                console.log(datas);
                if(datas.content != null ){
                    if( datas.content.data[0].code == 0){
                    var table = $('#tableEnterpriseSubmit').DataTable();
                    var dataRow = table.rows().data().toArray();
                    var remove = "<i class='bx bx-trash cursor-pointer' onclick='removeGpkdEnterprise(\""+gpkdEnterprise+"\", this)' style='font-size: 16px;'></i>";
                    $('#tableEnterpriseSubmit').DataTable().row.add([
                        dataRow.length, nameEnterprise, gpkdEnterprise, remove
                    ]).draw();

                    listEnterpriseSubmit.push({
                        "name": nameEnterprise,
                        "business_license": gpkdEnterprise
                    });
                    countEnterpriseAdd++;

                    $("#infoEnterpriseModal").modal('hide');
                    $("#addAccountModal").modal('show');
                    }
                    else{
                        if( datas.content.data[0].code == 2027){
                            showNotification('danger',Messages("GPKD không thuộc quyền quản lí"));
                        }else{
                            showNotification('danger',Messages("GPKD không thuộc quyền quản lí"));
                        }
                    }
                } else {
                    showNotification('danger',Messages("GPKD không tồn tại trong hệ thống"));
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("GPKD không tồn tại trong hệ thống"));
            },
            complete: function (){
                FinishProcess();
            }
        });
    } else {
        showNotification('danger',Messages("Trùng dữ liệu"));
    }
}

function removeGpkdEnterprise(gpkd, el) {
    // $("#gpkd_"+gpkd).remove();
    $('#tableEnterpriseSubmit').DataTable().row( $(el).parents('tr') )
        .remove()
        .draw();

    listEnterpriseSubmit = listEnterpriseSubmit.filter(item => item.business_license != gpkd);
    console.log(listEnterpriseSubmit);

    // var table = document.getElementById("tableEnterpriseSubmit");
    // for(var i = 1; i < table.rows.length; i++) {
    //     table.rows[i].cells[0].innerHTML = i;
    // }
}
function isValidPhoneNumber(input) {

    if (/^0|^84/.test(input) && input.length>=10) {
            return true;
    }
    return false;
}
function processSubmitAddAccount() {
    if(!validateTextEmpty($('#fullNameAdd').val().trim())){
        showNotification('danger', Messages("Họ tên không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#roleCmpAdd').val().trim())){
        showNotification('danger', Messages("Bạn chưa chọn quyền tài khoản"));
        return;
    }
    if(!validateEmail($('#emailAdd').val().trim())){
        showNotification('danger', Messages("Email không đúng định dạng"));
        return;
    }
    if(!validateTextEmpty($('#phoneAdd').val().trim())){
        showNotification('danger', Messages("Số điện thoại không được bỏ trống"));
        return;
    }
    if(!isValidPhoneNumber($('#phoneAdd').val().trim())){
        showNotification('danger', Messages("Số điện thoại không đúng định dạng"));
        return;
    }
    if(listEnterpriseSubmit.length == 0){
        showNotification('danger', Messages("Bạn chưa thêm doanh nghiệp"));
        return;
    }

    var body = new FormData();
    body.name = $('#fullNameAdd').val().trim();
    body.cmp_role = $('#roleCmpAdd').val();
    body.phone = $('#phoneAdd').val();
    body.email = $('#emailAdd').val().trim();
    body.listEnterprise = listEnterpriseSubmit;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.addAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                showNotification('success',Messages("noti.Addsuccess"));
                cancleSubmitAddAccount();
                $("#addAccountModal").modal('hide');
                getListAccount();
            } else {
                if(datas.content != null && datas.content.code == 2006){
                    showNotification('danger',Messages("Email đã được sử dụng"));

                } else if(datas.content != null && datas.content.code == 1006){
                    showNotification('danger',Messages("Số điện thoại đã được sử dụng"));

                } else {
                    if(datas.content != null && datas.content.data != null && datas.content.data.length > 0){
                        var ischeck = false;
                        for(var i=0; i<datas.content.data.length; i++){
                            if(datas.content.data[i].code == 0){
                                ischeck = true;
                                break;
                            }
                        }
                        if(!ischeck){
                            showNotification('danger',Messages("Bạn không có quyền tạo tài khoản có GPKD này"));
                        } else {
                            showNotification('success',Messages("noti.Addsuccess"));
                            cancleSubmitAddAccount();
                            $("#addAccountModal").modal('hide');
                            getListAccount();
                        }
                    } else {
                        showNotification('danger',Messages("noti.AddFalse"));
                    }
                }
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

function processSubmitAddAccountV2() {
    if(!validateTextEmpty($('#fullNameAdd').val().trim())){
        showNotification('danger', Messages("Họ tên không được bỏ trống"));
        return;
    }
    if(!validateTextEmpty($('#roleCmpAdd').val().trim())){
        showNotification('danger', Messages("Bạn chưa chọn quyền tài khoản"));
        return;
    }
    if(!validateEmail($('#emailAdd').val().trim())){
        showNotification('danger', Messages("Email không đúng định dạng"));
        return;
    }
    if(!validateTextEmpty($('#phoneAdd').val().trim())){
        showNotification('danger', Messages("Số điện thoại không được bỏ trống"));
        return;
    }
    if(!isValidPhoneNumber($('#phoneAdd').val().trim())){
        showNotification('danger', Messages("Số điện thoại không đúng định dạng"));
        return;
    }
    if(listEnterpriseSubmit.length == 0){
        showNotification('danger', Messages("Bạn chưa thêm doanh nghiệp"));
        return;
    }

    var body = new FormData();
    body.name = $('#fullNameAdd').val().trim();
    body.cmp_role = $('#roleCmpAdd').val();
    body.phone = $('#phoneAdd').val();
    body.email = $('#emailAdd').val().trim();
    body.listEnterprise = listEnterpriseSubmit;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.addAccountCmpV2();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                showNotification('success',Messages("noti.Addsuccess"));
                $("#addAccountModal").modal('hide');
                getListAccount();
            } else {
                if(datas.content != null && datas.content.code == 2006){
                    showNotification('danger',Messages("Email đã được sử dụng"));

                } else if(datas.content != null && datas.content.code == 1006){
                    showNotification('danger',Messages("Số điện thoại đã được sử dụng"));

                } else {
                    if(datas.content != null && datas.content.data != null && datas.content.data.length > 0){
                        var ischeck = false;
                        for(var i=0; i<datas.content.data.length; i++){
                            if(datas.content.data[i].code == 0){
                                ischeck = true;
                                break;
                            }
                        }
                        if(!ischeck){
                            showNotification('danger',Messages("Bạn không có quyền tạo tài khoản có GPKD này"));
                        } else {
                            showNotification('success',Messages("noti.Addsuccess"));
                            $("#addAccountModal").modal('hide');
                            getListAccount();
                        }
                    } else {
                        showNotification('danger',Messages("noti.AddFalse"));
                    }
                }
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


function cancleSubmitAddAccount() {
    listEnterpriseSubmit = [];
    $("#tableEnterpriseSubmit").find('tbody').html("");

    $('#fullNameAdd').val("");
    $('#roleCmpAdd').val("");
    $('#phoneAdd').val("");
    $('#emailAdd').val("");
}
