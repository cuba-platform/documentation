@Component
public class LoginEventListener {
    @Inject
    private Logger log;

    @EventListener
    private void onUserLoggedIn(UserLoggedInEvent event) {
        User user = event.getSource().getUser();
        log.info("Logged in user {}", user.getInstanceName());
    }
}