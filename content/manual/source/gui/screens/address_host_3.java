@UiController("demo_HostScreen")
@UiDescriptor("host-screen.xml")
public class HostScreen extends Screen {

    @Inject
    private Fragments fragments;

    @Inject
    private GroupBoxLayout addressBox;

    @Subscribe
    private void onInit(InitEvent event) {
        AddressFragment addressFragment = fragments.create(this, AddressFragment.class);
        addressFragment.setStrParam("some value"); // <1>
        addressBox.add(addressFragment.getFragment());
    }
}