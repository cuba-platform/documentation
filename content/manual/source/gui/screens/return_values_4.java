@Inject
private ScreenBuilders screenBuilders;
@Inject
private Notifications notifications;

private void openOtherScreen() {
        screenBuilders.screen(this)
                .withScreenClass(OtherScreen.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    OtherScreen otherScreen = afterCloseEvent.getScreen();
                    if (afterCloseEvent.getCloseAction().equals(WINDOW_COMMIT_AND_CLOSE_ACTION)) {
                        String result = otherScreen.getResult();
                        notifications.create().withCaption("Result: " + result).show();
                    }
                })
                .build()
                .show();
}
