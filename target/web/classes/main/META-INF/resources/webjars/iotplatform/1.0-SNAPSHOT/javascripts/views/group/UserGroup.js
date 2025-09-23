/**
 * Created by vtk-anhlt166 on 4/7/21.
 */
function refreshviewAddUser() {
    $('#emailAddUser').val('');
}

function viewUserToTable(lUsers) {
    $("#totalUser").html(Messages("Tổng: ") + lUsers.length + Messages(" người dùng"));
    $("#tabUser").empty();
    // console.log(lUsers);
    ListData=new Array();
    listIdUser=new Array();
    ListIdUsername=new Array();
    listUserSave=new Array();
    listIdUserAction=new Array();

    var mtmlUser = "<table id='smlUsersTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        // "<th>"+Messages("ID")+"</th>" +
        "<th data-field=\"email\">"+Messages("manage.user.email")+"</th>" +
        "<th data-field=\"role\">"+Messages("manage.user.group")+"</th>" +
        "<th data-field=\"role\">"+Messages("manage.user.role")+"</th>" +
        "<th data-field=\"action\"></th>" +
        "</thead>" +
        "<tbody>";

    if (lUsers!=null && lUsers.length > 0) {
        for (var i = 0; i < lUsers.length; i++) {
            // var r = jsRoutes.controllers.UserController.userDetail(lUsers[i].id);
            var group_name = (lUsers[i].group_name != null) ? lUsers[i].group_name : "";
            var role_name = (lUsers[i].role_name != null) ? lUsers[i].role_name : "";
            var role_id = (lUsers[i].role_id != null) ? lUsers[i].role_id : "";


            mtmlUser += "<tr id='tr_"+lUsers[i].user_id+"'>";
            mtmlUser += "<td class='stt'></td>";
            // mtmlUser += "<td class='email'>" + lUsers[i].user_id + "</td>";
            mtmlUser += "<td class='email'>" + lUsers[i].email + "</td>";
            mtmlUser += "<td class='group'>" + group_name + "</td>";
            mtmlUser += "<td class='role'>" + role_name + "</td>";
            mtmlUser += "<td align='center'>" ;
            // mtmlUser += "<input type=\"checkbox\" style='float: left' onchange=\"change_checkbox_action(this,0)\" value='"+lUsers[i].id+"' />";
            // mtmlUser += "<span class='form-check-sign'><span class='check'></span></span>";
            mtmlUser += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlUser += '<ul class="dropdown-menu dropdown-table">' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageAttrUser(\''+lUsers[i].user_id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnAttr")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditUserInOrg(\''+lUsers[i].user_id+'\', \''+lUsers[i].email+'\', \''+role_id+'\')"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Sửa vai trò")+'</a></li>' +
                '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelUserInOrg(\''+lUsers[i].user_id+'\')"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>' +
                '</ul>';
            mtmlUser +="</td>";
            // mtmlUser += "</td>";
            mtmlUser += "</tr>";
        }
    }
    mtmlUser += "</tbody></table>";
    $("#tabUser").html(mtmlUser);

    var table = $('#smlUsersTable').DataTable( {
        responsive: true,
        lengthChange: false,
        // buttons: [ 'excel', 'pdf', 'print'],
        "order": false,
        "info": false,
        bSort: false,
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showPopupAddUser' );
                    showPopupAddUser();
                }
            }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlUsersTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function remotePageAttrUser(id) {
    window.location.href = jsRoutes.controllers.AttributeController.attributeUser(projectId, id).url;
}

function showPopupAddUser() {
    refreshviewAddUser();
    $("#groupAdduser").modal('show');

    StartProcess();
    var formData = new FormData;
    formData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    formData.projectId = projectId;
    var r = jsRoutes.controllers.GroupListController.getListGroupUser();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var option = '<option value="" selected disabled>'+Messages("manage.group.tructhuoc")+'</option>';
                if(data.content != null){
                    if(data.content.groups != null && data.content.groups.length > 0){
                        for(var i=0; i<data.content.groups.length; i++){
                            option +=
                                '<option value="'+data.content.groups[i].id+'">'+data.content.groups[i].name+'</option>';
                        }
                    }
                }
                $("#chooseGroupUserAdd").html(option);
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

function editRootUser(groupRole, list, number) {
    console.log(groupRole);
    console.log(list);
    console.log(number);
    $('#groupIdEdit').val(list[number].id);
    $('#usernameEdit').val(list[number].username);
    $('#emailEdit').val(list[number].email);
    var roleOption = "";
    if(groupRole == 1){
        roleOption += "<option value='"+ROLE_USER.SAdmin.value+"'>"+ROLE_USER.SAdmin.name+"</option>";
        roleOption += "<option value='"+ROLE_USER.Admin.value+"'>"+ROLE_USER.Admin.name+"</option>";
        roleOption += "<option value='"+ROLE_USER.SMod.value+"'>"+ROLE_USER.SMod.name+"</option>";
        roleOption += "<option value='"+ROLE_USER.Mod.value+"'>"+ROLE_USER.Mod.name+"</option>";
        roleOption += "<option value='"+ROLE_USER.User.value+"'>"+ROLE_USER.User.name+"</option>";
    } else {
        roleOption += "<option value='"+ROLE_USER.SMod.value+"'>"+ROLE_USER.SMod.name+"</option>";
        roleOption += "<option value='"+ROLE_USER.Mod.value+"'>"+ROLE_USER.Mod.name+"</option>";
        roleOption += "<option value='"+ROLE_USER.User.value+"'>"+ROLE_USER.User.name+"</option>";
    }
    $('#roleEdit').html(roleOption).selectpicker('refresh');
    $("#roleEdit").val(list[number].role).trigger("change");

    if(!list[number].active){
        console.log(false);
        $("#activeUserRole").prop('checked', true);
        // $("#activeTextRole").val(false);
        document.getElementById("activeUserRole").checked = true;
    } else {
        $("#activeUserRole").prop('checked', false);
        // $("#activeTextRole").val(true);
        document.getElementById("activeUserRole").checked = false;
    }

}

function setAddUsrGroupId(){
    console.log(currentSelectedGroup);
    $('#groupAdduser').val(currentSelectedGroup.id);
}

function processAddUser() {
    StartProcess();
    var userData = new FormData();

    userData.email = $('#emailAddUser').val();
    userData.password = $('#inputChoosePassword').val();
    userData.rePassword = $('#inputChooseRePassword').val();
    userData.projectId = projectId;
    userData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    userData.groupId = ($('#chooseGroupUserAdd').val() != null) ? $('#chooseGroupUserAdd').val() : "";
    userData.roleId = ($('#chooseRoleUserAdd').val() != null) ? $('#chooseRoleUserAdd').val() : "";
    console.log(userData);

    var r = jsRoutes.controllers.GroupController.createUserInOrg();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(userData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
                showNotification('error',data.errorString, data.status);
            }

        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('error',Messages("connection.failed"));

            setTimeout(function () {
                window.location.reload();
            },1000);
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }

    });
}

function setDelUserInOrg(id) {
    console.log(id);
    $('#idUserDelete').val(id);
    $("#deleteUsersconfirm").modal('show');
}

function postDataDelUserInOrg() {
    var Data = new FormData();
    Data.id = $('#idUserDelete').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.UserController.deleteUser();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                selectUpdateGroup(currentSelectedGroup.id);
            }else{  //tra ve cau hinh truoc do
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

function setDelUsrids(){
    var listUsrid = "";
    if (listIdUserAction.length>0){
        listUsrid = listIdUserAction.join();    //Joins the elements of an array into a string.The elements will be separated by a specified separator
    }
    $('#listUsrid').val(listUsrid);
}

function showPassword() {
    console.log("showPassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHidePass").attr("onclick","hidePassword()");
    document.getElementById("inputChoosePassword").type = "text";
}

function hidePassword() {
    console.log("hidePassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHidePass").attr("onclick","showPassword()");
    document.getElementById("inputChoosePassword").type = "password";
}

function showRePassword() {
    console.log("showRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHideRePass").attr("onclick","hideRePassword()");
    document.getElementById("inputChooseRePassword").type = "text";
}

function hideRePassword() {
    console.log("hideRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHideRePass").attr("onclick","showRePassword()");
    document.getElementById("inputChooseRePassword").type = "password";
}

//edit role
function setEditUserInOrg(userId, email, roleId) {
    $("#idUserEdit").val(userId);
    $("#emailUserEdit").val(email);
    $("#editRoleUserModal").modal('show');

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
            $("#chooseRoleUserEdit").html(option);
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

function processEditRoleUser() {
    // if($("#listRoleGroupUsers").val() == "" || $("#listRoleGroupUsers").val() == undefined || $("#listRoleGroupUsers").val() == null){
    //     showNotification('danger', Messages("Bạn chưa chọn vai trò"));
    //     return;
    // }
    var groupData = new FormData;
    groupData.role_id = $("#chooseRoleUserEdit").val();
    groupData.user_id = $("#idUserEdit").val();
    console.log(groupData);
    var r = jsRoutes.controllers.GroupController.updateRoleForUser();
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
                $("#editRoleUserModal").modal('hide');
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