@Inject
private CollectionLoader<Customer> customersDl;

@Subscribe("customersTable.refresh")
public void onCustomersTableRefresh(Action.ActionPerformedEvent event) {
    customersDl.load();
}
