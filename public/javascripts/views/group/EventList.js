/**
 * Created by vtk-anhlt166 on 11/18/21.
 */
var countCondition = 1;
var countAction = 1;
var listDevices = new Array;
$(document).ready(function() {
    $('#addMoreCondition').on('click', function () {
        countCondition++;
        var option = "<option selected disabled value=''>"+Messages("event.choose.device")+"</option>";
        if(listDevices.length > 0 && listDevices.length > 0){
            for(var i=0; i<listDevices.length; i++){
                option += '<option value="'+listDevices[i].deviceId+'">'+listDevices[i].deviceName+'</option>';
            }
        }

        var appendHtml =
            '<div class="row mb-2 row-condition">'+
            '<div class="col-sm-12">'+
            '<div class="row mb-2">'+
            '<div class="col-sm-6"></div>'+
            '<div class="col-sm-3">'+
            '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.combinationConditions")+'</label>'+
            '</div>'+
            '<div class="col-sm-2">'+
            '<select class="form-select logical-operator">' +
            '<option value="and">And</option>'+
            '<option value="or">Or</option>'+
            '</select>' +
            '</div>'+
            '<div class="col-sm-1"></div>'+
            '</div>'+
            '</div>'+
            '<div class="col-sm-11">'+
            '<div class="row">'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.device")+'</label>'+
            '<select id="listDevice'+countCondition+'" onchange="getListAttrDevice('+countCondition+')" class="form-select mb-3 device-list" aria-label="Default select example">'+option+'</select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.attr")+'</label>'+
            '<select id="listAttributeDevice'+countCondition+'" class="form-select mb-3 var-list" aria-label="Default select example"></select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.condition")+'</label>'+
            '<select id="listConditionDevice'+countCondition+'" class="form-select mb-3 op-list" aria-label="Default select example">'+
            '<option value="=">'+Messages("event.operator.equal")+'</option>'+
            '<option value=">">'+Messages("event.operator.greater")+'</option>'+
            '<option value="<">'+Messages("event.operator.less")+'</option>'+
            '</select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.value")+'</label>'+
            '<input id="valueConditionDevice'+countCondition+'" type="text" class="form-control input-threshold" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-sm-1">'+
            '<div class="col-sm-12">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages(" ")+'</label>'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removeCondition(this)"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $('#conditionList').append(appendHtml)
    });

    $('#addMoreAction').on('click', function () {
        var appendHtml =
            '<div class="row mb-2 row-action">'+
            '<div class="col-sm-11">'+
            '<div class="row">'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.hd")+'</label>'+
            '<select id="listAction" class="form-select mb-3 actionType-list" aria-label="Default select example">'+
            '<option value="email">Email</option>'+
            '<option value="sms">Sms</option>'+
            '<option value="mqtt">Mqtt</option>'+
            '</select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.address")+'</label>'+
            '<input id="addressAction" type="text" class="form-control input-receiver" autocomplete="off" required>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.title")+'</label>'+
            '<input id="titleAction" type="text" class="form-control input-subject" autocomplete="off" required>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.content")+'</label>'+
            '<input id="contentAction" type="text" class="form-control input-message" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-sm-1">'+
            '<div class="col-sm-12">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages(" ")+'</label>'+
            '<i class="bx bx-trash" style="font-size: 24px; cursor: pointer;" onclick="removeAction(this)"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $('#actionList').append(appendHtml)
    });
});
function removeCondition(el) {
    console.log("remove condition");
    $(el).parents('.row-condition').remove();
}
function removeAction(el) {
    console.log("remove action");
    $(el).parents('.row-action').remove();
}

//view
function viewEventToTable(data) {
    $("#totalEvent").html(Messages("Tổng: ") + data.length + Messages(" sự kiện"));
    $("#tabEvent").empty();

    var mtmlEvent = "<table id='smlEventsTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th hidden>"+Messages("group.id")+"</th>" +
        "<th>"+Messages("group.event.name")+"</th>" +
        "<th>"+Messages("group.event.groupName")+"</th>" +
        "<th style='text-align: center'>"+Messages("Kích hoạt")+"</th>" +
        "<th></th>" +
        "</thead>" +
        "<tbody>";

    if (data != null && data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            mtmlEvent += "<tr id='tr_"+data[i].eventid+"'>";
            mtmlEvent += "<td></td>";
            mtmlEvent += "<td hidden><p id='event_"+data[i].id+"'>" + data[i].id + "</p></td>";
            mtmlEvent += "<td>" + data[i].name + "</td>";
            mtmlEvent += "<td>" + data[i].group_name + "</td>";
            if(data[i].onClick){
                mtmlEvent += "<td align='center'>" + '<i class="bx bx-message-alt-check" style="cursor: pointer" onclick="setOnlickEvent(\''+data[i].id+'\')"></i>' + "</td>";
            } else {
                mtmlEvent += "<td></td>";
            }
            mtmlEvent += "<td align='center'>" ;
            mtmlEvent += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlEvent += '<ul class="dropdown-menu dropdown-table">' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="copyIdEvent(\''+data[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("Copy ID")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="remotePageAttrEvent(\''+data[i].id+'\')"><img src="'+iconCopy+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnAttr")+'</a></li>' +
                '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="showPopupDetailEvent(\''+data[i].id+'\')"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnEdit")+'</a></li>' +
                // '<li style="cursor: pointer"><a class="dropdown-item" onclick="showPopupDetailEvent(\''+data[i].id+'\')"><i class="bx bx-message-square-edit"></i> '+Messages("btnEdit")+'</a></li>' +
                '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelIdEvent(\''+data[i].id+'\')"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>' +
                '</ul>';
            mtmlEvent += "</td>";
            mtmlEvent += "</td>";
            mtmlEvent += "</tr>";
        }
    }
    mtmlEvent += "</tbody></table>";
    $("#tabEvent").html(mtmlEvent);

    var table = $('#smlEventsTable').DataTable( {
        responsive: true,
        lengthChange: false,
        // buttons: [ 'excel', 'pdf', 'print'],
        "order": [],
        "info": false,
        bSort: false,
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showPopupAddEvent' );
                    showPopupAddEvent();
                }
            }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlEventsTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();

    //get ds device in org
    var bodyData = new FormData;
    bodyData.projectId = projectId;
    bodyData.groupId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    bodyData.page = 1;
    bodyData.pageSize = 1000;
    console.log(bodyData);
    var r_device = jsRoutes.controllers.GroupController.getListDeviceOfOrg();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(bodyData),
        contentType: "application/json",
        url: r_device.url,
        type: r_device.type,
        success: function (data) {
            console.log(data);
            if (data.content.devices != null) {
                listDevices = [];
                if (data.content.devices.length > 0) {
                    var devices = data.content.devices;
                    var option = "<option selected value=''>" + Messages("event.choose.device") + "</option>";
                    devices.forEach(function (item) {
                        listDevices.push({
                            "deviceId": item.id,
                            "deviceName": item.name
                        });
                        option += '<option value="' + item.id + '">' + item.name + '</option>';
                    });
                }
            }
        }
    })
}

function copyIdEvent(id) {
    copyToClipboard("#event_"+id);
}

function remotePageAttrEvent(id) {
    window.location.href = jsRoutes.controllers.AttributeController.attributeEvent(projectId, id).url;
}

function showPopupAddEvent() {
    $("#addEventModal").modal('show');

    var option = "<option selected disabled value=''>"+Messages("event.choose.device")+"</option>";
    if(listIdDevice.length > 0 && listNameDevice.length > 0){
        for(var i=0; i<listIdDevice.length; i++){
            option += '<option value="'+listIdDevice[i]+'">'+listNameDevice[i]+'</option>';
        }
    }
    $("#listDevice1").html(option);

    //select truc thuoc
    StartProcess();
    var formData = new FormData;
    formData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    formData.projectId = projectId;
    var r = jsRoutes.controllers.GroupListController.getListGroupEvent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                var option = '<option value="" selected>'+Messages("manage.group.tructhuoc")+'</option>';
                if(data.content != null){
                    if(data.content.groups != null && data.content.groups.length > 0){
                        for(var i=0; i<data.content.groups.length; i++){
                            option +=
                                '<option value="'+data.content.groups[i].id+'">'+data.content.groups[i].name+'</option>';
                        }
                    }
                }
                $("#chooseGroupEventAdd").html(option);
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

    var option = "<option selected value=''>"+Messages("event.choose.device")+"</option>";
    listDevices.forEach(function (item) {
        option += '<option value="'+item.deviceId+'">'+item.deviceName+'</option>';
    });

    var appendHtml =
        '<div class="row mb-2 row-condition">'+
        '<div class="col-sm-12">'+
        '<div class="col-sm-11">'+
        '<div class="row">'+
        '<div class="col-sm-3">'+
        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.device")+'</label>'+
        '<select id="listDevice'+countCondition+'" onchange="getListAttrDevice('+countCondition+')" class="form-select mb-3 device-list" aria-label="Default select example">'+option+'</select>'+
        '</div>'+
        '<div class="col-sm-3">'+
        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.attr")+'</label>'+
        '<select id="listAttributeDevice'+countCondition+'" class="form-select mb-3 var-list" aria-label="Default select example"></select>'+
        '</div>'+
        '<div class="col-sm-3">'+
        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.condition")+'</label>'+
        '<select id="listConditionDevice'+countCondition+'" class="form-select mb-3 op-list" aria-label="Default select example">'+
        '<option value="=">'+Messages("event.operator.equal")+'</option>'+
        '<option value=">">'+Messages("event.operator.greater")+'</option>'+
        '<option value="<">'+Messages("event.operator.less")+'</option>'+
        '</select>'+
        '</div>'+
        '<div class="col-sm-3">'+
        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.value")+'</label>'+
        '<input id="valueConditionDevice'+countCondition+'" type="text" class="form-control input-threshold" autocomplete="off" required>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="col-sm-1">'+
        // '<div class="col-sm-12">'+
        // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages(" ")+'</label>'+
        // '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; margin-top: 10px; cursor: pointer" onclick="removeCondition(this)"></i>'+
        // '</div>'+
        '</div>'+
        '</div>';
    $('#conditionList').html(appendHtml)
}

function selectTypeEvent(el) {
    if(el.value == "schedule"){
        document.getElementById("tabConditionAdd").style.display = 'none';
        document.getElementById("tabTimeEnd").style.display = 'none';

        document.getElementById("buttonCreateEvent").style.display = 'none';
        document.getElementById("buttonCreateSchedule").style.display = 'block';
    } else {
        document.getElementById("tabConditionAdd").style.display = 'block';
        document.getElementById("tabTimeEnd").style.display = 'block';

        document.getElementById("buttonCreateEvent").style.display = 'block';
        document.getElementById("buttonCreateSchedule").style.display = 'none';
    }
}

function selectTypeOnclick(el) {
    if(el.value == "true"){
        document.getElementById("tabConditionAdd").style.display = 'none';
    } else {
        document.getElementById("tabConditionAdd").style.display = 'block';
    }
}

function getListAttrDevice(count) {
    var id = $("#listDevice"+count).val();
    console.log(id);

    var groupData = new FormData;
    groupData.id = id;
    groupData.type = "DEVICE";

    StartProcess();
    var r = jsRoutes.controllers.AttributeController.getAttributeList();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if (data.content != null) {
                var option = "";
                if(data.content.attributes.length > 0){
                    for(var i=0; i<data.content.attributes.length; i++){
                        option += '<option value="'+data.content.attributes[i].attribute_key+'">'+data.content.attributes[i].attribute_key+'</option>';
                    }
                }
                $("#listAttributeDevice"+count).html(option);
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

function setVartype(count) {
    console.log(count);
    console.log($("#listAttributeDevice"+count).find(':selected').attr('vartype'));
    $("#varType"+count).val($("#listAttributeDevice"+count).find(':selected').attr('vartype'));
}

//create
function handlerTime(e) {
    console.log(e.target.value);
    var startTime = $('#startTime').val();
    var endTime = $('#endTime').val();
    console.log(startTime, endTime);
    var hStart = parseInt(startTime.substring(0,2));
    var mStart = parseInt(startTime.substring(3,5));
    var timeStart = hStart*60 + mStart;
    var hEnd = parseInt(endTime.substring(0,2));
    var mEnd = parseInt(endTime.substring(3,5));
    var timeEnd = hEnd*60 + mEnd;
    console.log(timeStart, timeEnd);
    if(timeStart < timeEnd){
        var count = timeEnd - timeStart;
        console.log(count);
        var hCount = Math.floor(count/60);
        var mCount = count%60;
        $("#circleCount").html(hCount + ":" + mCount);
    } else {
        showNotification('danger',Messages("event.validateTime"));
    }
}

function postCreateEvent() {
    var groupData = new FormData();
    groupData.name = $('#nameEventNew').val();
    groupData.project_id = projectId;
    groupData.org_id = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    groupData.group_id = ($("#chooseGroupEventAdd").val() != null) ? $("#chooseGroupEventAdd").val() : "";
    groupData.status = ($("#chooseStatusEventAdd").val() == "true") ? true : false;
    if($("#retryAdd").val() < 0){
        showNotification('danger', Messages("Số lần lặp lại phải lớn hơn hoặc bằng 0"));
        return;
    }
    groupData.retry = parseInt($("#retryAdd").val());
    groupData.onClick = ($("#chooseOnclickAdd").val() == "true") ? true : false;

    var conditions = [];
    if(!groupData.onClick){
        var count = $('#conditionList .var-list').length;
        if(count > 0){
            for(var i=0; i<count-1; i++){
                var ddrVariable = $("#conditionList").find('.var-list')[i];
                // var ddrVarType = $("#conditionList").find('.var-type')[i];
                var ddrDevice = $("#conditionList").find('.device-list')[i];
                console.log($(ddrDevice).children("option:selected").text());
                var ddrOperator = $("#conditionList").find('.op-list')[i];
                var inpThreshold = $("#conditionList").find('.input-threshold')[i];
                var ddrLogicalOp = $("#conditionList").find('.logical-operator')[i];
                var condition = {
                    "device_id": ($(ddrDevice).val() != null && $(ddrDevice).val().length > 0) ? $(ddrDevice).val() : "",
                    "attribute_name": ($(ddrVariable).val() != null && $(ddrVariable).val().length > 0) ? $(ddrVariable).val() : "",
                    "condition_type":"normal",
                    "operator": ($(ddrOperator).val() != null && $(ddrOperator).val().length > 0) ? $(ddrOperator).val() : "",
                    "threshold": ($(inpThreshold).val() != null && $(inpThreshold).val().length > 0) ? $(inpThreshold).val() : "",
                    "logical_operator": ($(ddrLogicalOp).val() != null && $(ddrLogicalOp).val().length > 0) ? $(ddrLogicalOp).val() : "and"
                };
                conditions.push(condition);
            }
        }
        groupData.condition = conditions;
    }
    // $('#conditionList').children().each(function (){
    //
    // });

    var actions = [];
    $('#actionList').children().each(function (){
        var ddrActionType = $(this).find('.actionType-list')[0];
        var inputReceiver = $(this).find('.input-receiver')[0];
        var inputSubject = $(this).find('.input-subject')[0];
        var inputMessage = $(this).find('.input-message')[0];
        var action = {
            "action_type": $(ddrActionType).val(),
            "receiver": $(inputReceiver).val(),
            "subject": $(inputSubject).val(),
            "message": $(inputMessage).val(),
        };
        actions.push(action);
    });
    groupData.action = actions;

    groupData.interval = {
        "monday": $('#monday').is(':checked'),
        "tuesday": $('#tuesday').is(':checked'),
        "wednesday": $('#wednesday').is(':checked'),
        "thursday": $('#thursday').is(':checked'),
        "friday": $('#friday').is(':checked'),
        "saturday": $('#saturday').is(':checked'),
        "sunday": $('#sunday').is(':checked'),
        "start_time": $('#startTime').val(),
        "end_time": $('#endTime').val()
    };

    var hStart = parseInt($('#startTime').val().substring(0,2));
    var mStart = parseInt($('#startTime').val().substring(3,5));
    var timeStart = hStart*60 + mStart;
    var hEnd = parseInt($('#endTime').val().substring(0,2));
    var mEnd = parseInt($('#endTime').val().substring(3,5));
    var timeEnd = hEnd*60 + mEnd;
    console.log(timeStart, timeEnd);
    if(timeStart >= timeEnd){
        showNotification('danger',Messages("event.validateTime"));
        return;
    }
    console.log("groupData aaaaaa",groupData);

    $("#addEventModal").modal('hide');

    StartProcess();
    var r = jsRoutes.controllers.EventController.addNewEvent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);

            }else{  //tra ve cau hinh truoc do
                showNotification('danger',data.errorString);
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

function postCreateSchedule() {
    var groupData = new FormData();
    groupData.name = $('#nameEventNew').val();
    groupData.project_id = projectId;
    groupData.org_id = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    groupData.group_id = ($("#chooseGroupEventAdd").val() != null) ? $("#chooseGroupEventAdd").val() : "";
    groupData.status = ($("#chooseStatusEventAdd").val() == "true") ? true : false;
    if($("#retryAdd").val() < 0){
        showNotification('danger', Messages("Số lần lặp lại phải lớn hơn hoặc bằng 0"));
        return;
    }
    groupData.retry = parseInt($("#retryAdd").val());

    var actions = [];
    $('#actionList').children().each(function (){
        var ddrActionType = $(this).find('.actionType-list')[0];
        var inputReceiver = $(this).find('.input-receiver')[0];
        var inputSubject = $(this).find('.input-subject')[0];
        var inputMessage = $(this).find('.input-message')[0];
        var action = {
            "action_type": $(ddrActionType).val(),
            "receiver": $(inputReceiver).val(),
            "subject": $(inputSubject).val(),
            "message": $(inputMessage).val()
        };
        actions.push(action);
    });
    groupData.action = actions;

    var repeat = "";
    if($('#monday').is(':checked')){
        repeat += "monday";
    }
    if($('#tuesday').is(':checked')){
        repeat += ",tuesday";
    }
    if($('#wednesday').is(':checked')){
        repeat += ",wednesday";
    }
    if($('#thursday').is(':checked')){
        repeat += ",thursday";
    }
    if($('#friday').is(':checked')){
        repeat += ",friday";
    }
    if($('#saturday').is(':checked')){
        repeat += ",saturday";
    }
    if($('#sunday').is(':checked')){
        repeat += ",sunday";
    }
    groupData.schedule = {
        "time": $('#startTime').val(),
        "repeat" : repeat
    };
    console.log("groupData aaaaaa",groupData);

    StartProcess();
    var r = jsRoutes.controllers.EventController.addNewSchedule();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#addEventModal").modal('hide');

                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);

            }else{  //tra ve cau hinh truoc do
                showNotification('danger',data.errorString);
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

//del
function setDelIdEvent(id) {
    $("#deleteEventConfirm").modal('show');
    $("#idEventDelete").val(id);
}
function postDeleteEvent() {
    var groupData = new FormData();
    groupData.id = $('#idEventDelete').val();
    groupData.projectId = projectId;

    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.EventController.deleteEvent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                selectUpdateGroup(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{  //tra ve cau hinh truoc do
                showNotification('danger',data.errorString);
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

function setOnlickEvent(eventId) {
    var body = new FormData;
    body.eventId = eventId;
    body.projectId = projectId;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.EventController.onclickEvent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
            }else{  //tra ve cau hinh truoc do
                if(data.content.message != null){
                    showNotification('danger',data.content.message);

                } else {
                    showNotification('danger',data.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            setTimeout(function () {
                FinishProcess(); //Stop display loading...
            },500)
        }
    });
}