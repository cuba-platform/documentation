@Named("customersTable.excel")
private ExcelAction customersTableExcel;

@Subscribe("customersTable.excel")
public void onCustomersTableExcel(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Are you sure you want to print the content to XLS?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customersTableExcel.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
