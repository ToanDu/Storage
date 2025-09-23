$(() => {
    $('form.email').on('submit', sendEmail)

})
function sendEmail(event) {
    event.preventDefault()
    const $input = $(event.target).find('input[name="email"]')
    const txt_mail = $input.val().trim()
    const mailRegex = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/, 'gi')
    const isValid = txt_mail.match(mailRegex)
    return isValid ? showNotification('success', 'Gửi thành công') : showNotification('danger','Mail không hợp lệ, vui lòng nhập lại');
}
document.getElementById('hide').style.display = "none";
document.getElementById('shows1').style.display = "none";
document.getElementById('shows2').style.display = "none";
document.getElementById('shows3').style.display = "none";
document.getElementById('shows4').style.display = "none";
function Clickme(){
    document.getElementById('shows1').style.display ="none";
    document.getElementById('hide1').style.display = "initial";
    document.getElementById('shows2').style.display ="none";
    document.getElementById('hide2').style.display = "initial";
    document.getElementById('shows3').style.display ="none";
    document.getElementById('hide3').style.display = "initial";
    document.getElementById('shows4').style.display ="none";
    document.getElementById('hide4').style.display = "initial";
    let el = document.getElementById('btn-shows');
    if( el.ariaExpanded == 'true'){
        document.getElementById('shows').style.display = "none";
        document.getElementById('hide').style.display = "initial";
    }else {
        document.getElementById('shows').style.display = "initial";
        document.getElementById('hide').style.display = "none";
    }
}
function Clickme1(){
    document.getElementById('shows').style.display = "none";
    document.getElementById('hide').style.display = "initial";
    document.getElementById('shows2').style.display = "none";
    document.getElementById('hide2').style.display = "initial";
    document.getElementById('shows3').style.display = "none";
    document.getElementById('hide3').style.display = "initial";
    document.getElementById('shows4').style.display = "none";
    document.getElementById('hide4').style.display = "initial";
    let el = document.getElementById('btn-shows1');
    if( el.ariaExpanded == 'true'){
        document.getElementById('hide1').style.display = "initial";
        document.getElementById('shows1').style.display = "none";
    }else {
        document.getElementById('shows1').style.display = "initial";
        document.getElementById('hide1').style.display = "none";
    }
}
function Clickme2(){
    document.getElementById('shows').style.display = "none";
    document.getElementById('hide').style.display = "initial";
    document.getElementById('shows1').style.display = "none";
    document.getElementById('hide1').style.display = "initial";
    document.getElementById('shows2').style.display = "none";
    document.getElementById('hide2').style.display = "initial";
    document.getElementById('shows3').style.display = "none";
    document.getElementById('hide3').style.display = "initial";
    document.getElementById('shows4').style.display = "none";
    document.getElementById('hide4').style.display = "initial";
    let el = document.getElementById('btn-shows2');
    if( el.ariaExpanded == 'true'){
        document.getElementById('hide2').style.display = "initial";
        document.getElementById('shows2').style.display = "none";
    }else {
        document.getElementById('shows2').style.display = "initial";
        document.getElementById('hide2').style.display = "none";
    }
}
function Clickme3(){
    document.getElementById('shows').style.display = "none";
    document.getElementById('hide').style.display = "initial";
    document.getElementById('shows1').style.display = "none";
    document.getElementById('hide1').style.display = "initial";
    document.getElementById('shows2').style.display = "none";
    document.getElementById('hide2').style.display = "initial";
    document.getElementById('shows4').style.display = "none";
    document.getElementById('hide4').style.display = "initial";

    let el = document.getElementById('btn-shows3');
    if( el.ariaExpanded == 'true'){
        document.getElementById('hide3').style.display = "initial";
        document.getElementById('shows3').style.display = "none";
    }else {
        document.getElementById('shows3').style.display = "initial";
        document.getElementById('hide3').style.display = "none";
    }
}
function Clickme4(){
    document.getElementById('shows').style.display = "none";
    document.getElementById('hide').style.display = "initial";
    document.getElementById('shows1').style.display = "none";
    document.getElementById('hide1').style.display = "initial";
    document.getElementById('shows2').style.display = "none";
    document.getElementById('hide2').style.display = "initial";
    document.getElementById('shows3').style.display = "none";
    document.getElementById('hide3').style.display = "initial";
    let el = document.getElementById('btn-shows4');
    if( el.ariaExpanded == 'true'){
        document.getElementById('hide4').style.display = "initial";
        document.getElementById('shows4').style.display = "none";

    }else {
        document.getElementById('shows4').style.display = "initial";
        document.getElementById('hide4').style.display = "none";
    }
}





