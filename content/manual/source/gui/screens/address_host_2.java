@UiController("demo_HostScreen")
@UiDescriptor("host-screen.xml")
public class HostScreen extends Screen {

    @Inject
    private Fragments fragments; // <1>

    @Inject
    private GroupBoxLayout addressBox;

    @Subscribe
    private void onInit(InitEvent event) {
        AddressFragment addressFragment = fragments.create(this, AddressFragment.class); // <2>
        addressFragment.init(); // <3>
        addressBox.add(addressFragment.getFragment()); // <4>
    }
}