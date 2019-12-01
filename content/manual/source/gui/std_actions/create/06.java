@Install(to = "customersTable.create", subject = "initializer")
protected void customersTableCreateInitializer(Customer entity) {
    entity.setName("a customer");
}
