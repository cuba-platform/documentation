// controller
@Inject
private Notifications notifications;

private void showNotification(String message) {
    notifications.create().setCaption(message).setType(Notifications.NotificationType.HUMANIZED).show();
}

@Subscribe("sayBtn.hello")
private void onSayBtnHelloActionPerformed(Action.ActionPerformedEvent event) {
    showNotification("Hello");
}

@Subscribe("sayBtn.goodbye")
private void onSayBtnGoodbyeActionPerformed(Action.ActionPerformedEvent event) {
    showNotification("Goodbye");
}