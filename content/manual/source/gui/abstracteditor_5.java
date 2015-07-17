@Override
protected boolean preCommit() {
    if (somethingWentWrong) {
        showNotification("Something went wrong", NotificationType.WARNING);
        return false;
    }
    return true;
}