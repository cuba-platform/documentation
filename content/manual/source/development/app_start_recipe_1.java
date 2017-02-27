@Component("sample_AppLifecycle")
public class AppLifecycle implements AppContext.Listener {

    @Inject
    private EntityListenerManager entityListenerManager;

    public AppLifecycle() {
        AppContext.addListener(this);
    }

    @Override
    public void applicationStarted() {
        entityListenerManager.addListener(User.class, "sample_UserEntityListener");
    }

    @Override
    public void applicationStopped() {
    }
}
