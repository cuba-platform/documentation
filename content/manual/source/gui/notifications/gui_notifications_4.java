@Inject
private Notifications notifications;

@Subscribe("sayHelloBtn")
protected void onSayHelloBtnClick(Button.ClickEvent event) {
    notifications.create()
            .withContentMode(ContentMode.HTML)
            .withCaption("<i>Hello World!</i>")
            .show();
}