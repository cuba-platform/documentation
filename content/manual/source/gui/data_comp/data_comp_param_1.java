@UiController("demo_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
public class CityBrowse extends StandardLookup<City> {

    @Inject
    private CollectionLoader<City> citiesDl;

    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        if (country == null)
            throw new IllegalStateException("country parameter is null");
        citiesDl.setParameter("country", country);
        citiesDl.load();
    }
}