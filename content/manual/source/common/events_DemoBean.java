@Component
public class DemoBean {
    @Inject
    private Events events;
    @Inject
    private UserSessionSource userSessionSource;

    public void demo() {
        UserSession userSession = userSessionSource.getUserSession();
        events.publish(new DemoEvent(userSession.getUser()));
    }
}