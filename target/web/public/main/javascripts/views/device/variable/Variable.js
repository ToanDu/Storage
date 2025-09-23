/**
 * Created by vtk-anhlt166 on 6/4/21.
 */
$(document).ready(function () {
    localStorage.deviceId = deviceId;
    console.log(localStorage.deviceId);

    $("#totalVariable").text(lenghtListVar);
    if(lenghtListVar > 0){
        for(var i=0; i<lenghtListVar; i++){
            var number = i+1;
            var e = {
                series: [{
                    name: "Revenue",
                    data: [getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999), getRamdom(100,999)]
                }],
                chart: {
                    type: "area",
                    height: 45,
                    toolbar: {
                        show: !1
                    },
                    zoom: {
                        enabled: !1
                    },
                    dropShadow: {
                        enabled: !1,
                        top: 3,
                        left: 14,
                        blur: 4,
                        opacity: .12,
                        color: "#fff"
                    },
                    sparkline: {
                        enabled: !0
                    }
                },
                markers: {
                    size: 0,
                    colors: ["#fff"],
                    strokeColors: "#fff",
                    strokeWidth: 2,
                    hover: {
                        size: 7
                    }
                },
                dataLabels: {
                    enabled: !1
                },
                stroke: {
                    show: !0,
                    width: 2,
                    curve: "smooth"
                },
                fill: {
                    type: 'gradient',
                    gradient: {
                        shade: 'light',
                        type: "vertical",
                        shadeIntensity: 0.5,
                        gradientToColors: ["#fff"],
                        inverseColors: true,
                        opacityFrom: 0.2,
                        opacityTo: 0.5,
                        stops: [0, 50, 100],
                        colorStops: []
                    }
                },
                colors: ["#fff"],
                xaxis: {
                    categories: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
                },
                tooltip: {
                    theme: "dark",
                    fixed: {
                        enabled: !1
                    },
                    x: {
                        show: !1
                    },
                    y: {
                        title: {
                            formatter: function(e) {
                                return ""
                            }
                        }
                    },
                    marker: {
                        show: !1
                    }
                }
            };
            new ApexCharts(document.querySelector("#chart"+number), e).render();
        }
    }
});

function getRamdom(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}