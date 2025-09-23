function showAepList() {
    document.getElementById("choose-aep").style.display = 'flex';
    $("#title-aep").html(Messages("Dịch vụ mở rộng"));

    document.getElementById("device-aep").style.display = 'none';
    document.getElementById("gps-aep").style.display = 'none';
    document.getElementById("weather-aep").style.display = 'none';

}

var isEditorWeather = false;
var editorResponseWeather;
function showEditorWeather() {
    document.getElementById("choose-aep").style.display = 'none';
    $("#title-aep").html('<a onclick="showAepList()" style="cursor: pointer;">'+Messages("Dịch vụ mở rộng")+'</a>'+ '<small style="font-weight:400;">'+Messages(" > Thời tiết")+'</small>');

    document.getElementById("weather-aep").style.display = 'flex';

    if(!isEditorWeather){
        var editorRequestWeather = CodeMirror.fromTextArea(document.getElementById('editorRequestWeather'), {
            lineNumbers: true,
            mode: 'text/x-perl',
            theme: 'abbott'
        });
        editorResponseWeather = CodeMirror.fromTextArea(document.getElementById('editorResponseWeather'), {
            lineNumbers: true,
            mode: 'text/x-perl',
            theme: 'abbott'
        });
        isEditorWeather = true;
    }
}

var isEditorGps = false;
var editorResponseGps;
var editorRequestGps;
function showEditorGps() {
    document.getElementById("choose-aep").style.display = 'none';
    $("#title-aep").html('<a onclick="showAepList()" style="cursor: pointer;">'+Messages("Dịch vụ mở rộng")+'</a>'+ '<small style="font-weight:400;">'+Messages(" > Định vị")+'</small>');

    document.getElementById("gps-aep").style.display = 'flex';

    if(!isEditorGps){
        editorRequestGps = CodeMirror.fromTextArea(document.getElementById('editorRequestGps'), {
            lineNumbers: true,
            mode: 'text/x-perl',
            theme: 'abbott'
        });
        editorResponseGps = CodeMirror.fromTextArea(document.getElementById('editorResponseGps'), {
            lineNumbers: true,
            mode: 'text/x-perl',
            theme: 'abbott'
        });
        isEditorGps = true;
    }
}

var isTabDevice = false;
function showTabDevice() {
    document.getElementById("choose-aep").style.display = 'none';
    $("#title-aep").html('<a onclick="showAepList()" style="cursor: pointer;">'+Messages("Dịch vụ mở rộng")+'</a>'+ '<small style="font-weight:400;">'+Messages(" > Quản lý thiết bị")+'</small>');

    document.getElementById("device-aep").style.display = 'flex';

    if(!isTabDevice){
        isTabDevice = true;

        getListSubscriberCmp();
    }
}

function validateJson(json) {
    try {
        JSON.parse(json);
        return true;
    } catch (err) {
        return false;
    }
}

function choosePayType(el) {
    // console.log(el);
    if(el.value == 1){
        var sellect =
            '<option value="" selected>'+Messages("-- Chọn --")+'</option>'+
            '<option value="000">'+Messages("Bình thường")+'</option>'+
            '<option value="020">'+Messages("Chặn 2 chiều nợ cước")+'</option>'+
            '<option value="010">'+Messages("Chặn 1 chiều nợ cước")+'</option>'+
            '<option value="100">'+Messages("Chặn 1 chiều khách hàng yêu cầu")+'</option>'+
            '<option value="110">'+Messages("Chặn 1 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước")+'</option>'+
            '<option value="120">'+Messages("Chặn 1 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước")+'</option>'+
            '<option value="200">'+Messages("Chặn 2 chiều khách hàng yêu cầu")+'</option>'+
            '<option value="220">'+Messages("Chặn 2 chiều khách hàng yêu cầu, chặn 2 chiều nợ cước")+'</option>'+
            '<option value="210">'+Messages("Chặn 2 chiều khách hàng yêu cầu, chặn 1 chiều nợ cước")+'</option>';
        $("#actStatus").html(sellect);
    } else if(el.value == 2){
        var sellect =
            '<option value="" selected>'+Messages("-- Chọn --")+'</option>'+
            '<option value="000">'+Messages("Bình thường")+'</option>'+
            '<option value="020">'+Messages("Chặn 2 chiều do hệ thống")+'</option>'+
            '<option value="010">'+Messages("Chặn 1 chiều do hệ thống")+'</option>'+
            '<option value="030">'+Messages("Chưa kích hoạt")+'</option>'+
            '<option value="100">'+Messages("Chặn 1 chiều khách hàng yêu cầu")+'</option>'+
            '<option value="110">'+Messages("Chặn 1 chiều khách hàng yêu cầu, chặn 1 chiều do hệ thống")+'</option>'+
            '<option value="120">'+Messages("Chặn 1 chiều khách hàng yêu cầu, chặn 2 chiều do hệ thống")+'</option>'+
            '<option value="200">'+Messages("Chặn 2 chiều khách hàng yêu cầu")+'</option>'+
            '<option value="220">'+Messages("Chặn 2 chiều khách hàng yêu cầu, chặn 2 chiều do hệ thống")+'</option>'+
            '<option value="210">'+Messages("Chặn 2 chiều khách hàng yêu cầu, chặn 1 chiều do hệ thống")+'</option>';
        $("#actStatus").html(sellect);
    } else {
        $("#actStatus").html('<option value="" selected>'+Messages("-- Hãy chọn loại dịch vụ --")+'</option>');
    }
}