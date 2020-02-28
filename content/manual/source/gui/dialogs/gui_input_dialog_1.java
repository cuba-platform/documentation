@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
private void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createInputDialog(this)
            .withCaption("Enter some values")
            .withParameters(
                    InputParameter.stringParameter("name")
                        .withCaption("Name").withRequired(true), // <1>
                    InputParameter.doubleParameter("quantity")
                        .withCaption("Quantity").withDefaultValue(1.0), // <2>
                    InputParameter.entityParameter("customer", Customer.class)
                        .withCaption("Customer"), // <3>
                    InputParameter.enumParameter("status", Status.class)
                        .withCaption("Status") // <4>
            )
            .withActions(DialogActions.OK_CANCEL) // <5>
            .withCloseListener(closeEvent -> {
                if (closeEvent.closedWith(DialogOutcome.OK)) { // <6>
                    String name = closeEvent.getValue("name"); // <7>
                    Double quantity = closeEvent.getValue("quantity");
                    Optional<Customer> customer = closeEvent.getOptional("customer"); // <8>
                    Status status = closeEvent.getValue("status");
                    // process entered values...
                }
            })
            .show();
}
