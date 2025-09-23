/**
 * Created by vtk-anhlt166 on 4/24/23.
 */
function setModalGpkdOfAdminAndSpEnterprise(userId) {
    $("#infoAdminSuperenModal").modal('show');
    $("#idUserAdminSperen").val(userId);
    $("#page").val(1);
    $("#pageSize").val(10);
    $("#descriptionDetail").val("");

    getListGpkdOfAdminAndSpEnterprise();
}

function getListGpkdOfAdminAndSpEnterprise() {
    var body = new FormData;
    body.userId = $("#idUserAdminSperen").val();
    body.page = $("#pageDetail").val();
    body.pageSize = $("#pageSizeDetail").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.AdminTelcoController.getListEnterpriseSubmitOfAdminSpe();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            $("#listEnterpriseTable").find('tbody').html("");
            if(datas.content != null){
                var startAt = (body.page - 1)*body.pageSize;
                viewDataSubmitGpkdToTable(datas.content, startAt, body.page, body.pageSize);
            } else {
                $("#notiNotDataDetail").html("Không có thông tin để hiển thị");
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewDataSubmitGpkdToTable(datas, startAt, page, pageSize) {
    var body = "";
    var listEnterprise = datas.data;
    if (listEnterprise != null && listEnterprise.length > 0) {
        $("#notiNotDataDetail").html("");
        for (var i = 0; i < listEnterprise.length; i++) {
            var dataEnterprise = listEnterprise[i];
            if(listEnterprise[i].action == "UPDATE" || dataEnterprise.action == "CREATE"){
                if(listEnterprise[i].update_info != null){
                    dataEnterprise = listEnterprise[i].update_info;
                }
            }

            var nameNew = "";
            var gpkdNew = "";
            var nameOld = "";
            var gpkdOld = "";
            var action ="";
            if(dataEnterprise.action == "DELETE"){
                nameOld = listEnterprise[i].name;
                gpkdOld = listEnterprise[i].business_license;
                nameNew = "";
                gpkdNew = "";
                action = "DELETE"
            } else if(dataEnterprise.action == "CREATE"){
                nameOld = dataEnterprise.name;
                gpkdOld = dataEnterprise.business_license;
                nameNew = dataEnterprise.name;
                gpkdNew = dataEnterprise.business_license;
                action = "CREATE";
            } else {
                if(listEnterprise[i].action != ""){
                    nameOld = dataEnterprise.name;
                    gpkdOld = dataEnterprise.business_license;
                    nameNew = dataEnterprise.name;
                    gpkdNew = dataEnterprise.business_license;
                    action = listEnterprise[i].action;
                }
                else{
                    nameOld = dataEnterprise.name;
                    gpkdOld = dataEnterprise.business_license;
                    action = "CREATE";
                }

            }

            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + nameOld + "</td>";
            body += "<td>" +gpkdOld+ "</td>";
            body += "<td>" + action + "</td>";
            body += "<td class='modal-footer' >";
            body += "<button type='button' class='btn btn-success' id='buttonApproved' onclick='processComfirmApplyListEnterprise(\""+Messages("APPROVED")+"\",\""+dataEnterprise.id+"\")' >"+Messages('Xác nhận')+"</button>";
            body += "<button type='button' class='btn btn-danger' id='buttonRejected' onclick='processComfirmApplyListEnterprise(\""+Messages("REJECTED")+"\",\""+dataEnterprise.id+"\")'>"+Messages('Từ chối')+"</button>";
            body += "</td>";
            body += "</tr>";

        }
    } else {
        $("#notiNotDataDetail").html("Không có thông tin để hiển thị");
    }
    $("#listEnterpriseTable").find('tbody').html(body);

    pagingTableDetail(datas.total, page, pageSize);
}

//paging
function pagingTableDetail(total, page, pageSize) {
    // console.log("total : " + total);
    // console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchDetail(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchDetail('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchDetail('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearchDetail('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchDetail('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchDetail('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchDetail('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTableDetail").html(paging);
}

function applySearchDetail(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=pageDetail]').val(page);
    $('[name=pageSizeDetail]').val(pageSize);

    getListGpkdOfAdminAndSpEnterprise();
}

function ApplyFilterDetail(page, pageSize, isResetPage) {
    $("#countPageSizeDetail").html(pageSize);
    $('[name=pageDetail]').val(page);
    $('[name=pageSizeDetail]').val(pageSize );

    getListGpkdOfAdminAndSpEnterprise();
}

//chap nhan / tu choi
function processComfirmApplyListEnterprise(status, id ) {
    if(status == "REJECTED"){
        if($("#descriptionDetail").val().trim().length == 0){
            showNotification('success', Messages("Bạn chưa nhập lý do từ chối!"));
            return;
        }
    }

    var body = new FormData;
    body.id = id;
    body.status = status;
    body.description = $("#descriptionDetail").val().trim();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.AdminTelcoController.processComfirmInfoCompany();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            $("#infoAdminSuperenModal").modal('hide');
            if(data.status == 200){
                showNotification('success', Messages("Cập nhật thành công"));
                getListApprovedInfo();
            } else {
                showNotification('danger', Messages("Cập nhật thất bại"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}