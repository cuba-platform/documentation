@Install(to = "customersTable.remove", subject = "actionCancelledHandler")
protected void customersTableRemoveActionCancelledHandler(RemoveOperation.ActionCancelledEvent event) {
    System.out.println("Cancelled");
}
