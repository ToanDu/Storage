/**
 * Created by vtk-anhlt166 on 12/9/21.
 */
$(document).ready(function () {
    getListFlow();
});
function getListFlow() {
    var groupData = new FormData();
    groupData.projectId = projectId;
    console.log(groupData);
    var r = jsRoutes.controllers.FlowEngineController.getListFlow();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas, textStatus, jqXHR) {
            console.log(datas);
            if(datas.success){
                viewFlowList(datas.content.data);

            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function viewFlowList(data) {
    var list = "";
    if (data != null && data.length > 0) {
        list =
            "<input checked='checked' class='carousel2__activator' id='carousel2-slide-flow-1' name='carousel2' type='radio'>"+
            "<input class='carousel2__activator' id='carousel2-slide-flow-2' name='carousel2' type='radio'>"+
            "<input class='carousel2__activator' id='carousel2-slide-flow-3' name='carousel2' type='radio'>";

        var control = "";
        var count = Math.floor(data.length/3);
        console.log(count);
        if(count > 0){
            control +=
                "<div class='carousel2__controls'>"+
                "<label class='carousel2__control carousel2__control--forward' for='carousel2-slide-flow-2'>"+
                "<i class='bx bx-caret-right'></i>"+
                "</label>"+
                "</div>";
            for(var c=0; c<count-1; c++){
                var left = c+1;
                var right = c+3;
                control +=
                    "<div class='carousel2__controls'>"+
                    "<label class='carousel2__control carousel2__control--backward' for='carousel2-slide-flow-"+left+"'>"+
                    "<i class='bx bx-caret-left'></i>"+
                    "</label>"+
                    "<label class='carousel2__control carousel2__control--forward' for='carousel2-slide-flow-"+right+"'>"+
                    "<i class='bx bx-caret-right'></i>"+
                    "</label>"+
                    "</div>";
            }
            control +=
                "<div class='carousel2__controls'>"+
                "<label class='carousel2__control carousel2__control--backward' for='carousel2-slide-flow-"+(count)+"'>"+
                "<i class='bx bx-caret-left'></i>"+
                "</label>"+
                "</div>";
        }
        list += control;
    }

    var flowList = "<div class='carousel2__screen'>"+
        "<div class='carousel2__track'>";
    if (data != null && data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            var date = Messages("Ngày tạo: ") + moment.unix(data[i].createdTime/1000).format("DD/MM/YYYY HH:mm");
            var content = Messages("Thông tin mô tả: ") + (data[i].additionalInfo.description != null ? data[i].additionalInfo.description : "");
            var imgFlow = img;
            if(i%3 == 1){
                imgFlow = img1;
            } else if(i%3 == 2){
                imgFlow = img2;
            }
            flowList +=
                '<div class="carousel2__item carousel2__item--mobile-in-1 carousel2__item--tablet-in-2 carousel2__item--desktop-in-3 list_flow">'+
                '<div class="col-md-12" style="cursor: pointer" onclick="goPageFlowEnginge(\''+data[i].id.id+'\')">'+
                '<div class="card w-100">'+
                '<div class="row g-0">'+
                '<div class="card-header border-bottom cardTitle">'+
                '<div class="d-flex align-items-center">'+
                '<div>'+
                '<h6 class="mb-0" style="color: white; text-transform: uppercase;">'+data[i].name+'</h6>'+
                '</div>'+
                '<div class="font-22 ms-auto text-white"><i class="bx bx-dots-horizontal-rounded"></i>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '<div class="row g-0">'+
                '<div class="col-md-6">'+
                '<img src="'+imgFlow+'" alt="..." class="card-img" style="height: 200px; padding: 15px">'+
                '</div>'+
                '<div class="col-md-6">'+
                '<div class="card-body" style="height: 100%;overflow: auto; min-height: 100px">'+
                '<p class="card-text">'+date+'</p>'+
                '<p class="card-text"><small class="">'+content+'</small></p>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
        }
    } else {
        document.getElementById("titleNotFlow").style.display = 'block';
    }
    flowList +=
        '<div class="carousel__item carousel__item--mobile-in-1 carousel__item--tablet-in-2 carousel__item--desktop-in-3">'+
        '<div class="ml-auto mr-auto text-center" style="margin-top: 0rem !important;">'+
        '<button type="button" class="btn px-5 radius-15 modal-title text-white" style="padding: 15px; background-color: #858687" onclick="remotePageFlow()">'+
        '<i class="bx bx-plus-circle mr-1"></i>'+ Messages("Tạo mới Flow Engine") +
        '</button>'+
        '</div>'+
        '</div>';
    flowList += '</div></div>';

    list += flowList;
    $("#listFlowEngine").html(list);
}

function goPageFlowEnginge(id) {
    window.location.href = jsRoutes.controllers.RuleChainController.flowEngineWithId(projectId, id).url;
}

function remotePageFlow() {
    window.location.href = jsRoutes.controllers.RuleChainController.ruleChain(projectId).url;
}