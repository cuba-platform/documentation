@Subscribe("customersTable.edit")
public void onCustomersTableEdit(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to edit the customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableEdit.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
