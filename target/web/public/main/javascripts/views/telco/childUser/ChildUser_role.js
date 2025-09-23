function setRoleChildUser(userId) {
    $("#idChildUserUpdateRole").val(userId);

    var body = new FormData();
    body.userId = userId;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.getRolesOfChildUser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                $("#roleChildUserModal").modal('show');
                if(datas.content.data != null && datas.content.data.length > 0){
                    var actions = datas.content.data[0].actions;
                    if(actions != null && actions.length > 0){
                        actions.forEach(function (item) {
                            if(document.getElementById(item) != undefined){
                                document.getElementById(item).checked = true;
                            }
                        })
                    }
                } else {
                    var listCheckbox = document.getElementsByClassName("checked_role");
                    for(var i=0; i<listCheckbox.length; i++){
                        listCheckbox[i].checked = true;
                    }
                }

                onchangeCheckboxTabDashboard();
                onchangeCheckboxTabSub();
                onchangeCheckboxTabContract();
                onchangeCheckboxTabInvoice();
                onchangeCheckboxTabUtilities();
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



function processUpdateRoleChildUser() {
    var action =  [
        // "view_dashboard",
        // "view_sub",
        // "export_sub",
        // "view_contract",
        // "export_contract",
        // "view_invoice",
        // "download_invoice",
        // "register_vas",
        // "unregister_vas",
        // "cancel_extend",
        // "top_up",
        // "block_sub",
        // "open_sub",
        // "pay_by_contract"
    ];
    var listCheckbox = document.getElementsByClassName("checked_role");
    for(var i=0; i<listCheckbox.length; i++){
        if(listCheckbox[i].checked){
            action.push(listCheckbox[i].id);
        }
    }
    console.log(action);
    if(action.length == 0){
        showNotification('danger', Messages("Bạn hãy chọn ít nhất 1 quyền"));
        return;
    }

    var body = new FormData();
    body.userId = $("#idChildUserUpdateRole").val();
    body.action = action;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoChildUserController.updateRolesOfChildUser();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                $("#roleChildUserModal").modal('hide');
                showNotification('success',datas.resultString);
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

//onchange checkbox
function onchangeCheckboxTabDashboard() {
    var listCheckboxDashboard = document.getElementsByClassName("dashboard");
    var countCheckboxDashboard = 0;
    for(var i=0; i<listCheckboxDashboard.length; i++){
        if(!listCheckboxDashboard[i].checked){
            countCheckboxDashboard++;
        }
    }
    if(countCheckboxDashboard > 0){
        document.getElementById("dashboard").checked = false;
    } else {
        document.getElementById("dashboard").checked = true;
    }
}
function onchangeCheckboxTabSub() {
    var listCheckbox = document.getElementsByClassName("sub");
    var countCheckbox = 0;
    for(var i=0; i<listCheckbox.length; i++){
        if(!listCheckbox[i].checked){
            countCheckbox++;
        }
    }
    if(countCheckbox > 0){
        document.getElementById("sub").checked = false;
    } else {
        document.getElementById("sub").checked = true;
    }
}
function onchangeCheckboxTabContract() {
    var listCheckbox = document.getElementsByClassName("contract");
    var countCheckbox = 0;
    for(var i=0; i<listCheckbox.length; i++){
        if(!listCheckbox[i].checked){
            countCheckbox++;
        }
    }
    if(countCheckbox > 0){
        document.getElementById("contract").checked = false;
    } else {
        document.getElementById("contract").checked = true;
    }
}
function onchangeCheckboxTabInvoice() {
    var listCheckbox = document.getElementsByClassName("invoices");
    var countCheckbox = 0;
    for(var i=0; i<listCheckbox.length; i++){
        if(!listCheckbox[i].checked){
            countCheckbox++;
        }
    }
    if(countCheckbox > 0){
        document.getElementById("invoices").checked = false;
    } else {
        document.getElementById("invoices").checked = true;
    }
}
function onchangeCheckboxTabUtilities() {
    var listCheckbox = document.getElementsByClassName("utilities");
    var countCheckbox = 0;
    for(var i=0; i<listCheckbox.length; i++){
        if(!listCheckbox[i].checked){
            countCheckbox++;
        }
    }
    if(countCheckbox > 0){
        document.getElementById("utilities").checked = false;
    } else {
        document.getElementById("utilities").checked = true;
    }
}

//checkall
function checkAllDashboard(el) {
    var listCheckboxDashboard = document.getElementsByClassName("dashboard");
    for(var i=0; i<listCheckboxDashboard.length; i++){
        if(el.checked){
            listCheckboxDashboard[i].checked = true;
        } else {
            listCheckboxDashboard[i].checked = false;
        }
    }
}
function checkAllSub(el) {
    var listCheckboxDashboard = document.getElementsByClassName("sub");
    for(var i=0; i<listCheckboxDashboard.length; i++){
        if(el.checked){
            listCheckboxDashboard[i].checked = true;
        } else {
            listCheckboxDashboard[i].checked = false;
        }
    }
}
function checkAllContract(el) {
    var listCheckboxDashboard = document.getElementsByClassName("contract");
    for(var i=0; i<listCheckboxDashboard.length; i++){
        if(el.checked){
            listCheckboxDashboard[i].checked = true;
        } else {
            listCheckboxDashboard[i].checked = false;
        }
    }
}
function checkAllInvoice(el) {
    var listCheckboxDashboard = document.getElementsByClassName("invoices");
    for(var i=0; i<listCheckboxDashboard.length; i++){
        if(el.checked){
            listCheckboxDashboard[i].checked = true;
        } else {
            listCheckboxDashboard[i].checked = false;
        }
    }
}
function checkAllUtilities(el) {
    var listCheckboxDashboard = document.getElementsByClassName("utilities");
    for(var i=0; i<listCheckboxDashboard.length; i++){
        if(el.checked){
            listCheckboxDashboard[i].checked = true;
        } else {
            listCheckboxDashboard[i].checked = false;
        }
    }
}