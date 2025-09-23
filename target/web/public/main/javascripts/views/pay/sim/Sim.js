/**
 * Created by vtk-anhlt166 on 10/4/22.
 */
$(document).ready(function () {
    processDataSimInfo();
});

function processDataSimInfo() {
    var model = new FormData;
    model.type = 3;
    model.key = simnb;
    model.project_id = projectId;
    console.log(model);

    StartProcess();
    var r = jsRoutes.controllers.ManageSimController.getDataCustomer();
    $.ajax({
        url: r.url,
        data: JSON.stringify(model),
        dataType: "json",
        type: r.type,
        contentType: "application/json; charset=utf-8",
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                var listItem = "<h6>"+Messages("Danh sách thiết bị")+"</h6>";
                var infoDevice = "";
                if(datas.content != null && datas.content.data != null && datas.content.data.data != null){
                    var listDevice = datas.content.data.data;
                    if(listDevice.length > 0){
                        for(var i=0; i<listDevice.length; i++){
                            if(listDevice[i].imei != null && listDevice[i].imei.length > 0){
                                var imei = listDevice[i].imei;
                                var statusDauNoi = "Đã đấu nối";
                                var serial = listDevice[i].serial != null ? listDevice[i].serial : "";
                                var esim = listDevice[i].esim != null ? listDevice[i].esim : "";
                                const type = ["TB trả trước", "TB trả sau"];
                                const randomType = Math.floor(Math.random() * type.length);
                                var typeService = type[randomType];

                                var statusEsim = Messages("Bình thường");
                                if(listDevice[i].tpp.alertnb == 2){
                                    statusEsim = Messages("Hết hạn");
                                } else if(listDevice[i].tpp.alertnb == 1){
                                    statusEsim = Messages("Sắp hết hạn");
                                }
                                var dateNow = new Date();
                                const money = ["10.000 đ", "20.000 đ", "50.000 đ"];
                                const randomMoney = Math.floor(Math.random() * money.length);
                                const plan = ["Tomato", "ST30K", "ST120K", "MIMAX200"];
                                const randomPlan = Math.floor(Math.random() * plan.length);

                                var serialSim = (listDevice[i].tpp != null && listDevice[i].tpp.imsinb != null) ? listDevice[i].tpp.imsinb : "";
                                var balnb = (listDevice[i].tpp.balnb > 0) ? (new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(listDevice[i].tpp.balnb)) : listDevice[i].tpp.balnb;

                                var classActive = "";
                                var liActive = "";
                                if(i == 0){
                                    liActive = "active";
                                    classActive = "show active";
                                }
                                const card = [1, 2, 5, 10];
                                const randomCard = Math.floor(Math.random() * card.length);
                                var numberNap = card[randomCard]*10000;

                                listItem += '<li class="nav-item" role="presentation"><button class="nav-link '+liActive+' btn radius-30" data-bs-toggle="tab" href="#link'+imei+'" role="tab" aria-selected="true">'+listDevice[i].id+'</button></li>';

                                infoDevice += '<div class="tab-pane fade '+classActive+'" id="link'+imei+'" role="tabpanel">'+
                                    '<div class="row">'+
                                    '<div class="col-md-6">'+
                                    '<div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">'+
                                    '<span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">'+Messages("Thông tin thiết bị")+'</span>'+
                                    '</div>'+
                                    '<div class="card mb-3" style="border: 1px solid #858687;">'+
                                    '<div class="card-body">'+
                                    '<p class="card-text" >'+Messages("ID: ")+'<label>'+listDevice[i].id+'</label></p>'+
                                    '<p class="card-text" >'+Messages("Mã IMEI: ")+'<label>'+imei+'</label></p>'+
                                    '<p class="card-text" >'+Messages("Serial: ")+'<label>'+serial+'</label></p>'+
                                    '<p class="card-text" >'+Messages("ESim: ")+'<label>'+esim+'</label></p>'+
                                    '<p class="card-text" >'+Messages("Trạng thái đấu nối: ")+'<label>'+statusDauNoi+'</label></p>'+
                                    '<p class="card-text" >'+Messages("Loại dịch vụ: ")+'<label>'+typeService+'</label></p>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+

                                    '<div class="col-md-6">'+
                                    '<div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">'+
                                    '<span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">'+Messages("Gói cước eSim")+'</span>'+
                                    '</div>'+
                                    '<div class="card mb-3" style="border: 1px solid #858687;">'+
                                    '<div class="card-body">'+
                                    '<p class="card-text" >'+Messages("Tên gói cước: ")+listDevice[i].tpp.pronb+'</p>'+
                                    '<p class="card-text" >'+Messages("Trạng thái: ")+statusEsim+'</p>'+
                                    '<p class="card-text" >'+Messages("Số dư: ")+balnb+'</p>'+
                                    '<p class="card-text" >'+Messages("Ngày nạp tiền gần nhất: ")+moment.unix(dateNow.getTime()/1000).format("DD/MM/YYYY")+'</p>'+
                                    '<p class="card-text" >'+Messages("Số tiền nạp gần nhất: ")+money[randomMoney]+'</p>'+
                                    '<p class="card-text" >'+Messages("Thời điểm hết hạn: ")+listDevice[i].tpp.expnb+'</p>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+

                                    '<div class="col-md-12">'+
                                    '<div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">'+
                                    '<span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">'+Messages("Thông tin thuê bao")+'</span>'+
                                    '</div>'+
                                    '<div class="card mb-3" style="border: 1px solid #858687;">'+
                                    '<div class="card-body">'+
                                    '<div class="row">'+
                                    '<div class="col-md-6">'+
                                    '<p class="card-text" >'+Messages("Thuê bao Viettel: Có")+'</p>'+
                                    '<p class="card-text" >'+Messages("Trạng thái thuê bao: Active")+'</p>'+
                                    '<p class="card-text" >'+Messages("Trạng thái chặn cắt: Không")+'</p>'+
                                    '<p class="card-text" >'+Messages("Ngày đấu nối: ")+moment.unix(dateNow.getTime()/1000 - 7*24*60*60).format("DD/MM/YYYY")+'</p>'+
                                    '<p class="card-text" >'+Messages("Ngày kích hoạt: ")+moment.unix(dateNow.getTime()/1000 - 7*24*60*60).format("DD/MM/YYYY")+'</p>'+
                                    '<p class="card-text" >'+Messages("Tổng tiêu dùng: ")+money[randomMoney]+'</p>'+
                                    '</div>'+
                                    '<div class="col-md-6">'+
                                    '<p class="card-text" >'+Messages("Số thuê bao: ")+listDevice[i].owner+'</p>'+
                                    '<p class="card-text" >'+Messages("Gói cước chính: ")+plan[randomPlan]+'</p>'+
                                    '<p class="card-text" >'+Messages("Ngày bắt đầu gói cước chính: ")+moment.unix(dateNow.getTime()/1000 - 7*24*60*60).format("DD/MM/YYYY")+'</p>'+
                                    '<p class="card-text" >'+Messages("Ngày hết hạn gói cước chính: ")+moment.unix(dateNow.getTime()/1000 + 23*24*60*60).format("DD/MM/YYYY")+'</p>'+
                                    '<p class="card-text" >'+Messages("Data theo KB: ")+ramdomNumber(1024, 10240) +" kb"+'</p>'+
                                    '<p class="card-text" >'+Messages("Data còn lại theo KB: ")+ramdomNumber(10240, 20480) +" kb"+'</p>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+

                                    '<div class="col-md-12">'+
                                    '<div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">'+
                                    '<span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">'+Messages("Thông tin nạp tiền, trừ tiền")+'</span>'+
                                    '</div>'+
                                    '<div class="card mb-3" style="border: 1px solid #858687;">'+
                                    '<div class="card-body">'+
                                    '<table class="table mb-0">'+
                                    '<thead>'+
                                    '<tr>'+
                                    '<th scope="col">#</th>'+
                                    '<th scope="col">'+Messages("Số tiền")+'</th>'+
                                    '<th scope="col">'+Messages("Thời gian")+'</th>'+
                                    '<th scope="col">'+Messages("Serial thẻ")+'</th>'+
                                    '<th scope="col">'+Messages("Số PIN")+'</th>'+
                                    '<th scope="col">'+Messages("Số tiền trước")+'</th>'+
                                    '<th scope="col">'+Messages("Số tiền sau")+'</th>'+
                                    '</tr>'+
                                    '</thead>'+
                                    '<tbody>'+
                                    '<tr>'+
                                    '<th scope="row">1</th>'+
                                    '<td>'+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(numberNap))+'</td>'+
                                    '<td>'+moment.unix(dateNow.getTime()/1000 - 7*24*60*60).format("DD/MM/YYYY")+'</td>'+
                                    '<td>'+ramdomString(14)+'</td>'+
                                    '<td>'+ramdomString(14)+'</td>'+
                                    '<td>'+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(0))+'</td>'+
                                    '<td>'+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(numberNap))+'</td>'+
                                    '</tr>'+
                                    '</tbody>'+
                                    '</table>'+
                                    '</div>'+
                                    '</div>'+
                                    '</div>'+

                                    '</div>';
                            }
                        }
                    }

                    $("#listDeviceOfCustomer").html(listItem);
                    $("#infoCustomer").html(infoDevice);
                } else {
                    $("#listDeviceOfCustomer").html("");
                    $("#infoCustomer").html("");
                    showNotification('danger', Messages("Không tìm được thông tin"));
                }
            } else {
                showNotification('danger', Messages("Không tìm được thông tin"));
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
}

function ramdomNumber(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}

function ramdomString(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
        result += characters.charAt(Math.floor(Math.random() *
            charactersLength));
    }
    return result;
}