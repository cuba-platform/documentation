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

if (isPc()) {

    $(document).ready(function () {
        $('#toc .sectlevel1').treeview ({
             collapsed: true,
             animated: "medium",
            persist: "location",
            unique: false,
            control: "#treecontrol"
        });

        var closePanel = $("#close-panel");
        var tocMarker = $("#toc-position-marker");
        var highlightedTocLink;

        var book = $(".book");
        var tocPanel = $("#toc");

        closePanel.bind('click', function(e) {
            e.preventDefault();
            isShowPanel = false;

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

        var highlightEnabled = true;

        $(window).resize(function() {
            highlightEnabled = $(window).width() > 1024;
        });

        $(window).scroll(function() {
            if (!highlightEnabled) return;
            clearTimeout($.data(this, 'scrollTimer'));
            $.data(this, 'scrollTimer', setTimeout(function() {
                var markerOffset = tocMarker.offset();
                var nearestLink = $.nearest({x: markerOffset.left, y: markerOffset.top}, 'h2 > a, h3 > a, h4 > a, h5 > a, h6 > a')[0];
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
    });
}
