@Override
protected boolean preCommit() {
    if (somethingWentWrong) {
        notifications.create()
                .withCaption("Something went wrong")
                .withType(Notifications.NotificationType.WARNING)
                .show();
        return false;
    }
    return true;
}