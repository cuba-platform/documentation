@Component
public class CustomHttpFilter implements HttpRequestFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        // delegate to the next filter/servlet
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}