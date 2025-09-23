//xuat file mau
function downloadTemplateListSerialConnect() {
    createTableTemplate();
    var filename = "List_Serial_Adm1";
    outExcel(filename);
}
function createTableTemplate() {
    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", "myTableExcel");

    document.body.appendChild(table);

    var tablethread = document.createElement("thead");

    var tablethreadtr = document.createElement("tr");

    tablethreadtr.appendChild(createTh(Messages("STT")));
    tablethreadtr.appendChild(createTh(Messages("Serial Sim")));
    tablethreadtr.appendChild(createTh(Messages("Mã Adm1")));

    tablethread.appendChild(tablethreadtr);

    table.appendChild(tablethread);
}
function createTh(message) {
    var th0 = document.createElement("th");
    var t0 = document.createTextNode(message);
    th0.appendChild(t0);
    return th0;
}
function outExcel(name) {
    console.log(name);
    var tableex = $('#myTableExcel');
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableex);

    $('#myTableExcel').remove();
}

//export list sub recharge
function exportListSerialAdm1True() {
    if(listSerialAdm1TrueSubmit.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListSerialAdm1TrueSubmit");
        document.body.appendChild(table);
        var tablethread=document.createElement("thead");
        var tablethreadtr=document.createElement("tr");

        var th0=document.createElement("th");
        var t0 = document.createTextNode(Messages("STT"));
        th0.appendChild(t0);
        tablethreadtr.appendChild(th0);

        var th1=document.createElement("th");
        var t1 = document.createTextNode(Messages("Số TB"));
        th1.appendChild(t1);
        tablethreadtr.appendChild(th1);

        tablethread.appendChild(tablethreadtr);
        table.appendChild(tablethread);

        var tablebody=document.createElement("tbody");
        for (var i=0; i<listSerialAdm1TrueSubmit.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listSerialAdm1TrueSubmit[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListSerialAdm1TrueSubmit');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSerialAdm1False() {
    if(listSerialAdm1FalseSubmit.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListSerialAdm1FalseSubmit");
        document.body.appendChild(table);
        var tablethread=document.createElement("thead");
        var tablethreadtr=document.createElement("tr");

        var th0=document.createElement("th");
        var t0 = document.createTextNode(Messages("STT"));
        th0.appendChild(t0);
        tablethreadtr.appendChild(th0);

        var th1=document.createElement("th");
        var t1 = document.createTextNode(Messages("Số TB"));
        th1.appendChild(t1);
        tablethreadtr.appendChild(th1);

        tablethread.appendChild(tablethreadtr);
        table.appendChild(tablethread);

        var tablebody=document.createElement("tbody");
        for (var i=0; i<listSerialAdm1FalseSubmit.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listSerialAdm1FalseSubmit[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListSerialAdm1FalseSubmit');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}