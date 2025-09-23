function validateEmail(input) {
    console.log(input);
    var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (input.match(validRegex)) {
        return true;
    } else {
        return false;
    }
}

function validateTimeCurrent(id) {
    var input = document.getElementById(id);
    if(input != null && input != undefined){
        var dateString = $("#"+id).val();
        var dateParts = dateString.split("/");
        var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
        var dateNow = new Date();
        if(dateObject.getTime() > dateNow.getTime()){
            return false;
        } else {
            return true;
        }
    }

    return true;
}

function validateText(id) {
    if($("#"+id).val() != null && $("#"+id).val() != undefined){
        var string = $("#"+id).val().trim();
        if(string.length == 0){
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
}

function isNumberKey(e) {
    var charCode = (e.which) ? e.which : e.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    } else {
        return true;
    }
}

function validatePhoneVn(inputtxt) {
    var phone = /(84|0)+([0-9]{9})\b/;
    if(phone.test(inputtxt)) {
        return true;
    } else {
        return false;
    }
}

function validateTextEmpty(text) {
    // console.log(text);
    if(text == null || text.length == 0){
        return false;
    } else {
        return true;
    }
}

function validateDateCurrent(dateString) {
    var dateParts = dateString.split("/");
    var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
    var dateNow = new Date();
    if(dateObject.getTime() > dateNow.getTime()){
        return false;
    } else {
        return true;
    }
}