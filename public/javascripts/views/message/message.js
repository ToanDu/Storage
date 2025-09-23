function processSendMessageToDevice() {
    var Data = new FormData();
    Data.content = $('#messageToDevice').val();
    Data.deviceId = deviceId;

    if(document.getElementById('dataCheck').checked){
        Data.type = "data";
    } else if(document.getElementById('eventsCheck').checked){
        Data.type = "events";
    } else if(document.getElementById('appControlsCheck').checked){
        Data.type = "app/controls";
    } else if(document.getElementById('deviceControlsCheck').checked){
        Data.type = "device/controls";
    } else {
        showNotification('danger',Messages("message.chooseTypeMessage"));
        return;
    }

    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.MessagesDeviceController.sendMessageToDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                showNotification('success',data.resultString);
                $('#messageToDevice').val("");

                if(paramMessage.length > 0){
                    getMessageDevice();
                }

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
        }
    });
}

function getMessageDevice() {
    var Data = new FormData();
    Data.deviceId = deviceId;
    Data.param = paramMessage;

    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.MessagesDeviceController.getMessageFormDevice();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(Data),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            $("#listMessageOfDevice").html("");
            if(data.success && data.content != null){
                //show table message of device
                if(data.content.length > 0){

                    var table = document.createElement("table");
                    table.setAttribute("class", "table table-striped table-bordered");
                    table.setAttribute("id", "dataTables");
                    table.setAttribute("style","width: 100%");

                    document.body.appendChild(table);

                    var tablethread=document.createElement("thead");
                    tablethread.setAttribute("class","cf");

                    var tablethreadtr=document.createElement("tr");

                    var th0=document.createElement("th");
                    var t0 = document.createTextNode("STT");
                    th0.appendChild(t0);
                    tablethreadtr.appendChild(th0);

                    var th1=document.createElement("th");
                    var t1 = document.createTextNode("Payload");
                    th1.appendChild(t1);
                    tablethreadtr.appendChild(th1);

                    var th2=document.createElement("th");
                    var t2 = document.createTextNode("Subtopic");
                    th2.appendChild(t2);
                    tablethreadtr.appendChild(th2);

                    var th3=document.createElement("th");
                    var t3 = document.createTextNode("CreatedTime");
                    th3.appendChild(t3);
                    tablethreadtr.appendChild(th3);

                    tablethread.appendChild(tablethreadtr);

                    table.appendChild(tablethread);

                    var tablebody=document.createElement("tbody");
                    for(var i=0; i<data.content.length; i++){
                        var tabletr=document.createElement("tr");

                        var td0=document.createElement("td");
                        var text0 = document.createTextNode(i+1);
                        td0.appendChild(text0);
                        tabletr.appendChild(td0);

                        var td1=document.createElement("td");
                        var text1 = document.createTextNode(data.content[i].payload);
                        td1.appendChild(text1);
                        tabletr.appendChild(td1);

                        var td2=document.createElement("td");
                        var text2 = document.createTextNode(data.content[i].subtopic);
                        td2.appendChild(text2);
                        tabletr.appendChild(td2);

                        var curdate = new Date();
                        curdate.setTime(data.content[i].createdtime/1000000000);
                        console.log(curdate);
                        var logDate = moment.unix(curdate).format("DD/MM/YYYY HH:mm");

                        var td3=document.createElement("td");
                        var text3 = document.createTextNode(logDate);
                        td3.appendChild(text3);
                        tabletr.appendChild(td3);

                        tablebody.appendChild(tabletr);
                    }
                    table.appendChild(tablebody);

                    $("#listMessageOfDevice").html(table);

                    setTimeout(function () {
                        var tableOption = $('#dataTables').DataTable( {
                            responsive: true,
                            lengthChange: false,
                            // buttons: [ 'excel', 'pdf', 'print']
                        } );
                        tableOption.buttons().container()
                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
                    },500);
                } else {
                    showNotification('danger', Messages("tableNoData"));
                }

            }else{
                $("#listMessageOfDevice").html("");
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function checkCheckBoxShowData() {
    if(document.getElementById('invalidCheckData').checked){
        if(document.getElementById('invalidCheckEvents').checked){
            if(document.getElementById('invalidCheckAppControls').checked){
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "data,events,app/controls,device/controls";
                } else {
                    paramMessage = "data,events,app/controls";
                }
            } else {
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "data,events,device/controls";
                } else {
                    paramMessage = "data,events";
                }
            }
        } else {
            if(document.getElementById('invalidCheckAppControls').checked){
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "data,app/controls,device/controls";
                } else {
                    paramMessage = "data,app/controls";
                }
            } else {
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "data,device/controls";
                } else {
                    paramMessage = "data";
                }
            }
        }
    } else {
        if(document.getElementById('invalidCheckEvents').checked){
            if(document.getElementById('invalidCheckAppControls').checked){
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "events,app/controls,device/controls";
                } else {
                    paramMessage = "events,app/controls";
                }
            } else {
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "events,device/controls";
                } else {
                    paramMessage = "events";
                }
            }
        } else {
            if(document.getElementById('invalidCheckAppControls').checked){
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "app/controls,device/controls";
                } else {
                    paramMessage = "app/controls";
                }
            } else {
                if(document.getElementById('invalidCheckDeviceControls').checked){
                    paramMessage = "device/controls";
                } else {
                    paramMessage = "";
                    console.log("ban chua chon gi!");

                    $("#listMessageOfDevice").html("");
                    return;
                }
            }
        }
    }

    console.log(paramMessage);
    getMessageDevice();
}