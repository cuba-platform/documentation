@Inject
private ScreenBuilders screenBuilders;
@Inject
private Notifications notifications;

private void openOtherScreen() {
    screenBuilders.screen(this)
            .withScreenClass(OtherScreen.class)
            .withAfterCloseListener(e -> {
                OtherScreen screen = e.getScreen();
                CloseAction closeAction = e.getCloseAction();
                notifications.create()
                    .withCaption("Closed " + screen + " with action " + closeAction)
                    .show();
            })
            .build()
            .show();
}
