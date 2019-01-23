@Inject
private Notifications notifications;

@Subscribe("sayHelloBtn")
protected void onSayHelloBtnClick(Button.ClickEvent event) {
    notifications.create(Notifications.NotificationType.TRAY).withCaption("Hello World!").show();
}