/**
 * Created by vtk-anhlt166 on 2/1/23.
 */
function appendDataFormChooseSubs() {
    var count_pack_data = document.getElementsByClassName("count_pack_data");
    var item = "";
    for(var i=0; i<count_pack_data.length; i++){
        // console.log(count_pack_data[i]);
        var sttId = count_pack_data[i].getAttribute("stt");
        var namePack = $("#goi_cuoc_"+sttId).val();
        // console.log(sttId);
        item +=
            '<div class="row">'+
            '<div class="col-md-12 m-t-4">'+
            '<span class="display-4 title-section-1">'+(i+1)+Messages("subscriber.choose.title")+namePack+'</span>'+
            '</div>'+
            '<div class="col-md-12 mt-3">'+
            '<div class="row m-b-3">'+
            '<div class="col-sm-5">'+
            '<input class="form-check-input" name="inlineRadio_'+sttId+'" type="radio" id="" onclick="getConnectSubscriberChoose('+sttId+')"><label class="form-check-label" for="">'+Messages("subscriber.choose.label")+'</label>'+
            '</div>'+
            '<div class="col-sm-7">'+
            '<input class="form-check-input" name="inlineRadio_'+sttId+'" type="radio" id="" onclick="getConnectSubscriberRamdom('+sttId+')"><label class="form-check-label" for="">'+Messages("subscriber.random.label")+'</label>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-12 mt-3">'+
            '<div class="card-body">'+
            '<div class="row">'+
            '<label class="col-sm-3 col-form-label title-section-2" style="text-align: left">'+Messages("subscriber.needed.label")+'</label>'+
            '<div class="col-sm-4">'+
            '<input class="form-control countSubscriberBuy" id="countSubscriberBuy_'+sttId+'" value="'+count_pack_data[i].value+'" type="number" readonly>'+
            '</div>'+
            '</div>'+
            '<div id="tabChooseSubsRamdom_'+sttId+'" style="display: none">'+
            '</div>'+
            '<div id="tabChooseSubsSearch_'+sttId+'" style="display: none">'+
            '<div class="row mt-3">'+
            '<label class="col-sm-3 col-form-label title-section-2" style="text-align: left">'+Messages("subscriber.search.label")+'</label>'+
            '<div class="col-sm-4">'+
            '<input class="form-control" id="textSearchChooseSubs_'+sttId+'" type="number" onchange="" placeholder="'+Messages("subscriber.search.placeholder")+'" onKeyPress="if(this.value.length==15) return false;">'+
            '</div>'+
            '<div class="col-sm-3">'+
            '<button type="button" class="btn btn-search float-start" onclick="searchSubscriberByStock('+sttId+')" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">'+Messages("subscriber.search.button")+'</button>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="row">'+
            '<div class="table-responsive mt-3" id="tableBuySubscriber_'+sttId+'"></div>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</div>';
    }

    $("#tabChooseSubsForPackdata").html(item);

}

//ramdom
function getConnectSubscriberRamdom(sttId){
    document.getElementById("tabChooseSubsRamdom_"+sttId).style.display = 'block';
    document.getElementById("tabChooseSubsSearch_"+sttId).style.display = 'none';
    $("#tableBuySubscriber_"+sttId).html("");

    var body = new FormData;
    var countTotal = 0;
    var listCount = document.getElementsByClassName("count_pack_data");
    if(listCount != undefined && listCount.length>0){
        for(var i=0 ; i<listCount.length; i++){
            // console.log(listCount[i].value);
            countTotal += parseInt(listCount[i].value);
        }
    }
    body.count = countTotal;
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoOrderController.getConnectSubscriberRamdom();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(data){
            console.log('%c getConnectSubscriberRamdom', 'background: #222; color: #bada55');
            console.log(data);
            if(data.content != null){
                if(data.content.lstIsdn != null && data.content.lstIsdn.length > 0){
                    var listIsdnArr = new Array;
                    var mtml = "";
                    mtml +=
                        "<table id='smlTableChooseSubs_"+sttId+"' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
                        "<thead>" +
                        "<th>"+Messages("STT")+"</th>" +
                        "<th>"+Messages("subscriber.number.label")+"</th>" +
                        "<th style='display: none;'>"+"<input type='checkbox' id='checkall-chooseSubsBuy-"+sttId+"' onchange='checkAll(this, "+sttId+")' checked>"+"</th>" +
                        "</thead>" +
                        "<tbody>";
                    var num = 0;
                    var count = $("#countSubscriberBuy_"+sttId).val();
                    console.log(count);
                    for(var i=0; i<data.content.lstIsdn.length; i++){
                        if(num >= count){
                            break;
                        } else {
                            if(checkContainIsdnChoosed(data.content.lstIsdn[i].isdn)){
                                num++;
                                mtml += "<tr>";
                                mtml += "<td>" +num+ "</td>";
                                mtml += "<td class='tb-choose'>" + data.content.lstIsdn[i].isdn + "</td>";
                                mtml += "<td style='display: none;'>" +"<input type='checkbox' class='chooseSubsBuy checkbox-chooseSubsBuy-"+sttId+"' id='checkbox-"+data.content.lstIsdn[i].isdn+"' value='"+data.content.lstIsdn[i].isdn+"' pack='"+$("#goi_cuoc_"+sttId).val()+"' sttId='"+sttId+"' onchange='checkListCheckbox("+sttId+")' checked>"+ "</td>";
                                mtml += "</tr>";

                                var isdns = {
                                    "isdn": data.content.lstIsdn[i].isdn
                                };
                                listIsdnArr.push(isdns);
                            }
                        }
                    }
                    if(num < count){
                        showNotification('danger',Messages("subscriber.stock.insufficient"));
                    }

                    mtml += "</tbody></table>";
                    $("#tableBuySubscriber_"+sttId).html(mtml);

                    // var table = $("#smlTableChooseSubs_"+sttId).DataTable({
                    //     // responsive: true,
                    //     order: false,
                    //     lengthMenu: false,
                    //     searching: false,
                    //     "bLengthChange" : false,
                    //     "bInfo":true
                    // });
                    // table.on('order.dt search.dt', function () {
                    //     table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                    //         cell.innerHTML = i+1;
                    //     } );
                    // } ).draw();

                    //block list isdn
                    // console.log("block isdn list - ", listIsdnArr);
                    // var body = new FormData;
                    // body.isdns = listIsdnArr;
                    // console.log(body);
                    // var r = jsRoutes.controllers.TelcoOrderController.blockIsdnVht();
                    // $.ajax({
                    //     type: r.type,
                    //     data: JSON.stringify(body),
                    //     contentType: "application/json; charset=utf-8",
                    //     url: r.url,
                    //     success: function (datas) {
                    //         console.log('%c blockIsdnVht', 'background: #222; color: #bada55');
                    //         console.log(datas);
                    //     },
                    //     error: function (xhr) {
                    //         console.log(xhr);
                    //     },
                    //     complete: function (){
                    //         // FinishProcess();
                    //     }
                    // })
                } else {
                    showNotification('danger',data.content.description);
                }
            } else {
                showNotification('danger',Messages("data.fetch.failed"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

//choose
function getConnectSubscriberChoose(sttId) {
    console.log(sttId);
    document.getElementById("tabChooseSubsRamdom_" + sttId).style.display = 'none';
    document.getElementById("tabChooseSubsSearch_" + sttId).style.display = 'block';
    $("#tableBuySubscriber_"+sttId).html("");

    var mtml = "";
    mtml +=
        "<table id='smlTableChooseSubs_"+sttId+"' class='table table-striped table-bordered' cellspacing='0' width='100%'>" +
        "<thead>" +
        "<th>"+Messages("STT")+"</th>" +
        "<th>"+Messages("subscriber.number.label")+"</th>" +
        "<th>"+"<input type='checkbox' id='checkall-chooseSubsBuy-"+sttId+"' onchange='checkAll(this, "+sttId+")' checked>"+"</th>" +
        "</thead>" +
        "<tbody>";
    mtml += "</tbody></table>";
    $("#tableBuySubscriber_"+sttId).html(mtml);
}

// var listSubsChooseInStock = new Array;
function searchSubscriberByStock(sttId) {
    sttIdCurrent = sttId;
    console.log(sttIdCurrent);

    if($("#textSearchChooseSubs_"+sttId).val().length <= 0){
        showNotification('danger', Messages("search.input.required"));
        return;
    }

    var body = new FormData;
    body.isdn = $("#textSearchChooseSubs_"+sttId).val();
    console.log(body);
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
                        "<th>"+Messages("subscriber.number.short")+"</th>" +
                        "<th>"+Messages("subscriber.choose.column")+"</th>" +
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
                    $("#tableSearchBuySubsInStock").html(mtml);

                    // var table = $("#smlTableSearchSubsStock").DataTable({
                    //     // responsive: true,
                    //     order: false,
                    //     lengthMenu: false,
                    //     searching: false,
                    //     "bLengthChange" : false,
                    //     "bInfo":true
                    // });
                    // table.on('order.dt search.dt', function () {
                    //     table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                    //         cell.innerHTML = i+1;
                    //     } );
                    // } ).draw();

                    $("#searchBuySubsInStockModal").modal('show');
                } else {
                    showNotification('danger',data.content.description);
                }
            } else {
                showNotification('danger',Messages("subscriber.not.found"));
            }
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var sttIdCurrent = 0;
function chooseListSubsInStock() {
    var listSubsChooseInStock = [];
    $(".checkbox-subInStock").each(function() {
        if(this.checked){
            listSubsChooseInStock.push(this.value);
        }
    });
    console.log(listSubsChooseInStock);
    if(listSubsChooseInStock.length >  0){
        $("#searchBuySubsInStockModal").modal('hide');
    } else {
        showNotification('danger',Messages("subscriber.not.selected"));
        return;
    }

    //append to table
    var mtml = "";
    var table = document.getElementById("smlTableChooseSubs_"+sttIdCurrent);
    var totalRowCount = table.rows.length;
    listSubsChooseInStock.forEach(function (item) {
        if(checkContainIsdnChoosed(item)){
            mtml += "<tr>";
            mtml += "<td>" +totalRowCount+ "</td>";
            mtml += "<td class='tb-choose'>" + item + "</td>";
            mtml += "<td>" +"<input type='checkbox' class='chooseSubsBuy checkbox-chooseSubsBuy-"+sttIdCurrent+"' id='checkbox-"+item+"' value='"+item+"' pack='"+$("#goi_cuoc_"+sttIdCurrent).val()+"' sttId='"+sttIdCurrent+"' onchange='checkListCheckbox("+sttIdCurrent+")' checked>"+ "</td>";
            mtml += "</tr>";

            totalRowCount++;
        }
    });

    $("#tableBuySubscriber_"+sttIdCurrent).find('tbody').append(mtml);

}

//checkbox
function checkListCheckbox(sttId) {
    var countCheckbox = true;
    $(".checkbox-chooseSubsBuy-"+sttId).each(function() {
        if(!this.checked){
            countCheckbox = false;
        }
    });
    if(countCheckbox){
        document.getElementById("checkall-chooseSubsBuy-"+sttId).checked = true;
    } else {
        document.getElementById("checkall-chooseSubsBuy-"+sttId).checked = false;
    }
}
function checkAll(el, sttId) {
    $(".checkbox-chooseSubsBuy-"+sttId).each(function() {
        this.checked = el.checked;
    });
}

function checkContainIsdnChoosed(isdn) {
    //check isdn da chon
    // console.log(isdn);
    var countAs = 0;
    var listSubInTable = document.getElementsByClassName("tb-choose");
    console.log(listSubInTable);
    if(listSubInTable != undefined && listSubInTable.length>0){
        for(var l=0 ; l<listSubInTable.length; l++){
            // console.log(listSubInTable[l].innerText);
            if(listSubInTable[l].innerText == isdn){
                countAs++;
            }
        }
        if(countAs > 0){
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
}