public class MyTestContainer extends TestContainer {
    // ...

    @Override
    protected void initDataSources() {
        super.initDataSources();
        try {
            Class.forName("org.postgresql.Driver");
            TestDataSource mydbDataSource = new TestDataSource("jdbc:postgresql://localhost/mydatabase", "cuba", "cuba");
            TestContext.getInstance().bind(AppContext.getProperty("cuba.dataSourceJndiName_mydb"), mydbDataSource);
        } catch (ClassNotFoundException | NamingException e) {
            throw new RuntimeException("Error initializing datasource", e);
        }
    }

    // ...
}