@Install(to = "customersTable.remove", subject = "actionCancelledHandler")
protected void customersTableRemoveActionCancelledHandler(RemoveOperation.ActionCancelledEvent<Customer> event) {
    System.out.println("Cancelled");
}
