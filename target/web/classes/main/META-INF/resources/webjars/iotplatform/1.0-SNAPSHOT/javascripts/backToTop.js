/**
 * Created by vtk-anhlt166 on 7/21/22.
 */
$(window).on("scroll", function() {
    $(this).scrollTop() > 300 ? $(".back-to-top").fadeIn() : $(".back-to-top").fadeOut()
}), $(".back-to-top").on("click", function() {
    return $("html, body").animate({
        scrollTop: 0
    }, 600), !1
})

$(document).ready(function () {
    $('.back-to-top').on("click", function () {
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        return false;
    });
});