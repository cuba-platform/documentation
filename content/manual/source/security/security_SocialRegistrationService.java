public interface SocialRegistrationService {
    String NAME = "demo_SocialRegistrationService";

    User findOrRegisterUser(String facebookId, String email, String name);
}