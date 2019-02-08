@Subscribe
private void onInit(InitEvent event) {
    ScreenOptions options = event.getOptions();
    if (options instanceof FancyMessageOptions) {
        String message = ((FancyMessageOptions) options).getMessage();
        messageLabel.setValue(message);
    }
}