@Order(10)
@Component
public class AppStartedEventListener implements ApplicationListener<AppStartedEvent> {

    private static final String PROMO_USER_COOKIE = "PROMO_USER";

    @Inject
    private Logger log;

    @Override
    public void onApplicationEvent(AppStartedEvent event) {
        String promoUserLogin = event.getApp().getCookieValue(PROMO_USER_COOKIE);
        if (promoUserLogin != null) {
            Connection connection = event.getApp().getConnection();
            if (!connection.isAuthenticated()) {
                try {
                    connection.login(new ExternalUserCredentials(promoUserLogin));
                } catch (LoginException e) {
                    log.warn("Unable to login promo user {}: {}", promoUserLogin, e.getMessage());
                } finally {
                    event.getApp().removeCookie(PROMO_USER_COOKIE);
                }
            }
        }
    }
}
