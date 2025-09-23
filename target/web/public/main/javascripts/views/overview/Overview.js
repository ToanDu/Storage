/**
 * Created by vtk-anhlt166 on 12/9/21.
 */
$(document).ready(function () {
    getNameProject();
});

function getNameProject() {
    console.log(projectId);
    var route = jsRoutes.controllers.ProjectController.getNameProject(projectId);
    $.ajax({
        type: route.type,
        data: JSON.stringify(""),
        contentType: "application/json; charset=utf-8",
        url: route.url,
        success: function (data) {
            console.log(data);
            if (data.success) {
                $("#nameProjectTitle").html(Messages("Dự án: ") + data.content)
            } else {
                $("#nameProjectTitle").html("")
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger', Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    })
}

//search
$('#searchDashboard').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchDashboard').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_dashboard').each(function() {
        var isMatch = $(this).find('h6').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});

$('#searchFlow').on('click keyup', function(event) {
    // Prevent the original click for not reloading the whole page
    event.preventDefault();

    // Get value from search input
    var searchInputString = $('#searchFlow').val();
    var regExp = new RegExp(searchInputString, 'i');

    // Search the list and if it matches display it, else hide it
    $('.list_flow').each(function() {
        var isMatch = $(this).find('h6').text().match(regExp);
        $(this).toggle((isMatch) ? true : false);
    });
});