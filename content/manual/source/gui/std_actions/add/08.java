@Install(to = "customersTable.add", subject = "afterCloseHandler")
private void customersTableAddAfterCloseHandler(AfterCloseEvent event) {
    if (event.closedWith(StandardOutcome.SELECT)) {
        System.out.println("Selected");
    }
}
