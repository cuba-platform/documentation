@Inject
private PieChart chart;

@Inject
private Metadata metadata;

@Subscribe
protected void onInit(InitEvent event) {
    ListDataProvider dataProvider = new ListDataProvider();
    dataProvider.addItem(new EntityDataItem(valueDescription(75, "Sky")));
    dataProvider.addItem(new EntityDataItem(valueDescription(7, "Shady side of pyramid")));
    dataProvider.addItem(new EntityDataItem(valueDescription(18, "Sunny side of pyramid")));

    chart.setDataProvider(dataProvider);
}

private ValueDescription valueDescription(Integer value, String description) {
    ValueDescription entity = metadata.create(ValueDescription.class);
    entity.setValue(value);
    entity.setDescription(description);
    return entity;
}