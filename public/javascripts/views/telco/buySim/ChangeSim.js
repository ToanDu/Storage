$(document).ready(function () {
    getProvince();
});

function getProvince() {
    var body = new FormData();
    body.type = "PROVINCE";
    body.parentCode = "";
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            // console.log(data);
            if(data.success){
                var province = '<option value="" selected>'+Messages("location.province")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        province += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#province").html(province);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//onchange select
function getDistrict() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#province").val();
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                var district = '<option value="" selected>'+Messages("option.selectDistrict")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#district").html(district);
                $("#ward").html('<option value="" selected>'+Messages("location.ward")+'</option>');
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function getWard() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#district").val();
    console.log(body);
    var r = jsRoutes.controllers.TelcoAccountController.getListArea();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log(data);
            if(data.success){
                var ward = '<option value="" selected>'+Messages("location.ward")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        ward += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#ward").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

function validateFormInfoDNChangeSim() {
    if(!validateInputId("recipientName")){
        showNotification('danger',Messages("validation.representative.required"));
        return false;
    }
    if(!validateInputId("bussinessLicense")){
        showNotification('danger',Messages("validation.businessLicense.required"));
        return false;
    }
    if(!validateInputId("recipientPhone")){
        showNotification('danger',Messages("validation.phone.required"));
        return false;
    }
    let recipientPhone = $('#recipientPhone').val().trim();
    if (recipientPhone.length > 0 && !validatePhoneVn(recipientPhone)) {
        showNotification('danger', Messages("validation.phone.format"));
        return false;
    }
    if(!validateInputId("bussinessName")){
        showNotification('danger',Messages("validation.businessName.required"));
        return false;
    }
    if(!document.getElementById("optionOne").checked && !document.getElementById("optionTwo").checked){
        showNotification('danger',Messages("validation.deliveryMethod.required"));
        return false;
    }
    if(!validateInputId("province") || !validateInputId("district") || !validateInputId("ward")){
        showNotification('danger',Messages("validation.address.required"));
        return false;
    }
    if(!validateInputId("address")){
        showNotification('danger',Messages("validation.detailAddress.required"));
        return false;
    }  

    return true;
}

function confirmChangeSim () {
    const $btn = $("#buttonCommfirmChangeSim");
    $btn.prop("disabled", true);

    var body = {
        userId: userId,
        recipientName: $("#recipientName").val(),
        recipientPhone: $("#recipientPhone").val(),
        bussinessName: $("#bussinessName").val(),
        bussinessLicense: $("#bussinessLicense").val(),
        transactionPlace: $("#optionOne").prop("checked") ? "HOME" : "SHOP",
        address: $("#address").val(),
        type: "change",
        data: {
            changeSim: listMiAddonSubsTrue
        }
    };
    console.log("check đổi sim:", body);
    
    const r = jsRoutes.controllers.TelcoOrderController.processOrderBuySim();
    StartProcess();
    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            FinishProcess();
            let orderID = data?.content?.data?.id;
            if (data?.success && orderID) {
                $('#successChangeSimModal').modal('show');
                $('#order_ID').text(orderID);
            } else {
                $('#failChangeSimModal').modal('show');
            }
        },
        error: function (err) {
            $btn.prop("disabled", false);
        }
    });

     $('#successChangeSimModal').on('hidden.bs.modal', function () {
        location.reload(); 
    });
     $('#failChangeSimModal').on('hidden.bs.modal', function () {
        location.reload(); 
    });
}

$("input[name='transactionPlace']").on("change", function () {
    if ($("#optionOne").prop("checked")) {
        $("#changMessageOption1").show();
    } else {
        $("#changMessageOption1").hide();
    }
});

/**
 * Hiển thị thông tin người nhận, địa chỉ, doanh nghiệp, danh sách SIM với phân trang.
 */
function checkChangeInformation() {
    let recipientName = $("#recipientName").val();
    let recipientPhone = $("#recipientPhone").val();
    let transactionPlace =  $("input[name='transactionPlace']:checked").closest('label').text().trim();
    let address = $("#address").val();
    
    // Hiển thị thông tin người nhận và địa chỉ
    $('#recipientNameInfor').text(recipientName);
    $('#recipientPhoneInfor').text(recipientPhone);
    $('#bussinessNameInfor').text(bussinessNameFetch);
    $('#bussinessLicenseInfor').text(bussinessLicenseFetch); 
    $('#transactionPlaceInfor').text("- " + transactionPlace); 
    $('#addressInfor').text(Messages("address.prefix") + " " + address); 

    // Hiển thị danh sách SIM với phân trang
    showSimPageData(1);
    renderPaginationChangeSim(1);
}

/**
 * Hiển thị thông tin SIM cho trang hiện tại.
 * @param {number} page - Trang hiện tại.
 */
function showSimPageData(page) {
    const itemsPerPage = 20; // Số lượng mục trên mỗi trang
    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;
    const pageItems = listMiAddonSubsTrue.slice(start, end);  // Lấy dữ liệu SIM cho trang này
    
    let simInfoHtml = "";
  
    if (pageItems.length > 0) {
        // Lặp qua danh sách SIM và hiển thị thông tin của từng SIM
        pageItems.forEach((item, index) => {
            simInfoHtml += `
                <tr>
                    <td>${start + index + 1}</td> 
                    <td class="text-start">${item || ""}</td>
                </tr>
            `;
        });
    } else {
        simInfoHtml = `
            <tr>
                <td colspan="2" class="text-center">${Messages("data.noData")}</td>
            </tr>
        `;
    }

    // Cập nhật bảng thông tin SIM
    $('#sim_info').html(simInfoHtml);
    // Hiển thị số lượng SIM
    $('#sim_length').html(listMiAddonSubsTrue.length);
}

/**
 * Hiển thị phân trang cho danh sách gói cước.
 * @param {number} currentPage - Trang hiện tại.
 */
function renderPaginationChangeSim(currentPage) {
    
    const itemsPerPage = 20;  // Số lượng gói cước trên mỗi trang
    const totalPages = Math.ceil(listMiAddonSubsTrue.length / itemsPerPage);  // Tổng số trang
    const pagination = document.getElementById("paginationChangeSim");
    pagination.innerHTML = "";  // Reset nội dung phân trang

    // Hàm tạo nút phân trang
    const createButton = (label, page, isActive = false, isFirstLast = false) => {
        const btn = document.createElement("button");
        btn.innerHTML = label;
        btn.onclick = () => {
            renderPaginationChangeSim(page);  // Cập nhật phân trang cho trang mới
            showSimPageData(page);  // Hiển thị gói cước cho trang mới
        };
        if (isActive) btn.classList.add("active");
        if (isFirstLast) {
            btn.classList.add(page === 1 ? "pagination-button-first" : "pagination-button-last");
        }
        return btn;
    };

    // Tạo span với thông tin tổng số bản ghi
    const totalRecordsSpan = document.createElement("span");
    totalRecordsSpan.textContent = Messages("pagination.totalRecords").replace("{0}", listMiAddonSubsTrue.length); 
    pagination.appendChild(totalRecordsSpan);

    // Nút "Previous" (nút quay lại)
    if (currentPage > 1) {
        const prevButton = createButton('<i class="bx bx-chevron-left pagination-icon"></i>', currentPage - 1);
        pagination.appendChild(prevButton);
    }

    // Nút cho trang 1
    pagination.appendChild(createButton("1", 1, currentPage === 1));

    // Tính toán và hiển thị các trang gần với trang hiện tại
    let start = Math.max(2, currentPage - 1);
    let end = Math.min(totalPages - 1, currentPage + 1);

    if (start > 2) {
        pagination.appendChild(document.createElement("button")).textContent = "...";
    }

    for (let i = start; i <= end; i++) {
        pagination.appendChild(createButton(i, i, currentPage === i));
    }

    if (end < totalPages - 1) {
        pagination.appendChild(document.createElement("button")).textContent = "...";
    }

    // Nút cho trang cuối
    if (totalPages > 1) {
        pagination.appendChild(createButton(totalPages, totalPages, currentPage === totalPages));
    }

    // Nút "Next" (nút tiếp theo)
    if (currentPage < totalPages) {
        const nextButton = createButton('<i class="bx bx-chevron-right pagination-icon"></i>', currentPage + 1);
        pagination.appendChild(nextButton);
    }
}
