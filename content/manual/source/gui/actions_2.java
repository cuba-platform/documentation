// controller
@Inject
private Notifications notifications;

@Subscribe("sayHello")
protected void onSayHelloActionPerformed(Action.ActionPerformedEvent event) {
    notifications.create().setCaption("Hello").setType(Notifications.NotificationType.HUMANIZED).show();
}