@Install(to = "customersTable.view", subject = "afterCommitHandler")
protected void customersTableViewAfterCommitHandler(Customer entity) {
    System.out.println("Updated " + entity);
}
