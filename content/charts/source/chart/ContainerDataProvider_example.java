@Inject
private SerialChart chart;

@Inject
private CollectionContainer<CountryGrowth> countryGrowthDc;

@Subscribe
private void onInit(InitEvent event) {
    List<CountryGrowth> items = new ArrayList<>();
    items.add(countryGrowth("USA", 3.5, 4.2));
    //...
    countryGrowthDc.setItems(items);
    chart.setDataProvider(new ContainerDataProvider(countryGrowthDc));
    chart.setCategoryField("country");
}