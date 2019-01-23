// controller
@Inject
private Notifications notifications;

private void showNotification(String message) {
    notifications.create()
            .withCaption(message)
            .withType(NotificationType.HUMANIZED)
            .show();
}

@Subscribe("sayBtn.hello")
private void onSayBtnHelloActionPerformed(Action.ActionPerformedEvent event) {
    notifications.create()
            .withCaption("Hello")
            .show();
}

@Subscribe("sayBtn.goodbye")
private void onSayBtnGoodbyeActionPerformed(Action.ActionPerformedEvent event) {
    notifications.create()
            .withCaption("Hello")
            .show();
}