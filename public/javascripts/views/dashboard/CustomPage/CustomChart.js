/**
 * Created by vtk-anhlt166 on 6/14/21.
 */
var numberColumn = 0;
function createLiChartColumn() {
    numberColumn++;
    var id = "chartColumn"+numberColumn;
    console.log(id);
    var li = '<li class="draggable" style="height: 100%;" id="'+id+'" onclick="clickEditDetail(this, 2)">' +
        '<img src="'+chartColumnImg+'" width="100%" height="100%" alt="" />' +
        '<div class="col" style="margin-top: 12px">'+
        '<div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">'+
        '<button type="button" class="btn btn-light"><i class="bx bx-edit"></i>'+
        '</button>'+
        '<button type="button" class="btn btn-light" onclick="removeLiID(\''+id+'\')"><i class="bx bx-x"></i>'+
        '</button>'+
        '</div>'+
        '</div>'+
        '</li>';

    $("#divChartColumn").append(li);

    setTimeout(function () {
        $('.draggable').draggable({ connectWith: '#rhs' });
    },200);
}


var numberLine = 0;
function createLiChartLine() {
    numberLine++;
    var id = "chartLine"+numberLine;
    var li = '<li class="draggable" style="height: 100%;" id="chartLine'+numberLine+'" onclick="clickEditDetail(this, 2)">' +
        '<img src="'+chartLineImg+'" width="100%" height="100%" alt="" />' +
        '<div class="col" style="margin-top: 12px">'+
        '<div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">'+
        '<button type="button" class="btn btn-light"><i class="bx bx-edit"></i>'+
        '</button>'+
        '<button type="button" class="btn btn-light" onclick="removeLiID(\''+id+'\')"><i class="bx bx-x"></i>'+
        '</button>'+
        '</div>'+
        '</div>'+
        '</li>';

    $("#divChartLine").append(li);

    setTimeout(function () {
        $('.draggable').draggable({ connectWith: '#rhs' });
    },200);
}


var numberCircle = 0;
function createLiChartCircle() {
    numberCircle++;
    var id = "chartCircle"+numberCircle;
    var li = '<li class="draggable" style="height: 100%;" id="chartCircle'+numberCircle+'" onclick="clickEditDetail(this, 2)">' +
        '<img src="'+chartCircleImg+'" width="100%" height="100%" alt="" />' +
        '<div class="col" style="margin-top: 12px">'+
        '<div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">'+
        '<button type="button" class="btn btn-light"><i class="bx bx-edit"></i>'+
        '</button>'+
        '<button type="button" class="btn btn-light" onclick="removeLiID(\''+id+'\')"><i class="bx bx-x"></i>'+
        '</button>'+
        '</div>'+
        '</div>'+
        '</li>';

    $("#divChartCircle").append(li);

    setTimeout(function () {
        $('.draggable').draggable({ connectWith: '#rhs' });
    },200);
}
