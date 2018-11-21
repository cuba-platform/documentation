@Inject
private CollectionContainer<Customer> customersDc;

private Optional<Customer> findByName(String name) {
    return customersDc.getItems().stream()
            .filter(customer -> Objects.equals(customer.getName(), name))
            .findFirst();
}
