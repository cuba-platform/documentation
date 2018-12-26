@Component
@Order(NavigationFilter.LOWEST_PLATFORM_PRECEDENCE)
public class CubaLoginScreenFilter implements NavigationFilter {
    @Inject
    protected Messages messages;

    @Override
    public AccessCheckResult allowed(NavigationState fromState, NavigationState toState) {
        if (!"login".equals(toState.getRoot())) {
            return AccessCheckResult.allowed();
        }
        boolean authenticated = App.getInstance().getConnection().isAuthenticated();
        return authenticated ? AccessCheckResult.rejected(messages.getMainMessage("navigation.unableToGoToLogin")) : AccessCheckResult.allowed();
    }
}