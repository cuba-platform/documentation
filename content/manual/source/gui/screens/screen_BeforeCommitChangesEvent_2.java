@Subscribe
public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
    if (getEditedEntity().getStatus() == null) {
        dialogs.createOptionDialog()
                .withCaption("Confirmation")
                .withMessage("Status is empty. Do you really want to commit?")
                .withActions(
                        new DialogAction(DialogAction.Type.OK).withHandler(e -> {
                            // resume with default behavior
                            event.resume();
                        }),
                        new DialogAction(DialogAction.Type.CANCEL)
                )
                .show();
        // abort
        event.preventCommit();
    }
}
