/**
 * Created by vtk-anhlt166 on 12/21/21.
 */
var hostname;
$(document).ready(function () {
    hostname = location.protocol + '//' + location.host;
    console.log(hostname);
});

function getInfoOrg(orgId) {
    console.log(orgId);
    if(orgId == projectId || orgId.length == 0){
        document.getElementById("tabAttribute").style.display = "none";

        $("#infoIdOrg").html("");
        $("#infoNameOrg").html(nameProject);
        $("#infoContentOrg").html("");

        currentSelectedGroup = {"id": projectId};
    } else {
        document.getElementById("tabAttribute").style.display = "block";

        StartProcess();

        var groupData = new FormData;
        groupData.orgId = orgId;

        var r = jsRoutes.controllers.GroupController.getInfoOrg();
        $.ajax({
            dataType: 'json',
            data: JSON.stringify(groupData),
            contentType: "application/json",
            url: r.url,
            type: r.type,
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                if (data.success && data.content != null) {
                    currentSelectedGroup = data.content;

                    $("#infoIdOrg").html(data.content.id);
                    $("#infoNameOrg").html(data.content.name);
                    $("#infoContentOrg").html(data.content.description);

                    var img = imgOrgDefault;
                    // var img = "http://localhost:9000/getImg/e21206c04e5d11ecbe19a08cfdd227ee-Screenshot.png";
                    if(data.content.image != null && data.content.image.length>0){
                        img = hostname + "/getImg/" + data.content.image;
                    }
                    $('#imageInfoOrg').attr('src', img);
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
}

function getAtrributeOrg(orgId) {
    if(orgId == projectId){

    } else {

        // StartProcess();

        var groupData = new FormData;
        groupData.orgId = orgId;

        var r = jsRoutes.controllers.GroupController.getAttributeOrg();
        $.ajax({
            dataType: 'json',
            data: JSON.stringify(groupData),
            contentType: "application/json",
            url: r.url,
            type: r.type,
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                if (data.success && data.content != null) {
                    viewAtrributeToTable(data.content.attributes);
                }
            },
            error: function (xhr) {
                console.log(xhr);
                showNotification('danger',Messages("connection.failed"));
            },
            complete: function (jqXHR, textStatus) {
                // FinishProcess(); //Stop display loading...
            }
        })
    }
}

var listAttr = new Array;
function viewAtrributeToTable(attrs) {
    console.log(attrs);
    listAttr = new Array;

    var mtmlAttr = '<span class="input-group-text mb-3" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; ">'+Messages("Danh sách thuộc tính")+'</span>' +
        "<table id='smlAttributeTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("Thuộc tính")+"</th>" +
        // "<th>"+Messages("Mã ID")+"</th>" +
        "<th>"+Messages("Loại thuộc tính")+"</th>" +
        "<th>"+Messages("Loại giá trị")+"</th>" +
        "<th>"+Messages("Lưu lịch sử")+"</th>" +
        "<th>"+Messages("Giá trị hiện tại")+"</th>" +
        "<th>"+Messages("Lần cập nhật cuối")+"</th>" +
        "<th></th>" +
        "</thead>" +
        "<tbody>";

    if (attrs!=null && attrs.length > 0) {
        for (var i = 0; i < attrs.length; i++) {
            listAttr.push(attrs[i].value);

            mtmlAttr += "<tr>";
            mtmlAttr += "<td></td>";
            mtmlAttr += "<td>"+attrs[i].attribute_key+"</td>";
            mtmlAttr += "<td>"+Messages("Server")+"</td>";
            mtmlAttr += "<td>"+getTypeAttr(attrs[i].value_type)+"</td>";
            mtmlAttr += "<td>"+attrs[i].logged+"</td>";
            var value = "";
            if(attrs[i].value_type == "JSON"){
                value = JSON.stringify(attrs[i].value);
            } else {
                value = attrs[i].value;
            }
            mtmlAttr += "<td>"+value+"</td>";
            var last_update_ts = moment.unix(attrs[i].last_update_ts/1000).format("DD/MM/YYYY HH:mm");
            mtmlAttr += "<td>"+last_update_ts+"</td>";
            mtmlAttr += "<td align='center'>";
            mtmlAttr += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlAttr += '<ul class="dropdown-menu dropdown-table">';
            mtmlAttr += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;" onclick="setEditAttrInOrg(\''+attrs[i].attribute_key+'\', \''+attrs[i].value_type+'\', \''+i+'\', \''+attrs[i].logged+'\')"><a class="dropdown-item"><img src="'+iconEdit+'" width="20" alt=""/>&nbsp&nbsp'+Messages("btnEdit")+'</a></li>';
            mtmlAttr += '<li style="cursor: pointer" onclick="setDelAttrInOrg(\''+attrs[i].attribute_key+'\')"><a class="dropdown-item"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp'+Messages("btnDelete")+'</a></li>';
            mtmlAttr += '</ul>';
            mtmlAttr +="</td>";
            mtmlAttr += "</tr>";
        }
    }
    mtmlAttr += "</tbody></table>";
    $("#tabAttribute").html(mtmlAttr);

    var table = $('#smlAttributeTable').DataTable( {
        responsive: true,
        lengthChange: false,
        "order": [],
        "info": false,
        "columnDefs": [ {
            "targets": 0,
            "orderable": false
        } ],
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showPopupAddAttribute' );
                    showPopupAddAttribute();
                }
            }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlAttributeTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}
function getTypeAttr(el) {
    if(el == "STR"){
        return "String";
    } else if(el == "BOOL"){
        return "Boolean";
    } else if(el == "LONG"){
        return "Long";
    } else if(el == "DBL"){
        return "Double";
    } else if(el == "JSON"){
        return "Json";
    }
}

function showPopupAddAttribute() {
    $("#addAttributeModal").modal('show');
}

function processAddAttribute() {
    var formData = new FormData;
    formData.entity_id = currentSelectedGroup.id;
    formData.attribute_key = $("#nameAttrAdd").val();
    formData.entity_type = "ORGANIZATION";
    formData.attribute_type = $("#chooseAttrTypeAdd").val();
    formData.value_t = $("#chooseAttrValueAdd").val();
    formData.value = $("#chooseAttrDefaultAdd").val();
    formData.logged = $("#chooseAttrHistoryAdd").val();
    console.log(formData);

    StartProcess();
    var r = jsRoutes.controllers.AttributeController.addAttribute();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                getAtrributeOrg(currentSelectedGroup.id);
                showNotification('success',data.resultString);
            } else {
                showNotification('error',data.errorString, data.status);
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

//delete
function setDelAttrInOrg(attribute_key) {
    console.log(attribute_key );
    $("#attributeKeyDel").val(attribute_key);

    $("#deleteAttributeConfirm").modal('show');
}
function delAttributeOfOrg() {
    var groupData = new FormData();
    groupData.entity_id = currentSelectedGroup.id;
    groupData.entity_type= "ORGANIZATION";
    groupData.attribute_key = $('#attributeKeyDel').val();
    groupData.attribute_type = "SCOPE_SERVER";

    StartProcess();
    var r = jsRoutes.controllers.AttributeController.deleteAttributeOrg();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            if(data.success){
                getAtrributeOrg(currentSelectedGroup.id);

                showNotification('success',data.resultString);
            }else{
                showNotification('error',data.errorString, data.status);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('error',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });

}

//edit
var loggerCurrent = "";
function setEditAttrInOrg(attribute_key, value_type, i, logger){
    console.log(attribute_key, value_type, i, logger);
    $("#nameAttrEdit").val(attribute_key);
    $("#chooseAttrValueEdit").val(value_type).change();
    if(value_type == "JSON"){
        $("#chooseAttrDefaultEdit").val(JSON.stringify(listAttr[i]));
    } else {
        $("#chooseAttrDefaultEdit").val(listAttr[i]);
    }
    $("#chooseAttrHistoryEdit").val(logger).change();
    loggerCurrent = logger;

    $("#editAttributeModal").modal('show');
}
function processEditAttribute() {
    var formData = new FormData;
    formData.entity_id = currentSelectedGroup.id;
    formData.entity_type = "ORGANIZATION";
    formData.attribute_key = $("#nameAttrEdit").val();
    formData.attribute_type = $("#chooseAttrTypeEdit").val();
    formData.value_t = $("#chooseAttrValueEdit").val();
    formData.value = $("#chooseAttrDefaultEdit").val();
    if($("#chooseAttrHistoryEdit").val() != loggerCurrent){
        formData.logged = $("#chooseAttrHistoryEdit").val();
    }
    console.log(formData);

    StartProcess();
    var r = jsRoutes.controllers.AttributeController.editAttributeOrg();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.content.value || data.content.logged){
                getAtrributeOrg(currentSelectedGroup.id);
                showNotification('success', Messages("noti.Updatesuccess"));
            } else {
                showNotification('error', Messages("noti.Updatefalse"));
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


//up img
$(function () {
    $("#wizard-picture").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
        }
    });
});
function imageIsLoaded(e) {
    $('#wizardPicturePreview').attr('src', e.target.result);
}
function chooseImgDefault() {
    $("#wizard-picture").val("");
    $('#wizardPicturePreview').attr('src', imgOrgDefault);
}
function chooseImgDefaultEdit() {
    $("#wizard-picture-edit").val("");
    $('#wizardPicturePreviewEdit').attr('src', imgOrgDefault);
}

//edit
$(function () {
    $("#wizard-picture-edit").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoadedEdit;
            reader.readAsDataURL(this.files[0]);
        }
    });
});
function imageIsLoadedEdit(e) {
    $('#wizardPicturePreviewEdit').attr('src', e.target.result);
}