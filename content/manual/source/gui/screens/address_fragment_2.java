@UiController("demo_AddressFragment")
@UiDescriptor("address-fragment.xml")
public class AddressFragment extends ScreenFragment {

    @Inject
    private CollectionLoader<City> citiesLd;

    @Subscribe(target = Target.PARENT_CONTROLLER) // <1>
    private void onBeforeShowHost(Screen.BeforeShowEvent event) {
        citiesLd.load();
    }
}