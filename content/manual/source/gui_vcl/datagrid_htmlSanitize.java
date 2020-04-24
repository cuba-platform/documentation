protected static final String UNSAFE_HTML = "<i>Jackdaws </i><u>love</u> <font size=\"javascript:alert(1)\" " +
            "color=\"moccasin\">my</font> " +
            "<font size=\"7\">big</font> <sup>sphinx</sup> " +
            "<font face=\"Verdana\">of</font> <span style=\"background-color: " +
            "red;\">quartz</span><svg/onload=alert(\"XSS\")>";

@Inject
private DataGrid<Customer> customersDataGrid;
@Inject
private DataGrid<Customer> customersDataGrid2;
@Inject
private DataGrid<Customer> customersDataGrid3;

@Subscribe
public void onInit(InitEvent event) {
    customersDataGrid.setHtmlSanitizerEnabled(true);
    customersDataGrid.getColumn("name")
            .setRenderer(customersDataGrid.createRenderer(DataGrid.HtmlRenderer.class));

    customersDataGrid2.setHtmlSanitizerEnabled(true);
    customersDataGrid2.setRowDescriptionProvider(customer -> UNSAFE_HTML, ContentMode.HTML);

    customersDataGrid3.setHtmlSanitizerEnabled(true);
    customersDataGrid3.getColumn("name").setDescriptionProvider(customer -> UNSAFE_HTML, ContentMode.HTML);
}