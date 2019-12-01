@Install(to = "customersTable.create", subject = "newEntitySupplier")
protected Customer customersTableCreateNewEntitySupplier() {
    Customer customer = metadata.create(Customer.class);
    customer.setName("a customer");
    return customer;
}
