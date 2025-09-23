/**
 * Created by vtk-anhlt166 on 6/21/21.
 */
function getLogDeviceById(id) {
    console.log(id);
    $("#deviceIdCurent").text(id);

    var Data = new FormData();
    Data.deviceId = id;
    console.log(Data);

    StartProcess();
    var r = jsRoutes.controllers.LogDeviceController.getAllLogMessage();
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
                            lengthChange: false,
                            // buttons: [ 'excel', 'pdf', 'print']
                        } );
                        tableOption.buttons().container()
                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
                    },500);
                } else {
                    $("#listMessageOfDevice").html("");
                    showNotification('danger', Messages("noti.notFoundData"));
                }

            }else{
                $("#listMessageOfDevice").html("");
                showNotification('danger', Messages("noti.notFoundData"));
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