@Inject
private Screens screens;
@Inject
private Notifications notifications;

private void openOtherScreen() {
    OtherScreen otherScreen = screens.create(OtherScreen.class);
    otherScreen.addAfterCloseListener(afterCloseEvent -> {
        notifications.create().withCaption("Closed " + afterCloseEvent.getScreen()).show();
    });
    otherScreen.show();
}