public class CustomWebListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        registerServlet(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    protected void registerServlet(ServletContext servletContext) {
        Servlet testServlet = new TestServlet();
        ServletRegistration.Dynamic servletReg = servletContext.addServlet("test_servlet", cubaServlet);
        servletReg.setLoadOnStartup(0);
        servletReg.setAsyncSupported(true);
        servletReg.addMapping("/testServlet");
    }
}