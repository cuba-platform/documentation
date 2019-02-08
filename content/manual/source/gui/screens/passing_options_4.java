@Subscribe
private void onInit(InitEvent event) {
    ScreenOptions options = event.getOptions();
    if (options instanceof MapScreenOptions) {
        String message = (String) ((MapScreenOptions) options).getParams().get("message");
        messageLabel.setValue(message);
    }
}