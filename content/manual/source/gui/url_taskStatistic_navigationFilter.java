@Component
@Order(NavigationFilter.LOWEST_PLATFORM_PRECEDENCE - 100)
public class TaskStatisticNavigationFilter implements NavigationFilter {

    @Override
    public AccessCheckResult allowed(NavigationState fromState, NavigationState toState) {
        return AccessCheckResult.allowed();
    }
}