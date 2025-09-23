/**
 * Created by vtk-anhlt166 on 10/6/22.
 */
var tableSimList;
$(document).ready(function () {
    tableSimList = $("#listSimTable").DataTable({
        responsive: true,
        order: [[ 7, "desc" ]],
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
    tableSimList.on('order.dt search.dt', function () {
        tableSimList.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();

    setTimeout(function () {
        // getListProjectAll();
        getListDeviceOfProject();
    },500);
});
var listProjectId = ["a802cfe5-ae6b-4381-97ab-494b9277ea63"];
function getListProjectAll() {
    var groupData = new FormData;
    groupData.page = $("#page").val();
    groupData.pageSize = $("#pageSize").val();
    console.log(groupData);

    var r = jsRoutes.controllers.AdminManageSimController.getAllProjectWithPaging();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            // console.log(data);
            if(data.success){
                if(data.content.projects != null && data.content.projects.length > 0){
                    var projects = data.content.projects;
                    projects.forEach(function (item, key) {
                        listProjectId.push(item.id);
                    });
                    // listProjectId.push("a802cfe5-ae6b-4381-97ab-494b9277ea63");
                    console.log(listProjectId);

                    if((data.content.offset + data.content.limit) < data.content.total){
                        $("#page").val(parseInt(groupData.page)+1);
                        getListProjectAll();
                    } else {
                        getListDeviceOfProject();
                    }
                }
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
}

function getListDeviceOfProject() {
    console.log(listProjectId.length);
    var stt = 0;
    if(listProjectId.length > 0){
        // for(stt=0; stt<listProjectId.length; stt++){
        //     listDeviceWithProjectId(1, 15, listProjectId[stt]);
        // }
        listDeviceWithProjectId(1, 15, 0);
    }
}

var listDevice = [];
function listDeviceWithProjectId(page, pageSize, index) {
    var groupData = new FormData;
    groupData.page = page;
    groupData.pageSize = pageSize;
    groupData.projectId = listProjectId[index];
    console.log(groupData);

    var r = jsRoutes.controllers.AdminManageSimController.getListDeviceWithProjectId();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content.devices != null && data.content.devices.length > 0){
                    var devices = data.content.devices;
                    devices.forEach(function (item, key) {
                        listDevice.push(item.id);
                    })
                }
                // console.log(listDevice);
                if((data.content.offset + data.content.limit) < data.content.total){
                    listDeviceWithProjectIdNext(parseInt(page)+1, pageSize, groupData.projectId);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
            index++;
            if(index <= listProjectId.length-1){
                listDeviceWithProjectId(1, 15, index);
            } else {
                processGetAttrTppDevice();
            }
        }
    });
}
function listDeviceWithProjectIdNext(page, pageSize, projectId) {
    // console.log(page, pageSize, projectId);
    var groupData = new FormData;
    groupData.page = page;
    groupData.pageSize = pageSize;
    groupData.projectId = projectId;
    console.log(groupData);

    var r = jsRoutes.controllers.AdminManageSimController.getListDeviceWithProjectId();
    // StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if(data.success){
                if(data.content.devices != null && data.content.devices.length > 0){
                    var devices = data.content.devices;
                    devices.forEach(function (item, key) {
                        listDevice.push(item.id);
                    })
                }
                // console.log(listDevice);
                if((data.content.offset + data.content.limit) < data.content.total && page < 1){
                    listDeviceWithProjectIdNext(parseInt(page)+1, pageSize, projectId);
                }
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
}

function processGetAttrTppDevice() {
    console.log(listDevice.length);
    getValueAttrSimDevice(0);
}
function getValueAttrSimDevice(index) {
    var groupData = new FormData;
    groupData.deviceId = listDevice[index];
    console.log(groupData);

    var r = jsRoutes.controllers.AdminManageSimController.getAttrSimDevice();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            // console.log(data);
            if(data.success){
                console.log(data);
                if(data.content.value != null){
                    if(data.content.value.simnb != null && data.content.value.simnb != ""){
                        var arrayTr = [];
                        arrayTr.push(index+1);
                        arrayTr.push(data.content.value.simnb != null ? data.content.value.simnb : "");
                        arrayTr.push(data.content.value.imsinb != null ? data.content.value.imsinb : "");
                        arrayTr.push(data.content.value.pronb != null ? data.content.value.pronb : "");
                        arrayTr.push((data.content.value.balnb != null && data.content.value.balnb != "") ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(parseInt(data.content.value.balnb))) : 0);
                        arrayTr.push((data.content.value.pronb != null && data.content.value.pronb != "") ? "ACTIVE" : "DEACTIVE");
                        arrayTr.push("Không");
                        arrayTr.push(data.content.value.expnb != null ? data.content.value.expnb : "");
                        arrayTr.push('<button type="button" class="btn btn-success" onclick="remotePageDetailSim(\''+data.content.value.simnb+'\')"><i class="bx bx-info-square me-0"></i></button>');

                        tableSimList.row.add(arrayTr).draw();
                    }
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            // showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            index++;
            if(index <= listDevice.length-1){
                getValueAttrSimDevice(index);
            } else {
                FinishProcess(); //Stop display loading...
            }
        }
    });
}

function remotePageDetailSim(simNb) {
    localStorage.simNb = simNb;
    window.open(jsRoutes.controllers.ManageSimController.detailSim(projectId, simNb).url, '_blank');
}