@Inject
private SerialChart serialChart;

@Subscribe
private void onInit(InitEvent event) {
    ListDataProvider serialChartDataProvider = new ListDataProvider();
    int[] serialChartData = {5, 7, 6, 9, 7, 8, 5, 6, 4, 6, 5, 7, 4, 5, 3, 4, 2, 0};

    for (int i = 0; i < serialChartData.length; i++) {
        serialChartDataProvider.addItem(graphData(serialChartData[i]));
    }

    serialChart.setDataProvider(serialChartDataProvider);
}

private DataItem graphData(int value) {
    MapDataItem item = new MapDataItem();
    item.add("value", value);
    return item;
}