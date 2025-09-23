function change_module_action(el, stt) {
    $("#titleProduct").text(el);

    if(stt == 1){
        document.getElementById("moduleWifi").style.display = 'block';
        document.getElementById("moduleBluetooth").style.display = 'none';
        document.getElementById("moduleWifiBluetooth").style.display = 'none';
        document.getElementById("moduleNbIot").style.display = 'none';
        document.getElementById("moduleZigbee").style.display = 'none';
        document.getElementById("module2G").style.display = 'none';
    } else if(stt == 2){
        document.getElementById("moduleWifi").style.display = 'none';
        document.getElementById("moduleBluetooth").style.display = 'block';
        document.getElementById("moduleWifiBluetooth").style.display = 'none';
        document.getElementById("moduleNbIot").style.display = 'none';
        document.getElementById("moduleZigbee").style.display = 'none';
        document.getElementById("module2G").style.display = 'none';
    }  else if(stt == 3){
        document.getElementById("moduleWifi").style.display = 'none';
        document.getElementById("moduleBluetooth").style.display = 'none';
        document.getElementById("moduleWifiBluetooth").style.display = 'block';
        document.getElementById("moduleNbIot").style.display = 'none';
        document.getElementById("moduleZigbee").style.display = 'none';
        document.getElementById("module2G").style.display = 'none';
    } else if(stt == 4){
        document.getElementById("moduleWifi").style.display = 'none';
        document.getElementById("moduleBluetooth").style.display = 'none';
        document.getElementById("moduleWifiBluetooth").style.display = 'none';
        document.getElementById("moduleNbIot").style.display = 'block';
        document.getElementById("moduleZigbee").style.display = 'none';
        document.getElementById("module2G").style.display = 'none';
    } else if(stt == 5){
        document.getElementById("moduleWifi").style.display = 'none';
        document.getElementById("moduleBluetooth").style.display = 'none';
        document.getElementById("moduleWifiBluetooth").style.display = 'none';
        document.getElementById("moduleNbIot").style.display = 'none';
        document.getElementById("moduleZigbee").style.display = 'block';
        document.getElementById("module2G").style.display = 'none';
    } else if(stt == 6){
        document.getElementById("moduleWifi").style.display = 'none';
        document.getElementById("moduleBluetooth").style.display = 'none';
        document.getElementById("moduleWifiBluetooth").style.display = 'none';
        document.getElementById("moduleNbIot").style.display = 'none';
        document.getElementById("moduleZigbee").style.display = 'none';
        document.getElementById("module2G").style.display = 'block';
    } else {
        document.getElementById("moduleWifi").style.display = 'block';
        document.getElementById("moduleBluetooth").style.display = 'block';
        document.getElementById("moduleWifiBluetooth").style.display = 'block';
        document.getElementById("moduleNbIot").style.display = 'block';
        document.getElementById("moduleZigbee").style.display = 'block';
        document.getElementById("module2G").style.display = 'block';
    }
}
