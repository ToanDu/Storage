/**
 * Created by vtk-anhlt166 on 6/10/21.
 */
var treeNodeArrayOrg = [];
function getAddListOrganization() {
    StartProcess();
    treeNodeArrayOrg = [];
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

                    $('#selectOrganizationsAdd').jstree({
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
                    $('#selectOrganizationsAdd').jstree();
                    $('#selectOrganizationsAdd').on("changed.jstree", function (e, data) {
                        selectOrgAdd(data.selected);
                    });
                    $('#selectOrganizationsAdd').on('loaded.jstree', function() {
                        //open tat ca cac node
                        $('#selectOrganizationsAdd').jstree('open_all');
                    });
                    $('button').on('click', function () {
                        $('#selectOrganizationsAdd').jstree(true).select_node('child_node_1');
                        $('#selectOrganizationsAdd').jstree('select_node', 'child_node_1');
                        $.jstree.reference('#selectOrganizationsAdd').select_node('child_node_1');
                    });
                    $('#selectOrganizationsAdd').on("search.jstree", function (nodes, str, res){
                        if(str.nodes.length===0){
                            $('#selectOrganizationsAdd').jstree(true).hide_all();
                        };
                    })
                    $("#search-selectOrgAdd").keyup(function () {
                        var searchString = $(this).val();
                        $('#selectOrganizationsAdd').jstree(true).show_all();
                        $('#selectOrganizationsAdd').jstree('search', searchString);
                    });
                }
            } else {
                showNotification('error',data.resultString);
            }
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
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
function selectOrgAdd(data) {
    console.log(data[0]);
    $("#orgIdMoveAdd").val(data[0]);
}

function postDataCreateUser() {
    var Data = new FormData();
    Data.email = $('#emailUserAdd').val();
    Data.orgId = $('#orgIdMoveAdd').val();
    Data.password = $('#inputCreateNewPassword').val();
    Data.rePassword = $('#inputCreateNewRePassword').val();
    console.log(Data);

    if(Data.orgId == "" || Data.orgId == null || Data.orgId == undefined){
        showNotification('danger', Messages("manage.deviceIot.chooseOrg"));
        return;
    }

    StartProcess();
    var r = jsRoutes.controllers.UserController.addNewUser();
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
            setTimeout(function () {
                window.location.reload();
            },1000);
        }
    });
}

function showPassword1() {
    console.log("showPassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHidePass").attr("onclick","hidePassword1()");
    document.getElementById("inputCreateNewPassword").type = "text";
}

function hidePassword1() {
    console.log("hidePassword");
    document.getElementById("iconHidePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHidePass").attr("onclick","showPassword1()");
    document.getElementById("inputCreateNewPassword").type = "password";
}

function showRePassword1() {
    console.log("showRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-show'></i>";
    $("#iconHideRePass").attr("onclick","hideRePassword1()");
    document.getElementById("inputCreateNewRePassword").type = "text";
}

function hideRePassword1() {
    console.log("hideRePassword");
    document.getElementById("iconHideRePass").innerHTML = "<i class='bx bx-hide'></i>";
    $("#iconHideRePass").attr("onclick","showRePassword1()");
    document.getElementById("inputCreateNewRePassword").type = "password";
}