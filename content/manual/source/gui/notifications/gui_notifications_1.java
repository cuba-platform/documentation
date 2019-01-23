@Inject
private Notifications notifications;

@Subscribe("sayHelloBtn")
protected void onSayHelloBtnClick(Button.ClickEvent event) {
    notifications.create().withCaption("Hello!").show();
}