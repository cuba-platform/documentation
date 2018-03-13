public class SalesTestContainer extends TestContainer {

    public SalesTestContainer() {
        super();
        appComponents = Arrays.asList(
                "com.haulmont.cuba"
                // add CUBA premium add-ons here
                // "com.haulmont.bpm",
                // "com.haulmont.charts",
                // "com.haulmont.fts",
                // "com.haulmont.reports",
                // and custom app components if any
        );
        appPropertiesFiles = Arrays.asList(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the core module
                "com/company/sales/app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "test-app.properties",
                "com/company/sales/test-app.properties");
        dbDriver = "org.postgresql.Driver";
        dbUrl = "jdbc:postgresql://localhost/sales_test";
        dbUser = "cuba";
        dbPassword = "cuba";
    }
}