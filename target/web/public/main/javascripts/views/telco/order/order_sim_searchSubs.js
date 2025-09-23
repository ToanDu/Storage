/**
 * Created by vtk-anhlt166 on 1/16/23.
 */
var listSubsChooseInStock = new Array;
function searchSubscriberByStock() {
    listSubsChooseInStock = [];
    if($("#textSearchChooseSubs").val().length < 1){
        showNotification('danger',Messages("Bạn hãy nhập ít nhất 1 chữ số để tìm kiếm thuê bao"));
        return;
    }
    var body = new FormData;
    body.isdn = $("#textSearchChooseSubs").val();
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.searchSubscriberByStock();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log('%c searchSubscriberByStock', 'background: #222; color: #bada55');
            console.log(data);
            if(data.content != null){
                if(data.content.lstIsdn != null && data.content.lstIsdn.length > 0){
                    var mtml = "";
                    mtml +=
                        "<table id='smlTableSearchSubsStock' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
                        "<thead>" +
                        "<th>"+Messages("STT")+"</th>" +
                        "<th>"+Messages("Số TB")+"</th>" +
                        "<th>"+Messages("Chọn")+"</th>" +
                        "</thead>" +
                        "<tbody>";

                    data.content.lstIsdn.forEach(function (item, key) {
                        mtml += "<tr>";
                        mtml += "<td>" +(key+1)+ "</td>";
                        mtml += "<td>" + item.isdn + "</td>";
                        mtml += "<td>"+"<input type='checkbox' class='checkbox-subInStock' value='"+item.isdn+"'>"+"</td>";
                        mtml += "</tr>";
                    });

                    mtml += "</tbody></table>";
                    $("#tableSearchSubsInStock").html(mtml);

                    var table = $("#smlTableSearchSubsStock").DataTable({
                        // responsive: true,
                        order: false,
                        lengthMenu: false,
                        searching: false,
                        "bLengthChange" : false,
                        "bInfo":true
                    });
                    table.on('order.dt search.dt', function () {
                        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                            cell.innerHTML = i+1;
                        } );
                    } ).draw();

                    $("#searchSubsInStockModal").modal('show');
                } else {
                    showNotification('danger',data.content.description);
                }
            } else {
                showNotification('danger',Messages("Không tìm thấy thuê bao"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function chooseListSubsInStock() {
    $(".checkbox-subInStock").each(function() {
        if(this.checked){
            listSubsChooseInStock.push(this.value);
        }
    });
    console.log(listSubsChooseInStock);
    if(listSubsChooseInStock.length >  0){
        $("#searchSubsInStockModal").modal('hide');
    } else {
        showNotification('danger',Messages("Bạn chưa chọn thuê bao"));
        return;
    }

    //append to table
    var myTab = document.getElementById('smlTableChooseSubsChoose');
    var stt = 0;
    var listIsdnArr = new Array;

    for(var s=0; s<listSubsChooseInStock.length; s++){
        for (var i = 1; i < myTab.rows.length; i++) {
            var objCells = myTab.rows.item(i).cells;
            if(objCells.item(2).innerHTML == undefined || objCells.item(2).innerHTML == ""){
                var listSubInTable = document.getElementsByClassName("tb-choose");
                var countAs = 0;
                if(listSubInTable != undefined && listSubInTable.length>0) {
                    for (var l = 0; l < listSubInTable.length; l++) {
                        if(listSubInTable[l].innerText == listSubsChooseInStock[s]){
                            countAs++;
                        }
                    }
                }
                if(countAs == 0){
                    objCells.item(2).innerHTML = listSubsChooseInStock[s];
                    break;
                }
            }
        }
    }
}

function blockIsdnVht(listIsdnArr) { //khoa so thue bao
    var body = new FormData;
    body.isdns = listIsdnArr;
    console.log(body);

    var r = jsRoutes.controllers.TelcoOrderController.blockIsdnVht();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log('%c blockIsdnVht', 'background: #222; color: #bada55');
            console.log(datas);
            if (datas.success) {
                if(datas.content.data != null && datas.content.data.length > 0){
                    datas.content.data.forEach(function (item, key) {
                        document.getElementById("tb-choose-"+item.serial).style.color = "green";
                    })
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
        },
        complete: function (){
            // FinishProcess();
        }
    })
}