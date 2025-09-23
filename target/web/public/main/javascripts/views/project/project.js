/**
 * Created by vtk-anhlt166 on 11/22/21.
 */
var hostname;
var countProject = 0;
$(document).ready(function () {
    getListProject();

    getListTag();

    hostname = location.protocol + '//' + location.host;
    console.log(hostname);
});
//search
$('#search').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#search').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.lister_item').each(function() {
        var isMatch = $(this).find('h5').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

function getListProject() {
    StartProcess();
    var r = jsRoutes.controllers.ProjectController.getProject();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success && data.content != null){
                var listProject = [];
                var mnt = "";
                if(data.content.projects.length > 0){
                    countProject = data.content.projects.length;
                    for(var i=0; i< data.content.projects.length; i++){
                        var img = imgProject0;

                        // var img = "http://localhost:9000/getImg/e21206c04e5d11ecbe19a08cfdd227ee-Screenshot.png";
                        if(data.content.projects[i].image != null && data.content.projects[i].image.length>0){
                            img = hostname + "/getImg/" + data.content.projects[i].image;
                        }
                        console.log(img);

                        var description = (data.content.projects[i].description != undefined) ? data.content.projects[i].description : "";
                        var image = (data.content.projects[i].image != undefined) ? data.content.projects[i].image : "";
                        mnt += '<div class="col-md-4 lister_item">'+
                            '<div class="col" style="padding: 20px 20px 20px 20px">'+
                            '<div class="card radius-10">'+
                            '<img src="'+img+'" class="card-img" alt="..." height="300">'+
                            '<div class="card-img-overlay">'+
                            '<div class="d-flex align-items-center">'+
                            '<div class="font-22 ms-auto text-white">' +
                            '<i class="bx bx-dots-horizontal-rounded" data-bs-toggle="dropdown" aria-expanded="false" style="cursor: pointer"></i>'+
                            '<ul class="dropdown-menu dropdown-table">'+
                            '<li style="cursor: pointer"><a class="dropdown-item" onclick="showPopupEditProject(\''+data.content.projects[i].id+'\', \''+data.content.projects[i].name+'\', \''+data.content.projects[i].tag+'\', \''+description+'\', \''+image+'\')"><i class="bx bx-message-square-edit"></i> '+Messages("btnEdit")+'</a></li>'+
                            '<li style="cursor: pointer"><a class="dropdown-item" onclick="showPopupDelProject(\''+data.content.projects[i].id+'\')"><i class="bx bx-message-square-x"></i> '+Messages("btnDelete")+'</a></li>'+
                            '</ul>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '<div style="position: absolute;right: 0;bottom: 0px;left: 0;padding: 1rem;background-color: #333333; width: 90%; opacity: 0.65; border-radius: 0px 5px 5px 0px;">'+
                            '<div class="d-flex" style="cursor: pointer;" onclick="routesPageOverview(\''+data.content.projects[i].id+'\')">'+
                            '<img src="'+img+'" class="rounded-circle p-1 border" width="80" height="80" alt="...">'+
                            '<div class="flex-grow-1 ms-3">'+
                            '<h5 class="mt-0 text-white">'+data.content.projects[i].name+'</h5>'+
                            '<p class="mb-0 text-white">'+ description +'</p>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';

                        var project = {
                            "id": data.content.projects[i].id,
                            "name": data.content.projects[i].name != null ? data.content.projects[i].name : "",
                            "description": data.content.projects[i].description != null ? data.content.projects[i].description : "",
                            "image": data.content.projects[i].image != null ? data.content.projects[i].image : ""
                        };
                        listProject.push(project);
                    }
                } else {
                    countProject = 0;
                }

                mnt += '<div class="col-md-4 lister_item">'+
                    '<div class="col" style="padding: 20px 20px 20px 20px">'+
                    '<div class="card radius-10">'+
                    '<img src="'+imgAddProject+'" class="card-img" alt="..." height="300">'+
                    '<div class="card-img-overlay">'+
                    '<div class="d-flex align-items-center">'+
                    '<div class="font-22 ms-auto text-white">' +
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '<div data-bs-toggle="modal" data-bs-target="#addProjectModal" style="position: absolute;right: 0;bottom: 25%;left: 0;padding: 1rem;background-color: #212529; width: 90%; opacity: 0.65; border-radius: 0px 5px 5px 0px;">'+
                    '<div class="d-flex" style="cursor: pointer;" onclick="">'+
                    '<i class="bx bx-plus-circle" style="font-size: 35px; color: white"></i>'+
                    '<div class="flex-grow-1 ms-3">'+
                    '<h5 class="mt-0 text-white">'+Messages("Tạo mới")+'</h5>'+
                    '<p class="mb-0 text-white">'+Messages("dự án")+'</p>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';

                mnt += '<div class="col-md-4 lister_item">'+
                    '<div class="col" style="padding: 20px 20px 20px 20px">'+
                    '<div class="card radius-10">'+
                    '<img src="'+imgAddProject+'" class="card-img" alt="..." height="300">'+
                    '<div class="card-img-overlay">'+
                    '<div class="d-flex align-items-center">'+
                    '<div class="font-22 ms-auto text-white">' +
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '<div onclick="showPopupCreateTemplate()" data-bs-toggle="modal" data-bs-target="#createTemplateProjectModal" style="position: absolute;right: 0;bottom: 25%;left: 0;padding: 1rem;background-color: #212529; width: 90%; opacity: 0.65; border-radius: 0px 5px 5px 0px;">'+
                    '<div class="d-flex" style="cursor: pointer;" onclick="">'+
                    '<i class="bx bx-donate-blood" style="font-size: 35px; color: white"></i>'+
                    '<div class="flex-grow-1 ms-3">'+
                    '<h5 class="mt-0 text-white">'+Messages("Giải pháp mẫu ")+'</h5>'+
                    '<p class="mb-0 text-white">'+Messages("giúp bạn triển khai nhanh cho dự án")+'</p>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';

                mnt += '<div class="col-md-4 lister_item">'+
                    '<div class="col" style="padding: 20px 20px 20px 20px">'+
                    '<div class="card radius-10">'+
                    '<img src="'+imgAddProject+'" class="card-img" alt="..." height="300">'+
                    '<div class="card-img-overlay">'+
                    '<div class="d-flex align-items-center">'+
                    '<div class="font-22 ms-auto text-white">' +
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '<div onclick="directPageAccountTelco()" style="position: absolute;right: 0;bottom: 25%;left: 0;padding: 1rem;background-color: #212529; width: 90%; opacity: 0.65; border-radius: 0px 5px 5px 0px;">'+
                    '<div class="d-flex" style="cursor: pointer;">'+
                    '<i class="bx bx-credit-card" style="font-size: 35px; color: white"></i>'+
                    '<div class="flex-grow-1 ms-3">'+
                    '<h5 class="mt-0 text-white">'+Messages("Quản lý Telco")+'</h5>'+
                    '<p class="mb-0 text-white">'+Messages("giúp bạn quản lý toàn bộ thuê bao/sim")+'</p>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';

                mnt += '<div class="col-md-4 lister_item">'+
                    '<div class="col" style="padding: 20px 20px 20px 20px">'+
                    '<div class="card radius-10">'+
                    '<img src="'+imgAddProject+'" class="card-img" alt="..." height="300">'+
                    '<div class="card-img-overlay">'+
                    '<div class="d-flex align-items-center">'+
                    '<div class="font-22 ms-auto text-white">' +
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '<div onclick="directPageManageProduct(\''+currentUserId+'\')" style="position: absolute;right: 0;bottom: 25%;left: 0;padding: 1rem;background-color: #212529; width: 90%; opacity: 0.65; border-radius: 0px 5px 5px 0px;">'+
                    '<div class="d-flex" style="cursor: pointer;">'+
                    '<i class="bx bxl-product-hunt" style="font-size: 35px; color: white"></i>'+
                    '<div class="flex-grow-1 ms-3">'+
                    '<h5 class="mt-0 text-white">'+Messages("Quản lý bán sản phẩm")+'</h5>'+
                    '<p class="mb-0 text-white">'+Messages("giúp bạn tạo sản phẩm bán trên market place")+'</p>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';

                $("#listProject").html(mnt);
                localStorage.listProject = JSON.stringify(listProject);
                console.log(localStorage.listProject);

            } else {
                if(data.status == 401){
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showErrorCode(data.errorString, data.status);
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

function routesPageOverview(projectId) {
    window.location.href = jsRoutes.controllers.OverviewController.overview(projectId).url;
}

function directPageManageProduct(currentUserId) {
    window.location.href = jsRoutes.controllers.ProductListController.productList(currentUserId).url;
}

function directPageAccountTelco() {
    window.location.href = jsRoutes.controllers.TelcoAccountController.accountInfo().url;
}

function postDataCreateProject() {
    if($('#nameProjectCreate').val().length == 0){
        showNotification('danger',Messages("noti.valid.name"));
        $('#nameProjectCreate').focus();
        return;
    }
    if($('#descriptionProjectCreate').val().length == 0){
        showNotification('danger',Messages("noti.valid.description"));
        $('#descriptionProjectCreate').focus();
        return;
    }

    if($('#nameProjectCreate').val().length > 30){
        showNotification('danger',Messages("Tên dự án không quá 30 kí tự"));
        $('#nameProjectCreate').focus();
        return;
    }
    if($('#descriptionProjectCreate').val().length == 0){
        showNotification('danger',Messages("Mô tả dự án không quá 100 kí tự"));
        $('#descriptionProjectCreate').focus();
        return;
    }
    if($('#tagCreate').val().length == 0){
        showNotification('danger',Messages("Bạn chưa chọn lĩnh vực của dự án"));
        return;
    }

    var groupData = new FormData();
    groupData.append("name", $('#nameProjectCreate').val());
    groupData.append("description", $('#descriptionProjectCreate').val());
    groupData.append("avatar", $("#wizard-picture").prop("files")[0]);
    groupData.append("tagId", $('#tagCreate').val());
    console.log(groupData);

    $("#addProjectModal").modal('hide');

    StartProcess();
    var r = jsRoutes.controllers.ProjectController.createProjectForm();
    $.ajax({
        type: r.type,
        data: groupData,
        contentType: false,
        processData: false,
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                getListProject();
            }else{
                showErrorCode(data.errorString, data.status);
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
    $('#wizardPicturePreview').attr('src', imgProject0);
}

function getListTag () {
    var r = jsRoutes.controllers.ProjectController.getListTag();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            var options = "<option value='' disabled>"+Messages("Chọn lĩnh vực dự án")+"</option>";
            if(data.success){
                if(data.content.tags && data.content.tags.length > 0){
                    for(var i=0; i<data.content.tags.length; i++){
                        options += '<option value="'+data.content.tags[i].id+'">'+data.content.tags[i].name+'</option>';
                    }
                }
            }

            $("#tagCreate").html(options);
            $("#tagEdit").html(options);

            $('.multiple-select').select2({
                theme: 'bootstrap4',
                width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                placeholder: $(this).data('placeholder'),
                allowClear: Boolean($(this).data('allow-clear')),
            });
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