var prefix_round_switch = "round-switch-";
var filter = "";
var filterValue = "";
function showWidgetRoundSwitch() {
    var body = "<img src='"+roundSwitchImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetRoundSwitch() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(3),
        h: Math.round(2),
        // noMove: true, noResize: true, locked: true
    };

    while($(`#${prefix_round_switch}${count}`).length)
        count++;
    var id = prefix_round_switch + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Công tắc")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick= "loadWidgetRoundSwitch(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetRoundSwitchModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editRoundSwitch")+'"></i>' +
        '<i class="bx bx-x-circle" data-bs-toggle="modal" data-bs-target="#deleteWidgetConfirm" onclick="removeWidget(\''+id+'\')"></i>' +
        '</div>' +
        '</div>' +
        '<div class="paper-middle" style="margin-top: 5px">' +
        '<div class="map-canvas" id="'+id+'"></div>' +
        '</div>' +
        '</div>';
    node.content = map;
    node.id = id;
    grid.addWidget(node);

    // document.getElementById(id).innerHTML = `<div class="round-switch demo1">
    //                         <input type="checkbox">
    //                         <label></label>
    //                     </div>`;
    document.getElementById(id).innerHTML =
        '<div class="toggle toggle--text">'+
        '<input id="" class="toggle--checkbox" type="checkbox" checked>'+
        '<label class="toggle--btn" for="" data-label-on="on" data-label-off="off"></label>'+
        '</div>';

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type', WIDGET.ROUND_SWITCH.value);
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

function loadWidgetRoundSwitch(div, idWidget) {
    $('#editWidgetRoundSwitchModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetRoundSwitchEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetRoundSwitchEditGroup").html(se);
        $("#selectWidgetRoundSwitchEditGroup").val(filterValue).change();
    });
    // getDTs((data) => {
    //     console.log(data);
    //     var se = `<option value="" selected>Chọn</option>`;
    //     for(var i = 0; i < data.length; i++){
    //         se += `<option value="${data[i].id}">${data[i].name}</option>`;
    //     }
    //     $("#selectWidgetRoundSwitchEditDT").html(se);
    //     $("#selectWidgetRoundSwitchEditDT").val(filterValue).change();
    // });

    filter = widget.getAttribute("filter") || "";
    $('#idWidgetRoundSwitchEditOption').val(filter).change();

    console.log(widget);
    var topic = widget.getAttribute('topic') == "null" ? "" : widget.getAttribute('topic');
    $('#widgetRoundSwitchTopic').val(topic);
    $('#widgetRoundSwitchTopic').focusout();
    var on = widget.getAttribute('cmdon') == "null" ? "" : widget.getAttribute('cmdon');
    $('#widgetRoundSwitchOn').val(on);
    $('#widgetRoundSwitchOn').focusout();
    var off = widget.getAttribute('cmdoff') == "null" ? "" : widget.getAttribute('cmdoff');
    $('#widgetRoundSwitchOff').val(off);
    $('#widgetRoundSwitchOff').focusout();
}

function changeOptionWidgetRoundSwitchEdit(op){
    var idWidget = $('#editWidgetRoundSwitchModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetRoundSwitchOrg").css("display", "none");
    $("#idWidgetRoundSwitchGroup").css("display", "none");
    $("#idWidgetRoundSwitchDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetRoundSwitchOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetRoundSwitchGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetRoundSwitchDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceRoundSwitch();
        filter = "alldevice";
        filterValue = "";
    }
    else
    //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetRoundSwitchEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        $("#idWidgetRoundSwitchTable").html("");
        return;
    }
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetRoundSwitchModal').data('widget-id');
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

    var template = $('#round-switch-edit-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetRoundSwitchTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeGroupWidgetRoundSwitchEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        $("#idWidgetRoundSwitchTable").html("");
        return;
    }
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetRoundSwitchModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByGroup(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        dev.selected = "";

        for (var key in dataWidget) {
            var d = dataWidget[key];
            if(d.device == dev.id)
                dev.selected = "selected";
        }
    }
    jsonData.devices = devs;

    var template = $('#round-switch-edit-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetRoundSwitchTable").html(render);

    $('.table-loading').hide();
}

async function changeDTWidgetRoundSwitchEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        $("#idWidgetRoundSwitchTable").html("");
        return;
    }
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetRoundSwitchModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    //widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByDT(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        dev.wid = widgetId;
        dev.selected = "";

        for (var key in dataWidget) {
            var d = dataWidget[key];
            if(d.device == dev.id)
                dev.selected = "selected";
        }
    }
    jsonData.devices = devs;

    var template = $('#round-switch-edit-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetRoundSwitchTable").html(render);

    $('.table-loading').hide();
}

async function selectAllDeviceRoundSwitch(){
    $("#idWidgetRoundSwitchTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetGaugeModal').data('widget-id');
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

    var template = $('#gauge-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetRoundSwitchTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

function confirmWidgetRoundSwitch(){
    var devs = $('#idWidgetRoundSwitchTable table tbody tr');
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
    console.log(json);
    if(isJsonString($('#widgetRoundSwitchOn').val()) && isJsonString($('#widgetRoundSwitchOff').val())){

    } else {
        showNotification('danger', Messages("Bản tin bật/tắt chưa đúng định dạng json"));
        return;
    }

    var widgetId = $('#editWidgetRoundSwitchModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    widget.setAttribute('filter', filter);
    widget.setAttribute("filter-value", filterValue);
    widget.setAttribute("data", JSON.stringify(json));
    widget.setAttribute('title', Messages("Công tắc: ") + $('#selectWidgetRoundSwitchEditDevice :selected').text());
    widget.setAttribute("topic", $('#widgetRoundSwitchTopic').val());
    widget.setAttribute("cmdon", $('#widgetRoundSwitchOn').val());
    widget.setAttribute("cmdoff", $('#widgetRoundSwitchOff').val());
    $('#editWidgetRoundSwitchModal').modal('hide');
}

function isJsonString(str) {
    try {
        var o = JSON.parse(str);
        if (o && typeof o === "object") {
            return o;
        }
    } catch (e) {

    }
    return false;
}