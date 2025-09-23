/**
 * Created by vtk-anhlt166 on 7/8/21.
 */
function exportQrCodeList() {
    StartProcess();
    var r = jsRoutes.controllers.QrCodeController.getListQrCode();
    $.ajax({
        type: r.type,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data != null && data.length > 0){
                exportZipImg(data);
                // outExcel("Export_QR_Code_list");
            } else {
                showNotification('danger', Messages("noti.notFoundData"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess();
        }
    });
}

function createtable(data){

    var table = document.createElement("table");
    table.setAttribute("class", "table table-striped table-bordered");
    table.setAttribute("id", "myTableExcel");

    document.body.appendChild(table);

    var tablethread=document.createElement("thead");

    var tablethreadtr=document.createElement("tr");

    var th0=document.createElement("th");
    var t0 = document.createTextNode(Messages("STT"));
    th0.appendChild(t0);
    tablethreadtr.appendChild(th0);

    var th1=document.createElement("th");
    var t1 = document.createTextNode(Messages("ID"));
    th1.appendChild(t1);
    tablethreadtr.appendChild(th1);

    var th2=document.createElement("th");
    var t2 = document.createTextNode(Messages("QR Code"));
    th2.appendChild(t2);
    tablethreadtr.appendChild(th2);

    var th3=document.createElement("th");
    var t3 = document.createTextNode(Messages("Log Date"));
    th3.appendChild(t3);
    tablethreadtr.appendChild(th3);

    tablethread.appendChild(tablethreadtr);
    table.appendChild(tablethread);

    var tablebody=document.createElement("tbody");

    for (var i=0; i<data.length;i++) {
        var tabletr=document.createElement("tr");

        var td0=document.createElement("td");
        var text0 = document.createTextNode(i+1);
        td0.appendChild(text0);
        tabletr.appendChild(td0);

        var td1=document.createElement("td");
        var text1 = document.createTextNode(data[i].id);
        td1.appendChild(text1);
        tabletr.appendChild(td1);

        var td2=document.createElement("td");
        var text2 = document.createElement("img");
        text2.src = data[i].src;
        td2.appendChild(text2);
        tabletr.appendChild(td2);

        var curdate3 = new Date();
        curdate3.setTime(data[i].logDate);
        var lastUpdated3 = (data[i].logDate != null) ? moment.unix(curdate3/1000).format("HH:mm - DD/MM/YYYY") : "";
        var td3=document.createElement("td");
        var text3 = document.createTextNode(lastUpdated3);
        td3.appendChild(text3);
        tabletr.appendChild(td3);

        tablebody.appendChild(tabletr);
    }

    table.appendChild(tablebody);
}

function outExcel(name){
    // var tableex=  $('#myTableExcel');
    // var table2excel = new Table2Excel({defaultFileName:name,tableNameDataAttribute:"myTableExport"});
    // table2excel.export(tableex);
    FinishProcess();
    var tab = document.getElementById('myTableExcel');
    $('#myTableExcel').remove();
    var win = window.open('', '', 'height=700,width=700');
    win.document.write(tab.outerHTML);
    win.document.close();
    win.print();
}

function exportZipImg(data) {
    var zip = new JSZip();

    var ds="";
    var img = zip.folder("images");
    for (var i=0; i<data.length;i++) {

        var base64Img = data[i].src.replace(/^data:image\/(png|jpg);base64,/, "");
        img.file(data[i].name +"_"+ data[i].id+".png", base64Img, {base64: true});

        var number = i+1;
        ds += number + ". " + data[i].id + "\n";
    }
    zip.file("Danh_sach_QR_code.txt", ds);
    zip.generateAsync({type:"blob"})
        .then(function(content) {
            // see FileSaver.js
            saveAs(content, "QRCode.zip");
        });
}