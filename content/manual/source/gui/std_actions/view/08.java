@Install(to = "customersTable.view", subject = "afterCloseHandler")
protected void customersTableViewAfterCloseHandler(AfterCloseEvent event) {
    if (event.closedWith(StandardOutcome.COMMIT)) {
        System.out.println("Enabled editing and then committed");
    }
}
