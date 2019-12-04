@Named("customerField.lookup")
private LookupAction customerFieldLookup;

@Subscribe("customerField.lookup")
public void onCustomerFieldLookup(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to select a customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customerFieldLookup.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
