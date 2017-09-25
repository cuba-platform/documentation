public class MyTestContainer extends TestContainer {

    static {
        System.setProperty("logback.configurationFile", "my-test-logback.xml");
    }

    // ...
}