@Component
public class BeforeLoginEventListener {
    @Order(10)
    @EventListener
    protected void onBeforeLogin(BeforeLoginEvent event) throws LoginException {
        if (event.getCredentials() instanceof LoginPasswordCredentials) {
            LoginPasswordCredentials loginPassword = (LoginPasswordCredentials) event.getCredentials();

            if (loginPassword.getLogin() != null
                    && !loginPassword.getLogin().contains("@company")) {
                throw new LoginException(
                        "Only users from @company are allowed to login");
            }
        }
    }
}