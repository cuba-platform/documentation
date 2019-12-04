@Install(to = "customerField.lookup", subject = "afterCloseHandler")
private void customerFieldLookupAfterCloseHandler(AfterCloseEvent event) {
    if (event.closedWith(StandardOutcome.SELECT)) {
        System.out.println("Selected");
    }
}
