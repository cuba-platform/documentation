@Component
public class DemoAuthenticationProvider extends AbstractAuthenticationProvider
        implements AuthenticationProvider, Ordered {
    @Inject
    private UserSessionManager userSessionManager;

    @Inject
    public DemoAuthenticationProvider(Persistence persistence, Messages messages) {
        super(persistence, messages);
    }

    @Nullable
    @Override
    public AuthenticationDetails authenticate(Credentials credentials) throws LoginException {
        // ...
    }

    @Override
    public boolean supports(Class<?> credentialsClass) {
        return LoginPasswordCredentials.class.isAssignableFrom(credentialsClass);
    }

    @Override
    public int getOrder() {
        return 10;
    }
}