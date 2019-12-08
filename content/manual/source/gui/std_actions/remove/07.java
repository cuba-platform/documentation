@Install(to = "customersTable.remove", subject = "afterActionPerformedHandler")
protected void customersTableRemoveAfterActionPerformedHandler(RemoveOperation.AfterActionPerformedEvent<Customer> event) {
    System.out.println("Removed " + event.getItems());
}
