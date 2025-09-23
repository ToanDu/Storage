/**
 *  BootTree Treeview plugin for Bootstrap.
 *
 *  Based on BootSnipp TreeView Example by Sean Wessell
 *  URL:    http://bootsnipp.com/snippets/featured/bootstrap-30-treeview
 *
 *    Revised code by Leo "LeoV117" Myers
 *
 */
var currentSelectedGroup = "";

var node_selected;
var listIdUser=new Array();
var ListIdUsername=new Array();
var listUserSave=new Array();
var listIdUserAction=new Array();


var listDeviceSave=new Array();
var listIdDeviceAction=new Array();
var listIdBorderSeaAction=new Array();
var listDeviceSearch=new Array();
var listDeviceAccept=new Array();
var ROLE_USER = {
    SAdmin: {value: 100, name: "SAdmin"},
    Admin: {value: 4, name: "Admin"},
    SMod: {value: 3, name: "Supermod"},
    Mod: {value: 2, name: "Mod"},
    User: {value: 1, name: "User"}
};

$.fn.extend({
    treeview: function (){
        return this.each(function (){
            // Initialize the top levels;
            var tree = $(this);

            tree.addClass('treeview-tree');
            tree.find('li').each(function () {
                var stick = $(this);
            });
            tree.find('li').has("ul").each(function () {
                var branch = $(this); //li with children ul

                branch.prepend("<i class='tree-indicator glyphicon glyphicon-chevron-right'></i>");
                branch.addClass('tree-branch');
                branch.on('click', function (e) {
                    if (this == e.target) {
                        var icon = $(this).children('i:first');

                        icon.toggleClass("glyphicon-chevron-down glyphicon-chevron-right");
                        $(this).children().children().toggle();
                    }
                });
                branch.children().children().toggle();

                /**
                 *    The following snippet of code enables the treeview to
                 *    function when a button, indicator or anchor is clicked.
                 *
                 *    It also prevents the default function of an anchor and
                 *    a button from firing.
                 */
                branch.children('.tree-indicator, button, a').click(function (e) {
                    branch.click();

                    e.preventDefault();
                });
            });
        });
    }
});

$(window).on('load', function () {
    $('.treeview').each(function () {
        var tree = $(this);
        tree.treeview();
    });

});

function changeTabInfoOrg() {
    getInfoOrg(currentSelectedGroup.id);
    getAtrributeOrg(currentSelectedGroup.id);
}
function changeTabGroup() {
    selectTabGroupOfOrg(currentSelectedGroup.id);
}
function changeTabUser() {
    selectTabUserOfOrg(currentSelectedGroup.id);
}
function changeTabDevice() {
    selectTabDeviceOfOrg(currentSelectedGroup.id);
}
function changeTabEvent() {
    selectTabEventOfOrg(currentSelectedGroup.id);
}
function changeTabRole() {
    selectTabRoleOfOrg(currentSelectedGroup.id);
}

function selectGroup(orgId) {
    console.log(orgId);

    getInfoOrg(orgId);

    if(document.getElementById("infoOrg").classList.contains("active")){
        getAtrributeOrg(orgId);
    }

    if(document.getElementById("addDelGroup").classList.contains("active")){
        selectTabGroupOfOrg(orgId);
    }

    if(document.getElementById("addDelUser").classList.contains("active")){
        selectTabUserOfOrg(orgId);
    }

    if(document.getElementById("addDelDevice").classList.contains("active")){
        selectTabDeviceOfOrg(orgId);
    }

    if(document.getElementById("addDelEvent").classList.contains("active")){
        selectTabEventOfOrg(orgId);
    }

    if(document.getElementById("addDelRole").classList.contains("active")){
        selectTabRoleOfOrg(orgId);
    }
}

function selectUpdateGroup(orgId) {
    console.log(orgId);

    if(document.getElementById("infoOrg").classList.contains("active")){
        getInfoOrg(orgId);
        getAtrributeOrg(orgId);
    }

    if(document.getElementById("addDelGroup").classList.contains("active")){
        selectTabGroupOfOrg(orgId);
    }

    if(document.getElementById("addDelUser").classList.contains("active")){
        selectTabUserOfOrg(orgId);
    }

    if(document.getElementById("addDelDevice").classList.contains("active")){
        selectTabDeviceOfOrg(orgId);
    }

    if(document.getElementById("addDelEvent").classList.contains("active")){
        selectTabEventOfOrg(orgId);
    }

    if(document.getElementById("addDelRole").classList.contains("active")){
        selectTabRoleOfOrg(orgId);
    }
}

function selectTabGroupOfOrg(orgId) {
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (orgId != projectId) ? orgId : "";

    var r = jsRoutes.controllers.GroupController.getListGroupOfOrg();
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
                viewGroupToTable(data.content.groupList.groups);
            }else{
                // showNotification('danger',data.errorString, data.status);
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
function selectTabUserOfOrg(orgId) {
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (orgId != projectId) ? orgId : "";

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
            if(data.success){
                viewUserToTable(data.content.listGroupUsers.users);
            }else{
                $("#tabUser").html("");
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
function selectTabDeviceOfOrg(orgId) {
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (orgId != projectId) ? orgId : "";
    groupData.page = $("#page").val();
    groupData.pageSize = $("#pageSize").val();
    console.log(groupData);

    var r = jsRoutes.controllers.GroupController.getListDeviceOfOrg();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if(data.success){
                viewDeviceToTable(data.content);
            }else{
                $("#tabDevice").html("");
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
function selectTabEventOfOrg(orgId) {
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (orgId != projectId) ? orgId : "";

    var r = jsRoutes.controllers.GroupController.getListEventOfOrg();
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
                viewEventToTable(data.content.eventList.events);
            }else{
                $("#tabEvent").html("");
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
function selectTabRoleOfOrg(orgId) {
    var groupData = new FormData;
    groupData.projectId = projectId;
    groupData.groupId = (orgId != projectId) ? orgId : "";

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
            if(data.success){
                viewRoleToTable(data.content.roleList.roles);
            }else{
                $("#tabRole").html("");
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

function viewGroupInfo(group) {
    console.log(group);
    if(group!=null){
        //console.log("group:"+JSON.stringify(group))
        $('#idUpdateGroup').val(group.id);
        $(' #nameUpdateGroup').val(group.name);
        $(' #addressUpdateGroup').val(group.address);
        $(' #emailUpdateGroup').val(group.email);
        $(' #phoneUpdateGroup').val(group.phone);
    }
}




function refreshviewInsertGroup() {
    $('#idInsertGroup').val(currentSelectedGroup.id);
    $('#nameInsertGroup').val('');
    $('#addressInsertGroup').val('');
    $('#emailInsertGroup').val('');
    $('#phoneInsertGroup').val('');
}

function AddChildGroup(csrfToken){
    // if (!$('#insertGroupForm').valid()){
    //     return;
    // }

    console.log("Pass Validator "+$('#insertGroupForm input[name=name]').val())

    var groupData = new FormData();
    groupData.id = $('#idInsertGroup').val();
    groupData.name = $('#nameInsertGroup').val();
    groupData.address = $('#addressInsertGroup').val();
    groupData.email = $('#emailInsertGroup').val();
    groupData.phone = $('#phoneInsertGroup').val();
    console.log(groupData);

    var r = jsRoutes.controllers.GroupController.addGroupChild();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        beforeSend: function(request) {
            request.setRequestHeader("Csrf-Token", csrfToken);
        },
        success: function (data, textStatus, jqXHR) {
            if(data.success){
                showNotification('success',data.resultString);
                // window.location.href = jsRoutes.controllers.GroupController.groupList().url;
                setTimeout(function () {
                    window.location.reload();
                },1000)
            }else{
                showNotification('error',data.errorString, data.status);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('error',Messages("connection.failed"));
        }
    });
}





function change_checkbox_actionSend(el,itype){
    if(itype==0){ //user
        if(el.checked){
            listIdUserAction.push(el.value);
        }else{
            listIdUserAction.splice(listIdUserAction.indexOf(el.value),1);
        }
        if(listIdUserAction.length>0){
            $('.dropdown-user-actionSend').prop('disabled', false);
        }else{
            $('.dropdown-user-actionSend').prop('disabled', true);
        }

    }else{ //device
        //console.log(el.value);
        if(el.checked){
            listIdDeviceAction.push(el.value);
        }else{
            listIdDeviceAction.splice(listIdDeviceAction.indexOf(el.value),1);
        }
        if(listIdDeviceAction.length>0){
            $('.dropdown-device-actionSend').prop('disabled', false);
        }else{
            $('.dropdown-device-actionSend').prop('disabled', true);
        }
    }
}

function change_checkbox_action(el,itype){
    if(itype==0){ //user
        if(el.checked){
            listIdUserAction.push(el.value);
        }else{
            listIdUserAction.splice(listIdUserAction.indexOf(el.value),1);
        }
        if(listIdUserAction.length>0){
            $('.dropdown-user-action').prop('disabled', false);
        }else{
            $('.dropdown-user-action').prop('disabled', true);
        }

        console.log(listIdUserAction);
    } else if(itype == 2){
        if(el.checked){
            listIdContactAction.push(el.value);
        }else{
            listIdContactAction.splice(listIdContactAction.indexOf(el.value),1);
        }
        if(listIdContactAction.length>0){
            $('.dropdown-contact-action').prop('disabled', false);
        }else{
            $('.dropdown-contact-action').prop('disabled', true);
        }
    } else if(itype == 1) { //device
        //console.log(el.value);
        if(el.checked){
            listIdDeviceAction.push(el.value);
        }else{
            listIdDeviceAction.splice(listIdDeviceAction.indexOf(el.value),1);
        }
        if(listIdDeviceAction.length>0){
            $('.dropdown-device-action').prop('disabled', false);
        }else{
            $('.dropdown-device-action').prop('disabled', true);
        }
    }
}

function view_other_groups(itype){
    //itype = 0 - tab user
    //itype = 1 - tab thing

    $('#selectGroup #itype').val(itype);
}













function setDelDevicesId(){
    var listImei = "";
    if (listIdDeviceAction.length>0){
        listImei = listIdDeviceAction.join();    //Joins the elements of an array into a string.The elements will be separated by a specified separator
    }
    $('#deleteDevices input[name=listImei]').val(listImei);
}

function selectDeviceSync() {
    console.log(listIdDeviceAction);
    console.log(ListIdUsername);
    var option = "";
    for(var i=0; i<listIdDeviceAction.length; i++){
        option += "<option value='"+listIdDeviceAction[i]+"'>"+listIdDeviceAction[i]+"</option>";
    }
    var optionUser="";
    for(var j=0; j<ListIdUsername.length; j++){
        optionUser += "<option value='"+listIdUser[j]+"'>"+ListIdUsername[j]+"</option>";
    }
    $('#imeiDevice').html(option).selectpicker('refresh');
    $('#idUser').html(optionUser).selectpicker('refresh');
}


