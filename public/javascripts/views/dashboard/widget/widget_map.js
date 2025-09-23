const prefix_map = "map-";
var filter = "", filterValue = "";

function showWidgetMap() {
    var body = "<img src='"+ggmapImg+"' style='width: 100%;'><hr>";
    $("#bodyWidget").html(body);
}

function addWidgetMap() {
    var node = {
        x: Math.round(x),
        y: Math.round(y),
        w: Math.round(6),
        h: Math.round(5),
        // noMove: true, noResize: true, locked: true
    };
    while($("#map-canvas-"+count).length)
        count++;
    var id = "map-canvas-"+count;
    var map = '<div class="card-body" style="height: 100%; overflow: hidden">\n' +
        '<div class="d-flex align-items-center">' +
        '<div>' +
        '<h6 class="mb-0 text-dark">'+Messages("dashboard.map")+'</h6>' +
        '</div>' +
        '<div class="font-22 ms-auto cursor-pointer text-dark">' +
        '<i class="bx bx-edit" onclick="loadWidgetMap(this.parentNode.parentNode.parentNode.parentNode.parentNode, \''+id+'\')" style="margin-right: 5px" id="edit-'+id+'" data-bs-toggle="tooltip" data-bs-placement="top" title="'+Messages("widget.editMap")+'"></i>' +
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

    var initLatLng = new google.maps.LatLng(21.025703, 105.832758);
    var mapOptions = {
        center: initLatLng,
        zoom: 12,
        zoomControl: false,
        // zoomControlOptions: {
        //     position: google.maps.ControlPosition.RIGHT_BOTTOM
        // },
        // mapTypeControlOptions: {
        //     position: google.maps.ControlPosition.TOP_RIGHT
        // },
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        fullscreenControl: false,
        // fullscreenControlOptions: {
        //     position: google.maps.ControlPosition.RIGHT_BOTTOM
        // },
        gestureHandling: 'greedy'
    };
    var mapPosition = new google.maps.Map(document.getElementById('map-canvas-'+count), mapOptions);

    //add data
    $('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('type',WIDGET.MAP.value);
    count++;
    $("#edit-"+ id).tooltip();

    if(x+w < 12){
        x = x+w;
    } else {
        x = 0;
        y = y+h;
    }

    return false;
}

function loadWidgetMap(div, idWidget) {
    $("#editWidgetMapModal").modal('show');

    validateWidgetMapForm();
    $('#editWidgetMapModal').data('widget-id', idWidget);

    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    filterValue = widget.getAttribute("filter-value") || "";
    getOrgs("selectWidgetMapEditOrg");

    getGroups((data) => {
        console.log(data);
        var se = `<option value="" selected>Chọn</option>`;
        for(var i = 0; i < data.length; i++){
            se += `<option value="${data[i].id}">${data[i].name}</option>`;
        }
        $("#selectWidgetMapEditGroup").html(se);
        $("#selectWidgetMapEditGroup").val(filterValue).change();
    });
    // getDTs((data) => {
    //     console.log(data);
    //     var se = `<option value="" selected>Chọn</option>`;
    //     for(var i = 0; i < data.length; i++){
    //         se += `<option value="${data[i].id}">${data[i].name}</option>`;
    //     }
    //     $("#selectWidgetMapEditDT").html(se);
    //     $("#selectWidgetMapEditDT").val(filterValue).change();
    // });
    filter = widget.getAttribute("filter") || "";
    $('#idWidgetMapEditOption').val(filter).change();

    var title = widget.getAttribute('title') == "null" ? "" : widget.getAttribute('title');
    $('#idWidgetMapEditTitle').val(title);
    var typeMap = widget.getAttribute('typeMap') == "null" ? "" : widget.getAttribute('typeMap');
    console.log(typeMap);
    $('#typeWidgetMapEdit').val(typeMap);

    $('#idWidgetMapEditTitle').focusout();
}

function changeOptionWidgetMapEdit(op){
    var idWidget = $('#editWidgetMapModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+idWidget+'"]')[0];
    op = op.value;
    $("#idWidgetMapOrg").css("display", "none");
    $("#idWidgetMapGroup").css("display", "none");
    $("#idWidgetMapDT").css("display", "none");
    $('.table-loading').hide();
    // if(op == "all"){
    //     widget.setAttribute('filter', "all");
    //     widget.setAttribute('filter-value', "");
    //     widget.setAttribute('data', "[]");
    // }
    if(op == "org"){
        $("#idWidgetMapOrg").css("display", "block");
        //widget.setAttribute('filter', "org");
        filter = "org";
    }
    else if(op == "group"){
        $("#idWidgetMapGroup").css("display", "block");
        //widget.setAttribute('filter', "group");
        filter = "group";
    }
    else if(op == "devicetype"){
        $("#idWidgetMapDT").css("display", "block");
        //widget.setAttribute('filter', "devicetype");
        filter = "devicetype";
    }
    else if(op == "alldevice"){
        filter = "alldevice";
        filterValue = "";
    }
    else{
        //widget.setAttribute('filter', "");
        filter = "";
    }
    $("#idWidgetMapTable").html("");
}

async function changeOrgWidgetMapEdit(e) {
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetMapTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetMapModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    // widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByOrg(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;
        dev.isActive = false;
        dev.disabled = "disabled";
        if(dev.vars != undefined && dev.vars.length)
        {
            dev.isActive = true;
            dev.disabled = "";
            var devVars = Array.from(dev.vars);
            devVars.forEach((v) => {
                if(v.type == "string")
                    v.disabled = "disabled";

                // console.log(dataWidget);
                for (var key in dataWidget) {
                    var d = dataWidget[key];
                    if(d.device == dev.id){
                        if(d.lat == v.attribute_key)
                            v.latSelected = "selected";
                        if(d.long == v.attribute_key)
                            v.longSelected = "selected";
                    }
                }
            });
        }
    }
    jsonData.devices = devs;
    console.log(jsonData);

    var template = $('#map-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetMapTable").html(render);
    $('.table-loading').hide();
}

async function changeGroupWidgetMapEdit(e){
    //console.log(e.value);
    if(e.value == ""){
        return;
    }
    $("#idWidgetMapTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetMapModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    // widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByGroup(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;
        dev.isActive = false;
        dev.disabled = "disabled";
        if(dev.vars != undefined && dev.vars.length)
        {
            dev.isActive = true;
            dev.disabled = "";

            var devVars = Array.from(dev.vars);
            devVars.forEach((v) => {
                if(v.type == "string")
                    v.disabled = "disabled";

                for (var key in dataWidget) {
                    var d = dataWidget[key];
                    if(d.device == dev.id){
                        if(d.lat == v.attribute_key)
                            v.latSelected = "selected";
                        if(d.long == v.attribute_key)
                            v.longSelected = "selected";
                    }
                }
            });
        }
    }
    jsonData.devices = devs;

    var template = $('#map-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetMapTable").html(render);
    $('.table-loading').hide();
}

async function changeDTWidgetMapEdit(e){
    if(e.value == ""){
        return;
    }
    $("#idWidgetMapTable").html("");
    $('.table-loading').show();
    var jsonData = {"devices":[]};
    var widgetId = $('#editWidgetMapModal').data('widget-id');
    var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
    // widget.setAttribute('filter-value', e.value);
    filterValue = e.value;
    var dataWidget = JSON.parse(widget.getAttribute("data"));

    var devs = await getDevicesByDT(e.value);
    for(var i = 0; i < devs.length; i++){
        var dev = devs[i];
        //dev.vars = await getVarsByDevice(dev.id);
        dev.vars = dev.attributes;
        dev.isActive = false;
        dev.disabled = "disabled";
        if(dev.vars != undefined && dev.vars.length)
        {
            dev.isActive = true;
            dev.disabled = "";

            var devVars = Array.from(dev.vars);
            devVars.forEach((v) => {
                if(v.type == "string")
                    v.disabled = "disabled";

                for (var key in dataWidget) {
                var d = dataWidget[key];
                    if(d.device == dev.id){
                        if(d.lat == v.attribute_key)
                            v.latSelected = "selected";
                        if(d.long == v.attribute_key)
                            v.longSelected = "selected";
                    }
                }
            });
        }
    }
    jsonData.devices = devs;

    var template = $('#map-edit-table-template').html();
    var render = Mustache.render(template, jsonData);
    $("#idWidgetMapTable").html(render);
    $('.table-loading').hide();
}

function confirmWidgetMap(){
    if($("#editWidgetMapModal form").valid()){
        var devs = $('#idWidgetMapTable table tbody tr');
        var json = [];

        for(var i = 0; i < devs.length; i++) {
            var child = devs[i].getElementsByTagName("td");
            if(child[0].getAttribute('data-active') == "true")
            {
                var lat = child[1].getElementsByTagName("select")[0].value;
                var long = child[2].getElementsByTagName("select")[0].value;
                if(lat == "" ^ long == ""){
                    if(lat == "")
                        child[1].children[0].classList.add("error");
                    if(long == "")
                        child[2].children[0].classList.add("error");
                    return;
                }
                else{
                    child[1].children[0].classList.remove("error");
                    child[2].children[0].classList.remove("error");
                }

                var slLat = child[1].getElementsByTagName("select")[0];
                console.log(slLat.options[slLat.selectedIndex].getAttribute('attribute-type'));

                if(lat != "" && long != ""){
                    json.push({
                        "device": child[0].getAttribute("data-id"),
                        "lat": lat,
                        "long": long,
                        "attribute_type": slLat.options[slLat.selectedIndex].getAttribute('attribute-type'),
                        "value_type": slLat.options[slLat.selectedIndex].getAttribute('value-type'),
                    });
                    console.log(json);
                }
            }
        }

        var widgetId = $('#editWidgetMapModal').data('widget-id');
        var widget = $('.grid-stack-item[gs-id="'+widgetId+'"]')[0];
        widget.setAttribute('filter', filter);
        //$('.grid-stack-item[gs-id="'+id+'"]')[0].setAttribute('data', JSON.stringify(json));
        widget.setAttribute("filter-value", filterValue);
        widget.setAttribute("data", JSON.stringify(json));
        widget.setAttribute('title', $('#idWidgetMapEditTitle').val());
        widget.setAttribute('typeMap', $('#typeWidgetMapEdit').val());
        $('#editWidgetMapModal').modal('hide');

        // autoSaveWidget();
    }
}

function validateWidgetMapForm(){

    $("#editWidgetMapModal form").validate({
        ignore: [],
        errorClass: "error",
        rules: {
            idWidgetMapEditTitle: {
                required: true,
            },
            typeWidgetMapEdit: {
                required: true,
            },
            idWidgetMapEditOption: {
                required: true
            },
            selectWidgetMapEditOrg: {
                required: function(elem){
                    return $('#idWidgetMapEditOption').val() == "org";
                }
            },
            selectWidgetMapEditGroup: {
                required: function(elem){
                    return $('#idWidgetMapEditOption').val() == "group";
                }
            },
            selectWidgetMapEditDT: {
                required: function(elem){
                    return $('#idWidgetMapEditOption').val() == "devicetype";
                }
            },
            // widgetMapTableSelectLat: {
            //     required: function(elem){
            //         return $(elem).val() == "" ^ $(elem).parent().parent().find(".long").val() == "";
            //     }
            // },
            // widgetMapTableSelectLong: {
            //     required: function(elem){
            //         return $(elem).val() == "" ^ $(elem).parent().parent().find(".lat").val() == "";
            //     }
            // },
            widgetMapTableSelect: {
                required: function(elem){
                    if($('#idWidgetMapEditOption').val() == "alldevice")
                        return false;
                    var sel = $('#idWidgetMapTable select');
                    for(var i = 0; i < sel.length; i++){
                        if($(sel[i]).val())
                            return false;
                    }
                    return true;
                }
            }
        },
        messages: {
            idWidgetMapEditTitle: "Tiêu đề không được bỏ trống",
            typeWidgetMapEdit: "Chọn loại bản đồ",
            idWidgetMapEditOption: "Bộ lọc không được bỏ trống",
            selectWidgetMapEditOrg: "Chọn tổ chức thiết bị",
            selectWidgetMapEditGroup: "Chọn nhóm thiết bị",
            selectWidgetMapEditDT: "Chọn loại thiết bị",
            widgetMapTableSelectLat: "Chọn thuộc tính cho vĩ độ",
            widgetMapTableSelectLong: "chọn thuộc tính cho kinh độ",
            widgetMapTableSelect: "Chọn ít nhất một thiết bị"
        }
    });
}

function clickWidgetMap() {
    console.log("clickWidgetMap");
}