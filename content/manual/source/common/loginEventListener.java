@Component
public class LoginEventListener {
    @Inject
    private Logger log;

    @EventListener
    protected void onUserLoggedIn(UserLoggedInEvent event) {
        User user = event.getUserSession().getUser();
        log.info("Logged in user {}", user.getLogin());
    }
}