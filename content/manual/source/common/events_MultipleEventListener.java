@Component
public class MultipleEventListener {
    @Order(10)
    @EventListener
    private void handleDemoEvent(DemoEvent event) {
        // handle event
    }

    @Order(1010)
    @EventListener
    private void handleUserLoginEvent(UserLoggedInEvent event) {
        // handle event
    }
}