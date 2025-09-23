/**
 * Created by vtk-anhlt166 on 1/27/23.
 */
$(document).ready(function () {
    appendListProvince();
    getInfoAccount();
});
function appendListProvince() {
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
                $("#tinh_tp").html(province);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

//onchange select
function selectDistrict() {
    var body = new FormData();
    body.type = "DISTRICT";
    body.parentCode = $("#tinh_tp").val();
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
                var district = '<option value="" selected>'+Messages("location.district")+'</option>';
                if(data.content != null && data.content.length > 0){
                    for(var i=0; i<data.content.length; i++){
                        district += '<option value="'+data.content[i].areaCode+'">'+data.content[i].name+'</option>';
                    }
                }
                $("#quan_huyen").html(district);
                $("#phuong_xa").html('<option value="" selected>'+Messages("location.ward")+'</option>');
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}
function selectWard() {
    var body = new FormData();
    body.type = "WARD";
    body.parentCode = $("#quan_huyen").val();
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
                $("#phuong_xa").html(ward);
            }
        },
        complete: function (){
            // FinishProcess();
        }
    })
}

var bussinessNameFetch = "";
var bussinessLicenseFetch = "";

/**
 * Gọi API lấy thông tin giấy phép kinh doanh đã được duyệt
 * và hiển thị vào các input tương ứng.
 */
function getInfoAccount() {
    var r = jsRoutes.controllers.TelcoAccountController.getInfoGpkdApproved();
    $.ajax({
        type: r.type,
        contentType: false,
        processData: false,
        url: r.url,
        success: function(datas){
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    let indexUserID = datas.content.data.findIndex(item => item.user_id === userId);
                    if (indexUserID == -1) { 
                        showNotification('danger', Messages("business.license.missing"));
                    }
                    var data = datas.content.data[indexUserID];
                    bussinessNameFetch = data.name;
                    bussinessLicenseFetch = data.business_license;
                    $('#ten_ng_dai_dien').val(data?.user_name);
                    $('#recipientName').val(data?.user_name);
                    $('#so_dien_thoai_lien_he').val(data?.user_phone);
                    $('#recipientPhone').val(data?.user_phone);
                    $('#ten_doanh_nghiep').val(bussinessNameFetch);
                    $('#ma_so_doanh_nghiep').val(bussinessLicenseFetch);
                    $('#bussinessName').val(bussinessNameFetch);
                    $('#bussinessLicense').val(bussinessLicenseFetch); 
                } else {
                    showNotification('danger', Messages("business.license.updateRequired"));
                }
            } else {
                if(datas.status == 401){
                    showNotification('danger', Messages("noti.sessionTimeOut"));
                    window.location.href = jsRoutes.controllers.Application.logout().url;
                } else {
                    showNotification('danger', datas.errorString);
                }
            }
        },
        error: function (xhr) {
            showNotification('danger',Messages("connection.failed"));
        }
    })
}

/**
 * Lấy toàn bộ dữ liệu gói cước và số lượng sim
 * từ các khối có id bắt đầu bằng "choose_pack_".
 * @returns {Array} Danh sách gói cước đã chọn
 */
function getAllPackData() {
    var allPackData = []; 

    $('[id^="choose_pack_"]').each(function() {
        var packData = {};  
        
        $(this).find('[name]').each(function() {
            var name = $(this).attr('name').replace(/_\d+$/, '');
            var value = $(this).val();
            
            if (name === 'numIsdn') {
                value = Number(value);
            }
            
            if (value) {
                packData[name] = value;
            }
        });

        if (Object.keys(packData).length > 0) {
            allPackData.push(packData);
        }
    });

    return allPackData;
}

/**
 * Hiển thị thông tin người nhận, địa chỉ, doanh nghiệp và danh sách gói cước
 * vào màn hình xác nhận đơn hàng.
 */
function checkOrderInformation() {
    let recipientName = $("#ten_ng_dai_dien").val();
    let recipientPhone = $("#so_dien_thoai_lien_he").val();
    let transactionPlace = $("input[name='inlineRadioOptions']:checked").closest('label').text().trim();
    let address = $("#dia_chi_chi_tiet").val();
    
    $('#recipientNameText').text(recipientName);
    $('#recipientPhoneText').text(recipientPhone);
    $('#bussinessNameText').text(bussinessNameFetch);
    $('#bussinessLicenseText').text(bussinessLicenseFetch); 
    $('#transactionPlaceText').text("- " + transactionPlace); 
    $('#addressText').text(Messages("address.display.prefix") + " " + address); 

    showPackData(1);  // Hiển thị gói cước cho trang 1
    renderPaginationOrderSim(1);  // Hiển thị phân trang cho trang 1
}

/**
 * Hiển thị dữ liệu gói cước cho trang hiện tại.
 * @param {number} page - Trang hiện tại.
 */
function showPackData(page) {
    const allPackData = getAllPackData();  // Lấy tất cả gói cước
    const itemsPerPage = 20;  // Số lượng gói cước trên mỗi trang
    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;
    const pageItems = allPackData.slice(start, end);  // Lọc gói cước cho trang hiện tại

    let packDataHtml = "";

    // Nếu có gói cước, hiển thị các mục
    if (pageItems.length > 0) {
        pageItems.forEach((item, index) => {
            packDataHtml += `
                <tr>
                    <td>${start + index + 1}</td>  <!-- Tính lại chỉ số mục (dựa vào start) -->
                    <td>${item.productCode || ""}</td>
                    <td>${item.numIsdn || ""}</td>
                </tr>
            `;
        });
    } else {
        // Nếu không có gói cước, hiển thị thông báo
        packDataHtml = `
            <tr>
                <td colspan="3" class="text-center">${Messages("notification.no.data")}</td>
            </tr>
        `;
    }

    // Hiển thị các gói cước trong bảng
    $('#listContractTable tbody').html(packDataHtml);
}

/**
 * Hiển thị phân trang cho danh sách gói cước.
 * @param {number} currentPage - Trang hiện tại.
 */
function renderPaginationOrderSim(currentPage) {
    const allPackData = getAllPackData();  // Lấy tất cả gói cước
    const itemsPerPage = 20;  // Số lượng gói cước trên mỗi trang
    const totalPages = Math.ceil(allPackData.length / itemsPerPage);  // Tổng số trang
    const pagination = document.getElementById("paginationOrderSim");
    pagination.innerHTML = "";  // Reset nội dung phân trang

    // Hàm tạo nút phân trang
    const createButton = (label, page, isActive = false, isFirstLast = false) => {
        const btn = document.createElement("button");
        btn.innerHTML = label;
        btn.onclick = () => {
            renderPaginationOrderSim(page);  // Cập nhật phân trang cho trang mới
            showPackData(page);  // Hiển thị gói cước cho trang mới
        };
        if (isActive) btn.classList.add("active");
        if (isFirstLast) {
            btn.classList.add(page === 1 ? "pagination-button-first" : "pagination-button-last");
        }
        return btn;
    };

    // Tạo span với thông tin tổng số bản ghi
    const totalRecordsSpan = document.createElement("span");
    totalRecordsSpan.textContent = Messages("pagination.total.records", allPackData.length); 
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


/**
 * Gửi yêu cầu đặt hàng sim lên backend.
 * Hiển thị modal thành công hoặc thất bại sau khi gửi.
 */
function confirmOder() {
    const $btn = $("#buttonCommfirmBuySim");
    $btn.prop("disabled", true);

    var body = {
        userId: userId,
        recipientName: $("#ten_ng_dai_dien").val(),
        recipientPhone: $("#so_dien_thoai_lien_he").val(),
        bussinessName: bussinessNameFetch,
        bussinessLicense: bussinessLicenseFetch,
        address: $("#dia_chi_chi_tiet").val(),
        type: "order",
        transactionPlace: $("#inlineRadio1").prop("checked") ? "HOME" : "SHOP",
        data: {
            orderSim: getAllPackData()
        }
    };

    const r = jsRoutes.controllers.TelcoOrderController.processOrderBuySim();

    $.ajax({
        type: r.type,
        url: r.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            let orderID = data?.content?.data?.id;
            if (data?.success && orderID) {
                $('#successOrderModal').modal('show');
                $('#orderID').text(orderID);
            } else {
                $('#failOrderModal').modal('show');
            }
        },
        error: function (err) {
            $btn.prop("disabled", false);
        }
    });

     $('#successOrderModal').on('hidden.bs.modal', function () {
        location.reload(); 
    });
    
     $('#failOrderModal').on('hidden.bs.modal', function () {
        location.reload(); 
    });
}

$("input[name='inlineRadioOptions']").on("change", function () {
    if ($("#inlineRadio2").prop("checked")) {
        $("#orderMessageOption1").show();
    } else {
        $("#orderMessageOption1").hide();
    }
});