var prefix_gauge = "gauge-";
var title = "", unit = "", filter = "", filterValue = "", maxValue = "";
function showWidgetGauge() {
    var body = "<img src='"+gaugeImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetGauge() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(4),
        h: Math.round(3),
        // noMove: true, noResize: true, locked: true
    };

    while($(`#${prefix_gauge}${count}`).length)
        count++;
    var id = prefix_gauge + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Biểu đồ máy đo")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetGauge(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetGaugeModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editGause")+'"></i>' +
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

    var options = {
        series: [76],
        labels: [''],
        chart: {
            type: 'radialBar',
            offsetY: -20,
            sparkline: {
                enabled: true
            }
        },
        plotOptions: {
            radialBar: {
                startAngle: -90,
                endAngle: 90,
                track: {
                    background: "#e7e7e7",
                    strokeWidth: '97%',
                    margin: 5, // margin is in pixels
                    dropShadow: {
                        enabled: true,
                        top: 2,
                        left: 0,
                        color: '#999',
                        opacity: 1,
                        blur: 2
                    }
                },
                dataLabels: {
                    name: {
                        show: false
                    },
                    value: {
                        offsetY: 25,
                        fontSize: '22px',
                        formatter: function (val) {
                            return "100%";
                        }
                    }
                }
            }
        },
        grid: {
            padding: {
                top: -10
            }
        },
        legend: {
            show: true,
            floating: false,
            horizontalAlign: 'center',
            position: 'bottom'
        },
    };

    var chart = new ApexCharts(document.getElementById(id), options);
    chart.render();

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type', WIDGET.GAUGE.value);
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


function loadWidgetGauge(div, idWidget) {
    validateWidgetGaugeForm();
    $('#editWidgetGaugeModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetGaugeEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetGaugeEditGroup").html(se);
        $("#selectWidgetGaugeEditGroup").val(filterValue).change();
    });
    // getDTs((data) => {
    //     console.log(data);
    //     var se = `<option value="" selected>Chọn</option>`;
    //     for(var i = 0; i < data.length; i++){
    //         se += `<option value="${data[i].id}">${data[i].name}</option>`;
    //     }
    //     $("#selectWidgetGaugeEditDT").html(se);
    //     $("#selectWidgetGaugeEditDT").val(filterValue).change();
    // });

    title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');
    $('#idWidgetGaugeEditTitle').val(title);
    $('#idWidgetGaugeEditTitle').focusout();
    unit = widget.getAttribute('unit') == "null" ? "" : widget.getAttribute('unit');
    $('#idWidgetGaugeEditUnit').val(unit);
    $('#idWidgetGaugeEditUnit').focusout();
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetGaugeEditOption').val(filter).change();
    maxValue = widget.getAttribute("max-value") || "";
    $('#idWidgetGaugeEditMax').val(maxValue);
    $('#idWidgetGaugeEditMax').focusout();
}

function changeOptionWidgetGaugeEdit(op){
    var idWidget = $('#editWidgetGaugeModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetGaugeTable").html("");
    $("#idWidgetGaugeOrg").css("display", "none");
    $("#idWidgetGaugeGroup").css("display", "none");
    $("#idWidgetGaugeDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetGaugeOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetGaugeGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetGaugeDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceGauge();
        filter = "alldevice";
        filterValue = "";
    }
    else
        //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetGaugeEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetGaugeTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetGaugeModal').data('widget-id');
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

    var template = $('#gauge-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetGaugeTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeGroupWidgetGaugeEdit(e){
    if(e.value == ""){
        return;
    }
    $("#idWidgetGaugeTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetGaugeModal').data('widget-id');
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

    var template = $('#gauge-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetGaugeTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeDTWidgetGaugeEdit(e){
    if(e.value == ""){
        return;
    }
    $("#idWidgetGaugeTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetGaugeModal').data('widget-id');
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

    var template = $('#gauge-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetGaugeTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function selectAllDeviceGauge(){
    $("#idWidgetGaugeTable").html("");
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
    $("#idWidgetGaugeTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

function confirmWidgetGauge(){
    if($("#editWidgetGaugeModal form").valid()){
        var devs = $('#idWidgetGaugeTable table tbody tr');
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

        var widgetId = $('#editWidgetGaugeModal').data('widget-id');
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
        widget.setAttribute('filter', filter);
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        widget.setAttribute("filter-value", filterValue);
        widget.setAttribute("data", JSON.stringify(json));
        widget.setAttribute('unit', $('#idWidgetGaugeEditUnit').val());
        widget.setAttribute('title', $('#idWidgetGaugeEditTitle').val());
        widget.setAttribute('max-value', $('#idWidgetGaugeEditMax').val());
        $('#editWidgetGaugeModal').modal('hide');

        // autoSaveWidget();
    }
}

function validateWidgetGaugeForm(){
    $("#editWidgetGaugeModal form").validate({
        ignore: [],
        errorClass: "error",
        rules: {
            idWidgetGaugeEditTitle: {
                required: true,
            },
            // idWidgetGaugeEditUnit: {
            //     required: true
            // },
            idWidgetGaugeEditMax: {
                required: true,
                number: true
            },
            idWidgetGaugeEditOption: {
                required: true
            },
            selectWidgetGaugeEditOrg: {
                required: function(elem){
                    return $('#idWidgetGaugeEditOption').val() == "org";
                }
            },
            selectWidgetGaugeEditGroup: {
                required: function(elem){
                    return $('#idWidgetGaugeEditOption').val() == "group";
                }
            },
            selectWidgetGaugeEditDT: {
                required: function(elem){
                    return $('#idWidgetGaugeEditOption').val() == "devicetype";
                }
            },
            widgetGaugeTableCheckbox: {
                required: function(elem){
                    var checkboxs = $('#idWidgetGaugeTable [type=radio]');
                    if(checkboxs.filter(':checked').length > 0)
                        return false;
                    return true;
                }
            }
        },
        messages: {
            idWidgetGaugeEditTitle: "Tiêu đề không được bỏ trống",
            idWidgetGaugeEditMax: "Giá trị lớn nhất không được bỏ trống",
            idWidgetGaugeEditOption: "Bộ lọc không được bỏ trống",
            selectWidgetGaugeEditOrg: "Chọn tổ chức thiết bị",
            selectWidgetGaugeEditGroup: "Chọn nhóm thiết bị",
            selectWidgetGaugeEditDT: "Chọn loại thiết bị",
            widgetGaugeTableCheckbox: "Chọn một thuộc tính"
        }
    })
}