/**
 * Created by vtk-anhlt166 on 2/8/22.
 */
$(document).ready(function () {
    var getGroup = jsRoutes.controllers.GroupController.getListOrganizations(projectId);
    $.ajax({
        type: getGroup.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: getGroup.url,
        success: function (data) {
            console.log(data);
            if(data.success && data.content.organizations != null){
                renderChartOrg(data.content.organizations);
            } else {
                showNotification('error',data.errorString);
            }
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
});

var nameProject = "";
function renderChartOrg(data) {
    var listProject = JSON.parse(localStorage.listProject);
    var nameProjectDefault = "";
    for(var k=0; k<listProject.length; k++){
        if(listProject[k].id == projectId){
            nameProjectDefault = listProject[k].name;
            break;
        }
    }
    nameProject = nameProjectDefault;
    console.log(nameProject);

    var children = [];
    if(data.length > 0){
        for(var i=0; i< data.length; i++){
            var arrChild = [];
            if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
                arrChild = renderSubOrg(data[i].sub_orgs);
            }
            var chil = {
                'name': '<img src="'+iconOrg+'" style="margin-right: 15px;" width="" alt=""/>'+Messages("orginazation"),
                'title': data[i].name,
                'className': 'middle-level',
                'children': arrChild
            };

            children.push(chil);
        }
    }
    console.log(children);
    var datascource = {
        'name': '<img src="'+iconOrg+'" style="margin-right: 15px;" width="" alt=""/>'+Messages("project"),
        'title': nameProject,
        'children': children
    };

    $('#chart-container').orgchart({
        'data' : datascource,
        'nodeContent': 'title'
    });
}

function renderSubOrg(subOrg) {
    var subOrgList = [];
    for(var i=0; i<subOrg.length; i++){
        var chil = {
            'name':  subOrg[i].name,
            'title': subOrg[i].id,
            'className': 'product-dept',
            'children': ((subOrg[i].sub_orgs != null && subOrg[i].sub_orgs.length > 0) ? renderSubOrg(subOrg[i].sub_orgs) : [])
        };
        subOrgList.push(chil);
    }

    return subOrgList;
}