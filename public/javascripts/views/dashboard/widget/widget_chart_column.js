const prefix_cc = "chart-column-";
var title = "", filter = "", filterValue = "";
function showWidgetChartColumn() {
    var body = "<img src='"+chartColumnImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetChartColumn() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(4),
        h: Math.round(3),
        // noMove: true, noResize: true, locked: true
    };
    while($(`#${prefix_cc}-${count}`).length)
        count++;
    var id = prefix_cc + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("dashboard.chartColumn")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetChartColumn(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetChartColumnModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editChartColumn")+'"></i>' +
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
        series: [{
            name: 'Temperature',
            data: [44, 55, 57, 56, 61, 58]
        }, {
            name: 'Humid',
            data: [76, 85, 101, 98, 87, 105]
        }],
        chart: {
            type: 'bar',
            height: '100%',
            toolbar: {
                show: false
            },
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '55%',
                endingShape: 'rounded'
            },
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            colors: ['transparent']
        },
        xaxis: {
            categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul']
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            y: {
                formatter: function (val) {
                    return val
                }
            }
        }
    };

    var chart = new ApexCharts(document.getElementById(id), options);
    chart.render();

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type',WIDGET.CHART_COLUMN.value);
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


function loadWidgetChartColumn(div, idWidget) {
    validateWidgetChartColumnForm();
    $('#editWidgetChartColumnModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetChartColumnEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetChartColumnEditGroup").html(se);
        $("#selectWidgetChartColumnEditGroup").val(filterValue).change();
    });
    // getDTs((data) => {
    //     console.log(data);
    //     var se = `<option value="" selected>Chọn</option>`;
    //     for(var i = 0; i < data.length; i++){
    //         se += `<option value="${data[i].id}">${data[i].name}</option>`;
    //     }
    //     $("#selectWidgetChartColumnEditDT").html(se);
    //     $("#selectWidgetChartColumnEditDT").val(filterValue).change();
    // });
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetChartColumnEditOption').val(filter).change();
    $('#idWidgetChartColumnEditOption').focusout();
    title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');
    $('#idWidgetChartColumnEditTitle').val(title);
    $('#idWidgetChartColumnEditTitle').focusout();
}

function changeOptionWidgetChartColumnEdit(op){
    var idWidget = $('#editWidgetChartColumnModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetChartColumnTable").html("");
    $("#idWidgetChartColumnOrg").css("display", "none");
    $("#idWidgetChartColumnGroup").css("display", "none");
    $("#idWidgetChartColumnDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetChartColumnOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetChartColumnGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetChartColumnDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceChartColumn();
        filter = "alldevice";
        filterValue = "";
    }
    else
        //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetChartColumnEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetChartColumnTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartColumnModal').data('widget-id');
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

    var template = $('#chart-column-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartColumnTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeGroupWidgetChartColumnEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetChartColumnTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartColumnModal').data('widget-id');
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

    var template = $('#chart-column-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartColumnTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeDTWidgetChartColumnEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetChartColumnTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartColumnModal').data('widget-id');
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

    var template = $('#chart-column-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartColumnTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}


async function selectAllDeviceChartColumn(){
    //console.log(e.value);
    $("#idWidgetChartColumnTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartColumnModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    var dataWidget = JSON.parse(widget.getAttribute("data"));
    filterValue = "";

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

    var template = $('#chart-column-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartColumnTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

function confirmWidgetChartColumn(){
    if($("#editWidgetChartColumnModal form").valid()){
        var devs = $('#idWidgetChartColumnTable table tbody tr');
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
                    console.log(json);
                }
            }

        }

        var widgetId = $('#editWidgetChartColumnModal').data('widget-id');
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
        widget.setAttribute('filter', filter);
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        widget.setAttribute("filter-value", filterValue);
        widget.setAttribute("data", JSON.stringify(json));
        widget.setAttribute('title', $('#idWidgetChartColumnEditTitle').val());
        $('#editWidgetChartColumnModal').modal('hide');

        // autoSaveWidget();
    }

}

function validateWidgetChartColumnForm(){
    $("#editWidgetChartColumnModal form").validate({
        ignore: [],
        errorClass: "error",
        rules: {
            idWidgetChartColumnEditTitle: {
                required: true,
            },
            idWidgetChartColumnEditOption: {
                required: true
            },
            selectWidgetChartColumnEditOrg: {
                required: function(elem){
                    return $('#idWidgetChartColumnEditOption').val() == "org";
                }
            },
            selectWidgetChartColumnEditGroup: {
                required: function(elem){
                    return $('#idWidgetChartColumnEditOption').val() == "group";
                }
            },
            selectWidgetChartColumnEditDT: {
                required: function(elem){
                    return $('#idWidgetChartColumnEditOption').val() == "devicetype";
                }
            },
            widgetChartColumnTableCheckbox: {
                required: function(elem){
                    var checkboxs = $('#idWidgetChartColumnTable [type=checkbox]');
                    if(checkboxs.filter(':checked').length > 0)
                        return false;
                    return true;
                }
            }
        },
        messages: {
            idWidgetChartColumnEditTitle: "Tiêu đề không được bỏ trống",
            idWidgetChartColumnEditOption: "Bộ lọc không được bỏ trống",
            selectWidgetChartColumnEditOrg: "Chọn tổ chức thiết bị",
            selectWidgetChartColumnEditGroup: "Chọn nhóm thiết bị",
            selectWidgetChartColumnEditDT: "Chọn loại thiết bị",
            widgetChartColumnTableCheckbox: "Chọn ít nhất một thuộc tính"
        }
    })
}