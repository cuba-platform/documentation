@Before
public void setUp() throws Exception {
    addEntityPackage("com.haulmont.cuba.security.entity");
    addEntityPackage("com.haulmont.cuba.core.entity");
    addEntityPackage("com.haulmont.cuba.gui.data.impl.testmodel1");
    setViewConfig("/com/haulmont/cuba/gui/data/impl/testmodel1/test-views.xml");
    setupInfrastructure();

    metadataSession = metadata.getSession();
    dataSupplier = new TestDataSupplier();

    dataSupplier.commitCount = 0;

    new NonStrictExpectations() {
        @Mocked ClientConfig clientConfig;
        @Mocked PersistenceHelper persistenceHelper;
        {
            configuration.getConfig(ClientConfig.class); result = clientConfig;

            clientConfig.getCollectionDatasourceDbSortEnabled(); result = true;

            persistenceManager.getMaxFetchUI(anyString); result = 10000;

            PersistenceHelper.isNew(any); result = false;
        }
    };
}