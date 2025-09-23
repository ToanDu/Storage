var serviceList = new Map();
var servicePermissions = new Map();
var listSvcSelected = []

function createNewRole() {
    var Data = new FormData();
    Data.name = $('#newRoleName').val();
    var policies = []


    $('#resourceList').children().each(function (){
        var ddrService = $(this).find('.form-select.service-list')[0]
        var sltPermission = $(this).find('.chosen-select.permission-list')[0]
        if ($(ddrService).val() != null && $(ddrService).val() != "" && $(sltPermission).val().length > 0 ){
            var policy = {
                "service": $(ddrService).val(),
                "actions": $(sltPermission).val(),
            };
            policies.push(policy);
        }
    });


    var body = {
        "role_name" : $('#newRoleName').val(),
        "services_policy": policies
    }
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.RoleController.addNewRole();
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
                if(data.status === 409){
                    showNotification('danger',Messages("role.existName"));
                } else {
                    showNotification('danger',data.errorString, data.status);
                }
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

function initSelect(){
    $('.chosen-select').chosen({ width: '100%' });
    $('.chosen-choices').addClass('chosen-wrapper');
    $('.chosen-search-input').addClass('chosen-input');
    $('.chosen-results').addClass('chosen-drd');
}

$(document).ready(function () {
    $('#serviceList option').each(function (){
        serviceList.set($(this).val(), $(this).text());
    });
    $('#servicePermissions option').each(function (){
        servicePermissions.set($(this).val(), $(this).text());
    });
    $('.chosen-select').chosen({ width: '100%' });
    $('.chosen-choices').addClass('chosen-wrapper');
    $('.chosen-search-input').addClass('chosen-input');
    $('.chosen-results').addClass('chosen-drd');
    $('#addMore').on('click', function (){


        $('#resourceList').append(addMoreSvc(false))
        eventHandler();
        initSelect();
    });
    $('#addMoreEdit').on('click', function (){

        $('#resourceListEdit').append(addMoreSvc(true))
        eventHandler();
        initSelect();
    });
    eventHandler();
});

function addMoreSvc(isUpdate) {
    var svcOtions = '';
    for(let [key, value] of serviceList.entries()){
        svcOtions += '<option class="' + key + '" value="' + key + '">' + value + '</option>\n';
    }
    var svcPermission = '';
    for(let [key, value] of servicePermissions.entries()){
        if(key === "read"){
            svcPermission += '<option value="' + key + '" selected>' + value + '</option>\n';
        }else{
            svcPermission += '<option value="' + key + '">' + value + '</option>\n';
        }

    }
    // svcPermission = '<option value="create" selected>@Messages("role.permission.create")</option>\n' +
    //     '            <option value="read">@Messages("role.permission.read")</option>\n' +
    //     '            <option value="modify">@Messages("role.permission.modify")</option>\n' +
    //     '            <option value="delete">@Messages("role.permission.delete")</option>'

    if (!isUpdate) {
        return  appendHtml = '<div class="row py-3">\n' +
            '                                    <div class="col-md-3">\n' +
            '                                        <select data-placeholder="Select resource" class="form-select service-list">\n' +
            svcOtions +
            '                                        </select>\n' +
            '                                    </div>\n' +
            '                                    <div class="col-md-8">\n' +
            '                                        <select id="devicePermission" data-placeholder="Lựa chọn nghiệp vụ" multiple class="chosen-select permission-list">\n' +
            svcPermission +
            '                                        </select>\n' +
            '                                    </div>\n' +
            '                                    <div class="col-md-1 pt-sm-2">\n' +
            '                                        <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource"></i>\n' +
            '                                    </div>\n' +
            '                                </div>';
    } else {
        return  appendHtml = '<div class="row py-3">\n' +
            '                                    <div class="col-md-3">\n' +
            '                                        <select data-placeholder="Select resource" class="form-select service-list">\n' +
            svcOtions +
            '                                        </select>\n' +
            '                                    </div>\n' +
            '                                    <div class="col-md-8">\n' +
            '                                        <select id="devicePermission" data-placeholder="Select action" multiple class="chosen-select permission-list">\n' +
            svcPermission +
            '                                        </select>\n' +
            '                                    </div>\n' +
            '                                    <div class="col-md-1 pt-sm-2">\n' +
            '                                        <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource-edit"></i>\n' +
            '                                    </div>\n' +
            '                                </div>';
    }
}

function eventHandler(){
    $('.icon-remove-resource').on('click', function (){
        if ($('#resourceList').children().length > 1){
            $(this).parents('.row.py-3').remove()

        }
    });
    $('.icon-remove-resource-edit').on('click', function (){
        if ($('#resourceListEdit').children().length > 1){
            $(this).parents('.row.py-3').remove()

        }
    });
}


function deleteRole(id) {
    $("#idRoleDelete").val(id);
}
function processDeleteEvent() {
    var groupData = new FormData();
    groupData.id = $('#idRoleDelete').val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.RoleController.deleteRole();
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

function getUpdateView(id) {
    var groupData = new FormData();
    groupData.id = id
    console.log(groupData);

    var r = jsRoutes.controllers.RoleController.getRole();
    $.ajax({
        type: r.type,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        url: r.url + '?id=' + id,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                $('#roleNameEdit').val(data.content.role_name)
                $('#roleIdEdit').val(data.content.id)
                var svcOtions = '';
                var svcPermission = '';
                $('#resourceListEdit').empty();
                for (const policy of data.content.services_policy) {
                    svcOtions = '';
                    svcPermission = '';
                    for(let [key, value] of serviceList.entries()){
                        if(policy.resource[0] == key){
                            svcOtions += '<option selected class="' + key + '" value="' + key + '">' + value + '</option>\n';
                        } else {
                            svcOtions += '<option class="' + key + '" value="' + key + '">' + value + '</option>\n';
                        }

                    }
                    for(let [key, value] of servicePermissions.entries()){
                        if (policy.action.includes(key)) {
                            svcPermission += '<option selected value="' + key + '">' + value + '</option>\n';
                        } else {
                            svcPermission += '<option value="' + key + '">' + value + '</option>\n';
                        }

                    }
                    var appendHtml = '<div class="row py-3">\n' +
                        '<input class="policyIdEdit" type="hidden" value="' + policy.id +'">' +
                        '                                    <div class="col-md-3">\n' +
                        '                                        <select data-placeholder="Select resource" class="form-select service-list">\n' +
                        svcOtions +
                        '                                        </select>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="col-md-8">\n' +
                        '                                        <select id="devicePermission" data-placeholder="Select action" multiple class="chosen-select permission-list">\n' +
                        svcPermission +
                        '                                        </select>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="col-md-1 pt-sm-2">\n' +
                        '                                        <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource-edit"></i>\n' +
                        '                                    </div>\n' +
                        '                                </div>';

                    $('#resourceListEdit').append(appendHtml)
                }
                eventHandler();
                initSelect();
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

function updateRole() {
    var Data = new FormData();
    Data.name = $('#roleNameEdit').val();
    var policies = []


    $('#resourceListEdit').children().each(function (){
        var ddrService = $(this).find('.form-select.service-list')[0]
        var sltPermission = $(this).find('.chosen-select.permission-list')[0]
        var policyId = $(this).find('.policyIdEdit')[0]
        if ($(ddrService).val() != null && $(ddrService).val() != "" && $(sltPermission).val().length > 0 ){
            var policy = {
                "service": $(ddrService).val(),
                "actions": $(sltPermission).val(),
            };
            if (policyId != null && $(policyId).val() != "") {
                Object.assign(policy, {"id": $(policyId).val()})
            }

            policies.push(policy);
        }
    });


    var body = {
        "id": $('#roleIdEdit').val(),
        "role_name" : $('#roleNameEdit').val(),
        "services_policy": policies
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.RoleController.updateRole();
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

function showServicePolicy(data) {
    console.log(data);
    console.log(Base64.decode(data));
    var div = "<div>"+Base64.decode(data)+"</div>";
    $("#detailRole").html(div);
}