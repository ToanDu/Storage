/**
 * Created by vtk-anhlt166 on 3/7/22.
 */
$(document).ready(function () {
    var formData = new FormData;
    formData.projectId = projectId;
    StartProcess();
    var route = jsRoutes.controllers.PaySubsController.getAllSubs();
    $.ajax({
        type: route.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                viewSubsListToTable(datas.content.data);
            } else {
                showNotification('danger', datas.errorString);
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

function viewSubsListToTable(data) {
    console.log(data);

    var mtmlAttr =
        "<table id='smlSubsTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("Mã đăng ký")+"</th>" +
        "<th>"+Messages("Người dùng")+"</th>" +
        "<th>"+Messages("Loại dịch vụ")+"</th>" +
        "<th>"+Messages("Gói cước")+"</th>" +
        "<th>"+Messages("Ngày đăng ký")+"</th>" +
        "<th>"+Messages("Trạng thái")+"</th>" +
        "<th>"+Messages("Hủy đăng kí")+"</th>" +
        "<th>"+Messages("Thanh toán")+"</th>" +
        "</thead>" +
        "<tbody>";

    if (data!=null && data.length > 0) {
        var stt = 1;
        for (var i = data.length-1; i >= 0; i--) {
            mtmlAttr += "<tr>";
            mtmlAttr += "<td>"+stt+"</td>";
            mtmlAttr += '<td>'+data[i].s_id+'</td>';
            mtmlAttr += "<td>"+data[i].c_user_email+"</td>";
            mtmlAttr += "<td>"+data[i].s_service_type+"</td>";
            mtmlAttr += "<td>"+data[i].p_name+"</td>";
            mtmlAttr += "<td>"+(data[i].s_date_register > 0 ? moment.unix(data[i].s_date_register).format("YYYY/MM/DD HH:mm") : "")+"</td>";
            if(data[i].s_status == "Active"){
                mtmlAttr += "<td style='color: green' id='status-"+data[i].s_id+"'>"+data[i].s_status+"</td>";
                mtmlAttr += "<td id='action-"+data[i].s_id+"'>";
                mtmlAttr += '<button class="btn btn-danger" onclick="setIdCancelSub(\''+data[i].s_id+'\')" data-bs-toggle="modal" data-bs-target="#cancelSubConfirm" type="button" style="cursor: pointer" title="'+Messages("Hủy đăng ký")+'"><i class="bx bx-x me-0"></i></button>';
                mtmlAttr += "</td>";
            } else if(data[i].s_status == "Cancelled"){
                mtmlAttr += "<td style='color: red' id='status-"+data[i].s_id+"'>"+data[i].s_status+"</td>";
                mtmlAttr += "<td id='action-"+data[i].s_id+"'>";
                mtmlAttr += '<button class="btn btn-danger" onclick="" type="button" style="cursor: pointer" title="'+Messages("Hủy đăng ký")+'" disabled><i class="bx bx-x me-0"></i></button>';
                mtmlAttr += "</td>";
            } else { // pending active + panding cancel
                mtmlAttr += "<td style='color: orangered' id='status-"+data[i].s_id+"'>"+data[i].s_status+"</td>";
                mtmlAttr += "<td id='action-"+data[i].s_id+"'>";
                mtmlAttr += '<button class="btn btn-danger" onclick="" type="button" style="cursor: pointer" title="'+Messages("Hủy đăng ký")+'" disabled><i class="bx bx-x me-0"></i></button>';
                mtmlAttr += "</td>";
            }
            if(data[i].s_status == "Pending Active"){
                mtmlAttr += "<td id='actionPay-"+data[i].s_id+"'>";
                mtmlAttr += '<button class="btn btn-info" onclick="paymentSub(\''+data[i].s_id+'\')" data-bs-toggle="modal" data-bs-target="#paymentSubConfirm" type="button" style="cursor: pointer" title="'+Messages("Thanh toán")+'"><i class="bx bx-credit-card me-0"></i></button>';
                mtmlAttr += "</td>";
            } else {
                mtmlAttr += "<td id='actionPay-"+data[i].s_id+"'>";
                mtmlAttr += '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-credit-card me-0"></i></button>';
                mtmlAttr += "</td>";
            }


            mtmlAttr += "</tr>";
            stt++;
        }

        mtmlAttr += "</tbody></table>";
        $("#tabSubsList").html(mtmlAttr);

        var oTable=$('#smlSubsTable').DataTable( {
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
        $("#tabSubsList").html('<h4>'+Messages("Chưa có đăng ký")+'</h4>');
    }

}

//huy sub
function setIdCancelSub(id) {
    $("#idDelete").val(id);
}

function cancelSub(){
    var groupData = new FormData();
    groupData.id = $("#idDelete").val();
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PayCustomerController.cancelSubscription();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                getInfoSub(groupData.id);

                showNotification('success', Messages("noti.Updatesuccess"));
            } else {
                showNotification('danger', datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}

function getInfoSub(id) {
    var groupData = new FormData();
    groupData.id = id;
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PaySubsController.getInfoSub();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                if(datas.content.data.s_status == "Active"){
                    $("#status-"+ datas.content.data.s_id).html(datas.content.data.s_status);
                    document.getElementById("status-"+datas.content.data.s_id).style.color = "green";

                    var button = '<button class="btn btn-danger" onclick="setIdCancelSub(\''+datas.content.data.s_id+'\')" data-bs-toggle="modal" data-bs-target="#cancelSubConfirm" type="button" style="cursor: pointer" title="'+Messages("Hủy đăng ký")+'"><i class="bx bx-x me-0"></i></button>';
                    $("#action-"+datas.content.data.s_id).html(button);
                } else if(datas.content.data.s_status == "Cancelled"){
                    $("#status-"+ datas.content.data.s_id).html(datas.content.data.s_status);
                    document.getElementById("status-"+datas.content.data.s_id).style.color = "red";

                    var button = '<button class="btn btn-danger" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-x me-0"></i></button>';
                    $("#action-"+datas.content.data.s_id).html(button);
                } else {
                    $("#status-"+ datas.content.data.s_id).html(datas.content.data.s_status);
                    document.getElementById("status-"+datas.content.data.s_id).style.color = "orangered";

                    var button = '<button class="btn btn-danger" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-x me-0"></i></button>';
                    $("#action-"+datas.content.data.s_id).html(button);
                }

                if(datas.content.data.s_status == "Pending Active"){
                    var button = '<button class="btn btn-info" onclick="paymentSub(\''+datas.content.data.s_id+'\')" data-bs-toggle="modal" data-bs-target="#paymentSubConfirm" title="'+Messages("Thanh toán")+'" type="button" style="cursor: pointer" disabled><i class="bx bx-x me-0"></i></button>';
                    $("#actionPay-"+datas.content.data.s_id).html(button);
                } else {
                    var button = '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-x me-0"></i></button>';
                    $("#actionPay-"+datas.content.data.s_id).html(button);
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}

//thanh toan
function paymentSub(id) {
    console.log(id);
    var formData = new FormData;
    formData.id = id;
    StartProcess();
    var route = jsRoutes.controllers.PaySubsController.getLinkPaymentSub();
    $.ajax({
        type: route.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                $("#tdIdSub").html(id);
                $("#tdLinkPaySub").html(datas.content.data);
                document.getElementById("tdLinkPaySub").setAttribute("href", datas.content.data);
                document.getElementById("tdLinkPaySub").setAttribute("target", "_blank");
            } else {
                $("#tdIdSub").html("");
                $("#tdLinkPaySub").html("");
                document.getElementById("tdLinkPaySub").removeAttribute("href");
                document.getElementById("tdLinkPaySub").removeAttribute("target");
                showNotification('danger', Messages("noti.Getfalse"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function checkStatusSub() {
    var formData = new FormData;
    formData.id = $("#tdIdSub").text();
    console.log(formData);

    StartProcess();
    var r = jsRoutes.controllers.PaySubsController.getInfoSub();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                if(datas.content.data.s_status == "Active"){
                    $("#status-"+ datas.content.data.s_id).html(datas.content.data.s_status);
                    document.getElementById("status-"+datas.content.data.s_id).style.color = "green";

                    var button = '<button class="btn btn-danger" onclick="setIdCancelSub(\''+datas.content.data.s_id+'\')" data-bs-toggle="modal" data-bs-target="#cancelSubConfirm" type="button" style="cursor: pointer" title="'+Messages("Hủy đăng ký")+'"><i class="bx bx-x me-0"></i></button>';
                    $("#action-"+datas.content.data.s_id).html(button);

                    var button = '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-credit-card me-0"></i></button>';
                    $("#actionPay-"+datas.content.data.s_id).html(button);

                    showNotification('success',Messages("Đăng ký đã được kích hoạt"));
                } else if(datas.content.data.s_status == "Cancelled"){
                    $("#status-"+ datas.content.data.s_id).html(datas.content.data.s_status);
                    document.getElementById("status-"+datas.content.data.s_id).style.color = "red";

                    var button = '<button class="btn btn-danger" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-x me-0"></i></button>';
                    $("#action-"+datas.content.data.s_id).html(button);

                    var button = '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-credit-card me-0"></i></button>';
                    $("#actionPay-"+datas.content.data.s_id).html(button);

                    showNotification('success',Messages("Đăng ký đã được hủy"));
                } else {
                    $("#status-"+ datas.content.data.s_id).html(datas.content.data.s_status);
                    document.getElementById("status-"+datas.content.data.s_id).style.color = "orangered";

                    var button = '<button class="btn btn-danger" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-x me-0"></i></button>';
                    $("#action-"+datas.content.data.s_id).html(button);


                    if(datas.content.data.s_status == "Pending Active"){
                        var button = '<button class="btn btn-info" onclick="paymentSub(\''+datas.content.data.s_id+'\')" data-bs-toggle="modal" data-bs-target="#paymentSubConfirm" title="'+Messages("Thanh toán")+'" type="button" style="cursor: pointer"><i class="bx bx-credit-card me-0"></i></button>';
                        $("#actionPay-"+datas.content.data.s_id).html(button);

                        showNotification('danger',Messages("Chờ kích hoạt đăng ký"));
                    } else {//pending cancel
                        var button = '<button class="btn btn-info" onclick="" type="button" style="cursor: pointer" disabled><i class="bx bx-credit-card me-0"></i></button>';
                        $("#actionPay-"+datas.content.data.s_id).html(button);

                        showNotification('danger',Messages("Chờ hủy đăng ký"));
                    }
                }



            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}