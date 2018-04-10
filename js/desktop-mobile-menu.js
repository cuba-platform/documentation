$(document).ready(function () {

    var drawerOpenedStyle = 'opened';
    var drawerClosedStyle = 'closed';
    var drawerGoneStyle = 'gone';

    var mobileDeskStyle = 'mobile-desk';
    var tocMarkerStyle = 'marker-desk';
    var tocHighlightedStyle = 'desk';

    var mobileDeskIEStyle = 'mobile-desk-ie';

    if (isPc()) {
         // don't display mobile drawer button
        $("#menubutton").addClass("menubutton-gone")

        var drawerButton = createDrawerButton();
        var jQDrawerButton = $(drawerButton);
        jQDrawerButton.click(function(){
            if (jQDrawerButton.hasClass(drawerClosedStyle)) {
                openMenu();
            } else {
                closeMenu();
            }
        });

        var frontDiv = document.getElementById('front');
        var topDiv = document.getElementById('top');
        // index page
        if (frontDiv) {
            frontDiv.appendChild(drawerButton);
        }
        // others
        if (topDiv) {
            topDiv.appendChild(drawerButton);
        }

        // handle changing width
        initMediaQueryWidthHandler(jQDrawerButton);

        // open menu if it is not search page
        if (isOpenMenu() && window.location.href.indexOf('search.jsp') == -1 ) {
            openMenu();
        } else {
            closeMenu();
        }
    }

    function initMediaQueryWidthHandler(drawerButton){
        var mediaQueryList = window.matchMedia("(min-width: 1025px)");

        mediaQueryList.addListener(handleOrientationChange);
        handleOrientationChange(mediaQueryList);

        function handleOrientationChange(mediaQueryList) {
            if (mediaQueryList.matches) {
                // normal desktop menu is shown
                drawerButton.addClass(drawerGoneStyle);
                closeMenu();
            } else {
                // switched on the mobile menu
                drawerButton.removeClass(drawerGoneStyle)
            }
        }
    }

    function openMenu() {
        $("#toc").addClass('desk');
        jQDrawerButton.removeClass(drawerClosedStyle)
        jQDrawerButton.addClass(drawerOpenedStyle);

        $(".searchfield").addClass(mobileDeskStyle);
        $(".desktop-toc").addClass(mobileDeskStyle);
        $(".toc-root").addClass(mobileDeskStyle);
        $(".toc-link").addClass(mobileDeskStyle);

        $(".toc-marker").addClass(tocMarkerStyle);
        $(".toc-highlighted").addClass(tocHighlightedStyle);

        if (isEdgeOrIE()){
            $(".searchfield").addClass(mobileDeskIEStyle);
            $(".desktop-toc").addClass(mobileDeskIEStyle);
        }

        // scroll to the selected item;
        var scrollDiv = document.getElementsByClassName(mobileDeskStyle)[0];
        var selEl = $(scrollDiv).find('.toc-selected-item');
        if (selEl[0]) {
            var topPos = selEl[0].offsetTop;
            scrollDiv.scrollTop = topPos;
        }

        // save state to the sessionStorage
        setOpenMenu(true);
    }

    function closeMenu(){
        $("#toc").removeClass('desk');
        jQDrawerButton.removeClass(drawerOpenedStyle)
        jQDrawerButton.addClass(drawerClosedStyle);

        $(".searchfield").removeClass(mobileDeskStyle);
        $(".desktop-toc").removeClass(mobileDeskStyle);
        $(".toc-root").removeClass(mobileDeskStyle);
        $(".toc-link").removeClass(mobileDeskStyle);

        $(".toc-marker").removeClass(tocMarkerStyle);
        $(".toc-highlighted").removeClass(tocHighlightedStyle);

        if (isEdgeOrIE()){
            $(".searchfield").removeClass(mobileDeskIEStyle);
            $(".desktop-toc").removeClass(mobileDeskIEStyle);
        }

        // save state to the sessionStorage
        setOpenMenu(false);
    }

    function createDrawerButton(){
        var drawerButton = document.createElement('div');
        drawerButton.id = 'drawerbuttondesc';
        drawerButton.className = 'drawerbutton-desk' + ' ' + drawerClosedStyle;
        return drawerButton;
    }

    function isPc() {
        var userAgent = navigator.userAgent.toLowerCase();
        var notPcOsArr = ["ipad", "iphone", "ipod", "windows phone", "phone", "android"];
        for (var i = 0; i < notPcOsArr.length; i++) {
            if (userAgent.indexOf(notPcOsArr[i]) >= 0) {
                return false;
            }
        }
        return true;
    }

    function setOpenMenu(isMenuOpen){
        sessionStorage.setItem('isMenuOpen', isMenuOpen);
    }

    function isOpenMenu(){
        var state = sessionStorage.getItem('isMenuOpen');
        return state === 'true';
    }

    function isEdgeOrIE(){
        if (document.documentMode || /Edge/.test(navigator.userAgent)) {
            return true;
        } else {
            return false;
        }
    }
});