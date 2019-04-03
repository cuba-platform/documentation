@Inject
private PieChart chart;

@Subscribe
protected void onInit(InitEvent event) {
    ListDataProvider dataProvider = new ListDataProvider();
    dataProvider.addItem(new MapDataItem(
            ImmutableMap.of("value", 75, "description", "Sky")));
    dataProvider.addItem(new MapDataItem(
            ImmutableMap.of("value", 7, "description", "Shady side of pyramid")));
    dataProvider.addItem(new MapDataItem(
            ImmutableMap.of("value", 18, "description", "Sunny side of pyramid")));

    chart.setDataProvider(dataProvider);
}