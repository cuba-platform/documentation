@Inject
private Screens screens;

private void showDefaultFancyMessage() {
    screens.create(FancyMessageScreen.class).show();
}