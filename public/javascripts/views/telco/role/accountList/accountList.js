/**
 * Created by vtk-anhlt166 on 3/2/23.
 */
$(document).ready(function () {
    getListAccount();

    // $('#fullNameAdd').bind('keypress', textInput);
    var fullNameInput = document.getElementById("fullNameAdd");
    fullNameInput.addEventListener("input", function() {
        var inputValue = fullNameInput.value;

        var updatedValue = "";
        for (var i = 0; i < inputValue.length; i++) {
            var currentChar = inputValue.charAt(i);

            if (isVietnameseCharacter(currentChar)) {
                updatedValue += currentChar;
            }
        }

        fullNameInput.value = updatedValue;

    });
});

$("#formSearch").keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        onlickButtonSearch();
    }
});

function isVietnameseCharacter(char) {
    // Biểu thức chính quy để kiểm tra ký tự tiếng Việt
    var vietnamesePattern = /[a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s·]/i;
    return vietnamesePattern.test(char);
}

function textInput(event) {
    var inputValue = event.target.value;
    console.log(inputValue)
    console.log(isVietnameseCharacter(inputValue))
    // Kiểm tra từng ký tự trong chuỗi mới nhập
    var sanitizedInput = inputValue
        .split('') // Chuyển chuỗi thành mảng ký tự
        .filter(isVietnameseCharacter) // Lọc các ký tự tiếng Việt
        .join(''); // Chuyển mảng thành chuỗi

    // Nếu có thay đổi, cập nhật giá trị đầu vào
    if (inputValue !== sanitizedInput) {
        event.target.value = sanitizedInput;
    }
}

function onlickButtonSearch() {
    $("#page").val(1);

    getListAccount();
}
function getListAccount() {
    var body = new FormData();
    body.email = $("#email").val().trim();
    body.cmpRole = $("#roleCmp").val();
    // body.enterpriseName = $("#nameDN").val();
    // body.businessLicense = $("#gpdn").val();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.getListAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewDeviceToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    setTimeout(function () {
                        window.location.href = jsRoutes.controllers.Application.logout().url;
                    },1500);
                } else {
                    $("#listAccountsTable").find('tbody').html("");
                    $("#notiNotData").html("Không có thông tin để hiển thị");
                    showNotification('danger',datas.errorString);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listAccountsTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function viewDeviceToTable(data, startAt, page, pageSize) {
    var body = "";
    var listUser = data.users;
    if (listUser != null && listUser.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listUser.length; i++) {
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            if(listUser[i].cmp_role == ROLE_CMP.ENTERPRISE.value || listUser[i].cmp_role == ROLE_CMP.ENTERPRISE_VIEW.value){
                body += "<td>" + "<a onclick='remotePageManageSubs(\""+listUser[i].enterprise_business_license+"\", \""+listUser[i].user_id+"\")' style='color: #00a5bb; cursor: pointer;'>"+ listUser[i].email + "</a>" + "</td>";
            } else {
                if(listUser[i].cmp_role == ROLE_CMP.ADMIN.value || listUser[i].cmp_role == ROLE_CMP.SUPER_ENTERPRISE.value){
                    body += "<td>" + "<a onclick='remotePageInfoAccountCmp(\""+listUser[i].user_id+"\")' style='color: #f63205; cursor: pointer;'>"+ listUser[i].email + "</a>" + "</td>";
                } else {
                    body += "<td>" + listUser[i].email + "</td>";
                }
            }
            body += "<td class='wrap-text'>" + listUser[i].name + "</td>";
            body += "<td>" + listUser[i].phone + "</td>";
            body += "<td>" + getRoleNameByCode(listUser[i].cmp_role) + "</td>";

            if(roleCmp == "SUPER_ENTERPRISE"){
                body += "";
            }
            else{
                body += "<td align='center' style='padding: 0px;'>";
                if(listUser[i].cmp_role == ROLE_CMP.ENTERPRISE.value || listUser[i].cmp_role == ROLE_CMP.ENTERPRISE_VIEW.value){
                    body += "<a class='btn' title='Sửa quyền tài khoản' onclick='setEditRoleAccountCmp(\""+listUser[i].user_id+"\", \""+listUser[i].email+"\", \""+listUser[i].cmp_role+"\")'><i class='bx bx-edit'></i></a>";
                } else {
                    body += "";
                }
                body += "</td>";
            }


            body += "<td align='center' style='padding: 0px;'>";
            // body += "<a class='btn' title='Thông tin tài khoản' onclick='viewInfoAccountCmp(\""+listUser[i].user_id+"\")'><i class='bx bx-show'></i></a>";
            // if(listUser[i].cmp_role != "SUPER_ADMIN" && listUser[i].cmp_role != "ENTERPRISE" && getRoleNameByCode(listUser[i].cmp_role) != "ENTERPRISE_VIEW"){
            //     body += "<a class='btn' title='Cập nhật thông tin tài khoản' onclick='remotePageInfoAccountCmp(\""+listUser[i].user_id+"\")'><i class='bx bx-show'></i></a>";
            // }
            if(roleCmp == "SUPER_ADMIN" || roleCmp == "ADMIN" || roleCmp=="SUPER_ENTERPRISE"){
                body += "<a class='btn' title='Xoá tài khoản' onclick='setDeleteAccountCmp(\""+listUser[i].user_id+"\", \""+listUser[i].email+"\")'><i class='bx bx-trash'></i></a>";
            }
            body += "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listAccountsTable").find('tbody').html(body);

    pagingTable(data.total, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    // console.log("total : " + total);
    // console.log("page : " + page);
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

    getListAccount();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListAccount();
}

function remotePageInfoAccountCmp(userId) {
    window.open(jsRoutes.controllers.TelcoRoleAccountController.infoAccountCmp(userId).url, "_blank");
}

function comfirmGenaratePass(id) {
    $("#comfirmGenPassModal").modal('show');
    $("#genId").val(id);
}
function generatePass() {
    var body = new FormData();
    body.user_id = $("#genId").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.generatePassAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                $("#generatePassModal").modal('show');
                $("#genPass").val(datas.content.password);
            } else {
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function remotePageManageSubs(gpkd, userId) {
    if(gpkd == "" || gpkd == null || gpkd == undefined){
        gpkd = "demo";
    }
    window.open(jsRoutes.controllers.TelcoSubscriberController.subscriberManage(userId).url, '_blank');
}

function importFileAddEnterprise() {
    $("#filesAddEnterprise").click();
}

function checkValidGpkd(idNo) {
    var body = new FormData();
    body.idNo = idNo;
    console.log(body);

    // StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.validateGpkd();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.code == 0){
                return true;
            } else {
                return false;
            }
        },
        error: function (xhr) {
            console.log(xhr);
            // showNotification('danger',Messages("connection.failed"));
            return false;
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function setEditRoleAccountCmp(id, email, role) {
    console.log(id, email, role);
    $("#editRoleAccountCmpModal").modal('show');
    $("#idAccountEditRole").val(id);
    $("#emailAccountEditRole").val(email);
    $("#roleAccountEditRole").val(role);
}

function processEditRoleAccountCmp() {
    var body = new FormData();
    body.userId = $("#idAccountEditRole").val();
    body.cmp_role = $("#roleAccountEditRole").val();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoRoleAccountController.updatRoleAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                showNotification('success', datas.resultString);
            } else {
                showNotification('danger', datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            // FinishProcess();
            getListAccount();
        }
    })
}