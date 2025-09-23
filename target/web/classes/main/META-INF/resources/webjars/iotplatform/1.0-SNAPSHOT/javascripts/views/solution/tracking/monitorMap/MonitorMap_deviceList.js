/**
 * Created by vtk-anhlt166 on 9/20/21.
 */
var deviceListController = (function () {
    return {
        init: function () {
            // console.log('Application has started.');
        },
        renderDeviceListTable: function (data) {
            console.log(data);
            $("#id-sum-stt").html(data.length);
            if(data.length > 0){
                $("#table-map-view tbody:last-child").html("");
                for(var i =0; i<data.length; i++){
                    // var logdate = (data[i].dateTracking > 0) ? moment.unix(data[i].dateTracking).format("DD/MM/YYYY HH:mm") : 0;

                    $("#table-map-view tbody:last-child").append('<tr onclick="controller.selectMarker(\'' + data[i].id + '\', ' + true + ' )" class="list_device" id="map-index-' + data[i].id + '" style="cursor: pointer; background-color: #fff; border-bottom: 1px solid #D6D6D7">' +
                        '<td class="text-center">' + (i + 1) + '</td>\n' +
                        '<td class="name_device">' + data[i].name + '</td>\n' +
                        '<td id="status_'+data[i].id+'">' + data[i].status + '</td>\n' +
                        '</tr>');
                }
            }
        }
    }
})();