@Inject
private CollectionLoader<Customer> customersDl;

private String customerName;

@Subscribe
protected void onBeforeShow(BeforeShowEvent event) {
    customersDl.setParameter("name", customerName)
    customersDl.load();
}