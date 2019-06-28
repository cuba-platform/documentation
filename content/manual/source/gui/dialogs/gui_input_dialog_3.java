@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
private void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createInputDialog(this)
            .withCaption("Enter some values")
            .withParameters(
                InputParameter.stringParameter("name").withCaption("Name")
            )
            .withActions( // <1>
                    InputDialogAction.action("confirm")
                            .withCaption("Confirm")
                            .withPrimary(true)
                            .withHandler(actionEvent -> {
                                InputDialog dialog = actionEvent.getInputDialog();
                                String name = dialog.getValue("name"); // <2>
                                dialog.closeWithDefaultAction(); // <3>
                                // process entered values...
                            }),
                    InputDialogAction.action("refuse")
                            .withCaption("Refuse")
                            .withValidationRequired(false)
                            .withHandler(actionEvent ->
                                actionEvent.getInputDialog().closeWithDefaultAction())
            )
            .show();
}
