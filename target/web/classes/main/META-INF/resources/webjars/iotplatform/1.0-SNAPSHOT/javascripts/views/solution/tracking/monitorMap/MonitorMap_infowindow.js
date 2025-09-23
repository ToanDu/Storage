/**
 * Created by vtk-anhlt166 on 9/20/21.
 */
var isAnalysisPostion = true;
var assetsFlagPath='/assets/img/flags/';
var assetsDefaultAvatar='/assets/images/favicon.png';
var COUNTRIES = [["AF", "AFG", 4, "Afghanistan"], ["AX", "ALA", 248, "Åland Islands"], ["AL", "ALB", 8, "Albania"], ["DZ", "DZA", 12, "Algeria"], ["AS", "ASM", 16, "American Samoa"], ["AD", "AND", 20, "Andorra"], ["AO", "AGO", 24, "Angola"], ["AI", "AIA", 660, "Anguilla"], ["AQ", "ATA", 10, "Antarctica"], ["AG", "ATG", 28, "Antigua and Barbuda"], ["AR", "ARG", 32, "Argentina"], ["AM", "ARM", 51, "Armenia"], ["AW", "ABW", 533, "Aruba"], ["AU", "AUS", 36, "Australia"], ["AT", "AUT", 40, "Austria"], ["AZ", "AZE", 31, "Azerbaijan"], ["BS", "BHS", 44, "Bahamas"], ["BH", "BHR", 48, "Bahrain"], ["BD", "BGD", 50, "Bangladesh"], ["BB", "BRB", 52, "Barbados"], ["BY", "BLR", 112, "Belarus"], ["BE", "BEL", 56, "Belgium"], ["BZ", "BLZ", 84, "Belize"], ["BJ", "BEN", 204, "Benin"], ["BM", "BMU", 60, "Bermuda"], ["BT", "BTN", 64, "Bhutan"], ["BO", "BOL", 68, "Bolivia (Plurinational State of)"], ["BQ", "BES", 535, "Bonaire, Sint Eustatius and Saba"], ["BA", "BIH", 70, "Bosnia and Herzegovina"], ["BW", "BWA", 72, "Botswana"], ["BV", "BVT", 74, "Bouvet Island"], ["BR", "BRA", 76, "Brazil"], ["IO", "IOT", 86, "British Indian Ocean Territory"], ["BN", "BRN", 96, "Brunei Darussalam"], ["BG", "BGR", 100, "Bulgaria"], ["BF", "BFA", 854, "Burkina Faso"], ["BI", "BDI", 108, "Burundi"], ["KH", "KHM", 116, "Cambodia"], ["CM", "CMR", 120, "Cameroon"], ["CA", "CAN", 124, "Canada"], ["CV", "CPV", 132, "Cabo Verde"], ["KY", "CYM", 136, "Cayman Islands"], ["CF", "CAF", 140, "Central African Republic"], ["TD", "TCD", 148, "Chad"], ["CL", "CHL", 152, "Chile"], ["CN", "CHN", 156, "China"], ["CX", "CXR", 162, "Christmas Island"], ["CC", "CCK", 166, "Cocos (Keeling) Islands"], ["CO", "COL", 170, "Colombia"], ["KM", "COM", 174, "Comoros"], ["CG", "COG", 178, "Congo"], ["CD", "COD", 180, "Congo (Democratic Republic of the)"], ["CK", "COK", 184, "Cook Islands"], ["CR", "CRI", 188, "Costa Rica"], ["CI", "CIV", 384, "Côte d'Ivoire"], ["HR", "HRV", 191, "Croatia"], ["CU", "CUB", 192, "Cuba"], ["CW", "CUW", 531, "Curaçao"], ["CY", "CYP", 196, "Cyprus"], ["CZ", "CZE", 203, "Czech Republic"], ["DK", "DNK", 208, "Denmark"], ["DJ", "DJI", 262, "Djibouti"], ["DM", "DMA", 212, "Dominica"], ["DO", "DOM", 214, "Dominican Republic"], ["EC", "ECU", 218, "Ecuador"], ["EG", "EGY", 818, "Egypt"], ["SV", "SLV", 222, "El Salvador"], ["GQ", "GNQ", 226, "Equatorial Guinea"], ["ER", "ERI", 232, "Eritrea"], ["EE", "EST", 233, "Estonia"], ["ET", "ETH", 231, "Ethiopia"], ["FK", "FLK", 238, "Falkland Islands (Malvinas)"], ["FO", "FRO", 234, "Faroe Islands"], ["FJ", "FJI", 242, "Fiji"], ["FI", "FIN", 246, "Finland"], ["FR", "FRA", 250, "France"], ["GF", "GUF", 254, "French Guiana"], ["PF", "PYF", 258, "French Polynesia"], ["TF", "ATF", 260, "French Southern Territories"], ["GA", "GAB", 266, "Gabon"], ["GM", "GMB", 270, "Gambia"], ["GE", "GEO", 268, "Georgia"], ["DE", "DEU", 276, "Germany"], ["GH", "GHA", 288, "Ghana"], ["GI", "GIB", 292, "Gibraltar"], ["GR", "GRC", 300, "Greece"], ["GL", "GRL", 304, "Greenland"], ["GD", "GRD", 308, "Grenada"], ["GP", "GLP", 312, "Guadeloupe"], ["GU", "GUM", 316, "Guam"], ["GT", "GTM", 320, "Guatemala"], ["GG", "GGY", 831, "Guernsey"], ["GN", "GIN", 324, "Guinea"], ["GW", "GNB", 624, "Guinea-Bissau"], ["GY", "GUY", 328, "Guyana"], ["HT", "HTI", 332, "Haiti"], ["HM", "HMD", 334, "Heard Island and McDonald Islands"], ["VA", "VAT", 336, "Holy See"], ["HN", "HND", 340, "Honduras"], ["HK", "HKG", 344, "Hong Kong"], ["HU", "HUN", 348, "Hungary"], ["IS", "ISL", 352, "Iceland"], ["IN", "IND", 356, "India"], ["ID", "IDN", 360, "Indonesia"], ["IR", "IRN", 364, "Iran (Islamic Republic of)"], ["IQ", "IRQ", 368, "Iraq"], ["IE", "IRL", 372, "Ireland"], ["IM", "IMN", 833, "Isle of Man"], ["IL", "ISR", 376, "Israel"], ["IT", "ITA", 380, "Italy"], ["JM", "JAM", 388, "Jamaica"], ["JP", "JPN", 392, "Japan"], ["JE", "JEY", 832, "Jersey"], ["JO", "JOR", 400, "Jordan"], ["KZ", "KAZ", 398, "Kazakhstan"], ["KE", "KEN", 404, "Kenya"], ["KI", "KIR", 296, "Kiribati"], ["KP", "PRK", 408, "Korea (Democratic People's Republic of)"], ["KR", "KOR", 410, "Korea (Republic of)"], ["KW", "KWT", 414, "Kuwait"], ["KG", "KGZ", 417, "Kyrgyzstan"], ["LA", "LAO", 418, "Lao People's Democratic Republic"], ["LV", "LVA", 428, "Latvia"], ["LB", "LBN", 422, "Lebanon"], ["LS", "LSO", 426, "Lesotho"], ["LR", "LBR", 430, "Liberia"], ["LY", "LBY", 434, "Libya"], ["LI", "LIE", 438, "Liechtenstein"], ["LT", "LTU", 440, "Lithuania"], ["LU", "LUX", 442, "Luxembourg"], ["MO", "MAC", 446, "Macao"], ["MK", "MKD", 807, "Macedonia (the former Yugoslav Republic of)"], ["MG", "MDG", 450, "Madagascar"], ["MW", "MWI", 454, "Malawi"], ["MY", "MYS", 458, "Malaysia"], ["MV", "MDV", 462, "Maldives"], ["ML", "MLI", 466, "Mali"], ["MT", "MLT", 470, "Malta"], ["MH", "MHL", 584, "Marshall Islands"], ["MQ", "MTQ", 474, "Martinique"], ["MR", "MRT", 478, "Mauritania"], ["MU", "MUS", 480, "Mauritius"], ["YT", "MYT", 175, "Mayotte"], ["MX", "MEX", 484, "Mexico"], ["FM", "FSM", 583, "Micronesia (Federated States of)"], ["MD", "MDA", 498, "Moldova (Republic of)"], ["MC", "MCO", 492, "Monaco"], ["MN", "MNG", 496, "Mongolia"], ["ME", "MNE", 499, "Montenegro"], ["MS", "MSR", 500, "Montserrat"], ["MA", "MAR", 504, "Morocco"], ["MZ", "MOZ", 508, "Mozambique"], ["MM", "MMR", 104, "Myanmar"], ["NA", "NAM", 516, "Namibia"], ["NR", "NRU", 520, "Nauru"], ["NP", "NPL", 524, "Nepal"], ["NL", "NLD", 528, "Netherlands"], ["NC", "NCL", 540, "New Caledonia"], ["NZ", "NZL", 554, "New Zealand"], ["NI", "NIC", 558, "Nicaragua"], ["NE", "NER", 562, "Niger"], ["NG", "NGA", 566, "Nigeria"], ["NU", "NIU", 570, "Niue"], ["NF", "NFK", 574, "Norfolk Island"], ["MP", "MNP", 580, "Northern Mariana Islands"], ["NO", "NOR", 578, "Norway"], ["OM", "OMN", 512, "Oman"], ["PK", "PAK", 586, "Pakistan"], ["PW", "PLW", 585, "Palau"], ["PS", "PSE", 275, "Palestine, State of"], ["PA", "PAN", 591, "Panama"], ["PG", "PNG", 598, "Papua New Guinea"], ["PY", "PRY", 600, "Paraguay"], ["PE", "PER", 604, "Peru"], ["PH", "PHL", 608, "Philippines"], ["PN", "PCN", 612, "Pitcairn"], ["PL", "POL", 616, "Poland"], ["PT", "PRT", 620, "Portugal"], ["PR", "PRI", 630, "Puerto Rico"], ["QA", "QAT", 634, "Qatar"], ["RE", "REU", 638, "Réunion"], ["RO", "ROU", 642, "Romania"], ["RU", "RUS", 643, "Russian Federation"], ["RW", "RWA", 646, "Rwanda"], ["BL", "BLM", 652, "Saint Barthélemy"], ["SH", "SHN", 654, "Saint Helena, Ascension and Tristan da Cunha"], ["KN", "KNA", 659, "Saint Kitts and Nevis"], ["LC", "LCA", 662, "Saint Lucia"], ["MF", "MAF", 663, "Saint Martin (French part)"], ["PM", "SPM", 666, "Saint Pierre and Miquelon"], ["VC", "VCT", 670, "Saint Vincent and the Grenadines"], ["WS", "WSM", 882, "Samoa"], ["SM", "SMR", 674, "San Marino"], ["ST", "STP", 678, "Sao Tome and Principe"], ["SA", "SAU", 682, "Saudi Arabia"], ["SN", "SEN", 686, "Senegal"], ["RS", "SRB", 688, "Serbia"], ["SC", "SYC", 690, "Seychelles"], ["SL", "SLE", 694, "Sierra Leone"], ["SG", "SGP", 702, "Singapore"], ["SX", "SXM", 534, "Sint Maarten (Dutch part)"], ["SK", "SVK", 703, "Slovakia"], ["SI", "SVN", 705, "Slovenia"], ["SB", "SLB", 90, "Solomon Islands"], ["SO", "SOM", 706, "Somalia"], ["ZA", "ZAF", 710, "South Africa"], ["GS", "SGS", 239, "South Georgia and the South Sandwich Islands"], ["SS", "SSD", 728, "South Sudan"], ["ES", "ESP", 724, "Spain"], ["LK", "LKA", 144, "Sri Lanka"], ["SD", "SDN", 729, "Sudan"], ["SR", "SUR", 740, "Suriname"], ["SJ", "SJM", 744, "Svalbard and Jan Mayen"], ["SZ", "SWZ", 748, "Swaziland"], ["SE", "SWE", 752, "Sweden"], ["CH", "CHE", 756, "Switzerland"], ["SY", "SYR", 760, "Syrian Arab Republic"], ["TW", "TWN", 158, "Taiwan, Province of China"], ["TJ", "TJK", 762, "Tajikistan"], ["TZ", "TZA", 834, "Tanzania, United Republic of"], ["TH", "THA", 764, "Thailand"], ["TL", "TLS", 626, "Timor-Leste"], ["TG", "TGO", 768, "Togo"], ["TK", "TKL", 772, "Tokelau"], ["TO", "TON", 776, "Tonga"], ["TT", "TTO", 780, "Trinidad and Tobago"], ["TN", "TUN", 788, "Tunisia"], ["TR", "TUR", 792, "Turkey"], ["TM", "TKM", 795, "Turkmenistan"], ["TC", "TCA", 796, "Turks and Caicos Islands"], ["TV", "TUV", 798, "Tuvalu"], ["UG", "UGA", 800, "Uganda"], ["UA", "UKR", 804, "Ukraine"], ["AE", "ARE", 784, "United Arab Emirates"], ["GB", "GBR", 826, "United Kingdom of Great Britain and Northern Ireland"], ["US", "USA", 840, "United States of America"], ["UM", "UMI", 581, "United States Minor Outlying Islands"], ["UY", "URY", 858, "Uruguay"], ["UZ", "UZB", 860, "Uzbekistan"], ["VU", "VUT", 548, "Vanuatu"], ["VE", "VEN", 862, "Venezuela (Bolivarian Republic of)"], ["VN", "VNM", 704, "Viet Nam"], ["VG", "VGB", 92, "Virgin Islands (British)"], ["VI", "VIR", 850, "Virgin Islands (U.S.)"], ["WF", "WLF", 876, "Wallis and Futuna"], ["EH", "ESH", 732, "Western Sahara"], ["YE", "YEM", 887, "Yemen"], ["ZM", "ZMB", 894, "Zambia"], ["ZW", "ZWE", 716, "Zimbabwe"]];


function showInfoWindow(data, isClickMarker) {
    //console.log("showInfoWindow: ", data);
    if (isClickMarker && data != undefined) {
        if (!$("#pos_map_info").is(":visible")) {
            $("#pos_map_info").css({display: "inline-block", visibility: "visible"});
        }
        if (isAnalysisPostion == true) {
            isAnalysisPostion = false;
            var _docHeight = (document.height !== undefined) ? document.height : document.body.offsetHeight;
            var _docWidth = (document.width !== undefined) ? document.width : document.body.offsetWidth;
            // console.log("document: ", _docHeight, _docWidth);
            $("#pos_map_info").css({top: _docHeight / 6 + 10, left: _docWidth / 2 + 30});

        }

        // set data view
        fillData(data);

        //show
        $("#pos_map_info").show();

        var uagent = navigator.userAgent.toLowerCase();
        if (navigator.userAgent.match(/Android/i)
            || navigator.userAgent.match(/webOS/i)
            || navigator.userAgent.match(/iPhone/i)
            || navigator.userAgent.match(/BlackBerry/i)
            || navigator.userAgent.match(/Windows Phone/i)){
            // console.log("mobile");
            $('#pos_map_info').animate({"left":"0.5%"},'fast');
            $('#pos_map_info').animate({"top":80},'fast');
            $('#pos_map_info').attr("trigger","1");
            // $('#menu-toggle').click();
        } else if (navigator.userAgent.match(/iPad/i)
            || navigator.userAgent.match(/Tablet/i)
            || navigator.userAgent.match(/iPod/i)){
            // console.log("tablet");
            $('#pos_map_info').animate({"left":"25%"},'fast');
            $('#pos_map_info').attr("trigger","1");
        } else {
            // console.log("web");
        }
    } else {
        $("#pos_map_info").hide();
    }
}

function closeInfoWindow() {
    if (!$("#pos_map_info").is(":visible")) {
        $("#pos_map_info").css({display: "block", visibility: "visible"});
    }
    // $("#pos_map_info").hide("slow");
    $("#pos_map_info").hide();
}

function fillData(device) {
    console.log(device);

    $("#infowindow-devider0").html("");
    $("#infowindow-devider1").html("");
    $("#info_name").html(device.id);
    var name = '<span class="infowindow-mtitle" style="margin-top: 5px">'+Messages("map.info.name")+'</span>'+
        '<br>'+
        '<span class="infowindow-mdesc" id="mInfo_name">'+device.name+'</span>'+
        '<br>';
    $("#infowindow-devider0").append(name);


    console.log(device.attributes);

    if(device.attributes != null && device.attributes.length > 0){
        device.attributes.forEach(function (item, index) {
            // console.log(item, index);
            if(item.attribute_key == "location"){
                var location = item.value;
                console.log(location);

                var status = '<span class="infowindow-mtitle" style="margin-top: 5px">'+Messages("map.info.dateTracking")+'</span>'+
                    '<br>'+
                    '<span class="infowindow-mdesc" id="mInfo_last_update_ts">'+moment.unix(item.last_update_ts/1000).format("DD/MM/YYYY HH:mm")+'</span>'+
                    '<br>';
                $("#infowindow-devider1").append(status);

                var lat = convertDmsLat(location.lat);
                var attrLat = '<span class="infowindow-mtitle" style="margin-top: 2px">'+Messages("map.info.latitude")+'</span>'+
                    '<br>'+
                    '<span class="infowindow-mdesc" id="mInfo_lat">'+lat+'</span>'+
                    '<br>';
                $("#infowindow-devider0").append(attrLat);

                var lon = convertDmsLon(location.lon);
                var attrLon = '<span class="infowindow-mtitle" style="margin-top: 2px">'+Messages("map.info.longitude")+'</span>'+
                    '<br>'+
                    '<span class="infowindow-mdesc" id="mInfo_lon">'+lon+'</span>'+
                    '<br>';
                $("#infowindow-devider1").append(attrLon);

                var i=0;
                for (key in location) {
                    if (location.hasOwnProperty(key)) {
                        // console.log(key + " = " + location[key]);
                        if(key != "lat" && key != "lon"){
                            if(location[key] != "" && location[key] != undefined && location[key] != null){
                                var attr = '<span class="infowindow-mtitle" style="margin-top: 2px">'+key+'</span>'+
                                    '<br>'+
                                    '<span class="infowindow-mdesc infwin-key" id="mInfo_'+key+'" title="'+location[key]+'">'+location[key]+'</span>'+
                                    '<br>';
                                $("#infowindow-devider"+ (i%2)).append(attr);
                                i++;
                            }
                        }
                    }
                }
            }
        })
    }
}

function getStatusString(statusVehicle, timestamp_unix, speedVehicle,alarmType) {
    // console.log(alarmType);
    if(alarmType == 5){
        document.getElementById("sendCancelAlarm").style.display = "";
    } else {
        document.getElementById("sendCancelAlarm").style.display = "none";
    }
    if(statusVehicle == STATUS_VEHICLE.ALARM.value){
        if(alarmType == 3 || alarmType == 10){
            document.getElementById("saveStatus").style.display = "";
        } else {
            document.getElementById("saveStatus").style.display = "none";
        }
    }
    //   console.log(statusVehicle, timestamp_unix, speedVehicle);
    var result = "";
    var localize = $('.spanLocallize').attr('id');

    if (statusVehicle == STATUS_VEHICLE.RUNNING.value) {
        if(localize == "flag-description-GB"){
            result = Messages("Run") + " " + speedVehicle + " Knots";
        } else if(localize == "flag-description-VN"){
            result = Messages("Chạy") + " " + speedVehicle + " Knots";
        }

    } else if (statusVehicle == STATUS_VEHICLE.ALARM.value) {
        // console.log("getStatusString");
        // console.log(alarmType);

        result =  getAlarmStringByStatus(alarmType);

    }
    else {
        var kq = analysicDate(timestamp_unix);

        if(localize == "flag-description-GB"){
            if (statusVehicle == STATUS_VEHICLE.PARKING.value) {
                result = Messages("Park") + " " + kq;
            } else if (statusVehicle == STATUS_VEHICLE.GPS_LOST.value) {
                result = Messages("GPS Lost") + " " + kq;
            } else if (statusVehicle == STATUS_VEHICLE.SIGNAL_LOST.value) {
                result = Messages("Disconnect") + " " + kq;
            }
        } else if(localize == "flag-description-VN"){
            if (statusVehicle == STATUS_VEHICLE.PARKING.value) {
                result = Messages("Đậu") + " " + kq;
            } else if (statusVehicle == STATUS_VEHICLE.GPS_LOST.value) {
                result = Messages("Mất GPS") + " " + kq;
            } else if (statusVehicle == STATUS_VEHICLE.SIGNAL_LOST.value) {
                result = Messages("Mất kết nối") + " " + kq;
            }
        }

    }
    return result;
}

function analysicDate(timestamp_unix) {
    var newDate = new Date();
    var msRemainder = Date.parse(newDate) - timestamp_unix;
    var days = Math.floor(msRemainder / 86400000, 0);
    msRemainder = msRemainder - (days * 86400000);
    var hours = Math.floor(msRemainder / 3600000, 0);
    msRemainder = msRemainder - (hours * 3600000);
    var minutes = Math.floor(msRemainder / 60000, 0);
    msRemainder = msRemainder - (minutes * 60000);
    var seconds = Math.floor(msRemainder / 1000, 0);
    msRemainder = msRemainder - (seconds * 1000);
    var milliseconds = msRemainder;
    var kq = "";
    if (days > 0) {
        kq = days + "d     ";
    }
    if (days > 0 || hours > 0) {
        kq += hours + "h ";
    }
    if (days > 0 || hours > 0 || minutes > 0) {
        kq += minutes + "' ";
    }
    kq += seconds + "''";
    return kq;

}

$(function () {
    $("#pos_map_info").draggable();
    // $("#sidebar-wrapper-2").draggable();

    var draggableDiv = $('#pos_map_info').draggable();
    $('.infowindow-inner2', draggableDiv).mousedown(function(ev) {
        draggableDiv.draggable('disable');
    }).mouseup(function(ev) {
        draggableDiv.draggable('enable');
    });
});

function pressVolumnUp() {
    $('#toggle-volumn i').removeClass("fa-volume-off");
    $('#toggle-volumn i').addClass("fa-volume-up");
    playAudio();
}
function pressVolumnMute() {
    $('#toggle-volumn i').removeClass("fa-volume-up");
    $('#toggle-volumn i').addClass("fa-volume-off");
    pauseAudio();
}
function toggleVolumn() {

    if($('#toggle-volumn i').hasClass("fa-volume-off")){
        $('#toggle-volumn i').removeClass("fa-volume-off");
        $('#toggle-volumn i').addClass("fa-volume-up");
        // playAudio();
    }else {
        $('#toggle-volumn i').removeClass("fa-volume-up");
        $('#toggle-volumn i').addClass("fa-volume-off");
        pauseAudio();
    }

}
function playAudio() {
    var x = document.getElementById("sosSound");
    x.play();
}

function pauseAudio() {
    var x = document.getElementById("sosSound");
    x.pause();
}