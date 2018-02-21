@Component
public class WebInitializer {
     
    @Inject
    private ServletRegistrationManager servletRegistrationManager;
 
    @EventListener
    public void initializeHttpServlet(ServletContextInitializedEvent e) {
        Servlet myServlet = servletRegistrationManager.createServlet(e.getApplicationContext(), "com.demo.comp.MyHttpServlet");
 
        e.getSource().addServlet("my_servlet", myServlet)
                .addMapping("/myservlet/");
    }
}