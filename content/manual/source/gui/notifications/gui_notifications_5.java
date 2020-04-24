protected static final String UNSAFE_HTML = "<i>Jackdaws </i><u>love</u> <font size=\"javascript:alert(1)\" " +
            "color=\"moccasin\">my</font> " +
            "<font size=\"7\">big</font> <sup>sphinx</sup> " +
            "<font face=\"Verdana\">of</font> <span style=\"background-color: " +
            "red;\">quartz</span><svg/onload=alert(\"XSS\")>";

@Inject
private Notifications notifications;

@Subscribe("showNotificationOnBtn")
public void onShowNotificationOnBtnClick(Button.ClickEvent event) {
    notifications.create()
            .withCaption("Notification with Sanitizer")
            .withDescription(UNSAFE_HTML)
            .withContentMode(ContentMode.HTML)
            .withHtmlSanitizer(true)
            .show();
}

@Subscribe("showNotificationOffBtn")
public void onShowNotificationOffBtnClick(Button.ClickEvent event) {
    notifications.create()
            .withCaption("Notification without Sanitizer")
            .withDescription(UNSAFE_HTML)
            .withContentMode(ContentMode.HTML)
            .withHtmlSanitizer(false)
            .show();
}