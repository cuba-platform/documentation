@Component
@Order(NavigationFilter.LOWEST_PLATFORM_PRECEDENCE - 100)
public class TaskStatisticNavigationFilter implements NavigationFilter {

    @Inject
    private UserSessionSource userSessionSource;

    @Override
    public AccessCheckResult allowed(NavigationState fromState, NavigationState toState) {
        if (toState == null || !toState.getNestedRoute().endsWith("task-statistic")) {
            // skip all routes we are not interested in
            return NavigationFilter.AccessCheckResult.allowed();
        }
        if (!userSessionSource.checkCurrentUserSession()) {
            // reject navigation if there is no session to check permissions
            return NavigationFilter.AccessCheckResult.rejected("No user session found. Unable to check permissions");
        }

        // trying to find "Manager" role
        String managerRole = userSessionSource.getUserSession().getRoles()
                .stream()
                .filter(roleName -> "manager".equals(roleName.toLowerCase()))
                .findFirst()
                .orElse(null);

        // reject navigation if user associated with current session doesn't have "Manager" role
        return managerRole != null
                ? NavigationFilter.AccessCheckResult.allowed()
                : NavigationFilter.AccessCheckResult.rejected("Only managers are allowed to view TaskStatistic screen");
    }
}