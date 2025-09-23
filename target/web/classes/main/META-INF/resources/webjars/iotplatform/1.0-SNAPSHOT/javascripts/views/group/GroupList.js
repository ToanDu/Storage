/**
 * Created by vtk-anhlt166 on 11/18/21.
 */
function viewGroupToTable(data) {
    $("#totalGroup").html(Messages("Tổng: ") + data.length + Messages(" nhóm"));
    $("#tabGroup").empty();

    var mtmlGroup = "<table id='smlGroupsTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th hidden>"+Messages("group.id")+"</th>" +
        "<th>"+Messages("group.name")+"</th>" +
        "<th>"+Messages("Loại")+"</th>" +
        "<th>"+Messages("Quyền")+"</th>" +
        "<th>"+Messages("User")+"</th>" +
        "<th></th>" +
        "</thead>" +
        "<tbody>";

    if (data != null && data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            mtmlGroup += "<tr id='tr_"+data[i].id+"'>";
            mtmlGroup += "<td></td>";
            mtmlGroup += "<td hidden><p id='group_"+data[i].id+"'>" + data[i].id + "</p></td>";
            mtmlGroup += "<td>" + data[i].name + "</td>";
            mtmlGroup += "<td>" + data[i].entity_type + "</td>";
            var roleId = "";
            var roleName = "";
            var userId = "";
            var userName = "";
            if(data[i].attributes != null && data[i].attributes.length > 0){
                console.log(data[i].attributes);
                data[i].attributes.forEach(function (item, ke) {
                    if(item.attribute_key == "_role_id"){
                        roleId = item.value;
                    }
                    if(item.attribute_key == "_role_name"){
                        roleName = item.value;
                    }
                    if(item.attribute_key == "_user_id"){
                        userId = item.value;
                    }
                    if(item.attribute_key == "_user_name"){
                        userName = item.value;
                    }
                })
            }
            mtmlGroup += "<td>" + roleName + "</td>";
            mtmlGroup += "<td>" + userName + "</td>";
            mtmlGroup += "<td align='center'>" ;
            mtmlGroup += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlGroup += '<ul class="dropdown-menu dropdown-table">';
            mtmlGroup += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="copyIdGroup(\''+data[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Copy ID")+'</a></li>';
            mtmlGroup += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageAttrGroup(\''+data[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnAttr")+'</a></li>';
            mtmlGroup += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditGroupInOrg(\''+data[i].id+'\', \''+data[i].name+'\', \''+data[i].entity_type+'\')"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnEdit")+'</a></li>';
            if(data[i].entity_type == "USER"){
                mtmlGroup += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditRoleGroupUser(\''+data[i].id+'\', \''+roleId+'\')"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Cập nhật quyền")+'</a></li>';
            }
            if(data[i].entity_type == "DEVICE"){
                mtmlGroup += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setAddUserToGroupDevice(\''+data[i].id+'\', \''+userId+'\')"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Gán user")+'</a></li>';
            }
            mtmlGroup += '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelGroupInOrg(\''+data[i].id+'\')"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>';
            mtmlGroup += '</ul>';
            mtmlGroup +="</td>";
            mtmlGroup += "</td>";
            mtmlGroup += "</tr>";
        }
    }
    mtmlGroup += "</tbody></table>";
    $("#tabGroup").html(mtmlGroup);

    var table = $('#smlGroupsTable').DataTable( {
        lengthChange: false,
        "info": false,
        // "columnDefs": [ {
        //     "targets": 3,
        //     "orderable": false
        // } ],
        bSort: false,
        "order": false,
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showPopupAddGroup' );
                    showPopupAddGroup();
                }
            }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlGroupsTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function copyIdGroup(id) {
    copyToClipboard("#group_"+id);
}

function remotePageAttrGroup(id) {
    window.location.href = jsRoutes.controllers.AttributeController.attributeGroup(projectId, id).url;
}

function showPopupAddGroup() {
    $("#addGroupModal").modal('show');
}

function postAddNewGroup() {
    var Data = new FormData();
    Data.name = $('#nameGroupNew').val();
    Data.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    Data.entity = $("#entityGroupAdd").val();
    Data.projectId = projectId;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.GroupListController.addNewGroups();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
                showNotification('danger',data.errorString, data.status);
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
function setEditGroupInOrg(id, name, type) {
    $("#editGroupModal").modal('show');
    $("#idGroupEdit").val(id);
    $("#nameGroupEdit").val(name);
    // $("#entityGroupEdit").val(type);

}
function postEditGroup() {
    var Data = new FormData();
    Data.id = $('#idGroupEdit').val();
    Data.name = $('#nameGroupEdit').val();
    Data.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.GroupListController.editNameGroups();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
                showNotification('danger',data.errorString, data.status);
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
function setDelGroupInOrg(id) {
    $("#deleteGroupconfirm").modal('show');
    $("#idGroupDelete").val(id);
}
function postDeleteGroup() {
    var Data = new FormData();
    Data.id = $('#idGroupDelete').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.GroupListController.deleteGroup();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
                showNotification('danger',data.errorString, data.status);
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

//sua quyen group user
function setEditRoleGroupUser(id, roleId) {
    console.log(id);
    $("#idRoleGroupUser").val(id);
    $("#editRoleGroupUserModal").modal('show');
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    console.log(groupData);
    var r = jsRoutes.controllers.GroupController.getListRoleOfOrg();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            var option = "";
            if(data.content.roleList != null){
                if(data.content.roleList.roles != null && data.content.roleList.roles.length > 0){
                    var roles = data.content.roleList.roles;
                    roles.forEach(function (item) {
                        if(item.id == roleId){
                            option += '<option value="'+item.id+'" selected>'+item.name+'</option>';
                        } else {
                            option += '<option value="'+item.id+'">'+item.name+'</option>';
                        }
                    })
                }
            }
            $("#listRoleGroupUsers").html(option);
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
function proccessUpdateRoleGroupUser() {
    if($("#listRoleGroupUsers").val() == "" || $("#listRoleGroupUsers").val() == undefined || $("#listRoleGroupUsers").val() == null){
        showNotification('danger', Messages("Bạn chưa chọn vai trò"));
        return;
    }
    var groupData = new FormData;
    groupData.role_id = $("#listRoleGroupUsers").val();
    groupData.group_id = $("#idRoleGroupUser").val();
    console.log(groupData);
    var r = jsRoutes.controllers.GroupController.updateRoleToGroupUser();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#editRoleGroupUserModal").modal('hide');
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
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


//gan user cho nhom device
function setAddUserToGroupDevice(id, userId) {
    console.log(id);
    $("#idGroupdevice").val(id);
    $("#addUserToGroupDeviceModal").modal('show');
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    console.log(groupData);
    var r = jsRoutes.controllers.GroupController.getListUserOfOrg();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            var option = "";
            if(data.content.listGroupUsers != null){
                if(data.content.listGroupUsers.users != null && data.content.listGroupUsers.users.length > 0){
                    var roles = data.content.listGroupUsers.users;
                    roles.forEach(function (item) {
                        if(item.user_id == userId){
                            option += '<option value="'+item.user_id+'" selected>'+item.email+'</option>';
                        } else {
                            option += '<option value="'+item.user_id+'">'+item.email+'</option>';
                        }
                    })
                }
            }
            $("#listUsersAddGroupdevice").html(option);
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
function proccessUpdateUserToGroupdevice() {
    if($("#listUsersAddGroupdevice").val() == "" || $("#listUsersAddGroupdevice").val() == undefined || $("#listUsersAddGroupdevice").val() == null){
        showNotification('danger', Messages("Bạn chưa chọn user"));
        return;
    }
    var groupData = new FormData;
    groupData.user_id = $("#listUsersAddGroupdevice").val();
    groupData.group_id = $("#idGroupdevice").val();
    console.log(groupData);
    var r = jsRoutes.controllers.GroupController.updateUserToGroupDevice();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#addUserToGroupDeviceModal").modal('hide');
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
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