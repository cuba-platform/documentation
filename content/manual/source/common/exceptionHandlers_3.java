@Override
protected void doHandle(String className, String message, @Nullable Throwable throwable, WindowManager windowManager) {
    String msg = messages.getMainMessage("zeroBalance.message");
    windowManager.showNotification(msg, IFrame.NotificationType.ERROR);
}