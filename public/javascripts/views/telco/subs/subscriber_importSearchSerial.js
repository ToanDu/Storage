/**
 * Created by vtk-anhlt166 on 12/6/22.
 */
function importSearchListSerial() {
    console.log("importSearchListSerial");
    document.getElementById("filesSearchSerial").value = "";
    $("#importSearchSerialModal").modal('show');
}

function downloadTemplateSearchSerial() {
    createTableTemplateSerial();
    var filename = "List_Serial";
    outExcelSerial(filename);
}
function createTableTemplateSerial() {
    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", "myTableExcel");

    document.body.appendChild(table);

    var tablethread = document.createElement("thead");

    var tablethreadtr = document.createElement("tr");

    tablethreadtr.appendChild(createTh(Messages("subscriber.export.column.stt")));
    tablethreadtr.appendChild(createTh(Messages("subscriber.import.serialNumber")));

    tablethread.appendChild(tablethreadtr);

    table.appendChild(tablethread);
}
function outExcelSerial(name) {
    console.log(name);
    var tableex = $('#myTableExcel');
    var table2excel = new Table2Excel({defaultFileName: name, tableNameDataAttribute: "myTableExport"});
    table2excel.export(tableex);

    $('#myTableExcel').remove();
}

//import
var listSerialImport = new Array;
function uploadSearchSerial(evt) {
    listSerialImport = [];
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var fileList = evt.target.files;
        console.log("fileList", fileList);
        var file = fileList[0];
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("subscriber.import.fileWrongFormat"));
            return;
        }
        var reader = new FileReader();
        reader.readAsBinaryString(file);
        reader.onload = function (event) {
            var data = event.target.result;
            var workbook = XLSX.read(data, {
                type: 'binary'
            });
            var firstSheet = workbook.SheetNames[0];
            console.log(firstSheet.name);
            //header: 1 de lay deader
            var listFile = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet], {header: 1});
            // dataImported.
            console.log(listFile);
            if(listFile.length > 1){
                for(var i=1; i<listFile.length; i++){
                    if(listFile[i][1] != null){
                        var serial = listFile[i][1].trim().replaceAll("'","");
                        if(!listSerialImport.includes(serial)){
                            listSerialImport.push(serial);
                        }
                    }
                }
            } else {
                showNotification('danger',Messages("subscriber.import.fileNotEnoughData"));
                return;
            }
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
    }
}

function comfirmListSerialImport() {
    console.log(listSerialImport);
    if(listSerialImport.length > 0){
        if(listSerialImport.length > 500){
            showNotification('danger',Messages("subscriber.import.maxSerials"));
            return;
        }
        var listSerial = "";
        for(var i=0; i<listSerialImport.length; i++){
            var serial = listSerialImport[i].trim().replace(/\D/g,'');
            if(serial.length > 0){
                if(i == 0){
                    listSerial += serial;
                } else {
                    listSerial += ","+serial;
                }
            }
        }
        $("#serialSim").val(listSerial);
    } else {
        showNotification('danger',Messages("subscriber.import.noValidSerial"));
    }
}

//search with list serial
var sttIndexSerial = 0;
function getListByFileSerial(index) {
    console.log(listCheckSerial[index]);
    if(index == 0){
        sttIndexSerial = 0;
        $("#listSubsTable").find('tbody').html("");
        document.getElementById("divPagingTable").style.display = 'none';
    }

    if(listCheckSerial[index] != null && listCheckSerial[index].length > 0){
        var body = new FormData();
        body.idNo = gpkd;
        body.isdn = $('#isdn').val().trim();
        body.serial = listCheckSerial[index].trim();
        body.accountId = $('#accountId').val().trim();
        body.payType = $('#payType').val();
        body.productCode = $('#productCode').val();
        body.actStatus = $('#actStatus').val();
        body.promotionCode = $('#promotionCode').val();
        body.fromStaDatetime = $('#staDatetimeFrom').val();
        body.toStaDatetime = $('#staDatetimeTo').val();
        body.fromActiveDatetime = $('#activeDateFrom').val();
        body.toActiveDatetime = $('#activeDateTo').val();
        body.page = $("#page").val();
        body.pageSize = $("#pageSize").val();

        StartProcess();
        var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function(datas){
                console.log(datas);
                if(listCheckSerial[index].trim().length > 0){
                    if(datas.success){
                        if(datas.content != null){
                            if(datas.content.listSubscriber != null && datas.content.listSubscriber.length > 0){
                                $("#notiNotDataSubs").html("");

                                var listSubscriber = datas.content.listSubscriber;
                                var idTooltip = "tooltip_"+listSubscriber[0].isdn;
                                var body = "<tr>";
                                body += "<td>"+(sttIndexSerial+1)+"</td>";
                                body += "<td>" + '<a class="tb cursor-pointer" onclick="showInfoSubscriber(\''+listSubscriber[0].isdn+'\', \''+listSubscriber[0].promotionCode+'\', \''+listSubscriber[0].serial+'\', \''+listSubscriber[0].payType+'\', \''+listSubscriber[0].actStatus+'\', \''+listSubscriber[0].staDatetime+'\', \''+listSubscriber[0].activeDatetime+'\', \''+listSubscriber[0].productCode+'\')">'+ listSubscriber[0].isdn +'</a>' + "</td>";
                                body += "<td class='wrap-text'>" + listSubscriber[0].subId + "</td>";
                                body += "<td class='wrap-text'>" + listSubscriber[0].productCode + "</td>";
                                body += "<td class='wrap-text'>" + listSubscriber[0].promotionCode + "</td>";
                                body += "<td class='wrap-text'>" + listSubscriber[0].accountId + "</td>";
                                body += "<td class='wrap-text'>" + listSubscriber[0].custId + "</td>";
                                body += "<td class='wrap-text'>" + listSubscriber[0].serial + "</td>";
                                body += "<td class='wrap-text'>" + getStatusByCode(listSubscriber[0].actStatus, listSubscriber[0].payType) + "</td>";
                                body += "<td class='wrap-text'>" + (listSubscriber[0].staDatetime.length > 0 ? moment(moment(listSubscriber[0].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
                                body += "<td class='wrap-text'>" + (listSubscriber[0].activeDatetime.length > 0 ? moment(moment(listSubscriber[0].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
                                body += "<td class='wrap-text'>" + getPayTypeByCode(listSubscriber[0].payType) + "</td>";
                                // body += "<td>" +
                                //     '<a class="btn-tb cursor-pointer" id="boton" onclick="showTooltips(\''+idTooltip+'\')">'+Messages("Kiểm tra LL")+'</a>' +
                                //     '<div class="tooltip" id="'+idTooltip+'">' +
                                //     '<span class="text-white">'+Messages("Comming Soon")+'</span>' +
                                //     '<button onclick="closeTooltip()">'+Messages("Close")+'</button>' +
                                //     '</div>' +
                                //     "</td>";
                                body += "</tr>";

                                $("#listSubsTable").find('tbody').append(body);
                                sttIndexSerial++;
                            }
                        }
                    }
                }
            },
            complete: function (){
                // FinishProcess();
                if(index < listCheckSerial.length-1){
                    getListByFileSerial(index+1);
                } else {
                    if($("#listSubsTable").find('tr').length <= 1){
                        $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
                    }
                    $("#count-tb").html(sttIndexSerial);
                    FinishProcess();
                }
            }
        })
    } else {
        if(index < listCheckSerial.length-1){
            getListByFileSerial(index+1);
        } else {
            if($("#listSubsTable").find('tr').length <= 1){
                $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
            }
            $("#count-tb").html(sttIndexSerial);
            FinishProcess();
        }
    }
}
