/**
 * Created by vtk-anhlt166 on 4/8/21.
 */
var treeNodeArrayOrgMove = [];
var listIdNodeMove = [];
function getGroupListMove(el) {
    if(el == 0){ //move user
        document.getElementById("buttonMoveUser").style.display = "block";
        document.getElementById("buttonMoveDevice").style.display = "none";
    } else if(el == 1){ // move device
        document.getElementById("buttonMoveUser").style.display = "none";
        document.getElementById("buttonMoveDevice").style.display = "block";
    }
    $("#tabListOrgMove").html("");
    treeNodeArrayOrgMove = [];
    listIdNodeMove = [];

    var getGroup = jsRoutes.controllers.GroupController.getListOrganizations(projectId);
    $.ajax({
        type: getGroup.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: getGroup.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.success && data.content.organizations != null){
                    $("#tabListOrgMove").html('<div id="jstreeMove"></div>');
                    pushDataTreeNodeOrgMove(data.content.organizations);

                    console.log(treeNodeArrayOrgMove);
                    $('#jstreeMove').jstree({
                        core: {
                            data: treeNodeArrayOrgMove,
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
                    $('#jstreeMove').jstree();
                    $('#jstreeMove').on('loaded.jstree', function() {
                        //open tat ca cac node
                        $('#jstreeMove').jstree('open_all');

                        //select default
                        if(listIdNodeMove.length > 0){
                            $('#jstreeMove').jstree('select_node', treeNodeArrayOrgMove[0]);
                            setIdOrdMove(treeNodeArrayOrgMove[0].id);
                        }
                    });
                    $('button').on('click', function () {
                        $('#jstreeMove').jstree(true).select_node('child_node_1');
                        $('#jstreeMove').jstree('select_node', 'child_node_1');
                        $.jstree.reference('#jstreeMove').select_node('child_node_1');
                    });
                    $("#search-selectOrgMove").keyup(function () {
                        var searchString = $(this).val();
                        $('#jstreeMove').jstree('search', searchString);
                    });
                }
            } else {
                showNotification('error',data.resultString);
            }

        }
    });
}
function pushDataTreeNodeOrgMove(data) {
    var listProject = JSON.parse(localStorage.listProject);
    var nameProjectDefault = "";
    for(var k=0; k<listProject.length; k++){
        if(listProject[k].id == projectId){
            nameProjectDefault = listProject[k].name;
            break;
        }
    }

    nameProject = nameProjectDefault;

    var textDefault = '<span onclick="setIdOrdMove(\''+projectId+'\');" style="padding: 15px; font-size: 16px;">'+Messages("Dự án: ")+nameProjectDefault+'</span>';
    var nodeDefault = {
        id: projectId,
        parent: "#",
        text: textDefault
    };
    treeNodeArrayOrgMove.push(nodeDefault);
    listIdNodeMove.push(projectId);

    if(data.length > 0){
        for(var i =0 ; i<data.length; i++){
            var text = '<span onclick="setIdOrdMove(\''+data[i].id+'\');" style="padding: 15px; font-size: 16px;">'+data[i].name+'</span>';
            var node = {
                id: data[i].id,
                parent: (data[i].org_id != "") ? data[i].org_id : projectId ,
                text: text
            };
            treeNodeArrayOrgMove.push(node);
            listIdNodeMove.push(data[i].id);

            if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
                pushDataNodeChildMove(data[i].sub_orgs);
            }
        }
    }

    console.log(treeNodeArrayOrgMove);
}
function pushDataNodeChildMove(data) {
    console.log(data);
    for(var i=0; i<data.length; i++){
        var text = '<span onclick="setIdOrdMove(\''+data[i].id+'\');" style="padding: 15px; font-size: 16px;">'+data[i].name+'</span>';
        var node = {
            id: data[i].id,
            parent: (data[i].org_id != "") ? data[i].org_id : projectId ,
            text: text
        };
        treeNodeArrayOrgMove.push(node);
        listIdNodeMove.push(data[i].id);

        if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
            pushDataNodeChildMove(data[i].sub_orgs);
        }
    }
}

function setIdOrdMove(id) {
    $("#groupIdMove").val(id);
}

function DataMove() {
    this.listUser="";
    this.listDevice="";
    this.groupIdNew="";
}
function processMoveUser() {
    var dataMove = new DataMove();
    dataMove.groupIdNew = $("#groupIdMove").val();
    if(dataMove.groupIdNew == "" || dataMove.groupIdNew == null || dataMove.groupIdNew == undefined){
        showNotification('error',Messages("noti.chooseGroupIdNew"));
        return;
    }
    if(listIdUserAction.length > 0){
        for(var i=0 ; i<listIdUserAction.length; i++){
            dataMove.listUser += listIdUserAction[i]+",";
        }
    }
    console.log(dataMove);

    var r = jsRoutes.controllers.GroupController.processMoveUserToGroupOther();
    $.ajax({
        type: r.type,
        data: JSON.stringify(dataMove),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                selectGroup(currentSelectedGroup.id);
                // $("#move-tree-view").modal('hide');
            } else {
                showNotification('error',data.resultString);
            }
        }
    });
}

function processMoveDevice() {
    var dataMove = new FormData();
    dataMove.orgId = $("#groupIdMove").val() == projectId ? "" : $("#groupIdMove").val();
    dataMove.deviceId = $("#idMove").val();
    dataMove.projectId = projectId;
    console.log(dataMove);

    var r = jsRoutes.controllers.GroupController.processMoveDeviceToGroupOther();
    $.ajax({
        type: r.type,
        data: JSON.stringify(dataMove),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                $("#move-tree-view").modal('hide');
                selectGroup(currentSelectedGroup.id);
            } else {
                showNotification('error',data.errorString);
            }
        }
    });
}