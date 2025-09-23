$(document).ready(function () {
    getDataWithRegion();
    getListSubscriber();
})

var regionJson = new Array();
function getDataWithRegion() {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=REGION';
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].region != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].region.long, datas.content.data[i].region.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].region.name,
                                    "description": datas.content.data[i].region.full_name,
                                    "id": datas.content.data[i].region.id,
                                    "total": datas.content.data[i].total_sub
                                }
                            })
                        }
                    }
                    regionJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderMarkerWithData(regionJson, "region");
                } else {
                    showNotification('danger',Messages("noti.notFoundData"));
                }
            } else {
                showNotification('danger',Messages("noti.notFoundData"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var provinceJson = new Array();
function getDataWithProvince() {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=PROVINCE';
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].province != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].province.long, datas.content.data[i].province.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].province.name,
                                    "description": datas.content.data[i].province.full_name,
                                    "id": datas.content.data[i].province.id,
                                    "total": datas.content.data[i].total_sub
                                }
                            })
                        }
                    }
                    provinceJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderMarkerWithData(provinceJson, "province");
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var districtJson = new Array();
function getDataWithDistrict() {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=DISTRICT';
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].district != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].district.long, datas.content.data[i].district.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].district.name,
                                    "description": datas.content.data[i].district.full_name,
                                    "id": datas.content.data[i].district.id,
                                    "total": datas.content.data[i].total_sub
                                }
                            })
                        }
                    }
                    districtJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    renderMarkerWithData(districtJson, "district");
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

var cellJson;
function getDataWithCell(districtId) {
    var formData = new FormData();
    formData.param='/api/telco/subscriber/location/statistic?userId='+userId+'&groupType=CELL&districtId='+districtId;
    console.log(formData);
    StartProcess();
    var r = jsRoutes.controllers.SendApiController.getDataWithParam();
    $.ajax({
        type: r.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.length > 0){
                    var features = [];
                    for(var i=0; i < datas.content.data.length; i++){
                        if(datas.content.data[i].cell != null){
                            features.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data[i].cell.long, datas.content.data[i].cell.lat]
                                },
                                "properties": {
                                    "title": datas.content.data[i].cell.cell_id,
                                    "description": datas.content.data[i].cell.address,
                                    "id": datas.content.data[i].cell.cell_id,
                                    "total": datas.content.data[i].total_sub,
                                    "lac": datas.content.data[i].cell.lac
                                }
                            })
                        }
                    }
                    cellJson = {
                        "type": "FeatureCollection",
                        "features": features
                    }
                    console.log(cellJson);
                    renderMarkerWithData(cellJson, "cell");
                }

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();

            setTimeout(function () {
                isShowRegion = false;
                isShowProvince = false;
                isShowDistrict = false;
            }, 1000);
        }
    })
}

function getListSubscriber() {
    document.getElementById("divPagingTableIsdnMap").style.display = 'flex';

    var body = new FormData();
    body.userId = userId;
    body.isdn = $('#isdn').val().trim();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                viewIsdnToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                $("#listSubscriberIspn").find('tbody').html("");
                $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listSubscriberIspn").find('tbody').html("");
            $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            // getTotalSubscriber(body.page, body.pageSize);
        }
    })
}

function findByIsdn() {
    $("#page").val(1);
    getListSubscriber();
}

function resetSearch() {
    $("#isdn").val("");
    getListSubscriber();
}

function viewIsdnToTable(data, startAt, page, pageSize) {
    var body = "";
    var listSubscriber = data.listSubscriber;
    if (listSubscriber!=null && listSubscriber.length > 0) {
        $("#notiNotDataSubs").html("");
        for (var i = 0; i < listSubscriber.length; i++) {
            var curIsdn = listSubscriber[i].isdn;
            var curSerial = listSubscriber[i].serial;
            body += "<tr class='cursor-pointer' onclick='searchByIsdn(\""+curIsdn+"\", \""+curSerial+"\")'>";
            body += "<th>"+(startAt+i+1)+"</th>";
            body += "<td>" + listSubscriber[i].isdn + "</td>";
            body += "</tr>";
        }
    } else {
        $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
    }
    $("#listSubscriberIspn").find('tbody').html(body);
    pagingTableIsdnMap(data.countSubscriber, page, pageSize);
}

var cellPointJson;
var IsdnFeatures = [];
var zoomOnSearch = false;
function searchByIsdn(isdn, serial) {
    cellPointJson = {};
    IsdnFeatures = [];
    zoomOnSearch = true;
    var body = new FormData();
    var isdns = new Array();
    isdns.push({isdn: isdn, serial: serial});
    body.isdns = isdns;
    console.log(body);

    StartProcess();
    var r = jsRoutes.controllers.TelcoLocationController.searchByIsdn();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            console.log('onSearch1', zoomOnSearch);
            if(datas.content != null){
                if(datas.content.data != null && datas.content.data.data != null && datas.content.data.data.length > 0){
                    removeAllMarker();
                    for(var i=0; i < datas.content.data.data.length; i++){
                        IsdnFeatures.push({
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [datas.content.data.data[i].long, datas.content.data.data[i].lat]
                                },
                                "properties": {
                                    "title": datas.content.data.data[i].cell_id,
                                    "description": datas.content.data.data[i].address,
                                    "id": datas.content.data.data[i].cell_id,
                                    "total": "",
                                    "lac": datas.content.data.data[i].lac
                                }
                            })

                    }
                    console.log(IsdnFeatures);
                    cellPointJson = {
                        "type": "FeatureCollection",
                        "features": IsdnFeatures
                    }
                    console.log(cellPointJson);
                    renderMarkerWithData(cellPointJson, "cell");
                    // zoomOnSearch = false;
                } else {
                    showNotification('danger',Messages("Không có dữ liệu"));
                }
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listSubscriberIspn").find('tbody').html("");
            $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            console.log('complete')
            setTimeout(function () {
                isShowRegion = false;
                isShowProvince = false;
                isShowDistrict = false;
            }, 1000);
        }
    })
}

function pagingTableIsdnMap(total, page, pageSize) {
    console.log("total : " + total);
    console.log("page : " + page);
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("Tổng ")+total+Messages(" bản ghi")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchIsdnMap(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchIsdnMap('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchIsdnMap('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearchIsdnMap('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchIsdnMap('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchIsdnMap('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearchIsdnMap('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTableIsdnMap").html(paging);

}

function applySearchIsdnMap(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);
    getListSubscriber();
}

function ApplyFilterIsdnMap(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );
    getListSubscriber()
}

function dbclickDistrictMarker(id) {
    console.log(id);
    removeAllMarker();
    getDataWithCell(id);
}


