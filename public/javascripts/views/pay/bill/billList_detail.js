/**
 * Created by vtk-anhlt166 on 3/7/22.
 */
function billDetail(id) {
    var formData = new FormData;
    formData.id = id;
    StartProcess();
    var route = jsRoutes.controllers.PayBillController.getInfoBill();
    $.ajax({
        type: route.type,
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (datas) {
            console.log(datas);
            if (datas.success) {
                $("#detailBillModal").modal('show');

                $("#tdDetailVName").html(datas.content.data.v_name);
                $("#tdDetailVTax").html(datas.content.data.v_tax_code);
                $("#tdDetailVAddress").html(datas.content.data.v_address);

                $("#tdDetailCName").html(datas.content.data.c_name);
                $("#tdDetailCTax").html(datas.content.data.c_phone);
                $("#tdDetailCAddress").html(datas.content.data.c_address);

                $("#tdDetailBId").html(datas.content.data.b_id);
                $("#tdDetailBSubId").html(datas.content.data.b_sub_id);
                // $("#tdDetailBDevice").html("");
                $("#tdDetailSService").html(datas.content.data.s_service_type);

                $("#tdDetailDateRequest").html(datas.content.data.b_date_request > 0 ? moment.unix(datas.content.data.b_date_request).format("YYYY/MM/DD HH:mm") : "");
                $("#tdDetailDateExpiry").html(datas.content.data.b_date_expiry > 0 ? moment.unix(datas.content.data.b_date_expiry).format("YYYY/MM/DD HH:mm") : "");
                $("#tdDetailDatePayment").html(datas.content.data.b_date_payment > 0 ? moment.unix(datas.content.data.b_date_payment).format("YYYY/MM/DD HH:mm") : "");
                var color = "#333333";
                var status = "Khởi tạo";
                if(datas.content.data.b_status == "Pending"){
                    color = "#ff6e07";
                    status = "Chờ thanh toán";
                } else if(datas.content.data.b_status == "Paid"){
                    color = "#17a00e";
                    status = "Đã thanh toán";
                } else if(datas.content.data.b_status == "Expired"){
                    color = "#ff0019";
                    status = "Quá hạn";
                }
                $("#tdDetailStatus").html('<span style="color: '+color+'">'+status+'</span>');

                //table
                var mtmlTable = "<table id='smlDetailCostTable' class='table align-middle mb-0 table-responsive table-striped' style='width: 100%'>" +
                    "<thead>" +
                    '<th>'+Messages("STT")+'</th>'+
                    '<th>'+Messages("Tên dịch vụ")+'</th>'+
                    '<th>'+Messages("ĐVT")+'</th>'+
                    '<th>'+Messages("Số lượng")+'</th>'+
                    '<th>'+Messages("Đơn giá")+'</th>'+
                    '<th>'+Messages("Số tiền")+'</th>'+
                    "</thead>" +
                    "<tbody>";

                var cost = datas.content.data.b_quantity * datas.content.data.b_cost;
                var tableBody = "<tr>" +
                    "<td>1</td>" +
                    "<td>"+datas.content.data.s_service_type+"</td>" +
                    "<td>"+datas.content.data.b_charging_unit+"</td>" +
                    "<td>"+datas.content.data.b_quantity+"</td>" +
                    "<td>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(datas.content.data.b_cost))+"</td>" +
                    "<td>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(datas.content.data.b_quantity * datas.content.data.b_cost))+"</td>" +
                    "</tr>"+

                    "<tr>" +
                    "<td></td>" +
                    "<td><span style='font-weight: 600;'>"+Messages("Tổng")+"</span></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td><span style='font-weight: 600;'>"+(new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(cost))+"</span></td>" +
                    "</tr>";
                mtmlTable += tableBody + "</tbody></table>";
                $("#tableDetailCost").html(mtmlTable);

                var oTable=$('#smlDetailCostTable').DataTable( {
                    responsive: true,
                    lengthMenu: false,
                    bSort: false,
                    searching: false,
                    "bLengthChange" : false,
                    "bInfo":false,
                    "paging":false
                } );
                var oSettings = oTable.settings();

                $("#textCostTotal").html(Messages("Số tiền bằng chữ: ") + convertNumberToMoneyText(cost) + " việt nam đồng.")
            } else {
                $("#tableDetailCost").html("");
                showNotification('danger', Messages("connection.failed"));
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    })
}

function doc1so(so) {
    var arr_chuhangdonvi=['không','một','hai','ba','bốn','năm','sáu','bảy','tám','chín'];
    var resualt='';
    resualt=arr_chuhangdonvi[so];
    return resualt;
}

function doc2so(so) {
    so=so.replace(' ','');
    var arr_chubinhthuong=['không','một','hai','ba','bốn','năm','sáu','bảy','tám','chín'];
    var arr_chuhangdonvi=['mươi','mốt','hai','ba','bốn','lăm','sáu','bảy','tám','chín'];
    var arr_chuhangchuc=['','mười','hai mươi','ba mươi','bốn mươi','năm mươi','sáu mươi','bảy mươi','tám mươi','chín mươi'];
    var resualt='';
    var sohangchuc=so.substr(0,1);
    var sohangdonvi=so.substr(1,1);
    resualt+=arr_chuhangchuc[sohangchuc];
    if(sohangchuc==1&&sohangdonvi==1)
        resualt+=' '+arr_chubinhthuong[sohangdonvi];
    else if(sohangchuc==1&&sohangdonvi>1)
        resualt+=' '+arr_chuhangdonvi[sohangdonvi];
    else if(sohangchuc>1&&sohangdonvi>0)
        resualt+=' '+arr_chuhangdonvi[sohangdonvi];

    return resualt;
}

function doc3so(so) {
    var resualt='';
    var arr_chubinhthuong=['không','một','hai','ba','bốn','năm','sáu','bảy','tám','chín'];
    var sohangtram=so.substr(0,1);
    var sohangchuc=so.substr(1,1);
    var sohangdonvi=so.substr(2,1);
    resualt=arr_chubinhthuong[sohangtram]+' trăm';
    if(sohangchuc==0&&sohangdonvi!=0)
        resualt+=' linh '+arr_chubinhthuong[sohangdonvi];
    else if(sohangchuc!=0)
        resualt+=' '+this.doc2so(sohangchuc+' '+sohangdonvi);
    return resualt;
}

function docsonguyen(so) {
    var result='';
    if(so!=undefined)
    {
        //alert(so);
        var arr_So=[{ty:''},{trieu:''},{nghin:''},{tram:''}];
        var sochuso=so.length;
        for(var i=(sochuso-1);i>=0;i--)
        {

            if((sochuso-i)<=3)
            {
                if(arr_So['tram']!=undefined)
                    arr_So['tram']=so.substr(i,1)+arr_So['tram'];
                else arr_So['tram']=so.substr(i,1);

            }
            else if((sochuso-i)>3&&(sochuso-i)<=6)
            {
                if(arr_So['nghin']!=undefined)
                    arr_So['nghin']=so.substr(i,1)+arr_So['nghin'];
                else arr_So['nghin']=so.substr(i,1);
            }
            else if((sochuso-i)>6&&(sochuso-i)<=9)
            {
                if(arr_So['trieu']!=undefined)
                    arr_So['trieu']=so.substr(i,1)+arr_So['trieu'];
                else arr_So['trieu']=so.substr(i,1);
            }
            else
            {
                if(arr_So.ty!=undefined)
                    arr_So.ty=so.substr(i,1)+arr_So.ty;
                else arr_So.ty=so.substr(i,1);
            }
            //console.log(arr_So);
        }

        if(arr_So['ty']>0)
            result+=this.doc(arr_So['ty'])+' tỷ';
        if(arr_So['trieu']>0)
        {
            if(arr_So['trieu'].length>=3||arr_So['ty']>0)
                result+=' '+this.doc3so(arr_So['trieu'])+' triệu';
            else if(arr_So['trieu'].length>=2)
                result+=' '+this.doc2so(arr_So['trieu'])+' triệu';
            else result+=' '+this.doc1so(arr_So['trieu'])+' triệu';
        }
        if(arr_So['nghin']>0)
        {
            if(arr_So['nghin'].length>=3||arr_So['trieu']>0)
                result+=' '+this.doc3so(arr_So['nghin'])+' nghìn';
            else if(arr_So['nghin'].length>=2)
                result+=' '+this.doc2so(arr_So['nghin'])+' nghìn';
            else result+=' '+this.doc1so(arr_So['nghin'])+' nghìn';
        }
        if(arr_So['tram']>0)
        {
            if(arr_So['tram'].length>=3||arr_So['nghin']>0)
                result+=' '+this.doc3so(arr_So['tram']);
            else if(arr_So['tram'].length>=2)
                result+=' '+this.doc2so(arr_So['tram']);
            else result+=' '+this.doc1so(arr_So['tram']);
        }
    }
    return result;
}

function convertNumberToMoneyText(so) {
    var kytuthapphan=",";
    var result='';
    if(so!=undefined)
    {
        so=" "+so+" ";
        so=so.trim();
        var cautrucso=so.split(kytuthapphan);
        if(cautrucso[0]!=undefined)
        {
            result+=this.docsonguyen(cautrucso[0]);
        }
        if(cautrucso[1]!=undefined)
        {
            //alert(this.docsonguyen(cautrucso[1]));
            result+=' phẩy '+ this.docsonguyen(cautrucso[1]);
        }
    }

    return result;
}