@Inject
private Notifications notifications;

@Subscribe("clipBtn")
private void onClipBtnClick(Button.ClickEvent event) {
    notifications.create().withCaption("Copied to clipboard").show();
}
