@Named("customersTable.bulkEdit")
private BulkEditAction customersTableBulkEdit;

@Subscribe("customersTable.bulkEdit")
public void onCustomersTableBulkEdit(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Are you sure you want to edit the selected entities?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableBulkEdit.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
