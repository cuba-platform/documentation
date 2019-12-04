@Install(to = "customersTable.add", subject = "transformation")
private Collection<Customer> customersTableAddTransformation(Collection<Customer> collection) {
    return reloadCustomers(collection);
}
