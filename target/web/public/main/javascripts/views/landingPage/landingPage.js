/**
 * Created by vtk-anhlt166 on 7/6/21.
 */
$(document).ready(function () {
    var tag = document.createElement('script');
    tag.src = 'https://www.youtube.com/iframe_api';
    var firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
});
function submitFormContact() {
    success_noti('Gửi liên hệ thành công!');
    return;

    var dataForm = new FormData;
    dataForm.name = $("#name").val();
    dataForm.email = $("#email").val();Carousel
    dataForm.phone = $("#phone").val();
    dataForm.field = $("#field").val();
    dataForm.content = $("#content").val();
    console.log(dataForm);

    StartProcess();
    document.getElementById("buttonSubmitContact").disabled = true;
    var r = jsRoutes.controllers.LandingPageController.submitFormContact();
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
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
            document.getElementById("buttonSubmitContact").disabled = false;
        }
    });
}

function showVideoDevelop() {
    console.log("showVideoDevelop");
    $("#playVideoConfirm").modal('show');
}

var player1;
var player2;
var player3;
function onYouTubeIframeAPIReady() {
    player1 = new YT.Player('myVideo1', {
        events: {
            'onReady': onPlayerReady
        }
    });
    player2 = new YT.Player('myVideo2', {
        events: {
            'onReady': onPlayerReady
        }
    });
    player3 = new YT.Player('myVideo3', {
        events: {
            'onReady': onPlayerReady
        }
    });
}
function onPlayerReady(event) {
    document.getElementById('carousel-control-next').addEventListener('click', function() {
        player1.pauseVideo();
        player2.pauseVideo();
        player3.pauseVideo();
    });

    document.getElementById('carousel-control-prev').addEventListener('click', function() {
        player1.pauseVideo();
        player2.pauseVideo();
        player3.pauseVideo();
    });
}

function notiMustLogin() {
    showNotification('danger', "Bạn hãy đăng nhập để sử dụng");
}

function goToByScroll(id){
    // Scroll
    $('html,body').animate({
            scrollTop: $("#"+id).offset().top-60},
        'slow');
}

function closeRegisterDeveloper() {
    document.getElementById("register-developer").style.display = 'none';
    setTimeout(function () {
        document.getElementById("register-developer").style.display = 'block';
    },180000)
}

function notiSendMail() {
    showNotification('success', "Đăng kí thành công!");
}