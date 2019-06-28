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
                if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) { // <6>
                    String name = closeEvent.getValue("name"); // <7>
                    Double quantity = closeEvent.getValue("quantity");
                    Customer customer = closeEvent.getValue("customer");
                    Status status = closeEvent.getValue("status");
                    // process entered values...
                }
            })
            .show();
}
