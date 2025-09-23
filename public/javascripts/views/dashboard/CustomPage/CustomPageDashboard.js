function createRow() {
    var numberCol = $("#numberCol").val();
    var heightRow = $("#heightRow").val();
    var dvCol = $("#dvCol").val();
    console.log(numberCol);

    var countCol = 12 / numberCol;
    var row = '<div class="row" style="margin-top: 30px">';
    for (var i=0; i<numberCol; i++){
        row += '<div class="col-md-'+countCol+'" id="col'+i+'">';
        row += '<div class="droppable" style="margin: 5px; height: '+heightRow+dvCol+'"></div>';
        row += '</div>';
    }
    row += '</div>';

    $("#bodyDashboard").append(row);

    setTimeout(function () {
        $('.draggable').draggable({ connectWith: '#rhs' })
        $('.droppable').droppable({ activeClass: 'active', hoverClass: 'drop-here' })
    },500);
}

function resetAllDesign() {
    $("#bodyDashboard").html("");

    console.log(document.getElementById("map0"));
    if(document.getElementById("map0") == null){
        var map = '<li class="draggable" style="height: 100%;" id="map0" onclick="clickEditDetail(this, 2)">'+
            '<img src="'+mapImg+'" width="100%" height="100%" alt="" />'+
            '<div class="col" style="margin-top: 12px">'+
            '<div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">'+
            '<button type="button" class="btn btn-light"><i class="bx bx-edit"></i>'+
            '</button>'+
            '<button type="button" class="btn btn-light" onclick="removeLiID(\'map0\')"><i class="bx bx-x"></i>'+
            '</button>'+
            '</div>'+
            '</div>'+
            '</li>';
        $("#divMap").append(map);

        setTimeout(function () {
            $('.draggable').draggable({ connectWith: '#rhs' });
        },200);
    }
}

function removeLiID(id) {
    console.log(id);
    if(document.getElementById(id) != null && document.getElementById(id) != undefined){
        document.getElementById(id).remove();

        console.log(document.getElementById("map0"));
        if(document.getElementById("map0") == null){
            var map = '<li class="draggable" style="height: 100%;" id="map0" onclick="clickEditDetail(this, 2)">'+
                '<img src="'+mapImg+'" width="100%" height="100%" alt="" />'+
                '<div class="col" style="margin-top: 12px">'+
                '<div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">'+
                '<button type="button" class="btn btn-light"><i class="bx bx-edit"></i>'+
                '</button>'+
                '<button type="button" class="btn btn-light" onclick="removeLiID(\'map0\')"><i class="bx bx-x"></i>'+
                '</button>'+
                '</div>'+
                '</div>'+
                '</li>';
            $("#divMap").append(map);

            setTimeout(function () {
                $('.draggable').draggable({ connectWith: '#rhs' });
            },200);
        }
    }
}

function clickEditDetail(element, level) {
    console.log(element);

    while(level-- > 0) {
        element = element.parentNode;
        if(!element) {
            return null;
        }
    }
    console.log(element);
    console.log(element.className);
    console.log(element.id);
}