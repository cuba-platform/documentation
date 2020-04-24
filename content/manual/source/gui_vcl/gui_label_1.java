protected static final String UNSAFE_HTML = "<i>Jackdaws </i><u>love</u> <font size=\"javascript:alert(1)\" " +
            "color=\"moccasin\">my</font> " +
            "<font size=\"7\">big</font> <sup>sphinx</sup> " +
            "<font face=\"Verdana\">of</font> <span style=\"background-color: " +
            "red;\">quartz</span><svg/onload=alert(\"XSS\")>";

@Inject
private Label<String> label;

@Subscribe
public void onInit(InitEvent event) {
    label.setHtmlEnabled(true);
    label.setHtmlSanitizerEnabled(true);
    label.setValue(UNSAFE_HTML);
}