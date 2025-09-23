/**
 * Created by vtk-anhlt166 on 4/7/21.
 */
var listIdDevice=new Array();
var listNameDevice=new Array();
var listDevices = new Array();
function searchDevices(searchStr){
    newLDevices = new Array()
    for (var i = 0; i < listDevices.length; i++) {
        if(listDevices[i].name.includes(searchStr)){
            newLDevices.push(listDevices[i])
        }
    }

    viewDeviceToTable(newLDevices);
}
function viewDeviceToTable(data) {
    $("#totalDevice").html(Messages("Tổng: ") + data.total + Messages(" thiết bị"));
    $("#tabDevice").empty();

    listIdDevice = [];
    listNameDevice = [];

    var mtmlDevice = "<table id='smlDevicesTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th scope='col'>"+Messages("manage.stt")+"</th>" +
        "<th scope='col'>" + Messages("manage.deviceIot.deviceName") + "</th>" +
        "<th scope='col'>" + Messages("manage.deviceIot.groupName") + "</th>" +
        "<th scope='col'>" + Messages("manage.deviceIot.template") + "</th>" +
        "<th scope='col' hidden>"+Messages("manage.deviceIot.id")+"</th>" +
        "<th scope='col' hidden>"+Messages("manage.deviceIot.token")+"</th>" +
        "<th scope='col'></th>" +
        "</thead>" +
        "<tbody align=\"left\">";

    var lDevices = data.devices;
    if (lDevices!=null && lDevices.length > 0) {
        var stt=0;
        for (var i = 0; i < lDevices.length; i++) {
            stt++;
            listIdDevice.push(lDevices[i].id);
            listNameDevice.push(lDevices[i].name);

            mtmlDevice += "<tr>";
            mtmlDevice += "<th scope='row'>"+(data.offset + i+1)+"</th>";
            mtmlDevice += "<td>" + lDevices[i].name + "</td>";
            mtmlDevice += "<td>" + lDevices[i].group_name + "</td>";
            mtmlDevice += "<td>" + lDevices[i].template_name + "</td>";
            mtmlDevice += "<td align='center'>" ;
            mtmlDevice += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlDevice +=
                '<ul class="dropdown-menu dropdown-table">' +
                // '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageVariable(\''+lDevices[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDetail")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="copyIdDevice(\''+lDevices[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Copy ID")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="copyTokenDevice(\''+lDevices[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Copy Token Device")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageAttribute(\''+lDevices[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnAttr")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditDeviceInOrg(\''+lDevices[i].id+'\', \''+lDevices[i].name+'\', \''+lDevices[i].group_id+'\', \''+lDevices[i].template_id+'\')"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnEdit")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setMoveDeviceToOrg(\''+lDevices[i].id+'\')"><img src="'+iconGroup+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Chuyển thiết bị")+'</a></li>' +
                '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelDeviceInOrg(\''+lDevices[i].id+'\')"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>' +
                '</ul>';
            mtmlDevice +="</td>";
            mtmlDevice += "<td hidden><p id='device_"+lDevices[i].id+"'>" + lDevices[i].id + "</p></td>";
            mtmlDevice += "<td hidden><p id='device_token_"+lDevices[i].id+"'>" + lDevices[i].token + "</p></td>";
            mtmlDevice += "</tr>";
        }
    }
    mtmlDevice += "</tbody></table>";
    $("#tabDevice").html(mtmlDevice);

    var table = $('#smlDevicesTable').DataTable( {
        lengthChange: false,
        "info": false,
        bSort: false,
        "order": false,
        "paging" : false,
        responsive: true,
        buttons: [
            {
                text: Messages("Tạo thiết bị"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showPopupAddDevice' );
                    showPopupAddDevice();
                }
            }
        ]
    } );
    table.buttons().container()
        .appendTo( '#smlDevicesTable_wrapper .col-md-6:eq(0)' );

    pagingTable(data.total, Math.round(data.offset/data.limit+1), data.limit);
}

function showPopupAddDevice() {
    $("#groupadddevice").modal('show');

    StartProcess();
    var formData = new FormData;
    formData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    formData.projectId = projectId;
    var r = jsRoutes.controllers.GroupListController.getListGroupDevice();
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
                $("#chooseGroupDeviceAdd").html(option);
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

    var url = jsRoutes.controllers.DeviceTemplateController.getListDeviceTemplate();
    $.ajax({
        type: url.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: url.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var option = '<option value="" selected disabled>'+Messages("manage.group.templateDevice")+'</option>';
                if(data.content != null){
                    if(data.content.templates != null && data.content.templates.length > 0){
                        for(var i=0; i<data.content.templates.length; i++){
                            option +=
                                '<option value="'+data.content.templates[i].id+'">'+data.content.templates[i].name+'</option>';
                        }
                    }
                }
                $("#chooseTemplateDeviceAdd").html(option);
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
function processCreateDeviceToOrg() {
    var groupData = new FormData();
    groupData.name = $('#nameDeviceAdd').val();
    groupData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    groupData.projectId = projectId;
    groupData.groupId = ($('#chooseGroupDeviceAdd').val() != null) ? $('#chooseGroupDeviceAdd').val() : "";
    groupData.templateId = ($("#chooseTemplateDeviceAdd").val() != null) ? $("#chooseTemplateDeviceAdd").val() : "";
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.addNewDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',Messages("manage.deviceIot.successCreate"));
                selectUpdateGroup(currentSelectedGroup.id);
            }else {
                showNotification('danger', data.errorString);
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

function remotePageVariable(id) {
    window.location.href = jsRoutes.controllers.DeviceVariableController.deviceVariable(projectId, id).url;
}

function remotePageAttribute(id) {
    // window.location.href = jsRoutes.controllers.AttributeController.attributeDevice(projectId, id).url;
    window.open(jsRoutes.controllers.AttributeController.attributeDevice(projectId, id).url, "_blank");
}

function copyIdDevice(id) {
    copyToClipboard("#device_"+id);
}

function copyTokenDevice(id) {
    copyToClipboard("#device_token_"+id);
}

//delete device
function setDelDeviceInOrg(id) {
    console.log(id);
    $('#idDeviceDelete').val(id);
    $("#deleteDevicesconfirm").modal('show');
}

function postDataDelDeviceInOrg() {
    var Data = new FormData();
    Data.id = $('#idDeviceDelete').val();
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.deleteDevice();
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



//edit device
function setEditDeviceInOrg(id, name, groupId, templateId) {
    console.log(id, name, groupId, templateId);
    $("#idDeviceEdit").val(id);
    $("#nameDeviceEdit").val(name);

    StartProcess();
    var formData = new FormData;
    formData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    formData.projectId = projectId;
    var r = jsRoutes.controllers.GroupListController.getListGroupDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var option = '<option value="" disabled>'+Messages("manage.group.tructhuoc")+'</option>';
                if(data.content != null){
                    if(data.content.groups != null && data.content.groups.length > 0){
                        for(var i=0; i<data.content.groups.length; i++){
                            option +=
                                '<option value="'+data.content.groups[i].id+'">'+data.content.groups[i].name+'</option>';
                        }
                    }
                }
                setTimeout(function () {
                    $("#chooseGroupDeviceEdit").html(option);
                },500);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
            var url = jsRoutes.controllers.DeviceTemplateController.getListDeviceTemplate();
            $.ajax({
                type: url.type,
                dataType: 'json',
                data: JSON.stringify(formData),
                contentType: "application/json; charset=utf-8",
                url: url.url,
                success: function (data) {
                    console.log(data);
                    if(data.success){
                        var option = '<option value="" disabled>'+Messages("manage.group.templateDevice")+'</option>';
                        if(data.content != null){
                            if(data.content.templates != null && data.content.templates.length > 0){
                                for(var i=0; i<data.content.templates.length; i++){
                                    option +=
                                        '<option value="'+data.content.templates[i].id+'">'+data.content.templates[i].name+'</option>';
                                }
                            }
                        }
                        setTimeout(function () {
                            $("#chooseTemplateDeviceEdit").html(option);
                        },500);
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
    });



    $("#editDeviceModal").modal('show');

    setTimeout(function () {
        $('#chooseGroupDeviceEdit').val(groupId).trigger('change');
        $('#chooseTemplateDeviceEdit').val(templateId).trigger('change');
    },1000);

}
function processEditDeviceInOrg() {
    var groupData = new FormData();
    groupData.id = $('#idDeviceEdit').val();
    groupData.name = $('#nameDeviceEdit').val();
    groupData.groupId = ($('#chooseGroupDeviceEdit').val() != null) ? $('#chooseGroupDeviceEdit').val() : "";
    groupData.templateId = ($("#chooseTemplateDeviceEdit").val() != null) ? $("#chooseTemplateDeviceEdit").val() : "";
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.editNameDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success', data.resultString);
                selectUpdateGroup(currentSelectedGroup.id);
            }else {
                showNotification('danger', data.errorString);
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

//chuyen thiet bi
function setMoveDeviceToOrg(id) {
    $("#move-tree-view").modal('show');
    $("#idMove").val(id);
    getGroupListMove(1);
}