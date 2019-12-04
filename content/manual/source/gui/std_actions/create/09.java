@Named("customersTable.create")
private CreateAction customersTableCreate;

@Subscribe("customersTable.create")
public void onCustomersTableCreate(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to create new customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableCreate.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
