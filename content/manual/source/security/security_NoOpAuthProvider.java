public class NoOpAuthProvider implements CubaAuthProvider {
    @Override
    public void authenticate(String login, String password, Locale messagesLocale) throws LoginException {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }
}