@Subscribe
public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
    if (getEditedEntity().getStatus() == null) {
        notifications.create().withCaption("Enter status!").show();
        event.preventCommit();
    }
}