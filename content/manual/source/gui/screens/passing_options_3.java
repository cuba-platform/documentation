@Inject
private ScreenBuilders screenBuilders;

private void showFancyMessage(String message) {
    screenBuilders.screen(this)
            .withScreenClass(FancyMessageScreen.class)
            .withOptions(new FancyMessageOptions(message))
            .build()
            .show();
}
