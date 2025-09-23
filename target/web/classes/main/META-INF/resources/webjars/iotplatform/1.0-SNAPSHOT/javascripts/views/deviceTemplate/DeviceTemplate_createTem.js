/**
 * Created by vtk-anhlt166 on 6/14/22.
 */
var listTemplate;
var listDeviceType;
var listBusinessType;
var listGroupType;
var listProtocol;
$(document).ready(function () {
    getListTempDevice();
});
function showCreateTemp() {
    $("#chooseDeviceTemplateModal").modal('show');
}
function getListTempDevice() {
    StartProcess();
    var r = jsRoutes.controllers.TemplateDeviceController.getListTemplateDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            listTemplate = [];
            listDeviceType = [];
            listBusinessType = [];
            listGroupType = [];
            listProtocol = [];

            if(data.content != null && data.content.length > 0){
                listTemplate = data.content;
                for(var i=0; i<data.content.length; i++){
                    var deviceType = data.content[i].deviceType;
                    var businessType = data.content[i].businessType;
                    var deviceGroup = data.content[i].deviceGroup;

                    if(!listDeviceType.includes(deviceType)){
                        listDeviceType.push(deviceType);
                    }
                    if(!listBusinessType.includes(businessType)){
                        listBusinessType.push(businessType);
                    }
                    if(!listGroupType.includes(deviceGroup)){
                        listGroupType.push(deviceGroup);
                    }

                    var protocols = data.content[i].protocols;
                    if(protocols != null && protocols.length > 0){
                        var arrProtocol = protocols.split(',');
                        if(arrProtocol.length > 0){
                            for(var p=0; p<arrProtocol.length; p++){
                                if(!listProtocol.includes(arrProtocol[p])){
                                    listProtocol.push(arrProtocol[p]);
                                }
                            }
                        }
                    }
                }
            }

            // console.log(listDeviceType);
            // console.log(listBusinessType);
            // console.log(listGroupType);
            // console.log(listProtocol);

            var optionDeviceType = "";
            if(listDeviceType.length>0){
                for(var t=0; t<listDeviceType.length; t++){
                    optionDeviceType += '<div class="form-check">'+
                        '<input class="form-check-input" type="radio" name="flexRadioDefault1" onchange="change_deviceType(\''+listDeviceType[t]+'\')" style="margin-top: 0.25em;font-size: 20px;">'+
                        '<h4 class="mt-1">'+listDeviceType[t]+'</h4>'+
                        '</div>';
                }
            }
            $("#listDeviceType").html(optionDeviceType);
            // change_deviceType(listDeviceType[0]);

            var optionBusinessType = "";
            if(listBusinessType.length>0){
                for(var b=0; b<listBusinessType.length; b++){
                    optionBusinessType += '<div class="form-check">'+
                        '<input class="form-check-input" type="radio" name="flexRadioDefault2" onchange="change_businessType(\''+listBusinessType[b]+'\')" style="margin-top: 0.25em;font-size: 20px;">'+
                        '<h4 class="mt-1">'+listBusinessType[b]+'</h4>'+
                        '</div>';
                }
            }
            $("#listBusinessType").html(optionBusinessType);

            var optionGroupType = "";
            if(listGroupType.length>0){
                for(var g=0; g<listGroupType.length; g++){
                    optionGroupType += '<div class="form-check">'+
                        '<input class="form-check-input" type="radio" name="flexRadioDefault3" onchange="change_groupType(\''+listGroupType[g]+'\')" style="margin-top: 0.25em;font-size: 20px;">'+
                        '<h4 class="mt-1">'+listGroupType[g]+'</h4>'+
                        '</div>';
                }
            }
            $("#listGroupType").html(optionGroupType);

            var optionProtocol = "";
            if(listProtocol.length>0){
                for(var p=0; p<listProtocol.length; p++){
                    optionProtocol += '<div class="form-check">'+
                        '<input class="form-check-input" type="radio" name="flexRadioDefault4" onchange="change_protocolType(\''+listProtocol[p]+'\')" style="margin-top: 0.25em;font-size: 20px;">'+
                        '<h4 class="mt-1">'+listProtocol[p]+'</h4>'+
                        '</div>';
                }
            }
            $("#listProtocol").html(optionProtocol);
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

function change_deviceType(deviceType) {
    console.log(deviceType);
    console.log(listTemplate);
    var listImgDeviceType = "";
    for(var i=0; i<listTemplate.length; i++){
        if(listTemplate[i].deviceType == deviceType){
            listImgDeviceType +=
                '<div class="col-md-6">'+
                '<div class="alert border-0 alert-dismissible fade show py-2" style="background-color: #aaa">'+
                '<div class="d-flex align-items-center">'+
                '<div style="padding-right: 15px;"><input class="form-check-input" type="radio" name="radioChooseDeviceType" onchange="choose_deviceTemplate(\''+listTemplate[i].id+'\')" style="font-size: 20px;"></div>'+
                '<div class="font-35 ml-3">'+
                '<img src="'+listTemplate[i].urlImage+'" height="45">'+
                '</div>'+
                '<div class="ms-3">'+
                '<h6 class="mb-0 text-white">'+listTemplate[i].deviceName+'</h6>'+
                '<div class="text-white">'+listTemplate[i].protocols+'</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
        }
    }
    $("#listImgDeviceType").html(listImgDeviceType);
}

function change_businessType(businessType) {
    console.log(businessType);
    console.log(listTemplate);
    var listImgBusinessType = "";
    for(var i=0; i<listTemplate.length; i++){
        if(listTemplate[i].businessType == businessType){
            listImgBusinessType +=
                '<div class="col-md-6">'+
                '<div class="alert border-0 alert-dismissible fade show py-2" style="background-color: #aaa">'+
                '<div class="d-flex align-items-center">'+
                '<div style="padding-right: 15px;"><input class="form-check-input" type="radio" name="radioChooseDeviceType" onchange="choose_deviceTemplate(\''+listTemplate[i].id+'\')" style="font-size: 20px;"></div>'+
                '<div class="font-35 ml-3">'+
                '<img src="'+listTemplate[i].urlImage+'" height="45">'+
                '</div>'+
                '<div class="ms-3">'+
                '<h6 class="mb-0 text-white">'+listTemplate[i].deviceName+'</h6>'+
                '<div class="text-white">'+listTemplate[i].protocols+'</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
        }
    }
    $("#listImgBusinessType").html(listImgBusinessType);
}

function change_groupType(groupType) {
    console.log(groupType);
    console.log(listTemplate);
    var listImgGroupType = "";
    for(var i=0; i<listTemplate.length; i++){
        if(listTemplate[i].deviceGroup == groupType){
            listImgGroupType +=
                '<div class="col-md-6">'+
                '<div class="alert border-0 alert-dismissible fade show py-2" style="background-color: #aaa">'+
                '<div class="d-flex align-items-center">'+
                '<div style="padding-right: 15px;"><input class="form-check-input" type="radio" name="radioChooseDeviceType" onchange="choose_deviceTemplate(\''+listTemplate[i].id+'\')" style="font-size: 20px;"></div>'+
                '<div class="font-35 ml-3">'+
                '<img src="'+listTemplate[i].urlImage+'" height="45">'+
                '</div>'+
                '<div class="ms-3">'+
                '<h6 class="mb-0 text-white">'+listTemplate[i].deviceName+'</h6>'+
                '<div class="text-white">'+listTemplate[i].protocols+'</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
        }
    }
    $("#listImgGroupType").html(listImgGroupType);
}

function change_protocolType(protocol) {
    console.log(protocol);
    console.log(listTemplate);
    var listImgProtocol = "";
    for(var i=0; i<listTemplate.length; i++){
        var strProtocol = listTemplate[i].protocols;
        if(strProtocol != null && strProtocol.length > 0){
            var arrProtocol = strProtocol.split(',');
            if(arrProtocol.length > 0){
                if(arrProtocol.includes(protocol)){
                    listImgProtocol +=
                        '<div class="col-md-6">'+
                        '<div class="alert border-0 alert-dismissible fade show py-2" style="background-color: #aaa">'+
                        '<div class="d-flex align-items-center">'+
                        '<div style="padding-right: 15px;"><input class="form-check-input" type="radio" name="radioChooseDeviceType" onchange="choose_deviceTemplate(\''+listTemplate[i].id+'\')" style="font-size: 20px;"></div>'+
                        '<div class="font-35 ml-3">'+
                        '<img src="'+listTemplate[i].urlImage+'" height="45">'+
                        '</div>'+
                        '<div class="ms-3">'+
                        '<h6 class="mb-0 text-white">'+listTemplate[i].deviceName+'</h6>'+
                        '<div class="text-white">'+listTemplate[i].protocols+'</div>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                        '</div>';
                }
            }
        }
    }
    $("#listImgProtocol").html(listImgProtocol);
}

function choose_deviceTemplate(id) {
    $("#idDeviceTemplateChoose").val(id);
    $("#tableAttributeTemplateDevice").html("");
    var item = listTemplate.find(item => item.id === id);
    console.log(item);

    var mtmlBody = "<h4>"+item.deviceName+"</h4>" +
        "<table id='attrTemDevice' class='table align-middle mb-0 table-responsive table-striped mt-3' style='width: 100%;'>" +
        "<thead >" +
        "<th>"+Messages("No")+"</th>" +
        "<th>"+Messages("Attribute")+"</th>" +
        "<th>"+Messages("Type")+"</th>" +
        "<th>"+Messages("Save Log")+"</th>" +
        "<th>"+Messages("Content")+"</th>" +
        "</thead>" +
        "<tbody>";
    if(item != null){
        if(item.templateDeviceAttributeList != null && item.templateDeviceAttributeList.length > 0){
            var data = item.templateDeviceAttributeList;
            for (var i = 0; i < data.length; i++) {
                mtmlBody += "<tr>";
                mtmlBody += "<td></td>";
                mtmlBody += "<td>" + data[i].attribute + "</td>";
                mtmlBody += "<td>" + data[i].attrType + "</td>";
                mtmlBody += "<td>" + data[i].saveLog + "</td>";
                mtmlBody += "<td>" + data[i].contentAttr + "</td>";
                mtmlBody += "</tr>";
            }
        }
    }
    mtmlBody += "</tbody></table>";
    $("#tableAttributeTemplateDevice").html(mtmlBody);

    var table = $("#attrTemDevice").DataTable({
        responsive: true,
        order: [[ 0, "desc" ]],
        lengthMenu: [
            [ 10, 50, -1],
            ['10', '50', 'Tất cả']
        ],
        "columnDefs": [ {
            "targets": 0,
            "orderable": false
        } ],
        searching: true,
        "bLengthChange" : true,
        "bInfo":true
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function processCreateTemplateDevice() {
    var formData = new FormData;
    formData.id = $("#idDeviceTemplateChoose").val();
    formData.project_id = projectId;

    StartProcess();
    var r = jsRoutes.controllers.DeviceTemplateController.createTemDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getListDeviceTemplate();
                showNotification('success',data.resultString);
            } else{
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