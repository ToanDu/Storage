/**
 * Created by vtk-anhlt166 on 1/5/22.
 */
$(document).ready(function () {
    getDashboardList();

    getListOrganizations();
});

function getDashboardList() {
    var groupData = new FormData;
    groupData.projectId = projectId;

    StartProcess();
    var r = jsRoutes.controllers.DashboardV3Controller.getListDashboard();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if (data.success && data.content != null) {
                viewDashboardListToTable(data.content);
            } else {
                showNotification('error', Messages("noti.Getfalse"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}

function viewDashboardListToTable(dbs) {
    console.log(dbs);

    var mtmlAttr =
        "<table id='smlDashboardTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("ID")+"</th>" +
        "<th>"+Messages("filter.name")+"</th>" +
        "<th>"+Messages("Tổ chức")+"</th>" +
        "<th>"+Messages("filter.logDate")+"</th>" +
        "<th></th>" +
        "</thead>" +
        "<tbody>";

    if (dbs != null && dbs.length > 0) {
        for (var i = 0; i < dbs.length; i++) {
            mtmlAttr += "<tr>";
            mtmlAttr += "<td></td>";
            mtmlAttr += "<td>"+'<a onclick="remotePageDetailDashboard(\''+dbs[i].id+'\')" style="cursor: pointer; color: #ec1b2e">'+dbs[i].id+"</a>"+"</td>";
            mtmlAttr += "<td>"+dbs[i].name+"</td>";
            mtmlAttr += "<td>"+(dbs[i].orgName != null ? dbs[i].orgName : "")+"</td>";
            var logDate = moment.unix(dbs[i].logDate/1000).format("YYYY/MM/DD HH:mm");
            mtmlAttr += "<td>"+logDate+"</td>";
            mtmlAttr += "<td align='center'>";
            mtmlAttr += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlAttr += '<ul class="dropdown-menu dropdown-table">';
            mtmlAttr += '<li style="cursor: pointer;border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="chooseOrgForDashboard(\''+dbs[i].id+'\', \''+dbs[i].orgId+'\', \''+dbs[i].orgName+'\')"><img src="'+iconEdit+'" alt=""/>&nbsp&nbsp '+Messages("Gán tổ chức")+'</a></li>';
            mtmlAttr += '<li style="cursor: pointer;border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageDetailDashboard(\''+dbs[i].id+'\')"><img src="'+iconInfo+'" alt=""/>&nbsp&nbsp '+Messages("btnDetail")+'</a></li>';
            mtmlAttr += '<li style="cursor: pointer;border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditDashboard(\''+dbs[i].id+'\', \''+dbs[i].name+'\', \''+dbs[i].content+'\')"><img src="'+iconEdit+'" alt=""/>&nbsp&nbsp '+Messages("dashboard.edit")+'</a></li>';
            mtmlAttr += '<li style="cursor: pointer;border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageDashboardApp(\''+dbs[i].id+'\', \''+dbs[i].token+'\')"><img src="'+iconInfo+'" alt=""/>&nbsp&nbsp '+Messages("View App")+'</a></li>';
            mtmlAttr += '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelDashboard(\''+dbs[i].id+'\')"><img src="'+iconDelete+'" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>';
            mtmlAttr += '</ul>';
            mtmlAttr +="</td>";
            mtmlAttr += "</tr>";
        }
    }
    mtmlAttr += "</tbody></table>";
    $("#listDashboard").html(mtmlAttr);

    var table = $('#smlDashboardTable').DataTable( {
        responsive: true,
        lengthChange: false,
        "order": [],
        "info": false,
        "columnDefs": [ {
            "targets": 4,
            "orderable": false
        } ],
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'addNewRecord' );
                    showAddDashboard();
                }
            }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlDashboardTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function remotePageDashboardApp(id, token) {
    // window.location.href = jsRoutes.controllers.DashboardV3Controller.appDashboard(projectId, id, token).url;
    window.open(jsRoutes.controllers.DashboardAppController.appDashboard(projectId, id, token).url, '_blank');
}

function remotePageDetailDashboard(id) {
    // window.location.href = jsRoutes.controllers.DashboardV3Controller.dashboard(projectId, id).url;
    window.open(jsRoutes.controllers.DashboardV3Controller.dashboard(projectId, id).url, '_blank');
}

//create
function showAddDashboard() {
    $("#addDashboardModal").modal('show');
}

function processAddDashboard() {
    if($("#nameDashboardAdd").val().length == 0){
        showNotification('danger',Messages("noti.valid.name"));
        $('#nameDashboardAdd').focus();
        return;
    }
    if($("#contentDashboardAdd").val().length == 0){
        showNotification('danger',Messages("noti.valid.content"));
        $('#contentDashboardAdd').focus();
        return;
    }

    var formData = new FormData;
    formData.projectId = projectId;
    formData.name = $("#nameDashboardAdd").val();
    formData.content = $("#contentDashboardAdd").val();
    console.log(formData);

    $("#addDashboardModal").modal('hide');

    StartProcess();
    var r = jsRoutes.controllers.DashboardV3Controller.addNewDashboard();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getDashboardList();
                showNotification('success',data.resultString);
            } else {
                showNotification('error',data.errorString, data.status);
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
function setDelDashboard(id) {
    console.log(id);
    $("#idDashboardDel").val(id);

    $("#deleteDashboardConfirm").modal('show');
}
function processDelDashboard() {
    var groupData = new FormData();
    groupData.id = $("#idDashboardDel").val();

    StartProcess();
    var r = jsRoutes.controllers.DashboardV3Controller.deleteDashboard();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            if(data.success){
                getDashboardList();

                showNotification('success',data.resultString);
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

//edit
function setEditDashboard(id, name, content) {
    $("#idDashboardEdit").val(id);
    $("#nameDashboardEdit").val(name);
    $("#contentDashboardEdit").val(content);

    $("#editDashboardModal").modal('show');
}
function processEditDashboard() {
    if($("#nameDashboardEdit").val().length == 0){
        showNotification('danger',Messages("noti.valid.name"));
        $('#nameDashboardEdit').focus();
        return;
    }
    if($("#contentDashboardEdit").val().length == 0){
        showNotification('danger',Messages("noti.valid.content"));
        $('#contentDashboardEdit').focus();
        return;
    }

    var formData = new FormData;
    formData.id = $("#idDashboardEdit").val();;
    formData.name = $("#nameDashboardEdit").val();
    formData.content = $("#contentDashboardEdit").val();
    console.log(formData);

    $("#editDashboardModal").modal('hide');

    StartProcess();
    var r = jsRoutes.controllers.DashboardV3Controller.editContentDashboard();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getDashboardList();
                showNotification('success',data.resultString);
            } else {
                showNotification('error',data.errorString);
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

var treeNodeArrayOrg = [];
var listIdNode = [];
function getListOrganizations() {
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
                    // if(listIdNode.length > 0){
                    //     $('#jstree').jstree('select_node', treeNodeArrayOrg[0]);
                    //     selectGroup(treeNodeArrayOrg[0].id);
                    // }
                });
                $('button').on('click', function () {
                    $('#jstree').jstree(true).select_node('child_node_1');
                    $('#jstree').jstree('select_node', 'child_node_1');
                    $.jstree.reference('#jstree').select_node('child_node_1');
                });
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
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

    var textDefault = '<span onclick="chosseOrg(\''+""+'\', \''+""+'\')" style="padding: 15px; font-size: 16px;">'+Messages("Dự án: ")+nameProjectDefault+'</span>';
    var nodeDefault = {
        id: projectId,
        parent: "#",
        text: textDefault
    };
    treeNodeArrayOrg.push(nodeDefault);
    listIdNode.push(projectId);

    if(data.length > 0){
        for(var i =0 ; i<data.length; i++){
            var text = '<span onclick="chosseOrg(\''+data[i].id+'\', \''+data[i].name+'\');" style="padding: 15px; font-size: 16px;">'+data[i].name+'</span>';
            var node = {
                id: data[i].id,
                parent: (data[i].org_id != "") ? data[i].org_id : projectId ,
                text: text
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
        var text = '<span onclick="chosseOrg(\''+data[i].id+'\', \''+data[i].name+'\');" style="padding: 15px; font-size: 16px;">'+data[i].name+'</span>';
        var node = {
            id: data[i].id,
            parent: (data[i].org_id != "") ? data[i].org_id : projectId ,
            text: text
        };
        treeNodeArrayOrg.push(node);
        listIdNode.push(data[i].id);

        if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
            pushDataNodeChild(data[i].sub_orgs);
        }
    }
}

function chooseOrgForDashboard(id, orgId, orgName) {
    console.log(id, orgId);
    $("#move-tree-view").modal('show');
    $("#idDashboard").val(id);
    $("#orgIdMove").val(orgId != null ? orgId : "");
    $("#orgNameMove").val(orgName != null ? orgName : "");

    if(orgId != null && orgId != ""){
        $('#jstree').jstree('select_node', orgId);
    } else {
        $('#jstree').jstree('select_node', projectId);
    }
}

function chosseOrg(orgId, orgName) {
    console.log(orgId);
    $("#orgIdMove").val(orgId);
    $("#orgNameMove").val(orgName);
}

function processMoveDashboardToOrg() {
    var dataForm = new FormData;
    dataForm.idOrg = $("#orgIdMove").val();
    dataForm.nameOrg = $("#orgNameMove").val();
    dataForm.dashboardId = $("#idDashboard").val();

    StartProcess();
    var r = jsRoutes.controllers.DashboardV3Controller.moveDashboardToOrg();
    $.ajax({
        type: r.type,
        data: JSON.stringify(dataForm),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getDashboardList();
                showNotification('success',data.resultString);
            } else {
                showNotification('danger',data.errorString);
            }
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}