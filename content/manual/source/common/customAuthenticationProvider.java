public class CustomLoginPasswordAuthenticationProvider extends LoginPasswordAuthenticationProvider {
    @Inject
    public CustomLoginPasswordAuthenticationProvider(Persistence persistence, Messages messages) {
        super(persistence, messages);
    }

    @Override
    public AuthenticationDetails authenticate(Credentials credentials) throws LoginException {
        LoginPasswordCredentials loginPassword = (LoginPasswordCredentials) credentials;
        // for instance, add new check before login
        if ("demo".equals(loginPassword.getLogin())) {
            throw new LoginException("Demo account is disabled");
        }

        return super.authenticate(credentials);
    }
}