@Inject
private CollectionContainer<Customer> customersDc;

private void createCustomer() {
    Customer customer = metadata.create(Customer.class);
    customer.setName("Homer Simpson");
    customersDc.getMutableItems().add(customer);
}