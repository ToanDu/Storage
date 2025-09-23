/**
 * Created by vtk-anhlt166 on 11/30/21.
 */
//edit
var countConditionEdit = 0;
$(document).ready(function () {
    $('#addMoreConditionEdit').on('click', function () {
        countConditionEdit++;
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
            '<select class="form-select logical-operator-edit">' +
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
            '<select id="listDeviceEdit'+countConditionEdit+'" onchange="getListAttrDeviceEdit('+countConditionEdit+')" class="form-select mb-3 device-list-edit" aria-label="Default select example">'+option+'</select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.attr")+'</label>'+
            '<select id="listAttributeDeviceEdit'+countConditionEdit+'" class="form-select mb-3 var-list-edit" aria-label="Default select example"></select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.condition")+'</label>'+
            '<select id="listConditionDeviceEdit'+countConditionEdit+'" class="form-select mb-3 op-list-edit" aria-label="Default select example">'+
            '<option value="=">'+Messages("event.operator.equal")+'</option>'+
            '<option value=">">'+Messages("event.operator.greater")+'</option>'+
            '<option value="<">'+Messages("event.operator.less")+'</option>'+
            '</select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.value")+'</label>'+
            '<input id="valueConditionDeviceEdit'+countConditionEdit+'" type="text" class="form-control input-threshold-edit" autocomplete="off" required>'+
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
        $('#conditionListEdit').append(appendHtml)
    });

    $('#addMoreActionEdit').on('click', function () {
        var appendHtml =
            '<div class="row mb-2 row-action">'+
            '<div class="col-sm-11">'+
            '<div class="row">'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.hd")+'</label>'+
            '<select id="listActionEdit" class="form-select mb-3 actionType-list-edit" aria-label="Default select example">'+
            '<option value="email">Email</option>'+
            '<option value="sms">Sms</option>'+
            '<option value="mqtt">Mqtt</option>'+
            '</select>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.address")+'</label>'+
            '<input id="addressActionEdit" type="text" class="form-control input-receiver-edit" autocomplete="off" required>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.title")+'</label>'+
            '<input id="titleActionEdit" type="text" class="form-control input-subject-edit" autocomplete="off" required>'+
            '</div>'+
            '<div class="col-sm-3">'+
            // '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.content")+'</label>'+
            '<input id="contentActionEdit" type="text" class="form-control input-message-edit" autocomplete="off" required>'+
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
        $('#actionListEdit').append(appendHtml)
    });
})

function getListAttrDeviceEdit(count) {
    var id = $("#listDeviceEdit"+count).val();
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
                $("#listAttributeDeviceEdit"+count).html(option);
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

function showPopupDetailEvent(id) {
    $("#idEventEdit").val(id);
    $("#editEventModal").modal('show');

    //select truc thuoc
    var formData = new FormData;
    formData.orgId = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    formData.projectId = projectId;
    var url = jsRoutes.controllers.GroupListController.getListGroupEvent();
    $.ajax({
        type: url.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: url.url,
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
                $("#chooseGroupEventEdit").html(option);
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

    //get data event
    var groupData = new FormData();
    groupData.id = id;
    groupData.projectId = projectId;
    StartProcess();
    var r = jsRoutes.controllers.EventController.getEvent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){

                $('#nameEventEdit').val(data.content.name);
                $('#chooseGroupEventEdit').val(data.content.group_id);
                $('#chooseStatusEventEdit').val(data.content.status.toString());
                $('#chooseOnclickEdit').val(data.content.onClick.toString());
                $('#retryEdit').val(data.content.retry);

                if(data.content.condition != null && data.content.condition.length > 0){
                    $('#chooseTypeEventEdit').val("event");
                    document.getElementById("tabConditionEdit").style.display = 'block';
                    document.getElementById("tabTimeEndEdit").style.display = 'block';
                    document.getElementById("buttonEditEvent").style.display = 'block';
                    document.getElementById("buttonEditSchedule").style.display = 'none';

                    countConditionEdit = data.content.condition.length;

                    var conditionEdit =
                    '<div class="row mb-3">\n' +
                        '                    <div class="col-sm-11">\n' +
                        '                      <div class="row">\n' +
                        '                        <div class="col-sm-3">\n' +
                        '                          <label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.device")+'</label>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-sm-3">\n' +
                        '                          <label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.attr")+'</label>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-sm-3">\n' +
                        '                          <label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.condition1")+'</label>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-sm-3">\n' +
                        '                          <label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.value")+'</label>\n' +
                        '                        </div>\n' +
                        '                      </div>\n' +
                        '                    </div>\n' +
                        '                    <div class="col-sm-1"></div>\n' +
                        '                  </div>';
                    for(var i=0; i < data.content.condition.length; i++){
                        conditionEdit +=
                            '<div class="row mb-2 row-condition">'+
                            '<div class="col-sm-12">';
                        if(i > 0){
                            conditionEdit +=
                                '<div class="row mb-2">'+
                                '<div class="col-sm-6"></div>'+
                                '<div class="col-sm-3">'+
                                '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.title.combinationConditions")+'</label>'+
                                '</div>'+
                                '<div class="col-sm-2">'+
                                '<select class="form-select logical-operator-edit">' ;

                            if(data.content.condition[i].logical_operator == "and"){
                                conditionEdit +=
                                    '<option value="and">And</option>';
                            } else {
                                conditionEdit +=
                                    '<option value="or">Or</option>';

                            }
                            conditionEdit +=
                                '</select>' +
                                '</div>'+
                                '<div class="col-sm-1"></div>'+
                                '</div>';
                        }

                        conditionEdit +=
                            '</div>'+
                            '<div class="col-sm-11">'+
                            '<div class="row">'+
                            '<div class="col-sm-3">'+
                            '<select id="listDeviceEdit'+(i+1)+'" onchange="getListAttrDevice('+(i+1)+')" class="form-select mb-3 device-list-edit" aria-label="Default select example">';

                        var option = '<option selected value="">'+Messages("event.choose.device")+'</option>';
                        listDevices.forEach(function (item) {
                            if(item.deviceId == data.content.condition[i].device_id){
                                option += '<option value="'+item.deviceId+'" selected>'+item.deviceName+'</option>';
                            } else {
                                option += '<option value="'+item.deviceId+'">'+item.deviceName+'</option>';
                            }
                        });

                        conditionEdit += option +
                            '</select>'+
                            '</div>'+
                            '<div class="col-sm-3">'+
                            '<select id="listAttributeDeviceEdit'+(i+1)+'" class="form-select mb-3 var-list-edit" aria-label="Default select example">'+
                            '<option value="'+data.content.condition[i].attribute_name+'">'+data.content.condition[i].attribute_name+'</option>'+
                            '</select>'+
                            '</div>'+
                            '<div class="col-sm-3">'+
                            '<select id="listConditionDeviceEdit'+countCondition+'" class="form-select mb-3 op-list-edit" aria-label="Default select example">';

                        if(data.content.condition[i].operator == ">"){
                            conditionEdit +=
                                '<option value=">">'+Messages("event.operator.greater")+'</option>';
                        } else if(data.content.condition[i].operator == "<"){
                            conditionEdit +=
                                '<option value="<">'+Messages("event.operator.less")+'</option>';
                        } else {
                            conditionEdit +=
                                '<option value="=">'+Messages("event.operator.equal")+'</option>';
                        }

                        conditionEdit +=
                            '</select>'+
                            '</div>'+
                            '<div class="col-sm-3">'+
                            '<input id="valueConditionDeviceEdit'+(i+1)+'" value="'+data.content.condition[i].threshold+'" type="text" class="form-control input-threshold-edit" autocomplete="off" required>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '<div class="col-sm-1">';

                        conditionEdit +=
                            '<div class="col-sm-12">'+
                            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removeCondition(this)"></i>'+
                            '</div>';

                        conditionEdit +=
                            '</div>'+
                            '</div>';
                    }
                    $("#conditionListEdit").html(conditionEdit);
                } else {
                    $('#chooseTypeEventEdit').val("schedule");
                    document.getElementById("tabConditionEdit").style.display = 'none';
                    document.getElementById("tabTimeEndEdit").style.display = 'none';
                    document.getElementById("buttonEditEvent").style.display = 'none';
                    document.getElementById("buttonEditSchedule").style.display = 'block';
                }

                if(data.content.action != null && data.content.action.length > 0){
                    //action
                    var actionEdit =
                        '<div class="row mb-2">'+
                        '<div class="col-sm-11">'+
                        '<div class="row">'+
                        '<div class="col-sm-3">'+
                        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.hd")+'</label>'+
                        '</div>'+
                        '<div class="col-sm-3">'+
                        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.address")+'</label>'+
                        '</div>'+
                        '<div class="col-sm-3">'+
                        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.title")+'</label>'+
                        '</div>'+
                        '<div class="col-sm-3">'+
                        '<label class="col-sm-12 col-form-label" style="text-align: center">'+Messages("event.column.title.content")+'</label>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                        '<div class="col-sm-1">'+
                        '</div>'+
                        '</div>';
                    for(var k=0; k < data.content.action.length; k++){
                        // console.log(data.content.action[k]);
                        actionEdit +=
                            '<div class="row mb-2 row-action">'+
                            '<div class="col-sm-11">'+
                            '<div class="row">'+
                            '<div class="col-sm-3">'+
                            '<select id="listAction" class="form-select mb-3 actionType-list-edit" aria-label="Default select example">';

                        if(data.content.action[k].action_type == "email"){
                            actionEdit += '<option value="email">Email</option>';
                        } else if(data.content.action[k].action_type == "mqtt"){
                            actionEdit += '<option value="mqtt">Mqtt</option>';
                        } else {
                            actionEdit += '<option value="sms">Sms</option>';
                        }

                        var message = data.content.action[k].message;
                        // console.log(message);
                        actionEdit +=
                            '</select>'+
                            '</div>'+
                            '<div class="col-sm-3">'+
                            "<input id='addressActionEdit' value='"+data.content.action[k].receiver+"' type='text' class='form-control input-receiver-edit'  autocomplete='off' required>"+
                            '</div>'+
                            '<div class="col-sm-3">'+
                            "<input id='titleActionEdit' value='"+data.content.action[k].subject+"' type='text' class='form-control input-subject-edit' autocomplete='off' required>"+
                            '</div>'+
                            '<div class="col-sm-3">'+
                            "<input id='contentActionEdit' value='"+data.content.action[k].message+"' type='text' class='form-control input-message-edit'  autocomplete='off'>"+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '<div class="col-sm-1">';

                        actionEdit +=
                            '<div class="col-sm-12">'+
                            '<i class="bx bx-trash" style="font-size: 24px; cursor: pointer;" onclick="removeAction(this)"></i>'+
                            '</div>';

                        actionEdit +=
                            '</div>'+
                            '</div>';
                    }
                    $("#actionListEdit").html(actionEdit);
                }

                $('#mondayEdit').prop('checked', data.content.interval.monday);
                $('#tuesdayEdit').prop('checked', data.content.interval.tuesday);
                $('#wednesdayEdit').prop('checked', data.content.interval.wednesday);
                $('#thursdayEdit').prop('checked', data.content.interval.thursday);
                $('#fridayEdit').prop('checked', data.content.interval.friday);
                $('#saturdayEdit').prop('checked', data.content.interval.saturday);
                $('#sundayEdit').prop('checked', data.content.interval.sunday);

                $('#startTimeEdit').val(data.content.interval.start_time != "" ? data.content.interval.start_time : "00:00");
                $('#endTimeEdit').val(data.content.interval.end_time != "" ? data.content.interval.end_time : "23:59");

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

function selectTypeEventEdit(el) {
    if(el.value == "schedule"){
        document.getElementById("tabConditionEdit").style.display = 'none';
        document.getElementById("tabTimeEndEdit").style.display = 'none';

        document.getElementById("buttonEditEvent").style.display = 'none';
        document.getElementById("buttonEditSchedule").style.display = 'block';
    } else {
        document.getElementById("tabConditionEdit").style.display = 'block';
        document.getElementById("tabTimeEndEdit").style.display = 'block';

        document.getElementById("buttonEditEvent").style.display = 'block';
        document.getElementById("buttonEditSchedule").style.display = 'none';
    }
}

function selectTypeOnclickEdit(el) {
    if(el.value == "true"){
        document.getElementById("tabConditionEdit").style.display = 'none';
    } else {
        document.getElementById("tabConditionEdit").style.display = 'block';
    }
}

function handlerTimeDetail(e) {
    console.log(e.target.value);
    var startTime = $('#startTime-detail').val();
    var endTime = $('#endTime-detail').val();
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
        $("#circleCountDetail").html(hCount + ":" + mCount);
    }
}

function postEditEvent() {
    var groupData = new FormData();
    groupData.name = $('#nameEventEdit').val();
    groupData.project_id = projectId;
    groupData.org_id = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    groupData.group_id = ($("#chooseGroupEventEdit").val() != null) ? $("#chooseGroupEventEdit").val() : "";
    groupData.status = ($("#chooseStatusEventEdit").val() == "true") ? true : false;
    if($("#retryEdit").val() < 0){
        showNotification('danger', Messages("Số lần lặp lại phải lớn hơn hoặc bằng 0"));
        return;
    }
    groupData.retry = parseInt($("#retryEdit").val());
    groupData.onClick = ($("#chooseOnclickEdit").val() == "true") ? true : false;

    var conditions = [];
    if(!groupData.onClick){
        var count = $('.var-list-edit').length;
        console.log(count);
        if(count > 0){
            for(var i=0; i<count; i++){
                var ddrVariable = $("#conditionListEdit").find('.var-list-edit')[i];
                // var ddrVarType = $("#conditionList").find('.var-type')[i];
                var ddrDevice = $("#conditionListEdit").find('.device-list-edit')[i];
                var ddrOperator = $("#conditionListEdit").find('.op-list-edit')[i];
                var inpThreshold = $("#conditionListEdit").find('.input-threshold-edit')[i];
                var ddrLogicalOp = $("#conditionListEdit").find('.logical-operator-edit')[i];
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

    var actions = [];
    $('#actionListEdit').children().each(function (){
        var ddrActionType = $(this).find('.actionType-list-edit')[0];
        var inputReceiver = $(this).find('.input-receiver-edit')[0];
        var inputSubject = $(this).find('.input-subject-edit')[0];
        var inputMessage = $(this).find('.input-message-edit')[0];
        if($(ddrActionType).val() != undefined && $(inputReceiver).val() != undefined){
            var action = {
                "action_type": $(ddrActionType).val(),
                "receiver": $(inputReceiver).val(),
                "subject": $(inputSubject).val(),
                "message": $(inputMessage).val()
            };
            actions.push(action);
        }
    });
    groupData.action = actions;

    groupData.interval = {
        "monday": $('#mondayEdit').is(':checked'),
        "tuesday": $('#tuesdayEdit').is(':checked'),
        "wednesday": $('#wednesdayEdit').is(':checked'),
        "thursday": $('#thursdayEdit').is(':checked'),
        "friday": $('#fridayEdit').is(':checked'),
        "saturday": $('#saturdayEdit').is(':checked'),
        "sunday": $('#sundayEdit').is(':checked'),
        "start_time": $('#startTimeEdit').val(),
        "end_time": $('#endTimeEdit').val()
    };

    var hStart = parseInt($('#startTimeEdit').val().substring(0,2));
    var mStart = parseInt($('#startTimeEdit').val().substring(3,5));
    var timeStart = hStart*60 + mStart;
    var hEnd = parseInt($('#endTimeEdit').val().substring(0,2));
    var mEnd = parseInt($('#endTimeEdit').val().substring(3,5));
    var timeEnd = hEnd*60 + mEnd;
    console.log(timeStart, timeEnd);
    if(timeStart >= timeEnd){
        showNotification('danger',Messages("event.validateTime"));
        return;
    }
    console.log("groupData edit event",groupData);

    StartProcess();
    var id = $("#idEventEdit").val();
    var r = jsRoutes.controllers.EventController.editEvent(id);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#editEventModal").modal('hide');

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

function postEditSchedule() {
    var groupData = new FormData();
    groupData.name = $('#nameEventEdit').val();
    groupData.project_id = projectId;
    groupData.org_id = (currentSelectedGroup.id == projectId) ? "":currentSelectedGroup.id;
    groupData.group_id = ($("#chooseGroupEventEdit").val() != null) ? $("#chooseGroupEventEdit").val() : "";
    groupData.status = ($("#chooseStatusEventEdit").val() == "true") ? true : false;
    if($("#retryEdit").val() < 0){
        showNotification('danger', Messages("Số lần lặp lại phải lớn hơn hoặc bằng 0"));
        return;
    }
    groupData.retry = parseInt($("#retryEdit").val());
    groupData.onClick = ($("#chooseOnclickEdit").val() == "true") ? true : false;

    var actions = [];
    $('#actionListEdit').children().each(function (){
        var ddrActionType = $(this).find('.actionType-list-edit')[0];
        var inputReceiver = $(this).find('.input-receiver-edit')[0];
        var inputSubject = $(this).find('.input-subject-edit')[0];
        var inputMessage = $(this).find('.input-message-edit')[0];
        if($(ddrActionType).val() != undefined && $(inputReceiver).val() != undefined){
            var action = {
                "action_type": $(ddrActionType).val(),
                "receiver": $(inputReceiver).val(),
                "subject": $(inputSubject).val(),
                "message": $(inputMessage).val()
            };
            actions.push(action);
        }
    });
    groupData.action = actions;

    var repeat = "";
    if($('#mondayEdit').is(':checked')){
        repeat += "monday";
    }
    if($('#tuesdayEdit').is(':checked')){
        repeat += ",tuesday";
    }
    if($('#wednesdayEdit').is(':checked')){
        repeat += ",wednesday";
    }
    if($('#thursdayEdit').is(':checked')){
        repeat += ",thursday";
    }
    if($('#fridayEdit').is(':checked')){
        repeat += ",friday";
    }
    if($('#saturdayEdit').is(':checked')){
        repeat += ",saturday";
    }
    if($('#sundayEdit').is(':checked')){
        repeat += ",sunday";
    }
    groupData.schedule = {
        "time": $('#startTimeEdit').val(),
        "repeat" : repeat
    };
    console.log("groupData schedule",groupData);

    StartProcess();
    var id = $("#idEventEdit").val();
    var r = jsRoutes.controllers.EventController.editSchedule(id);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $("#editEventModal").modal('hide');

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