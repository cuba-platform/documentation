@Subscribe
public void onAfterCommitChanges(AfterCommitChangesEvent event) {
    notifications.create()
            .withCaption("Saved!")
            .show();
}
