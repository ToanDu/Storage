/**
 * Created by vtk-anhlt166 on 6/17/22.
 */
$(document).ready(function () {
    getListTag();
    getListProjectAdmin();
});

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
            var options = '<select id="tagsSelect">';
            if(data.success){
                if(data.content){
                    if(data.content.tags && data.content.tags.length > 0){
                        for(var i=0; i<data.content.tags.length; i++){
                            options += '<option value="'+data.content.tags[i].id+'">'+data.content.tags[i].name+'</option>';
                        }
                    }
                }
            }
            options += '</select>';
            options += '<button class="btn btn-dark" type="button" onclick="getListProjectAdmin()">'+Messages("Áp dụng")+'</button>';

            $("#tabSelectTag").html(options);
            $("#tagsSelect").CreateMultiCheckBox({ width: '230px', defaultText : 'Theo lĩnh vực', height:'250px' });
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

function getListProjectAdmin() {
    console.log(listTag);
    var groupData = new FormData;
    groupData.name = $("#searchNameProject").val();
    groupData.page = $("#page").val();
    groupData.pageSize = $("#pageSize").val();
    groupData.sortKey = $("#sortKey").val();
    groupData.sortType = $("#sortType").val();
    groupData.tag = listTag.toString();
    console.log(groupData);

    var r = jsRoutes.controllers.AdminOverviewController.getListProjectWithPaging();
    StartProcess();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            viewProjectToTable(data);
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

function viewProjectToTable(datas) {
    var mtmlProject = "<table id='smlProjectsTable' class='table  align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead style='background: #F1F1F1;border: 1px solid #D9D9D9;'>" +
        "<th scope='col'>"+Messages("STT")+"</th>" +
        "<th scope='col'>"+Messages("Tên dự án")+"</th>" ;

    if($("#sortKey").val() == "msg_quantity"){
        if($("#sortType").val() == "DESC"){
            mtmlProject += "<th scope='col' id='thMsg' onclick='sortListProject(1, \""+Messages("ASC")+"\")'>" +
                Messages("Số bản tin") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-down" viewBox="0 0 16 16"><path d="M3.5 2.5a.5.5 0 0 0-1 0v8.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L3.5 11.293V2.5zm3.5 1a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        } else {
            mtmlProject += "<th scope='col' id='thMsg' onclick='sortListProject(1, \""+Messages("DESC")+"\")'>" +
                Messages("Số bản tin") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-up" viewBox="0 0 16 16"><path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        }
    } else {
        mtmlProject += "<th scope='col' id='thMsg' onclick='sortListProject(1, \""+Messages("DESC")+"\")'>" +
            Messages("Số bản tin") +
            "</th>";
    }

    if($("#sortKey").val() == "device_quantity"){
        if($("#sortType").val() == "DESC"){
            mtmlProject += "<th scope='col' id='thDeviceOn' onclick='sortListProject(2, \""+Messages("ASC")+"\")'>" +
                Messages("Đã kích hoạt") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-down" viewBox="0 0 16 16"><path d="M3.5 2.5a.5.5 0 0 0-1 0v8.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L3.5 11.293V2.5zm3.5 1a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        } else {
            mtmlProject += "<th scope='col' id='thDeviceOn' onclick='sortListProject(2, \""+Messages("DESC")+"\")'>" +
                Messages("Đã kích hoạt") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-up" viewBox="0 0 16 16"><path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        }
    } else {
        mtmlProject += "<th scope='col' id='thDeviceOn' onclick='sortListProject(2, \""+Messages("DESC")+"\")'>" +
            Messages("Đã kích hoạt") +
            "</th>";
    }

    if($("#sortKey").val() == "device_active"){
        if($("#sortType").val() == "DESC"){
            mtmlProject += "<th scope='col' id='thDeviceActive' onclick='sortListProject(3, \""+Messages("ASC")+"\")'>" +
                Messages("Đang hoạt động") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-down" viewBox="0 0 16 16"><path d="M3.5 2.5a.5.5 0 0 0-1 0v8.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L3.5 11.293V2.5zm3.5 1a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        } else {
            mtmlProject += "<th scope='col' id='thDeviceActive' onclick='sortListProject(3, \""+Messages("DESC")+"\")'>" +
                Messages("Đang hoạt động") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-up" viewBox="0 0 16 16"><path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        }
    } else {
        mtmlProject += "<th scope='col' id='thDeviceActive' onclick='sortListProject(3, \""+Messages("DESC")+"\")'>" +
            Messages("Đang hoạt động") +
            "</th>";
    }

    if($("#sortKey").val() == "user_quantity"){
        if($("#sortType").val() == "DESC"){
            mtmlProject += "<th scope='col' id='thUserQuantity' onclick='sortListProject(4, \""+Messages("ASC")+"\")'>" +
                Messages("Số khách hàng") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-down" viewBox="0 0 16 16"><path d="M3.5 2.5a.5.5 0 0 0-1 0v8.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L3.5 11.293V2.5zm3.5 1a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        } else {
            mtmlProject += "<th scope='col' id='thUserQuantity' onclick='sortListProject(4, \""+Messages("DESC")+"\")'>" +
                Messages("Số khách hàng") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-up" viewBox="0 0 16 16"><path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        }
    } else {
        mtmlProject += "<th scope='col' id='thUserQuantity' onclick='sortListProject(4, \""+Messages("DESC")+"\")'>" +
            Messages("Số khách hàng") +
            "</th>";
    }

    mtmlProject += "<th scope='col' id='thFlowQuantity' >" +
        Messages("Số Flow") +
        "</th>";

    if($("#sortKey").val() == "created_time"){
        if($("#sortType").val() == "DESC"){
            mtmlProject += "<th scope='col' id='thCreateTime' onclick='sortListProject(5, \""+Messages("ASC")+"\")'>" +
                Messages("Ngày tạo") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-down" viewBox="0 0 16 16"><path d="M3.5 2.5a.5.5 0 0 0-1 0v8.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L3.5 11.293V2.5zm3.5 1a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        } else {
            mtmlProject += "<th scope='col' id='thCreateTime' onclick='sortListProject(5, \""+Messages("DESC")+"\")'>" +
                Messages("Ngày tạo") +
                '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" style="float: right" class="bi bi-sort-up" viewBox="0 0 16 16"><path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/></svg>' +
                "</th>";
        }
    } else {
        mtmlProject += "<th scope='col' id='thCreateTime' onclick='sortListProject(5, \""+Messages("DESC")+"\")'>" +
            Messages("Ngày tạo") +
            "</th>";
    }

    mtmlProject +=
        "</thead>" +
        "<tbody align=\"left\">";

    if(datas.content != null){
        var data =  datas.content;
        if(data.projects != null){
            var listProject = data.projects;
            if (listProject != null && listProject.length > 0) {
                for (var i = 0; i < listProject.length; i++) {
                    var urlImg = location.protocol + '//' + location.host + "/getImg/" + listProject[i].image;
                    // console.log(urlImg);
                    if(/\.(jpg|jpeg|png|webp|avif|gif|svg)$/.test(urlImg)){
                        // console.log(true) ;
                    } else {
                        urlImg = iconDefault;
                    }
                    var name = (listProject[i].name != null && listProject[i].name.length > 30) ? (listProject[i].name.substring(0,30) + "...") : listProject[i].name;
                    var description = (listProject[i].description != null && listProject[i].description.length > 30) ? (listProject[i].description.substring(0,30) + "...") : listProject[i].description;
                    var owner_mail = (listProject[i].owner_mail != null && listProject[i].owner_mail.length > 30) ? (listProject[i].owner_mail.substring(0,30) + "...") : listProject[i].owner_mail;

                    mtmlProject += "<tr>";
                    mtmlProject += "<th scope='row'>"+(data.offset + i+1)+"</th>";
                    mtmlProject += "<td class='cursor-pointer' onclick='openProjectHref(\""+listProject[i].id+"\")'>" ;
                    mtmlProject += '<div class="d-flex">';
                    mtmlProject += '<div class="font-35">';
                    mtmlProject += '<img src="'+urlImg+'" style="height: 35px; width: 55px;">';
                    mtmlProject += '</div>';
                    mtmlProject += '<div class="ms-3">';
                    mtmlProject += '<span class="limitName">'+ name +'</span><br>';
                    mtmlProject += '<span class="limitEmail">'+owner_mail +'</span><br>';
                    mtmlProject += '<span class="limitDescription">'+description +'</span><br>';
                    mtmlProject += '</div>';
                    mtmlProject += '</div>';
                    mtmlProject += "</td>" ;
                    mtmlProject += "<td>" + listProject[i].msg_quantity + "</td>";
                    mtmlProject += "<td>" + listProject[i].device_quantity + "</td>";
                    mtmlProject += "<td>" + listProject[i].device_active + "</td>";
                    mtmlProject += "<td>" + listProject[i].user_quantity + "</td>";
                    mtmlProject += "<td>" + listProject[i].flow_quantity + "</td>";
                    mtmlProject += "<td>" + moment.unix(listProject[i].created_time/1000).format("DD/MM/YYYY HH:mm") + "</td>";
                    mtmlProject += "</tr>";
                }
            }
        }

        mtmlProject += "</tbody></table>";
        $("#tabListProject").html(mtmlProject);

        var table = $('#smlProjectsTable').DataTable( {
            responsive: true,
            lengthMenu: false,
            bSort: false,
            searching: false,
            "bLengthChange" : false,
            "bInfo":false,
            "paging":false
        } );

        pagingTable(data.total, Math.round(data.offset/data.limit+1), data.limit);
    } else {
        mtmlProject += "</tbody></table>";
        $("#tabListProject").html(mtmlProject);

        pagingTable(0, 1, 15);
    }
}

//paging
function pagingTable(total, offset, limit) {
    console.log("total : " + total);
    console.log("offset : " + offset);
    console.log("limit : " + limit);
    var paging =
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(offset > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+limit+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset-1)+','+limit+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (offset - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset-item)+','+limit+',false)">'+(offset - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+offset+','+limit+',false)">'+offset+'</a></li>';

    var getTotalPage = Math.floor(total/limit);
    if(total%limit >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (offset + item)*limit <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset+item)+','+limit+',false)">'+(offset + item)+'</a></li>'
        }
    }

    if(offset*limit < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset+1)+','+limit+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+limit+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListProjectAdmin();
}

// function getInfoProjectSmarthome() {
//     // StartProcess();
//     var r = jsRoutes.controllers.AdminOverviewController.getInfoOVerviewSmarthome();
//     $.ajax({
//         type: r.type,
//         dataType: 'json',
//         data: JSON.stringify(""),
//         contentType: "application/json; charset=utf-8",
//         url: r.url,
//         success: function (datas) {
//             console.log(datas);
//             if(datas.success){
//                 $("#tdSmarthomeActive").html(datas.content.deviceSmarthome.total);
//                 $("#tdSmarthomeOn").html(datas.content.onSmarthome.total);
//                 $("#tdSmarthomeCustomer").html(datas.content.customerSmarthome.total);
//             }
//         },
//         error: function (xhr) {
//             console.log(xhr);
//             showNotification('danger',Messages("connection.failed"));
//         },
//         complete: function (jqXHR, textStatus) {
//             // FinishProcess(); //Stop display loading...
//         }
//     });
// }
//
// function getInfoProjectVtag() {
//     // StartProcess();
//     var r = jsRoutes.controllers.AdminOverviewController.getInfoOVerviewVtag();
//     $.ajax({
//         type: r.type,
//         dataType: 'json',
//         data: JSON.stringify(""),
//         contentType: "application/json; charset=utf-8",
//         url: r.url,
//         success: function (datas) {
//             console.log(datas);
//             if(datas.success){
//                 $("#tdVtagActive").html(datas.content.deviceVtag.total);
//                 $("#tdVtagOn").html(datas.content.onVtag.total);
//                 $("#tdVtagCustomer").html(datas.content.customerVtag.total);
//             }
//         },
//         error: function (xhr) {
//             console.log(xhr);
//             showNotification('danger',Messages("connection.failed"));
//         },
//         complete: function (jqXHR, textStatus) {
//             // FinishProcess(); //Stop display loading...
//         }
//     });
// }
//
// function getInfoProjectFleet() {
//     // StartProcess();
//     var r = jsRoutes.controllers.AdminOverviewController.getInfoOVerviewFleet();
//     $.ajax({
//         type: r.type,
//         dataType: 'json',
//         data: JSON.stringify(""),
//         contentType: "application/json; charset=utf-8",
//         url: r.url,
//         success: function (datas) {
//             console.log(datas);
//             if(datas.success){
//                 $("#tdFleetActive").html(datas.content.deviceFleet.total);
//                 $("#tdFleetOn").html(datas.content.onFleet.total);
//                 $("#tdFleetCustomer").html(datas.content.customerFleet.total);
//             }
//         },
//         error: function (xhr) {
//             console.log(xhr);
//             showNotification('danger',Messages("connection.failed"));
//         },
//         complete: function (jqXHR, textStatus) {
//             // FinishProcess(); //Stop display loading...
//         }
//     });
// }
//
// function getInfoProjectMetter() {
//     // StartProcess();
//     var r = jsRoutes.controllers.AdminOverviewController.getInfoOVerviewMetter();
//     $.ajax({
//         type: r.type,
//         dataType: 'json',
//         data: JSON.stringify(""),
//         contentType: "application/json; charset=utf-8",
//         url: r.url,
//         success: function (datas) {
//             console.log(datas);
//             if(datas.success){
//                 $("#tdMetterActive").html(datas.content.deviceMetter.total);
//                 $("#tdMetterOn").html(datas.content.onMetter.total);
//                 $("#tdMetterCustomer").html(datas.content.customerMetter.total);
//             }
//         },
//         error: function (xhr) {
//             console.log(xhr);
//             showNotification('danger',Messages("connection.failed"));
//         },
//         complete: function (jqXHR, textStatus) {
//             // FinishProcess(); //Stop display loading...
//         }
//     });
// }

function openProjectHref(idProject) {
    console.log(idProject);
    window.open(jsRoutes.controllers.AdminOverviewProjectController.adminOverviewProject(idProject).url, '_blank');
}

function sortListProject(el, type) {
    console.log(el, type);
    $("#sortType").val(type);

    if(el == 1){
        $("#sortKey").val("msg_quantity");
    } else if(el == 2){
        $("#sortKey").val("device_quantity");
    } else if(el == 3){
        $("#sortKey").val("device_active");
    } else if(el == 4){
        $("#sortKey").val("user_quantity");
    } else if(el == 5){
        $("#sortKey").val("created_time");
    } else if(el == 6){
        $("#sortKey").val("flow_quantity");
    }

    getListProjectAdmin();
}


function exportListProject() {
    var tableEx = $('#smlProjectsTable');
    var table2excel = new Table2Excel({defaultFileName: "ListProject", tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableEx);
}