
$(document).ready(function () {
        getApiKey();
    }
)
function getApiKey() {

    var body = new FormData();
    body.param='/api/tenant/apikey';
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    console.log(r)
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            if (datas == null){
                $("#listApiKeyTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
            }
            if(datas.success){
                apiKeyToTable(datas);
                console.log(datas.content);
            }else{
                $("#listApiKeyTable").find('tbody').html("");
                $("#notiNotData").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listApiKeyTable").find('tbody').html("");
            $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            // getTotalContract(body.page, body.pageSize);
        }
    })
}

function apiKeyToTable(data) {
    var body = "";
    var listKey = data.content.data;
    if (listKey != null && listKey.length > 0) {
        $("#notiNotData").html("");
        for (var i = 0; i < listKey.length; i++) {
            var create_time = converterCreateTime(listKey[i].created_time)
            var expire_time = convertDateTime(listKey[i].expire_time)
            var status = "Đã kích hoạt";
            if(listKey[i].status != "ACTIVATED"){
                status = "Chưa kích hoạt";
            }
            body += "<tr>";
            body += "<td class='wrap-text'>" + (i+1) + "</td>";
            body += "<td class='wrap-text'>" + listKey[i].name + "</td>";
            // body += "<td class='wrap-text'>" + listKey[i].description + "</td>";
            body += "<td class='wrap-text'>" + listKey[i].key_suggest + "</td>";
            body += "<td class='wrap-text'>" + create_time + "</td>";
            // body += "<td class='wrap-text'>" + listKey[i].last_used + "</td>";
            // body += "<td class='wrap-text'>" + listKey[i].rate_limit + "</td>";
            body += "<td class='wrap-text'>" + expire_time + "</td>";
            body += "<td class='wrap-text' >" + status + "</td>";
            body += '<td style="text-align: center;  vertical-align: middle;">' +
                // '<button class="btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="editRow(this)">Edit</button>' +
                '<button class="btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="confirmDelete(this)">Xóa</button>' +
                '</td>';
            body += "<td class='wrap-text' style=\"display:none;\" >" + listKey[i].key + "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotData").html("Không có thông tin để hiển thị");
    }
    $("#listApiKeyTable").find('tbody').html(body);



}
function converterCreateTime(UNIX_timestamp) {
    var a = new Date(UNIX_timestamp * 1000);
    var year = a.getFullYear();
    var month = ('0' + (a.getMonth() + 1)).slice(-2); // Thêm 1 vì tháng bắt đầu từ 0
    var date = ('0' + a.getDate()).slice(-2);
    var hour = ('0' + a.getHours()).slice(-2);
    var min = ('0' + a.getMinutes()).slice(-2);
    var sec = ('0' + a.getSeconds()).slice(-2);
    var time = hour + ':' + min + ':' + sec + ' ' + date + '/' + month + '/' + year;
    return time;
}
function convertDateTime(dateTimeString) {
    var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];

    const dateTime = new Date(dateTimeString);

    const hour = ('0' + dateTime.getHours()).slice(-2);
    const min = ('0' + dateTime.getMinutes()).slice(-2);
    const sec = ('0' + dateTime.getSeconds()).slice(-2);
    const date = ('0' + dateTime.getDate()).slice(-2);
    const monthIndex = dateTime.getMonth();
    const month = ('0' + (monthIndex + 1)).slice(-2);
    const year = dateTime.getFullYear();

    const formattedDateTime = `${hour}:${min}:${sec} ${date}/${month}/${year}`;

    return formattedDateTime;
}
function deleteRow(key){

    var body = new FormData();
    body.param="/api/tenant/apikey/"+key;
    console.log(body.param)
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.deleteDataWithParam();
    // console.log(r)
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(){
            getApiKey();
            showNotification('success',"Xóa API Key thành công");
            //TODO
            // $("#listLogsTable").find('tbody').html("");
            // $("#notiNotData").html("Không có thông tin để hiển thị");
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',"Xóa API Key thất bại");
        },
        complete: function (){
            FinishProcess();
        }
    })

}


function createApiKey() {
    var formData = new FormData();
    formData.param='/api/tenant/apikey';

    if($("#nameKey").val()==null || $("#nameKey").val() ===""){
        var name =  "API Key";
    }else{
        var name =  $("#nameKey").val();
    }
    formData.body= {
        "name" :name,
    };
    formData.param
    console.log(formData.body.name);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.portDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            // console.log(datas);
            if(datas.success){
                var apiKey = datas.content.key;
                console.log(apiKey);
                // Get the input element by its ID
                var textBox = document.getElementById("nameKeyView");
                // Set the value of the text box
                textBox.value = apiKey;
                getApiKey();
                showNotification('success',"Tạo API Key thành công");

            }else{
                $("#listApiKeyTable").find('tbody').html("");
                $("#notiNotData").html("save failed");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listApiKeyTable").find('tbody').html("");
            $("#notiNotData").html("create failed");
        },
        complete: function (){
            FinishProcess();
            // getTotalContract(body.page, body.pageSize);
        }
    })


}
function copyFunction() {
    // Get the text field
    var copyText = document.getElementById("nameKeyView");

    navigator.clipboard.writeText(copyText.value);

    // Alert the copied text
    showNotification('success', "API Key đã được sao chép");
    return false;
}
function openCreateApiKeyModal() {

    var listApiKeyTable = document.getElementById('listApiKeyTable');
    if (listApiKeyTable && listApiKeyTable.rows.length <= 10) {
        var myModal = new bootstrap.Modal(document.getElementById('createApiKeyModal'));
        myModal.show();
    } else {
        showNotification('danger', "Không thể tạo quá 10 key");
    }
}
var keyHash;
function confirmDelete(button) {
    var modal = document.getElementById('confirmDeleteModal');
    modal.style.display = 'block';
    var hiddenDataElement = button.parentElement.nextElementSibling;
    var hiddenData = hiddenDataElement.textContent || hiddenDataElement.innerText;
    console.log(hiddenData)
    keyHash=hiddenData
    console.log(keyHash)
}

function closeModal() {
    var modal = document.getElementById('confirmDeleteModal');
    modal.style.display = 'none';
}

function deleteConfirmed() {
    deleteRow(keyHash);

    closeModal();


}