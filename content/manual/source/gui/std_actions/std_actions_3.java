@Install(to = "customersTable.create", subject = "afterCommitHandler")
protected void customersTableCreateAfterCommitHandler(Customer entity) {
    System.out.println("Created " + entity);
}