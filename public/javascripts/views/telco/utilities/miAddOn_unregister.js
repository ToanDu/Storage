/**
 * Created by vtk-anhlt166 on 12/30/22.
 */
var codeUnregisterMiAddon = "";
var nameUnregisterMiAddonPack = "";
function getListPackUnregister() {
    $("#tableUnregisterMiAddon").html("");
    var mtml = "";
    mtml += "<table id='smlTableUnregisterMiAddon' class='table table-striped' style='width: 100%'>" +
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
        mtml += "<td align='center'>" +'<input class="form-check-input" type="checkbox" name="flexRadioUnregister" value="'+listPackMiAddOn[i].code+'" namepack="'+listPackMiAddOn[i].name+'" onchange="choosePackUnregiter(this)" >'+ "</td>";
        mtml += "</tr>";
    }

    mtml += "</tbody></table>";
    $("#tableUnregisterMiAddon").html(mtml);

    var table = $("#smlTableUnregisterMiAddon").DataTable({
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

function choosePackUnregiter(el) {
    var table = $("#smlTableUnregisterMiAddon").DataTable();
    var rows = table.rows({ 'search': 'applied' }).nodes();
    $('input[value="'+codeUnregisterMiAddon+'"]', rows).prop('checked', !el.checked);
    // console.log(el);
    codeUnregisterMiAddon = el.value;
    nameUnregisterMiAddonPack = el.getAttribute('namepack');
    console.log(codeUnregisterMiAddon);
    console.log(nameUnregisterMiAddonPack);

}

var listMiAddonSubsUnregister = new Array();
function comfirmUnregisterMiAddon() {
    listMiAddonSubsUnregister = [];
    $("#dataImportMiAddOnCancelPack  .checkbox-MiAddonSub").each(function() {
        if(this.checked){
            listMiAddonSubsUnregister.push(this.value);
        }
    });

    if(listMiAddonSubsUnregister.length > 0){

        if(nameUnregisterMiAddonPack.length > 0){
            $("#textComfirmUnregisterMiAddon").html('Bạn có chắc chắn muốn thực hiện huỷ gói ' + nameUnregisterMiAddonPack + ' cho ' + listMiAddonSubsUnregister.length + ' thuê bao?');
            $("#unregisterMiAddonModal").modal('hide');
            $("#comfirmUnregisterMiAddonModal").modal('show');
            console.log(listMiAddonSubsUnregister);
        } else {
            showNotification('danger',Messages("Bạn chưa chọn gói cước MI, Add-on"));
        }
    } else {
        showNotification('danger',Messages("Không có thuê bao được chọn để đăng ký"));
    }
}

var countUnregisterMiAddonSuccess = 0;
function processUnregisterMiAddon(index) {
    console.log(listMiAddonSubsUnregister);
    if(index == 0){
        StartProcess();
        countUnregisterMiAddonSuccess = 0;
    }

    $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("Đang thực hiện...");
    $("#dataImportMiAddOnCancelPack #pack-MiAddon-"+listMiAddonSubsUnregister[index]).html(nameUnregisterMiAddonPack);
    $("#dataImportMiAddOnCancelPack #action-MiAddon-"+listMiAddonSubsUnregister[index]).html("Huỷ gói");
    $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html("");

    //validate & get gpkd
    var formData = new FormData;
    formData.isdn = listMiAddonSubsUnregister[index];
    formData.userId = userId;
    formData.actionCode = "22";
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
                        body.isdn = listMiAddonSubsUnregister[index];
                        body.vasCode = codeUnregisterMiAddon;
                        body.pkgName = nameUnregisterMiAddonPack;
                        body.userId = userId;
                        console.log(body);

                        var r = jsRoutes.controllers.TelcoUtilitiesController.unregisterMiAddon();
                        $.ajax({
                            type: r.type,
                            data: JSON.stringify(body),
                            contentType: "application/json; charset=utf-8",
                            url: r.url,
                            success: function(data){
                                console.log(data);
                                if(data.content != null){
                                    if(data.content.code == 0  || data.content.errCode == 0){
                                        $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-success'>"+Messages("Huỷ gói thành công ")+"</span>");
                                        $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html("");
                                        countUnregisterMiAddonSuccess++;
                                    } else {
                                        if(data.content.message != null){
                                            $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-danger'>"+Messages("Huỷ đăng kí không thành công")+"</span>");
                                            $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html(Messages(data.content.message));
                                        } else {
                                            $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-danger'>"+Messages("Huỷ đăng kí không thành công")+"</span>");
                                            $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html(Messages("Không xác định"));
                                        }
                                    }
                                } else {
                                    $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-danger'>"+Messages("Huỷ đăng kí không thành công")+"</span>");
                                    $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html(Messages("Không có dữ liệu"));
                                }
                            }
                        })
                    } else {
                        $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-danger'>"+Messages("Huỷ đăng ký không thành công")+"</span>");
                        $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html(Messages("Không tìm thấy GPKD của thuê bao"));
                    }
                } else {
                    $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-danger'>"+Messages("Huỷ đăng ký không thành công")+"</span>");
                    $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html(Messages("Số thuê bao không hợp lệ"));
                }
            } else {
                $("#dataImportMiAddOnCancelPack #result-MiAddon-"+listMiAddonSubsUnregister[index]).html("<span class='text-danger'>"+Messages("Huỷ đăng ký không thành công")+"</span>");
                $("#dataImportMiAddOnCancelPack #reason-MiAddon-"+listMiAddonSubsUnregister[index]).html(Messages("Số thuê bao không đủ điều kiện"));
            }
        },
        complete: function (){
            // FinishProcess();
            if(index < listMiAddonSubsUnregister.length-1){
                setTimeout(function () {
                    processUnregisterMiAddon(index+1);
                },500);
            } else {
                FinishProcess();

                if(countUnregisterMiAddonSuccess > 0){
                    $("#textNofitication1").html(Messages("Quý khách đã huỷ thành công gói "+nameRegisterMiAddon));
                    $("#textNofitication2").html(countUnregisterMiAddonSuccess + Messages(" thuê bao"));

                    $("#notificationModal").modal('show');
                }

            }
        }
    })
}