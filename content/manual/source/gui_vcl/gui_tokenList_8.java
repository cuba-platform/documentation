@Inject
private TokenList<?> tokenList;

@Subscribe
public void onInit(InitEvent event) {
    tokenList.setNewOptionHandler(string ->
            notifications.create()
                    .withCaption(string)
                    .withType(Notifications.NotificationType.TRAY)
                    .show());
}