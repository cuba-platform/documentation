@Inject
protected CollectionDatasource<Customer, UUID> customersDs;

@Named("customersTable.remove")
protected RemoveAction removeAction;

public void init(Map<String, Object> params) {
    ...
    customersDs.addListener(new DsListenerAdapter<Customer>() {
        @Override
            public void itemChanged(Datasource<Customer> ds, Customer prevItem, Customer item) {
            removeAction.setEnabled(canCustomerBeDeleted(item));
        }
    });
}