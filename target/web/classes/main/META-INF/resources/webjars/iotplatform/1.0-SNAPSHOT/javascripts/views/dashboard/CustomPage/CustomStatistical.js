/**
 * Created by vtk-anhlt166 on 6/14/21.
 */
var numberStatistical = 0;
function createLiStatistical() {
    numberStatistical++;
    var id = "statistical"+numberStatistical;
    var li = '<li class="draggable" style="height: 100%;" id="statistical'+numberStatistical+'" onclick="clickEditDetail(this, 2)">' +
        '<img src="'+statisticalImg+'" width="100%" height="100%" alt="" />' +
        '<div class="col" style="margin-top: 12px">'+
        '<div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">'+
        '<button type="button" class="btn btn-light"><i class="bx bx-edit"></i>'+
        '</button>'+
        '<button type="button" class="btn btn-light" onclick="removeLiID(\''+id+'\')"><i class="bx bx-x"></i>'+
        '</button>'+
        '</div>'+
        '</div>'+
        '</li>';

    $("#divChartStatistical").append(li);

    setTimeout(function () {
        $('.draggable').draggable({ connectWith: '#rhs' });
    },200);
}