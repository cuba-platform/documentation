public class SalesTestContainer extends TestContainer {

    public SalesTestContainer() {
        super();
        appPropertiesFiles = Arrays.asList(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the core module
                "cuba-app.properties",
                "sales-app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "test-app.properties");
        dbDriver = "org.postgresql.Driver";
        dbUrl = "jdbc:postgresql://localhost/sales_test";
        dbUser = "cuba";
        dbPassword = "cuba";
    }
}