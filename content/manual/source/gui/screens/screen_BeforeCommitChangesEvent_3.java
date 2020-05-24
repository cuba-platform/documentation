@Subscribe
public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
    if (getEditedEntity().getStatus() == null) {
        dialogs.createOptionDialog()
                .withCaption("Confirmation")
                .withMessage("Status is empty. Do you want to use default?")
                .withActions(
                        new DialogAction(DialogAction.Type.OK).withHandler(e -> {
                            getEditedEntity().setStatus(getDefaultStatus());
                            // retry commit and resume action
                            event.resume(commitChanges());
                        }),
                        new DialogAction(DialogAction.Type.CANCEL)
                )
                .show();
        // abort
        event.preventCommit();
    }
}
