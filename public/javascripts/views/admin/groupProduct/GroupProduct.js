/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
$(document).ready(function () {
    getListGroupProduct();
});
function getListGroupProduct() {
    StartProcess();
    var r = jsRoutes.controllers.AdminGroupProductController.getListGroupProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            var mtmlBody = "<table id='listGroupProductTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%;'>" +
                "<thead >" +
                "<th>"+Messages("STT")+"</th>" +
                "<th>"+Messages("Mã nhóm ")+"</th>" +
                "<th>"+Messages("Tên nhóm ")+"</th>" +
                "<th>"+Messages("Phân loại")+"</th>" +
                "<th>"+Messages("Trạng thái")+"</th>" +
                "<th>"+Messages("Ngày tạo")+"</th>" +
                "<th>"+Messages("Thao tác ")+"</th>" +
                "</thead>" +
                "<tbody>";
            if(data.success){
                if(data.content.length > 0){
                    for (var i = 0; i < data.content.length; i++) {
                        var type = "";
                        if(data.content[i].type == 0){
                            type ="Thiết bị"
                        } else if(data.content[i].type == 1){
                            type ="Giải pháp"
                        }
                        mtmlBody += "<tr>";
                        mtmlBody += "<td></td>";
                        mtmlBody += "<td>" + data.content[i].code + "</td>";
                        mtmlBody += "<td>" + data.content[i].name + "</td>";
                        mtmlBody += "<td>" + type + "</td>";
                        mtmlBody += "<td>" + (data.content[i].status ? "Hiện" : "Ẩn") + "</td>";
                        mtmlBody += "<td>" + moment.unix(data.content[i].logDate/1000).format("YYYY/MM/DD HH:mm") + "</td>";
                        mtmlBody += "<td>" ;
                        mtmlBody += '<button class="btn btn-light" onclick="setEditGroupProduct(\''+data.content[i].id+'\', \''+data.content[i].code+'\', \''+data.content[i].name+'\', \''+data.content[i].type+'\', \''+data.content[i].status+'\')" style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#editConfirmModal"><i class="bx bx-edit"></i></button>';
                        mtmlBody += '<button class="btn btn-light" onclick="setDelGroupProduct(\''+data.content[i].id+'\')" style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#delConfirmModal"><i class="bx bx-trash"></i></button>';
                        mtmlBody += "</td>";
                        mtmlBody += "</tr>";
                    }
                }
            } else{
                showNotification('danger',data.errorString);
            }
            mtmlBody += "</tbody></table>";
            $("#listGroupProductDiv").html(mtmlBody);

            var table = $("#listGroupProductTable").DataTable({
                responsive: true,
                order: [[ 5, "desc" ]],
                lengthMenu: [
                    [ 15, 50, -1],
                    ['15', '50', 'Tất cả']
                ],
                "columnDefs": [ {
                    "targets": 0,
                    "orderable": false
                } ],
                searching: true,
                "bLengthChange" : true,
                "bInfo":true
            });
            table.on('order.dt search.dt', function () {
                table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                    cell.innerHTML = i+1;
                } );
            } ).draw();
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function processAddGroupProduct() {
    var body = {
        "code": $("#codeGroupProductAdd").val(),
        "name": $("#nameGroupProductAdd").val(),
        "type": $("#typeGroupProductAdd").val(),
        "status": $("#statusGroupProductAdd").val()
    };
    StartProcess();
    var r = jsRoutes.controllers.AdminGroupProductController.addGroupProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                getListGroupProduct();
                showNotification('success',data.resultString);
            } else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}


//delete
function setDelGroupProduct(id) {
    $("#idDelete").val(id);
}
function postDeleteGroupProduct() {
    var body = {
        "id": $("#idDelete").val()
    };
    StartProcess();
    var r = jsRoutes.controllers.AdminGroupProductController.deleteGroupProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getListGroupProduct();
                showNotification('success',data.resultString);
            } else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

//edit
function setEditGroupProduct(id, code, name, type, status) {
    $("#idGroupProductEdit").val(id);
    $("#codeGroupProductEdit").val(code);
    $("#nameGroupProductEdit").val(name);
    $("#typeGroupProductEdit").val(type);
    $("#statusGroupProductEdit").val(status);
}
function processEditGroupProduct() {
    var body = {
        "id": $("#idGroupProductEdit").val(),
        "code": $("#codeGroupProductEdit").val(),
        "name": $("#nameGroupProductEdit").val(),
        "type": $("#typeGroupProductEdit").val(),
        "status": $("#statusGroupProductEdit").val()
    };
    StartProcess();
    var r = jsRoutes.controllers.AdminGroupProductController.editGroupProduct();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                getListGroupProduct();
                showNotification('success',data.resultString);
            } else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}