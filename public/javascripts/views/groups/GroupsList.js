
//DEL
function deleteGroupId(id) {
    $("#idGroupDelete").val(id);
}
function processDeleteGroupId() {
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
function editGroupName(id, name) {
    $("#idGroupEdit").val(id);
    $("#nameGroupEdit").val(name);
}
function postEditNameGroup() {
    var Data = new FormData();
    Data.id = $('#idGroupEdit').val();
    Data.name = $('#nameGroupEdit').val();
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
var treeNodeArray = [];
function setIdGroupUpdate(id, orgId) {
    console.log(orgId);
    $("#idGroupUpdate").val(id);
    // $("#search-selectOrg").val("...Search Organizations")
    if(orgId != null && orgId != ""){
        $("#"+orgId+"_anchor").click();
    } else {
        $('#selectOrganizations').jstree("deselect_all");
    }
}
function getOrgList() {
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
                    pushDataTreeNode(data.content);

                    $('#selectOrganizations').jstree({
                        core: {
                            data: treeNodeArray,
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
                showNotification('error',data.resultString);
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}
function pushDataTreeNode(data) {
    for(var i =0 ; i<data.length; i++){
        var node = {
            id: data[i].id,
            parent: data[i].parent,
            text: data[i].name
        };
        treeNodeArray.push(node);
    }
    console.log(treeNodeArray);
}
function selectOrg(data) {
    console.log(data[0]);
    $("#orgIdMove").val(data[0]);
}
function postUpdateOrgIdForGroup() {
    var Data = new FormData();
    Data.id = $('#idGroupUpdate').val();
    Data.idOrg = $('#orgIdMove').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.GroupListController.updateOrgIdForGroups();
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