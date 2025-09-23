/**
 * Created by vtk-anhlt166 on 11/1/22.
 */
var prefix_command = "command-";
function addWidgetCommand() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(6),
        h: Math.round(4)
        // noMove: true, noResize: true, locked: true
    };

    while($(`#${prefix_command}${count}`).length)
        count++;
    var id = prefix_command + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Command")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetCommand(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetCommandModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top"></i>' +
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

    document.getElementById(id).innerHTML =
        '<div class="console">'+
        '<div class="consolebody">'+
        '<p>please enter the command sent to the device</p>'+
        '<p>>_</p>'+
        '</div>'+
        '</div>';

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type', WIDGET.COMMAND.value);
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

function loadWidgetCommand(div, idWidget) {
    $('#editWidgetCommandModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetCommandEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetCommandEditGroup").html(se);
        $("#selectWidgetCommandEditGroup").val(filterValue).change();
    });


    title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');
    $('#idWidgetCommandEditTitle').val(title);
    $('#idWidgetCommandEditTitle').focusout();
    unit = widget.getAttribute('unit') == "null" ? "" : widget.getAttribute('unit');
    $('#idWidgetCommandEditUnit').val(unit);
    $('#idWidgetCommandEditUnit').focusout();
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetCommandEditOption').val(filter).change();

}

function changeOptionWidgetCommandEdit(op){
    var idWidget = $('#editWidgetCommandModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetCommandTable").html("");
    $("#idWidgetCommandOrg").css("display", "none");
    $("#idWidgetCommandGroup").css("display", "none");
    $("#idWidgetCommandDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetCommandOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetCommandGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetCommandDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceCommand();
        filter = "alldevice";
        filterValue = "";
    }
    else
    //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetCommandEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetCommandTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetCommandModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByOrg(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        //dev.vars = await getVarsByDevice(dev.id);
        // dev.vars = dev.attributes;
    //
    //     var devVars = Array.from(dev.vars);
    //     devVars.forEach((v) => {
    //         if(v.type == "string")
    //     v.disabled = "disabled";
    // });
    }
    jsonData.devices = devs;

    var template = $('#command-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetCommandTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function selectAllDeviceCommand(){
    $("#idWidgetCommandTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetCommandModal').data('widget-id');
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

    var template = $('#command-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetCommandTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

function confirmWidgetCommand(){
    var json = [];
    json.push({
        "device": $('#selectWidgetCommandEditDevice :selected').val(),
        "deviceName": $('#selectWidgetCommandEditDevice :selected').text()
    });
    console.log(json);

    var widgetId = $('#editWidgetCommandModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    widget.setAttribute('filter', filter);
    widget.setAttribute("filter-value", filterValue);
    widget.setAttribute("data", JSON.stringify(json));
    widget.setAttribute('title', Messages("Command: ") + $('#selectWidgetCommandEditDevice :selected').text());
    $('#editWidgetCommandModal').modal('hide');
}