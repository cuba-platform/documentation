@Component
public class DemoEventListener {
    @Inject
    private Logger log;

    @Order(10)
    @EventListener
    private void onUserLoggedIn(UserLoggedInEvent event) {
        log.info("Demo");
    }
}