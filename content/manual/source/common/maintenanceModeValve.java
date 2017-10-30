@Component
public class MaintenanceModeValve {
    private volatile boolean maintenance = true;

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    @EventListener
    private void onBeforeLogin(BeforeLoginEvent event) throws LoginException {
        if (maintenance && event.getCredentials() instanceof AbstractClientCredentials) {
            throw new LoginException("Sorry, system is unavailable");
        }
    }
}