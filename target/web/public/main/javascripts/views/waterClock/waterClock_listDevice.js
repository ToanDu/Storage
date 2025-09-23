/**
 * Created by vtk-anhlt166 on 5/12/22.
 */
$(document).ready(function () {
    getListClock();
});

function getListClock() {
    var groupData = new FormData;
    groupData.token = token;
    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.WaterClockController.getListClock();
    $.ajax({
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json",
        url: r.url,
        type: r.type,
        success: function (data) {
            console.log(data);
            if (data.success && data.content != null) {
                viewClockDeviceToTable(data.content.devices);
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

function viewClockDeviceToTable(data) {
    $("#totalDevice").html(data.length);

    var mtmlBody = "<table id='listDeviceTable' class='table align-middle mb-0'>" +
        "<thead class='table-info'>" +
        "<th>"+Messages("No")+"</th>" +
        "<th>"+Messages("Name")+"</th>" +
        "<th>"+Messages("Positive vol(m³)")+"</th>" +
        "<th>"+Messages("Negative vol(m³)")+"</th>" +
        "<th>"+Messages("Total vol(m³)")+"</th>" +
        "<th>"+Messages("Flow rate(l/h)")+"</th>" +
        "<th>"+Messages("Water temp")+"</th>" +
        "<th>"+Messages("Battery")+"</th>" +
        "<th>"+Messages("Time")+"</th>" +
        "</thead>" +
        "<tbody>";
    var option ='<select id="chooseDeviceClock" class="single-select" style="width: 100%" multiple>';

    if (data!=null && data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            var id = "";
            var battery = "";
            var current_flow_rate = "";
            var current_ts = "";
            var current_water_temp = "";
            var delta_vols = "";
            var negative_vol = "";
            var positive_vol = "";
            var total_vol = "";

            var attrs = data[i].attributes;
            id = data[i].key;
            if(attrs != null && attrs.length > 0){
                for(var key in attrs){
                    // console.log(key, attrs[key]);
                    var attr = attrs[key];
                    if(attr.attribute_key == "telegram"){
                        var valueClock = attr.value;

                        battery = valueClock.battery_level;
                        current_flow_rate = valueClock.current_flow_rate;
                        current_ts = valueClock.current_ts;
                        current_water_temp = valueClock.current_water_temp;
                        // delta_vols = valueClock.delta_vols;
                        negative_vol = valueClock.negative_vol/1000;
                        positive_vol = valueClock.positive_vol/1000;
                        total_vol = valueClock.total_vol/1000;

                        break;
                    }
                }
            }

            mtmlBody += "<tr>";
            mtmlBody += "<td></td>";
            mtmlBody += "<td>"+id+"</td>";
            mtmlBody += "<td>"+positive_vol+"</td>";
            mtmlBody += "<td>"+negative_vol+"</td>";
            mtmlBody += "<td>"+total_vol+"</td>";
            mtmlBody += "<td>"+current_flow_rate+"</td>";
            mtmlBody += "<td>"+current_water_temp+"°C"+"</td>";
            mtmlBody += "<td>"+battery + "%" +"</td>";
            mtmlBody += "<td>"+moment.unix(current_ts).format("YYYY/MM/DD HH:mm")+"</td>";

            mtmlBody += "</tr>";

            option += '<option value="'+data[i].id+'" selected>'+id+'</option>';
        }

        option += '</select>';
    }
    mtmlBody += "</tbody></table>";
    $("#listClock").html(mtmlBody);

    var table = $("#listDeviceTable").DataTable({
        responsive: true,
        order: [[ 1, "desc" ]],
        lengthMenu: [
            [ 10, 50, -1],
            ['10', '50', 'Tất cả']
        ],
        "columnDefs": [ {
            "targets": 0,
            "orderable": false
        } ],
        searching: true,
        "bLengthChange" : true,
        "bInfo":true
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();

    //select
    $("#selectClock").html(option);
    $('.single-select').select2({
        theme: 'bootstrap4',
        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
        placeholder: $(this).data('placeholder'),
        allowClear: Boolean($(this).data('allow-clear'))
    });

    getHistoryClock();
}