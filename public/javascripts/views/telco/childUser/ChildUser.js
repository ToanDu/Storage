// $(document).ready(function () {
//     getListChildUser();
// });

// $(document).keypress(function(event) {
//     if (event.keyCode == 13) {
//         event.preventDefault();
//         getListChildUser();
//     }
// });

function checkEnter(event) {
    if (event.key === "Enter") {
        $("#page").val(1);
        var inputValue = document.getElementById("emailEnterpriseLv2").value;
        getListChildUser(inputValue.trim());
    }
}
function onlickButtonSearchLv2() {
    $("#page").val(1);
    var inputValue = document.getElementById("emailEnterpriseLv2").value;
    getListChildUser(inputValue.trim());
}
function getListChildUser(email) {

    var body = new FormData();
    body.userId = userId;
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    body.email = email;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.getListChildUser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewContractToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                $("#listChildUserTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listChildUserTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            // getTotalContract(body.page, body.pageSize);
        }
    })
}

function viewContractToTable(data, startAt, page, pageSize) {
    var body = "";
    var listUser = data.users;
    if (listUser != null && listUser.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listUser.length; i++) {
            // var r = jsRoutes.controllers.TelcoInvoiceController.invoiceOfContract(listAccountDTO[i].accountID);
            // var idTooltip = "tooltip_"+listSubscriber[i].isdn;
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td class='wrap-text'>" + listUser[i].name + "</td>";
            body += "<td>" + "<a onclick='remotePageDetailChildUser(\""+listUser[i].user_id+"\", \""+listUser[i].email+"\")' style='color: #00a5bb; cursor: pointer;'>"+ listUser[i].email + "</a>" + "</td>";
            // body += "<td class='wrap-text'>" + listUser[i].email + "</td>";
            body += "<td class='wrap-text'>" + listUser[i].phone + "</td>";
            body += "<td align='center'>";
            body += '<i class="bx bx-edit cursor-pointer" style="font-size: 20px;" title="Cập nhật" onclick="setRoleChildUser(\''+listUser[i].user_id+'\')"></i>';
            body += "</td>";
            body += "<td align='center'>";
            body += '<i class="bx bx-lock-open cursor-pointer" style="font-size: 20px;" title="Reset mật khẩu" onclick="setIdGenPass(\''+listUser[i].user_id+'\', \''+listUser[i].email+'\')"></i>';
            body += "</td>";
            body += "<td align='center'>";
            body += '<i class="bx bx-trash cursor-pointer" style="font-size: 20px;" title="Xóa user" onclick="setDeleteChildUser(\''+listUser[i].user_id+'\', \''+listUser[i].email+'\')"></i>';
            body += "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listChildUserTable").find('tbody').html(body);

    pagingTable(data.total, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListChildUser();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListChildUser();
}

function resetFormSearch() {
    console.log("resetFormSearch");
    // $("#numberSubs").tagsinput('removeAll');
    // $("#serialSim").tagsinput('removeAll');
    // $("#accountId").tagsinput('removeAll');
    $("#emailEnterpriseLv2").val('');
    getListChildUser();
}

function remotePageDetailChildUser(userChildId, email) {
    window.open(jsRoutes.controllers.TelcoChildUserController.childUserDetail(userId, userChildId, email).url, "_blank");
}
