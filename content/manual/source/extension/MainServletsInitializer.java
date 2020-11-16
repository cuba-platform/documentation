@Component(MainServletsInitializer.NAME)
public class MainServletsInitializer {

    public static final String NAME = "demo_MainServletsInitializer";
	
    @Inject
    protected ServletRegistrationManager servletRegistrationManager;

    @EventListener
    public void initServlets(ServletContextInitializedEvent event){
        initAppServlet(event); // <1>
        initDispatcherServlet(event); // <2>
        initCubaFilter(event); // <3>
    }

    protected void initAppServlet(ServletContextInitializedEvent event) {
        CubaApplicationServlet cubaServlet = (CubaApplicationServlet) servletRegistrationManager.createServlet(
                event.getApplicationContext(),
                "com.haulmont.cuba.web.sys.CubaApplicationServlet");
        cubaServlet.setClassLoader(Thread.currentThread().getContextClassLoader());
        ServletRegistration.Dynamic registration = event.getSource()
                .addServlet("app_servlet", cubaServlet); // <4>
        registration.setLoadOnStartup(0);
        registration.setAsyncSupported(true);
        registration.addMapping("/*");
        JSR356WebsocketInitializer.initAtmosphereForVaadinServlet(registration, event.getSource());  // <5>
        try {
            cubaServlet.init(new AbstractWebAppContextLoader.CubaServletConfig("app_servlet", event.getSource()));  // <6>
        } catch (ServletException e) {
            throw new RuntimeException("An error occurred while initializing app_servlet servlet", e);
        }
    }

    protected void initDispatcherServlet(ServletContextInitializedEvent event) {
        CubaDispatcherServlet cubaDispatcherServlet = (CubaDispatcherServlet) servletRegistrationManager.createServlet(
                event.getApplicationContext(),
                "com.haulmont.cuba.web.sys.CubaDispatcherServlet");
        try {
            cubaDispatcherServlet.init(
                    new AbstractWebAppContextLoader.CubaServletConfig("dispatcher", event.getSource()));
        } catch (ServletException e) {
            throw new RuntimeException("An error occurred while initializing dispatcher servlet", e);
        }
        ServletRegistration.Dynamic cubaDispatcherServletReg = event.getSource()
                .addServlet("dispatcher", cubaDispatcherServlet);
        cubaDispatcherServletReg.setLoadOnStartup(1);
        cubaDispatcherServletReg.addMapping("/dispatch/*");
    }

    protected void initCubaFilter(ServletContextInitializedEvent event) {
        CubaHttpFilter cubaHttpFilter = (CubaHttpFilter) servletRegistrationManager.createFilter(
                event.getApplicationContext(),
                "com.haulmont.cuba.web.sys.CubaHttpFilter");
        FilterRegistration.Dynamic registration = event.getSource()
                .addFilter("cuba_filter", cubaHttpFilter);
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}