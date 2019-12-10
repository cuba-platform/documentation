@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
public void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createInputDialog(this)
            .withCaption("Select the file")
            .withParameters(
                    InputParameter.fileParameter("fileField") // <1>
                            .withCaption("File"))
            .withCloseListener(closeEvent -> {
                if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                    FileDescriptor fileDescriptor = closeEvent.getValue("fileField");  // <2>
                }
            })
            .show();
}