/**
 * Created by vtk-anhlt166 on 1/6/22.
 */
$(document).ready(function () {
    getDashboardList();
});

function getDashboardList() {
    var groupData = new FormData;
    groupData.projectId = projectId;

    // StartProcess();
    var r = jsRoutes.controllers.DashboardV3Controller.getListDashboard();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if (data.success && data.content != null) {
                viewDashboardList(data.content);
            } else {
                showNotification('error', Messages("noti.Getfalse"));
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

function viewDashboardList(data) {
    var list = "";
    if (data != null && data.length > 0) {
        list =
            "<input checked='checked' class='carousel__activator' id='carousel-slide-activator-1' name='carousel' type='radio'>"+
            "<input class='carousel__activator' id='carousel-slide-activator-2' name='carousel' type='radio'>"+
            "<input class='carousel__activator' id='carousel-slide-activator-3' name='carousel' type='radio'>";

        var control = "";
        var count = Math.floor(data.length/3);
        console.log(count);
        if(count > 0){
            control +=
                "<div class='carousel__controls'>"+
                "<label class='carousel__control carousel__control--forward' for='carousel-slide-activator-2'>"+
                "<i class='bx bx-caret-right'></i>"+
                "</label>"+
                "</div>";
            for(var c=0; c<count-1; c++){
                var left = c+1;
                var right = c+3;
                control +=
                    "<div class='carousel__controls'>"+
                    "<label class='carousel__control carousel__control--backward' for='carousel-slide-activator-"+left+"'>"+
                    "<i class='bx bx-caret-left'></i>"+
                    "</label>"+
                    "<label class='carousel__control carousel__control--forward' for='carousel-slide-activator-"+right+"'>"+
                    "<i class='bx bx-caret-right'></i>"+
                    "</label>"+
                    "</div>";
            }
            control +=
                "<div class='carousel__controls'>"+
                "<label class='carousel__control carousel__control--backward' for='carousel-slide-activator-"+(count)+"'>"+
                "<i class='bx bx-caret-left'></i>"+
                "</label>"+
                "</div>";
        }
        list += control;
    }

    var dashboardList = "<div class='carousel__screen'>"+
                        "<div class='carousel__track'>";
    if (data != null && data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            var date = Messages("Ngày tạo: ") + moment.unix(data[i].logDate/1000).format("DD/MM/YYYY HH:mm");
            var content = Messages("Thông tin mô tả: ") + (data[i].content != null ? data[i].content : "");
            var imgDB = dashboard;
            if(i%3 == 1){
                imgDB = dashboard2;
            } else if(i%3 == 2){
                imgDB = dashboard3;
            }
            dashboardList +=
                '<div class="carousel__item carousel__item--mobile-in-1 carousel__item--tablet-in-2 carousel__item--desktop-in-3 list_dashboard">'+
                '<div class="card w-100">'+
                '<div class="row g-0">'+
                '<div class="card-header border-bottom cardTitle">'+
                '<div class="d-flex align-items-center">'+
                '<div>'+
                '<h6 class="mb-0" style="color: white; text-transform: uppercase;">'+data[i].name+'</h6>'+
                '</div>'+
                '<div class="font-22 ms-auto text-white"><i class="bx bx-dots-horizontal-rounded"></i>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '<div class="row g-0" style="cursor: pointer" onclick="remotePageDetailDashboard(\''+data[i].id+'\')">'+
                '<div class="col-md-6">'+
                '<img src="'+imgDB+'" alt="..." class="card-img" style="height: 200px; padding: 15px">'+
                '</div>'+
                '<div class="col-md-6">'+
                '<div class="card-body" style="height: 100%;overflow: auto; min-height: 100px">'+
                '<p class="card-text">'+date+'</p>'+
                '<p class="card-text"><small class="">'+content+'</small>'+
                '</p>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
        }
    } else {
        document.getElementById("titleNotDashboard").style.display = 'block';
    }
    dashboardList +=
        '<div class="carousel__item carousel__item--mobile-in-1 carousel__item--tablet-in-2 carousel__item--desktop-in-3">'+
        '<div class="ml-auto mr-auto text-center" style="margin-top: 0rem !important;">'+
        '<button type="button" class="btn px-5 radius-15 modal-title text-white" style="padding: 15px; background-color: #858687" onclick="remotePageListDashboard()">'+
        '<i class="bx bx-plus-circle mr-1"></i>'+ Messages("Tạo mới bảng điều khiển") +
        '</button>'+
        '</div>'+
        '</div>';
    dashboardList += '</div></div>';

    list += dashboardList;
    $("#listDashboard").html(list);
}

function remotePageListDashboard() {
    window.location.href = jsRoutes.controllers.DashboardV3Controller.dashboardList(projectId).url;
}

function remotePageDetailDashboard(id) {
    window.location.href = jsRoutes.controllers.DashboardV3Controller.dashboard(projectId, id).url;
}