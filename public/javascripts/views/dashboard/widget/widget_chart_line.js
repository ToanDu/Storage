var prefix_cl = "chart-line-";
var title = "", filter = "", filterValue = "";
function showWidgetChartLine() {
    var body = "<img src='"+chartLineImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetChartLine() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(4),
        h: Math.round(3),
    };
    while($(`#${prefix_cl}${count}`).length)
        count++;
    var id = prefix_cl + count;

    var map = '<div class="card-body" style="height: 100%; overflow: hidden">' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("Biểu đồ đường")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetChartLine(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" data-bs-toggle="modal" data-bs-target="#editWidgetChartLineModal" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editChartLine")+'"></i>' +
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
            name: "Test",
            data: [23, 25, 30, 32, 35, 37, 33, 20, 19]
        }],
        chart: {
            height: '100%',
            type: 'line',
            zoom: {
                enabled: false
            },
            toolbar: {
                show: false
            },
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            curve: 'straight'
        },
        grid: {
            row: {
                colors: ['#f3f3f3', 'transparent'],
                opacity: 0.5
            },
        },
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
        }
    };

    var chart = new ApexCharts(document.getElementById(id), options);
    chart.render();

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type',WIDGET.CHART_LINE.value);
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


function loadWidgetChartLine(div, idWidget) {
    validateWidgetChartLineForm();

    // console.log(div);
    $('#editWidgetChartLineModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";

    getOrgs("selectWidgetChartLineEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetChartLineEditGroup").html(se);
        $("#selectWidgetChartLineEditGroup").val(filterValue).change();
    });
    // getDTs((data) => {
    //     console.log(data);
    //     var se = `<option value="" selected>Chọn</option>`;
    //     for(var i = 0; i < data.length; i++){
    //         se += `<option value="${data[i].id}">${data[i].name}</option>`;
    //     }
    //     $("#selectWidgetChartLineEditDT").html(se);
    //     $("#selectWidgetChartLineEditDT").val(filterValue).change();
    // });
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetChartLineEditOption').val(filter).change();
    $('#idWidgetChartLineEditOption').focusout();
    title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');

    $('#idWidgetChartLineEditTitle').val(title);
    $('#idWidgetChartLineEditTitle').focusout();
}

function changeOptionWidgetChartLineEdit(op){
    var idWidget = $('#editWidgetChartLineModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetChartLineTable").html("");
    $("#idWidgetChartLineOrg").css("display", "none");
    $("#idWidgetChartLineGroup").css("display", "none");
    $("#idWidgetChartLineDT").css("display", "none");
    $('.table-loading').hide();
    if(op == "org"){
        $("#idWidgetChartLineOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetChartLineGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetChartLineDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        selectAllDeviceChartLine();
        filter = "alldevice";
        filterValue = "";
    }
    else
        //widget.setAttribute('filter', "");
        filter = "";
}

async function changeOrgWidgetChartLineEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        //$("#idWidgetChartLineTable").html("");
        return;
    }
    $("#idWidgetChartLineTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartLineModal').data('widget-id');
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

    var template = $('#chart-line-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartLineTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeGroupWidgetChartLineEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        //$("#idWidgetChartLineTable").html("");
        return;
    }
    $("#idWidgetChartLineTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartLineModal').data('widget-id');
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

    var template = $('#chart-line-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartLineTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function changeDTWidgetChartLineEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        //$("#idWidgetChartLineTable").html("");
        return;
    }
    $("#idWidgetChartLineTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartLineModal').data('widget-id');
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

    var template = $('#chart-line-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartLineTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
    }
    $('.table-loading').hide();
}

async function selectAllDeviceChartLine(){
    //console.log(e.value);
    $("#idWidgetChartLineTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetChartLineModal').data('widget-id');
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

    var template = $('#chart-line-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetChartLineTable").html(render);

    for (var key in dataWidget) {
        var d = dataWidget[key];
        $(`#${widgetId}-${d.attribute_key}`).prop("checked", true);
        //$(`#${widgetId}-${d.var}`).attr('selected','selected');
    }

    // for(var i = 0; i < devs.length; i++){
    //     var dev = devs[i];
    //     $(`#${widgetId}-${dev.id}`).select2({
    //         width: '100%'
    //     });
    // }

    $('.table-loading').hide();
}

function confirmWidgetChartLine(){
    if($("#editWidgetChartLineModal form").valid()){
        var devs = $('#idWidgetChartLineTable table tbody tr');
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
        // var selects = $('#idWidgetChartLineTable select');
        // selects.each((_, sel) => {
        //     let val = $(sel).val();
        //     if(val.length > 0){
        //         json.push({
        //             "device": sel.getAttribute("data-id"),
        //             "deviceName": sel.getAttribute("data-name"),
        //             // "var": subChild.getAttribute("data-id"),
        //             // "varName": subChild.getAttribute("data-name")\
        //             "variables": val
        //         });
        //     }
        // });


        var widgetId = $('#editWidgetChartLineModal').data('widget-id');
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
        widget.setAttribute('filter', filter);
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        widget.setAttribute("filter-value", filterValue);
        widget.setAttribute("data", JSON.stringify(json));
        widget.setAttribute('title', $('#idWidgetChartLineEditTitle').val());
        $('#editWidgetChartLineModal').modal('hide');

        // autoSaveWidget();
    }
}

function validateWidgetChartLineForm(){
    $("#editWidgetChartLineModal form").validate({
        ignore: [],
        errorClass: "error",
        rules: {
            idWidgetChartLineEditTitle: {
                required: true,
            },
            idWidgetChartLineEditOption: {
                required: true
            },
            selectWidgetChartLineEditOrg: {
                required: function(elem){
                    return $('#idWidgetChartLineEditOption').val() == "org";
                }
            },
            selectWidgetChartLineEditGroup: {
                required: function(elem){
                    return $('#idWidgetChartLineEditOption').val() == "group";
                }
            },
            selectWidgetChartLineEditDT: {
                required: function(elem){
                    return $('#idWidgetChartLineEditOption').val() == "devicetype";
                }
            },
            widgetChartLineTableCheckbox: {
                required: function(elem){
                    var checkboxs = $('#idWidgetChartLineTable  [type=checkbox]');
                    if(checkboxs.filter(':checked').length > 0)
                        return false;
                    return true;
                }
            }
        },
        messages: {
            idWidgetChartLineEditTitle: "Tiêu đề không được bỏ trống",
            idWidgetChartLineEditOption: "Bộ lọc không được bỏ trống",
            selectWidgetChartLineEditOrg: "Chọn tổ chức thiết bị",
            selectWidgetChartLineEditGroup: "Chọn nhóm thiết bị",
            selectWidgetChartLineEditDT: "Chọn loại thiết bị",
            widgetChartLineTableCheckbox: "Chọn ít nhất một thuộc tính"
        }
    })
}