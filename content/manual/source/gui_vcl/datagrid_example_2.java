@Inject
private DataGrid<CountryGrowth> dataGrid;
@Inject
private UserSessionSource userSessionSource;
@Inject
private Messages messages;
@Inject
private CollectionContainer<CountryGrowth> countryGrowthsDc;

private DecimalFormat percentFormat;

@Subscribe
protected void onBeforeShow(BeforeShowEvent event) {
    initPercentFormat();
    initHeader();
    initFooter();
    initRenderers();
}

private DecimalFormat initPercentFormat() {
    percentFormat = (DecimalFormat) NumberFormat.getPercentInstance(userSessionSource.getLocale());
    percentFormat.setMultiplier(1);
    percentFormat.setMaximumFractionDigits(2);
    return percentFormat;
}

private void initRenderers() {
    dataGrid.getColumnNN("year2017").setRenderer(new WebNumberRenderer(percentFormat));
    dataGrid.getColumnNN("year2018").setRenderer(new WebNumberRenderer(percentFormat));
}

private void initHeader() {
    DataGrid.HeaderRow headerRow = dataGrid.prependHeaderRow();
    DataGrid.HeaderCell headerCell = headerRow.join("year2017", "year2018");
    headerCell.setText("GDP growth");
    headerCell.setStyleName("center-bold");
}

private void initFooter() {
    DataGrid.FooterRow footerRow = dataGrid.appendFooterRow();
    footerRow.getCell("country").setHtml("<strong>" + messages.getMainMessage("average") + "</strong>");
    footerRow.getCell("year2017").setText(percentFormat.format(getAverage("year2017")));
    footerRow.getCell("year2018").setText(percentFormat.format(getAverage("year2018")));
}

private double getAverage(String propertyId) {
    double average = 0.0;
    List<CountryGrowth> items = countryGrowthsDc.getItems();
    for (CountryGrowth countryGrowth : items) {
        Double value = countryGrowth.getValue(propertyId);
        average += value != null ? value : 0.0;
    }
    return average / items.size();
}