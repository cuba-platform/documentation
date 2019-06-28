@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
private void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createInputDialog(this)
            .withCaption("Enter some values")
            .withParameters(
                    InputParameter.stringParameter("name").withCaption("Name"),
                    InputParameter.entityParameter("customer", Customer.class).withCaption("Customer")
            )
            .withValidator(context -> { // <1>
                String name = context.getValue("name"); // <2>
                Customer customer = context.getValue("customer");
                if (Strings.isNullOrEmpty(name) && customer == null) {
                    return ValidationErrors.of("Enter name or select a customer");
                }
                return ValidationErrors.none();
            })
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                    String name = closeEvent.getValue("name");
                    Customer customer = closeEvent.getValue("customer");
                    // process entered values...
                }
            })
            .show();
}
