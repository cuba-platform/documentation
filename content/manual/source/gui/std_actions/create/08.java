@Install(to = "customersTable.create", subject = "afterCloseHandler")
protected void customersTableCreateAfterCloseHandler(AfterCloseEvent event) {
    if (event.closedWith(StandardOutcome.COMMIT)) {
        System.out.println("Committed");
    }
}
