@Inject
private DataComponents dataComponents;

private void createCustomerLoader(CollectionContainer<Customer> container) {
    CollectionLoader<Customer> loader = dataComponents.createCollectionLoader();
    loader.setQuery("select e from sample_Customer e");
    loader.setContainer(container);
    loader.setDataContext(getScreenData().getDataContext());
}