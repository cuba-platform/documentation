@Named("customersTable.exclude")
private ExcludeAction customersTableExclude;

@Subscribe("customersTable.exclude")
public void onCustomersTableExclude(Action.ActionPerformedEvent event) {
    customersTableExclude.setConfirmation(false);
    dialogs.createOptionDialog()
            .withCaption("My fancy confirm dialog")
            .withMessage("Do you really want to remove the customer from the list?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableExclude.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
