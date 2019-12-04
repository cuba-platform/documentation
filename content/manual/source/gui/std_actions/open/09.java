@Named("customerField.open")
private OpenAction customerFieldOpen;

@Subscribe("customersTable.edit")
public void onCustomersTableEdit(Action.ActionPerformedEvent event) {
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
