@Inject
private Screens screens;

private void showFancyMessage(String message) {
    FancyMessageScreen screen = screens.create(FancyMessageScreen.class, OpenMode.DIALOG);
    screen.setFancyMessage(message);
    screens.show(screen);
}