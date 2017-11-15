@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {
    @Inject
    private Logger log;

    @Override
    public void onApplicationEvent(DemoEvent event) {
        log.debug("Demo event is published");
    }
}