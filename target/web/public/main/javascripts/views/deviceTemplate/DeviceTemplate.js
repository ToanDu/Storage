/**
 * Created by vtk-anhlt166 on 12/3/21.
 */
$(document).ready(function () {
    getListDeviceTemplate();
});
// $('#searchDeviceTemplate').on('click keyup', function(event) {
//     // Prevent the original click for not reloading the whole page
//     event.preventDefault();
//
//     // Get value from search input
//     var searchInputString = $('#searchDeviceTemplate').val();
//     var regExp = new RegExp(searchInputString, 'i');
//
//     // Search the list and if it matches display it, else hide it
//     $('.list_template').each(function() {
//         var isMatch = $(this).find('h4').text().match(regExp);
//         $(this).toggle((isMatch) ? true : false);
//     });
// });
var templateId;
function getListDeviceTemplate() {
    StartProcess();
    var groupData = new FormData();
    groupData.projectId = projectId;
    console.log(groupData);
    var r = jsRoutes.controllers.DeviceTemplateController.getListDeviceTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                viewListTemplateToTable(datas.content);
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

function viewListTemplateToTable(datas) {
    console.log(datas);

    var mtmlTem =
        "<table id='smlListTemplateTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("Thông tin mẫu thiết bị")+"</th>" +
        "<th>"+Messages("Giao thức")+"</th>" +
        "<th>"+Messages("Nhóm thiết bị")+"</th>" +
        "<th>"+Messages("Thao tác")+"</th>" +
        "</thead>" +
        "<tbody>";

    if (datas.templates && datas.templates.length > 0) {
        for (var i = 0; i < datas.templates.length; i++) {
            mtmlTem += "<tr>";
            mtmlTem += "<td></td>";
            mtmlTem += "<td>"+
                '<a class="cursor-pointer" style="color: red;" data-bs-toggle="modal" data-bs-target="#detailAttrConfirm" onclick="getAttributeTemplateList(\''+datas.templates[i].id+'\')">'+datas.templates[i].name+'</a>' +
                '<br><small>'+Messages("ID: ")+datas.templates[i].id+'</small>' +
                '<br><small>'+Messages("Provision Key: ")+datas.templates[i].provision_key+'</small>' +
                '<br><small>'+Messages("Provision Secret: ")+datas.templates[i].provision_secret+'</small>' +
                "</td>";
            mtmlTem += "<td>"+datas.templates[i].businessType+"</td>";
            mtmlTem += "<td>"+datas.templates[i].deviceGroup+"</td>";
            mtmlTem += "<td align='center'>" ;
            mtmlTem += '<i class="bx bx-grid-vertical " data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>';
            mtmlTem += '<ul class="dropdown-menu dropdown-table">' +
                '<li style="cursor: pointer"><a class="dropdown-item" onclick="setDelTemplate(\''+datas.templates[i].id+'\')"><img src="'+iconDelete+'" width="20" alt=""/>&nbsp&nbsp '+Messages("btnDelete")+'</a></li>' +
                '</ul>';
            mtmlTem +="</td>";
            mtmlTem += "</tr>";
        }
    }
    mtmlTem += "</tbody></table>";
    $("#tabListTemplate").html(mtmlTem);

    var table = $('#smlListTemplateTable').DataTable( {
        responsive: true,
        lengthChange: false,
        "order": [],
        "info": false,
        bSort: false,
        buttons: [
            {
                text: Messages("Tạo mới "),
                className: 'btn-dark',
                action: function ( e, dt, node, config ) {
                    console.log( 'showCreateTemp' );
                    showPopupCreateDeviceTemplate();
                }
            },
            // {
            //     text: Messages("Tạo theo mẫu "),
            //     className: 'btn-dark',
            //     action: function ( e, dt, node, config ) {
            //         console.log( 'showCreateTemp' );
            //         showCreateTemp();
            //     }
            // }
        ]
    } );

    table.buttons().container()
        .appendTo( '#smlListTemplateTable_wrapper .col-md-6:eq(0)' );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function remotePageAttrTemplate(id) {
    window.location.href = jsRoutes.controllers.AttributeController.attributeTemplate(projectId, id).url;
}

//create
function showPopupCreateDeviceTemplate() {
    $("#addDeviceTemplateModal").modal('show');

    StartProcess();
    var groupData = new FormData();
    groupData.projectId = projectId;
    console.log(groupData);
    var r = jsRoutes.controllers.FlowEngineController.getListFlow();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            var mtmlGroup = "<table id='smlFlowsTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
                "<thead>" +
                "<th></th>" +
                "<th>"+Messages("manage.stt")+"</th>" +
                "<th>"+Messages("deviceTemplate.id")+"</th>" +
                "<th>"+Messages("deviceTemplate.nameFlow")+"</th>" +
                "<th></th>" +
                "</thead>" +
                "<tbody>";

            if (datas.content != null && datas.content.data.length > 0) {
                for (var i = 0; i < datas.content.data.length; i++) {
                    mtmlGroup += "<tr>";
                    mtmlGroup += "<td align='center'>" ;
                    mtmlGroup += "<div class='form-check'>";
                    mtmlGroup += '<input type="radio" onchange="change_flow_action(this)" class="form-check-input" name="radio-stacked" value="'+datas.content.data[i].id.id+'" />';
                    mtmlGroup += "</div>";
                    mtmlGroup +="</td>";
                    mtmlGroup += "<td>"+(i+1)+"</td>";
                    mtmlGroup += "<td>" + datas.content.data[i].id.id + "</td>";
                    mtmlGroup += "<td>" + datas.content.data[i].name + "</td>";
                    mtmlGroup += "<td align='center'>" ;
                    mtmlGroup +="</td>";
                    mtmlGroup += "</td>";
                    mtmlGroup += "</tr>";
                }
            }
            mtmlGroup += "</tbody></table>";
            $("#tableListFlowAdd").html(mtmlGroup);

            var table = $('#smlFlowsTable').DataTable( {
                responsive: true,
                lengthChange: false,
                "order": [],
                "info": false,
                "columnDefs": [ {
                    "targets": 0,
                    "orderable": false
                } ]
            } );
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

var idFlow = "";
function change_flow_action(el) {
    idFlow = el.value;
    console.log(idFlow);
}

function postCreateDeviceTemplate() {
    StartProcess();
    var groupData = new FormData();
    groupData.projectId = projectId;
    groupData.name = $("#nameDeviceTemplateAdd").val();
    groupData.idFlow = idFlow;
    console.log(groupData);
    var r = jsRoutes.controllers.DeviceTemplateController.createDeviceTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                getListDeviceTemplate();
                showNotification('success',datas.resultString);
            } else{
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

//detail
function detailTemplate(name, key, secret, id) {
    console.log(id);
    if(templateId != ""){
        removeHoverDeviceTemplateItem(templateId);
    }

    $("#nameDeviceTemplate").html(Messages("Tên: ") + name);
    $("#provisionKey").html(Messages("Provision key: ") + key);
    $("#provisionSecret").html(Messages("Provision secret: ") + secret);

    templateId = id;
    getAttributeTemplateList(id);
    setTimeout(function () {
        setHoverDeviceTemplateItem(id);
    },300)
}

function removeHoverDeviceTemplateItem(id) {
    $('#device-template-' + id).css('background-color', '#858687');
}

function setHoverDeviceTemplateItem(id) {
    $('#device-template-' + id).css('background-color', '#EC1B2E');
}

//del
function setDelTemplate(id) {
    $("#idTemplateDelete").val(id);

    $("#deleteTemplateConfirm").modal('show');
}
function postDataDelTemplate() {
    StartProcess();
    var groupData = new FormData();
    groupData.id = $("#idTemplateDelete").val();

    console.log(groupData);
    var r = jsRoutes.controllers.DeviceTemplateController.deleteDeviceTemplate();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                getListDeviceTemplate();
                showNotification('success',datas.resultString);
            } else{
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}