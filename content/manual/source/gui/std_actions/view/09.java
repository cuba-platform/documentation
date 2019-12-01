@Subscribe("customersTable.view")
public void onCustomersTableView(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to view the customer?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableView.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
