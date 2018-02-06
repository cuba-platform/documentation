@Component
public class MyInitializerBean {

    @Inject
    private Logger log;

    @EventListener
    public void foo(ServletContextInitializedEvent e) {
        log.info("Application and servlet context is initialized");
    }

    @EventListener
    public void bar(ServletContextDestroyedEvent e) {
        log.info("Application is about to shut down, all contexts are now destroyed");
    }
}