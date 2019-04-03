@Inject
private PieChart chart;

@Subscribe
protected void onInit(InitEvent event) {
    ListDataProvider dataProvider = new ListDataProvider();
    dataProvider.addItem(new SimpleDataItem(new ValueDescription(75, "Sky")));
    dataProvider.addItem(new SimpleDataItem(new ValueDescription(7, "Shady side of pyramid")));
    dataProvider.addItem(new SimpleDataItem(new ValueDescription(18, "Sunny side of pyramid")));

    chart.setDataProvider(dataProvider);
}

public class ValueDescription {
    private Integer value;
    private String description;

    public ValueDescription(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}