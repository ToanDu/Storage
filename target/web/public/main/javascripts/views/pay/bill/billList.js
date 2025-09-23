/**
 * Created by vtk-anhlt166 on 3/2/22.
 */
$(document).ready(function () {
    var formData = new FormData;
    formData.projectId = projectId;
    StartProcess();
    var route = jsRoutes.controllers.PayBillController.getAllBill();
    $.ajax({
        type: route.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if (data.success) {
                viewBillToTable(data.content.data);
            } else {
                showNotification('danger', Messages("connection.failed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
});

var listAttr;
function viewBillToTable(data) {
    console.log(data);
    listAttr = new Array;

    var mtmlAttr =
        "<table id='smlBillTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("ID")+"</th>" +
        "<th>"+Messages("Mã đăng ký")+"</th>" +
        "<th>"+Messages("Số lượng đăng ký")+"</th>" +
        "<th>"+Messages("Số lượng")+"</th>" +
        "<th>"+Messages("Đơn giá")+"</th>" +
        "<th>"+Messages("Tổng chi phí")+"</th>" +
        "<th>"+Messages("Bắt đầu sử dụng")+"</th>" +
        "<th>"+Messages("Kết thúc sử dụng")+"</th>" +
        "<th>"+Messages("Yêu cầu thanh toán")+"</th>" +
        "<th>"+Messages("Hết hạn thanh toán")+"</th>" +
        "<th>"+Messages("Thanh toán thực tế")+"</th>" +
        "<th>"+Messages("Trạng thái")+"</th>" +
        "<th>"+Messages("Thanh toán")+"</th>" +
        "</thead>" +
        "<tbody>";

    if (data!=null && data.length > 0) {
        var stt = 1;
        for (var i = data.length-1; i >= 0; i--) {
            var color = "#333333";
            var status = "Khởi tạo";
            if(data[i].status == "Pending"){
                color = "#ff6e07";
                status = "Chờ thanh toán";
            } else if(data[i].status == "Paid"){
                color = "#17a00e";
                status = "Đã thanh toán";
            } else if(data[i].status == "Expired"){
                color = "#ff0019";
                status = "Quá hạn";
            }
            mtmlAttr += "<tr>";
            mtmlAttr += "<td>"+stt+"</td>";
            mtmlAttr += '<td onclick="billDetail(\''+data[i].id+'\')" style="color: #00a5bb; cursor: pointer;">'+data[i].id+'</td>';
            mtmlAttr += "<td>"+data[i].sub_id+"</td>";
            mtmlAttr += "<td>"+data[i].register+"</td>";
            mtmlAttr += "<td>"+data[i].quantity+"</td>";
            mtmlAttr += "<td>"+data[i].price_unit+"</td>";
            mtmlAttr += "<td>"+data[i].cost+"</td>";
            mtmlAttr += "<td>"+(data[i].date_begin > 0 ? moment.unix(data[i].date_begin).format("YYYY/MM/DD HH:mm") : "")+"</td>";
            mtmlAttr += "<td>"+(data[i].date_end > 0 ? moment.unix(data[i].date_end).format("YYYY/MM/DD HH:mm") : "")+"</td>";
            mtmlAttr += "<td>"+(data[i].date_request > 0 ? moment.unix(data[i].date_request).format("YYYY/MM/DD HH:mm") : "")+"</td>";
            mtmlAttr += "<td>"+(data[i].date_expiry > 0 ? moment.unix(data[i].date_expiry).format("YYYY/MM/DD HH:mm") : "")+"</td>";
            mtmlAttr += "<td>"+(data[i].date_payment > 0 ? moment.unix(data[i].date_payment).format("YYYY/MM/DD HH:mm") : "")+"</td>";
            mtmlAttr += "<td style='color: "+color+"' id='status-"+data[i].id+"'>"+status+"</td>";
            mtmlAttr += "<td>";
            if(data[i].status == "Pending" || data[i].status == "Expired"){
                mtmlAttr += '<button class="btn btn-info" onclick="paymentBill(\''+data[i].id+'\')" data-bs-toggle="modal" data-bs-target="#paymentBillConfirm" type="button" style="cursor: pointer" title="'+Messages("Thanh toán")+'"><i class="bx bx-credit-card"></i></button>';
            } else {
                mtmlAttr += '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-credit-card"></i></button>';
            }
            mtmlAttr += "</td>";
            mtmlAttr += "</tr>";
            stt++;
        }

        mtmlAttr += "</tbody></table>";
        $("#tabBillList").html(mtmlAttr);

        var oTable=$('#smlBillTable').DataTable( {
            responsive: true,
            lengthMenu: [
                [ 10, 50, -1],
                ['10', '50', 'Tất cả']
            ],
            "order": [[ 0, "asc" ]],
            bSort: false,
            searching: true,
            "bLengthChange" : true,
            "bInfo":true
        } );
        var oSettings = oTable.settings();
    } else {
        $("#tabBillList").html('<h4>'+Messages("Bạn chưa có hóa đơn nào")+'</h4>');
    }

}