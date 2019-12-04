@Install(to = "customerField.lookup", subject = "transformation")
private Collection<Customer> customerFieldLookupTransformation(Collection<Customer> collection) {
    return reloadCustomers(collection);
}
