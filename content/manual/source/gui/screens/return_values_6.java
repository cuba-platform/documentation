@Inject
private Screens screens;
@Inject
private Notifications notifications;

private void openOtherScreen() {
    Screen otherScreen = screens.create("demo_OtherScreen", OpenMode.THIS_TAB);
    otherScreen.addAfterCloseListener(afterCloseEvent -> {
        CloseAction closeAction = afterCloseEvent.getCloseAction();
        if (closeAction instanceof MyCloseAction) {
            String result = ((MyCloseAction) closeAction).getResult();
            notifications.create().withCaption("Result: " + result).show();
        }
    });
    otherScreen.show();
}
