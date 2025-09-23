var columnTitles = new Array;
const idExportTable = 'TableListSurvey';
function exportListSurvey() {
    var body = new FormData();
    console.log(body);
    StartProcess();
    var r = jsRoutes.controllers.TelcoLogController.exportLogCustomerSurvey();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.success){
                if(datas.content != null && datas.content.length > 0){
                    createTable(datas.content);

                    outExcel("DS_khao_sat_KH_su_dung_CMP");
                }
            } else {
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            FinishProcess();
        }
    })
}

function createTable(data){

    var table = document.createElement("table");
    table.setAttribute("class", "table");
    table.setAttribute("id", "myTableExcel");

    document.body.appendChild(table);

    var tablethread=document.createElement("thead");

    var tablethreadtr=document.createElement("tr");

    var th0=document.createElement("th");
    var t0 = document.createTextNode(Messages("STT"));
    th0.appendChild(t0);
    tablethreadtr.appendChild(th0);

    var th1=document.createElement("th");
    var t1 = document.createTextNode(Messages("Email"));
    th1.appendChild(t1);
    tablethreadtr.appendChild(th1);

    var th2=document.createElement("th");
    var t2 = document.createTextNode("Tên KH");
    th2.appendChild(t2);
    tablethreadtr.appendChild(th2);

    var th3=document.createElement("th");
    var t3 = document.createTextNode("Người liên hệ");
    th3.appendChild(t3);
    tablethreadtr.appendChild(th3);

    var th4=document.createElement("th");
    var t4 = document.createTextNode("Chức vụ");
    th4.appendChild(t4);
    tablethreadtr.appendChild(th4);

    var th5=document.createElement("th");
    var t5 = document.createTextNode("Số thuê bao");
    th5.appendChild(t5);
    tablethreadtr.appendChild(th5);

    var th6=document.createElement("th");
    var t6 = document.createTextNode(Messages("Anh/chị có gặp bất tiện gì trong quá trình sử dụng không? Nếu có, xin cụ thể vấn đề gây khó chịu nhất?"));
    th6.appendChild(t6);
    tablethreadtr.appendChild(th6);

    var th7=document.createElement("th");
    var t7 = document.createTextNode(Messages("Có tính năng nào anh chị chưa thử dùng trên CMP? "));
    th7.appendChild(t7);
    tablethreadtr.appendChild(th7);

    var th20=document.createElement("th");
    var t20 = document.createTextNode(Messages("Có 3 tính năng nâng cao sắp tới sẽ đưa vào triển khai, bạn thấy tính năng nào sẽ có ý nghĩa nhất với doanh nghiệp của mình? "));
    th20.appendChild(t20);
    tablethreadtr.appendChild(th20);

    var th8=document.createElement("th");
    var t8 = document.createTextNode(Messages("Theo anh chị, hệ thống cần bổ sung thêm tính năng nào để Doanh nghiệp quản lý thuê bao tốt hơn?"));
    th8.appendChild(t8);
    tablethreadtr.appendChild(th8);

    var th9=document.createElement("th");
    var t9 = document.createTextNode(Messages("CMP giúp đơn vị giảm được nhân sự vận hành hệ thống không?"));
    th9.appendChild(t9);
    tablethreadtr.appendChild(th9);

    var th10=document.createElement("th");
    var t10 = document.createTextNode(Messages("CMP giúp doanh nghiệp tiết kiệm thời gian trong khâu nào nhất? (quản lý SIM, nạp tiền, chặn/mở chặn, đấu nối SIM)"));
    th10.appendChild(t10);
    tablethreadtr.appendChild(th10);

    var th11=document.createElement("th");
    var t11 = document.createTextNode(Messages("Biết đến tính năng Quản lý hợp đồng của CMP không?"));
    th11.appendChild(t11);
    tablethreadtr.appendChild(th11);

    var th12=document.createElement("th");
    var t12 = document.createTextNode(Messages("Biết đến tính năng mua gói data/Mi của CMP không?"));
    th12.appendChild(t12);
    tablethreadtr.appendChild(th12);

    var th13=document.createElement("th");
    var t13 = document.createTextNode(Messages("Biết đến tính năng nạp tiền của CMP không?"));
    th13.appendChild(t13);
    tablethreadtr.appendChild(th13);

    var th14=document.createElement("th");
    var t14 = document.createTextNode(Messages("Biết đến tính năng mở chiều/chặn chiều thuê bao của CMP không?"));
    th14.appendChild(t14);
    tablethreadtr.appendChild(th14);

    var th15=document.createElement("th");
    var t15 = document.createTextNode(Messages("Biết đến tính năng đấu nối/đặt hàng thuê bao của CMP không?"));
    th15.appendChild(t15);
    tablethreadtr.appendChild(th15);

    var th16=document.createElement("th");
    var t16 = document.createTextNode(Messages("Biết đến tính năng tạo user/phân quyền của CMP"));
    th16.appendChild(t16);
    tablethreadtr.appendChild(th16);

    var th17=document.createElement("th");
    var t17 = document.createTextNode(Messages("Biết đến tính năng định vị thuê bao của CMP "));
    th17.appendChild(t17);
    tablethreadtr.appendChild(th17);

    var th18=document.createElement("th");
    var t18 = document.createTextNode(Messages("Biết đến tính năng tư vấn gói cước phù hợp, dựa trên lưu lượng sử dụng thực tế của thuê bao"));
    th18.appendChild(t18);
    tablethreadtr.appendChild(th18);

    var th19=document.createElement("th");
    var t19 = document.createTextNode(Messages("Đội ngũ phát triển ứng dụng"));
    th19.appendChild(t19);
    tablethreadtr.appendChild(th19);

    var th20=document.createElement("th");
    var t20 = document.createTextNode(Messages("Lĩnh vực"));
    th20.appendChild(t20);
    tablethreadtr.appendChild(th20);

    var th21=document.createElement("th");
    var t21 = document.createTextNode(Messages("Số lượng kết nối"));
    th21.appendChild(t21);
    tablethreadtr.appendChild(th21);

    var th22=document.createElement("th");
    var t22 = document.createTextNode(Messages("Sẵn sàng thử nghiệm"));
    th22.appendChild(t22);
    tablethreadtr.appendChild(th22);

    var th23=document.createElement("th");
    var t23= document.createTextNode(Messages("Điều gì của CMP sẽ khiến các bạn giới thiệu cho bạn bè "));
    th23.appendChild(t23);
    tablethreadtr.appendChild(th23);

    var th24=document.createElement("th");
    var t24 = document.createTextNode(Messages("Gợi ý"));
    th24.appendChild(t24);
    tablethreadtr.appendChild(th24);

    var th25=document.createElement("th");
    var t25 = document.createTextNode(Messages("Mô tả"));
    th25.appendChild(t25);
    tablethreadtr.appendChild(th25);

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
        var text1 = document.createTextNode(data[i].username);
        td1.appendChild(text1);
        tabletr.appendChild(td1);

        var td2=document.createElement("td");
        var text2 = document.createTextNode(data[i].tenKhachHang);
        td2.appendChild(text2);
        tabletr.appendChild(td2);

        var td3=document.createElement("td");
        var text3 = document.createTextNode(data[i].ngLienHe);
        td3.appendChild(text3);
        tabletr.appendChild(td3);


        var td4=document.createElement("td");
        var text4 = document.createTextNode(data[i].chucVu);
        td4.appendChild(text4);
        tabletr.appendChild(td4);

        var td5=document.createElement("td");
        var text5 = document.createTextNode(data[i].soThueBao);
        td5.appendChild(text5);
        tabletr.appendChild(td5);


        var td6=document.createElement("td");
        var text6 = document.createTextNode(data[i].q1);
        td6.appendChild(text6);
        tabletr.appendChild(td6);

        var td7=document.createElement("td");
        var q2Array = data[i].q2.split(",");
        var content = "";
        if(q2Array.length > 0){
            for(var j=0; j<q2Array.length; j++){
                if(q2Array[j] == 1){
                    content += "1. Xem thông tin thuê bao\n";
                } else if(q2Array[j] == 2){
                    content += "2.  Quản lý hợp đồng\n";
                } else if(q2Array[j] == 3){
                    content += "3.  Tra cứu cước\n";
                } else if(q2Array[j] == 4){
                    content += "4.  Theo dõi nội dung thuê bao đã dùng\n";
                } else if(q2Array[j] == 5){
                    content += "5. Định vị thuê bao\n";
                } else if(q2Array[j] == 6){
                    content += "6.  Đầu nối SIM\n";
                } else if(q2Array[j] == 7){
                    content += "7.  Chặn mở SIM\n";
                } else if(q2Array[j] == 8){
                    content += "8.  Nạp tiền cho thuê bao\n";
                } else if(q2Array[j] == 9){
                    content += "9.  Phân quyền user (theo phân cấp đơn vị)\n";
                }
            }
        }
        var text7 = document.createTextNode(content);
        td7.appendChild(text7);
        tabletr.appendChild(td7);

        var td8=document.createElement("td");
        var contentQ3 = "";
        var q3Array = data[i].q3;
                if(q3Array == 1){
                    contentQ3 += "1. Tính năng tư vấn gói cước dựa trên lưu lượng tiêu dùng thực tế\n";
                } else if(q3Array == 2){
                    contentQ3 += "2.  Tính năng định vị thuê bao (cho bạn biết vị trí thực tế của từng thuê bao)\n";
                } else if(q3Array == 3){
                    contentQ3 += "3.  Hỗ trợ quản lý thiết bị (quản lý trạng thái, quản lý phiên bản phần mềm thiết bị, nâng cấp phần mềm thiết bị từ xa)\n";
                }

        var text8 = document.createTextNode(contentQ3);
        td8.appendChild(text8);
        tabletr.appendChild(td8);

        var td9=document.createElement("td");
        var text9 = document.createTextNode(data[i].q4);
        td9.appendChild(text9);
        tabletr.appendChild(td9);

        var td10=document.createElement("td");
        var contentQ5 = "";
        var q5Array = data[i].q5;
        if(q5Array == 1){
            contentQ5 = " Có\n";
        } else if(q5Array == 2){
            contentQ5 = " Không\n";
        }
        var text10 = document.createTextNode(contentQ5);
        td10.appendChild(text10);
        tabletr.appendChild(td10);

        var td11=document.createElement("td");
        var text11 = document.createTextNode(data[i].q6);
        td11.appendChild(text11);
        tabletr.appendChild(td11);

        var td12=document.createElement("td");
        var contentQ7 = "";
        var q7Array = data[i].q7;
        if(q7Array == 1){
            contentQ7 = " Có\n";
        } else if(q7Array == 2){
            contentQ7 = " Không\n";
        }
        var text12 = document.createTextNode(contentQ7);
        td12.appendChild(text12);
        tabletr.appendChild(td12);

        var td13=document.createElement("td");
        var contentQ8 = "";
        var q8Array = data[i].q8;
        if(q8Array == 1){
            contentQ8 = " Có\n";
        } else if(q8Array == 2){
            contentQ8 = " Không\n";
        }
        var text13 = document.createTextNode(contentQ8);
        td13.appendChild(text13);
        tabletr.appendChild(td13);

        var td14=document.createElement("td");
        var contentQ9 = "";
        var q9Array = data[i].q9;
        if(q9Array == 1){
            contentQ9 = " Có\n";
        } else if(q9Array == 2){
            contentQ9 = " Không\n";
        }
        var text14 = document.createTextNode(contentQ9);
        td14.appendChild(text14);
        tabletr.appendChild(td14);

        var td15=document.createElement("td");
        var contentQ10 = "";
        var q10Array = data[i].q10;
        if(q10Array == 1){
            contentQ10 = " Có\n";
        } else if(q10Array == 2){
            contentQ10 = " Không\n";
        }
        var text15 = document.createTextNode(contentQ10);
        td15.appendChild(text15);
        tabletr.appendChild(td15);

        var td16=document.createElement("td");
        var contentQ11 = "";
        var q11Array = data[i].q11;
        if(q11Array == 1){
            contentQ11 = " Có\n";
        } else if(q11Array == 2){
            contentQ11 = " Không\n";
        }
        var text16 = document.createTextNode(contentQ11);
        td16.appendChild(text16);
        tabletr.appendChild(td16);

        var td17=document.createElement("td");
        var contentQ12 = "";
        var q12Array = data[i].q12;
        if(q12Array == 1){
            contentQ12 = " Có\n";
        } else if(q12Array == 2){
            contentQ12 = " Không\n";
        }
        var text17 = document.createTextNode(contentQ12);
        td17.appendChild(text17);
        tabletr.appendChild(td17);

        var td18=document.createElement("td");
        var contentQ13 = "";
        var q13Array = data[i].q13;
        if(q13Array == 1){
            contentQ13 = " Có\n";
        } else if(q13Array == 2){
            contentQ13 = " Không\n";
        }
        var text18 = document.createTextNode(contentQ13);
        td18.appendChild(text18);
        tabletr.appendChild(td18);

        var td19=document.createElement("td");
        var contentQ14 = "";
        var q14Array = data[i].q14;
        if(q14Array == 1){
            contentQ14 = " Có\n";
        } else if(q14Array == 2){
            contentQ14 = " Không\n";
        }
        var text19 = document.createTextNode(contentQ14);
        td19.appendChild(text19);
        tabletr.appendChild(td19);

        var td20=document.createElement("td");
        var contentQ15 = "";
        var q15Array = data[i].q15;
        if(q15Array == 1){
            contentQ15 = " 0\n";
        } else if(q15Array == 2){
            contentQ15 = " 1\n";
        } else if(q15Array == 3){
            contentQ15 = " 2\n";
        } else if(q15Array == 4){
            contentQ15 = " 3\n";
        } else if(q15Array == 5){
            contentQ15 = " 4\n";
        } else if(q15Array == 6){
            contentQ15 = " lơn hơn 5\n";
        }
        var text20 = document.createTextNode(contentQ15);
        td20.appendChild(text20);
        tabletr.appendChild(td20);

        var td21=document.createElement("td");
        var q16Array = data[i].q16.split(",");
        var contentQ16 = "";
        if(q16Array.length > 0){
            for(var j=0; j<q16Array.length; j++){
                if(q16Array[j] == 1){
                    contentQ16 += "1.Giao thông\n";
                } else if(q16Array[j] == 2){
                    contentQ16 += "2.  Vận tải ( khách, hàng hóa)\n";
                } else if(q16Array[j] == 3){
                    contentQ16 += "3.  Quản lý thú cưng, tài sản\n";
                } else if(q16Array[j] == 4){
                    contentQ16 += "4.  Y tế - Chăm sóc sức khỏe\n";
                } else if(q16Array[j] == 5){
                    contentQ16 += "5. Đo lường (điện, nước)\n";
                } else if(q16Array[j] == 6){
                    contentQ16 += "6.  Phát wifi\n";
                } else if(q16Array[j] == 7){
                    contentQ16 += "7.  Camera giám sát\n";
                } else if(q16Array[j] == 8){
                    contentQ16 += "8.  Đèn đường\n";
                } else if(q16Array[j] == 9){
                    contentQ16 += "9.  Nông nghiệp (cây trồng)\n";
                } else if(q16Array[j] == 10){
                    contentQ16 += "10.  Thủy canh (tôm, cá)\n";
                } else if(q16Array[j] == 11){
                    contentQ16 += "11.  Quan trắc môi trường (nguồn nước, không khí, nước thải)\n";
                } else if(q16Array[j] == 12){
                    contentQ16 += "12.  Sản xuất - truyền tải điệ\n";
                } else if(q16Array[j] == 13){
                    contentQ16 += "13.  Đồng hồ thông minh (trẻ em, thể thao)\n";
                } else if(q16Array[j] == 14){
                    contentQ16 += "14.  Lĩnh vực khác...)\n";
                }
            }
        }
        var text21 = document.createTextNode(contentQ16);
        td21.appendChild(text21);
        tabletr.appendChild(td21);

        var td22=document.createElement("td");
        var text22 = document.createTextNode(data[i].q17);
        td22.appendChild(text22);
        tabletr.appendChild(td22);

        var td23=document.createElement("td");
        var contentQ18 = "";
        var q18Array = data[i].q18;
        if(q18Array == 1){
            contentQ18 += " Không\n";
        } else if(q18Array == 2){
            contentQ18 += " Xem xét\n";
        } else if(q18Array == 3){
            contentQ18 += "Sẵn sàng\n";
        }
        var text23 = document.createTextNode(contentQ3);
        td23.appendChild(text23);
        tabletr.appendChild(td23);

        var td24=document.createElement("td");
        var text24 = document.createTextNode(data[i].q19);
        td24.appendChild(text24);
        tabletr.appendChild(td24);

        var td25=document.createElement("td");
        var text25 = document.createTextNode(data[i].q20);
        td25.appendChild(text25);
        tabletr.appendChild(td25);

        var td26=document.createElement("td");
        var text26 = document.createTextNode(data[i].q21);
        td26.appendChild(text26);
        tabletr.appendChild(td26);


        tablebody.appendChild(tabletr);
    }

    table.appendChild(tablebody);


}

function outExcel(name){
    var tableex=  $('#myTableExcel');
    var table2excel = new Table2Excel({defaultFileName:name,tableNameDataAttribute:"myTableExport"});
    table2excel.export(tableex);

    $('#myTableExcel').remove()
}
