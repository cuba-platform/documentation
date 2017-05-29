@Override
protected void doHandle(String className, String message, @Nullable Throwable throwable, WindowManager windowManager) {
    if (throwable != null)
        windowManager.showExceptionDialog(throwable, "Exception is thrown", message);
    else
        windowManager.showNotification(message, IFrame.NotificationType.ERROR);
}