/**
 * Created by vtk-anhlt166 on 11/15/22.
 */
var STATUS_ACCOUNT = {
    UNKNOWN: {value: -1, name: "Không xác định"},
    NEW: {value: 1, name: "Mới tiếp nhận"},
    ACTIVE: {value: 2, name: "Hoạt động"},
    CANCLE: {value: 3, name: "Đã huỷ"}
};
$(document).ready(function () {
    if(view_contract == "true"){
        getListAccountContract();
    }
});

$(document).keypress(function(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        if(view_contract == "true"){
            getListAccountContract();
        }
    }
});

function onlickButtonSearch() {
    $("#page").val(1);
    getListAccountContract();
}
function getListAccountContract() {
    console.log("click herreeee")
    var body = new FormData();
    body.userId = userId;
    body.accountId = $('#accountId').val().trim();
    body.accountNo = $('#accountNo').val().trim();
    body.page = $("#page").val();
    body.pageSize = $("#pageSize").val();
    console.log("***********************");
    console.log(body);
    console.log("***********************");
    StartProcess();
    $("#total_record").html(0);
    $("#pagingTable").empty()
    var r = jsRoutes.controllers.TelcoContractController.getListAccountContract();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log("***********************");
            console.log(datas);
            console.log("************************");

            if(datas.success){
                var startAt = (body.page - 1)*body.pageSize;
                $("#total_record").html(datas.content?.countAccount || 0);
                viewContractToTable(datas.content, startAt, body.page, body.pageSize);
            }else{
                $("#listContractTable").find('tbody').html("");
                $("#notiNotDataContract").html("Không có thông tin để hiển thị");
                showNotification('danger',datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
            $("#listContractTable").find('tbody').html("");
            $("#notiNotDataContract").html("Không có thông tin để hiển thị");
        },
        complete: function (){
            FinishProcess();
            // getTotalContract(body.page, body.pageSize);
        }
    })
}

function viewContractToTable(data, startAt, page, pageSize) {
    var body = "";
    var listAccountDTO = data.listAccountDTO;
    if (listAccountDTO != null && listAccountDTO.length > 0) {
        $("#notiNotDataContract").html("");
        for (var i = 0; i < listAccountDTO.length; i++) {
            // var r = jsRoutes.controllers.TelcoInvoiceController.invoiceOfContract(listAccountDTO[i].accountID);
            // var idTooltip = "tooltip_"+listSubscriber[i].isdn;
            body += "<tr>";
            body += "<th>"+(startAt+i+1)+"</th>";
            if(view_detail_contract == "true"){
                body += "<td>" + '<a class="tb cursor-pointer" onclick="showInfoContact(\''+listAccountDTO[i].accountID+'\', \''+listAccountDTO[i].accountNo+'\', \''+listAccountDTO[i].status+'\', \''+listAccountDTO[i].payType+'\')">'+ listAccountDTO[i].accountID +'</a>' + "</td>";
            } else {
                body += "<td>" + listAccountDTO[i].accountID + "</td>";
            }
            body += "<td class='wrap-text'>" + listAccountDTO[i].accountNo + "</td>";
            body += "<td class='wrap-text'>" + getStatusByCode(listAccountDTO[i].status) + "</td>";
            body += "<td class='wrap-text'>" + (listAccountDTO[i].effectDate.length > 0 ? moment(moment(listAccountDTO[i].effectDate, "YYYY-MM-DD'T'HH:mm:ss+07:00")).format('HH:mm DD/MM/YYYY') : "") + "</td>";
            body += "<td class='wrap-text'>" + listAccountDTO[i].isdn + "</td>";
            body += "<td class='wrap-text'>" + listAccountDTO[i].address + "</td>";
            console.log(typeof(isViewInvoice));
            if(isViewInvoice=="true"){
                body += "<td class='wrap-text'>" + '<a class="btn-tb cursor-pointer" onclick="remotePageInvoice(\''+listAccountDTO[i].accountID+'\')">'+Messages("contract.js.checkInvoice")+'</a>' + "</td>";
            }
            body += "</tr>";
        }
    } else {
        $("#notiNotDataContract").html("Không có thông tin để hiển thị");
    }
    $("#listContractTable").find('tbody').html(body);
    const pagingHtml = paging2HTML(data.countAccount, page, pageSize, applySearch);
    $("#pagingTable").html(pagingHtml);
    // pagingTable(data.countAccount, page, pageSize);
}

//paging
function pagingTable(total, page, pageSize) {
    var paging =
        '<label class="col-form-label" style="font-weight: 400;font-size: 14px;color: #727272;margin-right: 15px;">'+Messages("contract.table.totalRecordsPrefix")+' '+total+' '+Messages("contract.table.totalRecordsSuffix")+'</label>' +
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(page > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+pageSize+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-1)+','+pageSize+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (parseInt(page) - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)-item)+','+pageSize+',false)">'+(parseInt(page) - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+parseInt(page)+','+pageSize+',false)">'+page+'</a></li>';

    var getTotalPage = Math.floor(total/pageSize);
    if(total%pageSize >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (parseInt(page) + item)*pageSize <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+item)+','+pageSize+',false)">'+(parseInt(page) + item)+'</a></li>'
        }
    }

    if(parseInt(page)*pageSize < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(parseInt(page)+1)+','+pageSize+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+pageSize+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);

    //an phan trang neu so ban ghi it hon 1 trang
    // if(total <= pageSize){
    //     document.getElementById("divPagingTable").style.display = 'none';
    // } else {
    //     document.getElementById("divPagingTable").style.display = 'block';
    // }
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    getListAccountContract();
}

function ApplyFilter(page, pageSize, isResetPage) {
    $("#countPageSize").html(pageSize);
    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize );

    getListAccountContract();
}

function resetFormSearch() {
    console.log("resetFormSearch");
    // $("#numberSubs").tagsinput('removeAll');
    // $("#serialSim").tagsinput('removeAll');
    // $("#accountId").tagsinput('removeAll');
    $("#accountId").val('');
    $("#accountNo").val('');
    getListAccountContract();
}

function remotePageInvoice(invoice) {
    console.log(invoice);
    window.open(jsRoutes.controllers.TelcoInvoiceController.invoiceOfContract(userId, invoice).url, "_blank");
}

function getStatusByCode(code) {
    code = parseInt(code);

    if(code == STATUS_ACCOUNT.NEW.value){
        return STATUS_ACCOUNT.NEW.name;
    } else if(code == STATUS_ACCOUNT.ACTIVE.value){
        return STATUS_ACCOUNT.ACTIVE.name;
    }  else if(code == STATUS_ACCOUNT.CANCLE.value){
        return STATUS_ACCOUNT.CANCLE.name;
    } else {
        return STATUS_ACCOUNT.UNKNOWN.name;
    }
}

function paging2HTML(total, page, pageSize, handleSearch = () => {}) {
  let paging = `<ul class="pagination mb-0 gap-10 justify-content-center justify-content-md-end" id="pagination_custom">`;
  let currentPage = parseInt(page);
  let totalPage = Math.ceil(total / pageSize);

  if (currentPage > 1) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(1, ${pageSize})">
                    <i class="bx bx-chevrons-left"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage - 1
    }, ${pageSize})">
                    <i class="bx bx-chevron-left"></i>
                </a>
                </li>`;
  }

  if (currentPage - 1 > 0) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage - 1
    }, ${pageSize})">${currentPage - 1}</a>
                </li>`;
  }

  paging += `
            <li class="paginate_button page-item active">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${currentPage}, ${pageSize})">${currentPage}</a>
            </li>`;

  if (currentPage + 1 <= totalPage) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage + 1
    }, ${pageSize})">${currentPage + 1}</a>
                </li>`;
  }

  if (currentPage < totalPage) {
    paging += `
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${
      currentPage + 1
    }, ${pageSize})">
                    <i class="bx bx-chevron-right"></i>
                </a>
                </li>
                <li class="paginate_button page-item">
                <a class="page-link cursor-pointer rounded-3" onclick="(${handleSearch})(${totalPage}, ${pageSize})">
                    <i class="bx bx-chevrons-right"></i>
                </a>
                </li>`;
  }

  paging += "</ul>";
  return paging;
}