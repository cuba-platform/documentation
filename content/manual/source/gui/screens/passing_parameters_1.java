@Inject
private ScreenBuilders screenBuilders;

private void showFancyMessage(String message) {
    FancyMessageScreen screen = screenBuilders.screen(this)
            .withScreenClass(FancyMessageScreen.class)
            .build();
    screen.setFancyMessage(message);
    screen.show();
}