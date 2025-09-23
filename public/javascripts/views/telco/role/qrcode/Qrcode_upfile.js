function uploadBanCamKet() {
    $("#filesBanCamKet").click();
}

function loadFilesBanCamKet(evt) {
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var file = evt.target.files[0];
        console.log(file);
        if (!file.name.endsWith(".pdf")) {
            showNotification('danger', Messages("File không đúng format pdf"));
            document.getElementById("filesBanCamKet").value = "";
            $("#nameBanCamKet").val("");
            return;
        } else {
            $("#nameBanCamKet").val(file.name);
            document.getElementById("filesBanCamKet").value = "";
        }
    }
}

function uploadHopDong() {
    $("#filesHopDong").click();
}

function loadFilesHopDong(evt) {
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var file = evt.target.files[0];
        console.log(file);
        if (!file.name.endsWith(".pdf")) {
            showNotification('danger', Messages("File không đúng format pdf"));
            document.getElementById("filesHopDong").value = "";
            $("#nameHopDong").val("");
            return;
        } else {
            $("#nameHopDong").val(file.name);
            document.getElementById("filesHopDong").value = "";
        }
    }
}

function uploadPhuLucHd() {
    $("#filesPhuLucHd").click();
}

function loadFilesPhuLucHd(evt) {
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var file = evt.target.files[0];
        console.log(file);
        if (!file.name.endsWith(".pdf")) {
            showNotification('danger', Messages("File không đúng format pdf"));
            document.getElementById("filesPhuLucHd").value = "";
            $("#namePhuLucHd").val("");
            return;
        } else {
            $("#namePhuLucHd").val(file.name);
            document.getElementById("filesPhuLucHd").value = "";
        }
    }
}

$(document).ready(function () {
    $("#wizard-picture-1").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if (!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")) {
                showNotification('danger', Messages("File ảnh đại diện không đúng định dạng"));
                $('#wizardPicturePreview1').attr('src', imgDefault);
                $("#wizard-picture-1").val("");
                return;
            } else {
                if (this.files[0].size > 3000000) {
                    showNotification('danger', Messages("File ảnh đại diện dung lượng không được quá 3mb"));
                    $('#wizardPicturePreview1').attr('src', imgDefault);
                    $("#wizard-picture-1").val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = imageIsLoaded1;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-2").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if (!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")) {
                showNotification('danger', Messages("File ảnh đại diện không đúng định dạng"));
                $('#wizardPicturePreview2').attr('src', imgDefault);
                $("#wizard-picture-2").val("");
                return;
            } else {
                if (this.files[0].size > 3000000) {
                    showNotification('danger', Messages("File ảnh đại diện dung lượng không được quá 3mb"));
                    $('#wizardPicturePreview2').attr('src', imgDefault);
                    $("#wizard-picture-2").val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = imageIsLoaded2;
            reader.readAsDataURL(this.files[0]);
        }
    });
    $("#wizard-picture-3").change(function () {
        if (this.files && this.files[0]) {
            var nameimg = this.files[0].name.toLowerCase();
            console.log(nameimg);
            if (!nameimg.includes("jpg") && !nameimg.includes("png") && !nameimg.includes("jpeg")) {
                showNotification('danger', Messages("File ảnh đại diện không đúng định dạng"));
                $('#wizardPicturePreview3').attr('src', imgDefault);
                $("#wizard-picture-3").val("");
                return;
            } else {
                if (this.files[0].size > 3000000) {
                    showNotification('danger', Messages("File ảnh đại diện dung lượng không được quá 3mb"));
                    $('#wizardPicturePreview3').attr('src', imgDefault);
                    $("#wizard-picture-3").val("");
                    return;
                }
            }

            var reader = new FileReader();
            reader.onload = imageIsLoaded3;
            reader.readAsDataURL(this.files[0]);
        }
    });
})
function imageIsLoaded1(e) {
    $('#wizardPicturePreview1').attr('src', e.target.result);
}
function imageIsLoaded2(e) {
    $('#wizardPicturePreview2').attr('src', e.target.result);
}
function imageIsLoaded3(e) {
    $('#wizardPicturePreview3').attr('src', e.target.result);
}