@Component
public class MultipleEventListener {
    @Order(10)
    @EventListener
    protected void handleDemoEvent(DemoEvent event) {
        // handle event
    }

    @Order(1010)
    @EventListener
    protected void handleUserLoginEvent(UserLoggedInEvent event) {
        // handle event
    }
}