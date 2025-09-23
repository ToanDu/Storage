var formStt = 0;
function addFormInfoCompany() {
    formStt++;
    var formInfoCompany =
        '<input id="id_doanh_nghiep_'+formStt+'" class="id_doanh_nghiep" stt="'+formStt+'" hidden readonly>' +
        '                        <div class="col-md-12 m-t-3" id="tt_doanh_nghiep_'+formStt+'" style="border: 1px solid #a2a2a2;">' +
        '                            <div class="row m-t-3">' +
        '                                <div class="col-md-8">' +
        '                                    <div class="row m-b-4">' +
        '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Tên DN")+'<span class="text-red">'+Messages("*")+'</span></label>' +
        '                                        <div class="col-sm-10">' +
        '                                            <input id="tenDoanhNghiep_'+formStt+'" type="text" class="form-control input-form" maxlength="250" value="">' +
        '                                        </div>\n' +
        '                                    </div>\n' +
        '                                    <div class="row m-b-4">\n' +
        '                                        <div class="col-sm-6">\n' +
        '                                            <div class="row">\n' +
        '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Mã số thuế")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                                <div class="col-sm-8">\n' +
        '                                                    <input id="maSoThue_'+formStt+'" type="text" class="form-control input-form" maxlength="250" value="">\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                        <div class="col-sm-6">\n' +
        '                                            <div class="row">\n' +
        '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Số GPKD")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                                <div class="col-sm-8">\n' +
        '                                                    <input id="soGpkd_'+formStt+'" type="text" class="form-control input-form id_no" maxlength="250" value="" >\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                    </div>\n' +
        '                                    <div class="row m-b-4">\n' +
        '                                        <div class="col-sm-6">\n' +
        '                                            <div class="row">\n' +
        '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Ngày thành lập")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                                <div class="col-sm-8">\n' +
        '                                                    <input id="ngayThanhLap_'+formStt+'" type="text" class="form-control input-form date_timepicker" maxlength="250">\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                        <div class="col-sm-6">\n' +
        '                                            <div class="row">\n' +
        '                                                <label class="col-sm-4 col-form-label title-section-2">'+Messages("Số điện thoại DN")+'</label>\n' +
        '                                                <div class="col-sm-8">\n' +
        '                                                    <input id="sdtDN_'+formStt+'" type="number" class="form-control input-form" pattern="/^-?\\d+\\.?\\d*$/" onKeyPress="if(this.value.length==11) return false;">\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                    </div>\n' +
        '                                    <div class="row m-b-4">\n' +
        '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Email DN")+'</label>\n' +
        '                                        <div class="col-sm-10">\n' +
        '                                            <input id="emailDN_'+formStt+'" type="text" class="form-control input-form" maxlength="250">\n' +
        '                                        </div>\n' +
        '                                    </div>\n' +
        '                                    <div class="row m-b-3">\n' +
        '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Địa chỉ")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                        <div class="col-sm-10">\n' +
        '                                            <div class="row">\n' +
        '                                                <div class="col-sm-4">\n' +
        '                                                    <select class="form-control" id="tinhTpDN_'+formStt+'" onchange="selectDistrictDN('+formStt+')">'+listOptionProvince+'</select>\n' +
        '                                                </div>\n' +
        '                                                <div class="col-sm-4">\n' +
        '                                                    <select class="form-control" id="quanHuyenDN_'+formStt+'" onchange="selectWardDN('+formStt+')">\n' +
        '                                                        <option value="">'+Messages("Huyện/ Quận")+'</option>\n' +
        '                                                    </select>\n' +
        '                                                </div>\n' +
        '                                                <div class="col-sm-4">\n' +
        '                                                    <select class="form-control" id="phuongXaDN_'+formStt+'">\n' +
        '                                                        <option value="">'+Messages("Phường/Xã")+'</option>\n' +
        '                                                    </select>\n' +
        '                                                </div>\n' +
        '                                                <div class="col-sm-12 m-t-3">\n' +
        '                                                    <input id="diaChiChiTietDN_'+formStt+'" type="text" class="form-control input-form" maxlength="250" placeholder="Địa chỉ chi tiết">\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                    </div>\n' +

        '                                   <div class="row m-t-3">\n' +
        '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Lĩnh vực")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                        <div class="col-sm-10">\n' +
        '                                            <select class="form-control" id="linhVuc_'+formStt+'" multiple>\n' +
                                                        dsLinhVuc +
        '                                            </select>\n' +
        '                                        </div>\n' +
        '                                    </div>'+
        '                                   <div class="row m-t-3">\n' +
        '                                        <label class="col-sm-2 col-form-label title-section-2">'+Messages("Dòng thiết bị")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                        <div class="col-sm-10">\n' +
        '                                            <select class="form-control" id="dongThietBi_'+formStt+'" multiple>\n' +
                                                        dsDongThietBi +
        '                                            </select>\n' +
        '                                        </div>\n' +
        '                                    </div>'+

        '                                </div>\n' +
        '                                <div class="col-md-4">\n' +
        '                                    <div class="row m-b-4">\n' +
        '                                        <label class="col-sm-12 col-form-label title-section-2">'+Messages("Ảnh GPKD")+'<span class="text-red">'+Messages("*")+'</span></label>\n' +
        '                                        <div class="col-sm-12 position-relative">\n' +
        '                                            <div class="row">\n' +
        '                                                <div class="col-md-4 position-relative">\n' +
        '                                                    <input id="imgOld4_'+formStt+'" type="text" class="form-control" hidden>\n' +
        '                                                    <input id="changeImg4_'+formStt+'" type="checkbox" hidden>\n' +
        '                                                    <div class="d-flex flex-column align-items-center text-center square-item" >\n' +
        '                                                        <img src="'+imgDefault+'" id="wizardPicturePreview4_'+formStt+'" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">\n' +
        '                                                        <input id="wizard-picture-4_'+formStt+'" onchange="onchangeImg(this, '+formStt+')" stt="'+formStt+'" name="avatar" type="file" hidden/>' +
        '                                                    </div>\n' +
        '                                                </div>\n' +
        '                                                <div class="col-md-8 position-relative">\n' +
        '                                                    <label class="form-label ">'+Messages("Upload image")+'</label><br>\n' +
        '                                                    <label class="form-label ">'+Messages("Kéo thả file ảnh hoặc mở file ")+'<a onclick="$(\'#wizard-picture-4_'+formStt+'\').click();" class="cursor-pointer text-danger">'+Messages("tại đây")+'</a></label>\n' +
        '                                                </div>\n' +
        '                                                <div class="col-md-12 position-relative">\n' +
        '                                                    <small class="form-label ">'+Messages("File jpg, png,... dung lượng file không quá 3mb")+'</small>\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                    </div>' +
        '                                </div>' +
        '                                <div class="col-md-12">\n' +
        '                                    <div class="row m-t-3">\n' +
        '                                         <label class="col-sm-12 col-form-label title-section-2" id="notiApproved_'+formStt+'"></label>\n' +
        '                                    </div>' +
        '                                </div>' +
        '                            </div>' +
        '<div class="row m-t-2 m-b-4">' +
        '<div class="col-md-12 mx-auto text-center">' +
        '<button type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getOtpUpdateEnterprise('+formStt+')">'+Messages("btnComfirm")+'</button>' +
        '<button type="button" class="btn btn-telco-account" style="background: #FFFFFF; color: #EA0033;" onclick="delFormInfoCompany('+formStt+')">'+Messages("Xóa doanh nghiệp")+'</button>' +
        '</div>' +
        '</div>'+
        '</div>';

    $("#tab_info_company").append(formInfoCompany);

    $('.date_timepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY',
        time: false
    });

    $('#linhVuc_'+formStt).select2({
        theme: 'bootstrap4',
        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
        placeholder: $(this).data('placeholder'),
        allowClear: Boolean($(this).data('allow-clear'))
    });
    $('#dongThietBi_'+formStt).select2({
        theme: 'bootstrap4',
        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
        placeholder: $(this).data('placeholder'),
        allowClear: Boolean($(this).data('allow-clear'))
    });
}

function onchangeImg(el, stt) {
    console.log(stt);
    console.log(el.files[0]);

    if (el.files && el.files[0]) {
        var nameimg = el.files[0].name.toLowerCase();
        console.log(nameimg);
        if(!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")){
            showNotification('danger', Messages("File ảnh GPKD không đúng định dạng"));
            $('#wizardPicturePreview4_'+stt).attr('src', imgDefault);
            $("#wizard-picture-4_"+stt).val("");
            return;
        } else {
            if(el.files[0].size > 3000000){
                showNotification('danger', Messages("File ảnh GPKD dung lượng không được quá 3mb"));
                $('#wizardPicturePreview4_'+stt).attr('src', imgDefault);
                $("#wizard-picture-4_"+stt).val("");
                return;
            }
        }
        var reader = new FileReader();
        reader.onload = (function (file) { // here we save variable 'file' in closure
            return function (e) { // return handler function for 'onload' event
                $('#wizardPicturePreview4_'+stt).attr('src', e.target.result);
            }
        })(el.files[0]);
        reader.readAsDataURL(el.files[0]);
    }
}

function delFormInfoCompany(formStt) {
    $("#tt_doanh_nghiep_"+formStt).remove();
}