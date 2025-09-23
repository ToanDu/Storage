
document.getElementById('shows').style.display = "none";
document.getElementById('shows1').style.display = "none";
document.getElementById('shows2').style.display = "none";
document.getElementById('shows3').style.display = "none";

function Clickme(id){
    let el = document.getElementById('btn-shows');
    let el1 = document.getElementById('btn-shows1');
    let el2 = document.getElementById('btn-shows2');
    let el3 = document.getElementById('btn-shows3');
    switch(id) {
        case 1:
            if( el.ariaExpanded == 'true'){
                document.getElementById('shows').style.display = "none";
                document.getElementById('hide').style.display = "initial";
            }else {
                document.getElementById('shows').style.display = "initial";
                document.getElementById('hide').style.display = "none";
            }
            break;
        case 2:
            if( el1.ariaExpanded == 'true'){
                document.getElementById('shows1').style.display = "none";
                document.getElementById('hide1').style.display = "initial";
            }else {
                document.getElementById('shows1').style.display = "initial";
                document.getElementById('hide1').style.display = "none";
            }
            break;
        case 3:
            if( el2.ariaExpanded == 'true'){
                document.getElementById('shows2').style.display = "none";
                document.getElementById('hide2').style.display = "initial";
            }else {
                document.getElementById('shows2').style.display = "initial";
                document.getElementById('hide2').style.display = "none";
            }
            break;
        case 4:
            if( el3.ariaExpanded == 'true'){
                document.getElementById('shows3').style.display = "none";
                document.getElementById('hide3').style.display = "initial";
            }else {
                document.getElementById('shows3').style.display = "initial";
                document.getElementById('hide3').style.display = "none";
            }
            break;
        default:
    }
}

$('.carousel').carousel({
    interval: false,
});
function goToByScroll(id){
    if(window.location.pathname !== "/") {
        window.location.pathname = "/"
    }
    // Scroll
    $('html,body').animate({
            scrollTop: $("#"+id).offset().top-60},
        'slow');
}

let offerType = '';
let payType = '';
let category = 'METERING';
function clickTab(tab){
    switch(tab) {
        case 1:
            category = 'METERING'
            getListProductOfferPack2(offerType, payType, 'METERING')
            getListProductOfferPack2(offerType, payType, 'METERING')
            break;
        case 2:
            category = 'TRACKING'
            getListProductOfferPack2(offerType, payType, 'TRACKING')
            break;
        case 3:
            category = 'POS'
            getListProductOfferPack2(offerType, payType, 'POS')
            break;
        case 4:
            category = 'SMART_SPEAKER'
            getListProductOfferPack2(offerType, payType, 'SMART_SPEAKER')
            break;
        case 5:
            category = 'ADS_SCREEN'
            getListProductOfferPack2(offerType, payType, 'ADS_SCREEN')
            break;
        case 6:
            category = 'CAMERA'
            getListProductOfferPack2(offerType, payType, 'CAMERA')
            break;
        case 7:
            category = 'CAR'
            getListProductOfferPack2(offerType, payType, 'CAR')
            break;
        case 8:
            category = 'SELL_DEVICE'
            getListProductOfferPack2(offerType, payType, 'SELL_DEVICE')
            break;
        case 9:
            category = ''
            getListProductOfferPack2(offerType, payType, '')
            getListProductOfferPack2(offerType, payType, '')
            break;
        default:
            category = 'METERING'
            getListProductOfferPack2(offerType, payType, 'METERING')
    }
};
$(function() {
    $('#switch1').change(function() {
        const checkbox = document.getElementById('switch2');
        if($(this).prop('checked') == true) {
            if(checkbox.checked == false){
                offerType= 'NB'
                payType = 'PRE_PAID'
                getListProductOfferPack2('NB', 'PRE_PAID', category)
            }else{
                offerType= 'NB'
                payType = 'POST_PAID'
                getListProductOfferPack2('NB', 'POST_PAID', category)
            }

        }else {
            if(checkbox.checked == false){
                offerType= '4G'
                payType = 'PRE_PAID'
                getListProductOfferPack2('4G', 'PRE_PAID', category)
            }else{
                offerType= '4G'
                payType = 'POST_PAID'
                getListProductOfferPack2('4G', 'POST_PAID', category)
            }
        }
        console.log(offerType)
        console.log(checkbox.checked)
    })
    $('#switch2').change(function() {
        const checkbox2 = document.getElementById('switch1');
        if($(this).prop('checked') == true) {
            // payType = 'POST_PAID'
            // getListProductOfferPack2(offerType, 'POST_PAID', category)
            if(checkbox2.checked == false){
                offerType= '4G'
                payType = 'POST_PAID'
                getListProductOfferPack2('4G', 'POST_PAID', category)
            }else{
                offerType= 'NB'
                payType = 'POST_PAID'
                getListProductOfferPack2('NB', 'POST_PAID', category)
            }
        }else {
            // payType = 'PRE_PAID'
            // getListProductOfferPack2(offerType, 'PRE_PAID', category)
            if(checkbox2.checked == false){
                offerType= '4G'
                payType = 'PRE_PAID'
                getListProductOfferPack2('4G', 'PRE_PAID', category)
            }else{
                offerType= 'NB'
                payType = 'PRE_PAID'
                getListProductOfferPack2('NB', 'PRE_PAID', category)
            }
        }
        console.log(payType)
        console.log(checkbox2.checked)
    })
})
$(document).ready(function() {
    offerType = '4G';
    payType = 'PRE_PAID';
    getListProductOfferPack2(offerType, payType, category);
});
let listProductOfferPack2 = [];
let listChecked= [];
function getListProductOfferPack2(a, b, c) {
    var r = jsRoutes.controllers.LandingPageController.getListProductOfferPack(a,b,c);
    console.log(a)
    console.log(b)
    console.log(c)
    $.ajax({
        type: r.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            listProductOfferPack2 = data.content.data;
            console.log(listProductOfferPack2)
            listChecked = []
            for (let i = 0; i < listCompare.length ; i++){
                const idx = listProductOfferPack2.findIndex(el=> el.name === listCompare[i].name)
                if(idx >= 0) {
                    listChecked.push(idx)
                }
            }
            for (let a = 0;a < listChecked.length ; a++){
                $("#checkbox")[listChecked[a]].checked = true
            }
            console.log(listChecked)
            if(!c) c = "ALL";
            $(`#${c}`).html(`<div class="owl-carousel mt-4"></div>`);
            if(listProductOfferPack2 && amoutCompare < 5) {

                // $(`#${eid}`).html(`<div class="owl-carousel mt-4"></div>`);
                var carouselItems = "";
                for (var i = 0; i < listProductOfferPack2.length; i++) {
                    console.log(listProductOfferPack2[i])
                    carouselItems += `<div class="item" >
                            <div>
                                <div class="card2-listProject" style="">
                                    <div class="alignItemCenter mt-4" style="text-align: center;">
                                        <input type="checkbox" class = "myCheckbox" onclick="clickCheckbox(this, ${i})" id="checkbox-${listProductOfferPack2[i].name}" name="checkbox" >
                                        <div class="pack" style="display: inline-block;">${listProductOfferPack2[i].name}</div>
                                    </div>
                                    <div class="text mt-3">
                                        <p class="money">${listProductOfferPack2[i].fee}</p>
                                    </div>
                                    <div class="content-custom">
                                       <div class="description">
                                            <i class="fa fa-check" aria-hidden="true"></i>                                        
                                            <p class="descriptions opacity-8">${listProductOfferPack2[i].discountPromotionData}</p>
                                       </div>
                                      <div class="description">
                                            <i class="fa fa-check" aria-hidden="true"></i>  
                                          <p class="descriptions opacity-8">${listProductOfferPack2[i].monthlyFee} ${Messages("monthly subscriber")}</p>
                                      </div>
                                      <div class="description">
                                            <i class="fa fa-check" aria-hidden="true"></i>  
                                          <p class="descriptions opacity-8">Mã đăng ký: ${listProductOfferPack2[i].offerCode}</p>
                                      </div>
                                    </div>
                                    <div class="modal-dialog_btn-2column">
                                        <button type="button" class="button button_normal" style="background: #EA0033; color: #FFFFFF" data-toggle="modal" data-target="#questionModal1">Đăng ký ngay<span style="margin-left: 4px;">&#8599;</span></button>
                                    </div>
                                </div>
                            </div>
                        </div>`;
                    // $(`#${eid} div`).append(carouselItem);
                    // console.log(carouselItems)
                }


                $(`#${c} div`).append(carouselItems);
                $(`#${c} div`).owlCarousel({
                    loop:false,
                    margin:0,
                    // autoPlayTimeout:500,
                    // autoplaySpeed:5500,
                    autoHeight:true,
                    autoplayHoverPause:false,
                    nav:true,
                    navText: ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"],
                    responsive:{
                        0:{
                            items:1
                        },
                        600:{
                            items:1
                        },
                        1000:{
                            items:4
                        }
                    }
                });
            }else{

                // $(`#${eid}`).html(`<div class="owl-carousel mt-4"></div>`);
                var carouselItems = "";
                for (var i = 0; i < listProductOfferPack2.length; i++) {
                    console.log(listProductOfferPack2[i])
                    carouselItems += `<div class="item" >
                            <div>
                                <div class="card2-listProject" style="">
                                    <div class="alignItemCenter mt-4" style="text-align: center;">
                                        <input type="checkbox" class = "myCheckbox" onclick="clickCheckbox(this, ${i})" id="checkbox-${listProductOfferPack2[i].name}" name="checkbox" disabled>
                                        <div class="pack" style="display: inline-block;">${listProductOfferPack2[i].name}</div>
                                    </div>
                                    <div class="text mt-3">
                                        <p class="money">${listProductOfferPack2[i].fee}</p>
                                    </div>
                                    <div class="content-custom">
                                       <div class="description">
                                            <i class="fa fa-check" aria-hidden="true"></i>                                        
                                            <p class="descriptions opacity-8">${listProductOfferPack2[i].discountPromotionData}</p>
                                       </div>
                                      <div class="description">
                                            <i class="fa fa-check" aria-hidden="true"></i>  
                                          <p class="descriptions opacity-8">${listProductOfferPack2[i].monthlyFee}+ ${Messages("monthly subscriber")}</p>
                                      </div>
                                      <div class="description">
                                            <i class="fa fa-check" aria-hidden="true"></i>  
                                          <p class="descriptions opacity-8">Mã đăng ký: ${listProductOfferPack2[i].offerCode}</p>
                                      </div>
                                    </div>
                                    <div class="modal-dialog_btn-2column">
                                        <button type="button" class="button button_normal" style="background: #EA0033; color: #FFFFFF" data-toggle="modal" data-target="#questionModal1">Đăng ký ngay<span style="margin-left: 4px;">&#8599;</span></button>
                                    </div>
                                </div>
                            </div>
                        </div>`;
                    // $(`#${eid} div`).append(carouselItem);
                    // console.log(carouselItems)
                }


                $(`#${c} div`).append(carouselItems);
                $(`#${c} div`).owlCarousel({
                    loop:false,
                    margin:0,
                    // autoPlayTimeout:500,
                    // autoplaySpeed:5500,
                    autoHeight:true,
                    autoplayHoverPause:false,
                    nav:true,
                    navText: ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"],
                    responsive:{
                        0:{
                            items:1
                        },
                        600:{
                            items:1
                        },
                        1000:{
                            items:4
                        }
                    }
                });
            }
        },
    })
}
let listCompare = []; // ipchecking-0, ipchecking-1, metering-0
let amoutCompare = 0;
function clickCheckbox(e, idx) {
    const checkboxes = document.querySelectorAll('.myCheckbox');

    if ($(e)[0].checked){
        listCompare.push(listProductOfferPack2[idx])
        amoutCompare += 1
        if (listCompare.length > 1 && listCompare.length < 6){
                $("#btncompare")[0].disabled = false
        } else {
            $("#btncompare")[0].disabled = true
        }

    }else {
        listCompare = listCompare.filter(item => item.name !== listProductOfferPack2[idx].name);
        amoutCompare -= 1
        checkboxes.forEach((checkbox) => {
            if (!checkbox.checked) {
                checkbox.disabled = false;
            }
        });
        if (listCompare.length > 1 && listCompare.length < 6){
            $("#btncompare")[0].disabled = false
        } else {
            $("#btncompare")[0].disabled = true
        }
    }

    if (amoutCompare == 5 ) {
        checkboxes.forEach((checkbox) => {
            if (!checkbox.checked) {
                checkbox.disabled = true;
            }
        });
        showNotification("info", Messages("So sánh tối đa 5 gói cước"))
    }
}
function selectData() {
    listCompare = [];
    amoutCompare = 0;
    $("#btncompare")[0].disabled = true;
    getListProductOfferPack2(offerType, payType, category);
}
var popup = "popup"
function clickCompare() {  //click so sánh
    $(`#${popup}`).html(`<div class="modal-body"></div>`);
    var compareItems = `
    <table id='smlTableChooseSubsChoose1' class='table table-striped table-bordered' cellspacing='0' width='100%'>
        <tr>
            <th>Tên gói</th>
    `
    for (var i = 0; i < listCompare.length; i++ ){
        console.log(i)
        compareItems += `
        <td> ${listCompare[i].name} </td>
        `;
    }
    compareItems += `
                </tr>   
                <tr>
                    <th>Phí cước</th>
        `;
    for (var i = 0; i < listCompare.length; i++ ){
        compareItems += `
        <td> ${listCompare[i].fee} </td>
        `;
    }
    compareItems += `
                </tr>
                <tr>
                    <th>Mã đăng ký</th>
        `;
    for (var i = 0; i < listCompare.length; i++ ) {
        compareItems += `
        <td> ${listCompare[i].offerCode} </td>
        `;
    }
    compareItems += `</tr>
                    <tr>
                        <th>Gói cước</th>
        `;
    for (var i = 0; i < listCompare.length; i++ ) {
        compareItems += `
        <td> ${listCompare[i].offerType} </td>
        `;
    }
    compareItems += `</tr>
                    <tr>
                        <th>Ưu đãi data/tháng</th>
        `;
    for (var i = 0; i < listCompare.length; i++ ){
        compareItems += `
        <td> ${listCompare[i].discountPromotionData} </td>
        `;
    }
    compareItems += `</tr>
                    <tr>
                        <th>Cước thuê bao tháng</th>
        `;
    for (var i = 0; i < listCompare.length; i++ ) {
        compareItems += `
        <td> ${listCompare[i].monthlyFee} </td>
        `;
    }
    compareItems += `</tr> 
                    </table>
        `;
    $(`#${popup} div`).append(compareItems);
    listCompare = [];
}
function submitFormContactTelco() {
    var dataForm = new FormData;
    dataForm.name = $("#name").val();
    dataForm.email = $("#email").val();
    dataForm.phone = $("#phone").val();
    dataForm.content = $("#content").val();
    console.log(dataForm);


    document.getElementById("buttonSubmitContacts").disabled = true;
    var r = jsRoutes.controllers.LandingPageController.submitFormContactTelco();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(dataForm),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                $("#name").val("");
                $("#email").val("");
                $("#phone").val("");
                $("#content").val("")
            }else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages(" Vui lòng điền nhập đủ các trường thông tin"));
        },
        complete: function (jqXHR, textStatus) {
            document.getElementById("buttonSubmitContacts").disabled = false;
        }
    });
}
function checkButton() {
    if (flagLogin === 'notLogin'){
        window.location.href = '/login';
    }else{
        if(document.getElementById('age1').checked) {
            window.location.href = "/telco/orderSubs/"+userId;
        }
        else if(document.getElementById('age2').checked) {
            window.location.href = "/telco/buySim/" +userId;
        }
    }

}
$('.owl-carousel.mt-4').owlCarousel({
    loop:true,
    margin:0,
    nav:true,
    autoplay:true,
    autoplayTimeout:3000,
    autoplayHoverPause:true,
    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
    responsive:{
        0:{
            items:1
        },
        600:{
            items:0
        },
        1000:{
            items:4
        }
    }
})
$('.owl-carousel.mt-2').owlCarousel({
    loop:false,
    margin:4,
    nav:true,
    autoplayTimeout:6000,
    autoplayHoverPause:false,
    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
    responsive:{
        0:{
            items:1
        },
        600:{
            items:1
        },
        1000:{
            items:1
        }
    }
})
$('.owl-carousel.mt-5').owlCarousel({
    loop:false,
    margin:10,
    nav:true,
    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
    responsive:{
        0:{
            items:1
        },
        600:{
            items:1
        },
        1000:{
            items:1
        }
    }
})
$('.owl-carousel.mt-6').owlCarousel({
    loop:true,
    margin:10,
    nav:true,
    autoplay:true,
    autoplayTimeout:3000,
    autoplayHoverPause:true,
    navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
    responsive:{
        0:{
            items:1
        },
        600:{
            items:1
        },
        1000:{
            items:4
        }
    }
})