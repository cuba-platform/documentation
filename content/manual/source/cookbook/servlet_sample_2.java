@Component
public class WebInitializer {

    private static final String WEB_DISPATCHER_CLASS = "com.demo.comp.web.WebDispatcherServlet";
    private static final String WEB_DISPATCHER_NAME = "web_dispatcher_servlet";
    private final Logger log = LoggerFactory.getLogger(WebInitializer.class);

    @Inject
    private ServletRegistrationManager servletRegistrationManager;

    @EventListener
    public void initialize(ServletContextInitializedEvent e) {
        Servlet webDispatcherServlet = servletRegistrationManager.createServlet(e.getApplicationContext(), WEB_DISPATCHER_CLASS);
        ServletContext servletContext = e.getSource();
        try {
            webDispatcherServlet.init(new AbstractWebAppContextLoader.CubaServletConfig(WEB_DISPATCHER_NAME, servletContext));
        } catch (ServletException ex) {
            throw new RuntimeException("Failed to init WebDispatcherServlet");
        }
        servletContext.addServlet(WEB_DISPATCHER_NAME, webDispatcherServlet)
                .addMapping("/webd/*");
    }
}