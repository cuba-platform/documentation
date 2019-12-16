// controller
@Inject
private Notifications notifications;

@Subscribe("sayHello")
protected void onSayHelloActionPerformed(Action.ActionPerformedEvent event) {
    notifications.create()
                .withCaption("Hello")
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();
}