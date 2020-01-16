public class DemoTestContainer extends TestContainer {

    public DemoTestContainer() {
        super();
        appComponents = Arrays.asList(
                "com.haulmont.cuba"
        );
        appPropertiesFiles = Arrays.asList(
                "com/company/demo/app.properties",
                "com/haulmont/cuba/testsupport/test-app.properties",
                "com/company/demo/test-app.properties" // your test properties
        );
        autoConfigureDataSource();
    }
