/**
 * Created by vtk-anhlt166 on 12/30/22.
 */
function getListPackUnextend() {
    $("#tableUnextendMiAddon").html("");
    var mtml = "";
    mtml += "<table id='smlTableUnextendMiAddon' class='table table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th style='text-align: center'>"+Messages("STT")+"</th>" +
        "<th>"+Messages("Tên gói")+"</th>" +
        "<th>"+Messages("Loại")+"</th>" +
        "<th>"+Messages("Chi tiết")+"</th>" +
        "<th style='text-align: center'>"+Messages("Chọn")+"</th>" +
        "</thead>" +
        "<tbody>";
    for(var i=0; i<listPackMiAddOn.length; i++){
        mtml += "<tr>";
        mtml += "<td align='center'>" + (i+1) + "</td>";
        mtml += "<td>" + listPackMiAddOn[i].name + " (Mã: " + listPackMiAddOn[i].name+ ")" + "</td>";
        mtml += "<td>" + getPayTypeByCode(listPackMiAddOn[i].payType) + "</td>";
        mtml += "<td>" + listPackMiAddOn[i].description + "</td>";
        mtml += "<td align='center'>" +'<input class="form-check-input" type="checkbox" name="flexRadioUnextend" value="'+listPackMiAddOn[i].code+'" namepack="'+listPackMiAddOn[i].name+'" onchange="choosePackUnextend(this)" >'+ "</td>";
        mtml += "</tr>";
    }

    mtml += "</tbody></table>";
    $("#tableUnextendMiAddon").html(mtml);

    var table = $("#smlTableUnextendMiAddon").DataTable({
        // responsive: true,
        lengthMenu: [
            [ 10, 50, -1],
            ['10', '50', 'Tất cả']
        ],
        "order": [[ 1, "asc" ]],
        bSort: false,
        searching: true,
        "bLengthChange" : false,
        "bInfo":true,
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
    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

var codeUnextendMiAddon = "";
var nameUnextendMiAddon = "";
function choosePackUnextend(el) {
    var table = $("#smlTableUnextendMiAddon").DataTable();
    var rows = table.rows({ 'search': 'applied' }).nodes();
    $('input[value="'+codeUnextendMiAddon+'"]', rows).prop('checked', !el.checked);
    // console.log(el);
    codeUnextendMiAddon = el.value;
    nameUnextendMiAddon = el.getAttribute('namepack');
    console.log(codeUnextendMiAddon + " - " + nameUnextendMiAddon);
}

var listMiAddonSubsUnextend = new Array();
function comfirmUnextendMiAddon() {
    listMiAddonSubsUnextend = [];
    $("#dataImportMiAddOnCancelExtendPack .checkbox-MiAddonSub").each(function() {
        if(this.checked){
            listMiAddonSubsUnextend.push(this.value);
        }
    });

    if(listMiAddonSubsUnextend.length > 0){
        if(nameUnextendMiAddon.length > 0){
            $("#textComfirmUnextendMiAddon").html('Bạn có chắc chắn muốn thực hiện huỷ gia hạn gói ' + nameUnextendMiAddon + ' cho ' + listMiAddonSubsUnextend.length + ' thuê bao?');
            $("#unextendMiAddonModal").modal('hide');
            $("#comfirmUnextendMiAddonModal").modal('show');
            console.log(listMiAddonSubsUnextend);
        } else {
            showNotification('danger',Messages("Bạn chưa chọn gói cước MI, Add-on"));
        }
    } else {
        showNotification('danger',Messages("Không có thuê bao được chọn để đăng ký"));
    }
}

var countUnextendMiAddonSuccess = 0;
function processUnextendMiAddon(index) {
    console.log(listMiAddonSubsUnextend);
    if(index == 0){
        StartProcess();
        countUnextendMiAddonSuccess = 0;
    }

    $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("Đang thực hiện...");
    $("#dataImportMiAddOnCancelExtendPack #pack-MiAddon-"+listMiAddonSubsUnextend[index]).html(nameUnextendMiAddon);
    $("#dataImportMiAddOnCancelExtendPack #action-MiAddon-"+listMiAddonSubsUnextend[index]).html("Huỷ gia hạn");
    $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html("");

    //validate & get gpkd
    var formData = new FormData;
    formData.isdn = listMiAddonSubsUnextend[index];
    formData.userId = userId;
    formData.actionCode = "23";
    console.log(formData);

    var url = jsRoutes.controllers.TelcoUtilitiesController.validateSubs();
    $.ajax({
        type: url.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: url.url,
        success: function (datas) {
            console.log(datas);
            if (datas.content != null && datas.content.data != null) {
                if (datas.content.data.valid) {
                    if (datas.content.data.idNo != null) {

                        var body = new FormData;
                        body.idNo = datas.content.data.idNo;
                        body.isdn = listMiAddonSubsUnextend[index];
                        body.vasCode = codeUnextendMiAddon;
                        body.pkgName = nameUnextendMiAddon;
                        body.userId = userId;
                        console.log(body);

                        var r = jsRoutes.controllers.TelcoUtilitiesController.unextendMiAddon();
                        $.ajax({
                            type: r.type,
                            data: JSON.stringify(body),
                            contentType: "application/json; charset=utf-8",
                            url: r.url,
                            success: function(data){
                                console.log(data);
                                if(data.content != null){
                                    if(data.content.code == 0  || data.content.errCode == 0){
                                        $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-success'>"+Messages("Huỷ gia hạn gói thành công ")+"</span>");
                                        $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html("");
                                        countUnextendMiAddonSuccess++;
                                    } else {
                                        if(data.content.message != null){
                                            $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-danger'>"+Messages("Huỷ gia hạn gói không thành công")+"</span>");
                                            $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html(Messages(data.content.message));
                                        } else {
                                            $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-danger'>"+Messages("Huỷ gia hạn gói không thành công")+"</span>");
                                            $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html(Messages("Không xác định"));
                                        }
                                    }
                                } else {
                                    $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-danger'>"+Messages("Huỷ gia hạn gói không thành công")+"</span>");
                                    $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html(Messages("Không có dữ liệu"));
                                }
                            }
                        })

                    } else {
                        $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-danger'>"+Messages("Huỷ gia hạn gói không thành công")+"</span>");
                        $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html(Messages("Không tìm thấy GPKD của thuê bao"));
                    }
                } else {
                    $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-danger'>"+Messages("Huỷ gia hạn gói không thành công")+"</span>");
                    $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html(Messages("Số thuê bao không hợp lệ"));
                }
            } else {
                $("#dataImportMiAddOnCancelExtendPack #result-MiAddon-"+listMiAddonSubsUnextend[index]).html("<span class='text-danger'>"+Messages("Huỷ gia hạn gói không thành công")+"</span>");
                $("#dataImportMiAddOnCancelExtendPack #reason-MiAddon-"+listMiAddonSubsUnextend[index]).html(Messages("Số thuê bao không đủ điều kiện"));
            }
        },
        complete: function (){
            // FinishProcess();
            if(index < listMiAddonSubsUnextend.length-1){
                setTimeout(function () {
                    processUnextendMiAddon(index+1);
                },500);
            } else {
                FinishProcess();

                if(countUnextendMiAddonSuccess > 0){
                    $("#textNofitication1").html(Messages("Quý khách đã huỷ gia hạn thành công gói "+nameUnextendMiAddon));
                    $("#textNofitication2").html(countUnextendMiAddonSuccess + Messages(" thuê bao"));

                    $("#notificationModal").modal('show');
                }

            }
        }
    })


}