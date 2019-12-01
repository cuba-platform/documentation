@Install(to = "customersTable.remove", subject = "afterActionPerformedHandler")
protected void customersTableRemoveAfterActionPerformedHandler(RemoveOperation.AfterActionPerformedEvent event) {
    System.out.println("Removed " + event.getItems());
}
