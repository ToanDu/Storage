var count = 0;
var x = 0;
var y = 0;
var w = 4;
var h = 3;

var options = { // put in gridstack options here
    disableOneColumnMode: true, // for jfiddle small window size
    // float: false
};
var grid = GridStack.init(options);

function removeWidget(id) {
    console.log(id);
    $('.grid-stack-item[gs-id="'+id+'"]').remove();
}

var WIDGET = {
    MAP: {value: 1, name: "map"},
    TABLE: {value: 2, name: "table"},
    CHART_COLUMN: {value: 3, name: "chart"},
    CHART_LINE: {value: 4, name: "line"},
    GAUGE: {value: 5, name: "gauge"},
    ROUND_SWITCH: {value: 6, name: "round-switch"},
    DATA: {value: 7, name: "data"},
    COMMAND: {value: 8, name: "command"},
};
function chooseWidget() {
    if($("#selectWidget").val() == WIDGET.MAP.value){
        showWidgetMap();
    }
    else if($("#selectWidget").val() == WIDGET.CHART_COLUMN.value){
        showWidgetChartColumn();
    }
    else if($("#selectWidget").val() == WIDGET.CHART_LINE.value){
        showWidgetChartLine();
    }
    else if($("#selectWidget").val() == WIDGET.TABLE.value){
        showWidgetTable();
    }
    else if($("#selectWidget").val() == WIDGET.GAUGE.value){
        showWidgetGauge();
    }
    else if($("#selectWidget").val() == WIDGET.ROUND_SWITCH.value){
        showWidgetRoundSwitch();
    }
    else {
        $("#bodyWidget").html("");
    }
}

var sttWidget = 0;
function change_widget_action(el) {
    sttWidget = el.value;
    console.log(sttWidget);
}

function addNewWidget() {
    if(sttWidget == WIDGET.MAP.value){
        addWidgetMap();
        $("#addConfirmModal").modal('hide');
    }
    else if(sttWidget == WIDGET.CHART_COLUMN.value){
        addWidgetChartColumn();
        $("#addConfirmModal").modal('hide');
    }
    else if(sttWidget == WIDGET.CHART_LINE.value){
        addWidgetChartLine();
        $("#addConfirmModal").modal('hide');
    }
    else if(sttWidget == WIDGET.TABLE.value){
        addWidgetTable();
        $("#addConfirmModal").modal('hide');
    }
    else if(sttWidget == WIDGET.GAUGE.value){
        addWidgetGauge();
        $("#addConfirmModal").modal('hide');
    }
    else if(sttWidget == WIDGET.ROUND_SWITCH.value){
        addWidgetRoundSwitch();
        $("#addConfirmModal").modal('hide');
    } else if(sttWidget == WIDGET.DATA.value){
        addWidgetData();
        $("#addConfirmModal").modal('hide');
    } else if(sttWidget == WIDGET.COMMAND.value){
        addWidgetCommand();
        $("#addConfirmModal").modal('hide');
    } else {
        showNotification('danger', Messages("Bạn chưa chọn widget mới"));
    }

    // autoSaveWidget();
}

function removeWidget(wid){
    //grid.removeWidget(div);
    $('#idWidgetDelete').val(wid);
}

function processDeleteWidgetId(){
    var div = $(`[gs-id="${$('#idWidgetDelete').val()}"]`);
    grid.removeWidget(div[0]);

    // autoSaveWidget();
}

function getAllDevice(){
    var route = jsRoutes.controllers.DeviceIotController.getListDeviceIot();
    return new Promise(function(resolve, reject) {
        $.ajax({
            type: route.type,
            data: JSON.stringify(""),
            contentType: "application/json; charset=utf-8",
            url: route.url,
            success: function (data) {
                console.log(data);
                if (data.success) {
                    if (data.content != null && data.content.length > 0) {
                        resolve(data.content);
                    }
                    resolve([]);
                }
                else{
                    showNotification('danger', Messages(data.errorString));
                    resolve([]);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
                resolve([]);
            },
        });
    });
}

function getOrgs(id){
    var route = jsRoutes.controllers.GroupController.getListOrganizations(projectId);
    $.ajax({
        type: route.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#"+id).html("");
                var se = '<option selected disabled>Chọn</option>'+
                    '<option value="'+projectId+'">'+Messages("Dự án: ") + projectName+'</option>';
                $("#"+id).append(se);
                if(data.content.organizations != null && data.content.organizations.length>0){
                    for(var i = 0; i < data.content.organizations.length; i++){
                        var op = '<option value="'+data.content.organizations[i].id+'">'+data.content.organizations[i].name+'</option>';
                        $("#"+id).append(op);

                        if(data.content.organizations[i].sub_orgs != null && data.content.organizations[i].sub_orgs.length > 0){
                            appendOptionOrg(data.content.organizations[i].sub_orgs, id);
                        }
                    }
                    $("#"+id).val(filterValue).change();
                }
            }
            // else{
            //     showNotification('danger', Messages("connection.failed"));
            // }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
    });
}
function appendOptionOrg(data, id) {
    for(var i = 0; i < data.length; i++){
        var op = '<option value="'+data[i].id+'">'+data[i].name+'</option>';
        $("#"+id).append(op);

        if(data[i].sub_orgs != null && data[i].sub_orgs.length > 0){
            appendOptionOrg(data[i].sub_orgs, id);
        }
    }
}

function getDevicesByOrg(orgId){
    console.log(orgId);
    var route = jsRoutes.controllers.DeviceIotController.getListDeviceAndAttrByOrg(orgId, projectId);
    return new Promise(function(resolve, reject) {
        $.ajax({
            type: route.type,
            data: JSON.stringify(""),
            contentType: "application/json; charset=utf-8",
            url: route.url,
            success: function (data) {
                console.log(data);
                if (data.success) {
                    if (data.content != null && data.content.length > 0) {
                        resolve(data.content);
                    }
                    resolve([]);
                }
                else{
                    showNotification('danger', Messages("connection.failed"));
                    resolve([]);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
                resolve([]);
            },
        });
    });
}


function getGroups(callback){
    var route = jsRoutes.controllers.GroupListController.getListGroups();
    $.ajax({
        type: route.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.length>0){
                    callback(data.content);
                }
            }
            // else{
            //     showNotification('danger', Messages("connection.failed"));
            // }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
    });
}

function getDevicesByGroup(groupid){
    var route = jsRoutes.controllers.DeviceIotController.getListDeviceByGroup(groupid);
    return new Promise(function (resolve, reject){
        $.ajax({
            type: route.type,
            data: JSON.stringify(""),
            contentType: "application/json; charset=utf-8",
            url: route.url,
            success: function (data) {
                //console.log(data);
                if(data.success){
                    if(data.content != null && data.content.length>0){
                        resolve(data.content);
                    }
                    resolve([]);
                }
                else{
                    showNotification('danger', Messages("connection.failed"));
                    resolve([]);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
                resolve([]);
            },
        });
    });
}

function getVarsByDevice(deviceid){
    var route = jsRoutes.controllers.DeviceIotController.getListDeviceVarsByDevice(deviceid);
    return new Promise(function (resolve, reject) {
        $.ajax({
            type: route.type,
            data: JSON.stringify(""),
            contentType: "application/json; charset=utf-8",
            url: route.url,
            success: function (data) {
                //console.log(data);
                if (data.success) {
                    if (data.content != null && data.content.length > 0) {
                        resolve(data.content);
                    }
                    resolve([]);
                }
                else{
                    showNotification('danger', Messages("connection.failed"));
                    resolve([]);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
                resolve([]);
            },
        });
    });
}


function getDTs(callback){
    var route = jsRoutes.controllers.DeviceTypeController.getListTypes();
    $.ajax({
        type: route.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content != null && data.content.length>0){
                    callback(data.content);
                }
            }
            else{
                showNotification('danger', Messages("connection.failed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
    });
}

function getDevicesByDT(deviceTypeId){
    var route = jsRoutes.controllers.DeviceIotController.getListDeviceByDeviceType(deviceTypeId);
    return new Promise(function (resolve, reject){
        $.ajax({
            type: route.type,
            data: JSON.stringify(""),
            contentType: "application/json; charset=utf-8",
            url: route.url,
            success: function (data) {
                //console.log(data);
                if(data.success){
                    if(data.content != null && data.content.length>0){
                        resolve(data.content);
                    }
                    resolve([]);
                }
                else
                {
                    showNotification('danger', Messages("connection.failed"));
                    resolve([]);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger', Messages("connection.failed"));
                resolve([]);
            },
        });
    });
}
