$(document).ready(function () {
    var menubutton = $("#menubutton");
    var closemenu = $("#closemenu");
    var mobileMenu = $(".mobile-toc");

    menubutton.bind('click', function (e) {
        if (mobileMenu.hasClass("active")) {
            mobileMenu.removeClass("active");
        } else {
            mobileMenu.addClass("active");
            
            var selEl = document.getElementsByClassName('toc-selected-item')[1]; // from mobile menu
            if (selEl) {
                selEl.scrollIntoView();
            }
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