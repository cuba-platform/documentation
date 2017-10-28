public interface AuthenticationManager {

    AuthenticationDetails authenticate(Credentials credentials) throws LoginException;

    AuthenticationDetails login(Credentials credentials) throws LoginException;

    UserSession substituteUser(User substitutedUser);

    void logout();
}