@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Inject
    private Notifications notifications;

    @EventListener
    protected void onPageRefresh(UIRefreshEvent event) {
        notifications.create()
                .withCaption("Page is refreshed " + event.getTimestamp())
                .show();
    }
}