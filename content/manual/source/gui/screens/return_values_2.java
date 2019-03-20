@Inject
private ScreenBuilders screenBuilders;
@Inject
private Notifications notifications;

private void openOtherScreen() {
    screenBuilders.screen(this)
            .withScreenClass(OtherScreen.class)
            .withAfterCloseListener(afterCloseEvent -> {
                notifications.create().withCaption("Closed " + afterCloseEvent.getScreen()).show();
            })
            .build()
            .show();
}