@Inject
protected Chart serialChart;

@Override
public void init(Map<String, Object> params) {
    super.init(params);

    ListDataProvider serialChartDataProvider = new ListDataProvider();
    int[] serialChartChartData = {5, 7, 6, 9, 7, 8, 5, 6, 4, 6, 5, 7, 4, 5, 3, 4, 2, 0};

    for (int i = 0; i < redLineChartData.length; i++) {
        serialChartDataProvider.addItem(graphData(serialChartChartData[i]));
    }

    serialChartConfiguration.setDataProvider(serialChartDataProvider);
}