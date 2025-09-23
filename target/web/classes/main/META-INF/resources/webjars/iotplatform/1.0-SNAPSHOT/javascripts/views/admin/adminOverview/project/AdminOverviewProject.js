/**
 * Created by vtk-anhlt166 on 8/22/22.
 */
$(document).ready(function () {
    getNameProject();

    totalDeviceActive();
    totalDeviceConnect();
    totalUser();
    totalCustomer();
});

function totalDeviceActive() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/device?project_id="+projectId;
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalDeviceActive").html(data.content.total);
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

function totalDeviceConnect() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/deviceactive?project_id="+projectId;
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalDevice").html(data.content.total);
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

function totalUser() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/tenant";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalUser").html(data.content.total);
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

function totalCustomer() {
    var modalData = new FormData;
    modalData.url = "/api/overviews/enduser";
    StartProcess();
    var r = jsRoutes.controllers.AdminOverviewController.getTotalOverview();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(modalData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#totalCustomer").html(data.content.total);
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

function getNameProject() {
    StartProcess();
    var r = jsRoutes.controllers.ProjectController.getNameProject(projectId);
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: "",
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                $("#nameProject").html(Messages("Tổng quan dự án ") + (data.content != null ? data.content : ""));
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