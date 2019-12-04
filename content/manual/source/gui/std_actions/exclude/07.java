@Install(to = "customersTable.exclude", subject = "afterActionPerformedHandler")
private void customersTableExcludeAfterActionPerformedHandler(RemoveOperation.AfterActionPerformedEvent<Customer> event) {
    System.out.println("Removed " + event.getItems());
}
