/**
 * Created by vtk-anhlt166 on 4/14/23.
 */
$(document).ready(function () {
    if(localStorage.startTime != undefined && localStorage.startTime.length > 0){
        $("#date_timepicker_start").val(localStorage.startTime);
    }
    if(localStorage.endTime != undefined && localStorage.endTime.length > 0){
        $("#date_timepicker_end").val(localStorage.endTime);
    }

    if(localStorage.aggType != undefined && localStorage.aggType.length > 0){
        $("#aggType").val(localStorage.aggType);
    }

    if(localStorage.interval != undefined && localStorage.interval.length > 0){
        $("#interval").val(localStorage.interval);
    }

    $(".switcher-btn").on("click", function() {
        $(".switcher-wrapper").toggleClass("switcher-toggled")
    });
    $(".close-switcher").on("click", function() {
        $(".switcher-wrapper").removeClass("switcher-toggled")
    });
})

function applyConfigDashboard() {
    var dateStart = moment($("#date_timepicker_start").val(), "DD/MM/YYYY HH:mm");
    var dateObjectStart = dateStart.toDate();

    var dateEnd = moment($("#date_timepicker_end").val(), "DD/MM/YYYY HH:mm");
    var dateObjectEnd = dateEnd.toDate();

    if(dateObjectStart.getTime() >= dateObjectEnd.getTime()){
        showNotification('danger', Messages("Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc"));
        return;
    }

    localStorage.startTime = $("#date_timepicker_start").val();
    localStorage.endTime = $("#date_timepicker_end").val();
    localStorage.aggType = $("#aggType").val();
    localStorage.interval = $("#interval").val();
    localStorage.config = true;

    showNotification('success', Messages("Áp dụng thành công"));
}

function resetConfigDashboard() {
    localStorage.startTime = "";
    localStorage.endTime = "";
    localStorage.aggType = "";
    localStorage.interval = "";
    localStorage.config = false;

    showNotification('success', Messages("Reset thành công"));

}

function chooseAggType(el) {
    if(el.value == "NONE"){
        document.getElementById("tabInterval").style.display = "none";
    } else {
        document.getElementById("tabInterval").style.display = "block";
    }
}