public class WebDispatcherServlet extends DispatcherServlet {
    private volatile boolean initialized = false;

    @Override
    public String getContextConfigLocation() {
        String configFile = "demo-dispatcher-spring.xml";
        File baseDir = new File(AppContext.getProperty("cuba.confDir"));

        String[] tokenArray = new StrTokenizer(configFile).getTokenArray();
        StringBuilder locations = new StringBuilder();

        for (String token : tokenArray) {
            String location;
            if (ResourceUtils.isUrl(token)) {
                location = token;
            } else {
                if (token.startsWith("/"))
                    token = token.substring(1);
                File file = new File(baseDir, token);
                if (file.exists()) {
                    location = file.toURI().toString();
                } else {
                    location = "classpath:" + token;
                }
            }
            locations.append(location).append(" ");
        }
        return locations.toString();
    }

    @Override
    protected WebApplicationContext initWebApplicationContext() {
        WebApplicationContext wac = findWebApplicationContext();
        if (wac == null) {
            ApplicationContext parent = AppContext.getApplicationContext();
            wac = createWebApplicationContext(parent);
        }

        onRefresh(wac);

        String attrName = getServletContextAttributeName();
        getServletContext().setAttribute(attrName, wac);
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Published WebApplicationContext of servlet '" + getServletName() +
                    "' as ServletContext attribute with name [" + attrName + "]");
        }

        return wac;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        if (!initialized) {
            super.init(config);
            initialized = true;
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        _service(response);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        _service(res);
    }

    private void _service(ServletResponse res) throws IOException {
        String testMessage = AppContext.getApplicationContext().getBean(Messages.class).getMainMessage("testMessage");

        res.getWriter()
                .write("WebDispatcherServlet test message: " + testMessage);
    }
}