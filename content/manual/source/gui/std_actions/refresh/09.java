@Named("customersTable.refresh")
private RefreshAction customersTableRefresh;

@Subscribe("customersTable.refresh")
public void onCustomersTableRefresh(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Are you sure you want to refresh the list?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableRefresh.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
