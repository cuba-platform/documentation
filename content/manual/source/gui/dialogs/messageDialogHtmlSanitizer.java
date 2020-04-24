protected static final String UNSAFE_HTML = "<i>Jackdaws </i><u>love</u> <font size=\"javascript:alert(1)\" " +
            "color=\"moccasin\">my</font> " +
            "<font size=\"7\">big</font> <sup>sphinx</sup> " +
            "<font face=\"Verdana\">of</font> <span style=\"background-color: " +
            "red;\">quartz</span><svg/onload=alert(\"XSS\")>";

@Inject
private Dialogs dialogs;

@Subscribe("showMessageDialogOnBtn")
public void onShowMessageDialogOnBtnClick(Button.ClickEvent event) {
    dialogs.createMessageDialog()
            .withCaption("MessageDialog with Sanitizer")
            .withMessage(UNSAFE_HTML)
            .withContentMode(ContentMode.HTML)
            .withHtmlSanitizer(true)
            .show();
}

@Subscribe("showMessageDialogOffBtn")
public void onShowMessageDialogOffBtnClick(Button.ClickEvent event) {
    dialogs.createMessageDialog()
            .withCaption("MessageDialog without Sanitizer")
            .withMessage(UNSAFE_HTML)
            .withContentMode(ContentMode.HTML)
            .withHtmlSanitizer(false)
            .show();
}