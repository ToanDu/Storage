$(document).ready(function () {
    setInterval(function () {
        $("#chart1").html("");
        renderChart1([getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999)]);

        $("#chart2").html("");
        renderChart2([getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999)]);

        $("#chart3").html("");
        renderChart3([getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999)]);

        // $("#chart4").html("");
        // renderChart4([getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999)]);

        $("#chart5").html("");
        renderChart5([getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999)]);

        var lastDate = moment.unix(Date.now()/1000).format("HH:mm");
        $("#lastDateTracking").text(lastDate);
    },10000)
});

function getRamdom(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}