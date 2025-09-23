/**
 * Created by vtk-anhlt166 on 4/6/23.
 */
/**
 * Created by vtk-anhlt166 on 3/20/23.
 */
$(document).ready(function () {
    getListUserTenant();
});
function onlickButtonSearch() {
    $("#page").val(1);
    getListUserTenant();
}

function getListUserTenant() {
    var body = new FormData();
    body.name = $("#nameSearch").val().trim();
    body.phone = $("#phoneSearch").val().trim();

    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.getListUserTenant();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewDataToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                $("#listDatasTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listDatasTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var listPermission = new Array;
function viewDataToTable(data, startAt, page, pageSize) {
    var body = "";
    listPermission = [];
    var listData = data.tenant;
    if (listData != null && listData.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listData.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listData[i].email + "</td>";
            body += "<td class='wrap-text'>" + listData[i].name + "</td>";
            body += "<td class='wrap-text'>" + listData[i].phone + "</td>";
            body += "<td class='wrap-text'>" + listData[i].system_role + "</td>";
            body += "<td align='center' style='padding: 0px;'>";
            body += "<a class='btn' onclick='setInfoUserTenant(\""+listData[i].id+"\", \""+listData[i].email+"\", \""+listData[i].name+"\", \""+listData[i].phone+"\")' data-bs-toggle='modal' data-bs-target='#editModal'><i class='bx bx-cog'></i></a>";
            body += "<a class='btn' onclick='setDelUserTenant(\""+listData[i].id+"\", \""+listData[i].email+"\")' data-bs-toggle='modal' data-bs-target='#delModal'><i class='bx bx-trash'></i></a>";
            body += "</td>";
            body += "</tr>";

            listPermission[listData[i].id] = listData[i].permissions;
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listDatasTable").find('tbody').html(body);

    pagingTable(data.total, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    // console.log("total : " + total);
    // console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListUserTenant();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListUserTenant();
}

function showDataRespone(id) {
    // console.log(listRespon[id]);
    var element = $("#contentResponsive");
    var obj = JSON.parse(listRespon[id]);
    console.log(obj);
    element.html(JSON.stringify(obj, undefined, 2));

    $("#responsiveModal").modal('show');
}

function resetFormSearch() {
    $("#nameSearch").val("");
    $("#phoneSearch").val("");
}

//them moi
function createUserTenant() {
    var body = new FormData();
    body.name = $("#name").val().trim();
    body.phone = $("#phone").val().trim();
    body.email = $("#email").val().trim();
    body.password = $("#password").val().trim();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.createUserTenant();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', "Tạo thành công");
                $("#addModal").modal('hide');
                getListUserTenant();
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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

function setDelUserTenant(id, email) {
    $("#idDel").val(id);
    $("#nameDel").html("Bạn có chắc chắn muốn xoá user " + email);
}
function processDeleteUser() {
    var body = new FormData();
    body.id = $("#idDel").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.delUserTenant();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', "Xoá thành công");
                $("#delModal").modal('hide');
                getListUserTenant();
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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

function setInfoUserTenant(id, email, name, phone) {
    $("#idEdit").val(id);
    $("#userIdPerAdd").val(id);
    $("#emailEdit").val(email);
    $("#nameEdit").val(name);
    $("#phoneEdit").val(phone);

    console.log(listPermission[id]);
    $("#listPermissionUser").find('tbody').html("");
    if (listPermission[id] != null && listPermission[id].length > 0) {
        $("#notiNotDataPermission").html("");
        var listData = listPermission[id];
        var body = "";
        for (var i = 0; i < listData.length; i++) {
            body += "<tr>";
            body += "<th>"+(i+1)+"</th>";
            body += "<td class='wrap-text'>" + listData[i].project_id + "</td>";
            body += "<td class='wrap-text'>" + listData[i].role_id + "</td>";
            body += "<td align='center' style='padding: 0px;'>";
            body += "<a class='btn' onclick='setEditPermission(\""+id+"\", \""+listData[i].project_id+"\", \""+listData[i].role_id+"\")' data-bs-toggle='modal' data-bs-target='#updateRoleModal'><i class='bx bx-edit'></i></a>";
            body += "<a class='btn' onclick='setDelPermission(\""+id+"\", \""+listData[i].project_id+"\")' data-bs-toggle='modal' data-bs-target='#delRoleModal'><i class='bx bx-trash'></i></a>";
            body += "</td>";
            body += "</tr>";
        }
        $("#listPermissionUser").find('tbody').html(body);
    } else {
        $("#notiNotDataPermission").html("Không có thông tin để hiển thị");
    }
}
function processEditUser() {
    var body = new FormData();
    body.id = $("#idEdit").val();
    body.email = $("#emailEdit").val();
    body.name = $("#nameEdit").val();
    body.phone = $("#phoneEdit").val();
    body.password = $("#passwordEdit").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.editUserTenant();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', "Cập nhật thành công");

            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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

function setEditPermission(id, projectId, roleId) {
    console.log(projectId, roleId);
    $("#editModal").modal('hide');
    $("#userIdPer").val(id);
    $("#projectIdPer").val(projectId);

    var body = new FormData();
    body.projectId = projectId;

    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.getListRoleOfOrg();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                var listRole = "<option value=''>"+Messages("---Chọn role---")+"</option>";
                if(datas.content.roleList != null && datas.content.roleList.roles != null && datas.content.roleList.roles.length > 0){
                    for(var i=0; i<datas.content.roleList.roles.length; i++){
                        listRole += "<option value='"+datas.content.roleList.roles[i].id+"'>"+datas.content.roleList.roles[i].name+"</option>";
                    }
                }
                $("#roleIdListPer").html(listRole);

                setTimeout(function () {
                    $("#roleIdListPer").val(roleId);
                },300);
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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
function closeUpdateRoleModal() {
    $("#updateRoleModal").modal('hide');
    $("#editModal").modal('show');
}
function processUpdateRolePermision() {
    var body = new FormData;
    body.tenant_id = $("#userIdPer").val();
    body.project_id = $("#projectIdPer").val();
    body.role_id = $("#roleIdListPer").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.updateRoleUserPermission();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', "Cập nhật thành công");
                $("#updateRoleModal").modal('hide');
                setTimeout(function () {
                    window.location.reload();
                },1500)
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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

//del role permision
function setDelPermission(id, projectId) {
    $("#editModal").modal('hide');
    $("#userIdPerDel").val(id);
    $("#projectIdPerDel").val(projectId);
}
function closeDelRoleModal() {
    $("#delRoleModal").modal('hide');
    $("#editModal").modal('show');
}
function processDelRolePermision() {
    var body = new FormData;
    body.tenant_id = $("#userIdPerDel").val();
    body.project_id = $("#projectIdPerDel").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.delRoleUserPermission();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', "Xoá thành công");
                $("#delRoleModal").modal('hide');
                setTimeout(function () {
                    window.location.reload();
                },1500)
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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

//add role permis
function setAddPermission() {
    $("#editModal").modal('hide');
    $("#addRoleModal").modal('show');

    var r = jsRoutes.controllers.ProjectController.getProject();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                var listProject = "<option value=''>"+Messages("---Chọn project---")+"</option>";
                if(datas.content.projects != null && datas.content.projects.length > 0){
                    for(var i=0; i<datas.content.projects.length; i++){
                        listProject += "<option value='"+datas.content.projects[i].id+"'>"+datas.content.projects[i].name+"</option>";
                    }
                }
                $("#projectIdPerAdd").html(listProject);
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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
function closeAddRoleModal() {
    $("#editModal").modal('show');
    $("#addRoleModal").modal('hide');
}
function processAddRolePermision() {
    if($("#projectIdPerAdd").val().length == 0){
        showNotification('danger',"Bạn chưa chọn dự án");
        return;
    }
    if($("#roleIdListPerAdd").val().length == 0){
        showNotification('danger',"Bạn chưa chọn quyền");
        return;
    }

    var body = new FormData;
    body.tenant_id = $("#userIdPerAdd").val();
    body.project_id = $("#projectIdPerAdd").val();
    body.role_id = $("#roleIdListPerAdd").val();

    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.updateRoleUserPermission();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', "Cập nhật thành công");
                $("#addRoleModal").modal('hide');
                setTimeout(function () {
                    window.location.reload();
                },1500)
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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
function chooseProjectGetListRole() {
    if($("#projectIdPerAdd").val().length == 0){
        showNotification('danger',"Bạn chưa chọn dự án");
        return;
    }

    var body = new FormData();
    body.projectId = $("#projectIdPerAdd").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.UserTenantListController.getListRoleOfOrg();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                var listRole = "<option value=''>"+Messages("---Chọn role---")+"</option>";
                if(datas.content.roleList != null && datas.content.roleList.roles != null && datas.content.roleList.roles.length > 0){
                    for(var i=0; i<datas.content.roleList.roles.length; i++){
                        listRole += "<option value='"+datas.content.roleList.roles[i].id+"'>"+datas.content.roleList.roles[i].name+"</option>";
                    }
                }
                $("#roleIdListPerAdd").html(listRole);
            } else {
                if(datas.content.message != null){
                    showNotification('danger', datas.content.message);
                } else {
                    showNotification('danger',datas.errorString);
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