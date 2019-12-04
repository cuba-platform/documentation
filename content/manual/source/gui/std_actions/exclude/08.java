@Install(to = "customersTable.exclude", subject = "actionCancelledHandler")
private void customersTableExcludeActionCancelledHandler(RemoveOperation.ActionCancelledEvent<Customer> event) {
    System.out.println("Cancelled");
}
