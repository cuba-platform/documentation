@Inject
private DataContext dataContext;

private void loadCustomer(Id<Customer, UUID> customerId) {
    Customer customer = dataManager.load(customerId).one();
    Customer trackedCustomer = dataContext.merge(customer);
    customersDc.getMutableItems().add(trackedCustomer);
}