@Subscribe("customersTable.remove")
public void onCustomersTableRemove(Action.ActionPerformedEvent event) {
    customersTableRemove.setConfirmation(false);
    dialogs.createOptionDialog()
            .withCaption("My fancy confirm dialog")
            .withMessage("Do you really want to remove the customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableRemove.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
