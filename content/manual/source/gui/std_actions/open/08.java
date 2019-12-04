@Install(to = "customerField.open", subject = "afterCloseHandler")
private void customerFieldOpenAfterCloseHandler(AfterCloseEvent event) {
    System.out.println("Closed with " + event.getCloseAction());
}
