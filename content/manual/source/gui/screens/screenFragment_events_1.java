@UiController("demo_AddressFragment")
@UiDescriptor("address-fragment.xml")
public class AddressFragment extends ScreenFragment {

    private static final Logger log = LoggerFactory.getLogger(AddressFragment.class);

    @Subscribe
    private void onAttach(AttachEvent event) {
        Screen hostScreen = getHostScreen();
        FrameOwner hostController = getHostController();
        log.info("onAttach to screen {} with controller {}", hostScreen, hostController);
    }

    @Subscribe
    private void onDetach(DetachEvent event) {
        log.info("onDetach");
    }
}