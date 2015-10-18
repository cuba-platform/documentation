@Component
public class MyBean implements AppContext.Listener {

    @Inject
    private EntityListenerManager entityListenerManager;

    public ClusterManager() {
        AppContext.addListener(this);
    }

    @Override
    public void applicationStarted() {
        entityListenerManager.addListener(User.class, MyUserListener.class);
    }

    @Override
    public void applicationStopped() {
    }
}