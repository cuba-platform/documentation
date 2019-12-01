@Install(to = "customersTable.edit", subject = "afterCloseHandler")
protected void customersTableEditAfterCloseHandler(AfterCloseEvent event) {
    if (event.closedWith(StandardOutcome.COMMIT)) {
        System.out.println("Committed");
    }
}
