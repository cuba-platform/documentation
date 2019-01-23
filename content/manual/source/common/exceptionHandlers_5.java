@Override
protected void doHandle(String className, String message, @Nullable Throwable throwable, UiContext context) {
    if (throwable != null) {
        context.getDialogs().createExceptionDialog()
                .withThrowable(throwable)
                .withCaption("Error")
                .withMessage(message)
                .show();
    } else {
        context.getNotifications().create(Notifications.NotificationType.ERROR)
                .withCaption("Error")
                .withDescription(message)
                .show();
    }
}