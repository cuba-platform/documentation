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
                if (closeEvent.closedWith(DialogOutcome.OK)) {
                    FileDescriptor fileDescriptor = closeEvent.getValue("fileField");  // <2>
                }
            })
            .show();
}