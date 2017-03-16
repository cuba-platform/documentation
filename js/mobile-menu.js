$(document).ready(function () {
    var menubutton = $("#menubutton");
    var closemenu = $("#closemenu");
    var mobileMenu = $(".mobile-toc");

    menubutton.bind('click', function (e) {
        if (mobileMenu.hasClass("active")) {
            mobileMenu.removeClass("active");
        } else {
            mobileMenu.addClass("active");
        }
    });

    closemenu.bind('click', function (e) {
        if (mobileMenu.hasClass("active")) {
            mobileMenu.removeClass("active");
        } else {
            mobileMenu.addClass("active");
        }
    });
});