/**
 * Created by vtk-anhlt166 on 12/1/21.
 */
// $(function() {
//     "use strict";
//     new PerfectScrollbar(".header-message-list")
//
// });

$(document).ready(function () {
    var listProject = JSON.parse(localStorage.listProject);
    console.log(listProject);
   if(listProject.length > 0){
       var project = "";
        for(var i=0; i<listProject.length; i++){
            var img = imgProject0;
            if(i%3 == 1){
                img = imgProject1;
            } else if(i%3 == 2){
                img = imgProject2;
            }

            var color = "";
            if(projectId == listProject[i].id){
                console.log(listProject[i].name);
                // $("#nameHeaderProject").html("<i class='bx bx-atom'></i>"+Messages(listProject[i].name)+" <i class='bx bx-caret-down'></i>");

                color = "#ec1b2e40";
            }

            var des = (listProject[i].description != undefined && listProject[i].description.length < 30) ? listProject[i].description : (listProject[i].description.substring(0,30) + "...");
            project +=
                '<a class="dropdown-item" onclick="routesProjectOther(\''+listProject[i].id+'\')" style="cursor: pointer; background-color: '+color+'">'+
                '<div class="d-flex" title="'+listProject[i].description+'">'+
                '<div class="user-online">'+
                '<img src="'+img+'" class="msg-avatar" alt="user avatar">'+
                '</div>'+
                '<div class="flex-grow-1">'+
                '<h6 class="msg-name" style="font-weight: bold">'+listProject[i].name+'</h6>'+
                '<p class="msg-info">'+des+'</p>'+
                '</div>'+
                '</div>'+
                '</a>';


        }
        $("#headerListProject").html(project);
   }
});

function routesProjectOther(projectId) {
    window.location.href = jsRoutes.controllers.OverviewController.overview(projectId).url;
}