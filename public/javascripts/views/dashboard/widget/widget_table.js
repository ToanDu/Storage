const prefix_table = "table-";
var filter = "", filterValue = "";
function showWidgetTable() {
    var body = "<img src='"+tableImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetTable() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(4),
        h: Math.round(3),
        // noMove: true, noResize: true, locked: true
    };
    while($(`#${prefix_table}${count}`).length)
        count++;
    var id = prefix_table + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Bảng dữ liệu")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetTable(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetTableModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editTable")+'"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 15px">' +
        '<div class="map-canvas" id="'+id+'"></div>' +
        '</div>' +
        '</div>';
    node.content = map;
    node.id = id;
    grid.addWidget(node);

    document.getElementById(id).innerHTML = `<table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Device</th>
          <th scope="col">Data</th>
          <th scope="col">Time</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Light</td>
          <td>128,255,255</td>
          <td>8/24/2021, 4:50:42 PM</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Smoke</td>
          <td>1</td>
          <td>8/24/2021, 4:50:43 PM</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Switch</td>
          <td>ON</td>
          <td>8/24/2021, 4:51:42 PM</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Switch</td>
          <td>OFF</td>
          <td>8/24/2021, 4:51:43 PM</td>
        </tr>
      </tbody>
    </table>`;

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type', WIDGET.TABLE.value);
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


function loadWidgetTable(div, idWidget) {
    validateWidgetTableForm();
    $('#editWidgetTableModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetTableEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetTableEditGroup").html(se);
        $("#selectWidgetTableEditGroup").val(filterValue).change();
    });
    // getDTs((data) => {
    //     console.log(data);
    //     var se = `<option value="" selected>Chọn</option>`;
    //     for(var i = 0; i < data.length; i++){
    //         se += `<option value="${data[i].id}">${data[i].name}</option>`;
    //     }
    //     $("#selectWidgetTableEditDT").html(se);
    //     $("#selectWidgetTableEditDT").val(filterValue).change();
    // });
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetTableEditOption').val(filter).change();
    $('#idWidgetTableEditOption').focusout();
    title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');
    $('#idWidgetTableEditTitle').val(title);
    $('#idWidgetTableEditTitle').focusout();
}

function changeOptionWidgetTableEdit(op){
    var idWidget = $('#editWidgetTableModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetTableTable").html("");
    $("#idWidgetTableOrg").css("display", "none");
    $("#idWidgetTableGroup").css("display", "none");
    $("#idWidgetTableDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetTableOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetTableGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetTableDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceTable();
        filter = "alldevice";
        filterValue = "";
    }
    else
        //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetTableEdit(e) {
    console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetTableTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetTableModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByOrg(e.value);
    console.log(devs);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;
    }
    jsonData.devices = devs;

    var template = $('#table-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetTableTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        // console.log(widgetId, d);
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeGroupWidgetTableEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetTableTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetTableModal').data('widget-id');
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
    }
    jsonData.devices = devs;

    var template = $('#table-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetTableTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        console.log(widgetId, d);
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeDTWidgetTableEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetTableTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetTableModal').data('widget-id');
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
    }
    jsonData.devices = devs;

    var template = $('#table-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetTableTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        console.log(widgetId, d);
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function selectAllDeviceTable(){
    $("#idWidgetTableTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetTableModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    filterValue = "";
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getAllDevice();
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;
    }
    jsonData.devices = devs;

    var template = $('#table-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetTableTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        console.log(widgetId, d);
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

function confirmWidgetTable(){
    if($("#editWidgetTableModal form").valid()){
        var devs = $('#idWidgetTableTable table tbody tr');
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
                }
            }

        }

        var widgetId = $('#editWidgetTableModal').data('widget-id');
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
        widget.setAttribute('filter', filter);
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        widget.setAttribute("filter-value", filterValue);
        widget.setAttribute("data", JSON.stringify(json));
        widget.setAttribute('title', $('#idWidgetTableEditTitle').val());
        $('#editWidgetTableModal').modal('hide');

        // autoSaveWidget();
    }

}


function validateWidgetTableForm(){
    $("#editWidgetTableModal form").validate({
        ignore: [],
        errorClass: "error",
        rules: {
            idWidgetTableEditTitle: {
                required: true,
            },
            idWidgetTableEditOption: {
                required: true
            },
            selectWidgetTableEditOrg: {
                required: function(elem){
                    return $('#idWidgetTableEditOption').val() == "org";
                }
            },
            selectWidgetTableEditGroup: {
                required: function(elem){
                    return $('#idWidgetTableEditOption').val() == "group";
                }
            },
            selectWidgetTableEditDT: {
                required: function(elem){
                    return $('#idWidgetTableEditOption').val() == "devicetype";
                }
            },
            widgetTableTableCheckbox: {
                required: function(elem){
                    var checkboxs = $('#idWidgetTableTable [type=checkbox]');
                    if(checkboxs.filter(':checked').length > 0)
                        return false;
                    return true;
                }
            }
        },
        messages: {
            idWidgetTableEditTitle: "Tiêu đề không được bỏ trống",
            idWidgetTableEditOption: "Bộ lọc không được bỏ trống",
            selectWidgetTableEditOrg: "Chọn tổ chức thiết bị",
            selectWidgetTableEditGroup: "Chọn nhóm thiết bị",
            selectWidgetTableEditDT: "Chọn loại thiết bị",
            widgetTableTableCheckbox: "Chọn ít nhất một thuộc tính"
        }
    })
}