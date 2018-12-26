@Inject
private Notifications notifications;

@Subscribe
protected void onUrlParamsChanged(UrlParamsChangedEvent event) {
        notifications.create(Notifications.NotificationType.HUMANIZED)
        .withCaption("Params changed!")
        .show();
}