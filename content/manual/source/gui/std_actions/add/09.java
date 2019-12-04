@Named("customersTable.add")
private AddAction customersTableAdd;

@Subscribe("customersTable.add")
public void onCustomersTableAdd(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to add a customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableAdd.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
