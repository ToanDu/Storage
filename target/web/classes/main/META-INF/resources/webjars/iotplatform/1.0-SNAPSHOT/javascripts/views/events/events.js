var listVariables = [];
var deviceList = new Map();
var operatorNumberList = new Map();
var operatorStringList = new Map();


function postDataCreateEvent() {
    var groupData = new FormData();
    groupData.name = $('#newEventName').val()
    var conditions = [];
    $('#conditionLst').children().each(function (){
        var ddrVariable = $(this).find('.var-list')[0]
        var ddrDevice = $(this).find('.device-list')[0]
        var ddrOperator = $(this).find('.op-list')[0]
        var inpThreshold = $(this).find('.input-threshold')[0]
        var ddrLogicalOp = $(this).find('.logical-operator')[0]
        if ($(ddrVariable).val() != null && $(ddrVariable).val() != "" ){
            var condition = {
                "deviceid": $(ddrDevice).val(),
                "variableName": $(ddrVariable).val(),
                "operator": $(ddrOperator).val(),
                "threshold": $(inpThreshold).val(),
                "logicalOperator": ddrLogicalOp != undefined ? $(ddrLogicalOp).val() : "and"
            };
            conditions.push(condition);
        }
    });
    groupData.conditions = conditions;

    var actions = [];
    $('#actionList').children().each(function (){
        var ddrActionType = $(this).find('.actionType-list')[0]
        var inputReceiver = $(this).find('.input-receiver')[0]
        var inputSubject = $(this).find('.input-subject')[0]
        var inputMessage = $(this).find('.input-message')[0]
        if ($(ddrActionType).val() != null && $(ddrActionType).val() != "" && $(inputReceiver).val() != ""
            && $(inputSubject).val() != "" && $(inputMessage).val() != ""){
            var action = {
                "actionType": $(ddrActionType).val(),
                "receiver": $(inputReceiver).val(),
                "subject": $(inputSubject).val(),
                "message": $(inputMessage).val(),
            };
            actions.push(action);
        }
    });
    groupData.actions = actions;

    groupData.monday = $('#monday').is(':checked');
    groupData.tuesday = $('#tuesday').is(':checked');
    groupData.wednesday = $('#wednesday').is(':checked');
    groupData.thursday = $('#thursday').is(':checked');
    groupData.friday = $('#friday').is(':checked');
    groupData.saturday = $('#saturday').is(':checked');
    groupData.sunday = $('#sunday').is(':checked');

    groupData.startTime = $('#startTime').val();
    groupData.endTime = $('#endTime').val();

    console.log("groupData aaaaaa",groupData);

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
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
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

function getVarsByDevice(current, selectedVar) {
    var groupData = new FormData();
    groupData.deviceId = $(current).val();
    console.log(groupData);

    console.log($('#conditionLst').children().length);

    var r = jsRoutes.controllers.EventController.getVarsByDevice();
    $.ajax({
        type: r.type,
        url: r.url + "?deviceId=" +  $(current).val(),
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            listVariables = data.variables;
            var parentDiv = $(current).parent().parent().children()[1];
            $(parentDiv).children('.var-list').empty().append('<option selected disabled value="">Select variable</option>');

            if(data.total > 0){
                $(parentDiv).children('.var-list').each(function (){
                    $(this).prop('disabled', false);
                    for(var v of data.variables){
                        if (selectedVar != null && selectedVar == v.varname) {
                            $(this).append($('<option></option>').attr("value", v.varname).attr("selected", true).attr("name", v.vartype).text(v.varname));
                        }else {
                            $(this).append($('<option></option>').attr("value", v.varname).attr("name", v.vartype).text(v.varname));
                        }


                    }
                });

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

$(document).ready(function() {
    $('#listDeviceDrd option').each(function (){
        if ($(this).val() != "") {
            deviceList.set($(this).val(), $(this).text());
        }
    });

    $('#listOprStringDrd option').each(function (){
        if ($(this).val() != "") {
            operatorStringList.set($(this).val(), $(this).text());
        }
    });

    $('#listOprDrd option').each(function (){
        if ($(this).val() != "") {
            operatorNumberList.set($(this).val(), $(this).text());
        }
    });

    eventHandler();
    $('#addMoreCondition, #addMoreConditionEdit').on('click', function (){

        var deviceOptions = '';
        for(let [key, value] of deviceList.entries()){
            deviceOptions += '<option value="' + key + '">' + value + '</option>\n';
        }
        var appendHtml =
            '<div class="row-condition">\n' +
            '<div class="row py-1">\n' +
            '                                <div class="col-md-5"></div>\n' +
            '                                <div class="col-md-2">\n' +
            '                                    <select class="form-select logical-operator">\n' +
            '                                        <option value="and">And</option>\n' +
            '                                        <option value="or">Or</option>\n' +
            '                                    </select>\n' +
            '                                </div>\n' +
            '                                <div class="col-md-5"></div>\n' +
            '                            </div>' +
            '              <div class="row py-1">\n' +
            '                                <div class="col-md">\n' +
            '                                    <select class="form-select device-list">\n' +
            '                                        <option selected disabled value="">Select Device</option>\n' +
                                                        deviceOptions +
            '                                    </select>\n' +
            '                                </div>\n' +
            '                                <div class="col-md">\n' +
            '                                    <select class="form-select var-list">\n' +
            '                                        <option selected disabled value="">Select variable</option>\n' +
            '                                    </select>\n' +
            '                                </div>\n' +
            '                                <div class="col-md">\n' +
            '                                    <select class="form-select op-list">\n' +
            '                                        <option selected disabled value="">Select operator</option>\n' +
            '                                        <option value="=">Equal to</option>\n' +
            '                                        <option value=">">Greater than</option>\n' +
            '                                        <option value="<">Less than</option>\n' +
            '                                    </select>\n' +
            '                                </div>\n' +
            '                                <div class="col-md-2">\n' +
            '                                    <input name="name" type="text" placeholder="Threshold" class="form-control input-threshold" maxlength="50" autocomplete="off" required>\n' +
            '                                </div>\n' +
            '                                <div class="col-sm-1 pt-sm-2">\n' +
            '                                    <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-cond"></i>\n' +
            '                                </div>' +
            '</div>' +
            '                            </div>';
        if ($(this).attr('id') == "addMoreCondition") {
            $('#conditionLst').append(appendHtml)
        }else {
            $('#conditionLstEdit').append(appendHtml)
        }
        eventHandler();
    });
    $('#addMoreAction, #addMoreActionEdit').on('click', function (){


        var appendHtml = '<div class="row pb-3 row-action">\n' +
            '                                <div class="col-md">\n' +
            '                                    <select class="form-select actionType-list">\n' +
            '                                        <option selected disabled value="">Select action</option>\n' +
            '                                        <option value="sms">Sms</option>\n' +
            '                                        <option value="email">Email</option>\n' +
            '                                    </select>\n' +
            '                                </div>\n' +
            '                                <div class="col-md">\n' +
            '                                    <input type="text" placeholder="Receiver" class="form-control input-receiver" maxlength="50" autocomplete="off" required>\n' +
            '                                </div>\n' +
            '                                <div class="col-md">\n' +
            '                                    <input type="text" placeholder="Subject" class="form-control input-subject" maxlength="50" autocomplete="off" required>\n' +
            '                                </div>\n' +
            '                                <div class="col-md">\n' +
            '                                    <input type="text" placeholder="Message" class="form-control input-message" maxlength="50" autocomplete="off" required>\n' +
            '                                </div>\n' +
            '\n' +
            '                                <div class="col-sm-1 pt-sm-2">\n' +
            '                                    <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-action"></i>\n' +
            '                                </div>' +
            '                            </div>';

        if ($(this).attr('id') == "addMoreAction") {
            $('#actionList').append(appendHtml)
        }else {
            $('#actionListEdit').append(appendHtml)
        }
        eventHandler();
    });
});

function eventHandler(){
    $('#conditionLst .icon-remove-cond').on('click', function (){
        if ($('#conditionLst').children().length > 1){
            $(this).parents('.row-condition').remove()
        }
    });
    $('#actionList .icon-remove-action').on('click', function (){
        if ($('#actionList').children().length > 1){
            $(this).parents('.row-action').remove()
        }
    });
    $('#conditionLstEdit .icon-remove-cond').on('click', function (){
        if ($('#conditionLstEdit').children().length > 1){
            $(this).parents('.row-condition').remove()
        }
    });
    $('#actionListEdit .icon-remove-action').on('click', function (){
        if ($('#actionListEdit').children().length > 1){
            $(this).parents('.row-action').remove()
        }
    });
    $('.device-list').on('change', function (){
        getVarsByDevice(this, null)
    });
    $('#conditionLstEdit .var-list').on('focus', function (){
        var parentDiv = $(this).parent().parent().children()[0];
        getVarsByDevice($(parentDiv).children('.device-list'), $(this).val())
    });
    $('.var-list').on('change', function (){
        var varType =  $('option:selected', this).attr('name');
        var parentDiv = $(this).parent().parent().children()[2];
        var opListDrd = $(parentDiv).children('.op-list')
        $(parentDiv).children('.op-list').empty().append('<option selected disabled value="">Select Operator</option>');
        if (varType == "number") {
            for(let [key, value] of operatorNumberList.entries()){
                $(parentDiv).children('.op-list').append('<option value="' + key + '">' + value + '</option>');
            }
        }else {
            for(let [key, value] of operatorStringList.entries()){
                $(parentDiv).children('.op-list').append('<option value="' + key + '">' + value + '</option>');
            }
        }
    });
}

function deleteEvent(id) {
    $("#idEventDelete").val(id);
}

function processDeleteEvent() {
    var groupData = new FormData();
    groupData.id = $('#idEventDelete').val();
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
                showNotification('success',data.resultString);
                setTimeout(function () {
                    window.location.reload();
                },1000);
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

function getEvent(id) {
    var r = jsRoutes.controllers.EventController.getEvent();
    $.ajax({
        type: r.type,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        url: r.url + '?id=' + id,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $('#eventNameEdit').val(data.content.name)
                $('#eventIdEdit').val(data.content.eventid)
                $('#eventStatus').prop('checked', data.content.status);
                var devicesHtml = '';
                var varsHtml = '';
                var operatorHtml = '';
                var logicalOpHtml = '';
                $('#conditionLstEdit').empty();
                for (const [i, cond] of data.content.condition.entries()) {
                    devicesHtml = '';
                    varsHtml = '';
                    operatorHtml = '';
                    logicalOpHtml = '';
                    var thresholdHtml = '<input value="' +cond.threshold + '" type="text" placeholder="Threshold" class="form-control input-threshold" maxlength="50" autocomplete="off" required>\n'
                    for(let [key, value] of deviceList.entries()){
                        if(cond.deviceID == key){
                            devicesHtml += '<option selected value="' + key + '">' + value + '</option>\n';
                        } else {
                            devicesHtml += '<option value="' + key + '">' + value + '</option>\n';
                        }
                    }
                    varsHtml = '<option selected value="' + cond.variableName + '">' + cond.variableName + '</option>\n';

                    if (cond.variableType == "number") {
                        for(let [key, value] of operatorNumberList.entries()){
                            if(cond.operator == key){
                                operatorHtml += '<option selected value="' + key + '">' + value + '</option>\n';
                            } else {
                                operatorHtml += '<option value="' + key + '">' + value + '</option>\n';
                            }
                        }
                    }else {
                        for(let [key, value] of operatorStringList.entries()){
                            if(cond.operator == key){
                                operatorHtml += '<option selected value="' + key + '">' + value + '</option>\n';
                            } else {
                                operatorHtml += '<option value="' + key + '">' + value + '</option>\n';
                            }
                        }
                    }

                    if (cond.logicalOperator == "and" ){
                        logicalOpHtml = '<option selected value="and">And</option>\n' +
                            '<option value="or">Or</option>\n';
                    }else {
                        logicalOpHtml = '<option value="and">And</option>\n' +
                            '<option selected value="or">Or</option>\n';
                    }
                    var appendHtml = '';
                    if (i==0) {
                        appendHtml = '<div class="row pt-3 pb-1">\n' +
                            '                                <div class="col-md">\n' +
                            '                                    <select id="listDeviceDrd" class="form-select device-list">\n' +
                            '                                        <option selected disabled value="">Select device</option>\n' +
                            devicesHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md">\n' +
                            '                                    <select id="listVarDrd" class="form-select var-list">\n' +
                            '                                        <option disabled selected value="">Select variable</option>\n' +
                            varsHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md">\n' +
                            '                                    <select id="listOprDrd" class="form-select op-list">\n' +
                            '                                        <option selected disabled value="">Select operator</option>\n' +
                            operatorHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md-2">\n' +
                            thresholdHtml +
                            '                                </div>\n' +
                            '                                <div class="col-sm-1 pt-sm-2">\n' +
                            '                                    <i style="font-size: 16px; cursor: pointer; visibility: hidden" class="bx bxs-trash-alt icon-remove-cond"></i>\n' +
                            '                                </div>\n' +
                            '                            </div>';
                    } else {
                        appendHtml =
                            '<div class="row-condition">\n' +
                            '<div class="row py-1">\n' +
                            '                                <div class="col-md-5"></div>\n' +
                            '                                <div class="col-md-2">\n' +
                            '                                    <select class="form-select logical-operator">\n' +
                            logicalOpHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md-5"></div>\n' +
                            '                            </div>' +
                            '              <div class="row py-1">\n' +
                            '                                <div class="col-md">\n' +
                            '                                    <select class="form-select device-list">\n' +
                            '                                        <option selected disabled value="">Select Device</option>\n' +
                            devicesHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md">\n' +
                            '                                    <select class="form-select var-list">\n' +
                            '                                        <option selected disabled value="">Select variable</option>\n' +
                            varsHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md">\n' +
                            '                                    <select class="form-select op-list">\n' +
                            '                                        <option selected disabled value="">Select operator</option>\n' +
                            operatorHtml +
                            '                                    </select>\n' +
                            '                                </div>\n' +
                            '                                <div class="col-md-2">\n' +
                            thresholdHtml +
                            '                                </div>\n' +
                            '                                <div class="col-sm-1 pt-sm-2">\n' +
                            '                                    <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-cond"></i>\n' +
                            '                                </div>' +
                            '</div>' +
                            '                            </div>';
                    }
                    $('#conditionLstEdit').append(appendHtml)
                }
                var actionTypeHtml = '';
                var receiverHtml = '';
                var subjectHtml = '';
                var messageHtml = '';
                $('#actionListEdit').empty();
                for (const action of data.content.action) {
                    if (action.actionType == "sms" ){
                        actionTypeHtml = '<option selected value="sms">Sms</option>\n' +
                            '<option value="email">Email</option>\n';
                    }else {
                        actionTypeHtml = '<option value="sms">Sms</option>\n' +
                            '<option selected value="email">Email</option>\n';
                    }
                    receiverHtml = '<input value="' + action.receiver + '" type="text" placeholder="Receiver" class="form-control input-receiver" maxlength="50" autocomplete="off" required>\n'
                    subjectHtml = '<input value="' + action.subject + '" type="text" placeholder="Subject" class="form-control input-subject" maxlength="50" autocomplete="off" required>\n'
                    messageHtml = '<input value="' + action.message + '" type="text" placeholder="Message" class="form-control input-message" maxlength="50" autocomplete="off" required>\n'
                    var appendHtml = '<div class="row pb-3 row-action">\n' +
                        '                                <div class="col-md">\n' +
                        '                                    <select id="listActionTypeDrd" class="form-select actionType-list">\n' +
                        '                                        <option selected disabled value="">Select action</option>\n' +
                        actionTypeHtml +
                        '                                    </select>\n' +
                        '                                </div>\n' +
                        '                                <div class="col-md">\n' +
                        receiverHtml +
                        '                                </div>\n' +
                        '                                <div class="col-md">\n' +
                        subjectHtml +
                        '                                </div>\n' +
                        '                                <div class="col-md">\n' +
                        messageHtml +
                        '                                </div>\n' +
                        '                                <div class="col-sm-1 pt-sm-2">\n' +
                        '                                    <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-action"></i>\n' +
                        '                                </div>\n' +
                        '                            </div>';
                    $('#actionListEdit').append(appendHtml)
                }
                $('#editEventModal #monday-edit').prop('checked', data.content.interval.monday);
                $('#editEventModal #tuesday-edit').prop('checked', data.content.interval.tuesday);
                $('#editEventModal #wednesday-edit').prop('checked', data.content.interval.wednesday);
                $('#editEventModal #thursday-edit').prop('checked', data.content.interval.thursday);
                $('#editEventModal #friday-edit').prop('checked', data.content.interval.friday);
                $('#editEventModal #saturday-edit').prop('checked', data.content.interval.saturday);
                $('#editEventModal #sunday-edit').prop('checked', data.content.interval.sunday);

                $('#editEventModal #startTime-edit').val(data.content.interval.starttime);
                $('#editEventModal #endTime-edit').val(data.content.interval.endtime);
                eventHandler();
            }else{  //tra ve cau hinh truoc do
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

function updateEvent(){
    var groupData = new FormData();
    groupData.name = $('#newEventName').val()
    var conditions = [];
    $('#conditionLstEdit').children().each(function (){
        var ddrVariable = $(this).find('.var-list')[0]
        var ddrDevice = $(this).find('.device-list')[0]
        var ddrOperator = $(this).find('.op-list')[0]
        var inpThreshold = $(this).find('.input-threshold')[0]
        var ddrLogicalOp = $(this).find('.logical-operator')[0]
        if ($(ddrVariable).val() != null && $(ddrVariable).val() != "" ){
            var condition = {
                "deviceid": $(ddrDevice).val(),
                "variableName": $(ddrVariable).val(),
                "operator": $(ddrOperator).val(),
                "threshold": $(inpThreshold).val(),
                "logicalOperator": ddrLogicalOp != undefined ? $(ddrLogicalOp).val() : "and"
            };
            conditions.push(condition);
        }
    });
    groupData.conditions = conditions;

    var actions = [];
    $('#actionListEdit').children().each(function (){
        var ddrActionType = $(this).find('.actionType-list')[0]
        var inputReceiver = $(this).find('.input-receiver')[0]
        var inputSubject = $(this).find('.input-subject')[0]
        var inputMessage = $(this).find('.input-message')[0]
        if ($(ddrActionType).val() != null && $(ddrActionType).val() != "" && $(inputReceiver).val() != ""
            && $(inputSubject).val() != "" && $(inputMessage).val() != ""){
            var action = {
                "actionType": $(ddrActionType).val(),
                "receiver": $(inputReceiver).val(),
                "subject": $(inputSubject).val(),
                "message": $(inputMessage).val(),
            };
            actions.push(action);
        }
    });
    groupData.actions = actions;
    var interval = {
        "monday": $('#monday-edit').is(':checked'),
        "tuesday": $('#tuesday-edit').is(':checked'),
        "wednesday": $('#wednesday-edit').is(':checked'),
        "thursday": $('#thursday-edit').is(':checked'),
        "friday": $('#friday-edit').is(':checked'),
        "saturday": $('#saturday-edit').is(':checked'),
        "sunday": $('#sunday-edit').is(':checked'),
        "starttime": $('#startTime-edit').val(),
        "endtime": $('#endTime-edit').val(),
    }

    var body = {
        "id" : $('#eventIdEdit').val(),
        "name" : $('#eventNameEdit').val(),
        "condition": conditions,
        "action": actions,
        "interval": interval,
        "status": $('#eventStatus').is(':checked')
    }

    groupData.monday = $('#monday').is(':checked');
    groupData.tuesday = $('#tuesday').is(':checked');
    groupData.wednesday = $('#wednesday').is(':checked');
    groupData.thursday = $('#thursday').is(':checked');
    groupData.friday = $('#friday').is(':checked');
    groupData.saturday = $('#saturday').is(':checked');
    groupData.sunday = $('#sunday').is(':checked');

    groupData.startTime = $('#startTime').val();
    groupData.endTime = $('#endTime').val();

    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.EventController.updateEvent();
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
                setTimeout(function () {
                    window.location.reload();
                },1000);
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

function setEventOrg(eventId,orgId){
    localStorage.setItem("selectedEvent",eventId);
    localStorage.setItem("selectedEventOrg",orgId);
    value = "" + orgId;
    $('#listOrg').val(value);
}

function changeEventOrganization(){
    var Data = new FormData();
    Data.eventId = localStorage.getItem("selectedEvent");
    Data.orgId = $('#listOrg').val();

    StartProcess()
    var r = jsRoutes.controllers.EventController.changeEventOrg();

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
function removeEventOrganization(){
    var Data = new FormData();
    Data.eventId = localStorage.getItem("selectedEvent");
    Data.orgId = localStorage.getItem("selectedEventOrg");

    StartProcess()
    var r = jsRoutes.controllers.EventController.removeEventOrg();
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

function activeEvent(eventId){
    var Data = new FormData();
    Data.eventId = eventId;

    StartProcess()
    var r = jsRoutes.controllers.EventController.activeEvent();
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
function deActiveEvent(eventId){
    var Data = new FormData();
    Data.eventId = eventId;

    StartProcess()
    var r = jsRoutes.controllers.EventController.deActiveEvent();
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
