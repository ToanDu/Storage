/**
 * Created by vtk-anhlt166 on 11/4/21.
 */
var treeNodeArrayOrg = [];
var listIdNode = [];
function getListOrganizations() {
    StartProcess();
    var getGroup = jsRoutes.controllers.GroupController.getListOrganizations(projectId);
    $.ajax({
        type: getGroup.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: getGroup.url,
        success: function (data) {
            console.log(data);
            if(data.success && data.content.organizations != null){
                $("#tabListOrg").html('<div id="jstree"></div>');
                treeNodeArrayOrg = [];
                listIdNode = [];

                pushDataTreeNodeOrg(data.content.organizations);

                console.log(treeNodeArrayOrg);
                $('#jstree').jstree({
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
                $('#jstree').jstree();
                // $('#jstree').on("changed.jstree", function (e, data) {
                //     if(data.selected != null && data.selected.length > 0){
                //         selectGroup(data.selected);
                //     }
                // });
                $('#jstree').on('loaded.jstree', function() {
                    //open tat ca cac node
                    $('#jstree').jstree('open_all');

                    //select default
                    if(listIdNode.length > 0){
                        $('#jstree').jstree('select_node', treeNodeArrayOrg[0]);
                        selectGroup(treeNodeArrayOrg[0].id);
                    }
                });
                $('button').on('click', function () {
                    $('#jstree').jstree(true).select_node('child_node_1');
                    $('#jstree').jstree('select_node', 'child_node_1');
                    $.jstree.reference('#jstree').select_node('child_node_1');
                });
                $("#search-selectOrg").keyup(function () {
                    var searchString = $(this).val();
                    $('#jstree').jstree('search', searchString);
                });
            } else {
                if(data.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('error',data.errorString, data.status);
                    FinishProcess();
                }
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
            setTimeout(function () {
                FinishProcess();
            },1000);
        }
    });
}

var nameProject = "";
function pushDataTreeNodeOrg(data) {
    var listProject = JSON.parse(localStorage.listProject);
    var nameProjectDefault = "";
    for(var k=0; k<listProject.length; k++){
        if(listProject[k].id == projectId){
            nameProjectDefault = listProject[k].name;
            break;
        }
    }

    nameProject = nameProjectDefault;

    var textDefault = '<span onclick="selectGroup(\''+""+'\');" style="padding: 15px; font-size: 16px;">'+Messages("Dự án: ")+nameProjectDefault+'</span>';
    var nodeDefault = {
        id: projectId,
        parent: "#",
        text: textDefault
    };
    treeNodeArrayOrg.push(nodeDefault);
    listIdNode.push(projectId);

    if(data.length > 0){
        for(var i =0 ; i<data.length; i++){
            var button = '<i class="bx bx-dots-vertical" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer; background-color: #B5B6B7; color: white; border-radius: 0px 4px 4px 0px; padding: 0px 2px 0px 2px;"></i>'+
                '<ul class="dropdown-menu dropdown-jstree">' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;" data-bs-toggle="modal" data-bs-target="#editOrgModal" onclick="setEditOrg(\''+data[i].id+'\', \''+data[i].group_id+'\')"><a class="dropdown-item"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp'+Messages("btnEdit")+'</a></li>' +
                '<li style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#deleteOrgConfirm" onclick="setdelGroupid(\''+data[i].id+'\')"><a class="dropdown-item"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp'+Messages("btnDelete")+'</a></li>' +
                '</ul>';
            var text = '<span onclick="selectGroup(\''+data[i].id+'\');" style="padding: 15px; font-size: 16px;">'+data[i].name+'</span>';
            var node = {
                id: data[i].id,
                parent: (data[i].org_id != "") ? data[i].org_id : projectId ,
                text: text + button
            };
            treeNodeArrayOrg.push(node);
            listIdNode.push(data[i].id);

            if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
                pushDataNodeChild(data[i].sub_orgs);
            }
        }
    }

    console.log(treeNodeArrayOrg);
}

function pushDataNodeChild(data) {
    console.log(data);
    for(var i=0; i<data.length; i++){
        var button = '<i class="bx bx-dots-vertical" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer; background-color: #B5B6B7; color: white; border-radius: 0px 4px 4px 0px; padding: 0px 2px 0px 2px;"></i>'+
            '<ul class="dropdown-menu dropdown-jstree">' +
            '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;" data-bs-toggle="modal" data-bs-target="#editOrgModal" onclick="setEditOrg(\''+data[i].id+'\', \''+data[i].group_id+'\')"><a class="dropdown-item"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp'+Messages("btnEdit")+'</a></li>' +
            '<li style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#deleteOrgConfirm" onclick="setdelGroupid(\''+data[i].id+'\')"><a class="dropdown-item"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp'+Messages("btnDelete")+'</a></li>' +
            '</ul>';
        var text = '<span onclick="selectGroup(\''+data[i].id+'\');" style="padding: 15px; font-size: 16px;">'+data[i].name+'</span>';
        var node = {
            id: data[i].id,
            parent: (data[i].org_id != "") ? data[i].org_id : projectId ,
            text: text + button
        };
        treeNodeArrayOrg.push(node);
        listIdNode.push(data[i].id);

        if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
            pushDataNodeChild(data[i].sub_orgs);
        }
    }
}

// function updateListOrg(id, parent, name, description) {
//     console.log(id, parent, name);
//     if(listIdNode.length > 1){
//         var button = '<i class="bx bx-grid-vertical" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer; background-color: red; color: white;"></i>'+
//             '<ul class="dropdown-menu dropdown-table jstreeClass">' +
//             '<li style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#editOrgModal" onclick="setEditOrg(\''+id+'\', \''+name+'\', \''+description+'\')"><a class="dropdown-item"><i class="bx bx-message-square-edit"></i> '+Messages("btnEdit")+'</a></li>' +
//             '<li style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#deleteOrgConfirm" onclick="setdelGroupid(\''+id+'\')"><a class="dropdown-item"><i class="bx bx-message-square-x"></i> '+Messages("btnDelete")+'</a></li>' +
//             '</ul>';
//         var text = '<span onclick="selectGroup(\''+id+'\');" style="margin-left: 5px; margin-right: 5px;">'+name+'</span>';
//
//         $('#jstree').jstree().create_node('#' ,  { "id" : id, "parent" : parent, "text" : text + button }, "last", function(){
//             console.log("done");
//         });
//     } else {
//         getListOrganizations();
//     }
// }

function focusSearchTree() {
    $("#search-selectOrg").focus();
}

//create
function showPopupAddOrg() {
    StartProcess();
    var formData = new FormData;
    formData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    formData.projectId = projectId;
    var r = jsRoutes.controllers.GroupListController.getListGroupOrganization();
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
                $("#chooseGroupOrgAdd").html(option);
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
function postDataCreateOrg() {
    var groupData = new FormData();
    // groupData.name = $('#nameOrgCreate').val();
    // groupData.description = $("#descriptionOrgCreate").val();
    // groupData.projectId = projectId;
    // groupData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    // groupData.groupId = ($("#chooseGroupOrgAdd").val() != null) ? $("#chooseGroupOrgAdd").val() : "";
    groupData.append("name", $('#nameOrgCreate').val());
    groupData.append("description", $('#descriptionOrgCreate').val());
    groupData.append("projectId", projectId);
    groupData.append("orgId", (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id);
    groupData.append("groupId", ($("#chooseGroupOrgAdd").val() != null) ? $("#chooseGroupOrgAdd").val() : "");
    groupData.append("avatar", $("#wizard-picture").prop("files")[0]);
    console.log(groupData);

    if($('#nameOrgCreate').val().length == 0){
        showNotification('danger',Messages("noti.valid.name"));
        $('#nameOrgCreate').focus();
        return;
    }
    if($('#descriptionOrgCreate').val().length == 0){
        showNotification('danger',Messages("Mô tả không được bỏ trống"));
        $('#descriptionProjectCreate').focus();
        return;
    }

    StartProcess();
    var r = jsRoutes.controllers.GroupController.addGroupRoot();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);

                listIdNode.push(data.content.id);
                // updateListOrg(data.content.id, "", data.content.name, data.content.description);
                getListOrganizations();
            }else{  //tra ve cau hinh truoc do
                viewGroupInfo(currentSelectedGroup);
                showNotification('danger',data.errorString, data.status);
                FinishProcess();
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            FinishProcess();
        },
        complete: function (jqXHR, textStatus) {
            // setTimeout(function () {
            //     FinishProcess(); //Stop display loading...
            // },500);
            // FinishProcess();
        }
    });
}

//del org
function setdelGroupid(id){
    if(currentSelectedGroup.id != id){
        selectGroup(id);
    }
    console.log(id);
    $('#delIdOrg').val(id);
}

function delOrgWithId() {
    var groupData = new FormData();
    groupData.id = $('#delIdOrg').val();

    StartProcess();
    var r = jsRoutes.controllers.GroupController.deleteGroup();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            if(data.success){
                showNotification('success',data.resultString);
                $("#jstree").jstree("delete_node","#"+groupData.id+"_anchor");

                listIdNode.splice(listIdNode.indexOf(groupData.id), 1);
                console.log(listIdNode);
                $("#"+ listIdNode[0] + "_anchor").click();
                selectGroup(listIdNode[0]);
            }else{
                showNotification('error',data.errorString, data.status);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('error',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });

}

//edit org
function setEditOrg(id, groupId) {
    if(currentSelectedGroup.id != id){
        selectGroup(id);
    }

    console.log(id, groupId);
    $("#editIdOrg").val(id);
    $("#textIdOrg").html(id + '&nbsp;&nbsp;<i class="bx bx-copy" style="cursor: pointer; color: green; font-size: 18px" onclick="copyIdOrg()" title="'+Messages("btnCopy")+'"></i>');

    var groupData = new FormData;
    groupData.orgId = (id != projectId) ? id : "";
    console.log(groupData);
    StartProcess();
    var url = jsRoutes.controllers.GroupController.getInfoOrg();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: url.url,
        type: url.type,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if (data.success && data.content != null) {
                $("#editNameOrg").val(data.content.name);
                $("#editDescriptionOrg").val(data.content.description);

                var img = imgOrgDefault;
                // var img = "http://localhost:9000/getImg/e21206c04e5d11ecbe19a08cfdd227ee-Screenshot.png";
                if(data.content.image != null && data.content.image.length>0){
                    img = hostname + "/getImg/" + data.content.image;

                    $("#imgOld").val(data.content.image);
                } else {
                    $("#imgOld").val("");
                }
                $('#wizardPicturePreviewEdit').attr('src', img);

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });


    var formData = new FormData;
    formData.orgId = currentSelectedGroup.id;
    formData.projectId = projectId;
    var r = jsRoutes.controllers.GroupListController.getListGroupOrganization();
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
                $("#chooseGroupOrgEdit").html(option);
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

    setTimeout(function () {
        $('#chooseGroupOrgEdit').val(groupId).trigger('change');
    },500);
}
function editOrg(){
    var groupData = new FormData();
    // groupData.projectId = projectId;
    // groupData.id = $('#editIdOrg').val();
    // groupData.name = $('#editNameOrg').val();
    // groupData.description = $('#editDescriptionOrg').val();
    groupData.append("id", $('#editIdOrg').val());
    groupData.append("name", $('#editNameOrg').val());
    groupData.append("description", $('#editDescriptionOrg').val());
    groupData.append("avatar", $("#wizard-picture-edit").prop("files")[0]);

    groupData.append("imgOld", $('#imgOld').val());
    if($("#wizard-picture-edit").prop("files")[0] != null){
        groupData.append("changeImg", true);
    } else {
        groupData.append("changeImg", false);
    }
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.GroupController.updateGroup();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                currentSelectedGroup.name = groupData.get("name");
                var button = '<i class="bx bx-dots-vertical" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer; background-color: #B5B6B7; color: white; border-radius: 0px 4px 4px 0px; padding: 0px 2px 0px 2px;"></i>'+
                    '<ul class="dropdown-menu dropdown-jstree">' +
                    '<li style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#editOrgModal" onclick="setEditOrg(\''+groupData.get("id")+'\', \''+groupData.get("group_id")+'\')"><a class="dropdown-item"><img src="'+iconEdit+'" width="14" alt=""/> '+Messages("btnEdit")+'</a></li>' +
                    '<li style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#deleteGroupconfirm" onclick="setdelGroupid(\''+groupData.get("id")+'\')"><a class="dropdown-item"><img src="'+iconDelete+'" width="14" alt=""/> '+Messages("btnDelete")+'</a></li>' +
                    '</ul>';
                var text = '<span onclick="selectGroup(\''+groupData.get("id")+'\');" style="padding: 15px; font-size: 16px;">'+groupData.get("name")+'</span>';
                if(document.getElementById(data.content.id+"_anchor") != null){
                    $("#"+data.content.id+"_anchor").html(text + button);
                }
                selectGroup(groupData.get("id"));
            }else{
                viewGroupInfo(currentSelectedGroup);
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

function copyIdOrg() {
    /* Get the text field */
    var copyText = document.getElementById("editIdOrg");

    /* Select the text field */
    copyText.select();
    copyText.setSelectionRange(0, 99999); /* For mobile devices */

    /* Copy the text inside the text field */
    navigator.clipboard.writeText(copyText.value);

    /* Alert the copied text */
    console.log("Copied the text: " + copyText.value);

    showNotification('success', Messages("btnCopySuccess"));
}

function copyToClipboard(element) {
    var $temp = $("<input>");
    $("body").append($temp);
    $temp.val($(element).text()).select();
    document.execCommand("copy");
    $temp.remove();
    showNotification('success', Messages("btnCopySuccess"));
}