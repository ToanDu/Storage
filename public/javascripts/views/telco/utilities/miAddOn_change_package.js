/**
 * Danh sách các thuê bao được chọn để đổi gói
 */
var listMiAddonChangePackage = [];

/**
 * Mở modal đổi gói cước và khởi tạo các giá trị ban đầu
 */
function changePackage() {
    // Kiểm tra có thuê bao nào được chọn không
    if (getListMiAddonChangePackage() === false) {
        return;
    }
    
    // Hiển thị modal
    $('#modal_change_package').modal('show');

    // Khởi tạo UI cho bước 1
    $('.step-content.step-1').show();
    $('.step-content.step-2').hide();
    $('.footer-step.step-1').show();
    $('.footer-step.step-2').hide();

    // Đánh dấu bước hiện tại
    $('.step-container .step').removeClass('active');
    $('.step-container .step').eq(0).addClass('active');

    // Tạo bảng danh sách gói
    createTablePackMiAddon("cancel_pack_list");
    createTablePackMiAddon("register_pack_list");
}

/**
 * Mở modal xác nhận đổi gói
 */
function openConfirmModalChangePackage() {
    // Kiểm tra đã chọn gói hủy và gói đăng ký mới chưa
    let cancelSelected = $('#sml_cancel_pack_list input[type="radio"]:checked');
    let registerSelected = $('#sml_register_pack_list input[type="radio"]:checked');
    
    if (!cancelSelected.length || !registerSelected.length) {
        let errorMsg = !cancelSelected.length ? "Vui lòng chọn gói cần hủy" : "Vui lòng chọn gói đăng ký mới";
        showNotification('danger', Messages(errorMsg));
        return;
    }

    // Cập nhật thông tin trên modal xác nhận
    $('#subscriber_count').text(listMiAddonChangePackage.length);
    $('#pkgNameUnRegister').text(cancelSelected.attr('namepack'));
    $('#pkgNameRegister').text(registerSelected.attr('namepack'));
    
    // Chuyển sang modal xác nhận
    $('#modal_change_package').modal('hide');
    $('#modal_confirm_change_package').modal('show');
}

/**
 * Xử lý sự kiện khi bấm nút xác nhận đổi gói
 */
$('#confirmChangeBtn').on('click', function () {
    $('#modal_confirm_change_package').modal('hide');
    processChangePackageMiAddon();
});

/**
 * Tạo bảng danh sách gói cước
 * @param {string} idRender - ID của thẻ div chứa bảng
 */
function createTablePackMiAddon(idRender) {
    $(`#${idRender}`).html("");
    var html = "";
    html += "<table id='sml_" + idRender + "' class='table table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th style='text-align: center'>" + Messages("STT") + "</th>" +
        "<th>" + Messages("Tên gói") + "</th>" +
        "<th>" + Messages("Loại") + "</th>" +
        "<th>" + Messages("Chi tiết") + "</th>" +
        "<th style='text-align: center'>" + Messages("Chọn") + "</th>" +
        "</thead>" +
        "<tbody>";

    const radioName = "radio_pack_" + idRender;

    // Tạo các dòng trong bảng
    for (var i = 0; i < listPackMiAddOn.length; i++) {
        html += "<tr>";
        html += "<td align='center'>" + (i + 1) + "</td>";
        html += "<td>" + listPackMiAddOn[i].name + " (Mã: " + listPackMiAddOn[i].code + ")" + "</td>";
        html += "<td>" + getPayTypeByCode(listPackMiAddOn[i].payType) + "</td>";
        html += "<td>" + listPackMiAddOn[i].description + "</td>";
        html += "<td align='center'>" +
            '<input class="form-check-input" type="radio"' +
            ' name="' + radioName + '"' +
            ' value="' + listPackMiAddOn[i].code + '"' +
            ' namepack="' + listPackMiAddOn[i].name + '"' +
            ' onchange="choosePackMiAddon(this)">' +
            "</td>";
        html += "</tr>";
    }

    html += "</tbody></table>";
    $(`#${idRender}`).html(html);
    
    // Khởi tạo DataTable
    $(`#sml_${idRender}`).DataTable({
        lengthChange: false,
        info: true,
        bSort: false,
        order: false,
        paging: true,
        pageLength: 8, // Hiển thị 8 dòng mỗi trang
        searching: true,
        language: { 
            search: "",
            searchPlaceholder: "Nhập tên gói..",
            infoEmpty: 'Không tìm thấy kết quả nào',
            info: 'Hiển thị trang _PAGE_ trên tổng số _PAGES_',
            zeroRecords: 'Không tìm thấy kết quả nào',
            paginate: {
                first: 'Đầu',
                last: 'Cuối',
                next: 'Tiếp',
                previous: 'Trước'
            },
            lengthMenu: 'Hiển thị _MENU_ dòng',
            emptyTable: 'Không có dữ liệu',
            sInfoFiltered: "(lọc từ tổng số _MAX_ dòng)",
            sInfoThousands: ",",
            sLoadingRecords: "Đang tải...",
            sProcessing: "Đang xử lý...",
        },
    });
}

/**
 * Lấy danh sách thuê bao được chọn để đổi gói
 * @returns {boolean} true nếu có thuê bao được chọn
 */
function getListMiAddonChangePackage() {
    listMiAddonChangePackage = [];
    $("#dataImportMiAddOnChangelPackage .checkbox-MiAddonSub").each(function () {
        if (this.checked) {
            listMiAddonChangePackage.push(this.value);
        }
    });

    if (listMiAddonChangePackage.length <= 0) {
        showNotification('danger', Messages("Không có thuê bao được chọn"));
        return false;
    }
    return true;
}

/**
 * Chuyển sang bước 2 (đăng ký gói mới)
 */
function nextProcess() {
    // Kiểm tra đã chọn gói hủy chưa
    if (!$('#sml_cancel_pack_list input[type="radio"]:checked').length) {
        showNotification('danger', Messages("Vui lòng chọn gói cần hủy"));
        return;
    }
    
    // Chuyển UI sang bước 2
    $('.step-content.step-1').fadeOut("slow", function () {
        $('.step-content.step-2').fadeIn("slow");
        $('.footer-step.step-1').hide();
        $('.footer-step.step-2').show();
        $('.step-container .step').removeClass('active');
        $('.step-container .step').eq(1).addClass('active');
    });
}

/**
 * Quay lại bước 1 (hủy gói cũ)
 */
function backProcess() {
    $('.step-content.step-2').fadeOut("slow", function () {
        $('.step-content.step-1').fadeIn("slow");
        $('.footer-step.step-2').hide();
        $('.footer-step.step-1').show();
        $('.step-container .step').removeClass('active');
        $('.step-container .step').eq(0).addClass('active');
    });
}

// ==================== EVENT HANDLERS ====================

// Sự kiện khi modal xác nhận đóng
$('#cancelConfirmChangeBtn').on('click', function () {
    // Mở lại modal đổi gói và giữ nguyên trạng thái
    $('#modal_change_package').modal('show');
});

// Sự kiện khi bấm nút hủy trong modal xác nhận
$('#modal_confirm_change_package #cancelConfirmChangeBtn, #modal_confirm_change_package #confirmChangeBtn').on('click', function() {
    $('#modal_confirm_change_package').modal('hide');
    // Không cần thêm code vì sự kiện hidden.bs.modal đã xử lý
});

function processChangePackageMiAddon(index = 0) {
    if (index === 0) {
        StartProcess();
        countRegisterMiAddonSuccess = 0;
    }

    const cancelSelected = $('#sml_cancel_pack_list input[type="radio"]:checked');
    const registerSelected = $('#sml_register_pack_list input[type="radio"]:checked');

    if (!cancelSelected.length || !registerSelected.length) {
        showNotification('danger', Messages("Vui lòng chọn cả gói cần hủy và gói đăng ký mới"));
        return;
    }

    const nameUnregister = cancelSelected.attr('namepack');
    const nameRegister = registerSelected.attr('namepack');

    const listIsdns = listMiAddonChangePackage.slice(index, (index + 1) * 1000);

    listIsdns.forEach(isdn => {
        const row = $(`#dataImportMiAddOnChangelPackage`);
        row.find(`#old-pack-MiAddon-${isdn}`).html(nameUnregister);
        row.find(`#pack-MiAddon-${isdn}`).html(nameRegister);
        row.find(`#action-MiAddon-${isdn}`).html("Đổi gói");
        row.find(`#result-MiAddon-${isdn}`).html("Đang thực hiện...");
        row.find(`#reason-MiAddon-${isdn}`).html("");
    });


    let body = new FormData;
    body.param = "/api/telco/data/change/bulk";
    body.body = {
        isdns: listIsdns,
        vasCodeRegister: nameRegister,
        pkgNameRegister: nameRegister,
        userId: userId,
        vasCodeUnRegister: nameUnregister,
        pkgNameUnRegister: nameUnregister,
        systemClient: "cmp",
        userAction: "change"
    }

    const route = jsRoutes.controllers.SendApiController.portDataWithParam();

    $.ajax({
        type: route.type,
        url: route.url,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            const $container = $("#dataImportMiAddOnChangelPackage");

            if (data.content) {
                data.content.forEach(item => {
                    const $result = $container.find(`#result-MiAddon-${item.isdn}`);
                    const $reason = $container.find(`#reason-MiAddon-${item.isdn}`);

                    if (item.errCode === "0" || item.failed_on === "") {
                        
                        $result.html(`<span class='text-success'>${Messages("Đổi gói thành công ")}</span>`);
                        $reason.html("");
                        countRegisterMiAddonSuccess++;
                    } else {
                        $result.html(`<span class='text-danger'>${Messages("Đổi gói không thành công")}</span>`);
                        $reason.html(getErrorMessage(item.errCode, item?.failed_on, item.description));
                    }
                });
            } else {
                listIsdns.forEach(isdn => {
                    $(`#result-MiAddon-${isdn}`).html(`<span class='text-danger'>${Messages("Đổi gói không thành công")}</span>`);
                    $(`#reason-MiAddon-${isdn}`).html(Messages("Không có dữ liệu"));
                });
            }
        },
        complete: function () {
            if ((index + 1) * 1000 < listMiAddonChangePackage.length) {
                setTimeout(() => processChangePackageMiAddon(index + 1), 500);
            } else {
                FinishProcess();
                if (countRegisterMiAddonSuccess > 0) {
                    $("#textNofitication1").html(Messages("Quý khách đã đăng ký thành công gói " + nameRegister));
                    $("#textNofitication2").html(countRegisterMiAddonSuccess + Messages(" thuê bao"));
                    $("#notificationModal").modal('show');
                }
            }
        }
    });
}

function getErrorMessage(errCode, failed_on, description) {
    // Hàm viết thường chữ cái đầu của description
    function lowercaseFirstLetter(str) {
        return str.charAt(0).toLowerCase() + str.slice(1);
    }

    if (errCode === "2411") {
        return Messages("So thue bao khong hop le");
    } else if (errCode === "2408") {
        return Messages("Khong tim thay thong tin thue bao");
    } else if (errCode === "2001") {
        return Messages("Du lieu khong hop le");
    }  else if (errCode === "2407" || errCode === "2406" || errCode === "-1") {
        return Messages("Co loi xay ra, vui long thu lai sau");
    } else {
        const formattedDescription = lowercaseFirstLetter(description);
        if (failed_on == "Unregister") {
            return Messages(`Huy goi khong thanh cong do ${formattedDescription}`);
        } else if (failed_on == "Register") {
            return Messages(`Dang ky khong thanh cong do ${formattedDescription}`);
        }
        return Messages(formattedDescription);
    }
}
