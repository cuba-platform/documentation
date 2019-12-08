@Named("customerField.open")
private OpenAction customerFieldOpen;

@Subscribe("customerField.open")
public void onCustomerFieldOpen(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to open the customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customerFieldOpen.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
