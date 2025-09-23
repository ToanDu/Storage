/**
 * Created by vtk-anhlt166 on 12/27/21.
 */
function searchHistoryAttributeUser() {
    var groupData = new FormData;
    groupData.id = userid;
    groupData.starttime = $("#datePickerFrom").find("input").val().replace(/\//g, "-");
    groupData.endtime = $("#datePickerTo").find("input").val().replace(/\//g, "-");
    groupData.type = "USER";
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.AttributeController.getAttributeHistory();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if (data.success && data.content != null) {
                viewAtrributeHistoryToTable(data.content.logs);
            } else {
                showNotification('error', Messages("noti.Getfalse"));
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

function viewAtrributeHistoryToTable(attrs) {
    console.log(attrs);

    var mtmlAttr =
        "<table id='historyAttributeTable' class='table align-middle mb-0 table-responsive' style='width: 100%'>" +
        "<thead>" +
        "<th>"+Messages("manage.stt")+"</th>" +
        "<th>"+Messages("Thuộc tính")+"</th>" +
        "<th>"+Messages("Loại thuộc tính")+"</th>" +
        "<th>"+Messages("Loại giá trị")+"</th>" +
        "<th>"+Messages("Giá trị hiện tại")+"</th>" +
        "<th>"+Messages("Lần cập nhật cuối")+"</th>" +
        "</thead>" +
        "<tbody>";

    if (attrs!=null && attrs.length > 0) {
        for (var i = 0; i < attrs.length; i++) {
            mtmlAttr += "<tr>";
            mtmlAttr += "<td></td>";
            mtmlAttr += "<td>"+attrs[i].attribute_key+"</td>";
            var type = "";
            if(attrs[i].attribute_type == "SCOPE_SHARE"){
                type = "Share";
            } else {
                type = "Server";
            }
            mtmlAttr += "<td>"+type+"</td>";
            mtmlAttr += "<td>"+getTypeAttr(attrs[i].value_type)+"</td>";
            var value = "";
            if(attrs[i].value_type == "JSON"){
                value = JSON.stringify(attrs[i].value);
            } else {
                value = attrs[i].value;
            }
            mtmlAttr += "<td style='word-break: break-all;'>"+value+"</td>";
            var last_update_ts = moment.unix(attrs[i].ts/1000).format("YYYY/MM/DD HH:mm");
            mtmlAttr += "<td>"+last_update_ts+"</td>";
            mtmlAttr += "</tr>";
        }
    }
    mtmlAttr += "</tbody></table>";
    $("#tabHistory").html(mtmlAttr);

    var table = $('#historyAttributeTable').DataTable( {
        lengthChange: false,
        "order": [],
        "info": false
    } );

    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}
