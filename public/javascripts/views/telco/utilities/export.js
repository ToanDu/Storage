/**
 * Created by vtk-anhlt166 on 1/3/23.
 */
function exportListSubsMiAddonTrue() {
    if(listMiAddonSubsTrue.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListMiAddonSubsTrue");
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
        for (var i=0; i<listMiAddonSubsTrue.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listMiAddonSubsTrue[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListMiAddonSubsTrue');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsMiAddonFalse() {
    if(listMiAddonSubsFalse.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListMiAddonSubsFalse");
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
        for (var i=0; i<listMiAddonSubsFalse.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listMiAddonSubsFalse[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListMiAddonSubsFalse');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

//export list sub block
function exportListSubsBlockTrue() {
    if(listBlockSubsTrue.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListBlockSubsTrue");
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
        for (var i=0; i<listBlockSubsTrue.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listBlockSubsTrue[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListBlockSubsTrue');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsBlockFalse() {
    if(listBlockSubsFalse.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListBlockSubsFalse");
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
        for (var i=0; i<listBlockSubsFalse.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listBlockSubsFalse[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListBlockSubsFalse');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

//export list sub open
function exportListSubsOpenTrue() {
    if(listOpen1SubsTrueSubmit.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListOpenSubsTrue");
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
        for (var i=0; i<listOpen1SubsTrueSubmit.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listOpen1SubsTrueSubmit[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListOpenSubsTrue');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsOpenFalse() {
    if(listOpenSubsFalse.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListOpenSubsFalse");
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
        for (var i=0; i<listOpenSubsFalse.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listOpenSubsFalse[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListOpenSubsFalse');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsOpenTrue2() {
    if(listOpen2SubsTrueSubmit.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListOpenSubsTrue2");
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
        for (var i=0; i<listOpen2SubsTrueSubmit.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listOpen2SubsTrueSubmit[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListOpenSubsTrue2');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsOpenFalse2() {
    if(listOpenSubsFalse2.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListOpenSubsFalse2");
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
        for (var i=0; i<listOpenSubsFalse2.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listOpenSubsFalse2[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListOpenSubsFalse2');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

//export list sub recharge
function exportListSubsRechargeTrue() {
    if(listRechargeSubsTrueSubmit.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListRechargeSubsTrue");
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
        for (var i=0; i<listRechargeSubsTrueSubmit.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listRechargeSubsTrueSubmit[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListRechargeSubsTrue');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();

    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}

function exportListSubsRechargeFalse() {
    if(listRechargeSubsFalse.length > 0){
        var table = document.createElement("table");
        table.setAttribute("class", "table");
        table.setAttribute("id", "tableListRechargeSubsFalse");
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
        for (var i=0; i<listRechargeSubsFalse.length;i++) {
            var tabletr=document.createElement("tr");

            var td0=document.createElement("td");
            var text0 = document.createTextNode(i+1);
            td0.appendChild(text0);
            tabletr.appendChild(td0);

            var td1=document.createElement("td");
            var text1 = document.createTextNode(listRechargeSubsFalse[i]);
            td1.appendChild(text1);
            tabletr.appendChild(td1);

            tablebody.appendChild(tabletr);
        }

        table.appendChild(tablebody);

        var tableEx = $('#tableListRechargeSubsFalse');
        var table2excel = new Table2Excel({defaultFileName: "Export_List_Subs_Not_Valid", tableNameDataAttribute: "myTableExport"});
        table2excel.export(tableEx);
        tableEx.remove();
    } else {
        showNotification('danger',Messages("Dữ liệu không có sẵn"));
    }
}