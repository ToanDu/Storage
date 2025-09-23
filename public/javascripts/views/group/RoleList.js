/**
 * Created by vtk-anhlt166 on 11/18/21.
 */
function viewRoleToTable(data) {
    $("#totalRole").html(Messages("Tổng: ") + data.length + Messages(" vai trò"));
    $("#tabRole").empty();

    var mtmlGroup = "<table id='smlRolesTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th hidden>"+Messages("group.id")+"</th>" +
        "<th>"+Messages("group.role.name")+"</th>" +
        "<th></th>" +
        "</thead>" +
        "<tbody>";

    if (data != null && data.length > 0) {
        var option = '<option value="" selected disabled>'+Messages("manage.group.tructhuoc")+'</option>';

        for (var i = 0; i < data.length; i++) {
            mtmlGroup += "<tr id='tr_"+data[i].id+"'>";
            mtmlGroup += "<td></td>";
            mtmlGroup += "<td hidden><p id='role_"+data[i].id+"'>" + data[i].id + "</p></td>";
            mtmlGroup += "<td>" + data[i].name + "</td>";
            mtmlGroup += "<td align='center'>" ;
            mtmlGroup += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlGroup += '<ul class="dropdown-menu dropdown-table">' +
                // '<li style="cursor: pointer"><a class="dropdown-item"><i class="bx bx-info-circle"></i> '+Messages("btnDetail")+'</a></li>' +
                // '<li style="cursor: pointer"><a class="dropdown-item" onclick=""><i class="bx bx-message-square-edit"></i> '+Messages("btnEdit")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="copyIdRole(\''+data[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Copy ID")+'</a></li>' +
                '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelIdRole(\''+data[i].id+'\')"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>' +
                '</ul>';
            mtmlGroup += "</td>";
            mtmlGroup += "</td>";
            mtmlGroup += "</tr>";

            option +=
                '<option value="'+data[i].id+'">'+data[i].name+'</option>';
        }

        //append select role
        $("#chooseRoleUserAdd").html(option);
    }
    mtmlGroup += "</tbody></table>";
    $("#tabRole").html(mtmlGroup);

    var table = $('#smlRolesTable').DataTable( {
        lengthChange: false,
        // buttons: [ 'excel', 'pdf', 'print'],
        "order": [],
        "info": false,
        "columnDefs": [ {
            "targets": 3,
            "orderable": false
        } ],
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showPopupAddRole' );
                    showPopupAddRole();
                }
            }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlRolesTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function copyIdRole(id) {
    copyToClipboard("#role_"+id);
}

var countResource = 0;
var listIdOrgGroupAction = [];
var listIdDeviceGroupAction = [];
var listIdUserGroupAction = [];
var listIdEventGroupAction = [];
function showPopupAddRole() {
    $("#addRoleModal").modal('show');
    countResource = $('#resourcesRoleNew .service-list').length;

    // StartProcess();
    // var groupData = new FormData();
    // groupData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;;
    // groupData.projectId = projectId;
    // console.log(groupData);
    // var r = jsRoutes.controllers.GroupListController.getGroupWithEntityType();
    // $.ajax({
    //     type: r.type,
    //     dataType: 'json',
    //     data: JSON.stringify(groupData),
    //     contentType: "application/json; charset=utf-8",
    //     url: r.url,
    //     success: function (data, textStatus, jqXHR) {
    //         console.log(data);
    //         if(data.success){
    //             if(data.content.ORGANIZATION.groups.length > 0){
    //                 listIdOrgGroupAction = [];
    //                 var groupOrg = "<table id='groupOrgTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
    //                     "<thead>" +
    //                     "<th></th>" +
    //                     "<th>"+Messages("manage.stt")+"</th>" +
    //                     "<th>"+Messages("group.role.name")+"</th>" +
    //                     "<th>"+Messages("group.id")+"</th>" +
    //                     "</thead>" +
    //                     "<tbody>";
    //                 for(var o=0; o<data.content.ORGANIZATION.groups.length; o++){
    //                     groupOrg += "<tr>";
    //                     groupOrg += "<td align='center'>" ;
    //                     groupOrg += '<input type="checkbox" onchange="change_role_action(this,0)" class="organization-group" value="'+data.content.ORGANIZATION.groups[o].id+'" />';
    //                     groupOrg += "</td>";
    //                     groupOrg += "<td>"+(o+1)+"</td>";
    //                     groupOrg += "<td>" + data.content.ORGANIZATION.groups[o].name + "</td>";
    //                     groupOrg += "<td>" + data.content.ORGANIZATION.groups[o].id + "</td>";
    //                     groupOrg += "</td>";
    //                     groupOrg += "</tr>";
    //                 }
    //                 groupOrg += "</tbody></table>";
    //                 $("#groupOrg").html(groupOrg);
    //             }
    //
    //             if(data.content.DEVICE.groups.length > 0){
    //                 listIdDeviceGroupAction = [];
    //                 var groupDevice = "<table id='groupDeviceTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
    //                     "<thead>" +
    //                     "<th></th>" +
    //                     "<th>"+Messages("manage.stt")+"</th>" +
    //                     "<th>"+Messages("group.role.name")+"</th>" +
    //                     "<th>"+Messages("group.id")+"</th>" +
    //                     "</thead>" +
    //                     "<tbody>";
    //                 for(var d=0; d<data.content.DEVICE.groups.length; d++){
    //                     groupDevice += "<tr>";
    //                     groupDevice += "<td align='center'>" ;
    //                     groupDevice += '<input type="checkbox" onchange="change_role_action(this,1)" class="device-group" value="'+data.content.DEVICE.groups[d].id+'" />';
    //                     groupDevice += "</td>";
    //                     groupDevice += "<td>"+(d+1)+"</td>";
    //                     groupDevice += "<td>" + data.content.DEVICE.groups[d].name + "</td>";
    //                     groupDevice += "<td>" + data.content.DEVICE.groups[d].id + "</td>";
    //                     groupDevice += "</td>";
    //                     groupDevice += "</tr>";
    //                 }
    //                 groupDevice += "</tbody></table>";
    //                 $("#groupDevice").html(groupDevice);
    //             }
    //
    //             if(data.content.USER.groups.length > 0){
    //                 listIdUserGroupAction = [];
    //                 var groupUser = "<table id='groupUserTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
    //                     "<thead>" +
    //                     "<th></th>" +
    //                     "<th>"+Messages("manage.stt")+"</th>" +
    //                     "<th>"+Messages("group.role.name")+"</th>" +
    //                     "<th>"+Messages("group.id")+"</th>" +
    //                     "</thead>" +
    //                     "<tbody>";
    //                 for(var u=0; u<data.content.USER.groups.length; u++){
    //                     groupUser += "<tr>";
    //                     groupUser += "<td align='center'>" ;
    //                     groupUser += '<input type="checkbox" onchange="change_role_action(this,2)" class="user-group" value="'+data.content.USER.groups[u].id+'" />';
    //                     groupUser += "</td>";
    //                     groupUser += "<td>"+(u+1)+"</td>";
    //                     groupUser += "<td>" + data.content.USER.groups[u].name + "</td>";
    //                     groupUser += "<td>" + data.content.USER.groups[u].id + "</td>";
    //                     groupUser += "</td>";
    //                     groupUser += "</tr>";
    //                 }
    //                 groupUser += "</tbody></table>";
    //                 $("#groupUser").html(groupUser);
    //             }
    //
    //             if(data.content.EVENT.groups.length > 0){
    //                 listIdEventGroupAction = [];
    //                 var groupEvent = "<table id='groupUserTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
    //                     "<thead>" +
    //                     "<th></th>" +
    //                     "<th>"+Messages("manage.stt")+"</th>" +
    //                     "<th>"+Messages("group.role.name")+"</th>" +
    //                     "<th>"+Messages("group.id")+"</th>" +
    //                     "</thead>" +
    //                     "<tbody>";
    //                 for(var e=0; e<data.content.EVENT.groups.length; e++){
    //                     groupEvent += "<tr>";
    //                     groupEvent += "<td align='center'>" ;
    //                     groupEvent += '<input type="checkbox" onchange="change_role_action(this,3)" class="user-group" value="'+data.content.EVENT.groups[e].id+'" />';
    //                     groupEvent += "</td>";
    //                     groupEvent += "<td>"+(e+1)+"</td>";
    //                     groupEvent += "<td>" + data.content.EVENT.groups[e].name + "</td>";
    //                     groupEvent += "<td>" + data.content.EVENT.groups[e].id + "</td>";
    //                     groupEvent += "</td>";
    //                     groupEvent += "</tr>";
    //                 }
    //                 groupEvent += "</tbody></table>";
    //                 $("#groupEvent").html(groupEvent);
    //             }
    //
    //         } else{
    //             showNotification('danger',data.errorString, data.status);
    //         }
    //     },
    //     error: function (xhr) {
    //         console.log(xhr);
    //         showNotification('danger',Messages("connection.failed"));
    //     },
    //     complete: function (jqXHR, textStatus) {
    //         FinishProcess(); //Stop display loading...
    //     }
    // });
}

//add new
function appendResourcesRole() {
    countResource++;
    var appendHtml =
        '<div class="row row-Resource">'+
        '<div class="col-sm-5">'+
        '<div class="form-check form-check-inline" style="width: 100%; padding-left: 0px;">'+
        '<select class="form-select mb-3 service-list" id="serviceList'+countResource+'">'+
        '<option class="organizations" value="organizations" selected>'+Messages("role.service.organizations")+'</option>'+
        '<option class="groups" value="groups">'+Messages("role.service.groups")+'</option>'+
        '<option class="devices" value="devices">'+Messages("role.service.devices")+'</option>'+
        '<option class="users" value="users">'+Messages("role.service.users")+'</option>'+
        '<option class="events" value="events">'+Messages("role.service.events")+'</option>'+
        '</select>'+
        '</div>'+
        '</div>'+
        '<div class="col-sm-6 permission-list">'+
        '<div class="form-check form-check-inline" style="margin-top: 10px">'+
        '<input class="form-check-input CheckBoxView" type="checkbox" id="CheckBoxView'+countResource+'" value="option1">'+
        '<label class="form-check-label" for="CheckBoxView'+countResource+'">'+Messages("btnView")+'</label>'+
        '</div>'+
        '<div class="form-check form-check-inline" style="margin-top: 10px">'+
        '<input class="form-check-input CheckBoxCreate" type="checkbox" id="CheckBoxCreate'+countResource+'" value="option2">'+
        '<label class="form-check-label" for="CheckBoxCreate'+countResource+'">'+Messages("btnCreate")+'</label>'+
        '</div>'+
        '<div class="form-check form-check-inline" style="margin-top: 10px">'+
        '<input class="form-check-input CheckBoxEdit" type="checkbox" id="CheckBoxEdit'+countResource+'" value="option3">'+
        '<label class="form-check-label" for="CheckBoxEdit'+countResource+'">'+Messages("btnEdit")+'</label>'+
        '</div>'+
        '<div class="form-check form-check-inline" style="margin-top: 10px">'+
        '<input class="form-check-input CheckBoxDelete" type="checkbox" id="CheckBoxDelete'+countResource+'" value="option4">'+
        '<label class="form-check-label" for="CheckBoxDelete'+countResource+'">'+Messages("btnDelete")+'</label>'+
        '</div>'+
        '</div>'+
        '<div class="col-sm-1 pt-sm-2">'+
        '<i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource" onclick="removeResource(this)"></i>'+
        '</div>'+
        '</div>';

        $('#resourcesRoleNew').append(appendHtml)
}

function postNewRole() {
    var policies = [];

    $('#resourcesRoleNew').children().each(function () {
        var selectService = $(this).find('.service-list')[0];
        console.log(selectService);
        var CheckBoxView = $(this).find('.CheckBoxView')[0];
        var CheckBoxCreate = $(this).find('.CheckBoxCreate')[0];
        var CheckBoxEdit = $(this).find('.CheckBoxEdit')[0];
        var CheckBoxDelete = $(this).find('.CheckBoxDelete')[0];

        var actions = [];
        if($(CheckBoxView).is(':checked')){
            actions.push("read");
        }
        if($(CheckBoxCreate).is(':checked')){
            actions.push("create");
        }
        if($(CheckBoxEdit).is(':checked')){
            actions.push("modify");
        }
        if($(CheckBoxDelete).is(':checked')){
            actions.push("delete");
        }
        var policy = {
            "type": "generic",
            "resources": [$(selectService).val()],
            "actions": actions
        };
        policies.push(policy);
    });

    if(listIdOrgGroupAction.length > 0){
        for(var o=0; o<listIdOrgGroupAction.length; o++){
            var policy = {
                "type": "group",
                "resources": ["organizations"],
                "actions": listActionOrganization,
                "group_id": listIdOrgGroupAction[o]
            };
            policies.push(policy);
        }
    }
    if(listIdDeviceGroupAction.length > 0){
        for(var d=0; d<listIdDeviceGroupAction.length; d++){
            var policy = {
                "type": "group",
                "resources": ["devices"],
                "actions": listActionDevice,
                "group_id": listIdDeviceGroupAction[d]
            };
            policies.push(policy);
        }
    }
    if(listIdUserGroupAction.length > 0){
        for(var u=0; u<listIdUserGroupAction.length; u++){
            var policy = {
                "type": "group",
                "resources": ["users"],
                "actions": listActionUser,
                "group_id": listIdUserGroupAction[u]
            };
            policies.push(policy);
        }
    }
    if(listIdEventGroupAction.length > 0){
        for(var e=0; e<listIdEventGroupAction.length; e++){
            var policy = {
                "type": "group",
                "resources": ["organizations"],
                "actions": listActionEvent,
                "group_id": listIdEventGroupAction[e]
            };
            policies.push(policy);
        }
    }

    var body = {
        "project_id": projectId,
        "org_id": (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id,
        "name" : $('#nameRoleNew').val(),
        "policies": policies
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.RoleController.addNewRole();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);

                selectUpdateGroup(currentSelectedGroup.id);
            } else{
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

function change_role_action(el,itype){
    if(itype==0){
        if(el.checked){
            listIdOrgGroupAction.push(el.value);
        }else{
            listIdOrgGroupAction.splice(listIdOrgGroupAction.indexOf(el.value),1);
        }
        console.log(listIdOrgGroupAction);
    } else if(itype==1){
        if(el.checked){
            listIdDeviceGroupAction.push(el.value);
        }else{
            listIdDeviceGroupAction.splice(listIdDeviceGroupAction.indexOf(el.value),1);
        }
        console.log(listIdDeviceGroupAction);
    } else if(itype==2){
        if(el.checked){
            listIdUserGroupAction.push(el.value);
        }else{
            listIdUserGroupAction.splice(listIdUserGroupAction.indexOf(el.value),1);
        }
        console.log(listIdUserGroupAction);
    } else if(itype==3){
        if(el.checked){
            listIdEventGroupAction.push(el.value);
        }else{
            listIdEventGroupAction.splice(listIdEventGroupAction.indexOf(el.value),1);
        }
        console.log(listIdEventGroupAction);
    }
}

function changeTabAction(el) {
    // console.log(el);
    if(el==0){
        document.getElementById("groupAction").style.display = "block";
        document.getElementById("deviceAction").style.display = "none";
        document.getElementById("userAction").style.display = "none";
        document.getElementById("eventAction").style.display = "none";
    } else if(el==2){
        document.getElementById("groupAction").style.display = "none";
        document.getElementById("deviceAction").style.display = "block";
        document.getElementById("userAction").style.display = "none";
        document.getElementById("eventAction").style.display = "none";
    } else if(el==1){
        document.getElementById("groupAction").style.display = "none";
        document.getElementById("deviceAction").style.display = "none";
        document.getElementById("userAction").style.display = "block";
        document.getElementById("eventAction").style.display = "none";
    } else if(el==3){
        document.getElementById("groupAction").style.display = "none";
        document.getElementById("deviceAction").style.display = "none";
        document.getElementById("userAction").style.display = "none";
        document.getElementById("eventAction").style.display = "block";
    }
}

var listActionOrganization = [];
var listActionDevice = [];
var listActionUser = [];
var listActionEvent = [];
function change_action(el, id, action) {
    // console.log(el, id, action);
    if(id == "groupAction"){
        if(el.checked){
            listActionOrganization.push(el.value);
        }else{
            listActionOrganization.splice(listActionOrganization.indexOf(el.value),1);
        }
        console.log(listActionOrganization);
    } else if(id == "deviceAction"){
        if(el.checked){
            listActionDevice.push(el.value);
        }else{
            listActionDevice.splice(listActionDevice.indexOf(el.value),1);
        }
        console.log(listActionDevice);
    } else if(id == "userAction"){
        if(el.checked){
            listActionUser.push(el.value);
        }else{
            listActionUser.splice(listActionUser.indexOf(el.value),1);
        }
        console.log(listActionUser);
    } else if(id == "eventAction"){
        if(el.checked){
            listActionEvent.push(el.value);
        }else{
            listActionEvent.splice(listActionEvent.indexOf(el.value),1);
        }
        console.log(listActionEvent);
    }
}

function removeResource(el) {
    console.log("removeResource");
    $(el).parents('.row-Resource').remove();
}

//del
function setDelIdRole(id) {
    $("#deleteRoleConfirm").modal('show');
    $("#idRoleDelete").val(id);
}
function postDeleteRole() {
    var groupData = new FormData();
    groupData.id = $('#idRoleDelete').val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.RoleController.deleteRole();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
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
