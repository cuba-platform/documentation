@Install(to = "customersTable.edit", subject = "afterCommitHandler")
protected void customersTableEditAfterCommitHandler(Customer entity) {
    System.out.println("Updated " + entity);
}
