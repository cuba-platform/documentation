@Inject
private PieChart pieChart;

@Subscribe
private void onBeforeShow(BeforeShowEvent event) {
    pieChart.addData(MapDataItem.of("key", "piece of apple pie",
                "value", 70),
            MapDataItem.of("key", "piece of blueberry pie",
                "value", 20),
            MapDataItem.of("key", "piece of cherry pie",
                "value", 10));
}