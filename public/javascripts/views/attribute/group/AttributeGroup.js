/**
 * Created by vtk-anhlt166 on 12/24/21.
 */
$(document).ready(function () {
    getAttributeGroupList();

    searchHistoryAttributeGroup();
});

function getAttributeGroupList() {
    var groupData = new FormData;
    groupData.id = groupId;
    groupData.type = "GROUP";

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
            if (data.success && data.content != null) {
                viewAtrributeGroupToTable(data.content.attributes);
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

var listAttr = new Array;
function viewAtrributeGroupToTable(attrs) {
    console.log(attrs);
    listAttr = new Array;

    var mtmlAttr =
        "<table id='smlAttributeTable' class='table align-middle mb-0 table-responsive' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("Thuộc tính")+"</th>" +
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
            var type = "";
            if(attrs[i].attribute_type == "SCOPE_SHARE"){
                type = "Share";
            } else {
                type = "Server";
            }
            mtmlAttr += "<td>"+type+"</td>";
            mtmlAttr += "<td>"+getTypeAttr(attrs[i].value_type)+"</td>";
            mtmlAttr += "<td>"+attrs[i].logged+"</td>";
            var value = "";
            if(attrs[i].value_type == "JSON"){
                value = JSON.stringify(attrs[i].value);
            } else {
                value = attrs[i].value;
            }
            mtmlAttr += "<td style='word-break: break-all;'>"+value+"</td>";
            var last_update_ts = moment.unix(attrs[i].last_update_ts/1000).format("YYYY/MM/DD HH:mm");
            mtmlAttr += "<td>"+last_update_ts+"</td>";
            mtmlAttr += "<td align='center'>";
            mtmlAttr += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlAttr += '<ul class="dropdown-menu dropdown-table">';
            mtmlAttr += '<li style="cursor: pointer; border-bottom: 1px solid #ccc!important;"><a class="dropdown-item" onclick="setEditAttr(\''+attrs[i].attribute_key+'\', \''+attrs[i].value_type+'\', \''+i+'\', \''+attrs[i].logged+'\')"><img src="'+iconEdit+'" alt=""/>&nbsp&nbsp '+Messages("btnEdit")+'</a></li>';
            mtmlAttr += '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelAttrInOrg(\''+attrs[i].attribute_key+'\', \''+attrs[i].attribute_type+'\')"><img src="'+iconDelete+'" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>';
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
            "targets": 7,
            "orderable": false
        } ],
        buttons: [
            {
                text: Messages("btnAdd"),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showAddAttribute' );
                    showAddAttribute();
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

function showAddAttribute() {
    $("#addAttributeModal").modal('show');
}

function processAddAttribute() {
    var formData = new FormData;
    formData.entity_id = groupId;
    formData.attribute_key = $("#nameAttrAdd").val();
    formData.entity_type = "GROUP";
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
                getAttributeGroupList();
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

//edit
var loggerCurrent = "";
function setEditAttr(attribute_key, value_type, i, logger){
    console.log(attribute_key, value_type, i, logger);
    console.log(listAttr[i]);
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
    formData.entity_id = groupId;
    formData.entity_type = "GROUP";
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
                getAttributeGroupList();
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

//delete
function setDelAttrInOrg(attribute_key, attribute_type) {
    console.log(attribute_key, attribute_type);
    $("#attributeKeyDel").val(attribute_key);
    $("#attributeTypeDel").val(attribute_type);

    $("#deleteAttributeConfirm").modal('show');
}
function delAttributeOfOrg() {
    var groupData = new FormData();
    groupData.entity_id = groupId;
    groupData.entity_type= "GROUP";
    groupData.attribute_key = $('#attributeKeyDel').val();
    groupData.attribute_type = $('#attributeTypeDel').val();

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
                getAttributeGroupList();

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