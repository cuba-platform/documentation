public class DataGridHeaderFooterFrame extends AbstractFrame {
    @Inject
    private DataGrid<CountryGrowth> dataGrid;
    @Inject
    private CollectionDatasource<CountryGrowth, UUID> countryGrowthDs;
    @Inject
    private UserSessionSource userSessionSource;

    private DecimalFormat percentFormat;

    @Override
    public void init(Map<String, Object> params) {
        countryGrowthDs.refresh();

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
        dataGrid.getColumnNN("year2014").setRenderer(new WebNumberRenderer(percentFormat));
        dataGrid.getColumnNN("year2015").setRenderer(new WebNumberRenderer(percentFormat));
    }

    private void initHeader() {
        HeaderRow headerRow = dataGrid.prependHeaderRow();
        HeaderCell headerCell = headerRow.join("year2014", "year2015");
        headerCell.setText("GDP growth");
        headerCell.setStyleName("center-bold");
    }

    private void initFooter() {
        FooterRow footerRow = dataGrid.appendFooterRow();
        footerRow.getCell("country").setHtml("<strong>" + getMessage("average") + "</strong>");
        footerRow.getCell("year2014").setText(percentFormat.format(getAverage("year2014")));
        footerRow.getCell("year2015").setText(percentFormat.format(getAverage("year2015")));
    }

    private double getAverage(String propertyId) {
        double average = 0.0;
        Collection<CountryGrowth> items = countryGrowthDs.getItems();
        for (CountryGrowth countryGrowth : items) {
            Double value = countryGrowth.getValue(propertyId);
            average += value != null ? value : 0.0;
        }
        return average / items.size();
    }
}
