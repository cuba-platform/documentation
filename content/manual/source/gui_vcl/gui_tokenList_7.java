@Inject
private Notifications notifications;

@Install(to = "tokenList", subject = "newOptionHandler")
private void tokenListNewOptionHandler(String string) {
    notifications.create()
            .withCaption(string)
            .withType(Notifications.NotificationType.TRAY)
            .show();
}