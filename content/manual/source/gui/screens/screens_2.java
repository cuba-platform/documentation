@Inject
private Screens screens;

private void showFancyMessage(String message) {
    FancyMessageScreen screen = screens.create(FancyMessageScreen.class);
    screen.setFancyMessage(message);
    screens.show(screen);
}