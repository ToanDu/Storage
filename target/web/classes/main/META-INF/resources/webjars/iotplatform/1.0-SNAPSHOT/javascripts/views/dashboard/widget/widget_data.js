/**
 * Created by vtk-anhlt166 on 1/13/22.
 */
var prefix_data = "data-";
var title = "", unit = "", filter = "", filterValue = "", maxValue = "";
function showWidgetData() {
    var body = "<img src='"+dataImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetData() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(2),
        h: Math.round(2),
        // noMove: true, noResize: true, locked: true
    };

    while($(`#${prefix_data}${count}`).length)
        count++;
    var id = prefix_data + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Dữ liệu")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetData(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetDataModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editData")+'"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle">' +
        '<div class="map-canvas" id="'+id+'"></div>' +
        '</div>' +
        '</div>';
    node.content = map;
    node.id = id;
    grid.addWidget(node);

    var dateNow = new Date();
    document.getElementById(id).innerHTML =
        // '<image src="'+dataImg+'" width="100%" alt="" />';
        '<div class="card bg-transparent shadow-none mb-0">'+
        '<div class="text-center">'+
        '<h5 class="mt-3 mb-1" style="font-weight: 600;">'+ "80.123" +'</h5>'+
        '<h6 class="mb-3 text-black-50" style="margin-left: 25%;">'+Messages("Unit: %")+'</h6>'+
        '<small class="mt-3 text-black-50">'+moment.unix(dateNow/1000).format("hh:mm DD/MM/YYYY")+'</small>'+
        '</div>'+
        '</div>';

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type', WIDGET.DATA.value);
    $("#edit-"+ id).tooltip();
    count++;

    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    return false;
}


function loadWidgetData(div, idWidget) {
    validateWidgetDataForm();
    $('#editWidgetDataModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetDataEditOrg");

    getGroups((data) => {
        console.log(data);
    var se = `<option value="" selected>Chọn</option>`;
    for(var i = 0; i < data.length; i++){
        se += `<option value="${data[i].id}">${data[i].name}</option>`;
    }
    $("#selectWidgetDataEditGroup").html(se);
    $("#selectWidgetDataEditGroup").val(filterValue).change();
});
//     getDTs((data) => {
//         console.log(data);
//     var se = `<option value="" selected>Chọn</option>`;
//     for(var i = 0; i < data.length; i++){
//         se += `<option value="${data[i].id}">${data[i].name}</option>`;
//     }
//     $("#selectWidgetDataEditDT").html(se);
//     $("#selectWidgetDataEditDT").val(filterValue).change();
// });

    title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');
    $('#idWidgetDataEditTitle').val(title);
    $('#idWidgetDataEditTitle').focusout();
    unit = widget.getAttribute('unit') == "null" ? "" : widget.getAttribute('unit');
    $('#idWidgetDataEditUnit').val(unit);
    $('#idWidgetDataEditUnit').focusout();
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetDataEditOption').val(filter).change();

}

function changeOptionWidgetDataEdit(op){
    var idWidget = $('#editWidgetDataModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetDataTable").html("");
    $("#idWidgetDataOrg").css("display", "none");
    $("#idWidgetDataGroup").css("display", "none");
    $("#idWidgetDataDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetDataOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetDataGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetDataDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceData();
        filter = "alldevice";
        filterValue = "";
    }
    else
    //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetDataEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetDataTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetDataModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByOrg(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;

        var devVars = Array.from(dev.vars);
        devVars.forEach((v) => {
            if(v.type == "string")
            v.disabled = "disabled";
        });
    }
    jsonData.devices = devs;

    var template = $('#data-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetDataTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeGroupWidgetDataEdit(e){
    if(e.value == ""){
        return;
    }
    $("#idWidgetDataTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetDataModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByGroup(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;

        var devVars = Array.from(dev.vars);
        devVars.forEach((v) => {
            if(v.type == "string")
            v.disabled = "disabled";
        });
    }
    jsonData.devices = devs;

    var template = $('#data-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetDataTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeDTWidgetDataEdit(e){
    if(e.value == ""){
        return;
    }
    $("#idWidgetDataTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetDataModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByDT(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;

        var devVars = Array.from(dev.vars);
        devVars.forEach((v) => {
            if(v.type == "string")
            v.disabled = "disabled";
        });
    }
    jsonData.devices = devs;

    var template = $('#Data-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetDataTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function selectAllDeviceData(){
    $("#idWidgetDataTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetDataModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    filterValue = "";
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getAllDevice();
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        dev.vars = dev.attributes;

        var devVars = Array.from(dev.vars);
        devVars.forEach((v) => {
            if(v.type == "string")
            v.disabled = "disabled";
        });
    }
    jsonData.devices = devs;

    var template = $('#data-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetDataTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

function confirmWidgetData(){
    if($("#editWidgetDataModal form").valid()){
        var devs = $('#idWidgetDataTable table tbody tr');
        var json = [];
        for(var i = 0; i < devs.length; i++) {
            var child = devs[i].getElementsByTagName("td");
            for(var j = 1; j < child.length; j++){
                var subChild = child[j].getElementsByTagName("input")[0];
                if(subChild.checked){
                    json.push({
                        "device": child[0].getAttribute("data-id"),
                        "deviceName": child[0].textContent,
                        "var": subChild.getAttribute("data-id"),
                        "varName": subChild.getAttribute("data-name"),
                        "attribute_key": subChild.getAttribute("attribute-key"),
                        "attribute_type": subChild.getAttribute("attribute-type"),
                        "value_type": subChild.getAttribute("value-type"),
                    });
                    break;
                }
            }

        }

        var widgetId = $('#editWidgetDataModal').data('widget-id');
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
        widget.setAttribute('filter', filter);
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        widget.setAttribute("filter-value", filterValue);
        widget.setAttribute("data", JSON.stringify(json));
        widget.setAttribute('unit', $('#idWidgetDataEditUnit').val());
        widget.setAttribute('title', $('#idWidgetDataEditTitle').val());
        $('#editWidgetDataModal').modal('hide');

        // autoSaveWidget();
    }
}

function validateWidgetDataForm(){
    $("#editWidgetDataModal form").validate({
        ignore: [],
        errorClass: "error",
        rules: {
            idWidgetDataEditTitle: {
                required: true,
            },
            // idWidgetDataEditUnit: {
            //     required: true
            // },
            idWidgetDataEditMax: {
                required: true,
                number: true
            },
            idWidgetDataEditOption: {
                required: true
            },
            selectWidgetDataEditOrg: {
                required: function(elem){
                    return $('#idWidgetDataEditOption').val() == "org";
                }
            },
            selectWidgetDataEditGroup: {
                required: function(elem){
                    return $('#idWidgetDataEditOption').val() == "group";
                }
            },
            selectWidgetDataEditDT: {
                required: function(elem){
                    return $('#idWidgetDataEditOption').val() == "devicetype";
                }
            },
            widgetDataTableCheckbox: {
                required: function(elem){
                    var checkboxs = $('#idWidgetDataTable [type=radio]');
                    if(checkboxs.filter(':checked').length > 0)
                        return false;
                    return true;
                }
            }
        },
        messages: {
            idWidgetDataEditTitle: "Tiêu đề không được bỏ trống",
            idWidgetDataEditMax: "Giá trị lớn nhất không được bỏ trống",
            idWidgetDataEditOption: "Bộ lọc không được bỏ trống",
            selectWidgetDataEditOrg: "Chọn tổ chức thiết bị",
            selectWidgetDataEditGroup: "Chọn nhóm thiết bị",
            selectWidgetDataEditDT: "Chọn loại thiết bị",
            widgetDataTableCheckbox: "Chọn một thuộc tính"
        }
    })
}