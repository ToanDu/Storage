/**
 * Created by vtk-anhlt166 on 12/6/22.
 */
function importSearchListSub() {
    console.log("importSearchListSub");
    document.getElementById("filesSearchSubs").value = "";
    $("#importSearchSubsModal").modal('show');
}

//xuat file mau
function downloadTemplateSearchSubs() {
    createTableTemplate();
    var filename = "List_Subs";
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
    tablethreadtr.appendChild(createTh(Messages("subscriber.phoneNumber")));

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

//import
var listSubsImport = new Array;
function uploadSearchSubs(evt) {
    listSubsImport = [];
    if (!browserSupportFileUpload()) {
        console.log('The File APIs are not fully supported in this browser!');
    } else {
        var fileList = evt.target.files;
        console.log("fileList", fileList);
        var file = fileList[0];
        if (!file.name.endsWith(".xlsx")) {
            showNotification('danger',Messages("File không đúng format xlsx"));
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
                        if(validatePhone(listFile[i][1])){
                            if(!listSubsImport.includes(listFile[i][1])){
                                listSubsImport.push(listFile[i][1]);
                            }
                        }
                    }
                }
            } else {
                showNotification('danger',Messages("File không đủ dữ liệu"));
                return;
            }
        };
        reader.onerror = function () {
            console.log('Unable to read ' + file.fileName);
        };
    }
}

function browserSupportFileUpload() {
    var isCompatible = false;
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        isCompatible = true;
    }
    return isCompatible;
}

function comfirmListSubsImport() {
    console.log(listSubsImport);
    if(listSubsImport.length > 0){
        if(listSubsImport.length > 500){
            showNotification('danger',Messages("subscriber.import.max.500.error"));
            return;
        }
        var listSubs = "";
        for(var i=0; i<listSubsImport.length; i++){
            var sub = parseFloat(listSubsImport[i].trim().replace(/\D/g,''));
            if(sub > 0){
                if(i == 0){
                    listSubs += sub.toString();
                } else {
                    listSubs += ","+sub.toString();
                }
            }
        }
        console.log(listSubs);
        $("#isdn").val(listSubs);
    } else {
        showNotification('danger',Messages("subscriber.import.no.valid.numbers"));
    }
}

function validatePhone(inputtxt) {
    var phone9 = /^\d{9}$/;
    var phone10 = /^\d{10}$/;
    if(phone9.test(inputtxt) || phone10.test(inputtxt)) {
        return true;
    } else {
        return false;
    }
}

//search with list subs
var sttSearch = 0;
function getListByFileSubs(index) {
    console.log(listCheckSubs[index]);
    if(index == 0){
        sttSearch = 0;
        $("#listSubsTable").find('tbody').html("");
        document.getElementById("divPagingTable").style.display = 'none';
    }

    if(listCheckSubs[index] != null && listCheckSubs[index].length > 0){
        var body = new FormData();
        body.idNo = gpkd;
        body.isdn = listCheckSubs[index].trim();
        body.serial = $('#serialSim').val().trim();
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
        console.log(body);
        StartProcess();
        var r = jsRoutes.controllers.TelcoSubscriberController.getListSubscriber();
        $.ajax({
            type: r.type,
            data: JSON.stringify(body),
            contentType: "application/json; charset=utf-8",
            url: r.url,
            success: function(datas){
                console.log(datas);
                if(listCheckSubs[index].trim().length > 0){
                    if(datas.success){
                        if(datas.content != null){
                            if(datas.content.listSubscriber != null && datas.content.listSubscriber.length > 0){
                                $("#notiNotDataSubs").html("");

                                var listSubscriber = datas.content.listSubscriber;
                                var idTooltip = "tooltip_"+listSubscriber[0].isdn;
                                var body = "<tr>";
                                body += "<td>"+(sttSearch+1)+"</td>";
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
                                sttSearch++;
                            }
                        }
                    }
                }
            },
            complete: function (){
                // FinishProcess();
                if(index < listCheckSubs.length-1){
                    getListByFileSubs(index+1);
                } else {
                    if($("#listSubsTable").find('tr').length <= 1){
                        $("#notiNotDataSubs").html(Messages("subscriber.noDataToDisplay"));
                    }
                    $("#count-tb").html(sttSearch);
                    FinishProcess();
                }
            }
        })
    } else {
        if(index < listCheckSubs.length-1){
            getListByFileSubs(index+1);
        } else {
            if($("#listSubsTable").find('tr').length <= 1){
                $("#notiNotDataSubs").html("Không có thông tin để hiển thị");
            }
            $("#count-tb").html(sttSearch);
            FinishProcess();
        }
    }
}