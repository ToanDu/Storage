/**
 * Created by vtk-anhlt166 on 2/15/23.
 */
var tableExportMultiSerial;
function exportMultiSearchSerial(index) {
    console.log(listCheckSerial[index]);
    if(index == 0){
        tableExportMultiSerial = null;
        sttSearch = 0;

        tableExportMultiSerial = document.createElement("table");
        tableExportMultiSerial.setAttribute("class", "table");
        tableExportMultiSerial.setAttribute("id", "myTableExcelMultiSerial");

        document.body.appendChild(tableExportMultiSerial);

        var tablethread=document.createElement("thead");
        var tablethreadtr=document.createElement("tr");

        var th0=document.createElement("th");
        var t0 = document.createTextNode("STT");
        th0.appendChild(t0);
        tablethreadtr.appendChild(th0);

        var th1=document.createElement("th");
        var t1 = document.createTextNode(Messages("subscriber.phoneNumber"));
        th1.appendChild(t1);
        tablethreadtr.appendChild(th1);

        var th2=document.createElement("th");
        var t2 = document.createTextNode("Mã TB");
        th2.appendChild(t2);
        tablethreadtr.appendChild(th2);

        var th3=document.createElement("th");
        var t3 = document.createTextNode("Gói cước	");
        th3.appendChild(t3);
        tablethreadtr.appendChild(th3);

        var th4=document.createElement("th");
        var t4 = document.createTextNode("Mã CTKM");
        th4.appendChild(t4);
        tablethreadtr.appendChild(th4);

        var th5=document.createElement("th");
        var t5 = document.createTextNode("Mã hợp đồng");
        th5.appendChild(t5);
        tablethreadtr.appendChild(th5);

        var th6=document.createElement("th");
        var t6 = document.createTextNode("Mã KH");
        th6.appendChild(t6);
        tablethreadtr.appendChild(th6);

        var th7=document.createElement("th");
        var t7 = document.createTextNode("Serial sim");
        th7.appendChild(t7);
        tablethreadtr.appendChild(th7);

        var th8=document.createElement("th");
        var t8 = document.createTextNode("TT chặn cắt");
        th8.appendChild(t8);
        tablethreadtr.appendChild(th8);

        var th9=document.createElement("th");
        var t9 = document.createTextNode("Kích hoạt");
        th9.appendChild(t9);
        tablethreadtr.appendChild(th9);

        var th10=document.createElement("th");
        var t10 = document.createTextNode("Đấu nối");
        th10.appendChild(t10);
        tablethreadtr.appendChild(th10);

        var th11=document.createElement("th");
        var t11 = document.createTextNode("Loại DV");
        th11.appendChild(t11);
        tablethreadtr.appendChild(th11);

        tablethread.appendChild(tablethreadtr);

        tableExportMultiSerial.appendChild(tablethread);

        var tablebody=document.createElement("tbody");
        tableExportMultiSerial.appendChild(tablebody);
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
                if(listCheckSerial[index].trim().length > 0){
                    if(datas.success){
                        if(datas.content != null){
                            if(datas.content.listSubscriber != null && datas.content.listSubscriber.length > 0){
                                var listSubscriber = datas.content.listSubscriber;
                                var tabletr=document.createElement("tr");

                                var td0=document.createElement("td");
                                var text0 = document.createTextNode(sttSearch+1);
                                td0.appendChild(text0);
                                tabletr.appendChild(td0);

                                var td1=document.createElement("td");
                                var text1 = document.createTextNode(listSubscriber[0].isdn);
                                td1.appendChild(text1);
                                tabletr.appendChild(td1);

                                var td2=document.createElement("td");
                                var text2 = document.createTextNode(listSubscriber[0].subId);
                                td2.appendChild(text2);
                                tabletr.appendChild(td2);

                                var td3=document.createElement("td");
                                var text3 = document.createTextNode(listSubscriber[0].productCode);
                                td3.appendChild(text3);
                                tabletr.appendChild(td3);

                                var td4=document.createElement("td");
                                var text4 = document.createTextNode(listSubscriber[0].promotionCode);
                                td4.appendChild(text4);
                                tabletr.appendChild(td4);

                                var td5=document.createElement("td");
                                var text5 = document.createTextNode(listSubscriber[0].accountId);
                                td5.appendChild(text5);
                                tabletr.appendChild(td5);

                                var td6=document.createElement("td");
                                var text6 = document.createTextNode(listSubscriber[0].custId);
                                td6.appendChild(text6);
                                tabletr.appendChild(td6);

                                var td7=document.createElement("td");
                                var text7 = document.createTextNode("'"+listSubscriber[0].serial);
                                td7.appendChild(text7);
                                tabletr.appendChild(td7);

                                var td8=document.createElement("td");
                                var text8 = document.createTextNode(getStatusByCode(listSubscriber[0].actStatus, listSubscriber[0].payType));
                                td8.appendChild(text8);
                                tabletr.appendChild(td8);

                                var td9=document.createElement("td");
                                var text9 = document.createTextNode(listSubscriber[0].staDatetime.length > 0 ? (moment(moment(listSubscriber[0].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("HH:mm")+"-"+moment(moment(listSubscriber[0].staDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("DD/MM/YYYY")) : "");
                                td9.appendChild(text9);
                                tabletr.appendChild(td9);

                                var td10=document.createElement("td");
                                var text10 = document.createTextNode(listSubscriber[0].activeDatetime.length > 0 ? (moment(moment(listSubscriber[0].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("HH:mm")+"-"+moment(moment(listSubscriber[0].activeDatetime, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format("DD/MM/YYYY")) : "");
                                td10.appendChild(text10);
                                tabletr.appendChild(td10);

                                var td11=document.createElement("td");
                                var text11 = document.createTextNode(getPayTypeByCode(listSubscriber[0].payType));
                                td11.appendChild(text11);
                                tabletr.appendChild(td11);

                                $("#myTableExcelMultiSerial").find('tbody').append(tabletr);
                                sttSearch++;
                            }
                        }
                    }
                }
            },
            complete: function (){
                // FinishProcess();
                if(index < listCheckSerial.length-1){
                    exportMultiSearchSerial(index+1);
                } else {
                    FinishProcess();
                    if(sttSearch == 0){
                        showNotification('danger',Messages("manage.no.data"));
                        return;
                    }
                    outExcelMultiSerial("List_subscriber");
                }
            }
        })
    } else {
        if(index < listCheckSerial.length-1){
            exportMultiSearchSerial(index+1);
        } else {
            FinishProcess();
            if(sttSearch == 0){
                showNotification('danger',Messages("manage.no.data"));
                return;
            }
            outExcelMultiSerial("List_subscriber");
        }
    }
}

function outExcelMultiSerial(name){
    console.log(name);
    var tableex=  $('#myTableExcelMultiSerial');
    var table2excel = new Table2Excel({defaultFileName:name,tableNameDataAttribute:"myTableExport"});
    table2excel.export(tableex);

    $('#myTableExcelMultiSerial').remove();
}