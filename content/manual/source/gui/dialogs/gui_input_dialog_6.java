@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
public void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createInputDialog(this)
            .withParameters(
                    InputParameter.stringParameter("nameField").withCaption("Name"),
                    InputParameter.intParameter("countField").withCaption("Count")
            )
            .withActions(DialogActions.OK_CANCEL, result -> {
                switch (result.getCloseActionType()) {
                    case OK:
                        Optional<String> nameOptional = result.getOptional("nameField"); // <1>
                        Optional<Integer> countOptional = result.getOptional("countField");
                        break;
                    case CANCEL:
                        // do something
                        break;
                }
            })
            .show();
}