/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
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

$(document).ready(function () {
    $(".book").append('<div id="smallDeviceIndicator" style="display: none">');

    $('#toc .sectlevel1').treeview({
        collapsed: true,
        animated: "medium",
        persist: "location",
        unique: false,
    });

    var closePanel = $("#treecontrol");
    var tocMarker = $("#toc-position-marker");

    var book = $(".book");
    var tocPanel = $("#toc");

    closePanel.bind('click', function (e) {
        e.preventDefault();
        tocPanel.addClass('toc-collapsed');
        book.addClass('toc-collapsed');
        tocMarker.addClass('toc-collapsed');
    });

    tocMarker.bind('click', function (e) {
        e.preventDefault();
        tocPanel.removeClass('toc-collapsed');
        book.removeClass('toc-collapsed');
        tocMarker.removeClass('toc-collapsed');
    });

    if (isPc()) {
        var highlightedTocLink;
        var highlightEnabled = true;

        $(window).resize(function () {
            //css media query will set #smallDeviceIndicator float to "left" for small screens
            //we had to do this because of browser width measurement issues.
            highlightEnabled = $("#smallDeviceIndicator").css("float") == "right";
        });

        $(window).scroll(function () {
            if (!highlightEnabled) return;
            clearTimeout($.data(this, 'scrollTimer'));
            $.data(this, 'scrollTimer', setTimeout(function () {
                var markerOffset = tocMarker.offset();
                var nearestLink = $.nearest({
                    x: markerOffset.left,
                    y: markerOffset.top
                }, 'h2 > a, h3 > a, h4 > a, h5 > a, h6 > a')[0];
                highlightTocLink(nearestLink);
            }, 500));
        });


        function highlightTocLink(nearestLink) {
            if (highlightedTocLink != undefined && highlightedTocLink.href == nearestLink.href) return;

            if (highlightedTocLink != undefined) {
                highlightedTocLink.removeClass("toc-highlighted")
            }

            highlightedTocLink = $("#toc a[href='" + $(nearestLink).attr("href") + "']");
            if (highlightedTocLink != undefined) {
                highlightedTocLink.addClass("toc-highlighted")

                var openedNodesDivs = $('div.hitarea', '.treeview').filter('.collapsable-hitarea');
                var nodesDivsToBeOpened = $(highlightedTocLink).parents('li').children('div.hitarea');
                var nodesDivsToBeClosed = $.map(openedNodesDivs, function (val) {
                    if ($.inArray(val, nodesDivsToBeOpened) === -1) {
                        return val;
                    } else {
                        return null;
                    }
                });

                closeTocNodes($(nodesDivsToBeClosed));
                openTocNodes(nodesDivsToBeOpened);
            }
        }

        function closeTocNodes(divs) {
            divs.each(function () {
                if ($(this).hasClass('collapsable-hitarea')) {
                    $(this).click();
                }
            });
        }

        function openTocNodes(divs) {
            divs.each(function () {
                if ($(this).hasClass('expandable-hitarea')) {
                    $(this).click();
                }
            });
        }
    }
});