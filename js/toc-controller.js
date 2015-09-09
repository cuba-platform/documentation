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
        var contentPanel = $("#content");

        closePanel.bind('click', function(e) {
            e.preventDefault();
            isShowPanel = false;
            var linkLocation;

            tocPanel.css('display', 'none');
            book.css('padding-left', '2.5em');
            tocMarker.css('display', 'block');
        });

        tocMarker.bind('click', function (e) {
            e.preventDefault();
            tocPanel.css('display', 'block');
            book.css('padding-left', '25em');
             tocMarker.css('display', 'none');
        });


        $(window).scroll(function() {
            clearTimeout($.data(this, 'scrollTimer'));
            $.data(this, 'scrollTimer', setTimeout(function() {
                var object = $(tocMarker).closest("h2, h3, h4, h5, h6")

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
