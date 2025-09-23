var listSerial = new Array;
var listSubs = new Array;
function showModalCreateDevice() {
    listSerial = [];
    listSubs = [];
    var listSub = document.getElementsByClassName("check-sub");
    for(var i=0 ; i<listSub.length; i++){
        if(listSub[i].checked){
            listSerial.push(listSub[i].value);
            listSubs[listSub[i].value] = listSub[i].getAttribute("sub");
        }
    }
    console.log(listSerial);
    console.log(listSubs);

    if(listSerial.length > 0){
        $("#projectModal").modal('show');
        getListProject();
    } else {
        showNotification('danger',Messages("Bạn chưa chọn thuê bao"));
        return;
    }
}

function createOneDevice(isdn, serial) {
    listSerial = [];
    listSubs = [];
    listSerial.push(serial);
    listSubs[serial] = isdn;

    $("#projectModal").modal('show');
    getListProject();
}

function getListProject() {
    StartProcess();
    var r = jsRoutes.controllers.ProjectController.getProject();
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas, "getListProject");
            if(datas.content != null){
                var listProject = "<option value=''>"+Messages("---Chọn project---")+"</option>";
                if(datas.content.projects != null && datas.content.projects.length > 0){
                    for(var i=0; i<datas.content.projects.length; i++){
                        listProject += "<option value='"+datas.content.projects[i].id+"'>"+datas.content.projects[i].name+"</option>";
                    }
                }
                $("#chooseProjectAdd").html(listProject);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function addProject() {
    var body = new FormData;
    body.name = $("#nameProjectAdd").val().trim();
    body.description = $("#desProjectAdd").val();
    console.log(body);
    if(body.name.length <= 0){
        showNotification('danger',Messages("Tên dự án không được bỏ trống"));
        return;
    }
    StartProcess();
    var r = jsRoutes.controllers.ProjectController.addProject();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                getListProject();
                showNotification('success', datas.resultString);
                $("#nameProjectAdd").val('');
                $("#desProjectAdd").val('');
            } else {
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}


//TODO : flow
function backModalAddProject() {
    $("#flowModal").modal('hide');
    $("#projectModal").modal('show');
}
function nextModalAddFlow() {
    if($("#chooseProjectAdd").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn dự án"));
        return;
    }

    $("#projectModal").modal('hide');
    $("#flowModal").modal('show');
    getListFlow();
}
function getListFlow() {
    var body = new FormData;
    body.projectId = $("#chooseProjectAdd").val();
    StartProcess();
    var r = jsRoutes.controllers.FlowEngineController.getListFlow();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas, "getListFlow");
            if(datas.content != null){
                var listFlow = "<option value=''>"+Messages("---Chọn Flow---")+"</option>";
                if(datas.content.data != null && datas.content.data.length > 0){
                    for(var i=0; i<datas.content.data.length; i++){
                        listFlow += "<option value='"+datas.content.data[i].id.id+"'>"+datas.content.data[i].name+"</option>";
                    }
                }
                $("#chooseFlowAdd").html(listFlow);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}
function addFlow() {
    if($("#nameFlowAdd").val().trim().length <= 0){
        showNotification('danger',Messages("Tên Flow không được bỏ trống"));
        return;
    }
    var body = {
        "name": $("#nameFlowAdd").val().trim(),
        "projectId": $("#chooseProjectAdd").val(),
        "additionalInfo": {
            "description": $("#descriptionFlowAdd").val().trim()
        },
        "debugMode":true
    };
    StartProcess();
    var r = jsRoutes.controllers.FlowEngineController.addFlow();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                getListFlow();
                showNotification('success', datas.resultString);
                $("#nameFlowAdd").val('');
                $("#descriptionFlowAdd").val('');
            } else {
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

//TODO : template
function backModalAddFlow() {
    $("#flowModal").modal('show');
    $("#templateModal").modal('hide');
}
function nextModalAddTemplate() {
    if($("#chooseFlowAdd").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn Flow"));
        return;
    }

    $("#flowModal").modal('hide');
    $("#templateModal").modal('show');
    getListTemplate();
}
function getListTemplate() {
    var body = new FormData();
    body.projectId = $("#chooseProjectAdd").val();
    console.log(body);
    var r = jsRoutes.controllers.DeviceTemplateController.getListDeviceTemplate();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas, "getListDeviceTemplate");
            if(datas.content != null){
                var listTemplate = "<option value=''>"+Messages("---Chọn Template---")+"</option>";
                if(datas.content.templates != null && datas.content.templates.length > 0){
                    for(var i=0; i<datas.content.templates.length; i++){
                        listTemplate += "<option value='"+datas.content.templates[i].id+"'>"+datas.content.templates[i].name+"</option>";
                    }
                }
                $("#chooseTemplateAdd").html(listTemplate);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}
function addTemplate() {
    if($("#nameTemplateAdd").val().trim().length <= 0){
        showNotification('danger',Messages("Tên Template không được bỏ trống"));
        return;
    }
    var body = {
        "projectId": $("#chooseProjectAdd").val(),
        "name": $("#nameTemplateAdd").val().trim(),
        "idFlow": $("#chooseFlowAdd").val()
    };
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.DeviceTemplateController.createDeviceTemplate();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                getListTemplate();
                showNotification('success', datas.resultString);
                $("#nameTemplateAdd").val('');
            } else {
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}


//TODO : device
function backModalAddTemplate() {
    $("#templateModal").modal('show');
    $("#deviceModal").modal('hide');
}
function nextModalAddDevice() {
    if($("#chooseTemplateAdd").val().length <= 0){
        showNotification('danger',Messages("Bạn chưa chọn mẫu thiết bị"));
        return;
    }

    $("#templateModal").modal('hide');
    $("#deviceModal").modal('show');

    var body = "";
    console.log(listSerial);
    for (var i = 0; i < listSerial.length; i++) {
        body += "<tr>";
        body += "<th>"+(i+1)+"</th>";
        body += "<td class='wrap-text'>" + Messages("device ") + listSubs[listSerial[i]] + "</td>";
        body += "<td class='wrap-text'>" + listSerial[i] + "</td>";
        body += "<td class='wrap-text' id='result-"+listSerial[i]+"'></td>";
        body += "</tr>";
    }
    $("#listDeviceCreateWithSerial").find('tbody').html(body);
}

function addDeviceWithSerial(index) {
    var body = {
        "project_id": $("#chooseProjectAdd").val(),
        "org_id": "",
        "group_id": "",
        "template_id": $("#chooseTemplateAdd").val(),
        "name": "device "+listSubs[listSerial[index]],
        "metadata": {},
        "key": listSerial[index]
    };
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.DeviceIotController.createDeviceWithSerialSim();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                $("#result-"+listSerial[index]).html('<span style="color: green">'+datas.resultString+'</span>');
            } else {
                // showNotification('danger',datas.errorString);
                $("#result-"+listSerial[index]).html('<span style="color: red">'+datas.errorString+'</span>');
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(index < listSerial.length-1){
                addDeviceWithSerial(index+1);
            } else {
                FinishProcess();
            }
        }
    })
}