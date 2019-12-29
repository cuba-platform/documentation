@Inject
private ScreenBuilders screenBuilders;
@Inject
private Notifications notifications;

private void openOtherScreen() {
        screenBuilders.screen(this)
                .withScreenClass(OtherScreen.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    OtherScreen otherScreen = afterCloseEvent.getScreen();
                    if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                        String result = otherScreen.getResult();
                        notifications.create().withCaption("Result: " + result).show();
                    }
                })
                .build()
                .show();
}
