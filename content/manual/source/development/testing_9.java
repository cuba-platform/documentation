public class DemoTestContainer extends TestContainer {

    static {
        System.setProperty("logback.configurationFile", "com/company/demo/my-test-logback.xml");
    }