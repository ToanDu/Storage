/**
 * Created by vtk-anhlt166 on 6/14/22.
 */
$(document).ready(function () {
    getListTemplateDevice();
});
function getListTemplateDevice() {
    StartProcess();
    var r = jsRoutes.controllers.TemplateDeviceController.getListTemplateDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            var mtmlBody = "<table id='listDeviceTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%;'>" +
                "<thead >" +
                "<th>"+Messages("STT")+"</th>" +
                "<th>"+Messages("Business Type")+"</th>" +
                "<th>"+Messages("Device Type")+"</th>" +
                "<th>"+Messages("Device Group")+"</th>" +
                "<th>"+Messages("Device Name")+"</th>" +
                "<th>"+Messages("Protocol")+"</th>" +
                "<th>"+Messages("Url Image")+"</th>" +
                "<th>"+Messages("Attributes")+"</th>" +
                "<th>"+Messages("Action")+"</th>" +
                "</thead>" +
                "<tbody>";
            if(data.success){
                if(data.content.length > 0){
                    for (var i = 0; i < data.content.length; i++) {
                        mtmlBody += "<tr>";
                        mtmlBody += "<td></td>";
                        mtmlBody += "<td>" + data.content[i].businessType + "</td>";
                        mtmlBody += "<td>" + data.content[i].deviceType + "</td>";
                        mtmlBody += "<td>" + data.content[i].deviceGroup + "</td>";
                        mtmlBody += "<td>" + data.content[i].deviceName + "</td>";
                        mtmlBody += "<td>" + data.content[i].protocols + "</td>";
                        mtmlBody += "<td>" + data.content[i].urlImage + "</td>";
                        mtmlBody += "<td>" + JSON.stringify(data.content[i].templateDeviceAttributeList, undefined, 4) + "</td>";
                        mtmlBody += "<td align='center'>" ;
                        mtmlBody += '<button class="btn btn-light" onclick="setEditTemplateDevice(\''+data.content[i].id+'\')" style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#editConfirmModal"><i class="bx bx-edit"></i></button>';
                        mtmlBody += '<button class="btn btn-light" onclick="setDelTemplateDevice(\''+data.content[i].id+'\')" style="cursor: pointer" data-bs-toggle="modal" data-bs-target="#delConfirmModal"><i class="bx bx-trash"></i></button>';
                        mtmlBody += "</td>";
                        mtmlBody += "</tr>";
                    }
                }
            } else{
                showNotification('danger',data.errorString);
            }
            mtmlBody += "</tbody></table>";
            $("#listTemplateDeviceDiv").html(mtmlBody);

            var table = $("#listDeviceTable").DataTable({
                responsive: true,
                order: [[ 4, "desc" ]],
                lengthMenu: [
                    [ 15, 50, -1],
                    ['15', '50', 'Tất cả']
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

var countResource = 0;
function appendResourcesAttr() {
    console.log(countResource);
    countResource++;
    var appendHtml =
        '<div class="row row-Resource">'+
        '<div class="col-sm-1 pt-sm-2">'+
        '<i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource" onclick="removeResourceAttr(this)"></i>'+
        '</div>'+

        '<div class="col-sm-3">'+
        '<div class="form-check-inline">'+
        '<input type="text" class="form-control attribute-list" autocomplete="off" id="nameAttr'+countResource+'" placeholder="attribute name...">'+
        '</div>'+
        '</div>'+

        '<div class="col-sm-2">'+
        '<div class="form-check-inline" style="width: 100%; padding-left: 0px;">'+
        '<select class="form-select mb-3 attrType-list" id="typeAttr'+countResource+'">'+
        '<option value="STR" selected>'+Messages("String")+'</option>'+
        '<option value="DBL">'+Messages("Double")+'</option>'+
        '<option value="BOOL">'+Messages("Boolean")+'</option>'+
        '<option value="JSON">'+Messages("Json")+'</option>'+
        '</select>'+
        '</div>'+
        '</div>'+

        '<div class="col-sm-2">'+
        '<div class="form-check form-check-inline">'+
        '<input class="form-check-input attrCheckbox-list" type="checkbox" id="checkBoxView'+countResource+'" value="option1">'+
        '<label class="form-check-label" for="checkBoxView'+countResource+'">'+Messages("Lưu")+'</label>'+
        '</div>'+
        '</div>'+

        '<div class="col-sm-4">'+
        '<div class="form-check-inline">'+
        '<input type="text" class="form-control attrContent-list" autocomplete="off" id="contentAttr'+countResource+'" placeholder="attribute content...">'+
        '</div>'+
        '</div>'+

        '</div>';

    $('#listAttributeAdd').append(appendHtml)
}
function removeResourceAttr(el) {
    console.log("removeResourceAttr");
    $(el).parents('.row-Resource').remove();
}

function processAddTemplatDevice() {
    var attrs = [];
    $('#listAttributeAdd').children().each(function () {
        var attribute = $(this).find('.attribute-list')[0];
        var type = $(this).find('.attrType-list')[0];
        var checkbox = $(this).find('.attrCheckbox-list')[0];
        var check = false;
        if($(checkbox).is(':checked')){
            check = true;
        }
        var content = $(this).find('.attrContent-list')[0];

        var attr = {
            "attribute": [$(attribute).val()][0],
            "type": [$(type).val()][0],
            "checkbox": check,
            "content": [$(content).val()][0]
        };
        attrs.push(attr);
    });

    var body = {
        "businessType": $("#businessTypeAdd").val(),
        "deviceType": $("#deviceTypeAdd").val(),
        "deviceGroup": $("#deviceGroupAdd").val(),
        "deviceName": $("#deviceNameAdd").val(),
        "protocols": $("#protocolAdd").val(),
        "urlImage": $("#urlImageAdd").val(),
        "attributes": attrs
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TemplateDeviceController.addTemplateDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                getListTemplateDevice();
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


//TODO: EDIT
var countResourceEdit = 0;
function setEditTemplateDevice(id) {
    console.log(id);
    var modalData = new FormData;
    modalData.id = id;
    StartProcess();
    var r = jsRoutes.controllers.TemplateDeviceController.getTemplateDeviceById();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#idTemplateDeviceEdit").val(data.content.id);
                $("#businessTypeEdit").val(data.content.businessType);
                $("#deviceTypeEdit").val(data.content.deviceType);
                $("#deviceGroupEdit").val(data.content.deviceGroup);
                $("#deviceNameEdit").val(data.content.deviceName);
                $("#protocolEdit").val(data.content.protocols);
                $("#urlImageEdit").val(data.content.urlImage);

                var listAttrs = "";
                if(data.content.templateDeviceAttributeList != null && data.content.templateDeviceAttributeList.length > 0){
                    countResourceEdit = data.content.templateDeviceAttributeList.length;
                    var templateDevice = data.content.templateDeviceAttributeList;
                    for(var i=0; i<templateDevice.length; i++){
                        listAttrs +=
                            '<div class="row row-ResourceEdit">'+
                            '<div class="col-sm-1 pt-sm-2">'+
                            '<i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource" onclick="removeResourceAttrEdit(this)"></i>'+
                            '</div>'+

                            '<div class="col-sm-3">'+
                            '<div class="form-check-inline">'+
                            '<input type="text" class="form-control attributeEdit-list" autocomplete="off" id="nameAttrEdit'+i+'" value="'+templateDevice[i].attribute+'">'+
                            '</div>'+
                            '</div>'+

                            '<div class="col-sm-2">'+
                            '<div class="form-check-inline" style="width: 100%; padding-left: 0px;">'+
                            '<select class="form-select mb-3 attrTypeEdit-list" id="typeAttrEdit'+i+'">'+
                            '<option value="STR" '+(templateDevice[i].attrType == "STR" ? "selected" : "")+'>'+Messages("String")+'</option>'+
                            '<option value="DBL" '+(templateDevice[i].attrType == "DBL" ? "selected" : "")+'>'+Messages("Double")+'</option>'+
                            '<option value="BOOL" '+(templateDevice[i].attrType == "BOOL" ? "selected" : "")+'>'+Messages("Boolean")+'</option>'+
                            '<option value="JSON" '+(templateDevice[i].attrType == "JSON" ? "selected" : "")+'>'+Messages("Json")+'</option>'+
                            '</select>'+
                            '</div>'+
                            '</div>'+

                            '<div class="col-sm-2">'+
                            '<div class="form-check form-check-inline">'+
                            '<input class="form-check-input attrCheckboxEdit-list" type="checkbox" id="checkBoxViewEdit'+i+'" '+(templateDevice[i].saveLog == true ? "checked" : "")+'>'+
                            '<label class="form-check-label" for="checkBoxViewEdit'+i+'">'+Messages("Lưu")+'</label>'+
                            '</div>'+
                            '</div>'+

                            '<div class="col-sm-4">'+
                            '<div class="form-check-inline">'+
                            '<input type="text" class="form-control attrContentEdit-list" autocomplete="off" id="contentAttrEdit'+i+'" value="'+templateDevice[i].contentAttr+'">'+
                            '</div>'+
                            '</div>'+

                            '</div>';
                    }
                }
                $("#listAttributeEdit").html(listAttrs);

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
function removeResourceAttrEdit(el) {
    $(el).parents('.row-ResourceEdit').remove();
}
function appendResourcesAttrEdit() {
    console.log(countResourceEdit);
    countResourceEdit++;
    var appendHtml =
        '<div class="row row-ResourceEdit">'+
        '<div class="col-sm-1 pt-sm-2">'+
        '<i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource" onclick="removeResourceAttrEdit(this)"></i>'+
        '</div>'+

        '<div class="col-sm-3">'+
        '<div class="form-check-inline">'+
        '<input type="text" class="form-control attributeEdit-list" autocomplete="off" id="nameAttrEdit'+countResourceEdit+'" placeholder="attribute name...">'+
        '</div>'+
        '</div>'+

        '<div class="col-sm-2">'+
        '<div class="form-check-inline" style="width: 100%; padding-left: 0px;">'+
        '<select class="form-select mb-3 attrTypeEdit-list" id="typeAttrEdit'+countResourceEdit+'">'+
        '<option value="STR" selected>'+Messages("String")+'</option>'+
        '<option value="DBL">'+Messages("Double")+'</option>'+
        '<option value="BOOL">'+Messages("Boolean")+'</option>'+
        '<option value="JSON">'+Messages("Json")+'</option>'+
        '</select>'+
        '</div>'+
        '</div>'+

        '<div class="col-sm-2">'+
        '<div class="form-check form-check-inline">'+
        '<input class="form-check-input attrCheckboxEdit-list" type="checkbox" id="checkBoxViewEdit'+countResourceEdit+'" value="option1">'+
        '<label class="form-check-label" for="checkBoxViewEdit'+countResourceEdit+'">'+Messages("Lưu")+'</label>'+
        '</div>'+
        '</div>'+

        '<div class="col-sm-4">'+
        '<div class="form-check-inline">'+
        '<input type="text" class="form-control attrContentEdit-list" autocomplete="off" id="contentAttrEdit'+countResourceEdit+'" placeholder="attribute content...">'+
        '</div>'+
        '</div>'+

        '</div>';

    $('#listAttributeEdit').append(appendHtml)
}

function processEditTemplatDevice() {
    var attrs = [];
    $('#listAttributeEdit').children().each(function () {
        var attribute = $(this).find('.attributeEdit-list')[0];
        var type = $(this).find('.attrTypeEdit-list')[0];
        var checkbox = $(this).find('.attrCheckboxEdit-list')[0];
        var check = false;
        if($(checkbox).is(':checked')){
            check = true;
        }
        var content = $(this).find('.attrContentEdit-list')[0];

        var attr = {
            "attribute": [$(attribute).val()][0],
            "type": [$(type).val()][0],
            "checkbox": check,
            "content": [$(content).val()][0]
        };
        attrs.push(attr);
    });

    var body = {
        "id": $("#idTemplateDeviceEdit").val(),
        "businessType": $("#businessTypeEdit").val(),
        "deviceType": $("#deviceTypeEdit").val(),
        "deviceGroup": $("#deviceGroupEdit").val(),
        "deviceName": $("#deviceNameEdit").val(),
        "protocols": $("#protocolEdit").val(),
        "urlImage": $("#urlImageEdit").val(),
        "attributes": attrs
    };
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TemplateDeviceController.editTemplateDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                getListTemplateDevice();
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

//TODO: delete
function setDelTemplateDevice(id) {
    $("#idDelete").val(id);
}
function postDeleteTemplateDevice() {
    var modalData = new FormData;
    modalData.id = $("#idDelete").val();
    StartProcess();
    var r = jsRoutes.controllers.TemplateDeviceController.deleteTemplateDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getListTemplateDevice();
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