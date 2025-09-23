/**
 * Created by vtk-anhlt166 on 6/24/22.
 */
//paging
function pagingTable(total, offset, limit) {
    console.log("total : " + total);
    console.log("offset : " + offset);
    console.log("limit : " + limit);
    var paging =
        '<ul class="pagination" style="float: right!important; margin: 0px 0;">';

    if(offset > 1){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch(1,'+limit+',false)"> << </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset-1)+','+limit+',false)"> < </a></li>';
    }

    for(var item = 1; item < 2; item++){
        if( (offset - item) >0){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset-item)+','+limit+',false)">'+(offset - item)+'</a></li>'
        }
    }

    paging+= '<li class="paginate_button page-item active"><a class="page-link" onclick="applySearch('+offset+','+limit+',false)">'+offset+'</a></li>';

    var getTotalPage = Math.floor(total/limit);
    if(total%limit >= 1){
        getTotalPage++;
    }
    for(var item = 1; item < 2; item++){
        if( (offset + item)*limit <= total){
            paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset+item)+','+limit+',false)">'+(offset + item)+'</a></li>'
        }
    }

    if(offset*limit < total){
        paging += '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+(offset+1)+','+limit+',false)"> > </a></li>'+
            '<li class="paginate_button page-item "><a class="page-link" onclick="applySearch('+getTotalPage+','+limit+',false)"> >> </a></li>';
    }

    paging += '</ul>';

    $("#pagingTable").html(paging);
}

function applySearch(page, pageSize, isResetPage) {
    console.log(page, pageSize, isResetPage);

    $('[name=page]').val(page);
    $('[name=pageSize]').val(pageSize);

    selectTabDeviceOfOrg(currentSelectedGroup.id);
}