function showNotification(type, content, status){
    if(type == "success"){
        success_noti(content);
    } else if(type == "info") {
        info_noti(content);
    } else {
        error_noti(content, status);
    }
}

function error_noti(content, status) {
    var mess = "";
    if(status > 0){
        mess = Messages("error", status) + Messages(" ");
    }
    Lobibox.notify('error', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        sound: false,
        position: 'top right',
        icon: 'bx bx-x-circle',
        msg: mess + content,
        delay: 3000
    });
}

function success_noti(content) {
    Lobibox.notify('success', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        sound: false,
        position: 'top right',
        icon: 'bx bx-check-circle',
        msg: content,
        delay: 1500
    });
}

function info_noti(content) {
    Lobibox.notify('info', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        sound: false,
        position: 'top right',
        icon: 'bx bx-comment-detail',
        msg: content,
        delay: 2500
    });
}