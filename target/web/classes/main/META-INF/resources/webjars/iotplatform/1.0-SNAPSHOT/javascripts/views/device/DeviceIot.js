function deleteDeviceId(id) {
    $("#idDeviceDelete").val(id);
}
function processDeleteDeviceId() {
    var groupData = new FormData();
    groupData.id = $('#idDeviceDelete').val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.deleteDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
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

//EDIT NAME
function editDeviceName(id, name) {
    $("#idDeviceEdit").val(id);
    $("#nameDeviceEdit").val(name);
}
function postEditNameDevice() {
    var Data = new FormData();
    Data.id = $('#idDeviceEdit').val();
    Data.name = $('#nameDeviceEdit').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.editNameDevice();
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
                setTimeout(function () {
                    window.location.reload();
                },1000);
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

//UPDATE
var treeNodeArrayOrg = [];
var treeNodeArrayGroup = [];
var oldData2 = {
    groupId: "",
    orgId: "",
    typeId: ""
}
function getDataUpdateDevice(id, groupId, orgId, typeId) {
    $("#idDeviceUpdate").val(id);

    oldData2.groupId = groupId;
    oldData2.orgId = orgId;
    oldData2.typeId = typeId;

    if(groupId != null && groupId != "" && groupId != undefined){
        $("#"+groupId+"_anchor").click();
    } else {
        $('#selectGroups').jstree("deselect_all");
    }

    if(orgId != null && orgId != "" && orgId != undefined){
        $("#"+orgId+"_anchor").click();
    } else {
        $('#selectOrganizations').jstree("deselect_all");
    }

    if(typeId != null && typeId != "" && typeId != undefined){
        $("#checkbox-"+typeId).click();
    } else {
        $("#checkbox-default").click();
    }
}
function getListOrganizations() {
    // StartProcess();
    var getGroup = jsRoutes.controllers.GroupController.getListOrganizations();
    $.ajax({
        type: getGroup.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: getGroup.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.length>0){
                    pushDataTreeNodeOrg(data.content);

                    $('#selectOrganizations').jstree({
                        core: {
                            data: treeNodeArrayOrg,
                            check_callback: true  // don't forget to set this param to true
                        },
                        "plugins": ["search", "sort"],
                        "search": {
                            "case_sensitive": false,
                            "show_only_matches": true
                        },
                        "sort" : function(a, b) {
                            //What is the function of sorting
                            a1 = this.get_node(a);
                            b1 = this.get_node(b);
                            if (a1.icon == b1.icon){
                                return (a1.text > b1.text) ? 1 : -1;
                            } else {
                                return (a1.icon > b1.icon) ? 1 : -1;
                            }
                        }
                    });
                    $('#selectOrganizations').jstree();
                    $('#selectOrganizations').on("changed.jstree", function (e, data) {
                        selectOrg(data.selected);
                    });
                    $('#selectOrganizations').on('loaded.jstree', function() {
                        //open tat ca cac node
                        $('#selectOrganizations').jstree('open_all');
                    });
                    $('button').on('click', function () {
                        $('#selectOrganizations').jstree(true).select_node('child_node_1');
                        $('#selectOrganizations').jstree('select_node', 'child_node_1');
                        $.jstree.reference('#selectOrganizations').select_node('child_node_1');
                    });
                    $("#search-selectOrg").keyup(function () {
                        var searchString = $(this).val();
                        $('#selectOrganizations').jstree('search', searchString);
                    });
                }
            } else {
                showNotification('error',data.resultString, data.status);
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}
function pushDataTreeNodeOrg(data) {
    for(var i =0 ; i<data.length; i++){
        var node = {
            id: data[i].id,
            parent: data[i].parent,
            text: data[i].name
        };
        treeNodeArrayOrg.push(node);
    }
    console.log(treeNodeArrayOrg);
}
function selectOrg(data) {
    console.log(data[0]);
    $("#orgIdMove").val(data[0]);
}

function getListGroups() {
    // StartProcess();
    var getGroup = jsRoutes.controllers.GroupListController.getListGroups();
    $.ajax({
        type: getGroup.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: getGroup.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.length>0){
                    pushDataTreeNodeGroup(data.content);

                    $('#selectGroups').jstree({
                        core: {
                            data: treeNodeArrayGroup,
                            check_callback: true  // don't forget to set this param to true
                        },
                        "plugins": ["search", "sort"],
                        "search": {
                            "case_sensitive": false,
                            "show_only_matches": true
                        },
                        "sort" : function(a, b) {
                            //What is the function of sorting
                            a1 = this.get_node(a);
                            b1 = this.get_node(b);
                            if (a1.icon == b1.icon){
                                return (a1.text > b1.text) ? 1 : -1;
                            } else {
                                return (a1.icon > b1.icon) ? 1 : -1;
                            }
                        }
                    });
                    $('#selectGroups').jstree();
                    $('#selectGroups').on("changed.jstree", function (e, data) {
                        selectGroup(data.selected);
                    });
                    $('#selectGroups').on('loaded.jstree', function() {
                        //open tat ca cac node
                        $('#selectGroups').jstree('open_all');
                    });
                    $('button').on('click', function () {
                        $('#selectGroups').jstree(true).select_node('child_node_1');
                        $('#selectGroups').jstree('select_node', 'child_node_1');
                        $.jstree.reference('#selectGroups').select_node('child_node_1');
                    });
                    $("#search-selectGroup").keyup(function () {
                        var searchString = $(this).val();
                        $('#selectGroups').jstree('search', searchString);
                    });
                }
            } else {
                showNotification('error',data.resultString, data.status);
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}
function pushDataTreeNodeGroup(data) {
    for(var i =0 ; i<data.length; i++){
        var node = {
            id: data[i].id,
            parent: data[i].parent,
            text: data[i].name
        };
        treeNodeArrayGroup.push(node);
    }
    console.log(treeNodeArrayGroup);
}
function selectGroup(data) {
    console.log(data[0]);
    $("#groupIdMove").val(data[0]);
}

function getListTypes() {
    // StartProcess();
    var getGroup = jsRoutes.controllers.DeviceTypeController.getListTypes();
    $.ajax({
        type: getGroup.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: getGroup.url,
        success: function (data) {
            console.log(data);
            $("#listDeviceTypes").html("<input type=\"radio\" class=\"form-check-input\" name=\"radio-stacked\" id='checkbox-default' onclick='chooseDeviceTypes(\"\")' hidden>");
            if(data.content != null && data.content.length > 0){
                for(var i =0; i<data.content.length; i++){
                    var device =
                        "<div class=\"customers-list-item d-flex align-items-center border-top border-bottom p-2 cursor-pointer\" >"+
                        "<div class=\"ms-2\">" +
                        "<input type=\"radio\" class=\"form-check-input\" name=\"radio-stacked\" id='checkbox-"+data.content[i].id+"' onclick='chooseDeviceTypes(\""+data.content[i].id+"\")' required>" +
                        "</div>"+
                        "<div class=\"ms-2\">" +
                        "<h6 class=\"mb-1 font-14\">"+ data.content[i].name +"</h6>" +
                        "<p class=\"mb-0 font-13\">"+ data.content[i].id +"</p>" +
                        "</div>" +
                        "</div>";
                    $("#listDeviceTypes").append(device);

                }
            }

        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    })
}

function chooseDeviceTypes(idType) {
    $("#typeIdMove").val(idType);
}

//update
function processUpdateDevice() {
    var Data = new FormData();
    Data.id = $('#idDeviceUpdate').val();
    Data.idOrg = $('#orgIdMove').val();
    Data.idGroup = $('#groupIdMove').val();
    Data.idType = $('#typeIdMove').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.updateDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            console.log(this.oldData);
            if(data.success){
                if(data.content != null){
                    if(data.content.organization != null){
                        if(data.content.organization) {
                            if (data.content.updatedDevice.orgID !== oldData2.orgId) {
                                showNotification('success', Messages("device.updateOrg.success"));
                            }
                        } else {
                            showNotification('danger', Messages("device.updateOrg.false"), data.content.orgStatus);
                        }
                    }

                    if(data.content.group != null){
                        if(data.content.group){
                            if (data.content.updatedDevice.groupId !== oldData2.groupId) {
                                showNotification('success', Messages("device.updateGroup.success"));
                            }
                        } else {
                            showNotification('danger', Messages("device.updateGroup.false"), data.content.groupStatus);
                        }
                    }

                    if(data.content.type != null){
                        if(data.content.type){
                            if (data.content.updatedDevice.typeID !== oldData2.typeId) {
                                showNotification('success', Messages("device.updateType.success"));
                            }
                        } else {
                            showNotification('danger', Messages("device.updateType.false"), data.content.typeStatus);
                        }
                    }
                }
                setTimeout(function () {
                    window.location.reload();
                },1000);
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