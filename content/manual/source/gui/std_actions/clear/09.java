@Named("customerField.clear")
private ClearAction customerFieldClear;

@Subscribe("customerField.clear")
public void onCustomerFieldClear(Action.ActionPerformedEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Please confirm")
            .withMessage("Do you really want to clear the field?")
            .withActions(
                    new DialogAction(DialogAction.Type.YES)
                            .withHandler(e -> customerFieldClear.execute()), // execute action
                    new DialogAction(DialogAction.Type.NO)
            )
            .show();
}
