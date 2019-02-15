@Inject
private ScreenBuilders screenBuilders;

private void showCitiesOfCountry(Country country) {
    CityBrowse cityBrowse = screenBuilders.screen(this)
            .withScreenClass(CityBrowse.class)
            .build();
    cityBrowse.setCountry(country);
    cityBrowse.show();
}
